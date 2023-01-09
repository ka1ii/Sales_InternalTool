package kzhang.demo.w22.Sales_pipeline.data;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import kzhang.demo.w22.Sales_pipeline.data.localizedDatabase.Pair;
import kzhang.demo.w22.Sales_pipeline.models.*;
import kzhang.demo.w22.Sales_pipeline.services.*;

@EnableAutoConfiguration
@Component
public class GenerateSA {

    @Autowired
    private localizedDatabase db;

    @Autowired
    private TransactionServices transactionS;

    @Autowired
    private Seller_achievementService seller_achievementS;

    public GenerateSA() {

    }

    /**
     * checks if the rule matches with the current transaction
     * 
     * @param transaction the current transaction
     * @param rule        corresponding rule
     * @return true if matches
     */
    private boolean matchesRule(Transaction transaction, String terr_type, String terr_val) {
        if (terr_type.equals("ACCT_YR")) {
            if (terr_val.equals(transaction.getAcctyr())) {
                return true;
            }
            return false;
        } else if (terr_type.equals("ACCT_MTH")) {
            if (terr_val.equals(transaction.getAcctmth())) {
                return true;
            }
            return false;
        } else if (terr_type.equals("ACCOUNT")) {
            if (terr_val.equals(transaction.getAccount())) {
                return true;
            }
            return false;
        } else if (terr_type.equals("CUSTNUM")) {
            if (terr_val.equals(transaction.getCustnum())) {
                return true;
            }
            return false;
        } else if (terr_type.equals("CHANID")) {
            if (terr_val.equals(transaction.getChandid())) {
                return true;
            }
            return false;
        } else if (terr_type.equals("RCTRYNUM")) {
            if (terr_val.equals(transaction.getRctrynum())) {
                return true;
            }
            return false;
        } else if (terr_type.equals("DEPTNUM")) {
            if (terr_val.equals(transaction.getDeptnum())) {
                return true;
            }
            return false;
        } else if (terr_type.equals("PRODID")) {
            if (terr_val.equals(transaction.getProdid())) {
                return true;
            }
            return false;
        } else if (terr_type.equals("CONTRACTNUM")) {
            if (terr_val.equals(transaction.getContractnum())) {
                return true;
            }
            return false;
        } else {
            if (terr_val.equals("" + transaction.getUsdollar())) {
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
        HashMap<Character, ArrayList<Long>>[] sellerlinks = db.getSellerLinkMapList();
        // iterate through all the seller_setlinks
        for (int i = 1; i < sellerlinks.length; i++) {
            int matchedAllRules = 0;
            // all 'A' InclExclIndc rule must match
            if (sellerlinks[i].get('A') != null) {
                for (Long sellerId : sellerlinks[i].get('A')) {
                    if (set.contains(sellerId)) {
                        matchedAllRules = 1;
                    } else {
                        // break once finding a non-matching rule
                        // the set does not match
                        matchedAllRules = -1;
                        break;
                    }
                }
            }
            // if not 'A' rules match, continue to the next set
            // if there are no 'A' rules or all 'A' rules match, keep matching 'O' rules
            if (matchedAllRules < 0) {
                continue;
            }

            // only one 'O' InclExclIndc rule need to match
            if (sellerlinks[i].get('O') != null) {
                for (Long sellerId : sellerlinks[i].get('O')) {
                    if (set.contains(sellerId)) {
                        // exit after finding one matching rule
                        matchedAllRules = 1;
                        break;
                    }
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
        HashMap<Character, ArrayList<Long>>[] setList = db.getSetRuleMapList();
        // iterate through all sets
        for (int i = 1; i < setList.length; i++) {
            int matchedAllRules = 0;
            // all 'A' InclExclIndc rule must match
            if (setList[i].get('A') != null) {
                for (Long subsetId : setList[i].get('A')) {
                    System.out.println(i);
                    if (subset.contains(subsetId)) {
                        matchedAllRules = 1;
                    } else {
                        // break once finding a non-matching rule
                        // the set does not match
                        matchedAllRules = -1;
                        break;
                    }
                }
            }
            // if not 'A' rules match, continue to the next set
            // if there are no 'A' rules or all 'A' rules match, keep matching 'O' rules
            if (matchedAllRules < 0) {
                continue;
            }

            // only one 'O' InclExclIndc rule need to match
            if (setList[i].get('O') != null) {
                for (Long subsetId : setList[i].get('O')) {
                    if (subset.contains(subsetId)) {
                        // exit after finding one matching rule
                        matchedAllRules = 1;
                        break;
                    }
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
        HashMap<String, ArrayList<Pair<String, Character>>>[] subsetRules = db.getSubsetRuleMapList();
        for (int i = 1; i < subsetRules.length; i++) {
            // must match one of every terrType
            boolean matchedAllTypes = false;

            // iterate through all the rules for a particular terr type
            for (String type : subsetRules[i].keySet()) {

                // must find a match within each subset
                boolean matchedCurType = false;
                for (Pair<String, Character> pair : subsetRules[i].get(type)) {
                    if (matchesRule(transaction, type, pair.first) && pair.second == 'I') {
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
                arr.add((Long) (long) i);
            }
        }
        // with all the matched subset rules, match the corresponding set_rules
        return arr;
    }

    /**
     * generates Seller achievements from a single transaction
     * 
     * @param transaction
     */
    public void generateSellerAchievement(Transaction transaction) {
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
                    transaction.getTransactionid(),
                    transaction.getUsdollar());
            seller_achievementS.save(s);
        }
    }

    /**
     * generates seller achievement from existing transaction database
     */
    public void generateAllSellerAchievement() {
        // find all sellers that matches with a given transaction

        for (Transaction transaction : transactionS.findAll()) {
            generateSellerAchievement(transaction);
        }
    }

}