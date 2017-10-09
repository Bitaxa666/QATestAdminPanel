package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CreateCategoryTest extends BaseScript {
    private static final String OKEY = "Создано";
    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
         //WebDriver driver = getConfiguredDriver();
        EventFiringWebDriver driver = getConfiguredDriver();
        try {
            driver.get(Properties.getBaseAdminUrl());

            SignUpPage signUpPage = new SignUpPage(driver);
            signUpPage.enterName(Properties.getAdminEmail(), Properties.getAdminPWD());
            signUpPage.submitBtn();

//            CatalogItem catalog = new CatalogItem(driver);
//            catalog.markCatalogItem();
//            catalog.addCategoryClickBtn();
//            catalog.addNewCategoryName(Properties.getCategoryName());
//            catalog.successfulAddCategory(CreateCategoryTest.OKEY);
//            catalog.filterName();
//            catalog.findYourCategory(Properties.getCategoryName());

            LogOut logOutSite = new LogOut(driver);
            logOutSite.logOutOnPage();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Script have a problem");
        }finally {
            quitDriver(driver);
        }
    }
}
