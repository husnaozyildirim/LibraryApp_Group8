package com.cydeo.step_defs;

import com.cydeo.pages.AddBooksPage;
import com.cydeo.pages.BasePage;
import com.cydeo.pages.BookPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import com.cydeo.utility.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;

public class US6StepDefs {


    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    AddBooksPage addBooksPage = new AddBooksPage();



    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {

        loginPage.login("librarian");


    }

    @Given("I navigate to Books page")
    public void i_navigate_to_Books_page() {

        BrowserUtil.waitForVisibility(bookPage.books,10);

    }



    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {

        addBooksPage.addBooksButton.click();

    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {


        addBooksPage.enterBookName.sendKeys(bookName);

    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String ISBN) {

        addBooksPage.enterISBN.sendKeys(ISBN);

    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {

        addBooksPage.enterYear.sendKeys(year);

    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {

        addBooksPage.enterAuthor.sendKeys(author);

    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String bookCategory) {

        Select select = new Select(addBooksPage.chooseBookCategory);
        select.selectByVisibleText(bookCategory);

    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {

        addBooksPage.saveChangesButton.click();

    }
    @Then("the librarian verify new book by {string}")
    public void the_librarian_verify_new_book_by(String bookName) {

        addBooksPage.searchForVerification.sendKeys(bookName);

    }

    @Then("the librarian verify new book from database by {string}")
    public void the_librarian_verify_new_book_from_database_by(String string) {

        String newBooks;
        DB_Util.runQuery("select id,name,author from books\n" +
                "where name = 'Clean Code' and author='Robert C.Martin'\n" +
                "order by id desc");
        newBooks = DB_Util.getCellValue(1, "name");







    }


}
