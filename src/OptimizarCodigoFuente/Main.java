/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package OptimizarCodigoFuente;

/**
 *
 * @author Yohanna Gelo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Esto es crear / instanciar un objeto
        Calculadora casio1 = new Calculadora("Casio", "PD20", "SN231242");
        Calculadora casio2 = new Calculadora();
        
        //ya podemos usar sus metodos (suma, resta...) que no son STATIC
        casio1.suma(3, 8);
        casio2.multiplica(5, 7);
        
        System.out.println("");
        
        //usamos el metodo sobrecargado por número de parametros:
        casio1.suma();
        
        System.out.println("");
        
        //usamos el metodo sobrecargado por tipo de datos:
        int n1 = 5;
        int n2 = 5;
        casio1.suma(n1, n2);
        
        System.out.println("");
        
        //por defecto no puedo acceder a los atributos, ya que su visivilidad es privada. Pero si puedo verlos a través de un metodo de su clase
        casio1.datos();
        
        System.out.println("");
        
        //con los getter podemos recibir los datos en nueva variable o mostrarlo con sout
        String marca1 = casio1.getMarca();
        System.out.println(marca1);
        
        //con los setter pasaremos un parámetro para modificar el dato en cuestion
        casio2.setModelo("TG2564");
        
        
    }
    
}
