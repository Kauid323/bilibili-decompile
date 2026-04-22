package tv.danmaku.bili.change;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;

/* compiled from: AccountSwitchFragment.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ltv/danmaku/bili/change/ISwitchAction;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.change.AccountSwitchViewModel$handleAction$1$result$3", f = "AccountSwitchFragment.kt", i = {0, 1, 2, 3, 5}, l = {302, BR.inlineButton, BR.inputAlpha, BR.isBackVisible, BR.labelVisible, BR.job, BR.labelVisible, BR.labelVisible}, m = "invokeSuspend", n = {"$this$ActionResult", "$this$ActionResult", "$this$ActionResult", "$this$ActionResult", "$this$ActionResult"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"}, v = 1)
final class AccountSwitchViewModel$handleAction$1$result$3 extends SuspendLambda implements Function2<FlowCollector<? super ISwitchAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ISwitchAction $action;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountSwitchViewModel$handleAction$1$result$3(ISwitchAction iSwitchAction, Continuation<? super AccountSwitchViewModel$handleAction$1$result$3> continuation) {
        super(2, continuation);
        this.$action = iSwitchAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> accountSwitchViewModel$handleAction$1$result$3 = new AccountSwitchViewModel$handleAction$1$result$3(this.$action, continuation);
        accountSwitchViewModel$handleAction$1$result$3.L$0 = obj;
        return accountSwitchViewModel$handleAction$1$result$3;
    }

    public final Object invoke(FlowCollector<? super ISwitchAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: ConstInlineVisitor
        java.lang.ArrayIndexOutOfBoundsException: -1
        	at java.util.ArrayList.elementData(ArrayList.java:422)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.ConstInlineVisitor.needExplicitCast(ConstInlineVisitor.java:282)
        	at jadx.core.dex.visitors.ConstInlineVisitor.replaceArg(ConstInlineVisitor.java:263)
        	at jadx.core.dex.visitors.ConstInlineVisitor.replaceConst(ConstInlineVisitor.java:181)
        	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:109)
        	at jadx.core.dex.visitors.ConstInlineVisitor.process(ConstInlineVisitor.java:53)
        	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:45)
        */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0186: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY] A[D('$result' java.lang.Object)]), block:B:57:0x0185 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x018a: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY] A[D('$result' java.lang.Object)]), block:B:59:0x018a */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0187: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('$this$ActionResult' kotlinx.coroutines.flow.FlowCollector)]), block:B:57:0x0185 */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.change.AccountSwitchViewModel$handleAction$1$result$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}