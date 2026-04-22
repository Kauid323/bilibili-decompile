package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FixedWidthTextView.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/FixedWidthTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPrevText", "", "mTextLengthChanged", "", "setText", "", "text", "type", "Landroid/widget/TextView$BufferType;", "requestLayout", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FixedWidthTextView extends AppCompatTextView {
    private CharSequence mPrevText;
    private boolean mTextLengthChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedWidthTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTextLengthChanged = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedWidthTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mTextLengthChanged = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedWidthTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mTextLengthChanged = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setText(CharSequence text, TextView.BufferType type) {
        boolean z;
        TextPaint paint;
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.mPrevText != null && text != null) {
            CharSequence charSequence = this.mPrevText;
            Intrinsics.checkNotNull(charSequence);
            if (charSequence.length() == text.length()) {
                z = false;
                this.mTextLengthChanged = z;
                this.mPrevText = text;
                paint = getPaint();
                if (!this.mTextLengthChanged && text != null && paint != null) {
                    this.mTextLengthChanged = paint.measureText(text, 0, text.length()) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()));
                }
                super.setText(text, type);
                this.mTextLengthChanged = false;
            }
        }
        z = true;
        this.mTextLengthChanged = z;
        this.mPrevText = text;
        paint = getPaint();
        if (!this.mTextLengthChanged) {
            this.mTextLengthChanged = paint.measureText(text, 0, text.length()) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()));
        }
        super.setText(text, type);
        this.mTextLengthChanged = false;
    }

    public void requestLayout() {
        if (!this.mTextLengthChanged) {
            return;
        }
        super.requestLayout();
    }
}