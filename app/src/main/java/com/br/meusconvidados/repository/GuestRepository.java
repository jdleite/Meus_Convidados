package com.br.meusconvidados.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.br.meusconvidados.Entities.GuestEntity;
import com.br.meusconvidados.constats.DataBaseConstants;

import java.util.ArrayList;
import java.util.List;

public class GuestRepository {
    private static GuestRepository INSTANCE;
    private GuestDatabaseHelper mGuestDatabaseHelper;

    private GuestRepository(Context context) {
        this.mGuestDatabaseHelper = new GuestDatabaseHelper(context);

    }

    public static synchronized GuestRepository getInstance(Context context) {
        if (INSTANCE == null) INSTANCE = new GuestRepository(context);
        return INSTANCE;
    }

    public Boolean insert(GuestEntity guestEntity) {
        try {
            SQLiteDatabase db = this.mGuestDatabaseHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(DataBaseConstants.GUEST.COLUMNS.NAME, guestEntity.getName());
            cv.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guestEntity.getConfirmed());

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, cv);

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public GuestEntity load(int id) {
        GuestEntity guestEntity = new GuestEntity();
        try {

            SQLiteDatabase sqLiteDatabase = this.mGuestDatabaseHelper.getReadableDatabase();

            String[] projection = {

                    DataBaseConstants.GUEST.COLUMNS.ID,
                    DataBaseConstants.GUEST.COLUMNS.NAME,
                    DataBaseConstants.GUEST.COLUMNS.PRESENCE,


            };

            String selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?";
            String[] selectionArgs = {String.valueOf(id)};


            Cursor cursor = sqLiteDatabase.query(DataBaseConstants.GUEST.TABLE_NAME, projection, selection, selectionArgs, null, null, null);

            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                guestEntity.setId(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID)));
                guestEntity.setName(cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME)));
                guestEntity.setConfirmed(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)));
            }

            if (cursor != null) {
                cursor.close();
            }


            return guestEntity;
        } catch (Exception e) {
            return guestEntity;
        }

    }

    public List<GuestEntity> getGuestsByQuery(String query) {
        List<GuestEntity> list = new ArrayList<>();
        try {
            SQLiteDatabase sqLiteDatabase = this.mGuestDatabaseHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);

            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    GuestEntity guestEntity = new GuestEntity();
                    guestEntity.setId(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID)));
                    guestEntity.setName(cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME)));
                    guestEntity.setConfirmed(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)));

                    list.add(guestEntity);
                }
            }

            if (cursor != null) {
                cursor.close();
            }


        } catch (Exception e) {
            return list;
        }

        return list;

    }


}
