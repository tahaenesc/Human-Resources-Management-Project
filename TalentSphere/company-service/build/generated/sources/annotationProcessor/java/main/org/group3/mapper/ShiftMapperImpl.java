package org.group3.mapper;

import java.time.LocalTime;
import javax.annotation.processing.Generated;
import org.group3.dto.request.ShiftSaveRequestDto;
import org.group3.dto.response.ShiftResponseDto;
import org.group3.entity.Shift;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-23T02:52:32+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19 (Oracle Corporation)"
)
@Component
public class ShiftMapperImpl implements ShiftMapper {

    @Override
    public Shift saveRequestDtoToShift(ShiftSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Shift.ShiftBuilder shift = Shift.builder();

        shift.name( dto.getName() );
        if ( dto.getStartTime() != null ) {
            shift.startTime( LocalTime.parse( dto.getStartTime() ) );
        }
        if ( dto.getEndTime() != null ) {
            shift.endTime( LocalTime.parse( dto.getEndTime() ) );
        }

        return shift.build();
    }

    @Override
    public ShiftResponseDto shiftToResponseDto(Shift shift) {
        if ( shift == null ) {
            return null;
        }

        ShiftResponseDto.ShiftResponseDtoBuilder shiftResponseDto = ShiftResponseDto.builder();

        shiftResponseDto.name( shift.getName() );
        shiftResponseDto.startTime( shift.getStartTime() );
        shiftResponseDto.endTime( shift.getEndTime() );

        return shiftResponseDto.build();
    }
}
