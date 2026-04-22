package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

public interface IXposedHookLoadPackage extends IXposedMod {
    void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Wrapper extends XC_LoadPackage {
        private final IXposedHookLoadPackage instance;

        public Wrapper(IXposedHookLoadPackage instance) {
            this.instance = instance;
        }

        @Override // de.robv.android.xposed.IXposedHookLoadPackage
        public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
            this.instance.handleLoadPackage(lpparam);
        }
    }
}