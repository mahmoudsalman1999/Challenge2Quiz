package com.challenge2.Controller;

import com.challenge2.Services.clientService;
import com.challenge2.Services.productService;
import com.challenge2.Services.saleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;

@RestController
@RequestMapping("/Reportting")
public class reportingController {

        @Autowired
        private saleService salesService;
        @Autowired
        private clientService clientService;
        @Autowired
        private productService productService;

        @GetMapping("/sales")
        public ResponseEntity<byte[]> generateSalesReport(@RequestParam("startDate") LocalDate startDate,
                                                          @RequestParam("endDate") LocalDate endDate) {
            byte[] reportBytes = salesService.generateSalesReport(startDate, endDate);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "sales_report.pdf");
            headers.setContentLength(reportBytes.length);
            return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
        }

    @GetMapping("/clients")
    public ResponseEntity<byte[]> generateClientReport() {
        byte[] reportBytes = clientService.generateClientReport();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "client_report.pdf");
        headers.setContentLength(reportBytes.length);
        return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
        }
    @GetMapping("/products")
    public ResponseEntity<byte[]> generateProductReport() {
        byte[] reportBytes = productService.generateProductReport();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "product_report.pdf");
        headers.setContentLength(reportBytes.length);
        return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
    }
    }


