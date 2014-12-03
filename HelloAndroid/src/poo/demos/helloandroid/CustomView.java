package poo.demos.helloandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.IBinder;
import android.view.View;

public class CustomView extends View {

	private Paint brush;
	private boolean flippedState;
	
	private void initBrush() 
	{
		brush = new Paint();
		brush.setColor(Color.RED);
		brush.setStyle(Style.FILL);
		brush.setStrokeWidth(5);
	}
	
	public CustomView(Context context) 
	{
		super(context);
		initBrush();
		flippedState = false;
	}


	@Override
	protected void onDraw(Canvas canvas) 
	{
		super.onDraw(canvas);
		if(!flippedState)
			canvas.drawLine(0, 0, getWidth(), getHeight(), brush);
		else
			canvas.drawLine(getWidth(), 0, 0, getHeight(), brush);
	}
	
	public void toggleFlippedState()
	{
		this.flippedState = !this.flippedState;
		invalidate();
	}

	public boolean getFlippedState() 
	{
		return flippedState;
	}
	
	public void setFlippedState(boolean flippedState)
	{
		this.flippedState = flippedState;
	}
}
