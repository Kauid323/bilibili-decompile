package io.ktor.util.debug;

import com.bilibili.ship.theseus.ogv.operation.OgvClickTarget;
import io.ktor.util.debug.plugins.PluginName;
import io.ktor.util.debug.plugins.PluginsTrace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;

/* compiled from: ContextUtils.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a4\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001a<\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\b\u001a\u00020\u00072\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a<\u0010\u0011\u001a\u00020\u000f\"\b\b\u0000\u0010\f*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u0001H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "initContextInDebugMode", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "pluginName", "addToContextInDebugMode", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext$Element;", "Element", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "", OgvClickTarget.URI_ACTION_KEY, "useContextElementInDebugMode", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextUtilsKt {
    public static final <T> Object initContextInDebugMode(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        if (IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected()) {
            CoroutineContext debugContext = continuation.getContext().plus(new PluginsTrace(null, 1, null));
            return BuildersKt.withContext(debugContext, new ContextUtilsKt$initContextInDebugMode$2(function1, null), continuation);
        }
        return function1.invoke(continuation);
    }

    public static final <T> Object addToContextInDebugMode(String pluginName, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        if (IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected()) {
            CoroutineContext debugContext = continuation.getContext().plus(new PluginName(pluginName));
            return BuildersKt.withContext(debugContext, new ContextUtilsKt$addToContextInDebugMode$2(function1, null), continuation);
        }
        return function1.invoke(continuation);
    }

    public static final <Element extends CoroutineContext.Element> Object useContextElementInDebugMode(CoroutineContext.Key<Element> key, Function1<? super Element, Unit> function1, Continuation<? super Unit> continuation) {
        if (IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected()) {
            CoroutineContext.Element element = continuation.getContext().get(key);
            if (element != null) {
                function1.invoke(element);
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}