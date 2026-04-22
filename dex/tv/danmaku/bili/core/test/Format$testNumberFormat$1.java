package tv.danmaku.bili.core.test;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommonTestPage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.core.test.测试大鸡儿的Format", f = "CommonTestPage.kt", i = {0, 0, 0}, l = {102}, m = "testNumberFormat", n = {"success", "failureTimes", "i"}, s = {"I$0", "I$1", "J$0"}, v = 1)
/* renamed from: tv.danmaku.bili.core.test.测试大鸡儿的Format$testNumberFormat$1  reason: invalid class name */
public final class Format$testNumberFormat$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Format this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Format$testNumberFormat$1(Format format, Continuation<? super Format$testNumberFormat$1> continuation) {
        super(continuation);
        this.this$0 = format;
    }

    public final Object invokeSuspend(Object obj) {
        Object testNumberFormat;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        testNumberFormat = this.this$0.testNumberFormat((Continuation) this);
        return testNumberFormat;
    }
}