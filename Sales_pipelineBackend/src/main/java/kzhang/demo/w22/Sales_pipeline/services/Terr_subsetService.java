package kzhang.demo.w22.Sales_pipeline.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.models.Terr_subset;
import kzhang.demo.w22.Sales_pipeline.repositories.Terr_subsetRepository;

/**
 * The service is used to handle CRUD operations on the Terr_subset model.
 * In
 * addition to all functionality from `Service`, we also have functionality for
 * retrieving a single Terr_subset by id.
 *
 */
@Component
@Transactional
public class Terr_subsetService extends Service<Terr_subset, Long> {

    /**
     * Terr_subset_rule, to be autowired in by Spring and provide CRUD
     * operations on Transaction model.
     */
    @Autowired
    private Terr_subsetRepository Terr_subsetRepo;

    @Override
    protected JpaRepository<Terr_subset, Long> getRepository() {
        return Terr_subsetRepo;
    }

    /**
     * Find a terr_subset with the provided id
     * 
     * @param id
     *           id of the terr_subset to find
     * @return id terr_subset, null if none
     */
    public Terr_subset findById(final long id) {
        return Terr_subsetRepo.findById(id);
    }

}
