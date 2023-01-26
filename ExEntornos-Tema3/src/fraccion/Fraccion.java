package fraccion;

/**
 * Clase que define una fracción
 * 
 * @author pgallardo
 * @version 1.0
 */

public class Fraccion {
	/**
	 * Numerador
	 */
	private int num;

	/**
	 * Denominador
	 */
	private int den;

	/**
	 * Constructor por defecto Debe generar el valor neutro que es 0/1
	 */
	public Fraccion() {
		/**
		 * 
		 */
		num = 0;
		den = 1;

	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param num Numerador
	 * @param den Denominador
	 */
	public Fraccion(int num, int den) {
		/**
		 * Debo evitar crear fracciones con 0 en el divisor
		 */
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		/**
		 * Devuelvo la fracción simplificada
		 */

		simplificar();
	}

	/**
	 * Constructor copia
	 * 
	 * @param f fracción del método
	 */

	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	/**
	 * Setter num
	 * 
	 * @param num Numerador
	 */

	public void setNum(int num) {
		this.num = num;

	}

	/**
	 * Getter num
	 * @return num Devuelve el numerador
	 */
	public int getNum() {
		return num;

	}

	/**
	 * Setter den
	 * @param den Denominador
	 */

	public void setDen(int den) {
		this.den = den;
	}

	/**
	 * Getter den
	 * @return den Devuelve el denominador
	 */
	public int getDen() {
		return den;
	}

	/**
	 * Cálculo del máximo común divisor por el algoritmo de Euclides
	 * @return u Devuelve el valor absoluto del numerador
	 */
	private int mcd() {
		int u = (Math.abs(num));
		int v = (Math.abs(den)); 
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	/**
	 * método para simplificar fracciones
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}
 
	/**
	 * Crea el mensaje
	 * @return mensaje devuelve el mensaje
	 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}


	/**
	 *suma de fracciones
	 * @param f Fracción 
	 * @return aux devuelve el resultado
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	
	/**
	 * Restar fracciones
	 * @param f Fracción 
	 * @return aux devuelve el resultado
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}


	/**
	 * Multiplicar fracciones
	 * @param f Fracción
	 * @return aux devuelve el resultado
	 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}


	/**
	 * Dividir fracciones
	 * @param f Fracción
	 * @return aux devuelve el resultado
	 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
