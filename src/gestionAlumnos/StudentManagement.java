
package gestionAlumnos;
import java.util.Scanner;

/**
 *
 * @author Yohanna Gelo
 */
public class StudentManagement {

    //variables que se declaran fuera del main, deben ser estáticos
    private static Scanner s = new Scanner(System.in);
    private static Student[] studentsArray;
    private static Module[] modulesArray;

    //FUNCIÓN MENÚ
    private static int menu() {

        int opt = 0;

        System.out.println("\n      ~ GESTIÓN DE ALUMNADO ~");

        System.out.println("\n+-----------------------------------+");
        System.out.println("|         MENÚ PRINCIPAL:           |");
        System.out.println("|        -----------------          |");
        System.out.println("|    ·  1. Matricular alumnos       |");
        System.out.println("|    ·  2. Listar alumnos           |");
        System.out.println("|    ·  3. Cargar notas             |");
        System.out.println("|    ·  4. Listar notas             |");
        System.out.println("|         -----------------         |");
        System.out.println("|    ·  5. SALIR                    |");
        System.out.println("+-----------------------------------+");

        System.out.print("    -> Seleccione una opción: ");
        opt = s.nextInt();

        while (opt < 1 || opt > 5) {
            System.out.print("- La opción debe estar entre 1 y 5: ");
            opt = s.nextInt();
        }

        return opt;
    }

    //FUNCIÓN MENÚ MÓDULOS
    public static Module selectModule(Module[] selectedModules) {
       
        Module module = null;   //asigno un valor null para poder devolver el valor haciendo verificaciones...
        boolean validSelection = false; //...como que el alumno no haya elegido ya ese modulo, para eso este booleano

        while (!validSelection) {   //mientras no se haya elegido el modulo seleccionado, entro
            System.out.println("Seleciona el módulo");
            System.out.println("1. EDD - 1DAW");
            System.out.println("2. PGR - 1DAW");
            System.out.println("3. BD - 1DAW");
            System.out.println("4. LM - 1DAW");
            System.out.println("5. SI - 1DAW");
            System.out.println("6. DPL - 2DAW");
            System.out.println("7. ESERV - 2DAW");
            System.out.println("8. ECLIEN - 2DAW");
            System.out.println("9. DINT - 2DAW");
            System.out.println("10.LC - 2DAW");

            int op = s.nextInt();

            switch (op) {
                case 1 ->
                    module = new Module("EDD", "1DAW", 3);
                case 2 ->
                    module = new Module("PGR", "1DAW", 8);
                case 3 ->
                    module = new Module("BD", "1DAW", 6);
                case 4 ->
                    module = new Module("LM", "1DAW", 4);
                case 5 ->
                    module = new Module("SI", "1DAW", 6);
                case 6 ->
                    module = new Module("DPL", "2DAW", 3);
                case 7 ->
                    module = new Module("ESERV", "2DAW", 8);
                case 8 ->
                    module = new Module("ECL", "2DAW", 6);
                case 9 ->
                    module = new Module("DINT", "2DAW", 6);
                case 10 ->
                    module = new Module("LC", "2DAW", 3);
                default -> {
                    System.out.println("No se ha selecionado un módulo de la lista , se creará uno vacío");
                    module = new Module();
                }
            }

            
            if (module != null) {
                // Verificar si el módulo ya fue elegido por el estudiante
                boolean alreadySelected = false;
                for (Module selectedModule : selectedModules) { //si el nombre del modulo coincide con alguno ya guardado y es distinto a null
                    if (selectedModule != null && selectedModule.getName().equals(module.getName())) {
                        alreadySelected = true; //activamos la bandera de modulo seleccionado
                        break;
                    }
                }
                if (!alreadySelected) { //segun la bandera anterior decimos si la seleccion es válida y seguimos eligiendo el siguiente módulo
                    validSelection = true;
                } else {
                    System.out.println("Este módulo ya fue elegido.\nPor favor, selecciona otro.\n");  //o pedimos que se elija otro que no esté elegido
                }
            }

            
        }

        return module;

    }

