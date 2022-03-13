package ru.netology.radioman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    public int minStation = 0;
    public int maxStation = 11;
    public int minVolume = 0;
    public int maxVolume = 100;

    @Test
    void setCurrentStation() {
        Radio station = new Radio();
        int expected = 3;

        station.setCurrentStation(expected);

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
    void setCurrentStationOn() {
        Radio station = new Radio(8,43,minStation,maxStation,minVolume,maxVolume);
        int expected = 3;

        station.setCurrentStation(expected);

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
    void incorrectMinValueSetCurrentStation() {
        int expected = 3;
        Radio station = new Radio(expected, 63, minStation, maxStation, minVolume, maxVolume);

        station.setCurrentStation(-1);

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
    void incorrectMinValueSetCurrentStationGetMin() {
        int expected = 0;
        Radio station = new Radio();

        station.setCurrentStation(-1);

        assertEquals(expected, station.getMinStation());
    }

    @Test
    void incorrectMaxValueSetCurrentStation() {
        int expected = 3;
        Radio station = new Radio(expected, 63, minStation, maxStation, minVolume, maxVolume);

        station.setCurrentStation(12);

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
    void incorrectMaxValueSetCurrentStationGetMax() {
        int expected = 11;
        Radio station = new Radio(9, 63, minStation, maxStation, minVolume, maxVolume);

        station.setCurrentStation(12);

        assertEquals(expected, station.getMaxStation());
    }

    @Test
    void pushNextRadioStation() {
        Radio station = new Radio(11, 63, minStation, maxStation, minVolume, maxVolume);
        station.nextStation();

        int expected = 0;

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
    void pushNextRadioStationGetMin() {
        Radio station = new Radio(11, 63, minStation, maxStation, minVolume, maxVolume);
        station.nextStation();

        int expected = 0;

        assertEquals(expected, station.getMinStation());
    }

    @Test
    void pushDoubleNextRadioStation() {
        Radio station = new Radio(10, 63, minStation, maxStation, minVolume, maxVolume);
        station.nextStation();
        station.nextStation();

        int expected = 0;

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
    void pushPrevRadioStation() {
        Radio station = new Radio(0, 63, minStation, maxStation, minVolume, maxVolume);
        station.prevStation();

        int expected = 11;

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
    void pushDoublePrevRadioStation() {
        Radio station = new Radio(1, 63, minStation, maxStation, minVolume, maxVolume);

        station.prevStation();
        station.prevStation();

        int expected = 11;

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
    void setCurrentVolume() {
        Radio station = new Radio(8, 63, minStation, maxStation, minVolume, maxVolume);
        int expected = 63;

        station.setCurrentVolume(expected);

        assertEquals(expected, station.getCurrentVolume());
    }

    @Test
    void setCurrentVolumeNoConstructor() {
        int expected = 63;
        Radio station = new Radio();

        station.setCurrentVolume(expected);

        assertEquals(expected, station.getCurrentVolume());
    }

    @Test
    void setCurrentVolumeMinVolume() {
        int expected = 0;
        Radio station = new Radio(7,2,minStation,maxStation,minVolume,maxVolume);

        station.setCurrentVolume(expected);

        assertEquals(expected, station.getMinVolume());
    }

    @Test
    void setCurrentVolumeMinVolumeNo() {
        int expected = 0;
        Radio station = new Radio();

        station.setCurrentVolume(expected);

        assertEquals(expected, station.getMinVolume());
    }

    @Test
    void incorrectMaxValueSetCurrentVolume() {
        int expected = 77;
        Radio station = new Radio(8, expected, minStation, maxStation, minVolume, maxVolume);

        station.setCurrentVolume(101);

        assertEquals(expected, station.getCurrentVolume());
    }

    @Test
    void incorrectMaxValueSetCurrentVolumeOn() {
        int expected = 100;
        Radio station = new Radio();

        station.setCurrentVolume(101);

        assertEquals(expected, station.getMaxVolume());
    }


    @Test
    void incorrectMinValueSetCurrentVolume() {
        int expected = 0;
        Radio station = new Radio(8, expected, minStation, maxStation, minVolume, maxVolume);

        station.setCurrentVolume(-1);

        assertEquals(expected, station.getMinVolume());
    }

    @Test
    void volumeUpCurrentVolume() {
        Radio station = new Radio(8, 100, minStation, maxStation, minVolume, maxVolume);

        station.increaseCurrentVolume();

        assertEquals(station.getMaxVolume(), station.getCurrentVolume());
    }

    @Test
    void volumeDoubleUpCurrentVolume() {
        Radio station = new Radio(8, 99, minStation, maxStation, minVolume, maxVolume);

        station.increaseCurrentVolume();
        station.increaseCurrentVolume();

        assertEquals(station.getMaxVolume(), station.getCurrentVolume());
    }

    @Test
    void volumeDownCurrentVolume() {
        Radio station = new Radio(8, 0, minStation, maxStation, minVolume, maxVolume);

        station.decreaseCurrentVolume();

        assertEquals(station.getMinVolume(), station.getCurrentVolume());
    }

    @Test
    void volumeDoubleDownCurrentVolume() {
        Radio station = new Radio(8, 1, minStation, maxStation, minVolume, maxVolume);

        station.decreaseCurrentVolume();
        station.decreaseCurrentVolume();

        assertEquals(station.getMinVolume(), station.getCurrentVolume());
    }
}