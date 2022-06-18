/* Name.java
 Domain for Name
 Author: Zaeem Petersen (219010145)
 Date: 12 June 2022
*/
package za.ac.cput.domain;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;



@Embeddable
public class Name implements Serializable {
    @NotNull
    public String firstName;

    public String middleName;
    @NotNull
    public String lastName;

    public Name(){

    }

    private Name(Builder builder) {
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.middleName=builder.middleName;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getMiddleName(){
        return middleName;
    }
    public String getLastName(){
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Name name=(Name) o;
        return firstName.equals(name.firstName) && middleName.equals(name.middleName)
                && lastName.equals(name.lastName);
    }
    @Override
    public int hashCode(){return Objects.hash(firstName, middleName, lastName);}

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;

        public Builder firstName(String firstName) {
            this.firstName=firstName;
            return this;
        }
        public Builder middleName(String middleName) {
            this.middleName=middleName;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName=lastName;
            return this;
        }

        public Builder copy(Name name) {
            this.firstName=name.firstName;
            this.middleName=name.middleName;
            this.lastName=name.lastName;
            return this;
        }
        public Name build(){
            return new Name(this);
        }
    }
}
