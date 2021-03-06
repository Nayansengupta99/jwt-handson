package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController()
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private CountryService service;

	@SuppressWarnings("resource")
	@RequestMapping("/country")
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		return (Country) context.getBean("country", Country.class);
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		return service.getAllCountries();
	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		return service.getCountry(code);
	}

	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		return service.addCountry(country);
	}

}