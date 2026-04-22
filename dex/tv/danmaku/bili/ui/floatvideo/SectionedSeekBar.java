package tv.danmaku.bili.ui.floatvideo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import tv.danmaku.biliplayer.baseres.R;

public class SectionedSeekBar extends AppCompatSeekBar {
    private static final int MAX_PER_SECTION = 100;
    private Adapter mAdapter;
    private float[] mBaseX;
    private int mColor;
    private SectionChangedListener mListener;
    private Paint mPointPaint;
    private float mRadius;
    private int mSection;
    private int mSeekBarHeight;
    private int mSelectedTextColor;
    private int mSpace;
    private int mTextColor;
    private Paint mTextPaint;
    private int mTextSize;
    private Drawable mThumb;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface Adapter {
        String getText(int i);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface SectionChangedListener {
        void onSectionedChanged(int i);
    }

    public SectionedSeekBar(Context context) {
        super(context);
    }

    public SectionedSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SectionedSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SectionedSeekBar);
        this.mSection = a.getInt(R.styleable.SectionedSeekBar_sectionCount, 0);
        this.mColor = a.getColor(R.styleable.SectionedSeekBar_sectionPointColor, -1);
        this.mRadius = a.getDimension(R.styleable.SectionedSeekBar_sectionPointSize, 0.0f) / 2.0f;
        this.mSpace = a.getDimensionPixelSize(R.styleable.SectionedSeekBar_space, 24);
        this.mTextSize = a.getDimensionPixelSize(R.styleable.SectionedSeekBar_textSize, 30);
        this.mTextColor = a.getColor(R.styleable.SectionedSeekBar_textColor, -1);
        this.mSelectedTextColor = a.getColor(R.styleable.SectionedSeekBar_selectedTextColor, -16777216);
        this.mSeekBarHeight = a.getDimensionPixelSize(R.styleable.SectionedSeekBar_seekBarHeight, 10);
        int defaultSection = a.getInt(R.styleable.SectionedSeekBar_defaultSection, 0);
        this.mBaseX = new float[this.mSection + 1];
        a.recycle();
        setMax(this.mSection * 100);
        setSelectedSection(defaultSection);
        setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: tv.danmaku.bili.ui.floatvideo.SectionedSeekBar.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                int section = SectionedSeekBar.this.getSection(seekBar.getProgress());
                seekBar.setProgress(section * 100);
                if (SectionedSeekBar.this.mListener != null) {
                    SectionedSeekBar.this.mListener.onSectionedChanged(section);
                }
            }
        });
    }

    public void setSectionedPointColor(int color) {
        this.mColor = color;
    }

    public void setSectionedPointSize(int radius) {
        this.mRadius = radius;
    }

    public void setSectionCount(int sectionCount) {
        this.mSection = Math.min(0, sectionCount);
    }

    public void setSpace(int space) {
        this.mSpace = space;
    }

    public void setTextSize(int textSize) {
        this.mTextSize = textSize;
    }

    public void setAdapter(Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void setSelectedSection(int section) {
        if (section >= 0 && section <= this.mSection) {
            setProgress(section * 100);
        }
    }

    public void setOnSectionChangedListener(SectionChangedListener listener) {
        this.mListener = listener;
    }

    public void setThumb(Drawable thumb) {
        super.setThumb(thumb);
        this.mThumb = thumb;
    }

    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        int newHeight = (this.mTextSize * 2) + height + this.mSpace;
        setMeasuredDimension(width, newHeight);
    }

    protected synchronized void onDraw(Canvas canvas) {
        int topHeight = (this.mTextSize * 2) + this.mSpace;
        int height = getHeight();
        float translateY = Math.abs(topHeight - (height - topHeight));
        canvas.translate(0.0f, translateY);
        if (this.mSection > 0 && this.mRadius > 0.0f) {
            drawSectionPoint(canvas);
        }
        int centerY = getHeight() / 2;
        if (this.mThumb != null) {
            Rect thumbRect = this.mThumb.getBounds();
            int thumbHeight = thumbRect.height();
            this.mThumb.setBounds(thumbRect.left, centerY - (thumbHeight / 2), thumbRect.right, (thumbHeight / 2) + centerY);
        }
        Rect rect = getProgressDrawable().getBounds();
        getProgressDrawable().setBounds(rect.left, centerY - (this.mSeekBarHeight / 2), rect.right, (this.mSeekBarHeight / 2) + centerY);
        super.onDraw(canvas);
        canvas.translate(0.0f, -translateY);
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        float baseY;
        int i;
        if (this.mAdapter == null) {
            return;
        }
        int topHeight = (this.mTextSize * 2) + this.mSpace;
        if (this.mTextPaint == null) {
            this.mTextPaint = new Paint(1);
            this.mTextPaint.setColor(-1);
            this.mTextPaint.setStyle(Paint.Style.FILL);
            this.mTextPaint.setTextSize(this.mTextSize);
        }
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        int section = getSection(getProgress());
        for (int i2 = 0; i2 <= this.mSection; i2++) {
            String text = this.mAdapter.getText(i2);
            float textWidth = this.mTextPaint.measureText(text);
            float baseX = this.mBaseX[i2] - (textWidth / 2.0f);
            if (section == i2) {
                this.mTextPaint.setColor(this.mSelectedTextColor);
                baseY = topHeight - fontMetrics.descent;
                i = this.mSpace * 2;
            } else {
                this.mTextPaint.setColor(this.mTextColor);
                baseY = topHeight - fontMetrics.descent;
                i = this.mSpace;
            }
            canvas.drawText(text, baseX, baseY - i, this.mTextPaint);
        }
    }

    private void drawSectionPoint(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int drawWidth = (getWidth() - paddingLeft) - paddingRight;
        int seekBarHeight = getHeight();
        int cy = seekBarHeight / 2;
        if (this.mPointPaint == null) {
            this.mPointPaint = new Paint(1);
            this.mPointPaint.setColor(this.mColor);
            this.mPointPaint.setStyle(Paint.Style.FILL);
        }
        for (int i = 0; i <= this.mSection; i++) {
            this.mBaseX[i] = ((i * drawWidth) / this.mSection) + paddingLeft;
            canvas.drawCircle(this.mBaseX[i], cy, this.mRadius, this.mPointPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSection(int progress) {
        int section = progress / 100;
        int mod = progress % 100;
        if (mod >= 50) {
            return section + 1;
        }
        return section;
    }
}