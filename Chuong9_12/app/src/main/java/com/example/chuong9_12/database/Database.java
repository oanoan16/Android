package com.example.chuong9_12.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.chuong9_12.model.Category;
import com.example.chuong9_12.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="chuong9.db";
    private static int DATABASE_VERSION = 1;
    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =  "create table categories("
                + "id integer primary key autoincrement,"
                + "name text)";
        db.execSQL(sql);

        sql = "create table items(" +
                "id integer primary key autoincrement," +
                "name text," +
                "cid integer," +
                "price real," +
                "dataUpdate text,"+
                "foreign key(cid) references categories(id))";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertCate(Category c){
        String sql = "INSERT INTO categories(name)"+
                "VALUES(?)";
        String[] args = {c.getName()};
        SQLiteDatabase st = getWritableDatabase();
        st.execSQL(sql,args);

    }
    public long insertItem(Item i){
        ContentValues values = new ContentValues();
        values.put("name", i.getName());
        values.put("cid", i.getCategory().getId());
        values.put("price", i.getPrice());
        values.put("dateUpdate", i.getDateUpdate());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert("items",null, values);
    }

    public  List<Category> getCates(){
        List<Category> list = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.query("categories",
                null, null, null,
                null, null, null);
        while (rs != null && rs.moveToNext()){
            list.add(new Category(rs.getInt(0), rs.getString(1)));
        }
        return list;
    }

    public List<Item> getItems(){
        List<Item> list = new ArrayList<>();
        String sql = "select t";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String order = "date DESC";
        Cursor rs = sqLiteDatabase.query("items",
                null, null, null,
                null, null, order);
        while ((rs != null) && (rs.moveToNext())) {
            int id= rs.getInt(0);
            String title = rs.getString(1);
            String category = rs.getString(2);
            String price = rs.getString(3);
            String date = rs.getString(4);
            list.add(new Item(id,title,category,price,date));
        }
        return list;
    }

    public Item getItemById(int id){
        String whereClause = "id=?";
        String[] whereArgs = {Integer.toString(id)};
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor rs = sqLiteDatabase.query("items",
                null, whereClause, whereArgs,
                null, null, null);
        if (rs != null && rs.moveToNext()) {
            return new Item(rs.getInt(0, rs.getString(1), rs.getDouble(3),
                    rs.getString(4), new Category(rs.getInt(0), ""));
        }
        return null;
    }

    public int updateItem(Item i){
        ContentValues values = new ContentValues();
        values.put("name", i.getName());
        values.put("cid", i.getCategory().getId());
        values.put("price", i.getPrice());
        values.put("dateUpdate", i.getDateUpdate());
        String whereClause = "id=?";
        String[] whereArgs = {Integer.toString(i.getId())};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.update("items",values, whereClause, whereArgs);
    }

    public int deleteItemById(Item id){
        String whereClause = "id=?";
        String[] whereArgs = {Integer.toString(id.getId())};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase(); // read cho select
        return sqLiteDatabase.delete("items", whereClause, whereArgs);
    }

    // tim theo 1 ki tu nao do
    public List<Item> searchItemByKey(String key){
        List<Item> list = new ArrayList<>();
        String sql = "select t.id, t.name, t.price, t.dateUpdate, c.id, c.name "+
                "from categories c inner join items t " +
                "on (c.id = t.cid) where t.name like ? or c.name like ?";
        String[] whereArgs = {"%" + key + "%", "%" + key + "%"};
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor rs = sqLiteDatabase.rawQuery(sql, whereArgs);
        while ((rs != null) && (rs.moveToNext())) {
            Category c = new Category(rs.getInt(4), rs.getString(5));
            list.add(new Item(rs.getInt(0, rs.getString(1), rs.getDouble(2),
                    rs.getString(3), c);
        }
        return list;
    }
    // tu nam den nam
    public List<Item> searchItemByfromDatetoDate(String from, String to){
        List<Item> list = new ArrayList<>();
        String sql = "select t.id, t.name, t.price, t.dateUpdate, c.id, c.name "+
                "from categories c inner join items t " +
                "on (c.id = t.cid) where dateUpdate between ? and ?";
        String[] whereArgs = {from + "1/1/",to + "31/12"};
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor rs = sqLiteDatabase.rawQuery(sql, whereArgs);
        while ((rs != null) && (rs.moveToNext())) {
            Category c = new Category(rs.getInt(4), rs.getString(5));
            list.add(new Item(rs.getInt(0, rs.getString(1), rs.getDouble(2),
                    rs.getString(3), c);
        }
        return list;
    }



}
