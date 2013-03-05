package com.urbanautomaton.lichtenstein;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity implements  OnClickListener {
	public final static String EXTRA_MESSAGE = "com.urbanautomaton.lichtenstein.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        LinearLayout media_table = (LinearLayout) findViewById(R.id.media_table);
        
        addRow(media_table, "some goddamn row");
        addRow(media_table, "another goddamn row");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void addRow(LinearLayout table, String row_name) {
    	LinearLayout row = new LinearLayout(this);
    	row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
    										 LayoutParams.WRAP_CONTENT));
    	row.setOrientation(LinearLayout.HORIZONTAL);

    	TextView tv = new TextView(this);
    	tv.setText(row_name);

    	ImageView iv = new ImageView(this);
    	int id = R.drawable.ic_launcher;
    	iv.setImageResource(id);

    	row.addView(iv);
    	row.addView(tv);
    	row.setClickable(true);
    	row.setOnClickListener(this);
    	table.addView(row);
    }
    
    public void onClick(View v) {
    	Intent intent = new Intent(this, PlayerActivity.class);
    	startActivity(intent);
    }

}
