package tv.danmaku.android.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CpuUtils {
    private static final int EM_386 = 3;
    private static final int EM_AARCH64 = 183;
    private static final int EM_ARM = 40;
    private static final int EM_MIPS = 8;
    private static final int EM_X86_64 = 62;
    private static ARCH sArch = ARCH.Unknown;
    private static ARCH sArchRunning = ARCH.Unknown;
    private static Boolean srunAs64Bit = null;
    private static Boolean sIsX86 = null;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum ARCH {
        Unknown("unknown"),
        ARM("armeabi-v7a"),
        X86("x86"),
        MIPS("mips"),
        ARM64("arm64-v8a"),
        X86_64("x86_64");
        
        private String value;

        ARCH(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static boolean runAs64Bit() {
        if (srunAs64Bit != null) {
            return srunAs64Bit.booleanValue();
        }
        String[] supportedAbi = Build.SUPPORTED_64_BIT_ABIS;
        String targetAbi = Build.CPU_ABI;
        if (supportedAbi != null && supportedAbi.length > 0) {
            for (String idx : supportedAbi) {
                if (idx.contains(targetAbi)) {
                    srunAs64Bit = true;
                    return srunAs64Bit.booleanValue();
                }
            }
        }
        srunAs64Bit = false;
        return srunAs64Bit.booleanValue();
    }

    public static synchronized ARCH getMyCpuArch2(Context context) {
        synchronized (CpuUtils.class) {
            if (sArchRunning != ARCH.Unknown) {
                return sArchRunning;
            }
            File libDir = new File(context.getApplicationInfo().nativeLibraryDir);
            File[] files = libDir.listFiles(new FilenameFilter() { // from class: tv.danmaku.android.util.CpuUtils.1
                @Override // java.io.FilenameFilter
                public boolean accept(File dir, String name) {
                    if (!TextUtils.isEmpty(name) && name.endsWith(".so")) {
                        return true;
                    }
                    return false;
                }
            });
            if (files != null && files.length > 0) {
                sArchRunning = getMyCpuArchByFile(files[0]);
            } else {
                sArchRunning = getMyCpuArch();
            }
            return sArchRunning;
        }
    }

    public static synchronized ARCH getMyCpuArch() {
        synchronized (CpuUtils.class) {
            if (sArch != ARCH.Unknown) {
                return sArch;
            }
            boolean runAs64Bit = runAs64Bit();
            File libc = null;
            if (runAs64Bit) {
                File tmp = new File(Environment.getRootDirectory(), "lib64/libc.so");
                if (tmp.canRead()) {
                    libc = tmp;
                }
            }
            if (libc == null) {
                libc = new File(Environment.getRootDirectory(), "lib/libc.so");
            }
            sArch = getMyCpuArchByFile(libc.getAbsoluteFile());
            return sArch;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0062 A[Catch: all -> 0x0078, TryCatch #5 {, blocks: (B:5:0x0004, B:10:0x002e, B:13:0x0033, B:20:0x003f, B:27:0x004b, B:37:0x005c, B:38:0x005e, B:40:0x0062, B:41:0x0066, B:42:0x006a, B:43:0x006e, B:44:0x0072, B:8:0x000b, B:18:0x003a, B:25:0x0046), top: B:53:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0066 A[Catch: all -> 0x0078, TryCatch #5 {, blocks: (B:5:0x0004, B:10:0x002e, B:13:0x0033, B:20:0x003f, B:27:0x004b, B:37:0x005c, B:38:0x005e, B:40:0x0062, B:41:0x0066, B:42:0x006a, B:43:0x006e, B:44:0x0072, B:8:0x000b, B:18:0x003a, B:25:0x0046), top: B:53:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006a A[Catch: all -> 0x0078, TryCatch #5 {, blocks: (B:5:0x0004, B:10:0x002e, B:13:0x0033, B:20:0x003f, B:27:0x004b, B:37:0x005c, B:38:0x005e, B:40:0x0062, B:41:0x0066, B:42:0x006a, B:43:0x006e, B:44:0x0072, B:8:0x000b, B:18:0x003a, B:25:0x0046), top: B:53:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006e A[Catch: all -> 0x0078, TryCatch #5 {, blocks: (B:5:0x0004, B:10:0x002e, B:13:0x0033, B:20:0x003f, B:27:0x004b, B:37:0x005c, B:38:0x005e, B:40:0x0062, B:41:0x0066, B:42:0x006a, B:43:0x006e, B:44:0x0072, B:8:0x000b, B:18:0x003a, B:25:0x0046), top: B:53:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0072 A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #5 {, blocks: (B:5:0x0004, B:10:0x002e, B:13:0x0033, B:20:0x003f, B:27:0x004b, B:37:0x005c, B:38:0x005e, B:40:0x0062, B:41:0x0066, B:42:0x006a, B:43:0x006e, B:44:0x0072, B:8:0x000b, B:18:0x003a, B:25:0x0046), top: B:53:0x0004, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized ARCH getMyCpuArchByFile(File soFile) {
        ARCH result;
        synchronized (CpuUtils.class) {
            int machine = 0;
            if (soFile.canRead()) {
                RandomAccessFile fp = null;
                try {
                    fp = new RandomAccessFile(soFile, "r");
                    fp.seek(18L);
                    byte[] data = new byte[2];
                    fp.readFully(data);
                    machine = ((data[1] & 255) << 8) | (data[0] & 255);
                    try {
                        fp.close();
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        result = ARCH.Unknown;
                        switch (machine) {
                            case 3:
                                break;
                            case 8:
                                break;
                            case 40:
                                break;
                            case 62:
                                break;
                            case 183:
                                break;
                        }
                        return result;
                    }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    if (fp != null) {
                        try {
                            fp.close();
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                            result = ARCH.Unknown;
                            switch (machine) {
                                case 3:
                                    break;
                                case 8:
                                    break;
                                case 40:
                                    break;
                                case 62:
                                    break;
                                case 183:
                                    break;
                            }
                            return result;
                        }
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    if (fp != null) {
                        try {
                            fp.close();
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            result = ARCH.Unknown;
                            switch (machine) {
                                case 3:
                                    break;
                                case 8:
                                    break;
                                case 40:
                                    break;
                                case 62:
                                    break;
                                case 183:
                                    break;
                            }
                            return result;
                        }
                    }
                }
            }
            result = ARCH.Unknown;
            switch (machine) {
                case 3:
                    result = ARCH.X86;
                    break;
                case 8:
                    result = ARCH.MIPS;
                    break;
                case 40:
                    result = ARCH.ARM;
                    break;
                case 62:
                    result = ARCH.X86_64;
                    break;
                case 183:
                    result = ARCH.ARM64;
                    break;
            }
        }
        return result;
    }

    public static boolean isX86(Context context) {
        if (sIsX86 != null) {
            return sIsX86.booleanValue();
        }
        ARCH arch = getMyCpuArch2(context);
        sIsX86 = Boolean.valueOf(ARCH.X86 == arch || ARCH.X86_64 == arch);
        return sIsX86.booleanValue();
    }

    public static String getCpuName() {
        String cpuName;
        String hardWare = Build.HARDWARE;
        String socModel = "";
        if (!TextUtils.isEmpty(Build.HARDWARE)) {
            hardWare = Build.HARDWARE;
        }
        if (Build.VERSION.SDK_INT >= 31 && !TextUtils.isEmpty(Build.SOC_MODEL)) {
            socModel = Build.SOC_MODEL;
        }
        if (hardWare.length() >= socModel.length() && hardWare.toLowerCase().contains(socModel.toLowerCase())) {
            cpuName = hardWare;
        } else if (hardWare.length() < socModel.length() && socModel.toLowerCase().contains(hardWare.toLowerCase())) {
            cpuName = socModel;
        } else {
            cpuName = hardWare + " " + socModel;
        }
        return TextUtils.isEmpty(cpuName) ? CpuInfoKt.getCpuHardWare() : cpuName;
    }
}