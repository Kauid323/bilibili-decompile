package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;

/* compiled from: Await.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH\u0086@¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AwaitKt {
    public static final <T> Object awaitAll(Deferred<? extends T>[] deferredArr, Continuation<? super List<? extends T>> continuation) {
        return deferredArr.length == 0 ? CollectionsKt.emptyList() : new AwaitAll(deferredArr).await(continuation);
    }

    public static final <T> Object awaitAll(Collection<? extends Deferred<? extends T>> collection, Continuation<? super List<? extends T>> continuation) {
        return collection.isEmpty() ? CollectionsKt.emptyList() : new AwaitAll((Deferred[]) collection.toArray(new Deferred[0])).await(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0058 -> B:19:0x0059). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object joinAll(Job[] jobArr, Continuation<? super Unit> continuation) {
        AwaitKt$joinAll$1 awaitKt$joinAll$1;
        AwaitKt$joinAll$1 awaitKt$joinAll$12;
        int length;
        int i;
        Job[] jobArr2;
        if (continuation instanceof AwaitKt$joinAll$1) {
            awaitKt$joinAll$1 = (AwaitKt$joinAll$1) continuation;
            if ((awaitKt$joinAll$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                awaitKt$joinAll$1.label -= IntCompanionObject.MIN_VALUE;
                awaitKt$joinAll$12 = awaitKt$joinAll$1;
                Object $result = awaitKt$joinAll$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (awaitKt$joinAll$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        length = jobArr.length;
                        i = 0;
                        jobArr2 = jobArr;
                        break;
                    case 1:
                        length = awaitKt$joinAll$12.I$1;
                        i = awaitKt$joinAll$12.I$0;
                        jobArr2 = (Job[]) awaitKt$joinAll$12.L$0;
                        ResultKt.throwOnFailure($result);
                        i++;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (i < length) {
                    Job it = jobArr2[i];
                    awaitKt$joinAll$12.L$0 = jobArr2;
                    awaitKt$joinAll$12.I$0 = i;
                    awaitKt$joinAll$12.I$1 = length;
                    awaitKt$joinAll$12.label = 1;
                    if (it.join(awaitKt$joinAll$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i++;
                    if (i < length) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
        awaitKt$joinAll$1 = new AwaitKt$joinAll$1(continuation);
        awaitKt$joinAll$12 = awaitKt$joinAll$1;
        Object $result2 = awaitKt$joinAll$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (awaitKt$joinAll$12.label) {
        }
        if (i < length) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object joinAll(Collection<? extends Job> collection, Continuation<? super Unit> continuation) {
        AwaitKt$joinAll$3 awaitKt$joinAll$3;
        AwaitKt$joinAll$3 awaitKt$joinAll$32;
        Iterator it;
        if (continuation instanceof AwaitKt$joinAll$3) {
            awaitKt$joinAll$3 = (AwaitKt$joinAll$3) continuation;
            if ((awaitKt$joinAll$3.label & IntCompanionObject.MIN_VALUE) != 0) {
                awaitKt$joinAll$3.label -= IntCompanionObject.MIN_VALUE;
                awaitKt$joinAll$32 = awaitKt$joinAll$3;
                Object $result = awaitKt$joinAll$32.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (awaitKt$joinAll$32.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Collection<? extends Job> $this$forEach$iv = collection;
                        it = $this$forEach$iv.iterator();
                        break;
                    case 1:
                        it = (Iterator) awaitKt$joinAll$32.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (it.hasNext()) {
                    Object element$iv = it.next();
                    Job it2 = (Job) element$iv;
                    awaitKt$joinAll$32.L$0 = it;
                    awaitKt$joinAll$32.label = 1;
                    if (it2.join(awaitKt$joinAll$32) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        awaitKt$joinAll$3 = new AwaitKt$joinAll$3(continuation);
        awaitKt$joinAll$32 = awaitKt$joinAll$3;
        Object $result2 = awaitKt$joinAll$32.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (awaitKt$joinAll$32.label) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}