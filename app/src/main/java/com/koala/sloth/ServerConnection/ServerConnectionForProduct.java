package com.koala.sloth.ServerConnection;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.koala.sloth.HomeActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.android.volley.Request.Method;

public class ServerConnectionForProduct {
   private final String url = "https://slothweb.herokuapp.com/product";

    public ArrayList<Product> products = new ArrayList<Product>();
    private Product tmpProduct ;
    private RequestQueue queue ;

    public ServerConnectionForProduct(RequestQueue queue) {
        this.queue = queue;
    }

    public void add(JSONObject post){

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
    public void returnById(int id){
        String strId="/"+id+"";
        JsonObjectRequest getRequest = new JsonObjectRequest(Method.GET, url+strId, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        try {

                            JSONObject obj = (JSONObject) response;
                            Product product = new Product();

                            Integer id = (Integer) obj.get("id");
                            product.setId(id);

                            String type = (String) obj.get("name");
                            product.setName(type);

                            String brand = (String) obj.get("brand");
                            product.setBrand(brand);

                            String category = (String) obj.get("category");
                            product.setCategory(category);

                            double price = (double) obj.get("price");
                            product.setPrice(price);

                            String price_UNIT = (String) obj.get("price_UNIT");
                            product.setPriceUnit(price_UNIT);

                            String physical_UNIT = (String) obj.get("physical_UNIT");
                            product.setPhysicalUnit(physical_UNIT);

                            long date = (Integer) obj.get("first_DATE");
                            product.setFirstDate(date);

                            Integer fridge = (Integer) obj.get("inTheFridge");
                            product.setInFridge(fridge);

                            tmpProduct=product;
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

    public void delete(int intId){
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


    public void updateAdd(String name){
        JsonObjectRequest updRequest = new JsonObjectRequest(Method.GET, url + "/update/add/"+name, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        try {
                            Log.d("Successful", "added");
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

    public void updateDel(String name){
        JsonObjectRequest updRequest = new JsonObjectRequest(Method.GET, url + "/update/del/"+name, null,
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

    public void returnAllProduct(){

        JsonArrayRequest getRequest = new JsonArrayRequest(Method.GET, url, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response", response.toString());
                        try {

                            for(int i=0 ; i<response.length();i++){
                                JSONObject obj = (JSONObject) response.get(i);
                                Product product = new Product();

                                Integer id = (Integer) obj.get("id");
                                product.setId(id);

                                String type = (String) obj.get("name");
                                product.setName(type);

                                String brand = (String) obj.get("brand");
                                product.setBrand(brand);

                                String category = (String) obj.get("category");
                                product.setCategory(category);

                                double price = (double) obj.get("price");
                                product.setPrice(price);

                                String price_UNIT = (String) obj.get("price_UNIT");
                                product.setPriceUnit(price_UNIT);

                                String physical_UNIT = (String) obj.get("physical_UNIT");
                                product.setPhysicalUnit(physical_UNIT);

                                long date = (long) obj.get("first_DATE");
                                product.setFirstDate(date);

                                Integer fridge = (Integer) obj.get("inTheFridge");
                                product.setInFridge(fridge);

                                products.add(product);

                            }

                            for(int i =0;i<response.length();i++){
                                Log.d("Number of Product : ", ""+i+1+". products : ");
                                Log.d("id : ",""+products.get(i).getId());
                                Log.d("name : ",""+products.get(i).getName());
                                Log.d("brand : ",products.get(i).getBrand()+"");
                                Log.d("category : ",products.get(i).getCategory()+"");
                                Log.d("price : ",""+products.get(i).getPrice());
                                Log.d("priceUnit : ",""+products.get(i).getPriceUnit());
                                Log.d("physicalUnit : ",products.get(i).getPhysicalUnit()+"");
                                Log.d("firstDate : ",products.get(i).getFirstDate()+"");
                                Log.d("intheFridge : ",products.get(i).getInFridge()+"");

                            }
                            HomeActivity.sencProducts();
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

    public void getAllFromFridge(){
        String fridge = "/fridge";
        JsonArrayRequest getRequest = new JsonArrayRequest(Method.GET, url+fridge, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            for(int i=0 ; i<response.length();i++){
                                JSONObject obj = (JSONObject) response.get(i);
                                Product product = new Product();

                                Integer id = (Integer) obj.get("id");
                                product.setId(id);

                                String type = (String) obj.get("name");
                                product.setName(type);

                                String brand = (String) obj.get("brand");
                                product.setBrand(brand);

                                String category = (String) obj.get("category");
                                product.setCategory(category);

                                double price = (double) obj.get("price");
                                product.setPrice(price);

                                String price_UNIT = (String) obj.get("price_UNIT");
                                product.setPriceUnit(price_UNIT);

                                String physical_UNIT = (String) obj.get("physical_UNIT");
                                product.setPhysicalUnit(physical_UNIT);

                                long date = (Integer) obj.get("first_DATE");
                                product.setFirstDate(date);

                                Integer fridge = (Integer) obj.get("inTheFridge");
                                product.setInFridge(fridge);

                                products.add(product);

                            }

                            for(int i =0;i<response.length();i++){
                                Log.d("Number of Product : ", ""+i+1+". products : ");
                                Log.d("id : ",""+products.get(i).getId());
                                Log.d("name : ",""+products.get(i).getName());
                                Log.d("brand : ",products.get(i).getBrand()+"");
                                Log.d("category : ",products.get(i).getCategory()+"");
                                Log.d("price : ",""+products.get(i).getPrice());
                                Log.d("priceUnit : ",""+products.get(i).getPriceUnit());
                                Log.d("physicalUnit : ",products.get(i).getPhysicalUnit()+"");
                                Log.d("firstDate : ",products.get(i).getFirstDate()+"");
                                Log.d("intheFridge : ",products.get(i).getInFridge()+"");

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
