/**
 * Enunciado: Desarrollar un programa para cambiar un número de una base b a base 10 usando la Regla de Horner.
 * 
 * @author Daniel Alejandro Castro García <dandev237@gmail.com>
 */

import java.util.Scanner;

public class Horner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NumeroBase numero;
        String num;
        int base;
        boolean fin = false;
        
        
        System.out.println("Inserta un numero");
        num = input.nextLine();
        System.out.println("Inserta la base numérica del número anterior");        
        base = input.nextInt();
        numero = new NumeroBase(num.toUpperCase(), base);
        
        
        if(numero.esValido()){
            System.out.println("Número recibido como parámetro: " + numero.getNumero());
            System.out.println("Base numérica: " + numero.getBase());
            System.out.println("------------------------------------------------------");
            System.out.println("La representación en base decimal del numero es: " + numero.cambiarBase());
        }else{
            System.out.println("Error en la entrada");
        }
    }
}
