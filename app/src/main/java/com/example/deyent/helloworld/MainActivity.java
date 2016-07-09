package com.example.deyent.helloworld;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
    private RecyclerView recyclerView;
    private List<String> mDatas;
    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recyclerview);

        initData();
        recyclerView=(RecyclerView) findViewById(R.id.recycle);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(homeAdapter = new HomeAdapter());
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
    }
    protected void initData(){
        mDatas= new ArrayList<String>();
        for(int i = 'A'; i<'Z'; i++){
            mDatas.add(""+ (char)i);
        }
        for(int i = 'a'; i<'z'; i++){
            mDatas.add(""+ (char)i);
        }
        for(int i = 'A'; i<'Z'; i++){
            mDatas.add(""+ (char)i);
        }
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_home, parent, false));
            return holder;

        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position){
            holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount(){
            return mDatas.size();
        }

        class MyViewHolder extends ViewHolder {
            TextView tv;

            public MyViewHolder(View view){
                super(view);
                tv=(TextView) view.findViewById(R.id.id_num);
            }
        }
    }

}
