package com.cydeo.step_defs;

import com.cydeo.pages.BookPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigurationReader;
import com.cydeo.utility.DB_Util;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import java.util.List;

public class BookStepDefs {
    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    //us3
    @Given("I login as a {string}")
    public void i_login_as_a(String userType) {
        loginPage.login(userType);
    }

    @When("I navigate to {string} page")
    public void i_navigate_to_page(String module) {
        BrowserUtil.waitForVisibility(bookPage.books,10);
        bookPage.navigateModule(module);
    }

    List<String> allBookCategoriesUI;

    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        BrowserUtil.waitForVisibility(bookPage.pageHeader,10);
        allBookCategoriesUI = bookPage.getAllBookCategoriesText();
    }

    List<String> allBookCategoriesDB;

    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        DB_Util.runQuery("select name from book_categories");
        allBookCategoriesDB = DB_Util.getColumnDataAsList(1);
    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        Assertions.assertEquals(allBookCategoriesDB, allBookCategoriesUI);
    }
}
