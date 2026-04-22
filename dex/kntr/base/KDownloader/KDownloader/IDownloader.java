package kntr.base.KDownloader.KDownloader;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KDownloader.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lkntr/base/KDownloader/KDownloader/IDownloader;", "", "create", "Lkntr/base/KDownloader/KDownloader/IDownloader$DownloadRequest;", "url", "", "fullPath", "tag", "dir", "fileName", "pause", "", "taskId", "cancel", "DownloadRequest", "DownloadListener", "Task", "Info", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDownloader {

    /* compiled from: KDownloader.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0000H&J\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/base/KDownloader/KDownloader/IDownloader$DownloadRequest;", "", "speedLimit", "", "priority", "totalSize", "", "md5", "", "sourceType", "addListener", "listener", "Lkntr/base/KDownloader/KDownloader/IDownloader$DownloadListener;", "disallowBreakContinuing", "addHeader", "name", "value", "build", "Lkntr/base/KDownloader/KDownloader/IDownloader$Task;", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface DownloadRequest {
        DownloadRequest addHeader(String str, String str2);

        DownloadRequest addListener(DownloadListener downloadListener);

        Task build();

        DownloadRequest disallowBreakContinuing();

        DownloadRequest md5(String str);

        DownloadRequest priority(int i);

        DownloadRequest sourceType(int i);

        DownloadRequest speedLimit(int i);

        DownloadRequest totalSize(long j);
    }

    /* compiled from: KDownloader.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/base/KDownloader/KDownloader/IDownloader$Task;", "", "taskId", "", "getTaskId", "()Ljava/lang/String;", "enqueue", "", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Task {
        void enqueue();

        String getTaskId();
    }

    boolean cancel(String str);

    DownloadRequest create(String str, String str2, String str3);

    DownloadRequest create(String str, String str2, String str3, String str4);

    boolean pause(String str);

    /* compiled from: KDownloader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/base/KDownloader/KDownloader/IDownloader$DownloadListener;", "", "onLoading", "", "info", "Lkntr/base/KDownloader/KDownloader/IDownloader$Info$Loading;", "onFinish", "result", "Lkntr/base/KDownloader/KDownloader/IDownloader$Info$Success;", "onError", "Lkntr/base/KDownloader/KDownloader/IDownloader$Info$Error;", "onCancel", "onPause", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface DownloadListener {
        void onCancel();

        void onError(Info.Error error);

        void onFinish(Info.Success success);

        void onLoading(Info.Loading loading);

        void onPause();

        /* compiled from: KDownloader.kt */
        /* renamed from: kntr.base.KDownloader.KDownloader.IDownloader$DownloadListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            public static void $default$onCancel(DownloadListener _this) {
            }

            public static void $default$onPause(DownloadListener _this) {
            }
        }

        /* compiled from: KDownloader.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static void onLoading(DownloadListener $this, Info.Loading info) {
                Intrinsics.checkNotNullParameter(info, "info");
                Intrinsics.checkNotNullParameter(info, "info");
            }

            @Deprecated
            public static void onFinish(DownloadListener $this, Info.Success result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(result, "result");
            }

            @Deprecated
            public static void onError(DownloadListener $this, Info.Error result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(result, "result");
            }

            @Deprecated
            public static void onCancel(DownloadListener $this) {
                CC.$default$onCancel($this);
            }

            @Deprecated
            public static void onPause(DownloadListener $this) {
                CC.$default$onPause($this);
            }
        }
    }

    /* compiled from: KDownloader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/base/KDownloader/KDownloader/IDownloader$Info;", "", "Loading", "Success", "Error", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Info {

        /* compiled from: KDownloader.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/base/KDownloader/KDownloader/IDownloader$Info$Loading;", "", "totalSize", "", "loadedSize", "<init>", "(JJ)V", "getTotalSize", "()J", "getLoadedSize", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Loading {
            private final long loadedSize;
            private final long totalSize;

            public static /* synthetic */ Loading copy$default(Loading loading, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = loading.totalSize;
                }
                if ((i & 2) != 0) {
                    j2 = loading.loadedSize;
                }
                return loading.copy(j, j2);
            }

            public final long component1() {
                return this.totalSize;
            }

            public final long component2() {
                return this.loadedSize;
            }

            public final Loading copy(long j, long j2) {
                return new Loading(j, j2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Loading) {
                    Loading loading = (Loading) obj;
                    return this.totalSize == loading.totalSize && this.loadedSize == loading.loadedSize;
                }
                return false;
            }

            public int hashCode() {
                return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.totalSize) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.loadedSize);
            }

            public String toString() {
                long j = this.totalSize;
                return "Loading(totalSize=" + j + ", loadedSize=" + this.loadedSize + ")";
            }

            public Loading(long totalSize, long loadedSize) {
                this.totalSize = totalSize;
                this.loadedSize = loadedSize;
            }

            public final long getTotalSize() {
                return this.totalSize;
            }

            public final long getLoadedSize() {
                return this.loadedSize;
            }
        }

        /* compiled from: KDownloader.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkntr/base/KDownloader/KDownloader/IDownloader$Info$Success;", "", "absolutePathString", "", "<init>", "(Ljava/lang/String;)V", "getAbsolutePathString", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Success {
            private final String absolutePathString;

            public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = success.absolutePathString;
                }
                return success.copy(str);
            }

            public final String component1() {
                return this.absolutePathString;
            }

            public final Success copy(String str) {
                Intrinsics.checkNotNullParameter(str, "absolutePathString");
                return new Success(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && Intrinsics.areEqual(this.absolutePathString, ((Success) obj).absolutePathString);
            }

            public int hashCode() {
                return this.absolutePathString.hashCode();
            }

            public String toString() {
                return "Success(absolutePathString=" + this.absolutePathString + ")";
            }

            public Success(String absolutePathString) {
                Intrinsics.checkNotNullParameter(absolutePathString, "absolutePathString");
                this.absolutePathString = absolutePathString;
            }

            public final String getAbsolutePathString() {
                return this.absolutePathString;
            }
        }

        /* compiled from: KDownloader.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lkntr/base/KDownloader/KDownloader/IDownloader$Info$Error;", "", "errorCodes", "", "", "throwable", "", "<init>", "(Ljava/util/List;Ljava/lang/Throwable;)V", "getErrorCodes", "()Ljava/util/List;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Error {
            private final List<Integer> errorCodes;
            private final Throwable throwable;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Error copy$default(Error error, List list, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = error.errorCodes;
                }
                if ((i & 2) != 0) {
                    th = error.throwable;
                }
                return error.copy(list, th);
            }

            public final List<Integer> component1() {
                return this.errorCodes;
            }

            public final Throwable component2() {
                return this.throwable;
            }

            public final Error copy(List<Integer> list, Throwable th) {
                Intrinsics.checkNotNullParameter(list, "errorCodes");
                Intrinsics.checkNotNullParameter(th, "throwable");
                return new Error(list, th);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Error) {
                    Error error = (Error) obj;
                    return Intrinsics.areEqual(this.errorCodes, error.errorCodes) && Intrinsics.areEqual(this.throwable, error.throwable);
                }
                return false;
            }

            public int hashCode() {
                return (this.errorCodes.hashCode() * 31) + this.throwable.hashCode();
            }

            public String toString() {
                List<Integer> list = this.errorCodes;
                return "Error(errorCodes=" + list + ", throwable=" + this.throwable + ")";
            }

            public Error(List<Integer> list, Throwable throwable) {
                Intrinsics.checkNotNullParameter(list, "errorCodes");
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                this.errorCodes = list;
                this.throwable = throwable;
            }

            public final List<Integer> getErrorCodes() {
                return this.errorCodes;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }
        }
    }
}