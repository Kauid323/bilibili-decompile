package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintTextView;

public class VectorTextView extends TintTextView {
    private int[] mCompoundDrawableHeight;
    private int[] mCompoundDrawableResIds;
    private int[] mCompoundDrawableTintResIds;
    private int[] mCompoundDrawableWidth;

    public VectorTextView(Context context) {
        this(context, null);
    }

    public VectorTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 16842884);
    }

    public VectorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mCompoundDrawableResIds = new int[4];
        this.mCompoundDrawableTintResIds = new int[4];
        this.mCompoundDrawableWidth = new int[4];
        this.mCompoundDrawableHeight = new int[4];
        loadFromAttribute(context, attrs, defStyleAttr);
    }

    void loadFromAttribute(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.VectorTextView, defStyleAttr, 0);
        this.mCompoundDrawableResIds[0] = a.getResourceId(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableLeft, 0);
        this.mCompoundDrawableTintResIds[0] = a.getResourceId(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableLeftTint, 0);
        this.mCompoundDrawableWidth[0] = a.getDimensionPixelOffset(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableLeftWidth, 0);
        this.mCompoundDrawableHeight[0] = a.getDimensionPixelOffset(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableLeftHeight, 0);
        this.mCompoundDrawableResIds[1] = a.getResourceId(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableTop, 0);
        this.mCompoundDrawableTintResIds[1] = a.getResourceId(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableTopTint, 0);
        this.mCompoundDrawableWidth[1] = a.getDimensionPixelOffset(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableTopWidth, 0);
        this.mCompoundDrawableHeight[1] = a.getDimensionPixelOffset(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableTopHeight, 0);
        this.mCompoundDrawableResIds[2] = a.getResourceId(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableRight, 0);
        this.mCompoundDrawableTintResIds[2] = a.getResourceId(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableRightTint, 0);
        this.mCompoundDrawableWidth[2] = a.getDimensionPixelOffset(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableRightWidth, 0);
        this.mCompoundDrawableHeight[2] = a.getDimensionPixelOffset(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableRightHeight, 0);
        this.mCompoundDrawableResIds[3] = a.getResourceId(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableBottom, 0);
        this.mCompoundDrawableTintResIds[3] = a.getResourceId(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableBottomTint, 0);
        this.mCompoundDrawableWidth[3] = a.getDimensionPixelOffset(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableBottomWidth, 0);
        this.mCompoundDrawableHeight[3] = a.getDimensionPixelOffset(com.bilibili.lib.widget.R.styleable.VectorTextView_vtvDrawableBottomHeight, 0);
        a.recycle();
        setDrawables(context);
    }

    private void setDrawables(Context context) {
        setCompoundDrawables(createVectorDrawable(context, this.mCompoundDrawableResIds[0], this.mCompoundDrawableTintResIds[0], this.mCompoundDrawableWidth[0], this.mCompoundDrawableHeight[0]), createVectorDrawable(context, this.mCompoundDrawableResIds[1], this.mCompoundDrawableTintResIds[1], this.mCompoundDrawableWidth[1], this.mCompoundDrawableHeight[1]), createVectorDrawable(context, this.mCompoundDrawableResIds[2], this.mCompoundDrawableTintResIds[2], this.mCompoundDrawableWidth[2], this.mCompoundDrawableHeight[2]), createVectorDrawable(context, this.mCompoundDrawableResIds[3], this.mCompoundDrawableTintResIds[3], this.mCompoundDrawableWidth[3], this.mCompoundDrawableHeight[3]));
    }

    private Drawable createVectorDrawable(Context context, int vectorDrawableID, int colorID, int width, int height) {
        if (vectorDrawableID == 0) {
            return null;
        }
        Drawable vectorDrawable = VectorDrawableCompat.create(context.getResources(), vectorDrawableID, context.getTheme());
        if (colorID != 0) {
            vectorDrawable = ThemeUtils.tintDrawable(vectorDrawable, ThemeUtils.getColorById(context, colorID, getViewThemeId()));
        }
        if (vectorDrawable != null) {
            int w = width == 0 ? vectorDrawable.getIntrinsicWidth() : width;
            int h = height == 0 ? vectorDrawable.getIntrinsicHeight() : height;
            vectorDrawable.setBounds(0, 0, w, h);
        }
        return vectorDrawable;
    }

    public void setLeftCompoundDrawable(int vectorDrawableID, int colorID, int width, int height) {
        this.mCompoundDrawableResIds[0] = vectorDrawableID;
        this.mCompoundDrawableTintResIds[0] = colorID;
        this.mCompoundDrawableWidth[0] = width;
        this.mCompoundDrawableHeight[0] = height;
        setDrawables(getContext());
    }

    public void setTopCompoundDrawable(int vectorDrawableID, int colorID, int width, int height) {
        this.mCompoundDrawableResIds[1] = vectorDrawableID;
        this.mCompoundDrawableTintResIds[1] = colorID;
        this.mCompoundDrawableWidth[1] = width;
        this.mCompoundDrawableHeight[1] = height;
        setDrawables(getContext());
    }

    public void setRightCompoundDrawable(int vectorDrawableID, int colorID, int width, int height) {
        this.mCompoundDrawableResIds[2] = vectorDrawableID;
        this.mCompoundDrawableTintResIds[2] = colorID;
        this.mCompoundDrawableWidth[2] = width;
        this.mCompoundDrawableHeight[2] = height;
        setDrawables(getContext());
    }

    public void setBottomCompoundDrawable(int vectorDrawableID, int colorID, int width, int height) {
        this.mCompoundDrawableResIds[3] = vectorDrawableID;
        this.mCompoundDrawableTintResIds[3] = colorID;
        this.mCompoundDrawableWidth[3] = width;
        this.mCompoundDrawableHeight[3] = height;
        setDrawables(getContext());
    }

    public void setVectorDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        setCompoundDrawables(left, top, right, bottom);
    }

    public void tint() {
        super.tint();
        setDrawables(getContext());
    }
}