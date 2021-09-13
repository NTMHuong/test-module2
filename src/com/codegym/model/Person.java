package com.codegym.model;

public class Person {
    private String group;
    private String phoneNumber;
    private String name;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String email;

    public Person() {
    }

    public Person(String group, String phoneNumber, String name, String gender, String address, String dateOfBirth, String email) {
        this.group = group;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public boolean setGroup(String group) {
        if(!group.equals("")) {
            this.group = group;
            return true;
        } else {
            System.out.println("Nhập lỗi! Không được để trống");
            return false;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10 && !phoneNumber.equals("")) {
            this.phoneNumber = phoneNumber;
            return true;
        } else {
            System.out.println("Nhập lỗi! Số điện thoại gồm 10 số(0-9)");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (!name.equals("")) {
            this.name = name;
            return true;
        } else {
            System.out.println("Nhập lỗi! Không được để trống");
            return false;
        }
    }

    public String getGender() {
        return gender;
    }

    public boolean setGender(String gender) {
        if (gender.equalsIgnoreCase("nam") || gender.equalsIgnoreCase("nu")) {
            this.gender = gender;
            return true;
        } else {
            System.out.println("Nhập lỗi! Không được để trống và nhập nam/ nu");
            return false;
        }
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        if (!address.equals("")) {
            this.address = address;
            return true;
        } else {
            System.out.println("Nhập lỗi! Không được để trống");
            return false;
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean setDateOfBirth(String dateOfBirth) {
        if (!dateOfBirth.equals("")) {
            this.dateOfBirth = dateOfBirth;
            return true;
        } else {
            System.out.println("Nhập lỗi! Không được để trống");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (!email.equals("") && email.contains("@") && !email.contains(" ")) {
            this.email = email;
            return true;
        } else {
            System.out.println("Nhập lỗi! Không được để trống");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "group='" + group + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
