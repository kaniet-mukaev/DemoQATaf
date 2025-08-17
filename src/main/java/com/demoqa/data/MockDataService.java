package com.demoqa.data;

import com.github.javafaker.Faker;

import java.util.Random;

public class MockDataService {

    Faker faker = new Faker();

    public String generateRandomFirstName() {
        return faker.name().firstName();
    }

    public String generateRandomLastName() {
        return faker.name().lastName();
    }

    public String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String generateRandomUsername() {return faker.name().username();}

    public String generateRandomPassword() {return faker.internet().password(8, 15);}

    public String generateRandomAge() {
        return String.valueOf(faker.random().nextInt(18, 65));
    }

    public String generateRandomSalary() {
        int salary = faker.number().numberBetween(10, 81) * 100;
        return String.valueOf(salary);
    }

    public String generateRandomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public String generateRandomAddress() {
        return faker.address().fullAddress();
    }

    public String generateKyrgyzPhoneNumber() {
        String[] codes = { "700", "701", "702", "703", "704", "705", "706", "707", "708", "709",
                           "500", "501", "502", "503", "504", "505", "506", "507", "508", "509",
                           "550", "551", "552", "553", "554", "555", "556", "557", "558", "559",
                           "990", "991", "992", "993", "994", "995", "996", "997", "998", "999",
                           "770", "771", "772", "773", "774", "775", "776", "777", "778", "779",
        };
        String code = codes[new Random().nextInt(codes.length)];
        String numberBody = faker.numerify("######");
        return "0" + code + numberBody;
    }

    public String generateDepartment() {
        String[] departments = {
                "Human Resources", "Finance", "Marketing", "Sales", "Customer Service", "IT","Research and Development",
                "Logistics", "Legal", "Procurement", "Administration", "Engineering", "Operations", "Quality Assurance",
                "Business Development", "Security", "Public Relations", "Product Management", "Training", "Accounting"
        };
        return departments[new Random().nextInt(departments.length)];
    }

    public String generateRandomCompany() {
        return String.valueOf(faker.company());
    }

    public String generateRandomState() {
        return String.valueOf(faker.address().state());
    }

    public String generateRandomCity() {
        return String.valueOf(faker.address().city());
    }

    public String generateRandomCountry() {
        return String.valueOf(faker.address().country());
    }

    public String generateRandomZipcode() {
        return String.valueOf(faker.address().zipCode());
    }

    public String generateRandomSubject() {
        return String.valueOf(faker.ancient());
    }

}
