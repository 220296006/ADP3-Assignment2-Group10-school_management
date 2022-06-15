package za.ac.cput.domain;

import java.util.Locale;
import java.util.Objects;

public class EmployeeAddress {
    private String staffId;
    private String Address;

    public String getStaffId() {
        return staffId;
    }

    public String getAddress() {
        return Address;
    }

    private EmployeeAddress(Builder builder) {
        this.staffId = builder.staffId;
        this.Address = builder.Address;
    }

    public static class Builder {
        private String staffId;
        private String Address;

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setAddress(String address) {
            this.Address = address;
            return this;
        }

        public EmployeeAddress build(){
            return new EmployeeAddress(this);
        }

        public Builder copy(EmployeeAddress employeeAddress){
            this.staffId = employeeAddress.staffId;
            this.Address = employeeAddress.Address;
            return this;
        }

    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }

}
