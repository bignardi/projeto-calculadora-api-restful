package com.vbt.projetocalculadora.domain.vo.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

// Ajusta a ordem dos resultados no JSON
@JsonPropertyOrder({"id", "firs_tName", "last_Name", "address", "gender", "birthday"})
public class PersonV2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String address;
    private String gender;
    private Date birthday;

    public PersonV2() {
    }

    public PersonV2(Long id, String firstName, String lastName, String address, String gender, Date birthday) {
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
        PersonV2 personV2 = (PersonV2) o;
        return Objects.equals(id, personV2.id)
                && Objects.equals(firstName, personV2.firstName)
                && Objects.equals(lastName, personV2.lastName)
                && Objects.equals(address, personV2.address)
                && Objects.equals(gender, personV2.gender)
                && Objects.equals(birthday, personV2.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender, birthday);
    }
}
