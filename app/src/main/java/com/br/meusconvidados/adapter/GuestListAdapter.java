package com.br.meusconvidados.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.meusconvidados.Entities.GuestEntity;
import com.br.meusconvidados.R;
import com.br.meusconvidados.listener.OnGuestListenerInteractionListener;
import com.br.meusconvidados.viewHolder.GuestViewHolder;

import java.util.List;

public class GuestListAdapter extends RecyclerView.Adapter<GuestViewHolder> {

    private List<GuestEntity> mGuestEntityList;
    private OnGuestListenerInteractionListener mOnGuestListenerInteractionListener;

    public GuestListAdapter(List<GuestEntity> guestEntityList, OnGuestListenerInteractionListener listener) {
        this.mGuestEntityList = guestEntityList;
        this.mOnGuestListenerInteractionListener = listener;
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_guest_list, viewGroup, false);
        return new GuestViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder guestViewHolder, int i) {
        GuestEntity guestEntity = this.mGuestEntityList.get(i);

        guestViewHolder.bindData(guestEntity, mOnGuestListenerInteractionListener);

    }

    @Override
    public int getItemCount() {

        return this.mGuestEntityList.size();
    }
}
