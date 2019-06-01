package com.codingblocks.feedback;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;


public class ComfortFeedbackActivity extends AppCompatActivity {

    RatingBar ratingBar;

    CardView feedback;

    TextView question;
    Button q1,q2,q3,q4,q5;
    boolean p1=false;
    boolean p2=false;
    boolean p3=false;
    boolean p4=false;
    boolean p5=false;
    Button submit;

    float ratingvalue ;
    String description="",pgId;

    SharedPreferences sharedPreferences;
    int pgNumber;


    FirebaseUser firebaseUser;
    DatabaseReference databaseReference,databaseReference1;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://eazypg.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comfort_feedback);

        feedback=findViewById(R.id.feedbackComfort);

        ratingBar=findViewById(R.id.cratingBar);
        question=findViewById(R.id.cquestion);
        sharedPreferences = getSharedPreferences("PG",Context.MODE_PRIVATE);
        pgNumber = sharedPreferences.getInt("PGNumber", 1);

databaseReference1=firebaseDatabase.getReference("Tenants/" + FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pgId= dataSnapshot.child("pgId").getValue(String.class);

                databaseReference = firebaseDatabase.getReference("PG/" + pgId + "/PG" + pgNumber);

                q1=findViewById(R.id.cq1);
                q2=findViewById(R.id.cq2);
                q3=findViewById(R.id.cq3);
                q4=findViewById(R.id.cq4);
                q5=findViewById(R.id.cq5);

                submit=findViewById(R.id.csubmit);

                feedback.setVisibility(View.GONE);
                sharedPreferences = getSharedPreferences("PG",Context.MODE_PRIVATE);
                pgNumber = sharedPreferences.getInt("PGNumber", 1);


                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {


                        if(rating>=4 && rating<5){
                            ratingvalue=rating;

                            question.setText("Why isn't it awesome ?");
                            q1.setText("Slow Internet");
                            q2.setText("Powercut");
                            q3.setText("Foul Smell");
                            q4.setText("Drinking Water");
                            q5.setText("Noise");


                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p1){
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p1=true;
                                        description+=(q1.getText().toString()+"");
                                    }
                                    else{
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1=false;
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p2){
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p2=true;
                                        description+=(q2.getText().toString()+"");
                                    }
                                    else{
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2=false;
                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p3){
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q3.getText().toString()+"");
                                        p3=true;
                                    }
                                    else{
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3=false;
                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p4){
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q4.getText().toString()+"");
                                        p4=true;
                                    }
                                    else{
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4=false;
                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p5){
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q5.getText().toString()+"");
                                        p5=true;
                                    }
                                    else{
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5=false;
                                    }
                                }
                            });
                        }
                        if(rating>=3 && rating<4){
                            ratingvalue=rating;

                            question.setText("Why isn't it good ?");
                            q1.setText("Slow Internet");
                            q2.setText("Powercut");
                            q3.setText("Foul Smell");
                            q4.setText("Drinking Water");
                            q5.setText("Noise");


                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p1){
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p1=true;
                                        description+=(q1.getText().toString()+"");
                                    }
                                    else{
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1=false;
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p2){
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p2=true;
                                        description+=(q2.getText().toString()+"");
                                    }
                                    else{
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2=false;
                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p3){
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q3.getText().toString()+"");
                                        p3=true;
                                    }
                                    else{
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3=false;
                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p4){
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q4.getText().toString()+"");
                                        p4=true;
                                    }
                                    else{
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4=false;
                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p5){
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q5.getText().toString()+"");
                                        p5=true;
                                    }
                                    else{
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5=false;
                                    }
                                }
                            });

                            feedback.setVisibility(View.VISIBLE);
                        }
                        if(rating>=2 && rating<3){
                            ratingvalue=rating;

                            question.setText("Why it is bad ?");
                            q1.setText("Slow Internet");
                            q2.setText("Powercut");
                            q3.setText("Foul Smell");
                            q4.setText("Drinking Water");
                            q5.setText("Noise");


                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p1){
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p1=true;
                                        description+=(q1.getText().toString()+"");
                                    }
                                    else{
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1=false;
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p2){
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p2=true;
                                        description+=(q2.getText().toString()+"");
                                    }
                                    else{
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2=false;
                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p3){
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q3.getText().toString()+"");
                                        p3=true;
                                    }
                                    else{
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3=false;
                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p4){
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q4.getText().toString()+"");
                                        p4=true;
                                    }
                                    else{
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4=false;
                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p5){
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q5.getText().toString()+"");
                                        p5=true;
                                    }
                                    else{
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5=false;
                                    }
                                }
                            });

                            feedback.setVisibility(View.VISIBLE);
                        }
                        if(rating>0 && rating<2){
                            ratingvalue =rating;

                            question.setText("Why it is so bad ?");
                            q1.setText("Slow Internet");
                            q2.setText("Powercut");
                            q3.setText("Foul Smell");
                            q4.setText("Drinking Water");
                            q5.setText("Noise");


                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p1){
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p1=true;
                                        description+=(q1.getText().toString()+"");
                                    }
                                    else{
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1=false;
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p2){
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p2=true;
                                        description+=(q2.getText().toString()+"");
                                    }
                                    else{
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2=false;
                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p3){
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q3.getText().toString()+"");
                                        p3=true;
                                    }
                                    else{
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3=false;
                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p4){
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q4.getText().toString()+"");
                                        p4=true;
                                    }
                                    else{
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4=false;
                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p5){
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q5.getText().toString()+"");
                                        p5=true;
                                    }
                                    else{
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5=false;
                                    }
                                }
                            });
                            feedback.setVisibility(View.VISIBLE);
                        }
                        if(ratingBar.getRating()==0){
                            rating=ratingBar.getRating();
                            feedback.setVisibility(View.GONE);
                        }
                        if(ratingBar.getRating()==5){
                            rating=ratingBar.getRating();

                            question.setText("What did you like ?");
                            q1.setText("Power Backup");
                            q2.setText("Lift");
                            q3.setText("Laundry");
                            q4.setText("Gym");
                            q5.setText("RO & Water Cooler");


                            feedback.setVisibility(View.VISIBLE);

                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p1){
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p1=true;
                                        description+=(q1.getText().toString()+"");
                                    }
                                    else{
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1=false;
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p2){
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p2=true;
                                        description+=(q2.getText().toString()+"");
                                    }
                                    else{
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2=false;
                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p3){
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q3.getText().toString()+"");
                                        p3=true;
                                    }
                                    else{
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3=false;
                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p4){
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q4.getText().toString()+"");
                                        p4=true;
                                    }
                                    else{
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4=false;
                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p5){
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q5.getText().toString()+"");
                                        p5=true;
                                    }
                                    else{
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5=false;
                                    }
                                }
                            });

                        }

                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date date = new Date();

                String key = databaseReference.push().getKey();

                FeedbackDetails feedbackDetails = new FeedbackDetails(ratingvalue, description, key, date);
                databaseReference.child("Feedback").child("TenantFeedback").child("Comfort").child(key).setValue(feedbackDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ComfortFeedbackActivity.this, "Feedback Sent", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }


}