package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelPage {

   public HotelPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement ılkLoginButonu;

    @FindBy(xpath = "//input[@class='form-control required']")
    public WebElement username;

    @FindBy(xpath = "//input[@class='form-control required password']")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement ikinciLoginButonu;

    @FindBy(xpath = "//a[@class='btn btn-circle btn-default']")
    public WebElement addUser;







    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement createUsername;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement createPassword;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement createEmail;

    @FindBy(xpath = "//input[@id='NameSurname']")
    public WebElement createFullName;

    @FindBy(xpath = "//input[@id='PhoneNo']")
    public WebElement createPhoneNumber;

    @FindBy(xpath = "//input[@name='SSN']")
    public WebElement ssNumber;

    @FindBy(xpath = "//input[@id='DrivingLicense']")
    public WebElement drivingLicense;

    @FindBy()
    public WebElement country;

    @FindBy
    public WebElement state;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement address;

    @FindBy(xpath = "//input[@placeholder='Date of Birth']")
    public WebElement dateOfBirth;

    @FindBy(xpath = "//input[@id='WorkingSector']")
    public WebElement workingSector;

    @FindBy(xpath = "")
    public WebElement selectRole;


















}
