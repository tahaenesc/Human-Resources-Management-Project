package org.group3.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HolidayRequestDto {

    Long companyId;

    String name;

    String startDate;

    String endDate;

    String description;

    List<Long> personals;

    String role;

}
