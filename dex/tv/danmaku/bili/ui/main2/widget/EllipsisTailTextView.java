package tv.danmaku.bili.ui.main2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bilibili.magicasakura.widgets.TintTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: EllipsisTailTextView.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/main2/widget/EllipsisTailTextView;", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ellipsisTail", "", "originalText", "", "recount", "", "fullText", "setMaxLines", "", "maxLines", "onDraw", "canvas", "Landroid/graphics/Canvas;", "truncateText", "setOriginalText", "original", "setEllipsisTail", "tail", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EllipsisTailTextView extends TintTextView {
    public static final int $stable = 8;
    private String ellipsisTail;
    private CharSequence originalText;
    private boolean recount;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EllipsisTailTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EllipsisTailTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EllipsisTailTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        if (attrs == null) {
            return;
        }
        int[] attrs$iv = R.styleable.EllipsisTailTextView;
        Intrinsics.checkNotNullExpressionValue(attrs$iv, "EllipsisTailTextView");
        TypedArray $this$lambda_u240_u240 = context.obtainStyledAttributes(attrs, attrs$iv, 0, 0);
        this.ellipsisTail = $this$lambda_u240_u240.getString(R.styleable.EllipsisTailTextView_ellipsisTail);
        $this$lambda_u240_u240.recycle();
    }

    public /* synthetic */ EllipsisTailTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final String fullText() {
        CharSequence it = this.originalText;
        if (it != null) {
            String str = this.ellipsisTail;
            if (str == null) {
                str = "";
            }
            return ((Object) it) + str;
        }
        return null;
    }

    public void setMaxLines(int maxLines) {
        this.recount = true;
        super.setMaxLines(maxLines);
    }

    protected void onDraw(Canvas canvas) {
        String fullText;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.recount) {
            setEllipsize((TextUtils.TruncateAt) null);
            if (getLayout() != null && getLayout().getLineCount() > getMaxLines()) {
                CharSequence text = getText();
                String obj = text != null ? text.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                fullText = truncateText(obj);
            } else {
                fullText = fullText();
            }
            setText(fullText);
            this.recount = false;
        }
        super.onDraw(canvas);
    }

    private final CharSequence truncateText(String fullText) {
        if (getLayout().getLineCount() <= getMaxLines()) {
            return fullText;
        }
        String str = this.ellipsisTail;
        if (str == null) {
            str = "";
        }
        String ellipsis = "…" + str;
        int start = getLayout().getLineStart(getMaxLines() - 1);
        int end = getLayout().getLineEnd(getMaxLines() - 1);
        float expandWidth = Layout.getDesiredWidth(ellipsis, 0, ellipsis.length(), getPaint());
        do {
            end--;
            if (end < start) {
                break;
            }
        } while (getLayout().getWidth() - Layout.getDesiredWidth(fullText, start, end, getPaint()) < expandWidth);
        if (end < 0) {
            end = 0;
        }
        return ((Object) fullText.subSequence(0, end)) + ellipsis;
    }

    public final void setOriginalText(String original) {
        this.originalText = original;
        this.recount = true;
        setText(fullText());
    }

    public final void setEllipsisTail(String tail) {
        this.ellipsisTail = tail;
        this.recount = true;
        setText(fullText());
    }
}