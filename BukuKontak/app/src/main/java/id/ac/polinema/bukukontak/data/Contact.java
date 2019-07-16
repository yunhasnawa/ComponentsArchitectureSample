package id.ac.polinema.bukukontak.data;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact")
public class Contact
{
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "phone_number")
    private String phoneNumber;

    public Contact()
    {

    }

    public Contact(String name, String phoneNumber)
    {
        this.id = null;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
