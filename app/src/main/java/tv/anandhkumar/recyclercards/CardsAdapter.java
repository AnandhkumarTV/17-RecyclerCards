package tv.anandhkumar.recyclercards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//following are the ten(10) steps to implement the custom array adapter

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {


    //6.2-creating the instance of the type ArrayList of Cards class which is used to get the current item
    private ArrayList<Cards> mCardsList;

    //1-creating ViewHolder class
    public static class CardsViewHolder extends RecyclerView.ViewHolder{

        //4-declare and map the resources
        public ImageView imageView;
        public TextView textView;


        //2-create the constructor
        public CardsViewHolder(@NonNull View itemView) {
            super(itemView);

            //4-mapping the resource
            imageView = itemView.findViewById(R.id.imageView);
            textView  =itemView.findViewById(R.id.textView);


        }
    }

    //6.1-creating the constructor to pass the list of resources(cardview) from the Cards class
    //this is to generate the no.of items
    public CardsAdapter(ArrayList<Cards> cardsList){
        mCardsList=cardsList;
    }

    //3-implement the following three methods
    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //5-we need the inflate our custom designed layout resource called Cards
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards,viewGroup,false);
        CardsViewHolder cardsViewHolder = new CardsViewHolder(view);
        return cardsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardsViewHolder cardsViewHolder, int i) {
        //7-setting the resources on-demand by using the get(i/position)-method
        Cards currentItem = mCardsList.get(i);
        cardsViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        cardsViewHolder.textView.setText(currentItem.getmText());

    }

    @Override
    public int getItemCount() {
        //8-returning the no.of items which is cards in this case
        return mCardsList.size();
    }








}
