package com.test_classes;

import activities.test_data_helper.TestDataProviders;
import core.api.APIBase;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static activities.constant_details.ListOfHeroesConstants.getHeaderDetails;

public class ResetTheFightTest {
    Logger logger= Logger.getLogger(ResetTheFightTest.class);
    ResponseBody responseObject = null;

    @Test(description = "Deleting and verifying hero fight data is deleted : ",
            dataProvider = "deletedFightData",
            dataProviderClass = TestDataProviders.class,
            priority = 10,
            enabled = true,
            alwaysRun = true)
    public void api_10_VerifyResetFight(String runMode, String scenario, int expectedResponseCode, String message) {
        if (runMode.equalsIgnoreCase("Y") || scenario.toLowerCase().contains("positive")) {
            APIBase apiBase = new APIBase("constant_details.ResetTheFightConstants");
            logger.info("Test scenario : " + scenario);

            responseObject = apiBase
                    .getRequest()
                    .setHeader(getHeaderDetails)
                    .returnDeleteApiResp();
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
