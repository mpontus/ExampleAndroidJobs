package app.example.schedulers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import app.example.schedulers.utils.NotificationUtils;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    NotificationUtils.showNotification(this);
  }
}
