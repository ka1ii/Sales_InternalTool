package kzhang.demo.w22.Sales_pipeline.data;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.models.*;
import kzhang.demo.w22.Sales_pipeline.services.*;

/**
 * this class serves as a localized database from which we can access the rules
 * without query
 * departmentalize data correspondingly for business logic implementation
 */
@EnableAutoConfiguration
@Component
@SuppressWarnings({ "unchecked" })
public class localizedDatabase {

    @Autowired
    private Terr_subset_ruleService terr_subset_ruleS;

    @Autowired
    private Terr_set_ruleService terr_set_ruleS;

    @Autowired
    private Seller_setlinkService seller_setlinkS;

    // array slot corresponds to the subset id
    // string represents the terr_type
    // Character represents the INCLEXCLINDC rule
    private HashMap<String, ArrayList<Pair<String, Character>>>[] subsetRuleMapList;

    // array slot corresponds to the set id
    // Character represents INCLEXCLINDC value
    // key is the list of subset ids matching
    private HashMap<Character, ArrayList<Long>>[] setRuleMapList;

    // array slot corresponds to the seller id
    // Character represents INCLEXCLINDC value
    // key is the list of set ids matching
    private HashMap<Character, ArrayList<Long>>[] sellerLinkMapList;

    public localizedDatabase() {

    }

    /**
     * call this method once the subset rules, set rules, and seller link rules are
     * loaded into mysql
     * this initializes a local copy of the database
     */
    @PostConstruct
    public void initialize() {
        // initialize the list of map(subset rules)
        // from id 1 to max
        int subsetNum = terr_subset_ruleS.max();
        subsetRuleMapList = new HashMap[subsetNum + 1];
        // Initialize each element of the array to a new HashMap
        for (int i = 0; i <= subsetNum; i++) {
            subsetRuleMapList[i] = new HashMap<String, ArrayList<Pair<String, Character>>>();
        }
        // save all rules into the list
        List<Terr_subset_rule> subset_rules = terr_subset_ruleS.findAll();
        for (Terr_subset_rule rule : subset_rules) {
            // initiallize the key value pair if null
            if (subsetRuleMapList[(int) rule.getSubsetId()].get(rule.getTerrType()) == null) {
                ArrayList<Pair<String, Character>> list1 = new ArrayList<Pair<String, Character>>();
                subsetRuleMapList[(int) rule.getSubsetId()].put(rule.getTerrType(), list1);
            }
            // adds the subset rule to the list of existing rules for the particular subset
            // and terr type
            subsetRuleMapList[(int) rule.getSubsetId()].get(rule.getTerrType())
                    .add(new Pair<String, Character>(rule.getTerrValue(), rule.getInclExclIndc()));

        }

        // initialize the set rule map
        int setNum = terr_set_ruleS.max();
        setRuleMapList = new HashMap[setNum + 1];
        // Initialize each element of the array to a new HashMap
        for (int i = 0; i <= setNum; i++) {
            setRuleMapList[i] = new HashMap<Character, ArrayList<Long>>();
        }
        // save all set rules into the list
        List<Terr_set_rule> set_rules = terr_set_ruleS.findAll();
        for (Terr_set_rule rule : set_rules) {
            // initialize the key value pair if null
            if (setRuleMapList[(int) rule.getSetId()].get(rule.getInclExclIndc()) == null) {
                ArrayList<Long> list1 = new ArrayList<>();
                setRuleMapList[(int) rule.getSetId()].put(rule.getInclExclIndc(), list1);
            }
            // add the set rule to the list of existing rules for a particular set
            setRuleMapList[(int) rule.getSetId()].get(rule.getInclExclIndc()).add(rule.getSubsetId());
        }

        // initialize the seller setlink map
        int sellerNum = seller_setlinkS.max();
        sellerLinkMapList = new HashMap[sellerNum + 1];

        // Initialize each element of the array to a new HashMap
        for (int i = 0; i <= sellerNum; i++) {
            sellerLinkMapList[i] = new HashMap<Character, ArrayList<Long>>();
        }

        // save all set rules into the list
        List<Seller_setlink> sellerLinks = seller_setlinkS.findAll();
        for (Seller_setlink link : sellerLinks) {
            // initialize the key value pair if null
            if (sellerLinkMapList[(int) link.getSellerId()].get(link.getInclExclIndc()) == null) {
                ArrayList<Long> list1 = new ArrayList<>();
                sellerLinkMapList[(int) link.getSellerId()].put(link.getInclExclIndc(), list1);
            }
            // add the set rule to the list of existing rules for a particular set
            sellerLinkMapList[(int) link.getSellerId()].get(link.getInclExclIndc()).add(link.getSetId());
        }

    }

    // A simple class to represent a pair of long and char values
    class Pair<T1, T2> {
        T1 first;
        T2 second;

        Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    public HashMap<String, ArrayList<Pair<String, Character>>>[] getSubsetRuleMapList() {
        return subsetRuleMapList;
    }

    public HashMap<Character, ArrayList<Long>>[] getSetRuleMapList() {
        return setRuleMapList;
    }

    public HashMap<Character, ArrayList<Long>>[] getSellerLinkMapList() {
        return sellerLinkMapList;
    }

}
