package com.example.cbs2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crop {

    int photoID;

    @SerializedName("instructions")
    @Expose
    private List<String> instructions = null;
    @SerializedName("instructions_weight")
    @Expose
    private List<Integer> instructionsWeight = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("season")
    @Expose
    private String season;
    @SerializedName("insructions")
    @Expose
    private List<String> insructions = null;

    public Crop(List<String> instructions, List<Integer> instructionsWeight, String name, String season) {
        this.insructions = instructions;
        this.instructionsWeight = instructionsWeight;
        this.name = name;
        this.season = season;

        check();
    }

    private void check() {
        switch (name) {
            case "tomato" : photoID = R.drawable.tomaato;
                break;
            case "potato" : photoID = R.drawable.potato;
                break;
            case "maize" : photoID = R.drawable.maize;
                break;
            case "wheat" : photoID = R.drawable.wheat;
            break;
            default:photoID = -1;
        }
    }

    public Crop() {

    }

    public Crop(String name, int maize1) {
        this.name = name;
        check();
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public List<Integer> getinstructions_weight() {
        return instructionsWeight;
    }

    public void setinstructions_weight(List<Integer> instructionsWeight) {
        this.instructionsWeight = instructionsWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<String> getInsructions() {
        return insructions;
    }

    public void setInsructions(List<String> insructions) {
        this.insructions = insructions;
    }

    public int getPhotoID() {
        return photoID;
    }

}
