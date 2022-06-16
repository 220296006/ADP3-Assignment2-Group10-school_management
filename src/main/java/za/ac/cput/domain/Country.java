package za.ac.cput.domain;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;
/* Country.java
 * Entity for the Country Domain
 * @Author: Thabiso Matsaba (220296006)
 * Date: 10 June 2022
 */
@Entity
public class Country  {

    @NotNull
    @javax.persistence.Id
    private String id;

    @NotNull
    private String name;

    protected Country(){
    }

    private Country(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder{
        private String id;
        private String name;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Country country){
            this.id = country.id;
            this.name = country.name;
            return this;

        }

        public Country build(){

            return new Country(this);
        }
    }

    public static class Id {
        private String id;

        public Id(String id) {
            this.id = id;
        }

        protected Id(){
        }

        public String getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() !=o.getClass()) return false;
            Id id = (Id) o;
            return id.equals(id.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Id{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }
    }

