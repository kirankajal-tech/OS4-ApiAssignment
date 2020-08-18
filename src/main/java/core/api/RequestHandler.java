/*
        Written & Developed by KAJAL Kiran
*/
package core.api;

import io.restassured.response.Response;

public class RequestHandler extends ApiConfigSetup<RequestHandler>{
    private static Response response;
    private static Object parameter;
    private static int statusCode;

    public RequestHandler(){
        super(RequestHandler.class);
    }

    public Response returnGetApiResp() {
        System.out.println("Hitting api");
        try {
            response = requestSpecification
                    .when()
                    .get()
                    .then()
                    .extract()
                    .response();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public int returnGetApiRespCode() {
        System.out.println("Hitting api");
        try {
            statusCode = requestSpecification
                    .when()
                    .get()
                    .getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public Response returnPostApiResp() {
        System.out.println("Hitting api");
        try {
            response = requestSpecification
                    .when()
                    .post()
                    .then()
                    .extract()
                    .response();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public int returnPostApiRespCode() {
        System.out.println("Hitting api");
        try {
            statusCode = requestSpecification
                    .when()
                    .post()
                    .getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public Response returnDeleteApiResp() {
        System.out.println("Hitting api");
        try {
            response = requestSpecification
                    .relaxedHTTPSValidation()
                    .when()
                    .delete()
                    .then()
                    .extract()
                    .response();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public int returnDeleteApiRespCode() {
        System.out.println("Hitting api");
        try {
            statusCode = requestSpecification
                    .when()
                    .put()
                    .getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public Object returnParamsFromResp(String extractedPath) {
        System.out.println("Hitting api");
        try {
            parameter = requestSpecification
                    .when()
                    .get()
                    .then()
                    .extract()
                    .path(extractedPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parameter;
    }
}