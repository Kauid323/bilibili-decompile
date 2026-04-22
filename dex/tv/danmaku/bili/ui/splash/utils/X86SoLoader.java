package tv.danmaku.bili.ui.splash.utils;

import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.mod.SplashModHelperKt;

public class X86SoLoader {
    public static void installNativeLibraryPath(ClassLoader classLoader, File folder) throws Throwable {
        if (folder != null && folder.exists()) {
            if ((Build.VERSION.SDK_INT != 25 || Build.VERSION.PREVIEW_SDK_INT == 0) && Build.VERSION.SDK_INT <= 25) {
                try {
                    V23.install(classLoader, folder);
                    return;
                } catch (Throwable th) {
                    V14.install(classLoader, folder);
                    return;
                }
            }
            try {
                V25.install(classLoader, folder);
                return;
            } catch (Throwable th2) {
                V23.install(classLoader, folder);
                return;
            }
        }
        BLog.e(SplashModHelperKt.TAG, "so folder doesn't exist");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class V25 {
        private V25() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File folder) throws Throwable {
            Field pathListField = X86SoLoader.findField(classLoader, "pathList");
            Object dexPathList = pathListField.get(classLoader);
            Field nativeLibraryDirectories = X86SoLoader.findField(dexPathList, "nativeLibraryDirectories");
            List<File> origLibDirs = (List) nativeLibraryDirectories.get(dexPathList);
            if (origLibDirs == null) {
                origLibDirs = new ArrayList<>(2);
            }
            Iterator libDirIt = origLibDirs.iterator();
            while (true) {
                if (!libDirIt.hasNext()) {
                    break;
                }
                File libDir = libDirIt.next();
                if (folder.equals(libDir)) {
                    libDirIt.remove();
                    break;
                }
            }
            origLibDirs.add(0, folder);
            Field systemNativeLibraryDirectories = X86SoLoader.findField(dexPathList, "systemNativeLibraryDirectories");
            List<File> origSystemLibDirs = (List) systemNativeLibraryDirectories.get(dexPathList);
            if (origSystemLibDirs == null) {
                origSystemLibDirs = new ArrayList<>(2);
            }
            List<File> newLibDirs = new ArrayList<>(origLibDirs.size() + origSystemLibDirs.size() + 1);
            newLibDirs.addAll(origLibDirs);
            newLibDirs.addAll(origSystemLibDirs);
            Method makeElements = X86SoLoader.findMethod(dexPathList, "makePathElements", List.class);
            Object[] elements = (Object[]) makeElements.invoke(dexPathList, newLibDirs);
            Field nativeLibraryPathElements = X86SoLoader.findField(dexPathList, "nativeLibraryPathElements");
            nativeLibraryPathElements.set(dexPathList, elements);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class V23 {
        private V23() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File folder) throws Throwable {
            Field pathListField = X86SoLoader.findField(classLoader, "pathList");
            Object dexPathList = pathListField.get(classLoader);
            Field nativeLibraryDirectories = X86SoLoader.findField(dexPathList, "nativeLibraryDirectories");
            List<File> origLibDirs = (List) nativeLibraryDirectories.get(dexPathList);
            if (origLibDirs == null) {
                origLibDirs = new ArrayList<>(2);
            }
            Iterator libDirIt = origLibDirs.iterator();
            while (true) {
                if (!libDirIt.hasNext()) {
                    break;
                }
                File libDir = libDirIt.next();
                if (folder.equals(libDir)) {
                    libDirIt.remove();
                    break;
                }
            }
            origLibDirs.add(0, folder);
            Field systemNativeLibraryDirectories = X86SoLoader.findField(dexPathList, "systemNativeLibraryDirectories");
            List<File> origSystemLibDirs = (List) systemNativeLibraryDirectories.get(dexPathList);
            if (origSystemLibDirs == null) {
                origSystemLibDirs = new ArrayList<>(2);
            }
            List<File> newLibDirs = new ArrayList<>(origLibDirs.size() + origSystemLibDirs.size() + 1);
            newLibDirs.addAll(origLibDirs);
            newLibDirs.addAll(origSystemLibDirs);
            Method makeElements = X86SoLoader.findMethod(dexPathList, "makePathElements", List.class, File.class, List.class);
            ArrayList<IOException> suppressedExceptions = new ArrayList<>();
            Object[] elements = (Object[]) makeElements.invoke(dexPathList, newLibDirs, null, suppressedExceptions);
            Field nativeLibraryPathElements = X86SoLoader.findField(dexPathList, "nativeLibraryPathElements");
            nativeLibraryPathElements.set(dexPathList, elements);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class V14 {
        private V14() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File folder) throws Throwable {
            Field pathListField = X86SoLoader.findField(classLoader, "pathList");
            Object dexPathList = pathListField.get(classLoader);
            Field nativeLibDirField = X86SoLoader.findField(dexPathList, "nativeLibraryDirectories");
            File[] origNativeLibDirs = (File[]) nativeLibDirField.get(dexPathList);
            List<File> newNativeLibDirList = new ArrayList<>(origNativeLibDirs.length + 1);
            newNativeLibDirList.add(folder);
            for (File origNativeLibDir : origNativeLibDirs) {
                if (!folder.equals(origNativeLibDir)) {
                    newNativeLibDirList.add(origNativeLibDir);
                }
            }
            nativeLibDirField.set(dexPathList, newNativeLibDirList.toArray(new File[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field findField(Object instance, String name) throws NoSuchFieldException {
        for (Class clazz = instance.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Field field = clazz.getDeclaredField(name);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException("Field " + name + " not found in " + instance.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method findMethod(Object instance, String name, Class... parameterTypes) throws NoSuchMethodException {
        for (Class clazz = instance.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Method method = clazz.getDeclaredMethod(name, parameterTypes);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException("Method " + name + " with parameters " + Arrays.asList(parameterTypes) + " not found in " + instance.getClass());
    }
}