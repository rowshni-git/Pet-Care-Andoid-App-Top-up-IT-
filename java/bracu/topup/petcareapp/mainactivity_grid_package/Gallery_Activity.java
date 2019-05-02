package bracu.topup.petcareapp.mainactivity_grid_package;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bracu.topup.petcareapp.R;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.GridView;

import java.util.ArrayList;

import android.view.View;

import bracu.topup.petcareapp.adapter.GalleryAdapter;
import bracu.topup.petcareapp.model.Galselector;

public class Gallery_Activity extends AppCompatActivity {

    GridView gridViewGal;
    GalleryAdapter adapterGal;
    ArrayList<Galselector> galselector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gridViewGal = findViewById(R.id.gridViewGal);
        galselector = new ArrayList<>();
        setData();
        adapterGal = new GalleryAdapter(galselector, Gallery_Activity.this);
        gridViewGal.setAdapter(adapterGal);

    }


    private void setData() {
        Galselector p1 = new Galselector(R.drawable.p1);
        Galselector p2 = new Galselector(R.drawable.p2);
        Galselector p3 = new Galselector(R.drawable.p3);
        Galselector p4 = new Galselector(R.drawable.p4);
        Galselector p5 = new Galselector(R.drawable.p5);
        Galselector p6 = new Galselector(R.drawable.p6);
        Galselector p7 = new Galselector(R.drawable.p7);
        Galselector p8 = new Galselector(R.drawable.p8);

        galselector.add(p1);
        galselector.add(p2);
        galselector.add(p3);
        galselector.add(p4);
        galselector.add(p5);
        galselector.add(p6);
        galselector.add(p7);
        galselector.add(p8);
    }

    public void addPhotos(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(Gallery_Activity.this);
        dialog.setTitle("Gallery").setMessage("Access phone media?").setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Gallery_Activity.this,Gallery_Activity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }
}
