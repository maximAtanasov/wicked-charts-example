package de.adesso.wickedcharts.example;

import de.adesso.wickedcharts.chartjs.ChartConfiguration;
import de.adesso.wickedcharts.chartjs.chartoptions.*;
import de.adesso.wickedcharts.chartjs.chartoptions.colors.RgbaColor;
import de.adesso.wickedcharts.chartjs.chartoptions.colors.SimpleColor;
import de.adesso.wickedcharts.chartjs.chartoptions.label.TextLabel;
import de.adesso.wickedcharts.chartjs.chartoptions.valueType.IntegerValue;
import de.adesso.wickedcharts.wicket8.chartjs.Chart;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author maximAtanasov
 */
public class Homepage extends WebPage implements Serializable {

    private static final long serialVersionUID = 1L;

    public Homepage(final PageParameters parameters) {
        ChartConfiguration chartConfiguration = new ChartConfiguration();
        Data data = new Data().setLabels(TextLabel.of("January", "February", "March", "April", "May", "June", "July"));

        Dataset dataset1 = new Dataset()
                .setLabel("My first dataset")  //Ein Label für den Datensatz
                .setBackgroundColor(SimpleColor.RED) //Wir wählen eine Farbe aus dem SimpleColor Enum, dieses Enum enthält einige der am häufigsten verwendeten Farben.
                .setBorderColor(new RgbaColor(0, 50, 255, 255)) //Sie können aber auch Ihre eigene Farbe mit den Klassen RgbaColor/HexColor definieren.
                        .setData(IntegerValue.of(6,7,8,2,1,1,3)) //Hier setzen wir die eigentlichen Datenpunkte.
                        .setFill(false);

        data.setDatasets(Arrays.asList(dataset1));
        chartConfiguration.setData(data);
        chartConfiguration.setType(ChartType.LINE);

        Options options = new Options()
                .setResponsive(true)
                .setTitle(new Title()
                        .setDisplay(true)
                        .setText("Chart.js Line Chart")) //Der Titel unseres Diagramms.
                .setTooltips(new Tooltips() //Unsere Tooltips (Diese sieht man beim Überfahren eines Datenpunktes)
                        .setMode(TooltipMode.INDEX)
                        .setIntersect(false))
                .setHover(new Hover()
                        .setMode(HoverMode.NEAREST)
                        .setIntersect(true))
                .setScales(new Scales()
                        .setXAxes(new AxesScale() //Wir konfigurieren die X-Achse
                                .setDisplay(true)
                                .setScaleLabel(new ScaleLabel()
                                        .setDisplay(true)
                                        .setLabelString("Month")))
                        .setYAxes(new AxesScale() //Und die Y-Achse
                                .setDisplay(true)
                                .setTicks(new Ticks()
                                        .setMax(10)
                                        .setMin(0))
                                .setScaleLabel(new ScaleLabel()
                                        .setDisplay(true)
                                        .setLabelString("Value"))));

        chartConfiguration.setOptions(options);
        Chart chart = new Chart("chart", chartConfiguration);
        add(chart);
    }
}
