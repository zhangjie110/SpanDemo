package test.bwei.com.spandemo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv1=(TextView) findViewById(R.id.tv1);
        tv2=(TextView) findViewById(R.id.tv2);
        tv3=(TextView) findViewById(R.id.tv3);
        tv4=(TextView) findViewById(R.id.tv4);
        tv5=(TextView) findViewById(R.id.tv5);

        setTv1();
        setTv2();
        setTv3();
        setTv5();
    }
    private void setTv3() {
        //SpannableString与SpannableStringBuilder区别
        //使用SpannableString，必须一次传入，构造完成
        // 1.BackgroundColorSpan 背景色
        SpannableString word = new SpannableString("迭代是最好的老师！");
        word.setSpan(new BackgroundColorSpan(Color.GREEN), 0, word.length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv4.append("\n");
        tv4.append(word);
        //ClickableSpan 文本可点击，有点击事件
        word = new SpannableString("每天进步一点点- http://orgcent.com");
        word.setSpan(new ForegroundColorSpan(Color.BLUE), 6, word.length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv4.append("\n");
        tv4.append(word);

        //使用SpannableStringBuilder,可以使用append()再添加 别的用法和SpannableString一致
        SpannableStringBuilder multiWord = new SpannableStringBuilder();
        multiWord.append("欢迎光临");
        multiWord.append("Harvic的");
        multiWord.append("博客");

        StyleSpan span = new StyleSpan(Typeface.BOLD_ITALIC);
        multiWord.setSpan(span, 0, multiWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv3.setText(multiWord);
    }

    private void setTv2() {
        SpannableString ss = new SpannableString("图片：.");//.作为占位符 用来显示图片
        //获取Drawable资源
        Drawable d = getResources().getDrawable(R.mipmap.ic_launcher);
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        //创建ImageSpan
        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
        //提供了不同类型图片的构造方法
        //用ImageSpan替换文本
        ss.setSpan(span, 3, 4, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        tv2.setText(ss);
    }

    private void setTv1() {
        //SpannableString文本类，包含不可变的文本但可以用已有对象替换和分离。
        //可变文本类参考SpannableStringBuilder
        SpannableString ss = new SpannableString("红色打电话斜体删除线绿色下划线.");
        System.out.println("length:"+ss.length());
        //不同的Span类 参考http://www.cnblogs.com/jisheng/archive/2013/01/10/2854088.html


        //用颜色标记文本
        ss.setSpan(new ForegroundColorSpan(Color.RED),0,2,
                //setSpan时需要指定的 flag,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括).
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用超链接标记文本
        ss.setSpan(new URLSpan("tel:4155551212"), 2, 5,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用样式标记文本（斜体）
        ss.setSpan(new StyleSpan(Typeface.ITALIC), 5, 7,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用删除线标记文本
        ss.setSpan(new StrikethroughSpan(), 7, 10,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用下划线标记文本
        ss.setSpan(new UnderlineSpan(), 10, 16,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用颜色标记
        ss.setSpan(new ForegroundColorSpan(Color.GREEN), 10, 13,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv1.setText(ss);

    }
    private void setTv5() {
        //创建SpannableString对象,内容不可修改
        SpannableString ss=new SpannableString("字体测试字体绝对大小相对大小缩放大小" +
                "前景颜色背景颜色字体样式下划线删除线上标X2下标Y3链接" +
                "字体外表图图图图");
        //使用setSpan()方法设置标记对象
        //使用removeSpan()解绑标记对象
        //public void setSpan (Object what, int start, int end, int flags)
        //绑定特定的标记对象（Object what）到起始为start，终止为end的text对象上(若已绑定标记对象则先移除)
        //设置字体TypefaceSpan()
        //设置字体大小(绝对值)AbsoluteSizeSpan()
        //设置字体大小(相对值)RelativeSizeSpan()
        //设置字体大小(相对值,默认字体宽度的倍数)ScaleXSpan()
        //设置字体的前景色ForegroundColorSpan()
        //设置字体的背景色BackgroundColorSpan()
        //设置字体的样式StyleSpan()
        //设置下划线UnderlineSpan()
        //删除线StrikethroughSpan()
        //上标SuperscriptSpan()
        //下标SubscriptSpan()
        //链接URLSpan()-->需要添加setMovementMethod方法附加响应
        //字体外观设置（依次包括字体名称，字体大小，字体样式，字体颜色，链接颜色)TextAppearanceSpan()
        //项目符号BulletSpan()
        //图片ImageSpan()

        //设置字体(default,default-bold,monospace,serif,sans-serif)
        ss.setSpan(new TypefaceSpan("sans-serif"),0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new AbsoluteSizeSpan(30,true),4,10,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new RelativeSizeSpan(0.5f),10,14,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        ss.setSpan(new ScaleXSpan(1.5f),14,18,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE),18,22,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new BackgroundColorSpan(Color.YELLOW),22,26,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new StyleSpan(Typeface.BOLD),26,30,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new UnderlineSpan(),30,33,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new StrikethroughSpan(),33,36,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new SuperscriptSpan(),39,40,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new SubscriptSpan(),43,44,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new URLSpan("http://www.baidu.com"),44,46,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        ColorStateList color = null;
        ColorStateList linkColor = null;

        /*XmlResourceParser parser = getResources().getXml(R.drawable.colorselector);
        try {
            color = ColorStateList.createFromXml(getResources(),parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            linkColor = ColorStateList.createFromXml(getResources(),parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        ss.setSpan(new TextAppearanceSpan("serif",Typeface.BOLD_ITALIC,40,color,linkColor),46,50,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        ss.setSpan(new ImageSpan(drawable), 50, 54, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new BulletSpan(BulletSpan.STANDARD_GAP_WIDTH,Color.RED),0,ss.length(),Spanned.SPAN_COMPOSING);
        tv5.setMovementMethod(LinkMovementMethod.getInstance());
        tv5.setText(ss);
    }
}
