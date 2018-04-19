package com.suarakan.suarakan;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {

    private PieChart chartProvinsi, chartKabupaten;
    private TextView txtProvinsi, txtKabupaten;
    private MaterialBetterSpinner spinnerKabupaten;

    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance() {
        InfoFragment fragment = new InfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        setViewById(view);
        setVisibilityGone();
        settingSpinner();
        settingChart();
        return view;
    }

    private void setViewById(View view) {
        chartProvinsi = view.findViewById(R.id.chart_provinsi);
        chartKabupaten = view.findViewById(R.id.chart_kabupaten);
        spinnerKabupaten = view.findViewById(R.id.spinner_kabupaten);
        txtProvinsi = view.findViewById(R.id.text_provinsi);
        txtKabupaten = view.findViewById(R.id.text_kabupaten);
    }

    private void setVisibilityGone() {
        chartKabupaten.setVisibility(View.GONE);
        txtKabupaten.setVisibility(View.GONE);
    }

    private void settingSpinner() {
        final String[] CITIES = getResources().getStringArray(R.array.city_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_dropdown_item_1line, CITIES);
        spinnerKabupaten.setAdapter(adapter);
        spinnerKabupaten.setHint("Pilih Kabupaten/Kota");
        spinnerKabupaten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                chartKabupaten.setVisibility(View.VISIBLE);
                txtKabupaten.setVisibility(View.VISIBLE);
                txtKabupaten.setText(CITIES[i]);
            }
        });
    }

    private void settingChart() {
        settingChartAttribute(chartProvinsi);
        settingChartAttribute(chartKabupaten);
        setDataChart(chartProvinsi);
        setDataChart(chartKabupaten);
    }

    private void settingChartAttribute(PieChart chart) {
        chart.setUsePercentValues(true);
        chart.setRotationEnabled(false);
        chart.setDrawHoleEnabled(false);
        chart.getDescription().setEnabled(false);
    }

    private void setDataChart(PieChart chart) {
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry((float) 100/3, "Paslon 1"));
        entries.add(new PieEntry((float) 100/3, "Paslon 2"));
        entries.add(new PieEntry((float) 100/3, "Paslon 3"));
        PieDataSet dataSet = new PieDataSet(entries, null);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextColor(Color.WHITE);
        chart.setData(data);
        chart.invalidate();
    }

}
