package bracu.topup.petcareapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import bracu.topup.petcareapp.R;
import bracu.topup.petcareapp.model.AdoptUser;

/**
 * Created by Uttal on 3/28/2018.
 */

public class CustomListAdapter_adopt extends BaseAdapter {

    Context context;
    ArrayList<AdoptUser> arrayList;

    public CustomListAdapter_adopt(Context context, ArrayList<AdoptUser> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
    public View getView(final int i,final View view,final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.item_list_adopt, null);

        RelativeLayout relativeL = customView.findViewById(R.id.relativeLadopt);
        TextView adpetname = (TextView)customView.findViewById(R.id.adpetname);
        TextView adpetage =  (TextView)customView.findViewById(R.id.adpetage);
        TextView adpetgender = (TextView) customView.findViewById(R.id.adpetgender);
        TextView adpetnumber = (TextView) customView.findViewById(R.id.adpetnumber);



        adpetname.setText(arrayList.get(i).getApetname()+"");
        adpetage.setText(arrayList.get(i).getApetage()+"");
        adpetgender.setText(arrayList.get(i).getApetgender()+"");
        adpetnumber.setText(arrayList.get(i).getApetnumber()+"");


        if(i%2==1)
        {
            relativeL.setBackgroundColor(context.getResources().getColor(R.color.y1));
        }else{
            relativeL.setBackgroundColor(context.getResources().getColor(R.color.y2));
        }


        return customView;
    }
}
