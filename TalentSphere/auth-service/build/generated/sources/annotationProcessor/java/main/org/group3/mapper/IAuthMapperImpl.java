package org.group3.mapper;

import javax.annotation.processing.Generated;
import org.group3.dto.request.RegisterRequestDto;
import org.group3.dto.response.FindAllResponseDto;
import org.group3.dto.response.FindByIdRespoonseDto;
import org.group3.dto.response.RegisterResponseDto;
import org.group3.entity.Auth;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T12:24:34+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19 (Oracle Corporation)"
)
@Component
public class IAuthMapperImpl implements IAuthMapper {

    @Override
    public Auth registerRequestDtotoAuth(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Auth.AuthBuilder auth = Auth.builder();

        auth.username( dto.getUsername() );
        auth.password( dto.getPassword() );
        auth.email( dto.getEmail() );
        auth.role( dto.getRole() );

        return auth.build();
    }

    @Override
    public RegisterResponseDto authToRegisterResponseDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        RegisterResponseDto.RegisterResponseDtoBuilder registerResponseDto = RegisterResponseDto.builder();

        registerResponseDto.id( auth.getId() );
        registerResponseDto.username( auth.getUsername() );
        registerResponseDto.email( auth.getEmail() );
        registerResponseDto.activationCode( auth.getActivationCode() );
        registerResponseDto.status( auth.getStatus() );

        return registerResponseDto.build();
    }

    @Override
    public FindAllResponseDto authToFindAllResponseDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        FindAllResponseDto.FindAllResponseDtoBuilder findAllResponseDto = FindAllResponseDto.builder();

        findAllResponseDto.id( auth.getId() );
        findAllResponseDto.username( auth.getUsername() );
        findAllResponseDto.email( auth.getEmail() );
        findAllResponseDto.activationCode( auth.getActivationCode() );
        findAllResponseDto.role( auth.getRole() );

        return findAllResponseDto.build();
    }

    @Override
    public FindByIdRespoonseDto authToFindByIdResponseDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        FindByIdRespoonseDto.FindByIdRespoonseDtoBuilder findByIdRespoonseDto = FindByIdRespoonseDto.builder();

        findByIdRespoonseDto.id( auth.getId() );
        findByIdRespoonseDto.username( auth.getUsername() );
        findByIdRespoonseDto.email( auth.getEmail() );
        findByIdRespoonseDto.activationCode( auth.getActivationCode() );
        findByIdRespoonseDto.role( auth.getRole() );

        return findByIdRespoonseDto.build();
    }
}
