package com.example.bump;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GynecologistFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class GynecologistFragment extends ListFragment {

    String[] players={"Dr.Ander Herera","Dr.Diego Costa","Dr.Juan Mata","Dr.David De Gea","Dr.Thibaut Courtouis","Dr.Van Persie","Dr.Oscar"};
    String[] places={"Mangalore","Mumbai","Goa","Bangalore","Delhi","Mysore","Pune"};
    String[] phoneNo={"9341394245","9972638046","9900396615","9164462002","8495088892","9278360481","9023786541"};
    String[] country={"India","India","India","India","India","India","India"};
    String[] email={"ander@gmail.com","diegocosta@gmail.com","juan@gmail.com","david@gmail.com","thibaut@gmail.com","van@gmail.com","oscar@gmail.com"};
    int[] images={R.drawable.profile2,R.drawable.profile1,R.drawable.profile4,R.drawable.profile3,R.drawable.profile5,R.drawable.profile6,R.drawable.profile7};

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        //MAP
        HashMap<String, String> map=new HashMap<String, String>();

        //FILL
        for(int i=0;i<players.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Player", players[i]);
            map.put("Phone",phoneNo[i]);
//            map.put("Email",email[i]) ;
            map.put("Place",places[i]);
//            map.put("Country",country[i]);
            map.put("Image", Integer.toString(images[i]));

            data.add(map);
        }

        //KEYS IN MAP
        String[] from={"Player","Place","Image"};

        //IDS OF VIEWS
        int[] to={R.id.nameTxt,R.id.placeTxt,R.id.imageView1};

        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.model, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                // TODO Auto-generated method stub



                HashMap<String, String> s= data.get(pos);
                SecondActivity mn1=(SecondActivity) getActivity();
                mn1.f1(s);


//                Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();

            }
        });
    }
}