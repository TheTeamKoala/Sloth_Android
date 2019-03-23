package com.koala.sloth.Shared;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.koala.sloth.Database.Dao.Item.Product;
import com.koala.sloth.Service.AlarmController;

import java.util.ArrayList;

public class Methods {

    public static void addItemToBasket(Product newItem) {
        for (Product item: Constant.basket) {
            if (item.getName().equals(newItem.getName())) {
                item.setQuantity(newItem.getQuantity());
                return;
            }
        }

        Constant.basket.add(newItem);
    }
    public static void removeItemToBasket(String itemName) {
        Product item = null;
        for (Product product_item: Constant.basket) {
            if (product_item.getName().equals(itemName)) {
                item = product_item;
                break;
            }
        }

        if (item!=null)
            Constant.basket.remove(item);
    }
    public static int getTotalQuantity() {
        int totalQuantity = 0;
        for (Product product_item: Constant.basket) {
            totalQuantity = totalQuantity + product_item.getQuantity();
        }

        return totalQuantity;
    }
    public static double getTotalPrice() {
        double totalPrice = 0;
        for (Product product_item: Constant.basket) {
            totalPrice = totalPrice + product_item.getQuantity()*product_item.getPrice();
        }

        return totalPrice;
    }

    public void scheduleAlarmController(Context context) {
        long alarmTime = 30000;

        try {
            Intent intentAlarm = new Intent(context, AlarmController.class);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

            if (alarmManager == null) {
                scheduleAlarmController(context);
                return;
            }

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 2, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + alarmTime, pendingIntent);
        } catch (Exception exception) {
            scheduleAlarmController(context);
        }
    }

}
