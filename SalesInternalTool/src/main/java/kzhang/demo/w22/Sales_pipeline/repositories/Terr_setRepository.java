package kzhang.demo.w22.Sales_pipeline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kzhang.demo.w22.Sales_pipeline.models.Terr_set;

/**
 * Terr_setREPO is used to provide CRUD operations for the
 * Terr_set
 * model.
 * Spring will generate appropriate code with JPA.
 *
 */
public interface Terr_setRepository extends JpaRepository<Terr_set, Long> {

    /**
     * Finds a Terr_set object with the provided id. Spring will generate
     * code
     * to make this happen.
     *
     * @param id
     *           id of the Terr_set
     * @return Found Terr_set, null if none.
     */
    Terr_set findById(long id);

}
