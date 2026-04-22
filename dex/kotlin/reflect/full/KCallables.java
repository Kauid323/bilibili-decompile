package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;

/* compiled from: KCallables.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u001a\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a6\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\u00022\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0018\"\u0004\u0018\u00010\u0019H\u0087@¢\u0006\u0002\u0010\u001a\u001a4\u0010\u001b\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\u00022\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001cH\u0087@¢\u0006\u0002\u0010\u001d\"$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"$\u0010\f\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"instanceParameter", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KCallable;", "getInstanceParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "getInstanceParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "contextParameters", "", "getContextParameters$annotations", "getContextParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "extensionReceiverParameter", "getExtensionReceiverParameter$annotations", "getExtensionReceiverParameter", "valueParameters", "getValueParameters$annotations", "getValueParameters", "findParameterByName", "name", "", "callSuspend", "R", "args", "", "", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspendBy", "", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KCallables {
    public static /* synthetic */ void getContextParameters$annotations(KCallable kCallable) {
    }

    public static /* synthetic */ void getExtensionReceiverParameter$annotations(KCallable kCallable) {
    }

    public static /* synthetic */ void getInstanceParameter$annotations(KCallable kCallable) {
    }

    public static /* synthetic */ void getValueParameters$annotations(KCallable kCallable) {
    }

    public static final KParameter getInstanceParameter(KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Iterable $this$singleOrNull$iv = kCallable.getParameters();
        Object single$iv = null;
        boolean found$iv = false;
        Iterator<T> it = $this$singleOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object element$iv = it.next();
                KParameter it2 = (KParameter) element$iv;
                if (it2.getKind() == KParameter.Kind.INSTANCE) {
                    if (found$iv) {
                        single$iv = null;
                        break;
                    }
                    single$iv = element$iv;
                    found$iv = true;
                }
            } else if (!found$iv) {
                single$iv = null;
            }
        }
        return (KParameter) single$iv;
    }

    public static final List<KParameter> getContextParameters(KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Iterable $this$filter$iv = kCallable.getParameters();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            KParameter it = (KParameter) element$iv$iv;
            if (it.getKind() == KParameter.Kind.CONTEXT) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final KParameter getExtensionReceiverParameter(KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Iterable $this$singleOrNull$iv = kCallable.getParameters();
        Object single$iv = null;
        boolean found$iv = false;
        Iterator<T> it = $this$singleOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object element$iv = it.next();
                KParameter it2 = (KParameter) element$iv;
                if (it2.getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                    if (found$iv) {
                        single$iv = null;
                        break;
                    }
                    single$iv = element$iv;
                    found$iv = true;
                }
            } else if (!found$iv) {
                single$iv = null;
            }
        }
        return (KParameter) single$iv;
    }

    public static final List<KParameter> getValueParameters(KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Iterable $this$filter$iv = kCallable.getParameters();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            KParameter it = (KParameter) element$iv$iv;
            if (it.getKind() == KParameter.Kind.VALUE) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final KParameter findParameterByName(KCallable<?> kCallable, String name) {
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterable $this$singleOrNull$iv = kCallable.getParameters();
        Object single$iv = null;
        boolean found$iv = false;
        Iterator<T> it = $this$singleOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object element$iv = it.next();
                KParameter it2 = (KParameter) element$iv;
                if (Intrinsics.areEqual(it2.getName(), name)) {
                    if (found$iv) {
                        single$iv = null;
                        break;
                    }
                    single$iv = element$iv;
                    found$iv = true;
                }
            } else if (!found$iv) {
                single$iv = null;
            }
        }
        return (KParameter) single$iv;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object callSuspend(KCallable<? extends R> kCallable, Object[] args, Continuation<? super R> continuation) {
        KCallables$callSuspend$1 kCallables$callSuspend$1;
        Object call;
        if (continuation instanceof KCallables$callSuspend$1) {
            kCallables$callSuspend$1 = (KCallables$callSuspend$1) continuation;
            if ((kCallables$callSuspend$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                kCallables$callSuspend$1.label -= IntCompanionObject.MIN_VALUE;
                Object $result = kCallables$callSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kCallables$callSuspend$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!kCallable.isSuspend()) {
                            return kCallable.call(Arrays.copyOf(args, args.length));
                        }
                        if (!(kCallable instanceof KFunction)) {
                            throw new IllegalArgumentException("Cannot callSuspend on a property " + kCallable + ": suspend properties are not supported yet");
                        }
                        kCallables$callSuspend$1.L$0 = kCallable;
                        kCallables$callSuspend$1.L$1 = args;
                        kCallables$callSuspend$1.label = 1;
                        Continuation it = kCallables$callSuspend$1;
                        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                        spreadBuilder.addSpread(args);
                        spreadBuilder.add(it);
                        call = kCallable.call(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
                        if (call == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(kCallables$callSuspend$1);
                        }
                        if (call == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        Object[] objArr = (Object[]) kCallables$callSuspend$1.L$1;
                        kCallable = (KCallable) kCallables$callSuspend$1.L$0;
                        ResultKt.throwOnFailure($result);
                        call = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object result = call;
                return (Intrinsics.areEqual(((KFunction) kCallable).getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) || ((KFunction) kCallable).getReturnType().isMarkedNullable()) ? result : Unit.INSTANCE;
            }
        }
        kCallables$callSuspend$1 = new KCallables$callSuspend$1(continuation);
        Object $result2 = kCallables$callSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kCallables$callSuspend$1.label) {
        }
        Object result2 = call;
        if (Intrinsics.areEqual(((KFunction) kCallable).getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class))) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object callSuspendBy(KCallable<? extends R> kCallable, Map<KParameter, ? extends Object> map, Continuation<? super R> continuation) {
        KCallables$callSuspendBy$1 kCallables$callSuspendBy$1;
        Object callDefaultMethod$kotlin_reflection;
        if (continuation instanceof KCallables$callSuspendBy$1) {
            kCallables$callSuspendBy$1 = (KCallables$callSuspendBy$1) continuation;
            if ((kCallables$callSuspendBy$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                kCallables$callSuspendBy$1.label -= IntCompanionObject.MIN_VALUE;
                Object $result = kCallables$callSuspendBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kCallables$callSuspendBy$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (kCallable.isSuspend()) {
                            if (!(kCallable instanceof KFunction)) {
                                throw new IllegalArgumentException("Cannot callSuspendBy on a property " + kCallable + ": suspend properties are not supported yet");
                            }
                            KCallableImpl kCallable2 = UtilKt.asKCallableImpl(kCallable);
                            if (kCallable2 == null) {
                                throw new KotlinReflectionInternalError("This callable does not support a default call: " + kCallable);
                            }
                            kCallables$callSuspendBy$1.L$0 = kCallable;
                            kCallables$callSuspendBy$1.L$1 = map;
                            kCallables$callSuspendBy$1.L$2 = kCallable2;
                            kCallables$callSuspendBy$1.label = 1;
                            Continuation it = kCallables$callSuspendBy$1;
                            callDefaultMethod$kotlin_reflection = kCallable2.callDefaultMethod$kotlin_reflection(map, it);
                            if (callDefaultMethod$kotlin_reflection == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(kCallables$callSuspendBy$1);
                            }
                            if (callDefaultMethod$kotlin_reflection != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } else {
                            return kCallable.callBy(map);
                        }
                    case 1:
                        KCallableImpl kCallableImpl = (KCallableImpl) kCallables$callSuspendBy$1.L$2;
                        Map map2 = (Map) kCallables$callSuspendBy$1.L$1;
                        kCallable = (KCallable) kCallables$callSuspendBy$1.L$0;
                        ResultKt.throwOnFailure($result);
                        callDefaultMethod$kotlin_reflection = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object result = callDefaultMethod$kotlin_reflection;
                return (Intrinsics.areEqual(((KFunction) kCallable).getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) || ((KFunction) kCallable).getReturnType().isMarkedNullable()) ? result : Unit.INSTANCE;
            }
        }
        kCallables$callSuspendBy$1 = new KCallables$callSuspendBy$1(continuation);
        Object $result2 = kCallables$callSuspendBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kCallables$callSuspendBy$1.label) {
        }
        Object result2 = callDefaultMethod$kotlin_reflection;
        if (Intrinsics.areEqual(((KFunction) kCallable).getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class))) {
        }
    }
}