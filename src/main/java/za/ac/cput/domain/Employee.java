/* Employee.java
 Domain for Employee
 Author: Zaeem Petersen (219010145)
 Date: 11 June 2022
*/
package za.ac.cput.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Employee implements Serializable {
    @NotNull
    @Id
    private String staffId;
    @NotNull
    private String email;
    @Embedded
    private Name name;

    protected Employee(){}

    private Employee(Builder builder) {
        this.staffId = builder.staffId;
        this.email = builder.email;
        this.name = builder.name;
    }

    //getters
    public Name getName() {
        return name;
    }

    public String getStaffId() {
        return staffId;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Employee employee=(Employee) o;
        return staffId.equals(employee.staffId) && email.equals(employee.email)
                //add name
                && name.equals(employee.name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(staffId, email, name);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' + '}';
    }

    //builder class
    public static class Builder {
        private String staffId;
        private String email;
        private Name name;

        public Builder staffId(String staffId) {
            this.staffId=staffId;
            return this;
        }

        public Builder email(String email) {
            this.email=email;
            return this;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder copy(Employee employee)
        {
            this.staffId = employee.staffId;
            this.email = employee.email;
            this.name = employee.name;
            return this;
        }
        public Employee build(){ return new Employee(this);}
    }
}
