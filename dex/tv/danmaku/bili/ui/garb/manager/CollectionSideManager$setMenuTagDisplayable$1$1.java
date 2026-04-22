package tv.danmaku.bili.ui.garb.manager;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.manager.CollectionSideManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionSideManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.manager.CollectionSideManager$setMenuTagDisplayable$1$1", f = "CollectionSideManager.kt", i = {}, l = {BR.displayingBanner}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CollectionSideManager$setMenuTagDisplayable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $containerId;
    int label;
    final /* synthetic */ CollectionSideManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionSideManager$setMenuTagDisplayable$1$1(CollectionSideManager collectionSideManager, int i, Continuation<? super CollectionSideManager$setMenuTagDisplayable$1$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionSideManager;
        this.$containerId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionSideManager$setMenuTagDisplayable$1$1(this.this$0, this.$containerId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Map map;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                map = this.this$0.menuTagData;
                CollectionSideManager.MenuTagData menuTagData = (CollectionSideManager.MenuTagData) map.get(Boxing.boxInt(this.$containerId));
                if (menuTagData != null) {
                    this.label = 1;
                    if (menuTagData.reportTagRemoved((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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