package com.shusa.beachratingapp;

import java.util.ArrayList;

public class Beach {
    String name;
    String displayRating;
    int imageLocation;
    int personalRating;
    ArrayList<String> messages;

    // Default Constructor
    public Beach() {
        name = null;
        displayRating = null;
        imageLocation = 0;
        personalRating = 0;
        messages = new ArrayList<>();
    }

    // Explicit Constructor
    public Beach(final String NAME, final String DISPLAY_RATING,
                 final int IMAGE_LOCATION, final int PERSONAL_RATING,
                 final ArrayList<String> MESSAGES) {
        name = NAME;
        displayRating = DISPLAY_RATING;
        imageLocation = IMAGE_LOCATION;
        personalRating = PERSONAL_RATING;
        messages = MESSAGES;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getDisplayRating() {
        return displayRating;
    }
    public int getImageLocation() {
        return imageLocation;
    }
    public int getPersonalRating() {
        return personalRating;
    }
    public ArrayList<String> getMessages() {
        return messages;
    }

    // Setters
    public void setName(final String NAME) {
        this.name = NAME;
    }
    public void setDisplayRating(final String DISPLAY_RATING) {
        this.displayRating = DISPLAY_RATING;
    }
    public void setImageLocation(final int IMAGE_LOCATION) {
        this.imageLocation = IMAGE_LOCATION;
    }
    public void setPersonalRating(final int PERSONAL_RATING) {
        this.personalRating = PERSONAL_RATING;
    }
    public void setMessages(final ArrayList<String> MESSAGES) {
        this.messages = MESSAGES;
    }
}
