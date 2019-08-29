package com.example.a015;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<String> data;
    private LayoutInflater mLayoutInflater;
    private List<Integer> letterCharList;
    private String[] title;

    public MyAdapter(Context context, List<String> data, List<Integer> letterCharList, String[] title) {
        super();
        this.context = context;
        this.data = data;
        this.letterCharList = letterCharList;
        this.title = title;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(mLayoutInflater==null){
            mLayoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null){
            convertView=mLayoutInflater.inflate(R.layout.maillist_item,null,false);
        }
        TextView tv02=convertView.findViewById(R.id.mainlist_item_tv01);
        if(letterCharList.get(position)>=0){
            tv02.setVisibility(View.VISIBLE);
            tv02.setText(title[letterCharList.get(position)]);
        }else {
            tv02.setVisibility(View.GONE);
        }
        tv02.setTextColor(Color.BLACK);
		TextView tv01 = (TextView) convertView.findViewById(R.id.mainlist_item_tv02);
		tv01.setText(data.get(position));
		tv01.setTextColor(Color.BLACK);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.cityTV.setText(data.get(position));
            }
        });
        return convertView;
    }
}
