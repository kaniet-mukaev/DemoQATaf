package com.demoqa.pages.elements;

import com.demoqa.entity.Employee;
import com.demoqa.pages.BasePage;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WebTablesPage extends BasePage {

    @Setter
    @Getter
    private List<Employee> listOfEmployees = new LinkedList<>();

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewRecordBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@class='rt-tbody']/div[contains(@class,'rt-tr-group')]")
    public List<WebElement> employeeRows;

    public void addNewEmployee() {
        actions.click(addNewRecordBtn);
        actions.type(firstNameInput, dataService.generateRandomFirstName())
                .type(lastNameInput, dataService.generateRandomLastName())
                .type(userEmailInput, dataService.generateRandomEmail())
                .type(ageInput, dataService.generateRandomAge())
                .type(salaryInput, dataService.generateRandomSalary())
                .type(departmentInput, dataService.generateDepartment())
                .click(submitBtn);
    }

    public List<Employee> getAllRecordsFromWebTable() {
        List<Employee> employeeList = new ArrayList<>();

        for (WebElement row : employeeRows) {
            List<WebElement> cells = row.findElements(By.className("rt-td"));

            if (cells.size() >= 6 && !cells.get(0).getText().trim().isEmpty()) {
                    Employee employee = Employee.builder()
                            .firstName(cells.get(0).getText().trim())
                            .lastName(cells.get(1).getText().trim())
                            .age(Integer.parseInt(cells.get(2).getText().trim()))
                            .email(cells.get(3).getText().trim())
                            .salary(Integer.parseInt(cells.get(4).getText().trim()))
                            .department(cells.get(5).getText().trim())
                            .build();
                    employeeList.add(employee);
                    listOfEmployees.add(employee);
            }
        }
        return employeeList;
    }
}


