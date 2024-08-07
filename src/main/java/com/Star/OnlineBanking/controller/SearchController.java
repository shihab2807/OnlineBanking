package com.Star.OnlineBanking.controller;

import com.Star.OnlineBanking.entity.Client;
import com.Star.OnlineBanking.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    public Page<Client> searchClients(@RequestParam(required = false) LocalDate dateOfBirth,
                                      @RequestParam(required = false) String phone,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false) String email,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return searchService.searchClients(dateOfBirth, phone, name, email, page, size);
    }
}
