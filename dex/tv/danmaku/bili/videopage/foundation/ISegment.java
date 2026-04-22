package tv.danmaku.bili.videopage.foundation;

import kotlin.Metadata;
import tv.danmaku.bili.videopage.foundation.IHost;
import tv.danmaku.bili.videopage.foundation.ParamsParser;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ISegment.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H&¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\r\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/foundation/ISegment;", "H", "Ltv/danmaku/bili/videopage/foundation/IHost;", "P", "Ltv/danmaku/bili/videopage/foundation/ParamsParser;", "", "onAttach", "", "host", "paramsParser", "(Ltv/danmaku/bili/videopage/foundation/IHost;Ltv/danmaku/bili/videopage/foundation/ParamsParser;)V", "onBindDependency", "segment", "onDetach", "videopagefoundation_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ISegment<H extends IHost, P extends ParamsParser> {
    void onAttach(H h, P p);

    void onBindDependency(ISegment<?, ?> iSegment);

    void onDetach();

    /* compiled from: ISegment.kt */
    /* renamed from: tv.danmaku.bili.videopage.foundation.ISegment$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
    }
}