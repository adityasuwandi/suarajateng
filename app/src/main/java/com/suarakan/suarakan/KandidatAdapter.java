package com.suarakan.suarakan;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class KandidatAdapter extends RecyclerView.Adapter<KandidatAdapter.ViewHolder> {

    private List<Kandidat> kandidats;

    public KandidatAdapter(List<Kandidat> kandidats) {
        this.kandidats = kandidats;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kandidat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Kandidat kandidat = kandidats.get(position);
        holder.txtNo.setText(String.valueOf(kandidat.getNoUrut()));
        holder.txtUrutan.setText(kandidat.getUrutanPanjang());
        holder.txtPaslon.setText(kandidat.getNamaPasangan());
        Log.d("Adapter", "Added");
    }

    @Override
    public int getItemCount() {
        return kandidats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNo, txtUrutan, txtPaslon;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNo = itemView.findViewById(R.id.text_kandidat_no);
            txtUrutan = itemView.findViewById(R.id.text_kandidat_no_urut);
            txtPaslon = itemView.findViewById(R.id.text_kandidat_nama);
        }
    }
}
