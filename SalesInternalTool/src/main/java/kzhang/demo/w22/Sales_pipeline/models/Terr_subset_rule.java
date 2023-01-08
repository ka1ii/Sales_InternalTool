package kzhang.demo.w22.Sales_pipeline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Terr_subset_rule extends DomainObject {

    // Terr subset rule identifier, unique
    @Id
    private long subsetRuleId;

    // id of the corresponding subset
    private long subsetId;

    // territory type
    private String terrType;

    // territory value
    private String terrValue;

    // whether the rule is valid
    private char inclExclIndc;

    // default constructor
    public Terr_subset_rule() {
    }

    public Terr_subset_rule(long subsetRuleId, long subsetId, String terrType, String terrValue, char inclExclIndc) {
        this.subsetRuleId = subsetRuleId;
        this.subsetId = subsetId;
        this.terrType = terrType;
        this.terrValue = terrValue;
        this.inclExclIndc = inclExclIndc;
    }

    public long getSubsetRuleId() {
        return subsetRuleId;
    }

    public void setSubsetRuleId(long subsetRuleId) {
        this.subsetRuleId = subsetRuleId;
    }

    public long getSubsetId() {
        return subsetId;
    }

    public void setSubsetId(long subsetId) {
        this.subsetId = subsetId;
    }

    public String getTerrType() {
        return terrType;
    }

    public void setTerrType(String terrType) {
        this.terrType = terrType;
    }

    public String getTerrValue() {
        return terrValue;
    }

    public void setTerrValue(String terrValue) {
        this.terrValue = terrValue;
    }

    public char getInclExclIndc() {
        return inclExclIndc;
    }

    public void setInclExclIndc(char inclExclIndc) {
        this.inclExclIndc = inclExclIndc;
    }

    @Override
    public String toString() {
        return "Terr_subset_rule [subsetRuleId=" + subsetRuleId + ", subsetId=" + subsetId + ", terrType=" + terrType
                + ", terrValue=" + terrValue + ", inclExclIndc=" + inclExclIndc + "]";
    }

    @Override
    public Serializable getId() {
        return subsetRuleId;
    }

}