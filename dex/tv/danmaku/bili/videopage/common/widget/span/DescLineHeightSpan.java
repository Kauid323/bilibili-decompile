package tv.danmaku.bili.videopage.common.widget.span;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DescLineHeightSpan.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J<\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/span/DescLineHeightSpan;", "Landroid/text/style/LineHeightSpan;", "height", "", "<init>", "(I)V", "chooseHeight", "", "text", "", "start", ShareIconObserverKt.SHARE_FROM_END, "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DescLineHeightSpan implements LineHeightSpan {
    private final int height;

    public DescLineHeightSpan(int height) {
        this.height = height;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm) {
        int h = this.height / 2;
        if (fm != null) {
            fm.top = -h;
        }
        if (fm != null) {
            fm.ascent = -h;
        }
        if (fm != null) {
            fm.descent = h;
        }
        if (fm != null) {
            fm.bottom = h;
        }
    }
}