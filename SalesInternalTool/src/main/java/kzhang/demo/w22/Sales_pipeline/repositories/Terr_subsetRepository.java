package kzhang.demo.w22.Sales_pipeline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kzhang.demo.w22.Sales_pipeline.models.Terr_subset;

/**
 * Terr_subsetREPO is used to provide CRUD operations for the Terr_subset
 * model.
 * Spring will generate appropriate code with JPA.
 *
 */
public interface Terr_subsetRepository extends JpaRepository<Terr_subset, Long> {

    /**
     * Finds a Terr_subset object with the provided id. Spring will generate
     * code
     * to make this happen.
     *
     * @param id
     *           id of the Terr_subset
     * @return Found Terr_subset, null if none.
     */
    Terr_subset findById(long id);

}
