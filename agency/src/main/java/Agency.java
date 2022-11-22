public class Agency {
    private String name;
    private String address;
    private long phoneNumber;
    private Apartment apartments[] = new Apartment[9];
    private int apartmentsCounter;

    public Agency(String name, String address, long phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void addApartment(Apartment apartment){
        this.apartments[this.apartmentsCounter++] = apartment;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void showApartments(){
        for (int i = 0; i < apartments.length; i++) {
            System.out.println(apartments[i]);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "agency{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
