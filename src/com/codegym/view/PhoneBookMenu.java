package com.codegym.view;

import com.codegym.model.Person;
import com.codegym.controller.PhoneBookManagement;

import java.io.IOException;
import java.util.Scanner;

public class PhoneBookMenu {
    public static Scanner sc = new Scanner(System.in);
    public static PhoneBookManagement phoneBookManagement = new PhoneBookManagement();
    static {
        phoneBookManagement.addNewPerson(new Person("Nhóm 1", "0123456789", "Huong", "Nu", "Ninh Bình", "06/01/2000", "abcxyz@gmail.com"));
        phoneBookManagement.addNewPerson(new Person("Nhóm 2", "0123452789", "Huong1", "nam", "Ninh Bình", "06/01/2000", "abcxyz@gmail.com"));
        phoneBookManagement.addNewPerson(new Person("Nhóm 1", "0123416789", "Huong2", "nu", "Ninh Bình", "06/01/2000", "abcxyz@gmail.com"));
        phoneBookManagement.addNewPerson(new Person("Nhóm 3", "0129456789", "Huong3", "Nu", "Ninh Bình", "06/01/2000", "abcxyz@gmail.com"));

    }

    public void run() {
        int choice;
        do {
            menu();
            System.out.println("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    displayPhoneBook();
                    break;
                }
                case 2: {
                    addNewPerson();
                    break;
                }
                case 3: {
                    updatePerson();
                    break;
                }
                case 4: {
                    removePerson();
                    break;
                }
                case 5: {
                    findPerson();
                    break;
                }
                case 6: {
                    readFile();
                    break;
                }
                case 7: {
                    writeFile();
                    break;
                }
                case 0: {
                    System.out.println("GoodBye!");
                    break;
                }
                default: {
                    System.out.println("Nhập sai rồi! Chạy lại nhé");
                    break;
                }
            }
        }
        while (choice != 0);
    }

    private void findPerson() {
        System.out.print("Nhập vào số điện thoại hoặc họ tên để tìm kiếm trong danh bạ: ");
        String check = sc.nextLine();
        int indexNumberPhone = phoneBookManagement.findByPhoneNumber(check);
        int indexName = phoneBookManagement.findByName(check);

        if(indexName != -1) {
            System.out.println("liên hệ mà bạn cần tìm");
            System.out.println(phoneBookManagement.getPersons().get(indexName));
        } else if (indexNumberPhone != -1) {
            System.out.println("liên hệ mà bạn cần tìm");
            System.out.println(phoneBookManagement.getPersons().get(indexNumberPhone));
        } else {
            System.out.println("Không tìm thấy liên hệ nào phù hợp");
        }
    }

    private void writeFile() {
        try {
            phoneBookManagement.writePersonToFile("data/products.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        try {
            phoneBookManagement.readPersonToFile("data/products.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void removePerson() {
        System.out.println("-----------------------------------------");
        System.out.println("Nhập số điện thoại người cần xóa: ");
        String phoneNumber = sc.nextLine();
        int index = phoneBookManagement.findByPhoneNumber(phoneNumber);
        if (index != -1) {
            System.out.println(phoneBookManagement.getPersons().get(index));
            System.out.println("Bạn có muốn xóa SĐT của người này không?");
            System.out.println("Nhập Y để xóa, nhập kí tự bất kỳ để thoát");
            String input = sc.nextLine();
            if (input.equals("Y")) {
                phoneBookManagement.removeByPhoneNumber(phoneNumber);
            }
            return;
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            removePerson();
        }
    }


    private void updatePerson() {
        System.out.println("-----------------------------------------");
        System.out.println("Nhập số điện thoại người cần sửa: ");
        String phoneNumber = sc.nextLine();
        int index = phoneBookManagement.findByPhoneNumber(phoneNumber);
        if (index != -1) {
            Person person = inputPerson();
            phoneBookManagement.updateByPhoneNumber(phoneNumber, person);
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            System.out.println("Vui lòng nhập lại: ");
            updatePerson();
            if (phoneNumber.equals("")) {
                return;
            }
        }

    }

    private void displayPhoneBook() {
        phoneBookManagement.showAll();
    }

    private void addNewPerson() {
        int n;
        System.out.println("Nhập số người bạn muốn thêm: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Person person = inputPersonFromKeyBoard();
            phoneBookManagement.addNewPerson(person);
        }
    }
    private Person inputPerson() {
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        System.out.println("-------------------------");

        System.out.println("Nhập nhóm danh bạ:");
        while (!person.setGroup(sc.nextLine())) ;

        System.out.println("Nhập tên:");
        while (!person.setName(sc.nextLine())) ;

        System.out.println("Nhập giới tính:");
        while (!person.setGender(sc.nextLine())) ;

        System.out.println("Nhập địa chỉ:");
        while (!person.setAddress(sc.nextLine()));

        System.out.println("Nhập ngày tháng năm sinh:");
        while (!person.setDateOfBirth(sc.nextLine())) ;

        System.out.println("Nhập email:");
        while (!person.setEmail(sc.nextLine())) ;

        return person;
    }


    private Person inputPersonFromKeyBoard() {
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        System.out.println("-------------------------");

        System.out.println("Nhập nhóm danh bạ:");
        while (!person.setGroup(sc.nextLine())) ;

        System.out.println("Nhập số điện thoại:");
        while (!person.setPhoneNumber(sc.nextLine()));

        System.out.println("Nhập tên:");
        while (!person.setName(sc.nextLine())) ;

        System.out.println("Nhập giới tính:");
        while (!person.setGender(sc.nextLine())) ;

        System.out.println("Nhập địa chỉ:");
        while (!person.setAddress(sc.nextLine()));

        System.out.println("Nhập ngày tháng năm sinh:");
        while (!person.setDateOfBirth(sc.nextLine())) ;

        System.out.println("Nhập email:");
        while (!person.setEmail(sc.nextLine())) ;

        return person;
    }

    private void menu() {
        System.out.println("------CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ--------");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi từ file");
        System.out.println("0. Thoát");
    }
}
