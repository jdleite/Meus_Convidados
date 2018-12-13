package com.br.meusconvidados.business;

import android.content.Context;

import com.br.meusconvidados.Entities.GuestEntity;
import com.br.meusconvidados.constats.DataBaseConstants;
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

    public GuestEntity load(int id){

    return  this.mGuestRepository.load(id);

    }

    public List<GuestEntity> getInvited(){
        return this.mGuestRepository.getGuestsByQuery("select * from " + DataBaseConstants.GUEST.TABLE_NAME);
    }


}
