package com.vbt.projetocalculadora.domain.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Objects;

// Ajusta a ordem dos resultados no JSON
@JsonPropertyOrder({"id", "firs_tName", "last_Name", "address", "gender"})
public class PersonV1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String address;
    private String gender;

    public PersonV1() {
    }

    public PersonV1(Long id, String firstName, String lastName, String address, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonV1 personV1 = (PersonV1) o;
        return Objects.equals(id, personV1.id)
                && Objects.equals(firstName, personV1.firstName)
                && Objects.equals(lastName, personV1.lastName)
                && Objects.equals(address, personV1.address)
                && Objects.equals(gender, personV1.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
