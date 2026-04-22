package de.robv.android.xposed;

public interface IXposedHookZygoteInit extends IXposedMod {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class StartupParam {
        public String modulePath;
        public boolean startsSystemServer;
    }

    void initZygote(StartupParam startupParam) throws Throwable;
}