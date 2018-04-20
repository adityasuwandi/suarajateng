package com.suarakan.suarakan;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.List;


public class KandidatFragment extends Fragment implements View.OnClickListener {

    private Button btnNomor1, btnNomor2;
    private MaterialBetterSpinner spinnerKotaKab;
    private RecyclerView recviewKandidat;
    private RecyclerView.Adapter adapter;
    private List<Kandidat> kandidats = new ArrayList<>();

    public KandidatFragment() {
        // Required empty public constructor
    }

    public static KandidatFragment newInstance() {
        KandidatFragment fragment = new KandidatFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kandidat, container, false);
        settingWidget(view);
        settingSpinner();
        return view;
    }

    private void settingWidget(View view) {
        btnNomor1 = view.findViewById(R.id.button_nomor_1);
        btnNomor2 = view.findViewById(R.id.button_nomor_2);
        spinnerKotaKab = view.findViewById(R.id.spinner_kabupaten);
        recviewKandidat = view.findViewById(R.id.recview_kandidat);
        btnNomor1.setOnClickListener(this);
        btnNomor2.setOnClickListener(this);
        recviewKandidat.setHasFixedSize(true);
        recviewKandidat.setLayoutManager(new LinearLayoutManager(getContext()));
        recviewKandidat.setNestedScrollingEnabled(false);
        adapter = new KandidatAdapter(kandidats);
        recviewKandidat.setAdapter(adapter);
    }

    private void settingSpinner() {
        final String[] CITIES = getResources().getStringArray(R.array.city_list);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_dropdown_item_1line, CITIES);
        spinnerKotaKab.setAdapter(spinnerAdapter);
        spinnerKotaKab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                kandidats.clear();
                kandidats.addAll(Kandidat.getKandidats(Kandidat.City.values()[i], getContext()));
                Log.d("KandidatFragment", String.valueOf(kandidats.size()));
                adapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_nomor_1:
                showDialog(0, R.drawable.no_1);
                return;
            case R.id.button_nomor_2:
                showDialog(1, R.drawable.no_2);
                return;
        }
    }

    private void showDialog(int stringIndex, int drawable) {
        String[] PASLON = getResources().getStringArray(R.array.paslon_gubernur);
        Bundle bundle = new Bundle();
        bundle.putString("nama_paslon", PASLON[stringIndex]);
        bundle.putInt("drawable_image", drawable);
        DialogFragment dialog = new KandidatDialog();
        dialog.setArguments(bundle);
        dialog.show(getActivity().getSupportFragmentManager(), "dialog_kandidat");
    }
}
