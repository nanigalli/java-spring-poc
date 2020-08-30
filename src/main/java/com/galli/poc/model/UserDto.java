package com.galli.poc.model;

public class UserDto {

    private int id;

    private int dni;

    private String name;

    private boolean enabled;

    public UserDto() {
    }

    public UserDto(int id, int dni, String name, boolean enabled) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
