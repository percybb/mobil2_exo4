package com.example.ecran.MyViews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class Termometro extends View {

    public int valini;

    @Override
    protected void onDraw(Canvas canvas) {  //permitira diseñar nuestro control
        super.onDraw(canvas);
        int heigth = this.getHeight();
        int width = this.getWidth();
        float xs = (float)width/2.0f;
        float ys = (float)heigth-100.0f;
        float xf = ((float)width/2.0f);
        float yf = ys - (valini*10) - 600;


        Paint pinceau = new Paint(10);
        pinceau.setStrokeWidth(5);
        pinceau.setColor(Color.rgb(255,0,0));

        canvas.drawRect (xs-10,ys,xf+10,yf,pinceau);
        canvas.drawCircle(xs,ys,40,pinceau);

        Paint paint = new Paint();
        paint.setColor(Color.rgb(0,0,0));
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(45);
        paint.setStrokeWidth(3);
        paint.setTypeface(Typeface.SERIF);

        canvas.drawRect(xs-200,ys+60,xf+200,90,paint);

        Paint pline = new Paint();
        paint.setColor(Color.rgb(0,0,0));
        paint.setStrokeWidth(5);

        canvas.drawText("°C",xs - 150, 150,paint);
        canvas.drawText("°F",xs + 80, 150,paint);

        for(int i=-5; i<=10; i++)  //afficher des valeurs °C
        {
            float y2= ys - 600 - (i*100);
            canvas.drawRect(xs - 30, y2- 3, xs - 150,y2 + 3,pline );
            canvas.drawText(String.valueOf(i*10)+"°", xs-170, y2 - 20, paint);
            for(int j=0; j<5; j++)
            {
                canvas.drawRect(xs - 30,y2 - 3 - (j*20), xs - 60,y2+ 3 -(j*20),pline );
            }
        }

        for(int i=-5; i<=22; i++) //afficher des valeurs °F
        {
            float y1= ys - 600 - Math.round(((5.5556*i*10)-177.78 )) ;

            if((i % 2) == 0 )
            {
                canvas.drawText(String.valueOf(i*10)+"°", xs+90, y1 - 10, paint);
                canvas.drawRect(xs + 30,y1 - 3, xs + 150,y1 + 3,pline );
            }
            else{
                canvas.drawRect(xs + 30,y1 - 3, xs + 80,y1 + 3,pline );
            }

            for(int j=0; j<5; j++)
            {
                canvas.drawRect(xs + 30,y1 - 2 - (j*11), xs + 60,y1 + 2 -(j*11),pline );
            }
        }
    }

    public void setValini(int valini) {
        if (valini>=-50)
        {
            this.valini = valini;
        }
        else{

            this.valini = -50;
        }
        invalidate();
    }

    public Termometro(Context context, int tempInit) {
        super(context);
        valini=tempInit;
    }
}
