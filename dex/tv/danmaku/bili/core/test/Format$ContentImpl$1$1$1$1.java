package tv.danmaku.bili.core.test;

import com.bilibili.video.story.extension.ToastToolsKt;
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
/* compiled from: CommonTestPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.core.test.测试大鸡儿的Format$ContentImpl$1$1$1$1", f = "CommonTestPage.kt", i = {}, l = {BR.currentRoleAudioDesc}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* renamed from: tv.danmaku.bili.core.test.测试大鸡儿的Format$ContentImpl$1$1$1$1  reason: invalid class name */
public final class Format$ContentImpl$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Format this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Format$ContentImpl$1$1$1$1(Format format, Continuation<? super Format$ContentImpl$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = format;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Format$ContentImpl$1$1$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object testNumberFormat;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.this$0.isRunning()) {
                    ToastToolsKt.showToast("测试正在进行中，请稍后再试");
                    return Unit.INSTANCE;
                }
                this.this$0.setRunning(true);
                this.label = 1;
                testNumberFormat = this.this$0.testNumberFormat((Continuation) this);
                if (testNumberFormat == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.setRunning(false);
        return Unit.INSTANCE;
    }
}