package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.widget.CircleView;
import tv.danmaku.bili.videopage.common.widget.LiveAvatarStore;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LiveAvatarCircleView.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J(\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0014R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/LiveAvatarCircleView;", "Landroid/view/View;", "Ltv/danmaku/bili/videopage/common/widget/CircleView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCoordinateP", "Lkotlin/Pair;", "mConfig", "Ltv/danmaku/bili/videopage/common/widget/LiveAvatarStore$Config;", "invalidate", "", "config", "onAdded", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LiveAvatarCircleView extends View implements CircleView {
    private LiveAvatarStore.Config mConfig;
    private Pair<Integer, Integer> mCoordinateP;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAvatarCircleView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCoordinateP = TuplesKt.to(0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAvatarCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mCoordinateP = TuplesKt.to(0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAvatarCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mCoordinateP = TuplesKt.to(0, 0);
    }

    @Override // tv.danmaku.bili.videopage.common.widget.CircleView
    public void invalidate(LiveAvatarStore.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.mConfig = config;
        invalidate();
    }

    @Override // tv.danmaku.bili.videopage.common.widget.CircleView
    public void onAdded(LiveAvatarStore.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.mConfig = config;
        LiveAvatarStore.Config config2 = this.mConfig;
        if (config2 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            config2.onTint(context);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        LiveAvatarStore.Config it = this.mConfig;
        if (it != null) {
            canvas.drawCircle(((Number) this.mCoordinateP.getFirst()).intValue(), ((Number) this.mCoordinateP.getSecond()).intValue(), it.getRadiusStatic(), it.getPaintStatic());
            canvas.drawCircle(((Number) this.mCoordinateP.getFirst()).intValue(), ((Number) this.mCoordinateP.getSecond()).intValue(), it.getRadiusInner(), it.getPaintInner());
            canvas.drawCircle(((Number) this.mCoordinateP.getFirst()).intValue(), ((Number) this.mCoordinateP.getSecond()).intValue(), it.getRadiusOuter(), it.getPaintOuter());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mCoordinateP = TuplesKt.to(Integer.valueOf(w / 2), Integer.valueOf(h / 2));
    }
}