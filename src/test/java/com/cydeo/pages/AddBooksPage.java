package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddBooksPage extends BasePage {



    @FindBy (xpath ="//span[.='Books']" )
    public WebElement booksModule;




    @FindBy (xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")
    public WebElement addBooksButton;


    @FindBy (xpath = "//input[@placeholder='Book Name']")
    public WebElement enterBookName;


    @FindBy (xpath = "//input[@name='isbn']")
    public WebElement enterISBN;


    @FindBy (xpath = "//input[@name='year']")
    public WebElement enterYear;


    @FindBy (xpath = "//input[@name='author']")
    public WebElement enterAuthor;

    @FindBy (xpath = "//select[@id='book_group_id']")
    public WebElement chooseBookCategory;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChangesButton;

    @FindBy (xpath = "//input[@type='search']")
    public WebElement searchForVerification;


}
