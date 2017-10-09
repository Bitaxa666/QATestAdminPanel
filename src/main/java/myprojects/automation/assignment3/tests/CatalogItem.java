package myprojects.automation.assignment3.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by user on 10/4/17.
 */
public class CatalogItem extends PageObject {

    @CacheLookup
    @FindBy(id="subtab-AdminCatalog")
    private WebElement catalog;

    @CacheLookup
    //@FindBy(css = "a[title='Добавить категорию']")
    @FindBy(css = ".process-icon-new")
    private WebElement newCategory;

    @CacheLookup
    @FindBy(xpath=".//*[@id='employee_infos']/a/span/img")
    private WebElement logOutIcon;

    @CacheLookup
    @FindBy (id = "name_1")
    private WebElement inputNameCategory;

    @CacheLookup
    @FindBy (id = "category_form_submit_btn")
    private WebElement addBtnCategory;

    @CacheLookup
    //@FindBy (css = "button[data-dismiss='alert']")
    @FindBy (xpath = ".//*[@id='content']/div[3]/div")
    private WebElement successfulMessage;

    @CacheLookup
    @FindBy (css = "#table-category td:nth-child(3)")
    private WebElement yourCategory;

    @CacheLookup
    @FindBy (xpath = ".//*[@id='table-category']/thead/tr[1]/th[3]/span/a[1]/i")
    private WebElement filterName;

    WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).withMessage("Element was not found");


    public CatalogItem(EventFiringWebDriver driver) {
        super(driver);
    }
    public void markCatalogItem(){
        try{
            waitTheElement(driver, logOutIcon,10);

            Actions actions = new Actions(driver);
            actions.moveToElement(catalog).build().perform();

            catalog.findElements(By.cssSelector("li")).get(1).click();
        }catch(TimeoutException ignore) {
            ignore.printStackTrace();
            System.out.println("Mark Catalog Item not run");
        }
    }
    public void addCategoryClickBtn(){

        waitTheElement(driver, logOutIcon,10);
        this.newCategory.click();
    }
    public void addNewCategoryName(String catName){

        waitTheElement(driver, logOutIcon,10);

        this.inputNameCategory.clear();
        this.inputNameCategory.sendKeys(catName);

        this.addBtnCategory.click();
    }
    public void successfulAddCategory(String successful){

        waitTheElement(driver, successfulMessage,10);

        //System.out.println(successfulMessage.getText().substring(2, 9));
        Assert.assertEquals(successful, successfulMessage.getText().substring(2, 9));
    }

    public void filterName(){

        waitTheElement(driver, successfulMessage,10);

        this.filterName.click();
    }

    public void findYourCategory(String yourCateg){

        waitTheElement(driver, yourCategory,10);

        //System.out.println(yourCategory.getText());
        Assert.assertEquals(yourCateg, yourCategory.getText());
    }

    public void waitTheElement(EventFiringWebDriver driver, WebElement element, int timeSec){
        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        wait.until(ExpectedConditions. elementToBeClickable(element));
    }

}
