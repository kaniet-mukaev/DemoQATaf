package com.demoqa.pages.adidas.leftSideMenu;

import com.demoqa.drivers.DriverManager;
import com.demoqa.enams.Brands;
import com.demoqa.enams.Categories;
import com.demoqa.enams.SubCategories;
import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LeftSideMenu extends BasePage {

    public LeftSideMenu chooseBrand(Brands brand) {
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//a[text() ='"+brand.getName()+"']"));
        actions.click(element);
        return this;
    }

    public LeftSideMenu chooseCategory(Categories category, SubCategories subCategory) {
        try {
            WebElement elementCategory = DriverManager.getDriver().findElement(By.xpath("//a[@href='"+category.getDescription()+"']"));
            actions.click(elementCategory);
        } catch (EnumConstantNotPresentException e) {
            e.printStackTrace();
            System.out.println("No such category");
        }

        try {
            WebElement elementSubCategory = DriverManager.getDriver().findElement(By.xpath(
                    "//div[@id='"+category.getDescription().substring(1)+"']//a[normalize-space()='"+subCategory.getName()+"']"));
            actions.click(elementSubCategory);
        } catch (EnumConstantNotPresentException e) {
            e.printStackTrace();
            System.out.println("No such subCategory");
        }
        return this;
    }
}
