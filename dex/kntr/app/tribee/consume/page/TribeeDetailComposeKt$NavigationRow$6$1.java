package kntr.app.tribee.consume.page;

import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeDetailCompose.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeeDetailComposeKt$NavigationRow$6$1", f = "TribeeDetailCompose.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TribeeDetailComposeKt$NavigationRow$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KTribeeBaseInfo $basicInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeDetailComposeKt$NavigationRow$6$1(KTribeeBaseInfo kTribeeBaseInfo, Continuation<? super TribeeDetailComposeKt$NavigationRow$6$1> continuation) {
        super(2, continuation);
        this.$basicInfo = kTribeeBaseInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeDetailComposeKt$NavigationRow$6$1(this.$basicInfo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KTribeeBaseInfo kTribeeBaseInfo = this.$basicInfo;
                boolean z = false;
                if (kTribeeBaseInfo != null && kTribeeBaseInfo.isNewCodeRedDot()) {
                    z = true;
                }
                TrackerKt.reportMenuNotifyExposure(z ? "red_point" : "no_notice");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}