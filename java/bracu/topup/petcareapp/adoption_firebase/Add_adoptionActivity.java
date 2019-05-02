package bracu.topup.petcareapp.adoption_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bracu.topup.petcareapp.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import bracu.topup.petcareapp.adapter.CustomListAdapter_adopt;
import bracu.topup.petcareapp.model.AdoptUser;

public class Add_adoptionActivity extends AppCompatActivity {
    EditText editTextapetname, editTextapetage, editTextapetgender, editTextapetnumber;
    //ListView listViewA;
    String adoptUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_adoption);

        editTextapetname=findViewById(R.id.apetname);
        editTextapetage=findViewById(R.id.apetage);
        editTextapetgender=findViewById(R.id.apetgender);
        editTextapetnumber=findViewById(R.id.apetnumber);
    }

    //save data to fire//
    public void saveToFirebaseDB(View view){

        boolean error = false;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference adoptDatabase = database.getReference("adoptUsers");
        adoptUserID = adoptDatabase.push().getKey();



        //validity//
String AdoptPetName = editTextapetname.getText().toString();
        if (AdoptPetName.isEmpty()) {
            editTextapetname.setError("Name is missing!");
            error = true;
        } else if (AdoptPetName.length() < 2) {
            editTextapetname.setError("Name is too short!");
            error = true;
        }
String AdoptPetAge = editTextapetage.getText().toString();
        if (AdoptPetAge.isEmpty()) {
            editTextapetage.setError("Pet age is missing!");
            error = true;
        }
String AdoptPetGnder = editTextapetgender.getText().toString();
        if (AdoptPetGnder.isEmpty()) {
            editTextapetgender.setError("Gender is missing!");
            error = true;
        }


String Adoptnumber= editTextapetnumber.getText().toString();
        if (Adoptnumber.isEmpty()) {
            editTextapetnumber.setError("Phone No is missing!");
            error = true;
        } else if (Adoptnumber.length() == 11) {
            if (Adoptnumber.startsWith("017") || Adoptnumber.startsWith("018") || Adoptnumber.startsWith("019")|| Adoptnumber.startsWith("016") ||Adoptnumber.startsWith("015")) {

            } else {
                editTextapetnumber.setError("Phone no is not valid!");
            }
        } else {
            editTextapetnumber.setError("Phone No should be 11 digit!");
            error = true;
        }

        if (error) {
            Toast.makeText(Add_adoptionActivity.this, "Data is not correct!", Toast.LENGTH_LONG).show();

        } else {
           // clearData(view);
            AdoptUser adoptUser = new AdoptUser (AdoptPetName,AdoptPetAge,AdoptPetGnder,Adoptnumber);
            adoptDatabase.child(adoptUserID).setValue(adoptUser);
            Toast.makeText(Add_adoptionActivity.this, "Data is updated",Toast.LENGTH_LONG).show();
//go back
            Intent intent = new Intent(Add_adoptionActivity.this,Adopt_Activity.class);
            startActivity(intent);
            //adapter.notifyDataSetChanged();
            Toast.makeText(Add_adoptionActivity.this, "Data is inserted", Toast.LENGTH_LONG).show();
            finish();
        }


    }
    public void cancelAddition(View view){
        Toast.makeText(Add_adoptionActivity.this, "Cancelled",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(Add_adoptionActivity.this,Adopt_Activity.class);
        startActivity(intent);
        finish();
    }



}
