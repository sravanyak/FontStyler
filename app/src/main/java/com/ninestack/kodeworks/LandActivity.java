package com.ninestack.kodeworks;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LandActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        TabLayout.OnTabSelectedListener, AboutFragment.OnFragmentInteractionListener,
        ServicesFragment.OnFragmentInteractionListener, PortfolioFragment.OnFragmentInteractionListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("About Kodework"));
        tabLayout.addTab(tabLayout.newTab().setText("Services"));
        tabLayout.addTab(tabLayout.newTab().setText("Portfolio"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        LinearLayout headerLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.nav_header_land, null);

        if(navigationView!=null) {
            // Get the header layout
            headerLayout = (LinearLayout) navigationView.getHeaderView(0);
        }

        final TextView headerCall = (TextView) headerLayout.findViewById(R.id.caller);
        headerCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(LandActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(android.content.Intent.ACTION_CALL, Uri.parse("tel:" + headerCall.getText().toString().replace("Call", "")));
                    startActivity(intent);
                    return;
                }
            }});

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);
        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
        setIndicator(adapter);
    }

    public void setIndicator(Pager adapter) {
        for (int i = 0; i < adapter.getCount(); i++) {
            switch (i) {
                case 0:
                    tabLayout.getTabAt(i).setText("About Kodework");
                    tabLayout.getTabAt(i).setIcon(R.drawable.ic_polymer_black_24dp);
                    break;
                case 1:
                    tabLayout.getTabAt(i).setText("Services");
                    tabLayout.getTabAt(i).setIcon(R.drawable.ic_cloud_circle_black_24dp);
                    break;
                case 2:
                    tabLayout.getTabAt(i).setText("Portfolio");
                    tabLayout.getTabAt(i).setIcon(R.drawable.ic_work_black_24dp);
                    break;
                /*case 3:
                    tabL.getTabAt(i).setIcon(R.drawable.star_grey);
                    break;
                case 4:
                    tabL.getTabAt(i).setIcon(R.drawable.user_grey);
                    break;*/
                default:
                    break;
            }
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.land, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tech) {
            Intent i = new Intent(this,SkillActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
