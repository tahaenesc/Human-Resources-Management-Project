package org.group3.service;

import org.group3.dto.request.PhoneRequestDto;
import org.group3.dto.response.PhoneResponseDto;
import org.group3.dto.response.ShiftResponseDto;
import org.group3.entity.Communication;
import org.group3.entity.enums.EStatus;
import org.group3.exception.CompanyServiceException;
import org.group3.exception.ErrorType;
import org.group3.mapper.CommunicationMapper;
import org.group3.repository.CommunicationRepository;
import org.group3.utility.ServiceUtility;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommunicationService {

    private final CommunicationRepository repository;

    private final ServiceUtility serviceUtility;

    private final CompanyService companyService;

    public CommunicationService(CommunicationRepository repository, ServiceUtility serviceUtility, CompanyService companyService) {
        this.repository = repository;
        this.serviceUtility = serviceUtility;
        this.companyService = companyService;
    }

    public PhoneResponseDto save(PhoneRequestDto dto) {
        //mapper yerine builder
        Communication communication = repository.save(Communication.builder()
                        .company(companyService.findById(dto.getCompanyId()))
                        .name(dto.getName())
                        .phoneNumber(dto.getPhoneNumber())
                .build());
        //companyService.addCommunication(communication.getCompanyId(), communication.getId());
        return CommunicationMapper.INSTANCE.communicationToResponseDto(communication);
    }

    public PhoneResponseDto findById(Long id) {
        Optional<Communication> optionalCommunication = repository.findById(id);
        if (optionalCommunication.isPresent()) {
            if (optionalCommunication.get().getStatus() == EStatus.DELETED)
                throw new CompanyServiceException(ErrorType.COMMUNICATION_NOT_ACTIVE);
            return CommunicationMapper.INSTANCE.communicationToResponseDto(optionalCommunication.get());
        }
        throw new CompanyServiceException(ErrorType.COMMUNICATION_NOT_FOUND);
    }

    public List<PhoneResponseDto> findAllByCompanyId(Long companyId) {
        return repository.findAllByCompanyId(companyId).stream()
                .filter(communication -> communication.getStatus() == EStatus.ACTIVE)
                .map(CommunicationMapper.INSTANCE::communicationToResponseDto)
                .collect(Collectors.toList());
    }

    public Boolean deleteById(Long id) {
        return serviceUtility.softDelete(id, repository);
    }

    public PhoneResponseDto update(PhoneRequestDto dto) {
        Optional<Communication> optionalExistingPhone = repository.findById(dto.getId());
        if ((optionalExistingPhone.isPresent())) {
            if (optionalExistingPhone.get().getStatus() == EStatus.DELETED)
                throw new CompanyServiceException(ErrorType.COMMUNICATION_NOT_ACTIVE);
            Communication existingCommunication = optionalExistingPhone.get();
            if (dto.getName() != null) {
                existingCommunication.setName(dto.getName());
            }
            if (dto.getPhoneNumber() != null) {
                existingCommunication.setPhoneNumber(dto.getPhoneNumber());
            }
            return CommunicationMapper.INSTANCE.communicationToResponseDto(repository.save(existingCommunication));
        }
        throw new CompanyServiceException(ErrorType.COMMUNICATION_NOT_FOUND);
    }

    public List<PhoneResponseDto> findAllDto() {
        return repository.findAll().stream().map(CommunicationMapper.INSTANCE::communicationToResponseDto).collect(Collectors.toList());

    }
}
