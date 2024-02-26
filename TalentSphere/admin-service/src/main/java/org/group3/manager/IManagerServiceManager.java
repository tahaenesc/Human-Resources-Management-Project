package org.group3.manager;

import org.group3.dto.response.ManagerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

import static org.group3.constant.EndPoints.FIND_ALL;

@FeignClient(name = "manager-service-manager", url = "http://localhost:9094/manager")
public interface IManagerServiceManager {

    @GetMapping(FIND_ALL)
    ResponseEntity<List<ManagerResponseDto>> findAll();
}
