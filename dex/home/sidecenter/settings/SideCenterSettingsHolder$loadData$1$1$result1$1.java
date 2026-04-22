package home.sidecenter.settings;

import com.bapis.bilibili.app.home.v1.KHomeMoss;
import com.bapis.bilibili.app.home.v1.KTopLeftTabReq;
import com.bapis.bilibili.app.home.v1.KTopLeftTabRes;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SideCenterSettingsHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bapis/bilibili/app/home/v1/KTopLeftTabRes;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.settings.SideCenterSettingsHolder$loadData$1$1$result1$1", f = "SideCenterSettingsHolder.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SideCenterSettingsHolder$loadData$1$1$result1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KTopLeftTabRes>, Object> {
    final /* synthetic */ Ref.ObjectRef<Exception> $exception;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SideCenterSettingsHolder$loadData$1$1$result1$1(Ref.ObjectRef<Exception> objectRef, Continuation<? super SideCenterSettingsHolder$loadData$1$1$result1$1> continuation) {
        super(2, continuation);
        this.$exception = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SideCenterSettingsHolder$loadData$1$1$result1$1(this.$exception, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KTopLeftTabRes> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    obj = new KHomeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).topLeftTab(new KTopLeftTabReq(), (Continuation) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (KTopLeftTabRes) obj;
        } catch (Exception e2) {
            Ref.ObjectRef<Exception> objectRef = this.$exception;
            Exception exc = (Exception) this.$exception.element;
            if (exc == null) {
                exc = e2;
            }
            objectRef.element = exc;
            KLog_androidKt.getKLog().e("SideCenterSettingsHolder", "Failed load settings tab", e2);
            return null;
        }
    }
}