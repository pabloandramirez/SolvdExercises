package solvd.agency.src.persons;

public class Owner extends Person {
    private int idOwner;
    private static int idCounter;
    private int apartmentCounter;

    public Owner(String firstName, String lastName, long phoneNumber){
        super(firstName, lastName, phoneNumber);
        this.idOwner = ++Owner.idCounter;
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
