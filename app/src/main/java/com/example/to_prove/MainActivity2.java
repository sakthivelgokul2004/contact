package com.example.to_prove;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.to_prove.databinding.ActivityMain2Binding;
import com.example.to_prove.databinding.ResBinding;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements Helper_interfae {
    String   [] n={dbhelper.getDB_name,dbhelper.phone_no};
    int   [] nto={R.id.txt,R.id.txt2};
    private StudentAdapter studentAdapter;
    ArrayList<recylehelp> adapters;
    dbmanger dbmanger;
//    ResBinding resBinding=ResBinding.inflate(getLayoutInflater());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain2Binding binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ResBinding bnd=ResBinding.inflate(getLayoutInflater());
//       ArrayAdapter<String> arr = new ArrayAdapter<>(this, R.layout.res, bnd.txt.getId(), n);
//        binding.list.setAdapter(arr);
        ListView listView = binding.list;
        dbmanger=new dbmanger(getApplicationContext());
        dbmanger.open();
//        Cursor cursor = dbmanger.fetch();

//        Log.e("gopi ","ff "+cursor);
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.res, cursor, n, nto, 0);
//        adapter.notifyDataSetChanged();
//        binding.list.setAdapter(adapter);
        adapters= new ArrayList<recylehelp>() ;
        adapters.clear();
        adapters=dbmanger.read();
        studentAdapter =new StudentAdapter(this, adapters,this);
        binding.studentListRc.setLayoutManager(new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.VERTICAL,false));

        binding.studentListRc.setAdapter(studentAdapter);

        dbmanger.close();



    }


    @Override
    public void ondel( int postion) {
       dbmanger.open();

        dbmanger.delete(postion);
        studentAdapter.notifyDataSetChanged();

//       adapters.remove(postion);
//    studentAdapter.notifyDataSetChanged();
//        studentAdapter.notifyItemRemoved(studentAdapter.g);
//        mPeopleList.remove(position);
//        mRecyclerV.removeViewAt(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, mPeopleList.size());
//        notifyDataSetChanged()
//        studentAdapter.notifyItemRangeChanged(postion,adapters.size());

        dbmanger.close();
    }
}