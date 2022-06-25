package com.example.cap02;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class GuideHome extends AppCompatActivity implements View.OnClickListener {

    Button Btnplastic, Btncan, Btnpaper,Btnmirror, Btnmetal, Btnstyro, Btnvinyl;

    TabHost tabHost;

    private RecyclerView mMainRecyclerView;

    private MainAdapter mAdapter;
    private List<Board> mBoardList;

    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_home);

        tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpecCalendar = tabHost.newTabSpec("product").setIndicator("분리수거 하기");
        tabSpecCalendar.setContent(R.id.content1);
        tabHost.addTab(tabSpecCalendar);

        TabHost.TabSpec tabSpecArlam = tabHost.newTabSpec("qna").setIndicator("질문게시판");
        tabSpecArlam.setContent(R.id.content2);
        tabHost.addTab(tabSpecArlam);

        tabHost.setCurrentTab(0);

        Btnplastic = (Button) findViewById(R.id.plasticbtn);
        Btncan = (Button) findViewById(R.id.canbtn);
        Btnpaper = (Button) findViewById(R.id.paperbtn);
        Btnmirror = (Button) findViewById(R.id.mirrorbtn);
        Btnmetal = (Button) findViewById(R.id.metalbtn);
        Btnstyro = (Button) findViewById(R.id.styrobtn);
        Btnvinyl = (Button) findViewById(R.id.vinylbtn);

        mMainRecyclerView = findViewById(R.id.main_recycler_view);

        findViewById(R.id.main_write_button).setOnClickListener(this);

        mBoardList = new ArrayList<>();

        mStore.collection("board").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException error) {
                for (DocumentChange dc : queryDocumentSnapshots.getDocumentChanges()) {
                    String id = (String) dc.getDocument().getData().get("id");
                    String title = (String) dc.getDocument().getData().get("title");
                    String contents = (String) dc.getDocument().getData().get("contents");
                    String name = (String) dc.getDocument().getData().get("name");
                    Board data = new Board(id, title, contents, name);

                    mBoardList.add(data);
                }

                mAdapter = new MainAdapter(mBoardList);
                mMainRecyclerView.setAdapter(mAdapter);
            }
        });

        Btnplastic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlasticGuide.class);
                startActivity(intent);
            }
        });

        Btncan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CanGuide.class);
                startActivity(intent);
            }
        });

        Btnpaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaperGuide.class);
                startActivity(intent);
            }
        });

        Btnmirror.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GlassGuide.class);
                startActivity(intent);
            }
        });

        Btnmetal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MetalGuide.class);
                startActivity(intent);
            }
        });

        Btnstyro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StyroGuide.class);
                startActivity(intent);
            }
        });

        Btnvinyl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VinylGuide.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, WriteActivity.class));

    }


    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

        private List<Board> mBoardList;

        public MainAdapter(List<Board> mBoardList) {
            this.mBoardList = mBoardList;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Board data = mBoardList.get(position);
            holder.mTitleTextVew.setText(data.getTitle());
            holder.mNameTextView.setText(data.getName());
        }

        @Override
        public int getItemCount() {
            return mBoardList.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder{

            private TextView mTitleTextVew;
            private TextView mNameTextView;

            public MainViewHolder(View itemView) {
                super(itemView);

                mTitleTextVew = itemView.findViewById(R.id.item_title_text);
                mNameTextView = itemView.findViewById(R.id.item_name_text);
            }
        }
    }

}
