package tv.danmaku.bili.appwidget.upcard;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.RemoteViews;
import com.bilibili.base.util.DelayTaskController;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.utils.WidgetSizeUtilKt;
import tv.danmaku.bili.appwidget.upcard.data.Owner;
import tv.danmaku.bili.appwidget.upcard.data.UpCardWidgetData;
import tv.danmaku.bili.appwidget.upcard.data.WidgetUpCard;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.appwidget.upcard.utils.SpUtilKt;
import tv.danmaku.bili.appwidget.upcard.view.UpCardType;
import tv.danmaku.bili.appwidget.upcard.view.UpCardWidgetViewKt;

/* compiled from: UpCardAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002\u001a>\u0010\u000b\u001a\u00020\u0007*\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015\u001aX\u0010\u0016\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0002\u0010\u001b\u001aN\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0002\u0010 \u001a2\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010\b\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010%\u001a$\u0010&\u001a\u0004\u0018\u00010\u00192\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"ALLOW_LOAD_LOCAL_DATA_LIST", "", "", "ALLOW_LOAD_REMOTE_DATA_LIST", "ALLOW_LOAD_DEFAULT_IF_LOCAL_NULL", "TAG", ReportUtilKt.POS_UPDATE, "", "context", "Landroid/content/Context;", "updateReason", "updateWidgetView", "Lkotlinx/coroutines/CoroutineScope;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "data", "Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;", "appStatus", "", "(Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[ILtv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidgetBySizes", "coverBitmaps", "", "Landroid/graphics/Bitmap;", "avatarBitmap", "([ILandroid/content/Context;Landroid/appwidget/AppWidgetManager;Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;Ljava/util/List;ILandroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWidgetView", "Landroid/widget/RemoteViews;", "cardType", "Ltv/danmaku/bili/appwidget/upcard/view/UpCardType;", "(Landroid/content/Context;Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;Ljava/util/List;Ltv/danmaku/bili/appwidget/upcard/view/UpCardType;ILandroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadImage", "url", "width", "height", "(Landroid/content/Context;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBitmapFromFile", "file", "Ljava/io/File;", "desiredWidth", "desiredHeight", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UpCardAppWidgetUpdaterKt {
    private static final String TAG = "UpCardAppWidgetUpdater";
    private static final List<String> ALLOW_LOAD_LOCAL_DATA_LIST = CollectionsKt.listOf(new String[]{"tv.danmaku.bili.action.appwidget.IN_BACKGROUND", "android.intent.action.PACKAGE_CHANGED", "tv.danmaku.bili.action.appwidget.LAUNCH_APP", "android.appwidget.action.APPWIDGET_UPDATE", "tv.danmaku.bili.action.appwidget.RESTRICTED_MODE"});
    private static final List<String> ALLOW_LOAD_REMOTE_DATA_LIST = CollectionsKt.listOf(new String[]{"android.appwidget.action.APPWIDGET_UPDATE", "tv.danmaku.bili.action.appwidget.LAUNCH_APP", UpCardAppWidgetKt.APP_WIDGET_LOGIN_CHANGE_MODE_UPDATE, UpCardAppWidgetKt.APP_WIDGET_MANUAL_CLICK_UPDATE});
    private static final List<String> ALLOW_LOAD_DEFAULT_IF_LOCAL_NULL = CollectionsKt.listOf(new String[]{"tv.danmaku.bili.action.appwidget.IN_BACKGROUND", "tv.danmaku.bili.action.appwidget.LAUNCH_APP", "android.intent.action.PACKAGE_CHANGED"});

    public static final void update(Context context, String updateReason) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updateReason, "updateReason");
        BLog.i(TAG, "update reason:" + updateReason);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (appWidgetManager == null) {
            return;
        }
        int[] widgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, UpCardAppWidget.class));
        BLog.d(TAG, "onUpdate:" + Arrays.toString(widgetIds));
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
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new UpCardAppWidgetUpdaterKt$update$1(appStatus, updateReason, context, appWidgetManager, widgetIds, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015c A[LOOP:0: B:55:0x015a->B:56:0x015c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object updateWidgetView(CoroutineScope $this$updateWidgetView, Context context, AppWidgetManager appWidgetManager, int[] iArr, UpCardWidgetData upCardWidgetData, int i, Continuation<? super Unit> continuation) {
        UpCardAppWidgetUpdaterKt$updateWidgetView$1 upCardAppWidgetUpdaterKt$updateWidgetView$1;
        UpCardWidgetData data;
        Context context2;
        int[] appWidgetIds;
        int appStatus;
        int cardCount;
        CoroutineScope $this$updateWidgetView2;
        AppWidgetManager appWidgetManager2;
        CoroutineScope $this$updateWidgetView3;
        AppWidgetManager appWidgetManager3;
        int[] appWidgetIds2;
        UpCardWidgetData data2;
        int cardCount2;
        int appStatus2;
        Context context3;
        List<WidgetUpCard> widgetUpCards;
        Pair size;
        Deferred avatarBitmap;
        int i2;
        Iterable widgetUpCards2;
        List<WidgetUpCard> widgetUpCards3;
        WidgetUpCard widgetUpCard;
        Owner owner;
        String it;
        if (continuation instanceof UpCardAppWidgetUpdaterKt$updateWidgetView$1) {
            upCardAppWidgetUpdaterKt$updateWidgetView$1 = (UpCardAppWidgetUpdaterKt$updateWidgetView$1) continuation;
            if ((upCardAppWidgetUpdaterKt$updateWidgetView$1.label & Integer.MIN_VALUE) != 0) {
                upCardAppWidgetUpdaterKt$updateWidgetView$1.label -= Integer.MIN_VALUE;
                Object $result = upCardAppWidgetUpdaterKt$updateWidgetView$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (upCardAppWidgetUpdaterKt$updateWidgetView$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        data = upCardWidgetData;
                        context2 = context;
                        appWidgetIds = iArr;
                        appStatus = i;
                        cardCount = (data == null || (widgetUpCards = data.getWidgetUpCards()) == null) ? 0 : widgetUpCards.size();
                        if (cardCount == 0) {
                            upCardAppWidgetUpdaterKt$updateWidgetView$1.L$0 = $this$updateWidgetView;
                            upCardAppWidgetUpdaterKt$updateWidgetView$1.L$1 = context2;
                            upCardAppWidgetUpdaterKt$updateWidgetView$1.L$2 = appWidgetManager;
                            upCardAppWidgetUpdaterKt$updateWidgetView$1.L$3 = appWidgetIds;
                            upCardAppWidgetUpdaterKt$updateWidgetView$1.L$4 = data;
                            upCardAppWidgetUpdaterKt$updateWidgetView$1.I$0 = appStatus;
                            upCardAppWidgetUpdaterKt$updateWidgetView$1.I$1 = cardCount;
                            upCardAppWidgetUpdaterKt$updateWidgetView$1.label = 1;
                            if (updateWidgetBySizes(appWidgetIds, context2, appWidgetManager, data, null, appStatus, null, upCardAppWidgetUpdaterKt$updateWidgetView$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$updateWidgetView3 = $this$updateWidgetView;
                            appWidgetManager3 = appWidgetManager;
                            appWidgetIds2 = appWidgetIds;
                            data2 = data;
                            cardCount2 = cardCount;
                            appStatus2 = appStatus;
                            context3 = context2;
                            data = data2;
                            int[] iArr2 = appWidgetIds2;
                            cardCount = cardCount2;
                            $this$updateWidgetView2 = $this$updateWidgetView3;
                            context2 = context3;
                            appWidgetIds = iArr2;
                            AppWidgetManager appWidgetManager4 = appWidgetManager3;
                            appStatus = appStatus2;
                            appWidgetManager2 = appWidgetManager4;
                            break;
                        } else {
                            $this$updateWidgetView2 = $this$updateWidgetView;
                            appWidgetManager2 = appWidgetManager;
                            break;
                        }
                        break;
                    case 1:
                        cardCount2 = upCardAppWidgetUpdaterKt$updateWidgetView$1.I$1;
                        appStatus2 = upCardAppWidgetUpdaterKt$updateWidgetView$1.I$0;
                        data2 = (UpCardWidgetData) upCardAppWidgetUpdaterKt$updateWidgetView$1.L$4;
                        appWidgetIds2 = (int[]) upCardAppWidgetUpdaterKt$updateWidgetView$1.L$3;
                        appWidgetManager3 = (AppWidgetManager) upCardAppWidgetUpdaterKt$updateWidgetView$1.L$2;
                        context3 = (Context) upCardAppWidgetUpdaterKt$updateWidgetView$1.L$1;
                        $this$updateWidgetView3 = (CoroutineScope) upCardAppWidgetUpdaterKt$updateWidgetView$1.L$0;
                        ResultKt.throwOnFailure($result);
                        data = data2;
                        int[] iArr22 = appWidgetIds2;
                        cardCount = cardCount2;
                        $this$updateWidgetView2 = $this$updateWidgetView3;
                        context2 = context3;
                        appWidgetIds = iArr22;
                        AppWidgetManager appWidgetManager42 = appWidgetManager3;
                        appStatus = appStatus2;
                        appWidgetManager2 = appWidgetManager42;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (appWidgetIds == null) {
                    Pair size2 = WidgetSizeUtilKt.getWidgetsSize(context2, appWidgetManager2, appWidgetIds[0]);
                    if (data != null) {
                        data.setSize(size2);
                    }
                    if (((Number) size2.getFirst()).intValue() > 0 && ((Number) size2.getSecond()).intValue() > 0) {
                        size = ((Number) size2.getFirst()).intValue() / ((Number) size2.getSecond()).intValue() < 2 ? 1 : null;
                    } else {
                        size = null;
                    }
                } else {
                    size = null;
                }
                if (data != null || (widgetUpCards3 = data.getWidgetUpCards()) == null || (widgetUpCard = widgetUpCards3.get(0)) == null || (owner = widgetUpCard.getOwner()) == null || (it = owner.getFace()) == null) {
                    avatarBitmap = null;
                } else {
                    avatarBitmap = BuildersKt.async$default($this$updateWidgetView2, (CoroutineContext) null, (CoroutineStart) null, new UpCardAppWidgetUpdaterKt$updateWidgetView$avatarBitmap$1$1(context2, it, null), 3, (Object) null);
                }
                ArrayList arrayList = new ArrayList(cardCount);
                for (i2 = 0; i2 < cardCount; i2++) {
                    arrayList.add(null);
                }
                CopyOnWriteArrayList coverBitmaps = new CopyOnWriteArrayList(arrayList);
                if (data != null && (widgetUpCards2 = data.getWidgetUpCards()) != null) {
                    Iterable $this$forEachIndexed$iv = widgetUpCards2;
                    int index = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv = index + 1;
                        if (index < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        WidgetUpCard item = (WidgetUpCard) item$iv;
                        BuildersKt.launch$default($this$updateWidgetView2, (CoroutineContext) null, (CoroutineStart) null, new UpCardAppWidgetUpdaterKt$updateWidgetView$2$1(context2, data, cardCount, size != null, item, coverBitmaps, index, appWidgetIds, appWidgetManager2, appStatus, avatarBitmap, null), 3, (Object) null);
                        index = index$iv;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        upCardAppWidgetUpdaterKt$updateWidgetView$1 = new UpCardAppWidgetUpdaterKt$updateWidgetView$1(continuation);
        Object $result2 = upCardAppWidgetUpdaterKt$updateWidgetView$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (upCardAppWidgetUpdaterKt$updateWidgetView$1.label) {
        }
        if (appWidgetIds == null) {
        }
        if (data != null) {
        }
        avatarBitmap = null;
        ArrayList arrayList2 = new ArrayList(cardCount);
        while (i2 < cardCount) {
        }
        CopyOnWriteArrayList coverBitmaps2 = new CopyOnWriteArrayList(arrayList2);
        if (data != null) {
            Iterable $this$forEachIndexed$iv2 = widgetUpCards2;
            int index2 = 0;
            while (r27.hasNext()) {
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01bb -> B:96:0x01cd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object updateWidgetBySizes(int[] appWidgetIds, Context context, AppWidgetManager appWidgetManager, UpCardWidgetData data, List<Bitmap> list, int appStatus, Bitmap avatarBitmap, Continuation<? super Unit> continuation) {
        UpCardAppWidgetUpdaterKt$updateWidgetBySizes$1 upCardAppWidgetUpdaterKt$updateWidgetBySizes$1;
        List<Bitmap> list2;
        Context context2;
        int[] $this$forEach$iv;
        AppWidgetManager appWidgetManager2;
        Bitmap avatarBitmap2;
        UpCardWidgetData data2;
        boolean z;
        Continuation $completion;
        int $i$f$forEach;
        int cardCount;
        int cardCount2;
        int appStatus2;
        List<WidgetUpCard> widgetUpCards;
        Object $result;
        boolean z2;
        int nextAppStatus;
        Object obj;
        boolean z3;
        Bitmap avatarBitmap3;
        AppWidgetManager appWidgetManager3;
        int appStatus3;
        int appStatus4;
        int cardCount3;
        int i;
        int i2;
        Context context3;
        int[] $this$forEach$iv2;
        AppWidgetManager appWidgetManager4;
        if (continuation instanceof UpCardAppWidgetUpdaterKt$updateWidgetBySizes$1) {
            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1 = (UpCardAppWidgetUpdaterKt$updateWidgetBySizes$1) continuation;
            if ((upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.label & Integer.MIN_VALUE) != 0) {
                upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.label -= Integer.MIN_VALUE;
                Object $result2 = upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        list2 = list;
                        context2 = context;
                        int cardCount4 = (data == null || (widgetUpCards = data.getWidgetUpCards()) == null) ? 0 : widgetUpCards.size();
                        if (appWidgetIds == null) {
                            return Unit.INSTANCE;
                        }
                        $this$forEach$iv = appWidgetIds;
                        appWidgetManager2 = appWidgetManager;
                        avatarBitmap2 = avatarBitmap;
                        data2 = data;
                        z = false;
                        $completion = continuation;
                        $i$f$forEach = cardCount4;
                        cardCount = 0;
                        cardCount2 = appStatus;
                        appStatus2 = appWidgetIds.length;
                        if (cardCount < appStatus2) {
                            int it = $this$forEach$iv[cardCount];
                            Pair size = WidgetSizeUtilKt.getWidgetsSize(context2, appWidgetManager2, it);
                            Continuation $completion2 = $completion;
                            if (cardCount2 == 0) {
                                if (data2 != null) {
                                    $result = $result2;
                                    if (data2.getStyle() == 1) {
                                        z2 = true;
                                        if (z2) {
                                            nextAppStatus = 1;
                                        } else {
                                            if (!(data2 != null && data2.getStyle() == 2)) {
                                                if (!(data2 != null && data2.getStyle() == 3)) {
                                                    nextAppStatus = 6;
                                                    if (!(data2 != null && data2.getStyle() == 5)) {
                                                        if ((data2 != null && data2.getStyle() == 0) && ($i$f$forEach == 1 || $i$f$forEach == 2)) {
                                                            nextAppStatus = 0;
                                                        } else {
                                                            nextAppStatus = ((data2 != null && data2.getStyle() == 6) && ($i$f$forEach == 1 || $i$f$forEach == 2)) ? 5 : 1;
                                                        }
                                                    }
                                                }
                                            }
                                            nextAppStatus = 4;
                                        }
                                    }
                                } else {
                                    $result = $result2;
                                }
                                z2 = false;
                                if (z2) {
                                }
                            } else {
                                $result = $result2;
                                nextAppStatus = cardCount2;
                            }
                            boolean z4 = z;
                            BLog.i(TAG, "createWidgetView: nextAppStatus:" + nextAppStatus);
                            int style = data2 != null ? data2.getStyle() : 0;
                            if (((Number) size.getFirst()).intValue() <= 0 || ((Number) size.getSecond()).intValue() <= 0) {
                                obj = coroutine_suspended;
                            } else {
                                obj = coroutine_suspended;
                                if (((Number) size.getFirst()).intValue() / ((Number) size.getSecond()).intValue() < 2) {
                                    z3 = true;
                                    UpCardType upCardType = UpCardWidgetViewKt.getUpCardType($i$f$forEach, style, z3);
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$0 = context2;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$1 = appWidgetManager2;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$2 = data2;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$3 = list2;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$4 = avatarBitmap2;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$5 = $this$forEach$iv;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$6 = appWidgetManager2;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$0 = cardCount2;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$1 = $i$f$forEach;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$2 = cardCount;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$3 = appStatus2;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$4 = it;
                                    upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.label = 1;
                                    $result2 = createWidgetView(context2, data2, list2, upCardType, nextAppStatus, avatarBitmap2, upCardAppWidgetUpdaterKt$updateWidgetBySizes$1);
                                    coroutine_suspended = obj;
                                    if ($result2 != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $completion = $completion2;
                                    avatarBitmap3 = avatarBitmap2;
                                    z = z4;
                                    appWidgetManager3 = appWidgetManager2;
                                    appStatus3 = cardCount2;
                                    appStatus4 = $i$f$forEach;
                                    cardCount3 = cardCount;
                                    i = appStatus2;
                                    i2 = it;
                                    context3 = context2;
                                    $this$forEach$iv2 = $this$forEach$iv;
                                    appWidgetManager4 = appWidgetManager3;
                                    appWidgetManager4.updateAppWidget(i2, (RemoteViews) $result2);
                                    int i3 = cardCount3 + 1;
                                    appStatus2 = i;
                                    $i$f$forEach = appStatus4;
                                    cardCount2 = appStatus3;
                                    appWidgetManager2 = appWidgetManager3;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    avatarBitmap2 = avatarBitmap3;
                                    $result2 = $result;
                                    cardCount = i3;
                                    context2 = context3;
                                    if (cardCount < appStatus2) {
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                            z3 = false;
                            UpCardType upCardType2 = UpCardWidgetViewKt.getUpCardType($i$f$forEach, style, z3);
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$0 = context2;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$1 = appWidgetManager2;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$2 = data2;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$3 = list2;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$4 = avatarBitmap2;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$5 = $this$forEach$iv;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$6 = appWidgetManager2;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$0 = cardCount2;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$1 = $i$f$forEach;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$2 = cardCount;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$3 = appStatus2;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$4 = it;
                            upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.label = 1;
                            $result2 = createWidgetView(context2, data2, list2, upCardType2, nextAppStatus, avatarBitmap2, upCardAppWidgetUpdaterKt$updateWidgetBySizes$1);
                            coroutine_suspended = obj;
                            if ($result2 != coroutine_suspended) {
                            }
                        }
                        break;
                    case 1:
                        z = false;
                        int i4 = upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$4;
                        int i5 = upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$3;
                        int i6 = upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$2;
                        int cardCount5 = upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$1;
                        int appStatus5 = upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.I$0;
                        int[] $this$forEach$iv3 = (int[]) upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$5;
                        Bitmap avatarBitmap4 = (Bitmap) upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$4;
                        list2 = (List) upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$3;
                        data2 = (UpCardWidgetData) upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$2;
                        AppWidgetManager appWidgetManager5 = (AppWidgetManager) upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$1;
                        Context context4 = (Context) upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        $result = $result2;
                        $this$forEach$iv2 = $this$forEach$iv3;
                        avatarBitmap3 = avatarBitmap4;
                        appWidgetManager3 = appWidgetManager5;
                        appWidgetManager4 = (AppWidgetManager) upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.L$6;
                        appStatus3 = appStatus5;
                        appStatus4 = cardCount5;
                        cardCount3 = i6;
                        i = i5;
                        i2 = i4;
                        context3 = context4;
                        $completion = continuation;
                        appWidgetManager4.updateAppWidget(i2, (RemoteViews) $result2);
                        int i32 = cardCount3 + 1;
                        appStatus2 = i;
                        $i$f$forEach = appStatus4;
                        cardCount2 = appStatus3;
                        appWidgetManager2 = appWidgetManager3;
                        $this$forEach$iv = $this$forEach$iv2;
                        avatarBitmap2 = avatarBitmap3;
                        $result2 = $result;
                        cardCount = i32;
                        context2 = context3;
                        if (cardCount < appStatus2) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        upCardAppWidgetUpdaterKt$updateWidgetBySizes$1 = new UpCardAppWidgetUpdaterKt$updateWidgetBySizes$1(continuation);
        Object $result22 = upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (upCardAppWidgetUpdaterKt$updateWidgetBySizes$1.label) {
        }
    }

    static /* synthetic */ Object updateWidgetBySizes$default(int[] iArr, Context context, AppWidgetManager appWidgetManager, UpCardWidgetData upCardWidgetData, List list, int i, Bitmap bitmap, Continuation continuation, int i2, Object obj) {
        Bitmap bitmap2;
        if ((i2 & 64) == 0) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = null;
        }
        return updateWidgetBySizes(iArr, context, appWidgetManager, upCardWidgetData, list, i, bitmap2, continuation);
    }

    static /* synthetic */ Object createWidgetView$default(Context context, UpCardWidgetData upCardWidgetData, List list, UpCardType upCardType, int i, Bitmap bitmap, Continuation continuation, int i2, Object obj) {
        Bitmap bitmap2;
        if ((i2 & 32) == 0) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = null;
        }
        return createWidgetView(context, upCardWidgetData, list, upCardType, i, bitmap2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createWidgetView(Context context, UpCardWidgetData data, List<Bitmap> list, UpCardType cardType, int appStatus, Bitmap avatarBitmap, Continuation<? super RemoteViews> continuation) {
        switch (appStatus) {
            case 1:
                return UpCardWidgetViewKt.showBlockWidgetView(context);
            case 2:
                return UpCardWidgetViewKt.showTeenagerWidgetView(context);
            case 3:
                return UpCardWidgetViewKt.showLessonsWidgetView(context);
            case 4:
                return UpCardWidgetViewKt.showNoUpdateWidgetView(context);
            case 5:
                return UpCardWidgetViewKt.showUpUpdateWidgetView(context, data, list, continuation);
            case 6:
                return UpCardWidgetViewKt.showErrorWidgetView(context);
            default:
                return UpCardWidgetViewKt.createUpCardWidgetView(context, data, list, cardType, avatarBitmap, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object downloadImage(Context context, String url, int width, int height, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UpCardAppWidgetUpdaterKt$downloadImage$2(context, url, width, height, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap getBitmapFromFile(File file, int desiredWidth, int desiredHeight) {
        if (file == null || file.length() <= 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options);
        if (options.outHeight == 0 || options.outWidth == 0) {
            return null;
        }
        options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, desiredWidth, desiredHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getPath(), options);
    }
}