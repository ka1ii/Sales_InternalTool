package kzhang.demo.w22.Sales_pipeline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction extends DomainObject {

    @Id
    // transaction id not generated locally
    private long transactionid;

    // The year of the transaction
    private String acctyr;

    // the month
    private String acctmth;

    // the account
    private String account;

    // the customer number
    private String custnum;

    // id
    private String chandid;

    // country / region number
    private String rctrynum;

    // the department number
    private String deptnum;

    // id of the product sold
    private String prodid;

    // the contract number
    private String contractnum;

    // the amount sold in USD
    private double usdollar;

    // default constructor
    public Transaction() {
        // do nothing
    }

    public Transaction(long transactionid, String acctyr, String acctmth, String account, String custnum,
            String chandid, String rctrynum, String deptnum, String prodid, String contractnum, double usdollar) {
        this.transactionid = transactionid;
        this.acctyr = acctyr;
        this.acctmth = acctmth;
        this.account = account;
        this.custnum = custnum;
        this.chandid = chandid;
        this.rctrynum = rctrynum;
        this.deptnum = deptnum;
        this.prodid = prodid;
        this.contractnum = contractnum;
        this.usdollar = usdollar;
    }

    public long getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(long transactionid) {
        this.transactionid = transactionid;
    }

    public String getAcctyr() {
        return acctyr;
    }

    public void setAcctyr(String acctyr) {
        this.acctyr = acctyr;
    }

    public String getAcctmth() {
        return acctmth;
    }

    public void setAcctmth(String acctmth) {
        this.acctmth = acctmth;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCustnum() {
        return custnum;
    }

    public void setCustnum(String custnum) {
        this.custnum = custnum;
    }

    public String getChandid() {
        return chandid;
    }

    public void setChandid(String chandid) {
        this.chandid = chandid;
    }

    public String getRctrynum() {
        return rctrynum;
    }

    public void setRctrynum(String rctrynum) {
        this.rctrynum = rctrynum;
    }

    public String getDeptnum() {
        return deptnum;
    }

    public void setDeptnum(String deptnum) {
        this.deptnum = deptnum;
    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public String getContractnum() {
        return contractnum;
    }

    public void setContractnum(String contractnum) {
        this.contractnum = contractnum;
    }

    public double getUsdollar() {
        return usdollar;
    }

    public void setUsdollar(double usdollar) {
        this.usdollar = usdollar;
    }

    @Override
    public Serializable getId() {
        return transactionid;
    }

    @Override
    public String toString() {
        return "Transaction [transactionid=" + transactionid + ", acctyr=" + acctyr + ", acctmth=" + acctmth
                + ", account=" + account + ", custnum=" + custnum + ", chandid=" + chandid + ", rctrynum=" + rctrynum
                + ", deptnum=" + deptnum + ", prodid=" + prodid + ", contractnum=" + contractnum + ", usdollar="
                + usdollar + "]";
    }

}
