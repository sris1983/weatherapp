package com.example.weather.integration.ows;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherEntry implements Serializable {

	private Instant timestamp;

	private double temperature;

	private double pressure;

	private String weatherIcon;

	@JsonProperty("timestamp")
	public Instant getTimestamp() {
		return this.timestamp;
	}

	@JsonSetter("dt")
	public void setTimestamp(long unixTime) {
		this.timestamp = Instant.ofEpochMilli(unixTime * 1000);
	}

	/**
	 * Return the temperature in Kelvin (K).
	 */
	public double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		setTemperature(Double.parseDouble(main.get("temp").toString()));
		setPressure(Double.parseDouble(main.get("pressure").toString()));
	}

	public double getPressure() {
		return this.pressure;
	}
	
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public String getWeatherIcon() {
		return this.weatherIcon;
	}

	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherIcon((String) weather.get("icon"));
	}

}
