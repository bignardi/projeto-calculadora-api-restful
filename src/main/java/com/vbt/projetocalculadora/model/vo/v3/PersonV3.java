package com.vbt.projetocalculadora.domain.vo.v3;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonV3 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthday;

    public PersonV3() {
    }

    public PersonV3(Long id, String firstName, String lastName, String address, String gender, Date birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonV3 personV3 = (PersonV3) o;
        return Objects.equals(id, personV3.id)
                && Objects.equals(firstName, personV3.firstName)
                && Objects.equals(lastName, personV3.lastName)
                && Objects.equals(address, personV3.address)
                && Objects.equals(gender, personV3.gender)
                && Objects.equals(birthday, personV3.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender, birthday);
    }
}
