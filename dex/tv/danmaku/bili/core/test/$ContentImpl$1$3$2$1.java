package tv.danmaku.bili.core.test;

import androidx.compose.runtime.MutableState;
import com.bilibili.app.comm.restrict.OSTeenagersModeData;
import com.bilibili.app.comm.restrict.debug.KVOSTeenagersModeProviderKt;
import com.bilibili.app.comm.restrict.utils.TeenagersModeKt;
import com.bilibili.app.comm.restrict.utils.TeenagersModeSource;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommonTestPage.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.core.test.伪装成系统青少年开关$ContentImpl$1$3$2$1", f = "CommonTestPage.kt", i = {0}, l = {BR.foregroundTitleTextColor}, m = "invokeSuspend", n = {"it"}, s = {"I$0"}, v = 1)
/* renamed from: tv.danmaku.bili.core.test.伪装成系统青少年开关$ContentImpl$1$3$2$1  reason: invalid class name */
public final class $ContentImpl$1$3$2$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Integer> $currentAge;
    /* synthetic */ int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public $ContentImpl$1$3$2$1(MutableState<Integer> mutableState, Continuation<? super $ContentImpl$1$3$2$1> continuation) {
        super(2, continuation);
        this.$currentAge = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> _contentimpl_1_3_2_1 = new $ContentImpl$1$3$2$1(this.$currentAge, continuation);
        _contentimpl_1_3_2_1.I$0 = ((Number) obj).intValue();
        return _contentimpl_1_3_2_1;
    }

    public final Object invoke(int i, Continuation<? super Unit> continuation) {
        return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation) obj2);
    }

    public final Object invokeSuspend(Object $result) {
        int it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int it2 = this.I$0;
                if (TeenagersModeKt.getTeenagersModeSource() == TeenagersModeSource.OS) {
                    this.I$0 = it2;
                    this.label = 1;
                    if (TeenagersModeKt.setTeenagerAge(it2, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = it2;
                    this.$currentAge.setValue(Boxing.boxInt(it));
                    KVOSTeenagersModeProviderKt.getCurrentKVOSTMS().setValue(OSTeenagersModeData.copy$default((OSTeenagersModeData) KVOSTeenagersModeProviderKt.getCurrentKVOSTMS().getValue(), false, it, 1, (Object) null));
                    break;
                }
                break;
            case 1:
                it = this.I$0;
                ResultKt.throwOnFailure($result);
                ((Result) $result).unbox-impl();
                this.$currentAge.setValue(Boxing.boxInt(it));
                KVOSTeenagersModeProviderKt.getCurrentKVOSTMS().setValue(OSTeenagersModeData.copy$default((OSTeenagersModeData) KVOSTeenagersModeProviderKt.getCurrentKVOSTMS().getValue(), false, it, 1, (Object) null));
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}