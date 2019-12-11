
package acme.features.consumer.offer;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	@Autowired
	ConsumerOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "ticker", "moment", "deadline", "text", "minMoney", "maxMoney");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("confirm", "false");
		} else {
			request.transfer(model, "confirm");
		}

	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		assert request != null;

		Offer result;
		result = new Offer();
		return result;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("confirm")) {
			Boolean isAccepted = request.getModel().getBoolean("confirm");
			errors.state(request, isAccepted, "confirm", "consumer.offer.error.must-confirm");
		}

		if (!errors.hasErrors("minMoney")) {
			Boolean okMin = entity.getMinMoney().getCurrency().equals("EUR");
			errors.state(request, okMin, "minMoney", "consumer.offer.error.incorrect-currency");
		}

		if (!errors.hasErrors("maxMoney")) {
			Boolean okMax = entity.getMaxMoney().getCurrency().equals("EUR");
			errors.state(request, okMax, "maxMoney", "consumer.offer.error.incorrect-currency");
		}

		if (!errors.hasErrors("maxMoney") && !errors.hasErrors("minMoney")) {
			Boolean mayorQue = entity.getMaxMoney().getAmount() > entity.getMinMoney().getAmount();
			errors.state(request, mayorQue, "maxMoney", "consumer.offer.error.greater-than");
		}

		if (!errors.hasErrors("deadline")) {
			Date deadline = entity.getDeadline();
			Calendar calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 0);
			Date minDeadline = calendar.getTime();
			Boolean restriccion = deadline.after(minDeadline);
			errors.state(request, restriccion, "deadline", "consumer.offer.error.must-be-after");
		}

		if (!errors.hasErrors("ticker")) {
			Offer ticker = this.repository.findOneByTicker(entity.getTicker());
			errors.state(request, ticker == null, "ticker", "consumer.offer.error.unique-ticker");
		}

	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {

		assert request != null;
		assert entity != null;
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

		this.repository.save(entity);

	}

}
