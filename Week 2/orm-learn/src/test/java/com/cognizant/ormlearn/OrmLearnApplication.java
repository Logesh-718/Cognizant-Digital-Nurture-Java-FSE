package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);

		testGetAllCountries();

		testAddCountry();

		testQueryMethod();

		testHQL();

		testNativeQuery();
	}

	private static void testGetAllCountries() {

		LOGGER.info("========== Get All Countries ==========");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.info("Countries : {}", countries);
	}

	private static void testAddCountry() {

		LOGGER.info("========== Add Country ==========");

		Country country = new Country();

		// Change this code if it already exists in your database
		country.setCode("FR");
		country.setName("France");

		countryService.addCountry(country);

		Country c = countryService.findCountryByCode("FR");

		LOGGER.info("Added Country : {}", c);
	}

	private static void testQueryMethod() {

		LOGGER.info("========== Query Method ==========");

		Country country = countryService.findCountryByCode("IN");

		LOGGER.info("Country : {}", country);
	}

	private static void testHQL() {

		LOGGER.info("========== HQL ==========");

		List<Country> countries = countryService.getAllCountriesHQL();

		LOGGER.info("Countries : {}", countries);
	}

	private static void testNativeQuery() {

		LOGGER.info("========== Native Query ==========");

		List<Country> countries = countryService.getAllCountriesNative();

		LOGGER.info("Countries : {}", countries);
	}
}