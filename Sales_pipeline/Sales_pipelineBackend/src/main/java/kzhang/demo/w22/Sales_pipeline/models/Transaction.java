package kzhang.demo.w22.Sales_pipeline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction extends DomainObject {

    @Id
    // transaction id not generated locally
    private long TRANSACTION_ID;

    // The year of the transaction
    private String ACCT_YR;

    // the month
    private String ACCT_MTH;

    // the account
    private String ACCOUNT;

    // the customer number
    private String CUSTNUM;

    // id
    private String CHANID;

    // country / region number
    private String RCTRYNUM;

    // the department number
    private String DEPTNUM;

    // id of the product sold
    private String PRODID;

    // the contract number
    private String CONTRACTNUM;

    // the amount sold in USD
    private double US_DOLLAR;

    // default constructor
    public Transaction() {
        // do nothing
    }

    // constructor
    public Transaction(long tRANSACTION_ID, String aCCT_YR, String aCCT_MTH, String aCCOUNT,
            String cUSTNUM, String cHANID, String rCTRYNUM, String dEPTNUM, String pRODID, String cONTRACTNUM,
            double uS_DOLLAR) {
        TRANSACTION_ID = tRANSACTION_ID;
        ACCT_YR = aCCT_YR;
        ACCT_MTH = aCCT_MTH;
        ACCOUNT = aCCOUNT;
        CUSTNUM = cUSTNUM;
        CHANID = cHANID;
        RCTRYNUM = rCTRYNUM;
        DEPTNUM = dEPTNUM;
        PRODID = pRODID;
        CONTRACTNUM = cONTRACTNUM;
        US_DOLLAR = uS_DOLLAR;
    }

    public Long getTRANSACTION_ID() {
        return TRANSACTION_ID;
    }

    public void setTRANSACTION_ID(long tRANSACTION_ID) {
        TRANSACTION_ID = tRANSACTION_ID;
    }

    public String getACCT_YR() {
        return ACCT_YR;
    }

    public void setACCT_YR(String aCCT_YR) {
        ACCT_YR = aCCT_YR;
    }

    public String getACCT_MTH() {
        return ACCT_MTH;
    }

    public void setACCT_MTH(String aCCT_MTH) {
        ACCT_MTH = aCCT_MTH;
    }

    public String getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(String aCCOUNT) {
        ACCOUNT = aCCOUNT;
    }

    public String getCUSTNUM() {
        return CUSTNUM;
    }

    public void setCUSTNUM(String cUSTNUM) {
        CUSTNUM = cUSTNUM;
    }

    public String getCHANID() {
        return CHANID;
    }

    public void setCHANID(String cHANID) {
        CHANID = cHANID;
    }

    public String getRCTRYNUM() {
        return RCTRYNUM;
    }

    public void setRCTRYNUM(String rCTRYNUM) {
        RCTRYNUM = rCTRYNUM;
    }

    public String getDEPTNUM() {
        return DEPTNUM;
    }

    public void setDEPTNUM(String dEPTNUM) {
        DEPTNUM = dEPTNUM;
    }

    public String getPRODID() {
        return PRODID;
    }

    public void setPRODID(String pRODID) {
        PRODID = pRODID;
    }

    public String getCONTRACTNUM() {
        return CONTRACTNUM;
    }

    public void setCONTRACTNUM(String cONTRACTNUM) {
        CONTRACTNUM = cONTRACTNUM;
    }

    public double getUS_DOLLAR() {
        return US_DOLLAR;
    }

    public void setUS_DOLLAR(double uS_DOLLAR) {
        US_DOLLAR = uS_DOLLAR;
    }

    @Override
    public Serializable getId() {
        return TRANSACTION_ID;
    }

    @Override
    public String toString() {
        return "Transaction [TRANSACTION_ID=" + TRANSACTION_ID + ", ACCT_YR=" + ACCT_YR + ", ACCT_MTH=" + ACCT_MTH
                + ", ACCOUNT=" + ACCOUNT + ", CUSTNUM=" + CUSTNUM + ", CHANID=" + CHANID
                + ", RCTRYNUM=" + RCTRYNUM + ", DEPTNUM=" + DEPTNUM + ", PRODID=" + PRODID + ", CONTRACTNUM="
                + CONTRACTNUM + ", US_DOLLAR=" + US_DOLLAR + "]";
    }

}
