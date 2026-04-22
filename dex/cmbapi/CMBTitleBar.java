package cmbapi;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class CMBTitleBar extends FrameLayout {
    private final Context a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f129c;

    public CMBTitleBar(Context context) {
        super(context);
        this.a = context;
        LayoutInflater.from(this.a).inflate(R.layout.cmbtitlebar, this);
        a();
    }

    public CMBTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        LayoutInflater.from(this.a).inflate(R.layout.cmbtitlebar, this);
        a();
    }

    public CMBTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        LayoutInflater.from(this.a).inflate(R.layout.cmbtitlebar, this);
        a();
    }

    private ColorFilter a(int i) {
        return new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    private void a() {
        this.b = (ImageView) findViewById(R.id.back);
        this.f129c = (TextView) findViewById(R.id.title);
        this.b.setColorFilter(a(Color.parseColor("#000000")));
    }

    public void setOnBackListener(View.OnClickListener onClickListener) {
        if (this.b != null) {
            this.b.setOnClickListener(onClickListener);
        }
    }

    public void setTitle(String str) {
        this.f129c.setText(str);
    }
}