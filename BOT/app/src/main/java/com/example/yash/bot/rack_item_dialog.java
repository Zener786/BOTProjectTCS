package com.example.yash.bot;

/*

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class rack_item_dialog extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rack_item_dialog);


        Dialog dialog;
        final String[] items = {" PHP", " JAVA", " JSON", " C#", " Objective-C"};
        //final ArrayList itemsSelected = new ArrayList();
        final HashMap<String,Integer> item_price=new HashMap<String, Integer>();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Languages you know : ");
        builder.setMultiChoiceItems(items, null,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedItemId,
                                        boolean isSelected) {
                        if (isSelected) {
                            item_price.put(getString(selectedItemId),);
                        } else if (itemsSelected.contains(selectedItemId)) {
                            itemsSelected.remove(Integer.valueOf(selectedItemId));
                        }
                    }
                })
                .setPositiveButton("Done!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Your logic when OK button is clicked
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        dialog = builder.create();
        dialog.show();
    }
}
*/