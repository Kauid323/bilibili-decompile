package tv.danmaku.bili.appwidget.hotlist;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.graphics.Bitmap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetItemModel;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModel;
import tv.danmaku.bili.appwidget.hotlist.utils.ImageUtilKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HotListAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotlist.HotListAppWidgetUpdaterKt$updateWidgetView$2$1", f = "HotListAppWidgetUpdater.kt", i = {}, l = {BR.danmakuCountText, BR.danmukuTvVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HotListAppWidgetUpdaterKt$updateWidgetView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $appStatus;
    final /* synthetic */ int[] $appWidgetIds;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ int $bitmapMaxSize;
    final /* synthetic */ Context $context;
    final /* synthetic */ CopyOnWriteArrayList<Bitmap> $coverBitmaps;
    final /* synthetic */ HotListWidgetModel $data;
    final /* synthetic */ HotListWidgetItemModel $hotListWidgetItemModel;
    final /* synthetic */ int $index;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotListAppWidgetUpdaterKt$updateWidgetView$2$1(Context context, HotListWidgetItemModel hotListWidgetItemModel, int i, CopyOnWriteArrayList<Bitmap> copyOnWriteArrayList, int i2, HotListWidgetModel hotListWidgetModel, int i3, AppWidgetManager appWidgetManager, int[] iArr, Continuation<? super HotListAppWidgetUpdaterKt$updateWidgetView$2$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$hotListWidgetItemModel = hotListWidgetItemModel;
        this.$bitmapMaxSize = i;
        this.$coverBitmaps = copyOnWriteArrayList;
        this.$index = i2;
        this.$data = hotListWidgetModel;
        this.$appStatus = i3;
        this.$appWidgetManager = appWidgetManager;
        this.$appWidgetIds = iArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotListAppWidgetUpdaterKt$updateWidgetView$2$1(this.$context, this.$hotListWidgetItemModel, this.$bitmapMaxSize, this.$coverBitmaps, this.$index, this.$data, this.$appStatus, this.$appWidgetManager, this.$appWidgetIds, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object updateWidgetViewAfterDownload;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object downloadHotListCover = ImageUtilKt.downloadHotListCover(this.$context, this.$hotListWidgetItemModel.getCover(), this.$bitmapMaxSize, (Continuation) this);
                if (downloadHotListCover == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = downloadHotListCover;
                Bitmap bitmap = (Bitmap) $result;
                this.$coverBitmaps.set(this.$index, bitmap);
                BLog.i("HotListAppWidgetUpdater", "pic downloaded " + this.$index + " coverBitmaps:" + this.$coverBitmaps);
                this.label = 2;
                updateWidgetViewAfterDownload = HotListAppWidgetUpdaterKt.updateWidgetViewAfterDownload(this.$context, this.$data, this.$coverBitmaps, this.$appStatus, this.$appWidgetManager, this.$appWidgetIds, (Continuation) this);
                return updateWidgetViewAfterDownload != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                Bitmap bitmap2 = (Bitmap) $result;
                this.$coverBitmaps.set(this.$index, bitmap2);
                BLog.i("HotListAppWidgetUpdater", "pic downloaded " + this.$index + " coverBitmaps:" + this.$coverBitmaps);
                this.label = 2;
                updateWidgetViewAfterDownload = HotListAppWidgetUpdaterKt.updateWidgetViewAfterDownload(this.$context, this.$data, this.$coverBitmaps, this.$appStatus, this.$appWidgetManager, this.$appWidgetIds, (Continuation) this);
                if (updateWidgetViewAfterDownload != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}