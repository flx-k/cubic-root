package com.cubic.model.game;

public class Player {
    private String name;
    private Integer level;
    private Integer Blood;
    private Integer Mana;
    private String race;
    private String role;
    private String account;
    private Long experience;

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
