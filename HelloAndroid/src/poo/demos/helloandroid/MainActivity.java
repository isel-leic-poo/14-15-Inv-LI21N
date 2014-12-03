package poo.demos.helloandroid;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String MSG_BOX_STATE_KEY = "msgBoxText";
	private static final String GAME_AREA_STATE_KEY = "gameAreaReversedState";

	private TextView msgBox;
	private CustomView gameArea;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		msgBox = new TextView(this);
		msgBox.setTextSize(22);
		String msgBoxText = "";
		if(savedInstanceState != null)
			msgBoxText = savedInstanceState.getString(MSG_BOX_STATE_KEY);
		msgBox.setText(msgBoxText);
		
		Button button = new Button(this);
		button.setText("Click Me");
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View source) 
			{
				final EditText textBox = new EditText(MainActivity.this);
				new AlertDialog.Builder(MainActivity.this)
					.setMessage("Player Name ?")
					.setTitle("New entry")
					.setView(textBox)
					.setCancelable(false)
					.setNegativeButton("Cancel", null)
					.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) 
						{
							final String text = textBox.getText().toString();
							Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
							msgBox.setText(text);
						}
					}).create().show();
			}
		});
		
		gameArea = new CustomView(this);
		if(savedInstanceState != null)
			gameArea.setFlippedState(savedInstanceState.getBoolean(GAME_AREA_STATE_KEY));
		
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

	
	@Override
	protected void onSaveInstanceState(Bundle outState) 
	{
		super.onSaveInstanceState(outState);
		outState.putString(MSG_BOX_STATE_KEY, msgBox.getText().toString());
		outState.putBoolean(GAME_AREA_STATE_KEY, gameArea.getFlippedState());
	}
}
