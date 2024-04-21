/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package OptimizarCodigoFuente;

import java.util.Scanner;

/**
 *
 * @author Yohanna Gelo
 */
public class Calculadora {

    // Atributos
    private String marca;
    private String modelo;
    private String nserie;

    private Scanner s = new Scanner(System.in);

    // Constructor
    public Calculadora(String marca, String modelo, String nserie) {
        this.marca = marca;
        this.modelo = modelo;
        this.nserie = nserie;

    }

    // Constructor sobrecargado por n�mero de par�metros
    public Calculadora() {

    }

    // M�todos
    public double suma(double n1, double n2) {
        double result = n1+n2;
        System.out.println("La suma de " + n1 + " m�s " + n2 + " es " + result);
        
        return result;
    }

    //metodo suma sobrecargado por n�mero de par�metros
    public void suma() {
        System.out.println("Introduce el 1� n�mero: ");
        float n1 = s.nextFloat();

        System.out.println("Introduce el 2� n�mero: ");
        float n2 = s.nextFloat();

        System.out.println("La suma de " + n1 + " m�s " + n2 + " es " + (n1 + n2));
    }

    //metodo suma sobrecargado segun el tipo de parametros
    public int suma(int n1, int n2) {
        int result = n1+n2;
        System.out.println("La suma de " + n1 + " m�s " + n2 + " es " + result);
        
        return result;
    }

    public double resta(double n1, double n2) {
        double result = n1-n2;
        System.out.println("La resta de " + n1 + " menos " + n2 + " es "
                + result);
        
        return result;
    }

//    public double multiplica(double n1, double n2) {
//        double result = n1*n2;
//        System.out.println("La multiplicaci�n de " + n1 + " por " + n2 + " es " + result);
//        
//        return result;
//    }
//
    public double divide(double n1, double n2) {
        double result = n1/n2;
        System.out.println("La divisi�n de " + n1 + " entre " + n2 + " es " + result);
        
        return result;
    }

    
    //para poder visualizar los atributos private desde fuera, tendr�amos que pasarlo desde aqu�, desde la propia clase
    public void datos() {
        System.out.println("La marca es " + this.marca + ", el m�delo es " + this.modelo + " y el n�mero de serie es " + this.nserie);
    }

    // m�todos getters (LEER) y setters (MODIFICAR). DE ESTA FORMA PUEDO DEJAR QUE DESDE OTRAS CLASES SE VEAN Y MODIFIQUEN ESTOS DATOS
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNserie() {
        return nserie;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNserie(String nserie) {  //PODR�A ELIMINAR ESTE, YA QUE NO ES UN DATO QUE SE DEBA MODIFICAR
        this.nserie = nserie;
    }

}
