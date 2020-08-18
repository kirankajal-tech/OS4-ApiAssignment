package com.e2e_flow;

import activities.constant_details.AddHeroToFightConstants;
import activities.constant_details.GetOneHeroConstants;
import com.test_classes.ListOfHeroesTest;
import core.api.APIBase;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static activities.constant_details.ListOfHeroesConstants.getHeaderDetails;

public class O4SEndToEndApiFlow {
    Logger logger= Logger.getLogger(ListOfHeroesTest.class);
    APIBase apiBase;

    @Test(description = "Verifying List of all Heroes are getting displayed as expected (or) not : ",
            priority = 01,
            enabled = true,
            alwaysRun = true)
    public void verifyingEndToEndFlowTest() {
        apiBase = new APIBase("constant_details.ListOfHeroesConstants");
        Object listOfHeroesResponse1 = apiBase
                .getRequest()
                .setHeader(getHeaderDetails)
                .returnParamsFromResp("id[0]");
        String heroId1 = listOfHeroesResponse1.toString();
        logger.info("Fetching 1st Hero Id : " + heroId1);

        Object listOfHeroesResponse2 = apiBase
                .getRequest()
                .setHeader(getHeaderDetails)
                .returnParamsFromResp("id[1]");
        String heroId2 = listOfHeroesResponse2.toString();
        logger.info("Fetching 2nd Hero Id : " + heroId2);

        apiBase = new APIBase("constant_details.GetOneHeroConstants");
        logger.info("Passing the \"heroId1\" for fetching the given Hero response");
        Object getOneHeroResponse1 = apiBase
                .getRequest()
                .setHeader(getHeaderDetails)
                .setPathParam(GetOneHeroConstants.getPathParameter(heroId1))
                .returnGetApiResp();

        apiBase = new APIBase("constant_details.AddHeroToFightConstants");
        logger.info("Adding \"heroId1\" to fight");
        Object addHeroToFightResponse1 = apiBase
                .getRequest()
                .setHeader(getHeaderDetails)
                .setBody(AddHeroToFightConstants.getBody(heroId1))
                .returnPostApiResp();

        apiBase = new APIBase("constant_details.GetOneHeroConstants");
        logger.info("Passing the \"heroId2\" for fetching the given Hero response");
        Object getOneHeroResponse2 = apiBase
                .getRequest()
                .setHeader(getHeaderDetails)
                .setPathParam(GetOneHeroConstants.getPathParameter(heroId2))
                .returnGetApiResp();

        apiBase = new APIBase("constant_details.AddHeroToFightConstants");
        logger.info("Adding \"heroId2\" to fight");
        Object addHeroToFightResponse2 = apiBase
                .getRequest()
                .setHeader(getHeaderDetails)
                .setBody(AddHeroToFightConstants.getBody(heroId2))
                .returnPostApiResp();

        apiBase = new APIBase("constant_details.MakeThemFightConstants");
        logger.info("Making them fight");
        Object makeThemFightResponse = apiBase
                .getRequest()
                .setHeader(getHeaderDetails)
                .returnPostApiResp();

        apiBase = new APIBase("constant_details.ResetTheFightConstants");
        logger.info("Resetting the fight result");
        Object resetTheFightResponse = apiBase
                .getRequest()
                .setHeader(getHeaderDetails)
                .returnDeleteApiResp();
        int resetTheFightStatusCode = ((Response) resetTheFightResponse).getStatusCode();
        Assert.assertEquals(resetTheFightStatusCode, HttpStatus.SC_OK, "Assertion Fail ::: Status code is not displayed as expected");
    }
}
