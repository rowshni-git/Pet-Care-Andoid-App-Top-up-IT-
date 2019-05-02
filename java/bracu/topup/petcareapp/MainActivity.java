package bracu.topup.petcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


import bracu.topup.petcareapp.PetInfo_firebase.Pet_Activity;
import bracu.topup.petcareapp.adapter.GridAdapter;
import bracu.topup.petcareapp.adoption_firebase.Adopt_Activity;
import bracu.topup.petcareapp.mainactivity_grid_package.Calender_Activity;
import bracu.topup.petcareapp.mainactivity_grid_package.FirstAid_Activity;
import bracu.topup.petcareapp.mainactivity_grid_package.Foster_Activity;
import bracu.topup.petcareapp.mainactivity_grid_package.Gallery_Activity;
import bracu.topup.petcareapp.mainactivity_grid_package.Shop_Activity;
import bracu.topup.petcareapp.mainactivity_grid_package.Vet_Activity;

import bracu.topup.petcareapp.mainactivity_grid_package.AccountMain_Activity;
import bracu.topup.petcareapp.model.Selector;
public class MainActivity extends AppCompatActivity {

    GridView gridView;
    GridAdapter adapter;
    ArrayList<Selector> selector;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        selector = new ArrayList<>();
        setData();
        adapter = new GridAdapter(selector, MainActivity.this);
        gridView.setAdapter(adapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int finalT = i;

                if(finalT==0) //open account
                {
                    Intent intent = new Intent(MainActivity.this,AccountMain_Activity.class);
                    startActivity(intent);
                }
                else if(finalT==1) //open vet
                {
                    Intent intent = new Intent(MainActivity.this,Pet_Activity.class);
                    startActivity(intent);
                }else if(finalT==2) //open gallery
                {
                    Intent intent = new Intent(MainActivity.this,Vet_Activity.class);
                    startActivity(intent);
                }else if(finalT==3) //open scheduler
                {
                    Intent intent = new Intent(MainActivity.this,Gallery_Activity.class);
                    startActivity(intent);
                }else if(finalT==4) //open firstaid/medical
                {
                    Intent intent = new Intent(MainActivity.this,Calender_Activity.class);
                    startActivity(intent);
                }else if(finalT==5) //open shop
                {
                    Intent intent = new Intent(MainActivity.this,FirstAid_Activity.class);
                    startActivity(intent);
                }else if(finalT==6) //open adopt
                {
                    Intent intent = new Intent(MainActivity.this,Shop_Activity.class);
                    startActivity(intent);
                }else if(finalT==7) //open adopt
                {
                    Intent intent = new Intent(MainActivity.this,Adopt_Activity.class);
                    startActivity(intent);
                }
                else if(finalT==8) //open adopt
                {
                    Intent intent = new Intent(MainActivity.this,Foster_Activity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid entry", Toast.LENGTH_SHORT).show();
                }




                /////
            }
        });

    }

    private void setData() {
        Selector acc = new Selector(R.drawable.myaccount, "My Account");
        Selector vet = new Selector(R.drawable.vet, "Ask a Vet");
        Selector gallery = new Selector(R.drawable.gall, "Gallery");
        Selector schedule = new Selector(R.drawable.calen, "Calender");
        Selector care = new Selector(R.drawable.aid, "Care Guide");
        Selector shop = new Selector(R.drawable.shop, "Shop Online");
        Selector adopt = new Selector(R.drawable.adopt, "Adopt");
        Selector foster = new Selector(R.drawable.foster, "Foster Home");
        Selector pet = new Selector(R.drawable.mypet,"My Pets");
        selector.add(acc);
        selector.add(pet);
        selector.add(vet);
        selector.add(gallery);
        selector.add(schedule);
        selector.add(care);
        selector.add(shop);
        selector.add(adopt);
        selector.add(foster);

    }
}
