package kzhang.demo.w22.Sales_pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kzhang.demo.w22.Sales_pipeline.data.GenerateSA;

/**
 * Generates the inital table in MySQL
 * To generate Seller_achievements, run GenerateSA in test -> data
 */
@SpringBootApplication(scanBasePackages = { "kzhang.demo.w22.Sales_pipeline" })
@EnableAutoConfiguration
public class Sales_pipelineApplication {

    @Autowired
    private static GenerateSA gsa;

    /**
     * Main method
     * 
     * @param args
     *             Command-line args
     */
    public static void main(final String[] args) {
        SpringApplication.run(Sales_pipelineApplication.class, args);
        gsa.generateSellerAchievement();
        System.exit(0);
    }

}
