package com.tere.playground.apt;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.annotations.Command;
import com.annotations.CommandsMapFactory;
import com.mapper.CommandsMap;
import com.tere.playground.R;

/**
 * a test activity for annotation processing and Commands Map operations
 * <p>
 * Created by Ahmed Adel Ismail on 9/9/2017.
 */
@CommandsMapFactory
public class TestActivity extends Activity {

    private static final String TAG = TestActivity.class.getSimpleName();
    private CommandsMap commandsMap;
    private TextView tv_text;

    public TestActivity() {

        // initializing with reflections
        commandsMap = CommandsMap.of(this);

        // initializing without reflections :
        commandsMap = new com.tere.playground.apt.TestActivity$$CommandsMap();
        commandsMap.setCommandsMapFactory(this);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text = findViewById(R.id.tv_text);
        commandsMap.execute("0");
        commandsMap.execute(1L, "s1");
        commandsMap.execute(2, "s11", "s22");
    }

    @Command(keyString = "0")
    void printZero() {
        Log.d(TAG, "printZero()");
        tv_text.append("0");
    }

    @Command(keyLong = 1L)
    void printOne(String s) {
        Log.e(TAG, s);
        tv_text.append(s);

    }

    @Command(2)
    void printTwo(String s1, String s2) {
        String msg = s1 + s2;
        Log.e(TAG, msg);
        tv_text.append(msg);
    }


    @Override
    protected void onDestroy() {
        commandsMap.clear();
        super.onDestroy();
    }

    @VisibleForTesting
    public String collectedText() {
        return tv_text.getText().toString();
    }
}
