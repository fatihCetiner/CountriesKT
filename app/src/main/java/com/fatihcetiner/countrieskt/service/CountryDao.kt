package com.fatihcetiner.countrieskt.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fatihcetiner.countrieskt.model.Country

@Dao
interface CountryDao {

    // Data Access Object

    @Insert
    suspend fun insertAll(vararg countries: Country): List<Long>

    // Insert -> INSERT INTO
    // suspend -> coroutine, pause & resume
    // vararg -> multiple country object
    // List<Long> -> primary keys

    @Query("SELECT * FROM country")
    suspend fun gelAllCountries(): List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountries(countryId: Int): Country

    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()

}