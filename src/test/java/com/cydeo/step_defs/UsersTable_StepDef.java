package com.cydeo.step_defs;

import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class UsersTable_StepDef {
    String idCountTotal, idCountDistinct;
    List<String> actualAllColumns;

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DB_Util.runQuery("select count(id) from users");
        idCountTotal = DB_Util.getFirstRowFirstColumn();

        DB_Util.runQuery("select distinct count(id) from users;");
        idCountDistinct = DB_Util.getFirstRowFirstColumn();
    }
    @Then("verify all users has a unique ID")
    public void verify_all_users_has_a_unique_id() {
        Assert.assertEquals(idCountDistinct, idCountTotal);
    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery("select *from users");
        actualAllColumns = DB_Util.getAllColumnNamesAsList();
    }
    @Then("verify the below columns are listed in the result")
    public void verify_the_below_columns_are_listed_in_the_result(List<String> expectedAllColumns) {
       Assert.assertEquals(expectedAllColumns,actualAllColumns);
    }

}
