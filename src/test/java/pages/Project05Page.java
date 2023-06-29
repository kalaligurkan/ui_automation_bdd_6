package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;
import java.util.Map;

public class Project05Page {

    public Project05Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = ".is-size-2")
    public WebElement paginationHeading;

    @FindBy(css = "h2[id='sub_heading']")
    public WebElement populationHeading;

    @FindBy(id = "content")
    public WebElement paragraphText;

    @FindBy(id = "previous")
    public WebElement previousButton;

    @FindBy(id = "next")
    public WebElement nextButton;

    @FindBy(css = "div[class*=pagBody]>p")
    public List<WebElement> cityInfo;

    @FindBy(css = "img[class=city_image]")
    public WebElement cityImage;


}
