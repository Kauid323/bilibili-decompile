package de.robv.android.xposed;

import android.app.ActivityThread;
import android.app.AndroidAppHelper;
import android.app.Application;
import android.app.LoadedApk;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XResources;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;
import com.android.internal.os.ZygoteInit;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import de.robv.android.xposed.IXposedHookCmdInit;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XCallback;
import de.robv.android.xposed.services.BaseService;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
public final class XposedInit {
    private static final String BASE_DIR;
    private static final String INSTALLER_PACKAGE_NAME = "de.robv.android.xposed.installer";
    private static final String INSTANT_RUN_CLASS = "com.android.tools.fd.runtime.BootstrapApplication";
    private static final String TAG = "Xposed";
    private static final String[] XRESOURCES_CONFLICTING_PACKAGES;
    private static boolean disableResources;
    private static final boolean startsSystemServer = XposedBridge.startsSystemServer();
    private static final String startClassName = XposedBridge.getStartClassName();

    static {
        BASE_DIR = Build.VERSION.SDK_INT >= 24 ? "/data/user_de/0/de.robv.android.xposed.installer/" : "/data/data/de.robv.android.xposed.installer/";
        disableResources = false;
        XRESOURCES_CONFLICTING_PACKAGES = new String[]{"com.sygic.aura"};
    }

