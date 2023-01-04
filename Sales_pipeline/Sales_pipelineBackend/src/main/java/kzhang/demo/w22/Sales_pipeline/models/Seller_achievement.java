package kzhang.demo.w22.Sales_pipeline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Seller_achievement extends DomainObject {

    // id for individual seller achievement
    @Id
    @GeneratedValue
    private long SELLER_ACHIEVEMENT_ID;

    // the seller's id
    private long SELLER_ID;

    // the transaction's id
    private long TRANSACTION_ID;

    // achievement amount
    private double ACHIEVEMENT;

    public Seller_achievement() {
    }

    public Seller_achievement(long sELLER_ID, long tRANSACTION_ID, double aCHIEVEMENT) {
        SELLER_ID = sELLER_ID;
        TRANSACTION_ID = tRANSACTION_ID;
        ACHIEVEMENT = aCHIEVEMENT;
    }

    public long getSELLER_ACHIEVEMENT_ID() {
        return SELLER_ACHIEVEMENT_ID;
    }

    public void setSELLER_ACHIEVEMENT_ID(long sELLER_ACHIEVEMENT_ID) {
        SELLER_ACHIEVEMENT_ID = sELLER_ACHIEVEMENT_ID;
    }

    public long getSELLER_ID() {
        return SELLER_ID;
    }

    public void setSELLER_ID(long sELLER_ID) {
        SELLER_ID = sELLER_ID;
    }

    public long getTRANSACTION_ID() {
        return TRANSACTION_ID;
    }

    public void setTRANSACTION_ID(long tRANSACTION_ID) {
        TRANSACTION_ID = tRANSACTION_ID;
    }

    public double getACHIEVEMENT() {
        return ACHIEVEMENT;
    }

    public void setACHIEVEMENT(double aCHIEVEMENT) {
        ACHIEVEMENT = aCHIEVEMENT;
    }

    @Override
    public Serializable getId() {
        return SELLER_ACHIEVEMENT_ID;
    }

}