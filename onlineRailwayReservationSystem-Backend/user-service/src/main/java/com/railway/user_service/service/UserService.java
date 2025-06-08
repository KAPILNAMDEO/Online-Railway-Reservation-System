package com.railway.user_service.service;

import com.railway.user_service.dto.ReservationDTO;
import com.railway.user_service.dto.UserDTO;
import com.railway.user_service.feign.ReservationServiceClient;
import com.railway.user_service.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ReservationServiceClient reservationServiceClient;
    private final JwtUtil jwtUtil;

    public UserService(ReservationServiceClient reservationServiceClient, JwtUtil jwtUtil) {
        this.reservationServiceClient = reservationServiceClient;
        this.jwtUtil = jwtUtil;
    }




    // Registration logic
    public String register(UserDTO userDTO) {
        // Implement registration logic here
        return "User registered successfully";
    }

    // Login logic
    public String login(UserDTO userDTO) {
        // Dummy authentication logic
        if ("admin".equals(userDTO.getUsername()) && "password".equals(userDTO.getPassword())) {
            return jwtUtil.generateToken(userDTO.getUsername());
        }
        throw new RuntimeException("Invalid username or password");
    }


    // Preview booking
    public ReservationDTO previewBooking(String username, String trainNumber, int passengers) {
        return reservationServiceClient.previewBooking(username, trainNumber, passengers);
    }

    // Confirm booking
    public ReservationDTO confirmBooking(ReservationDTO dto) {
        return reservationServiceClient.confirmBooking(dto);
    }

    // Cancel booking
    public String cancelBooking(Long id) {
        return reservationServiceClient.cancelBooking(id);
    }
}
