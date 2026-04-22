package de.robv.android.xposed.services;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public abstract class BaseService {
    public static final int F_OK = 0;
    public static final int R_OK = 4;
    public static final int W_OK = 2;
    public static final int X_OK = 1;

    public abstract boolean checkFileAccess(String str, int i2);

    public abstract FileResult readFile(String str, int i2, int i3, long j, long j2) throws IOException;

    public abstract FileResult readFile(String str, long j, long j2) throws IOException;

    public abstract byte[] readFile(String str) throws IOException;

    public abstract FileResult statFile(String str) throws IOException;

    public boolean hasDirectFileAccess() {
        return false;
    }

    public boolean checkFileExists(String filename) {
        return checkFileAccess(filename, 0);
    }

    public long getFileSize(String filename) throws IOException {
        return statFile(filename).size;
    }

    public long getFileModificationTime(String filename) throws IOException {
        return statFile(filename).mtime;
    }

    public InputStream getFileInputStream(String filename) throws IOException {
        return new ByteArrayInputStream(readFile(filename));
    }

    public FileResult getFileInputStream(String filename, long previousSize, long previousTime) throws IOException {
        FileResult result = readFile(filename, previousSize, previousTime);
        if (result.content == null) {
            return result;
        }
        return new FileResult(new ByteArrayInputStream(result.content), result.size, result.mtime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ensureAbsolutePath(String filename) {
        if (!filename.startsWith("/")) {
            throw new IllegalArgumentException("Only absolute filenames are allowed: " + filename);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwCommonIOException(int errno, String errorMsg, String filename, String defaultText) throws IOException {
        switch (errno) {
            case 1:
            case 13:
                throw new FileNotFoundException(errorMsg != null ? errorMsg : "Permission denied: " + filename);
            case 2:
                throw new FileNotFoundException(errorMsg != null ? errorMsg : "No such file or directory: " + filename);
            case 12:
                throw new OutOfMemoryError(errorMsg);
            case 21:
                throw new FileNotFoundException(errorMsg != null ? errorMsg : "Is a directory: " + filename);
            default:
                throw new IOException(errorMsg != null ? errorMsg : "Error " + errno + defaultText + filename);
        }
    }
}