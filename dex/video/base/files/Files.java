package video.base.files;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.FileMetadata;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Files.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lvideo/base/files/Files;", "", "<init>", "()V", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Files {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: Files.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lvideo/base/files/Files$Companion;", "", "<init>", "()V", "recursivelyDelete", "", "path", "Lkotlinx/io/files/Path;", "getFolderSizeAtPath", "", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void recursivelyDelete(Path path) {
            Intrinsics.checkNotNullParameter(path, "path");
            FileMetadata metadata = FileSystemJvmKt.SystemFileSystem.metadataOrNull(path);
            if (metadata != null) {
                if (metadata.isDirectory()) {
                    Iterable $this$forEach$iv = FileSystemJvmKt.SystemFileSystem.list(path);
                    for (Object element$iv : $this$forEach$iv) {
                        Path it = (Path) element$iv;
                        Files.Companion.recursivelyDelete(it);
                    }
                    return;
                }
                FileSystemJvmKt.SystemFileSystem.delete(path, false);
            }
        }

        public final long getFolderSizeAtPath(Path path) {
            long j;
            Intrinsics.checkNotNullParameter(path, "path");
            FileMetadata metadata = FileSystemJvmKt.SystemFileSystem.metadataOrNull(path);
            if (metadata != null) {
                if (metadata.isDirectory()) {
                    long j2 = 0;
                    for (Path it : FileSystemJvmKt.SystemFileSystem.list(path)) {
                        FileMetadata metadata2 = FileSystemJvmKt.SystemFileSystem.metadataOrNull(it);
                        if (metadata2 != null) {
                            if (metadata2.isDirectory()) {
                                j = Files.Companion.getFolderSizeAtPath(it);
                            } else {
                                j = metadata2.getSize();
                            }
                        } else {
                            j = 0;
                        }
                        j2 += j;
                    }
                    return j2;
                }
                return metadata.getSize();
            }
            return 0L;
        }
    }
}