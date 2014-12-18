package poo.demos.androidwithmvc.model;

public class CounterState {

	public static interface OnStateChangedListener {
		
		public void onStateChange(CounterState source);
	}
	
	private int value;
	private OnStateChangedListener listener;
	
	private void fireOnCounterStateChangedEvent() 
	{
		if(listener != null)
			listener.onStateChange(this);
	}
	
	public CounterState(int initialValue)
	{
		value = initialValue;
	}
	
	public void setOnStateChangedListener(OnStateChangedListener listener)
	{
		this.listener = listener;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void increment()
	{
		value += 1;
		fireOnCounterStateChangedEvent();
	}
	
	public void decrement()
	{
		value -= 1;
		fireOnCounterStateChangedEvent();
	}
}
