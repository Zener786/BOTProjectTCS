//package com.example.yash.bot;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.content.Intent;
//
//
//import com.google.firebase.firestore.FirebaseFirestore;
//
//import java.util.List;
//
//public class RackAdapter extends RecyclerView.Adapter<RackAdapter.RackViewHolder> {
//
//    private Context mCtx;
//    private List<Coordinate> rackList;
//   private FirebaseFirestore db;
//
//    public RackAdapter(Context mCtx, List<Coordinate> rackList) {
//        this.mCtx = mCtx;
//        this.rackList = rackList;
//    }
//
//    @NonNull
//    @Override
//    public RackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new RackViewHolder(
//                LayoutInflater.from(mCtx).inflate(R.layout.layout_racks, parent, false)
//        );
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RackViewHolder holder, int position) {
//        Coordinate c = rackList.get(position);
//
//
//        holder.textX.setText(c.getX());
//        holder.textY.setText(c.getY());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return rackList.size();
//    }
//
//    class RackViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        TextView textX;
//        TextView textY;
//
//        public RackViewHolder(View itemView) {
//            super(itemView);
//
//            textX = itemView.findViewById(R.id.textX);
//            textY = itemView.findViewById(R.id.textY);
//
//            itemView.setOnClickListener(this);
//
//        }
//
//        @Override
//        public void onClick(View v) {
//            Coordinate c = rackList.get(getAdapterPosition());
//            Intent intent = new Intent(mCtx, ProductsActivity.class);
//           intent.putExtra("pos",getAdapterPosition());
//            mCtx.startActivity(intent);
//        }
//    }
//}