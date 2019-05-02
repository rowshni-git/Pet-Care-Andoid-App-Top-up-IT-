package bracu.topup.petcareapp.mainactivity_grid_package;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bracu.topup.petcareapp.R;
import bracu.topup.petcareapp.shop_webview_package.PetbanglaActivity;
import bracu.topup.petcareapp.shop_webview_package.PetcobdActivity;
import bracu.topup.petcareapp.shop_webview_package.PetcomActivity;
import bracu.topup.petcareapp.shop_webview_package.PetsupplyActivity;

import android.content.Intent;
import android.view.View;

import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class Shop_Activity extends AppCompatActivity {

    ImageView openPetBangla, openPetcom, openPetcoBD,openPetSupply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        openPetcoBD = findViewById(R.id.petcobd);
        openPetBangla = findViewById(R.id.petbangla);
        openPetcom = findViewById(R.id.petbd);
        openPetSupply=findViewById(R.id.petsupply);



        //animation
        YoYo.with(Techniques.FlipInX)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.petbangla));
        YoYo.with(Techniques.FlipInX)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.petbd));
        YoYo.with(Techniques.FlipInX)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.petcobd));
        YoYo.with(Techniques.FlipInX)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.petsupply));

    }


    public void openPetcoBD(View view) {
        Toast.makeText(Shop_Activity.this, "Opening webpage", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Shop_Activity.this, PetcobdActivity.class );
        startActivity(intent);

    }



    public void openPetBangla(View view) {
        Toast.makeText(Shop_Activity.this, "Opening webpage", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Shop_Activity.this, PetbanglaActivity.class );
        startActivity(intent);

    }


    public void openPetcom(View view) {
        Toast.makeText(Shop_Activity.this, "Opening webpage", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Shop_Activity.this, PetcomActivity.class );
        startActivity(intent);


    }

    public void openPetSupply(View view){
        Toast.makeText(Shop_Activity.this, "Opening webpage", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Shop_Activity.this, PetsupplyActivity.class );
        startActivity(intent);


    }




}