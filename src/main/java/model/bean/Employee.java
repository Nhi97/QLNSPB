package model.bean;

public class Employee {
    private String id;
    private String fullName;
    private String idPb;
    private String address;

    public Employee() {
    }

    public Employee(String id, String fullName, String idPb, String address) {
        this.id = id;
        this.fullName = fullName;
        this.idPb = idPb;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdPb() {
        return idPb;
    }

    public void setIdPb(String idPb) {
        this.idPb = idPb;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", idPb='" + idPb + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
