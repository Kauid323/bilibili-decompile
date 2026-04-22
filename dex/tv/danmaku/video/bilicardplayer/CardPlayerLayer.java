package tv.danmaku.video.bilicardplayer;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import com.bilibili.base.BiliContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.panel.IPlayerLayer;
import tv.danmaku.biliplayerv2.panel.VideoInset;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CardPlayerLayer.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0011H&J\b\u0010\u0018\u001a\u00020\u0011H&J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH&R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/video/bilicardplayer/CardPlayerLayer;", "Ltv/danmaku/biliplayerv2/panel/IPlayerLayer;", "Landroid/view/View;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "()V", "cardPlayerContext", "Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;", "getCardPlayerContext", "()Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;", "setCardPlayerContext", "(Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;)V", "mView", "getView", "attachToPlayerContainer", "", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "detachFromPlayerContainer", "setContext", "context", "onAttach", "onDetach", "onCreateView", "layoutInflater", "Landroid/view/LayoutInflater;", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class CardPlayerLayer implements IPlayerLayer<View> {
    private ICardPlayerContext cardPlayerContext;
    private Context mContext;
    private View mView;

    public abstract void onAttach();

    public abstract View onCreateView(LayoutInflater layoutInflater);

    public abstract void onDetach();

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public /* synthetic */ void onVideoInsetChanged(VideoInset videoInset) {
        Intrinsics.checkNotNullParameter(videoInset, "inset");
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

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public /* synthetic */ String type() {
        return IPlayerLayer.CC.$default$type(this);
    }

    public CardPlayerLayer(Context mContext) {
        this.mContext = mContext;
    }

    public CardPlayerLayer() {
        this(null);
    }

    public final ICardPlayerContext getCardPlayerContext() {
        return this.cardPlayerContext;
    }

    public final void setCardPlayerContext(ICardPlayerContext iCardPlayerContext) {
        this.cardPlayerContext = iCardPlayerContext;
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public final View getView() {
        View view2 = this.mView;
        if (view2 == null) {
            Application application = this.mContext;
            if (application == null) {
                application = BiliContext.application();
            }
            LayoutInflater from = LayoutInflater.from(application);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            View view3 = onCreateView(from);
            this.mView = view3;
            return view3;
        }
        return view2;
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public final void attachToPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        onAttach();
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public final void detachFromPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        onDetach();
    }

    public void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
    }
}