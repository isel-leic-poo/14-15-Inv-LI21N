package poo.demos.helloandroid;

import java.util.logging.Logger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView msgBox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		msgBox = new TextView(this);
		msgBox.setText("SLB, O Glorioso!!!");
		msgBox.setTextSize(22);
		msgBox.setVisibility(View.INVISIBLE);
		
		Button button = new Button(this);
		button.setText("Click Me");
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View source) 
			{
				source.postDelayed(new Runnable() {
					@Override
					public void run() 
					{
						int newState = msgBox.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE;
						msgBox.setVisibility(newState);
					}
				}, 1000);
			}
		});
		
		CustomView gameArea = new CustomView(this);
		gameArea.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View source, MotionEvent event) 
			{
				if(event.getPointerCount() != 1)
					return false;
				
				if(event.getAction() == MotionEvent.ACTION_DOWN)
				{
					StringBuilder builder = new StringBuilder();
					builder.append("X: ");
					builder.append(event.getX());
					builder.append("; Y: ");
					builder.append(event.getY());
					Toast.makeText(MainActivity.this, builder, Toast.LENGTH_LONG).show();
					((CustomView) source).toggleFlippedState();
					//Log.v("APP", builder.toString());
					return true;
				}
		
				return false;
			}
		});
		
		Button nextButton = new Button(this);
		nextButton.setText("Next");
		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) 
			{
				Intent startIntent = new Intent(MainActivity.this, poo.demos.helloandroid.OtherActivity.class);
				startActivity(startIntent);
			}
		});
		
		LinearLayout root = new LinearLayout(this);
		root.setOrientation(LinearLayout.VERTICAL);
		root.addView(msgBox);
		root.addView(button);
		root.addView(nextButton);
		root.addView(gameArea);
		
		setContentView(root);
	}
}
