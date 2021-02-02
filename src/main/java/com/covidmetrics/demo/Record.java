package com.covidmetrics.demo;

public class Record {
    private String country;
    private String country_code;
    private String continent;
    private long population;
    private String indicator;
    private String year_week;
    private int cumulative_count;
    private String source;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String countryCode) {
        this.country_code = countryCode;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getYear_week() {
        return year_week;
    }

    public void setYear_week(String yearWeek) {
        this.year_week = yearWeek;
    }

    public int getCumulative_count() {
        return cumulative_count;
    }

    public void setCumulative_count(int cumulativeCount) {
        this.cumulative_count = cumulativeCount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
