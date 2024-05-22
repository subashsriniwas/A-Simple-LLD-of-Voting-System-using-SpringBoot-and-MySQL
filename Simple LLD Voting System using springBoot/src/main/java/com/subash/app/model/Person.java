package com.subash.app.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope("prototype")
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Person_Name")
    private String name;
    @Column (name = "Person_age")
    private int age;
    @Column (name = "Person_isEligible")
    private boolean votingEligible;
    @Column(name = "Voted_Party")
    private String votedParty;

    @Override
    public String toString() {
        return "Person{" +
                "Voter ID= " + id +
                ", name= " + name + '\'' +
                ", age= " + age +
                ", votingEligible= " + votingEligible +
                ", Voted party= " + votedParty +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVotingEligible() {
        return votingEligible;
    }

    public void setVotingEligible(boolean votingEligible) {
        this.votingEligible = votingEligible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setVotedParty(String votedParty) { this.votedParty = votedParty; }
    public String getVotedParty() { return votedParty; }
}
