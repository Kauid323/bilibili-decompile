package video.biz.offline.list.ui.widget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageEvent;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineSettingComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.ui.widget.OfflineSettingComponentKt$mapToSettingComponent$4$1$1", f = "OfflineSettingComponent.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineSettingComponentKt$mapToSettingComponent$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OfflineSettingsPageStore $store;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineSettingComponentKt$mapToSettingComponent$4$1$1(OfflineSettingsPageStore offlineSettingsPageStore, Continuation<? super OfflineSettingComponentKt$mapToSettingComponent$4$1$1> continuation) {
        super(2, continuation);
        this.$store = offlineSettingsPageStore;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineSettingComponentKt$mapToSettingComponent$4$1$1(this.$store, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$store.getMachine().dispatch(OfflineSettingsPageEvent.ClickOfflineDiagnose.INSTANCE, (Continuation) this) == coroutine_suspended) {
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