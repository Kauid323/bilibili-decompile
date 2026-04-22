package kntr.app.tribee.steam.state;

import BottomSheetItemData$;
import com.bapis.bilibili.app.dynamic.v2.KThreeDot;
import com.bapis.bilibili.app.dynamic.v2.KTipsFootCard;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeBindAccountAbnormal;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeBindAccountNormal;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeData;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeNotBindResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeShareConfig;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeUserInfo;
import java.util.List;
import kntr.app.tribee.steam.state.TribeeSteamGameAchievementState;
import kntr.app.tribee.steam.state.TribeeSteamShareState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.qrcode.QrCodeProvider;
import kntr.common.screenshot.ScreenshotProvider;
import kntr.common.share.common.ui.ShareMenuVM;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamState.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017B1\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u0010\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000f\u0082\u0001\u0007\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamState;", "", "uiAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "requestingActions", "", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "isMaster", "", "<init>", "(Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;Ljava/util/List;Z)V", "getUiAction", "()Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "getRequestingActions", "()Ljava/util/List;", "()Z", "copyBy", "InitialState", "InitialErrorState", "UnbindSteamState", "HasBoundAndSyncingState", "HasBoundButPrivacyState", "HasBoundButDataFetchFailedState", "SteamInfoState", "Lkntr/app/tribee/steam/state/TribeeSteamState$HasBoundAndSyncingState;", "Lkntr/app/tribee/steam/state/TribeeSteamState$HasBoundButDataFetchFailedState;", "Lkntr/app/tribee/steam/state/TribeeSteamState$HasBoundButPrivacyState;", "Lkntr/app/tribee/steam/state/TribeeSteamState$InitialErrorState;", "Lkntr/app/tribee/steam/state/TribeeSteamState$InitialState;", "Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;", "Lkntr/app/tribee/steam/state/TribeeSteamState$UnbindSteamState;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class TribeeSteamState {
    public static final int $stable = 0;
    private final boolean isMaster;
    private final List<TribeeSteamStateAction> requestingActions;
    private final TribeeSteamUIAction uiAction;

    public /* synthetic */ TribeeSteamState(TribeeSteamUIAction tribeeSteamUIAction, List list, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(tribeeSteamUIAction, list, z);
    }

    public abstract TribeeSteamState copyBy(TribeeSteamUIAction tribeeSteamUIAction, List<? extends TribeeSteamStateAction> list);

    /* JADX WARN: Multi-variable type inference failed */
    private TribeeSteamState(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list, boolean isMaster) {
        this.uiAction = uiAction;
        this.requestingActions = list;
        this.isMaster = isMaster;
    }

    public /* synthetic */ TribeeSteamState(TribeeSteamUIAction tribeeSteamUIAction, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tribeeSteamUIAction, (i & 2) != 0 ? null : list, (i & 4) != 0 ? true : z, null);
    }

    public TribeeSteamUIAction getUiAction() {
        return this.uiAction;
    }

    public List<TribeeSteamStateAction> getRequestingActions() {
        return this.requestingActions;
    }

    public boolean isMaster() {
        return this.isMaster;
    }

    /* compiled from: TribeeSteamState.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\r\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamState$InitialState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "uiAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "requestingActions", "", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "<init>", "(Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;Ljava/util/List;)V", "getUiAction", "()Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "getRequestingActions", "()Ljava/util/List;", "copyBy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class InitialState extends TribeeSteamState {
        public static final int $stable = 0;
        private final List<TribeeSteamStateAction> requestingActions;
        private final TribeeSteamUIAction uiAction;

        public InitialState() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InitialState copy$default(InitialState initialState, TribeeSteamUIAction tribeeSteamUIAction, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeSteamUIAction = initialState.uiAction;
            }
            if ((i & 2) != 0) {
                list = initialState.requestingActions;
            }
            return initialState.copy(tribeeSteamUIAction, list);
        }

        public final TribeeSteamUIAction component1() {
            return this.uiAction;
        }

        public final List<TribeeSteamStateAction> component2() {
            return this.requestingActions;
        }

        public final InitialState copy(TribeeSteamUIAction tribeeSteamUIAction, List<? extends TribeeSteamStateAction> list) {
            return new InitialState(tribeeSteamUIAction, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InitialState) {
                InitialState initialState = (InitialState) obj;
                return Intrinsics.areEqual(this.uiAction, initialState.uiAction) && Intrinsics.areEqual(this.requestingActions, initialState.requestingActions);
            }
            return false;
        }

        public int hashCode() {
            return ((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + (this.requestingActions != null ? this.requestingActions.hashCode() : 0);
        }

        public String toString() {
            TribeeSteamUIAction tribeeSteamUIAction = this.uiAction;
            return "InitialState(uiAction=" + tribeeSteamUIAction + ", requestingActions=" + this.requestingActions + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public InitialState(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list) {
            super(null, null, false, 7, null);
            this.uiAction = uiAction;
            this.requestingActions = list;
        }

        public /* synthetic */ InitialState(TribeeSteamUIAction tribeeSteamUIAction, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : tribeeSteamUIAction, (i & 2) != 0 ? null : list);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamUIAction getUiAction() {
            return this.uiAction;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public List<TribeeSteamStateAction> getRequestingActions() {
            return this.requestingActions;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamState copyBy(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list) {
            return copy(uiAction, list);
        }
    }

    /* compiled from: TribeeSteamState.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\r\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamState$InitialErrorState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "uiAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "requestingActions", "", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "<init>", "(Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;Ljava/util/List;)V", "getUiAction", "()Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "getRequestingActions", "()Ljava/util/List;", "copyBy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class InitialErrorState extends TribeeSteamState {
        public static final int $stable = 0;
        private final List<TribeeSteamStateAction> requestingActions;
        private final TribeeSteamUIAction uiAction;

        public InitialErrorState() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InitialErrorState copy$default(InitialErrorState initialErrorState, TribeeSteamUIAction tribeeSteamUIAction, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeSteamUIAction = initialErrorState.uiAction;
            }
            if ((i & 2) != 0) {
                list = initialErrorState.requestingActions;
            }
            return initialErrorState.copy(tribeeSteamUIAction, list);
        }

        public final TribeeSteamUIAction component1() {
            return this.uiAction;
        }

        public final List<TribeeSteamStateAction> component2() {
            return this.requestingActions;
        }

        public final InitialErrorState copy(TribeeSteamUIAction tribeeSteamUIAction, List<? extends TribeeSteamStateAction> list) {
            return new InitialErrorState(tribeeSteamUIAction, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InitialErrorState) {
                InitialErrorState initialErrorState = (InitialErrorState) obj;
                return Intrinsics.areEqual(this.uiAction, initialErrorState.uiAction) && Intrinsics.areEqual(this.requestingActions, initialErrorState.requestingActions);
            }
            return false;
        }

        public int hashCode() {
            return ((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + (this.requestingActions != null ? this.requestingActions.hashCode() : 0);
        }

        public String toString() {
            TribeeSteamUIAction tribeeSteamUIAction = this.uiAction;
            return "InitialErrorState(uiAction=" + tribeeSteamUIAction + ", requestingActions=" + this.requestingActions + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public InitialErrorState(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list) {
            super(null, null, false, 7, null);
            this.uiAction = uiAction;
            this.requestingActions = list;
        }

        public /* synthetic */ InitialErrorState(TribeeSteamUIAction tribeeSteamUIAction, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : tribeeSteamUIAction, (i & 2) != 0 ? null : list);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamUIAction getUiAction() {
            return this.uiAction;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public List<TribeeSteamStateAction> getRequestingActions() {
            return this.requestingActions;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamState copyBy(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list) {
            return copy(uiAction, list);
        }
    }

    /* compiled from: TribeeSteamState.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0018\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017¨\u0006&"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamState$UnbindSteamState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "uiAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "requestingActions", "", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "unbindResp", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeNotBindResp;", "tipsFootCard", "Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;", "isMaster", "", "<init>", "(Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;Ljava/util/List;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeNotBindResp;Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;Z)V", "getUiAction", "()Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "getRequestingActions", "()Ljava/util/List;", "getUnbindResp", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeNotBindResp;", "getTipsFootCard", "()Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;", "()Z", "copyBy", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UnbindSteamState extends TribeeSteamState {
        public static final int $stable = 0;
        private final boolean isMaster;
        private final List<TribeeSteamStateAction> requestingActions;
        private final KTipsFootCard tipsFootCard;
        private final TribeeSteamUIAction uiAction;
        private final KTribeeSteamHomeNotBindResp unbindResp;

        public static /* synthetic */ UnbindSteamState copy$default(UnbindSteamState unbindSteamState, TribeeSteamUIAction tribeeSteamUIAction, List list, KTribeeSteamHomeNotBindResp kTribeeSteamHomeNotBindResp, KTipsFootCard kTipsFootCard, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeSteamUIAction = unbindSteamState.uiAction;
            }
            List<TribeeSteamStateAction> list2 = list;
            if ((i & 2) != 0) {
                list2 = unbindSteamState.requestingActions;
            }
            List list3 = list2;
            if ((i & 4) != 0) {
                kTribeeSteamHomeNotBindResp = unbindSteamState.unbindResp;
            }
            KTribeeSteamHomeNotBindResp kTribeeSteamHomeNotBindResp2 = kTribeeSteamHomeNotBindResp;
            if ((i & 8) != 0) {
                kTipsFootCard = unbindSteamState.tipsFootCard;
            }
            KTipsFootCard kTipsFootCard2 = kTipsFootCard;
            if ((i & 16) != 0) {
                z = unbindSteamState.isMaster;
            }
            return unbindSteamState.copy(tribeeSteamUIAction, list3, kTribeeSteamHomeNotBindResp2, kTipsFootCard2, z);
        }

        public final TribeeSteamUIAction component1() {
            return this.uiAction;
        }

        public final List<TribeeSteamStateAction> component2() {
            return this.requestingActions;
        }

        public final KTribeeSteamHomeNotBindResp component3() {
            return this.unbindResp;
        }

        public final KTipsFootCard component4() {
            return this.tipsFootCard;
        }

        public final boolean component5() {
            return this.isMaster;
        }

        public final UnbindSteamState copy(TribeeSteamUIAction tribeeSteamUIAction, List<? extends TribeeSteamStateAction> list, KTribeeSteamHomeNotBindResp kTribeeSteamHomeNotBindResp, KTipsFootCard kTipsFootCard, boolean z) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeNotBindResp, "unbindResp");
            return new UnbindSteamState(tribeeSteamUIAction, list, kTribeeSteamHomeNotBindResp, kTipsFootCard, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UnbindSteamState) {
                UnbindSteamState unbindSteamState = (UnbindSteamState) obj;
                return Intrinsics.areEqual(this.uiAction, unbindSteamState.uiAction) && Intrinsics.areEqual(this.requestingActions, unbindSteamState.requestingActions) && Intrinsics.areEqual(this.unbindResp, unbindSteamState.unbindResp) && Intrinsics.areEqual(this.tipsFootCard, unbindSteamState.tipsFootCard) && this.isMaster == unbindSteamState.isMaster;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + (this.requestingActions == null ? 0 : this.requestingActions.hashCode())) * 31) + this.unbindResp.hashCode()) * 31) + (this.tipsFootCard != null ? this.tipsFootCard.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMaster);
        }

        public String toString() {
            TribeeSteamUIAction tribeeSteamUIAction = this.uiAction;
            List<TribeeSteamStateAction> list = this.requestingActions;
            KTribeeSteamHomeNotBindResp kTribeeSteamHomeNotBindResp = this.unbindResp;
            KTipsFootCard kTipsFootCard = this.tipsFootCard;
            return "UnbindSteamState(uiAction=" + tribeeSteamUIAction + ", requestingActions=" + list + ", unbindResp=" + kTribeeSteamHomeNotBindResp + ", tipsFootCard=" + kTipsFootCard + ", isMaster=" + this.isMaster + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public UnbindSteamState(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list, KTribeeSteamHomeNotBindResp unbindResp, KTipsFootCard tipsFootCard, boolean isMaster) {
            super(null, null, false, 7, null);
            Intrinsics.checkNotNullParameter(unbindResp, "unbindResp");
            this.uiAction = uiAction;
            this.requestingActions = list;
            this.unbindResp = unbindResp;
            this.tipsFootCard = tipsFootCard;
            this.isMaster = isMaster;
        }

        public /* synthetic */ UnbindSteamState(TribeeSteamUIAction tribeeSteamUIAction, List list, KTribeeSteamHomeNotBindResp kTribeeSteamHomeNotBindResp, KTipsFootCard kTipsFootCard, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : tribeeSteamUIAction, (i & 2) != 0 ? null : list, kTribeeSteamHomeNotBindResp, (i & 8) != 0 ? null : kTipsFootCard, (i & 16) != 0 ? true : z);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamUIAction getUiAction() {
            return this.uiAction;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public List<TribeeSteamStateAction> getRequestingActions() {
            return this.requestingActions;
        }

        public final KTribeeSteamHomeNotBindResp getUnbindResp() {
            return this.unbindResp;
        }

        public final KTipsFootCard getTipsFootCard() {
            return this.tipsFootCard;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public boolean isMaster() {
            return this.isMaster;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamState copyBy(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list) {
            return copy$default(this, uiAction, list, null, null, false, 28, null);
        }
    }

    /* compiled from: TribeeSteamState.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0014\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013¨\u0006!"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamState$HasBoundAndSyncingState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "uiAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "requestingActions", "", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "data", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountNormal;", "isMaster", "", "<init>", "(Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;Ljava/util/List;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountNormal;Z)V", "getUiAction", "()Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "getRequestingActions", "()Ljava/util/List;", "getData", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountNormal;", "()Z", "copyBy", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class HasBoundAndSyncingState extends TribeeSteamState {
        public static final int $stable = 0;
        private final KTribeeSteamHomeBindAccountNormal data;
        private final boolean isMaster;
        private final List<TribeeSteamStateAction> requestingActions;
        private final TribeeSteamUIAction uiAction;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HasBoundAndSyncingState copy$default(HasBoundAndSyncingState hasBoundAndSyncingState, TribeeSteamUIAction tribeeSteamUIAction, List list, KTribeeSteamHomeBindAccountNormal kTribeeSteamHomeBindAccountNormal, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeSteamUIAction = hasBoundAndSyncingState.uiAction;
            }
            if ((i & 2) != 0) {
                list = hasBoundAndSyncingState.requestingActions;
            }
            if ((i & 4) != 0) {
                kTribeeSteamHomeBindAccountNormal = hasBoundAndSyncingState.data;
            }
            if ((i & 8) != 0) {
                z = hasBoundAndSyncingState.isMaster;
            }
            return hasBoundAndSyncingState.copy(tribeeSteamUIAction, list, kTribeeSteamHomeBindAccountNormal, z);
        }

        public final TribeeSteamUIAction component1() {
            return this.uiAction;
        }

        public final List<TribeeSteamStateAction> component2() {
            return this.requestingActions;
        }

        public final KTribeeSteamHomeBindAccountNormal component3() {
            return this.data;
        }

        public final boolean component4() {
            return this.isMaster;
        }

        public final HasBoundAndSyncingState copy(TribeeSteamUIAction tribeeSteamUIAction, List<? extends TribeeSteamStateAction> list, KTribeeSteamHomeBindAccountNormal kTribeeSteamHomeBindAccountNormal, boolean z) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeBindAccountNormal, "data");
            return new HasBoundAndSyncingState(tribeeSteamUIAction, list, kTribeeSteamHomeBindAccountNormal, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HasBoundAndSyncingState) {
                HasBoundAndSyncingState hasBoundAndSyncingState = (HasBoundAndSyncingState) obj;
                return Intrinsics.areEqual(this.uiAction, hasBoundAndSyncingState.uiAction) && Intrinsics.areEqual(this.requestingActions, hasBoundAndSyncingState.requestingActions) && Intrinsics.areEqual(this.data, hasBoundAndSyncingState.data) && this.isMaster == hasBoundAndSyncingState.isMaster;
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + (this.requestingActions != null ? this.requestingActions.hashCode() : 0)) * 31) + this.data.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMaster);
        }

        public String toString() {
            TribeeSteamUIAction tribeeSteamUIAction = this.uiAction;
            List<TribeeSteamStateAction> list = this.requestingActions;
            KTribeeSteamHomeBindAccountNormal kTribeeSteamHomeBindAccountNormal = this.data;
            return "HasBoundAndSyncingState(uiAction=" + tribeeSteamUIAction + ", requestingActions=" + list + ", data=" + kTribeeSteamHomeBindAccountNormal + ", isMaster=" + this.isMaster + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public HasBoundAndSyncingState(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list, KTribeeSteamHomeBindAccountNormal data, boolean isMaster) {
            super(null, null, false, 7, null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.uiAction = uiAction;
            this.requestingActions = list;
            this.data = data;
            this.isMaster = isMaster;
        }

        public /* synthetic */ HasBoundAndSyncingState(TribeeSteamUIAction tribeeSteamUIAction, List list, KTribeeSteamHomeBindAccountNormal kTribeeSteamHomeBindAccountNormal, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : tribeeSteamUIAction, (i & 2) != 0 ? null : list, kTribeeSteamHomeBindAccountNormal, (i & 8) != 0 ? true : z);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamUIAction getUiAction() {
            return this.uiAction;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public List<TribeeSteamStateAction> getRequestingActions() {
            return this.requestingActions;
        }

        public final KTribeeSteamHomeBindAccountNormal getData() {
            return this.data;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public boolean isMaster() {
            return this.isMaster;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamState copyBy(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list) {
            return copy$default(this, uiAction, list, null, false, 12, null);
        }
    }

    /* compiled from: TribeeSteamState.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0018\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017¨\u0006&"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamState$HasBoundButPrivacyState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "uiAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "requestingActions", "", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "data", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountAbnormal;", "tipsFootCard", "Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;", "isMaster", "", "<init>", "(Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;Ljava/util/List;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountAbnormal;Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;Z)V", "getUiAction", "()Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "getRequestingActions", "()Ljava/util/List;", "getData", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountAbnormal;", "getTipsFootCard", "()Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;", "()Z", "copyBy", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class HasBoundButPrivacyState extends TribeeSteamState {
        public static final int $stable = 0;
        private final KTribeeSteamHomeBindAccountAbnormal data;
        private final boolean isMaster;
        private final List<TribeeSteamStateAction> requestingActions;
        private final KTipsFootCard tipsFootCard;
        private final TribeeSteamUIAction uiAction;

        public static /* synthetic */ HasBoundButPrivacyState copy$default(HasBoundButPrivacyState hasBoundButPrivacyState, TribeeSteamUIAction tribeeSteamUIAction, List list, KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal, KTipsFootCard kTipsFootCard, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeSteamUIAction = hasBoundButPrivacyState.uiAction;
            }
            List<TribeeSteamStateAction> list2 = list;
            if ((i & 2) != 0) {
                list2 = hasBoundButPrivacyState.requestingActions;
            }
            List list3 = list2;
            if ((i & 4) != 0) {
                kTribeeSteamHomeBindAccountAbnormal = hasBoundButPrivacyState.data;
            }
            KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal2 = kTribeeSteamHomeBindAccountAbnormal;
            if ((i & 8) != 0) {
                kTipsFootCard = hasBoundButPrivacyState.tipsFootCard;
            }
            KTipsFootCard kTipsFootCard2 = kTipsFootCard;
            if ((i & 16) != 0) {
                z = hasBoundButPrivacyState.isMaster;
            }
            return hasBoundButPrivacyState.copy(tribeeSteamUIAction, list3, kTribeeSteamHomeBindAccountAbnormal2, kTipsFootCard2, z);
        }

        public final TribeeSteamUIAction component1() {
            return this.uiAction;
        }

        public final List<TribeeSteamStateAction> component2() {
            return this.requestingActions;
        }

        public final KTribeeSteamHomeBindAccountAbnormal component3() {
            return this.data;
        }

        public final KTipsFootCard component4() {
            return this.tipsFootCard;
        }

        public final boolean component5() {
            return this.isMaster;
        }

        public final HasBoundButPrivacyState copy(TribeeSteamUIAction tribeeSteamUIAction, List<? extends TribeeSteamStateAction> list, KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal, KTipsFootCard kTipsFootCard, boolean z) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeBindAccountAbnormal, "data");
            return new HasBoundButPrivacyState(tribeeSteamUIAction, list, kTribeeSteamHomeBindAccountAbnormal, kTipsFootCard, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HasBoundButPrivacyState) {
                HasBoundButPrivacyState hasBoundButPrivacyState = (HasBoundButPrivacyState) obj;
                return Intrinsics.areEqual(this.uiAction, hasBoundButPrivacyState.uiAction) && Intrinsics.areEqual(this.requestingActions, hasBoundButPrivacyState.requestingActions) && Intrinsics.areEqual(this.data, hasBoundButPrivacyState.data) && Intrinsics.areEqual(this.tipsFootCard, hasBoundButPrivacyState.tipsFootCard) && this.isMaster == hasBoundButPrivacyState.isMaster;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + (this.requestingActions == null ? 0 : this.requestingActions.hashCode())) * 31) + this.data.hashCode()) * 31) + (this.tipsFootCard != null ? this.tipsFootCard.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMaster);
        }

        public String toString() {
            TribeeSteamUIAction tribeeSteamUIAction = this.uiAction;
            List<TribeeSteamStateAction> list = this.requestingActions;
            KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal = this.data;
            KTipsFootCard kTipsFootCard = this.tipsFootCard;
            return "HasBoundButPrivacyState(uiAction=" + tribeeSteamUIAction + ", requestingActions=" + list + ", data=" + kTribeeSteamHomeBindAccountAbnormal + ", tipsFootCard=" + kTipsFootCard + ", isMaster=" + this.isMaster + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public HasBoundButPrivacyState(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list, KTribeeSteamHomeBindAccountAbnormal data, KTipsFootCard tipsFootCard, boolean isMaster) {
            super(null, null, false, 7, null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.uiAction = uiAction;
            this.requestingActions = list;
            this.data = data;
            this.tipsFootCard = tipsFootCard;
            this.isMaster = isMaster;
        }

        public /* synthetic */ HasBoundButPrivacyState(TribeeSteamUIAction tribeeSteamUIAction, List list, KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal, KTipsFootCard kTipsFootCard, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : tribeeSteamUIAction, (i & 2) != 0 ? null : list, kTribeeSteamHomeBindAccountAbnormal, (i & 8) != 0 ? null : kTipsFootCard, (i & 16) != 0 ? true : z);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamUIAction getUiAction() {
            return this.uiAction;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public List<TribeeSteamStateAction> getRequestingActions() {
            return this.requestingActions;
        }

        public final KTribeeSteamHomeBindAccountAbnormal getData() {
            return this.data;
        }

        public final KTipsFootCard getTipsFootCard() {
            return this.tipsFootCard;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public boolean isMaster() {
            return this.isMaster;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamState copyBy(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list) {
            return copy$default(this, uiAction, list, null, null, false, 28, null);
        }
    }

    /* compiled from: TribeeSteamState.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0014\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamState$HasBoundButDataFetchFailedState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "uiAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "requestingActions", "", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "isMaster", "", "data", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountAbnormal;", "<init>", "(Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;Ljava/util/List;ZLcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountAbnormal;)V", "getUiAction", "()Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "getRequestingActions", "()Ljava/util/List;", "()Z", "getData", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountAbnormal;", "copyBy", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class HasBoundButDataFetchFailedState extends TribeeSteamState {
        public static final int $stable = 0;
        private final KTribeeSteamHomeBindAccountAbnormal data;
        private final boolean isMaster;
        private final List<TribeeSteamStateAction> requestingActions;
        private final TribeeSteamUIAction uiAction;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HasBoundButDataFetchFailedState copy$default(HasBoundButDataFetchFailedState hasBoundButDataFetchFailedState, TribeeSteamUIAction tribeeSteamUIAction, List list, boolean z, KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeSteamUIAction = hasBoundButDataFetchFailedState.uiAction;
            }
            if ((i & 2) != 0) {
                list = hasBoundButDataFetchFailedState.requestingActions;
            }
            if ((i & 4) != 0) {
                z = hasBoundButDataFetchFailedState.isMaster;
            }
            if ((i & 8) != 0) {
                kTribeeSteamHomeBindAccountAbnormal = hasBoundButDataFetchFailedState.data;
            }
            return hasBoundButDataFetchFailedState.copy(tribeeSteamUIAction, list, z, kTribeeSteamHomeBindAccountAbnormal);
        }

        public final TribeeSteamUIAction component1() {
            return this.uiAction;
        }

        public final List<TribeeSteamStateAction> component2() {
            return this.requestingActions;
        }

        public final boolean component3() {
            return this.isMaster;
        }

        public final KTribeeSteamHomeBindAccountAbnormal component4() {
            return this.data;
        }

        public final HasBoundButDataFetchFailedState copy(TribeeSteamUIAction tribeeSteamUIAction, List<? extends TribeeSteamStateAction> list, boolean z, KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeBindAccountAbnormal, "data");
            return new HasBoundButDataFetchFailedState(tribeeSteamUIAction, list, z, kTribeeSteamHomeBindAccountAbnormal);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HasBoundButDataFetchFailedState) {
                HasBoundButDataFetchFailedState hasBoundButDataFetchFailedState = (HasBoundButDataFetchFailedState) obj;
                return Intrinsics.areEqual(this.uiAction, hasBoundButDataFetchFailedState.uiAction) && Intrinsics.areEqual(this.requestingActions, hasBoundButDataFetchFailedState.requestingActions) && this.isMaster == hasBoundButDataFetchFailedState.isMaster && Intrinsics.areEqual(this.data, hasBoundButDataFetchFailedState.data);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + (this.requestingActions != null ? this.requestingActions.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMaster)) * 31) + this.data.hashCode();
        }

        public String toString() {
            TribeeSteamUIAction tribeeSteamUIAction = this.uiAction;
            List<TribeeSteamStateAction> list = this.requestingActions;
            boolean z = this.isMaster;
            return "HasBoundButDataFetchFailedState(uiAction=" + tribeeSteamUIAction + ", requestingActions=" + list + ", isMaster=" + z + ", data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public HasBoundButDataFetchFailedState(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list, boolean isMaster, KTribeeSteamHomeBindAccountAbnormal data) {
            super(null, null, false, 7, null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.uiAction = uiAction;
            this.requestingActions = list;
            this.isMaster = isMaster;
            this.data = data;
        }

        public /* synthetic */ HasBoundButDataFetchFailedState(TribeeSteamUIAction tribeeSteamUIAction, List list, boolean z, KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : tribeeSteamUIAction, (i & 2) != 0 ? null : list, (i & 4) != 0 ? true : z, kTribeeSteamHomeBindAccountAbnormal);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamUIAction getUiAction() {
            return this.uiAction;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public List<TribeeSteamStateAction> getRequestingActions() {
            return this.requestingActions;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public boolean isMaster() {
            return this.isMaster;
        }

        public final KTribeeSteamHomeBindAccountAbnormal getData() {
            return this.data;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamState copyBy(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list) {
            return copy$default(this, uiAction, list, false, null, 12, null);
        }
    }

    /* compiled from: TribeeSteamState.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u00108\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010>\u001a\u00020\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u0010HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010C\u001a\u00020\u0018HÆ\u0003J\t\u0010D\u001a\u00020\u001aHÆ\u0003J\t\u0010E\u001a\u00020\u001cHÆ\u0003J¡\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cHÆ\u0001J\u0013\u0010G\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020KHÖ\u0001J\t\u0010L\u001a\u00020MHÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00103R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006N"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "uiAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "requestingActions", "", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "userInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;", "steamData", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeData;", "shareConfig", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeShareConfig;", "achievementState", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "shareState", "Lkntr/app/tribee/steam/state/TribeeSteamShareState;", "shareMenuVM", "Lkntr/common/share/common/ui/ShareMenuVM;", "tipsFootCard", "Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;", "threeDot", "Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;", "isMaster", "", "qrCodeProvider", "Lkntr/common/paragraph/qrcode/QrCodeProvider;", "screenshotProvider", "Lkntr/common/screenshot/ScreenshotProvider;", "<init>", "(Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;Ljava/util/List;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeData;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeShareConfig;Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;Lkntr/app/tribee/steam/state/TribeeSteamShareState;Lkntr/common/share/common/ui/ShareMenuVM;Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;ZLkntr/common/paragraph/qrcode/QrCodeProvider;Lkntr/common/screenshot/ScreenshotProvider;)V", "getUiAction", "()Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "getRequestingActions", "()Ljava/util/List;", "getUserInfo", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;", "getSteamData", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeData;", "getShareConfig", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeShareConfig;", "getAchievementState", "()Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "getShareState", "()Lkntr/app/tribee/steam/state/TribeeSteamShareState;", "getShareMenuVM", "()Lkntr/common/share/common/ui/ShareMenuVM;", "getTipsFootCard", "()Lcom/bapis/bilibili/app/dynamic/v2/KTipsFootCard;", "getThreeDot", "()Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;", "()Z", "getQrCodeProvider", "()Lkntr/common/paragraph/qrcode/QrCodeProvider;", "getScreenshotProvider", "()Lkntr/common/screenshot/ScreenshotProvider;", "copyBy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SteamInfoState extends TribeeSteamState {
        public static final int $stable = 0;
        private final TribeeSteamGameAchievementState achievementState;
        private final boolean isMaster;
        private final QrCodeProvider qrCodeProvider;
        private final List<TribeeSteamStateAction> requestingActions;
        private final ScreenshotProvider screenshotProvider;
        private final KTribeeSteamHomeShareConfig shareConfig;
        private final ShareMenuVM shareMenuVM;
        private final TribeeSteamShareState shareState;
        private final KTribeeSteamHomeData steamData;
        private final KThreeDot threeDot;
        private final KTipsFootCard tipsFootCard;
        private final TribeeSteamUIAction uiAction;
        private final KTribeeSteamHomeUserInfo userInfo;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SteamInfoState copy$default(SteamInfoState steamInfoState, TribeeSteamUIAction tribeeSteamUIAction, List list, KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo, KTribeeSteamHomeData kTribeeSteamHomeData, KTribeeSteamHomeShareConfig kTribeeSteamHomeShareConfig, TribeeSteamGameAchievementState tribeeSteamGameAchievementState, TribeeSteamShareState tribeeSteamShareState, ShareMenuVM shareMenuVM, KTipsFootCard kTipsFootCard, KThreeDot kThreeDot, boolean z, QrCodeProvider qrCodeProvider, ScreenshotProvider screenshotProvider, int i, Object obj) {
            return steamInfoState.copy((i & 1) != 0 ? steamInfoState.uiAction : tribeeSteamUIAction, (i & 2) != 0 ? steamInfoState.requestingActions : list, (i & 4) != 0 ? steamInfoState.userInfo : kTribeeSteamHomeUserInfo, (i & 8) != 0 ? steamInfoState.steamData : kTribeeSteamHomeData, (i & 16) != 0 ? steamInfoState.shareConfig : kTribeeSteamHomeShareConfig, (i & 32) != 0 ? steamInfoState.achievementState : tribeeSteamGameAchievementState, (i & 64) != 0 ? steamInfoState.shareState : tribeeSteamShareState, (i & 128) != 0 ? steamInfoState.shareMenuVM : shareMenuVM, (i & 256) != 0 ? steamInfoState.tipsFootCard : kTipsFootCard, (i & 512) != 0 ? steamInfoState.threeDot : kThreeDot, (i & 1024) != 0 ? steamInfoState.isMaster : z, (i & 2048) != 0 ? steamInfoState.qrCodeProvider : qrCodeProvider, (i & 4096) != 0 ? steamInfoState.screenshotProvider : screenshotProvider);
        }

        public final TribeeSteamUIAction component1() {
            return this.uiAction;
        }

        public final KThreeDot component10() {
            return this.threeDot;
        }

        public final boolean component11() {
            return this.isMaster;
        }

        public final QrCodeProvider component12() {
            return this.qrCodeProvider;
        }

        public final ScreenshotProvider component13() {
            return this.screenshotProvider;
        }

        public final List<TribeeSteamStateAction> component2() {
            return this.requestingActions;
        }

        public final KTribeeSteamHomeUserInfo component3() {
            return this.userInfo;
        }

        public final KTribeeSteamHomeData component4() {
            return this.steamData;
        }

        public final KTribeeSteamHomeShareConfig component5() {
            return this.shareConfig;
        }

        public final TribeeSteamGameAchievementState component6() {
            return this.achievementState;
        }

        public final TribeeSteamShareState component7() {
            return this.shareState;
        }

        public final ShareMenuVM component8() {
            return this.shareMenuVM;
        }

        public final KTipsFootCard component9() {
            return this.tipsFootCard;
        }

        public final SteamInfoState copy(TribeeSteamUIAction tribeeSteamUIAction, List<? extends TribeeSteamStateAction> list, KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo, KTribeeSteamHomeData kTribeeSteamHomeData, KTribeeSteamHomeShareConfig kTribeeSteamHomeShareConfig, TribeeSteamGameAchievementState tribeeSteamGameAchievementState, TribeeSteamShareState tribeeSteamShareState, ShareMenuVM shareMenuVM, KTipsFootCard kTipsFootCard, KThreeDot kThreeDot, boolean z, QrCodeProvider qrCodeProvider, ScreenshotProvider screenshotProvider) {
            Intrinsics.checkNotNullParameter(tribeeSteamGameAchievementState, "achievementState");
            Intrinsics.checkNotNullParameter(tribeeSteamShareState, "shareState");
            Intrinsics.checkNotNullParameter(qrCodeProvider, "qrCodeProvider");
            Intrinsics.checkNotNullParameter(screenshotProvider, "screenshotProvider");
            return new SteamInfoState(tribeeSteamUIAction, list, kTribeeSteamHomeUserInfo, kTribeeSteamHomeData, kTribeeSteamHomeShareConfig, tribeeSteamGameAchievementState, tribeeSteamShareState, shareMenuVM, kTipsFootCard, kThreeDot, z, qrCodeProvider, screenshotProvider);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SteamInfoState) {
                SteamInfoState steamInfoState = (SteamInfoState) obj;
                return Intrinsics.areEqual(this.uiAction, steamInfoState.uiAction) && Intrinsics.areEqual(this.requestingActions, steamInfoState.requestingActions) && Intrinsics.areEqual(this.userInfo, steamInfoState.userInfo) && Intrinsics.areEqual(this.steamData, steamInfoState.steamData) && Intrinsics.areEqual(this.shareConfig, steamInfoState.shareConfig) && Intrinsics.areEqual(this.achievementState, steamInfoState.achievementState) && Intrinsics.areEqual(this.shareState, steamInfoState.shareState) && Intrinsics.areEqual(this.shareMenuVM, steamInfoState.shareMenuVM) && Intrinsics.areEqual(this.tipsFootCard, steamInfoState.tipsFootCard) && Intrinsics.areEqual(this.threeDot, steamInfoState.threeDot) && this.isMaster == steamInfoState.isMaster && Intrinsics.areEqual(this.qrCodeProvider, steamInfoState.qrCodeProvider) && Intrinsics.areEqual(this.screenshotProvider, steamInfoState.screenshotProvider);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((this.uiAction == null ? 0 : this.uiAction.hashCode()) * 31) + (this.requestingActions == null ? 0 : this.requestingActions.hashCode())) * 31) + (this.userInfo == null ? 0 : this.userInfo.hashCode())) * 31) + (this.steamData == null ? 0 : this.steamData.hashCode())) * 31) + (this.shareConfig == null ? 0 : this.shareConfig.hashCode())) * 31) + this.achievementState.hashCode()) * 31) + this.shareState.hashCode()) * 31) + (this.shareMenuVM == null ? 0 : this.shareMenuVM.hashCode())) * 31) + (this.tipsFootCard == null ? 0 : this.tipsFootCard.hashCode())) * 31) + (this.threeDot != null ? this.threeDot.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMaster)) * 31) + this.qrCodeProvider.hashCode()) * 31) + this.screenshotProvider.hashCode();
        }

        public String toString() {
            TribeeSteamUIAction tribeeSteamUIAction = this.uiAction;
            List<TribeeSteamStateAction> list = this.requestingActions;
            KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo = this.userInfo;
            KTribeeSteamHomeData kTribeeSteamHomeData = this.steamData;
            KTribeeSteamHomeShareConfig kTribeeSteamHomeShareConfig = this.shareConfig;
            TribeeSteamGameAchievementState tribeeSteamGameAchievementState = this.achievementState;
            TribeeSteamShareState tribeeSteamShareState = this.shareState;
            ShareMenuVM shareMenuVM = this.shareMenuVM;
            KTipsFootCard kTipsFootCard = this.tipsFootCard;
            KThreeDot kThreeDot = this.threeDot;
            boolean z = this.isMaster;
            QrCodeProvider qrCodeProvider = this.qrCodeProvider;
            return "SteamInfoState(uiAction=" + tribeeSteamUIAction + ", requestingActions=" + list + ", userInfo=" + kTribeeSteamHomeUserInfo + ", steamData=" + kTribeeSteamHomeData + ", shareConfig=" + kTribeeSteamHomeShareConfig + ", achievementState=" + tribeeSteamGameAchievementState + ", shareState=" + tribeeSteamShareState + ", shareMenuVM=" + shareMenuVM + ", tipsFootCard=" + kTipsFootCard + ", threeDot=" + kThreeDot + ", isMaster=" + z + ", qrCodeProvider=" + qrCodeProvider + ", screenshotProvider=" + this.screenshotProvider + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public SteamInfoState(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list, KTribeeSteamHomeUserInfo userInfo, KTribeeSteamHomeData steamData, KTribeeSteamHomeShareConfig shareConfig, TribeeSteamGameAchievementState achievementState, TribeeSteamShareState shareState, ShareMenuVM shareMenuVM, KTipsFootCard tipsFootCard, KThreeDot threeDot, boolean isMaster, QrCodeProvider qrCodeProvider, ScreenshotProvider screenshotProvider) {
            super(null, null, false, 7, null);
            Intrinsics.checkNotNullParameter(achievementState, "achievementState");
            Intrinsics.checkNotNullParameter(shareState, "shareState");
            Intrinsics.checkNotNullParameter(qrCodeProvider, "qrCodeProvider");
            Intrinsics.checkNotNullParameter(screenshotProvider, "screenshotProvider");
            this.uiAction = uiAction;
            this.requestingActions = list;
            this.userInfo = userInfo;
            this.steamData = steamData;
            this.shareConfig = shareConfig;
            this.achievementState = achievementState;
            this.shareState = shareState;
            this.shareMenuVM = shareMenuVM;
            this.tipsFootCard = tipsFootCard;
            this.threeDot = threeDot;
            this.isMaster = isMaster;
            this.qrCodeProvider = qrCodeProvider;
            this.screenshotProvider = screenshotProvider;
        }

        public /* synthetic */ SteamInfoState(TribeeSteamUIAction tribeeSteamUIAction, List list, KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo, KTribeeSteamHomeData kTribeeSteamHomeData, KTribeeSteamHomeShareConfig kTribeeSteamHomeShareConfig, TribeeSteamGameAchievementState tribeeSteamGameAchievementState, TribeeSteamShareState tribeeSteamShareState, ShareMenuVM shareMenuVM, KTipsFootCard kTipsFootCard, KThreeDot kThreeDot, boolean z, QrCodeProvider qrCodeProvider, ScreenshotProvider screenshotProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : tribeeSteamUIAction, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : kTribeeSteamHomeUserInfo, (i & 8) != 0 ? null : kTribeeSteamHomeData, (i & 16) != 0 ? null : kTribeeSteamHomeShareConfig, (i & 32) != 0 ? new TribeeSteamGameAchievementState.EmptyGameState(null, null, null, 6, null) : tribeeSteamGameAchievementState, (i & 64) != 0 ? TribeeSteamShareState.InitialState.INSTANCE : tribeeSteamShareState, (i & 128) != 0 ? null : shareMenuVM, (i & 256) != 0 ? null : kTipsFootCard, (i & 512) != 0 ? null : kThreeDot, (i & 1024) != 0 ? true : z, qrCodeProvider, screenshotProvider);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamUIAction getUiAction() {
            return this.uiAction;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public List<TribeeSteamStateAction> getRequestingActions() {
            return this.requestingActions;
        }

        public final KTribeeSteamHomeUserInfo getUserInfo() {
            return this.userInfo;
        }

        public final KTribeeSteamHomeData getSteamData() {
            return this.steamData;
        }

        public final KTribeeSteamHomeShareConfig getShareConfig() {
            return this.shareConfig;
        }

        public final TribeeSteamGameAchievementState getAchievementState() {
            return this.achievementState;
        }

        public final TribeeSteamShareState getShareState() {
            return this.shareState;
        }

        public final ShareMenuVM getShareMenuVM() {
            return this.shareMenuVM;
        }

        public final KTipsFootCard getTipsFootCard() {
            return this.tipsFootCard;
        }

        public final KThreeDot getThreeDot() {
            return this.threeDot;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public boolean isMaster() {
            return this.isMaster;
        }

        public final QrCodeProvider getQrCodeProvider() {
            return this.qrCodeProvider;
        }

        public final ScreenshotProvider getScreenshotProvider() {
            return this.screenshotProvider;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamState
        public TribeeSteamState copyBy(TribeeSteamUIAction uiAction, List<? extends TribeeSteamStateAction> list) {
            return copy$default(this, uiAction, list, null, null, null, null, null, null, null, null, false, null, null, 8188, null);
        }
    }
}