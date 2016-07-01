package com.example.student.myapplication.List_eleve;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.student.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListExo extends AppCompatActivity {

    ArrayList<Eleve> eleves = new ArrayList<>();
    ListView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exo);

        for(int i =0;i<1000000;i++){
            eleves.add(new Eleve("add"+i,Integer.toString(i)));
        }


        view = (ListView) findViewById(R.id.list_view);
        EleveAdapter adapter = new EleveAdapter(this,eleves);
        view.setAdapter(adapter);
    }

    public class EleveAdapter extends ArrayAdapter<Eleve> {
        public EleveAdapter(Context context, ArrayList<Eleve> eleve) {
            super(context, 0, eleve);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Eleve eleve = getItem(position);
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.list_item_eleve, parent, false);
                viewHolder.name = (TextView) convertView.findViewById(R.id.eleve_name);
                viewHolder.note = (TextView) convertView.findViewById(R.id.eleve_note);
                convertView.setTag(viewHolder);
            }else{
                  viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.name.setText(eleve.getName());
            viewHolder.note.setText(eleve.getNote());
            return convertView;
        }
    }

    public static class ViewHolder {
        TextView name;
        TextView note;
    }
}
