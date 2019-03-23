package com.koala.sloth.Service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.koala.sloth.Database.Dao.Item.Product;
import com.koala.sloth.Database.Dao.OrdersDao;
import com.koala.sloth.Database.Dao.ProductDao;
import com.koala.sloth.HomeActivity;
import com.koala.sloth.R;
import com.koala.sloth.ServerConnection.ServerConnectionForOrder;
import com.koala.sloth.ServerConnection.ServerConnectionForProduct;
import com.koala.sloth.Shared.Methods;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class AlarmController extends BroadcastReceiver {

    RequestQueue queue ;
    static ServerConnectionForProduct connP ;
    static ServerConnectionForOrder connO ;
    static ArrayList<com.koala.sloth.ServerConnection.Product> serverProd;
    static ArrayList<com.koala.sloth.ServerConnection.Order> serverOrder;
    static OrdersDao ordersDao ;
    static  ProductDao productDao ;


    @Override
    public void onReceive(Context context, Intent intent) {
        sencProducts(context);
        Methods methods = new Methods();
        ProductDao productDao = new ProductDao(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("settings", 0);

        try {
            StringBuilder finishedProducts = new StringBuilder();

            String controlProducts = sharedPreferences.getString("controlProducts", "");
            String[] productNames = controlProducts.split("%");
            for (String name: productNames) {
                Product product = productDao.getProductByName(name);
                if (product.isInFridge()==0)
                    finishedProducts.append(name).append(", ");
            }
            if (!finishedProducts.toString().equals(""))
                sendNotification(context, "You don't have "+ finishedProducts + "in the fridge!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        methods.scheduleAlarmController(context);
    }
    public static void sendNotification(Context context, String message) {
        String title = "Sloth";

        if (Build.VERSION.SDK_INT > 25) {
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            String id = "my_channel_01";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel mChannel = new NotificationChannel(id, "Sloth",importance);
            mChannel.setDescription(message);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            if (mNotificationManager==null)
                return;

            mNotificationManager.createNotificationChannel(mChannel);
            mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            Intent resultIntent = new Intent(context, HomeActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(HomeActivity.class);
            stackBuilder.addNextIntent(resultIntent);

            Notification notification = new Notification.Builder(context, id)
                    .setContentIntent(stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT))
                    .setContentTitle(title)
                    .setContentText(message)
                    .setSmallIcon(R.drawable.ic_menu_fridge)
                    .setColor(ContextCompat.getColor(context, R.color.notification))
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_menu_fridge))
                    .setChannelId(id)
                    .setStyle(new Notification.BigTextStyle().bigText(message))
                    .build();
            if (mNotificationManager!=null)
                mNotificationManager.notify(1, notification);
        }
        else {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "channel_one");
            mBuilder.setSmallIcon(R.drawable.ic_menu_fridge);
            mBuilder.setColor(ContextCompat.getColor(context, R.color.notification));
            mBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.fruit));

            Intent intent = new Intent(context, HomeActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(pendingIntent);
            mBuilder.setAutoCancel(true);
            mBuilder.setFullScreenIntent(pendingIntent, true);
            mBuilder.setContentTitle(title).setContentText(message);
            mBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

            Intent resultIntent = new Intent(context, HomeActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(HomeActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (mNotificationManager != null)
                mNotificationManager.notify(1, mBuilder.build());
        }
    }
    public  void sencProducts(Context context){
        ordersDao = new OrdersDao(context);
        productDao = new ProductDao(context);
        queue = Volley.newRequestQueue(context);
        connP = new ServerConnectionForProduct(queue);
        connO = new ServerConnectionForOrder(queue);

        ArrayList<Product> products = productDao.getProductList();
        serverProd = connP.products;

        ArrayList<com.koala.sloth.ServerConnection.Product> diff = new ArrayList<>();
        Boolean bdiff=true;
        for (int i = 0 ; i<serverProd.size();i++){
            com.koala.sloth.ServerConnection.Product temp = serverProd.get(i);
            for (int j = 0 ; j<products.size();j++){
                Product temp2=products.get(j);
                if(temp.getId()==temp2.getId()){
                    if(temp.getInFridge()!=temp2.isInFridge()){
                        if(temp.getInFridge()==1){
                            productDao.addToFridge(temp2.getId());
                            productDao.setDateProduct(temp2.getId(),temp2.getFirstDate());
                        }
                        else{
                            productDao.removeFromFridge(temp2.getId());
                            productDao.setDateProduct(temp2.getId(),temp2.getFirstDate());
                        }
                    }
                    bdiff=false;
                    break;
                }
            }
            if (bdiff)
                diff.add(temp);
            bdiff=true;
        }

        for (int i =0 ; i<diff.size();i++){
            com.koala.sloth.ServerConnection.Product get = diff.get(i);
            String name=get.getName();
            String brand=get.getBrand();
            String category=get.getCategory();
            double price=get.getPrice();
            String priceUnit=get.getPriceUnit();
            String physicalUnit=get.getPhysicalUnit();
            long firstDate=get.getFirstDate();
            int inFridgeInt=get.getInFridge();
            boolean inFridge=false;
            if(inFridgeInt==1){
                inFridge=true;
            }
            else{
                inFridge=false;
            }

            int id = getDrawableId("a"+get.getId());
            byte [] img = productDao.getDrawableAsByteArray(id);
            productDao.addOrderProduct(name,brand,category,price,priceUnit,physicalUnit,firstDate,inFridge,img);

        }
    }
    public static int getDrawableId(String name) {
        Class<?> c = R.drawable.class;
        Field f = null;
        int id = 0;

        try {
            f = R.drawable.class.getField(name);
            id = f.getInt(null);
        } catch (NoSuchFieldException e) {
            Log.i("Reflection", "Missing drawable " + name);
        } catch (IllegalAccessException e) {
            Log.i("Reflection", "Illegal access to field " + name);
        }

        return id;
    }
}