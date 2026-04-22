package tv.danmaku.bili.widget.widget;

import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LikeClickableSpan.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/widget/widget/LikeClickableSpan;", "T", "Landroid/text/style/ClickableSpan;", "t", "<init>", "(Ljava/lang/Object;)V", "getT", "()Ljava/lang/Object;", "Ljava/lang/Object;", "onClick", "", "widget", "Landroid/view/View;", "onDataClick", "followingCard_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class LikeClickableSpan<T> extends ClickableSpan {
    public static final int $stable = 8;
    private final T t;

    public abstract void onDataClick(T t);

    public LikeClickableSpan(T t) {
        this.t = t;
    }

    public final T getT() {
        return this.t;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        onDataClick(this.t);
    }
}