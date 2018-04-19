package com.suarakan.suarakan;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class KandidatDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_paslon, null);
        ImageView imgPaslon = view.findViewById(R.id.image_paslon);
        TextView txtNamaPaslon = view.findViewById(R.id.text_kandidat_nama);
        int drawableImage = getArguments().
                getInt("drawable_image", R.drawable.no_1);
        String namaPaslon = getArguments().
                getString("nama_paslon", "PASLON 1");
        imgPaslon.setImageResource(drawableImage);
        txtNamaPaslon.setText(namaPaslon);
        builder.setView(view);
        return builder.create();
    }
}
