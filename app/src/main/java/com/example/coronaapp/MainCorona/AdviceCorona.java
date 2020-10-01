package com.example.coronaapp.MainCorona;
 import com.example.coronaapp.Adapter.RecyclerAdapterA;

 import android.content.Context;
 import android.content.Intent;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuInflater;
 import android.view.MenuItem;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

 import com.example.coronaapp.Chat.MessageActivity;
 import com.example.coronaapp.Helper.ViewHolder;
 import com.example.coronaapp.Model.ModelAdviceCorona;
 import com.example.coronaapp.Profile.LogIn;
 import com.example.coronaapp.Profile.Profile;
 import com.example.coronaapp.Profile.Register;
 import com.example.coronaapp.R;
 import com.firebase.ui.database.FirebaseRecyclerAdapter;
 import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

 import java.util.ArrayList;

public class AdviceCorona extends AppCompatActivity {


    private RecyclerAdapterA recyclerAdapterA;
    RecyclerView recyclerView;
    //fire base
    FirebaseDatabase firebaseDatabase;
   private DatabaseReference databaseReference;
   //variable
   private ArrayList<ModelAdviceCorona>modelAdviceCoronas;
   //context
    /*private Context mContext=getApplicationContext();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice_corona);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("كيفية الوقاية من كورونا");

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Data");

        modelAdviceCoronas=new ArrayList<>();


        //get Data Method
      /*  GetDataFromFirebase();*/






    }

    /*private void GetDataFromFirebase(){

        Query query=databaseReference.child("Data");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearList();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    ModelAdviceCorona model=new ModelAdviceCorona();
                    model.setImage(snapshot.child("image").getValue().toString());
                    model.setDescription(snapshot.child("description").getValue().toString());
                    model.setTitle(snapshot.child("title").getValue().toString());
                    modelAdviceCoronas.add(model);
                }
                recyclerAdapterA=new RecyclerAdapterA(mContext,modelAdviceCoronas);
                recyclerView.setAdapter(recyclerAdapterA);
                recyclerAdapterA.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void ClearList(){
        if(modelAdviceCoronas !=null) {
            modelAdviceCoronas.clear();

            if(recyclerAdapterA != null){recyclerAdapterA.notifyDataSetChanged();}
        }
        modelAdviceCoronas=new ArrayList<>();



    }
*/

  //Old Library
    protected void onStart() {

        super.onStart();
       FirebaseRecyclerAdapter<ModelAdviceCorona, ViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<ModelAdviceCorona, ViewHolder>(
               ModelAdviceCorona.class
               ,R.layout.row
               ,ViewHolder.class
               ,databaseReference
       ) {
           @Override
           protected void populateViewHolder(ViewHolder viewHolder, ModelAdviceCorona mod, int i) {
               viewHolder.setDetails(getApplicationContext(),mod.getTitle(),mod.getDescription(),mod.getImage());
           }
       };
       recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.tracker:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                return true;
            case R.id.profile:
                startActivity(new Intent(getApplicationContext(), Profile.class));
                return true;
            case R.id.regiser:
                startActivity(new Intent(getApplicationContext(), Register.class));
                return true;
            case R.id.advice:
                startActivity(new Intent(getApplicationContext(),AdviceCorona.class));
                return true;
            case R.id.login:
                startActivity(new Intent(getApplicationContext(), LogIn.class));
                return true;
            case R.id.videoCorona:
                startActivity(new Intent(getApplicationContext(), VideoAboutCorona.class));
                return true;
            case R.id.chat:
                startActivity(new Intent(getApplicationContext(), MessageActivity.class));
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
