package tourismrecord.com.tourismrecord.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import tourismrecord.com.tourismrecord.R;

/**
 * Created by huanghaojian on 17/4/15.
 */

public class EditShareActvity extends BaseActivity {
    private Toolbar toolbar;
    private EditText title;
    private EditText content;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_myshare);
        initView();
    }
    void initView(){
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title=(EditText)findViewById(R.id.shareTitle);
        content=(EditText)findViewById(R.id.shareContent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editsharemenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.send:
                Toast.makeText(EditShareActvity.this,"click Button",Toast.LENGTH_SHORT).show();
                break;
            default:

        }
        return true;
    }

    public static void actionStart(Context context){
        Intent intent=new Intent(context,EditShareActvity.class);
        context.startActivity(intent);
    }
}
