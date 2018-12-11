package com.br.meusconvidados.views;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.meusconvidados.R;
import com.br.meusconvidados.adapter.GuestListAdapter;

public class AllInvitedFragment extends Fragment {
    private ViewHolder mViewHolder = new ViewHolder();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_invited, container, false);
        Context context = view.getContext();

        this.mViewHolder.mRecyclerAllInvited = view.findViewById(R.id.recycler_all_invited);

        GuestListAdapter guestListAdapter = new GuestListAdapter();
        mViewHolder.mRecyclerAllInvited.setAdapter(guestListAdapter);

        this.mViewHolder.mRecyclerAllInvited.setLayoutManager(new LinearLayoutManager(context));


        return view;
    }

    private static class ViewHolder {
        RecyclerView mRecyclerAllInvited;
    }

}
