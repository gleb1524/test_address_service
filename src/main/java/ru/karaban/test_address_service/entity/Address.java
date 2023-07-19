package ru.karaban.test_address_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "AS_ADDR_OBJ")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "object_id")
    private Long objectId;

    @Column(name = "name")
    private String name;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_active")
    private Long isActive;

    @Column(name = "is_actual")
    private Long isActual;
}
