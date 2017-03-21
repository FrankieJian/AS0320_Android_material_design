package com.example.g572_528r.as0320_android_material_design;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by g572-528r on 2017/3/21.
 */

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.ViewHolder> {
    private Context mContext;
    private List<MaterialDesign> mMaterialDesignList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView materialImage;
        TextView materialName;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            materialImage = (ImageView) view.findViewById(R.id.material_image);
            materialName = (TextView) view.findViewById(R.id.material_name);
        }
    }

    public MaterialAdapter (List<MaterialDesign> materialDesignList) {
        mMaterialDesignList = materialDesignList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.material_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MaterialDesign materialDesign = mMaterialDesignList.get(position);
        holder.materialName.setText(materialDesign.getName());
        Glide.with(mContext).load(materialDesign.getImageId()).into(holder.materialImage);
    }

    @Override
    public int getItemCount() {
        return mMaterialDesignList.size();
    }
}
