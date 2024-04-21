
package gestionAlumnos;

/**
 *
 * @author Yohanna Gelo
 */
public class Student extends People {
    
    //ATRIBUTOS
    private Module[] modules;
    private String center;
    
    
    //CONSTRUCTORES
    public Student(Module[] modules, String center, String name, String surname, String dni, String direction, String province, String population, int cp) {
        super(name, surname, dni, direction, province, population, cp);
        this.modules = modules;
        this.center = center;
    }

    public Student(Module[] modules, String center) {
        this.modules = modules;
        this.center = center;
    }

    public Student() {
    }
    
    
    //ToSTRING Y GETTERS / SETTERS
    @Override
    public String toString(){
       String datos;
       datos = super.toString()
               + "\n\n Centro: " + this.center
               + "\n\n Módulos matriculados:";
      
       for (int i=0;i<modules.length;i++){
           
           datos = datos +  modules[i].toString();   
       } 
       return datos;
    }

    public Module[] getModules() {
        return modules;
    }

    public void setModules(Module[] modules) {
        this.modules = modules;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }
    
    
    
    
    //FUNCIÓN PARA VER SOLO LOS DATOS PERSONALES DE LOS ALUMNOS
    public String toStringPeople() {

        return super.toString();
        
    }
    
    
    
}
