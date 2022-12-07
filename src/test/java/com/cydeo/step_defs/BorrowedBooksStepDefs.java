package com.cydeo.step_defs;

import com.cydeo.pages.BorrowedBooksPage;
import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BorrowedBooksStepDefs {
    String actualBorrowedBookNumbers;
    LoginPage loginPage = new LoginPage();
    BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();
    DashBoardPage dashBoardPage = new DashBoardPage();



    @Given("user login as a {string}")
    public void user_login_as_a_librarian(String userType) {


        loginPage.login(userType);
    }
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        BrowserUtil.waitFor(3);


      actualBorrowedBookNumbers =dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBookNumbers = " + actualBorrowedBookNumbers);


    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

       DB_Util.runQuery("select count(*) as borrowedBooks from users u\n" +
               "                                          inner join book_borrow b on u.id = b.user_id where is_returned = 0");


        String expectedBorrowedBooks = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBorrowedBooks,actualBorrowedBookNumbers);





    }



}
