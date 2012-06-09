package com.koyamalab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TangochoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void startQuestion(View v) {
    	Intent intent = new Intent(this, QuestionActivity.class);
    	startActivity(intent);
    }
    
    public void startSetting(View v) {
    	Intent intent = new Intent(this, SettingActivity.class);
    	startActivity(intent);
    }
    
    public void exitApp(View v) {
    	finish();
    }
    
}