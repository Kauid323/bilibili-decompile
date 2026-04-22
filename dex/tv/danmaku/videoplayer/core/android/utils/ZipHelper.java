package tv.danmaku.videoplayer.core.android.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipHelper {
    public static boolean unzipEntry(String zipFile, String entryName, String dest) {
        Throwable th;
        File destFile = new File(dest);
        File destDir = destFile.getParentFile();
        if (!destDir.isDirectory()) {
            destDir.delete();
            if (!destDir.mkdirs()) {
                return false;
            }
        }
        byte[] buffer = new byte[32768];
        ZipFile zf = null;
        InputStream zi = null;
        OutputStream os = null;
        long fileSize = -1;
        long writtenSize = 0;
        try {
            zf = new ZipFile(zipFile);
        } catch (IOException e) {
            e = e;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            ZipEntry ze = zf.getEntry(entryName);
            if (ze != null) {
                fileSize = ze.getSize();
                if (destFile.lastModified() == ze.getTime() && fileSize == destFile.length()) {
                    if (0 != 0) {
                        try {
                            os.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (0 != 0) {
                        try {
                            zi.close();
                        } catch (IOException e3) {
                        }
                    }
                    try {
                        zf.close();
                    } catch (IOException e4) {
                    }
                    return true;
                }
                zi = zf.getInputStream(ze);
                os = new FileOutputStream(dest);
                while (true) {
                    int n = zi.read(buffer);
                    if (n <= 0) {
                        break;
                    }
                    os.write(buffer, 0, n);
                    writtenSize += n;
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e5) {
                }
            }
            if (zi != null) {
                try {
                    zi.close();
                } catch (IOException e6) {
                }
            }
            try {
                zf.close();
            } catch (IOException e7) {
            }
            boolean ret = fileSize > 0 && fileSize == writtenSize;
            return ret ? destFile.setLastModified(0L) : ret;
        } catch (IOException e8) {
            e = e8;
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e9) {
                }
            }
            if (zi != null) {
                try {
                    zi.close();
                } catch (IOException e10) {
                }
            }
            if (zf != null) {
                try {
                    zf.close();
                    return false;
                } catch (IOException e11) {
                    return false;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e12) {
                }
            }
            if (zi != null) {
                try {
                    zi.close();
                } catch (IOException e13) {
                }
            }
            if (zf != null) {
                try {
                    zf.close();
                } catch (IOException e14) {
                }
            }
            throw th;
        }
    }
}