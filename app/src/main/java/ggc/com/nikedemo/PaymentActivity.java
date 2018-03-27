package ggc.com.nikedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    String ItemName;
    String ItemPrice;
    TextView tvitemName;
    TextView tvitemprice;
    ImageView imageView;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Intent i=getIntent();
        ItemName=i.getStringExtra("itemname");
        ItemPrice=String.valueOf( i.getIntExtra("itemprice",1000));
       // position=i.getIntExtra("pos",10);
        tvitemName= (TextView) findViewById(R.id.paymentName);
        tvitemprice= (TextView) findViewById(R.id.paymentPrice);
        tvitemName.setText(ItemName);
        tvitemprice.setText("USD "+ItemPrice);
       // Log.i("bjdb", "onCreate: "+String.valueOf(position));
        imageView= (ImageView) findViewById(R.id.paymentItemImage);
        imageView.setImageResource(R.drawable.dirt2);
       /* if(position%2==0 )
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
            imageView.setImageResource(R.drawable.dirt2);

        }*/

    }
}
