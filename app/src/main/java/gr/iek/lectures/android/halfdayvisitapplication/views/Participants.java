package gr.iek.lectures.android.halfdayvisitapplication.views;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import gr.iek.lectures.android.halfdayvisitapplication.R;
import java.util.ArrayList;

public class Participants extends AppCompatActivity {
    private ListView listViewParticipants;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);

        list = new ArrayList<>();

        listViewParticipants = findViewById(R.id.listViewParticipants);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  getNames());
        listViewParticipants.setAdapter(adapter);
    }


    private ArrayList<String> getNames()
    {
        list.add("Eιδικότητα:\nΣτέλεχος οικονομίας και διοίκησης στον τομέα του τουρισμού");
        list.add("Oνόματα:");
        list.add("Τρυπιδάκη Χριστίνα");
        list.add("Κοκκινάκη Μαρία");
        list.add("Meletova Zemfira");
        list.add("Παρασύρη Αικατερίνη");
        list.add("Καρπαχτσίδης Γκεόργκι");
        list.add("Μάρας Μάριος");
        list.add("Yπεύθυνη καθηγήτρια: κ.Λημνίδη Αικατερίνη");
        list.add("");
        list.add("Eιδικότητα: Πληροφορική");
        list.add("Αποστολος-Μαριος Τραμπας");
        list.add("Σκουλατακης Ζαχαριας");

        return list;
    }

}
