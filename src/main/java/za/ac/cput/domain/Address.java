/**Address.java
 * Domain for Address
 *Author: Daniella Burgess(219446482)
 * Date: 09 June 2022
 */
package za.ac.cput.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Address implements Serializable {
    @NotNull
    private String unitNumber;
    @NotNull
    private String complexName;
    @NotNull
    private String streetNumber;
    @NotNull
    private String streetName;
    @NotNull
    private String postalCode;

    @ManyToOne(targetEntity = City.class, cascade = CascadeType.ALL)
    private City city;
    public City getCity(){
        return city;
    }


    public Address(){}

    public Address(Builder builder)
    {
        this.unitNumber=builder.unitNumber;
        this.complexName=builder.complexName;
        this.streetName=builder.streetName;
        this.streetNumber= builder.streetNumber;
        this.postalCode=builder.postalCode;
    }
    public String getUnitNumber(){
        return unitNumber;
    }
    public String getComplexName(){
        return complexName;
    }
    public String getStreetNumber(){
        return streetNumber;
    }
    public String getStreetName(){
        return streetName;
    }
    public String getPostalCode(){return postalCode;
    }

    private void setUnitNumber(String unitNumber)
    {
        this.unitNumber = unitNumber;
    }

    private void setComplexName(String complexName)
    {
        this.complexName = complexName;
    }

    private void setStreetNumber(String streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    private void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    private void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null|| getClass()!=o.getClass()) return false;
        Address address=(Address) o;
        return unitNumber.equals(address.unitNumber);
    }
    @Override
    public int hashCode(){return Objects.hash(unitNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    public static class Builder
    {
        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private String postalCode;
        private City city;

        public Builder setUnitNumber(String unitNumber)
        {
            this.unitNumber=unitNumber;
            return this;
        }
        public Builder setComplexName(String complexName)
        {
            this.complexName=complexName;
            return this;
        }
        public Builder setStreetNumber(String streetNumber)
        {
            this.streetNumber=streetNumber;
            return this;
        }
        public Builder setStreetName(String streetName)
        {
            this.streetName=streetName;
            return this;
        }
        public Builder setPostalCode(String postalCode)
        {
            this.postalCode=postalCode;
            return this;
        }
        public Builder setCity(City city)
        {
            this.city=city;
            return this;
        }
        public Builder copy(Address address)
        {
            this.unitNumber=address.unitNumber;
            this.complexName=address.complexName;
            this.streetNumber=address.streetNumber;
            this.streetName=address.streetName;
            this.postalCode=address.postalCode;
            return this;
        }
        public Address build(){return new Address(this);}
    }
}
