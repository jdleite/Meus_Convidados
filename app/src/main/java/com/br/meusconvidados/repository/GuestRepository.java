package com.br.meusconvidados.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.br.meusconvidados.Entities.GuestEntity;
import com.br.meusconvidados.constats.DataBaseConstants;

public class GuestRepository {
    private static GuestRepository INSTANCE;
    private GuestDatabaseHelper mGuestDatabaseHelper;

    private GuestRepository(Context context){
        this.mGuestDatabaseHelper = new GuestDatabaseHelper(context);

    }

    public static synchronized GuestRepository getInstance(Context context){
        if(INSTANCE == null) INSTANCE = new GuestRepository(context);
        return INSTANCE;
    }

    public Boolean insert(GuestEntity guestEntity){
        try {
            SQLiteDatabase db = this.mGuestDatabaseHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(DataBaseConstants.GUEST.COLUMNS.NAME,guestEntity.getName());
            cv.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE,guestEntity.getConfirmed());

            db.insert(DataBaseConstants.GUEST.TABLE_NAME,null,cv);

            return true;

        }catch (Exception e){
            return false;
        }
    }


}
