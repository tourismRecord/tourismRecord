package tourismrecord.com.tourismrecord.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tourismrecord.com.tourismrecord.Activity.MyShareContentActivity;
import tourismrecord.com.tourismrecord.Activity.ShareContentActivity;
import tourismrecord.com.tourismrecord.Model.ShareContent;
import tourismrecord.com.tourismrecord.R;

/**
 * Created by huanghaojian on 17/4/15.
 */

public class MyShareContentAdapter extends RecyclerView.Adapter<MyShareContentAdapter.ViewHolder>{
    private List<ShareContent> shareContentList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView head;
        TextView title;
        TextView userName;
        TextView publishTime;
        View shareContentView;
        public ViewHolder(View view){
            super(view);
            shareContentView=view;
            head=(ImageView)view.findViewById(R.id.head);
            title=(TextView)view.findViewById(R.id.item_title);
            userName=(TextView)view.findViewById(R.id.user_name);
            publishTime=(TextView)view.findViewById(R.id.publish_time);
        }
    }
    public MyShareContentAdapter(List<ShareContent> shareContentList){
        this.shareContentList=shareContentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.share_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.shareContentView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position=viewHolder.getAdapterPosition();
                ShareContent shareContent=shareContentList.get(position);
                MyShareContentActivity.actionStart(v.getContext(),shareContent.getId());
            }
        });
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,int position){
        ShareContent shareContent=shareContentList.get(position);
        viewHolder.head.setImageResource(shareContent.getImageId());
        viewHolder.title.setText(shareContent.getTitle());
        viewHolder.userName.setText(shareContent.getUserName());
        viewHolder.publishTime.setText(shareContent.getPublishTime());
    }
    @Override
    public int getItemCount(){
        return shareContentList.size();
    }
}