package ru.karaban.test_address_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.karaban.test_address_service.dto.RequestMessage;
import ru.karaban.test_address_service.service.HierarchyService;

@RestController
@RequestMapping("/hierarchy")
@RequiredArgsConstructor
public class HierarchyController {

    private final HierarchyService hierarchyService;

    @GetMapping
    public ResponseEntity<?> getAddress(RequestMessage message) {
        return ResponseEntity.ok(hierarchyService.findAllByTypeName(message.getParam()));
    }
}
