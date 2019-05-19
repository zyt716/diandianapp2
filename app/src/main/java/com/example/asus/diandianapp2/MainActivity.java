package com.example.asus.diandianapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getCanonicalName();
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        mList.add("cctv1");
        mList.add("cctv1 高清");
        mList.add("cctv2 高清");
        mList.add("cctv3");
        mList.add("cctv4");
        mList.add("cctv4 高清");
        mList.add("cctv5");
        mList.add("cctv5 高清");
    }

    private void initView() {
        VerticalAdapter adapter = new VerticalAdapter(this);
        RecyclerView rcvVertical = findViewById(R.id.rcv_vertical);

        LinearLayoutManager managerVertical = new LinearLayoutManager(this);
        managerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        rcvVertical.setLayoutManager(managerVertical);
        rcvVertical.setHasFixedSize(true);
        rcvVertical.setAdapter(adapter);

        adapter.setVerticalDataList(mList);

        adapter.setOnItemClickListener(new VerticalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //定义相应的事件逻辑
                switch (position) {
                    case 0: {
                        Intent intent1 = new Intent(MainActivity.this, cctv1.class);
                        MainActivity.this.startActivity(intent1);
                        break;
                    }
                    case 1: {
                        Intent intent2 = new Intent(MainActivity.this, cctv1HD.class);
                        MainActivity.this.startActivity(intent2);
                        break;
                    }
                    case 2: {
                        Intent intent3 = new Intent(MainActivity.this, cctv2HD.class);
                        MainActivity.this.startActivity(intent3);
                        break;
                    }
                    case 3: {
                        Intent intent4 = new Intent(MainActivity.this, cctv3.class);
                        MainActivity.this.startActivity(intent4);
                        break;
                    }

                    case 4: {
                        Intent intent6 = new Intent(MainActivity.this, cctv4.class);
                        MainActivity.this.startActivity(intent6);
                        break;
                    }
                    case 5: {
                        Intent intent7 = new Intent(MainActivity.this, cctv4HD.class);
                        MainActivity.this.startActivity(intent7);
                        break;
                    }
                    case 6: {
                        Intent intent8 = new Intent(MainActivity.this, cctv5.class);
                        MainActivity.this.startActivity(intent8);
                        break;
                    }
                    case 7: {
                        Intent intent9 = new Intent(MainActivity.this, cctv5HD.class);
                        MainActivity.this.startActivity(intent9);
                        break;
                    }
                }
            }
        });

    }
}