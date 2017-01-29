package com.ellie.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName", length = 50)
    private String firstName;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column(name = "personal_data", length = 250)
    private String personalData;

    //@Column(name = "subjects", length = 50)
    //private Map<String, Integer> subjects;

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }

    public String getPersonalData() {

        return personalData;
    }

//    public void setSubjects(Map<String, Integer> subjects) {
//        this.subjects = subjects;
//    }

//    public Map<String, Integer> getSubjects() {
//        return subjects;
//    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        User user = (User) obj;

        if (!id.equals(user.id))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
