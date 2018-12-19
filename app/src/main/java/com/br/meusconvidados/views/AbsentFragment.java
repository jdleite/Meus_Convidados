package com.br.meusconvidados.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.meusconvidados.Entities.GuestEntity;
import com.br.meusconvidados.R;
import com.br.meusconvidados.adapter.GuestListAdapter;
import com.br.meusconvidados.business.GuestBusiness;
import com.br.meusconvidados.constats.GuestConstants;
import com.br.meusconvidados.listener.OnGuestListenerInteractionListener;

import java.util.List;


public class AbsentFragment extends Fragment {

    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_absent, container, false);

        Context context = view.getContext();

        this.mViewHolder.mRecyclerAllAbsent = view.findViewById(R.id.recycler_all_absent);

        this.mGuestBusiness = new GuestBusiness(context);

        OnGuestListenerInteractionListener listener = new OnGuestListenerInteractionListener() {
            @Override
            public void onListClick(int id) {

                Bundle bundle = new Bundle();
                bundle.putInt(GuestConstants.BundleConstants.GUEST_ID, id);

                Intent intent = new Intent(getContext(), GuestFormActivity.class);

                intent.putExtras(bundle);

                startActivity(intent);


            }


            @Override
            public void onDeleteClick(int id) {

            }

        };


        List<GuestEntity> guestEntityList = this.mGuestBusiness.getAbsent();


        GuestListAdapter guestListAdapter = new GuestListAdapter(guestEntityList, listener);
        mViewHolder.mRecyclerAllAbsent.setAdapter(guestListAdapter);

        this.mViewHolder.mRecyclerAllAbsent.setLayoutManager(new LinearLayoutManager(context));

        return view;
    }

    private static class ViewHolder {
        RecyclerView mRecyclerAllAbsent;
    }

}
