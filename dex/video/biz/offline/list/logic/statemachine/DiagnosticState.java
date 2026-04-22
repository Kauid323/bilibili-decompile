package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.ResourceValidateCode;
import video.biz.offline.base.infra.utils.ResourceValidateImpl_androidKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DownloadErrorType;
import video.biz.offline.base.model.error.OfflineError;
import video.biz.offline.list.logic.list.OfflineResolveDataProviderKt;
import video.biz.offline.list.logic.utils.UtilsKt;

/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState;", "", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)V", "getEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "Completed", "Damaged", "Incomplete", "Companion", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Completed;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class DiagnosticState {
    private final OfflineVideoEntity entity;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = OfflineVideoEntity.$stable;

    public /* synthetic */ DiagnosticState(OfflineVideoEntity offlineVideoEntity, DefaultConstructorMarker defaultConstructorMarker) {
        this(offlineVideoEntity);
    }

    private DiagnosticState(OfflineVideoEntity entity) {
        this.entity = entity;
    }

    public OfflineVideoEntity getEntity() {
        return this.entity;
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Completed;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState;", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)V", "getEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Completed extends DiagnosticState {
        public static final int $stable = OfflineVideoEntity.$stable | OfflineVideoEntity.$stable;
        private final OfflineVideoEntity entity;

        public static /* synthetic */ Completed copy$default(Completed completed, OfflineVideoEntity offlineVideoEntity, int i, Object obj) {
            if ((i & 1) != 0) {
                offlineVideoEntity = completed.entity;
            }
            return completed.copy(offlineVideoEntity);
        }

        public final OfflineVideoEntity component1() {
            return this.entity;
        }

        public final Completed copy(OfflineVideoEntity offlineVideoEntity) {
            Intrinsics.checkNotNullParameter(offlineVideoEntity, "entity");
            return new Completed(offlineVideoEntity);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Completed) && Intrinsics.areEqual(this.entity, ((Completed) obj).entity);
        }

        public int hashCode() {
            return this.entity.hashCode();
        }

        public String toString() {
            return "Completed(entity=" + this.entity + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Completed(OfflineVideoEntity entity) {
            super(entity, null);
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.entity = entity;
        }

        @Override // video.biz.offline.list.logic.statemachine.DiagnosticState
        public OfflineVideoEntity getEntity() {
            return this.entity;
        }
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState;", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "reason", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason;)V", "getEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "getReason", "()Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Reason", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Damaged extends DiagnosticState {
        public static final int $stable = OfflineVideoEntity.$stable | OfflineVideoEntity.$stable;
        private final OfflineVideoEntity entity;
        private final Reason reason;

        public static /* synthetic */ Damaged copy$default(Damaged damaged, OfflineVideoEntity offlineVideoEntity, Reason reason, int i, Object obj) {
            if ((i & 1) != 0) {
                offlineVideoEntity = damaged.entity;
            }
            if ((i & 2) != 0) {
                reason = damaged.reason;
            }
            return damaged.copy(offlineVideoEntity, reason);
        }

        public final OfflineVideoEntity component1() {
            return this.entity;
        }

        public final Reason component2() {
            return this.reason;
        }

        public final Damaged copy(OfflineVideoEntity offlineVideoEntity, Reason reason) {
            Intrinsics.checkNotNullParameter(offlineVideoEntity, "entity");
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Damaged(offlineVideoEntity, reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Damaged) {
                Damaged damaged = (Damaged) obj;
                return Intrinsics.areEqual(this.entity, damaged.entity) && Intrinsics.areEqual(this.reason, damaged.reason);
            }
            return false;
        }

        public int hashCode() {
            return (this.entity.hashCode() * 31) + this.reason.hashCode();
        }

        public String toString() {
            OfflineVideoEntity offlineVideoEntity = this.entity;
            return "Damaged(entity=" + offlineVideoEntity + ", reason=" + this.reason + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Damaged(OfflineVideoEntity entity, Reason reason) {
            super(entity, null);
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.entity = entity;
            this.reason = reason;
        }

        @Override // video.biz.offline.list.logic.statemachine.DiagnosticState
        public OfflineVideoEntity getEntity() {
            return this.entity;
        }

        public final Reason getReason() {
            return this.reason;
        }

        /* compiled from: OfflineDiagnosePageStore.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason;", "", "<init>", "()V", "WithUnretryableDownloadingError", "DownloadedButInvalid", "DownloadingButInvalid", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason$DownloadedButInvalid;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason$DownloadingButInvalid;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason$WithUnretryableDownloadingError;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static abstract class Reason {
            public static final int $stable = 0;

            public /* synthetic */ Reason(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* compiled from: OfflineDiagnosePageStore.kt */
            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason$WithUnretryableDownloadingError;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason;", "errorType", "Lvideo/biz/offline/base/model/error/DownloadErrorType;", "<init>", "(Lvideo/biz/offline/base/model/error/DownloadErrorType;)V", "getErrorType", "()Lvideo/biz/offline/base/model/error/DownloadErrorType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class WithUnretryableDownloadingError extends Reason {
                public static final int $stable = 0;
                private final DownloadErrorType errorType;

                public static /* synthetic */ WithUnretryableDownloadingError copy$default(WithUnretryableDownloadingError withUnretryableDownloadingError, DownloadErrorType downloadErrorType, int i, Object obj) {
                    if ((i & 1) != 0) {
                        downloadErrorType = withUnretryableDownloadingError.errorType;
                    }
                    return withUnretryableDownloadingError.copy(downloadErrorType);
                }

                public final DownloadErrorType component1() {
                    return this.errorType;
                }

                public final WithUnretryableDownloadingError copy(DownloadErrorType downloadErrorType) {
                    Intrinsics.checkNotNullParameter(downloadErrorType, "errorType");
                    return new WithUnretryableDownloadingError(downloadErrorType);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof WithUnretryableDownloadingError) && this.errorType == ((WithUnretryableDownloadingError) obj).errorType;
                }

                public int hashCode() {
                    return this.errorType.hashCode();
                }

                public String toString() {
                    return "WithUnretryableDownloadingError(errorType=" + this.errorType + ")";
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public WithUnretryableDownloadingError(DownloadErrorType errorType) {
                    super(null);
                    Intrinsics.checkNotNullParameter(errorType, "errorType");
                    this.errorType = errorType;
                }

                public final DownloadErrorType getErrorType() {
                    return this.errorType;
                }
            }

            private Reason() {
            }

            /* compiled from: OfflineDiagnosePageStore.kt */
            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason$DownloadedButInvalid;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason;", "code", "Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;", "<init>", "(Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;)V", "getCode", "()Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class DownloadedButInvalid extends Reason {
                public static final int $stable = 0;
                private final ResourceValidateCode code;

                public static /* synthetic */ DownloadedButInvalid copy$default(DownloadedButInvalid downloadedButInvalid, ResourceValidateCode resourceValidateCode, int i, Object obj) {
                    if ((i & 1) != 0) {
                        resourceValidateCode = downloadedButInvalid.code;
                    }
                    return downloadedButInvalid.copy(resourceValidateCode);
                }

                public final ResourceValidateCode component1() {
                    return this.code;
                }

                public final DownloadedButInvalid copy(ResourceValidateCode resourceValidateCode) {
                    Intrinsics.checkNotNullParameter(resourceValidateCode, "code");
                    return new DownloadedButInvalid(resourceValidateCode);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof DownloadedButInvalid) && this.code == ((DownloadedButInvalid) obj).code;
                }

                public int hashCode() {
                    return this.code.hashCode();
                }

                public String toString() {
                    return "DownloadedButInvalid(code=" + this.code + ")";
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public DownloadedButInvalid(ResourceValidateCode code) {
                    super(null);
                    Intrinsics.checkNotNullParameter(code, "code");
                    this.code = code;
                }

                public final ResourceValidateCode getCode() {
                    return this.code;
                }
            }

            /* compiled from: OfflineDiagnosePageStore.kt */
            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason$DownloadingButInvalid;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason;", "code", "Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;", "<init>", "(Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;)V", "getCode", "()Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class DownloadingButInvalid extends Reason {
                public static final int $stable = 0;
                private final ResourceValidateCode code;

                public static /* synthetic */ DownloadingButInvalid copy$default(DownloadingButInvalid downloadingButInvalid, ResourceValidateCode resourceValidateCode, int i, Object obj) {
                    if ((i & 1) != 0) {
                        resourceValidateCode = downloadingButInvalid.code;
                    }
                    return downloadingButInvalid.copy(resourceValidateCode);
                }

                public final ResourceValidateCode component1() {
                    return this.code;
                }

                public final DownloadingButInvalid copy(ResourceValidateCode resourceValidateCode) {
                    Intrinsics.checkNotNullParameter(resourceValidateCode, "code");
                    return new DownloadingButInvalid(resourceValidateCode);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof DownloadingButInvalid) && this.code == ((DownloadingButInvalid) obj).code;
                }

                public int hashCode() {
                    return this.code.hashCode();
                }

                public String toString() {
                    return "DownloadingButInvalid(code=" + this.code + ")";
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public DownloadingButInvalid(ResourceValidateCode code) {
                    super(null);
                    Intrinsics.checkNotNullParameter(code, "code");
                    this.code = code;
                }

                public final ResourceValidateCode getCode() {
                    return this.code;
                }
            }
        }
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState;", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "reason", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason;)V", "getEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "getReason", "()Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Reason", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Incomplete extends DiagnosticState {
        public static final int $stable = OfflineVideoEntity.$stable | OfflineVideoEntity.$stable;
        private final OfflineVideoEntity entity;
        private final Reason reason;

        public static /* synthetic */ Incomplete copy$default(Incomplete incomplete, OfflineVideoEntity offlineVideoEntity, Reason reason, int i, Object obj) {
            if ((i & 1) != 0) {
                offlineVideoEntity = incomplete.entity;
            }
            if ((i & 2) != 0) {
                reason = incomplete.reason;
            }
            return incomplete.copy(offlineVideoEntity, reason);
        }

        public final OfflineVideoEntity component1() {
            return this.entity;
        }

        public final Reason component2() {
            return this.reason;
        }

        public final Incomplete copy(OfflineVideoEntity offlineVideoEntity, Reason reason) {
            Intrinsics.checkNotNullParameter(offlineVideoEntity, "entity");
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Incomplete(offlineVideoEntity, reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Incomplete) {
                Incomplete incomplete = (Incomplete) obj;
                return Intrinsics.areEqual(this.entity, incomplete.entity) && Intrinsics.areEqual(this.reason, incomplete.reason);
            }
            return false;
        }

        public int hashCode() {
            return (this.entity.hashCode() * 31) + this.reason.hashCode();
        }

        public String toString() {
            OfflineVideoEntity offlineVideoEntity = this.entity;
            return "Incomplete(entity=" + offlineVideoEntity + ", reason=" + this.reason + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Incomplete(OfflineVideoEntity entity, Reason reason) {
            super(entity, null);
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.entity = entity;
            this.reason = reason;
        }

        @Override // video.biz.offline.list.logic.statemachine.DiagnosticState
        public OfflineVideoEntity getEntity() {
            return this.entity;
        }

        public final Reason getReason() {
            return this.reason;
        }

        /* compiled from: OfflineDiagnosePageStore.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason;", "", "<init>", "()V", "Paused", "WithRetryableError", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason$Paused;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason$WithRetryableError;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static abstract class Reason {
            public static final int $stable = 0;

            public /* synthetic */ Reason(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* compiled from: OfflineDiagnosePageStore.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason$Paused;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason;", "<init>", "()V", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class Paused extends Reason {
                public static final int $stable = 0;
                public static final Paused INSTANCE = new Paused();

                private Paused() {
                    super(null);
                }
            }

            private Reason() {
            }

            /* compiled from: OfflineDiagnosePageStore.kt */
            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason$WithRetryableError;", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason;", "errorType", "Lvideo/biz/offline/base/model/error/DownloadErrorType;", "<init>", "(Lvideo/biz/offline/base/model/error/DownloadErrorType;)V", "getErrorType", "()Lvideo/biz/offline/base/model/error/DownloadErrorType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class WithRetryableError extends Reason {
                public static final int $stable = 0;
                private final DownloadErrorType errorType;

                public static /* synthetic */ WithRetryableError copy$default(WithRetryableError withRetryableError, DownloadErrorType downloadErrorType, int i, Object obj) {
                    if ((i & 1) != 0) {
                        downloadErrorType = withRetryableError.errorType;
                    }
                    return withRetryableError.copy(downloadErrorType);
                }

                public final DownloadErrorType component1() {
                    return this.errorType;
                }

                public final WithRetryableError copy(DownloadErrorType downloadErrorType) {
                    Intrinsics.checkNotNullParameter(downloadErrorType, "errorType");
                    return new WithRetryableError(downloadErrorType);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof WithRetryableError) && this.errorType == ((WithRetryableError) obj).errorType;
                }

                public int hashCode() {
                    return this.errorType.hashCode();
                }

                public String toString() {
                    return "WithRetryableError(errorType=" + this.errorType + ")";
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public WithRetryableError(DownloadErrorType errorType) {
                    super(null);
                    Intrinsics.checkNotNullParameter(errorType, "errorType");
                    this.errorType = errorType;
                }

                public final DownloadErrorType getErrorType() {
                    return this.errorType;
                }
            }
        }
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0087@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Companion;", "", "<init>", "()V", "from", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState;", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object from(OfflineVideoEntity entity, Continuation<? super DiagnosticState> continuation) {
            DiagnosticState$Companion$from$1 diagnosticState$Companion$from$1;
            Object validateLocalResource;
            Object isNotInDB;
            ResourceValidateCode validationCode;
            if (continuation instanceof DiagnosticState$Companion$from$1) {
                diagnosticState$Companion$from$1 = (DiagnosticState$Companion$from$1) continuation;
                if ((diagnosticState$Companion$from$1.label & Integer.MIN_VALUE) != 0) {
                    diagnosticState$Companion$from$1.label -= Integer.MIN_VALUE;
                    Object $result = diagnosticState$Companion$from$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (diagnosticState$Companion$from$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            diagnosticState$Companion$from$1.L$0 = entity;
                            diagnosticState$Companion$from$1.label = 1;
                            validateLocalResource = ResourceValidateImpl_androidKt.validateLocalResource(entity, diagnosticState$Companion$from$1);
                            if (validateLocalResource == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ResourceValidateCode validationCode2 = (ResourceValidateCode) validateLocalResource;
                            if (!entity.getDownloaded() && validationCode2 != ResourceValidateCode.SUCCESS) {
                                return new Damaged(entity, new Damaged.Reason.DownloadedButInvalid(validationCode2));
                            }
                            if (!entity.getDownloaded() && validationCode2 == ResourceValidateCode.SUCCESS) {
                                return new Completed(entity);
                            }
                            if (!entity.getDownloaded()) {
                                diagnosticState$Companion$from$1.L$0 = entity;
                                diagnosticState$Companion$from$1.L$1 = validationCode2;
                                diagnosticState$Companion$from$1.label = 2;
                                isNotInDB = OfflineResolveDataProviderKt.isNotInDB(entity, diagnosticState$Companion$from$1);
                                if (isNotInDB == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                validationCode = validationCode2;
                                if (!((Boolean) isNotInDB).booleanValue() || validationCode == ResourceValidateCode.ERROR_STORAGE_DIR_NOT_FOUND || validationCode == ResourceValidateCode.ERROR_INVALID_ENTRY || validationCode == ResourceValidateCode.ERROR_INVALID_INDEX) {
                                    return new Damaged(entity, new Damaged.Reason.DownloadingButInvalid(validationCode));
                                }
                            }
                            if (entity.getDownloaded() && UtilsKt.hasDownloadingError(entity)) {
                                DownloadErrorType errorType = DownloadErrorType.Companion.from(OfflineError.INSTANCE.getErrorNumber(entity.getErrorCode()));
                                if (UtilsKt.canRetry(errorType)) {
                                    return new Incomplete(entity, new Incomplete.Reason.WithRetryableError(errorType));
                                }
                                return new Damaged(entity, new Damaged.Reason.WithUnretryableDownloadingError(errorType));
                            }
                            return new Incomplete(entity, Incomplete.Reason.Paused.INSTANCE);
                        case 1:
                            entity = (OfflineVideoEntity) diagnosticState$Companion$from$1.L$0;
                            ResultKt.throwOnFailure($result);
                            validateLocalResource = $result;
                            ResourceValidateCode validationCode22 = (ResourceValidateCode) validateLocalResource;
                            if (!entity.getDownloaded()) {
                                break;
                            }
                            if (!entity.getDownloaded()) {
                                break;
                            }
                            if (!entity.getDownloaded()) {
                            }
                            if (entity.getDownloaded()) {
                                break;
                            }
                            return new Incomplete(entity, Incomplete.Reason.Paused.INSTANCE);
                        case 2:
                            validationCode = (ResourceValidateCode) diagnosticState$Companion$from$1.L$1;
                            entity = (OfflineVideoEntity) diagnosticState$Companion$from$1.L$0;
                            ResultKt.throwOnFailure($result);
                            isNotInDB = $result;
                            if (!((Boolean) isNotInDB).booleanValue()) {
                                break;
                            }
                            return new Damaged(entity, new Damaged.Reason.DownloadingButInvalid(validationCode));
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            diagnosticState$Companion$from$1 = new DiagnosticState$Companion$from$1(this, continuation);
            Object $result2 = diagnosticState$Companion$from$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (diagnosticState$Companion$from$1.label) {
            }
        }
    }
}