package tv.danmaku.bili.appwidget.guide;

import com.bapis.bilibili.app.show.mixture.v1.ApiMossKtxKt;
import com.bapis.bilibili.app.show.mixture.v1.MixtureMoss;
import com.bapis.bilibili.app.show.mixture.v1.WidgetGuideReply;
import com.bapis.bilibili.app.show.mixture.v1.WidgetGuideReq;
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
import tv.danmaku.bili.appwidget.guide.utils.ReportHelperKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WidgetGuide.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bapis/bilibili/app/show/mixture/v1/WidgetGuideReply;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.guide.WidgetGuideKt$suspendWidgetGuide$2", f = "WidgetGuide.kt", i = {}, l = {BR.backgroundTitleText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WidgetGuideKt$suspendWidgetGuide$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WidgetGuideReply>, Object> {
    final /* synthetic */ GuideScene $scene;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuideKt$suspendWidgetGuide$2(GuideScene guideScene, Continuation<? super WidgetGuideKt$suspendWidgetGuide$2> continuation) {
        super(2, continuation);
        this.$scene = guideScene;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WidgetGuideKt$suspendWidgetGuide$2(this.$scene, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WidgetGuideReply> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v8, types: [com.bapis.bilibili.app.show.mixture.v1.WidgetGuideReply, java.lang.Object] */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = 1;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure((Object) $result);
                    WidgetGuideReq req = WidgetGuideReq.newBuilder().setFromSpmid(AutoAddWidgetSceneExtKt.spmid(this.$scene)).setGuideType(AutoAddWidgetSceneExtKt.guideType(this.$scene)).setGuideStyleVersion(AutoAddWidgetSceneExtKt.guideStyleVersion(this.$scene)).setSkipUpdate(AutoAddWidgetSceneExtKt.skipUpdate(this.$scene)).build();
                    MixtureMoss mixtureMoss = new MixtureMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNull(req);
                    this.label = 1;
                    Object suspendWidgetGuide = ApiMossKtxKt.suspendWidgetGuide(mixtureMoss, req, (Continuation) this);
                    if (suspendWidgetGuide != coroutine_suspended) {
                        $result2 = $result;
                        $result3 = suspendWidgetGuide;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure((Object) $result);
                    $result2 = $result;
                    $result3 = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                $result = (WidgetGuideReply) $result3;
                String spmid = AutoAddWidgetSceneExtKt.spmid(this.$scene);
                String contentId = AutoAddWidgetSceneExtKt.contentId(this.$scene);
                int code = $result != 0 ? $result.getCode() : 0;
                String type = AutoAddWidgetSceneExtKt.type(this.$scene);
                if (!WidgetGuideKt.show($result)) {
                    i = 0;
                }
                ReportHelperKt.reportAutoAddGuideRequest(spmid, contentId, type, code, i);
                return $result;
            } catch (Exception e) {
                Object obj = $result2;
                $result = e;
                $result = obj;
                BLog.e("WidgetGuide", "widgetGuidePopup -> error = " + $result);
                return null;
            }
        } catch (Exception e2) {
            $result = e2;
        }
    }
}