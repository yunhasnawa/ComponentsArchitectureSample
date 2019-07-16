package id.ac.polinema.bukukontak.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.polinema.bukukontak.R;
import id.ac.polinema.bukukontak.data.Contact;

public class RecyclerContactListAdapter extends RecyclerView.Adapter<ContactItemViewHolder>
{
    private Context context;
    private List<Contact> contactList;

    public RecyclerContactListAdapter(Context context)
    {
        this.context = context;
    }

    public List<Contact> getContactList()
    {
        return contactList;
    }

    public void setContactList(List<Contact> contactList)
    {
        this.contactList = contactList;

        // Biar nge-refresh
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Dapatkan inflater
        LayoutInflater inflater = LayoutInflater.from(this.context);

        // Render view pakai inflater
        View contactItemView = inflater.inflate(R.layout.contact_item_view, parent, false);

        // View-nya dilempar ke ViewHolder
        ContactItemViewHolder vhContactItem = new ContactItemViewHolder(contactItemView);

        // Jadikan nilai balik method ini
        return vhContactItem;
    }

    // Ketika sedang me-render satu-persatu baris dari RecyclerView-nya...
    // Terjadi pe-renderan view holder satu persatu juga.
    @Override
    public void onBindViewHolder(@NonNull ContactItemViewHolder holder, int position)
    {
        // Dapatkan data di posisi saat ini...
        Contact currentContact = this.contactList.get(position);

        // Pasang datanya di ViewHolder saat ini
        String name = currentContact.getName();
        String phoneNumber = currentContact.getPhoneNumber();

        holder.getTxvName().setText(name);
        holder.getTxvPhone().setText(phoneNumber);
    }

    @Override
    public int getItemCount()
    {
        if(this.contactList == null)
            return 0;
        else
            return this.contactList.size();
    }
}


