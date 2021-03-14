package com.example.ht8_2;

import java.util.ArrayList;
import java.util.Scanner;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Bundle;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class BottleDispenser extends AppCompatActivity {

    private Button moneyAdder;
    private Button bottleBuyer;
    private Button catalogShower;
    private Button returnCash;
    private TextView screenView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottleBuyer = (Button) findViewById(R.id.buyButton);
        catalogShower = (Button) findViewById(R.id.catalogButton);
        returnCash = (Button) findViewById(R.id.returnMoney);
        screenView = (TextView) findViewById(R.id.screenView);


        moneyAdder = (Button) findViewById(R.id.addMoney);

        moneyAdder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money += 1;
                screenView.setText("Klink! Added more money!");
            }
        });

        bottleBuyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyBottle(v);
            }
        });

        returnCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnMoney(v);
            }
        });

        catalogShower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catalog(v);
            }
        });

    }

    private int bottles;
    private double money;
    ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();

    private static BottleDispenser bottleBud = new BottleDispenser();

    public static BottleDispenser getBottleDispenser() {
        return bottleBud;
    }

    private BottleDispenser() {
        bottles = 5;
        money = 0;

        for(int i = 0; i< bottles; i++) {
            Bottle temp = new Bottle();
            bottle_array.add(temp);

        }

        //Scanner skanneri = new Scanner(System.in);

        //while (true) {
            //System.out.println("");
            //System.out.print("*** BOTTLE DISPENSER ***\n1) Add money to the machine\n2) Buy a bottle\n3) Take money out\n4) List bottles in the dispenser\n0) End\n");
            //System.out.print("Your choice: ");
            //int num = skanneri.nextInt();

            //if (num == 4) {
                //System.out.print("1. Name: Pepsi Max\n\tSize: 0.5	Price: 1.8\n2. Name: Pepsi Max\n\tSize: 0.5	Price: 1.8\n3. Name: Pepsi Max\n\tSize: 0.5	Price: 1.8\n4. Name: Pepsi Max\n\tSize: 0.5	Price: 1.8\n");
                //catalog();

            //} else if (num == 1) {
                //addMoney();

            //} else if (num == 2 ) {
                //buyBottle();

            //}else if (num == 3) {
               // returnMoney();

            //}else if (num == 0) {
                //break;

            //}else {
                //System.out.println("Huono numero.");
            //}

        //}
        //skanneri.close();
    }

    public void catalog(View v) {
        for(int i = 1; i<= bottles; i++) {
            screenView.setText(i +". " + "Name: Pepsi Max\n\tSize: 0.5	Price: 1.8");
            //System.out.println(i +". " + "Name: Pepsi Max\n\tSize: 0.5	Price: 1.8");
        }
    }

    public void addMoney(View v) {
        money += 1;
        //balanceView.setText();
        screenView.setText("Klink! Added more money!");
        //System.out.println("Klink! Added more money!");
    }

    public void buyBottle(View v) {
        if (money < 1.8) {
            screenView.setText("Add money first!");
            //System.out.println("Add money first!");
        } else {
            if (bottles > 0) {
                bottles -= 1;
                money = money - 1.8;
                screenView.setText("KACHUNK! " + bottle_array.get(bottles).getName() + " came out of the dispenser!");
                //System.out.println("KACHUNK! " + bottle_array.get(bottles).getName() + " came out of the dispenser!");

            } else {
                screenView.setText("Out of bottles!");
                //System.out.println("Out of bottles!");
            }
        }
    }
    public void returnMoney(View v) {
        money = 0;
        screenView.setText("Klink klink. Money came out!");
        //System.out.println("Klink klink. Money came out!");
    }

}
