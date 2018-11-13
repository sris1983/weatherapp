package com.example.weather.web;

import com.example.weather.integration.ows.Weather;
import com.example.weather.integration.ows.WeatherForecast;
import com.example.weather.integration.ows.WeatherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@Api(value="WeatherApiController", description="WeatherApiController services")
public class WeatherApiController {

	private final WeatherService weatherService;

	public WeatherApiController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
    
	@ApiOperation(value = "getWeather",response = WeatherService.class)
	@RequestMapping("/now/{city}")
	public Weather getWeather(@PathVariable String city) {
		return this.weatherService.getWeather(city);
	}
 
	@ApiOperation(value = "getWeatherForecast",response = WeatherService.class)
	@RequestMapping("/threedays/{city}")
	public WeatherForecast getWeatherForecast(
			@PathVariable String city) {
		//@PathVariable String country,
		//return this.weatherService.getWeatherForecast(country, city);
		return this.weatherService.getWeatherForecast(city);
	}

}
