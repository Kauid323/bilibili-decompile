package kntr.app.tribee.publish.ui.v2.internal;

import kntr.app.tribee.publish.core.v2.TribeePublishAction;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Header.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.internal.HeaderKt$Header$1$2$1$1", f = "Header.kt", i = {}, l = {61, 63}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HeaderKt$Header$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $contentToastString;
    final /* synthetic */ boolean $contentValid;
    final /* synthetic */ Function2<TribeePublishAction, Continuation<? super Unit>, Object> $onAction;
    final /* synthetic */ String $titleToastString;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HeaderKt$Header$1$2$1$1(boolean z, Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, String str, String str2, Continuation<? super HeaderKt$Header$1$2$1$1> continuation) {
        super(2, continuation);
        this.$contentValid = z;
        this.$onAction = function2;
        this.$titleToastString = str;
        this.$contentToastString = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeaderKt$Header$1$2$1$1(this.$contentValid, this.$onAction, this.$titleToastString, this.$contentToastString, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Function2<TribeePublishAction, Continuation<? super Unit>, Object> function2;
        TribeePublishAction.Publish publish;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$contentValid) {
                    Function2<TribeePublishAction, Continuation<? super Unit>, Object> function22 = this.$onAction;
                    TribeePublishAction.TrackerAction.PublishButtonClick publishButtonClick = TribeePublishAction.TrackerAction.PublishButtonClick.INSTANCE;
                    this.label = 1;
                    if (function22.invoke(publishButtonClick, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                function2 = this.$onAction;
                publish = new TribeePublishAction.Publish(this.$titleToastString, this.$contentToastString, false, 4, null);
                this.label = 2;
                if (function2.invoke(publish, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                function2 = this.$onAction;
                publish = new TribeePublishAction.Publish(this.$titleToastString, this.$contentToastString, false, 4, null);
                this.label = 2;
                if (function2.invoke(publish, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}