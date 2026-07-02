package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String code) {
        return countryRepository.findByCode(code);
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public List<Country> getAllCountriesHQL() {
        return countryRepository.getAllCountries();
    }

    @Transactional
    public Country getCountryHQL(String code) {
        return countryRepository.getCountry(code);
    }

    @Transactional
    public List<Country> getAllCountriesNative() {
        return countryRepository.getAllCountriesNative();
    }

    @Transactional
    public Country getCountryNative(String code) {
        return countryRepository.getCountryNative(code);
    }
}