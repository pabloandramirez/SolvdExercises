package solvd.agency.src;

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

    public static void main(String[] args) {
        Owner owner1 = new Owner("Pablo", "Ramirez", 1234567);
        Owner owner2 = new Owner("Juan", "Gonzalez", 2345678);
        Owner owner3 = new Owner("Pedro", "Gomez", 3456789);
        Apartment apartmentMinimalistic = new Apartment(owner1, "Resistencia", 5000, 5, true, RentOrBuy.ForBuy);
        Apartment apartmentEcologic = new Apartment(owner1, "Mendoza", 4000, 3, true, RentOrBuy.ForRent);
        Apartment apartmentFuturistic = new Apartment(owner1, "Chicago", 3500, 3, true, RentOrBuy.ForRent);
        Apartment apartmentRustic = new Apartment(owner2, "Los Angeles", 1500, 1, true, RentOrBuy.ForBuy);
        Apartment apartmentSimple = new Apartment(owner2, "Chicago", 2000, 3, true, RentOrBuy.ForRent);
        Apartment apartmentFuturistic2 = new Apartment(owner2, "Santa Cruz", 6000, 4, true, RentOrBuy.ForRent);
        Apartment apartmentSimple2 = new Apartment(owner3, "Roma", 3500, 2, true, RentOrBuy.ForBuy);
        Apartment apartmentLuxury = new Apartment(owner3, "Lima", 5500, 4, true, RentOrBuy.ForRent);
        Apartment apartmentSpecial = new Apartment(owner3, "Chicago", 7000, 3, true, RentOrBuy.ForBuy);

        Agency agency1 = new Agency("Real Estate Agency", "Evergreen 123", 12345678);
        agency1.addApartment(apartmentMinimalistic);
        agency1.addApartment(apartmentEcologic);
        agency1.addApartment(apartmentFuturistic);
        agency1.addApartment(apartmentRustic);
        agency1.addApartment(apartmentSimple);
        agency1.addApartment(apartmentFuturistic2);
        agency1.addApartment(apartmentSimple2);
        agency1.addApartment(apartmentLuxury);
        agency1.addApartment(apartmentSpecial);
        agency1.showApartments();

        Customer customerPablo = new Customer("Pablo", "Ramirez", "Resistencia", "pablo@mail.com", 123456);
        customerPablo.buySearch(3, "Chicago", 8000, agency1);
        customerPablo.rentSearch(3, "Chicago", 8000, agency1);

        Agent agent1 = new Agent("Santiago", "Del Moro", 123456, agency1, 20,10);

        RentContract contract1 = new RentContract(customerPablo, 3, agent1);
        System.out.println("Commission for rents contracts: " + agent1.getRentCommission());
        System.out.println("Commission por sales contracts: " + agent1.getSaleCommission());
    }
}
