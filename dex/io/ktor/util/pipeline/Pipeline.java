package io.ktor.util.pipeline;

import com.bilibili.ship.theseus.united.page.intro.module.kingposition.KingPositionService;
import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Pipeline.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u000e\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u001b\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bBb\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012O\u0010\u0011\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u00100\n¢\u0006\u0004\b\u0007\u0010\u0012J \u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001bJ`\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052I\u0010\u001d\u001aE\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010!J^\u0010\"\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u00100\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J!\u0010%\u001a\u00020\u000e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b%\u0010&J#\u0010'\u001a\u00020\u000e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b'\u0010&J!\u0010(\u001a\u00020\u000e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b(\u0010&J!\u0010)\u001a\u00020\u000e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b)\u0010&J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J`\u0010.\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u00100\n2\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0004\b-\u0010#JX\u00101\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u00100\nH\u0000¢\u0006\u0004\b/\u00100J3\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J%\u00107\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u0001062\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u0002092\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020<2\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b=\u0010>JX\u0010?\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u00100\nH\u0002¢\u0006\u0004\b?\u00100J#\u0010@\u001a\u00020<2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b@\u0010AJX\u0010B\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u00100\nH\u0002¢\u0006\u0004\bB\u00100J\u000f\u0010C\u001a\u00020\u000eH\u0002¢\u0006\u0004\bC\u0010!J`\u0010E\u001a\u00020\u000e2O\u0010D\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u00100\nH\u0002¢\u0006\u0004\bE\u0010FJ#\u0010H\u001a\u00020\u000e2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000106H\u0002¢\u0006\u0004\bH\u0010IJ#\u0010K\u001a\u00020\u000e2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\bK\u0010&Jb\u0010L\u001a\u00020<2\u0006\u0010\t\u001a\u00020\u00052I\u0010\u001d\u001aE\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u0010H\u0002¢\u0006\u0004\bL\u0010MJ\u001f\u0010P\u001a\u00020<2\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u0005H\u0002¢\u0006\u0004\bP\u0010QR\u0017\u0010S\u001a\u00020R8\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001a\u0010W\u001a\u00020<8\u0016X\u0096D¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00010[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0017\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050\n8F¢\u0006\u0006\u001a\u0004\b`\u00100R\u0011\u0010b\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bb\u0010ZRº\u0001\u0010\u0011\u001aM\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u0010\u0018\u00010\n2Q\u0010c\u001aM\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0002\b\u0010\u0018\u00010\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bd\u00100\"\u0004\be\u0010FR\u0016\u0010f\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010XR\u0018\u0010g\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006i"}, d2 = {"Lio/ktor/util/pipeline/Pipeline;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "TSubject", "TContext", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lio/ktor/util/pipeline/PipelinePhase;", "phases", "<init>", "([Lio/ktor/util/pipeline/PipelinePhase;)V", "phase", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lio/ktor/util/pipeline/PipelineInterceptor;", "Lkotlin/ExtensionFunctionType;", "interceptors", "(Lio/ktor/util/pipeline/PipelinePhase;Ljava/util/List;)V", "context", "subject", "execute", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)V", "reference", "insertPhaseAfter", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhase;)V", "insertPhaseBefore", "block", "intercept", "(Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)V", "afterIntercepted", "()V", "interceptorsForPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Ljava/util/List;", KingPositionService.EXTRA_KEY_JUMP_FROM, "mergePhases", "(Lio/ktor/util/pipeline/Pipeline;)V", "mergeInterceptors", "merge", "resetFrom", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "toString", "()Ljava/lang/String;", "phaseInterceptors$ktor_utils", "phaseInterceptors", "interceptorsForTests$ktor_utils", "()Ljava/util/List;", "interceptorsForTests", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "createContext", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/util/pipeline/PhaseContent;", "findPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Lio/ktor/util/pipeline/PhaseContent;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "findPhaseIndex", "(Lio/ktor/util/pipeline/PipelinePhase;)I", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "hasPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Z", "cacheInterceptors", "fastPathMerge", "(Lio/ktor/util/pipeline/Pipeline;)Z", "sharedInterceptorsList", "resetInterceptorsList", "list", "notSharedInterceptorsList", "(Ljava/util/List;)V", "phaseContent", "setInterceptorsListFromPhase", "(Lio/ktor/util/pipeline/PhaseContent;)V", "pipeline", "setInterceptorsListFromAnotherPipeline", "tryAddToPhaseFastPath", "(Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)Z", "fromPhaseOrContent", "fromPhase", "insertRelativePhase", "(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelinePhase;)Z", "Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "developmentMode", "Z", "getDevelopmentMode", "()Z", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "phasesRaw", "Ljava/util/List;", "interceptorsQuantity", "I", "getItems", "items", "isEmpty", "value", "getInterceptors", "setInterceptors", "interceptorsListShared", "interceptorsListSharedPhase", "Lio/ktor/util/pipeline/PipelinePhase;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class Pipeline<TSubject, TContext> {
    private volatile /* synthetic */ Object _interceptors;
    private final Attributes attributes;
    private final boolean developmentMode;
    private boolean interceptorsListShared;
    private PipelinePhase interceptorsListSharedPhase;
    private int interceptorsQuantity;
    private final List<Object> phasesRaw;

    public Pipeline(PipelinePhase... phases) {
        Intrinsics.checkNotNullParameter(phases, "phases");
        this.attributes = AttributesJvmKt.Attributes(true);
        this.phasesRaw = CollectionsKt.mutableListOf(Arrays.copyOf(phases, phases.length));
        this._interceptors = null;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final List<PipelinePhase> getItems() {
        Iterable $this$map$iv = this.phasesRaw;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            PipelinePhase pipelinePhase = item$iv$iv instanceof PipelinePhase ? (PipelinePhase) item$iv$iv : null;
            if (pipelinePhase == null) {
                PhaseContent phaseContent = item$iv$iv instanceof PhaseContent ? (PhaseContent) item$iv$iv : null;
                PipelinePhase phase = phaseContent != null ? phaseContent.getPhase() : null;
                Intrinsics.checkNotNull(phase);
                pipelinePhase = phase;
            }
            destination$iv$iv.add(pipelinePhase);
        }
        return (List) destination$iv$iv;
    }

    public final boolean isEmpty() {
        return this.interceptorsQuantity == 0;
    }

    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> getInterceptors() {
        return (List) this._interceptors;
    }

    private final void setInterceptors(List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list) {
        this._interceptors = list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Pipeline(PipelinePhase phase, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list) {
        this(phase);
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            Function3 it = (Function3) element$iv;
            intercept(phase, it);
        }
    }

    public final Object execute(TContext tcontext, TSubject tsubject, Continuation<? super TSubject> continuation) {
        return createContext(tcontext, tsubject, continuation.getContext()).execute$ktor_utils(tsubject, continuation);
    }

    public final void addPhase(PipelinePhase phase) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        if (hasPhase(phase)) {
            return;
        }
        this.phasesRaw.add(phase);
    }

    public final void insertPhaseAfter(PipelinePhase reference, PipelinePhase phase) {
        PipelinePhaseRelation relation;
        PipelinePhase relatedTo;
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(phase, "phase");
        if (hasPhase(phase)) {
            return;
        }
        int index = findPhaseIndex(reference);
        if (index == -1) {
            throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
        }
        int lastRelatedPhaseIndex = index;
        int i = index + 1;
        int lastIndex = CollectionsKt.getLastIndex(this.phasesRaw);
        if (i <= lastIndex) {
            while (true) {
                Object obj = this.phasesRaw.get(i);
                PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                if (phaseContent != null && (relation = phaseContent.getRelation()) != null) {
                    PipelinePhaseRelation.After after = relation instanceof PipelinePhaseRelation.After ? (PipelinePhaseRelation.After) relation : null;
                    if (after != null && (relatedTo = after.getRelativeTo()) != null) {
                        lastRelatedPhaseIndex = Intrinsics.areEqual(relatedTo, reference) ? i : lastRelatedPhaseIndex;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        this.phasesRaw.add(lastRelatedPhaseIndex + 1, new PhaseContent(phase, new PipelinePhaseRelation.After(reference)));
    }

    public final void insertPhaseBefore(PipelinePhase reference, PipelinePhase phase) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(phase, "phase");
        if (hasPhase(phase)) {
            return;
        }
        int index = findPhaseIndex(reference);
        if (index == -1) {
            throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
        }
        this.phasesRaw.add(index, new PhaseContent(phase, new PipelinePhaseRelation.Before(reference)));
    }

    public final void intercept(PipelinePhase phase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(function3, "block");
        PhaseContent phaseContent = findPhase(phase);
        if (phaseContent == null) {
            throw new InvalidPhaseException("Phase " + phase + " was not registered for this pipeline");
        }
        if (tryAddToPhaseFastPath(phase, function3)) {
            this.interceptorsQuantity++;
            return;
        }
        phaseContent.addInterceptor(function3);
        this.interceptorsQuantity++;
        resetInterceptorsList();
        afterIntercepted();
    }

    public void afterIntercepted() {
    }

    public final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptorsForPhase(PipelinePhase phase) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(phase, "phase");
        Iterable $this$filterIsInstance$iv = this.phasesRaw;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof PhaseContent) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$firstOrNull$iv = (List) destination$iv$iv;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            PhaseContent phaseOrContent = (PhaseContent) element$iv;
            if (Intrinsics.areEqual(phaseOrContent.getPhase(), phase)) {
                break;
            }
        }
        PhaseContent phaseContent = (PhaseContent) element$iv;
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> sharedInterceptors = phaseContent != null ? phaseContent.sharedInterceptors() : null;
        return sharedInterceptors == null ? CollectionsKt.emptyList() : sharedInterceptors;
    }

    public final void mergePhases(Pipeline<TSubject, TContext> pipeline) {
        Intrinsics.checkNotNullParameter(pipeline, KingPositionService.EXTRA_KEY_JUMP_FROM);
        List fromPhases = pipeline.phasesRaw;
        List toInsert = CollectionsKt.toMutableList(fromPhases);
        while (!toInsert.isEmpty()) {
            Iterator iterator = toInsert.iterator();
            while (iterator.hasNext()) {
                Object fromPhaseOrContent = iterator.next();
                PipelinePhase fromPhase = fromPhaseOrContent instanceof PipelinePhase ? (PipelinePhase) fromPhaseOrContent : null;
                if (fromPhase == null) {
                    Intrinsics.checkNotNull(fromPhaseOrContent, "null cannot be cast to non-null type io.ktor.util.pipeline.PhaseContent<*, *>");
                    fromPhase = ((PhaseContent) fromPhaseOrContent).getPhase();
                }
                if (hasPhase(fromPhase)) {
                    iterator.remove();
                } else {
                    boolean inserted = insertRelativePhase(fromPhaseOrContent, fromPhase);
                    if (inserted) {
                        iterator.remove();
                    }
                }
            }
        }
    }

    private final void mergeInterceptors(Pipeline<TSubject, TContext> pipeline) {
        if (this.interceptorsQuantity == 0) {
            setInterceptorsListFromAnotherPipeline(pipeline);
        } else {
            resetInterceptorsList();
        }
        Iterable fromPhases = pipeline.phasesRaw;
        Iterable $this$forEach$iv = fromPhases;
        for (Object element$iv : $this$forEach$iv) {
            PipelinePhase fromPhase = element$iv instanceof PipelinePhase ? (PipelinePhase) element$iv : null;
            if (fromPhase == null) {
                Intrinsics.checkNotNull(element$iv, "null cannot be cast to non-null type io.ktor.util.pipeline.PhaseContent<*, *>");
                fromPhase = ((PhaseContent) element$iv).getPhase();
            }
            if ((element$iv instanceof PhaseContent) && !((PhaseContent) element$iv).isEmpty()) {
                PhaseContent phaseContent = (PhaseContent) element$iv;
                PhaseContent<TSubject, TContext> findPhase = findPhase(fromPhase);
                Intrinsics.checkNotNull(findPhase);
                ((PhaseContent) element$iv).addTo(findPhase);
                this.interceptorsQuantity += ((PhaseContent) element$iv).getSize();
            }
        }
    }

    public final void merge(Pipeline<TSubject, TContext> pipeline) {
        Intrinsics.checkNotNullParameter(pipeline, KingPositionService.EXTRA_KEY_JUMP_FROM);
        if (fastPathMerge(pipeline)) {
            return;
        }
        mergePhases(pipeline);
        mergeInterceptors(pipeline);
    }

    public final void resetFrom(Pipeline<TSubject, TContext> pipeline) {
        Intrinsics.checkNotNullParameter(pipeline, KingPositionService.EXTRA_KEY_JUMP_FROM);
        this.phasesRaw.clear();
        if (!(this.interceptorsQuantity == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        fastPathMerge(pipeline);
    }

    public String toString() {
        return super.toString();
    }

    public final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> phaseInterceptors$ktor_utils(PipelinePhase phase) {
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> sharedInterceptors;
        Intrinsics.checkNotNullParameter(phase, "phase");
        PhaseContent<TSubject, TContext> findPhase = findPhase(phase);
        return (findPhase == null || (sharedInterceptors = findPhase.sharedInterceptors()) == null) ? CollectionsKt.emptyList() : sharedInterceptors;
    }

    public final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptorsForTests$ktor_utils() {
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptors = getInterceptors();
        return interceptors == null ? cacheInterceptors() : interceptors;
    }

    private final PipelineContext<TSubject, TContext> createContext(TContext tcontext, TSubject tsubject, CoroutineContext coroutineContext) {
        return PipelineContextKt.pipelineContextFor(tcontext, sharedInterceptorsList(), tsubject, coroutineContext, getDevelopmentMode());
    }

    private final PhaseContent<TSubject, TContext> findPhase(PipelinePhase phase) {
        List phasesList = this.phasesRaw;
        int size = phasesList.size();
        for (int index = 0; index < size; index++) {
            Object current = phasesList.get(index);
            if (current == phase) {
                PhaseContent content = new PhaseContent(phase, PipelinePhaseRelation.Last.INSTANCE);
                phasesList.set(index, content);
                return content;
            } else if ((current instanceof PhaseContent) && ((PhaseContent) current).getPhase() == phase) {
                return (PhaseContent) current;
            }
        }
        return null;
    }

    private final int findPhaseIndex(PipelinePhase phase) {
        List phasesList = this.phasesRaw;
        int size = phasesList.size();
        for (int index = 0; index < size; index++) {
            Object current = phasesList.get(index);
            if (current == phase || ((current instanceof PhaseContent) && ((PhaseContent) current).getPhase() == phase)) {
                return index;
            }
        }
        return -1;
    }

    private final boolean hasPhase(PipelinePhase phase) {
        List phasesList = this.phasesRaw;
        int size = phasesList.size();
        for (int index = 0; index < size; index++) {
            Object current = phasesList.get(index);
            if (current == phase) {
                return true;
            }
            if ((current instanceof PhaseContent) && ((PhaseContent) current).getPhase() == phase) {
                return true;
            }
        }
        return false;
    }

    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> cacheInterceptors() {
        int interceptorsQuantity = this.interceptorsQuantity;
        if (interceptorsQuantity == 0) {
            notSharedInterceptorsList(CollectionsKt.emptyList());
            return CollectionsKt.emptyList();
        }
        List phases = this.phasesRaw;
        if (interceptorsQuantity == 1) {
            int phaseIndex = 0;
            int lastIndex = CollectionsKt.getLastIndex(phases);
            if (0 <= lastIndex) {
                while (true) {
                    Object obj = phases.get(phaseIndex);
                    PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                    if (phaseContent == null || phaseContent.isEmpty()) {
                        if (phaseIndex == lastIndex) {
                            break;
                        }
                        phaseIndex++;
                    } else {
                        List interceptors = phaseContent.sharedInterceptors();
                        setInterceptorsListFromPhase(phaseContent);
                        return interceptors;
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        int phaseIndex2 = 0;
        int lastIndex2 = CollectionsKt.getLastIndex(phases);
        if (0 <= lastIndex2) {
            while (true) {
                Object obj2 = phases.get(phaseIndex2);
                PhaseContent phase = obj2 instanceof PhaseContent ? (PhaseContent) obj2 : null;
                if (phase != null) {
                    phase.addTo(arrayList);
                }
                if (phaseIndex2 == lastIndex2) {
                    break;
                }
                phaseIndex2++;
            }
        }
        notSharedInterceptorsList(arrayList);
        return arrayList;
    }

    private final boolean fastPathMerge(Pipeline<TSubject, TContext> pipeline) {
        if (pipeline.phasesRaw.isEmpty()) {
            return true;
        }
        if (!this.phasesRaw.isEmpty()) {
            return false;
        }
        List fromPhases = pipeline.phasesRaw;
        int index = 0;
        int lastIndex = CollectionsKt.getLastIndex(fromPhases);
        if (0 <= lastIndex) {
            while (true) {
                Object fromPhaseOrContent = fromPhases.get(index);
                if (fromPhaseOrContent instanceof PipelinePhase) {
                    this.phasesRaw.add(fromPhaseOrContent);
                } else if (fromPhaseOrContent instanceof PhaseContent) {
                    PhaseContent phaseContent = (PhaseContent) fromPhaseOrContent;
                    this.phasesRaw.add(new PhaseContent(((PhaseContent) fromPhaseOrContent).getPhase(), ((PhaseContent) fromPhaseOrContent).getRelation(), ((PhaseContent) fromPhaseOrContent).sharedInterceptors()));
                }
                if (index == lastIndex) {
                    break;
                }
                index++;
            }
        }
        int index2 = this.interceptorsQuantity;
        this.interceptorsQuantity = index2 + pipeline.interceptorsQuantity;
        setInterceptorsListFromAnotherPipeline(pipeline);
        return true;
    }

    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> sharedInterceptorsList() {
        if (getInterceptors() == null) {
            cacheInterceptors();
        }
        this.interceptorsListShared = true;
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptors = getInterceptors();
        Intrinsics.checkNotNull(interceptors);
        return interceptors;
    }

    private final void resetInterceptorsList() {
        setInterceptors(null);
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = null;
    }

    private final void notSharedInterceptorsList(List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list) {
        setInterceptors(list);
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = null;
    }

    private final void setInterceptorsListFromPhase(PhaseContent<TSubject, TContext> phaseContent) {
        setInterceptors(phaseContent.sharedInterceptors());
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = phaseContent.getPhase();
    }

    private final void setInterceptorsListFromAnotherPipeline(Pipeline<TSubject, TContext> pipeline) {
        setInterceptors(pipeline.sharedInterceptorsList());
        this.interceptorsListShared = true;
        this.interceptorsListSharedPhase = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean tryAddToPhaseFastPath(PipelinePhase phase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3) {
        List currentInterceptors = getInterceptors();
        if (this.phasesRaw.isEmpty() || currentInterceptors == null || this.interceptorsListShared || !TypeIntrinsics.isMutableList(currentInterceptors)) {
            return false;
        }
        if (Intrinsics.areEqual(this.interceptorsListSharedPhase, phase)) {
            currentInterceptors.add(function3);
            return true;
        } else if (Intrinsics.areEqual(phase, CollectionsKt.last(this.phasesRaw)) || findPhaseIndex(phase) == CollectionsKt.getLastIndex(this.phasesRaw)) {
            PhaseContent<TSubject, TContext> findPhase = findPhase(phase);
            Intrinsics.checkNotNull(findPhase);
            findPhase.addInterceptor(function3);
            currentInterceptors.add(function3);
            return true;
        } else {
            return false;
        }
    }

    private final boolean insertRelativePhase(Object fromPhaseOrContent, PipelinePhase fromPhase) {
        PipelinePhaseRelation.Last fromPhaseRelation;
        if (fromPhaseOrContent == fromPhase) {
            fromPhaseRelation = PipelinePhaseRelation.Last.INSTANCE;
        } else {
            Intrinsics.checkNotNull(fromPhaseOrContent, "null cannot be cast to non-null type io.ktor.util.pipeline.PhaseContent<*, *>");
            fromPhaseRelation = ((PhaseContent) fromPhaseOrContent).getRelation();
        }
        if (fromPhaseRelation instanceof PipelinePhaseRelation.Last) {
            addPhase(fromPhase);
            return true;
        } else if ((fromPhaseRelation instanceof PipelinePhaseRelation.Before) && hasPhase(((PipelinePhaseRelation.Before) fromPhaseRelation).getRelativeTo())) {
            insertPhaseBefore(((PipelinePhaseRelation.Before) fromPhaseRelation).getRelativeTo(), fromPhase);
            return true;
        } else if (fromPhaseRelation instanceof PipelinePhaseRelation.After) {
            insertPhaseAfter(((PipelinePhaseRelation.After) fromPhaseRelation).getRelativeTo(), fromPhase);
            return true;
        } else {
            return false;
        }
    }
}