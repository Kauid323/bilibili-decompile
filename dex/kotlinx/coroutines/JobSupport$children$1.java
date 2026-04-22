package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: JobSupport.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {963, 965}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Job> sequenceScope, Continuation<? super Unit> continuation) {
        return ((JobSupport$children$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007d -> B:29:0x0097). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0095 -> B:29:0x0097). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        JobSupport$children$1 jobSupport$children$1;
        LockFreeLinkedListHead state;
        SequenceScope $this$sequence;
        LockFreeLinkedListHead this_$iv;
        LockFreeLinkedListNode cur$iv;
        JobSupport$children$1 jobSupport$children$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                jobSupport$children$1 = this;
                SequenceScope $this$sequence2 = (SequenceScope) jobSupport$children$1.L$0;
                Object state2 = jobSupport$children$1.this$0.getState$kotlinx_coroutines_core();
                if (state2 instanceof ChildHandleNode) {
                    jobSupport$children$1.label = 1;
                    if ($this$sequence2.yield(((ChildHandleNode) state2).childJob, jobSupport$children$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jobSupport$children$12 = jobSupport$children$1;
                    return Unit.INSTANCE;
                }
                if ((state2 instanceof Incomplete) && (state = ((Incomplete) state2).getList()) != null) {
                    LockFreeLinkedListHead this_$iv2 = state;
                    Object next = this_$iv2.getNext();
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                    LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                    $this$sequence = $this$sequence2;
                    this_$iv = this_$iv2;
                    cur$iv = lockFreeLinkedListNode;
                    if (!Intrinsics.areEqual(cur$iv, this_$iv)) {
                        if (cur$iv instanceof ChildHandleNode) {
                            ChildHandleNode it = (ChildHandleNode) cur$iv;
                            ChildJob childJob = it.childJob;
                            jobSupport$children$1.L$0 = $this$sequence;
                            jobSupport$children$1.L$1 = this_$iv;
                            jobSupport$children$1.L$2 = cur$iv;
                            jobSupport$children$1.label = 2;
                            if ($this$sequence.yield(childJob, jobSupport$children$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        cur$iv = cur$iv.getNextNode();
                        if (!Intrinsics.areEqual(cur$iv, this_$iv)) {
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                jobSupport$children$12 = this;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                jobSupport$children$1 = this;
                cur$iv = (LockFreeLinkedListNode) jobSupport$children$1.L$2;
                this_$iv = (LockFreeLinkedListHead) jobSupport$children$1.L$1;
                $this$sequence = (SequenceScope) jobSupport$children$1.L$0;
                ResultKt.throwOnFailure($result);
                cur$iv = cur$iv.getNextNode();
                if (!Intrinsics.areEqual(cur$iv, this_$iv)) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}