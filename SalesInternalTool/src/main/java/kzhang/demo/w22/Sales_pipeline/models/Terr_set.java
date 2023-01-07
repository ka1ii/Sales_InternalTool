package kzhang.demo.w22.Sales_pipeline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Terr_set extends DomainObject {

    // id of the set
    @Id
    private long SET_ID;

    // name of the set
    private String SET_NAME;

    // default
    public Terr_set() {
    }

    // constructor
    public Terr_set(long sET_ID, String sET_NAME) {
        SET_ID = sET_ID;
        SET_NAME = sET_NAME;
    }

    public long getSET_ID() {
        return SET_ID;
    }

    public void setSET_ID(long sET_ID) {
        SET_ID = sET_ID;
    }

    public String getSET_NAME() {
        return SET_NAME;
    }

    public void setSET_NAME(String sET_NAME) {
        SET_NAME = sET_NAME;
    }

    @Override
    public Serializable getId() {
        return SET_ID;
    }

    @Override
    public String toString() {
        return "Terr_set [SET_ID=" + SET_ID + ", SET_NAME=" + SET_NAME + "]";
    }

}
