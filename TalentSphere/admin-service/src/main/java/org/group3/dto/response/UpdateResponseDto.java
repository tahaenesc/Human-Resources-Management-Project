package org.group3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String photo;
    private Long createdDate;
    private Long updatedDate;
}
