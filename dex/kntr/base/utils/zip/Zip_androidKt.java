package kntr.base.utils.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Zip.android.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¨\u0006\u0011"}, d2 = {"mZip", "", "inputPaths", "", "", "outputZipPath", "addFileToZip", "file", "Ljava/io/File;", "zipPath", "zipOut", "Ljava/util/zip/ZipOutputStream;", "mUnzip", "zipFilePath", "targetDirectory", "overWrite", "", "zip_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Zip_androidKt {
    public static final void mZip(List<String> list, String outputZipPath) {
        Intrinsics.checkNotNullParameter(list, "inputPaths");
        Intrinsics.checkNotNullParameter(outputZipPath, "outputZipPath");
        File outputFile = new File(outputZipPath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile)));
        try {
            ZipOutputStream zipOut = zipOutputStream;
            for (String pathStr : list) {
                File file = new File(pathStr);
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                addFileToZip(file, name, zipOut);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipOutputStream, (Throwable) null);
        } finally {
        }
    }

    private static final void addFileToZip(File file, String zipPath, ZipOutputStream zipOut) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                boolean z = true;
                if (children != null) {
                    if (!(children.length == 0)) {
                        z = false;
                    }
                }
                if (z) {
                    String entryName = StringsKt.endsWith$default(zipPath, "/", false, 2, (Object) null) ? zipPath : zipPath + "/";
                    zipOut.putNextEntry(new ZipEntry(entryName));
                    zipOut.closeEntry();
                    return;
                }
                for (File child : children) {
                    Intrinsics.checkNotNull(child);
                    addFileToZip(child, zipPath + "/" + child.getName(), zipOut);
                }
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileInputStream fis = fileInputStream;
                zipOut.putNextEntry(new ZipEntry(zipPath));
                ByteStreamsKt.copyTo$default(fis, zipOut, 0, 2, (Object) null);
                zipOut.closeEntry();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStream, (Throwable) null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileInputStream, th);
                    throw th2;
                }
            }
        }
    }

    public static final void mUnzip(String zipFilePath, String targetDirectory, boolean overWrite) {
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter(targetDirectory, "targetDirectory");
        File zipFile = new File(zipFilePath);
        File target = new File(targetDirectory);
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
        try {
            ZipInputStream zipIn = zipInputStream;
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                File outFile = new File(target, entry.getName());
                if (entry.isDirectory()) {
                    outFile.mkdirs();
                } else if (outFile.exists() && !overWrite) {
                    zipIn.closeEntry();
                    entry = zipIn.getNextEntry();
                } else {
                    File parentFile = outFile.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(outFile);
                    FileOutputStream fos = fileOutputStream;
                    Long.valueOf(ByteStreamsKt.copyTo$default(zipIn, fos, 0, 2, (Object) null));
                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipInputStream, (Throwable) null);
        } finally {
        }
    }
}