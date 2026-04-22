package io.ktor.util.pipeline;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PipelinePhaseRelation.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lio/ktor/util/pipeline/PipelinePhaseRelation;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "<init>", "()V", "After", "Before", "Last", "Lio/ktor/util/pipeline/PipelinePhaseRelation$After;", "Lio/ktor/util/pipeline/PipelinePhaseRelation$Before;", "Lio/ktor/util/pipeline/PipelinePhaseRelation$Last;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PipelinePhaseRelation {
    public /* synthetic */ PipelinePhaseRelation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PipelinePhaseRelation() {
    }

    /* compiled from: PipelinePhaseRelation.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/pipeline/PipelinePhaseRelation$After;", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "Lio/ktor/util/pipeline/PipelinePhase;", "relativeTo", "<init>", "(Lio/ktor/util/pipeline/PipelinePhase;)V", "Lio/ktor/util/pipeline/PipelinePhase;", "getRelativeTo", "()Lio/ktor/util/pipeline/PipelinePhase;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223061509c0828d9e-3735-4f51-ba36-4f618f1c4193/20260223061509c0828d9e-3735-4f51-ba36-4f618f1c4193.dex */
    public static final class After extends PipelinePhaseRelation {
        private final PipelinePhase relativeTo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public After(PipelinePhase relativeTo) {
            super(null);
            Intrinsics.checkNotNullParameter(relativeTo, "relativeTo");
            this.relativeTo = relativeTo;
        }

        public final PipelinePhase getRelativeTo() {
            return this.relativeTo;
        }
    }

    /* compiled from: PipelinePhaseRelation.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/pipeline/PipelinePhaseRelation$Before;", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "Lio/ktor/util/pipeline/PipelinePhase;", "relativeTo", "<init>", "(Lio/ktor/util/pipeline/PipelinePhase;)V", "Lio/ktor/util/pipeline/PipelinePhase;", "getRelativeTo", "()Lio/ktor/util/pipeline/PipelinePhase;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223061509c0828d9e-3735-4f51-ba36-4f618f1c4193/20260223061509c0828d9e-3735-4f51-ba36-4f618f1c4193.dex */
    public static final class Before extends PipelinePhaseRelation {
        private final PipelinePhase relativeTo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Before(PipelinePhase relativeTo) {
            super(null);
            Intrinsics.checkNotNullParameter(relativeTo, "relativeTo");
            this.relativeTo = relativeTo;
        }

        public final PipelinePhase getRelativeTo() {
            return this.relativeTo;
        }
    }

    /* compiled from: PipelinePhaseRelation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/util/pipeline/PipelinePhaseRelation$Last;", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "<init>", "()V", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "other", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "equals", "(Ljava/lang/Object;)Z", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "hashCode", "()I", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "toString", "()Ljava/lang/String;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223061509c0828d9e-3735-4f51-ba36-4f618f1c4193/20260223061509c0828d9e-3735-4f51-ba36-4f618f1c4193.dex */
    public static final class Last extends PipelinePhaseRelation {
        public static final Last INSTANCE = new Last();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Last) {
                Last last = (Last) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 967869129;
        }

        public String toString() {
            return "Last";
        }

        private Last() {
            super(null);
        }
    }
}