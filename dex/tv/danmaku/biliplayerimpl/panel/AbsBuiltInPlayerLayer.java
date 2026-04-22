package tv.danmaku.biliplayerimpl.panel;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.panel.IPlayerLayer;
import tv.danmaku.biliplayerv2.panel.IVideoInsetChangedObserver;
import tv.danmaku.biliplayerv2.panel.VideoInset;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AbsBuiltInPlayerLayer.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/biliplayerimpl/panel/AbsBuiltInPlayerLayer;", "Ltv/danmaku/biliplayerv2/panel/IPlayerLayer;", "Landroid/view/View;", "rootView", "index", "", "<init>", "(Landroid/view/View;I)V", "getRootView", "()Landroid/view/View;", "mLastInsertIndex", "getView", "increaseInsertIndex", "", "decreaseInsertIndex", "insertIndex", "onVideoInsetChanged", "inset", "Ltv/danmaku/biliplayerv2/panel/VideoInset;", "type", "", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbsBuiltInPlayerLayer implements IPlayerLayer<View> {
    public static final Companion Companion = new Companion(null);
    private static final String TYPE = "builtInLayer";
    private int mLastInsertIndex;
    private final View rootView;

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public /* synthetic */ void attachToPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public /* synthetic */ void detachFromPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public /* synthetic */ void onViewPortUpdate(Rect rect, int i, int i2, boolean z) {
        IPlayerLayer.CC.$default$onViewPortUpdate(this, rect, i, i2, z);
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public /* synthetic */ void relayout() {
        IPlayerLayer.CC.$default$relayout(this);
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public /* synthetic */ void setVisibility(boolean z) {
        IPlayerLayer.CC.$default$setVisibility(this, z);
    }

    /* compiled from: AbsBuiltInPlayerLayer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/panel/AbsBuiltInPlayerLayer$Companion;", "", "<init>", "()V", "TYPE", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AbsBuiltInPlayerLayer(View rootView, int index) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.rootView = rootView;
        this.mLastInsertIndex = index + 1;
    }

    public final View getRootView() {
        return this.rootView;
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public View getView() {
        return this.rootView;
    }

    public final void increaseInsertIndex() {
        this.mLastInsertIndex++;
    }

    public final void decreaseInsertIndex() {
        this.mLastInsertIndex--;
    }

    public final int insertIndex() {
        return this.mLastInsertIndex;
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public void onVideoInsetChanged(VideoInset inset) {
        Intrinsics.checkNotNullParameter(inset, "inset");
        View view2 = getView();
        if (view2 instanceof IVideoInsetChangedObserver) {
            ((IVideoInsetChangedObserver) view2).onVideoInsetChanged(inset);
        }
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public String type() {
        return TYPE;
    }
}