package kzhang.demo.w22.Sales_pipeline.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kzhang.demo.w22.Sales_pipeline.models.Terr_subset_rule;

/**
 * Terr_subset_ruleREPO is used to provide CRUD operations for the
 * Terr_subset_rule
 * model.
 * Spring will generate appropriate code with JPA.
 *
 */
public interface Terr_subset_ruleRepository extends JpaRepository<Terr_subset_rule, Long> {

    /**
     * Finds a Terr_subset_rule object with the provided id. Spring will generate
     * code
     * to make this happen.
     *
     * @param id
     *           id of the Terr_subset_rule
     * @return Found Terr_subset_rule, null if none.
     */
    Terr_subset_rule findById(long id);

    /**
     * find all terr_subset_rule object with subset_id 'id' and
     * Terr Type terrType
     * 
     * @param subsetId the id
     * @param terrType the territory type
     * @return arraylist of all terr_subset_rule that has both subsetId and terrType
     */
    ArrayList<Terr_subset_rule> findBySubsetIdAndTerrType(long subsetId, String terrType);

    /**
     * the max subsetId
     * 
     * @return the max subsetId
     */
    @Query(value = "SELECT max(subsetId) FROM Terr_subset_rule")
    public int max();

}
