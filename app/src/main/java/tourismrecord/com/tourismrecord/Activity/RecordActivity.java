package tourismrecord.com.tourismrecord.Activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tourismrecord.com.tourismrecord.Adapter.ShareContentAdapter;
import tourismrecord.com.tourismrecord.Model.ShareContent;
import tourismrecord.com.tourismrecord.R;

/**
 * Created by huanghaojian on 17/4/14.
 */

public class RecordActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private List<ShareContent> shareContentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initList();
        initView();
    }

    void initView(){
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=(DrawerLayout)findViewById(R.id.main_drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.personalInfo);
        navigationView.setNavigationItemSelectedListener(this);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.share_content_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ShareContentAdapter adapter=new ShareContentAdapter(shareContentList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.photo:
                Toast.makeText(RecordActivity.this,"click photoButton",Toast.LENGTH_SHORT).show();
                 break;
            case R.id.map:
                Toast.makeText(RecordActivity.this,"click mapButton",Toast.LENGTH_SHORT).show();
                break;
            case R.id.editShare:
                EditShareActvity.actionStart(RecordActivity.this);
                break;
            default:

        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()){
            case R.id.personalInfo:
                Toast.makeText(RecordActivity.this,"click personalInfo",Toast.LENGTH_SHORT).show();
                break;
            case R.id.myshare:
                Toast.makeText(RecordActivity.this,"click myshare",Toast.LENGTH_SHORT).show();
                break;
            default:
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void initList(){
        ShareContent shareContent=new ShareContent("xingyingyue",R.mipmap.ic_launcher,"no_title","2017-04-16");
        shareContentList.add(shareContent);
    }
}
