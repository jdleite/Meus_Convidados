package com.br.meusconvidados.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.br.meusconvidados.Entities.GuestEntity;
import com.br.meusconvidados.R;
import com.br.meusconvidados.listener.OnGuestListenerInteractionListener;

public class GuestViewHolder extends RecyclerView.ViewHolder {
    private TextView mTextName;

    public GuestViewHolder(View itemView) {
        super(itemView);

        this.mTextName = itemView.findViewById(R.id.text_name);
    }

    public void bindData(final GuestEntity guestEntity, final OnGuestListenerInteractionListener  listener){
        this.mTextName.setText(guestEntity.getName());

        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onListClick(guestEntity.getId());
            }
        });
    }
}
