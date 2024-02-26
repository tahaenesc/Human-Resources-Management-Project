package org.group3.mapper;

import javax.annotation.processing.Generated;
import org.group3.dto.request.PersonelSaveManagerRequestDto;
import org.group3.dto.request.PersonelSaveRequestDto;
import org.group3.dto.request.PersonelUpdateRequestDto;
import org.group3.dto.request.RegisterRequestDto;
import org.group3.dto.response.PersonelResponseDto;
import org.group3.repository.entity.Personel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T23:14:05+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19 (Oracle Corporation)"
)
@Component
public class IPersonelMapperImpl implements IPersonelMapper {

    @Override
    public Personel saveRequestDtoToPersonel(PersonelSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Personel.PersonelBuilder personel = Personel.builder();

        personel.shiftId( dto.getShiftId() );
        personel.companyId( dto.getCompanyId() );
        personel.managerId( dto.getManagerId() );
        personel.name( dto.getName() );
        personel.surname( dto.getSurname() );
        personel.email( dto.getEmail() );
        personel.phone( dto.getPhone() );
        personel.title( dto.getTitle() );
        personel.photo( dto.getPhoto() );
        personel.salary( dto.getSalary() );

        return personel.build();
    }

    @Override
    public Personel saveManagerRequestDtoToPersonel(PersonelSaveManagerRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Personel.PersonelBuilder personel = Personel.builder();

        personel.shiftId( dto.getShiftId() );
        personel.companyId( dto.getCompanyId() );
        personel.authId( dto.getAuthId() );
        personel.name( dto.getName() );
        personel.surname( dto.getSurname() );
        personel.email( dto.getEmail() );
        personel.phone( dto.getPhone() );
        personel.title( dto.getTitle() );
        personel.photo( dto.getPhoto() );
        personel.salary( dto.getSalary() );

        return personel.build();
    }

    @Override
    public PersonelResponseDto personelToResponseDto(Personel personel) {
        if ( personel == null ) {
            return null;
        }

        PersonelResponseDto.PersonelResponseDtoBuilder personelResponseDto = PersonelResponseDto.builder();

        personelResponseDto.id( personel.getId() );
        personelResponseDto.companyId( personel.getCompanyId() );
        personelResponseDto.authId( personel.getAuthId() );
        personelResponseDto.name( personel.getName() );
        personelResponseDto.surname( personel.getSurname() );
        personelResponseDto.email( personel.getEmail() );
        personelResponseDto.phone( personel.getPhone() );
        personelResponseDto.title( personel.getTitle() );
        personelResponseDto.photo( personel.getPhoto() );
        personelResponseDto.salary( personel.getSalary() );
        personelResponseDto.createdDate( personel.getCreatedDate() );
        personelResponseDto.updatedDate( personel.getUpdatedDate() );

        return personelResponseDto.build();
    }

    @Override
    public RegisterRequestDto personalToRegisterRequestDto(Personel personel) {
        if ( personel == null ) {
            return null;
        }

        RegisterRequestDto.RegisterRequestDtoBuilder registerRequestDto = RegisterRequestDto.builder();

        registerRequestDto.email( personel.getEmail() );
        registerRequestDto.name( personel.getName() );
        registerRequestDto.surname( personel.getSurname() );
        registerRequestDto.title( personel.getTitle() );
        registerRequestDto.phone( personel.getPhone() );

        return registerRequestDto.build();
    }

    @Override
    public void updatePersonelFromDto(PersonelUpdateRequestDto dto, Personel existingPersonel) {
        if ( dto == null ) {
            return;
        }

        existingPersonel.setId( dto.getId() );
        existingPersonel.setName( dto.getName() );
        existingPersonel.setSurname( dto.getSurname() );
        existingPersonel.setEmail( dto.getEmail() );
        existingPersonel.setPhone( dto.getPhone() );
        existingPersonel.setTitle( dto.getTitle() );
        existingPersonel.setPhoto( dto.getPhoto() );
        existingPersonel.setSalary( dto.getSalary() );
    }
}
