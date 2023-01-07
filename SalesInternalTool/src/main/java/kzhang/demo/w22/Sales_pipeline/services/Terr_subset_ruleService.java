package kzhang.demo.w22.Sales_pipeline.services;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.models.Terr_subset_rule;
import kzhang.demo.w22.Sales_pipeline.repositories.Terr_subset_ruleRepository;

/**
 * The service is used to handle CRUD operations on the Terr_subset_rule model.
 * In
 * addition to all functionality from `Service`, we also have functionality for
 * retrieving a single transaction by id.
 *
 */
@Component
@Transactional
public class Terr_subset_ruleService extends Service<Terr_subset_rule, Long> {

    /**
     * Terr_subset_rule, to be autowired in by Spring and provide CRUD
     * operations on Transaction model.
     */
    @Autowired
    private Terr_subset_ruleRepository Terr_subset_ruleRepo;

    @Override
    protected JpaRepository<Terr_subset_rule, Long> getRepository() {
        return Terr_subset_ruleRepo;
    }

    /**
     * Find a terr_subset_rule with the provided id
     * 
     * @param id
     *           id of the terr_subset_rule to find
     * @return id terr_subset_rule, null if none
     */
    public Terr_subset_rule findById(final long id) {
        return Terr_subset_ruleRepo.findById(id);
    }

    /**
     * Find all terr_subset_rules with the provided subset_id and terrType
     * 
     * @param subsetId
     *                 id of the subset
     * @param terrType the terrType the subset_rule must have
     * @return arraylist of terr_subset_rules, null if none
     */
    public ArrayList<Terr_subset_rule> findBySubsetIdAndTerrType(final long subsetId, String terrType) {
        return Terr_subset_ruleRepo.findBySubsetIdAndTerrType(subsetId, terrType);
    }

    /**
     * returns the maximum subsetId
     * 
     * @return maximum subsetId
     */
    public int max() {
        return Terr_subset_ruleRepo.max();
    }

}
