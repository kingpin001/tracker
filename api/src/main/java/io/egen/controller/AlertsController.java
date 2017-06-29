package io.egen.controller;


import io.egen.Service.AlertService;

import io.egen.entity.Alerts;
import io.egen.entity.Readings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Component
@RestController
@RequestMapping(value="Alerts")

public class AlertsController {

    @Autowired
    private AlertService AService;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> findAll() {
        return AService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> findOne(@PathVariable("vin") String vin) {

        return AService.findByVin(vin);
    }
//

}
