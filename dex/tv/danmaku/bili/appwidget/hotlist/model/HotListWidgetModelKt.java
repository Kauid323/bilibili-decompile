package tv.danmaku.bili.appwidget.hotlist.model;

import android.content.Context;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.utils.SpUtilKt;

/* compiled from: HotListWidgetModel.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\"\u001b\u0010\u0005\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"getLastWidgetData", "Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;", "context", "Landroid/content/Context;", "getLastOppoWidgetData", "defaultWidgetData", "getDefaultWidgetData", "()Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;", "defaultWidgetData$delegate", "Lkotlin/Lazy;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotListWidgetModelKt {
    private static final Lazy defaultWidgetData$delegate = ListExtentionsKt.lazyUnsafe(new Function0() { // from class: tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModelKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            HotListWidgetModel defaultWidgetData_delegate$lambda$0;
            defaultWidgetData_delegate$lambda$0 = HotListWidgetModelKt.defaultWidgetData_delegate$lambda$0();
            return defaultWidgetData_delegate$lambda$0;
        }
    });

    public static final HotListWidgetModel getLastWidgetData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SpUtilKt.getLocalWidgetData(context);
    }

    public static final HotListWidgetModel getLastOppoWidgetData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SpUtilKt.getOppoLocalWidgetData(context);
    }

    public static final HotListWidgetModel getDefaultWidgetData() {
        return (HotListWidgetModel) defaultWidgetData$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HotListWidgetModel defaultWidgetData_delegate$lambda$0() {
        return new HotListWidgetModel(CollectionsKt.listOf(new HotListWidgetItemModel[]{new HotListWidgetItemModel("https://i0.hdslb.com/bfs/archive/e161008a0355e91901a8cf518becfa47261c607b.jpg", "4265.6万", "五分钟在家瘦腰运动！快速瘦肚子小蛮腰，马甲线一周现形！适合初学者【周六野Zoey】", "周六野Zoey", "bilibili://video/8775849?cid=14471402", "av", 8775849L, new HotListWidgetRcmdModel("千万播放"), 33, null, BR.roleType, null), new HotListWidgetItemModel("http://i1.hdslb.com/bfs/archive/ed2407e8dbeb232f8f001b87346eee1d5225631d.jpg", "163.7万", "熬夜后该如何补救？熬夜方式不同，事后补救的方法也应该不同 -【冷却报告】", "冷却报告", "bilibili://video/802511396?cid=324553164", "av", 802511396L, new HotListWidgetRcmdModel("每周必看"), 33, null, BR.roleType, null), new HotListWidgetItemModel("https://i0.hdslb.com/bfs/archive/fd8b6779af91782fc56fa7ce104395e529a9d266.jpg", "59.1万", "剧本都写不出来的综艺爆笑名场面", "娱东娱西", "bilibili://video/499909106?cid=246286580", "av", 499909106L, new HotListWidgetRcmdModel("八千点赞"), 33, null, BR.roleType, null)}));
    }
}