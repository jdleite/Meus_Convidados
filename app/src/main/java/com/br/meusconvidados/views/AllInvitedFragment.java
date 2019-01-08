package com.br.meusconvidados.views;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.br.meusconvidados.entities.GuestCount;
import com.br.meusconvidados.entities.GuestEntity;
import com.br.meusconvidados.R;
import com.br.meusconvidados.adapter.GuestListAdapter;
import com.br.meusconvidados.business.GuestBusiness;
import com.br.meusconvidados.constats.GuestConstants;
import com.br.meusconvidados.listener.OnGuestListenerInteractionListener;

import java.util.List;

public class AllInvitedFragment extends Fragment {
    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;
    private OnGuestListenerInteractionListener mOnGuestListenerInteractionListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_invited, container, false);
        final Context context = view.getContext();

        this.mViewHolder.mRecyclerAllInvited = view.findViewById(R.id.recycler_all_invited);
        this.mViewHolder.mTextPresentCount = view.findViewById(R.id.text_present_count);
        this.mViewHolder.mTextAbsentCount = view.findViewById(R.id.text_absent_count);
        this.mViewHolder.mTextAllInvitedCount = view.findViewById(R.id.text_all_invited_count);

        this.mGuestBusiness = new GuestBusiness(context);

        mOnGuestListenerInteractionListener = new OnGuestListenerInteractionListener() {
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

                mGuestBusiness.remove(id);

                Toast.makeText(getContext(),getString(R.string.convidado_removido_suesso),Toast.LENGTH_SHORT).show();
                loadDashBoard();
                loadGuests();

            }

        };


        this.mViewHolder.mRecyclerAllInvited.setLayoutManager(new LinearLayoutManager(context));


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        loadDashBoard();
        loadGuests();

    }

    private void loadGuests() {

        List<GuestEntity> guestEntityList = this.mGuestBusiness.getInvited();


        GuestListAdapter guestListAdapter = new GuestListAdapter(guestEntityList, mOnGuestListenerInteractionListener);
        mViewHolder.mRecyclerAllInvited.setAdapter(guestListAdapter);
        guestListAdapter.notifyDataSetChanged();

    }

    private void loadDashBoard() {
        GuestCount guestCount = this.mGuestBusiness.loadDashBoard();

        this.mViewHolder.mTextAllInvitedCount.setText(String.valueOf(guestCount.getAllInvitedCount()));
        this.mViewHolder.mTextAbsentCount.setText(String.valueOf(guestCount.getAbsentCount()));
        this.mViewHolder.mTextPresentCount.setText(String.valueOf(guestCount.getPresentCount()));

    }

    private static class ViewHolder {
        RecyclerView mRecyclerAllInvited;
        TextView mTextPresentCount;
        TextView mTextAbsentCount;
        TextView mTextAllInvitedCount;
    }

}
