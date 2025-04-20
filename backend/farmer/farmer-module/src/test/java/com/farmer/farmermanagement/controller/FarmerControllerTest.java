package com.farmer.farmermanagement.controller;

import com.farmer.farmermanagement.dto.*;
import com.farmer.farmermanagement.enums.*;
import com.farmer.farmermanagement.service.FarmerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class FarmerControllerTest {

    @Mock
    private FarmerService farmerService;

    @InjectMocks
    private FarmerController farmerController;

    private FarmerDto sampleFarmer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleFarmer = createSampleFarmer();
    }

    private FarmerDto createSampleFarmer() {
        FarmerDto farmer = new FarmerDto();
        farmer.setId(1L);
        farmer.setFirstName("John");
        farmer.setMiddleName("M.");
        farmer.setLastName("Doe");
        farmer.setAadharNumber("123456789012");
        farmer.setEmail("john.doe@example.com");
        farmer.setPhoneNumber("9876543210");
        farmer.setGender(Gender.MALE);
        farmer.setEducation(Education.GRADUATE);
        farmer.setDocument(Document.AADHARNUMBER);
        farmer.setDocumentPath("/documents/aadhar/john_doe.pdf");
        farmer.setDateOfBirth(LocalDate.of(1985, 10, 15));
        farmer.setPortalAccess(PortalAccess.ACTIVE);
        farmer.setPortalRole(PortalRole.USER);
        farmer.setFarmerType("Organic");

        // Mock Address
        AddressDto address = new AddressDto();
        address.setDistrict("Sunnyvale");
        address.setState("California");
        address.setPincode("123456");
        farmer.setAddress(address);

        // Mock BankDetails
        BankDetailsDto bankDetails = new BankDetailsDto();
        bankDetails.setAccountNumber("1234567890");
        bankDetails.setBankName(BankName.SBI);
        bankDetails.setIfscCode("SBIN0001234");
        farmer.setBankDetails(bankDetails);

        // Mock LandDetails
        LandDetailsDto landDetails = new LandDetailsDto();
        landDetails.setareaInAcres(5.5);
        landDetails.setSurveyNumber("SURV001");
        landDetails.setIrrigationSource(IrrigationSource.DRIP);
        farmer.setLandDetails(landDetails);

        // Mock Crops
        CropDto crop = new CropDto();
        crop.setCropName("Wheat");
        crop.setSeason("Rabi");
        crop.setAreaInAcres(2.0);
        farmer.setCrops(Collections.singletonList(crop));

        return farmer;
    }

    @Test
    public void testCreateFarmer() {
        when(farmerService.createFarmer(any(FarmerDto.class))).thenReturn(sampleFarmer);

        ResponseEntity<FarmerDto> response = farmerController.createFarmer(sampleFarmer);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("John", response.getBody().getFirstName());
        assertEquals("Greenfield", response.getBody().getAddress().getVillage());
        assertEquals("Wheat", response.getBody().getCrops().get(0).getCropName());
    }

    @Test
    public void testUpdateFarmer() {
        when(farmerService.updateFarmer(eq(1L), any(FarmerDto.class))).thenReturn(sampleFarmer);

        ResponseEntity<FarmerDto> response = farmerController.updateFarmer(1L, sampleFarmer);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Organic", response.getBody().getFarmerType());
        assertEquals("Sample Bank", response.getBody().getBankDetails().getBankName());
    }

    @Test
    public void testGetAllFarmers() {
        when(farmerService.getAllFarmers()).thenReturn(Arrays.asList(sampleFarmer));

        ResponseEntity<List<FarmerDto>> response = farmerController.getAllFarmers();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("John", response.getBody().get(0).getFirstName());
    }

    @Test
    public void testGetFarmerById() {
        when(farmerService.getFarmerById(1L)).thenReturn(sampleFarmer);

        ResponseEntity<FarmerDto> response = farmerController.getFarmerById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("9876543210", response.getBody().getPhoneNumber());
        assertEquals("Rabi", response.getBody().getCrops().get(0).getSeason());
    }
}
