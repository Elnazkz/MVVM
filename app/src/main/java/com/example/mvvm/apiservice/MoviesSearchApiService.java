package com.example.mvvm.apiservice;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mvvm.model.SearchResult;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoviesSearchApiService {
    private final Context context;

    public MoviesSearchApiService(Context context){
        this.context = context;
    }

    public interface OnSearchResultReceived {
        void onReceived(List<SearchResult> searchResultList);
    }

    public void getSearchInfo(OnSearchResultReceived onSearchResultReceived, String searchWord){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://tastedive.com/api/similar?q="+searchWord+"&type=movie&info=1&k=407880-MVVM-K7UACRAF",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                onSearchResultReceived.onReceived(parseSearchResult(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Check your Connection", Toast.LENGTH_LONG).show();
                onSearchResultReceived.onReceived(null);
            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(8000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(jsonObjectRequest);
    }

    public List<SearchResult> parseSearchResult(JSONObject response){
        List<SearchResult> searchResultList = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        try {
            JSONObject mainJsonObject = response.getJSONObject("Similar");
            Iterator<String> iter = mainJsonObject.keys();
            //String key = (String) iter.next();
            while(iter.hasNext()) {
                String key = (String) iter.next();
                if(key.equals("Info")) {
                    SearchResult searchResult = new SearchResult();
                    //the correct result
                    JSONObject mainResult = mainJsonObject.getJSONArray("Info").getJSONObject(0);
                    searchResult.setTitle(mainResult.getString("Name"));
                    searchResult.setType(mainResult.getString("Type"));
                    searchResult.setDescription(mainResult.getString("wTeaser"));
                    searchResult.setYoutubeUrl(mainResult.getString("yUrl"));
                    searchResultList.add(searchResult);
                }else {
                    JSONArray otherResultsArray = mainJsonObject.getJSONArray("Results");
                    for (int i = 0; i < otherResultsArray.length() ; i++) {
                        SearchResult searchResult = new SearchResult();
                        JSONObject otherResult = otherResultsArray.getJSONObject(i);
                        searchResult.setTitle(otherResult.getString("Name"));
                        searchResult.setType(otherResult.getString("Type"));
                        searchResult.setDescription(otherResult.getString("wTeaser"));
                        searchResult.setYoutubeUrl(otherResult.getString("yUrl"));
                        searchResultList.add(searchResult);
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return searchResultList;
    }
}
