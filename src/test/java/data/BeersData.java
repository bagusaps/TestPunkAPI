package data;

import io.restassured.response.ResponseBody;

public class BeersData {

    private int page;
    private int perPage;
    private ResponseBody responseBody;


    public void setPage(int page){
        this.page = page;
    }

    public Integer getPage(){
        return page;
    }

    public void setPerPage(int perPage){
        this.perPage = perPage;
    }

    public Integer getPerPage(){
        return perPage;
    }

    public void setResponseBody(ResponseBody responseBody){
        this.responseBody = responseBody;
    }

    public ResponseBody getResponseBody(){
        return responseBody;
    }
}
