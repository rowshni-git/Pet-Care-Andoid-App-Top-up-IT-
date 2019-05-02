package bracu.topup.petcareapp.PetInfo_firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import bracu.topup.petcareapp.R;
import bracu.topup.petcareapp.model.PetUser;

public class AddPet_Activity extends AppCompatActivity {
    EditText editTextMYpetname, editTextMYpetage, editTextMYpetgender, editTextMYpettype;
    //ListView listViewA;
    String petUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        editTextMYpetname = findViewById(R.id.addmypetname);
        editTextMYpetage = findViewById(R.id.addmypetage);
        editTextMYpetgender = findViewById(R.id.addmypetgender);
        editTextMYpettype = findViewById(R.id.addmypettype);
    }


    //save data to fire//
    public void saveToFirebaseDB(View view) {

        boolean error = false;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference petDatabase = database.getReference("petUsers01");
        petUserID = petDatabase.push().getKey();


        //validity//
        String AddPetName = editTextMYpetname.getText().toString();
        if (AddPetName.isEmpty()) {
            editTextMYpetname.setError("Pet Name is missing!");
            error = true;
        } else if (AddPetName.length() < 2) {
            editTextMYpetname.setError("Pet Name is too short!");
            error = true;
        }
        String AddPetAge = editTextMYpetage.getText().toString();
        if (AddPetAge.isEmpty()) {
            editTextMYpetage.setError("Pet age is missing!");
            error = true;
        }
        String AddPetGnder = editTextMYpetgender.getText().toString();
        if (AddPetGnder.isEmpty()) {
            editTextMYpetgender.setError("Gender is missing!");
            error = true;
        }
        String AddPetType = editTextMYpettype.getText().toString();
        if (AddPetType.isEmpty()) {
            editTextMYpettype.setError("Pet type is missing!");
            error = true;
        }


        if (error) {
            Toast.makeText(AddPet_Activity.this, "Data is not correct!", Toast.LENGTH_LONG).show();

        } else {
            // clearData(view);
            PetUser petUser = new PetUser (AddPetName,AddPetAge,AddPetGnder,AddPetType);
            petDatabase.child(petUserID).setValue(petUser);
            Toast.makeText(AddPet_Activity.this, "Data is updated",Toast.LENGTH_LONG).show();
//go back
            Intent intent = new Intent(AddPet_Activity.this,Pet_Activity.class);
            startActivity(intent);
            //adapter.notifyDataSetChanged();
            Toast.makeText(AddPet_Activity.this, "Data is inserted", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    public void cancelAddition(View view){
        Toast.makeText(AddPet_Activity.this, "Cancelled",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(AddPet_Activity.this,Pet_Activity.class);
        startActivity(intent);
        finish();
    }



}
