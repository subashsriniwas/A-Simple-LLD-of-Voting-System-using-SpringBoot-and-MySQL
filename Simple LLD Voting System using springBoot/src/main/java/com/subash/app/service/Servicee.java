package com.subash.app.service;

import com.subash.app.model.Person;
import com.subash.app.repository.Repo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JSqlParserUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class Servicee {
    @Autowired
    private Repo repo;
    public void save (Person person) {
        this.repo.save(person);
    }

    public boolean isEligible (int age) {
        return age >= 18;
    }

    public void display () {
        List<Person> list = repo.findAll();
        for (Person p : list) {
            System.out.println(p.toString());
        }
    }

    public void personWithVotingEligibility () {

        List<Person> eligiblePersons = repo.findAll().stream().filter(person -> person.isVotingEligible() && person.getVotedParty() == null).toList();

        if (eligiblePersons.isEmpty()) {
            System.out.println("No eligible persons found.");
        }
        else {
            eligiblePersons.forEach(p -> System.out.println(p.getName() + " is eligible to vote."));
        }
    }

    @Transactional
    public void saveVote(Long voterID, int vote) {
        Person p = repo.getById(voterID);
        if (repo.existsById(voterID) && p.isVotingEligible() && p.getVotedParty() == null) {
            String voted_party = "";
            if (vote == 1) {
                voted_party = "DMK";
            } else if (vote == 2) {
                voted_party = "ADMK";
            } else {
                voted_party = "NOTA";
            }
            p.setVotedParty(voted_party);
            save(p);
            System.out.println("Voted Successfully");
        } else {
            System.out.println("NOT eligible to vote or Already Voted");
        }
    }

    public void deleteById(Long voterId) {
        if (repo.existsById(voterId)) {
            repo.deleteById(voterId);
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Enter Valid Number or check the voter list..");
            display();
        }
    }
}
