package ru.karaban.test_address_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.karaban.test_address_service.dto.ActualMessage;
import ru.karaban.test_address_service.service.impl.HierarchyServiceImpl;

@RestController
@RequestMapping("/hierarchy")
@RequiredArgsConstructor
public class HierarchyController {

    private final HierarchyServiceImpl hierarchyService;

    @GetMapping
    public ResponseEntity<?> getAddress(@RequestBody ActualMessage message) {
        return ResponseEntity.ok(hierarchyService.findAllByTypeName(message.getParam()));
    }
}
