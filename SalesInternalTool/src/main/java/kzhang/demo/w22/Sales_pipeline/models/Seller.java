package kzhang.demo.w22.Sales_pipeline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seller extends DomainObject {

    // id of the seller
    @Id
    private long SELLER_ID;

    // name of the seller
    private String SELLER_NAME;

    // CNUM of the seller
    private String SELLER_CNUM;

    // appr status of the seller
    private int APPR_STATUS;

    public Seller() {
    }

    public Seller(long sELLER_ID, String sELLER_NAME, String sELLER_CNUM, int aPPR_STATUS) {
        SELLER_ID = sELLER_ID;
        SELLER_NAME = sELLER_NAME;
        SELLER_CNUM = sELLER_CNUM;
        APPR_STATUS = aPPR_STATUS;
    }

    public long getSELLER_ID() {
        return SELLER_ID;
    }

    public void setSELLER_ID(long sELLER_ID) {
        SELLER_ID = sELLER_ID;
    }

    public String getSELLER_NAME() {
        return SELLER_NAME;
    }

    public void setSELLER_NAME(String sELLER_NAME) {
        SELLER_NAME = sELLER_NAME;
    }

    public String getSELLER_CNUM() {
        return SELLER_CNUM;
    }

    public void setSELLER_CNUM(String sELLER_CNUM) {
        SELLER_CNUM = sELLER_CNUM;
    }

    public int getAPPR_STATUS() {
        return APPR_STATUS;
    }

    public void setAPPR_STATUS(int aPPR_STATUS) {
        APPR_STATUS = aPPR_STATUS;
    }

    @Override
    public Serializable getId() {
        return SELLER_ID;
    }

    @Override
    public String toString() {
        return "Seller [SELLER_ID=" + SELLER_ID + ", SELLER_NAME=" + SELLER_NAME + ", SELLER_CNUM=" + SELLER_CNUM
                + ", APPR_STATUS=" + APPR_STATUS + "]";
    }

}
