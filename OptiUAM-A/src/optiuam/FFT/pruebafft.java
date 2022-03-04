

package optiuam.FFT;

import optiuam.modelo.FFT;

/**
 *
 *
 */
public class pruebafft {
	public static void main(String[] args) {
		
                
		float[] datos = new float[128];
                for(int i = 0 ; i < 128 ; i++){
                        double x = i/2.0;
                        datos [i]= (float) (x*Math.exp(-x));  
                }
                for(float o :datos)
			System.out.println(o+" , ");
		
                                //2^n ,0Hz
		FFT fft = new FFT(128,8);
		
		FFT.NumeroComplejoArray cna = fft.fft(datos);
		
		for(int i=0;i<datos.length;i++)
			System.out.println(cna.getNumero(i));
		
		FFT.Analizador fftAnalyzer  = new FFT.Analizador(fft);
		
		System.out.println(fftAnalyzer.getFrequencyAtMaxAmplitude(cna));
		
		float[] oData = fft.ifft(cna);
		
		for(float o :oData)
			System.out.println(o+" , ");
                
              //  System.out.println(fft.getBinaryOne());
	}
}
