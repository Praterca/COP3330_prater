

public class ContactItem {

private String First;
private String Last;
private String phoneNumber;
private String email;

public ContactItem(String First, String Last, String phoneNumber, String email) {

    this.First = First;
    this.Last = Last;
    this.phoneNumber = phoneNumber;
    this.email = email;

}

    public void editContact(String First, String Last, String phoneNumber, String email){

        this.First = First;
        this.Last = Last;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public String toString(){
        return "Name: " + this.First + " " + this.Last + "\n" + "Phone Number: " + this.phoneNumber + "\n" + "Email: " + this.email + "\n\n";
    }


    public String getFirst() {
        return this.First;
    }

    public String getLastName(){
        return this.Last;
    }

    public String getPhoneNumber(){ return this.phoneNumber; }

    public String getEmail(){return this.email; }


}
