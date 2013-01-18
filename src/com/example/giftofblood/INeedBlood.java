package com.example.giftofblood;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class INeedBlood extends Activity implements OnClickListener, DialogInterface.OnClickListener, OnItemSelectedListener{

	Button buttonSendRequest;
	EditText editTextName;
	EditText editTextSurname;
	EditText editTextPhoneNumber;
	EditText editTextHospitalPhoneNumber;
	EditText editTextEMail;
	Spinner spinnerCountry;
	Spinner spinnerBloodType;
	Spinner spinnerCity;
	String[] BloodType = {"0+","0-","A+","A-","B+","B-","AB+","AB-"};
	String[] Countries = {"Bosna i Hercegovina", "Hrvatska", "Srbija", "Crna Gora", "Slovenija", "Makedonija"};
	String[] Cities_Bosnia = {"Bihac","Mostar","Sarajevo", "Tuzla","Zenica"};
	String[] Cities_Croatia = {"Dubrovnik", "Split", "Zagreb", "Varazdin", "Karlovac", "Osijek"};
	String[] Cities_Serbia = {"Beograd", "Nis","Novi Sad", "Kragujevac","Cacak","Subotica"};
	String[] Cities_Montenegro = {"Budva", "Bar","Podgorica","Herceg Novi","Niksic"};
	String[] Cities_Slovenia = {"Ljubljana", "Maribor", "Celje"};
	String[] Cities_Macedonia ={"Skopje","Bitola", "Ohrid", "Kumanovo","Strumica","Veles"};
	
	ArrayAdapter<String> adapterBloodType;
	ArrayAdapter<String> adapterCountries;
	ArrayAdapter<String> adapterCities;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		 setContentView(R.layout.ineedblood);
		
		 buttonSendRequest = (Button) findViewById(R.id.buttonAskHelp);
		 editTextName = (EditText) findViewById(R.id.editTextName);
		 editTextSurname = (EditText) findViewById(R.id.editTextSurname);
		 editTextPhoneNumber = (EditText) findViewById(R.id.editTextTelephoneNumber);
		 editTextHospitalPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
		 editTextEMail = (EditText) findViewById(R.id.editTextEMail);
		 spinnerBloodType = (Spinner) findViewById(R.id.listBloodType);
		 spinnerCity = (Spinner) findViewById(R.id.listCity);
		 spinnerCountry = (Spinner) findViewById(R.id.listCountry);
		 
			adapterBloodType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,BloodType);
			spinnerBloodType.setAdapter(adapterBloodType);
			
			
			adapterCountries = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Countries);
			spinnerCountry.setAdapter(adapterCountries);
		 
		spinnerCountry.setOnItemSelectedListener(this);
		buttonSendRequest.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ineedblood, menu);
		return true;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 * On button send click, create dialog
	 */
	@Override
	public void onClick(View v) {
				if(v == buttonSendRequest)
				{
					Builder dialog = new AlertDialog.Builder(this);
					String str = new String();
					
					str += getResources().getString(R.string.titleName);
					str += editTextName.getText().toString();
					str += '\n';
					
					str += getResources().getString(R.string.titleSurname);
					str += editTextSurname.getText().toString();
					str += '\n';
					
					str += getResources().getString(R.string.titleHospitalTelephoneNumber);
					str += editTextHospitalPhoneNumber.getText().toString();
					str += '\n';
					
					str += getResources().getString(R.string.titleTelephoneNumber);
					str += editTextPhoneNumber.getText().toString();
					str += '\n';
					
					str += getResources().getString(R.string.titleEMail);
					str += editTextEMail.getText().toString();
					str += '\n';
					
					str += getResources().getString(R.string.titleBloodType);
					str += spinnerBloodType.getSelectedItem().toString();
					str += '\n';
					
					str += getResources().getString(R.string.titleCountry);	
					str += spinnerCountry.getSelectedItem().toString();
					str += '\n';		
					
					str += getResources().getString(R.string.titleCity);
					str += spinnerCity.getSelectedItem().toString();
					
					dialog.setTitle(getResources().getString(R.string.titleConfirm));
					dialog.setMessage(str);
					
					dialog.setPositiveButton(getResources().getString(R.string.buttonPositive), this);
					dialog.setNegativeButton(getResources().getString(R.string.buttonNegative), this);
					
					dialog.create();
					dialog.show();
				}
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.content.DialogInterface.OnClickListener#onClick(android.content.DialogInterface, int)
	 * 
	 * When buttons from dialogs clicked(check if positive)
	 */
	@Override 
	public void onClick(DialogInterface dialog, int arg1) 
		{
		
			if(arg1 == DialogInterface.BUTTON_POSITIVE)
			{
				Toast.makeText(INeedBlood.this, "poslano" , Toast.LENGTH_SHORT).show();	
			}
			
			else if(arg1 == DialogInterface.BUTTON_NEGATIVE)
			{
				Toast.makeText(INeedBlood.this, "nije poslano" , Toast.LENGTH_SHORT).show();	
			}
			
			else
			{
				Toast.makeText(INeedBlood.this, "nedefinisano" , Toast.LENGTH_SHORT).show();	
			}
		
		}

	@Override
	public void onItemSelected(AdapterView<?> ad, View v, int arg2, long arg3) 
	{
			switch(arg2)
			{
				
				case 0: //Bosna
					adapterCities = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Cities_Bosnia);
					spinnerCity.setAdapter(adapterCities);
				break;
				
				case 1: //Hrvatska
					adapterCities = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Cities_Croatia);
					spinnerCity.setAdapter(adapterCities);
				break;
				
				case 2: //Srbija
					adapterCities = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Cities_Serbia);
					spinnerCity.setAdapter(adapterCities);
				break;
				case 3: //Crna gora
					adapterCities = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Cities_Montenegro);
					spinnerCity.setAdapter(adapterCities);					
				break;
				
				case 4: //Slovenija
					adapterCities = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Cities_Slovenia);
					spinnerCity.setAdapter(adapterCities);
				break;
				
				case 5: //Makedonija
					adapterCities = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Cities_Macedonia);
					spinnerCity.setAdapter(adapterCities);				
				break;
				
				default:
				break;
			}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
