package tv.danmaku.bili.update.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class FileUtils {
    public static String md5(File file) {
        DigestInputStream dis = null;
        try {
            try {
                dis = new DigestInputStream(new FileInputStream(file), MessageDigest.getInstance("MD5"));
                byte[] buffer = new byte[4096];
                while (dis.read(buffer) != -1) {
                }
                return ArrayExtsKt.toHexString(dis.getMessageDigest().digest());
            } catch (Exception var7) {
                var7.printStackTrace();
                IOUtils.closeQuietly(dis);
                return "";
            }
        } finally {
            IOUtils.closeQuietly(dis);
        }
    }

    public static void moveFile(File srcFile, File destFile) throws IOException {
        if (srcFile == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (destFile == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!srcFile.exists()) {
            throw new FileNotFoundException("Source '" + srcFile + "' does not exist");
        }
        if (srcFile.isDirectory()) {
            throw new IOException("Source '" + srcFile + "' is a directory");
        }
        if (destFile.exists()) {
            throw new IOException("Destination '" + destFile + "' already exists");
        }
        if (destFile.isDirectory()) {
            throw new IOException("Destination '" + destFile + "' is a directory");
        }
        boolean rename = srcFile.renameTo(destFile);
        if (!rename) {
            copyFile(srcFile, destFile);
            if (!srcFile.delete()) {
                deleteQuietly(destFile);
                throw new IOException("Failed to delete original file '" + srcFile + "' after copy to '" + destFile + "'");
            }
        }
    }

    public static boolean copyFile(File srcFile, File destFile) {
        try {
            InputStream in = new FileInputStream(srcFile);
            boolean result = copyToFile(in, destFile);
            in.close();
            return result;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean copyToFile(InputStream inputStream, File destFile) {
        boolean z = false;
        try {
            if (destFile.exists()) {
                destFile.delete();
            } else {
                File parentFile = destFile.getParentFile();
                if (parentFile == null) {
                    return false;
                }
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                } else if (!parentFile.isDirectory()) {
                    return false;
                }
                destFile.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(destFile);
            byte[] buffer = new byte[4096];
            while (true) {
                int bytesRead = inputStream.read(buffer);
                if (bytesRead < 0) {
                    break;
                }
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            try {
                out.getFD().sync();
            } catch (IOException e) {
            }
            out.close();
            z = true;
            return true;
        } catch (IOException e2) {
            return z;
        }
    }

    public static boolean deleteQuietly(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                deleteDirectory(file);
            }
        } catch (Exception e) {
        }
        try {
            return file.delete();
        } catch (Exception e2) {
            return false;
        }
    }

    public static void deleteDirectory(File directory) throws IOException {
        deleteDirectory(directory, true);
    }

    public static void deleteDirectory(File dir, boolean removeDir) {
        if (dir != null && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file, removeDir);
                    } else {
                        file.delete();
                    }
                }
            }
            if (removeDir) {
                dir.delete();
            }
        }
    }

    public static void cleanDirectory(File directory) throws IOException {
        if (!directory.exists()) {
            String message = directory + " does not exist";
            throw new IllegalArgumentException(message);
        } else if (!directory.isDirectory()) {
            String message2 = directory + " is not a directory";
            throw new IllegalArgumentException(message2);
        } else {
            File[] files = directory.listFiles();
            if (files == null) {
                throw new IOException("Failed to list contents of " + directory);
            }
            IOException exception = null;
            for (File file : files) {
                try {
                    forceDelete(file);
                } catch (IOException ioe) {
                    exception = ioe;
                }
            }
            if (exception != null) {
                throw exception;
            }
        }
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean filePresent = file.exists();
        if (!file.delete()) {
            if (!filePresent) {
                throw new FileNotFoundException("File does not exist: " + file);
            }
            String message = "Unable to delete file: " + file;
            throw new IOException(message);
        }
    }
}