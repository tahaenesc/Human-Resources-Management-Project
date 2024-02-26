package org.group3.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShiftSaveRequestDto {

    Long companyId;

    String name;

    String  startTime;

    String  endTime;
}
