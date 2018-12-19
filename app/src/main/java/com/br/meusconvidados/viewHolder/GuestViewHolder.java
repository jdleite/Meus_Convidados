package com.br.meusconvidados.viewHolder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.br.meusconvidados.Entities.GuestEntity;
import com.br.meusconvidados.R;
import com.br.meusconvidados.listener.OnGuestListenerInteractionListener;

public class GuestViewHolder extends RecyclerView.ViewHolder {
    private TextView mTextName;
    private Context mContext;

    public GuestViewHolder(View itemView,Context context) {
        super(itemView);

        this.mTextName = itemView.findViewById(R.id.text_name);

        mContext = context;
    }

    public void bindData(final GuestEntity guestEntity, final OnGuestListenerInteractionListener  listener){
        this.mTextName.setText(guestEntity.getName());

        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onListClick(guestEntity.getId());
            }
        });

        this.mTextName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                new AlertDialog.Builder(mContext)
                        .setTitle(mContext.getString(R.string.remocao_convidado))
                        .setMessage(mContext.getString(R.string.deseja_remover))
                        .setIcon(R.drawable.ic_menu_camera)
                        .setPositiveButton(mContext.getString(R.string.sim), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                listener.onDeleteClick(guestEntity.getId());

                            }
                        })
                .setNeutralButton(mContext.getString(R.string.nao),null)
                .show();

                return true;
            }
        });
    }
}
