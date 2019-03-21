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

public class ServerConnectionForOrder {

    private final String url = "https://slothweb.herokuapp.com/order";

    public ArrayList<Order> orders = new ArrayList<Order>();
    private Order tmpProduct ;
    private RequestQueue queue ;

    public ServerConnectionForOrder(RequestQueue queue) {
        this.queue = queue;
    }

    public  void returnbyId(int id){
        JsonObjectRequest getRequest = new JsonObjectRequest(Method.GET, url+"/"+id, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        try {
                            JSONObject obj = (JSONObject) response;
                            Order order = new Order();

                            Integer id = (Integer) obj.get("id");
                            order.setId(id);

                            Integer productId = (Integer) obj.get("product_ID");
                            order.setProductId(productId);

                            Integer quantity = (Integer) obj.get("quantity");
                            order.setQuantity(quantity);

                            long date = (Integer) obj.get("date");
                            order.setDate(date);

                            orders.add(order);

                            for(int i =0;i<orders.size();i++){
                                    Log.d("Number of Product : ", ""+i+1+". products : ");
                                    Log.d("id : ",""+orders.get(i).getId());
                                    Log.d("productId : ",""+orders.get(i).getProductId());
                                    Log.d("quantity : ",orders.get(i).getQuantity()+"");
                                    Log.d("date : ",orders.get(i).getDate()+"");

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       Log.d("Error.Response", String.valueOf(error));
                    }
                }

        );

        queue.add(getRequest);
    }

    public void returnAllOrder(){

        JsonArrayRequest getRequest = new JsonArrayRequest(Method.GET, url, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            for(int i=0 ; i<response.length();i++){
                                JSONObject obj = (JSONObject) response.get(i);
                                Order order = new Order();

                                Integer id = (Integer) obj.get("id");
                                order.setId(id);

                                Integer productId = (Integer) obj.get("product_ID");
                                order.setProductId(productId);

                                Integer quantity = (Integer) obj.get("quantity");
                                order.setQuantity(quantity);

                                long date = (long) obj.get("date");
                                order.setDate(date);

                                orders.add(order);

                            }

                            for(int i =0;i<response.length();i++){
                                Log.d("Number of Product : ", ""+i+1+". products : ");
                                Log.d("id : ",""+orders.get(i).getId());
                                Log.d("productId : ",""+orders.get(i).getProductId());
                                Log.d("quantity : ",orders.get(i).getQuantity()+"");
                                Log.d("date : ",orders.get(i).getDate()+"");

                            }
                            //HomeActivity.sencOrders();
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

    public  void prepareToAdd(int productId,int quatity,long date){
        JSONObject post = new JSONObject();
        try {
            post.accumulate("date",date);
            post.accumulate("quantity",quatity);
            post.accumulate("product_ID",productId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        add(post);
    }
}
