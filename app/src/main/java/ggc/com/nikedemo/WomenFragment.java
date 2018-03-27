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


public class WomenFragment extends Fragment {
    DatabaseHandler databasehandler;
    ArrayList<Items> item_list;
    ItemAadapter itemAadapter;
    ListView womenitemlist;

    public static WomenFragment newInstance() {
        
        Bundle args = new Bundle();
        
        WomenFragment fragment = new WomenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public WomenFragment() {
        // Required empty public constructor
    }




//nfkkdfjnjk




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_women, container, false);
        databasehandler=new DatabaseHandler(getActivity(),1);

        item_list=databasehandler.getallitems("womentable");
        itemAadapter=new ItemAadapter(getActivity(),item_list);
        womenitemlist= (ListView) root.findViewById(R.id.women_list);
        womenitemlist.setAdapter(itemAadapter);
        womenitemlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i =new Intent(getActivity(),PaymentActivity.class);
                startActivity(i);
            }
        });

        return root;
    }



 //dfsdfsdf



   }
