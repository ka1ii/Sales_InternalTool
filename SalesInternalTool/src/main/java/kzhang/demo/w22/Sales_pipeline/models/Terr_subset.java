package kzhang.demo.w22.Sales_pipeline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Terr_subset extends DomainObject {

    // Terr subset rule identifier, unique
    @Id
    private long SUBSET_ID;

    // name of the corresponding subset
    private String SUBSET_NAME;

    @Override
    public Serializable getId() {
        return SUBSET_ID;
    }

    public long getSUBSET_ID() {
        return SUBSET_ID;
    }

    public void setSUBSET_ID(long sUBSET_ID) {
        SUBSET_ID = sUBSET_ID;
    }

    public String getSUBSET_NAME() {
        return SUBSET_NAME;
    }

    public void setSUBSET_NAME(String sUBSET_NAME) {
        SUBSET_NAME = sUBSET_NAME;
    }

    @Override
    public String toString() {
        return "Terr_subset [SUBSET_ID=" + SUBSET_ID + ", SUBSET_NAME=" + SUBSET_NAME + "]";
    }

}