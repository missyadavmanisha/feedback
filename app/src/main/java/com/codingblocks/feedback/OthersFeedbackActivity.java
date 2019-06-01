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

public class OthersFeedbackActivity extends AppCompatActivity {


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

    float ratingvalue;
    String description="",pgId;

    SharedPreferences sharedPreferences;
    int pgNumber;


    FirebaseUser firebaseUser;
    DatabaseReference databaseReference,databaseReference1;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://eazypg.firebaseio.com");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_feedback);

        feedback=findViewById(R.id.feedbackother);

        sharedPreferences = getSharedPreferences("PG",Context.MODE_PRIVATE);
        pgNumber = sharedPreferences.getInt("PGNumber", 1);


        ratingBar=findViewById(R.id.oratingBar);
        question=findViewById(R.id.oquestion);

        q1=findViewById(R.id.oq1);
        q2=findViewById(R.id.oq2);
        q3=findViewById(R.id.oq3);
        q4=findViewById(R.id.oq4);
        q5=findViewById(R.id.oq5);

        submit=findViewById(R.id.osubmit);

        feedback.setVisibility(View.GONE);



        databaseReference1=firebaseDatabase.getReference("Tenants/" + FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pgId=dataSnapshot.child("pgId").getValue(String.class);
                databaseReference = firebaseDatabase.getReference("PG/" + pgId + "/PG" + pgNumber);


                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {



                        if(rating>=4 && rating<5){
                            ratingvalue=rating;
                            question.setText("What did you not like ?");
                            q1.setText("Unsafe");
                            q2.setText("No Mess");
                            q3.setText("Bad Locality");
                            q4.setText("Not Value For Money");
                            q5.setText("Poor Connectivity");


                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p1) {
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q1.getText().toString() + " ");
                                        p1 = true;
                                    } else {
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1 = false;
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p2) {
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q2.getText().toString() + " ");
                                        p2 = true;
                                    } else {
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2 = false;
                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p3) {
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q2.getText().toString() + " ");
                                        p3 = true;
                                    } else {
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3 = false;
                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p4) {
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q4.getText().toString());
                                        p4 = true;
                                    } else {
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4 = false;
                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p5) {
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q5.getText().toString() + " ");
                                        p5 = true;
                                    } else {
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5 = false;
                                    }
                                }
                            });

                        }
                        if(rating>=3 && rating<4){
                            ratingvalue=rating;

                            question.setText("Why isn't it good ?");
                            q1.setText("Unsafe");
                            q2.setText("No Mess");
                            q3.setText("Bad Locality");
                            q4.setText("Not Value For Money");
                            q5.setText("Poor Connectivity");


                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p1) {
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q1.getText().toString() + " ");
                                        p1 = true;
                                    } else {
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1 = false;
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p2) {
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q2.getText().toString() + " ");
                                        p2 = true;
                                    } else {
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2 = false;
                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p3) {
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q2.getText().toString() + " ");
                                        p3 = true;
                                    } else {
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3 = false;
                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p4) {
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q4.getText().toString());
                                        p4 = true;
                                    } else {
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4 = false;
                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p5) {
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q5.getText().toString() + " ");
                                        p5 = true;
                                    } else {
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5 = false;
                                    }
                                }
                            });


                            feedback.setVisibility(View.VISIBLE);
                        }
                        if(rating>=2 && rating<3){
                            ratingvalue=rating;

                            question.setText("Why it is bad ?");
                            q1.setText("Unsafe");
                            q2.setText("No Mess");
                            q3.setText("Bad Locality");
                            q4.setText("Not Value For Money");
                            q5.setText("Poor Connectivity");


                            feedback.setVisibility(View.VISIBLE);
                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p1) {
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q1.getText().toString() + " ");
                                        p1 = true;
                                    } else {
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1 = false;
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p2) {
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q2.getText().toString() + " ");
                                        p2 = true;
                                    } else {
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2 = false;
                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p3) {
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q2.getText().toString() + " ");
                                        p3 = true;
                                    } else {
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3 = false;
                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p4) {
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q4.getText().toString());
                                        p4 = true;
                                    } else {
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4 = false;
                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p5) {
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q5.getText().toString() + " ");
                                        p5 = true;
                                    } else {
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5 = false;
                                    }
                                }
                            });

                            feedback.setVisibility(View.VISIBLE);
                        }
                        if(rating>0 && rating<2){
                            ratingvalue=rating;


                            question.setText("Why it is so bad ?");
                            q1.setText("Unsafe");
                            q2.setText("No Mess");
                            q3.setText("Bad Locality");
                            q4.setText("Not Value For Money");
                            q5.setText("Poor Connectivity");


                            feedback.setVisibility(View.VISIBLE);


                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p1) {
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q1.getText().toString() + " ");
                                        p1 = true;
                                    } else {
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1 = false;
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p2) {
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q2.getText().toString() + " ");
                                        p2 = true;
                                    } else {
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2 = false;
                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p3) {
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q2.getText().toString() + " ");
                                        p3 = true;
                                    } else {
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3 = false;
                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p4) {
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q4.getText().toString());
                                        p4 = true;
                                    } else {
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4 = false;
                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p5) {
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q5.getText().toString() + " ");
                                        p5 = true;
                                    } else {
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5 = false;
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
                            q1.setText("Food");
                            q2.setText("Facilities");
                            q3.setText("Culture");
                            q4.setText("Management");
                            q5.setText("Value for money");


                            feedback.setVisibility(View.VISIBLE);

                            q1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p1) {
                                        q1.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q1.getText().toString() + " ");
                                        p1 = true;
                                    } else {
                                        q1.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p1 = false;
                                    }
                                }
                            });

                            q2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p2) {
                                        q2.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q2.getText().toString() + " ");
                                        p2 = true;
                                    } else {
                                        q2.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p2 = false;
                                    }
                                }
                            });
                            q3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p3) {
                                        q3.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q2.getText().toString() + " ");
                                        p3 = true;
                                    } else {
                                        q3.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p3 = false;
                                    }
                                }
                            });

                            q4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p4) {
                                        q4.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q4.getText().toString());
                                        p4 = true;
                                    } else {
                                        q4.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p4 = false;
                                    }
                                }
                            });

                            q5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!p5) {
                                        q5.setBackgroundColor(getResources().getColor(R.color.pink));
                                        description += (q5.getText().toString() + " ");
                                        p5 = true;
                                    } else {
                                        q5.setBackgroundColor(getResources().getColor(R.color.lightgray));
                                        p5 = false;
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
                databaseReference.child("Feedback").child("TenantFeedback").child("Other").child(key).setValue(feedbackDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(OthersFeedbackActivity.this, "Feedback Sent", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }


}