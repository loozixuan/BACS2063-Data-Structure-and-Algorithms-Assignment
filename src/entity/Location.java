package entity;

public class Location {

    String state;
    String city;
    String building;

    public Location() {

    }

    public Location(String state, String city, String building) {
        this.state = state;
        this.city = city;
        this.building = building;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Location{" + "state=" + state + ", city=" + city + ", building=" + building + '}';
    }

}
