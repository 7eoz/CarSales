package com.studies.sandrini.carsales;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sandrini on 13/11/2017.
 */

public class CarAdapter extends BaseAdapter {
    private final List<Car> cars;
    private final Context context;

    public CarAdapter(Context context, List<Car> cars) {
        this.context = context;
        this.cars = cars;
    }


    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return cars.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Car car = cars.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;

        if(view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView modeloField; //= (TextView) view.findViewById(R.id.car_model);
        TextView precoField; //= (TextView) view.findViewById(R.id.car_price);
        ImageView imagemField; //= (ImageView) view.findViewById(R.id.car_image);


        //modeloField.setText(car.getModelo());
        //precoField.setText(car.getPreco());
        if(car.getFoto() != null){
            Bitmap bitmap = BitmapFactory.decodeFile(car.getFoto());
            Bitmap minimizedBitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            //imagemField.setImageBitmap(minimizedBitmap);
            //imagemField.setScaleType(ImageView.ScaleType.FIT_XY);
        }

        return view;
    }
}


