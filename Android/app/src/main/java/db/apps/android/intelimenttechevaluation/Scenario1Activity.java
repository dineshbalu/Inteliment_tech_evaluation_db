package db.apps.android.intelimenttechevaluation;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Scenario1Activity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    TextView tabSelectionLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab( tabLayout.newTab().setText("Item 1"));
        tabLayout.addTab( tabLayout.newTab().setText("Item 2"));
        tabLayout.addTab( tabLayout.newTab().setText("Item 3"));
        tabLayout.addTab( tabLayout.newTab().setText("Item 4"));
        tabLayout.addTab( tabLayout.newTab().setText("Item 5"));

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        tabLayout.setOnTabSelectedListener(this);

        tabSelectionLabel = (TextView) findViewById( R.id.tabSelectionLabel);
        tabSelectionLabel.setText("Item 1");

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        tabSelectionLabel.setText( tab.getText() );

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
