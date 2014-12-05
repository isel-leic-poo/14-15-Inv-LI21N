package poo.demos.androidio;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class OtherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		
		Button button = (Button) findViewById(R.id.button1);
		
		/*
		LayoutInflater inflater = getLayoutInflater();
		View root = inflater.inflate(R.layout.activity_other, null);
		
		setContentView(root);
		*/
	}
}
