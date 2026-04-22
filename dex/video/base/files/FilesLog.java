package video.base.files;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;

/* compiled from: FilesLog.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lvideo/base/files/FilesLog;", "Lvideo/base/log/IVBLog;", "<init>", "()V", "logType", "", "getLogType", "()Ljava/lang/String;", "ReadFile", "DirectoryCreate", "WriteFile", "RemoveFile", "Lvideo/base/files/FilesLog$DirectoryCreate;", "Lvideo/base/files/FilesLog$ReadFile;", "Lvideo/base/files/FilesLog$RemoveFile;", "Lvideo/base/files/FilesLog$WriteFile;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class FilesLog implements IVBLog {
    public static final int $stable = 0;

    public /* synthetic */ FilesLog(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: FilesLog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lvideo/base/files/FilesLog$ReadFile;", "Lvideo/base/files/FilesLog;", "path", "", "success", "", "error", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getSuccess", "()Z", "getError", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ReadFile extends FilesLog {
        public static final int $stable = 0;
        private final String error;
        private final String path;
        private final boolean success;

        public static /* synthetic */ ReadFile copy$default(ReadFile readFile, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = readFile.path;
            }
            if ((i & 2) != 0) {
                z = readFile.success;
            }
            if ((i & 4) != 0) {
                str2 = readFile.error;
            }
            return readFile.copy(str, z, str2);
        }

        public final String component1() {
            return this.path;
        }

        public final boolean component2() {
            return this.success;
        }

        public final String component3() {
            return this.error;
        }

        public final ReadFile copy(String str, boolean z, String str2) {
            Intrinsics.checkNotNullParameter(str, "path");
            Intrinsics.checkNotNullParameter(str2, "error");
            return new ReadFile(str, z, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReadFile) {
                ReadFile readFile = (ReadFile) obj;
                return Intrinsics.areEqual(this.path, readFile.path) && this.success == readFile.success && Intrinsics.areEqual(this.error, readFile.error);
            }
            return false;
        }

        public int hashCode() {
            return (((this.path.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success)) * 31) + this.error.hashCode();
        }

        public String toString() {
            String str = this.path;
            boolean z = this.success;
            return "ReadFile(path=" + str + ", success=" + z + ", error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReadFile(String path, boolean success, String error) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(error, "error");
            this.path = path;
            this.success = success;
            this.error = error;
        }

        public /* synthetic */ ReadFile(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z, (i & 4) != 0 ? "" : str2);
        }

        public final String getPath() {
            return this.path;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final String getError() {
            return this.error;
        }
    }

    private FilesLog() {
    }

    @Override // video.base.log.IVBLog
    public /* bridge */ void debug(String message) {
        IVBLog.CC.$default$debug(this, message);
    }

    @Override // video.base.log.IVBLog
    public /* bridge */ void error(String message) {
        IVBLog.CC.$default$error(this, message);
    }

    @Override // video.base.log.IVBLog
    public /* bridge */ void error(String message, Throwable throwable) {
        IVBLog.CC.$default$error(this, message, throwable);
    }

    @Override // video.base.log.IVBLog
    public /* bridge */ void info(String message) {
        IVBLog.CC.$default$info(this, message);
    }

    @Override // video.base.log.IVBLog
    public /* bridge */ void warn(String message) {
        IVBLog.CC.$default$warn(this, message);
    }

    /* compiled from: FilesLog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lvideo/base/files/FilesLog$DirectoryCreate;", "Lvideo/base/files/FilesLog;", "path", "", "success", "", "error", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getSuccess", "()Z", "getError", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DirectoryCreate extends FilesLog {
        public static final int $stable = 0;
        private final String error;
        private final String path;
        private final boolean success;

        public static /* synthetic */ DirectoryCreate copy$default(DirectoryCreate directoryCreate, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = directoryCreate.path;
            }
            if ((i & 2) != 0) {
                z = directoryCreate.success;
            }
            if ((i & 4) != 0) {
                str2 = directoryCreate.error;
            }
            return directoryCreate.copy(str, z, str2);
        }

        public final String component1() {
            return this.path;
        }

        public final boolean component2() {
            return this.success;
        }

        public final String component3() {
            return this.error;
        }

        public final DirectoryCreate copy(String str, boolean z, String str2) {
            Intrinsics.checkNotNullParameter(str, "path");
            Intrinsics.checkNotNullParameter(str2, "error");
            return new DirectoryCreate(str, z, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DirectoryCreate) {
                DirectoryCreate directoryCreate = (DirectoryCreate) obj;
                return Intrinsics.areEqual(this.path, directoryCreate.path) && this.success == directoryCreate.success && Intrinsics.areEqual(this.error, directoryCreate.error);
            }
            return false;
        }

        public int hashCode() {
            return (((this.path.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success)) * 31) + this.error.hashCode();
        }

        public String toString() {
            String str = this.path;
            boolean z = this.success;
            return "DirectoryCreate(path=" + str + ", success=" + z + ", error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectoryCreate(String path, boolean success, String error) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(error, "error");
            this.path = path;
            this.success = success;
            this.error = error;
        }

        public /* synthetic */ DirectoryCreate(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z, (i & 4) != 0 ? "" : str2);
        }

        public final String getPath() {
            return this.path;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final String getError() {
            return this.error;
        }
    }

    /* compiled from: FilesLog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lvideo/base/files/FilesLog$WriteFile;", "Lvideo/base/files/FilesLog;", "path", "", "success", "", "<init>", "(Ljava/lang/String;Z)V", "getPath", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class WriteFile extends FilesLog {
        public static final int $stable = 0;
        private final String path;
        private final boolean success;

        public static /* synthetic */ WriteFile copy$default(WriteFile writeFile, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = writeFile.path;
            }
            if ((i & 2) != 0) {
                z = writeFile.success;
            }
            return writeFile.copy(str, z);
        }

        public final String component1() {
            return this.path;
        }

        public final boolean component2() {
            return this.success;
        }

        public final WriteFile copy(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "path");
            return new WriteFile(str, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WriteFile) {
                WriteFile writeFile = (WriteFile) obj;
                return Intrinsics.areEqual(this.path, writeFile.path) && this.success == writeFile.success;
            }
            return false;
        }

        public int hashCode() {
            return (this.path.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success);
        }

        public String toString() {
            String str = this.path;
            return "WriteFile(path=" + str + ", success=" + this.success + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WriteFile(String path, boolean success) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            this.path = path;
            this.success = success;
        }

        public final String getPath() {
            return this.path;
        }

        public final boolean getSuccess() {
            return this.success;
        }
    }

    /* compiled from: FilesLog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lvideo/base/files/FilesLog$RemoveFile;", "Lvideo/base/files/FilesLog;", "path", "", "success", "", "error", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getSuccess", "()Z", "getError", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class RemoveFile extends FilesLog {
        public static final int $stable = 0;
        private final String error;
        private final String path;
        private final boolean success;

        public static /* synthetic */ RemoveFile copy$default(RemoveFile removeFile, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = removeFile.path;
            }
            if ((i & 2) != 0) {
                z = removeFile.success;
            }
            if ((i & 4) != 0) {
                str2 = removeFile.error;
            }
            return removeFile.copy(str, z, str2);
        }

        public final String component1() {
            return this.path;
        }

        public final boolean component2() {
            return this.success;
        }

        public final String component3() {
            return this.error;
        }

        public final RemoveFile copy(String str, boolean z, String str2) {
            Intrinsics.checkNotNullParameter(str, "path");
            Intrinsics.checkNotNullParameter(str2, "error");
            return new RemoveFile(str, z, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoveFile) {
                RemoveFile removeFile = (RemoveFile) obj;
                return Intrinsics.areEqual(this.path, removeFile.path) && this.success == removeFile.success && Intrinsics.areEqual(this.error, removeFile.error);
            }
            return false;
        }

        public int hashCode() {
            return (((this.path.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success)) * 31) + this.error.hashCode();
        }

        public String toString() {
            String str = this.path;
            boolean z = this.success;
            return "RemoveFile(path=" + str + ", success=" + z + ", error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveFile(String path, boolean success, String error) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(error, "error");
            this.path = path;
            this.success = success;
            this.error = error;
        }

        public /* synthetic */ RemoveFile(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z, (i & 4) != 0 ? "" : str2);
        }

        public final String getPath() {
            return this.path;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final String getError() {
            return this.error;
        }
    }

    @Override // video.base.log.IVBLog
    public String getLogType() {
        return "Files";
    }
}