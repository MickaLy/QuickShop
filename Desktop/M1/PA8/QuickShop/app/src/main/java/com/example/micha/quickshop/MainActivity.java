package com.example.micha.quickshop;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.micha.entity.OnMyFragmentEvent;
import com.example.micha.entity.Product;

public class MainActivity extends AppCompatActivity implements OnMyFragmentEvent{
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView mNavDrawer;
    private FragmentManager fragmentManager;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Find drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawer.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        mNavDrawer = (NavigationView) findViewById(R.id.nav_view);
        setupDrawerContent(mNavDrawer);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //The action bar home/up action should open or close the drawer.
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                fragmentClass = HomeFragment.class;
                //transaction.replace(R.id.fragment_home,fragmentClass);
                break;
            case R.id.nav_account:
                fragmentClass = AccountFragment.class;
                break;
            case R.id.nav_shoppingcart:
                fragmentClass = ShoppingCartFragment.class;
                break;
            case R.id.nav_favorite:
                fragmentClass = FavoriteFragment.class;
                break;
            case R.id.nav_delivery:
                fragmentClass = DeliveryFragment.class;
                break;
            case R.id.nav_historic:
                fragmentClass = HistoricFragment.class;
                break;
            default:
                return;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    public void onMyEvent(Product product) {
        ShoppingCartFragment frg = (ShoppingCartFragment) fragmentManager.findFragmentById(R.id.fragment_shoppingCart);
        frg.addNewProduct(product);
    }
}
