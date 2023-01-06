package kzhang.demo.w22.Sales_pipeline.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.*;

import kzhang.demo.w22.Sales_pipeline.models.Seller_achievement;

public class csvHelper {

    public static ByteArrayInputStream tutorialsToCSV(List<Seller_achievement> sellerAchievements) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Seller_achievement sellerAchievement : sellerAchievements) {
                List<String> data = Arrays.asList(
                        String.valueOf(sellerAchievement.getSELLER_ACHIEVEMENT_ID()),
                        String.valueOf(sellerAchievement.getSELLER_ID()),
                        String.valueOf(sellerAchievement.getTRANSACTION_ID()),
                        String.valueOf(sellerAchievement.getACHIEVEMENT()));

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}