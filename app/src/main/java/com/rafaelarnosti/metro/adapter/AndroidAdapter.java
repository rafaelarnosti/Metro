package com.rafaelarnosti.metro.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rafaelarnosti.metro.R;
import com.rafaelarnosti.metro.model.Estacao;
import com.rafaelarnosti.metro.model.Linha;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by logonrm on 26/06/2017.
 */

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder> {

    private List<Linha> linhas;
    private OnItemClickListener listener;


    public AndroidAdapter(List<Linha> linhas, OnItemClickListener listener){
        this.linhas = linhas;
        this.listener = listener;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View meuLayout = inflater.inflate(R.layout.android_row,parent,false);
        return new AndroidViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, final int position) {

        holder.tvTitulo.setText(linhas.get(position).getCor());
        holder.tvSubTitulo.setText(linhas.get(position).getNumero());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(linhas.get(position));
            }
        });

        Picasso.with(holder.itemView.getContext())
                .load(linhas.get(position).getUrlImagem())
                .into(holder.ivAndroid);

    }

    @Override
    public int getItemCount() {
        return linhas.size();
    }

    public class AndroidViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivAndroid;
        public TextView tvTitulo;
        public TextView tvSubTitulo;

        public AndroidViewHolder(View itemView) {
            super(itemView);
            ivAndroid = (ImageView) itemView.findViewById(R.id.ivAndroid);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvSubTitulo = (TextView) itemView.findViewById(R.id.tvSubTitulo);

        }
    }
    public void update(List<Linha> linhas){
        this.linhas = linhas;
        notifyDataSetChanged();
    }
}
