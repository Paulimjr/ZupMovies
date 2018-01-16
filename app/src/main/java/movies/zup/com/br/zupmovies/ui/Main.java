package movies.zup.com.br.zupmovies.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import movies.zup.com.br.zupmovies.R;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(Main.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
