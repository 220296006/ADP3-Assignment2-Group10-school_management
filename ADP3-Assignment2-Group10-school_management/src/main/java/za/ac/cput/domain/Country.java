package za.ac.cput.domain;
/* Country.java
 * Entity for the Country Domain
 * @Author: Thabiso Matsaba (220296006)
 * Date: 10 June 2022
 */

public class Country{

    private String id;
    private String name;

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
}
