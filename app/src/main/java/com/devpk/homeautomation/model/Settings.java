package com.devpk.homeautomation.model;

public class Settings {
    public int fan_interval;
    public int gas_limit;
    public int humidity_inside_limit;
    public int humidity_outside_limit;
    public int lights_interval;
    public int lock_reset_interval;
    public int notifications_interval;
    public int temperature_inside_limit;
    public int temperature_outside_limit;
    public int water_level_max;
    public int water_level_min;

    public Settings(int fan_interval, int gas_limit, int humidity_inside_limit, int humidity_outside_limit, int lights_interval, int lock_reset_interval, int notifications_interval, int temperature_inside_limit, int temperature_outside_limit, int water_level_max, int water_level_min) {
        this.fan_interval = fan_interval;
        this.gas_limit = gas_limit;
        this.humidity_inside_limit = humidity_inside_limit;
        this.humidity_outside_limit = humidity_outside_limit;
        this.lights_interval = lights_interval;
        this.lock_reset_interval = lock_reset_interval;
        this.notifications_interval = notifications_interval;
        this.temperature_inside_limit = temperature_inside_limit;
        this.temperature_outside_limit = temperature_outside_limit;
        this.water_level_max = water_level_max;
        this.water_level_min = water_level_min;
    }

    public int getFan_interval() {
        return fan_interval;
    }

    public void setFan_interval(int fan_interval) {
        this.fan_interval = fan_interval;
    }

    public int getGas_limit() {
        return gas_limit;
    }

    public void setGas_limit(int gas_limit) {
        this.gas_limit = gas_limit;
    }

    public int getHumidity_inside_limit() {
        return humidity_inside_limit;
    }

    public void setHumidity_inside_limit(int humidity_inside_limit) {
        this.humidity_inside_limit = humidity_inside_limit;
    }

    public int getHumidity_outside_limit() {
        return humidity_outside_limit;
    }

    public void setHumidity_outside_limit(int humidity_outside_limit) {
        this.humidity_outside_limit = humidity_outside_limit;
    }

    public int getLights_interval() {
        return lights_interval;
    }

    public void setLights_interval(int lights_interval) {
        this.lights_interval = lights_interval;
    }

    public int getLock_reset_interval() {
        return lock_reset_interval;
    }

    public void setLock_reset_interval(int lock_reset_interval) {
        this.lock_reset_interval = lock_reset_interval;
    }

    public int getNotifications_interval() {
        return notifications_interval;
    }

    public void setNotifications_interval(int notifications_interval) {
        this.notifications_interval = notifications_interval;
    }

    public int getTemperature_inside_limit() {
        return temperature_inside_limit;
    }

    public void setTemperature_inside_limit(int temperature_inside_limit) {
        this.temperature_inside_limit = temperature_inside_limit;
    }

    public int getTemperature_outside_limit() {
        return temperature_outside_limit;
    }

    public void setTemperature_outside_limit(int temperature_outside_limit) {
        this.temperature_outside_limit = temperature_outside_limit;
    }

    public int getWater_level_max() {
        return water_level_max;
    }

    public void setWater_level_max(int water_level_max) {
        this.water_level_max = water_level_max;
    }

    public int getWater_level_min() {
        return water_level_min;
    }

    public void setWater_level_min(int water_level_min) {
        this.water_level_min = water_level_min;
    }
}


