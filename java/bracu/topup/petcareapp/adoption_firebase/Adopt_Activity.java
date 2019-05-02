package bracu.topup.petcareapp.adoption_firebase;

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

import bracu.topup.petcareapp.adapter.CustomListAdapter_adopt;
import bracu.topup.petcareapp.model.AdoptUser;

public class Adopt_Activity extends AppCompatActivity {
    ListView listView;
    ArrayList<AdoptUser> adoptUserArrayList;
    CustomListAdapter_adopt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt);

        //list view
        listView= findViewById(R.id.addAdoptList);
        adoptUserArrayList= new ArrayList<AdoptUser>();
        // adapter = new ArrayAdapter<AdoptUser>(Add_AdoptionActivity.this, android.R.layout.simple_expandable_list_item_1,adoptUserArrayList);

        adapter = new CustomListAdapter_adopt(Adopt_Activity.this, adoptUserArrayList);
        listView.setAdapter(adapter);
        getDataFromFirebase();
    }

    private void getDataFromFirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("adoptUsers");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adoptUserArrayList.clear();
                for(DataSnapshot userSnap : dataSnapshot.getChildren()){
                    String name = userSnap.child("apetname").getValue().toString();
                    String age = userSnap.child("apetage").getValue().toString();
                    String gender = userSnap.child("apetgender").getValue().toString();
                    String number = userSnap.child("apetnumber").getValue().toString();

                    AdoptUser adoptUser = new AdoptUser (name,age,gender,number);
                    adoptUserArrayList.add(adoptUser);
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
    public void addAdoptionItem(View view){

        Intent intent = new Intent(Adopt_Activity.this,Add_adoptionActivity.class);
        startActivity(intent);
        finish();
    }


}
