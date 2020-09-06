import java.util.*;

public class Hospital {
    
    private String name;
    private float oxygen_criteria, temp_criteria;
    private boolean status; // true if open false if closed
    private int available_beds;
    private List<Patient> patients;

    Hospital(String name, float temp_criteria, float oxygen_criteria, int available_beds) {
        
        this.name = name;
        this.temp_criteria = temp_criteria;
        this.oxygen_criteria = oxygen_criteria;
        this.available_beds = available_beds;

        patients = new ArrayList<Patient>();

        if (available_beds > 0) status = true;
        else status = false;
    }

    float get_oxygen_criteria() {
        return this.oxygen_criteria;
    }

    float get_temp_criteria() {
        return this.temp_criteria;
    }

    String get_name() {
        return name;
    }

    boolean get_status() {
        return status;
    }

    int get_available_beds() {
        return available_beds;
    }

    void occupy_bed() {
        this.available_beds--;
        if (available_beds == 0) status = false;
    }

    void add_patient(Patient p) {
        this.patients.add(p);
        p.hospitalize(this);
        occupy_bed();
    }

    List<Patient> get_patients() {
        return patients;
    }

    void display_patient_info() {
        for (Patient p : patients) {
            System.out.println(p.name + ", recovery time is " + p.get_recovery_days() + " days");
        }
    }

}