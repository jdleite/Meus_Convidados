package com.br.meusconvidados.business;

import android.content.Context;

import com.br.meusconvidados.entities.GuestCount;
import com.br.meusconvidados.entities.GuestEntity;
import com.br.meusconvidados.constats.DataBaseConstants;
import com.br.meusconvidados.constats.GuestConstants;
import com.br.meusconvidados.repository.GuestRepository;

import java.util.List;

public class GuestBusiness {

    private GuestRepository mGuestRepository;

    public GuestBusiness(Context context){
        this.mGuestRepository = GuestRepository.getInstance(context);
    }

    public boolean insert(GuestEntity guestEntity){
        return this.mGuestRepository.insert(guestEntity);
    }

    public boolean update(GuestEntity guestEntity){
        return this.mGuestRepository.update(guestEntity);
    }


    public boolean remove(int id){
        return this.mGuestRepository.remove(id);
    }

    public GuestEntity load(int id){

    return  this.mGuestRepository.load(id);

    }

    public GuestCount loadDashBoard(){
        return this.mGuestRepository.loadDashBoard();
    }

    public List<GuestEntity> getInvited(){
        return this.mGuestRepository.getGuestsByQuery("select * from " + DataBaseConstants.GUEST.TABLE_NAME);
    }

    public List<GuestEntity> getAbsent(){
        return this.mGuestRepository.getGuestsByQuery("select * from " + DataBaseConstants.GUEST.TABLE_NAME + " where "
                + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " = " + GuestConstants.CONFIRMATION.ABSENT);
    }

    public List<GuestEntity> getPresent(){
        return this.mGuestRepository.getGuestsByQuery("select * from " + DataBaseConstants.GUEST.TABLE_NAME + " where "
        + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " = " + GuestConstants.CONFIRMATION.PRESENT);
    }


}
