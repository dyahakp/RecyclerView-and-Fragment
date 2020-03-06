package com.example.pahlawanku;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

//1
public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HeroModel> heroList;

    public HeroAdapter(Context context, ArrayList<HeroModel> heroList) {
        this.context = context;
        this.heroList = heroList;
    }

    public ArrayList<HeroModel> getHeroList() {
        return heroList;
    }

    public void setHeroList(ArrayList<HeroModel> heroList) {
        this.heroList = heroList;
    }

    //2
    @NonNull
    @Override
    public HeroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_design, viewGroup, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapter.ViewHolder viewHolder, final int position) {
        Glide.with(context).load(getHeroList().get(position).getHeroImage()).into(viewHolder.imageView);
        viewHolder.tvHeroName.setText(getHeroList().get(position).getHeroName());
        viewHolder.tvHeroDetails.setText(getHeroList().get(position).getHeroDesc());
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Ini Pahlawan  : " + getHeroList().get(position).getHeroName(), Toast.LENGTH_SHORT).show();
            }

        });
        viewHolder.btnDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HeroDetails.class);
                intent.putExtra("img_url", getHeroList().get(position).getHeroImage());
                intent.putExtra("heroes_name", getHeroList().get(position).getHeroName());
                intent.putExtra("heroes_details", getHeroList().get(position).getHeroDesc());
                context.startActivity(intent);
            }

        });
        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String heroesDetails = "Hello saya ingin memberi kamu informasi tentang PAHLAWAN DI INDONESIA \n Nama Pahlawan : " + getHeroList().get(position).getHeroName() + "\n" + getHeroList().get(position).getHeroDesc();
                intent.putExtra(Intent.EXTRA_TEXT, heroesDetails);
                context.startActivity(Intent.createChooser(intent, "Share To "));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getHeroList().size();
    }

    //3
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvHeroName;
        private TextView tvHeroDetails;
        private Button btnShare;
        private Button btnDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //setelah ke recycler view
            imageView = itemView.findViewById(R.id.img_item_photo);
            tvHeroName = itemView.findViewById(R.id.tv_item_name);
            tvHeroDetails = itemView.findViewById(R.id.tv_item_detail);
            btnShare = itemView.findViewById(R.id.btn_share);
            btnDesc = itemView.findViewById(R.id.btn_details);


        }
    }
    //buat view holder

}
