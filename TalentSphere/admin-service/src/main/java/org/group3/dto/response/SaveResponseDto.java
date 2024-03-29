package org.group3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveResponseDto {
    private Long id;
    private Long authid;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
