package tv.danmaku.bili.ui.main2.resource;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: IHomeTab.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/main2/resource/IHomeTab;", "", "reporterId", "", "getReporterId", "()Ljava/lang/String;", "setReporterId", "(Ljava/lang/String;)V", "defaultSelected", "", "getDefaultSelected", "()Z", "setDefaultSelected", "(Z)V", "expiredAt", "", "getExpiredAt", "()J", "setExpiredAt", "(J)V", FavoritesConstsKt.POS, "", "getPos", "()I", "setPos", "(I)V", AudioIntentHelper.ARGS_URI, "getUri", "setUri", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IHomeTab {
    boolean getDefaultSelected();

    long getExpiredAt();

    int getPos();

    String getReporterId();

    String getUri();

    void setDefaultSelected(boolean z);

    void setExpiredAt(long j);

    void setPos(int i);

    void setReporterId(String str);

    void setUri(String str);
}