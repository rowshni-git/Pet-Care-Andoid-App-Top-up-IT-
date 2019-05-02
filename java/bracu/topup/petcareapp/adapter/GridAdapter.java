package bracu.topup.petcareapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import bracu.topup.petcareapp.R;
import bracu.topup.petcareapp.model.Selector;

/**
 * Created by Usha on 2/28/2018.
 */

public class GridAdapter extends BaseAdapter {

    ArrayList<Selector> arrayList = new ArrayList<>();
    Context context;

    public GridAdapter(ArrayList<Selector> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.item_layout, null);

        ImageView imageView = customView.findViewById(R.id.imageView);
        TextView textView = customView.findViewById(R.id.textV);

        imageView.setImageResource(arrayList.get(position).getImageSrc());
        textView.setText(arrayList.get(position).getTitle());

        return customView;
    }
}
