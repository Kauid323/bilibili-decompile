package de.robv.android.xposed.callbacks;

import android.content.pm.ApplicationInfo;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XCallback;

public abstract class XC_LoadPackage extends XCallback implements IXposedHookLoadPackage {
    public XC_LoadPackage() {
    }

    public XC_LoadPackage(int priority) {
        super(priority);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadPackageParam extends XCallback.Param {
        public ApplicationInfo appInfo;
        public ClassLoader classLoader;
        public boolean isFirstApplication;
        public String packageName;
        public String processName;

        public LoadPackageParam(XposedBridge.CopyOnWriteSortedSet<XC_LoadPackage> callbacks) {
            super(callbacks);
        }
    }

    @Override // de.robv.android.xposed.callbacks.XCallback
    protected void call(XCallback.Param param) throws Throwable {
        if (param instanceof LoadPackageParam) {
            handleLoadPackage((LoadPackageParam) param);
        }
    }
}