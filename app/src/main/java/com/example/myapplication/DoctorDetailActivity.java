package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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

public class DoctorDetailActivity extends AppCompatActivity {
    private String[][] doctor_details1= {
            {"Doctor Name : Ajith Perera", "Hospital address: Colombo","Exp:16Yrs", "Mobile:0765867854","1800"},
            {"Doctor Name : Namal Ranasinghe", "Hospital address: Kollupitiya","Exp:19Yrs", "Mobile:0765863454","2000"},
            {"Doctor Name : Nimal Rathnayaka", "Hospital address: Karapitiya","Exp:26Yrs", "Mobile:0763245678","2200"},
            {"Doctor Name : Malani Bulathsinghe", "Hospital address: Colombo","Exp:36Yrs", "Mobile:0786767854","2800"},
            {"Doctor Name : Wajira Perera", "Hospital address: kandy","Exp:30Yrs", "Mobile:0715067854","3000"}
    };
    private String[][] doctor_details2= {
            {"Doctor Name : Ajith Perera", "Hospital address: Colombo","Exp:16Yrs", "Mobile:0765867854","1800"},
            {"Doctor Name : Namal Ranasinghe", "Hospital address: Kollupitiya","Exp:19Yrs", "Mobile:0765863454","2000"},
            {"Doctor Name : Nimal Rathnayaka", "Hospital address: Karapitiya","Exp:26Yrs", "Mobile:0763245678","2200"},
            {"Doctor Name : Malani Bulathsinghe", "Hospital address: Colombo","Exp:36Yrs", "Mobile:0786767854","2800"},
            {"Doctor Name : Wajira Perera", "Hospital address: kandy","Exp:30Yrs", "Mobile:0715067854","3000"}
    };
    private String[][] doctor_details3= {
            {"Doctor Name : Ajith Perera", "Hospital address: Colombo","Exp:16Yrs", "Mobile:0765867854","1800"},
            {"Doctor Name : Namal Ranasinghe", "Hospital address: Kollupitiya","Exp:19Yrs", "Mobile:0765863454","2000"},
            {"Doctor Name : Nimal Rathnayaka", "Hospital address: Karapitiya","Exp:26Yrs", "Mobile:0763245678","2200"},
            {"Doctor Name : Malani Bulathsinghe", "Hospital address: Colombo","Exp:36Yrs", "Mobile:0786767854","2800"},
            {"Doctor Name : Wajira Perera", "Hospital address: kandy","Exp:30Yrs", "Mobile:0715067854","3000"}
    };
    private String[][] doctor_details4= {
            {"Doctor Name : Ajith Perera", "Hospital address: Colombo","Exp:16Yrs", "Mobile:0765867854","1800"},
            {"Doctor Name : Namal Ranasinghe", "Hospital address: Kollupitiya","Exp:19Yrs", "Mobile:0765863454","2000"},
            {"Doctor Name : Nimal Rathnayaka", "Hospital address: Karapitiya","Exp:26Yrs", "Mobile:0763245678","2200"},
            {"Doctor Name : Malani Bulathsinghe", "Hospital address: Colombo","Exp:36Yrs", "Mobile:0786767854","2800"},
            {"Doctor Name : Wajira Perera", "Hospital address: kandy","Exp:30Yrs", "Mobile:0715067854","3000"}
    };
    private String[][] doctor_details5= {
            {"Doctor Name : Ajith Perera", "Hospital address: Colombo","Exp:16Yrs", "Mobile:0765867854","1800"},
            {"Doctor Name : Namal Ranasinghe", "Hospital address: Kollupitiya","Exp:19Yrs", "Mobile:0765863454","2000"},
            {"Doctor Name : Nimal Rathnayaka", "Hospital address: Karapitiya","Exp:26Yrs", "Mobile:0763245678","2200"},
            {"Doctor Name : Malani Bulathsinghe", "Hospital address: Colombo","Exp:36Yrs", "Mobile:0786767854","2800"},
            {"Doctor Name : Wajira Perera", "Hospital address: kandy","Exp:30Yrs", "Mobile:0715067854","3000"}
    };

    TextView tv;
    String [][]getDoctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        tv = findViewById(R.id.textViewDDTitle);
        Button btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            getDoctor_details  = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            getDoctor_details  = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            getDoctor_details  = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            getDoctor_details  = doctor_details4;
        else
            getDoctor_details  = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailActivity.this,FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i< getDoctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",getDoctor_details[i][0]);
            item.put("line2",getDoctor_details[i][1]);
            item.put("line3",getDoctor_details[i][2]);
            item.put("line4",getDoctor_details[i][3]);
            item.put("line5","Cons Fees:"+getDoctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it=new Intent(DoctorDetailActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",getDoctor_details[i][0]);
                it.putExtra("text3",getDoctor_details[i][1]);
                it.putExtra("text4",getDoctor_details[i][3]);
                it.putExtra("text5",getDoctor_details[i][4]);
                startActivity(it);

            }
        });
    }
}