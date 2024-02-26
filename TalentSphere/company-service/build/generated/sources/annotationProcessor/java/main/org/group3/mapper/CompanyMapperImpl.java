package org.group3.mapper;

import javax.annotation.processing.Generated;
import org.group3.dto.request.CompanySaveRequestDto;
import org.group3.dto.response.CompanyFindAllInfoResponseDto;
import org.group3.dto.response.CompanyFindAllWithoutManagerResponseDto;
import org.group3.entity.Company;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-23T02:52:32+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public Company saveRequestDtoToCompany(CompanySaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.name( dto.getName() );
        company.address( dto.getAddress() );

        return company.build();
    }

    @Override
    public CompanyFindAllWithoutManagerResponseDto companyToCompanyFindAllWithoutManagerResponseDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyFindAllWithoutManagerResponseDto.CompanyFindAllWithoutManagerResponseDtoBuilder companyFindAllWithoutManagerResponseDto = CompanyFindAllWithoutManagerResponseDto.builder();

        companyFindAllWithoutManagerResponseDto.id( company.getId() );
        companyFindAllWithoutManagerResponseDto.name( company.getName() );

        return companyFindAllWithoutManagerResponseDto.build();
    }

    @Override
    public CompanyFindAllInfoResponseDto companyToCompanyFindAllInfoResponseDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyFindAllInfoResponseDto.CompanyFindAllInfoResponseDtoBuilder companyFindAllInfoResponseDto = CompanyFindAllInfoResponseDto.builder();

        companyFindAllInfoResponseDto.id( company.getId() );

        return companyFindAllInfoResponseDto.build();
    }
}
