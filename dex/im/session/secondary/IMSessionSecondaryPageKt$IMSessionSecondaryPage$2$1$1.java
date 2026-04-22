package im.session.secondary;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.PvEventTriggerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionSecondaryPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.secondary.IMSessionSecondaryPageKt$IMSessionSecondaryPage$2$1$1", f = "IMSessionSecondaryPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionSecondaryPageKt$IMSessionSecondaryPage$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KSessionPageType $pageType;
    final /* synthetic */ PvEventTrigger $pvTrigger;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionSecondaryPageKt$IMSessionSecondaryPage$2$1$1(PvEventTrigger pvEventTrigger, KSessionPageType kSessionPageType, Continuation<? super IMSessionSecondaryPageKt$IMSessionSecondaryPage$2$1$1> continuation) {
        super(2, continuation);
        this.$pvTrigger = pvEventTrigger;
        this.$pageType = kSessionPageType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSessionSecondaryPageKt$IMSessionSecondaryPage$2$1$1(this.$pvTrigger, this.$pageType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PvEventTriggerKt.updateExtra(this.$pvTrigger, "scene", this.$pageType.getName());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}