package poo.demos.androidwithmvc;

import poo.demos.androidwithmvc.model.CounterState;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.*;

public class CounterControlPanel extends LinearLayout {

	private CounterState model;
	
	private void initButtons(Context context)
	{
		Button incButton = new Button(context);
		incButton.setText("+");
		
		incButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) { if(model != null) model.increment(); }
		});

		Button decButton = new Button(context);
		decButton.setText("-");
		decButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) { if(model != null) model.decrement(); }
		});
		
		this.addView(incButton);
		this.addView(decButton);
		
	}
	
	public CounterControlPanel(Context context) 
	{
		super(context);
		initButtons(context);
	}
	
	public CounterControlPanel(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		initButtons(context);
	}
	
	public CounterControlPanel(Context context, AttributeSet attrs, int defStyle) 
	{
		super(context, attrs, defStyle);
		initButtons(context);
	}
	
	public void setModel(CounterState model)
	{
		this.model = model;
	}

}
