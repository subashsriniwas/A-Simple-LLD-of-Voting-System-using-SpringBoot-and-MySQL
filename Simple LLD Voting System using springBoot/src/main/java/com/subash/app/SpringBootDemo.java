package com.subash.app;

import com.subash.app.controller.Controlller;
import com.subash.app.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringBootDemo {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootDemo.class, args);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[1] for save person \n[2] for checking eligibility \n[3] for display " +
                    "\n[4] for Voting \n[5] to delete \n[6] for exit");
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1: {
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    System.out.println("Enter age:");
                    int age = sc.nextInt();
                    sc.nextLine();
                    Person person = context.getBean(Person.class);
                    person.setName(name);
                    person.setAge(age);

                    Controlller controller = context.getBean(Controlller.class);
                    boolean isPersonEligible = controller.eligible(age);
                    person.setVotingEligible(isPersonEligible);
                    controller.savePerson(person);
                    break;
                }

                case 2: {
                    Controlller controller = context.getBean(Controlller.class);
                    controller.printOnlyEligiblePersons();
                    break;
                }

                case 3: {
                    Controlller controller = context.getBean(Controlller.class);
                    controller.show();
                    break;
                }

                case 4: {
                    System.out.println("Enter Your Voter ID");
                    Long voterID = sc.nextLong();
                    System.out.println("[1] for DMK \n[2] for ADMK \n[3] for NOTA");
                    int vote = sc.nextInt();
                    Controlller controlller = context.getBean(Controlller.class);
                    controlller.votedParty(voterID, vote);
                    break;

                }

                case 5: {
                    System.out.println("Enter the voter ID to delete a person from the list");
                    Long voterID = sc.nextLong();
                    Controlller controlller = context.getBean(Controlller.class);
                    controlller.delete(voterID);
                    break;
                }

                case 6: {
                    System.out.println("Exiting the application.");
                    sc.close();
                    return;
                }

                default: {
                    System.out.println("Invalid option. Please try again.");
                    break;
                }
            }
        }
    }
}
