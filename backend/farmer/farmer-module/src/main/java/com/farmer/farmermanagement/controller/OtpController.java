package com.farmer.farmermanagement.controller;
 
import com.farmer.farmermanagement.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
public class OtpController {
 
    private final OtpService otpService;
 
    // Generate and send OTP to the phone number
    @PostMapping("/generate")
    public ResponseEntity<String> generateOtp(@RequestParam String phoneNumber) {
        String otp = otpService.generateAndSendOtp(phoneNumber);
        return ResponseEntity.ok("OTP sent successfully to " + phoneNumber);
    }
 
    // Verify the OTP entered by the user
    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String phoneNumber,
                                            @RequestParam String otp) {
        boolean isValid = otpService.verifyOtpCode(phoneNumber, otp);
        if (isValid) {
            return ResponseEntity.ok("OTP verified successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid OTP");
        }
    }
}