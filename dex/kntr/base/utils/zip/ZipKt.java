package kntr.base.utils.zip;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;

/* compiled from: Zip.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t\u001a+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"zip", "Lkotlin/Result;", "", "inputPaths", "", "", "outputZipPath", "overWrite", "", "(Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/Object;", "unzip", "zipFilePath", "targetDirectory", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;", "zip_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ZipKt {
    public static /* synthetic */ Object zip$default(List list, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return zip(list, str, z);
    }

    public static final Object zip(List<String> list, String outputZipPath, boolean overWrite) {
        Intrinsics.checkNotNullParameter(list, "inputPaths");
        Intrinsics.checkNotNullParameter(outputZipPath, "outputZipPath");
        try {
            if (list.isEmpty() || StringsKt.isBlank(outputZipPath)) {
                throw new IllegalArgumentException("params is invalid.");
            }
            FileSystem fs = FileSystemJvmKt.SystemFileSystem;
            FileAttr outputFile = UtilsKt.getFileAttr(fs, outputZipPath);
            if (outputFile.getExists()) {
                if (!overWrite) {
                    throw new IllegalArgumentException(outputZipPath + " exists but overWrite is false.");
                }
                FileSystem.-CC.delete$default(fs, outputFile.getPath(), false, 2, (Object) null);
            } else {
                FileAttr outputDir = outputFile.parent();
                if (outputDir == null) {
                    throw new IllegalArgumentException(outputZipPath + " parent is null.");
                }
                if (outputDir.getExists() && !outputDir.isDirectory()) {
                    throw new IllegalArgumentException(outputZipPath + " parent is not directory.");
                }
                if (!outputDir.getExists()) {
                    fs.createDirectories(outputDir.getPath(), true);
                }
            }
            Zip_androidKt.mZip(list, outputZipPath);
            Result.Companion companion = Result.Companion;
            return Result.m2636constructorimpl(Unit.INSTANCE);
        } catch (Exception e) {
            Result.Companion companion2 = Result.Companion;
            return Result.m2636constructorimpl(ResultKt.createFailure(new IllegalStateException("compress has exception " + e.getMessage(), e)));
        }
    }

    public static /* synthetic */ Object unzip$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return unzip(str, str2, z);
    }

    public static final Object unzip(String zipFilePath, String targetDirectory, boolean overWrite) {
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter(targetDirectory, "targetDirectory");
        try {
            FileSystem fs = FileSystemJvmKt.SystemFileSystem;
            FileAttr zipFile = UtilsKt.getFileAttr(fs, zipFilePath);
            if (StringsKt.isBlank(zipFilePath) || StringsKt.isBlank(targetDirectory)) {
                throw new IllegalArgumentException("params is invalid.");
            }
            if (!zipFile.getExists()) {
                throw new IllegalArgumentException("zip file " + zipFilePath + " not exits.");
            }
            FileAttr targetAttr = UtilsKt.getFileAttr(fs, targetDirectory);
            if (!targetAttr.getExists()) {
                fs.createDirectories(targetAttr.getPath(), true);
            }
            Zip_androidKt.mUnzip(zipFilePath, targetDirectory, overWrite);
            Result.Companion companion = Result.Companion;
            return Result.m2636constructorimpl(Unit.INSTANCE);
        } catch (Exception e) {
            Result.Companion companion2 = Result.Companion;
            return Result.m2636constructorimpl(ResultKt.createFailure(new IllegalStateException("decompress fail " + e.getMessage(), e)));
        }
    }
}