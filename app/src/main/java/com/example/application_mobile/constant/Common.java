package com.example.application_mobile.constant;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Common {

    private  String URL = "http://192.168.1.5:8088/api/v1/";
    private  String ADD_FUEL_STATION = "https://oktane-live.herokuapp.com/api/GasStation";
    private String GET_FUEL_STATIONS = "https://oktane-live.herokuapp.com/api/GasStation";
    private String GET_FUEL_STATIONS_BY_USER = "https://oktane-live.herokuapp.com/api/GasStation";
    private String GET_FUEL_QUANTITIES = "https://oktane-live.herokuapp.com/api/GasStation";
    private String UPDATE_FUELQUANTITY = "https://oktane-live.herokuapp.com/api/GasStation";
    private String CHANGE_QUE_STATUS = "https://oktane-live.herokuapp.com/api/GasStation/status";
    private String GET_DATA_BY_OWNER_ID = "https://oktane-live.herokuapp.com/api/GasStation";
    private String LOGIN = "https://oktane-live.herokuapp.com/api/GasStation";
    private String SIGN_UP = "https://oktane-live.herokuapp.com/api/GasStation";

    public String getGET_FUEL_STATIONS_BY_USER() {
        return GET_FUEL_STATIONS_BY_USER;
    }

    public void setGET_FUEL_STATIONS_BY_USER(String GET_FUEL_STATIONS_BY_USER) {
        this.GET_FUEL_STATIONS_BY_USER = GET_FUEL_STATIONS_BY_USER;
    }

    public String getUPDATE_FUELQUANTITY() {
        return UPDATE_FUELQUANTITY;
    }

    public void setUPDATE_FUELQUANTITY(String UPDATE_FUELQUANTITY) {
        this.UPDATE_FUELQUANTITY = UPDATE_FUELQUANTITY;
    }

    public String getCHANGE_QUE_STATUS() {
        return CHANGE_QUE_STATUS;
    }

    public void setCHANGE_QUE_STATUS(String CHANGE_QUE_STATUS) {
        this.CHANGE_QUE_STATUS = CHANGE_QUE_STATUS;
    }

    public String getGET_DATA_BY_OWNER_ID() {
        return GET_DATA_BY_OWNER_ID;
    }

    public void setGET_DATA_BY_OWNER_ID(String GET_DATA_BY_OWNER_ID) {
        this.GET_DATA_BY_OWNER_ID = GET_DATA_BY_OWNER_ID;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public String getSIGN_UP() {
        return SIGN_UP;
    }

    public void setSIGN_UP(String SIGN_UP) {
        this.SIGN_UP = SIGN_UP;
    }

    private  String JSON_PREFIX = "dataBundle";

    public String getGET_FUEL_QUANTITIES() {
        return GET_FUEL_QUANTITIES;
    }

    public void setGET_FUEL_QUANTITIES(String GET_FUEL_QUANTITIES) {
        this.GET_FUEL_QUANTITIES = GET_FUEL_QUANTITIES;
    }



    public String getJSON_PREFIX() {
        return JSON_PREFIX;
    }

    public void setJSON_PREFIX(String JSON_PREFIX) {
        this.JSON_PREFIX = JSON_PREFIX;
    }

    public String getGET_FUEL_STATIONS() {
        return GET_FUEL_STATIONS;
    }

    public void setGET_FUEL_STATIONS(String GET_FUEL_STATIONS) {
        this.GET_FUEL_STATIONS = GET_FUEL_STATIONS;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getADD_FUEL_STATION() {
        return ADD_FUEL_STATION;
    }

    public void setADD_FUEL_STATION(String ADD_FUEL_STATION) {
        this.ADD_FUEL_STATION = ADD_FUEL_STATION;
    }
}
