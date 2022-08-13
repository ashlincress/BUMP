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
 * Use the {@link counsellorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class counsellorFragment extends ListFragment {

    String[] players1={"Susan Posner","Michael Seligman","BlackMore Zimbardo","Poster Gardner","Harward Wiseman","Robert Loftus","Trivers Gopnik"};
    String[] places1={"Mangalore","Mumbai","Goa","Bangalore","Delhi","Mysore","Pune"};
    String[] phoneNo1={"9341394245","9972638046","9900396615","9164462002","8495088892","9278360481","9023786541"};
    String[] country1={"India","India","India","India","India","India","India"};
    String[] email1={"susan@gmail.com","michael@gmail.com","zimbardo@gmail.com","poster@gmail.com","harward@gmail.com","robert@gmail.com","trivers@gmail.com"};
    int[] images1={R.drawable.couns1,R.drawable.couns2,R.drawable.couns3,R.drawable.couns4,R.drawable.couns5,R.drawable.couns6,R.drawable.couns7};

    ArrayList<HashMap<String, String>> data1=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        //MAP
        HashMap<String, String> map1=new HashMap<String, String>();

        //FILL
        for(int i=0;i<players1.length;i++)
        {
            map1=new HashMap<String, String>();
            map1.put("Player", players1[i]);
            map1.put("Phone",phoneNo1[i]);
//            map1.put("Email",email1[i]) ;
            map1.put("Place",places1[i]);
//            map1.put("Country",country1[i]);
            map1.put("Image", Integer.toString(images1[i]));

            data1.add(map1);
        }

        //KEYS IN MAP
        String[] from={"Player","Place","Image"};

        //IDS OF VIEWS
        int[] to={R.id.nameTxt1,R.id.placeTxt1,R.id.imageView2};

        //ADAPTER
        adapter1=new SimpleAdapter(getActivity(), data1, R.layout.model3, from, to);
        setListAdapter(adapter1);

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



                HashMap<String, String> s= data1.get(pos);
                SecondActivity mn3=(SecondActivity) getActivity();
                mn3.f3(s);


//                Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();

            }
        });
    }
}