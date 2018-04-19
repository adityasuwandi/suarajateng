package com.suarakan.suarakan;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {

    private List<Timeline> timelines;

    public TimelineAdapter(List<Timeline> timelines) {
        this.timelines = timelines;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_timeline, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Bukan periode kegiatan", Toast.LENGTH_SHORT).show();
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Timeline timeline = timelines.get(position);
        SpannableString date = new SpannableString(timeline.getDate());
        date.setSpan(new UnderlineSpan(), 0, date.length(), 0);
        holder.txtDate.setText(date);
        holder.txtDescription.setText(timeline.getDescription());
    }

    @Override
    public int getItemCount() {
        return timelines.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtDate, txtDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            txtDate = itemView.findViewById(R.id.text_timeline_date);
            txtDescription = itemView.findViewById(R.id.text_timeline_desc);
        }
    }
}
