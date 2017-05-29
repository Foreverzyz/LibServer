package com.server.utils;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries;
import org.swtchart.ISeries.SeriesType;

import Catalano.Math.Matrix;

/**
 * An example to get bounds of series symbol.
 */
public class AllRssiDataAnalasy {

    private static String path1 = "E:\\RSSIdata\\all_testdata.txt";
    
    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	
    	int datasize[] = TxtUtils.getSize(path1);
		double data[][] = new double[datasize[0]][datasize[1]];
		data = TxtUtils.readTxtFile(path1, datasize);
    	
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("室内全局采样信号");
        shell.setSize(1000, 1000);
        shell.setLayout(new FillLayout());

        createChart(shell, data);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    /**
     * create the chart.
     * 
     * @param parent
     *            The parent composite
     * @return The created chart
     */
    static public Chart createChart(Composite parent,double[][] chardata) {

        // create a chart
        final Chart chart = new Chart(parent, SWT.NONE);
       
        chart.getTitle().setText("室内全局WIFI信号变化分布");
        chart.getAxisSet().getXAxis(0).getTitle().setText("时间变化/秒");
        chart.getAxisSet().getYAxis(0).getTitle().setText("WIFI信号强度值/dbm");
        // create line series
        ILineSeries series1 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_1");
        series1.setYSeries(Matrix.getColumn(chardata, 0));
       
        ILineSeries series2 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_2");
        series2.setYSeries(Matrix.getColumn(chardata, 1));
        series2.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_RED));
        ILineSeries series3 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_3");
        series3.setYSeries(Matrix.getColumn(chardata, 2));
        series3.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_BLACK));
        ILineSeries series4 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_4");
        series4.setYSeries(Matrix.getColumn(chardata, 3));
        series4.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_DARK_GREEN));
        
        ILineSeries series5 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_5");
        series5.setYSeries(Matrix.getColumn(chardata, 4));
        series5.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GREEN));
        ILineSeries series6 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_6");
        series6.setYSeries(Matrix.getColumn(chardata, 5));
        series6.setLineColor(Display.getDefault() 
                        .getSystemColor(SWT.COLOR_DARK_RED));
        
        ILineSeries series7 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_7");
        series7.setYSeries(Matrix.getColumn(chardata, 6));
        series7.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series8 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_8");
        series8.setYSeries(Matrix.getColumn(chardata, 7));
        series8.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series9 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_9");
        series9.setYSeries(Matrix.getColumn(chardata, 8));
        series9.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series10 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_10");
        series10.setYSeries(Matrix.getColumn(chardata, 9));
        series10.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series11 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_11");
        series11.setYSeries(Matrix.getColumn(chardata, 10));
        series11.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series12 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_12");
        series12.setYSeries(Matrix.getColumn(chardata, 11));
        series12.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series13 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_13");
        series13.setYSeries(Matrix.getColumn(chardata, 9));
        series13.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series14 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_14");
        series14.setYSeries(Matrix.getColumn(chardata, 9));
        series14.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series15 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_15");
        series15.setYSeries(Matrix.getColumn(chardata, 14));
        series15.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series16 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_16");
        series16.setYSeries(Matrix.getColumn(chardata, 15));
        series16.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        ILineSeries series17 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_17");
        series17.setYSeries(Matrix.getColumn(chardata, 16));
        series17.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        ILineSeries series18 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_18");
        series18.setYSeries(Matrix.getColumn(chardata, 17));
        series18.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        ILineSeries series19 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_19");
        series19.setYSeries(Matrix.getColumn(chardata, 18));
        series19.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        ILineSeries series20 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_20");
        series20.setYSeries(Matrix.getColumn(chardata, 19));
        series20.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series21 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_21");
        series21.setYSeries(Matrix.getColumn(chardata, 20));
        series21.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series22 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_22");
        series22.setYSeries(Matrix.getColumn(chardata, 21));
        series22.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series23 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_23");
        series23.setYSeries(Matrix.getColumn(chardata, 22));
        series23.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series24 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_24");
        series24.setYSeries(Matrix.getColumn(chardata, 23));
        series24.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series25 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_25");
        series25.setYSeries(Matrix.getColumn(chardata, 24));
        series25.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series26 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_26");
        series26.setYSeries(Matrix.getColumn(chardata, 25));
        series26.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series27 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_27");
        series27.setYSeries(Matrix.getColumn(chardata, 26));
        series27.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series28 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_28");
        series28.setYSeries(Matrix.getColumn(chardata, 27));
        series28.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series29 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_29");
        series29.setYSeries(Matrix.getColumn(chardata, 28));
        series29.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series30 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_30");
        series30.setYSeries(Matrix.getColumn(chardata, 29));
        series30.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series31 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_31");
        series31.setYSeries(Matrix.getColumn(chardata, 30));
        series31.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        ILineSeries series32 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_32");
        series32.setYSeries(Matrix.getColumn(chardata, 31));
        series32.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        
        ILineSeries series33 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_33");
        series33.setYSeries(Matrix.getColumn(chardata, 32));
        series33.setLineColor(Display.getDefault()
                        .getSystemColor(SWT.COLOR_GRAY));
        // adjust the axis range
        chart.getAxisSet().adjustRange();
        
        // add mouse move listener to open tooltip on data point
        chart.getPlotArea().addMouseMoveListener(new MouseMoveListener() {
            public void mouseMove(MouseEvent e) {
                for (ISeries series : chart.getSeriesSet().getSeries()) {
                    for (int i = 0; i < series.getYSeries().length; i++) {
                        Point p = series.getPixelCoordinates(i);
                        double distance = Math.sqrt(Math.pow(e.x - p.x, 2)
                                + Math.pow(e.y - p.y, 2));

                        if (distance < ((ILineSeries) series).getSymbolSize()) {
                            setToolTipText(series, i);
                            return;
                        }
                    }
                }
                chart.getPlotArea().setToolTipText(null);
            }

            private void setToolTipText(ISeries series, int index) {
                chart.getPlotArea().setToolTipText(
                        "Series: " + series.getId() + "\nValue: "
                                + series.getYSeries()[index]);
            }
        });
             
        return chart;
    }
}