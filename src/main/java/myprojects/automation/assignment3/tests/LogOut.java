package myprojects.automation.assignment3.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by user on 10/4/17.
 */
/**
 * Created by user on 9/25/17.
 */
public class LogOut extends PageObject {

    @CacheLookup
    @FindBy(xpath=".//*[@id='employee_infos']/a/span/img")
    private WebElement logOutIcon;

    @CacheLookup
    @FindBy(id="header_logout")
    private WebElement logOutBtn;

    private final Wait<WebDriver> wait= new WebDriverWait(driver, 5).withMessage("Element was not found");

    //Method for LogOut the site presta
    public LogOut(EventFiringWebDriver driver) {
        super(driver);
    }
    public void logOutOnPage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(this.logOutIcon));
            this.logOutIcon.click();
            if (!this.logOutBtn.isDisplayed()) {

                System.out.println("Can not find the logout button");
            }
            wait.until(ExpectedConditions.visibilityOf(this.logOutBtn));
            this.logOutBtn.click();
            System.out.println("Logout is successful");
        } catch (UnsupportedOperationException ue) {
            ue.printStackTrace();
            System.out.println("Doesn't logOut from the admin panel");
        }
    }
}