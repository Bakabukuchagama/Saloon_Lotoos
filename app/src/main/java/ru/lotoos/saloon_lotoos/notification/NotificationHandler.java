package ru.lotoos.saloon_lotoos.notification;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import ru.lotoos.saloon_lotoos.Navigation_menu;
import ru.lotoos.saloon_lotoos.R;

public class NotificationHandler extends IntentService {

    private int notId;

    public NotificationHandler() {
        super("notify");
    }



    public void Notifications(String notifTitle, String notifContent, int notifyId){

    NotificationCompat.Builder builder = new NotificationCompat.Builder(this, getString(R.string.channel_id))
            .setSmallIcon(R.drawable.ic_menu_share)
            .setContentTitle(notifTitle)
            .setContentText(notifContent)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(notifyId, builder.build());

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        Notifications("Уведомление", "Текст уведомления", notId+2);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }
}
