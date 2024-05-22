package com.subash.app.controller;

import com.subash.app.model.Person;
import com.subash.app.service.Servicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class Controlller {

    @Autowired
    private Servicee service;
    public void savePerson (Person person) {
        service.save(person);
    }

    public boolean eligible(int age) {
        return service.isEligible(age);
    }

    public void show () {
        service.display();
    }

    public void printOnlyEligiblePersons() {
        service.personWithVotingEligibility();
    }

    public void votedParty(Long voterID, int vote) {
        service.saveVote(voterID, vote);
    };

    public void delete(Long voterID) {
        service.deleteById(voterID);
    }
}
