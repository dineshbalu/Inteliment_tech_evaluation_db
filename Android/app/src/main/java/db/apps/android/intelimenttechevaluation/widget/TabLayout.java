package db.apps.android.intelimenttechevaluation.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import db.apps.android.intelimenttechevaluation.R;

/**
 * TODO: document your custom view class.
 */
public class TabLayout extends HorizontalScrollView {
    private CharSequence[] tabTitles; // TODO: use a default from R.string...

    LinearLayout childLayout;

    public TabLayout(Context context) {
        super(context);
        init(null, 0);
    }

    public TabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public TabLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.TabLayout, defStyle, 0);

        tabTitles = a.getTextArray(R.styleable.TabLayout_tabTitles);
        a.recycle();

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        childLayout = new LinearLayout( getContext() );
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.MATCH_PARENT );
        childLayout.setLayoutParams(lParams);
        childLayout.setOrientation(LinearLayout.HORIZONTAL);

        if( tabTitles != null && tabTitles.length > 0 ){

            for( int i=0;i<tabTitles.length;i++){

                Button btn = new Button(getContext() , null , android.R.style.Widget_DeviceDefault_Button_Borderless);
                lParams = new LinearLayout.LayoutParams( 0 , ViewGroup.LayoutParams.MATCH_PARENT , 1 );
                btn.setLayoutParams(lParams);


                btn.setText( tabTitles[i] );
                childLayout.addView(btn);

            }
        }

        addView( childLayout );

    }
}
