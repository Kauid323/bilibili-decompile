package tv.danmaku.bili.quick.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: OnePassLoginPathLinkManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus;", "", "phaseType", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "<init>", "(Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;)V", "getPhaseType", "()Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "Going", "Failed", "Passed", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus$Failed;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus$Going;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus$Passed;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class OnePassLoginPhaseStatus {
    public static final int $stable = 0;
    private final OnePassLoginPhaseType phaseType;

    public /* synthetic */ OnePassLoginPhaseStatus(OnePassLoginPhaseType onePassLoginPhaseType, DefaultConstructorMarker defaultConstructorMarker) {
        this(onePassLoginPhaseType);
    }

    /* compiled from: OnePassLoginPathLinkManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus$Going;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus;", "phaseType", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "<init>", "(Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;)V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Going extends OnePassLoginPhaseStatus {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Going(OnePassLoginPhaseType phaseType) {
            super(phaseType, null);
            Intrinsics.checkNotNullParameter(phaseType, "phaseType");
        }
    }

    private OnePassLoginPhaseStatus(OnePassLoginPhaseType phaseType) {
        this.phaseType = phaseType;
    }

    public final OnePassLoginPhaseType getPhaseType() {
        return this.phaseType;
    }

    /* compiled from: OnePassLoginPathLinkManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus$Failed;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus;", "phaseType", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "reason", "", "<init>", "(Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Failed extends OnePassLoginPhaseStatus {
        public static final int $stable = 0;
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(OnePassLoginPhaseType phaseType, String reason) {
            super(phaseType, null);
            Intrinsics.checkNotNullParameter(phaseType, "phaseType");
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* compiled from: OnePassLoginPathLinkManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus$Passed;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseStatus;", "phaseType", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "<init>", "(Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;)V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Passed extends OnePassLoginPhaseStatus {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Passed(OnePassLoginPhaseType phaseType) {
            super(phaseType, null);
            Intrinsics.checkNotNullParameter(phaseType, "phaseType");
        }
    }
}