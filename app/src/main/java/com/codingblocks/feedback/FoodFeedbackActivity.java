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


public class FoodFeedbackActivity extends AppCompatActivity {


    RatingBar ratingBar;

    CardView feedback;
     String description="", pgID="null";
     float ratingvalue;

    TextView question;
    Button q1,q2,q3,q4,q5;
    boolean p1=false;
    boolean p2=false;
    boolean p3=false;
    boolean p4=false;
    boolean p5=false;
    Button submit;
    SharedPreferences sharedPreferences;
    int pgNumber;


    FirebaseUser firebaseUser;
    DatabaseReference databaseReference, databaseReference1;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://eazypg.firebaseio.com");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_feedback);
        sharedPreferences = getSharedPreferences("PG",Context.MODE_PRIVATE);
        pgNumber = sharedPreferences.getInt("PGNumber", 1);


        feedback=findViewById(R.id.feedbackfood);
        ratingBar=findViewById(R.id.ratingBarfood);
        question=findViewById(R.id.fquestion);

        q1=findViewById(R.id.fq1);
        q2=findViewById(R.id.fq2);
        q3=findViewById(R.id.fq3);
        q4=findViewById(R.id.fq4);
        q5=findViewById(R.id.fq5);

        submit=findViewById(R.id.fsubmit);

        feedback.setVisibility(View.GONE);

