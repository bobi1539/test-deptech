package com.deptech.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse {
    private Long id;
    private AdminResponse admin;
    private LocalDateTime loginTime;
}
