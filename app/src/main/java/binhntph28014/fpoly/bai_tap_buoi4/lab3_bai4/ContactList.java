package binhntph28014.fpoly.bai_tap_buoi4.lab3_bai4;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
public class ContactList {
    @SerializedName("contacts")
    @Expose
    private ArrayList<Contacts> contacts = new ArrayList<>();

    public ArrayList<Contacts> getContacts() {
        return contacts;
    }
    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
    }
}