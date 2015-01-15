package com.example.miniproject3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ImageView b1,b2,b11,b13,x1;
	TextView p,q,r,s;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(ImageView)findViewById(R.id.button1);
		b2=(ImageView)findViewById(R.id.button2);
		b11=(ImageView)findViewById(R.id.button11);
		b13=(ImageView)findViewById(R.id.button13);
		x1=(ImageView)findViewById(R.id.img12);
		p=(TextView)findViewById(R.id.textView91);
		q=(TextView)findViewById(R.id.textView92);
		r=(TextView)findViewById(R.id.textView93);
		s=(TextView)findViewById(R.id.textView94);
		p.setTextColor(Color.WHITE);
		q.setTextColor(Color.WHITE);
		r.setTextColor(Color.WHITE);
		s.setTextColor(Color.WHITE);
		
		b1.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Dialer.class);
				startActivity(intent);
				
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Search.class);
				startActivity(intent);
				
			}
		});
		b11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Sms.class);
				startActivity(intent);
				
			}
			
		});
		b13.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Aboutus.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
