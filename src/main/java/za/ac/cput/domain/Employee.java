/* Employee.java
 Domain for Employee
 Author: Zaeem Petersen (219010145)
 Date: 11 June 2022
*/
package za.ac.cput.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(Employee.EmployeeId.class)
public class Employee {

    @Id
    @NotNull
    public String staffId;
    @NotNull
    public String email;
    public Name name;

    //builder constructor
    public Employee(Builder builder){
        this.staffId = builder.staffId;
        this.email = builder.email; ;
        this.name = builder.name;
    }

    public String getStaffId(){
        return staffId;
    }

    public void setStaffId(){
        this.staffId = staffId;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(){
        this.email = email;
    }

    public Name getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Employee{" +
                "Staff ID : " + staffId +
                "Email : " + email +
                "Name :" + name +
                "}";
    }

    public static class EmployeeId implements Serializable
    {
        public String staffId;
        public EmployeeId(String staffId){
            this.staffId=staffId;
        }
        protected EmployeeId(){

        }
        public String getStaffId(){
            return staffId;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return staffId.equals(employee.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);
    }

    //builder setters
    public static class Builder{
        public String staffId;
        public String email;
        public Name name;

        public Builder setStaffId(String staffId){
            this.staffId = staffId;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setName(Name name){
            this.name = name;
            return this;
        }

        //builder copy
        public Builder copy(Employee employee){
            this.staffId = employee.staffId;
            this.email = employee.email;
            this.name = employee.name;

            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
