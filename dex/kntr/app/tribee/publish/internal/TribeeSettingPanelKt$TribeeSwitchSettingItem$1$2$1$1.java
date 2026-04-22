package kntr.app.tribee.publish.internal;

import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.tribee.publish.TribeePublishSettingItem;
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
/* compiled from: TribeeSettingPanel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.internal.TribeeSettingPanelKt$TribeeSwitchSettingItem$1$2$1$1", f = "TribeeSettingPanel.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSettingPanelKt$TribeeSwitchSettingItem$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    final /* synthetic */ TribeePublishSettingItem.Switch $item;
    final /* synthetic */ Function2<TribeePublishAction, Continuation<? super Unit>, Object> $onAction;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeSettingPanelKt$TribeeSwitchSettingItem$1$2$1$1(Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, TribeePublishSettingItem.Switch r3, boolean z, Continuation<? super TribeeSettingPanelKt$TribeeSwitchSettingItem$1$2$1$1> continuation) {
        super(2, continuation);
        this.$onAction = function2;
        this.$item = r3;
        this.$isChecked = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSettingPanelKt$TribeeSwitchSettingItem$1$2$1$1(this.$onAction, this.$item, this.$isChecked, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<TribeePublishAction, Continuation<? super Unit>, Object> function2 = this.$onAction;
                TribeePublishAction.SwitchSettingItem switchSettingItem = new TribeePublishAction.SwitchSettingItem(this.$item.getType(), this.$isChecked);
                this.label = 1;
                if (function2.invoke(switchSettingItem, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}