package com.example.Sociqapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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

public class Pekerjaan extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pekerjaan);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);


        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("BELUM/TIDAK BEKERJA", 488321));
        data.add(new ValueDataEntry("APARATUR/PEJABAT NEGARA", 75127));
        data.add(new ValueDataEntry("  TENAGA PENGAJAR", 22407));
        data.add(new ValueDataEntry("WIRASWASTA", 813958));
        data.add(new ValueDataEntry("PERTANIAN/PETERNAKAN", 1356));
        data.add(new ValueDataEntry("NELAYAN", 47));
        data.add(new ValueDataEntry("AGAMA DAN KEPERCAYAAN", 935));
        data.add(new ValueDataEntry("PELAJAR/MAHASISWA", 541194));
        data.add(new ValueDataEntry("TENAGA KESEHATAN", 8637));
        data.add(new ValueDataEntry("PENSIUNAN", 35915));
        data.add(new ValueDataEntry("LAINNYA", 542911));



        Column column = cartesian.column(data);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("Jenis Pekerjaan");

        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Tahun");
        cartesian.yAxis(0).title("Jumlah Penduduk");

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