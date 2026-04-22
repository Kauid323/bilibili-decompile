package view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.bilibili.magicasakura.widgets.TintTextView;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TextViewLineSpacingFix.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lview/TextViewLineSpacingFix;", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRect", "Landroid/graphics/Rect;", "getMRect", "()Landroid/graphics/Rect;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "followingCard_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TextViewLineSpacingFix extends TintTextView {
    public static final int $stable = 8;
    private final Rect mRect;

    public final Rect getMRect() {
        return this.mRect;
    }

    public TextViewLineSpacingFix(Context context) {
        super(context);
        this.mRect = new Rect();
    }

    public TextViewLineSpacingFix(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRect = new Rect();
    }

    public TextViewLineSpacingFix(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mRect = new Rect();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getLineCount() > 0) {
            int baseline = getLineBounds(getLineCount() - 1, this.mRect);
            int result = 0;
            if (getMeasuredHeight() == getLayout().getHeight() + getPaddingBottom() + getPaddingTop()) {
                result = this.mRect.bottom - (getLayout().getPaint().getFontMetricsInt().descent + baseline);
            }
            if (result > 0) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() - result);
            }
        }
    }
}