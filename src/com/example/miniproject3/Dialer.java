package com.example.miniproject3;
import java.util.ArrayList;
import java.util.Locale;

import com.example.miniproject3.CustomList;

import com.example.miniproject3.R;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;

import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;



public class Dialer extends Activity implements TextToSpeech.OnInitListener {
	ListView list;
	String[] web=new String [150];
	String[] webs=new String [150];
	Button btn;
	TextView tv;
	String str;
	TextToSpeech tts;
	int i=0,j,k,l;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialer);
		btn =(Button) findViewById(R.id.button41);
		tv = (TextView) findViewById(R.id.textView41);
		tts = new TextToSpeech(this,this);
		displayContacts();
btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent in = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				in.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"en-US");
				startActivityForResult(in,31);
				
				
				
			}
		});
		
		 
		CustomList adapter=new CustomList(Dialer.this, web, webs);
		list=(ListView)findViewById(R.id.listView1);
	     
	        // Show email's on screen
	     //output.setText(emailStr);
	
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
			//	Toast.makeText(Dialer.this,"You Clicked at"+web[arg2],Toast.LENGTH_LONG).show();
				launchDialer(webs[arg2]);

			}
		});
	}
	
	private void displayContacts() {
		// TODO Auto-generated method stub
		ContentResolver cr=getContentResolver();
		Cursor cur=cr.query(ContactsContract.Contacts.CONTENT_URI, null, null,null, null);
	
		if(cur.getCount()>0)
		{
			while (cur.moveToNext()) {
				String id=cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
				String name=cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				if(Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0)
				{
					Cursor cur1=cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
							ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"= ?",new String[]{id},null);
					while (cur1.moveToNext()) {
						String phoneno=cur1.getString(cur1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
 					//	Toast.makeText(Dialer.this, "id"+id+"name: "+name+", Phone no: "+phoneno,Toast.LENGTH_SHORT).show();
						 
						 web[i]=name;
						 webs[i]=phoneno;
						 i++;
					
						 
						try {
							FileOutputStream fos=openFileOutput("contacts backup1", Context.MODE_APPEND);
							try {
								fos.write(name.getBytes());
								fos.write(phoneno.getBytes());
								fos.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						
						
					}
					cur1.close();
				}
				
			}
		}				
		}
	 public void launchDialer(String number){
         String numberToDial = "tel:"+number;
         startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(numberToDial)));
}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		switch (requestCode) {
		case 31:
		{
			if(resultCode==RESULT_OK && null !=data)
			{
				ArrayList<String> txt = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			
			tv.setText(txt.get(0));
		String str=txt.get(0);
		
		//launchDialer(webs[3]);
		
		//	tts.speak(txt.get(0),TextToSpeech.QUEUE_FLUSH,null);
			for(k=0;k<i;k++)
			{
				if(str.equalsIgnoreCase(web[k]))
					launchDialer(webs[k]);
					
				    }
				
				
			}
			
				}break;
		
			
			

		default:
			break;
		}
	
		}

		
	
	@Override
	public void onInit(int arg0) {

		// TODO Auto-generated method stub
		
		tts.setLanguage(Locale.US);
		tts.setPitch(5);
		//tts.setSpeechRate(speechRate)
		
	}
	
	
	//	CustomList adapter=new CustomList(Dialer.this, web, webs);
		
		//list.setAdapter(adapter);
		//list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			//@Override
			//public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				//	long arg3) {
				// TODO Auto-generated method stub
				//Toast.makeText(Dialer.this,"You Clicked at"+web[arg2],Toast.LENGTH_LONG).show();
			//}
		//});
		
	

	
}
