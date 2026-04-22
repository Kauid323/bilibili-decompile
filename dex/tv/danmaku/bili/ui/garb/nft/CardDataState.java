package tv.danmaku.bili.ui.garb.nft;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.garb.api.BillDLCRespInfo;

/* compiled from: DLCDrawCardDataManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/CardDataState;", "", "<init>", "()V", "Loading", "ResFailed", "Timeout", "ApiFailed", "Success", "Ltv/danmaku/bili/ui/garb/nft/CardDataState$ApiFailed;", "Ltv/danmaku/bili/ui/garb/nft/CardDataState$Loading;", "Ltv/danmaku/bili/ui/garb/nft/CardDataState$ResFailed;", "Ltv/danmaku/bili/ui/garb/nft/CardDataState$Success;", "Ltv/danmaku/bili/ui/garb/nft/CardDataState$Timeout;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class CardDataState {
    public static final int $stable = 0;

    public /* synthetic */ CardDataState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: DLCDrawCardDataManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/CardDataState$Loading;", "Ltv/danmaku/bili/ui/garb/nft/CardDataState;", "<init>", "()V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Loading extends CardDataState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    private CardDataState() {
    }

    /* compiled from: DLCDrawCardDataManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/CardDataState$ResFailed;", "Ltv/danmaku/bili/ui/garb/nft/CardDataState;", "dlcRespInfo", "Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;", "<init>", "(Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;)V", "getDlcRespInfo", "()Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;", "setDlcRespInfo", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ResFailed extends CardDataState {
        public static final int $stable = 8;
        private BillDLCRespInfo dlcRespInfo;

        public ResFailed() {
            this(null, 1, null);
        }

        public static /* synthetic */ ResFailed copy$default(ResFailed resFailed, BillDLCRespInfo billDLCRespInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                billDLCRespInfo = resFailed.dlcRespInfo;
            }
            return resFailed.copy(billDLCRespInfo);
        }

        public final BillDLCRespInfo component1() {
            return this.dlcRespInfo;
        }

        public final ResFailed copy(BillDLCRespInfo billDLCRespInfo) {
            return new ResFailed(billDLCRespInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ResFailed) && Intrinsics.areEqual(this.dlcRespInfo, ((ResFailed) obj).dlcRespInfo);
        }

        public int hashCode() {
            if (this.dlcRespInfo == null) {
                return 0;
            }
            return this.dlcRespInfo.hashCode();
        }

        public String toString() {
            return "ResFailed(dlcRespInfo=" + this.dlcRespInfo + ")";
        }

        public ResFailed(BillDLCRespInfo dlcRespInfo) {
            super(null);
            this.dlcRespInfo = dlcRespInfo;
        }

        public /* synthetic */ ResFailed(BillDLCRespInfo billDLCRespInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : billDLCRespInfo);
        }

        public final BillDLCRespInfo getDlcRespInfo() {
            return this.dlcRespInfo;
        }

        public final void setDlcRespInfo(BillDLCRespInfo billDLCRespInfo) {
            this.dlcRespInfo = billDLCRespInfo;
        }
    }

    /* compiled from: DLCDrawCardDataManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/CardDataState$Timeout;", "Ltv/danmaku/bili/ui/garb/nft/CardDataState;", "<init>", "()V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Timeout extends CardDataState {
        public static final int $stable = 0;
        public static final Timeout INSTANCE = new Timeout();

        private Timeout() {
            super(null);
        }
    }

    /* compiled from: DLCDrawCardDataManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/CardDataState$ApiFailed;", "Ltv/danmaku/bili/ui/garb/nft/CardDataState;", AuthResultCbHelper.ARGS_MSG, "", "<init>", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ApiFailed extends CardDataState {
        public static final int $stable = 8;
        private String msg;

        public ApiFailed() {
            this(null, 1, null);
        }

        public static /* synthetic */ ApiFailed copy$default(ApiFailed apiFailed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = apiFailed.msg;
            }
            return apiFailed.copy(str);
        }

        public final String component1() {
            return this.msg;
        }

        public final ApiFailed copy(String str) {
            return new ApiFailed(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApiFailed) && Intrinsics.areEqual(this.msg, ((ApiFailed) obj).msg);
        }

        public int hashCode() {
            if (this.msg == null) {
                return 0;
            }
            return this.msg.hashCode();
        }

        public String toString() {
            return "ApiFailed(msg=" + this.msg + ")";
        }

        public ApiFailed(String msg) {
            super(null);
            this.msg = msg;
        }

        public /* synthetic */ ApiFailed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getMsg() {
            return this.msg;
        }

        public final void setMsg(String str) {
            this.msg = str;
        }
    }

    /* compiled from: DLCDrawCardDataManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/CardDataState$Success;", "Ltv/danmaku/bili/ui/garb/nft/CardDataState;", "dlcRespInfo", "Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;", "<init>", "(Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;)V", "getDlcRespInfo", "()Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;", "setDlcRespInfo", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Success extends CardDataState {
        public static final int $stable = 8;
        private BillDLCRespInfo dlcRespInfo;

        public Success() {
            this(null, 1, null);
        }

        public static /* synthetic */ Success copy$default(Success success, BillDLCRespInfo billDLCRespInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                billDLCRespInfo = success.dlcRespInfo;
            }
            return success.copy(billDLCRespInfo);
        }

        public final BillDLCRespInfo component1() {
            return this.dlcRespInfo;
        }

        public final Success copy(BillDLCRespInfo billDLCRespInfo) {
            return new Success(billDLCRespInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.dlcRespInfo, ((Success) obj).dlcRespInfo);
        }

        public int hashCode() {
            if (this.dlcRespInfo == null) {
                return 0;
            }
            return this.dlcRespInfo.hashCode();
        }

        public String toString() {
            return "Success(dlcRespInfo=" + this.dlcRespInfo + ")";
        }

        public Success(BillDLCRespInfo dlcRespInfo) {
            super(null);
            this.dlcRespInfo = dlcRespInfo;
        }

        public /* synthetic */ Success(BillDLCRespInfo billDLCRespInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : billDLCRespInfo);
        }

        public final BillDLCRespInfo getDlcRespInfo() {
            return this.dlcRespInfo;
        }

        public final void setDlcRespInfo(BillDLCRespInfo billDLCRespInfo) {
            this.dlcRespInfo = billDLCRespInfo;
        }
    }
}