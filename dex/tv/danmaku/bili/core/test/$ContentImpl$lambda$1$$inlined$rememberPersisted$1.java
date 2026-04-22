package tv.danmaku.bili.core.test;

import androidx.compose.runtime.MutableState;
import com.bilibili.app.comm.list.common.cache.PersistedValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* compiled from: PersistedProperty.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/bilibili/app/comm/list/common/cache/PersistedPropertyKt$rememberPersisted$1$1"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "com.bilibili.app.comm.list.common.cache.PersistedPropertyKt$rememberPersisted$1$1", f = "PersistedProperty.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* renamed from: tv.danmaku.bili.core.test.伪装成系统青少年开关$ContentImpl$lambda$1$$inlined$rememberPersisted$1  reason: invalid class name */
public final class $ContentImpl$lambda$1$$inlined$rememberPersisted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState $result;
    final /* synthetic */ PersistedValue $value;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public $ContentImpl$lambda$1$$inlined$rememberPersisted$1(PersistedValue persistedValue, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$value = persistedValue;
        this.$result = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new $ContentImpl$lambda$1$$inlined$rememberPersisted$1(this.$value, this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (!Intrinsics.areEqual(this.$value.getV(), this.$result.getValue())) {
                    this.$value.setV(this.$result.getValue());
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}