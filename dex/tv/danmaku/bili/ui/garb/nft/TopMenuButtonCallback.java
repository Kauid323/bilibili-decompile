package tv.danmaku.bili.ui.garb.nft;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: DLCCardMenuButtonList.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/TopMenuButtonCallback;", "", "hasNftInfo", "", "canDonate", "canSaveImage", "seeNftInfo", "", "savePic", "giveOther", "dismissDialog", "getCurrentCardId", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface TopMenuButtonCallback {
    boolean canDonate();

    boolean canSaveImage();

    void dismissDialog();

    long getCurrentCardId();

    void giveOther();

    boolean hasNftInfo();

    void savePic();

    void seeNftInfo();

    /* compiled from: DLCCardMenuButtonList.kt */
    /* renamed from: tv.danmaku.bili.ui.garb.nft.TopMenuButtonCallback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$hasNftInfo(TopMenuButtonCallback _this) {
            return false;
        }

        public static boolean $default$canDonate(TopMenuButtonCallback _this) {
            return false;
        }

        public static void $default$seeNftInfo(TopMenuButtonCallback _this) {
        }

        public static void $default$savePic(TopMenuButtonCallback _this) {
        }

        public static void $default$giveOther(TopMenuButtonCallback _this) {
        }

        public static void $default$dismissDialog(TopMenuButtonCallback _this) {
        }

        public static long $default$getCurrentCardId(TopMenuButtonCallback _this) {
            return 0L;
        }
    }
}