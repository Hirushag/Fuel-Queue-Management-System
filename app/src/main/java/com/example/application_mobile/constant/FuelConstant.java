package com.example.application_mobile.constant;

import java.sql.Time;

import lombok.Data;

@Data
public class FuelConstant {


    private String Id = "Id";
    private String Name = "Name";
    private String Address = "Address";
    private String OwnerId = "OwnerId";
    private String OpenDateTime = "OpenDateTime";
    private String CloseDateTime = "CloseDateTime";
    private String IsAir = "IsAir";
    private String IsOpen = "IsOpen";
    private String City = "City";
    private String Inventory = "Inventory";
    private String OnTheWayQue = "OnTheWayQue";
    private String Que = "Que";
    private String HistoryQue = "HistoryQue";

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public String getOpenDateTime() {
        return OpenDateTime;
    }

    public void setOpenDateTime(String openDateTime) {
        OpenDateTime = openDateTime;
    }

    public String getCloseDateTime() {
        return CloseDateTime;
    }

    public void setCloseDateTime(String closeDateTime) {
        CloseDateTime = closeDateTime;
    }

    public String getIsAir() {
        return IsAir;
    }

    public void setIsAir(String isAir) {
        IsAir = isAir;
    }

    public String getIsOpen() {
        return IsOpen;
    }

    public void setIsOpen(String isOpen) {
        IsOpen = isOpen;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getInventory() {
        return Inventory;
    }

    public void setInventory(String inventory) {
        Inventory = inventory;
    }

    public String getOnTheWayQue() {
        return OnTheWayQue;
    }

    public void setOnTheWayQue(String onTheWayQue) {
        OnTheWayQue = onTheWayQue;
    }

    public String getQue() {
        return Que;
    }

    public void setQue(String que) {
        Que = que;
    }

    public String getHistoryQue() {
        return HistoryQue;
    }

    public void setHistoryQue(String historyQue) {
        HistoryQue = historyQue;
    }
}
