package com.qaprosoft.carina.demo.api;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.api.openweather.GetCallForecast;
import com.qaprosoft.carina.demo.api.openweather.GetOneCallAPI;
import com.qaprosoft.carina.demo.api.openweather.GetWeatherCity;
import com.qaprosoft.carina.demo.api.openweather.PostStation;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APIWeatherTests implements IAbstractTest {
    @Test
    public void testWeatherMinsk(){
        GetWeatherCity getWeatherCity = new GetWeatherCity();
        getWeatherCity.addParameter("q","Minsk");
        getWeatherCity.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherCity.callAPI();
        getWeatherCity.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherCity.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }
    @Test
    public void testUnknownCity(){
        GetWeatherCity getWeatherCity = new GetWeatherCity();
        getWeatherCity.addParameter("q","Gondor");
        getWeatherCity.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getWeatherCity.callAPI();
    }
    @Test
    public void testDailyForecast(){
        GetOneCallAPI getOneCallAPI = new GetOneCallAPI();
        getOneCallAPI.addParameter("lat","27.5667");
        getOneCallAPI.addParameter("lon","53.9");
        getOneCallAPI.addParameter("exclude","current,daily,minutely,hourly");
        getOneCallAPI.expectResponseStatus(HttpResponseStatusType.OK_200);
        getOneCallAPI.callAPI();
        getOneCallAPI.validateResponse(JSONCompareMode.STRICT,JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getOneCallAPI.validateResponseAgainstSchema("api/getonecallapi/rs.schema");
    }
    @Test
    public void testCallForecast(){
        GetCallForecast getCallForecast = new GetCallForecast();
        getCallForecast.addParameter("q","Lida");
        getCallForecast.addParameter("cnt","1");
        getCallForecast.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCallForecast.callAPI();
        //getCallForecast.validateResponse(JSONCompareMode.STRICT,JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCallForecast.validateResponseAgainstSchema("api/getcallforecast/rs_schema.json");
    }
    @Test
    public void testCreateStation(){
        PostStation postStation = new PostStation();
        postStation.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postStation.callAPI();
        postStation.validateResponse();
    }
}
