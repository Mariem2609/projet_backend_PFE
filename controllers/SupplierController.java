package controllers;


import entities.Supplier;
import services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        Optional<Supplier> supplier = supplierService.getSupplierById(id);
        return supplier.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierService.saveSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplierDetails) {
        Optional<Supplier> supplierOpt = supplierService.getSupplierById(id);
        if (supplierOpt.isPresent()) {
            Supplier supplier = supplierOpt.get();
            supplier.setNom(supplierDetails.getNom());
            supplier.setContact(supplierDetails.getContact());
            supplier.setTelephone(supplierDetails.getTelephone());
            supplier.setEmail(supplierDetails.getEmail());
            supplier.setAdresse(supplierDetails.getAdresse());
            Supplier updatedSupplier = supplierService.saveSupplier(supplier);
            return ResponseEntity.ok(updatedSupplier);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        if (supplierService.getSupplierById(id).isPresent()) {
            supplierService.deleteSupplier(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Supplier>> searchSuppliers(@RequestParam String keyword) {
        List<Supplier> suppliers = supplierService.searchSuppliers(keyword);
        return ResponseEntity.ok(suppliers);
    }
}