    //FUNCIÓN METER DATOS
    private static boolean loadStudents(boolean load) {

        boolean reload = false;     //controla si queremos volver a meter los datos

        if (load) {     //si los datos ya están cargados se advierte y se pregunta si se quiere volver a meterlos
            System.out.print("\nLos datos ya están cargados.\n¿Quiere volver a cargarlos? (Si / No): ");
            String answer = s.next();

            while (!answer.toLowerCase().equals("si") && !answer.toLowerCase().equals("no")) {
                System.out.print("    - La opción debe ser Si / No: ");
                answer = s.next();
            }

            if (answer.toLowerCase().equals("si")) {

                reload = true;

            }

        }

        //si aun no está metidos o se quieren volver a meter, entramos aquí y pedimos toda la información
        if (!load || reload) {

            System.out.print("\nIntroduce el número de estudiantes: ");
            studentsArray = new Student[s.nextInt()]; //para no crear una variable de tamaño

            System.out.println("\nIntroduzca los datos de los estudiantes.");
            s.nextLine();

            for (int i = 0; i < studentsArray.length; i++) {

                //Construir/instanciar objeto estudiante
                studentsArray[i] = new Student();

                //pedimos datos personales por teclado
                System.out.println("\n   " + (i + 1) + "º estudiante:\n"
                        + "   ---------------");
                System.out.print(" · Nombre\t: ");
                studentsArray[i].setName(s.nextLine());
                System.out.print(" · Apellidos\t: ");
                studentsArray[i].setSurname(s.nextLine());
                System.out.print(" · DNI\t\t: ");
                studentsArray[i].setDni(s.nextLine());
                System.out.print(" · Dirección\t: ");
                studentsArray[i].setDirection(s.nextLine());
                System.out.print(" · Provincia\t: ");
                studentsArray[i].setProvince(s.nextLine());
                System.out.print(" · Población\t: ");
                studentsArray[i].setPopulation(s.nextLine());
                System.out.print(" · CP\t\t: ");
                studentsArray[i].setCp(s.nextInt());
                s.nextLine();
                System.out.print(" · Centro\t: ");
                studentsArray[i].setCenter(s.nextLine());

                //pedimos los módulos en los que se quiere matricular
                System.out.print("\n · Módulos para matricular\t: ");
                System.out.print("\nIntroduce el número de modulos a elegir: ");
                //definimos el tamaño del array de los módulos
                modulesArray = new Module[s.nextInt()];

                System.out.println("\nSelecciona los módulos: ");
                for (int j = 0; j < modulesArray.length; j++) {

                    //pedimos los datos
                    System.out.println("\n   " + (j + 1) + "º módulo:\n"
                            + "   ---------------");

                    //Construir/instanciar objeto modulo
                    modulesArray[j] = selectModule(modulesArray);

                }
                //el nuevo array será el que modifique como parametro del estudiante
                studentsArray[i].setModules(modulesArray);

                s.nextLine();
            }
            load = true;
        }
        intro();
        return load;
    }

    //FUNCIÓN PARA VER DATOS DE LOS ALUMNOS
    private static void showPersonalData(Student[] studentsArray, boolean load) {

        if (load) {
            for (int i = 0; i < studentsArray.length; i++) {

                //mostramos los datos personales de cada estudiante
                System.out.println("\n   " + (i + 1) + "º estudiante:\n"
                        + "   ---------------");

                System.out.println(studentsArray[i].toStringPeople());

            }

            System.out.println("\n------------------------------------------\n");

            intro();

        } else {
            System.out.println("\nNecesita tener los datos de los alumnos\n"
                    + "cargados antes de poder verlos.");

            intro();
        }

    }

