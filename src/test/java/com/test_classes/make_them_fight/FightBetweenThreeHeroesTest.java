package com.test_classes.make_them_fight;

import activities.test_data_helper.TestDataProviders;
import core.api.APIBase;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static activities.constant_details.ListOfHeroesConstants.getHeaderDetails;

public class FightBetweenThreeHeroesTest {
    Logger logger= Logger.getLogger(FightBetweenThreeHeroesTest.class);
    ResponseBody responseObject = null;

    @Test(description = "Creating and verifying able to make the hero fight (or) not : ",
            dataProvider = "startFightWith3HeroesData",
            dataProviderClass = TestDataProviders.class,
            priority = 9,
            enabled = true,
            alwaysRun = true)
    public void api_09_VerifyMakeHeroFight(String runMode, String scenario, int expectedResponseCode, String message) {
        if (runMode.equalsIgnoreCase("Y") || scenario.toLowerCase().contains("positive")) {
            APIBase apiBase = new APIBase("constant_details.MakeThemFightConstants");
            logger.info("Test scenario : " + scenario);

            responseObject = apiBase
                    .getRequest()
                    .setHeader(getHeaderDetails)
                    .returnPostApiResp();
            logger.info(responseObject.asString());

            int statusCode = ((Response) responseObject).getStatusCode();
            Assert.assertEquals(statusCode, expectedResponseCode, "Assertion Fail ::: Status code is not displayed as expected");
        } else {
            logger.info(responseObject.asString());
            Assert.assertTrue(((Response) responseObject).getBody().asString().toLowerCase().contains(message),
                    "Error message is incorrect <<<<" + message + ">>>>");
            logger.info("*************** All Assertion Passed ***************");
        }
        logger.info("*************** Test Executed Successfully ***************");
    }
}
