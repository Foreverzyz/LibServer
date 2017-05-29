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
public class VectorAnalasy {
	 private static String file_path = "E:\\RSSIdata\\dataRssi_at_1.txt";
	
    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	int datasize[] = TxtUtils.getSize(file_path);
		double data[][] = new double[datasize[0]][datasize[1]];
		data = TxtUtils.readTxtFile(file_path, datasize);
		
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("信号标准化过程");
        shell.setSize(500, 400);
        shell.setLayout(new FillLayout());

        createChart(shell,data);

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
     * 
     */
    static public Chart createChart(Composite parent, double[][] chartdata) {
    	
    	double[]data = Matrix.getColumn(chartdata, 0);
    	for(double n : data){
    		System.out.println(n);
    	}
    	
        // create a chart
        final Chart chart = new Chart(parent, SWT.NONE);
        chart.getTitle().setText("AP信号正态分布图");
        chart.getAxisSet().getXAxis(0).getTitle().setText("WIFI信号强度变化");
        chart.getAxisSet().getYAxis(0).getTitle().setText("高斯分布");
        // create line series
        ILineSeries series1 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_1");
        series1.setYSeries(StatisticsUtils.GaosiCaculate(data));
        series1.setXSeries(Matrix.getColumn(chartdata, 0));
        
       
        
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