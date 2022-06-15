package za.ac.cput.domain;

/*Waseem Dollie - 216040566*/

import org.apache.tomcat.jni.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


@Entity
@IdClass(StudentAddress.StudentAddressId.class)
public class StudentAddress implements Serializable{

    @NotNull
    @Id
    public String studentId;


    @Embedded
    public Address address;
    public Address getAddress()
    {
        return address;
    }



    protected StudentAddress(){}
    public StudentAddress(Builder builder)
    {
        this.studentId=builder.studentId;
    }
    public String getStudentId(){return studentId;}


    public static class Builder
    {
        public String studentId;

        public Builder studentId(String studentId)
        {
            this.studentId=studentId;
            return this;
        }
        public Builder copy(StudentAddress studentAddress)
        {
            this.studentId=studentAddress.studentId;
            return this;
        }
        public StudentAddress build(){return new StudentAddress(this);}
    }
    public static class StudentAddressId implements Serializable
    {
        public String studentId;
        public StudentAddressId(String studentId){this.studentId=studentId;}
        protected StudentAddressId(){}
        public String getStudentId(){return studentId;}
    }
    @Override
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        StudentAddress studentAddress=(StudentAddress) o;
        return studentId.equals(studentAddress.studentId);
    }
    @Override
    public int hashCode(){return Objects.hash(studentId);}

    @Override
    public String toString()
    {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' + '}';
    }
}
