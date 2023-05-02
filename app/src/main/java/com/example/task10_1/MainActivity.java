package com.example.task10_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goTo2(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Белый текст");
        menu.add("Синий текст");
        menu.setGroupCheckable(menu.getItem(0).getItemId(), true, true);

        SubMenu sub1 = menu.addSubMenu("Темы");
        sub1.add("Светлая");
        sub1.add("Темная");
        sub1.setGroupCheckable(sub1.getItem(0).getItemId(), true, true);
        sub1.setGroupCheckable(sub1.getItem(1).getItemId(), true, true);
        sub1.getItem(0).setChecked(true);

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView header = findViewById(R.id.header);
        if (item.getTitle() == "Светлая" || item.getTitle() == "Темная") {
            item.setChecked(true);
            LinearLayout layout = findViewById(R.id.lay);
            if (item.getTitle() == "Светлая")
                layout.setBackgroundColor(getColor(R.color.white));
            else
                layout.setBackgroundColor(getColor(R.color.bg_black));
            return true;
        }
        if (item.getTitle() == "Белый текст" || item.getTitle() == "Синий текст") {
            if (item.getTitle() == "Синий текст")
                header.setTextColor(getColor(R.color.teal_200));
            else
                header.setTextColor(getColor(R.color.white));
            item.setChecked(true);
            return true;
        }
        header.setText(item.getTitle().toString());
        return true;
    }

}