/*
- La clase Empleado será una clase que hereda de la clase Persona (extends) y que añade los 
atributos y los métodos propios del Empleado.
- Vamos a crear en el Empleado el método nomina(), que genera la nómina del empleado 
mostrándola por pantalla. Este método nomina() 
usa toString para mostrar los datos personales y añade el cálculo de la nómina según los 
atributos del empleado. De esta forma se simplifica la función muestraNomina() de la clase
principal.
*/
package gestionEmpleadosV2;

/**
 *
 * @author Yohanna Gelo
 */
public class EmployeeV2 extends People {
    
    //ATRIBUTOS
    private int age, numberChildren, englishLevel, experienceCompany;
    private char profesionalCategory;
    
    
    //CONSTRUCTORES
    public EmployeeV2(int age, int numberChildren, int englishLevel, int experienceCompany, char profesionalCategory, String name, String surname, String dni, String direction, String province, String population, int cp) {
        super(name, surname, dni, direction, province, population, cp);
        this.age = age;
        this.numberChildren = numberChildren;
        this.englishLevel = englishLevel;
        this.experienceCompany = experienceCompany;
        this.profesionalCategory = profesionalCategory;
    }

    public EmployeeV2(String name, String surname, String dni, String direction, String province, String population, int cp) {
        super(name, surname, dni, direction, province, population, cp);
    }

    public EmployeeV2() {
    }

    
    //CREAR ToSTRING Y GETTERS / SETTERS (si es necesario)
    @Override
    public String toString() {
        return super.toString() + "\nEdad empleado\t: " + age + " años\nNº de hijos\t: " + numberChildren + "\nNivel de inglés\t: " + englishLevel + " (" + this.englishLevelReg()+ ")" + "\nAntiguedad\t: " + experienceCompany + " años\nCategoría\t: " + profesionalCategory + " (" + this.profesionalCategory() + ")";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberChildren() {
        return numberChildren;
    }

    public void setNumberChildren(int numberChildren) {
        this.numberChildren = numberChildren;
    }

    public int getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(int englishLevel) {
        this.englishLevel = englishLevel;
    }

    public int getExperienceCompany() {
        return experienceCompany;
    }

    public void setExperienceCompany(int experienceCompany) {
        this.experienceCompany = experienceCompany;
    }

    public char getProfesionalCategory() {
        return profesionalCategory;
    }

    public void setProfesionalCategory(char profesionalCategory) {
        this.profesionalCategory = profesionalCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
    
    
    //CREAR FUNCIONES/MÉTODOS
    /////Categoría
    public String profesionalCategory() {

        String cat = "";

        switch (this.profesionalCategory) {
            case 'A':
                cat = "Director";
                break;
            case 'B':
                cat = "Técnico superior";
                break;
            case 'C':
                cat = "Técnico medio";
                break;
            case 'D':
                cat = "Auxiliar";
                break;
        }

        return cat;

    }
    
    
    /////Sueldo base
    public double baseSalary() {
        
        double plus = 1;
        double base = 0;
        
        if (this.experienceCompany >= 5) {
            plus = 1.1; //esto dará el resultado de un 110%
            
        }
        
        switch (this.profesionalCategory) {
            case 'A':
                base = 2500;
                break;
            case 'B':
                base = 2000;
                break;
            case 'C':
                base = 1500;
                break;
            case 'D':
                base = 1000;
                break;
        }
        
        return base*plus;    
        
    }
       
    
    /////Retención IRPF
    public double irpfRetention() {
        
        double irpf = 0;
        
        if (numberChildren >= 2) {
            irpf = 14; 
            
        } else if (numberChildren == 1) {
            irpf = 16;
            
        } else {
            irpf = 18;
            
        }
        
        return irpf;
        
    }
    
    
    /////Nivel inglés registrado
    public String englishLevelReg() {

        String level = "";

        switch (this.englishLevel) {
            case 1:
                level = "Inicial";
                break;
            case 2:
                level = "Medio";
                break;
            case 3:
                level = "Avanzado";
                break;
            default: 
                level = "No registrado";
        }

        return level;

    }
    
    
    /////Nómina
    public void Payroll () {
        
                double irpfRet = (this.irpfRetention()/100) *  this.baseSalary();
                double finalSalary = this.baseSalary() - irpfRet;

                System.out.println(this.toString());

                //imprimo los decimales con printf para poder establecer solo 2 decimales.
                System.out.printf("\nSueldo base\t: %.2f Euros\nRetención\t: %.2f%%\n\nSUELDO TOTAL\t: %.2f Euros\n", this.baseSalary(), this.irpfRetention(), finalSalary);

    }
    
}

