package com.example.miniproject3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Aboutus extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutus);
		TextView a,b,c;
		a=(TextView)findViewById(R.id.textView57);
		b=(TextView)findViewById(R.id.textView58);
		c=(TextView)findViewById(R.id.textView59);
		a.setTextColor(Color.WHITE);
		b.setTextColor(Color.WHITE);
		c.setTextColor(Color.WHITE);
		
	}

}
