package tv.danmaku.bili.appwidget.hotword.api;

import android.content.Context;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotword.data.HotWordWidgetData;
import tv.danmaku.bili.appwidget.hotword.data.WidgetButtonData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppWidgetHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/appwidget/hotword/data/HotWordWidgetData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotword.api.AppWidgetHelperKt$getHotWordWidgetApiData$2", f = "AppWidgetHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AppWidgetHelperKt$getHotWordWidgetApiData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HotWordWidgetData>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetHelperKt$getHotWordWidgetApiData$2(Context context, Continuation<? super AppWidgetHelperKt$getHotWordWidgetApiData$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppWidgetHelperKt$getHotWordWidgetApiData$2(this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HotWordWidgetData> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
        tv.danmaku.bili.appwidget.hotword.api.AppWidgetHelperKt.saveHotWordCache(r4, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HotWordWidgetData cache;
        HotWordWidgetData constructDefaultHotWordWidgetData;
        Response $this$invokeSuspend_u24lambda_u240;
        HotWordWidgetData cache2;
        HotWordWidgetData cache3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    boolean z = true;
                    BiliCall<GeneralResponse<HotWordWidgetData>> hotWordWidgetData = ((WidgetApi) ServiceGenerator.createService(WidgetApi.class)).getHotWordWidgetData(1);
                    if (hotWordWidgetData == null || ($this$invokeSuspend_u24lambda_u240 = hotWordWidgetData.execute()) == null) {
                        return null;
                    }
                    Context context = this.$context;
                    GeneralResponse generalResponse = (GeneralResponse) $this$invokeSuspend_u24lambda_u240.body();
                    HotWordWidgetData data = generalResponse != null ? (HotWordWidgetData) generalResponse.data : null;
                    if ($this$invokeSuspend_u24lambda_u240.isSuccessful() && data != null) {
                        List<WidgetButtonData> list = data.buttons;
                        if (list != null && !list.isEmpty()) {
                            z = false;
                            break;
                        }
                    }
                    cache2 = AppWidgetHelperKt.getHotWordWidgetApiDataCache(context);
                    BLog.i("AppWidgetHelper", "getHotWordWidgetApiData using cache");
                    if (cache2 == null) {
                        cache3 = AppWidgetHelperKt.constructDefaultHotWordWidgetData(context);
                        return cache3;
                    }
                    return cache2;
                } catch (Exception e) {
                    cache = AppWidgetHelperKt.getHotWordWidgetApiDataCache(this.$context);
                    BLog.e("AppWidgetHelper", "getHotWordWidgetApiData error using cache");
                    if (cache == null) {
                        constructDefaultHotWordWidgetData = AppWidgetHelperKt.constructDefaultHotWordWidgetData(this.$context);
                        return constructDefaultHotWordWidgetData;
                    }
                    return cache;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}