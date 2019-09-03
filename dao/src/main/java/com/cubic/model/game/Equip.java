package com.cubic.model.game;

public class Equip {
    private String name;
    private Integer level;
    private Integer Blood;
    private Integer Mana;
    private Integer race;
    private Integer role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getBlood() {
        return Blood;
    }

    public void setBlood(Integer blood) {
        Blood = blood;
    }

    public Integer getMana() {
        return Mana;
    }

    public void setMana(Integer mana) {
        Mana = mana;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
