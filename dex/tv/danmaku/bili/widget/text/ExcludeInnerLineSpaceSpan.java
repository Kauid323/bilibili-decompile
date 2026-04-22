package tv.danmaku.bili.widget.text;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FixedLineSpacingTextView.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J:\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/widget/text/ExcludeInnerLineSpaceSpan;", "Landroid/text/style/LineHeightSpan;", "mHeight", "", "<init>", "(I)V", "chooseHeight", "", "text", "", "start", ShareIconObserverKt.SHARE_FROM_END, "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ExcludeInnerLineSpaceSpan implements LineHeightSpan {
    private int mHeight;

    public ExcludeInnerLineSpaceSpan(int mHeight) {
        this.mHeight = mHeight;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        int originHeight = fm.descent - fm.ascent;
        if (originHeight <= 0) {
            return;
        }
        float ratio = (this.mHeight * 1.0f) / originHeight;
        fm.descent = MathKt.roundToInt(fm.descent * ratio);
        fm.ascent = fm.descent - this.mHeight;
    }
}