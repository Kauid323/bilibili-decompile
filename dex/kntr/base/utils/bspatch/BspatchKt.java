package kntr.base.utils.bspatch;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.FileMetadata;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;

/* compiled from: Bspatch.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"patch", "Lkotlin/Result;", "", "oldFilePath", "", "newFilePath", "patchFilePath", "overWrite", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;", "bspatch_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BspatchKt {
    public static /* synthetic */ Object patch$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return patch(str, str2, str3, z);
    }

    public static final Object patch(String oldFilePath, String newFilePath, String patchFilePath, boolean overWrite) {
        Intrinsics.checkNotNullParameter(oldFilePath, "oldFilePath");
        Intrinsics.checkNotNullParameter(newFilePath, "newFilePath");
        Intrinsics.checkNotNullParameter(patchFilePath, "patchFilePath");
        try {
            FileSystem fs = FileSystemJvmKt.SystemFileSystem;
            boolean z = true;
            if (!(oldFilePath.length() == 0)) {
                if (!(newFilePath.length() == 0)) {
                    if (!(patchFilePath.length() == 0)) {
                        if (!fs.exists(PathsJvmKt.Path(oldFilePath))) {
                            throw new IllegalArgumentException(oldFilePath + " not exists.");
                        }
                        if (!fs.exists(PathsJvmKt.Path(patchFilePath))) {
                            throw new IllegalArgumentException(patchFilePath + " not exists.");
                        }
                        Path targetPath = PathsJvmKt.Path(newFilePath);
                        if (fs.exists(targetPath)) {
                            if (!overWrite) {
                                throw new IllegalArgumentException(targetPath + " exists but overWrite is false.");
                            }
                            fs.delete(targetPath, false);
                        } else {
                            Path targetDir = targetPath.getParent();
                            if (targetDir != null) {
                                FileMetadata metadataOrNull = fs.metadataOrNull(targetDir);
                                if (metadataOrNull == null || !metadataOrNull.isRegularFile()) {
                                    z = false;
                                }
                                if (!z) {
                                    fs.createDirectories(targetDir, false);
                                }
                            }
                            throw new IllegalArgumentException(targetPath + " parent directory is invalid.");
                        }
                        int code = Bspatch_androidKt.patchNative(oldFilePath, newFilePath, patchFilePath);
                        if (code != 0) {
                            throw new IllegalStateException("patchNative code = " + code);
                        }
                        Result.Companion companion = Result.Companion;
                        return Result.m2636constructorimpl(Unit.INSTANCE);
                    }
                }
            }
            throw new IllegalArgumentException("has filepath empty file path.");
        } catch (Exception e) {
            Result.Companion companion2 = Result.Companion;
            return Result.m2636constructorimpl(ResultKt.createFailure(new IllegalStateException("patch error " + e.getMessage(), e)));
        }
    }
}