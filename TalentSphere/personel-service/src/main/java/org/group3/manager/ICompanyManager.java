package org.group3.manager;


import org.group3.dto.request.Company;
import org.group3.dto.response.GetInformationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.group3.constant.EndPoints.ADD_PERSONAL;
import static org.group3.constant.EndPoints.FIND_BY_PERSONAL_ID_GET_INFO;


@FeignClient(name = "company-manager", url = "http://localhost:9097/company" )
public interface ICompanyManager {

    @GetMapping(ADD_PERSONAL)
    void addPersonal(@RequestParam Long companyId, @RequestParam Long personalId);

    @GetMapping(FIND_BY_PERSONAL_ID_GET_INFO)
    ResponseEntity<Company> findByPersonalIdGetInfo(@RequestParam Long personalId);
}
