/*
 */
package gestionEmpleadosV2;
import java.util.Scanner;
/**
 *
 * @author Yohanna Gelo
 */
public class EmployeeManagementV2 {

    //variables que se declaran fuera del main, deben ser est�ticos
    private static Scanner s = new Scanner(System.in);
    private static EmployeeV2[] employeesArray ;
    
    //FUNCI�N MEN�
    private static int menu() {
        
        int opt = 0;
        
            System.out.println("\n      ~ GESTI�N DE EMPLEADOS ~");

            System.out.println("\n+-----------------------------------+");
            System.out.println("|         MEN� PRINCIPAL:           |");
            System.out.println("|        -----------------          |");
            System.out.println("|    �  1. Cargar empleados         |");
            System.out.println("|    �  2. Listar empleados         |");
            System.out.println("|    �  3. Listar n�minas           |");
            System.out.println("|         -----------------         |");
            System.out.println("|    �  0. SALIR                    |");
            System.out.println("+-----------------------------------+");

            System.out.print(  "    -> Seleccione una opci�n: ");
            opt = s.nextInt();

            while (opt < 0 || opt > 3) {
                System.out.print("- La opci�n debe estar entre 0 y 3: ");
                opt = s.nextInt();
            }
        
        return opt;
    }
    
    
    //FUNCI�N METER DATOS
    private static boolean loadData (boolean load) {
        
        boolean reload = false;     //controla si queremos volver a meter los datos
        
        if (load) {     //si los datos ya est�n cargados se advierte y se pregunta si se quiere volver a meterlos
            System.out.print("\nLos datos ya est�n cargados.\n�Quiere volver a cargarlos? (Si / No): ");
            String answer = s.next();
            
            while (!answer.toLowerCase().equals("si") && !answer.toLowerCase().equals("no")  ) {
                System.out.print("    - La opci�n debe ser Si / No: ");
                answer = s.next();
            }
            
            if (answer.toLowerCase().equals("si")) {
                
                reload = true;
                
            }

        } 
        
        //si aun no est� metidos o se quieresn volver a meter, entramos aqu� y pedimos toda la informaci�n
        if (!load || reload)  {
            
            System.out.print("\nIntroduce el n�mero de empleados: ");
            //int numEmpl = s.nextInt();

            employeesArray = new EmployeeV2[s.nextInt()]; //par no crear una variable de tama�o

            System.out.println("\nIntroduzca los datos de los empleados.");
            s.nextLine();

            for (int i = 0; i < employeesArray.length; i++) {

                //Construir/instanciar objeto empleado
                employeesArray[i] = new EmployeeV2();

                //pedimos datos por teclado
                System.out.println("\n   " +(i+1)+"� empleado:\n"
                                + "   ---------------");
                System.out.print(" � Nombre\t: ");
                employeesArray[i].setName(s.nextLine());
                System.out.print(" � Apellidos\t: ");
                employeesArray[i].setSurname(s.nextLine());
                System.out.print(" � DNI\t\t: ");
                employeesArray[i].setDni(s.nextLine());
                System.out.print(" � Direcci�n\t: ");
                employeesArray[i].setDirection(s.nextLine());
                System.out.print(" � Provincia\t: ");
                employeesArray[i].setProvince(s.nextLine());
                System.out.print(" � Poblaci�n\t: ");
                employeesArray[i].setPopulation(s.nextLine());
                System.out.print(" � CP\t\t: ");
                employeesArray[i].setCp(s.nextInt());
                System.out.print(" � Edad\t\t: ");
                employeesArray[i].setAge(s.nextInt());
                s.nextLine();
                System.out.print(" � Categoria Profesional (A - B - C - D) : ");
                char cat = s.nextLine().toUpperCase().charAt(0);
                    while (cat != 'A' && cat != 'B' && cat != 'C' && cat != 'D') {
                    System.out.print("    - La opci�n debe ser A, B, C o D: ");
                    cat = s.nextLine().toUpperCase().charAt(0);
                    }
                    employeesArray[i].setProfesionalCategory(cat);

                System.out.print(" � N�mero de hijos : ");
                employeesArray[i].setNumberChildren(s.nextInt());
                System.out.print(" � Nivel ingl�s (1-3)\t: ");
                int levelEn = s.nextInt();
                    while (levelEn < 1 || levelEn > 3) {
                    System.out.print("    - La opci�n debe estar entre 1 y 3: ");
                    levelEn = s.nextInt();
                    }
                    employeesArray[i].setEnglishLevel(levelEn);

                System.out.print(" � A�os de antiguedad\t: ");
                employeesArray[i].setExperienceCompany(s.nextInt());

                s.nextLine();

            }

        load = true;
        
        }
        
        intro();
        return load;

    }
    
    //FUNCI�N PARA VER DATOS DE LOS EMPLEADOS
    private static void showData (EmployeeV2[] employeesArray, boolean load) {
        
        if (load) {
            for (int i = 0; i < employeesArray.length; i++) {

                //mostramos los datos personales de cada empleado
                System.out.println("\n   " +(i+1)+"� empleado:\n"
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
    
    //FUNCI�N PARA VER LAS N�MINAS DE LOS EMPLEADOS
    private static void showPayroll (EmployeeV2[] employeesArray, boolean load) {
        
        if (load) {
            for (int i = 0; i < employeesArray.length; i++) {

                //se calcula la n�mina de cada empleado
                System.out.println("\n   " +(i+1)+"� empleado:\n"
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
    
    
    //FUNCI�N PARA PULSAR INTRO Y CONTINUAR
    public static void intro () {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("\nPulse intro para volver al men� principal.");
        String intro = s.nextLine();
        System.out.println("\n\n");
        
    }
    
    
    
    ///   --->>>   ���   MAIN   !!!   <<<---   ///
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        boolean load = false;
        boolean repeat = true;
        
        ////LLAMAR FUNCIONES / ACCIONES
        //entramos en el bucle de ejecuci�n del programa
        while (repeat) {
            //lanzamos el men�
            int opt = EmployeeManagementV2.menu();
            

            //acciones seg�n la opci�n seleccionada
            switch (opt) {
                case 0:
                    //SALIMOS DEL PROGRAMA
                    repeat = false;
                    System.out.println("\n   �GRACIAS POR USAR EL PROGRAMA!\n"
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
                    //LISTAR N�MINAS
                    showPayroll(employeesArray, load);
                    break;
                    
            }   //fin switch
           
        }   //fin while
        
        
    }
    
}
