package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IVideoPlayDirectorService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IShareDataInterceptor;", "Ltv/danmaku/biliplayerv2/service/IPlayerShareInterceptor;", "interceptDataSource", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "sharingPlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "interceptVideoItem", "Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "videoPointer", "interceptVideoIndex", "", "index", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IShareDataInterceptor extends IPlayerShareInterceptor {
    PlayerDataSource interceptDataSource(Video.PlayableParams playableParams);

    int interceptVideoIndex(int i);

    CurrentVideoPointer interceptVideoItem(CurrentVideoPointer currentVideoPointer);

    /* compiled from: IVideoPlayDirectorService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IShareDataInterceptor$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static CurrentVideoPointer $default$interceptVideoItem(IShareDataInterceptor _this, CurrentVideoPointer videoPointer) {
            Intrinsics.checkNotNullParameter(videoPointer, "videoPointer");
            return videoPointer;
        }

        public static int $default$interceptVideoIndex(IShareDataInterceptor _this, int index) {
            return index;
        }
    }
}