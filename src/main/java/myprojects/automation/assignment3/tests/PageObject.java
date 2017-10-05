package myprojects.automation.assignment3.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by user on 10/3/17.
 */
public class PageObject {
    protected EventFiringWebDriver driver;

    //Base Page class
    public PageObject(EventFiringWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
