package com.tutorial.graduationproject.Models;

import java.io.Serializable;

public class ProfileModel implements Serializable {
    private String profileTitle;
    private String profileName;
    private String profileSmallDescription;
    private String profileLongDescription;
    private int profileImage;
    private int complementaryImage;
    private int contactPhoneNumber;

    public ProfileModel(String profileTitle, String profileName, String profileSmallDescription, String profileLongDescription, int profileImage, int complementaryImage, int contactPhoneNumber) {
        this.profileTitle = profileTitle;
        this.profileName = profileName;
        this.profileSmallDescription = profileSmallDescription;
        this.profileLongDescription = profileLongDescription;
        this.profileImage = profileImage;
        this.complementaryImage = complementaryImage;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public int getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(int contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public int getComplementaryImage() {
        return complementaryImage;
    }

    public void setComplementaryImage(int complementaryImage) {
        this.complementaryImage = complementaryImage;
    }

    public String getProfileTitle() {
        return profileTitle;
    }

    public void setProfileTitle(String profileTitle) {
        this.profileTitle = profileTitle;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileSmallDescription() {
        return profileSmallDescription;
    }

    public void setProfileSmallDescription(String profileSmallDescription) {
        this.profileSmallDescription = profileSmallDescription;
    }

    public String getProfileLongDescription() {
        return profileLongDescription;
    }

    public void setProfileLongDescription(String profileLongDescription) {
        this.profileLongDescription = profileLongDescription;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }
}
