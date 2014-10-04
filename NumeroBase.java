
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase que representa objetos con dos atributos:
 *  - Un número
 *  - La base de dicho número
 *  - Un booleano que indica si el número y la base cumplen todas las restricciones del problema 
 *    (ver más abajo)
 *  - Un mapa de correspondencias para poder resolver instancias del problema con bases mayores a 10
 * 
 * El número y la base deberán cumplir ciertas restricciones:
 *  - El número deberá ser no negativo
 *  - La base debe ser mayor o igual a 2
 *  - Cualquier cifra del número deberá ser estrictamente menor que la base
 * 
 *  Dado que el abecedario tiene 27 letras, se ha fijado la base numérica máxima permitida en 37.
 * 
 * @author Daniel Alejandro Castro García <dandev237@gmail.com>
 */

public class NumeroBase {

    //Atributos de clase
    String numeroString;
    int base;
    boolean correcto;
    Map<Character, Integer> mapValores = new TreeMap<>();
    
    //Constructor
    public NumeroBase (String num, int base){
        initMap();
        this.numeroString = num;
        this.base = base;
        correcto = comprobar();
    }
    
    //Métodos de clase

    /**
     * Método que comprueba que el número y la base cumplen todas las restricciones.
     *
     * @return true si el número y la base cumplen todas las restricciones del problema
     */
    private boolean comprobar() {
        boolean restriccionNumero = true, restriccionBase = true, restriccionCifras = true;
        
        //Comprobación restriccionNumero (El número deberá ser no negativo)
        if(numeroString.charAt(0) == '-')
            restriccionNumero = false;
        //Fin comprobación restriccionNumero
        
        //Comprobación restriccionBase (La base debe ser mayor o igual a 2, y menor o igual a 37)
        if(restriccionNumero && (base < 2 && base > 37))
            restriccionBase = false;
        //Fin comprobación restriccionBase
        
        // Comprobación restriccionCifras (Cualquier cifra del número deberá ser estrictamente menor que la base)
        if(restriccionNumero && restriccionBase){
            char[] cifras = numeroString.toCharArray();
            int i = 0;
        
           while(restriccionCifras && i < cifras.length){//Si el número es negativo, salta la comprobación 
              /*
                Mirar el mapa de correspondencias para averigüar el valor numérico asociado a la cifra.
                Útil cuando la cifra en cuestión tiene por numeral una letra (bases mayores a 10).
                */
                int cifraAux = mapValores.get(cifras[i]);
            
                if(cifraAux >= base)
                    restriccionCifras = false;
                i++;
            }
        }
        //Fin comprobación restriccionCifras
        
        return restriccionNumero && restriccionBase && restriccionCifras;
    }
    
    /**
     *  Método que permite comprobar si una instancia de NumeroBase es válida.
     * 
     * @return true si el número y la base cumplen las restricciones del problema
     */    
    
    public boolean esValido(){
        return correcto;
    }
    
    /**
     *  Método que realiza el cambio de base a base decimal del número en cuestión
     *  empleando el algoritmo de Horner.
     *
     *  @return el número contenido, en base decimal
     */

    public int cambiarBase (){
        int resultado = 0;
        String num = numeroString;

        for(int i = 0; i < num.length(); i++){
            int cifra = mapValores.get(num.charAt(i));
            cifra *= Math.pow(base, num.length()-(i+1));
            resultado += cifra;
        }
        
        return resultado;
    }

    //Getters para numero y base
    
    public String getNumero() {
        return numeroString;
    }

    public int getBase() {
        return base;
    }

    //Método auxiliar para inicializar el mapa de correspondencias
    private void initMap() {
        //Números
        mapValores.put('0', 0);
        mapValores.put('1', 1);
        mapValores.put('2', 2);
        mapValores.put('3', 3);
        mapValores.put('4', 4);
        mapValores.put('5', 5);
        mapValores.put('6', 6);
        mapValores.put('7', 7);
        mapValores.put('8', 8);
        mapValores.put('9', 9);
        
        //Letras
        mapValores.put('A', 10);
        mapValores.put('B', 11);
        mapValores.put('C', 12);
        mapValores.put('D', 13);
        mapValores.put('E', 14);
        mapValores.put('F', 15);
        mapValores.put('G', 16);
        mapValores.put('H', 17);
        mapValores.put('I', 18);
        mapValores.put('J', 19);
        mapValores.put('K', 20);
        mapValores.put('L', 21);
        mapValores.put('M', 22);
        mapValores.put('N', 23);
        mapValores.put('Ñ', 24);
        mapValores.put('O', 25);
        mapValores.put('P', 26);
        mapValores.put('Q', 27);
        mapValores.put('R', 28);
        mapValores.put('S', 29);
        mapValores.put('T', 30);
        mapValores.put('U', 31);
        mapValores.put('V', 32);
        mapValores.put('W', 33);
        mapValores.put('X', 34);
        mapValores.put('Y', 35);
        mapValores.put('Z', 36);
        
        mapValores.put('-', 9999999);
    }
    
    
}
