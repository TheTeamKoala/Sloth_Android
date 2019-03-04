package com.koala.sloth.ServerConnection;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import static com.android.volley.Request.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServerConnectionForProduct {
    final String url = "https://slothweb.herokuapp.com/api/v1/customers";
    ArrayList<Product> products = new ArrayList<Product>();
    Product tmpProduct= new Product();
    RequestQueue queue ;

    public ServerConnectionForProduct(RequestQueue queue) {
        this.queue = queue;
    }

    public void add(RequestQueue queue,String type,String firstDate,Boolean bool,int price){
        JSONObject post = new JSONObject();
        try {
            post.accumulate("type",type);
            post.accumulate("firstDate",firstDate);
            post.accumulate("inTheFridge",bool);
            post.accumulate("fiyat",price);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjRequest = new JsonObjectRequest
                (Method.POST, url, post, new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.d("Response", response.toString());
                    }
                },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Log.d("Error.Response", String.valueOf(error));
                            }
                        });

        queue.add(jsonObjRequest);
    }
    public void returnById(RequestQueue queue , int id){
        String strId="/"+id+"";
        JsonObjectRequest getRequest = new JsonObjectRequest(Method.GET, url+strId, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        try {

                            String typr = (String) response.get("type");
                            Log.d("object",response.toString());
                            Log.d("AAAAAAA",response.length()+"");

                            try {
                                String type = (String) response.get("type");
                                tmpProduct.setType(type);
                                String date = (String)response.get("firstDate");
                                tmpProduct.setFirstDate(date);
                                Boolean bool = (Boolean) response.get("inTheFridge");
                                tmpProduct.setBool(bool);
                                int price = (Integer) response.get("fiyat");
                                tmpProduct.setPrice(price);
                            }
                            catch (Exception e){

                            }

                            Log.d("type",tmpProduct.type);
                            Log.d("firstDate",tmpProduct.firstDate);
                            Log.d("inTheFridge",tmpProduct.bool+"");
                            Log.d("fiyat",tmpProduct.price+"");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", String.valueOf(error));
                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);
    }

    public void delete(RequestQueue queue,int intId){
        String id= intId+"";
        JsonObjectRequest delRequest = new JsonObjectRequest(Method.DELETE, url + "/del/"+id, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        try {
                            Log.d("Successful", "delete");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", String.valueOf(error));
                    }
                }
        );

        queue.add(delRequest);
    }


    public void update(RequestQueue queue ,String type){
        JsonObjectRequest updRequest = new JsonObjectRequest(Method.DELETE, url + "/update/add/"+type, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        try {
                            Log.d("Successful", "delete");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", String.valueOf(error));
                    }
                }
        );

        queue.add(updRequest);
    }

    public void returnAllArray(RequestQueue queue){

        JsonArrayRequest getRequest = new JsonArrayRequest(Method.GET, url, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response", response.toString());
                        try {
                            JSONObject obj = (JSONObject) response.get(0);
                            String typr = (String) obj.get("type");
                            Log.d("object",obj.toString());
                            Log.d("AAAAAAA",response.length()+"");

                            for(int i=0 ; i<response.length();i++){
                                JSONObject object = (JSONObject) response.get(i);
                                Product product = new Product();
                                String type = (String) obj.get("type");
                                product.setType(type);
                                String date = (String) obj.get("firstDate");
                                product.setFirstDate(date);
                                Boolean bool = (Boolean) obj.get("inTheFridge");
                                product.setBool(bool);
                                int price = (Integer) obj.get("fiyat");
                                product.setPrice(price);
                                products.add(product);

                            }

                            for(int i =0;i<response.length();i++){
                                Log.d("type",products.get(i).type);
                                Log.d("firstDate",products.get(i).firstDate);
                                Log.d("inTheFridge",products.get(i).bool+"");
                                Log.d("fiyat",products.get(i).price+"");

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", String.valueOf(error));
                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);
    }

}
