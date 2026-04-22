package kntr.base.primer;

import java.util.Iterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimerPath.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0086\u0081\u0002\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006!"}, d2 = {"Lkntr/base/primer/PrimerPath;", "", "path", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPath$annotations", "()V", "getPath", "()Ljava/lang/String;", "SplashEventList", "OnlineParam", "SplashBrandList", "TeenagersModeStatus", "OfflineManifest", "VersionFawkesUpgrade", "Tribe", "TotalUnread", "DmView", "GameCommonSwitch", "GameCopyWritingConfig", "GameAllExpInfo", "GameAutoDownload", "GameNoticeGame", "MallAbtest", "LiveWalletCurrency", "LiveFetchResource", "UperArchivePre", "UperBubble", "UperAbtest", "UperBlackList", "OGVSkinList", "Companion", "primer_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum PrimerPath {
    SplashEventList("app.bilibili.com/x/v2/splash/event/list2"),
    OnlineParam("app.bilibili.com/x/v2/param"),
    SplashBrandList("app.bilibili.com/x/v2/splash/brand/list"),
    TeenagersModeStatus("grpc.biliapi.net/bilibili.app.interface.v1.Teenagers/ModeStatus"),
    OfflineManifest("api.bilibili.com/x/offline/manifest"),
    VersionFawkesUpgrade("app.bilibili.com/x/v2/version/fawkes/upgrade"),
    Tribe("app.bilibili.com/x/v2/version/fawkes/tribe3"),
    TotalUnread("grpc.biliapi.net/bilibili.app.im.v1.im/GetTotalUnread"),
    DmView("grpc.biliapi.net/bilibili.community.service.dm.v1.DM/DmView"),
    GameCommonSwitch("line3-h5-mobile-api.biligame.com/api/common/switch"),
    GameCopyWritingConfig("line3-h5-mobile-api.biligame.com/api/common/copywriting/config"),
    GameAllExpInfo("line3-h5-mobile-api.biligame.com/game/abtest/get_all_exp_info"),
    GameAutoDownload("line3-h5-mobile-api.biligame.com/game/center/h5/user/auto_download/game_pkg_list/v2"),
    GameNoticeGame("line3-h5-mobile-api.biligame.com/game/center/h5/home/fetch_notice_game"),
    MallAbtest("mall.bilibili.com/mall/ashbringer/app/abtest"),
    LiveWalletCurrency("api.live.bilibili.com/xlive/revenue/v1/wallet/getCurrencyData"),
    LiveFetchResource("api.live.bilibili.com/xlive/open-interface/v1/fetch_resource"),
    UperArchivePre("member.bilibili.com/x/vupre/app/archive/pre/v2"),
    UperBubble("member.bilibili.com/x/app/archive/resource/bubble"),
    UperAbtest("member.bilibili.com/x/creative-tool/common/abtest"),
    UperBlackList("member.bilibili.com/x/app/operation/conf"),
    OGVSkinList("club.bilibili.com/api/query.skin.list.do");
    
    private final String path;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<PrimerPath> getEntries() {
        return $ENTRIES;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    PrimerPath(String path) {
        this.path = path;
    }

    public final String getPath() {
        return this.path;
    }

    /* compiled from: PrimerPath.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lkntr/base/primer/PrimerPath$Companion;", "", "<init>", "()V", "fromString", "Lkntr/base/primer/PrimerPath;", "string", "", "primer_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PrimerPath fromString(String string) {
            Object element$iv;
            Intrinsics.checkNotNullParameter(string, "string");
            Iterable $this$firstOrNull$iv = PrimerPath.getEntries();
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    PrimerPath it2 = (PrimerPath) element$iv;
                    if (Intrinsics.areEqual(it2.getPath(), string)) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            return (PrimerPath) element$iv;
        }
    }
}