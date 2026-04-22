package tv.danmaku.biliplayerimpl.toast;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AbsScaleableToastView.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000bH&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/AbsScaleableToastView;", "Ltv/danmaku/biliplayerimpl/toast/IScaleable;", "<init>", "()V", "mScaleFactor", "", "getMScaleFactor", "()F", "setMScaleFactor", "(F)V", "setScaleFactor", "", "factor", "scale", "scaleRootView", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbsScaleableToastView implements IScaleable {
    public static final Companion Companion = new Companion(null);
    public static final float SCALE_NORMAL = 1.0f;
    public static final float SCALE_SMALL = 0.8f;
    private float mScaleFactor = 0.8f;

    public abstract void scaleRootView();

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getMScaleFactor() {
        return this.mScaleFactor;
    }

    protected final void setMScaleFactor(float f) {
        this.mScaleFactor = f;
    }

    private final void setScaleFactor(float factor) {
        if (factor > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            this.mScaleFactor = factor;
        }
    }

    @Override // tv.danmaku.biliplayerimpl.toast.IScaleable
    public void scale(float factor) {
        setScaleFactor(factor);
        scaleRootView();
    }

    /* compiled from: AbsScaleableToastView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/AbsScaleableToastView$Companion;", "", "<init>", "()V", "SCALE_NORMAL", "", "SCALE_SMALL", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}