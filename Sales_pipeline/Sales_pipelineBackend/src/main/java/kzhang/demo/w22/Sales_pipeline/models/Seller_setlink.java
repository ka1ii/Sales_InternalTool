package kzhang.demo.w22.Sales_pipeline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seller_setlink extends DomainObject {

    // id of the seller_setlink
    @Id
    private long sellerSetlinkId;

    // id of the seller
    private long sellerId;

    // id of the set
    private long setId;

    // incl_excl
    private char inclExclIndc;

    public Seller_setlink(long sellerSetlinkId, long sellerId, long setId, char inclExclIndc) {
        this.sellerSetlinkId = sellerSetlinkId;
        this.sellerId = sellerId;
        this.setId = setId;
        this.inclExclIndc = inclExclIndc;
    }

    public Seller_setlink() {
    }

    public long getSellerSetlinkId() {
        return sellerSetlinkId;
    }

    public void setSellerSetlinkId(long sellerSetlinkId) {
        this.sellerSetlinkId = sellerSetlinkId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getSetId() {
        return setId;
    }

    public void setSetId(long setId) {
        this.setId = setId;
    }

    public char getInclExclIndc() {
        return inclExclIndc;
    }

    public void setInclExclIndc(char inclExclIndc) {
        this.inclExclIndc = inclExclIndc;
    }

    @Override
    public Serializable getId() {
        return sellerSetlinkId;
    }

    @Override
    public String toString() {
        return "Seller_setlink [sellerSetlinkId=" + sellerSetlinkId + ", sellerId=" + sellerId + ", setId=" + setId
                + ", inclExclIndc=" + inclExclIndc + "]";
    }

}
