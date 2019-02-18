package tv.anandhkumar.recyclercards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //creating the Arraylist to put/add our resources
    ArrayList<Cards> cards = new  ArrayList<>();

    //these three things are must for Recycler views
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button buttonAdd,buttonDelete;
    private EditText editTextAdd,editTextDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Datas();

        configRecyclerView();


        buttonAdd = findViewById(R.id.buttonadd);
        buttonDelete = findViewById(R.id.buttondelete);
        editTextAdd = findViewById(R.id.edittextadd);
        editTextDelete = findViewById(R.id.edittextdelete);


        //TODO:button Add is need to be validated.
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cards.isEmpty() && editTextAdd.getText() ==null){
                    Toast.makeText(getApplicationContext(),"Please enter the valid index to Add",
                            Toast.LENGTH_SHORT).show();
                }
                else if (!editTextAdd.getText().equals(0)){
                    int position = Integer.parseInt(editTextAdd.getText().toString());
                    addCard(position);
                }
                else{

                }

            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cards.isEmpty()) {
                    int position = Integer.parseInt(editTextDelete.getText().toString());
                    deleteCard(position);
                }
                else if (editTextDelete.getText() == null){
                    Toast.makeText(getApplicationContext(),"Please enter the index to Add",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"No more Cards to delete",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void configRecyclerView() {

        //Config for RecyclerView
        recyclerView = findViewById(R.id.recyclerView);

        //performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new CardsAdapter(cards);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void Datas() {

        //resources that we are passing to the Cards class constructor
        cards.add(new Cards(R.drawable.node,"Clicked at my studio"));
        cards.add(new Cards(R.drawable.oner,"Clicked at my Home"));
        cards.add(new Cards(R.drawable.twor,"Clicked at Greece"));
        cards.add(new Cards(R.drawable.threer,"Clicked at Rome"));
        cards.add(new Cards(R.drawable.fourr,"Clicked at SanDiego"));
        cards.add(new Cards(R.drawable.fiver,"Clicked at India"));
        cards.add(new Cards(R.drawable.sixr,"Clicked at UK"));
    }

    private void deleteCard(int position) {

        cards.remove(position);
        adapter.notifyItemRemoved(position);

    }

    private void addCard(int position) {
        cards.add(position,new Cards(R.drawable.sixr,"New Card"));
//        adapter.notifyDataSetChanged();
        adapter.notifyItemInserted(position);
    }




}
