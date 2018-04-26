package cn.edu.gdmec.android.fragmentapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        fragment1=new FragmentTest1();
        transaction.add(R.id.container,fragment1);
        transaction.commit();

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getFragmentManager();
                FragmentTransaction transaction1=fm.beginTransaction();
                Fragment f2=new FragmentTest2();
                transaction1.replace(R.id.container,f2);
                transaction1.addToBackStack(null);
                transaction1.commit();
            }
        });
    }
}
