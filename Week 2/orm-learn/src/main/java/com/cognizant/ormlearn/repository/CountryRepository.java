package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Query Methods
    Country findByCode(String code);

    List<Country> findByName(String name);

    List<Country> findByNameContaining(String name);

    // HQL
    @Query("FROM Country")
    List<Country> getAllCountries();

    @Query("FROM Country WHERE code = ?1")
    Country getCountry(String code);

    // Native Query
    @Query(value = "SELECT * FROM country", nativeQuery = true)
    List<Country> getAllCountriesNative();

    @Query(value = "SELECT * FROM country WHERE code = ?1", nativeQuery = true)
    Country getCountryNative(String code);
}