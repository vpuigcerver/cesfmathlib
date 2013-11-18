package cesf.math;
/**
 * 
 * @author cesf
 * Classe per disposar de nombres complexos
 * Els nombres complexos tenen la forma a+bi (ex. 3+4i),
 * on i és l'arrel quadrada de -1 i base dels nombres
 * imaginaris.
 * Les parts d'un nombre complex s'anomenen:
 * * a = part real
 * * b = part imaginària
 * Es poden calcular moltes coses amb nombres complexos
 * i accepten diverses operacions. Aquesta classe 
 * implementa les més destacables i necessàries.
 *
 *
 */
public class Complex {
	
	private final double re;  // part real
	private final double im;  // part imaginària
	
	// Constructor per defecte
	/**
	 * 
	 */
	public Complex() { 
		re = 0; 
		im = 0; 
	}
	// Constructor amb paràmetres
	/**
	 * 
	 * @param re
	 * @param im
	 */
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
    // Retorna una representació en cadena de text
	/**
	 * 
	 */
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // Retorna el mòdul del complex
    /**
     * 
     * @return
     */
    public double abs()   { return Math.hypot(re, im); }
    // Retorna la fase (angle) del complex
    /**
     * 
     * @return
     */
    public double phase() { return Math.atan2(im, re); }

    // Suma un segon complex i retorna el resultat
    /**
     * 
     * @param b
     * @return
     */
    public Complex add(Complex b) {
        double real = this.re + b.re;
        double imag = this.im + b.im;
        return new Complex(real, imag);
    }

    // Resta un segon complex i retorna el resultat
    /**
     * 
     * @param b
     * @return
     */
    public Complex substract(Complex b) {
        double real = this.re - b.re;
        double imag = this.im - b.im;
        return new Complex(real, imag);
    }

    // Multiplica per un segon complex i retorna el resultat
    /**
     * 
     * @param b
     * @return
     */
    public Complex multiply(Complex b) {
        double real = this.re * b.re - this.im * b.im;
        double imag = this.re * b.im + this.im * b.re;
        return new Complex(real, imag);
    }

    // Multiplica per un real i retorna el resultat
    /**
     * 
     * @param x
     * @return
     */
    public Complex multiply(double x) {
    	double real = x * this.re;
    	double imag = x * this.im;
        return new Complex(real, imag);
    }

    // Retorna la divisió per un segon complex
    /**
     * 
     * @param b
     * @return
     */
    public Complex divide(Complex b) {
        return this.multiply(b.reciprocal());
    }

    // Retorna el complex conjugat de l'actual
    /**
     * 
     * @return
     */
    public Complex conjugate() {
    	return new Complex(this.re, -this.im); 
    }

    // Retorna el recíproc d'aquest complex
    /**
     * 
     * @return
     */
    public Complex reciprocal() {
        double x = this.re * this.re + this.im * this.im;
        return new Complex(this.re / x, -this.im / x);
    }

    // getters
    /**
     * 
     * @return
     */
    public double getReal() { return this.re; }
    public double getImag() { return this.im; }

    // Retorna l'exponenciació del complex
    /**
     * 
     * @return
     */
    public Complex exp() {
    	double real = Math.exp(this.re) * Math.cos(this.im);
    	double imag = Math.exp(this.re) * Math.sin(this.im);
        return new Complex(real, imag);
    }

    // Retorna el sinus del complex
    /**
     * 
     * @return
     */
    public Complex sin() {
    	double real = Math.sin(re) * Math.cosh(im);
    	double imag = Math.cos(re) * Math.sinh(im);
        return new Complex(real, imag);
    }

    // Retorna el cosinus del complex
    /**
     * 
     * @return
     */
    public Complex cos() {
    	double real = Math.cos(re) * Math.cosh(im);
    	double imag = -Math.sin(re) * Math.sinh(im);
        return new Complex(real, imag);
    }

    // Retorna la tangent del complex
    /**
     * 
     * @return
     */
    public Complex tan() {
        return sin().divide(cos());
    }
    
    // versió estàtica de la funció suma
    /**
     * 
     * @param a
     * @param b
     * @return
     */
    public static Complex add(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }


}
