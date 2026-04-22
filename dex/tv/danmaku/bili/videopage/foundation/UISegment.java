package tv.danmaku.bili.videopage.foundation;

import android.view.ViewGroup;
import kotlin.Metadata;
import tv.danmaku.bili.videopage.foundation.IHost;
import tv.danmaku.bili.videopage.foundation.ParamsParser;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UISegment.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/foundation/UISegment;", "H", "Ltv/danmaku/bili/videopage/foundation/IHost;", "P", "Ltv/danmaku/bili/videopage/foundation/ParamsParser;", "Ltv/danmaku/bili/videopage/foundation/ISegment;", "onAttachView", "", "container", "Landroid/view/ViewGroup;", "onDetachView", "videopagefoundation_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface UISegment<H extends IHost, P extends ParamsParser> extends ISegment<H, P> {
    void onAttachView(ViewGroup viewGroup);

    void onDetachView();
}