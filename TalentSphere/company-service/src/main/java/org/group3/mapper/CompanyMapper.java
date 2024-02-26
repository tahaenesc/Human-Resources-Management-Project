package org.group3.mapper;

import org.group3.dto.request.CompanySaveRequestDto;
import org.group3.dto.response.CompanyFindAllInfoResponseDto;
import org.group3.dto.response.CompanyFindAllWithoutManagerResponseDto;
import org.group3.dto.response.CompanyFindByNameResponseDto;
import org.group3.dto.response.CompanyResponseDto;
import org.group3.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company saveRequestDtoToCompany(CompanySaveRequestDto dto);
    //CompanyResponseDto companyToCompanyResponseDto(Company company);

    CompanyFindAllWithoutManagerResponseDto companyToCompanyFindAllWithoutManagerResponseDto(Company company);

    CompanyFindAllInfoResponseDto companyToCompanyFindAllInfoResponseDto(Company company);
}
