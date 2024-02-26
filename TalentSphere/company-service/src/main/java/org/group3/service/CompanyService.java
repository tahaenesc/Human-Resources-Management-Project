package org.group3.service;

import org.group3.dto.request.CompanySaveRequestDto;
import org.group3.dto.request.CompanyUpdateRequestDto;
import org.group3.dto.response.*;
import org.group3.entity.Communication;
import org.group3.entity.Company;
import org.group3.entity.enums.EStatus;
import org.group3.exception.CompanyServiceException;
import org.group3.exception.ErrorType;
import org.group3.manager.ICommentManager;
import org.group3.manager.IManagerServiceManager;
import org.group3.manager.IPaymentManager;
import org.group3.mapper.CompanyMapper;
import org.group3.rabbit.model.AssignManagerModel;
import org.group3.rabbit.model.HolidayModel;
import org.group3.rabbit.model.PaymentModel;
import org.group3.rabbit.producer.ManagerProducer;
import org.group3.repository.CompanyRepository;
import org.group3.utility.ServiceUtility;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    private final ServiceUtility serviceUtility;

    private final ManagerProducer managerProducer;

    private final IManagerServiceManager managerServiceManager;

    private final IPaymentManager paymentManager;

    private final ICommentManager commentManager;

    //private final MessageSource messageSource;

    public CompanyService(CompanyRepository repository, ServiceUtility serviceUtility, ManagerProducer managerProducer, IManagerServiceManager managerServiceManager, IPaymentManager paymentManager, ICommentManager commentManager) {
        this.repository = repository;
        this.serviceUtility = serviceUtility;
        this.managerProducer = managerProducer;
        //this.messageSource = messageSource;
//        this.greet();
        this.managerServiceManager = managerServiceManager;
        this.paymentManager = paymentManager;
        this.commentManager = commentManager;
    }

//    public void greet() {
//        String greeting = messageSource.getMessage("hello", null, Locale.getDefault());
//        System.out.println(greeting); // Hello (eğer varsayılan dil İngilizce ise)
//    }

    public Boolean save(CompanySaveRequestDto dto) {
        Company company = repository.save(Company.builder()
                        .name(dto.getName())
                        .address(dto.getAddress())
                .build());
        List<Communication> communicationList = new ArrayList<>();
        communicationList.add(Communication.builder()
                        .company(company)
                        .phoneNumber(dto.getCommunicationPhone())
                        .name(dto.getCommunicationName())
                .build());
        company.setCommunications(communicationList);
        repository.save(company);
        return true;
    }



    public Company findById(Long id) {
        Optional<Company> optionalCompany = repository.findById(id);
        if (optionalCompany.isPresent()) {
            if (optionalCompany.get().getStatus() == EStatus.DELETED)
                throw new CompanyServiceException(ErrorType.COMPANY_NOT_ACTIVE);
            return optionalCompany.get();
        }
        throw new CompanyServiceException(ErrorType.COMPANY_NOT_FOUND);
    }

    public Company findByManagerId(Long managerId) {
        return repository.findByManagerId(managerId);


    }

    public Boolean deleteById(Long id) {
        return serviceUtility.softDelete(id, repository);
    }

    public Company update(CompanyUpdateRequestDto dto) {
        Company existingCompany = this.findById(dto.getId());
        if (dto.getManagerId() != null) {
            existingCompany.setManagerId(dto.getManagerId());
        }
        if (dto.getName() != null) {
            existingCompany.setName(dto.getName());
        }
        if (dto.getGallery() != null) {
            existingCompany.setGallery(dto.getGallery());
        }
        existingCompany.setUpdatedDateTime(LocalDateTime.now());
        return repository.save(existingCompany);
    }

