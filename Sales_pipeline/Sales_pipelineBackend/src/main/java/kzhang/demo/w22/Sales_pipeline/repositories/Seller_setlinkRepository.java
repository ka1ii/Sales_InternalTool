package kzhang.demo.w22.Sales_pipeline.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kzhang.demo.w22.Sales_pipeline.models.Seller_setlink;

/**
 * Seller_setLinkREPO is used to provide CRUD operations for the Seller_setlink
 * model.
 * Spring will generate appropriate code with JPA.
 *
 */
public interface Seller_setlinkRepository extends JpaRepository<Seller_setlink, Long> {

    /**
     * Finds a Seller_setlink object with the provided id. Spring will generate
     * code
     * to make this happen.
     *
     * @param id
     *           id of the seller_setlink
     * @return Found seller_setlink, null if none.
     */
    Seller_setlink findById(long id);

    /**
     * finds all seller_setlink that corresponds with the provided sellerId and
     * incExclIndc value
     * 
     * @param sellerId     the sellerId provided
     * @param inclExclIndc the indclExclIndc value
     * @return arraylist of seller_setlinks associated
     */
    ArrayList<Seller_setlink> findBySellerIdAndInclExclIndc(long sellerId, char inclExclIndc);

    /**
     * the max sellerId
     * 
     * @return the max sellerId
     */
    @Query(value = "SELECT max(sellerId) FROM Seller_setlink")
    public int max();

}
