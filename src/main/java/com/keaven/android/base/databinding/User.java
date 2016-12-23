package com.keaven.android.base.databinding;

/**
 * Created by a-keaven on 2016/12/21.
 */
public class User {
    private String firstName;
    private String lastName;
    private boolean fired = false;
    private int gender;

    public User() {
        super();
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public User(String firstName, String lastName,boolean isf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fired=isf;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }
}
