package solvd.agency.src;

public class Agency implements IBuySearch, IRentSearch{
    private String name;
    private String address;
    private long phoneNumber;
    private Apartment apartments[] = new  Apartment[9];
    private Person customers[];
    private Person agents[];
    private int apartmentsCounter;

    public Agency(String name, String address, long phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void addApartment(Apartment... apartments){
        for (int i = 0; i < apartments.length; i++) {
            this.apartments[i] = apartments[i];
        }
    }

    public void addCustomer(Person... customers){
        for (int i = 0; i < customers.length; i++) {
            this.customers[i] = customers[i];
        }
    }

    public void addAgent(Person... agents){
        for (int i = 0; i < agents.length; i++) {
            this.agents[i] = agents[i];
        }
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
        Owner owner1 = new Owner("John", "Doe", 1234567);
        Owner owner2 = new Owner("Meryl", "Streep", 2345678);
        Owner owner3 = new Owner("Jason", "Momoa", 3456789);
        Customer customerPaul = new Customer("Paul", "Newman", "Chicago", "pablo@mail.com", 123456);
        Customer customerMartin = new Customer("Martin", "Scorsese", "Missouri", "pablo@mail.com", 123456);
        Customer customerJonas = new Customer("Jonas", "Johnson", "Los Angeles", "pablo@mail.com", 123456);
        Apartment apartmentMinimalistic = new Apartment(owner1, "Los Angeles", 5000, 5, true, RentOrBuy.ForBuy);
        Apartment apartmentEcologic = new Apartment(owner1, "New York", 4000, 3, true, RentOrBuy.ForRent);
        Apartment apartmentFuturistic = new Apartment(owner1, "Chicago", 3500, 3, true, RentOrBuy.ForRent);
        Apartment apartmentRustic = new Apartment(owner2, "Los Angeles", 1500, 1, true, RentOrBuy.ForBuy);
        Apartment apartmentSimple = new Apartment(owner2, "Chicago", 2000, 3, true, RentOrBuy.ForRent);
        Apartment apartmentFuturistic2 = new Apartment(owner2, "Santa Cruz", 6000, 4, true, RentOrBuy.ForRent);
        Apartment apartmentSimple2 = new Apartment(owner3, "New Jersey", 3500, 2, true, RentOrBuy.ForBuy);
        Apartment apartmentLuxury = new Apartment(owner3, "Washington", 5500, 4, true, RentOrBuy.ForRent);
        Apartment apartmentSpecial = new Apartment(owner3, "Chicago", 7000, 3, true, RentOrBuy.ForBuy);

        Agency agency1 = new Agency("Real Estate Agency", "Evergreen 123", 12345678);
        agency1.addApartment(apartmentMinimalistic, apartmentEcologic, apartmentFuturistic,
                apartmentRustic, apartmentSimple, apartmentFuturistic2, apartmentSimple2,
                apartmentLuxury, apartmentSpecial);


        agency1.rentSearch(3, "Chicago", 8000, agency1.getApartments());
        agency1.buySearch(3, "Chicago", 8000, agency1.getApartments());

        Agent agent1 = new Agent("Santiago", "Del Moro", 123456, agency1, 20,10);

        if (owner1 == owner2){
            System.out.println("Same memory space reference");
        } else {
            System.out.println("Not same memory space reference");
        }
        if (owner1.equals(owner2)){
            System.out.println("Objects with same content");
        } else {
            System.out.println("Objects with different content");
        }
        if (owner1.hashCode() == owner2.hashCode()){
            System.out.println("Objects with same hash code");
        } else {
            System.out.println("Objects with different hash code");
        }
    }
}
