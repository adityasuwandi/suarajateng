package com.suarakan.suarakan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TimelineFragment extends Fragment {

    private RecyclerView recviewTimeline;
    private RecyclerView.Adapter adapter;
    private List<Timeline> timelines = new ArrayList<>();

    public TimelineFragment() {
        // Required empty public constructor
    }

    public static TimelineFragment newInstance() {
        TimelineFragment fragment = new TimelineFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        recviewTimeline = view.findViewById(R.id.recview_timeline);
        recviewTimeline.setHasFixedSize(true);
        recviewTimeline.setLayoutManager(new LinearLayoutManager(getContext()));
        addDataToList();
        adapter = new TimelineAdapter(timelines);
        recviewTimeline.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }

    private void addDataToList() {
        String[] timelineDates = getResources().getStringArray(R.array.timeline_date);
        String[] timelineDesc = getResources().getStringArray(R.array.timeline_desc);

        for (int i=0;i<timelineDates.length;i++) {
            timelines.add(new Timeline(timelineDates[i], timelineDesc[i]));
        }
    }
}
