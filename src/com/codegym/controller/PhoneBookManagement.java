package com.codegym.controller;

import com.codegym.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookManagement {
    public static Scanner sc = new Scanner(System.in);
    private List<Person> persons = new ArrayList<>();

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void readPersonToFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader br = new BufferedReader(fileReader);
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] productLine = line.split(",");
            String personGroup = productLine[0];
            String personPhoneNumber = productLine[1];
            String personName = productLine[2];
            String personGender = productLine[3];
            String personAddress = productLine[4];
            String personDateOfBirth = productLine[5];
            String personEmail = productLine[6];

            Person person = new Person(personGroup, personPhoneNumber, personName, personGender, personAddress, personDateOfBirth, personEmail);
            persons.add(person);

        }
        br.close();
        fileReader.close();
    }

    public void writePersonToFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bw= new BufferedWriter(fileWriter);
        for (int i = 0; i < persons.size(); i++) {
            bw.write(persons.get(i).toString());
            if (i != persons.size() - 1) {
                bw.write("\n");
            }
        }
        bw.close();
        fileWriter.close();
    }


    public void removeByPhoneNumber(String phoneNumber) {
        int index = findByPhoneNumber(phoneNumber);
        persons.remove(index);
    }

    public void updateByPhoneNumber(String phoneNumber, Person person) {
        int index = findByPhoneNumber(phoneNumber);
        persons.set(index, person);
    }

    public void addNewPerson(Person person) {
        persons.add(person);
    }

    public void showAll() {
        if (persons.isEmpty()) {
            System.out.println("Không có ai trong danh bạ.");
        }
        int count = 0;
        for (Person person : persons) {
            System.out.println(person);
            count++;
            if (count == 5) {
                count = 0;
                sc.nextLine();
            }
        }
    }
    public int findByName(String name) {
        int index = -1;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findByPhoneNumber(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getPhoneNumber().equals(phoneNumber)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
