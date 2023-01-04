package kzhang.demo.w22.Sales_pipeline.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.models.Terr_set_rule;
import kzhang.demo.w22.Sales_pipeline.repositories.Terr_set_ruleRepository;

/**
 * The service is used to handle CRUD operations on the Terr_set_rule model.
 * In
 * addition to all functionality from `Service`, we also have functionality for
 * retrieving a single terr_set_rule by id.
 *
 */
@Component
@Transactional
public class Terr_set_ruleService extends Service<Terr_set_rule, Long> {

    /**
     * Terr_set_rule, to be autowired in by Spring and provide CRUD
     * operations on Terr_set_rule model.
     */
    @Autowired
    private Terr_set_ruleRepository Terr_set_ruleRepo;

    @Override
    protected JpaRepository<Terr_set_rule, Long> getRepository() {
        return Terr_set_ruleRepo;
    }

    /**
     * Find a terr_set_rule with the provided id
     * 
     * @param id
     *           id of the terr_set_rule to find
     * @return id terr_set_rule, null if none
     */
    public Terr_set_rule findById(final long id) {
        return Terr_set_ruleRepo.findById(id);
    }

    /**
     * finds all terr_set_rules with given setId and inclExclIndc rule
     * 
     * @param setId        the setId given
     * @param inclExclIndc the inclExclIndc value given
     * @return arraylist of terr_set_rules or null
     */
    public ArrayList<Terr_set_rule> findBySetIdAndInclExclIndc(long setId, char inclExclIndc) {
        return Terr_set_ruleRepo.findBySetIdAndInclExclIndc(setId, inclExclIndc);
    }

    /**
     * returns the maximum setId
     * 
     * @return maximum setId
     */
    public int max() {
        return Terr_set_ruleRepo.max();
    }

}
