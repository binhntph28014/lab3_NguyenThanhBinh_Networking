package binhntph28014.fpoly.bai_tap_buoi4.lab3_bai4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import binhntph28014.fpoly.bai_tap_buoi4.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class bai4 extends AppCompatActivity {
    private ListView listView;
    private View parentView;
    private ArrayList<Contacts> contactsList;
    private MyContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        contactsList = new ArrayList<>();
        parentView = findViewById(R.id.parentLayout);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(parentView, contactsList.get(position).getName() + " => " + contactsList.get(position).getPhone().getHome(), Snackbar.LENGTH_LONG).show();
            }
        });
        Toast toast = Toast.makeText(getApplicationContext(), R.string.string_click_to_load, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (InternetConnection.checkConnection(getApplicationContext())) {
                    final ProgressDialog dialog;
                    dialog = new ProgressDialog(bai4.this);

                    dialog.setTitle(getString(R.string.string_getting_json_title));

                    dialog.setMessage(getString(R.string.string_getting_json_message));
                    dialog.show();
                    //Creating an object of our api interface
                    ApiService api = RetroClient.getApiService();
                    // Calling JSON
                    Call<ContactList> call = api.getMyJSON();
                    call.enqueue(new Callback<ContactList>() {
                        @Override
                        public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                            //Dismiss Dialog
                            dialog.dismiss();
                            if (response.isSuccessful()) {
                                // Got Successfully
                                contactsList = response.body().getContacts();
                                // Binding that List to Adapter
                                adapter = new MyContactAdapter(bai4.this, contactsList);
                                listView.setAdapter(adapter);
                            } else {
                                Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ContactList> call, Throwable t) {
                            dialog.dismiss();
                        }
                    });
                } else {
                    Snackbar.make(parentView, R.string.string_internet_connection_not_available, Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it ispresent.
        getMenuInflater().inflate(R.menu.openmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.toolbar) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

