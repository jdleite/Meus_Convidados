package com.br.meusconvidados.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.meusconvidados.R;
import com.br.meusconvidados.viewHolder.GuestViewHolder;

public class GuestListAdapter extends RecyclerView.Adapter<GuestViewHolder> {
    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();

        LayoutInflater layoutInflater  = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_guest_list,viewGroup,false);
        return new GuestViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder guestViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
