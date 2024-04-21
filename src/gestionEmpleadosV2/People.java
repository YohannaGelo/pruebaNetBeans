/*
- Vamos a crear la clase Persona que es una clase genérica para cualquier persona con los atributos: nombre. Apellidos, DNI, dirección, código postal, población y provincia.

Esta clase persona tiene los métodos constructor (todos los atributos) y constructor (), setters y getters, y método toString ().
 */
package gestionEmpleadosV2;

/**
 *
 * @author Yohanna Gelo
 */
public class People {

    //ATRIBUTOS
    protected String name, surname, dni, direction, province, population;
    protected int cp;

    //CONSTRUCTORES
    public People(String name, String surname, String dni, String direction, String province, String population, int cp) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.direction = direction;
        this.province = province;
        this.population = population;
        this.cp = cp;
    }

    public People() {
    }

    //CREAR ToSTRING Y GETTERS / SETTERS (si es necesario)
    @Override
    public String toString() {
        return "Nombre empleado\t: " + name + "\nApellidos\t: " + surname + "\nDNI\t\t: " + dni + "\nDirección\t: " + direction
                + "\nProvincia\t: " + province + "\nCódigo Postal\t: " + cp + " (" + population + ")";
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
    
    

}
