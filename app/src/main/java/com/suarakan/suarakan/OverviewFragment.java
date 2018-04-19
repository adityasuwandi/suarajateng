package com.suarakan.suarakan;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OverviewFragment extends Fragment implements View.OnClickListener {

    private CardView cardGuide, cardTips, cardBantuan, cardHoax;
    public OverviewFragment() {
        // Required empty public constructor
    }

    public static OverviewFragment newInstance() {
        OverviewFragment fragment = new OverviewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        cardGuide = view.findViewById(R.id.card_button_guide);
        cardTips = view.findViewById(R.id.card_button_tips);
        cardBantuan = view.findViewById(R.id.card_button_bantuan);
        cardHoax=view.findViewById(R.id.card_button_hoax);
        cardGuide.setOnClickListener(this);
        cardTips.setOnClickListener(this);
        cardBantuan.setOnClickListener(this);
        cardHoax.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_button_guide:
                startActivity(GuideActivity.class);
                return;
            case R.id.card_button_tips:
                startActivity(TipsActivity.class);
                return;
            case R.id.card_button_hoax:
                startActivity(HoaxActivity.class);
                return;
            case R.id.card_button_bantuan:
                startActivity(BantuanActivity.class);
                return;
        }
    }

    private void startActivity(Class<?> cls) {
        Intent intent =  new Intent(getContext(), cls);
        startActivity(intent);
    }
}
