package tourismrecord.com.tourismrecord.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tourismrecord.com.tourismrecord.Adapter.MyShareContentAdapter;
import tourismrecord.com.tourismrecord.Model.ShareContent;
import tourismrecord.com.tourismrecord.R;

/**
 * Created by huanghaojian on 17/4/16.
 */

public class MyShareActivity extends BaseActivity {
    private List<ShareContent> myshareList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstancedState){
        super.onCreate(savedInstancedState);
        setContentView(R.layout.myshare_list);
        initView();
        initList();
    }
    void initView(){
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.myshare_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyShareContentAdapter adapter=new MyShareContentAdapter(myshareList);
        recyclerView.setAdapter(adapter);
    }
    private void initList(){
        ShareContent shareContent=new ShareContent(0,"xingyingyue",R.mipmap.ic_launcher,"no_title","2017-04-16");
        myshareList.add(shareContent);
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,MyShareActivity.class);
        context.startActivity(intent);
    }
}
