package com.test_classes;

import core.api.APIBase;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static activities.constant_details.ListOfHeroesConstants.getHeaderDetails;

public class ListOfHeroesTest {
    Logger logger= Logger.getLogger(ListOfHeroesTest.class);

    @Test(description = "Verifying List of all Heroes are getting displayed as expected (or) not : ",
            priority = 01,
            enabled = true,
            alwaysRun = true)
    public void api_01_VerifyListOfHeroes() {
        APIBase apiBase = new APIBase("constant_details.ListOfHeroesConstants");

        Object responseObjects = apiBase
                .getRequest()
                .setHeader(getHeaderDetails)
                .returnGetApiResp()
                .asString();
        logger.info(responseObjects);

        Object responseStatusCode = apiBase.getRequest().returnGetApiRespCode();
        Assert.assertEquals(responseStatusCode, HttpStatus.SC_OK, "Assertion Fail ::: Status code is not displayed as expected");
    }
}