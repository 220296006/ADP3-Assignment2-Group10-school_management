/* Employee.java
 Domain for Employee
 Author: Zaeem Petersen (219010145)
 Date: 11 June 2022
*/
package za.ac.cput.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(Employee.EmployeeId.class)
public class Employee implements Serializable {
    @javax.validation.constraints.NotNull
    @Id public String staffId;
    @NotNull
    public String email;
    @Embedded private Name name;
    public Name getName()
    {
        return name;
    }

    protected Employee(){}
    private Employee(Builder builder)
    {
        this.staffId=builder.staffId;
        this.email=builder.email;

    }

    public String getStaffId() {
        return staffId;
    }
    public String getEmail() {
        return email;
    }

    public static class Builder
    {
        public String staffId;
        public String email;

        public Builder staffId(String staffId)
        {
            this.staffId=staffId;
            return this;
        }
        public Builder email(String email)
        {
            this.email=email;
            return this;
        }
        public Builder copy(Employee employee)
        {
            this.staffId=employee.staffId;
            this.email=employee.email;
            return this;
        }
        public Employee build(){ return new Employee(this);}}

    public static class EmployeeId implements Serializable
    {
        public String staffId;
        public EmployeeId(String staffId){this.staffId=staffId;}
        protected EmployeeId(){}
        public String getStaffId(){return staffId;}
    }
    @Override
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Employee employee=(Employee) o;
        return staffId.equals(employee.staffId);
    }
    @Override
    public int hashCode(){return Objects.hash(staffId);}


    @Override
    public String toString()
    {
        return "Employee{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' + '}';
    }
}
