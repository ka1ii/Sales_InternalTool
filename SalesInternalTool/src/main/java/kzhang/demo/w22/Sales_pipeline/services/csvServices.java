package kzhang.demo.w22.Sales_pipeline.services;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kzhang.demo.w22.Sales_pipeline.helper.csvHelper;
import kzhang.demo.w22.Sales_pipeline.models.Seller_achievement;
import kzhang.demo.w22.Sales_pipeline.repositories.Seller_achievementRepository;

@Service
public class csvServices {

    @Autowired
    Seller_achievementRepository repository;

    public ByteArrayInputStream load() {
        List<Seller_achievement> tutorials = repository.findAll();

        ByteArrayInputStream in = csvHelper.tutorialsToCSV(tutorials);
        return in;
    }
}