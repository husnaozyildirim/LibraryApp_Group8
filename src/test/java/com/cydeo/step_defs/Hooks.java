package com.cydeo.step_defs;

import com.cydeo.utility.ConfigurationReader;
import com.cydeo.utility.DB_Util;
import com.cydeo.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }

    @Before ("@db")
    public void setupDB(){
        DB_Util.createConnection();
    }
    @After ("@db")
    public void destroyDB(){
        DB_Util.destroy();
    }
}
