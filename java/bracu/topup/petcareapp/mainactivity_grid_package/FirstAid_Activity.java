package bracu.topup.petcareapp.mainactivity_grid_package;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import bracu.topup.petcareapp.R;
import bracu.topup.petcareapp.adapter.GridAdapter;
import bracu.topup.petcareapp.firstaid_package.Diet_Activity;
import bracu.topup.petcareapp.firstaid_package.Grooming_Activity;
import bracu.topup.petcareapp.firstaid_package.Health_Activity;
import bracu.topup.petcareapp.firstaid_package.Medicine_Activity;
import bracu.topup.petcareapp.firstaid_package.Vacc_Activity;
import bracu.topup.petcareapp.model.Selector;

public class FirstAid_Activity extends AppCompatActivity {
    GridView gridView;
    GridAdapter adapter;
    ArrayList<Selector> selector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaid);

        gridView = findViewById(R.id.gridView);
        selector = new ArrayList<>();
        setData();
        adapter = new GridAdapter(selector, FirstAid_Activity.this);
        gridView.setAdapter(adapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int finalT = i;

                if(finalT==0) //open account
                {
                    Intent intent = new Intent(FirstAid_Activity.this,Vacc_Activity.class);
                    startActivity(intent);
                }
                else if(finalT==1) //open vet
                {
                    Intent intent = new Intent(FirstAid_Activity.this,Medicine_Activity.class);
                    startActivity(intent);
                }else if(finalT==2) //open gallery
                {
                    Intent intent = new Intent(FirstAid_Activity.this,Diet_Activity.class);
                    startActivity(intent);
                }
                else if(finalT==3) //open gallery
                {
                    Intent intent = new Intent(FirstAid_Activity.this,Grooming_Activity.class);
                    startActivity(intent);
                }
                else if(finalT==4) //open gallery
                {
                    Intent intent = new Intent(FirstAid_Activity.this, Health_Activity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(FirstAid_Activity.this, "Invalid entry", Toast.LENGTH_SHORT).show();
                }




                /////
            }
        });

    }

    private void setData() {
        Selector vacc = new Selector(R.drawable.vacc, "Vaccination");
        Selector med = new Selector(R.drawable.meds, "Medicines");
        Selector diet = new Selector(R.drawable.food, "Diet Plan");
        Selector groomer = new Selector(R.drawable.groomer, "Grooming");
        Selector condition = new Selector(R.drawable.condition, "Condition");

        selector.add(vacc);
        selector.add(med);
        selector.add(diet);
        selector.add(groomer);
        selector.add(condition);



    }
}
