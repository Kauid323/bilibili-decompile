package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayDirectorServiceV2.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0010H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayDirector;", "", "getCurrentPlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "addVideoDirectorObserver", "", "observer", "Ltv/danmaku/biliplayerv2/service/VideoDirectorObserver;", "removeVideoDirectorObserver", "triggerResolveAndAutoStart", "autoStart", "", "switchToNext", "canLoop", "switchToPrevious", "itemCount", "", "hasNext", "loop", "hasPrevious", "getPlayingItemIndex", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayDirector {
    void addVideoDirectorObserver(VideoDirectorObserver videoDirectorObserver);

    Video.PlayableParams getCurrentPlayableParams();

    int getPlayingItemIndex();

    boolean hasNext(boolean z);

    boolean hasPrevious(boolean z);

    int itemCount();

    void removeVideoDirectorObserver(VideoDirectorObserver videoDirectorObserver);

    void switchToNext(boolean z);

    void switchToPrevious(boolean z);

    void triggerResolveAndAutoStart(boolean z);

    /* compiled from: IPlayDirectorServiceV2.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IPlayDirector$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$hasPrevious(IPlayDirector _this, boolean loop) {
            return false;
        }
    }
}