package tv.danmaku.bili.appwidget.upcard.api;

import android.content.Context;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
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
import tv.danmaku.bili.appwidget.upcard.data.UpCardWidgetData;
import tv.danmaku.bili.appwidget.upcard.utils.SpUtilKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppWidgetHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.upcard.api.AppWidgetHelperKt$getUpCardWidgetApiData$2", f = "AppWidgetHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AppWidgetHelperKt$getUpCardWidgetApiData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UpCardWidgetData>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetHelperKt$getUpCardWidgetApiData$2(Context context, Continuation<? super AppWidgetHelperKt$getUpCardWidgetApiData$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppWidgetHelperKt$getUpCardWidgetApiData$2(this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UpCardWidgetData> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Response $this$invokeSuspend_u24lambda_u240;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                BiliCall<GeneralResponse<UpCardWidgetData>> upCardWidgetData = ((UpWidgetApi) ServiceGenerator.createService(UpWidgetApi.class)).getUpCardWidgetData();
                if (upCardWidgetData == null || ($this$invokeSuspend_u24lambda_u240 = upCardWidgetData.execute()) == null) {
                    return null;
                }
                Context context = this.$context;
                GeneralResponse generalResponse = (GeneralResponse) $this$invokeSuspend_u24lambda_u240.body();
                UpCardWidgetData data = generalResponse != null ? (UpCardWidgetData) generalResponse.data : null;
                if ($this$invokeSuspend_u24lambda_u240.isSuccessful() && data != null) {
                    SpUtilKt.saveWidgetData(context, data);
                    return data;
                }
                UpCardWidgetData cache = SpUtilKt.getLocalWidgetData(context);
                BLog.i("AppWidgetHelper", "getUpCardWidgetApiData using cache");
                return cache;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}