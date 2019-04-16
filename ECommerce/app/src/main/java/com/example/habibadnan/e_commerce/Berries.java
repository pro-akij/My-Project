package com.example.habibadnan.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Berries extends AppCompatActivity {
    private Button add_card;
    private ImageView share, share_favourite, for_cardview;
    private TextView textView;
    private MenuItem menuItem;
    public int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berries);
        add_card= findViewById(R.id.add_to_card_berries);
        share= findViewById(R.id.berries_share);
        share_favourite= findViewById(R.id.fabourite_share_berries);
        Share();
        Add_Card();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        menuItem= menu.findItem(R.id.cart);
        View view= menuItem.getActionView();
        if (view!= null){
            textView= view.findViewById(R.id.card_notification_textview);
            for_cardview= view.findViewById(R.id.shopping_card_layout);
        }
        return true;
    }

    public void Share(){
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(intent.EXTRA_SUBJECT,"E-commerce App");
                intent.putExtra(intent.EXTRA_TEXT,"www.getjar.mobi/mobile/966549/BBPI");
                startActivity(intent.createChooser(intent,"Share With"));
            }
        });
    }
    private int Add_Card(){
        add_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textView.setText(String.valueOf(count));
            }
        });
        return count;
    }
}