package tv.danmaku.video.resolver;

import com.bilibili.lib.blrouter.ModuleApi;
import com.bilibili.lib.blrouter.ModuleContext;
import com.bilibili.lib.blrouter.ModuleDescriptor;
import com.bilibili.lib.media.resolver2.IMediaResolverV2;
import com.bilibili.lib.media.resolver2.MediaResolverHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ResolverBootstrapLaunch.kt */
@ModuleDescriptor(desc = "resolver模块初始化", name = "resolver")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/video/resolver/ResolverBootstrapLaunch;", "Lcom/bilibili/lib/blrouter/ModuleApi;", "<init>", "()V", "onCreate", "", "context", "Lcom/bilibili/lib/blrouter/ModuleContext;", "ugcresolver_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ResolverBootstrapLaunch extends ModuleApi {
    public void onCreate(ModuleContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        MediaResolverHandler.INSTANCE.registerResolvers(new IMediaResolverV2[]{new UrlDefaultResolver()});
        BLog.d("ResolverBootstrapLaunch", "register UrlDefaultResolver");
    }
}