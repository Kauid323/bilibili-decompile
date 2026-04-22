package tv.danmaku.bili.appwidget.hotlist.moss;

import android.content.Context;
import com.bapis.bilibili.app.show.mixture.v1.ApiMossKtxKt;
import com.bapis.bilibili.app.show.mixture.v1.MixtureMoss;
import com.bapis.bilibili.app.show.mixture.v1.WidgetReply;
import com.bapis.bilibili.app.show.mixture.v1.WidgetReq;
import com.bilibili.lib.moss.api.CallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModel;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModelKt;
import tv.danmaku.bili.appwidget.hotlist.utils.RouterUtilKt;
import tv.danmaku.bili.appwidget.hotlist.utils.SpUtilKt;

/* compiled from: HotListMoss.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"TAG", "", "getHostListData", "Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOppoHostListData", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotListMossKt {
    private static final String TAG = "HotListMoss";

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getHostListData(Context context, Continuation<? super HotListWidgetModel> continuation) {
        HotListMossKt$getHostListData$1 hotListMossKt$getHostListData$1;
        Object suspendWidget;
        try {
            if (continuation instanceof HotListMossKt$getHostListData$1) {
                hotListMossKt$getHostListData$1 = (HotListMossKt$getHostListData$1) continuation;
                if ((hotListMossKt$getHostListData$1.label & Integer.MIN_VALUE) != 0) {
                    hotListMossKt$getHostListData$1.label -= Integer.MIN_VALUE;
                    Object $result = hotListMossKt$getHostListData$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (hotListMossKt$getHostListData$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            MixtureMoss mixtureMoss = new MixtureMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                            WidgetReq build = WidgetReq.newBuilder().setFromSpmid("main.widgets-page.0.0").setPageNo(SpUtilKt.getHotListPageNo(context)).build();
                            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                            hotListMossKt$getHostListData$1.L$0 = context;
                            hotListMossKt$getHostListData$1.label = 1;
                            suspendWidget = ApiMossKtxKt.suspendWidget(mixtureMoss, build, hotListMossKt$getHostListData$1);
                            if (suspendWidget == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            context = (Context) hotListMossKt$getHostListData$1.L$0;
                            ResultKt.throwOnFailure($result);
                            suspendWidget = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    WidgetReply p0 = (WidgetReply) suspendWidget;
                    HotListWidgetModel it = new HotListWidgetModel(p0);
                    SpUtilKt.saveWidgetData(context, it);
                    BLog.d(TAG, "get data success:" + it);
                    return it;
                }
            }
            switch (hotListMossKt$getHostListData$1.label) {
            }
            WidgetReply p02 = (WidgetReply) suspendWidget;
            HotListWidgetModel it2 = new HotListWidgetModel(p02);
            SpUtilKt.saveWidgetData(context, it2);
            BLog.d(TAG, "get data success:" + it2);
            return it2;
        } catch (Exception e) {
            BLog.e(TAG, "use default data because get hot list data error:", e);
            HotListWidgetModel lastWidgetData = HotListWidgetModelKt.getLastWidgetData(context);
            if (lastWidgetData == null) {
                lastWidgetData = HotListWidgetModelKt.getDefaultWidgetData();
            }
            return lastWidgetData;
        }
        hotListMossKt$getHostListData$1 = new HotListMossKt$getHostListData$1(continuation);
        Object $result2 = hotListMossKt$getHostListData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getOppoHostListData(Context context, Continuation<? super HotListWidgetModel> continuation) {
        HotListMossKt$getOppoHostListData$1 hotListMossKt$getOppoHostListData$1;
        Object suspendWidget;
        try {
            if (continuation instanceof HotListMossKt$getOppoHostListData$1) {
                hotListMossKt$getOppoHostListData$1 = (HotListMossKt$getOppoHostListData$1) continuation;
                if ((hotListMossKt$getOppoHostListData$1.label & Integer.MIN_VALUE) != 0) {
                    hotListMossKt$getOppoHostListData$1.label -= Integer.MIN_VALUE;
                    Object $result = hotListMossKt$getOppoHostListData$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (hotListMossKt$getOppoHostListData$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            MixtureMoss mixtureMoss = new MixtureMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                            WidgetReq build = WidgetReq.newBuilder().setFromSpmid(RouterUtilKt.OPPO_HOT_LIST_WIDGET_SPMID).setPageNo(SpUtilKt.getOppoHotListPageNo(context)).build();
                            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                            hotListMossKt$getOppoHostListData$1.L$0 = context;
                            hotListMossKt$getOppoHostListData$1.label = 1;
                            suspendWidget = ApiMossKtxKt.suspendWidget(mixtureMoss, build, hotListMossKt$getOppoHostListData$1);
                            if (suspendWidget == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            context = (Context) hotListMossKt$getOppoHostListData$1.L$0;
                            ResultKt.throwOnFailure($result);
                            suspendWidget = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    WidgetReply p0 = (WidgetReply) suspendWidget;
                    HotListWidgetModel it = new HotListWidgetModel(p0);
                    SpUtilKt.saveOppoWidgetData(context, it);
                    BLog.i(TAG, "get data success:" + it);
                    return it;
                }
            }
            switch (hotListMossKt$getOppoHostListData$1.label) {
            }
            WidgetReply p02 = (WidgetReply) suspendWidget;
            HotListWidgetModel it2 = new HotListWidgetModel(p02);
            SpUtilKt.saveOppoWidgetData(context, it2);
            BLog.i(TAG, "get data success:" + it2);
            return it2;
        } catch (Exception e) {
            BLog.e(TAG, "use default data because get hot list data error:", e);
            HotListWidgetModel lastOppoWidgetData = HotListWidgetModelKt.getLastOppoWidgetData(context);
            if (lastOppoWidgetData == null) {
                lastOppoWidgetData = HotListWidgetModelKt.getDefaultWidgetData();
            }
            return lastOppoWidgetData;
        }
        hotListMossKt$getOppoHostListData$1 = new HotListMossKt$getOppoHostListData$1(continuation);
        Object $result2 = hotListMossKt$getOppoHostListData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}