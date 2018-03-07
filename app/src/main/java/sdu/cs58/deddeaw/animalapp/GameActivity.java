package sdu.cs58.deddeaw.animalapp;

import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {


    //Explicit
    Button btn1,btn2,btn3, btn4;
    ImageView questionImageView;
    ImageButton volumnImageButton;
    MediaPlayer mediaPlayer;//เล่นไฟล์เสียง
    int questionCount = 1;//เป็นตัวแปรเก็บจำนวนข้อคำถาม
    ArrayList<Integer> qID = new ArrayList<Integer>();// qID เป็นตัวแปร Array ในการสุ่มคำถาม
    String answer;//เก็บคำตอบ
    int score = 0;//รวมคะแนน


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //initial View ผูก element กับตัวแปรบน java
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        questionImageView = findViewById(R.id.imvQuestion);
        volumnImageButton = findViewById(R.id.imbVolumn);

        //แสงคำถามให้โชว์ขึ้นบนหน้าจอ
        for (int i=1; i <= questionCount; i++) {
            qID.add(i);

        }// ปิดแสดงข้อคำถาม

        Collections.shuffle(qID); //กำหนดให้ Random คำถาม
        setQuestion(qID.remove(0));//method ที่ใช้แสดงรายละเอียดคำถาม

    }//End onCreate Method

    private void setQuestion(int qID) { // method question ทำหน้าที่กำหนดข้อคำถาม และเฉลยในแต่ละข้อ
        if (qID == 1) {
            answer = "นก";
            questionImageView.setImageResource(R.drawable.bird);
            mediaPlayer = MediaPlayer.create(this,R.raw.bird);

            ArrayList<String> choice = new ArrayList<String>();//กำหนดการ Random choice
            choice.add("นก");//แสดงว่ามีสัตว์อะไรใน choice บ้าง
            choice.add("แมว");
            choice.add("ม้า");
            choice.add("หมู");
            Collections.shuffle(choice);//กำหนดให้ ramdom choice
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));

        }

    }//End setQuestion method

    public void playSound(View view) {
        mediaPlayer.start();

    }//end playSound medhod

}//end class
