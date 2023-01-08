package kzhang.demo.w22.Sales_pipeline.data;

import java.util.*;

import javax.transaction.Transactional;
import org.junit.Assert;

import kzhang.demo.w22.Sales_pipeline.TestConfig;
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

}
