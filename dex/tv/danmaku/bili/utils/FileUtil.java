package tv.danmaku.bili.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import tv.danmaku.android.log.BLog;

public class FileUtil {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;
    static final String FILES_PATH = "Compressor";
    private static final String TAG = "FileUtil";

    private FileUtil() {
    }

    public static File from(Context context, Uri uri) throws IOException {
        InputStream inputStream = context.getContentResolver().openInputStream(uri);
        String fileName = getFileName(context, uri);
        String[] splitName = splitFileName(fileName);
        File tempFile = rename(File.createTempFile(splitName[0], splitName[1]), fileName);
        tempFile.deleteOnExit();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(tempFile);
        } catch (FileNotFoundException e) {
            BLog.d(TAG, "file not found", e);
        }
        if (inputStream != null && out != null) {
            copy(inputStream, out);
            inputStream.close();
        }
        if (out != null) {
            out.close();
        }
        return tempFile;
    }

    static String[] splitFileName(String fileName) {
        String name = fileName;
        String extension = "";
        int i = fileName.lastIndexOf(".");
        if (i != -1) {
            name = fileName.substring(0, i);
            if (name.length() < 3) {
                name = "temp_" + name;
            }
            extension = fileName.substring(i);
        }
        return new String[]{name, extension};
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r1 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static String getFileName(Context context, Uri uri) {
        int index;
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst() && (index = cursor.getColumnIndex("_display_name")) >= 0) {
                            result = cursor.getString(index);
                        }
                    } catch (Exception e) {
                        BLog.d(TAG, "get file name by uri error", e);
                    }
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (result == null) {
            String result2 = uri.getPath();
            int cut = result2.lastIndexOf(File.separator);
            return cut != -1 ? result2.substring(cut + 1) : result2;
        }
        return result;
    }

    static File rename(File file, String newName) {
        File newFile = new File(file.getParent(), newName);
        if (!newFile.equals(file)) {
            if (newFile.exists() && newFile.delete()) {
                Log.d(TAG, "Delete old " + newName + " file");
            }
            if (file.renameTo(newFile)) {
                Log.d(TAG, "Rename file to " + newName);
            }
        }
        return newFile;
    }

    static int copy(InputStream input, OutputStream output) throws IOException {
        long count = copyLarge(input, output);
        if (count > 2147483647L) {
            return -1;
        }
        return (int) count;
    }

    static long copyLarge(InputStream input, OutputStream output) throws IOException {
        return copyLarge(input, output, new byte[DEFAULT_BUFFER_SIZE]);
    }

    static long copyLarge(InputStream input, OutputStream output, byte[] buffer) throws IOException {
        long count = 0;
        while (true) {
            int n = input.read(buffer);
            if (-1 != n) {
                output.write(buffer, 0, n);
                count += n;
            } else {
                return count;
            }
        }
    }
}