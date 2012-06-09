package com.koyamalab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AnserActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.anser);
	}
	
	public void returnQuestion(View v) {
		Intent intent = new Intent(this, QuestionActivity.class);
		startActivity(intent);
	}

}
