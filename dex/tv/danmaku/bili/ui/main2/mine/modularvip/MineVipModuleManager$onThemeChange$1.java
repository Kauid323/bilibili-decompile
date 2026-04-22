package tv.danmaku.bili.ui.main2.mine.modularvip;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MineVipModuleManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$onThemeChange$1", f = "MineVipModuleManager.kt", i = {}, l = {BR.errorViewVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MineVipModuleManager$onThemeChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MineVipModuleManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineVipModuleManager$onThemeChange$1(MineVipModuleManager mineVipModuleManager, Continuation<? super MineVipModuleManager$onThemeChange$1> continuation) {
        super(2, continuation);
        this.this$0 = mineVipModuleManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MineVipModuleManager$onThemeChange$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0048 -> B:14:0x004b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Iterable iterable;
        Iterator it;
        MineVipModuleManager$onThemeChange$1 mineVipModuleManager$onThemeChange$1;
        Iterator it2;
        MineVipModuleManager$onThemeChange$1 mineVipModuleManager$onThemeChange$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                iterable = this.this$0.enums;
                Iterable $this$forEach$iv = iterable;
                it = $this$forEach$iv.iterator();
                mineVipModuleManager$onThemeChange$1 = this;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                it2 = (Iterator) this.L$0;
                mineVipModuleManager$onThemeChange$12 = this;
                mineVipModuleManager$onThemeChange$1 = mineVipModuleManager$onThemeChange$12;
                it = it2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!it.hasNext()) {
            Object element$iv = it.next();
            MineVipModuleEnum it3 = (MineVipModuleEnum) element$iv;
            mineVipModuleManager$onThemeChange$1.L$0 = it;
            mineVipModuleManager$onThemeChange$1.label = 1;
            if (it3.onTint(mineVipModuleManager$onThemeChange$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            it2 = it;
            mineVipModuleManager$onThemeChange$12 = mineVipModuleManager$onThemeChange$1;
            mineVipModuleManager$onThemeChange$1 = mineVipModuleManager$onThemeChange$12;
            it = it2;
            if (!it.hasNext()) {
                return Unit.INSTANCE;
            }
        }
    }
}