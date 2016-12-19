package id.fikri.navigationdrawerapp;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.function.ToLongBiFunction;

import id.fikri.navigationdrawerapp.Fragmrnt.Contact;
import id.fikri.navigationdrawerapp.Fragmrnt.Home;
import id.fikri.navigationdrawerapp.Fragmrnt.Profile;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar new_toolbar = (Toolbar) findViewById(R.id.toolbar);
        new_toolbar.setTitle("Home");
        setSupportActionBar(new_toolbar);

        FragmentManager fr = getFragmentManager();
        fr.beginTransaction().replace(R.id.content_fragment, new Home()).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO for fab action
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, new_toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fr = getFragmentManager();
        Toolbar new_toolbar = (Toolbar) findViewById(R.id.toolbar);

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fr.beginTransaction().replace(R.id.content_fragment, new Home()).commit();
            new_toolbar.setTitle("Home");
        } else if (id == R.id.nav_profile) {
            fr.beginTransaction().replace(R.id.content_fragment, new Profile()).commit();
            new_toolbar.setTitle("Profile");
        } else if (id == R.id.nav_contact) {
            fr.beginTransaction().replace(R.id.content_fragment, new Contact()).commit();
            new_toolbar.setTitle("Contact");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
