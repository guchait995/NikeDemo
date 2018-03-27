package ggc.com.nikedemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GirlsFragment extends Fragment {
    DatabaseHandler databasehandler;
    ArrayList<Items> item_list;
    ItemAadapter itemAadapter;
    ListView girlsitemlist;


    public static GirlsFragment newInstance() {

        Bundle args = new Bundle();

        GirlsFragment fragment = new GirlsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public GirlsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_girls, container, false);
        databasehandler=new DatabaseHandler(getActivity(),1);

        item_list=databasehandler.getitems("girlstable");


        itemAadapter=new ItemAadapter(getActivity(),item_list);
        girlsitemlist= (ListView) root.findViewById(R.id.girls_list);
        girlsitemlist.setAdapter(itemAadapter);

        girlsitemlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i =new Intent(getActivity(),PaymentActivity.class);
                i.putExtra("itemname",item_list.get(position).getName());
                i.putExtra("itemprice",item_list.get(position).getPrice());
                i.putExtra("pos",position);
                //i.putExtra("itemimage",ge);
                startActivity(i);
            }
        });
        return root; }

}
