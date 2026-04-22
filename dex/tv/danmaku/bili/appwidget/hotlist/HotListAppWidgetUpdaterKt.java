package tv.danmaku.bili.appwidget.hotlist;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.SizeF;
import android.widget.RemoteViews;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.droid.ScreenUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetItemModel;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModel;
import tv.danmaku.bili.appwidget.hotlist.utils.SpUtilKt;
import tv.danmaku.bili.appwidget.hotlist.utils.WidgetSizeUtilKt;
import tv.danmaku.bili.appwidget.hotlist.view.HotListCardType;
import tv.danmaku.bili.appwidget.hotlist.view.HotListWidgetViewKt;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: HotListAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002\u001a>\u0010\u000b\u001a\u00020\u0007*\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015\u001aL\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0082@¢\u0006\u0002\u0010\u001a\u001aB\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u001f\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"ALLOW_LOAD_LOCAL_DATA_LIST", "", "", "ALLOW_LOAD_REMOTE_DATA_LIST", "ALLOW_LOAD_DEFAULT_IF_LOCAL_NULL", "TAG", ReportUtilKt.POS_UPDATE, "", "context", "Landroid/content/Context;", "updateReason", "updateWidgetView", "Lkotlinx/coroutines/CoroutineScope;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "data", "Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;", "appStatus", "", "(Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[ILtv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidgetViewAfterDownload", "coverBitmaps", "", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;Ljava/util/List;ILandroid/appwidget/AppWidgetManager;[ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWidgetView", "Landroid/widget/RemoteViews;", "cardType", "Ltv/danmaku/bili/appwidget/hotlist/view/HotListCardType;", "(Landroid/content/Context;Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;Ljava/util/List;Ltv/danmaku/bili/appwidget/hotlist/view/HotListCardType;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotListAppWidgetUpdaterKt {
    private static final String TAG = "HotListAppWidgetUpdater";
    private static final List<String> ALLOW_LOAD_LOCAL_DATA_LIST = CollectionsKt.listOf(new String[]{"tv.danmaku.bili.action.appwidget.IN_BACKGROUND", "android.intent.action.PACKAGE_CHANGED", "tv.danmaku.bili.action.appwidget.LAUNCH_APP", "android.appwidget.action.APPWIDGET_UPDATE", "tv.danmaku.bili.action.appwidget.RESTRICTED_MODE"});
    private static final List<String> ALLOW_LOAD_REMOTE_DATA_LIST = CollectionsKt.listOf(new String[]{"android.appwidget.action.APPWIDGET_UPDATE", "tv.danmaku.bili.action.appwidget.EXCHANGE_CLICK", "tv.danmaku.bili.action.appwidget.LAUNCH_APP"});
    private static final List<String> ALLOW_LOAD_DEFAULT_IF_LOCAL_NULL = CollectionsKt.listOf(new String[]{"tv.danmaku.bili.action.appwidget.IN_BACKGROUND", "tv.danmaku.bili.action.appwidget.LAUNCH_APP", "android.intent.action.PACKAGE_CHANGED"});

    public static final void update(Context context, String updateReason) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updateReason, "updateReason");
        BLog.i(TAG, "update reason:" + updateReason);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (appWidgetManager == null) {
            return;
        }
        int[] widgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, HotListAppWidget.class));
        BLog.i(TAG, "onUpdate:" + Arrays.toString(widgetIds));
        if (widgetIds != null) {
            if (widgetIds.length == 0) {
                return;
            }
            Ref.IntRef appStatus = new Ref.IntRef();
            if (DelayTaskController.shouldBlock()) {
                BLog.i(TAG, "not agree privacy agreement.");
                appStatus.element = 1;
            }
            if (SpUtilKt.isRestrictedTeenagerMode(context)) {
                BLog.i(TAG, "teenager mode");
                appStatus.element = 2;
            }
            if (SpUtilKt.isRestrictedLessonMode(context)) {
                BLog.i(TAG, "lessons mode");
                appStatus.element = 3;
            }
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new HotListAppWidgetUpdaterKt$update$1(appStatus, updateReason, context, appWidgetManager, widgetIds, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc A[LOOP:0: B:30:0x00da->B:31:0x00dc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object updateWidgetView(CoroutineScope $this$updateWidgetView, Context context, AppWidgetManager appWidgetManager, int[] iArr, HotListWidgetModel data, int i, Continuation<? super Unit> continuation) {
        HotListAppWidgetUpdaterKt$updateWidgetView$1 hotListAppWidgetUpdaterKt$updateWidgetView$1;
        int[] appWidgetIds;
        int appStatus;
        int size;
        CoroutineScope $this$updateWidgetView2;
        AppWidgetManager appWidgetManager2;
        HotListWidgetModel data2;
        Context context2;
        CoroutineScope $this$updateWidgetView3;
        AppWidgetManager appWidgetManager3;
        Context context3;
        int size2;
        int appStatus2;
        int[] appWidgetIds2;
        List<HotListWidgetItemModel> items;
        Iterable items2;
        if (continuation instanceof HotListAppWidgetUpdaterKt$updateWidgetView$1) {
            hotListAppWidgetUpdaterKt$updateWidgetView$1 = (HotListAppWidgetUpdaterKt$updateWidgetView$1) continuation;
            if ((hotListAppWidgetUpdaterKt$updateWidgetView$1.label & Integer.MIN_VALUE) != 0) {
                hotListAppWidgetUpdaterKt$updateWidgetView$1.label -= Integer.MIN_VALUE;
                Object $result = hotListAppWidgetUpdaterKt$updateWidgetView$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (hotListAppWidgetUpdaterKt$updateWidgetView$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        appWidgetIds = iArr;
                        appStatus = i;
                        if (appStatus == 0) {
                            size = (data == null || (items = data.getItems()) == null) ? 0 : items.size();
                            BLog.i(TAG, "pic download start size:" + size);
                            if (size <= 0) {
                                hotListAppWidgetUpdaterKt$updateWidgetView$1.L$0 = $this$updateWidgetView;
                                hotListAppWidgetUpdaterKt$updateWidgetView$1.L$1 = context;
                                hotListAppWidgetUpdaterKt$updateWidgetView$1.L$2 = appWidgetManager;
                                hotListAppWidgetUpdaterKt$updateWidgetView$1.L$3 = appWidgetIds;
                                hotListAppWidgetUpdaterKt$updateWidgetView$1.L$4 = data;
                                hotListAppWidgetUpdaterKt$updateWidgetView$1.I$0 = appStatus;
                                hotListAppWidgetUpdaterKt$updateWidgetView$1.I$1 = size;
                                hotListAppWidgetUpdaterKt$updateWidgetView$1.label = 1;
                                if (updateWidgetViewAfterDownload(context, data, null, appStatus, appWidgetManager, appWidgetIds, hotListAppWidgetUpdaterKt$updateWidgetView$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$updateWidgetView3 = $this$updateWidgetView;
                                appWidgetManager3 = appWidgetManager;
                                data2 = data;
                                context3 = context;
                                size2 = size;
                                appStatus2 = appStatus;
                                appWidgetIds2 = appWidgetIds;
                                AppWidgetManager appWidgetManager4 = appWidgetManager3;
                                size = size2;
                                $this$updateWidgetView2 = $this$updateWidgetView3;
                                appWidgetIds = appWidgetIds2;
                                context2 = context3;
                                appStatus = appStatus2;
                                appWidgetManager2 = appWidgetManager4;
                                ArrayList arrayList = new ArrayList(size);
                                for (int i2 = 0; i2 < size; i2++) {
                                    arrayList.add(null);
                                }
                                CopyOnWriteArrayList coverBitmaps = new CopyOnWriteArrayList(arrayList);
                                int bitmapMaxSize = (ScreenUtil.getScreenWidth(context2) - ListExtentionsKt.toPx(48)) / 3;
                                if (data2 != null && (items2 = data2.getItems()) != null) {
                                    Iterable $this$forEachIndexed$iv = items2;
                                    int index$iv = 0;
                                    for (Object item$iv : $this$forEachIndexed$iv) {
                                        int index$iv2 = index$iv + 1;
                                        if (index$iv < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        HotListWidgetItemModel hotListWidgetItemModel = (HotListWidgetItemModel) item$iv;
                                        int index = index$iv;
                                        BuildersKt.launch$default($this$updateWidgetView2, (CoroutineContext) null, (CoroutineStart) null, new HotListAppWidgetUpdaterKt$updateWidgetView$2$1(context2, hotListWidgetItemModel, bitmapMaxSize, coverBitmaps, index, data2, appStatus, appWidgetManager2, appWidgetIds, null), 3, (Object) null);
                                        index$iv = index$iv2;
                                    }
                                    break;
                                }
                            } else {
                                $this$updateWidgetView2 = $this$updateWidgetView;
                                appWidgetManager2 = appWidgetManager;
                                data2 = data;
                                context2 = context;
                                ArrayList arrayList2 = new ArrayList(size);
                                while (i2 < size) {
                                }
                                CopyOnWriteArrayList coverBitmaps2 = new CopyOnWriteArrayList(arrayList2);
                                int bitmapMaxSize2 = (ScreenUtil.getScreenWidth(context2) - ListExtentionsKt.toPx(48)) / 3;
                                if (data2 != null) {
                                    Iterable $this$forEachIndexed$iv2 = items2;
                                    int index$iv3 = 0;
                                    while (r23.hasNext()) {
                                    }
                                }
                            }
                        } else {
                            hotListAppWidgetUpdaterKt$updateWidgetView$1.label = 2;
                            if (updateWidgetViewAfterDownload(context, data, null, appStatus, appWidgetManager, appWidgetIds, hotListAppWidgetUpdaterKt$updateWidgetView$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        break;
                    case 1:
                        size2 = hotListAppWidgetUpdaterKt$updateWidgetView$1.I$1;
                        appStatus2 = hotListAppWidgetUpdaterKt$updateWidgetView$1.I$0;
                        data2 = (HotListWidgetModel) hotListAppWidgetUpdaterKt$updateWidgetView$1.L$4;
                        appWidgetIds2 = (int[]) hotListAppWidgetUpdaterKt$updateWidgetView$1.L$3;
                        appWidgetManager3 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetView$1.L$2;
                        context3 = (Context) hotListAppWidgetUpdaterKt$updateWidgetView$1.L$1;
                        $this$updateWidgetView3 = (CoroutineScope) hotListAppWidgetUpdaterKt$updateWidgetView$1.L$0;
                        ResultKt.throwOnFailure($result);
                        AppWidgetManager appWidgetManager42 = appWidgetManager3;
                        size = size2;
                        $this$updateWidgetView2 = $this$updateWidgetView3;
                        appWidgetIds = appWidgetIds2;
                        context2 = context3;
                        appStatus = appStatus2;
                        appWidgetManager2 = appWidgetManager42;
                        ArrayList arrayList22 = new ArrayList(size);
                        while (i2 < size) {
                        }
                        CopyOnWriteArrayList coverBitmaps22 = new CopyOnWriteArrayList(arrayList22);
                        int bitmapMaxSize22 = (ScreenUtil.getScreenWidth(context2) - ListExtentionsKt.toPx(48)) / 3;
                        if (data2 != null) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        hotListAppWidgetUpdaterKt$updateWidgetView$1 = new HotListAppWidgetUpdaterKt$updateWidgetView$1(continuation);
        Object $result2 = hotListAppWidgetUpdaterKt$updateWidgetView$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (hotListAppWidgetUpdaterKt$updateWidgetView$1.label) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01ee A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0234 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03cb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x02b5 -> B:63:0x03bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0311 -> B:63:0x03bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x036d -> B:63:0x03bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x03af -> B:62:0x03b2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object updateWidgetViewAfterDownload(Context context, HotListWidgetModel data, List<Bitmap> list, int i, AppWidgetManager appWidgetManager, int[] appWidgetIds, Continuation<? super Unit> continuation) {
        HotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1 hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1;
        int appStatus;
        int appStatus2;
        int length;
        AppWidgetManager appWidgetManager2;
        Context context2;
        int appStatus3;
        int[] $this$forEach$iv;
        int $i$f$forEach;
        HotListWidgetModel data2;
        List coverBitmaps;
        SizeF sizeF;
        Object createWidgetView;
        Pair[] pairArr;
        Context context3;
        HotListWidgetModel data3;
        int appStatus4;
        List<Bitmap> list2;
        AppWidgetManager appWidgetManager3;
        int[] appWidgetIds2;
        Pair[] pairArr2;
        SizeF sizeF2;
        Object createWidgetView2;
        Pair[] pairArr3;
        int i2;
        Object obj;
        int appStatus5;
        Context context4;
        Object createWidgetView3;
        SizeF sizeF3;
        int i3;
        Pair[] pairArr4;
        int[] appWidgetIds3;
        AppWidgetManager appWidgetManager4;
        Context context5;
        AppWidgetManager appWidgetManager5;
        int i4;
        int $i$f$forEach2;
        Object obj2;
        Object $result;
        boolean z;
        int it;
        int i5;
        int i6;
        int appStatus6;
        AppWidgetManager appWidgetManager6;
        int[] $this$forEach$iv2;
        AppWidgetManager appWidgetManager7;
        List coverBitmaps2;
        HotListWidgetModel data4;
        Context context6;
        Object $result2;
        int i7;
        int i8;
        int appStatus7;
        AppWidgetManager appWidgetManager8;
        int[] $this$forEach$iv3;
        List coverBitmaps3;
        HotListWidgetModel data5;
        RemoteViews remoteViews;
        int[] $this$forEach$iv4;
        HotListWidgetModel data6;
        AppWidgetManager appWidgetManager9;
        Continuation $completion = continuation;
        if ($completion instanceof HotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1) {
            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1 = (HotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1) $completion;
            if ((hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label & Integer.MIN_VALUE) != 0) {
                hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label -= Integer.MIN_VALUE;
                Object $result3 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.result;
                Object $result4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        appStatus = i;
                        if (Build.VERSION.SDK_INT >= 31) {
                            Pair[] pairArr5 = new Pair[3];
                            sizeF = new SizeF(320.0f, 140.0f);
                            HotListCardType hotListCardType = HotListCardType.SMALL_CARD;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0 = context;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1 = data;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2 = list;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3 = appWidgetManager;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4 = appWidgetIds;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5 = pairArr5;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$6 = pairArr5;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$7 = sizeF;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0 = appStatus;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1 = 0;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label = 1;
                            createWidgetView = createWidgetView(context, data, list, hotListCardType, appStatus, hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1);
                            if (createWidgetView == $result4) {
                                return $result4;
                            }
                            pairArr = pairArr5;
                            context3 = context;
                            data3 = data;
                            appStatus4 = 0;
                            list2 = list;
                            appWidgetManager3 = appWidgetManager;
                            appWidgetIds2 = appWidgetIds;
                            pairArr2 = pairArr;
                            pairArr[appStatus4] = TuplesKt.to(sizeF, createWidgetView);
                            sizeF2 = new SizeF(320.0f, 160.0f);
                            HotListCardType hotListCardType2 = HotListCardType.MIDDLE_CARD;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0 = context3;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1 = data3;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2 = list2;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3 = appWidgetManager3;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4 = appWidgetIds2;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5 = pairArr2;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$6 = pairArr2;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$7 = sizeF2;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0 = appStatus;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1 = 1;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label = 2;
                            createWidgetView2 = createWidgetView(context3, data3, list2, hotListCardType2, appStatus, hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1);
                            if (createWidgetView2 != $result4) {
                                return $result4;
                            }
                            pairArr3 = pairArr2;
                            i2 = 1;
                            Context context7 = context3;
                            obj = createWidgetView2;
                            appStatus5 = appStatus;
                            context4 = context7;
                            pairArr3[i2] = TuplesKt.to(sizeF2, obj);
                            SizeF sizeF4 = new SizeF(320.0f, 180.0f);
                            HotListCardType hotListCardType3 = HotListCardType.LARGE_CARD;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0 = appWidgetManager3;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1 = appWidgetIds2;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2 = pairArr2;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3 = pairArr2;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4 = sizeF4;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5 = null;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$6 = null;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$7 = null;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0 = 2;
                            hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label = 3;
                            createWidgetView3 = createWidgetView(context4, data3, list2, hotListCardType3, appStatus5, hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1);
                            if (createWidgetView3 != $result4) {
                                return $result4;
                            }
                            sizeF3 = sizeF4;
                            i3 = 2;
                            pairArr4 = pairArr2;
                            appWidgetIds3 = appWidgetIds2;
                            appWidgetManager4 = appWidgetManager3;
                            pairArr2[i3] = TuplesKt.to(sizeF3, createWidgetView3);
                            RemoteViews it2 = new RemoteViews(MapsKt.mapOf(pairArr4));
                            appWidgetManager4.updateAppWidget(appWidgetIds3, it2);
                            return Unit.INSTANCE;
                        }
                        if (appWidgetIds != null) {
                            appStatus2 = appStatus;
                            length = appWidgetIds.length;
                            appWidgetManager2 = appWidgetManager;
                            context2 = context;
                            appStatus3 = 0;
                            $this$forEach$iv = appWidgetIds;
                            $i$f$forEach = 0;
                            data2 = data;
                            coverBitmaps = list;
                            if (appStatus3 < length) {
                                int element$iv = $this$forEach$iv[appStatus3];
                                it = element$iv;
                                z = false;
                                Pair size = WidgetSizeUtilKt.getWidgetsSize(context2, appWidgetManager2, it);
                                if (((Number) size.getSecond()).intValue() == 0) {
                                    HotListCardType hotListCardType4 = HotListCardType.MIDDLE_CARD;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0 = context2;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1 = data2;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2 = coverBitmaps;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3 = appWidgetManager2;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4 = $this$forEach$iv;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5 = appWidgetManager2;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0 = appStatus2;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1 = appStatus3;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$2 = length;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$3 = it;
                                    Continuation $completion2 = $completion;
                                    hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label = 4;
                                    Object createWidgetView4 = createWidgetView(context2, data2, coverBitmaps, hotListCardType4, appStatus2, hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1);
                                    if (createWidgetView4 == $result4) {
                                        return $result4;
                                    }
                                    context5 = context2;
                                    appWidgetManager5 = appWidgetManager2;
                                    i4 = it;
                                    $i$f$forEach2 = $i$f$forEach;
                                    obj2 = $result4;
                                    $result = $result3;
                                    $result3 = createWidgetView4;
                                    $completion = $completion2;
                                    remoteViews = (RemoteViews) $result3;
                                    Context context8 = context5;
                                    $result2 = $result;
                                    $result4 = obj2;
                                    $i$f$forEach = $i$f$forEach2;
                                    $this$forEach$iv4 = $this$forEach$iv;
                                    appWidgetManager7 = appWidgetManager5;
                                    data6 = data2;
                                    context6 = context8;
                                    appWidgetManager2.updateAppWidget(i4, remoteViews);
                                    appStatus3++;
                                    appWidgetManager2 = appWidgetManager7;
                                    context2 = context6;
                                    $result3 = $result2;
                                    $this$forEach$iv = $this$forEach$iv4;
                                    data2 = data6;
                                    if (appStatus3 < length) {
                                    }
                                } else {
                                    Continuation $completion3 = $completion;
                                    $result2 = $result3;
                                    if (((Number) size.getSecond()).intValue() < 160) {
                                        HotListCardType hotListCardType5 = HotListCardType.SMALL_CARD;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0 = context2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1 = data2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2 = coverBitmaps;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3 = appWidgetManager2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4 = $this$forEach$iv;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5 = appWidgetManager2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0 = appStatus2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1 = appStatus3;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$2 = length;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$3 = it;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label = 5;
                                        $result3 = createWidgetView(context2, data2, coverBitmaps, hotListCardType5, appStatus2, hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1);
                                        if ($result3 == $result4) {
                                            return $result4;
                                        }
                                        $completion = $completion3;
                                        coverBitmaps2 = coverBitmaps;
                                        data4 = data2;
                                        context6 = context2;
                                        i5 = length;
                                        i6 = appStatus3;
                                        appStatus6 = appStatus2;
                                        appWidgetManager6 = appWidgetManager2;
                                        $this$forEach$iv2 = $this$forEach$iv;
                                        appWidgetManager7 = appWidgetManager6;
                                        remoteViews = (RemoteViews) $result3;
                                        $this$forEach$iv4 = $this$forEach$iv2;
                                        appWidgetManager2 = appWidgetManager6;
                                        appStatus2 = appStatus6;
                                        appStatus3 = i6;
                                        length = i5;
                                        i4 = it;
                                        HotListWidgetModel hotListWidgetModel = data4;
                                        coverBitmaps = coverBitmaps2;
                                        data6 = hotListWidgetModel;
                                        appWidgetManager2.updateAppWidget(i4, remoteViews);
                                        appStatus3++;
                                        appWidgetManager2 = appWidgetManager7;
                                        context2 = context6;
                                        $result3 = $result2;
                                        $this$forEach$iv = $this$forEach$iv4;
                                        data2 = data6;
                                        if (appStatus3 < length) {
                                        }
                                    } else if (((Number) size.getSecond()).intValue() < 180) {
                                        HotListCardType hotListCardType6 = HotListCardType.MIDDLE_CARD;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0 = context2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1 = data2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2 = coverBitmaps;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3 = appWidgetManager2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4 = $this$forEach$iv;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5 = appWidgetManager2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0 = appStatus2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1 = appStatus3;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$2 = length;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$3 = it;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label = 6;
                                        $result3 = createWidgetView(context2, data2, coverBitmaps, hotListCardType6, appStatus2, hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1);
                                        if ($result3 == $result4) {
                                            return $result4;
                                        }
                                        $completion = $completion3;
                                        coverBitmaps3 = coverBitmaps;
                                        data5 = data2;
                                        context6 = context2;
                                        i7 = length;
                                        i8 = appStatus3;
                                        appStatus7 = appStatus2;
                                        appWidgetManager8 = appWidgetManager2;
                                        $this$forEach$iv3 = $this$forEach$iv;
                                        appWidgetManager7 = appWidgetManager8;
                                        remoteViews = (RemoteViews) $result3;
                                        $this$forEach$iv4 = $this$forEach$iv3;
                                        appWidgetManager2 = appWidgetManager8;
                                        appStatus2 = appStatus7;
                                        appStatus3 = i8;
                                        length = i7;
                                        i4 = it;
                                        HotListWidgetModel hotListWidgetModel2 = data5;
                                        coverBitmaps = coverBitmaps3;
                                        data6 = hotListWidgetModel2;
                                        appWidgetManager2.updateAppWidget(i4, remoteViews);
                                        appStatus3++;
                                        appWidgetManager2 = appWidgetManager7;
                                        context2 = context6;
                                        $result3 = $result2;
                                        $this$forEach$iv = $this$forEach$iv4;
                                        data2 = data6;
                                        if (appStatus3 < length) {
                                        }
                                    } else {
                                        HotListCardType hotListCardType7 = HotListCardType.LARGE_CARD;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0 = context2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1 = data2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2 = coverBitmaps;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3 = appWidgetManager2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4 = $this$forEach$iv;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5 = appWidgetManager2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0 = appStatus2;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1 = appStatus3;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$2 = length;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$3 = it;
                                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label = 7;
                                        $result3 = createWidgetView(context2, data2, coverBitmaps, hotListCardType7, appStatus2, hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1);
                                        if ($result3 == $result4) {
                                            return $result4;
                                        }
                                        $completion = $completion3;
                                        appWidgetManager9 = appWidgetManager2;
                                        remoteViews = (RemoteViews) $result3;
                                        $this$forEach$iv4 = $this$forEach$iv;
                                        appWidgetManager7 = appWidgetManager9;
                                        data6 = data2;
                                        context6 = context2;
                                        i4 = it;
                                        appWidgetManager2.updateAppWidget(i4, remoteViews);
                                        appStatus3++;
                                        appWidgetManager2 = appWidgetManager7;
                                        context2 = context6;
                                        $result3 = $result2;
                                        $this$forEach$iv = $this$forEach$iv4;
                                        data2 = data6;
                                        if (appStatus3 < length) {
                                        }
                                    }
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        appStatus4 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1;
                        appStatus = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0;
                        sizeF = (SizeF) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$7;
                        ResultKt.throwOnFailure($result3);
                        context3 = (Context) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0;
                        data3 = (HotListWidgetModel) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1;
                        list2 = (List) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2;
                        appWidgetManager3 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3;
                        appWidgetIds2 = (int[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4;
                        pairArr2 = (Pair[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5;
                        pairArr = (Pair[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$6;
                        createWidgetView = $result3;
                        pairArr[appStatus4] = TuplesKt.to(sizeF, createWidgetView);
                        sizeF2 = new SizeF(320.0f, 160.0f);
                        HotListCardType hotListCardType22 = HotListCardType.MIDDLE_CARD;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0 = context3;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1 = data3;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2 = list2;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3 = appWidgetManager3;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4 = appWidgetIds2;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5 = pairArr2;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$6 = pairArr2;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$7 = sizeF2;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0 = appStatus;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1 = 1;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label = 2;
                        createWidgetView2 = createWidgetView(context3, data3, list2, hotListCardType22, appStatus, hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1);
                        if (createWidgetView2 != $result4) {
                        }
                        break;
                    case 2:
                        i2 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1;
                        appStatus5 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0;
                        sizeF2 = (SizeF) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$7;
                        pairArr3 = (Pair[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$6;
                        pairArr2 = (Pair[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5;
                        appWidgetIds2 = (int[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4;
                        appWidgetManager3 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3;
                        list2 = (List) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2;
                        data3 = (HotListWidgetModel) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1;
                        context4 = (Context) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0;
                        ResultKt.throwOnFailure($result3);
                        obj = $result3;
                        pairArr3[i2] = TuplesKt.to(sizeF2, obj);
                        SizeF sizeF42 = new SizeF(320.0f, 180.0f);
                        HotListCardType hotListCardType32 = HotListCardType.LARGE_CARD;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0 = appWidgetManager3;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1 = appWidgetIds2;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2 = pairArr2;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3 = pairArr2;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4 = sizeF42;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5 = null;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$6 = null;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$7 = null;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0 = 2;
                        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label = 3;
                        createWidgetView3 = createWidgetView(context4, data3, list2, hotListCardType32, appStatus5, hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1);
                        if (createWidgetView3 != $result4) {
                        }
                        break;
                    case 3:
                        i3 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0;
                        sizeF3 = (SizeF) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4;
                        pairArr4 = (Pair[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2;
                        appWidgetIds3 = (int[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1;
                        appWidgetManager4 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0;
                        ResultKt.throwOnFailure($result3);
                        pairArr2 = (Pair[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3;
                        createWidgetView3 = $result3;
                        pairArr2[i3] = TuplesKt.to(sizeF3, createWidgetView3);
                        RemoteViews it22 = new RemoteViews(MapsKt.mapOf(pairArr4));
                        appWidgetManager4.updateAppWidget(appWidgetIds3, it22);
                        return Unit.INSTANCE;
                    case 4:
                        int i9 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$3;
                        int i10 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$2;
                        int i11 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1;
                        int appStatus8 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0;
                        int[] $this$forEach$iv5 = (int[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4;
                        ResultKt.throwOnFailure($result3);
                        context5 = (Context) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0;
                        data2 = (HotListWidgetModel) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1;
                        coverBitmaps = (List) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2;
                        appWidgetManager5 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3;
                        $this$forEach$iv = $this$forEach$iv5;
                        appWidgetManager2 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5;
                        appStatus2 = appStatus8;
                        appStatus3 = i11;
                        length = i10;
                        i4 = i9;
                        $i$f$forEach2 = 0;
                        obj2 = $result4;
                        $result = $result3;
                        remoteViews = (RemoteViews) $result3;
                        Context context82 = context5;
                        $result2 = $result;
                        $result4 = obj2;
                        $i$f$forEach = $i$f$forEach2;
                        $this$forEach$iv4 = $this$forEach$iv;
                        appWidgetManager7 = appWidgetManager5;
                        data6 = data2;
                        context6 = context82;
                        appWidgetManager2.updateAppWidget(i4, remoteViews);
                        appStatus3++;
                        appWidgetManager2 = appWidgetManager7;
                        context2 = context6;
                        $result3 = $result2;
                        $this$forEach$iv = $this$forEach$iv4;
                        data2 = data6;
                        if (appStatus3 < length) {
                        }
                        break;
                    case 5:
                        $i$f$forEach = 0;
                        z = false;
                        it = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$3;
                        i5 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$2;
                        i6 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1;
                        appStatus6 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0;
                        appWidgetManager6 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5;
                        $this$forEach$iv2 = (int[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4;
                        appWidgetManager7 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3;
                        coverBitmaps2 = (List) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2;
                        data4 = (HotListWidgetModel) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1;
                        context6 = (Context) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0;
                        ResultKt.throwOnFailure($result3);
                        $result2 = $result3;
                        remoteViews = (RemoteViews) $result3;
                        $this$forEach$iv4 = $this$forEach$iv2;
                        appWidgetManager2 = appWidgetManager6;
                        appStatus2 = appStatus6;
                        appStatus3 = i6;
                        length = i5;
                        i4 = it;
                        HotListWidgetModel hotListWidgetModel3 = data4;
                        coverBitmaps = coverBitmaps2;
                        data6 = hotListWidgetModel3;
                        appWidgetManager2.updateAppWidget(i4, remoteViews);
                        appStatus3++;
                        appWidgetManager2 = appWidgetManager7;
                        context2 = context6;
                        $result3 = $result2;
                        $this$forEach$iv = $this$forEach$iv4;
                        data2 = data6;
                        if (appStatus3 < length) {
                        }
                        break;
                    case 6:
                        $i$f$forEach = 0;
                        z = false;
                        it = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$3;
                        i7 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$2;
                        i8 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1;
                        appStatus7 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0;
                        appWidgetManager8 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5;
                        $this$forEach$iv3 = (int[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4;
                        appWidgetManager7 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3;
                        coverBitmaps3 = (List) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2;
                        data5 = (HotListWidgetModel) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1;
                        context6 = (Context) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0;
                        ResultKt.throwOnFailure($result3);
                        $result2 = $result3;
                        remoteViews = (RemoteViews) $result3;
                        $this$forEach$iv4 = $this$forEach$iv3;
                        appWidgetManager2 = appWidgetManager8;
                        appStatus2 = appStatus7;
                        appStatus3 = i8;
                        length = i7;
                        i4 = it;
                        HotListWidgetModel hotListWidgetModel22 = data5;
                        coverBitmaps = coverBitmaps3;
                        data6 = hotListWidgetModel22;
                        appWidgetManager2.updateAppWidget(i4, remoteViews);
                        appStatus3++;
                        appWidgetManager2 = appWidgetManager7;
                        context2 = context6;
                        $result3 = $result2;
                        $this$forEach$iv = $this$forEach$iv4;
                        data2 = data6;
                        if (appStatus3 < length) {
                        }
                        break;
                    case 7:
                        $i$f$forEach = 0;
                        z = false;
                        it = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$3;
                        length = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$2;
                        appStatus3 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$1;
                        appStatus2 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.I$0;
                        appWidgetManager2 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$5;
                        $this$forEach$iv = (int[]) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$4;
                        appWidgetManager9 = (AppWidgetManager) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$3;
                        coverBitmaps = (List) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$2;
                        data2 = (HotListWidgetModel) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$1;
                        context2 = (Context) hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.L$0;
                        ResultKt.throwOnFailure($result3);
                        $result2 = $result3;
                        remoteViews = (RemoteViews) $result3;
                        $this$forEach$iv4 = $this$forEach$iv;
                        appWidgetManager7 = appWidgetManager9;
                        data6 = data2;
                        context6 = context2;
                        i4 = it;
                        appWidgetManager2.updateAppWidget(i4, remoteViews);
                        appStatus3++;
                        appWidgetManager2 = appWidgetManager7;
                        context2 = context6;
                        $result3 = $result2;
                        $this$forEach$iv = $this$forEach$iv4;
                        data2 = data6;
                        if (appStatus3 < length) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1 = new HotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1($completion);
        Object $result32 = hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.result;
        Object $result42 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (hotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createWidgetView(Context context, HotListWidgetModel data, List<Bitmap> list, HotListCardType cardType, int appStatus, Continuation<? super RemoteViews> continuation) {
        switch (appStatus) {
            case 1:
                return HotListWidgetViewKt.showBlockWidgetView(context);
            case 2:
                return HotListWidgetViewKt.showTeenagerWidgetView(context, cardType);
            case 3:
                return HotListWidgetViewKt.showLessonsWidgetView(context, cardType);
            default:
                return HotListWidgetViewKt.createHotListWidgetView(context, data, list, cardType, continuation);
        }
    }
}