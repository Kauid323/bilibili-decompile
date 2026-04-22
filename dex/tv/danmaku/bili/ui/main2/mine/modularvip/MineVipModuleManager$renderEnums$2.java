package tv.danmaku.bili.ui.main2.mine.modularvip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MineVipModuleManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$renderEnums$2", f = "MineVipModuleManager.kt", i = {}, l = {BR.currentRoleAudioDesc, BR.danmakuCountText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MineVipModuleManager$renderEnums$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MineVipModel $model;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MineVipModuleManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineVipModuleManager$renderEnums$2(MineVipModuleManager mineVipModuleManager, MineVipModel mineVipModel, Continuation<? super MineVipModuleManager$renderEnums$2> continuation) {
        super(2, continuation);
        this.this$0 = mineVipModuleManager;
        this.$model = mineVipModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> mineVipModuleManager$renderEnums$2 = new MineVipModuleManager$renderEnums$2(this.this$0, this.$model, continuation);
        mineVipModuleManager$renderEnums$2.L$0 = obj;
        return mineVipModuleManager$renderEnums$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Iterable iterable;
        List it;
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                iterable = this.this$0.enums;
                Iterable $this$map$iv = iterable;
                MineVipModel mineVipModel = this.$model;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv.add(BuildersKt.async$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new MineVipModuleManager$renderEnums$2$1$1((MineVipModuleEnum) item$iv$iv, mineVipModel, null), 3, (Object) null));
                }
                this.label = 1;
                if (AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                BLog.d(MineVipModuleManagerKt.TAG, "data render is completed.(" + this.$model + ")");
                this.label = 2;
                if (DelayKt.delay(1000L, (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = this.$model.getToReportPositions();
                if (!(it.isEmpty() ? false : true)) {
                    it = null;
                }
                if (it != null) {
                    MineVipModuleManager mineVipModuleManager = this.this$0;
                    MineVipModel mineVipModel2 = this.$model;
                    coroutineScope = mineVipModuleManager.reportScope;
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new MineVipModuleManager$renderEnums$2$3$1(mineVipModel2, null), 3, (Object) null);
                }
                return Unit.INSTANCE;
            case 1:
                $result2 = $result;
                ResultKt.throwOnFailure($result2);
                BLog.d(MineVipModuleManagerKt.TAG, "data render is completed.(" + this.$model + ")");
                this.label = 2;
                if (DelayKt.delay(1000L, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                it = this.$model.getToReportPositions();
                if (!(it.isEmpty() ? false : true)) {
                }
                if (it != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}