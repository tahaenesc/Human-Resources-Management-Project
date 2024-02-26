package org.group3.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.group3.dto.request.HolidayRequestDto;
import org.group3.dto.request.HolidaySaveByPersonalRequestDto;
import org.group3.dto.response.HolidayResponseDto;
import org.group3.dto.response.HolidayfFindAllByCompanyIdAndStatusPendingResponseDto;
import org.group3.entity.Holiday;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-23T01:22:14+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19 (Oracle Corporation)"
)
@Component
public class HolidayMapperImpl implements HolidayMapper {

    @Override
    public Holiday saveRequestDtoToHoliday(HolidayRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Holiday.HolidayBuilder holiday = Holiday.builder();

        holiday.companyId( dto.getCompanyId() );
        holiday.name( dto.getName() );
        holiday.startDate( dto.getStartDate() );
        holiday.endDate( dto.getEndDate() );
        holiday.description( dto.getDescription() );
        List<Long> list = dto.getPersonals();
        if ( list != null ) {
            holiday.personals( new ArrayList<Long>( list ) );
        }

        return holiday.build();
    }

    @Override
    public HolidayResponseDto holidayToResponseDto(Holiday holiday) {
        if ( holiday == null ) {
            return null;
        }

        HolidayResponseDto.HolidayResponseDtoBuilder holidayResponseDto = HolidayResponseDto.builder();

        holidayResponseDto.companyId( holiday.getCompanyId() );
        holidayResponseDto.name( holiday.getName() );
        holidayResponseDto.startDate( holiday.getStartDate() );
        holidayResponseDto.endDate( holiday.getEndDate() );
        holidayResponseDto.description( holiday.getDescription() );
        List<Long> list = holiday.getPersonals();
        if ( list != null ) {
            holidayResponseDto.personals( new ArrayList<Long>( list ) );
        }
        holidayResponseDto.status( holiday.getStatus() );

        return holidayResponseDto.build();
    }

    @Override
    public HolidayfFindAllByCompanyIdAndStatusPendingResponseDto holidayToHolidayfFindAllByCompanyIdAndStatusPendingResponseDto(Holiday holiday) {
        if ( holiday == null ) {
            return null;
        }

        HolidayfFindAllByCompanyIdAndStatusPendingResponseDto.HolidayfFindAllByCompanyIdAndStatusPendingResponseDtoBuilder holidayfFindAllByCompanyIdAndStatusPendingResponseDto = HolidayfFindAllByCompanyIdAndStatusPendingResponseDto.builder();

        holidayfFindAllByCompanyIdAndStatusPendingResponseDto.id( holiday.getId() );
        holidayfFindAllByCompanyIdAndStatusPendingResponseDto.name( holiday.getName() );
        holidayfFindAllByCompanyIdAndStatusPendingResponseDto.startDate( holiday.getStartDate() );
        holidayfFindAllByCompanyIdAndStatusPendingResponseDto.endDate( holiday.getEndDate() );
        holidayfFindAllByCompanyIdAndStatusPendingResponseDto.description( holiday.getDescription() );

        return holidayfFindAllByCompanyIdAndStatusPendingResponseDto.build();
    }

    @Override
    public Holiday holidaySaveByPersonalRequestDtoToHoliday(HolidaySaveByPersonalRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Holiday.HolidayBuilder holiday = Holiday.builder();

        holiday.companyId( dto.getCompanyId() );
        holiday.name( dto.getName() );
        holiday.startDate( dto.getStartDate() );
        holiday.endDate( dto.getEndDate() );
        holiday.description( dto.getDescription() );

        return holiday.build();
    }
}
