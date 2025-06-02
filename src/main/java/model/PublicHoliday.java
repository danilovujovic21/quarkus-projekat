package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PublicHoliday {

    @JsonProperty("date")
    private String date;

    @JsonProperty("localName")
    private String localName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("fixed")
    private boolean fixed;

    @JsonProperty("global")
    private boolean global;

    @JsonProperty("counties")
    private String[] counties; // može biti null

    @JsonProperty("launchYear")
    private Integer launchYear; // može biti null

    @JsonProperty("type")
    private String type;

    // Getteri i setteri

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocalName() { return localName; }
    public void setLocalName(String localName) { this.localName = localName; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public boolean isFixed() { return fixed; }
    public void setFixed(boolean fixed) { this.fixed = fixed; }

    public boolean isGlobal() { return global; }
    public void setGlobal(boolean global) { this.global = global; }

    public String[] getCounties() { return counties; }
    public void setCounties(String[] counties) { this.counties = counties; }

    public Integer getLaunchYear() { return launchYear; }
    public void setLaunchYear(Integer launchYear) { this.launchYear = launchYear; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
