package tv.danmaku.bili.ui.clipboard;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: ClipboardService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardResp;", "", "<init>", "()V", "Unset", "Start", "Success", "Failed", "Ltv/danmaku/bili/ui/clipboard/ClipboardResp$Failed;", "Ltv/danmaku/bili/ui/clipboard/ClipboardResp$Start;", "Ltv/danmaku/bili/ui/clipboard/ClipboardResp$Success;", "Ltv/danmaku/bili/ui/clipboard/ClipboardResp$Unset;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class ClipboardResp {
    public static final int $stable = 0;

    public /* synthetic */ ClipboardResp(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ClipboardService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardResp$Unset;", "Ltv/danmaku/bili/ui/clipboard/ClipboardResp;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Unset extends ClipboardResp {
        public static final int $stable = 0;
        public static final Unset INSTANCE = new Unset();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Unset) {
                Unset unset = (Unset) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -603228178;
        }

        public String toString() {
            return "Unset";
        }

        private Unset() {
            super(null);
        }
    }

    private ClipboardResp() {
    }

    /* compiled from: ClipboardService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardResp$Start;", "Ltv/danmaku/bili/ui/clipboard/ClipboardResp;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Start extends ClipboardResp {
        public static final int $stable = 0;
        public static final Start INSTANCE = new Start();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Start) {
                Start start = (Start) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -604913369;
        }

        public String toString() {
            return "Start";
        }

        private Start() {
            super(null);
        }
    }

    /* compiled from: ClipboardService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardResp$Success;", "Ltv/danmaku/bili/ui/clipboard/ClipboardResp;", "result", "Ltv/danmaku/bili/ui/clipboard/RecognizeResult;", "<init>", "(Ltv/danmaku/bili/ui/clipboard/RecognizeResult;)V", "getResult", "()Ltv/danmaku/bili/ui/clipboard/RecognizeResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Success extends ClipboardResp {
        public static final int $stable = 0;
        private final RecognizeResult result;

        public static /* synthetic */ Success copy$default(Success success, RecognizeResult recognizeResult, int i, Object obj) {
            if ((i & 1) != 0) {
                recognizeResult = success.result;
            }
            return success.copy(recognizeResult);
        }

        public final RecognizeResult component1() {
            return this.result;
        }

        public final Success copy(RecognizeResult recognizeResult) {
            Intrinsics.checkNotNullParameter(recognizeResult, "result");
            return new Success(recognizeResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.result, ((Success) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "Success(result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(RecognizeResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(result, "result");
            this.result = result;
        }

        public final RecognizeResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ClipboardService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardResp$Failed;", "Ltv/danmaku/bili/ui/clipboard/ClipboardResp;", "error", "", "<init>", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Failed extends ClipboardResp {
        public static final int $stable = 0;
        private final String error;

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.error;
            }
            return failed.copy(str);
        }

        public final String component1() {
            return this.error;
        }

        public final Failed copy(String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            return new Failed(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && Intrinsics.areEqual(this.error, ((Failed) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Failed(error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(String error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final String getError() {
            return this.error;
        }
    }
}