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


public class FavouritesFragment extends Fragment {
    DatabaseHandler databasehandler;
    ArrayList<Items> item_list;
    ItemAadapter itemAadapter;
    ListView favouriteitemlist;

    public FavouritesFragment() {
        // Required empty public constructor
    }

    public static FavouritesFragment newInstance() {

        Bundle args = new Bundle();

        FavouritesFragment fragment = new FavouritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_favourites, container, false);
        databasehandler=new DatabaseHandler(getActivity(),1);

        item_list=databasehandler.getitems("favouritestable");


        itemAadapter=new ItemAadapter(getActivity(),item_list);
        favouriteitemlist= (ListView) root.findViewById(R.id.favourite_list);
        favouriteitemlist.setAdapter(itemAadapter);
        favouriteitemlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i =new Intent(getActivity(),PaymentActivity.class);
                i.putExtra("itemname",item_list.get(position).getName());
                i.putExtra("itemprice",item_list.get(position).getPrice());
               // i.putExtra("pos",position);
                //i.putExtra("itemimage",ge);
                startActivity(i);
            }
        });

        return root;   }

}
