package de.robv.android.xposed.services;

import java.io.IOException;
import java.util.Arrays;

public final class ZygoteService extends BaseService {
    @Override // de.robv.android.xposed.services.BaseService
    public native boolean checkFileAccess(String str, int i2);

    @Override // de.robv.android.xposed.services.BaseService
    public native byte[] readFile(String str) throws IOException;

    @Override // de.robv.android.xposed.services.BaseService
    public native FileResult statFile(String str) throws IOException;

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String filename, long previousSize, long previousTime) throws IOException {
        FileResult stat = statFile(filename);
        if (previousSize == stat.size && previousTime == stat.mtime) {
            return stat;
        }
        return new FileResult(readFile(filename), stat.size, stat.mtime);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String filename, int offset, int length, long previousSize, long previousTime) throws IOException {
        int offset2 = offset;
        int length2 = length;
        FileResult stat = statFile(filename);
        if (previousSize == stat.size && previousTime == stat.mtime) {
            return stat;
        }
        if (offset2 > 0 || length2 > 0) {
            if (offset2 > 0 && offset2 >= stat.size) {
                throw new IllegalArgumentException("offset " + offset + " >= size " + stat.size + " for " + filename);
            }
            if (offset2 < 0) {
                offset2 = 0;
            }
            if (length2 > 0 && offset2 + length2 > stat.size) {
                throw new IllegalArgumentException("offset " + offset2 + " + length " + length + " > size " + stat.size + " for " + filename);
            }
            if (length2 <= 0) {
                length2 = (int) (stat.size - offset2);
            }
            byte[] content = readFile(filename);
            return new FileResult(Arrays.copyOfRange(content, offset2, offset2 + length2), stat.size, stat.mtime);
        }
        return new FileResult(readFile(filename), stat.size, stat.mtime);
    }
}