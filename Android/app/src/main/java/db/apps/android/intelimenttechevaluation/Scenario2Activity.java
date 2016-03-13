package db.apps.android.intelimenttechevaluation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import db.apps.android.intelimenttechevaluation.model.TransportData;
import retrofit.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class Scenario2Activity extends AppCompatActivity {


    public interface TransportService {
        @GET("sample.json")
        Call<List<TransportData>> getTransportDatas();
    }

    List<TransportData> datas;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario2);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://express-it.optusnet.com.au/")
                .build();

        TransportService service = retrofit.create(TransportService.class);

        Call<List<TransportData>> call = service.getTransportDatas();

        call.enqueue(new Callback<List<TransportData>>() {
            @Override
            public void onResponse(Call<List<TransportData>> call, Response<List<TransportData>> response) {
                if (response.isSuccessful() ) {
                    // tasks available
                    datas = response.body();

                    initWithData();
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<List<TransportData>> call, Throwable t) {
                // something went completely south (like no internet connection)
            }
        });

    }

    private void initWithData(){


        spinner = (Spinner) findViewById( R.id.spinner);
        spinner.setAdapter( new TransportAdapter( this , 0 ));
    }

    private class TransportAdapter extends ArrayAdapter<TransportData>{

        public TransportAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if( convertView == null )
                convertView = LayoutInflater.from(getContext()).inflate( android.R.layout.simple_spinner_dropdown_item , parent , false );

            TextView textView = (TextView)convertView.findViewById(android.R.id.text1 );
                    textView.setText( datas.get(position).name );

            return convertView;
        }
    }
}
