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
import bracu.topup.petcareapp.model.PetUser;

/**
 * Created by User-PC on 4/19/2018.
 */

public class Custome_petAdapter extends BaseAdapter {

    Context context;
    ArrayList<PetUser> arrayList;

    public Custome_petAdapter(Context context, ArrayList<PetUser> arrayList) {
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
    public View getView(final int i, final View view, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.item_mypets, null);

        RelativeLayout relMypet = customView.findViewById(R.id.relMypet);
        TextView mypetname = (TextView)customView.findViewById(R.id.mypetname);
        TextView mypetage =  (TextView)customView.findViewById(R.id.mypetage);
        TextView mypetgender = (TextView) customView.findViewById(R.id.mypetgender);
        TextView mypettype = (TextView) customView.findViewById(R.id.mypettype);



        mypetname.setText(arrayList.get(i).getMypetname()+"");
       mypetage.setText(arrayList.get(i).getMypetage()+"");
       mypetgender.setText(arrayList.get(i).getMypetgender()+"");
        mypettype.setText(arrayList.get(i).getMypettype()+"");


        if(i%2==1)
        {
            relMypet.setBackgroundColor(context.getResources().getColor(R.color.y1));
        }else{
            relMypet.setBackgroundColor(context.getResources().getColor(R.color.y2));
        }


        return customView;
    }
}
