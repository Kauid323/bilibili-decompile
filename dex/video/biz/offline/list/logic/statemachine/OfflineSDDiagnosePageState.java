package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.StorageInfoImpl_androidKt;
import video.biz.offline.base.model.model.StorageInfoModel;

/* compiled from: OfflineSDDiagnosePageStore.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageState;", "", "basicInfo", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "procedure", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnoseProcedure;", "result", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnoseResult;", "<init>", "(Lvideo/biz/offline/base/model/model/StorageInfoModel;Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnoseProcedure;Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnoseResult;)V", "getBasicInfo", "()Lvideo/biz/offline/base/model/model/StorageInfoModel;", "getProcedure", "()Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnoseProcedure;", "getResult", "()Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnoseResult;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineSDDiagnosePageState {
    public static final int $stable = StorageInfoModel.$stable;
    private final StorageInfoModel basicInfo;
    private final OfflineSDDiagnoseProcedure procedure;
    private final OfflineSDDiagnoseResult result;

    public OfflineSDDiagnosePageState() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ OfflineSDDiagnosePageState copy$default(OfflineSDDiagnosePageState offlineSDDiagnosePageState, StorageInfoModel storageInfoModel, OfflineSDDiagnoseProcedure offlineSDDiagnoseProcedure, OfflineSDDiagnoseResult offlineSDDiagnoseResult, int i, Object obj) {
        if ((i & 1) != 0) {
            storageInfoModel = offlineSDDiagnosePageState.basicInfo;
        }
        if ((i & 2) != 0) {
            offlineSDDiagnoseProcedure = offlineSDDiagnosePageState.procedure;
        }
        if ((i & 4) != 0) {
            offlineSDDiagnoseResult = offlineSDDiagnosePageState.result;
        }
        return offlineSDDiagnosePageState.copy(storageInfoModel, offlineSDDiagnoseProcedure, offlineSDDiagnoseResult);
    }

    public final StorageInfoModel component1() {
        return this.basicInfo;
    }

    public final OfflineSDDiagnoseProcedure component2() {
        return this.procedure;
    }

    public final OfflineSDDiagnoseResult component3() {
        return this.result;
    }

    public final OfflineSDDiagnosePageState copy(StorageInfoModel storageInfoModel, OfflineSDDiagnoseProcedure offlineSDDiagnoseProcedure, OfflineSDDiagnoseResult offlineSDDiagnoseResult) {
        Intrinsics.checkNotNullParameter(offlineSDDiagnoseProcedure, "procedure");
        Intrinsics.checkNotNullParameter(offlineSDDiagnoseResult, "result");
        return new OfflineSDDiagnosePageState(storageInfoModel, offlineSDDiagnoseProcedure, offlineSDDiagnoseResult);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflineSDDiagnosePageState) {
            OfflineSDDiagnosePageState offlineSDDiagnosePageState = (OfflineSDDiagnosePageState) obj;
            return Intrinsics.areEqual(this.basicInfo, offlineSDDiagnosePageState.basicInfo) && this.procedure == offlineSDDiagnosePageState.procedure && this.result == offlineSDDiagnosePageState.result;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.basicInfo == null ? 0 : this.basicInfo.hashCode()) * 31) + this.procedure.hashCode()) * 31) + this.result.hashCode();
    }

    public String toString() {
        StorageInfoModel storageInfoModel = this.basicInfo;
        OfflineSDDiagnoseProcedure offlineSDDiagnoseProcedure = this.procedure;
        return "OfflineSDDiagnosePageState(basicInfo=" + storageInfoModel + ", procedure=" + offlineSDDiagnoseProcedure + ", result=" + this.result + ")";
    }

    public OfflineSDDiagnosePageState(StorageInfoModel basicInfo, OfflineSDDiagnoseProcedure procedure, OfflineSDDiagnoseResult result) {
        Intrinsics.checkNotNullParameter(procedure, "procedure");
        Intrinsics.checkNotNullParameter(result, "result");
        this.basicInfo = basicInfo;
        this.procedure = procedure;
        this.result = result;
    }

    public /* synthetic */ OfflineSDDiagnosePageState(StorageInfoModel storageInfoModel, OfflineSDDiagnoseProcedure offlineSDDiagnoseProcedure, OfflineSDDiagnoseResult offlineSDDiagnoseResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? (StorageInfoModel) CollectionsKt.getOrNull(StorageInfoImpl_androidKt.getStorageInfoList(false), 1) : storageInfoModel, (i & 2) != 0 ? OfflineSDDiagnoseProcedure.Info : offlineSDDiagnoseProcedure, (i & 4) != 0 ? OfflineSDDiagnoseResult.NONE : offlineSDDiagnoseResult);
    }

    public final StorageInfoModel getBasicInfo() {
        return this.basicInfo;
    }

    public final OfflineSDDiagnoseProcedure getProcedure() {
        return this.procedure;
    }

    public final OfflineSDDiagnoseResult getResult() {
        return this.result;
    }
}