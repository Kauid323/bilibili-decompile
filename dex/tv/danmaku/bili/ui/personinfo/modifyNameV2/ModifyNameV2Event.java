package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ModifyNameV2.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event;", "", "<init>", "()V", "SubmitSuccess", "SubmitFailed", "ShowToast", "ShowChangeConformDialog", "ShowBindPhoneDialog", "ShowNameRetryDialog", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$ShowBindPhoneDialog;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$ShowChangeConformDialog;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$ShowNameRetryDialog;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$ShowToast;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$SubmitFailed;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$SubmitSuccess;", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class ModifyNameV2Event {
    public static final int $stable = 0;

    public /* synthetic */ ModifyNameV2Event(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$SubmitSuccess;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event;", "successName", "", "<init>", "(Ljava/lang/String;)V", "getSuccessName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SubmitSuccess extends ModifyNameV2Event {
        public static final int $stable = 0;
        private final String successName;

        public static /* synthetic */ SubmitSuccess copy$default(SubmitSuccess submitSuccess, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = submitSuccess.successName;
            }
            return submitSuccess.copy(str);
        }

        public final String component1() {
            return this.successName;
        }

        public final SubmitSuccess copy(String str) {
            Intrinsics.checkNotNullParameter(str, "successName");
            return new SubmitSuccess(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SubmitSuccess) && Intrinsics.areEqual(this.successName, ((SubmitSuccess) obj).successName);
        }

        public int hashCode() {
            return this.successName.hashCode();
        }

        public String toString() {
            return "SubmitSuccess(successName=" + this.successName + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubmitSuccess(String successName) {
            super(null);
            Intrinsics.checkNotNullParameter(successName, "successName");
            this.successName = successName;
        }

        public final String getSuccessName() {
            return this.successName;
        }
    }

    private ModifyNameV2Event() {
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$SubmitFailed;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event;", "exception", "Ljava/lang/Exception;", "<init>", "(Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SubmitFailed extends ModifyNameV2Event {
        public static final int $stable = 8;
        private final Exception exception;

        public static /* synthetic */ SubmitFailed copy$default(SubmitFailed submitFailed, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                exc = submitFailed.exception;
            }
            return submitFailed.copy(exc);
        }

        public final Exception component1() {
            return this.exception;
        }

        public final SubmitFailed copy(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "exception");
            return new SubmitFailed(exc);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SubmitFailed) && Intrinsics.areEqual(this.exception, ((SubmitFailed) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "SubmitFailed(exception=" + this.exception + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubmitFailed(Exception exception) {
            super(null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public final Exception getException() {
            return this.exception;
        }
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$ShowToast;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event;", "info", "", "<init>", "(Ljava/lang/Object;)V", "getInfo", "()Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowToast extends ModifyNameV2Event {
        public static final int $stable = 8;
        private final Object info;

        public static /* synthetic */ ShowToast copy$default(ShowToast showToast, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = showToast.info;
            }
            return showToast.copy(obj);
        }

        public final Object component1() {
            return this.info;
        }

        public final ShowToast copy(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "info");
            return new ShowToast(obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowToast) && Intrinsics.areEqual(this.info, ((ShowToast) obj).info);
        }

        public int hashCode() {
            return this.info.hashCode();
        }

        public String toString() {
            return "ShowToast(info=" + this.info + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowToast(Object info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        public final Object getInfo() {
            return this.info;
        }
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$ShowChangeConformDialog;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event;", "conformMsg", "", "<init>", "(Ljava/lang/String;)V", "getConformMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowChangeConformDialog extends ModifyNameV2Event {
        public static final int $stable = 0;
        private final String conformMsg;

        public static /* synthetic */ ShowChangeConformDialog copy$default(ShowChangeConformDialog showChangeConformDialog, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = showChangeConformDialog.conformMsg;
            }
            return showChangeConformDialog.copy(str);
        }

        public final String component1() {
            return this.conformMsg;
        }

        public final ShowChangeConformDialog copy(String str) {
            Intrinsics.checkNotNullParameter(str, "conformMsg");
            return new ShowChangeConformDialog(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowChangeConformDialog) && Intrinsics.areEqual(this.conformMsg, ((ShowChangeConformDialog) obj).conformMsg);
        }

        public int hashCode() {
            return this.conformMsg.hashCode();
        }

        public String toString() {
            return "ShowChangeConformDialog(conformMsg=" + this.conformMsg + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowChangeConformDialog(String conformMsg) {
            super(null);
            Intrinsics.checkNotNullParameter(conformMsg, "conformMsg");
            this.conformMsg = conformMsg;
        }

        public final String getConformMsg() {
            return this.conformMsg;
        }
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$ShowBindPhoneDialog;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event;", "conditionMsg", "", "tel", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getConditionMsg", "()Ljava/lang/String;", "getTel", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowBindPhoneDialog extends ModifyNameV2Event {
        public static final int $stable = 0;
        private final String conditionMsg;
        private final String tel;

        public static /* synthetic */ ShowBindPhoneDialog copy$default(ShowBindPhoneDialog showBindPhoneDialog, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = showBindPhoneDialog.conditionMsg;
            }
            if ((i & 2) != 0) {
                str2 = showBindPhoneDialog.tel;
            }
            return showBindPhoneDialog.copy(str, str2);
        }

        public final String component1() {
            return this.conditionMsg;
        }

        public final String component2() {
            return this.tel;
        }

        public final ShowBindPhoneDialog copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "conditionMsg");
            Intrinsics.checkNotNullParameter(str2, "tel");
            return new ShowBindPhoneDialog(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowBindPhoneDialog) {
                ShowBindPhoneDialog showBindPhoneDialog = (ShowBindPhoneDialog) obj;
                return Intrinsics.areEqual(this.conditionMsg, showBindPhoneDialog.conditionMsg) && Intrinsics.areEqual(this.tel, showBindPhoneDialog.tel);
            }
            return false;
        }

        public int hashCode() {
            return (this.conditionMsg.hashCode() * 31) + this.tel.hashCode();
        }

        public String toString() {
            String str = this.conditionMsg;
            return "ShowBindPhoneDialog(conditionMsg=" + str + ", tel=" + this.tel + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowBindPhoneDialog(String conditionMsg, String tel) {
            super(null);
            Intrinsics.checkNotNullParameter(conditionMsg, "conditionMsg");
            Intrinsics.checkNotNullParameter(tel, "tel");
            this.conditionMsg = conditionMsg;
            this.tel = tel;
        }

        public final String getConditionMsg() {
            return this.conditionMsg;
        }

        public final String getTel() {
            return this.tel;
        }
    }

    /* compiled from: ModifyNameV2.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event$ShowNameRetryDialog;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event;", "names", "", "", "<init>", "(Ljava/util/List;)V", "getNames", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowNameRetryDialog extends ModifyNameV2Event {
        public static final int $stable = 8;
        private final List<String> names;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ShowNameRetryDialog copy$default(ShowNameRetryDialog showNameRetryDialog, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = showNameRetryDialog.names;
            }
            return showNameRetryDialog.copy(list);
        }

        public final List<String> component1() {
            return this.names;
        }

        public final ShowNameRetryDialog copy(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "names");
            return new ShowNameRetryDialog(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowNameRetryDialog) && Intrinsics.areEqual(this.names, ((ShowNameRetryDialog) obj).names);
        }

        public int hashCode() {
            return this.names.hashCode();
        }

        public String toString() {
            return "ShowNameRetryDialog(names=" + this.names + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowNameRetryDialog(List<String> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "names");
            this.names = list;
        }

        public final List<String> getNames() {
            return this.names;
        }
    }
}