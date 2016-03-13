package db.apps.android.intelimenttechevaluation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.EventListener;

/**
 * Created by dineshbalu on 13/03/16.
 */
public class IPageFragment extends Fragment {

    public interface IPageListener extends EventListener{
        public void onClick( String message );
    }

    public static final String TITLE = "title";
    public static final String COLOR = "color";

    IPageListener mListener;

    String title;
    int color;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();
        if( b != null )
        {
            title = b.getString( TITLE );
            color = b.getInt( COLOR );
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView view = new TextView( getContext() );
        view.setGravity(Gravity.CENTER );
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tView = (TextView)view;

        tView.setText(title);
        tView.setBackgroundColor( getContext().getResources().getColor( color ) );

        tView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( mListener != null )
                    mListener.onClick( title );
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if( context instanceof IPageListener ){
            mListener = (IPageListener)context;
        }

    }
}
