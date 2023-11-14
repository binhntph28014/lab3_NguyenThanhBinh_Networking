package binhntph28014.fpoly.bai_tap_buoi4.lab3_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import binhntph28014.fpoly.bai_tap_buoi4.R;

public class bai1 extends AppCompatActivity {
    ListView lvContact;
    GetContact getContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContact = (ListView) findViewById(R.id.rcv_album);

        getContact = new GetContact(this,lvContact);
        getContact.execute();


    }


}