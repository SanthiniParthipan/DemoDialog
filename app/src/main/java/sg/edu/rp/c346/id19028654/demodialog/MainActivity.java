package sg.edu.rp.c346.id19028654.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.time.Month;
import java.time.MonthDay;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2,btnDemo3,btnEx3,btnDate,btnTime;
    TextView tvDemo2 ,tvDemo3,tvEx3,tvDate,tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDemo1=findViewById(R.id.buttonDemo1);
        btnDemo2= findViewById(R.id.buttonDemo2);
        tvDemo2= findViewById(R.id.textViewDemo2);
        btnDemo3=findViewById(R.id.buttonDemo3);
        tvDemo3=findViewById(R.id.textViewDemo3);
        btnEx3=findViewById(R.id.buttonExcerise);
        tvEx3=findViewById(R.id.textViewExercise);
        btnDate=findViewById(R.id.buttonDatePic);
        tvDate=findViewById(R.id.textViewDate);
        btnTime=findViewById(R.id.buttonTime);
        tvTime=findViewById(R.id.textViewTime);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener= new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourofDay, int minute) {

                        tvTime.setText("Time:"+ hourofDay + ":" + minute);
                    }


                };
                Calendar now = Calendar.getInstance();  //Create a Calendar object with current date and time

                int hour = now.get(Calendar.HOUR);
                int min= now.get(Calendar.MINUTE);
                int mind =now.get(Calendar.HOUR_OF_DAY);



                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,hour,min,true);
                myTimeDialog.show();
            }
        });


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener= new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        tvDate.setText("Date:"+ dayOfMonth + "/" + (monthOfYear+1)+ "/" +year);
                    }


                };
                Calendar now = Calendar.getInstance();  //Create a Calendar object with current date and time

                int Day = now.get(Calendar.DAY_OF_MONTH);
                int year= now.get(Calendar.YEAR);
                int Month= now.get(Calendar.MONTH);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,myDateListener ,year,Month,Day);
                myDateDialog.show();
            }
        });

        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.inputex, null);


                final EditText etInput1 = viewDialog.findViewById(R.id.editTextNum1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextNum2);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);


                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int message1 = Integer.valueOf(etInput1.getText().toString());
                        int  message2 =Integer.valueOf(etInput2.getText().toString());
                        String sum2 = String.valueOf(message1 + message2);
                        tvEx3.setText(sum2);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);


                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);


                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3 -Text Inout Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = etInput.getText().toString();
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });




        btnDemo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);


                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive");

                    }
                });

                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative");

                    }
                });

                myBuilder.setNeutralButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }

        });

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                /*
                myBuilder.setTitle("Demo 1 -Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("close",null);
*/

                    myBuilder.setTitle("Congratulations");
                    myBuilder.setMessage("you have completed a simple dialog Box");
                    myBuilder.setCancelable(false);
                    myBuilder.setPositiveButton("DISMISS",null);
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();
                }


            });
        }
    }
