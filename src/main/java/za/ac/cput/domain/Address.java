/**Address.java
 * Domain for Address
 *Author: Daniella Burgess(219446482)
 * Date: 09 June 2022
 */

package za.ac.cput.domain;

import java.util.Objects;

public class Address {
    private final String unitNumber, complexNumber, streetNumber, streetName;
    private final int postalCode;
    private Object city;
    private Address(Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexNumber = builder.complexNumber;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
    }

    public String getUnitNumber() {return unitNumber; }

    public String getComplexNumber() {return complexNumber; }

    public String getStreetNumber() {return streetNumber; }

    public String getStreetName() {return streetName; }

    public int getPostalCode() {return postalCode;}

    public Object getCity() {return city; }

    public static class Builder {
        private String unitNumber, complexNumber, streetNumber, streetName;
        private int postalCode;
        private Object city;

        public Builder unitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder complexNumber(String complexNumber) {
            this.complexNumber = complexNumber;
            return this;
        }

        public Builder streetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder streetName(String streetName) {
            this.streetNumber = streetName;
            return this;
        }

        public Builder postalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder city(Object city ) {
            this.city = city;
            return this;
        }

        public Builder copy(Address address) {
            this.unitNumber = address.unitNumber;
            this.complexNumber = address.complexNumber;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.city = address.city;
            return this;
        }

        public Address build() {return new Address(this); }
    }
    public static class AddressIdentity {
        private String streetNumber, streetName;

        public AddressIdentity(String streetNumber, String streetName) {
            this.streetNumber = streetNumber;
            this.streetName = streetName;
        }

        public String getStreetNumber() {
            return streetNumber;
        }

        public String getStreetName() {
            return streetName;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return streetNumber.equals(address.streetNumber) && streetName.equals(address.streetName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, streetName);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexNumber='" + complexNumber + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode +
                ", city=" + city +
                '}';
    }
}
