package com.br.meusconvidados.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.br.meusconvidados.constats.DataBaseConstants;

public class GuestDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME  = "MeusConvidados.db";

    private static  final String SQL_CREATE_TABLE_GUEST =
            "create table " + DataBaseConstants.GUEST.TABLE_NAME + "("
            + DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
            + DataBaseConstants.GUEST.COLUMNS.NAME + " text, "
            + DataBaseConstants.GUEST.COLUMNS.DOCUMENT + " text , "
            + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer);";

    private static final String DROP_TABLE_GUEST = "DROP TABLE  IF EXISTS " + DataBaseConstants.GUEST.TABLE_NAME;

    public GuestDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_GUEST);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
