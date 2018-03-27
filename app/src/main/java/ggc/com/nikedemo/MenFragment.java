package ggc.com.nikedemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenFragment extends Fragment {

    DatabaseHandler databasehandler;
    ArrayList<Items> item_list;
    ItemAadapter itemAadapter;
    ListView menitemlist;

    public static MenFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MenFragment fragment = new MenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_men, container, false);
        databasehandler=new DatabaseHandler(getActivity(),1);

        item_list=databasehandler.getitems("mentable");


        itemAadapter=new ItemAadapter(getActivity(),item_list);
        menitemlist= (ListView) root.findViewById(R.id.men_list);
        menitemlist.setAdapter(itemAadapter);

        menitemlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i =new Intent(getContext(),PaymentActivity.class);

                i.putExtra("itemname",item_list.get(position).getName());
                i.putExtra("itemprice",item_list.get(position).getPrice());

                //i.putExtra("pos",position);
                //i.putExtra("itemimage",ge);
                startActivity(i);
            }
        });

        return root;
    }

}
