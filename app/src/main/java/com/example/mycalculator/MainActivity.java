package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    StringBuilder editor = new StringBuilder();

    public void clickZero(View view) {
        TextView status = findViewById(R.id.status);
        if (!status.getText().toString().isEmpty()) {
            status.setText(editor.append("0"));
        }
    }

    public void clickOne(View view) {
        TextView status = findViewById(R.id.status);
        status.setText(editor.append("1"));
    }

    public void clickTwo(View view) {
        TextView status = findViewById(R.id.status);
        status.setText(editor.append("2"));
    }

    public void clickThree(View view) {
        TextView status = findViewById(R.id.status);
        status.setText(editor.append("3"));
    }

    public void clickFour(View view) {
        TextView status = findViewById(R.id.status);
        status.setText(editor.append("4"));
    }

    public void clickFive(View view) {
        TextView status = findViewById(R.id.status);
        status.setText(editor.append("5"));
    }

    public void clickSix(View view) {
        TextView status = findViewById(R.id.status);
        status.setText(editor.append("6"));
    }

    public void clickSeven(View view) {
        TextView status = findViewById(R.id.status);
        status.setText(editor.append("7"));
    }

    public void clickEight(View view) {
        TextView status = findViewById(R.id.status);
        status.setText(editor.append("8"));
    }

    public void clickNine(View view) {
        TextView status = findViewById(R.id.status);
        status.setText(editor.append("9"));
    }

    public void clickPlus(View view) {
        TextView status = findViewById(R.id.status);
        if (!status.getText().toString().isEmpty()) {
            if (!Character.toString(editor.charAt(editor.length() - 1)).matches(" ")) {
                status.setText(editor.append(" + "));
            }
        }
    }

    public void clickMinus(View view) {
        TextView status = findViewById(R.id.status);
        if (!status.getText().toString().isEmpty()) {
            if (!Character.toString(editor.charAt(editor.length() - 1)).matches(" ")) {
                status.setText(editor.append(" - "));
            }
        }
    }

    public void clickMultiply(View view) {
        TextView status = findViewById(R.id.status);
        if (!status.getText().toString().isEmpty()) {
            if (!Character.toString(editor.charAt(editor.length() - 1)).matches(" ")) {
                status.setText(editor.append(" x "));
            }
        }
    }

    public void clickDivide(View view) {
        TextView status = findViewById(R.id.status);
        if (!status.getText().toString().isEmpty()) {
            if (!Character.toString(editor.charAt(editor.length() - 1)).matches(" ")) {
                status.setText(editor.append(" ÷ "));
            }
        }
    }

    public void clickDecimal(View view) {
        TextView status = findViewById(R.id.status);
        if (status.getText().toString().isEmpty() || Character.toString(editor.charAt(editor.length() - 1)).matches(" ")) {
            status.setText(editor.append("0."));
        } else {
            if (!Character.toString(editor.charAt(editor.length() - 1)).matches("\\.")) {
                status.setText(editor.append("."));
            }
        }
    }

    public void clickClear(View view) {
        TextView status = findViewById(R.id.status);
        status.setText("");
        editor = new StringBuilder();
    }

    public void clickBackspace(View view) {
        TextView status = findViewById(R.id.status);
        if (!status.getText().toString().isEmpty()) {
            if (Character.toString(editor.charAt(editor.length() - 1)).matches(" ")) {
                editor.deleteCharAt(editor.length() - 1);
                editor.deleteCharAt(editor.length() - 1);
                editor.deleteCharAt(editor.length() - 1);
                status.setText(editor);

            } else {
                editor.deleteCharAt(editor.length() - 1);
                status.setText(editor);
            }
        }
    }

    public void clickEqual(View view) {
        if (!editor.toString().contains(".")) {
            TextView status = findViewById(R.id.status);
            if (editor.toString().contains(" + ")) {
                status.setText(calculateIntArray(editor.toString().split(" \\+ "), 1));
                editor = new StringBuilder(status.getText());
            } else if (editor.toString().contains(" - ")) {
                status.setText(calculateIntArray(editor.toString().split(" - "), 2));
                editor = new StringBuilder(status.getText());
            } else if (editor.toString().contains(" x ")) {
                status.setText(calculateIntArray(editor.toString().split(" x "), 3));
                editor = new StringBuilder(status.getText());
            } else if (editor.toString().contains(" ÷ ")) {
                status.setText(calculateIntArray(editor.toString().split(" ÷ "), 4));
                editor = new StringBuilder(status.getText());
            }
        } else {
            TextView status = findViewById(R.id.status);
            if (editor.toString().contains(" + ")) {
                status.setText(calculateDoubleArray(editor.toString().split(" \\+ "), 1));
                editor = new StringBuilder(status.getText());
            } else if (editor.toString().contains(" - ")) {
                status.setText(calculateDoubleArray(editor.toString().split(" - "), 2));
                editor = new StringBuilder(status.getText());
            } else if (editor.toString().contains(" x ")) {
                status.setText(calculateDoubleArray(editor.toString().split(" x "), 3));
                editor = new StringBuilder(status.getText());
            } else if (editor.toString().contains(" ÷ ")) {
                status.setText(calculateDoubleArray(editor.toString().split(" ÷ "), 4));
                editor = new StringBuilder(status.getText());
            }
        }
    }

    @SuppressLint("DefaultLocale")
    public String calculateIntArray(String[] ob, int i) {
        int answer = 0;
        switch (i) {
            case 1:
                for (String o : ob) {
                    answer += Integer.parseInt(o);
                }
                break;
            case 2:
                answer = Integer.parseInt(ob[0]);
                for (int j = 1; j < ob.length; j++) {
                    answer -= Integer.parseInt(ob[j]);
                }
                break;
            case 3:
                answer = 1;
                for (String o : ob) {
                    answer *= Integer.parseInt(o);
                }
                break;
            case 4:
                double answer1 = Integer.parseInt(ob[0]);
                for (int j = 1; j < ob.length; j++) {
                    answer1 /= Integer.parseInt(ob[j]);
                }
                return String.format("%.2f", answer1);

        }
        return Integer.toString(answer);
    }

    @SuppressLint("DefaultLocale")
    public String calculateDoubleArray(String[] ob, int i) {
        double answer = 0;
        switch (i) {
            case 1:
                for (String o : ob) {
                    answer += Double.parseDouble(o);
                }
                break;
            case 2:
                answer = Double.parseDouble(ob[0]);
                for (int j = 1; j < ob.length; j++) {
                    answer -= Double.parseDouble(ob[j]);
                }
                break;
            case 3:
                answer = 1;
                for (String o : ob) {
                    answer *= Double.parseDouble(o);
                }
                break;
            case 4:
                answer = Double.parseDouble(ob[0]);
                for (int j = 1; j < ob.length; j++) {
                    answer /= Double.parseDouble(ob[j]);
                }
                break;
        }
        return String.format("%.2f", answer);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                Intent intent = new Intent(this,InfoActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}