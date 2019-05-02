package bracu.topup.petcareapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import bracu.topup.petcareapp.R;
import bracu.topup.petcareapp.model.Vetuser;

/**
 * Created by User-PC on 4/17/2018.
 */

public class CustomAdapter_VET extends BaseAdapter {

    Context context;
    ArrayList<Vetuser> varrayList;
    LayoutInflater inflater;

    public CustomAdapter_VET(Context context, ArrayList<Vetuser> varrayList) {
        this.context = context;
        this.varrayList = varrayList;
    }

    @Override
    public int getCount() {
        return varrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, final View view, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.item_list_vet, null);
        RelativeLayout relativeLvet = customView.findViewById(R.id.relativeLVET);
        TextView vetname = (TextView)customView.findViewById(R.id.advetname);
        TextView vetspecial =  (TextView)customView.findViewById(R.id.advetspeciality);
        TextView vetnumber = (TextView) customView.findViewById(R.id.advetnumber);
        TextView vetchamber = (TextView) customView.findViewById(R.id.advetchamber);
ImageView callIcon = customView.findViewById(R.id.vetphoneimage);

callIcon.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String uri = varrayList.get(i).getVetnumber();
        intent.setData(Uri.parse("tel:"+uri));
        context.startActivity(intent);
    }
});

        vetname.setText(varrayList.get(i).getVetname()+"");
        vetspecial.setText(varrayList.get(i).getVetspecial()+"");
        vetnumber.setText(varrayList.get(i).getVetnumber()+"");
        vetchamber.setText(varrayList.get(i).getVetchamber()+"");

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(i%2==1)
        {
            relativeLvet.setBackgroundColor(context.getResources().getColor(R.color.y1));
        }else{
            relativeLvet.setBackgroundColor(context.getResources().getColor(R.color.y2));
        }


        return customView;
    }
}
