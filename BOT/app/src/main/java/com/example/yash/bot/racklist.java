package com.example.yash.bot;

//
//// custom adaptor class
//
//import android.app.Activity;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import java.util.List;
//
//public class racklist extends ArrayAdapter<product> {
//    private Activity context;
//    private List<product> ProductList;
//    public racklist(Activity context, List<product> ProductList){
//        super(context,R.layout.list_layout,ProductList);
//        this.context=context;
//        this.ProductList=ProductList;
//    }
//
//
//
//    @Override
//    public View getView(int position, View convertView,ViewGroup parent) {
//        LayoutInflater inflator = context.getLayoutInflater();
//
//        View listViewItem=inflator.inflate(R.layout.list_layout,null,true);
//
//        TextView t1=(TextView)listViewItem.findViewById(R.id.rackname);
//        TextView t2=(TextView)listViewItem.findViewById(R.id.productname);
//        TextView t3=(TextView)listViewItem.findViewById(R.id.price);
//        TextView t4=(TextView)listViewItem.findViewById(R.id.qty);
//        TextView t5=(TextView)listViewItem.findViewById(R.id.offer);
//
//
//        product p= ProductList.get(position);
//        t1.setText(p.getRackname());
//        t2.setText(p.getProductname());
//        t3.setText(p.getPrice());
//        t4.setText(p.getQty());
//        if(p.isOffer()) {
//            t5.setText("Offer Applicable");
//        }
//        else{
//            t5.setText("No Offer");
//        }
//        return listViewItem;
//    }
//}
