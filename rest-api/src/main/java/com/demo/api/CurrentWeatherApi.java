package com.demo.api;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;

import java.util.Map;

import static com.demo.utils.WeatherAPIConstants.*;
import static io.restassured.RestAssured.given;

public class CurrentWeatherApi {

    private <T> T getWeatherBy(Class<T> type, Map<String, Object> params) {
        return given().
                params(params).
                when().
                get().
                then().
                log().all().
                extract().
                response().
                as(type);
    }

    @Step("Get weather by city name : {0}")
    public <T> T getWeatherByCity(String city, Class<T> type) {
        Map<String, Object> params = ImmutableMap.of(CITY, city);
        return getWeatherBy(type, params);
    }

    @Step("Get weather by zip code : {0}")
    public <T> T getWeatherByZip(int code, Class<T> type) {
        Map<String, Object> params = ImmutableMap.of(ZIP_CODE, code);
        return getWeatherBy(type, params);
    }

    @Step("Get weather by latitude:{0} and longitude:{1}")
    public <T> T getWeatherByCoordinates(int lat, int lon, Class<T> type) {
        Map<String, Object> params = ImmutableMap.of(LAT, lat, LON, lon);
        return getWeatherBy(type, params);
    }

    @Step("Get weather by city:{0} and country code:{1}")
    public <T> T getWeatherByCityAndCountryCode(String city, String countryCode, Class<T> type) {
        Map<String, Object> params = ImmutableMap.of(CITY, String.join(",", city, countryCode));
        return getWeatherBy(type, params);
    }
}
