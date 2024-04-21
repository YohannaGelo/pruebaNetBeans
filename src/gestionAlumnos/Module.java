
package gestionAlumnos;

/**
 *
 * @author Yohanna Gelo
 */
public class Module {

    //ATRIBUTOS
    private String name, course;
    private int weeksHours;
    private double note1, note2, note3;

    //CONSTRUCTORES
    public Module(String name, String course, int weeksHours, double note1, double note2, double note3) {
        this.name = name;
        this.course = course;
        this.weeksHours = weeksHours;
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
    }

    public Module(String name, String course, int weeksHours) {
        this.name = name;
        this.course = course;
        this.weeksHours = weeksHours;
    }

    public Module() {
    }

    //ToSTRING Y GETTERS / SETTERS
    @Override
    public String toString() {

        String datos = "\n\n  · Módulo " + this.name + "\t  · Curso " + this.course
                + "\n Nota 1: " + this.note1 + "\t Nota 2: " + this.note2 + "\t Nota 3: " + this.note3
                + "\t Nota Final: " + this.finalNote();
        
        //añadimos también el resultado, llamando a la función según las notas finales, si está aprobado o suspenso se indica
        if (this.approved()) {
            datos = datos + "\n\t\t\t\t\t  ~ Módulo APROBADO ~";

        } else {
            datos = datos + "\n\t\t\t\t\t  ~ Módulo SUSPENSO ~";
        }

    return datos ;

}

public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getWeeksHours() {
        return weeksHours;
    }

    public void setWeeksHours(int weeksHours) {
        this.weeksHours = weeksHours;
    }

    public double getNote1() {
        return note1;
    }

    public void setNote1(double note1) {
        this.note1 = note1;
    }

    public double getNote2() {
        return note2;
    }

    public void setNote2(double note2) {
        this.note2 = note2;
    }

    public double getNote3() {
        return note3;
    }

    public void setNote3(double note3) {
        this.note3 = note3;
    }

    //FUNCIONES / MÉTODOS / ACCIONES
    public double finalNote() {
        if (this.note1 >= 5 && this.note2 >= 5 && this.note3 >= 5) {
            return (this.note1 + this.note2 + this.note3) / 3;
        } else {
            return 4.0;
        }

    }

    public boolean approved() {

        if (this.finalNote() >= 5) {
            return true;
        } else {
            return false;
        }
    }

}
