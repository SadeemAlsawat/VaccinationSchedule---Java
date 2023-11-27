package vaccinationschedule;
import java.io.Serializable;

public class ReservationModel implements Serializable {

    String name;
    String id;
    String age;
    String vacc;
    String day;
    String mon;
    String year;
    String gender;

    public ReservationModel(String name, String id, String age, String vacc, String day, String mon, String year, String gender) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender=gender;
        this.vacc = vacc;
        this.day = day;
        this.mon = mon;
        this.year = year;
        
        
    }

    @Override
    public String toString() {
        return "Name: "+name+"\n Id: "+id+"\nAge: "+age +
                "\n Gender: "+gender+ "\nVaccine: "+vacc+""
                + "\nDate: "+day+"-"+mon+"-"+year + "\n";
        //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
