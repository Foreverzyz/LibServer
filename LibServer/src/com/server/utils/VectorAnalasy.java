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
import org.swtchart.LineStyle;
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
    	
    	double[] xdata = Matrix.getColumn(chartdata, 0);
    	double[] ydata = StatisticsUtils.GaosiCaculate(xdata);
    	System.out.println(xdata.length);
    	System.out.println(ydata.length);
    	for(double n : xdata){
    		System.out.println(n);
    	}
    	
        // create a chart
        final Chart chart = new Chart(parent, SWT.NONE);
        chart.getTitle().setText("AP信号正态分布图");
        chart.getAxisSet().getXAxis(0).getTitle().setText("高斯分布");
        chart.getAxisSet().getYAxis(0).getTitle().setText("WIFI信号强度变化");
        // create line series
        ILineSeries series1 = (ILineSeries) chart.getSeriesSet().createSeries(
                SeriesType.LINE, "ap_1");
        series1.setLineStyle(LineStyle.NONE);
        series1.setXSeries(xdata);
        series1.setYSeries(ydata);
        
        // adjust the axis range
        chart.getAxisSet().adjustRange();

        return chart;
    }
}