//    public void addCommunication(Long id, Long phoneId) {
//        Company existingCompany = this.findById(id);
//        if (existingCompany.getCommunications().contains(phoneId))
//            throw new CompanyServiceException(ErrorType.COMMUNICATION_ALREADY_EXISTS);
//        existingCompany.getCommunications().add(phoneId);
//        repository.save(existingCompany);
//    }

    public void addPayment(PaymentModel model) {
        Company existingCompany = this.findById(model.getCompanyId());
        if (existingCompany.getPayments().contains(model.getPaymentId()))
            throw new CompanyServiceException(ErrorType.PAYMENT_ALREADY_EXISTS);
        existingCompany.getPayments().add(model.getPaymentId());
        repository.save(existingCompany);
    }

    public void addPersonal(Long id, Long personalId) {
        Company existingCompany = this.findById(id);
        if (existingCompany.getPersonals().contains(personalId))
            throw new CompanyServiceException(ErrorType.PERSONAL_ALREADY_EXISTS);
        existingCompany.getPersonals().add(personalId);
        repository.save(existingCompany);
    }

    public void addShift(Long id, Long shiftId) {
//        Company existingCompany = this.findById(id);
//        if (existingCompany.getShifts().contains(shiftId))
//            throw new CompanyServiceException(ErrorType.SHIFT_ALREADY_EXISTS);
//        existingCompany.getShifts().add(shiftId);
//        repository.save(existingCompany);
    }

    public void addHoliday(HolidayModel model) {
        Company existingCompany = this.findById(model.getCompanyId());
        if (existingCompany.getHolidays().contains(model.getHolidayId()))
            throw new CompanyServiceException(ErrorType.HOLIDAY_ALREADY_EXISTS);
        existingCompany.getHolidays().add(model.getHolidayId());
        repository.save(existingCompany);
    }

    public List<Company> findAll() {
        return repository.findAll();
    }


    public List<Company> findByPersonalId(Long personalId) {
        return repository.findByPersonalsContains(personalId);
    }

    public List<CompanyFindAllWithoutManagerResponseDto> findAllWithoutManager() {
        List<Company> companyList = repository.findAllByManagerIdIsNull();
        return companyList.stream()
                .map(CompanyMapper.INSTANCE::companyToCompanyFindAllWithoutManagerResponseDto)
                .collect(Collectors.toList());
    }

    public CompanyFindByNameResponseDto findByName(String name) {
        Company company=repository.findByName(name);
        CompanyFindByNameResponseDto dto = CompanyFindByNameResponseDto.builder()
                .name(company.getName())
                .address(company.getAddress())
                .gallery(company.getGallery())
                .personals(company.getPersonals())
                .managerId(company.getManagerId())
                .id(company.getId())
                .build();
        //return CompanyMapper.INSTANCE.companyToCompanyResponseDto(company);
        return dto;
    }

    public List<CompanyFindAllInfoResponseDto> findAllInfo() {
        List<Company> companyList=repository.findAll();
        return companyList.stream().map(CompanyMapper.INSTANCE::companyToCompanyFindAllInfoResponseDto)
                .collect(Collectors.toList());
    }

    public void assignManager(AssignManagerModel model) {
        Optional<Company> companyOptional = repository.findById(model.getCompanyId());
        if(companyOptional.isPresent()){
            companyOptional.get().setManagerId(model.getManagerId());
            repository.save(companyOptional.get());
        }else {
            throw new CompanyServiceException(ErrorType.COMPANY_NOT_FOUND);
        }
    }

    public String findNameByCompanyId(Long id) {
        Optional<Company> companyOptional = repository.findById(id);
        if(companyOptional.isPresent()){
            return companyOptional.get().getName();
        }else {
            throw new CompanyServiceException(ErrorType.COMPANY_NOT_FOUND);
        }
    }

    public GetInformationResponseDto findByPersonalIdGetInfo(Long personalId) {
        Optional<Company> companyOptional = repository.findByPersonalsContains(personalId).stream().findFirst();
        if(companyOptional.isPresent()){
            return GetInformationResponseDto.builder()
                    .id(companyOptional.get().getId())
                    .name(companyOptional.get().getName())
                    .address(companyOptional.get().getAddress())
                    .gallery(companyOptional.get().getGallery())
                    .personalNumber(companyOptional.get().getPersonals().size())
                    .shifts(companyOptional.get().getShifts().stream()
                            .map(shift -> ShiftGetInformationResponseDto.builder()
                                    .id(shift.getId())
                                    .name(shift.getName())
                                    .startTime(shift.getStartTime().toString())
                                    .endTime(shift.getEndTime().toString())
                                    .build()).collect(Collectors.toList()))
                    .communications(companyOptional.get().getCommunications().stream()
                            .map(communication -> CommunicationGetInformationResponseDto.builder()
                                    .name(communication.getName())
                                    .phoneNumber(communication.getPhoneNumber())
                                    .build()).collect(Collectors.toList()))
                    .build();
        }else {
            throw new CompanyServiceException(ErrorType.COMPANY_NOT_FOUND);
        }

    }

    public List<GetInformationForVisitorResponseDto> getInformationForVisitor() {

        return repository.findAll().stream().map(company ->{
            PaymentInformationForVisitorResponseDto payment = paymentManager.getInformationForVisitor(company.getId()).getBody();
            return GetInformationForVisitorResponseDto.builder()
                    .companyName(company.getName())
                    .managerName(managerServiceManager.findNameById(company.getManagerId()).getBody())
                    .address(company.getAddress())
                    .createdDate(company.getCreatedDateTime().toString())
                    .paymentNumber(payment.getPaymentNumber())
                    .turnOver(payment.getTurnOver())
                    .commentNumber(commentManager.findAll().getBody().stream()
                            .filter(comment -> Objects.equals(comment.getId(), company.getId())).toList().size())
                    .build();
        } ).collect(Collectors.toList());
    }
}
