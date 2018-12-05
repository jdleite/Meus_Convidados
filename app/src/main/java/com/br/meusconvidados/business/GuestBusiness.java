package com.br.meusconvidados.business;

import android.content.Context;

import com.br.meusconvidados.Entities.GuestEntity;
import com.br.meusconvidados.repository.GuestRepository;

public class GuestBusiness {

    private GuestRepository mGuestRepository;

    public GuestBusiness(Context context){
        this.mGuestRepository = GuestRepository.getInstance(context);
    }

    public boolean insert(GuestEntity guestEntity){
        return this.mGuestRepository.insert(guestEntity);
    }


}
