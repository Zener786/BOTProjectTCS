package com.example.yash.bot;




        import android.annotation.SuppressLint;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.app.Activity;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Menu;
        import android.view.View;
        import android.view.ViewGroup.LayoutParams;
        import android.widget.*;
/*
public class matrix extends AppCompatActivity
{
    int i,j;
    int colcount = 7;
    int rowcount = 20;

    Button[][] btn=new Button[rowcount][colcount];
    int selectedOptionForCell;
    RadioButton[] rb = new RadioButton[4];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ScrollView svv = new ScrollView(this);
        svv.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.WRAP_CONTENT, ScrollView.LayoutParams.WRAP_CONTENT));
        LinearLayout linLayout = new LinearLayout(this);
        linLayout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams linLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        GridLayout grd;
        GridLayout.LayoutParams gllop;
        HorizontalScrollView svh;

//        -------------------------------Upper Layout-----------------
        LinearLayout linLayout0 = new LinearLayout(this);
        linLayout0.setOrientation(LinearLayout.VERTICAL);

        TextView title=new TextView(this);
        title.setText("Select Check Box and Accordingly select boxes");
        title.setTextSize(25);
        title.setTextColor(Color.RED);
        title.setHeight(10);

        RadioGroup rg = new RadioGroup(this); //create the RadioGroup
        rg.setOrientation(RadioGroup.HORIZONTAL);//or RadioGroup.VERTICAL
        rb[0]=new RadioButton(this);
        rb[1]=new RadioButton(this);
        rb[2]=new RadioButton(this);
        rb[3]=new RadioButton(this);

        rb[0].setText("Blocked Way");
        rb[1].setText("Door");
        rb[2].setText("Racks");
        rb[3].setText("Delete Current state");

        for(int i=0; i<rb.length; i++)
        {
            rg.addView(rb[i]);
        }
        linLayout0.addView(title);
        linLayout0.addView(rg);

        linLayout.addView(linLayout0);
//--------------------------------------------------------------------------

        for(i = 0; i < rowcount; i++)
        {

            grd = new GridLayout(this);
            grd.setColumnCount(colcount);
            grd.setRowCount(rowcount);
            grd.setBackgroundColor(Color.YELLOW);
            for(j = 0; j < colcount; j++)
            {
                btn[i][j] = new Button(this);
                btn[i][j].setText("Block " + (i+1) +","+(j+1));

                grd.addView(btn[i][j]);
                selectedOptionForCell=-1;
                btn[i][j].setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        if(rb[0].isChecked())
                        {
                            v.setBackgroundColor(Color.BLACK);
                            ((Button)v).setTextColor(Color.WHITE);
                        }
                        else if(rb[1].isChecked())
                            v.setBackgroundColor(Color.CYAN);
                        else if(rb[2].isChecked())
                            v.setBackgroundColor(Color.RED);
                        else if(rb[3].isChecked())
                        {
                            v.setBackgroundResource(android.R.drawable.btn_default);
                            ((Button)v).setTextColor(Color.BLACK);
                        }

                    }
                });

            }
            svh = new HorizontalScrollView(this);
            svh.addView(grd);
            linLayout.addView(svh);
        }
        svv.addView(linLayout);
        setContentView(svv, linLayoutParam);

    }

    int dialog()
    {
        final String[] grpname={"Blocked Way","Door","Rack"};
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        //alt_bld.setIcon(R.drawable.icon);
        alt_bld.setTitle("Select a Group Name");
        alt_bld.setSingleChoiceItems(grpname, -1, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int item)
            {
                Toast.makeText(getApplicationContext(), "Group Name = "+grpname[item], Toast.LENGTH_SHORT).show();
                selectedOptionForCell=item;
                dialog.dismiss();// dismiss the alertbox after chose option

            }
        });
        AlertDialog alert = alt_bld.create();
        alert.show();

        return selectedOptionForCell;

    }

}


*/