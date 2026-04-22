package tv.danmaku.bili.ui.clipboard;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.splash.LaunchClipboard;

/* compiled from: ClipboardChecker.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/OpenResult;", "Ltv/danmaku/bili/ui/clipboard/RecognizeResult;", "<init>", "()V", "playData", "Ltv/danmaku/bili/ui/splash/LaunchClipboard$PlayData;", "getPlayData", "()Ltv/danmaku/bili/ui/splash/LaunchClipboard$PlayData;", "setPlayData", "(Ltv/danmaku/bili/ui/splash/LaunchClipboard$PlayData;)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OpenResult extends RecognizeResult {
    public static final int $stable = 8;
    private LaunchClipboard.PlayData playData;

    public final LaunchClipboard.PlayData getPlayData() {
        return this.playData;
    }

    public final void setPlayData(LaunchClipboard.PlayData playData) {
        this.playData = playData;
    }
}