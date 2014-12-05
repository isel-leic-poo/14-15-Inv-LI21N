package poo.demos.androidio;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String filename = "Table.txt";
	
	private ArrayList<String> table = new ArrayList<String>();
	private LinearLayout root;
	private Button newEntryButton;
	
	private void addNewView(String entry)
	{
		String viewClassName = "android.widget.";
		String[] pair = entry.split(":");
		viewClassName += pair[0];
		
		try {
			Class<?> viewType = Class.forName(viewClassName);
			TextView entryView = (TextView) viewType.getConstructor(android.content.Context.class).newInstance(MainActivity.this);
			entryView.setText(pair[1]);
			root.addView(entryView);
		} catch (Exception _) { }
	}
	
	private void loadTable()
	{
		try {
			Scanner in = new Scanner(openFileInput(filename));
			String line;
			while((line = in.nextLine()) != null)
				table.add(line);
			in.close();
		} 
		catch (FileNotFoundException _) { }
		catch (NoSuchElementException _) { }
	}
	
	private void saveTable()
	{
		try {
			PrintStream out = new PrintStream(openFileOutput(filename, MODE_PRIVATE));
			for(String elem : table)
				out.println(elem.trim());
			out.close();
		} catch (FileNotFoundException e) { }
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		root = new LinearLayout(this);
		root.setOrientation(LinearLayout.VERTICAL);
		
		newEntryButton = new Button(this);
		newEntryButton.setText("New Entry");
		newEntryButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View source) 
			{
				final EditText textBox = new EditText(MainActivity.this);
				new AlertDialog.Builder(MainActivity.this)
					.setTitle("New entry")
					.setMessage("Enter value:")
					.setView(textBox)
					.setCancelable(false)
					.setNegativeButton("Cancel", null)
					.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) 
						{
							final String entry = textBox.getText().toString();
							table.add(entry);
							saveTable();
							addNewView(entry);
						}
					}).create().show();
			}
		});
		
		root.addView(newEntryButton);
		loadTable();
		for(String elem : table)
			addNewView(elem);
		
		setContentView(root);
	}
}
