
package acme.features.sponsor.nonCommercialBanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.banner.NonCommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SponsorNonCommercialBannerRepository extends AbstractRepository {

	@Query("select a from NonCommercialBanner a where a.id = ?1")
	NonCommercialBanner findOneNonCommercialBannerById(int id);

	@Query("select a from NonCommercialBanner a where a.sponsor.id=?1")
	Collection<NonCommercialBanner> findManyBySponsorId2(int sponsorId);

	@Query("select a from CommercialBanner a")
	Collection<NonCommercialBanner> findManyAll();

	@Query("select a from Sponsor a where a.id = ?1")
	Sponsor findOneSponsorById(int id);

}
