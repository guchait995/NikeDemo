package ggc.com.nikedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by SOURAV on 7/8/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper{
    public DatabaseHandler(Context context, int version) {
        super(context,"itemdb", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table womentable (itemname text,price int,imagename text)");
        db.execSQL("insert into womentable (itemname,price,imagename) values ('Running Shoes',2000,'dirt')");
        db.execSQL("insert into womentable (itemname,price,imagename) values ('Running Shoes',3000,'dirt2')");
        db.execSQL("insert into womentable (itemname,price,imagename) values ('Running Shoes',4000,'dirt3')");
        db.execSQL("insert into womentable (itemname,price,imagename) values ('Running Shoes',5000,'dirt5')");
        db.execSQL("insert into womentable (itemname,price,imagename) values ('Running Shoes',6000,'dirt4')");
        db.execSQL("insert into womentable (itemname,price,imagename) values ('Running Shoes',2000,'dirt')");
        db.execSQL("insert into womentable (itemname,price,imagename) values ('Running Shoes',3000,'dirt5')");
        db.execSQL("insert into womentable (itemname,price,imagename) values ('Running Shoes',4000,'dirt2')");
        db.execSQL("insert into womentable (itemname,price,imagename) values ('Running Shoes',5000,'dirt')");
        db.execSQL("insert into womentable (itemname,price,imagename) values ('Running Shoes',6000,'dirt3')");

        db.execSQL("create table mentable (itemname text,price int)");
        db.execSQL("insert into mentable (itemname,price) values ('Nike DART',3349)");
        db.execSQL("insert into mentable (itemname,price) values ('NIke LITEFORCE',2450)");
        db.execSQL("insert into mentable (itemname,price) values ('Nike DOWNSHIFTER',4700)");
        db.execSQL("insert into mentable (itemname,price) values ('Nike INFURTURE',4609)");
        db.execSQL("insert into mentable (itemname,price) values ('Nike AIRMAX',4609)");
        db.execSQL("insert into mentable (itemname,price) values ('Nike DARWIN',5609)");
        db.execSQL("insert into mentable (itemname,price) values ('Nike LUNARSTELOS',4959)");
        db.execSQL("insert into mentable (itemname,price) values ('Nike REVOLUTION',2299)");
        db.execSQL("insert into mentable (itemname,price) values ('Nike AIR',3349)");
        db.execSQL("insert into mentable (itemname,price) values ('Nike PRIMEIRON',4800)");

        db.execSQL("create table boystable (itemname text,price int)");
        db.execSQL("insert into boystable (itemname,price) values ('Nike DART',3349)");
        db.execSQL("insert into boystable (itemname,price) values ('NIke LITEFORCE',2450)");
        db.execSQL("insert into boystable (itemname,price) values ('Nike DOWNSHIFTER',4700)");
        db.execSQL("insert into boystable (itemname,price) values ('Nike INFURTURE',4609)");
        db.execSQL("insert into boystable (itemname,price) values ('Nike AIRMAX',4609)");
        db.execSQL("insert into boystable (itemname,price) values ('Nike DARWIN',5609)");
        db.execSQL("insert into boystable (itemname,price) values ('Nike LUNARSTELOS',4959)");
        db.execSQL("insert into boystable (itemname,price) values ('Nike REVOLUTION',2299)");
        db.execSQL("insert into boystable (itemname,price) values ('Nike AIR',3349)");
        db.execSQL("insert into boystable (itemname,price) values ('Nike PRIMEIRON',4800)");

        db.execSQL("create table girlstable (itemname text,price int)");
        db.execSQL("insert into girlstable (itemname,price) values ('Nike DART',3349)");
        db.execSQL("insert into girlstable (itemname,price) values ('NIke LITEFORCE',2450)");
        db.execSQL("insert into girlstable (itemname,price) values ('Nike DOWNSHIFTER',4700)");
        db.execSQL("insert into girlstable (itemname,price) values ('Nike INFURTURE',4609)");
        db.execSQL("insert into girlstable (itemname,price) values ('Nike AIRMAX',4609)");
        db.execSQL("insert into girlstable (itemname,price) values ('Nike DARWIN',5609)");
        db.execSQL("insert into girlstable (itemname,price) values ('Nike LUNARSTELOS',4959)");
        db.execSQL("insert into girlstable (itemname,price) values ('Nike REVOLUTION',2299)");
        db.execSQL("insert into girlstable (itemname,price) values ('Nike AIR',3349)");
        db.execSQL("insert into girlstable (itemname,price) values ('Nike PRIMEIRON',4800)");

        db.execSQL("create table favouritestable (itemname text,price int)");
        db.execSQL("insert into favouritestable (itemname,price) values ('Nike DART',3349)");
        db.execSQL("insert into favouritestable (itemname,price) values ('NIke LITEFORCE',2450)");
        db.execSQL("insert into favouritestable (itemname,price) values ('Nike DOWNSHIFTER',4700)");
        db.execSQL("insert into favouritestable (itemname,price) values ('Nike INFURTURE',4609)");
        db.execSQL("insert into favouritestable (itemname,price) values ('Nike AIRMAX',4609)");


        db.execSQL("create table kidstable (itemname text,price int)");
        db.execSQL("insert into kidstable (itemname,price) values ('Running Shoes',200)");
        db.execSQL("insert into kidstable (itemname,price) values ('Running Shoes',300)");
        db.execSQL("insert into kidstable (itemname,price) values ('Running Shoes',400)");
        db.execSQL("insert into kidstable (itemname,price) values ('Running Shoes',500)");
        db.execSQL("insert into kidstable (itemname,price) values ('Running Shoes',600)");
        db.execSQL("insert into kidstable (itemname,price) values ('Running Shoes',200)");
        db.execSQL("insert into kidstable (itemname,price) values ('Running Shoes',300)");
        db.execSQL("insert into kidstable (itemname,price) values ('Running Shoes',400)");
        db.execSQL("insert into kidstable (itemname,price) values ('Running Shoes',500)");
        db.execSQL("insert into kidstable (itemname,price) values ('Running Shoes',600)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    ArrayList<Items> getallitems(String catagory)
    {
        ArrayList<Items> item_list=null;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor= db.rawQuery("select itemname,price,imagename from "+catagory,null);
        if(cursor.moveToFirst())
        {
            item_list=new ArrayList<>();
            do
            {
                // int id=cursor.getInt(0);
                String itemname=cursor.getString(0);
                int price=cursor.getInt(1);
                String image=cursor.getString(2);
                Items expense=new Items(itemname, price,image);

                item_list.add(expense);

            }while (cursor.moveToNext());
        }

        db.close();
        return item_list;

    }
    ArrayList<Items> getitems(String catagory)
    {
        ArrayList<Items> item_list=null;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor= db.rawQuery("select itemname,price from "+catagory,null);
        if(cursor.moveToFirst())
        {
            item_list=new ArrayList<>();
            do
            {
                // int id=cursor.getInt(0);
                String itemname=cursor.getString(0);
                int price=cursor.getInt(1);

                Items expense=new Items(itemname, price);

                item_list.add(expense);

            }while (cursor.moveToNext());
        }

        db.close();
        return item_list;

    }


}
