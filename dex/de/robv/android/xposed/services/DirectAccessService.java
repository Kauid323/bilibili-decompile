package de.robv.android.xposed.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DirectAccessService extends BaseService {
    @Override // de.robv.android.xposed.services.BaseService
    public boolean hasDirectFileAccess() {
        return true;
    }

    @Override // de.robv.android.xposed.services.BaseService
    public boolean checkFileAccess(String filename, int mode) {
        File file = new File(filename);
        if (mode == 0 && !file.exists()) {
            return false;
        }
        if ((mode & 4) != 0 && !file.canRead()) {
            return false;
        }
        if ((mode & 2) != 0 && !file.canWrite()) {
            return false;
        }
        if ((mode & 1) != 0 && !file.canExecute()) {
            return false;
        }
        return true;
    }

    @Override // de.robv.android.xposed.services.BaseService
    public boolean checkFileExists(String filename) {
        return new File(filename).exists();
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult statFile(String filename) throws IOException {
        File file = new File(filename);
        return new FileResult(file.length(), file.lastModified());
    }

    @Override // de.robv.android.xposed.services.BaseService
    public byte[] readFile(String filename) throws IOException {
        File file = new File(filename);
        byte[] content = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(content);
        fis.close();
        return content;
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String filename, long previousSize, long previousTime) throws IOException {
        File file = new File(filename);
        long size = file.length();
        long time = file.lastModified();
        if (previousSize == size && previousTime == time) {
            return new FileResult(size, time);
        }
        return new FileResult(readFile(filename), size, time);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String filename, int offset, int length, long previousSize, long previousTime) throws IOException {
        int offset2 = offset;
        int length2 = length;
        File file = new File(filename);
        long size = file.length();
        long time = file.lastModified();
        if (previousSize == size && previousTime == time) {
            return new FileResult(size, time);
        }
        if (offset2 > 0 || length2 > 0) {
            if (offset2 > 0 && offset2 >= size) {
                throw new IllegalArgumentException("Offset " + offset2 + " is out of range for " + filename);
            }
            if (offset2 < 0) {
                offset2 = 0;
            }
            if (length2 > 0 && offset2 + length2 > size) {
                throw new IllegalArgumentException("Length " + length2 + " is out of range for " + filename);
            }
            if (length2 <= 0) {
                length2 = (int) (size - offset2);
            }
            byte[] content = new byte[length2];
            FileInputStream fis = new FileInputStream(file);
            fis.skip(offset2);
            fis.read(content);
            fis.close();
            return new FileResult(content, size, time);
        }
        return new FileResult(readFile(filename), size, time);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public InputStream getFileInputStream(String filename) throws IOException {
        return new BufferedInputStream(new FileInputStream(filename), 16384);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult getFileInputStream(String filename, long previousSize, long previousTime) throws IOException {
        File file = new File(filename);
        long size = file.length();
        long time = file.lastModified();
        if (previousSize == size && previousTime == time) {
            return new FileResult(size, time);
        }
        return new FileResult(new BufferedInputStream(new FileInputStream(filename), 16384), size, time);
    }
}