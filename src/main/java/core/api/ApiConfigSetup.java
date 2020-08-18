/*
        Written & Developed by KAJAL Kiran
*/
package core.api;

import io.restassured.authentication.OAuthSignature;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class ApiConfigSetup <T extends ApiConfigSetup<?>> {
    HashMap<String,String> header;
    HashMap<String,String> param;
    RequestSpecification requestSpecification;
    protected final T self;

    protected ApiConfigSetup(final Class<T> selfClass){
        this.self = selfClass.cast(this);
        requestSpecification = given();
    }

    public ApiConfigSetup setAuth(String authId, String token){
        requestSpecification = given().auth().basic(authId, token);
        return self;
    }

    public ApiConfigSetup setAuth(String token){
        requestSpecification = given().auth().oauth2(token, OAuthSignature.QUERY_STRING);
        return self;
    }

    public T setHeader(String s){
        header = new HashMap<String, String>();
        String[] h = s.split(",");
        for(int i=0;i<h.length;i++){
            String[] hl = h[i].split(":");
            header.put(hl[0], hl[1]);
        }
        for(String a:header.keySet()){
            System.out.println(a+" "+header.get(a));
        }
        requestSpecification.headers(header);
        return self;
    }

    public T setEndPoint(String uri){
        requestSpecification.baseUri(uri);
        return self;
    }

    public T setBasePath(String path){
        requestSpecification.basePath(path);
        return self;
    }

    public T setBody(String body){
        requestSpecification.body(body);
        return self;
    }

    public T setPathParam(String s){
        param = new HashMap<String, String>();
        String[] p = s.split(",");
        for(int i=0;i<p.length;i++){
            String[] pp = p[i].split(":");
            param.put(pp[0], pp[1]);
        }
        for(String a:param.keySet()){
            System.out.println(a+" "+param.get(a));
        }
        requestSpecification.pathParams(param);
        return self;
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }
}