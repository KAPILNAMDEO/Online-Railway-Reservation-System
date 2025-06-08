package com.railway.train_service.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainDTO {
    private Long id;
    private String trainName;
    private String trainNumber;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private double fare;

    // Constructors


    // Getters and Setters
}
