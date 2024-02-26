package org.group3.mapper;

import java.time.LocalTime;
import javax.annotation.processing.Generated;
import org.group3.dto.request.BreakSaveRequestDto;
import org.group3.dto.response.BreakResponseDto;
import org.group3.entity.Break;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-23T02:52:32+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19 (Oracle Corporation)"
)
@Component
public class BreakMapperImpl implements BreakMapper {

    @Override
    public Break saveRequestDtoToBreak(BreakSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Break.BreakBuilder break1 = Break.builder();

        break1.name( dto.getName() );
        if ( dto.getStartTime() != null ) {
            break1.startTime( LocalTime.parse( dto.getStartTime() ) );
        }
        if ( dto.getEndTime() != null ) {
            break1.endTime( LocalTime.parse( dto.getEndTime() ) );
        }

        return break1.build();
    }

    @Override
    public BreakResponseDto breakToResponseDto(Break breakEntity) {
        if ( breakEntity == null ) {
            return null;
        }

        BreakResponseDto.BreakResponseDtoBuilder breakResponseDto = BreakResponseDto.builder();

        breakResponseDto.name( breakEntity.getName() );
        breakResponseDto.startTime( breakEntity.getStartTime() );
        breakResponseDto.endTime( breakEntity.getEndTime() );

        return breakResponseDto.build();
    }
}
