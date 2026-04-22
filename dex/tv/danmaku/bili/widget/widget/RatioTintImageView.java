package tv.danmaku.bili.widget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.bilibili.bplus.followingcard.R;
import com.bilibili.magicasakura.widgets.TintImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RatioTintImageView.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0014R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/widget/widget/RatioTintImageView;", "Lcom/bilibili/magicasakura/widgets/TintImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRatioWidth", "mRatioHeight", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "followingCard_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RatioTintImageView extends TintImageView {
    public static final int $stable = 8;
    private int mRatioHeight;
    private int mRatioWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatioTintImageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRatioWidth = 1;
        this.mRatioHeight = 1;
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatioTintImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRatioWidth = 1;
        this.mRatioHeight = 1;
        init(context, attrs);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatioTintImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRatioWidth = 1;
        this.mRatioHeight = 1;
        init(context, attrs);
    }

    private final void init(Context context, AttributeSet attrs) {
        TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.RatioTintImageView);
        Intrinsics.checkNotNullExpressionValue(type, "obtainStyledAttributes(...)");
        this.mRatioWidth = type.getInt(R.styleable.RatioTintImageView_ratioWidth, 1);
        this.mRatioHeight = type.getInt(R.styleable.RatioTintImageView_ratioHeight, 1);
        type.recycle();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int viewWidth = getMeasuredWidth();
        int viewHeight = (this.mRatioHeight * viewWidth) / this.mRatioWidth;
        setMeasuredDimension(viewWidth, viewHeight);
    }
}