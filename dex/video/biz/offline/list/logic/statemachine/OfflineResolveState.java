package video.biz.offline.list.logic.statemachine;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflineResloveStateMachine.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "", "Idle", "Loading", "OfflineResolvePageUiState", "Error", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$Error;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$Idle;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$Loading;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$OfflineResolvePageUiState;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OfflineResolveState {

    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$Idle;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Idle implements OfflineResolveState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Idle) {
                Idle idle = (Idle) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -413315861;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
        }
    }

    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$Loading;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Loading implements OfflineResolveState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loading) {
                Loading loading = (Loading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -749197115;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006#"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$OfflineResolvePageUiState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "aid", "", "cid", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "uploading", "", "buttonVisible", "buttonEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;ZZZ)V", "getAid", "()Ljava/lang/String;", "getCid", "getEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "getUploading", "()Z", "getButtonVisible", "getButtonEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class OfflineResolvePageUiState implements OfflineResolveState {
        public static final int $stable = OfflineVideoEntity.$stable;
        private final String aid;
        private final boolean buttonEnabled;
        private final boolean buttonVisible;
        private final String cid;
        private final OfflineVideoEntity entity;
        private final boolean uploading;

        public OfflineResolvePageUiState() {
            this(null, null, null, false, false, false, 63, null);
        }

        public static /* synthetic */ OfflineResolvePageUiState copy$default(OfflineResolvePageUiState offlineResolvePageUiState, String str, String str2, OfflineVideoEntity offlineVideoEntity, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = offlineResolvePageUiState.aid;
            }
            if ((i & 2) != 0) {
                str2 = offlineResolvePageUiState.cid;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                offlineVideoEntity = offlineResolvePageUiState.entity;
            }
            OfflineVideoEntity offlineVideoEntity2 = offlineVideoEntity;
            if ((i & 8) != 0) {
                z = offlineResolvePageUiState.uploading;
            }
            boolean z4 = z;
            if ((i & 16) != 0) {
                z2 = offlineResolvePageUiState.buttonVisible;
            }
            boolean z5 = z2;
            if ((i & 32) != 0) {
                z3 = offlineResolvePageUiState.buttonEnabled;
            }
            return offlineResolvePageUiState.copy(str, str3, offlineVideoEntity2, z4, z5, z3);
        }

        public final String component1() {
            return this.aid;
        }

        public final String component2() {
            return this.cid;
        }

        public final OfflineVideoEntity component3() {
            return this.entity;
        }

        public final boolean component4() {
            return this.uploading;
        }

        public final boolean component5() {
            return this.buttonVisible;
        }

        public final boolean component6() {
            return this.buttonEnabled;
        }

        public final OfflineResolvePageUiState copy(String str, String str2, OfflineVideoEntity offlineVideoEntity, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(str, "aid");
            Intrinsics.checkNotNullParameter(str2, "cid");
            return new OfflineResolvePageUiState(str, str2, offlineVideoEntity, z, z2, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OfflineResolvePageUiState) {
                OfflineResolvePageUiState offlineResolvePageUiState = (OfflineResolvePageUiState) obj;
                return Intrinsics.areEqual(this.aid, offlineResolvePageUiState.aid) && Intrinsics.areEqual(this.cid, offlineResolvePageUiState.cid) && Intrinsics.areEqual(this.entity, offlineResolvePageUiState.entity) && this.uploading == offlineResolvePageUiState.uploading && this.buttonVisible == offlineResolvePageUiState.buttonVisible && this.buttonEnabled == offlineResolvePageUiState.buttonEnabled;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.aid.hashCode() * 31) + this.cid.hashCode()) * 31) + (this.entity == null ? 0 : this.entity.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.uploading)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.buttonVisible)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.buttonEnabled);
        }

        public String toString() {
            String str = this.aid;
            String str2 = this.cid;
            OfflineVideoEntity offlineVideoEntity = this.entity;
            boolean z = this.uploading;
            boolean z2 = this.buttonVisible;
            return "OfflineResolvePageUiState(aid=" + str + ", cid=" + str2 + ", entity=" + offlineVideoEntity + ", uploading=" + z + ", buttonVisible=" + z2 + ", buttonEnabled=" + this.buttonEnabled + ")";
        }

        public OfflineResolvePageUiState(String aid, String cid, OfflineVideoEntity entity, boolean uploading, boolean buttonVisible, boolean buttonEnabled) {
            Intrinsics.checkNotNullParameter(aid, "aid");
            Intrinsics.checkNotNullParameter(cid, "cid");
            this.aid = aid;
            this.cid = cid;
            this.entity = entity;
            this.uploading = uploading;
            this.buttonVisible = buttonVisible;
            this.buttonEnabled = buttonEnabled;
        }

        public /* synthetic */ OfflineResolvePageUiState(String str, String str2, OfflineVideoEntity offlineVideoEntity, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) == 0 ? str2 : "", (i & 4) != 0 ? null : offlineVideoEntity, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? true : z3);
        }

        public final String getAid() {
            return this.aid;
        }

        public final String getCid() {
            return this.cid;
        }

        public final OfflineVideoEntity getEntity() {
            return this.entity;
        }

        public final boolean getUploading() {
            return this.uploading;
        }

        public final boolean getButtonVisible() {
            return this.buttonVisible;
        }

        public final boolean getButtonEnabled() {
            return this.buttonEnabled;
        }
    }

    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$Error;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "error", "", "<init>", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Error implements OfflineResolveState {
        public static final int $stable = 0;
        private final String error;

        public Error() {
            this(null, 1, null);
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.error;
            }
            return error.copy(str);
        }

        public final String component1() {
            return this.error;
        }

        public final Error copy(String str) {
            return new Error(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error);
        }

        public int hashCode() {
            if (this.error == null) {
                return 0;
            }
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ")";
        }

        public Error(String error) {
            this.error = error;
        }

        public /* synthetic */ Error(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getError() {
            return this.error;
        }
    }
}