package ggc.com.nikedemo;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by SOURAV on 7/8/2017.
 */

public class ItemAadapter extends ArrayAdapter<Items> {
    Context context;
    ArrayList<Items> item_list;
    TextView textViewRowItem;
    TextView textViewRowPrice;

    ImageView imageView;
    public ItemAadapter(@NonNull Context context, ArrayList<Items> item_list) {
        super(context, R.layout.each_item,item_list);
        this.context=context;
        this.item_list=item_list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View root=null;
        if(convertView==null)
        {
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            root=layoutInflater.inflate(R.layout.each_item,parent,false);
        }
        else {

            root = convertView;
        }


        Items item=item_list.get(position);
        textViewRowItem= (TextView) root.findViewById(R.id.item_name);
        textViewRowPrice= (TextView) root.findViewById(R.id.item_price);
        imageView= (ImageView) convertView.findViewById(R.id.item_image);

       String imagename=item.getImage_name();


      int id=root.getResources().getIdentifier(imagename,"drawable",context.getPackageName());
       Drawable drawable = context.getDrawable(id);


       imageView.setImageDrawable(drawable);

        //imageView.setImageResource(id);
        /*
        if(position%2==0 )
        {
            imageView.setImageResource(R.drawable.dirt2);
        }

        else if(position%3==0)
        {
            imageView.setImageResource(R.drawable.dirt3);
        }
        else if(position%5==0)
        {
            imageView.setImageResource(R.drawable.dirt4);

        }
        else if(position%7==0)
        {
            imageView.setImageResource(R.drawable.dirt5);

        }
       else if(position%9==0)
        {
            imageView.setImageResource(R.drawable.dirt2);

        }
        else
        {
            imageView.setImageResource(R.drawable.dirt3);

        }
*/
        textViewRowItem.setText(item.getName());
        textViewRowPrice.setText(String.valueOf(item.getPrice()));





        return root;
    }
}
