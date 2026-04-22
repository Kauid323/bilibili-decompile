package tv.danmaku.bili.appwidget.guide;

import com.bapis.bilibili.app.show.mixture.v1.ApiMossKtxKt;
import com.bapis.bilibili.app.show.mixture.v1.MixtureMoss;
import com.bapis.bilibili.app.show.mixture.v1.WidgetGuideUpdateReq;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.utils.AutoAddWidgetSceneExtKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WidgetGuide.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.guide.WidgetGuideKt$updateWidgetGuideFrequency$2", f = "WidgetGuide.kt", i = {}, l = {BR.bgImg}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WidgetGuideKt$updateWidgetGuideFrequency$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuideScene $scene;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuideKt$updateWidgetGuideFrequency$2(GuideScene guideScene, Continuation<? super WidgetGuideKt$updateWidgetGuideFrequency$2> continuation) {
        super(2, continuation);
        this.$scene = guideScene;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WidgetGuideKt$updateWidgetGuideFrequency$2(this.$scene, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    WidgetGuideUpdateReq req = WidgetGuideUpdateReq.newBuilder().setFromSpmid(AutoAddWidgetSceneExtKt.spmid(this.$scene)).setGuideType(AutoAddWidgetSceneExtKt.guideType(this.$scene)).build();
                    MixtureMoss mixtureMoss = new MixtureMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNull(req);
                    this.label = 1;
                    if (ApiMossKtxKt.suspendWidgetGuideUpdate(mixtureMoss, req, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            BLog.e("WidgetGuide", "widgetGuideUpdate -> error = " + e);
        }
        return Unit.INSTANCE;
    }
}