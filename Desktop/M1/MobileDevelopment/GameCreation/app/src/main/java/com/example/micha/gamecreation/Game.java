package com.example.micha.gamecreation;

import java.io.Serializable;

/**
 * Created by micha on 09/04/2017.
 */

public class Game implements Serializable{
    private int day, month, year;
    private String surface, typeOfGame;

    public Game(int day, int month, int year, String surface, String typeOfGame){
        this.day = day;
        this.month = month;
        this.year = year;
        this.surface = surface;
        this.typeOfGame = typeOfGame;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getTypeOfGame() {
        return typeOfGame;
    }

    public void setTypeOfGame(String typeOfGame) {
        this.typeOfGame = typeOfGame;
    }

    @Override
    public String toString() {
        return "toto";
        //return this.day + "/" + this.month + "/" + this.year;
    }
}
