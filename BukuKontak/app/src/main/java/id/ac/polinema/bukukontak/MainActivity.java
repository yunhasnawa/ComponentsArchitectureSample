package id.ac.polinema.bukukontak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.bukukontak.adapter.RecyclerContactListAdapter;
import id.ac.polinema.bukukontak.data.Contact;

public class MainActivity extends AppCompatActivity
{
    // Data
    private RecyclerContactListAdapter recyclerContactListAdapter;
    private ArrayList<Contact> contactList;

    // Components
    private RecyclerView recyclerContactList;
    private EditText edtName;
    private EditText edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initData();
        this.initComponents();
    }

    private void initData()
    {
        this.contactList = new ArrayList<>();

        // Tambahin dummy data..
        this.contactList.add(new Contact("Yoppy Y.", "085-123-456"));
        this.contactList.add(new Contact("Alan Walker", "0857-123-456"));
        this.contactList.add(new Contact("Hey Twayo", "0859-123-456"));
        this.contactList.add(new Contact("Dark Magician", "0859-129-456"));
        this.contactList.add(new Contact("Arctic Warfare Magnum", "0859-999-999"));

        // Seting recycler view-nya
        this.recyclerContactListAdapter = new RecyclerContactListAdapter(this);
    }

    private void initComponents()
    {
        this.recyclerContactList = this.findViewById(R.id.recycler_contact_list);
        this.recyclerContactList.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerContactList.setAdapter(this.recyclerContactListAdapter);

        this.edtName = this.findViewById(R.id.edt_name);
        this.edtPhone = this.findViewById(R.id.edt_phone);

        // Load data ke recycler View
        this.recyclerContactListAdapter.setContactList(this.contactList);
    }

    public void onBtnSave_Click(View view)
    {
        Contact newContact = this.makeContact();

        this.contactList.add(newContact);

        this.recyclerContactListAdapter.setContactList(this.contactList);
    }

    private Contact makeContact()
    {
        String name = this.edtName.getText().toString();
        String phoneNumber = this.edtPhone.getText().toString();

        Contact c = new Contact(name, phoneNumber);

        return c;
    }
}
