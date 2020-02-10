package com.java.androidtask;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {
    ArrayList<String> myItems;
    TestAdapter(ArrayList<String> listItems)
    {
        myItems = listItems;
    }
    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_item, parent, false);
        TestViewHolder hodelr = new TestViewHolder(v);
        return  hodelr;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        String item = myItems.get(position);
        holder.txtItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder{
        TextView txtItem;
        public TestViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtItem = itemView.findViewById(R.id.txtItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getAdapterPosition();
                    switch (itemPosition){
                        case 0:
                            Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+9821818313755"));
                            itemView.getContext().startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(itemView.getContext(), MainActivity.class);
                            itemView.getContext().startActivity(intent);
                    }

                }
            });
        }
    }
}