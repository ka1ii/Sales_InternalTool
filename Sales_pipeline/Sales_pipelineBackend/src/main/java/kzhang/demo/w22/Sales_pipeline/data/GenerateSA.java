package kzhang.demo.w22.Sales_pipeline.data;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.models.*;
import kzhang.demo.w22.Sales_pipeline.services.*;

@EnableAutoConfiguration
@Component
public class GenerateSA {

    @Autowired
    private TransactionServices transactionS;

    @Autowired
    private Terr_subset_ruleService terr_subset_ruleS;

    @Autowired
    private Seller_achievementService seller_achievementS;

    @Autowired
    private Terr_set_ruleService terr_set_ruleS;

    @Autowired
    private Seller_setlinkService seller_setlinkS;

    private String[] TYPES = { "ACCT_YR", "ACCT_MTH", "ACCOUNT", "CUSTNUM", "CHANID", "RCTRYNUM", "DEPTNUM",
            "PRODID",
            "CONTRACTNUM", "US_DOLLAR" };

    public GenerateSA() {
    }

    /**
     * checks if the rule matches with the current transaction
     * 
     * @param transaction the current transaction
     * @param rule        corresponding rule
     * @return true if matches
     */
    private boolean matchesRule(Transaction transaction, Terr_subset_rule rule) {
        if (rule.getTerrType().equals("ACCT_YR")) {
            if (rule.getTerrValue().equals(transaction.getACCT_YR())) {
                return true;
            }
            return false;
        } else if (rule.getTerrType().equals("ACCT_MTH")) {
            if (rule.getTerrValue().equals(transaction.getACCT_MTH())) {
                return true;
            }
            return false;
        } else if (rule.getTerrType().equals("ACCOUNT")) {
            if (rule.getTerrValue().equals(transaction.getACCOUNT())) {
                return true;
            }
            return false;
        } else if (rule.getTerrType().equals("CUSTNUM")) {
            if (rule.getTerrValue().equals(transaction.getCUSTNUM())) {
                return true;
            }
            return false;
        } else if (rule.getTerrType().equals("CHANID")) {
            if (rule.getTerrValue().equals(transaction.getCHANID())) {
                return true;
            }
            return false;
        } else if (rule.getTerrType().equals("RCTRYNUM")) {
            if (rule.getTerrValue().equals(transaction.getRCTRYNUM())) {
                return true;
            }
            return false;
        } else if (rule.getTerrType().equals("DEPTNUM")) {
            if (rule.getTerrValue().equals(transaction.getDEPTNUM())) {
                return true;
            }
            return false;
        } else if (rule.getTerrType().equals("PRODID")) {
            if (rule.getTerrValue().equals(transaction.getPRODID())) {
                return true;
            }
            return false;
        } else if (rule.getTerrType().equals("CONTRACTNUM")) {
            if (rule.getTerrValue().equals(transaction.getCONTRACTNUM())) {
                return true;
            }
            return false;
        } else {
            if (rule.getTerrValue().equals("" + transaction.getUS_DOLLAR())) {
                return true;
            }
            return false;
        }
    }

    /**
     * matches set to corresponding sellers through seller_setlink rules
     * 
     * @param set the rules
     * @return arraylist of matched sellers
     */
    public ArrayList<Long> matchSellers(HashSet<Long> set) {
        ArrayList<Long> arr = new ArrayList<>();
        // max id of the sellers
        int sellerNum = seller_setlinkS.max();
        // iterate through all the seller_setlinks
        for (int i = 0; i <= sellerNum; i++) {
            int matchedAllRules = 0;
            // all 'A' InclExclIndc rule must match
            for (Seller_setlink rule : seller_setlinkS.findBySellerIdAndInclExclIndc(i, 'A')) {
                if (set.contains(rule.getSetId())) {
                    matchedAllRules = 1;
                } else {
                    // break once finding a non-matching rule
                    // the set does not match
                    matchedAllRules = -1;
                    break;
                }
            }
            // if not 'A' rules match, continue to the next set
            // if there are no 'A' rules or all 'A' rules match, keep matching 'O' rules
            if (matchedAllRules < 0) {
                continue;
            }

            // only one 'O' InclExclIndc rule need to match
            for (Seller_setlink rule : seller_setlinkS.findBySellerIdAndInclExclIndc(i, 'O')) {
                if (set.contains(rule.getSetId())) {
                    // exit after finding one matching rule
                    matchedAllRules = 1;
                    break;
                }
            }
            // case if didn't match any 'O' rule nor 'A' rules
            if (matchedAllRules == 0) {
                continue;
            }
            // matched at least one 'O' rule and all 'A' rule
            arr.add((Long) (long) i);

        }
        return arr;
    }

