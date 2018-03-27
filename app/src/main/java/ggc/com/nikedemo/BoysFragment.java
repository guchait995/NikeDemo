package ggc.com.nikedemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class BoysFragment extends Fragment {
    DatabaseHandler databasehandler;
    ArrayList<Items> item_list;
    ItemAadapter itemAadapter;
    ListView  boysitemlist;

    public static BoysFragment newInstance() {
        
        Bundle args = new Bundle();
        
        BoysFragment fragment = new BoysFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public BoysFragment() {
        // Required empty public constructor
    }


   

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_boys, container, false);
        databasehandler=new DatabaseHandler(getActivity(),1);

        item_list=databasehandler.getitems("boystable");


        itemAadapter=new ItemAadapter(getActivity(),item_list);
        boysitemlist= (ListView) root.findViewById(R.id.boys_list);
        boysitemlist.setAdapter(itemAadapter);
        boysitemlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i =new Intent(getActivity(),PaymentActivity.class);
                i.putExtra("itemname",item_list.get(position).getName());
                i.putExtra("itemprice",item_list.get(position).getPrice());
                //i.putExtra("pos",position);
                //i.putExtra("itemimage",ge);
                startActivity(i);
            }
        });


        return root;  }


}
