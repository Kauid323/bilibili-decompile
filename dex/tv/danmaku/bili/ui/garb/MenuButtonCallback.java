package tv.danmaku.bili.ui.garb;

import kotlin.Metadata;
import kotlin.Pair;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;

/* compiled from: NftCardMenuButtonList.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/MenuButtonCallback;", "", "setAvatar", "", "setHeader", "hasNftInfo", "", "seeNftInfo", "savePic", "giveOther", "dismissDialog", "dismissMenu", "getCurrentCardId", "", "getLimitInfo", "Lkotlin/Pair;", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "Ltv/danmaku/bili/ui/garb/api/CardRight;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface MenuButtonCallback {
    void dismissDialog();

    void dismissMenu();

    long getCurrentCardId();

    Pair<CardRightShow, CardRight> getLimitInfo();

    void giveOther();

    boolean hasNftInfo();

    void savePic();

    void seeNftInfo();

    void setAvatar();

    void setHeader();

    /* compiled from: NftCardMenuButtonList.kt */
    /* renamed from: tv.danmaku.bili.ui.garb.MenuButtonCallback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static void $default$setAvatar(MenuButtonCallback _this) {
        }

        public static void $default$setHeader(MenuButtonCallback _this) {
        }

        public static boolean $default$hasNftInfo(MenuButtonCallback _this) {
            return false;
        }

        public static void $default$seeNftInfo(MenuButtonCallback _this) {
        }

        public static void $default$savePic(MenuButtonCallback _this) {
        }

        public static void $default$giveOther(MenuButtonCallback _this) {
        }

        public static void $default$dismissDialog(MenuButtonCallback _this) {
        }

        public static void $default$dismissMenu(MenuButtonCallback _this) {
        }

        public static long $default$getCurrentCardId(MenuButtonCallback _this) {
            return 0L;
        }
    }
}