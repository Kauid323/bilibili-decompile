package usercenter;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UserHandleApiService.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lusercenter/UpdateHandleResult;", "", "Success", "Failure", "Lusercenter/UpdateHandleResult$Failure;", "Lusercenter/UpdateHandleResult$Success;", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface UpdateHandleResult {

    /* compiled from: UserHandleApiService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lusercenter/UpdateHandleResult$Success;", "Lusercenter/UpdateHandleResult;", "newHandle", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNewHandle", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Success implements UpdateHandleResult {
        public static final int $stable = 0;
        private final String message;
        private final String newHandle;

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.newHandle;
            }
            if ((i & 2) != 0) {
                str2 = success.message;
            }
            return success.copy(str, str2);
        }

        public final String component1() {
            return this.newHandle;
        }

        public final String component2() {
            return this.message;
        }

        public final Success copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "newHandle");
            Intrinsics.checkNotNullParameter(str2, "message");
            return new Success(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.newHandle, success.newHandle) && Intrinsics.areEqual(this.message, success.message);
            }
            return false;
        }

        public int hashCode() {
            return (this.newHandle.hashCode() * 31) + this.message.hashCode();
        }

        public String toString() {
            String str = this.newHandle;
            return "Success(newHandle=" + str + ", message=" + this.message + ")";
        }

        public Success(String newHandle, String message) {
            Intrinsics.checkNotNullParameter(newHandle, "newHandle");
            Intrinsics.checkNotNullParameter(message, "message");
            this.newHandle = newHandle;
            this.message = message;
        }

        public final String getNewHandle() {
            return this.newHandle;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* compiled from: UserHandleApiService.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lusercenter/UpdateHandleResult$Failure;", "Lusercenter/UpdateHandleResult;", "code", "", "message", "", "optionHandleList", "", "<init>", "(JLjava/lang/String;Ljava/util/List;)V", "getCode", "()J", "getMessage", "()Ljava/lang/String;", "getOptionHandleList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Failure implements UpdateHandleResult {
        public static final int $stable = 8;
        private final long code;
        private final String message;
        private final List<String> optionHandleList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Failure copy$default(Failure failure, long j, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = failure.code;
            }
            if ((i & 2) != 0) {
                str = failure.message;
            }
            if ((i & 4) != 0) {
                list = failure.optionHandleList;
            }
            return failure.copy(j, str, list);
        }

        public final long component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final List<String> component3() {
            return this.optionHandleList;
        }

        public final Failure copy(long j, String str, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(list, "optionHandleList");
            return new Failure(j, str, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.message, failure.message) && Intrinsics.areEqual(this.optionHandleList, failure.optionHandleList);
            }
            return false;
        }

        public int hashCode() {
            return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.code) * 31) + this.message.hashCode()) * 31) + this.optionHandleList.hashCode();
        }

        public String toString() {
            long j = this.code;
            String str = this.message;
            return "Failure(code=" + j + ", message=" + str + ", optionHandleList=" + this.optionHandleList + ")";
        }

        public Failure(long code, String message, List<String> list) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(list, "optionHandleList");
            this.code = code;
            this.message = message;
            this.optionHandleList = list;
        }

        public /* synthetic */ Failure(long j, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final long getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public final List<String> getOptionHandleList() {
            return this.optionHandleList;
        }
    }
}