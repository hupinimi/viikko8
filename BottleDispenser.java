package com.example.ht8_2;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


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

        moneyAdder.setOnClickListener(v -> {
            money += 1;
            screenView.setText("Klink! Added more money!");
        });


        bottleBuyer.setOnClickListener(v -> {
            if (money < 1.8) {
                screenView.setText("Add money first!");
            } else {
                if (bottles > 0) {
                    bottles -= 1;
                    money = money - 1.8;
                    screenView.setText("KACHUNK! " + bottle_array.get(bottles).getName() + " came out of the dispenser!");

                } else {
                    screenView.setText("Out of bottles!");
                }
            }
        });

        returnCash.setOnClickListener(v -> {
            money = 0;
            screenView.setText("Klink klink. Money came out!");
        });

        catalogShower.setOnClickListener(v -> {
            for(int i = 1; i<= bottles; i++) {
                screenView.setText(i +". " + "Name: Pepsi Max\n\tSize: 0.5	Price: 1.8");
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
