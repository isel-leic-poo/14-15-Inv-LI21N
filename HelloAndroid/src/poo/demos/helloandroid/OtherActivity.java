package poo.demos.helloandroid;

import android.app.Activity;
import android.os.Bundle;

public class OtherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(new CustomView(this));
	}
	
}
