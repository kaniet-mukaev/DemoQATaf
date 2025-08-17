package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage {

    @FindBy(css = "button[title='Expand all']") // первая стрелочка-развернуть
    public WebElement unboxingAllButton;

    @FindBy(xpath = "//div[@class='react-checkbox-tree rct-icons-fa4']/descendant::button[3]") // первая стрелочка-развернуть
    public WebElement unboxingButtonOfHome;

    @FindBy(xpath = "//div[@class='react-checkbox-tree rct-icons-fa4']/descendant::button[4]") // вторая стрелочка-развернуть
    public WebElement unboxingButtonOfDesktop;

    @FindBy(xpath = "//div[@class='react-checkbox-tree rct-icons-fa4']/descendant::button[5]") // третья стрелочка-развернуть
    public WebElement unboxingButtonOfDocuments;

    @FindBy(xpath = "//div[@class='react-checkbox-tree rct-icons-fa4']/descendant::button[6]") // четвертая стрелочка-развернуть
    public WebElement unboxingButtonOfWorkSpace;

    @FindBy(xpath = "//div[@class='react-checkbox-tree rct-icons-fa4']/descendant::button[7]") // пятая стрелочка-развернуть
    public WebElement unboxingButtonOfOffice;

    @FindBy(xpath = "//div[@class='react-checkbox-tree rct-icons-fa4']/descendant::button[8]") // шестая стрелочка-развернуть
    public WebElement unboxingButtonOfDownloads;

    @FindBy(xpath = "//span[text()='Home']") // папка Home
    public WebElement home;

    @FindBy(xpath = "//span[text()='Desktop']")
    public WebElement desktop;

    @FindBy(xpath = "//span[text()='Notes']") // папка Notes
    public WebElement notes;

    @FindBy(xpath = "//span[text()='Commands']") // папка Commands
    public WebElement commands;

    @FindBy(xpath = "//span[text()='Documents']") // папка Documents
    public WebElement documents;

    @FindBy(xpath = "//span[text()='WorkSpace']") // папка WorkSpace
    public WebElement workSpace;

    @FindBy(xpath = "//span[text()='React']") // папка React
    public WebElement react;

    @FindBy(xpath = "//span[text()='Angular']") // папка Angular
    public WebElement angular;

    @FindBy(xpath = "//span[text()='Veu']") // папка Veu
    public WebElement veu;

    @FindBy(xpath = "//span[text()='Office']") // папка Office
    public WebElement office;

    @FindBy(xpath = "//span[text()='Public']") // папка Public
    public WebElement public_;

    @FindBy(xpath = "//span[text()='Private']") // папка Private
    public WebElement private_;

    @FindBy(xpath = "//span[text()='Classified']") // папка Classified
    public WebElement classified;

    @FindBy(xpath = "//span[text()='General']") // папка General
    public WebElement general;

    @FindBy(xpath = "//span[text()='Downloads']") // папка Downloads
    public WebElement downloads;

    @FindBy(xpath = "//span[text()='Word File.doc']") // папка Word File.doc
    public WebElement wordFile_doc;

    @FindBy(xpath = "//span[text()='Excel File.doc']") // папка Excel File.doc
    public WebElement excelFile_doc;

    @FindBy(id = "result") // поле вывода результата выборов
    public WebElement results;

    @FindBy(css = "button[title='Collapse all']")
    public WebElement collapseAllButton;
}
