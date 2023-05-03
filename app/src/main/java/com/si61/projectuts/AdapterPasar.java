package com.si61.projectuts;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPasar extends RecyclerView.Adapter<AdapterPasar.ViewHolderPasar> {
    private Context ctx;
    private ArrayList arrId, arrNama, arrKota, arrAlamat;

    public AdapterPasar(Context ctx, ArrayList arrId, ArrayList arrNama, ArrayList arrKota, ArrayList arrAlamat) {
        this.ctx = ctx;
        this.arrId = arrId;
        this.arrNama = arrNama;
        this.arrKota = arrKota;
        this.arrAlamat = arrAlamat;
    }


    @NonNull
    @Override
    public ViewHolderPasar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.list_item_pasar, parent, false);
        return new ViewHolderPasar(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPasar.ViewHolderPasar holder, int position) {
        holder.tvId.setText(arrId.get(position).toString());
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvKota.setText(arrKota.get(position).toString());
        holder.tvAlamat.setText(arrAlamat.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrNama.size();
    }

    public class ViewHolderPasar extends RecyclerView.ViewHolder {
        TextView tvId, tvNama, tvKota, tvAlamat;

        public ViewHolderPasar(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvKota = itemView.findViewById(R.id.tv_kota);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder pesan = new AlertDialog.Builder(ctx);
                    pesan.setTitle("Perhatian");
                    pesan.setMessage("Perintah Apa yang akan Dilakukan?");
                    pesan.setCancelable(true);

                    pesan.show();
                    return false;
                }
            });
        }
    }
}
