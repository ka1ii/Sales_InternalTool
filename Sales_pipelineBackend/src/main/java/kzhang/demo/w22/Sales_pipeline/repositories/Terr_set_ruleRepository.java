package kzhang.demo.w22.Sales_pipeline.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kzhang.demo.w22.Sales_pipeline.models.Terr_set_rule;

/**
 * Terr_set_ruleREPO is used to provide CRUD operations for the Terr_set_rule
 * model.
 * Spring will generate appropriate code with JPA.
 *
 */
public interface Terr_set_ruleRepository extends JpaRepository<Terr_set_rule, Long> {

    /**
     * Finds a Terr_set_rule object with the provided id. Spring will generate
     * code
     * to make this happen.
     *
     * @param id
     *           id of the Terr_set_rule
     * @return Found Terr_set_rule, null if none.
     */
    Terr_set_rule findById(long id);

    /**
     * finds all terr_set_rules that corresponds with the provided setId and
     * incExclIndc value
     * 
     * @param setId        the setId provided
     * @param inclExclIndc the indclExclIndc value
     * @return arraylist of terr_set_rules associated
     */
    ArrayList<Terr_set_rule> findBySetIdAndInclExclIndc(long setId, char inclExclIndc);

    /**
     * the max setId
     * 
     * @return the max setId
     */
    @Query(value = "SELECT max(setId) FROM Terr_set_rule")
    public int max();

}
