package com.example.healthcare_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {


    private String[][] doctor_details1=
            {
                    {"Doctor Name : Abu Essa","Hospital Address : Dhaka", "Exp : 5yrs","Mobile No: 01798744525","600"},
                    {"Doctor Name : Mehedi Hassan","Hospital Address : Jessore", "Exp : 4yrs","Mobile No: 01723876532","500"},
                    {"Doctor Name : Morsed","Hospital Address : Mipur-1", "Exp : 4yrs","Mobile No: 01787890987","700"},
                    {"Doctor Name : Billah Hossain","Hospital Address : Mirpur-6", "Exp : 7yrs","Mobile No: 01724536764","600"},
                    {"Doctor Name : Jubayer ","Hospital Address : Savar", "Exp : 3yrs","Mobile No: 01776455876","500"},
            };

    private String[][] doctor_details2=
            {
                    {"Doctor Name : Abdullah","Hospital Address : Dhaka", "Exp : 5yrs","Mobile No: 01798744525","600"},
                    {"Doctor Name : Alamin","Hospital Address : Jessore", "Exp : 4yrs","Mobile No: 01723876532","500"},
                    {"Doctor Name : Mahfuz","Hospital Address : Mipur-1", "Exp : 4yrs","Mobile No: 01787890987","700"},
                    {"Doctor Name : Mriam","Hospital Address : Mirpur-6", "Exp : 7yrs","Mobile No: 01724536764","600"},
                    {"Doctor Name : Zakir ","Hospital Address : Savar", "Exp : 3yrs","Mobile No: 01776455876","500"},
            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name : Walid","Hospital Address : Dhaka", "Exp : 5yrs","Mobile No: 01798744525","600"},
                    {"Doctor Name : Rofique","Hospital Address : Jessore", "Exp : 4yrs","Mobile No: 01723876532","500"},
                    {"Doctor Name : Farhan","Hospital Address : Mipur-1", "Exp : 4yrs","Mobile No: 01787890987","700"},
                    {"Doctor Name : Fahmeda","Hospital Address : Mirpur-6", "Exp : 7yrs","Mobile No: 01724536764","600"},
                    {"Doctor Name : Korim ","Hospital Address : Savar", "Exp : 3yrs","Mobile No: 01776455876","500"},
            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name : Rima","Hospital Address : Dhaka", "Exp : 5yrs","Mobile No: 01798744525","600"},
                    {"Doctor Name : Rokibul","Hospital Address : Jessore", "Exp : 4yrs","Mobile No: 01723876532","500"},
                    {"Doctor Name : Siam","Hospital Address : Mipur-1", "Exp : 4yrs","Mobile No: 01787890987","700"},
                    {"Doctor Name : Hosain","Hospital Address : Mirpur-6", "Exp : 7yrs","Mobile No: 01724536764","600"},
                    {"Doctor Name : Sabbir ","Hospital Address : Savar", "Exp : 3yrs","Mobile No: 01776455876","500"},
            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name : Sakib","Hospital Address : Dhaka", "Exp : 5yrs","Mobile No: 01798744525","600"},
                    {"Doctor Name : Moriam","Hospital Address : Jessore", "Exp : 4yrs","Mobile No: 01723876532","500"},
                    {"Doctor Name : Yesmin","Hospital Address : Mipur-1", "Exp : 4yrs","Mobile No: 01787890987","700"},
                    {"Doctor Name : Rased","Hospital Address : Mirpur-6", "Exp : 7yrs","Mobile No: 01724536764","600"},
                    {"Doctor Name : Abdullah ","Hospital Address : Savar", "Exp : 3yrs","Mobile No: 01776455876","500"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details={};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;

    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewHADTitle);
        btn=findViewById(R.id.buttonBMCartBack);
        Intent it=getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dantist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;


            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list  = new ArrayList();
        for (int i=0;i<doctor_details.length;i++)
        {
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Fees: "+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa =new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst=findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}