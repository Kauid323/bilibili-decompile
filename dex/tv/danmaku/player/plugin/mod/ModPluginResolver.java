package tv.danmaku.player.plugin.mod;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.lib.plugin.exception.PluginError;
import com.bilibili.lib.plugin.extension.PluginManager;
import com.bilibili.lib.plugin.extension.PluginManagerHelper;
import com.bilibili.lib.plugin.extension.model.behavior.SoLibBehavior;
import com.bilibili.lib.plugin.model.request.PluginRequest;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import tv.danmaku.android.log.BLog;
import tv.danmaku.player.plugin.IPlayerPluginResolver;
import tv.danmaku.player.plugin.IPluginResolverListener;
import tv.danmaku.player.plugin.PluginParams;
import tv.danmaku.player.plugin.PluginResult;

public class ModPluginResolver implements IPlayerPluginResolver {
    private static final String TAG = "IPlayerPluginResolver";
    private static final int TIMEOUT_MILLIS = 60000;

    @Override // tv.danmaku.player.plugin.IPlayerPluginResolver
    public boolean resolvePlugin(Context context, PluginParams params, IPluginResolverListener listener) {
        if (!IjkX86Helper.isX86Device()) {
            return true;
        }
        if (IjkX86Helper.sIjkX86 != null) {
            return checkSoFiles();
        }
        PluginManagerHelper.init(context);
        IjkX86Helper.setSoLoader();
        return getIjkX86Plugin(listener);
    }

    private boolean getIjkX86Plugin(IPluginResolverListener listener) {
        if (IjkX86Helper.sIjkX86 != null) {
            return checkSoFiles();
        }
        if (IjkX86Helper.sIjkX86 == null) {
            Callable<Boolean> callable = new AnonymousClass1(listener);
            try {
                callable.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (IjkX86Helper.sIjkX86 != null) {
                return checkSoFiles();
            }
            BLog.i(TAG, "Get ijk x86 plugin fail, see callback.");
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.player.plugin.mod.ModPluginResolver$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class AnonymousClass1 implements Callable<Boolean> {
        final Object lock = new Object();
        final X86Listener pluginCb = new X86Listener() { // from class: tv.danmaku.player.plugin.mod.ModPluginResolver.1.1
            public void onPreLoad(X86IjkRequest request) {
                super.onPreLoad((PluginRequest) request);
                BLog.i(ModPluginResolver.TAG, "Get x86 plugin, start new request.");
                if (AnonymousClass1.this.val$listener != null) {
                    AnonymousClass1.this.val$listener.onPreResolve();
                }
            }

            public void onProgress(X86IjkRequest request, float progress) {
                BLog.d(ModPluginResolver.TAG, "progress = " + String.valueOf(progress));
                super.onProgress((PluginRequest) request, progress);
                if (AnonymousClass1.this.val$listener != null) {
                    AnonymousClass1.this.val$listener.onProgress(progress);
                }
            }

            @Override // tv.danmaku.player.plugin.mod.X86Listener
            public void onFail(X86IjkRequest request, PluginError error) {
                List<Exception> exceptions;
                super.onFail(request, error);
                BLog.i(ModPluginResolver.TAG, "Get x86 plugin fail, see callback.");
                if (AnonymousClass1.this.val$listener != null && (exceptions = request.getExceptions()) != null) {
                    for (Exception exception : exceptions) {
                        AnonymousClass1.this.val$listener.onError(exception);
                    }
                }
                synchronized (AnonymousClass1.this.lock) {
                    AnonymousClass1.this.lock.notify();
                }
            }

            @Override // tv.danmaku.player.plugin.mod.X86Listener
            public void onPostLoad(X86IjkRequest request, SoLibBehavior behavior) {
                super.onPostLoad(request, behavior);
                if (AnonymousClass1.this.val$listener != null) {
                    AnonymousClass1.this.val$listener.onPostResolve(new PluginResult(true));
                }
                synchronized (AnonymousClass1.this.lock) {
                    AnonymousClass1.this.lock.notify();
                }
            }
        };
        final /* synthetic */ IPluginResolverListener val$listener;

        AnonymousClass1(IPluginResolverListener iPluginResolverListener) {
            this.val$listener = iPluginResolverListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            X86IjkRequest request = new X86IjkRequest();
            PluginManager.instance().addSync(request, this.pluginCb);
            synchronized (this.lock) {
                this.lock.wait(60000L);
            }
            return null;
        }
    }

    private boolean checkSoFiles() {
        String error = null;
        Set<File> soLibs = IjkX86Helper.sIjkX86.getLibrary();
        if (!hasFile(soLibs, "ijkffmpeg")) {
            error = "Losing ijkffmpeg.";
        }
        if (!hasFile(soLibs, "ijksdl")) {
            error = "Losing ijksdl.";
        }
        if (!hasFile(soLibs, "ijkplayer")) {
            error = "Losing ijkplayer.";
        }
        if (!hasFile(soLibs, "xp2p")) {
            error = "Losing xp2p.";
        }
        if (TextUtils.isEmpty(error)) {
            return true;
        }
        IjkX86Helper.sIjkX86 = null;
        BLog.w(TAG, error);
        return false;
    }

    private boolean hasFile(Set<File> files, String name) {
        for (File item : files) {
            if (item.getName().contains(name)) {
                return true;
            }
        }
        return false;
    }

    private void onTimeout() {
        BLog.w("plugin.listener", "Request ijk x86 fail, error = Network time out.");
    }
}