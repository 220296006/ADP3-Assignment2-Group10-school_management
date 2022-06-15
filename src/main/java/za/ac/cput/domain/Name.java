/* Name.java
 Domain for Name
 Author: Zaeem Petersen (219010145)
 Date: 12 June 2022
*/
package za.ac.cput.domain;

import java.util.Objects;

public class Name {

    public String firstName;
    public String middleName;
    public String lastName;

    //builder constructor
    public Name (Builder builder){
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(){
        this.firstName = firstName;
    }

    public String middleName(){
        return middleName;
    }

    public void setMiddleName(){
        this.middleName = middleName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(){
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "Name{" +
                "First Name :" + firstName +
                "Middle Name:" + middleName +
                "Last Name: " + lastName;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this==o)
            return true;
        if(o==null || getClass()!=o.getClass())
            return false;
        Name name=(Name) o;
        return firstName.equals(name.firstName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(firstName);
    }


    //builder setters
    public static class Builder{
        public String firstName;
        public String middleName;
        public String lastName;

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        //builder copy
        public Builder copy(Name name){
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.lastName = name.lastName;

            return this;
        }

        public Name build(){
            return new Name(this);
        }
    }
}
