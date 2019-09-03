package com.cubic.model.game;

public class Race {
    private String name;
    private Integer level;
    private Integer Blood;
    private Integer Mana;
    private String role;

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


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
