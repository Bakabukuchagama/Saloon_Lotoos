package ru.lotoos.saloon_lotoos;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import ru.lotoos.saloon_lotoos.ui.gallery.GalleryFragment;
import ru.lotoos.saloon_lotoos.ui.home.HomeFragment;
import ru.lotoos.saloon_lotoos.ui.phone.PhoneFragment;
import ru.lotoos.saloon_lotoos.ui.slideshow.SlideshowFragment;

public class Navigation_menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
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

        if(id == R.id.nav_home){

            fragmentClass = HomeFragment.class;
        }
        if(id == R.id.nav_gallery){
            fragmentClass = GalleryFragment.class;

        }
        if(id == R.id.nav_slideshow){
            fragmentClass = SlideshowFragment.class;
        }
        if(id == R.id.phone){
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
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }
}