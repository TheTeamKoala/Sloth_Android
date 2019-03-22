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

import com.koala.sloth.Database.Dao.Item.Product;
import com.koala.sloth.Database.Dao.ProductDao;
import com.koala.sloth.HomeActivity;
import com.koala.sloth.R;
import com.koala.sloth.Shared.Methods;


public class AlarmController extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
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

}