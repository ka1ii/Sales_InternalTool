package kzhang.demo.w22.Sales_pipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.*;

import java.io.*;
import java.util.*;

import kzhang.demo.w22.Sales_pipeline.data.GenerateSA;
import kzhang.demo.w22.Sales_pipeline.services.csvServices;
import kzhang.demo.w22.Sales_pipeline.models.*;

@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class APITransactionController extends APIController {

    @Autowired
    private GenerateSA gsa;

    @Autowired
    private csvServices services;

    @PostMapping(BASE_PATH + "/transactions")
    @ResponseBody
    public ResponseEntity handleTransactionsUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                InputStreamReader streamReader = new InputStreamReader(file.getInputStream());
                CsvToBean<Transaction> csvToBean = new CsvToBeanBuilder<Transaction>(streamReader)
                        .withType(Transaction.class)
                        .build();
                List<Transaction> transactions = csvToBean.parse();

                // Print the objects
                for (Transaction transaction : transactions) {
                    gsa.generateSellerAchievement(transaction);
                }
                return new ResponseEntity<String>(successResponse(String.valueOf("success")), HttpStatus.OK);
            } catch (IOException e) {
                return new ResponseEntity(errorResponse("error creating transactions"), HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity(errorResponse("empty file"), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(BASE_PATH + "/SellerAchievements")
    @ResponseBody
    public ResponseEntity getFile() {
        String filename = "seller_achievement.csv";
        InputStreamResource file = new InputStreamResource(services.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }
}
