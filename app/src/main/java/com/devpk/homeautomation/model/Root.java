package com.devpk.homeautomation.model;

public class Root {
    public int alive;
    public int fans;
    public int gas;
    public int humidity_inside;
    public int humidity_outside;
    public int lights;
    public int lock;
    public Settings settings;
    public int temperature_inside;
    public int temperature_inside_limit;
    public int temperature_outside;

    public Root(int alive, int fans, int gas, int humidity_inside, int humidity_outside, int lights, int lock, Settings settings,
                int temperature_inside, int temperature_inside_limit, int temperature_outside) {
        this.alive = alive;
        this.fans = fans;
        this.gas = gas;
        this.humidity_inside = humidity_inside;
        this.humidity_outside = humidity_outside;
        this.lights = lights;
        this.lock = lock;
        this.settings = settings;
        this.temperature_inside = temperature_inside;
        this.temperature_inside_limit = temperature_inside_limit;
        this.temperature_outside = temperature_outside;
    }

    public int getAlive() {
        return alive;
    }

    public void setAlive(int alive) {
        this.alive = alive;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getHumidity_inside() {
        return humidity_inside;
    }

    public void setHumidity_inside(int humidity_inside) {
        this.humidity_inside = humidity_inside;
    }

    public int getHumidity_outside() {
        return humidity_outside;
    }

    public void setHumidity_outside(int humidity_outside) {
        this.humidity_outside = humidity_outside;
    }

    public int getLights() {
        return lights;
    }

    public void setLights(int lights) {
        this.lights = lights;
    }

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public int getTemperature_inside() {
        return temperature_inside;
    }

    public void setTemperature_inside(int temperature_inside) {
        this.temperature_inside = temperature_inside;
    }

    public int getTemperature_inside_limit() {
        return temperature_inside_limit;
    }

    public void setTemperature_inside_limit(int temperature_inside_limit) {
        this.temperature_inside_limit = temperature_inside_limit;
    }

    public int getTemperature_outside() {
        return temperature_outside;
    }

    public void setTemperature_outside(int temperature_outside) {
        this.temperature_outside = temperature_outside;
    }
}
