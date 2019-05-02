package bracu.topup.petcareapp.PetInfo_firebase;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import bracu.topup.petcareapp.R;
import bracu.topup.petcareapp.adapter.Custome_petAdapter;
import bracu.topup.petcareapp.model.PetUser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import bracu.topup.petcareapp.R;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class Pet_Activity extends AppCompatActivity {
    ListView listView;
    ArrayList<PetUser> petArrayList;
    Custome_petAdapter adapter;
    String petUserID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);

        //list view
        listView = findViewById(R.id.addPETLIST);
        petArrayList = new ArrayList<PetUser>();
        // adapter = new ArrayAdapter<AdoptUser>(Add_AdoptionActivity.this, android.R.layout.simple_expandable_list_item_1,adoptUserArrayList);

        adapter = new Custome_petAdapter(Pet_Activity.this, petArrayList);
        listView.setAdapter(adapter);
        getDataFromFirebase();

    }


    private void getDataFromFirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("petUsers01");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                petArrayList.clear();
                for(DataSnapshot userSnap : dataSnapshot.getChildren()){
                    String name = userSnap.child("mypetname").getValue().toString();
                    String age = userSnap.child("mypetage").getValue().toString();
                    String gender = userSnap.child("mypetgender").getValue().toString();
                    String type = userSnap.child("mypettype").getValue().toString();

                    PetUser petUser = new PetUser (name,age,gender,type);
                    petArrayList.add(petUser);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("DATAerror", "Failed to read value.", error.toException());
            }
        });


    }
    public void addPetItem(View view){

        Intent intent = new Intent(Pet_Activity.this,AddPet_Activity.class);
        startActivity(intent);
        finish();
    }


}