    private XposedInit() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initForZygote() throws Throwable {
        if (needsToCloseFilesForFork()) {
            XC_MethodHook callback = new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    XposedBridge.closeFilesBeforeForkNative();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    XposedBridge.reopenFilesAfterForkNative();
                }
            };
            Class<?> zygote = XposedHelpers.findClass("com.android.internal.os.Zygote", null);
            XposedBridge.hookAllMethods(zygote, "nativeForkAndSpecialize", callback);
            XposedBridge.hookAllMethods(zygote, "nativeForkSystemServer", callback);
        }
        final HashSet<String> loadedPackagesInProcess = new HashSet<>(1);
        XposedHelpers.findAndHookMethod(ActivityThread.class, "handleBindApplication", "android.app.ActivityThread.AppBindData", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // de.robv.android.xposed.XC_MethodHook
            public void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                ActivityThread activityThread = (ActivityThread) param.thisObject;
                ApplicationInfo appInfo = (ApplicationInfo) XposedHelpers.getObjectField(param.args[0], "appInfo");
                String reportedPackageName = appInfo.packageName.equals("android") ? "system" : appInfo.packageName;
                SELinuxHelper.initForProcess(reportedPackageName);
                ComponentName instrumentationName = (ComponentName) XposedHelpers.getObjectField(param.args[0], "instrumentationName");
                if (instrumentationName != null) {
                    Log.w("Xposed", "Instrumentation detected, disabling framework for " + reportedPackageName);
                    XposedBridge.disableHooks = true;
                    return;
                }
                CompatibilityInfo compatInfo = (CompatibilityInfo) XposedHelpers.getObjectField(param.args[0], "compatInfo");
                if (appInfo.sourceDir == null) {
                    return;
                }
                XposedHelpers.setObjectField(activityThread, "mBoundApplication", param.args[0]);
                loadedPackagesInProcess.add(reportedPackageName);
                LoadedApk loadedApk = activityThread.getPackageInfoNoCheck(appInfo, compatInfo);
                XResources.setPackageNameForResDir(appInfo.packageName, loadedApk.getResDir());
                XC_LoadPackage.LoadPackageParam lpparam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
                lpparam.packageName = reportedPackageName;
                lpparam.processName = (String) XposedHelpers.getObjectField(param.args[0], "processName");
                lpparam.classLoader = loadedApk.getClassLoader();
                lpparam.appInfo = appInfo;
                lpparam.isFirstApplication = true;
                XC_LoadPackage.callAll(lpparam);
                if (reportedPackageName.equals(XposedInit.INSTALLER_PACKAGE_NAME)) {
                    XposedInit.hookXposedInstaller(lpparam.classLoader);
                }
            }
        });
        if (startsSystemServer) {
            XposedHelpers.findAndHookMethod(ActivityThread.class, "systemMain", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    final ClassLoader cl = Thread.currentThread().getContextClassLoader();
                    XposedHelpers.findAndHookMethod("com.android.server.SystemServer", cl, "startBootstrapServices", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.4.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // de.robv.android.xposed.XC_MethodHook
                        public void beforeHookedMethod(XC_MethodHook.MethodHookParam param2) throws Throwable {
                            SELinuxHelper.initForProcess("android");
                            loadedPackagesInProcess.add("android");
                            XC_LoadPackage.LoadPackageParam lpparam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
                            lpparam.packageName = "android";
                            lpparam.processName = "android";
                            lpparam.classLoader = cl;
                            lpparam.appInfo = null;
                            lpparam.isFirstApplication = true;
                            XC_LoadPackage.callAll(lpparam);
                            try {
                                XposedHelpers.findAndHookMethod("com.android.server.pm.HwPackageManagerService", cl, "isOdexMode", XC_MethodReplacement.returnConstant(false));
                            } catch (XposedHelpers.ClassNotFoundError e2) {
                            } catch (NoSuchMethodError e3) {
                            }
                            try {
                                String className = "com.android.server.pm.PackageDexOptimizer";
                                XposedHelpers.findAndHookMethod(className, cl, "dexEntryExists", String.class, XC_MethodReplacement.returnConstant(true));
                            } catch (XposedHelpers.ClassNotFoundError e4) {
                            } catch (NoSuchMethodError e5) {
                            }
                        }
                    });
                }
            });
        }
        XposedBridge.hookAllConstructors(LoadedApk.class, new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // de.robv.android.xposed.XC_MethodHook
            public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                LoadedApk loadedApk = (LoadedApk) param.thisObject;
                String packageName = loadedApk.getPackageName();
                XResources.setPackageNameForResDir(packageName, loadedApk.getResDir());
                if (packageName.equals("android") || !loadedPackagesInProcess.add(packageName) || !XposedHelpers.getBooleanField(loadedApk, "mIncludeCode")) {
                    return;
                }
                XC_LoadPackage.LoadPackageParam lpparam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
                lpparam.packageName = packageName;
                lpparam.processName = AndroidAppHelper.currentProcessName();
                lpparam.classLoader = loadedApk.getClassLoader();
                lpparam.appInfo = loadedApk.getApplicationInfo();
                lpparam.isFirstApplication = false;
                XC_LoadPackage.callAll(lpparam);
            }
        });
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager", null, "getResourcesForApplication", ApplicationInfo.class, new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // de.robv.android.xposed.XC_MethodHook
            public void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                ApplicationInfo app = (ApplicationInfo) param.args[0];
                XResources.setPackageNameForResDir(app.packageName, app.uid == Process.myUid() ? app.sourceDir : app.publicSourceDir);
            }
        });
        if (XposedHelpers.findFieldIfExists(ZygoteInit.class, "BOOT_START_TIME") != null) {
            XposedHelpers.setStaticLongField(ZygoteInit.class, "BOOT_START_TIME", XposedBridge.BOOT_START_TIME);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                XposedHelpers.setStaticBooleanField(XposedHelpers.findClass("com.android.internal.os.Zygote", null), "isEnhancedZygoteASLREnabled", false);
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: de.robv.android.xposed.XposedInit$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static class AnonymousClass3 extends XC_MethodHook {
        final /* synthetic */ HashSet val$loadedPackagesInProcess;

        AnonymousClass3(HashSet hashSet) {
            this.val$loadedPackagesInProcess = hashSet;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // de.robv.android.xposed.XC_MethodHook
        public void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
            SELinuxHelper.initForProcess("android");
            this.val$loadedPackagesInProcess.add("android");
            XC_LoadPackage.LoadPackageParam lpparam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
            lpparam.packageName = "android";
            lpparam.processName = "android";
            lpparam.classLoader = XposedBridge.BOOTCLASSLOADER;
            lpparam.appInfo = null;
            lpparam.isFirstApplication = true;
            XC_LoadPackage.callAll(lpparam);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void hookResources() throws Throwable {
        if (SELinuxHelper.getAppDataFileService().checkFileExists(BASE_DIR + "conf/disable_resources")) {
            Log.w("Xposed", "Found " + BASE_DIR + "conf/disable_resources, not hooking resources");
            disableResources = true;
        } else if (!XposedBridge.initXResourcesNative()) {
            Log.e("Xposed", "Cannot hook resources");
            disableResources = true;
        } else {
            final ThreadLocal<Object> latestResKey = new ThreadLocal<>();
            Class<?> classGTLR = Class.forName("android.app.ResourcesManager");
            final Class<?> classResKey = Class.forName("android.content.res.ResourcesKey");
            if (Build.VERSION.SDK_INT >= 24) {
                XposedBridge.hookAllMethods(classGTLR, "getOrCreateResources", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.7
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // de.robv.android.xposed.XC_MethodHook
                    public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        ArrayList<WeakReference<Resources>> resourceReferences;
                        int activityTokenIdx = XposedHelpers.getParameterIndexByType(param.method, IBinder.class);
                        int resKeyIdx = XposedHelpers.getParameterIndexByType(param.method, classResKey);
                        String resDir = (String) XposedHelpers.getObjectField(param.args[resKeyIdx], "mResDir");
                        XResources newRes = XposedInit.cloneToXResources(param, resDir);
                        if (newRes == null) {
                            return;
                        }
                        Object activityToken = param.args[activityTokenIdx];
                        synchronized (param.thisObject) {
                            if (activityToken != null) {
                                Object activityResources = XposedHelpers.callMethod(param.thisObject, "getOrCreateActivityResourcesStructLocked", activityToken);
                                resourceReferences = (ArrayList) XposedHelpers.getObjectField(activityResources, "activityResources");
                            } else {
                                resourceReferences = (ArrayList) XposedHelpers.getObjectField(param.thisObject, "mResourceReferences");
                            }
                            resourceReferences.add(new WeakReference<>(newRes));
                        }
                    }
                });
            } else {
                XposedBridge.hookAllConstructors(classResKey, new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.8
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // de.robv.android.xposed.XC_MethodHook
                    public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        latestResKey.set(param.thisObject);
                    }
                });
                XposedBridge.hookAllMethods(classGTLR, "getTopLevelResources", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.9
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // de.robv.android.xposed.XC_MethodHook
                    public void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        latestResKey.set(null);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // de.robv.android.xposed.XC_MethodHook
                    public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        Object key = latestResKey.get();
                        if (key == null) {
                            return;
                        }
                        latestResKey.set(null);
                        String resDir = (String) XposedHelpers.getObjectField(key, "mResDir");
                        XResources newRes = XposedInit.cloneToXResources(param, resDir);
                        if (newRes == null) {
                            return;
                        }
                        Map<Object, WeakReference<Resources>> mActiveResources = (Map) XposedHelpers.getObjectField(param.thisObject, "mActiveResources");
                        Object lockObject = param.thisObject;
                        synchronized (lockObject) {
                            WeakReference<Resources> existing = mActiveResources.put(key, new WeakReference<>(newRes));
                            if (existing != null && existing.get() != null && existing.get().getAssets() != newRes.getAssets()) {
                                existing.get().getAssets().close();
                            }
                        }
                    }
                });
                XposedBridge.hookAllMethods(classGTLR, "getTopLevelThemedResources", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.10
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // de.robv.android.xposed.XC_MethodHook
                    public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        String resDir = (String) param.args[0];
                        XposedInit.cloneToXResources(param, resDir);
                    }
                });
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Set<Method> methods = XposedHelpers.getOverriddenMethods(XResources.XTypedArray.class);
                XposedBridge.invalidateCallersNative((Member[]) methods.toArray(new Member[methods.size()]));
            }
            XposedBridge.hookAllConstructors(TypedArray.class, new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.11
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    TypedArray typedArray = (TypedArray) param.thisObject;
                    Resources res = typedArray.getResources();
                    if (res instanceof XResources) {
                        XposedBridge.setObjectClass(typedArray, XResources.XTypedArray.class);
                    }
                }
            });
            XResources systemRes = (XResources) XposedBridge.cloneToSubclass(Resources.getSystem(), XResources.class);
            systemRes.initObject((String) null);
            XposedHelpers.setStaticObjectField(Resources.class, "mSystem", systemRes);
            XResources.init(latestResKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static XResources cloneToXResources(XC_MethodHook.MethodHookParam param, String resDir) {
        Object result = param.getResult();
        if (result == null || (result instanceof XResources) || Arrays.binarySearch(XRESOURCES_CONFLICTING_PACKAGES, AndroidAppHelper.currentPackageName()) == 0) {
            return null;
        }
        XResources newRes = (XResources) XposedBridge.cloneToSubclass(result, XResources.class);
        newRes.initObject(resDir);
        if (newRes.isFirstLoad()) {
            String packageName = newRes.getPackageName();
            XC_InitPackageResources.InitPackageResourcesParam resparam = new XC_InitPackageResources.InitPackageResourcesParam(XposedBridge.sInitPackageResourcesCallbacks);
            resparam.packageName = packageName;
            resparam.res = newRes;
            XCallback.callAll(resparam);
        }
        param.setResult(newRes);
        return newRes;
    }

    private static boolean needsToCloseFilesForFork() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        File lib = new File(Environment.getRootDirectory(), "lib/libandroid_runtime.so");
        try {
            return XposedHelpers.fileContains(lib, "Unable to construct file descriptor table");
        } catch (IOException e2) {
            Log.e("Xposed", "Could not check whether " + lib + " has security patch level 5");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hookXposedInstaller(ClassLoader classLoader) {
        try {
            XposedHelpers.findAndHookMethod("de.robv.android.xposed.installer.XposedApp", classLoader, "getActiveXposedVersion", XC_MethodReplacement.returnConstant(Integer.valueOf(XposedBridge.getXposedVersion())));
            XposedHelpers.findAndHookMethod("de.robv.android.xposed.installer.XposedApp", classLoader, "onCreate", new XC_MethodHook() { // from class: de.robv.android.xposed.XposedInit.12
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // de.robv.android.xposed.XC_MethodHook
                public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    Application application = (Application) param.thisObject;
                    Resources res = application.getResources();
                    if (res.getIdentifier("installer_needs_update", "string", XposedInit.INSTALLER_PACKAGE_NAME) == 0) {
                        Log.e("XposedInstaller", "Xposed Installer is outdated (resource string \"installer_needs_update\" is missing)");
                        Toast.makeText(application, "Please update Xposed Installer!", 1).show();
                    }
                }
            });
        } catch (Throwable t) {
            Log.e("Xposed", "Could not hook Xposed Installer", t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void loadModules() throws IOException {
        String filename = BASE_DIR + "conf/modules.list";
        BaseService service = SELinuxHelper.getAppDataFileService();
        if (!service.checkFileExists(filename)) {
            Log.e("Xposed", "Cannot load any modules because " + filename + " was not found");
            return;
        }
        ClassLoader topClassLoader = XposedBridge.BOOTCLASSLOADER;
        while (true) {
            ClassLoader parent = topClassLoader.getParent();
            if (parent == null) {
                break;
            }
            topClassLoader = parent;
        }
        InputStream stream = service.getFileInputStream(filename);
        BufferedReader apks = new BufferedReader(new InputStreamReader(stream));
        while (true) {
            String apk = apks.readLine();
            if (apk != null) {
                loadModule(apk, topClassLoader);
            } else {
                apks.close();
                return;
            }
        }
    }

    private static void loadModule(String apk, ClassLoader topClassLoader) {
        Log.i("Xposed", "Loading modules from " + apk);
        if (!new File(apk).exists()) {
            Log.e("Xposed", "  File does not exist");
            return;
        }
        try {
            DexFile dexFile = new DexFile(apk);
            if (dexFile.loadClass(INSTANT_RUN_CLASS, topClassLoader) != null) {
                Log.e("Xposed", "  Cannot load module, please disable \"Instant Run\" in Android Studio.");
                XposedHelpers.closeSilently(dexFile);
            } else if (dexFile.loadClass(XposedBridge.class.getName(), topClassLoader) != null) {
                Log.e("Xposed", "  Cannot load module:");
                Log.e("Xposed", "  The Xposed API classes are compiled into the module's APK.");
                Log.e("Xposed", "  This may cause strange issues and must be fixed by the module developer.");
                Log.e("Xposed", "  For details, see: http://api.xposed.info/using.html");
                XposedHelpers.closeSilently(dexFile);
            } else {
                XposedHelpers.closeSilently(dexFile);
                try {
                    ZipFile zipFile = new ZipFile(apk);
                    ZipEntry zipEntry = zipFile.getEntry("assets/xposed_init");
                    if (zipEntry == null) {
                        Log.e("Xposed", "  assets/xposed_init not found in the APK");
                        XposedHelpers.closeSilently(zipFile);
                        return;
                    }
                    InputStream is = zipFile.getInputStream(zipEntry);
                    ClassLoader mcl = new PathClassLoader(apk, XposedBridge.BOOTCLASSLOADER);
                    BufferedReader moduleClassesReader = new BufferedReader(new InputStreamReader(is));
                    while (true) {
                        try {
                            try {
                                String moduleClassName = moduleClassesReader.readLine();
                                if (moduleClassName == null) {
                                    break;
                                }
                                String moduleClassName2 = moduleClassName.trim();
                                if (!moduleClassName2.isEmpty() && !moduleClassName2.startsWith("#")) {
                                    try {
                                        Log.i("Xposed", "  Loading class " + moduleClassName2);
                                        Class<?> moduleClass = mcl.loadClass(moduleClassName2);
                                        if (!IXposedMod.class.isAssignableFrom(moduleClass)) {
                                            Log.e("Xposed", "    This class doesn't implement any sub-interface of IXposedMod, skipping it");
                                        } else if (disableResources && IXposedHookInitPackageResources.class.isAssignableFrom(moduleClass)) {
                                            Log.e("Xposed", "    This class requires resource-related hooks (which are disabled), skipping it.");
                                        } else {
                                            Object moduleInstance = moduleClass.newInstance();
                                            if (XposedBridge.isZygote) {
                                                if (moduleInstance instanceof IXposedHookZygoteInit) {
                                                    IXposedHookZygoteInit.StartupParam param = new IXposedHookZygoteInit.StartupParam();
                                                    param.modulePath = apk;
                                                    param.startsSystemServer = startsSystemServer;
                                                    ((IXposedHookZygoteInit) moduleInstance).initZygote(param);
                                                }
                                                if (moduleInstance instanceof IXposedHookLoadPackage) {
                                                    XposedBridge.hookLoadPackage(new IXposedHookLoadPackage.Wrapper((IXposedHookLoadPackage) moduleInstance));
                                                }
                                                if (moduleInstance instanceof IXposedHookInitPackageResources) {
                                                    XposedBridge.hookInitPackageResources(new IXposedHookInitPackageResources.Wrapper((IXposedHookInitPackageResources) moduleInstance));
                                                }
                                            } else if (moduleInstance instanceof IXposedHookCmdInit) {
                                                IXposedHookCmdInit.StartupParam param2 = new IXposedHookCmdInit.StartupParam();
                                                param2.modulePath = apk;
                                                param2.startClassName = startClassName;
                                                ((IXposedHookCmdInit) moduleInstance).initCmdApp(param2);
                                            }
                                        }
                                    } catch (Throwable t) {
                                        Log.e("Xposed", "    Failed to load class " + moduleClassName2, t);
                                    }
                                }
                            } catch (IOException e2) {
                                Log.e("Xposed", "  Failed to load module from " + apk, e2);
                            }
                        } finally {
                            XposedHelpers.closeSilently(is);
                            XposedHelpers.closeSilently(zipFile);
                        }
                    }
                } catch (IOException e3) {
                    Log.e("Xposed", "  Cannot read assets/xposed_init in the APK", e3);
                    XposedHelpers.closeSilently((ZipFile) null);
                }
            }
        } catch (IOException e4) {
            Log.e("Xposed", "  Cannot load module", e4);
        }
    }
}