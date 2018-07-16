package com.example.android.infoline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter implements View.OnClickListener{


    String[] MainTopics = {"Health", "Network","Bank"};
    String[][] subTopics = {{"Cancer","Depression","Diabeties","Rape","Road Accident"
            ,"HIV", "Periods"},{"Vodaphone","Airtel"},{"SBI","PNB","HDFC"}};

    Context context;

    public ExpandableListViewAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getGroupCount() {
        return MainTopics.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return subTopics[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return MainTopics[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return subTopics[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //to return the main topics
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        TextView txtview = new TextView(context);
        txtview.setText(MainTopics[groupPosition]);
        txtview.setPadding(100,0,0,0);
        txtview.setTextColor(Color.parseColor("#D8F793"));
        txtview.setTextSize(40);
        return txtview;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {

        TextView txtview = new TextView(context);
        txtview.setText(subTopics[groupPosition][childPosition]);
        txtview.setPadding(100,0,0,0);
        txtview.setTextColor(Color.CYAN);
        txtview.setTextSize(40);
        txtview.setOnClickListener(this);

        //txtview.setOnClickListener(Toast.makeText(context,txtview.getText().toString(),Toast.LENGTH_SHORT).show();

        return txtview;
    }

    @Override
    public void onClick(View v) {

        String text = ((TextView) v).getText().toString();
        Log.i("value of child text",text);
        switch (text){
            case "Cancer":
                context.startActivity(new Intent(context, SecondActivity.class));
                break;
            case "Depression":
                context.startActivity(new Intent(context, DepressionActivity.class));
                break;
            case "Diabeties":
                context.startActivity(new Intent(context, DiabetiesActivity.class));
                break;
            case "Rape":
                context.startActivity(new Intent(context, RapeActivity.class));
                break;
            case "Road Acident":
                context.startActivity(new Intent(context, AccidentActivity.class));
                break;
            case "HIV":
                context.startActivity(new Intent(context, HIVActivity.class));
                break;
            case "Periods":
                context.startActivity(new Intent(context, PeriodsActivity.class));
                break;

        }

        //context.startActivity(new Intent(context, SecondActivity.class));
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
