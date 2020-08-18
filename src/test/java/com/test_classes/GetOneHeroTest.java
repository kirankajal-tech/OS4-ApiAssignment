package com.test_classes;

import activities.constant_details.GetOneHeroConstants;
import activities.test_data_helper.TestDataProviders;
import core.api.APIBase;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static activities.constant_details.ListOfHeroesConstants.getHeaderDetails;

public class GetOneHeroTest {
    Logger logger= Logger.getLogger("GetOneHeroTest");
    Response responseObject = null;

    @Test(description = "Verifying for existing Hero's details is displayed as expected (or) not : ",
            dataProvider = "getOneHeroData",
            dataProviderClass = TestDataProviders.class,
            priority = 02,
            enabled = true,
            alwaysRun = true)
    public void api_02_VerifyOneHeroDetails(String runMode, String scenario, String heroId, int expectedResponseCode, String message) {
        if(runMode.equalsIgnoreCase("Y") || scenario.toLowerCase().contains("positive")) {
            APIBase apiBase = new APIBase("constant_details.GetOneHeroConstants");

            logger.info("Test scenario : " + scenario);

            responseObject = apiBase
                    .getRequest()
                    .setHeader(getHeaderDetails)
                    .setPathParam(GetOneHeroConstants.getPathParameter(heroId))
                    .returnGetApiResp();

            logger.info(responseObject.asString());

            Object responseStatusCode = apiBase.getRequest().returnGetApiRespCode();
            Assert.assertEquals(responseStatusCode, expectedResponseCode, "Assertion Fail ::: Status code is not displayed as expected");
        } else {
            logger.info(responseObject.asString());
            Assert.assertTrue(((Response)responseObject).getBody().asString().toLowerCase().contains(message),
                    "Error message is incorrect <<<<" + message + ">>>>");
            logger.info("*************** All Assertion Passed ***************");
        }
        logger.info("*************** Test Executed Successfully ***************");
    }
}
