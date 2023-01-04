package kzhang.demo.w22.Sales_pipeline.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.models.Terr_set;
import kzhang.demo.w22.Sales_pipeline.repositories.Terr_setRepository;

/**
 * The service is used to handle CRUD operations on the Terr_set model.
 * In
 * addition to all functionality from `Service`, we also have functionality for
 * retrieving a single Terr_set by id.
 *
 */
@Component
@Transactional
public class Terr_setService extends Service<Terr_set, Long> {

    /**
     * Terr_set, to be autowired in by Spring and provide CRUD
     * operations on Terr_set model.
     */
    @Autowired
    private Terr_setRepository Terr_setRepo;

    @Override
    protected JpaRepository<Terr_set, Long> getRepository() {
        return Terr_setRepo;
    }

    /**
     * Find a terr_set with the provided id
     * 
     * @param id
     *           id of the terr_set to find
     * @return id terr_set, null if none
     */
    public Terr_set findById(final long id) {
        return Terr_setRepo.findById(id);
    }

}
