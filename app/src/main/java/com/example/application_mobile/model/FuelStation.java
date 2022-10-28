package com.example.application_mobile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelStation {

    private String Id;
    private String Name;
    private String Address;
    private String OwnerId;
    private String OpenDateTime;
    private String CloseDateTime;


    private String IsAir;
    private String IsOpen;
    private String City;
    private String Inventory;
    private String OnTheWayQue;
    private String Que;
    private String HistoryQue;
    private int TotalPetrol;
    private int TotalDiesel;

    public int getTotalPetrol() {
        return TotalPetrol;
    }

    public void setTotalPetrol(int totalPetrol) {
        TotalPetrol = totalPetrol;
    }

    public int getTotalDiesel() {
        return TotalDiesel;
    }

    public void setTotalDiesel(int totalDiesel) {
        TotalDiesel = totalDiesel;
    }


    public String getOpenDateTime() {
        return OpenDateTime;
    }

    public void setOpenDateTime(String openDateTime) {
        OpenDateTime = openDateTime;
    }



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

    public String getIsAir() {
        return IsAir;
    }

    public void setIsAir(String isAir) {
        IsAir = isAir;
    }


    public String getCloseDateTime() {
        return CloseDateTime;
    }

    public void setCloseDateTime(String closeDateTime) {
        CloseDateTime = closeDateTime;
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
