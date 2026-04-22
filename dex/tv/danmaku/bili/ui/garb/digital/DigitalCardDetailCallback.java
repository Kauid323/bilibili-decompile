package tv.danmaku.bili.ui.garb.digital;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRenderData;

/* compiled from: DigitalCardDetailCallback.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailCallback;", "", "onScrollStart", "", "onScrollEnd", "", "cardInfo", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "onCardLoadSuccess", "showCardInfo", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface DigitalCardDetailCallback {
    void onCardLoadSuccess(DigitalCardDetailRenderData digitalCardDetailRenderData);

    boolean onScrollEnd(DigitalCardDetailRenderData digitalCardDetailRenderData);

    void onScrollStart();

    void showCardInfo(DigitalCardDetailRenderData digitalCardDetailRenderData);

    /* compiled from: DigitalCardDetailCallback.kt */
    /* renamed from: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailCallback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static void $default$onScrollStart(DigitalCardDetailCallback _this) {
        }

        public static boolean $default$onScrollEnd(DigitalCardDetailCallback _this, DigitalCardDetailRenderData cardInfo) {
            Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
            return false;
        }

        public static void $default$onCardLoadSuccess(DigitalCardDetailCallback _this, DigitalCardDetailRenderData cardInfo) {
            Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        }

        public static void $default$showCardInfo(DigitalCardDetailCallback _this, DigitalCardDetailRenderData cardInfo) {
            Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        }
    }
}