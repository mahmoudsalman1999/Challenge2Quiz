package com.challenge2.Controller;
import com.challenge2.Entity.Clients;
import com.challenge2.Services.clientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cli")
public class clientController {
    @Autowired
    private clientService service;

    @PostMapping("/creatCli")
    public ResponseEntity<?> creatCli(@RequestBody Clients clients)
    {
        service.createClient(clients);
        return ResponseEntity.ok("Created ");
    }
    @GetMapping("/allCli")
    public ResponseEntity<?> FindallCli()
    {
        return ResponseEntity.ok(service.getAllClients() + "This All clients");

    }
    @GetMapping("/Cli/{id}")
    public ResponseEntity<?> findCliById(@PathVariable ("id") int id)
    {
        return ResponseEntity.ok("the client is : "+service.getClientById(id) );
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCli(@PathVariable ("id")int id, @RequestBody Clients clients)
    {
        service.updateClient(id , clients);
        return ResponseEntity.ok("Updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")int id)
    {
        service.deleteClient(id);
        return ResponseEntity.ok("Deleted");
    }
}
