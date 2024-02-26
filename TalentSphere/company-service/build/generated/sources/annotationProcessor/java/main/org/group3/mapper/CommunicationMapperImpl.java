package org.group3.mapper;

import javax.annotation.processing.Generated;
import org.group3.dto.request.PhoneRequestDto;
import org.group3.dto.response.PhoneResponseDto;
import org.group3.entity.Communication;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-23T02:52:32+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19 (Oracle Corporation)"
)
@Component
public class CommunicationMapperImpl implements CommunicationMapper {

    @Override
    public Communication saveRequestDtoToCommunication(PhoneRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Communication.CommunicationBuilder communication = Communication.builder();

        communication.id( dto.getId() );
        communication.name( dto.getName() );
        communication.phoneNumber( dto.getPhoneNumber() );

        return communication.build();
    }

    @Override
    public PhoneResponseDto communicationToResponseDto(Communication communication) {
        if ( communication == null ) {
            return null;
        }

        PhoneResponseDto.PhoneResponseDtoBuilder phoneResponseDto = PhoneResponseDto.builder();

        phoneResponseDto.name( communication.getName() );
        phoneResponseDto.phoneNumber( communication.getPhoneNumber() );

        return phoneResponseDto.build();
    }
}
