package tv.danmaku.bili.ui.garb.nft;

import kotlin.Metadata;
import kotlin.Pair;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;
import tv.danmaku.bili.ui.garb.nft.DLCCardBotttomMenuList;

/* compiled from: DLCCardBotttomMenuList.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u001a\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/BottomMenuButtonCallback;", "", "setAvatar", "", "setHeader", "getCurrentCardId", "", "onUsingMenuClick", "menuVm", "Ltv/danmaku/bili/ui/garb/nft/DLCCardBotttomMenuList$UseMenuVM;", "dismissMenu", "getLimitInfo", "Lkotlin/Pair;", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "Ltv/danmaku/bili/ui/garb/api/CardRight;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface BottomMenuButtonCallback {
    void dismissMenu();

    long getCurrentCardId();

    Pair<CardRightShow, CardRight> getLimitInfo();

    void onUsingMenuClick(DLCCardBotttomMenuList.UseMenuVM useMenuVM);

    void setAvatar();

    void setHeader();

    /* compiled from: DLCCardBotttomMenuList.kt */
    /* renamed from: tv.danmaku.bili.ui.garb.nft.BottomMenuButtonCallback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static void $default$setAvatar(BottomMenuButtonCallback _this) {
        }

        public static void $default$setHeader(BottomMenuButtonCallback _this) {
        }

        public static long $default$getCurrentCardId(BottomMenuButtonCallback _this) {
            return 0L;
        }

        public static void $default$dismissMenu(BottomMenuButtonCallback _this) {
        }
    }
}