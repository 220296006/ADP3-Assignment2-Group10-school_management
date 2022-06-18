package za.ac.cput.domain;

/*Waseem Dollie - 216040566*/

import za.ac.cput.domain.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class StudentAddress implements Serializable{

    @NotNull
    @Id
    private String studentId;


    private Address address;
    public Address getAddress() {
        return address;
    }

    protected StudentAddress(){

    }
    public StudentAddress(Builder builder) {
        this.studentId=builder.studentId;
        this.address = builder.address;
    }

    public String getStudentId(){
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        StudentAddress studentAddress=(StudentAddress) o;
        return studentId.equals(studentAddress.studentId) && address.equals(studentAddress.address);
    }

    @Override
    public int hashCode(){
        return Objects.hash(studentId, address);
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' + '}';
    }

    public static class Builder {
        private String studentId;
        private Address address;

        public Builder setStudentId(String studentId) {
            this.studentId=studentId;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(StudentAddress studentAddress) {
            this.studentId=studentAddress.studentId;
            return this;
        }
        public StudentAddress build(){
            return new StudentAddress(this);
        }
    }
}
