package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;

public class BannerIndicator extends View implements Tintable, ViewPager.OnPageChangeListener {
    private int mCurrentPage;
    private int mIndicatorColorSelectedId;
    private int mIndicatorColorUnSelectedId;
    private ViewPager.OnPageChangeListener mListener;
    private float mOffset;
    private Paint mPaintPageFill;
    private Paint mPaintPink;
    private float mRadius;
    private int mRealSize;
    private int mScrollState;
    private ViewPager mViewPager;

    public BannerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCurrentPage = 0;
        TypedArray array = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.BannerIndicator);
        if (array != null) {
            float dp3 = TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
            this.mRadius = array.getDimension(com.bilibili.lib.widget.R.styleable.BannerIndicator_radius, dp3);
            this.mOffset = array.getDimension(com.bilibili.lib.widget.R.styleable.BannerIndicator_offset, dp3);
            this.mIndicatorColorSelectedId = array.getResourceId(com.bilibili.lib.widget.R.styleable.BannerIndicator_colorId, com.bilibili.app.comm.baseres.R.color.theme_color_primary);
            this.mIndicatorColorUnSelectedId = array.getResourceId(com.bilibili.lib.widget.R.styleable.BannerIndicator_colorNoSelectId, com.bilibili.app.comm.baseres.R.color.white);
            array.recycle();
        }
        this.mPaintPageFill = new Paint();
        this.mPaintPageFill.setStyle(Paint.Style.FILL);
        this.mPaintPageFill.setColor(context.getResources().getColor(this.mIndicatorColorUnSelectedId));
        this.mPaintPageFill.setAntiAlias(true);
        this.mPaintPink = new Paint();
        this.mPaintPink.setStyle(Paint.Style.FILL);
        this.mPaintPink.setAntiAlias(true);
        invalidatePaint();
    }

    private void invalidatePaint() {
        if (this.mIndicatorColorSelectedId != 0) {
            this.mPaintPink.setColor(ThemeUtils.getColorById(getContext(), this.mIndicatorColorSelectedId));
            invalidate();
        }
    }

    public void setRealSize(int count) {
        this.mRealSize = count;
        requestLayout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int count;
        super.onDraw(canvas);
        if (this.mViewPager == null || (count = this.mViewPager.getAdapter().getCount()) == 0 || this.mRealSize == 0) {
            return;
        }
        if (this.mCurrentPage >= count) {
            setCurrentItem(count - 1);
            return;
        }
        float yOffset = getPaddingTop() + this.mRadius;
        for (int iLoop = 0; iLoop < this.mRealSize; iLoop++) {
            float dX = getCurrentOffsetX(iLoop);
            if (this.mPaintPageFill.getAlpha() > 0) {
                canvas.drawCircle(dX, yOffset, this.mRadius, this.mPaintPageFill);
            }
        }
        int iLoop2 = this.mRealSize;
        int current = iLoop2 == 0 ? this.mCurrentPage : this.mCurrentPage % this.mRealSize;
        float dX2 = getCurrentOffsetX(current);
        canvas.drawCircle(dX2, yOffset, this.mRadius, this.mPaintPink);
    }

    private int getCurrentOffsetX(int current) {
        return (int) (getPaddingLeft() + (current * ((this.mRadius * 2.0f) + this.mOffset)) + this.mRadius);
    }

    public void setViewPager(ViewPager view2) {
        if (this.mViewPager == view2) {
            return;
        }
        if (this.mViewPager != null) {
            this.mViewPager.removeOnPageChangeListener(this);
        }
        if (view2.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.mViewPager = view2;
        this.mViewPager.addOnPageChangeListener(this);
        invalidate();
    }

    public void setViewPager(ViewPager view2, int initialPosition) {
        setViewPager(view2);
        setCurrentItem(initialPosition);
    }

    public void setCurrentItem(int item) {
        if (this.mViewPager == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.mViewPager.setCurrentItem(item, Math.abs(this.mCurrentPage - item) == 1);
        this.mCurrentPage = item;
        invalidate();
    }

    public void notifyDataSetChanged() {
        invalidate();
    }

    public void onPageScrollStateChanged(int state) {
        this.mScrollState = state;
        if (this.mListener != null) {
            this.mListener.onPageScrollStateChanged(state);
        }
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (this.mListener != null) {
            this.mListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    public void onPageSelected(int position) {
        this.mCurrentPage = position;
        invalidate();
        if (this.mListener != null) {
            this.mListener.onPageSelected(position);
        }
    }

    public boolean isScrollIdle() {
        return this.mScrollState == 0;
    }

    public int getCurrentPage() {
        return this.mCurrentPage;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.mListener = listener;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    private int measureWidth(int measureSpec) {
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824 || this.mViewPager == null) {
            return specSize;
        }
        int count = this.mRealSize == 0 ? this.mViewPager.getAdapter().getCount() : this.mRealSize;
        int result = (int) (getPaddingLeft() + getPaddingRight() + (count * 2 * this.mRadius) + ((count - 1) * this.mOffset));
        if (specMode == Integer.MIN_VALUE) {
            return Math.min(result, specSize);
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824) {
            return specSize;
        }
        int result = (int) ((this.mRadius * 2.0f) + getPaddingTop() + getPaddingBottom());
        if (specMode == Integer.MIN_VALUE) {
            return Math.min(result, specSize);
        }
        return result;
    }

    public void setFillColor(int color) {
        this.mPaintPageFill.setColor(color);
    }

    public void setIndicatorColorId(int colorId) {
        this.mIndicatorColorSelectedId = colorId;
        invalidatePaint();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentPage = savedState.currentPage;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState savedState = new SavedState(superState);
        savedState.currentPage = this.mCurrentPage;
        return savedState;
    }

    public void tint() {
        invalidatePaint();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: tv.danmaku.bili.widget.BannerIndicator.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int currentPage;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.currentPage = in.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentPage);
        }
    }
}