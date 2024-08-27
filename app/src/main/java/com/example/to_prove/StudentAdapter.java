package com.example.to_prove;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.to_prove.databinding.ResBinding;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context context;
    ArrayList<recylehelp> cursorList;

    Helper_interfae helper_interfae;

    public StudentAdapter(Context context, ArrayList<recylehelp> cursorList, Helper_interfae helper_interfae) {
        this.context = context;
        this.cursorList = cursorList;
        this.helper_interfae=helper_interfae;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ResBinding resBinding=ResBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new StudentViewHolder(resBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {
      final   recylehelp help=cursorList.get(position);
        holder.view.txt.setText(help.getStname());
        holder.view.txt2.setText(help.getStphone());
        holder.view.btnRemove.setOnClickListener(view -> {
            helper_interfae.ondel(help.getId());
            cursorList.remove(help);
        });



    }

    @Override
    public int getItemCount() {
        return cursorList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        ResBinding view;
        public StudentViewHolder(@NonNull ResBinding itemView) {
            super(itemView.getRoot());
            view=itemView;
//            itemView.btnRemove.setOnClickListener(new View.OnClickListener() {a
//                @Override
//                public void onClick(View view) {
//
////                        quesList=db.getAllQuestions();
////                    if(quesList!= null && quesList.size() !=0) {
////                        currentQ=quesList.get(qid);
////                    }
//                    cursorList.remove(getAdapterPosition());
//                    cursorList.remove(getAdapterPosition());
//
//                        helper_interfae.ondel(help.getStphone());
//
//                        if(cursorList.size()==1){
//                           helper_interfae.ondel( cursorList.get(0).getStphone());}
//                        else if(cursorList.size()==0){
//                            helper_interfae.ondel(null);
//                        }
//
//                        notifyItemRemoved(getLayoutPosition());
//                }
//            });
        }
    }
}
