package ru.karaban.test_address_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "AS_ADM_HIERARCHY")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hierarchy {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "object_id")
    private Long objectAddress;

    @Column(name = "parent_obj_id")
    private Long parentObjectAddress;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_active")
    private Long isActive;
}
