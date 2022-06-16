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

@Entity
@Embeddable
@IdClass(Address.AddressId.class)
public class Address implements Serializable {
    @NotNull
    @Id
    public String unitNumber;
    @NotNull  public String   complexName,streetNumber,streetName;

    @NotNull public String postalCode;
    @Embedded
    public City city;
    public City getCity(){return city;}


    protected Address(){}
    public Address(Builder builder)
    {
        this.unitNumber=builder.unitNumber;
        this.complexName=builder.complexName;
        this.streetName=builder.streetName;
        this.streetNumber= builder.streetNumber;
        this.postalCode=builder.postalCode;
    }
    public String getUnitNumber(){return unitNumber;}
    public String getComplexName(){return complexName;}
    public String getStreetNumber(){return streetNumber;}
    public String getStreetName(){return streetName;}
    public String getPostalCode(){return postalCode;}

    public static class Builder
    {
        public String unitNumber;
        public String complexName;
        public String streetNumber;
        public String streetName;
        public String postalCode;

        public Builder unitNumber(String unitNumber)
        {
            this.unitNumber=unitNumber;
            return this;
        }
        public Builder complexName(String complexName)
        {
            this.complexName=complexName;
            return this;
        }
        public Builder streetNumber(String streetNumber)
        {
            this.streetNumber=streetNumber;
            return this;
        }
        public Builder streetName(String streetName)
        {
            this.streetName=streetName;
            return this;
        }
        public Builder postalCode(String postalCode)
        {
            this.postalCode=postalCode;
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

    public static class AddressId implements Serializable
    {
        public String unitNumber;

        public AddressId(String unitNumber){this.unitNumber=unitNumber;}
        protected AddressId(){}
        public String getUnitNumber(){return unitNumber;}
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
}
