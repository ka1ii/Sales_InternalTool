package kzhang.demo.w22.Sales_pipeline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kzhang.demo.w22.Sales_pipeline.models.Seller_achievement;

/**
 * Seller achievement repository is used to provide CRUD operations for the
 * transaction model.
 * Spring will generate appropriate code with JPA.
 *
 */
public interface Seller_achievementRepository extends JpaRepository<Seller_achievement, Long> {

    /**
     * Finds a seller achievement object with the provided name. Spring will
     * generate code
     * to make this happen.
     *
     * @param id
     *           id of the Seller_achievement
     * @return Found Seller_achievement, null if none.
     */
    Seller_achievement findById(long id);

}
