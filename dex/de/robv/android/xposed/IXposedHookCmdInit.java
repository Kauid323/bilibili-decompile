package de.robv.android.xposed;

public interface IXposedHookCmdInit extends IXposedMod {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class StartupParam {
        public String modulePath;
        public String startClassName;
    }

    void initCmdApp(StartupParam startupParam) throws Throwable;
}