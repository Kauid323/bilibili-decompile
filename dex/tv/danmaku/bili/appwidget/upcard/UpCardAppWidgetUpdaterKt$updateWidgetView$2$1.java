package tv.danmaku.bili.appwidget.upcard;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.graphics.Bitmap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.data.UpCardWidgetData;
import tv.danmaku.bili.appwidget.upcard.data.WidgetUpCard;
import tv.danmaku.bili.appwidget.upcard.utils.ImageUtilKt;
import tv.danmaku.bili.appwidget.upcard.utils.UpCardCoverUtilKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpCardAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.upcard.UpCardAppWidgetUpdaterKt$updateWidgetView$2$1", f = "UpCardAppWidgetUpdater.kt", i = {}, l = {181, 192, BR.endIcon}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UpCardAppWidgetUpdaterKt$updateWidgetView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $appStatus;
    final /* synthetic */ int[] $appWidgetIds;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ Deferred<Bitmap> $avatarBitmap;
    final /* synthetic */ int $cardCount;
    final /* synthetic */ Context $context;
    final /* synthetic */ CopyOnWriteArrayList<Bitmap> $coverBitmaps;
    final /* synthetic */ UpCardWidgetData $data;
    final /* synthetic */ int $index;
    final /* synthetic */ boolean $is43;
    final /* synthetic */ WidgetUpCard $item;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpCardAppWidgetUpdaterKt$updateWidgetView$2$1(Context context, UpCardWidgetData upCardWidgetData, int i, boolean z, WidgetUpCard widgetUpCard, CopyOnWriteArrayList<Bitmap> copyOnWriteArrayList, int i2, int[] iArr, AppWidgetManager appWidgetManager, int i3, Deferred<Bitmap> deferred, Continuation<? super UpCardAppWidgetUpdaterKt$updateWidgetView$2$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$data = upCardWidgetData;
        this.$cardCount = i;
        this.$is43 = z;
        this.$item = widgetUpCard;
        this.$coverBitmaps = copyOnWriteArrayList;
        this.$index = i2;
        this.$appWidgetIds = iArr;
        this.$appWidgetManager = appWidgetManager;
        this.$appStatus = i3;
        this.$avatarBitmap = deferred;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpCardAppWidgetUpdaterKt$updateWidgetView$2$1(this.$context, this.$data, this.$cardCount, this.$is43, this.$item, this.$coverBitmaps, this.$index, this.$appWidgetIds, this.$appWidgetManager, this.$appStatus, this.$avatarBitmap, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0108 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0109  */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        AppWidgetManager appWidgetManager;
        Deferred<Bitmap> deferred;
        int i;
        Bitmap bitmap;
        CopyOnWriteArrayList<Bitmap> copyOnWriteArrayList;
        int[] iArr;
        UpCardWidgetData upCardWidgetData;
        Context context;
        int i2;
        Object $result4;
        int[] iArr2;
        Context context2;
        AppWidgetManager appWidgetManager2;
        UpCardWidgetData upCardWidgetData2;
        CopyOnWriteArrayList<Bitmap> copyOnWriteArrayList2;
        Object updateWidgetBySizes;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Pair targetCoverSize = UpCardCoverUtilKt.getUpCardCoverSize(this.$context, this.$data, this.$cardCount, this.$data.getSize(), this.$is43);
                String targetCover = UpCardCoverUtilKt.getUpCardCover(this.$data, this.$item, this.$is43);
                this.label = 1;
                Object downloadUpCardCover = ImageUtilKt.downloadUpCardCover(this.$context, targetCover, targetCoverSize, (Continuation) this);
                if (downloadUpCardCover == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result3 = downloadUpCardCover;
                Bitmap targetBitmap = (Bitmap) $result3;
                this.$coverBitmaps.set(this.$index, targetBitmap);
                BLog.i("UpCardAppWidgetUpdater", "pic downloaded " + this.$index + " coverBitmaps:" + this.$coverBitmaps);
                int[] iArr3 = this.$appWidgetIds;
                Context context3 = this.$context;
                appWidgetManager = this.$appWidgetManager;
                UpCardWidgetData upCardWidgetData3 = this.$data;
                CopyOnWriteArrayList<Bitmap> copyOnWriteArrayList3 = this.$coverBitmaps;
                int i3 = this.$appStatus;
                deferred = this.$avatarBitmap;
                if (deferred == null) {
                    this.L$0 = iArr3;
                    this.L$1 = context3;
                    this.L$2 = appWidgetManager;
                    this.L$3 = upCardWidgetData3;
                    this.L$4 = copyOnWriteArrayList3;
                    this.I$0 = i3;
                    this.label = 2;
                    Object await = deferred.await((Continuation) this);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i2 = i3;
                    $result4 = await;
                    iArr2 = iArr3;
                    context2 = context3;
                    appWidgetManager2 = appWidgetManager;
                    upCardWidgetData2 = upCardWidgetData3;
                    copyOnWriteArrayList2 = copyOnWriteArrayList3;
                    bitmap = (Bitmap) $result4;
                    int[] iArr4 = iArr2;
                    i = i2;
                    iArr = iArr4;
                    Context context4 = context2;
                    copyOnWriteArrayList = copyOnWriteArrayList2;
                    context = context4;
                    AppWidgetManager appWidgetManager3 = appWidgetManager2;
                    upCardWidgetData = upCardWidgetData2;
                    appWidgetManager = appWidgetManager3;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 3;
                    updateWidgetBySizes = UpCardAppWidgetUpdaterKt.updateWidgetBySizes(iArr, context, appWidgetManager, upCardWidgetData, copyOnWriteArrayList, i, bitmap, (Continuation) this);
                    return updateWidgetBySizes == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                }
                i = i3;
                bitmap = null;
                copyOnWriteArrayList = copyOnWriteArrayList3;
                iArr = iArr3;
                upCardWidgetData = upCardWidgetData3;
                context = context3;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 3;
                updateWidgetBySizes = UpCardAppWidgetUpdaterKt.updateWidgetBySizes(iArr, context, appWidgetManager, upCardWidgetData, copyOnWriteArrayList, i, bitmap, (Continuation) this);
                if (updateWidgetBySizes == coroutine_suspended) {
                }
            case 1:
                $result3 = $result;
                ResultKt.throwOnFailure($result3);
                $result2 = $result3;
                Bitmap targetBitmap2 = (Bitmap) $result3;
                this.$coverBitmaps.set(this.$index, targetBitmap2);
                BLog.i("UpCardAppWidgetUpdater", "pic downloaded " + this.$index + " coverBitmaps:" + this.$coverBitmaps);
                int[] iArr32 = this.$appWidgetIds;
                Context context32 = this.$context;
                appWidgetManager = this.$appWidgetManager;
                UpCardWidgetData upCardWidgetData32 = this.$data;
                CopyOnWriteArrayList<Bitmap> copyOnWriteArrayList32 = this.$coverBitmaps;
                int i32 = this.$appStatus;
                deferred = this.$avatarBitmap;
                if (deferred == null) {
                }
                break;
            case 2:
                $result4 = $result;
                int i4 = this.I$0;
                ResultKt.throwOnFailure($result4);
                iArr2 = (int[]) this.L$0;
                context2 = (Context) this.L$1;
                appWidgetManager2 = (AppWidgetManager) this.L$2;
                upCardWidgetData2 = (UpCardWidgetData) this.L$3;
                copyOnWriteArrayList2 = (List) this.L$4;
                i2 = i4;
                $result2 = $result4;
                bitmap = (Bitmap) $result4;
                int[] iArr42 = iArr2;
                i = i2;
                iArr = iArr42;
                Context context42 = context2;
                copyOnWriteArrayList = copyOnWriteArrayList2;
                context = context42;
                AppWidgetManager appWidgetManager32 = appWidgetManager2;
                upCardWidgetData = upCardWidgetData2;
                appWidgetManager = appWidgetManager32;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 3;
                updateWidgetBySizes = UpCardAppWidgetUpdaterKt.updateWidgetBySizes(iArr, context, appWidgetManager, upCardWidgetData, copyOnWriteArrayList, i, bitmap, (Continuation) this);
                if (updateWidgetBySizes == coroutine_suspended) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}