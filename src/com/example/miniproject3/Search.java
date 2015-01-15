package com.example.miniproject3;

import java.util.ArrayList;
import java.util.Locale;


import com.example.miniproject3.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class Search extends Activity implements TextToSpeech.OnInitListener {
	Button btn;
	 Button  btn2, btn3, btn4,btn5;
	WebView wv;
	TextView tv;
	TextToSpeech tts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		btn =(Button) findViewById(R.id.button3);
		tv = (TextView) findViewById(R.id.textView1);
		tv.setTextColor(Color.WHITE);
		tts = new TextToSpeech(this,this);
		 wv = (WebView) findViewById(R.id.webview1);
		  wv.loadUrl("https://www.google.co.in");// opening local html file from assests folder
		  wv.setWebViewClient(new webCont());
btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent in = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				in.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"en-US");
				startActivityForResult(in,31);
				
				
				
			}
		});

btn2 = (Button) findViewById(R.id.button4);
btn2.setOnClickListener(new View.OnClickListener() {
 
 @Override
 public void onClick(View v) {
  // TODO Auto-generated method stub
 wv.goBack(); //backward traverse
 }
});
wv.requestFocus(View.FOCUS_DOWN);
wv.setOnTouchListener(new View.OnTouchListener() {


@Override
public boolean onTouch(View v, MotionEvent event) {
// TODO Auto-generated method stub
switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
        case MotionEvent.ACTION_UP:
            if (!v.hasFocus()) {
                v.requestFocus();
            }
            break;
    }
return false;
}
});
	}
class webCont extends WebViewClient
{

 @Override
 public boolean shouldOverrideUrlLoading(WebView view, String url) {
  // TODO Auto-generated method stub
  view.loadUrl(url);
  
  return true;
  
  
 }
 
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
		
		tts.speak(txt.get(0),TextToSpeech.QUEUE_FLUSH,null);
	//	String url = txt.toString();
		   wv.loadUrl("https://www.google.co.in/search?q="+txt );
		
		}
	}
		
		break;

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


}
	

