package calculadoraTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
import OptimizarCodigoFuente.Calculadora;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yohanna Gelo
 */
public class pruebasTest {
    
    //creamos atributos para usar en los diferentes test, en nuestro caso un objeto calculadora
    private Calculadora objectCalc = new Calculadora();

    public pruebasTest() {
    }

    
    //Antes de todos los test
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Comienza la ejecución de la clase prueba...");
    }

    //Después de todos los test
    @AfterClass
    public static void tearDownClass() {
        System.out.println("\nFin de la ejecución de la clase pruebas.");
    }

    //Antes de cada test
    @Before
    public void setUp() {
        System.out.println("\n   ---   INICIO PRUEBA   ---");
    }

    @After
    public void tearDown() {
        System.out.println("\n         FIN PRUEBA\n--------------------------------\n");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSuma() {
        System.out.println("\nEjecutando Suma");
        double num1 = 2.4;
        double num2 = 5.8;
        double expResult = 8.2;
        double result = objectCalc.suma(num1, num2);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testResta() {
        System.out.println("\nEjecutando Resta");
        double num1 = 90;
        double num2 = 75.8;
        double expResult = 14.2;
        double result = objectCalc.resta(num1, num2);
        assertEquals(expResult, result, 0.00000000000001);
    }
    
    
//    @Test
//    public void testMultiplica() {
//        System.out.println("\nEjecutando Multiplicación");
//        double num1 = 10;
//        double num2 = 6;
//        double expResult = 60;
//        double result = objectCalc.multiplica(num1, num2);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    
//    @Test
//    public void testDivide() {
//        System.out.println("\nEjecutando División");
//        double num1 = 10;
//        double num2 = 5;
//        double expResult = 2;
//        double result = objectCalc.divide(num1, num2);
//        assertEquals(expResult, result, 0.0);
//    }

}
