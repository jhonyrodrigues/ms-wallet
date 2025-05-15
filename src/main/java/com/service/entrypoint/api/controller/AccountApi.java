package com.service.entrypoint.api.controller;

import com.service.entrypoint.api.dto.AccountCreateResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/account")
public interface AccountApi {

    @PostMapping("/create")
    ResponseEntity<AccountCreateResponseDTO> create(@RequestHeader("customer-id") String customerId);
}
