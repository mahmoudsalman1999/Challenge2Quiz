package com.challenge2.Controller;

import com.challenge2.Entity.Products;
import com.challenge2.Services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/pro")
public class productController {
    @Autowired
    private productService service;

    @PostMapping("/creatPro")
    public ResponseEntity<?> creatPro(@RequestBody Products p)
    {
        service.createProduct(p);
        return ResponseEntity.ok("Created ");
    }
    @GetMapping("/allPro")
    public ResponseEntity<?> FindallPro()
    {
        return ResponseEntity.ok(service.getAllProducts() + "This All products");
    }
    @GetMapping("/Pro/{id}")
    public ResponseEntity<?> findProById(@PathVariable ("id") int id)
    {
        return ResponseEntity.ok("the product is : "+service.getProductById(id) );
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updatePro(@PathVariable ("id")int id, @RequestBody Products products)
    {
        service.updateProduct(id , products);
        return ResponseEntity.ok("Updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")int id)
    {
        service.deleteProduct(id);
        return ResponseEntity.ok("Deleted");
    }
}