    //FUNCIÓN PARA CARGAR NOTAS
    public static boolean loadNotes(Student[] studentsArray, Boolean load, Boolean loadNote) {

        boolean reload = false;     //controla si queremos volver a meter los datos

        if (loadNote) {     //si los datos ya están cargados se advierte y se pregunta si se quiere volver a meterlos
            System.out.print("\nLas notas ya están cargadas.\n¿Quiere volver a cargarlas? (Si / No): ");
            String answer = s.next();

            while (!answer.toLowerCase().equals("si") && !answer.toLowerCase().equals("no")) {
                System.out.print("    - La opción debe ser Si / No: ");
                answer = s.next();
            }

            if (answer.toLowerCase().equals("si")) {

                reload = true;

            }

        }

        //en caso de que los datos estén cargados Y las notas no esten cargadas o queramos volver a cargarla, entramos.
        if (load && (!loadNote || reload)) {

            for (int i = 0; i < studentsArray.length; i++) {

                //pedimos los datos de cada alumno
                System.out.println("\n     Estudiante: " + studentsArray[i].getName() + " " + studentsArray[i].getSurname() + "\n"
                        + "   ------------------------------------------");

                Module[] aux = studentsArray[i].getModules();
                //para cada módulo pedimos las 3 notas
                for (int j = 0; j < aux.length; j++) {

                    System.out.println("\n\tMódulo " + studentsArray[i].getModules()[j].getName() + " Curso " + studentsArray[i].getModules()[j].getCourse() + ": ");
                    System.out.print("\t  · Nota 1: ");
                    studentsArray[i].getModules()[j].setNote1(s.nextDouble());
                    System.out.print("\t  · Nota 2: ");
                    studentsArray[i].getModules()[j].setNote2(s.nextDouble());
                    System.out.print("\t  · Nota 3: ");
                    studentsArray[i].getModules()[j].setNote3(s.nextDouble());

                }

                System.out.println("   ------------------------------------------");
            }
            loadNote = true;

        } else if (!load) {
            System.out.println("\nNecesita tener los datos de los alumnos\n"
                    + "cargados antes de poder verlos.");

        }

        intro();
        return loadNote;

    }

    //FUNCIÓN PARA VER DATOS DE LOS ALUMNOS Y NOTAS
    private static void showCompleteData(Student[] studentsArray, boolean load, Boolean loadNote) {

        //si los datos y las notas están cargados mostramos la información
        if (load && loadNote) {
            for (int i = 0; i < studentsArray.length; i++) {

                //mostramos los datos personales de cada estudiante
                System.out.println("\n   " + (i + 1) + "º estudiante:\n"
                        + "   ---------------");

                Module[] aux = studentsArray[i].getModules();
                //calculamos la media y comprobamos si está o no aprobado en el propio tostring
                for (int j = 0; j < aux.length; j++) {
                    studentsArray[i].getModules()[j].finalNote();

                }

                System.out.println(studentsArray[i].toString());
                System.out.println(" --------------------------------------------------------------");
            }

            intro();

        } else {
            System.out.println("\nNecesita tener los datos de los alumnos y sus\n"
                    + "notas cargados antes de poder verlos.");

            intro();
        }

    }

    //FUNCIÓN PARA PULSAR INTRO Y CONTINUAR
    public static void intro() {

        Scanner s = new Scanner(System.in);

        System.out.println("\nPulse intro para volver al menú principal.");
        String intro = s.nextLine();
        System.out.println("\n\n");

    }

    
    ///   --->>>   ¡¡¡   MAIN   !!!   <<<---   ///
    public static void main(String[] args) {

        boolean load = false;
        boolean loadNote = false;
        boolean repeat = true;

        ////LLAMAR FUNCIONES / ACCIONES
        //entramos en el bucle de ejecución del programa
        while (repeat) {
            //lanzamos el menú
            int opt = StudentManagement.menu();

            //acciones según la opción seleccionada
            switch (opt) {
                case 1:
                    //CARGAR ESTUDIANTES
                    load = loadStudents(load);
                    break;
                case 2:
                    //LISTAR ESTUDIANTES
                    showPersonalData(studentsArray, load);
                    break;
                case 3:
                    //CARGAR NOTAS
                    loadNote = loadNotes(studentsArray, load, loadNote);
                    break;
                case 4:
                    //LISTAR NOTAS
                    showCompleteData(studentsArray, load, loadNote);
                    break;
                case 5:
                    //SALIMOS DEL PROGRAMA
                    repeat = false;
                    System.out.println("\n   ¡GRACIAS POR USAR EL PROGRAMA!\n"
                            + "      Creado por Yohanna Gelo\n");
                    break;

            }   //fin switch

        }   //fin while

    }

}
