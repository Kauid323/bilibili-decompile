package tv.danmaku.bili.widget.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bilibili.lib.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FixedLineSpacingTextView.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\b\b\u0001\u0010\u0014\u001a\u00020\u0007J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/widget/text/FixedLineSpacingTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLineSpacing", "mText", "", "mType", "Landroid/widget/TextView$BufferType;", "setText", "", "text", "type", "setLineSpacing", "lineSpacing", "setCustomText", "Landroid/text/SpannableStringBuilder;", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FixedLineSpacingTextView extends TextView {
    private int mLineSpacing;
    private CharSequence mText;
    private TextView.BufferType mType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FixedLineSpacingTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FixedLineSpacingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLineSpacingTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLineSpacing = FixedLineSpacingTextViewKt.toPx(4.0f);
        TypedArray array = null;
        try {
            array = context.obtainStyledAttributes(attrs, R.styleable.FixedLineSpacingTextView);
            this.mLineSpacing = array.getDimensionPixelSize(R.styleable.FixedLineSpacingTextView_line_spacing, this.mLineSpacing);
        } finally {
            if (array != null) {
                array.recycle();
            }
        }
    }

    public /* synthetic */ FixedLineSpacingTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        this.mType = type;
        this.mText = text;
        super.setText(setCustomText(text), type);
    }

    public final void setLineSpacing(int lineSpacing) {
        this.mLineSpacing = lineSpacing;
        setText(this.mText, this.mType);
    }

    private final SpannableStringBuilder setCustomText(CharSequence text) {
        SpannableStringBuilder builder;
        if (text == null) {
            return null;
        }
        int lineHeight = ((int) getTextSize()) + this.mLineSpacing;
        if (text instanceof SpannableStringBuilder) {
            builder = (SpannableStringBuilder) text;
        } else {
            builder = new SpannableStringBuilder(text);
        }
        builder.setSpan(new ExcludeInnerLineSpaceSpan(lineHeight), 0, text.length(), 33);
        return builder;
    }
}