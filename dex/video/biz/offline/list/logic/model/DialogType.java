package video.biz.offline.list.logic.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflinePageState.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\u0082\u0001\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType;", "", "None", "VipOnlyAlert", "VipExpiredAlert", "VipParallelDownloadAlert", "VipPreviewAlert", "ResourceInvalid", "BandWidthAlert", "Loading", "DeleteAlert", "MaxConcurrentSheet", "Lvideo/biz/offline/list/logic/model/DialogType$BandWidthAlert;", "Lvideo/biz/offline/list/logic/model/DialogType$DeleteAlert;", "Lvideo/biz/offline/list/logic/model/DialogType$Loading;", "Lvideo/biz/offline/list/logic/model/DialogType$MaxConcurrentSheet;", "Lvideo/biz/offline/list/logic/model/DialogType$None;", "Lvideo/biz/offline/list/logic/model/DialogType$ResourceInvalid;", "Lvideo/biz/offline/list/logic/model/DialogType$VipExpiredAlert;", "Lvideo/biz/offline/list/logic/model/DialogType$VipOnlyAlert;", "Lvideo/biz/offline/list/logic/model/DialogType$VipParallelDownloadAlert;", "Lvideo/biz/offline/list/logic/model/DialogType$VipPreviewAlert;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface DialogType {

    /* compiled from: OfflinePageState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType$None;", "Lvideo/biz/offline/list/logic/model/DialogType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class None implements DialogType {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof None) {
                None none = (None) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -774309864;
        }

        public String toString() {
            return "None";
        }

        private None() {
        }
    }

    /* compiled from: OfflinePageState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType$VipOnlyAlert;", "Lvideo/biz/offline/list/logic/model/DialogType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VipOnlyAlert implements DialogType {
        public static final int $stable = 0;
        public static final VipOnlyAlert INSTANCE = new VipOnlyAlert();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VipOnlyAlert) {
                VipOnlyAlert vipOnlyAlert = (VipOnlyAlert) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1557198419;
        }

        public String toString() {
            return "VipOnlyAlert";
        }

        private VipOnlyAlert() {
        }
    }

    /* compiled from: OfflinePageState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType$VipExpiredAlert;", "Lvideo/biz/offline/list/logic/model/DialogType;", "aid", "", "<init>", "(J)V", "getAid", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VipExpiredAlert implements DialogType {
        public static final int $stable = 0;
        private final long aid;

        public static /* synthetic */ VipExpiredAlert copy$default(VipExpiredAlert vipExpiredAlert, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = vipExpiredAlert.aid;
            }
            return vipExpiredAlert.copy(j);
        }

        public final long component1() {
            return this.aid;
        }

        public final VipExpiredAlert copy(long j) {
            return new VipExpiredAlert(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VipExpiredAlert) && this.aid == ((VipExpiredAlert) obj).aid;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid);
        }

        public String toString() {
            return "VipExpiredAlert(aid=" + this.aid + ")";
        }

        public VipExpiredAlert(long aid) {
            this.aid = aid;
        }

        public final long getAid() {
            return this.aid;
        }
    }

    /* compiled from: OfflinePageState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType$VipParallelDownloadAlert;", "Lvideo/biz/offline/list/logic/model/DialogType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VipParallelDownloadAlert implements DialogType {
        public static final int $stable = 0;
        public static final VipParallelDownloadAlert INSTANCE = new VipParallelDownloadAlert();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VipParallelDownloadAlert) {
                VipParallelDownloadAlert vipParallelDownloadAlert = (VipParallelDownloadAlert) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -317788240;
        }

        public String toString() {
            return "VipParallelDownloadAlert";
        }

        private VipParallelDownloadAlert() {
        }
    }

    /* compiled from: OfflinePageState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType$VipPreviewAlert;", "Lvideo/biz/offline/list/logic/model/DialogType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VipPreviewAlert implements DialogType {
        public static final int $stable = 0;
        public static final VipPreviewAlert INSTANCE = new VipPreviewAlert();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VipPreviewAlert) {
                VipPreviewAlert vipPreviewAlert = (VipPreviewAlert) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -159115695;
        }

        public String toString() {
            return "VipPreviewAlert";
        }

        private VipPreviewAlert() {
        }
    }

    /* compiled from: OfflinePageState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType$ResourceInvalid;", "Lvideo/biz/offline/list/logic/model/DialogType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ResourceInvalid implements DialogType {
        public static final int $stable = 0;
        public static final ResourceInvalid INSTANCE = new ResourceInvalid();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResourceInvalid) {
                ResourceInvalid resourceInvalid = (ResourceInvalid) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1909925161;
        }

        public String toString() {
            return "ResourceInvalid";
        }

        private ResourceInvalid() {
        }
    }

    /* compiled from: OfflinePageState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType$BandWidthAlert;", "Lvideo/biz/offline/list/logic/model/DialogType;", "action", "Lkotlin/Function0;", "", "hasFreeBandwidthError", "", "<init>", "(Lkotlin/jvm/functions/Function0;Z)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "getHasFreeBandwidthError", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BandWidthAlert implements DialogType {
        public static final int $stable = 0;
        private final Function0<Unit> action;
        private final boolean hasFreeBandwidthError;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BandWidthAlert copy$default(BandWidthAlert bandWidthAlert, Function0 function0, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = bandWidthAlert.action;
            }
            if ((i & 2) != 0) {
                z = bandWidthAlert.hasFreeBandwidthError;
            }
            return bandWidthAlert.copy(function0, z);
        }

        public final Function0<Unit> component1() {
            return this.action;
        }

        public final boolean component2() {
            return this.hasFreeBandwidthError;
        }

        public final BandWidthAlert copy(Function0<Unit> function0, boolean z) {
            Intrinsics.checkNotNullParameter(function0, "action");
            return new BandWidthAlert(function0, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BandWidthAlert) {
                BandWidthAlert bandWidthAlert = (BandWidthAlert) obj;
                return Intrinsics.areEqual(this.action, bandWidthAlert.action) && this.hasFreeBandwidthError == bandWidthAlert.hasFreeBandwidthError;
            }
            return false;
        }

        public int hashCode() {
            return (this.action.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasFreeBandwidthError);
        }

        public String toString() {
            Function0<Unit> function0 = this.action;
            return "BandWidthAlert(action=" + function0 + ", hasFreeBandwidthError=" + this.hasFreeBandwidthError + ")";
        }

        public BandWidthAlert(Function0<Unit> function0, boolean hasFreeBandwidthError) {
            Intrinsics.checkNotNullParameter(function0, "action");
            this.action = function0;
            this.hasFreeBandwidthError = hasFreeBandwidthError;
        }

        public /* synthetic */ BandWidthAlert(Function0 function0, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, (i & 2) != 0 ? false : z);
        }

        public final Function0<Unit> getAction() {
            return this.action;
        }

        public final boolean getHasFreeBandwidthError() {
            return this.hasFreeBandwidthError;
        }
    }

    /* compiled from: OfflinePageState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType$Loading;", "Lvideo/biz/offline/list/logic/model/DialogType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Loading implements DialogType {
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
            return -982750116;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: OfflinePageState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType$DeleteAlert;", "Lvideo/biz/offline/list/logic/model/DialogType;", "keys", "", "", "hasVideoGroup", "", "<init>", "(Ljava/util/List;Z)V", "getKeys", "()Ljava/util/List;", "getHasVideoGroup", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DeleteAlert implements DialogType {
        public static final int $stable = 8;
        private final boolean hasVideoGroup;
        private final List<String> keys;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DeleteAlert copy$default(DeleteAlert deleteAlert, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                list = deleteAlert.keys;
            }
            if ((i & 2) != 0) {
                z = deleteAlert.hasVideoGroup;
            }
            return deleteAlert.copy(list, z);
        }

        public final List<String> component1() {
            return this.keys;
        }

        public final boolean component2() {
            return this.hasVideoGroup;
        }

        public final DeleteAlert copy(List<String> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "keys");
            return new DeleteAlert(list, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DeleteAlert) {
                DeleteAlert deleteAlert = (DeleteAlert) obj;
                return Intrinsics.areEqual(this.keys, deleteAlert.keys) && this.hasVideoGroup == deleteAlert.hasVideoGroup;
            }
            return false;
        }

        public int hashCode() {
            return (this.keys.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasVideoGroup);
        }

        public String toString() {
            List<String> list = this.keys;
            return "DeleteAlert(keys=" + list + ", hasVideoGroup=" + this.hasVideoGroup + ")";
        }

        public DeleteAlert(List<String> list, boolean hasVideoGroup) {
            Intrinsics.checkNotNullParameter(list, "keys");
            this.keys = list;
            this.hasVideoGroup = hasVideoGroup;
        }

        public /* synthetic */ DeleteAlert(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? false : z);
        }

        public final List<String> getKeys() {
            return this.keys;
        }

        public final boolean getHasVideoGroup() {
            return this.hasVideoGroup;
        }
    }

    /* compiled from: OfflinePageState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/list/logic/model/DialogType$MaxConcurrentSheet;", "Lvideo/biz/offline/list/logic/model/DialogType;", "maxConcurrent", "", "<init>", "(I)V", "getMaxConcurrent", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class MaxConcurrentSheet implements DialogType {
        public static final int $stable = 0;
        private final int maxConcurrent;

        public static /* synthetic */ MaxConcurrentSheet copy$default(MaxConcurrentSheet maxConcurrentSheet, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = maxConcurrentSheet.maxConcurrent;
            }
            return maxConcurrentSheet.copy(i);
        }

        public final int component1() {
            return this.maxConcurrent;
        }

        public final MaxConcurrentSheet copy(int i) {
            return new MaxConcurrentSheet(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MaxConcurrentSheet) && this.maxConcurrent == ((MaxConcurrentSheet) obj).maxConcurrent;
        }

        public int hashCode() {
            return this.maxConcurrent;
        }

        public String toString() {
            return "MaxConcurrentSheet(maxConcurrent=" + this.maxConcurrent + ")";
        }

        public MaxConcurrentSheet(int maxConcurrent) {
            this.maxConcurrent = maxConcurrent;
        }

        public final int getMaxConcurrent() {
            return this.maxConcurrent;
        }
    }
}