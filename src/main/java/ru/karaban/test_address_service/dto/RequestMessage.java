package ru.karaban.test_address_service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RequestMessage {

    private String param;
    private List<Long> objectIds;
    private LocalDate date;
}
