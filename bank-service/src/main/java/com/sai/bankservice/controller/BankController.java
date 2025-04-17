package com.sai.bankservice.controller;

import com.sai.bankservice.common.Bank;
import com.sai.bankservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/nearby")
    public List<Bank> getNearbyBanks(@RequestParam String zipcode) {
        return bankService.findNearbyBanks(zipcode);
    }
}
