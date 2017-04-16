package tourismrecord.com.tourismrecord.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import tourismrecord.com.tourismrecord.R;

/**
 * Created by huanghaojian on 17/4/16.
 */

public class MyShareContentActivity extends BaseActivity {
    private TextView title;
    private TextView author;
    private TextView time;
    private TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myshare_content);
        initView();
        test();
    }
    void initView(){
        title=(TextView)findViewById(R.id.myshare_content_title);
        author=(TextView)findViewById(R.id.myshare_content_author);
        time=(TextView)findViewById(R.id.myshare_content_time);
        content=(TextView)findViewById(R.id.myshare_content);
    }
    void test(){
        title.setText("无题");
        author.setText("xingyingyue");
        time.setText("2017.04.16");
        content.setText("测试，留言模块不好搞，先放着;图片显示的模块，打算用GridView，目前没弄好；该界面还很简陋，会继续优化");
    }
    public static void actionStart(Context context, int id){
        Intent intent=new Intent(context,MyShareContentActivity.class);
        intent.putExtra("item_id",id);
        context.startActivity(intent);
    }
}
