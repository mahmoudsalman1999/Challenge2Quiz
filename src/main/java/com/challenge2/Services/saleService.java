package com.challenge2.Services;

import com.challenge2.Entity.Clients;
import com.challenge2.Entity.Sale;
import com.challenge2.Repository.clientRepository;
import com.challenge2.Repository.saleRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class saleService {
    @Autowired
    private saleRepository repository ;

    public List<Sale> getAllSales() {
        return repository.findAll();
    }

    public Sale getSalesById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found with id: " + id));
    }

    public Sale createSale(Sale sale) {
        return repository.save(sale);
    }

    public Sale updateSale(int id, Sale sale) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Sale not found with id: " + id);
        }
        sale.setId(id);
        return repository.save(sale);
    }

    public void deleteSale(int id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Sale not found with id: " + id);
        }
        repository.deleteById(id);
    }
    public static byte[] generateSalesReport(LocalDate startDate, LocalDate endDate) {
        // Retrieve sales records within the specified date range
        saleRepository saleRepository = null;
        List<Sale> sales = saleRepository.findByDateBetween(startDate, endDate);

        // Process data and generate report using a reporting library (e.g., Apache POI, JasperReports, etc.)

        // Dummy implementation for demo
        String reportContent = "Sample sales report content for " + startDate + " to " + endDate;
        return reportContent.getBytes();
    }
}
