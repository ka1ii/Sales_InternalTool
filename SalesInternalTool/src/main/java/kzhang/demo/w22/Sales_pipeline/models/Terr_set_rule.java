package kzhang.demo.w22.Sales_pipeline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Terr_set_rule extends DomainObject {

    // the id of the territory set
    @Id
    private long setRuleId;

    // the id of the corresponding set
    private long setId;

    // the id of the corresponding subset
    private long subsetId;

    // INCL_EXCL rule
    private char inclExclIndc;

    public Terr_set_rule(long setRuleId, long setId, long subsetId, char inclExclIndc) {
        this.setRuleId = setRuleId;
        this.setId = setId;
        this.subsetId = subsetId;
        this.inclExclIndc = inclExclIndc;
    }

    // default constructor
    public Terr_set_rule() {
    }

    public long getSetRuleId() {
        return setRuleId;
    }

    public void setSetRuleId(long setRuleId) {
        this.setRuleId = setRuleId;
    }

    public long getSetId() {
        return setId;
    }

    public void setSetId(long setId) {
        this.setId = setId;
    }

    public long getSubsetId() {
        return subsetId;
    }

    public void setSubsetId(long subsetId) {
        this.subsetId = subsetId;
    }

    public char getInclExclIndc() {
        return inclExclIndc;
    }

    public void setInclExclIndc(char inclExclIndc) {
        this.inclExclIndc = inclExclIndc;
    }

    @Override
    public String toString() {
        return "Terr_set_rule [setRuleId=" + setRuleId + ", setId=" + setId + ", subsetId=" + subsetId
                + ", inclExclIndc=" + inclExclIndc + "]";
    }

    @Override
    public Serializable getId() {
        return setRuleId;
    }

}