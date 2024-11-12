package com.persnal.persnal_backend.borad.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.persnal.persnal_backend.borad.domain.Brewery.BreweryDTO;
import com.persnal.persnal_backend.borad.service.BreweryService;

import java.util.List;

@RestController
public class BreweryController {
    @Autowired
    private BreweryService breweryService;

    @GetMapping("/brewery")
    public List<BreweryDTO> getBreweryInfo(@RequestParam int page, @RequestParam int perPage) {
        return breweryService.getRegionData("");
    }
}