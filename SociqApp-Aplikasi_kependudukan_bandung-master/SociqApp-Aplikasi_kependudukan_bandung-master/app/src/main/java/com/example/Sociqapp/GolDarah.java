package com.example.Sociqapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;

import java.util.ArrayList;
import java.util.List;

public class GolDarah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gol_darah);
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);


        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("A", 331835));
        data.add(new ValueDataEntry("B", 262284));
        data.add(new ValueDataEntry("AB", 128496));
        data.add(new ValueDataEntry("O", 453389));
        data.add(new ValueDataEntry("A+", 7706));
        data.add(new ValueDataEntry("A-", 303));
        data.add(new ValueDataEntry("B+", 7419));
        data.add(new ValueDataEntry("B-", 481));
        data.add(new ValueDataEntry("AB+", 3805));
        data.add(new ValueDataEntry("AB-", 683));
        data.add(new ValueDataEntry("O+", 6047));
        data.add(new ValueDataEntry("O-", 1990));
        data.add(new ValueDataEntry("Tidak Tahu", 1326010));




        Column column = cartesian.column(data);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("Jenis Golongan Darah");

        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Jenis Golongan Darah");
        cartesian.yAxis(0).title("Jumlah ");

        anyChartView.setChart(cartesian);

        ActionBar menu  = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}