        databaseReference1 = firebaseDatabase.getReference("Tenants/" + FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                pgID = dataSnapshot.child("pgId").getValue(String.class);

                databaseReference = firebaseDatabase.getReference("PG/" + pgID + "/PG" + pgNumber);

                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {


                        p1=false;
                        p2=false;
                        p3=false;
                        p4=false;
                        p5=false;
                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                        if(rating>=4 && rating<5){
                            ratingvalue=rating;

                            question.setText("Why isn't it awesome ?");
                            q1.setText("Unhealthy");
                            q2.setText("unhygienic");
                            q3.setText("Cold & Stale");
                            q4.setText("Bad server");
                            q5.setText("Repeated Menu");


                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p1){
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p1=true;
                                        description+=(q1.getText().toString()+"-");
                                    }
                                    else{
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1=false;
                                        description=description.replace(q1.getText().toString()+"-","");
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p2){
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        p2=true;
                                        description+=(q2.getText().toString()+"-");
                                    }
                                    else{
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2=false;
                                        description=description.replace(q2.getText().toString()+"-","");

                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p3){
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q3.getText().toString()+"-");
                                        p3=true;
                                    }
                                    else{
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3=false;
                                        description=description.replace(q3.getText().toString()+"-","");

                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p4){
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q4.getText().toString()+"-");
                                        p4=true;
                                    }
                                    else{
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4=false;
                                        description=description.replace(q4.getText().toString()+"-","");

                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p5){
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q5.getText().toString()+"-");
                                        p5=true;
                                    }
                                    else{
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5=false;
                                        description=description.replace(q5.getText().toString()+"-","");

                                    }
                                }
                            });
                        }
                        if(rating>=3 && rating<4){
                            ratingvalue =rating;

                            question.setText("Why isn't it good ?");
                            q1.setText("Unhealthy");
                            q2.setText("unhygienic");
                            q3.setText("Cold & Stale");
                            q4.setText("Bad servers");
                            q5.setText("Repeated Menu");

                            p1=false;
                            p2=false;
                            p3=false;
                            p4=false;
                            p5=false;
                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p1){
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q1.getText().toString()+"-");
                                        p1=true;
                                    }
                                    else{
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1=false;
                                        description=description.replace(q1.getText().toString()+"-","");

                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p2){
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q2.getText().toString()+"-");
                                        p2=true;
                                    }
                                    else{
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2=false;
                                        description=description.replace(q2.getText().toString()+"-","");

                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p3){
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q3.getText().toString()+"/");
                                        p3=true;
                                    }
                                    else{
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3=false;
                                        description=description.replace(q3.getText().toString()+"-","");

                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p4){
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q4.getText().toString()+"-");
                                        p4=true;
                                    }
                                    else{
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4=false;
                                        description=description.replace(q4.getText().toString()+"-","");

                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p5){
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q5.getText().toString()+"-");
                                        p5=true;
                                    }
                                    else{
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5=false;
                                        description=description.replace(q5.getText().toString()+"-","");

                                    }
                                }
                            });

                            feedback.setVisibility(View.VISIBLE);
                        }
                        if(rating>=2 && rating<3){
                            ratingvalue=rating;

                            question.setText("Why it is bad ?");
                            q1.setText("Unhealthy");
                            q2.setText("unhygienic");
                            q3.setText("Cold & Stale");
                            q4.setText("Bad servers");
                            q5.setText("Repeated Menu");
                            p1=false;
                            p2=false;
                            p3=false;
                            p4=false;
                            p5=false;


                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p1){
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q1.getText().toString()+"-");
                                        p1=true;
                                    }
                                    else{
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1=false;
                                        description=description.replace(q1.getText().toString()+"-","");

                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p2){
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q2.getText().toString()+"-");
                                        p2=true;
                                    }
                                    else{
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2=false;
                                        description=description.replace(q2.getText().toString()+"-","");

                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p3){
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q3.getText().toString()+"-");
                                        p3=true;
                                    }
                                    else{
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3=false;
                                        description=description.replace(q3.getText().toString()+"-","");

                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p4){
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q4.getText().toString()+"-");
                                        p4=true;
                                    }
                                    else{
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4=false;
                                        description=description.replace(q4.getText().toString()+"-","");

                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p5){
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q5.getText().toString()+"-");
                                        p5=true;
                                    }
                                    else{
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5=false;
                                        description=description.replace(q5.getText().toString()+"-","");

                                    }
                                }
                            });

                            feedback.setVisibility(View.VISIBLE);
                        }
                        if(ratingBar.getRating()>0 && ratingBar.getRating()<2){
                            rating=ratingBar.getRating();

                            question.setText("Why it is so bad ?");
                            q1.setText("Unhealthy");
                            q2.setText("unhygienic");
                            q3.setText("Cold & Stale");
                            q4.setText("Bad srevers");
                            q5.setText("Reapeted Menu");

                            p1=false;
                            p2=false;
                            p3=false;
                            p4=false;
                            p5=false;

                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p1){
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q1.getText().toString()+"-");
                                        p1=true;
                                    }
                                    else{
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1=false;
                                        description=description.replace(q1.getText().toString()+"-","");

                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p2){
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q2.getText().toString()+"-");
                                        p2=true;
                                    }
                                    else{
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2=false;
                                        description=description.replace(q2.getText().toString()+"-","");

                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p3){
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q3.getText().toString()+"-");
                                        p3=true;
                                    }
                                    else{
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3=false;
                                        description=description.replace(q3.getText().toString()+"-","");

                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p4){
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));

                                        description+=(q4.getText().toString()+"-");
                                        p4=true;

                                    }
                                    else{
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4=false;
                                        description=description.replace(q4.getText().toString()+"-","");

                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p5){
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q5.getText().toString()+"-");
                                        p5=true;
                                    }
                                    else{
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5=false;
                                        description=description.replace(q5.getText().toString()+"-","");

                                    }
                                }
                            });
                            feedback.setVisibility(View.VISIBLE);
                        }
                        if(rating==0){
                            ratingvalue=rating;
                            feedback.setVisibility(View.GONE);
                        }
                        if(rating==5){
                            ratingvalue=rating;

                            question.setText("What did you like ?");
                            q1.setText("Nutritious");
                            q2.setText("Hygiene");
                            q3.setText("Fresh & Hot");
                            q4.setText("Variety of Menu");
                            q5.setText("Unlimited Quantity");

                            p1=false;
                            p2=false;
                            p3=false;
                            p4=false;
                            p5=false;
                            feedback.setVisibility(View.VISIBLE);

                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p1){
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q1.getText().toString()+"-");
                                        p1=true;
                                    }
                                    else{
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1=false;
                                        description=description.replace(q1.getText().toString()+"-","");

                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p2){
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q2.getText().toString()+"-");
                                        p2=true;
                                    }
                                    else{
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2=false;
                                        description=description.replace(q2.getText().toString()+"-","");

                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p3){
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q3.getText().toString()+"-");
                                        p3=true;
                                    }
                                    else{
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3=false;
                                        description=description.replace(q3.getText().toString()+"-","");

                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p4){
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q4.getText().toString()+"-");
                                        p4=true;
                                    }
                                    else{
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4=false;
                                        description=description.replace(q4.getText().toString()+"-","");

                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(!p5){
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description+=(q5.getText().toString()+"-");
                                        p5=true;
                                    }
                                    else{
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5=false;
                                        description=description.replace(q5.getText().toString()+"-","");

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
                databaseReference.child("Feedback").child("TenantFeedback").child("Food").child(key).setValue(feedbackDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(FoodFeedbackActivity.this, "Feedback Sent", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

}