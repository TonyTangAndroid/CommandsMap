package com.tere.playground;

import static com.google.common.truth.Truth.assertThat;

import android.widget.TextView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.google.common.truth.Truth;
import com.tere.playground.apt.TestActivity;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Test
  public void androidEspressoTest() {
    try (ActivityScenario<TestActivity> scenario = ActivityScenario.launch(TestActivity.class)) {
      scenario.onActivity(activity -> {
        Truth.assertThat(((TextView) activity.findViewById(R.id.tv_text)).getText().toString())
            .isEqualTo("0s1s11s22");
        assertThat(activity.collectedText()).isEqualTo("0s1s11s22");
      });
    }
  }
}