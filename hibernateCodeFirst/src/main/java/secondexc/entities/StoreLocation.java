package secondexc.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "store_locations")
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String locationName;
    @OneToMany(mappedBy = "storeLocation")
    private Set<Sale> sales;

    public StoreLocation(){}

    public StoreLocation(String locationName, Set<Sale> sales) {
        this.locationName = locationName;
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
