package com.gdglima.example.appudacity.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdglima.example.appudacity.R;
import com.gdglima.example.appudacity.model.entity.CursoEntity;

import java.util.List;

/**
 * Created by emedinaa on 07/03/2015.
 */

public class CursoAdapter extends BaseAdapter{

    /**
     * Current context
     */
    protected Context mContext;

    private LayoutInflater mInflater;
    private List<CursoEntity> data;

    // -------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------

    public CursoAdapter(Context context, List<CursoEntity> objects) {

        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        data= objects;
    }


    // -------------------------------------------------------------
    //  getView()
    // -------------------------------------------------------------

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int i) {
        return this.data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // A ViewHolder keeps references to children views to avoid unneccessary calls
        // to findViewById() on each row.
        ViewHolder holder;

        // When convertView is not null, we can reuse it directly, there is no need
        // to reinflate it. We only inflate a new View when the convertView supplied
        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.row_cursos, parent, false);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to.
            holder = new ViewHolder();

            // TODO store references to your views
            //holder.text = (TextView) convertView.findViewById(R.id.text);
            holder.tviCursoName= (TextView)convertView.findViewById(R.id.tviCursoName);
            holder.iviCurso= (ImageView)convertView.findViewById(R.id.iviCurso);
            convertView.setTag(holder);

        } else {
            // Get the ViewHolder back to get fast access to the TextView
            // and the ImageView.
            holder = (ViewHolder) convertView.getTag();
        }

        CursoEntity item = (CursoEntity)getItem(position);


        if (item != null) {
            // TODO Bind your data efficiently with the holder.
            //holder.text.setText(item.getName());
            holder.tviCursoName.setText(item.getName());
        }


        return convertView;
    }

    // -------------------------------------------------------------
    //  ViewHolder
    // -------------------------------------------------------------

    private static class ViewHolder {

        // TODO define members for each view in the item layout
        //public TextView text;
        public ImageView iviCurso;
        public TextView tviCursoName;

    }


    // -------------------------------------------------------------
    //  Getters and Setters
    // -------------------------------------------------------------


    public Context getContext() {
        return mContext;
    }

}
