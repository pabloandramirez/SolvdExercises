public class Owner extends Person{
    private int idOwner;
    private static int idCounter;
    private Apartment apartments[];
    private int apartmentCounter;

    public Owner(String firstName, String lastName, long phoneNumber){
        super(firstName, lastName, phoneNumber);
        this.idOwner = ++Owner.idCounter;
    }

    public void addApartment(Apartment apartment){
        this.apartments[this.apartmentCounter++] = apartment;
    }

    public int getIdOwner() {
        return idOwner;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "idOwner=" + idOwner +
                ", person=" + super.toString() +
                '}';
    }
}
