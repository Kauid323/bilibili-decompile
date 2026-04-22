package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.XC_InitPackageResources;

public interface IXposedHookInitPackageResources extends IXposedMod {
    void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam initPackageResourcesParam) throws Throwable;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Wrapper extends XC_InitPackageResources {
        private final IXposedHookInitPackageResources instance;

        public Wrapper(IXposedHookInitPackageResources instance) {
            this.instance = instance;
        }

        @Override // de.robv.android.xposed.IXposedHookInitPackageResources
        public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam resparam) throws Throwable {
            this.instance.handleInitPackageResources(resparam);
        }
    }
}