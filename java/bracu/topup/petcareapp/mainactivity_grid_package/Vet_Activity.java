package bracu.topup.petcareapp.mainactivity_grid_package;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bracu.topup.petcareapp.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import bracu.topup.petcareapp.R;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import bracu.topup.petcareapp.adapter.CustomAdapter_VET;
import bracu.topup.petcareapp.adapter.CustomListAdapter_adopt;
import bracu.topup.petcareapp.adoption_firebase.Adopt_Activity;

import bracu.topup.petcareapp.model.Vetuser;
public class Vet_Activity extends AppCompatActivity {

    ListView listView;
    ArrayList<Vetuser> vetarraylist;
    CustomAdapter_VET vadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet);

        //list view
        listView= findViewById(R.id.addVet);
        vetarraylist= new ArrayList<Vetuser>();
        // adapter = new ArrayAdapter<AdoptUser>(Add_AdoptionActivity.this, android.R.layout.simple_expandable_list_item_1,adoptUserArrayList);

        vadapter = new CustomAdapter_VET(Vet_Activity.this, vetarraylist);
        listView.setAdapter(vadapter);
        getDataFromFirebase();
    }

    private void getDataFromFirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("vetUserEntry");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vetarraylist.clear();
                for(DataSnapshot userSnap : dataSnapshot.getChildren()){
                    String vetname = userSnap.child("vetname").getValue().toString();
                    String vetspecial = userSnap.child("vetspecial").getValue().toString();
                    String vetnumber = userSnap.child("vetnumber").getValue().toString();
                    String vetchamber = userSnap.child("vetchamber").getValue().toString();

                    Vetuser Vetuser = new Vetuser (vetname,vetspecial,vetnumber,vetchamber);
                    vetarraylist.add(Vetuser);
                    vadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("DATAerror", "Failed to read value.", error.toException());
            }
        });
    }


    //dialog call text or cancel Vet

}
