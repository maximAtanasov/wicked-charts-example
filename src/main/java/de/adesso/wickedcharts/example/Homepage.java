package de.adesso.wickedcharts.example;

import de.adesso.wickedcharts.chartjs.ChartConfiguration;
import de.adesso.wickedcharts.chartjs.chartoptions.*;
import de.adesso.wickedcharts.chartjs.chartoptions.colors.RgbaColor;
import de.adesso.wickedcharts.chartjs.chartoptions.colors.SimpleColor;
import de.adesso.wickedcharts.chartjs.chartoptions.label.TextLabel;
import de.adesso.wickedcharts.chartjs.chartoptions.valueType.IntegerValue;
import de.adesso.wickedcharts.wicket7.chartjs.Chart;
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
                .setLabel("My first dataset")
                .setBackgroundColor(SimpleColor.BLUE)
                .setBorderColor(SimpleColor.BLUE)
                        .setData(IntegerValue.of(6,7,8,2,1,1,3))
                        .setFill(false);

        data.setDatasets(Arrays.asList(dataset1));
        chartConfiguration.setData(data);
        chartConfiguration.setType(ChartType.LINE);

        Options options = new Options()
                .setResponsive(true)
                .setTitle(new Title()
                        .setDisplay(true)
                        .setText("Chart.js Line Chart"))
                .setTooltips(new Tooltips()
                        .setMode(TooltipMode.INDEX)
                        .setIntersect(false))
                .setHover(new Hover()
                        .setMode(HoverMode.NEAREST)
                        .setIntersect(true))
                .setScales(new Scales()
                        .setXAxes(new AxesScale()
                                .setDisplay(true)
                                .setScaleLabel(new ScaleLabel()
                                        .setDisplay(true)
                                        .setLabelString("Month")))
                        .setYAxes(new AxesScale()
                                .setTicks(new Ticks()
                                        .setMax(10)
                                        .setMin(0))
                                .setDisplay(true)
                                .setScaleLabel(new ScaleLabel()
                                        .setDisplay(true)
                                        .setLabelString("Value"))));

        chartConfiguration.setOptions(options);
        Chart chart = new Chart("chart", chartConfiguration);
        add(chart);
    }
}
