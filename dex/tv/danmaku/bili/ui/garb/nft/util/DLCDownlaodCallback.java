package tv.danmaku.bili.ui.garb.nft.util;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.model.DLCSubtitles;

/* compiled from: DLCResDownloader.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/util/DLCDownlaodCallback;", "", "success", "", "subtitle", "Ltv/danmaku/bili/ui/garb/nft/model/DLCSubtitles;", "fail", "t", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface DLCDownlaodCallback {
    void fail(Throwable th);

    void success(DLCSubtitles dLCSubtitles);
}