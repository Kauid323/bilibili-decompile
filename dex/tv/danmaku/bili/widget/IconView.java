package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

public class IconView extends AppCompatTextView {
    public static final String TAG = "IconView";
    private static IconInterceptorFactory sInterceptorFactory;
    private boolean loaded;
    private IconInterceptor mIconInterceptor;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IconInterceptor {
        boolean onSetText(CharSequence charSequence, TextView.BufferType bufferType, IconView iconView);

        void onTextColorChanged(IconView iconView);

        void onTextSizeChanged(IconView iconView, float f);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IconInterceptorFactory {
        IconInterceptor newInterceptor();
    }

    public static void init(IconInterceptorFactory interceptorFactory) {
        sInterceptorFactory = interceptorFactory;
    }

    public IconView(Context context) {
        super(context);
        this.loaded = false;
        init(context);
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.loaded = false;
        init(context);
    }

    public IconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.loaded = false;
        init(context);
    }

    private void init(Context context) {
        try {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "iconfont/iconfont.ttf");
            if (typeface != null) {
                setTypeface(typeface);
            }
            this.loaded = true;
        } catch (Exception e) {
        }
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void superSetText(CharSequence txt, TextView.BufferType type) {
        super.setText(txt, type);
    }

    public void setText(CharSequence txt, TextView.BufferType type) {
        if (this.mIconInterceptor == null && sInterceptorFactory != null) {
            this.mIconInterceptor = sInterceptorFactory.newInterceptor();
        }
        if (this.mIconInterceptor == null || !this.mIconInterceptor.onSetText(txt, type, this)) {
            superSetText(txt, type);
        }
    }

    public void setTextSize(float size) {
        super.setTextSize(size);
        if (this.mIconInterceptor != null) {
            this.mIconInterceptor.onTextSizeChanged(this, size);
        }
    }

    public void setTextColor(int color) {
        super.setTextColor(color);
        if (this.mIconInterceptor != null) {
            this.mIconInterceptor.onTextColorChanged(this);
        }
    }

    public void setTextColor(ColorStateList colors) {
        super.setTextColor(colors);
        if (this.mIconInterceptor != null) {
            this.mIconInterceptor.onTextColorChanged(this);
        }
    }

    public IconInterceptor getIconInterceptor() {
        return this.mIconInterceptor;
    }

    public void setIconInterceptor(IconInterceptor iconInterceptor) {
        this.mIconInterceptor = iconInterceptor;
    }
}