package td.nhan.lab01_exe02_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import td.nhan.lab01_exe02_listview.model.Job;

public class MainActivity extends AppCompatActivity {

    String rbValue;
    ListView listView;
    JobAdapter jobAdapter;
    List<Job> jobs = new ArrayList<>();

    EditText nameEditText, salaryEditText, dateCreatedEditText;
    Spinner imgSpinner;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        jobAdapter = new JobAdapter(this, jobs, R.layout.list_item);
        listView.setAdapter(jobAdapter);

        nameEditText = findViewById(R.id.etName);
        salaryEditText = findViewById(R.id.etSalary);
        dateCreatedEditText = findViewById(R.id.date);
        Calendar c = Calendar.getInstance();

        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        dateCreatedEditText.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year, month, dayOfMonth) -> {
                dateCreatedEditText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });
        dateCreatedEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year, month, dayOfMonth) -> {
                        dateCreatedEditText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
            }
        });

        imgSpinner = findViewById(R.id.sp_img);
        List<Integer> imgids = new ArrayList<>();
        imgids.add(R.drawable.facebook_logo_png_9024);
        imgids.add(R.drawable.google_logo_png_29546);
        imgids.add(R.drawable.iphone_12_red);

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, imgids);
        imgSpinner.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        addButton = findViewById(R.id.add);
        addButton.setOnClickListener(v -> {
            int resImg = (int) imgSpinner.getSelectedItem();
            String name = String.valueOf(nameEditText.getText());
            Long salary = Long.valueOf(String.valueOf(salaryEditText.getText()));
            String dateCreated = String.valueOf(dateCreatedEditText.getText());

            Job job = new Job(resImg, name, salary, dateCreated);

            jobs.add(job);
            jobAdapter.notifyDataSetChanged();
        });

    }

    public void onRadioButtonClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        if (checked) {
            rbValue = ((RadioButton) v).getText().toString();
        }
    }
}