package kzhang.demo.w22.Sales_pipeline.data;

import java.util.*;

import javax.transaction.Transactional;
import org.junit.Assert;

import kzhang.demo.w22.Sales_pipeline.TestConfig;
import kzhang.demo.w22.Sales_pipeline.data.localizedDatabase.Pair;
import kzhang.demo.w22.Sales_pipeline.models.*;
import kzhang.demo.w22.Sales_pipeline.services.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = TestConfig.class)
public class GenerateSATest {

        @Autowired
        private TransactionServices transactionS;

        @Autowired
        private GenerateSA gsa;

        @Autowired
        private localizedDatabase lbase;

        @Test
        @Transactional
        public void testMatchingSubsets() {
                Transaction t1 = new Transaction(111, "2022", "6", "40601004", "400031", "A", "631", "22", "p123d",
                                "345",
                                123);

                Transaction t2 = new Transaction(112, "2014", "May", "dd", "1234", "245", "1", "22", "p123d", "345",
                                444);

                transactionS.save(t1);
                transactionS.save(t2);

                HashSet<Long> set = gsa.matchSubset(transactionS.findById(111));
                Assert.assertTrue(set.contains((Long) (long) 9));
        }

        @Test
        public void testcreatingSA() {
                gsa.generateAllSellerAchievement();
        }

        @Test
        public void testMatchingSubsets2() {
                Transaction t1 = transactionS.findById(1);
                HashSet<Long> set = gsa.matchSubset(t1);
                for (Long i : set) {
                        System.out.println(i);
                }
        }

        @Test
        public void testMatchingSets2() {
                HashSet<Long> set = new HashSet<>();
                set.add((Long) (long) 1);
                set.add((Long) (long) 3);
                HashSet<Long> set2 = gsa.matchSet(set);
                for (Long i : set2) {
                        System.out.println(i);
                }
        }

        @Test
        public void testMatchingSellerlinks2() {
                HashSet<Long> set = new HashSet<>();
                set.add((Long) (long) 1);
                set.add((Long) (long) 4);
                ArrayList<Long> set2 = gsa.matchSellers(set);
                for (Long i : set2) {
                        System.out.println(i);
                }
        }

        @Test
        public void testcreatinglocalizedDatabase() {
                // int i = 0;
                // HashMap<Character, ArrayList<Long>>[] arry = lbase.getSellerLinkMapList();
                // for (HashMap<Character, ArrayList<Long>> map : arry) {
                // System.out.println(i);
                // for (Character terr_type : map.keySet()) {
                // System.out.print(terr_type);
                // for (Long pair : map.get(terr_type)) {
                // System.out.print("" + pair);
                // }
                // System.out.println();
                // }
                // i++;
                // }

                int j = 0;
                HashMap<Character, ArrayList<Long>>[] arry2 = lbase.getSetRuleMapList();
                for (HashMap<Character, ArrayList<Long>> map : arry2) {
                        System.out.println(j);
                        for (Character terr_type : map.keySet()) {
                                System.out.print(terr_type);
                                for (Long pair : map.get(terr_type)) {
                                        System.out.print("" + pair);
                                }
                                System.out.println();
                        }
                        j++;
                }
        }

}
