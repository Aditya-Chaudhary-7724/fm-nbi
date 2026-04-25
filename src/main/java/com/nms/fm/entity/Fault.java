package com.nms.fm.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Fault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alarmId;
    private String severity;
    private String description;
    private String status;
    private LocalDateTime timestamp;
}