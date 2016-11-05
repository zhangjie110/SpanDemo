package test.bwei.com.lianxizdyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangjie on 2016/11/5.
 */
public class ZdyView extends View {

    private Paint paint;
    private Paint paint1;

    public ZdyView(Context context) {
        super(context);
    }

    public ZdyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZdyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint=new Paint();
        paint.setColor(Color.RED);
        //消除锯齿
        paint.setAntiAlias(true);
        //空心圆
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(50);
        canvas.drawCircle(100,100,50,paint);

        paint1=new Paint();
        paint1.setColor(Color.GREEN);
        paint1.setTextSize(20);
        canvas.drawText("你好",80,100,paint1);


        Rect rect=new Rect(200,80,300,160);
        canvas.drawRect(rect,paint1);
    }
}
