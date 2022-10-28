package com.example.application_mobile.constant;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Common {

    private String URL = "http://192.168.1.5:8088/api/v1/";
    private String ADD_FUEL_STATION = "https://oktane-live.herokuapp.com/api/GasStation";
    private String GET_FUEL_STATIONS = "https://oktane-live.herokuapp.com/api/GasStation";



    private String GET_FUEL_QUANTITIES = "https://oktane-live.herokuapp.com/GetQueueStatus?stationId=";
    private String UPDATE_FUEL_QUANTITY = "https://oktane-live.herokuapp.com/save/fuel";
    private String GET_FUEL_STATIONS_BY_USER = "https://oktane-live.herokuapp.com/api/GasStation/";
    private String GET_FUEL_STATIONS_BY_ADMINID = "https://oktane-live.herokuapp.com/GetStationByUserId?userId=";
    private String JOIN_TO_QUE = "https://oktane-live.herokuapp.com/save/arrival-que";
    private String EXIT_FROM_THE_QUE = "https://oktane-live.herokuapp.com/save/historyque?queueId=";
    private String UPDATE_OPEN_CLOSE_STATUS = "https://oktane-live.herokuapp.com/change-status/station?stationId=";



    public String getUPDATE_OPEN_CLOSE_STATUS() {
        return UPDATE_OPEN_CLOSE_STATUS;
    }

    public void setUPDATE_OPEN_CLOSE_STATUS(String UPDATE_OPEN_CLOSE_STATUS) {
        this.UPDATE_OPEN_CLOSE_STATUS = UPDATE_OPEN_CLOSE_STATUS;
    }


    public String getJOIN_TO_QUE() {
        return JOIN_TO_QUE;
    }

    public String getEXIT_FROM_THE_QUE() {
        return EXIT_FROM_THE_QUE;
    }

    public void setEXIT_FROM_THE_QUE(String EXIT_FROM_THE_QUE) {
        this.EXIT_FROM_THE_QUE = EXIT_FROM_THE_QUE;
    }

    public void setJOIN_TO_QUE(String JOIN_TO_QUE) {
        this.JOIN_TO_QUE = JOIN_TO_QUE;
    }

    public String getGET_FUEL_STATIONS_BY_USER() {
        return GET_FUEL_STATIONS_BY_USER;
    }

    public void setGET_FUEL_STATIONS_BY_USER(String GET_FUEL_STATIONS_BY_USER) {
        this.GET_FUEL_STATIONS_BY_USER = GET_FUEL_STATIONS_BY_USER;
    }

    public String getGET_FUEL_STATIONS_BY_ADMINID() {
        return GET_FUEL_STATIONS_BY_ADMINID;
    }

    public void setGET_FUEL_STATIONS_BY_ADMINID(String GET_FUEL_STATIONS_BY_ADMINID) {
        this.GET_FUEL_STATIONS_BY_ADMINID = GET_FUEL_STATIONS_BY_ADMINID;
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

    public String getGET_FUEL_STATIONS() {
        return GET_FUEL_STATIONS;
    }

    public void setGET_FUEL_STATIONS(String GET_FUEL_STATIONS) {
        this.GET_FUEL_STATIONS = GET_FUEL_STATIONS;
    }

//    public String getGET_FUEL_STATIONS_BY_USER() {
//        return GET_FUEL_STATIONS_BY_USER;
//    }
//
//    public void setGET_FUEL_STATIONS_BY_USER(String GET_FUEL_STATIONS_BY_USER) {
//        this.GET_FUEL_STATIONS_BY_USER = GET_FUEL_STATIONS_BY_USER;
//    }

    public String getGET_FUEL_QUANTITIES() {
        return GET_FUEL_QUANTITIES;
    }

    public void setGET_FUEL_QUANTITIES(String GET_FUEL_QUANTITIES) {
        this.GET_FUEL_QUANTITIES = GET_FUEL_QUANTITIES;
    }

    public String getUPDATE_FUEL_QUANTITY() {
        return UPDATE_FUEL_QUANTITY;
    }

    public void setUPDATE_FUEL_QUANTITY(String UPDATE_FUEL_QUANTITY) {
        this.UPDATE_FUEL_QUANTITY = UPDATE_FUEL_QUANTITY;
    }



}
