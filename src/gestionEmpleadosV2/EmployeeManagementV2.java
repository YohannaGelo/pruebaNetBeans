/*
 */
package gestionEmpleadosV2;
import java.util.Scanner;
/**
 *
 * @author Yohanna Gelo
 */
public class EmployeeManagementV2 {

    //variables que se declaran fuera del main, deben ser estáticos
    private static Scanner s = new Scanner(System.in);
    private static EmployeeV2[] employeesArray ;
    
    //FUNCIÓN MENÚ
    private static int menu() {
        
        int opt = 0;
        
            System.out.println("\n      ~ GESTIÓN DE EMPLEADOS ~");

            System.out.println("\n+-----------------------------------+");
            System.out.println("|         MENÚ PRINCIPAL:           |");
            System.out.println("|        -----------------          |");
            System.out.println("|    ·  1. Cargar empleados         |");
            System.out.println("|    ·  2. Listar empleados         |");
            System.out.println("|    ·  3. Listar nóminas           |");
            System.out.println("|         -----------------         |");
            System.out.println("|    ·  0. SALIR                    |");
            System.out.println("+-----------------------------------+");

            System.out.print(  "    -> Seleccione una opción: ");
            opt = s.nextInt();

            while (opt < 0 || opt > 3) {
                System.out.print("- La opción debe estar entre 0 y 3: ");
                opt = s.nextInt();
            }
        
        return opt;
    }
    
    
    //FUNCIÓN METER DATOS
    private static boolean loadData (boolean load) {
        
        boolean reload = false;     //controla si queremos volver a meter los datos
        
        if (load) {     //si los datos ya están cargados se advierte y se pregunta si se quiere volver a meterlos
            System.out.print("\nLos datos ya están cargados.\n¿Quiere volver a cargarlos? (Si / No): ");
            String answer = s.next();
            
            while (!answer.toLowerCase().equals("si") && !answer.toLowerCase().equals("no")  ) {
                System.out.print("    - La opción debe ser Si / No: ");
                answer = s.next();
            }
            
            if (answer.toLowerCase().equals("si")) {
                
                reload = true;
                
            }

        } 
        
        //si aun no está metidos o se quieresn volver a meter, entramos aquí y pedimos toda la información
        if (!load || reload)  {
            
            System.out.print("\nIntroduce el número de empleados: ");
            //int numEmpl = s.nextInt();

            employeesArray = new EmployeeV2[s.nextInt()]; //par no crear una variable de tamaño

            System.out.println("\nIntroduzca los datos de los empleados.");
            s.nextLine();

            for (int i = 0; i < employeesArray.length; i++) {

                //Construir/instanciar objeto empleado
                employeesArray[i] = new EmployeeV2();

                //pedimos datos por teclado
                System.out.println("\n   " +(i+1)+"º empleado:\n"
                                + "   ---------------");
                System.out.print(" · Nombre\t: ");
                employeesArray[i].setName(s.nextLine());
                System.out.print(" · Apellidos\t: ");
                employeesArray[i].setSurname(s.nextLine());
                System.out.print(" · DNI\t\t: ");
                employeesArray[i].setDni(s.nextLine());
                System.out.print(" · Dirección\t: ");
                employeesArray[i].setDirection(s.nextLine());
                System.out.print(" · Provincia\t: ");
                employeesArray[i].setProvince(s.nextLine());
                System.out.print(" · Población\t: ");
                employeesArray[i].setPopulation(s.nextLine());
                System.out.print(" · CP\t\t: ");
                employeesArray[i].setCp(s.nextInt());
                System.out.print(" · Edad\t\t: ");
                employeesArray[i].setAge(s.nextInt());
                s.nextLine();
                System.out.print(" · Categoria Profesional (A - B - C - D) : ");
                char cat = s.nextLine().toUpperCase().charAt(0);
                    while (cat != 'A' && cat != 'B' && cat != 'C' && cat != 'D') {
                    System.out.print("    - La opción debe ser A, B, C o D: ");
                    cat = s.nextLine().toUpperCase().charAt(0);
                    }
                    employeesArray[i].setProfesionalCategory(cat);

                System.out.print(" · Número de hijos : ");
                employeesArray[i].setNumberChildren(s.nextInt());
                System.out.print(" · Nivel inglés (1-3)\t: ");
                int levelEn = s.nextInt();
                    while (levelEn < 1 || levelEn > 3) {
                    System.out.print("    - La opción debe estar entre 1 y 3: ");
                    levelEn = s.nextInt();
                    }
                    employeesArray[i].setEnglishLevel(levelEn);

                System.out.print(" · Años de antiguedad\t: ");
                employeesArray[i].setExperienceCompany(s.nextInt());

                s.nextLine();

            }

        load = true;
        
        }
        
        intro();
        return load;

    }
    
    //FUNCIÓN PARA VER DATOS DE LOS EMPLEADOS
    private static void showData (EmployeeV2[] employeesArray, boolean load) {
        
        if (load) {
            for (int i = 0; i < employeesArray.length; i++) {

                //mostramos los datos personales de cada empleado
                System.out.println("\n   " +(i+1)+"º empleado:\n"
                                + "   ---------------");

                System.out.println( employeesArray[i].toString());

            }
            
            intro();
            
        } else {
            System.out.println("\nNecesita tener los datos de los empleados\n"
                    + "cargados antes de poder verlos.");
            
            intro();
        }
        
    }
    
    //FUNCIÓN PARA VER LAS NÓMINAS DE LOS EMPLEADOS
    private static void showPayroll (EmployeeV2[] employeesArray, boolean load) {
        
        if (load) {
            for (int i = 0; i < employeesArray.length; i++) {

                //se calcula la nómina de cada empleado
                System.out.println("\n   " +(i+1)+"º empleado:\n"
                                + "   ---------------");
                
                employeesArray[i].Payroll();
                
            }
            
            intro();
            
        } else {
            System.out.println("\nNecesita tener los datos de los empleados\n"
                    + "cargados antes de poder verlos.");
            
            intro();
            
        }
        
        
    }
    
    
    //FUNCIÓN PARA PULSAR INTRO Y CONTINUAR
    public static void intro () {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("\nPulse intro para volver al menú principal.");
        String intro = s.nextLine();
        System.out.println("\n\n");
        
    }
    
    
    
    ///   --->>>   ¡¡¡   MAIN   !!!   <<<---   ///
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        boolean load = false;
        boolean repeat = true;
        
        ////LLAMAR FUNCIONES / ACCIONES
        //entramos en el bucle de ejecución del programa
        while (repeat) {
            //lanzamos el menú
            int opt = EmployeeManagementV2.menu();
            

            //acciones según la opción seleccionada
            switch (opt) {
                case 0:
                    //SALIMOS DEL PROGRAMA
                    repeat = false;
                    System.out.println("\n   ¡GRACIAS POR USAR EL PROGRAMA!\n"
                                     + "      Creado por Yohanna Gelo\n");
                    break;
                case 1:
                    //CARGAR EMPLEADOS
                    load = loadData(load);
                    break;
                case 2:
                    //LISTAR EMPLEADOS
                    showData(employeesArray, load);
                    break;
                case 3:
                    //LISTAR NÓMINAS
                    showPayroll(employeesArray, load);
                    break;
                    
            }   //fin switch
           
        }   //fin while
        
        
    }
    
}
