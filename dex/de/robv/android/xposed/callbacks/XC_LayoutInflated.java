package de.robv.android.xposed.callbacks;

import android.content.res.XResources;
import android.view.View;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XCallback;

public abstract class XC_LayoutInflated extends XCallback {
    public abstract void handleLayoutInflated(LayoutInflatedParam layoutInflatedParam) throws Throwable;

    public XC_LayoutInflated() {
    }

    public XC_LayoutInflated(int priority) {
        super(priority);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LayoutInflatedParam extends XCallback.Param {
        public XResources res;
        public XResources.ResourceNames resNames;
        public String variant;
        public View view;

        public LayoutInflatedParam(XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> callbacks) {
            super(callbacks);
        }
    }

    @Override // de.robv.android.xposed.callbacks.XCallback
    protected void call(XCallback.Param param) throws Throwable {
        if (param instanceof LayoutInflatedParam) {
            handleLayoutInflated((LayoutInflatedParam) param);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class Unhook implements IXUnhook<XC_LayoutInflated> {
        private final int id;
        private final String resDir;

        public Unhook(String resDir, int id) {
            this.resDir = resDir;
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // de.robv.android.xposed.callbacks.IXUnhook
        public XC_LayoutInflated getCallback() {
            return XC_LayoutInflated.this;
        }

        @Override // de.robv.android.xposed.callbacks.IXUnhook
        public void unhook() {
            XResources.unhookLayout(this.resDir, this.id, XC_LayoutInflated.this);
        }
    }
}