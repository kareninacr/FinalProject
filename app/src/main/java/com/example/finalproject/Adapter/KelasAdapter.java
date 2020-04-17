package com.example.finalproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Activities.Admin.InputData.DataKelas.DataKelas;
import com.example.finalproject.Activities.Admin.InputData.DataKelas.EditKelas;
import com.example.finalproject.Activities.Admin.InputData.DataKelas.ShowDataKelas;
import com.example.finalproject.Model.Kelas;
import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.KelasViewHolder> {

    private List<Kelas> kelasList = new ArrayList<>();
    private Context mContext;

    public KelasAdapter(List<Kelas> kelasList, Context mContext) {
        this.kelasList = kelasList;
        this.mContext = mContext;
    }

    @Override
    public KelasAdapter.KelasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.kelas_item, parent, false);
        KelasViewHolder kelasVH = new KelasViewHolder(v);
        return kelasVH;
    }

    @Override
    public void onBindViewHolder(KelasAdapter.KelasViewHolder holder, int position) {
        holder.tvKelas.setText(kelasList.get(position).getNama_kelas());
        holder.tvKompetensi.setText(kelasList.get(position).getKompetensi());
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, EditKelas.class);
                mContext.startActivity(intent);
            }
        });

        holder.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ShowDataKelas.class);
                mContext.startActivity(intent);
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"data telah dihapus",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return kelasList.size();
    }

    public static class KelasViewHolder extends RecyclerView.ViewHolder {
        TextView tvKelas, tvKompetensi;
        private ImageButton btnEdit,btnShow,btnDelete;

        public KelasViewHolder(View itemView) {
            super(itemView);

            tvKelas = (TextView) itemView.findViewById(R.id.tvKelas);
            tvKompetensi = (TextView) itemView.findViewById(R.id.tvKompetensi);
            btnEdit = (ImageButton) itemView.findViewById(R.id.btnEdit);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnHapus);
            btnShow = (ImageButton) itemView.findViewById(R.id.btnLihat);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