    /**
     * takes all the matched subsets and finds the corresponding sets
     * 
     * @param arr arraylist of matched subsets
     * @return sets, the sets that corresponds to the rule
     */
    public HashSet<Long> matchSet(HashSet<Long> subset) {
        HashSet<Long> sets = new HashSet<>();
        int setNum = terr_set_ruleS.max();
        // iterate through all sets
        for (int i = 1; i <= setNum; i++) {
            int matchedAllRules = 0;
            // all 'A' InclExclIndc rule must match
            for (Terr_set_rule rule : terr_set_ruleS.findBySetIdAndInclExclIndc(i, 'A')) {
                if (subset.contains(rule.getSubsetId())) {
                    matchedAllRules = 1;
                } else {
                    // break once finding a non-matching rule
                    // the set does not match
                    matchedAllRules = -1;
                    break;
                }
            }
            // if not 'A' rules match, continue to the next set
            // if there are no 'A' rules or all 'A' rules match, keep matching 'O' rules
            if (matchedAllRules < 0) {
                continue;
            }

            // only one 'O' InclExclIndc rule need to match
            for (Terr_set_rule rule : terr_set_ruleS.findBySetIdAndInclExclIndc(i, 'O')) {
                if (subset.contains(rule.getSubsetId())) {
                    // exit after finding one matching rule
                    matchedAllRules = 1;
                    break;
                }
            }
            // case if didn't match any 'O' rule nor 'A' rules
            if (matchedAllRules == 0) {
                continue;
            }
            // matched at least one 'O' rule and all 'A' rule
            sets.add((Long) (long) i);

        }
        return sets;
    }

    /**
     * matches each transaction to its subset and returns the matching subsets
     * 
     * @param transaction the transaction to be matched
     * @return HashSet of subsets that each transaction correlates to
     */
    public HashSet<Long> matchSubset(Transaction transaction) {
        HashSet<Long> arr = new HashSet<>();
        int setNum = terr_subset_ruleS.max();
        for (int i = 1; i <= setNum; i++) {
            // must match one of every terrType
            boolean matchedAllTypes = false;
            for (int j = 0; j < TYPES.length; j++) {
                // iterate through every terrType within given subsetId, skip if null
                if (terr_subset_ruleS.findBySubsetIdAndTerrType(i, TYPES[j]).size() == 0) {
                    continue;
                }
                // must find a match within each subset
                boolean matchedCurType = false;
                for (Terr_subset_rule rule : terr_subset_ruleS.findBySubsetIdAndTerrType(i, TYPES[j])) {
                    if (matchesRule(transaction, rule) && rule.getInclExclIndc() == 'I') {
                        matchedCurType = true;
                        break;
                    }
                }
                // if the current type isn't matched, the subset is deemed invalid
                // move on to the next subset
                if (!matchedCurType) {
                    matchedAllTypes = false;
                    break;
                }
                matchedAllTypes = true;
            }
            if (matchedAllTypes) {
                System.out.println(i);
                arr.add((Long) (long) i);
            }
        }
        // with all the matched subset rules, match the corresponding set_rules
        return arr;
    }

    public void generateSellerAchievement() {
        // find all sellers that matches with a given transaction

        for (Transaction transaction : transactionS.findAll()) {
            // find all matching subsets for this transaction
            HashSet<Long> subsets = matchSubset(transaction);
            // find all matching sets for the matching subsets
            HashSet<Long> sets = matchSet(subsets);
            // find all matching sellers for the matching sets
            ArrayList<Long> sellerIds = matchSellers(sets);

            // with the sellers, create new Seller_achievements and
            // save it in database
            for (Long sellerId : sellerIds) {
                Seller_achievement s = new Seller_achievement(sellerId,
                        transaction.getTRANSACTION_ID(),
                        transaction.getUS_DOLLAR());
                seller_achievementS.save(s);
            }
        }
    }

}