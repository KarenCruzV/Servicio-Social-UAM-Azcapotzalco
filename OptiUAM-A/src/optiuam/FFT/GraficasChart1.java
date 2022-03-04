
import optiuam.modelo.FFT;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficasChart1 {

    public static void main(String[] args) {
        int t0=8; //tiempo 0 , centrar pulso
        int w0=10; //frecuencia angular
        int s2 = 5; //ro^2 , anchura pulso
        int fs = 8; //frecuencia de muestreo
        int n = 128;//tamaño de datos
        double dt = 1/8.0;
        System.out.println(dt);
        
        float[] datos = new float[128];
                for(int i = 0 ; i < n ; i++){
                        
                        double x = i*dt;
                        //System.out.println(x);
                        datos [i]= (float) (Math.exp(-(Math.pow((x-t0),2))/(2*s2))*Math.cos(w0*x));  
                        //System.out.println(new BigDecimal(datos[i]).floatValue());
                }
         
                FFT fft = new FFT(128,8);
		
		FFT.NumeroComplejoArray cna = fft.fft(datos);
		
                float [] partesReales=cna.getPartesReales();
                float [] partesImaginarias=cna.getPartesImaginarias();
                float [] absFFT= new float[128];
                //sacar el valor absoluto sqrt(a+ib)
                for(int i =0; i < 128; i++){
                    absFFT[i]=(float) Math.sqrt(Math.pow(partesReales[i], 2)+Math.pow(partesImaginarias[i], 2));
                }
                
                
                //hacer el corriemiento a la derecha fftshift en Matlab
                float [] fftShift=new float [128];
                for(int i = 64; i < 128; i++){
                    fftShift[i]=absFFT[i-64];
                }
                
                for(int j = 0; j < 64; j++){
                    fftShift[j]=absFFT[j+64];
                }
                
		for(int i=0;i<datos.length;i++)
			System.out.println(i+"--"+fftShift[i]);
                
                
                

        XYSeries series = new XYSeries("xy");
        
         //Introduccion de datos
                for(int i = 0 ; i < 320 ; i++){
                        double x = i/20.0;
                        series.add(x,Math.exp(-(Math.pow((x-8),2))/(2*10))*Math.cos(10*x));  
                }
               
        XYSeries transformada = new XYSeries("xy");
                for(int i = -64;i<64;i++)
                    transformada.add((i*((2*Math.PI)/(n*dt))),fftShift[i+64]/fs);
                       
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "funcion", // Título
                "Tiempo (x)", // Etiqueta Coordenada X
                "y", // Etiqueta Coordenada Y
                dataset, // Datos
                PlotOrientation.VERTICAL,
                true, // Muestra la leyenda de los productos (Producto A)
                false,
                false
        );

        // Mostramos la grafica en pantalla
        ChartFrame frame = new ChartFrame("funcion", chart);
        frame.pack();
        frame.setVisible(true);
        
        //para la tranfsormada
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset2.addSeries(transformada);

        JFreeChart chart2 = ChartFactory.createXYLineChart(
                "transformada", // Título
                "frecuencia (w)", // Etiqueta Coordenada X
                "y", // Etiqueta Coordenada Y
                dataset2, // Datos
                PlotOrientation.VERTICAL,
                true, // Muestra la leyenda de los productos (Producto A)
                false,
                false
        );

        // Mostramos la grafica en pantalla
        ChartFrame frame2 = new ChartFrame("transformada", chart2);
        frame2.pack();
        frame2.setVisible(true);

    }

}