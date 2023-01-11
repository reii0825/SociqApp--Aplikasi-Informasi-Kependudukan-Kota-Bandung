package com.example.Sociqapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class Pendidikan extends AppCompatActivity {
    ListView listView;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendidikan);

        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("TIDAK/BELUM SEKOLAH", 442492));
        data.add(new ValueDataEntry("BELUM TAMAT SD/SEDERAJAT", 237422));
        data.add(new ValueDataEntry("TAMAT SD/SEDERAJAT", 290201));
        data.add(new ValueDataEntry("SLTP/SEDERAJAT", 338892));
        data.add(new ValueDataEntry("SLTA/SEDERAJAT", 811289));
        data.add(new ValueDataEntry("DIPLOMA I/II", 22632));
        data.add(new ValueDataEntry("AKADEMI/DIPLOMA III/S.MUDA", 92269));
        data.add(new ValueDataEntry("DIPLOMA IV/STRATA I", 260476));
        data.add(new ValueDataEntry("STRATA II", 30623));
        data.add(new ValueDataEntry("STRATA III", 4152));


        pie.data(data);

        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
        anyChartView.setChart(pie);

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