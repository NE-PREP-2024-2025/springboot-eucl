package com.example.electricity_management_system.controller;

import com.example.electricity_management_system.dto.PurchasedTokenRegistrationDto;
import com.example.electricity_management_system.dto.SuccessResponse;
import com.example.electricity_management_system.model.PurchasedTokenModel;
import com.example.electricity_management_system.service.PurchasedTokenServices;
import com.example.electricity_management_system.service.UserServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tokens")
@Tag(name="Token")
public class PurchasedTokenController {
    private final PurchasedTokenServices purchasedTokenServices;
    private final UserServices userServices;

    public PurchasedTokenController(PurchasedTokenServices purchasedTokenServices, UserServices userServices) {
        this.purchasedTokenServices = purchasedTokenServices;
        this.userServices = userServices;
    }
    @PostMapping("/purchase")
   public ResponseEntity<SuccessResponse<PurchasedTokenModel>> purchaseToken(@RequestBody PurchasedTokenRegistrationDto tokenInfo) throws BadRequestException {
        PurchasedTokenModel token=purchasedTokenServices.createToken(tokenInfo);
        return ResponseEntity.ok().body(new SuccessResponse<>("Token Purchased Successfully",token));
   }
   @GetMapping("{meterNumber}")
    public ResponseEntity<SuccessResponse<List<PurchasedTokenModel>>> getTokenByMeterNumber(@Valid @PathVariable Long meterNumber) throws BadRequestException {
        return ResponseEntity.ok().body(new SuccessResponse<List<PurchasedTokenModel>>("Token retrieved successfully",purchasedTokenServices.getTokenByMeterNumber(meterNumber)));
   }
}
