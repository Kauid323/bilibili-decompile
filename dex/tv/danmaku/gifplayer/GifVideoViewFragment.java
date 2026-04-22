package tv.danmaku.gifplayer;

import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: GifVideoView.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\tJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/gifplayer/GifVideoViewFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mGifVideoView", "Ltv/danmaku/gifplayer/GifVideoView;", "setGifVideoView", "", "videoView", "setGifVideoView$biligifplayer_debug", "getGifVideoView", "getGifVideoView$biligifplayer_debug", "onDestroy", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GifVideoViewFragment extends androidx_fragment_app_Fragment {
    private GifVideoView mGifVideoView;

    public final void setGifVideoView$biligifplayer_debug(GifVideoView videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.mGifVideoView = videoView;
    }

    public final GifVideoView getGifVideoView$biligifplayer_debug() {
        return this.mGifVideoView;
    }

    public void onDestroy() {
        super.onDestroy();
        GifVideoView gifVideoView = this.mGifVideoView;
        if (gifVideoView != null) {
            gifVideoView.stop(false, true);
        }
    }
}