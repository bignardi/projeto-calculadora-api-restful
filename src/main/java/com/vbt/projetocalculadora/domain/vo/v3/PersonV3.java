package com.vbt.projetocalculadora.domain.vo.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

// Ajusta a ordem dos resultados no JSON
@JsonPropertyOrder({"id", "firs_tName", "last_Name", "address", "gender", "enabled"})
public class PersonV3 extends RepresentationModel<PersonV3> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthday;
    private Boolean enabled;

    public PersonV3() {
    }

    public PersonV3(Long key, String firstName, String lastName, String address, String gender, Date birthday, Boolean enabled) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.birthday = birthday;
        this.enabled = enabled;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonV3 personV3 = (PersonV3) o;
        return Objects.equals(key, personV3.key)
                && Objects.equals(firstName, personV3.firstName)
                && Objects.equals(lastName, personV3.lastName)
                && Objects.equals(address, personV3.address)
                && Objects.equals(gender, personV3.gender)
                && Objects.equals(birthday, personV3.birthday)
                && Objects.equals(enabled, personV3.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, firstName, lastName, address, gender, birthday, enabled);
    }

}
