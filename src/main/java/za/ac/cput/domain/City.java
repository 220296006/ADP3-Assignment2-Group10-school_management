package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "city")
public class City implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String countryId;

    private City(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.countryId = builder.countryId;
    }

    public City() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountyId() {
        return countryId;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name=" + name + ", country=" + countryId + '}';
    }

    public static class Builder {
        private String id, name;
        private String countryId;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCountry(String countryId) {
            this.countryId = countryId;
            return this;
        }

        public Builder copy(City city) {
            this.id = city.id;
            this.name = city.name;
            this.countryId = city.countryId;
            return this;
        }

        public City build() {
            return new City(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        if (this == o) return true;
        City x = (City) o;
        return this.id.equals(x.id) && this.name.equals(x.name) && this.countryId.equals(x.countryId);
    }

}