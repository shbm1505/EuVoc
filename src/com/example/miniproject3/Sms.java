package com.example.miniproject3;

import com.example.miniproject3.R;
import java.util.ArrayList;
import java.util.Locale;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View.OnClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sms extends Activity implements TextToSpeech.OnInitListener {
	Button b12,b14,b15;
	EditText num , msg ;
	TextView nu,ms;
	TextToSpeech tts,tts1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms);
		b12=(Button)findViewById(R.id.button12);
		nu=(TextView)findViewById(R.id.textView11);
		ms=(TextView)findViewById(R.id.textView12);
		b14=(Button)findViewById(R.id.button14);
		b15=(Button)findViewById(R.id.button15);
	//	num=(EditText)findViewById(R.id.editText1);
		//msg=(EditText)findViewById(R.id.editText2);
		tts = new TextToSpeech(this,this);
		tts1 = new TextToSpeech(this,this);
b14.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent in = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				in.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"en-US");
				startActivityForResult(in,31);
				
				
				
			}
		});
b15.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		Intent in = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		in.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"en-US");
		startActivityForResult(in,32);
		
		
		
	}
});
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
			
			nu.setText(txt.get(0));
			
			tts.speak(txt.get(0),TextToSpeech.QUEUE_FLUSH,null);
			
			}
		}
			
			break;
		case 32:
		{
			if(resultCode==RESULT_OK && null !=data)
			{
				ArrayList<String> txt1 = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			
			ms.setText(txt1.get(0));
			
			tts1.speak(txt1.get(0),TextToSpeech.QUEUE_FLUSH,null);
			
			}
		}
			
			break;


		default:
			break;
		}
		
		
	}
	
	public void send (View view){
		String phone= nu.toString();
		String sms= ms.toString();
		
		try{
			SmsManager sm=SmsManager.getDefault();
			sm.sendTextMessage(phone, null, sms, null, null);
			Toast.makeText(getApplicationContext(), "SMS sent", Toast.LENGTH_LONG).show();
		}
		
		catch(Exception e){
			Toast.makeText(getApplicationContext(), "Failed , Try again", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		
	}

	public void onInit(int arg0) {
		// TODO Auto-generated method stub
		
		tts.setLanguage(Locale.US);
		tts.setPitch(5);
		tts1.setLanguage(Locale.US);
		tts1.setPitch(5);
		//tts.setSpeechRate(speechRate)
		
	}
}
