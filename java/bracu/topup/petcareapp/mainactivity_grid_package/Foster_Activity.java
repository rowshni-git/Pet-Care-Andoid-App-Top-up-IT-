package bracu.topup.petcareapp.mainactivity_grid_package;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import bracu.topup.petcareapp.R;
import bracu.topup.petcareapp.fosteractivity_package.CLB_fosterActivity;
import bracu.topup.petcareapp.fosteractivity_package.Prani_fosterActivity;

import android.content.Intent;

import android.view.View;
import android.widget.Toast;

public class Foster_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foster);
    }

    public void clb(View view){
        Toast.makeText(Foster_Activity.this, "Opening webpage", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Foster_Activity.this, CLB_fosterActivity.class );
        startActivity(intent);

    }

    public void prani (View view){

        Toast.makeText(Foster_Activity.this, "Opening webpage", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Foster_Activity.this, Prani_fosterActivity.class );
        startActivity(intent);

    }
}
