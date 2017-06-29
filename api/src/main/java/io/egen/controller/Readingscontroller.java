package io.egen.controller;


import io.egen.Service.ReadingService;
import io.egen.Service.VehicleService;
import io.egen.entity.Readings;
import io.egen.entity.Tires;
import io.egen.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@Component
@RestController
@RequestMapping(value="Readings")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class Readingscontroller {
    @Autowired
    private ReadingService RService;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> findAll() {

        return RService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings findOne(@PathVariable("vin") String vinId) {

        return RService.findOne(vinId);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings create(@RequestBody Readings readings) {

        return RService.create(readings);
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "{vin}")
    public void delete(@PathVariable("vin") String vin) {

        RService.delete(vin);
    }
}


