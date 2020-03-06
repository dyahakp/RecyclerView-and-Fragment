package com.example.pahlawanku;

public class HeroModel {
    //bikin var yang ada di Hero Data
    private String heroName;
    private String heroDesc;
    private int heroImage;
    //next generate setter getter

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroDesc() {
        return heroDesc;
    }

    public void setHeroDesc(String heroDesc) {
        this.heroDesc = heroDesc;
    }

    public int getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(int heroImage) {
        this.heroImage = heroImage;
    }
}
