package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;
	private static EmployeeService employeeService;

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);

		employeeService = context.getBean(EmployeeService.class);

		testGetAllCountries();

		testAddCountry();

		testQueryMethod();

		testHQL();

		testNativeQuery();

		testEmployeeMapping();
	}

	private static void testGetAllCountries() {

		LOGGER.info("========== Get All Countries ==========");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.info("Countries : {}", countries);
	}

	private static void testAddCountry() {

		LOGGER.info("========== Add Country ==========");

		Country country = new Country();

		// Change this code if JP already exists
		country.setCode("DE");
		country.setName("Germany");

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

	private static void testEmployeeMapping() {

		LOGGER.info("========== O/R Mapping ==========");

		List<Employee> employees = employeeService.getAllEmployees();

		for (Employee employee : employees) {
			LOGGER.info(employee.toString());
		}

		LOGGER.info("=================================");
	}
}