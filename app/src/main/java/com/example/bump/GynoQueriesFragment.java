package com.example.bump;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GynoQueriesFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class GynoQueriesFragment extends ListFragment {

    String[] questions={"How is my due date determined?","What are prenatal vitamins, and why do I need them?","What prenatal vitamins do you recommend?","How can I tell if the symptoms I'm having are normal?","When should I call a doctor?","How much weight should I gain?","When is my baby due?"};


    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        //MAP
        HashMap<String, String> map=new HashMap<String, String>();

        //FILL
        for (String question : questions) {
            map = new HashMap<String, String>();
            map.put("Question", question);


            data.add(map);
        }

        //KEYS IN MAP
        String[] from={"Question"};

        //IDS OF VIEWS
        int[] to={R.id.questionTxt1};

        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.model4, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

         getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
//                // TODO Auto-generated method stub
//
//

                HashMap<String, String> s= data.get(pos);
                GynoMainPage mn2=(GynoMainPage) getActivity();
                mn2.f2(s);
//
//
//

//        Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();
////
            }
        });
    }
}