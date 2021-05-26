
package com.appers.myretrofitapicall.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomResponse {

    @SerializedName("results")
    @Expose
    private List<Users> results = null;
    @SerializedName("info")
    @Expose
    private Info info;

    public List<Users> getResults() {
        return results;
    }

    public void setResults(List<Users> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
