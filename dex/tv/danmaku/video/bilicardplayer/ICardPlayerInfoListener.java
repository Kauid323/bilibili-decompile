package tv.danmaku.video.bilicardplayer;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ICardPlayerInfoListener.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/ICardPlayerInfoListener;", "", "onInfo", "", "what", "", "params", "Companion", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ICardPlayerInfoListener {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int INFO_PLAYER_SHOW = 2;
    public static final int INFO_STOP = 3;
    public static final int INFO_STOP_BY_OTHERS = 1;

    void onInfo(int i, Object obj);

    /* compiled from: ICardPlayerInfoListener.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/video/bilicardplayer/ICardPlayerInfoListener$Companion;", "", "<init>", "()V", "INFO_STOP_BY_OTHERS", "", "INFO_PLAYER_SHOW", "INFO_STOP", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int INFO_PLAYER_SHOW = 2;
        public static final int INFO_STOP = 3;
        public static final int INFO_STOP_BY_OTHERS = 1;

        private Companion() {
        }
    }
}