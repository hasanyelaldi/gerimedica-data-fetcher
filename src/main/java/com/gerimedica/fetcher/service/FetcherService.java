package com.gerimedica.fetcher.service;

import com.gerimedica.fetcher.common.ExcelHelper;
import com.gerimedica.fetcher.model.Record;
import com.gerimedica.fetcher.repository.FetcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FetcherService {
    @Autowired
    FetcherRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Record> records = ExcelHelper.excelToRecords(file.getInputStream());
            repository.saveAll(records);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Record> getAllRecords() {
        return repository.findAll();
    }

    public void deleteAllData() {
        repository.deleteAll();
    }
}
