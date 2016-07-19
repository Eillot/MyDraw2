package eliot.wakfo.com.mydraw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Eillot on 2016/7/19.
 *
 * Canvas作为绘图的直接对象，为我们提供了几个非常有用的方法:
 * 1)Canvas.save() ----用于保存画布，作用是将之前所有之前
 * 已经绘制的图形保存起来
 *
 * 2）Canvas.restore() -----用于将之前已经绘制好图片进行合并
 *
 *3）canvas.translate() ---平移画布
 *
 *4)canvas.rotate()----旋转画布
 *
 * 下面来看下实例----绘制仪表盘
 * 1)绘制外围大圆，2）绘制所有刻度  ，3）绘制刻度值 ,4)绘制指针
 */
public class CircleView extends View {



   private  int mWidth = getMeasuredWidth();
    private int mHeight = getMeasuredHeight();

    public CircleView(Context context) {
        super(context);

    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }



    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);
        //画外圆
        //画外围圆形
         int mWidth = getMeasuredWidth();
         int mHeight = getMeasuredHeight();
        Paint paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth( 5f );

        canvas.drawCircle(mWidth / 2 , mHeight / 2 ,mWidth /2 ,paintCircle);

        //画刻度
        Paint paintDegree = new Paint();
        paintCircle.setStrokeWidth(3f);
        for ( int i=0;i<24;i++){
            //区别整点与非整点
            if (i==0 || i==6 || i==12 || i== 18){
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);

                canvas.drawLine(mWidth / 2 , mHeight / 2 - mWidth/2,
                        mWidth / 2 , mHeight/2 - mWidth/2 + 60,paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree , mWidth / 2 - paintDegree.measureText(degree)/2,
                        mHeight / 2 - mWidth / 2 + 90 ,
                        paintDegree);
            }else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                canvas.drawLine(mWidth / 2 ,mHeight / 2 - mWidth / 2 ,
                       mWidth / 2 ,mHeight / 2 - mWidth / 2 + 30 ,
                        paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree , mWidth / 2 - paintDegree.measureText(degree)/2,
                        mHeight / 2 - mWidth /2 +60 ,paintDegree);
            }

            //通过旋转画布简化坐标运算
            canvas.rotate(15,mWidth/2 ,mHeight /2);
        }

        //画指针
        Paint paintHour = new Paint();
        paintHour.setStrokeWidth(20);

        Paint paintMinute = new Paint();
        paintMinute.setStrokeWidth(10);
        canvas.save();
        canvas.translate( mWidth / 2 , mHeight /2 );
        canvas.drawLine(0,0,100,100,paintHour);
        canvas.drawLine(0,0,100,200,paintMinute);
        canvas.restore();
    }
}
