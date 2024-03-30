package com.challenge2.Controller;
import com.challenge2.Entity.Clients;
import com.challenge2.Entity.Sale;
import com.challenge2.Services.clientService;
import com.challenge2.Services.saleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private saleService service;

    @PostMapping("/creatSale")
    public ResponseEntity<?> creatSale(@RequestBody Sale sale)
    {
        service.createSale(sale);
        return ResponseEntity.ok("Created ");
    }
    @GetMapping("/allSale")
    public ResponseEntity<?> FindallSale()
    {
        return ResponseEntity.ok(service.getAllSales() + "This All Sale");

    }
    @GetMapping("/Sale/{id}")
    public ResponseEntity<?> findSaleById(@PathVariable ("id") int id)
    {
        return ResponseEntity.ok("the Sale is : "+service.getSalesById(id) );
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateSale(@PathVariable ("id")int id, @RequestBody Sale sale)
    {
        service.updateSale(id , sale);
        return ResponseEntity.ok("Updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")int id)
    {
        service.deleteSale(id);
        return ResponseEntity.ok("Deleted");
    }
}
