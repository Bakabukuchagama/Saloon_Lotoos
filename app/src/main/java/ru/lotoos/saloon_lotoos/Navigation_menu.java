package ru.lotoos.saloon_lotoos;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import ru.lotoos.saloon_lotoos.dialog.CustomDialogFragment;
import ru.lotoos.saloon_lotoos.notification.NotificationHandler;
import ru.lotoos.saloon_lotoos.ui.gallery.GalleryFragment;
import ru.lotoos.saloon_lotoos.ui.home.HomeFragment;
import ru.lotoos.saloon_lotoos.ui.phone.PhoneFragment;
import ru.lotoos.saloon_lotoos.ui.slideshow.SlideshowFragment;

public class Navigation_menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private int notifyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            String idChannel = getString(R.string.channel_id);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(idChannel, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        notifyId = 0;
        Intent notif = new Intent(this, NotificationHandler.class);
        notif.putExtra("notId", notifyId);
        startService(notif);

        Annonces();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass = null;
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            fragmentClass = HomeFragment.class;
        }
        if (id == R.id.nav_gallery) {
            fragmentClass = GalleryFragment.class;

        }
        if (id == R.id.nav_slideshow) {
            fragmentClass = SlideshowFragment.class;
        }
        if (id == R.id.phone) {
            fragmentClass = PhoneFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
        // Выделяем выбранный пункт меню в шторке
        item.setChecked(true);
        // Выводим выбранный пункт в заголовке
        setTitle(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //скрывает меню
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }

    private void Annonces() {
        //NetworkImageView networkImageView = (NetworkImageView) findViewById(R.id.networkImageAnnonce);
        CustomDialogFragment dialog = new CustomDialogFragment();

        dialog.show(getSupportFragmentManager(), "custom");

    }
}