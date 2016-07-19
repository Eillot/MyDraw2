package eliot.wakfo.com.mydraw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView( new CircleView(this));
        setContentView(R.layout.activity_main);

    }

    public void btnColorMatrix(View view) {
        startActivity(new Intent(this, ColorMatrix.class));
    }


}
