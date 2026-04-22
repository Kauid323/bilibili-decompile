package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ModifyNameV2.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState;", "", "<init>", "()V", "Initial", "ShowLoading", "ShowEditState", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState$Initial;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState$ShowEditState;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState$ShowLoading;", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class PageState {
    public static final int $stable = 0;

    public /* synthetic */ PageState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState$Initial;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Initial extends PageState {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Initial) {
                Initial initial = (Initial) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1811769467;
        }

        public String toString() {
            return "Initial";
        }

        private Initial() {
            super(null);
        }
    }

    private PageState() {
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState$ShowLoading;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowLoading extends PageState {
        public static final int $stable = 0;
        public static final ShowLoading INSTANCE = new ShowLoading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowLoading) {
                ShowLoading showLoading = (ShowLoading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -945400522;
        }

        public String toString() {
            return "ShowLoading";
        }

        private ShowLoading() {
            super(null);
        }
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState$ShowEditState;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PageState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowEditState extends PageState {
        public static final int $stable = 0;
        public static final ShowEditState INSTANCE = new ShowEditState();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowEditState) {
                ShowEditState showEditState = (ShowEditState) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1272579551;
        }

        public String toString() {
            return "ShowEditState";
        }

        private ShowEditState() {
            super(null);
        }
    }
}