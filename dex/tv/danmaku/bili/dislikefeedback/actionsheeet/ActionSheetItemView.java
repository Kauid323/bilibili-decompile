package tv.danmaku.bili.dislikefeedback.actionsheeet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.dislikefeedback.data.DislikeReason;
import tv.danmaku.bili.dislikefeedback.utils.DislikeFeedbackHelper;
import tv.danmaku.biliplayer.baseres.R;

/* compiled from: ActionSheetItemView.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;J\u0012\u0010<\u001a\u0002092\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u000209H\u0016J\u0012\u0010@\u001a\u0002092\b\u00102\u001a\u0004\u0018\u00010-H\u0002J0\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nH\u0014J\u0010\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020IH\u0014J\u0012\u00107\u001a\u0002092\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\b\u0010L\u001a\u00020MH\u0002J\u0012\u0010N\u001a\u0002092\b\u0010H\u001a\u0004\u0018\u00010IH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001c\u00105\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101¨\u0006O"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/actionsheeet/ActionSheetItemView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIconLeftPx", "", "mMarginRightPx", "mIcon", "Landroid/graphics/drawable/Drawable;", "mIconWidthPx", "mIconHeightPx", "mSubIconWidthPx", "mSubIconHeightPx", "mTitleMarginLeftPx", "mTitleMarginRightPx", "mTitleTextSize", "mBottomLineStrokeWidth", "mIconTopPx", "mIconBottomPx", "mIconRightPx", "mSubIcon", "mSubIconTopPx", "mSubIconLeftPx", "mSubIconRightPx", "mSubIconBottomPx", "defaultDrawableResId", "getDefaultDrawableResId", "()I", "setDefaultDrawableResId", "(I)V", "shouldDrawBottomLine", "", "getShouldDrawBottomLine", "()Z", "setShouldDrawBottomLine", "(Z)V", "recognizedName", "", "getRecognizedName", "()Ljava/lang/String;", "setRecognizedName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", ReportUtilKt.POS_TITLE, "getTitle", "setTitle", "setData", "", "data", "Ltv/danmaku/bili/dislikefeedback/data/DislikeReason$ActionSheet;", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "onClick", "displayIcon", "onLayout", "changed", "left", "top", "right", "bottom", "onDraw", "canvas", "Landroid/graphics/Canvas;", "text", "", "getBottomLinePaint", "Landroid/graphics/Paint;", "drawBottomLine", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ActionSheetItemView extends AppCompatTextView {
    private int defaultDrawableResId;
    private String iconUrl;
    private final float mBottomLineStrokeWidth;
    private Drawable mIcon;
    private float mIconBottomPx;
    private final float mIconHeightPx;
    private final float mIconLeftPx;
    private float mIconRightPx;
    private float mIconTopPx;
    private final float mIconWidthPx;
    private final float mMarginRightPx;
    private Drawable mSubIcon;
    private float mSubIconBottomPx;
    private final float mSubIconHeightPx;
    private float mSubIconLeftPx;
    private float mSubIconRightPx;
    private float mSubIconTopPx;
    private final float mSubIconWidthPx;
    private final float mTitleMarginLeftPx;
    private final float mTitleMarginRightPx;
    private final float mTitleTextSize;
    private String recognizedName;
    private boolean shouldDrawBottomLine;
    private String title;

    public final int getDefaultDrawableResId() {
        return this.defaultDrawableResId;
    }

    public final void setDefaultDrawableResId(int i) {
        this.defaultDrawableResId = i;
    }

    public final boolean getShouldDrawBottomLine() {
        return this.shouldDrawBottomLine;
    }

    public final void setShouldDrawBottomLine(boolean z) {
        this.shouldDrawBottomLine = z;
    }

    public final String getRecognizedName() {
        return this.recognizedName;
    }

    public final void setRecognizedName(String str) {
        this.recognizedName = str;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionSheetItemView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionSheetItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionSheetItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIconLeftPx = DislikeFeedbackHelper.INSTANCE.dp2px(16, getContext());
        this.mMarginRightPx = DislikeFeedbackHelper.INSTANCE.dp2px(12, getContext());
        this.mIconWidthPx = DislikeFeedbackHelper.INSTANCE.dp2px(24, getContext());
        this.mIconHeightPx = this.mIconWidthPx;
        this.mSubIconWidthPx = DislikeFeedbackHelper.INSTANCE.dp2px(14, getContext());
        this.mSubIconHeightPx = this.mSubIconWidthPx;
        this.mTitleMarginLeftPx = this.mIconLeftPx + this.mIconWidthPx + DislikeFeedbackHelper.INSTANCE.dp2px(12, getContext());
        this.mTitleMarginRightPx = this.mMarginRightPx + this.mSubIconWidthPx + DislikeFeedbackHelper.INSTANCE.dp2px(12, getContext());
        this.mTitleTextSize = DislikeFeedbackHelper.INSTANCE.dp2px(14, getContext());
        this.mBottomLineStrokeWidth = DislikeFeedbackHelper.INSTANCE.dp2px(0.5f, getContext());
        this.mSubIcon = ContextCompat.getDrawable(getContext(), R.drawable.ic_player_arrow_right);
        this.defaultDrawableResId = com.bilibili.dislikefeedback.R.drawable.bili_rect_r4_ga2;
        this.shouldDrawBottomLine = true;
        setGravity(16);
        setSingleLine(true);
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void setData(DislikeReason.ActionSheet data) {
        if (data == null) {
            return;
        }
        this.recognizedName = data.getRecognizedName();
        this.iconUrl = data.getIcon();
        if (this.iconUrl == null) {
            setPadding((int) this.mTitleMarginLeftPx, 0, (int) this.mMarginRightPx, 0);
        }
        setTitle((CharSequence) data.getTitle());
        displayIcon(this.iconUrl);
    }

    public void setOnClickListener(final View.OnClickListener l) {
        super.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.dislikefeedback.actionsheeet.ActionSheetItemView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActionSheetItemView.setOnClickListener$lambda$0(l, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnClickListener$lambda$0(View.OnClickListener $l, ActionSheetItemView this$0, View view) {
        if ($l != null) {
            this$0.onClick();
            $l.onClick(view);
        }
    }

    public void onClick() {
    }

    private static final void displayIcon$displayIconFromUrl(ActionSheetItemView this$0, Drawable icon) {
        this$0.mIcon = icon;
        this$0.invalidate();
    }

    private static final void displayIcon$displayIconFromLocal(ActionSheetItemView this$0) {
        Drawable defaultIcon = ContextCompat.getDrawable(this$0.getContext(), this$0.defaultDrawableResId);
        if (defaultIcon == null) {
            return;
        }
        displayIcon$displayIconFromUrl(this$0, defaultIcon);
    }

    private final void displayIcon(String iconUrl) {
        displayIcon$displayIconFromLocal(this);
        if (iconUrl != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            DislikeFeedbackHelper.INSTANCE.loadDrawable((View) this, context, iconUrl, new Function1() { // from class: tv.danmaku.bili.dislikefeedback.actionsheeet.ActionSheetItemView$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit displayIcon$lambda$0$0;
                    displayIcon$lambda$0$0 = ActionSheetItemView.displayIcon$lambda$0$0(ActionSheetItemView.this, (Drawable) obj);
                    return displayIcon$lambda$0$0;
                }
            }, new Function0() { // from class: tv.danmaku.bili.dislikefeedback.actionsheeet.ActionSheetItemView$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayIcon$lambda$0$0(ActionSheetItemView this$0, Drawable icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        displayIcon$displayIconFromUrl(this$0, icon);
        return Unit.INSTANCE;
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        onLayout$measureIcon(this);
        onLayout$measureSubIcon(this);
    }

    private static final void onLayout$measureIcon(ActionSheetItemView this$0) {
        this$0.mIconTopPx = (this$0.getMeasuredHeight() - this$0.mIconHeightPx) / 2.0f;
        this$0.mIconBottomPx = this$0.mIconTopPx + this$0.mIconHeightPx;
        this$0.mIconRightPx = this$0.mIconLeftPx + this$0.mIconWidthPx;
    }

    private static final void onLayout$measureSubIcon(ActionSheetItemView this$0) {
        this$0.mSubIconRightPx = this$0.getMeasuredWidth() - this$0.mMarginRightPx;
        this$0.mSubIconLeftPx = this$0.mSubIconRightPx - this$0.mSubIconWidthPx;
        this$0.mSubIconTopPx = (this$0.getMeasuredHeight() - this$0.mSubIconHeightPx) / 2.0f;
        this$0.mSubIconBottomPx = this$0.mSubIconTopPx + this$0.mSubIconHeightPx;
    }

    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Drawable $this$onDraw_u24lambda_u240_u240 = this.mIcon;
        if ($this$onDraw_u24lambda_u240_u240 != null) {
            $this$onDraw_u24lambda_u240_u240.setBounds((int) this.mIconLeftPx, (int) this.mIconTopPx, (int) this.mIconRightPx, (int) this.mIconBottomPx);
            $this$onDraw_u24lambda_u240_u240.draw(canvas);
        }
        Drawable $this$onDraw_u24lambda_u240_u241 = this.mSubIcon;
        if ($this$onDraw_u24lambda_u240_u241 != null) {
            $this$onDraw_u24lambda_u240_u241.setBounds((int) this.mSubIconLeftPx, (int) this.mSubIconTopPx, (int) this.mSubIconRightPx, (int) this.mSubIconBottomPx);
            $this$onDraw_u24lambda_u240_u241.draw(canvas);
        }
        if (this.shouldDrawBottomLine) {
            drawBottomLine(canvas);
        }
    }

    private final void setTitle(CharSequence text) {
        setPadding((int) this.mTitleMarginLeftPx, 0, (int) this.mTitleMarginRightPx, 0);
        getPaint().setTextSize(this.mTitleTextSize);
        setTextColor(ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Ga10));
        setText(text);
    }

    private final Paint getBottomLinePaint() {
        TextPaint $this$getBottomLinePaint_u24lambda_u240 = getPaint();
        $this$getBottomLinePaint_u24lambda_u240.setColor(ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Ga2));
        $this$getBottomLinePaint_u24lambda_u240.setStrokeWidth(this.mBottomLineStrokeWidth);
        Intrinsics.checkNotNullExpressionValue($this$getBottomLinePaint_u24lambda_u240, "apply(...)");
        return $this$getBottomLinePaint_u24lambda_u240;
    }

    private final void drawBottomLine(Canvas canvas) {
        if (canvas != null) {
            canvas.drawLine(this.mIconLeftPx, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), getBottomLinePaint());
        }
    }
}