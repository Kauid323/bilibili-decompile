package tv.danmaku.bili.appwidget.upcard.utils;

import android.content.Context;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.ScreenUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.data.UpCardWidgetData;
import tv.danmaku.bili.appwidget.upcard.data.WidgetUpCard;

/* compiled from: UpCardCoverUtil.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001aN\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\u000f"}, d2 = {"getUpCardCover", "", "data", "Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;", "item", "Ltv/danmaku/bili/appwidget/upcard/data/WidgetUpCard;", "is43", "", "getUpCardCoverSize", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "cardCount", "widgetSize", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UpCardCoverUtilKt {
    public static final String getUpCardCover(UpCardWidgetData data, WidgetUpCard item, boolean is43) {
        Intrinsics.checkNotNullParameter(item, "item");
        boolean z = false;
        if (data != null && data.getStyle() == 6) {
            z = true;
        }
        if (z || is43) {
            String takeIfNotBlank = ListExtentionsKt.takeIfNotBlank(item.getCover43());
            return takeIfNotBlank == null ? item.getCover() : takeIfNotBlank;
        }
        return item.getCover();
    }

    public static /* synthetic */ Pair getUpCardCoverSize$default(Context context, UpCardWidgetData upCardWidgetData, int i, Pair pair, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            pair = null;
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        return getUpCardCoverSize(context, upCardWidgetData, i, pair, z);
    }

    public static final Pair<Integer, Integer> getUpCardCoverSize(Context context, UpCardWidgetData data, int cardCount, Pair<Integer, Integer> pair, boolean is43) {
        Pair targetSize;
        int targetWidth;
        int targetHeight;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        if (pair == null || ((Number) pair.getFirst()).intValue() <= 0 || ((Number) pair.getSecond()).intValue() <= 0) {
            targetSize = new Pair(Integer.valueOf(ScreenUtil.getScreenWidth(context)), Integer.valueOf(ListExtentionsKt.toPx((int) BR.coverHorizontal)));
        } else {
            targetSize = pair;
        }
        if (data.getStyle() == 6) {
            int height = ListExtentionsKt.toPx(((Number) targetSize.getSecond()).intValue());
            return new Pair<>(Integer.valueOf((int) (((height - ListExtentionsKt.toPx(24)) * 4.0f) / 3.0f)), Integer.valueOf(height));
        }
        int width = ListExtentionsKt.toPx(((Number) targetSize.getFirst()).intValue());
        switch (cardCount) {
            case 1:
                targetWidth = (width - ListExtentionsKt.toPx(24)) / 2;
                break;
            case 2:
                targetWidth = ((width - ListExtentionsKt.toPx(24)) - ListExtentionsKt.toPx(9)) / 2;
                break;
            default:
                targetWidth = (width - ListExtentionsKt.toPx(48)) / 3;
                break;
        }
        if (is43) {
            targetHeight = (int) ((targetWidth * 3.0f) / 4.0f);
        } else {
            targetHeight = (int) ((targetWidth * 9.0f) / 16.0f);
        }
        return new Pair<>(Integer.valueOf(targetWidth), Integer.valueOf(targetHeight));
    }
}