package com.example.miniproject3;

import com.example.miniproject3.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{
	
	public CustomList(Activity context,String[] web, String[] webs ) {
		super(context, R.layout.listview_layout, web);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.web=web;
		this.webs=webs;
		//this.imgId=imgId;
	}
	private final Activity context;
	private final String []web;
	private final String []webs;

@Override
public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub
	LayoutInflater inflater=context.getLayoutInflater();
	View v=inflater.inflate(R.layout.listview_layout,null,true);
	TextView tv=(TextView)v.findViewById(R.id.textView31);
	TextView tv2=(TextView)v.findViewById(R.id.textView32);
	
	
	tv.setText(web[position]);
	tv2.setText(webs[position]);
	//iv.setImageResource(imgId[position]);
	return v;
}

}
