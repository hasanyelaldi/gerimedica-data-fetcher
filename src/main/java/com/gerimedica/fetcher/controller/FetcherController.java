package com.gerimedica.fetcher.controller;

import com.gerimedica.fetcher.api.Response;
import com.gerimedica.fetcher.common.ExcelHelper;
import com.gerimedica.fetcher.model.Record;
import com.gerimedica.fetcher.service.FetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class FetcherController {
    @Autowired
    FetcherService service;

    @PostMapping("/upload")
    public ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        try {
            service.save(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
        }

    }

    @GetMapping("/records")
    public ResponseEntity<List<Record>> getAllRecords() {
        try {
            List<Record> tutorials = service.getAllRecords();

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public void deleteAllData() {
        service.deleteAllData();
    }
}
