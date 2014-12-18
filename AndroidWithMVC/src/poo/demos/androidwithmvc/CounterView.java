package poo.demos.androidwithmvc;

import poo.demos.androidwithmvc.model.CounterState;
import poo.demos.androidwithmvc.model.CounterState.OnStateChangedListener;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class CounterView extends TextView {

	private CounterState model;
	
	public CounterView(Context context) 
	{
		super(context);
	}
	
	public CounterView(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
	}
	
	public CounterView(Context context, AttributeSet attrs, int defStyle) 
	{
		super(context, attrs, defStyle);
	}

	public void setCounterState(CounterState model)
	{
		this.model = model;
		this.setText(Integer.toString(model.getValue()));
		
		this.model.setOnStateChangedListener(new OnStateChangedListener() {
			@Override
			public void onStateChange(CounterState source) 
			{
				CounterView.this.setText(Integer.toString(source.getValue()));
			}
		});

	}
}
