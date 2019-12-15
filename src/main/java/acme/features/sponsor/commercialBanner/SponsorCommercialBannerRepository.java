
package acme.features.sponsor.commercialBanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.banner.CommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SponsorCommercialBannerRepository extends AbstractRepository {

	@Query("select a from CommercialBanner a where a.id = ?1")
	CommercialBanner findOneCommercialBannerById(int id);

	@Query("select a from CommercialBanner a where a.sponsor.id=?1")
	Collection<CommercialBanner> findManyBySponsorId(int sponsorId);

	@Query("select a from CommercialBanner a")
	Collection<CommercialBanner> findManyAll();

	@Query("select a from Sponsor a where a.id = ?1")
	Sponsor findOneSponsorById(int id);

}
