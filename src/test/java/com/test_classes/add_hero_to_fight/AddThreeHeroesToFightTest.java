package com.test_classes.add_hero_to_fight;

import activities.constant_details.AddHeroToFightConstants;
import activities.test_data_helper.TestDataProviders;
import core.api.APIBase;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static activities.constant_details.ListOfHeroesConstants.getHeaderDetails;

public class AddThreeHeroesToFightTest {
    Logger logger = Logger.getLogger(AddThreeHeroesToFightTest.class);
    ResponseBody responseObject = null;

    @Test(description = "Creating and verifying able to add three Heroes to fight : ",
            dataProvider = "add3HeroesToFightData",
            dataProviderClass = TestDataProviders.class,
            priority = 05,
            enabled = true,
            alwaysRun = true)
    public void api_05_VerifyAddingThreeHeroesToFight(String runMode, String scenario, String heroId, int expectedResponseCode, String message) {
        if (runMode.equalsIgnoreCase("Y") || scenario.toLowerCase().contains("positive")) {
            APIBase apiBase = new APIBase("constant_details.AddHeroToFightConstants");
            logger.info("Test scenario : " + scenario);

            responseObject = apiBase
                    .getRequest()
                    .setHeader(getHeaderDetails)
                    .setBody(AddHeroToFightConstants.getBody(heroId))
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
