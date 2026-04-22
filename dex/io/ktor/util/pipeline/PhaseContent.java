package io.ktor.util.pipeline;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: PhaseContent.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 5*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u00015Bh\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012O\u0010\u000f\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r¢\u0006\u0002\b\u000e0\b¢\u0006\u0004\b\u0010\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0012JX\u0010\u0014\u001a\u00020\f2I\u0010\u0013\u001aE\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u0014\u0010\u0015J^\u0010\u0017\u001a\u00020\f2O\u0010\u0016\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r¢\u0006\u0002\b\u000e0\b¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0017\u001a\u00020\f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b\u0017\u0010\u0019JV\u0010\u001a\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r¢\u0006\u0002\b\u000e0\b¢\u0006\u0004\b\u001a\u0010\u001bJX\u0010\u001c\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r¢\u0006\u0002\b\u000e0\bH\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R_\u0010\u000f\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r¢\u0006\u0002\b\u000e0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u00100\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b0\u0010-R\u0011\u00104\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lio/ktor/util/pipeline/PhaseContent;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "TSubject", "Call", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "relation", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lio/ktor/util/pipeline/PipelineInterceptor;", "Lkotlin/ExtensionFunctionType;", "interceptors", "<init>", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhaseRelation;Ljava/util/List;)V", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhaseRelation;)V", "interceptor", "addInterceptor", "(Lkotlin/jvm/functions/Function3;)V", "destination", "addTo", "(Ljava/util/List;)V", "(Lio/ktor/util/pipeline/PhaseContent;)V", "sharedInterceptors", "()Ljava/util/List;", "copiedInterceptors", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "toString", "()Ljava/lang/String;", "copyInterceptors", "()V", "Lio/ktor/util/pipeline/PipelinePhase;", "getPhase", "()Lio/ktor/util/pipeline/PipelinePhase;", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "getRelation", "()Lio/ktor/util/pipeline/PipelinePhaseRelation;", "Ljava/util/List;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "shared", "Z", "getShared", "()Z", "setShared", "(Z)V", "isEmpty", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "getSize", "()I", "size", "Companion", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhaseContent<TSubject, Call> {
    public static final Companion Companion = new Companion(null);
    private static final List<Object> SharedArrayList = new ArrayList();
    private List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> interceptors;
    private final PipelinePhase phase;
    private final PipelinePhaseRelation relation;
    private boolean shared;

    public PhaseContent(PipelinePhase phase, PipelinePhaseRelation relation, List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> list) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        this.phase = phase;
        this.relation = relation;
        this.interceptors = list;
        this.shared = true;
    }

    public final PipelinePhase getPhase() {
        return this.phase;
    }

    public final PipelinePhaseRelation getRelation() {
        return this.relation;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PhaseContent(PipelinePhase phase, PipelinePhaseRelation relation) {
        this(phase, relation, TypeIntrinsics.asMutableList(r0));
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(relation, "relation");
        List<Object> list = SharedArrayList;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<@[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent>, TSubject of io.ktor.util.pipeline.PhaseContent, kotlin.Unit>>");
        if (!SharedArrayList.isEmpty()) {
            throw new IllegalStateException("The shared empty array list has been modified".toString());
        }
    }

    public final boolean getShared() {
        return this.shared;
    }

    public final void setShared(boolean z) {
        this.shared = z;
    }

    public final boolean isEmpty() {
        return this.interceptors.isEmpty();
    }

    public final int getSize() {
        return this.interceptors.size();
    }

    public final void addInterceptor(Function3<? super PipelineContext<TSubject, Call>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "interceptor");
        if (this.shared) {
            copyInterceptors();
        }
        this.interceptors.add(function3);
    }

    public final void addTo(List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> list) {
        Intrinsics.checkNotNullParameter(list, "destination");
        List interceptors = this.interceptors;
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(((ArrayList) list).size() + interceptors.size());
        }
        int size = interceptors.size();
        for (int index = 0; index < size; index++) {
            list.add(interceptors.get(index));
        }
    }

    public final void addTo(PhaseContent<TSubject, Call> phaseContent) {
        Intrinsics.checkNotNullParameter(phaseContent, "destination");
        if (isEmpty()) {
            return;
        }
        if (phaseContent.isEmpty()) {
            phaseContent.interceptors = sharedInterceptors();
            phaseContent.shared = true;
            return;
        }
        if (phaseContent.shared) {
            phaseContent.copyInterceptors();
        }
        addTo(phaseContent.interceptors);
    }

    public final List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> sharedInterceptors() {
        this.shared = true;
        return this.interceptors;
    }

    private final List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> copiedInterceptors() {
        return CollectionsKt.toMutableList(this.interceptors);
    }

    public String toString() {
        return "Phase `" + this.phase.getName() + "`, " + getSize() + " handlers";
    }

    private final void copyInterceptors() {
        this.interceptors = copiedInterceptors();
        this.shared = false;
    }

    /* compiled from: PhaseContent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/pipeline/PhaseContent$Companion;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "<init>", "()V", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "SharedArrayList", "Ljava/util/List;", "getSharedArrayList", "()Ljava/util/List;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223061509c0828d9e-3735-4f51-ba36-4f618f1c4193/20260223061509c0828d9e-3735-4f51-ba36-4f618f1c4193.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Object> getSharedArrayList() {
            return PhaseContent.SharedArrayList;
        }
    }
}