package de.robv.android.xposed.callbacks;

import android.content.res.XResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XCallback;

public abstract class XC_InitPackageResources extends XCallback implements IXposedHookInitPackageResources {
    public XC_InitPackageResources() {
    }

    public XC_InitPackageResources(int priority) {
        super(priority);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class InitPackageResourcesParam extends XCallback.Param {
        public String packageName;
        public XResources res;

        public InitPackageResourcesParam(XposedBridge.CopyOnWriteSortedSet<XC_InitPackageResources> callbacks) {
            super(callbacks);
        }
    }

    @Override // de.robv.android.xposed.callbacks.XCallback
    protected void call(XCallback.Param param) throws Throwable {
        if (param instanceof InitPackageResourcesParam) {
            handleInitPackageResources((InitPackageResourcesParam) param);
        }
    }
}