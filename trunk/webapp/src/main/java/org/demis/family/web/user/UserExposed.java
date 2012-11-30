package org.demis.family.web.user;

import org.demis.family.web.AbstractExposed;

public class UserExposed extends AbstractExposed {

    public final static String URI_BASE = "/users/";

    private String email = null;

    private String firstName = null;

    private String lastName = null;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
