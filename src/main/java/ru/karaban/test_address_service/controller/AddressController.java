package ru.karaban.test_address_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.karaban.test_address_service.dto.RequestMessage;
import ru.karaban.test_address_service.service.AddressService;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    @GetMapping
    public ResponseEntity<?> getAllAddressByDateAndObjectId(RequestMessage message) {
        return ResponseEntity.ok(addressService.getAllAddressByDateAndObjectId(message.getObjectIds(),message.getDate()));
    }
}
