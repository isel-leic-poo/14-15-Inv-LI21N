package poo.demos.androidwithmvc;

import poo.demos.androidwithmvc.model.CounterState;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final CounterState counterState = new CounterState(0);
		CounterView counterView = (CounterView) findViewById(R.id.counterTextView);
		counterView.setCounterState(counterState);
		
		CounterControlPanel counterControl = (CounterControlPanel) findViewById(R.id.counterControl);
		counterControl.setModel(counterState);
	}
}
