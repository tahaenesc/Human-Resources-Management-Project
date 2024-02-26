package org.group3.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.group3.dto.request.RegisterRequestDto;
import org.group3.dto.response.ManagerResponseDto;
import org.group3.entity.Manager;
import org.group3.rabbit.model.ManagerSaveModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T23:50:45+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19 (Oracle Corporation)"
)
@Component
public class ManagerMapperImpl implements ManagerMapper {

    @Override
    public Manager saveModelToManager(ManagerSaveModel model) {
        if ( model == null ) {
            return null;
        }

        Manager.ManagerBuilder manager = Manager.builder();

        manager.authId( model.getAuthId() );
        manager.name( model.getName() );
        manager.surname( model.getSurname() );
        manager.email( model.getEmail() );
        manager.title( model.getTitle() );
        manager.phone( model.getPhone() );

        return manager.build();
    }

    @Override
    public ManagerResponseDto ManagerToResponseDto(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        ManagerResponseDto.ManagerResponseDtoBuilder managerResponseDto = ManagerResponseDto.builder();

        managerResponseDto.id( manager.getId() );
        managerResponseDto.name( manager.getName() );
        managerResponseDto.surname( manager.getSurname() );
        managerResponseDto.email( manager.getEmail() );
        managerResponseDto.phone( manager.getPhone() );
        managerResponseDto.photo( manager.getPhoto() );
        managerResponseDto.companyId( manager.getCompanyId() );
        managerResponseDto.title( manager.getTitle() );
        List<Long> list = manager.getPersonals();
        if ( list != null ) {
            managerResponseDto.personals( new ArrayList<Long>( list ) );
        }
        managerResponseDto.updatedDateTime( manager.getUpdatedDateTime() );
        managerResponseDto.createdDateTime( manager.getCreatedDateTime() );

        return managerResponseDto.build();
    }

    @Override
    public RegisterRequestDto managerToRegisterRequestDto(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        RegisterRequestDto.RegisterRequestDtoBuilder registerRequestDto = RegisterRequestDto.builder();

        registerRequestDto.email( manager.getEmail() );
        registerRequestDto.name( manager.getName() );
        registerRequestDto.surname( manager.getSurname() );
        registerRequestDto.title( manager.getTitle() );
        registerRequestDto.phone( manager.getPhone() );

        return registerRequestDto.build();
    }
}
