//package com.farmer.farmermanagement.controller;
//
//import com.farmer.farmermanagement.dto.BankDetailsDto;
//import com.farmer.farmermanagement.service.BankDetailsService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/bank-details")
//@RequiredArgsConstructor
//public class BankDetailsController {
//
//    private final BankDetailsService bankDetailsService;
//
//    @PostMapping
//    public ResponseEntity<BankDetailsDto> addOrUpdateBankDetails(@Valid @RequestBody BankDetailsDto bankDetailsDTO) {
//        return ResponseEntity.ok(bankDetailsService.addOrUpdateBankDetails(bankDetailsDTO));
//    }
//
//    @GetMapping("/farmer/{farmerId}")
//    public ResponseEntity<BankDetailsDto> getBankDetailsByFarmerId(@PathVariable Long farmerId) {
//        return ResponseEntity.ok(bankDetailsService.getBankDetailsByFarmerId(farmerId));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBankDetails(@PathVariable Long id) {
//        bankDetailsService.deleteBankDetails(id);
//        return ResponseEntity.noContent().build();
//    }
//}
