package tv.danmaku.biliplayerv2.service.resolve;

import com.bilibili.lib.media.resolver.exception.ResolveException;
import com.bilibili.lib.media.resolver2.interceptor.MediaResourceInterceptorV2;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MediaResourceRetryResolveInterceptorV2.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/MediaResourceRetryResolveInterceptorV2;", "Lcom/bilibili/lib/media/resolver2/interceptor/MediaResourceInterceptorV2;", "mMaxRetry", "", "<init>", "(I)V", "intercept", "Lcom/bilibili/lib/media/resource/MediaResource;", "chain", "Lcom/bilibili/lib/media/resolver2/interceptor/MediaResourceInterceptorV2$MediaResourceChainV2;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaResourceRetryResolveInterceptorV2 implements MediaResourceInterceptorV2 {
    private final int mMaxRetry;

    public MediaResourceRetryResolveInterceptorV2(int mMaxRetry) {
        this.mMaxRetry = mMaxRetry;
    }

    public MediaResource intercept(MediaResourceInterceptorV2.MediaResourceChainV2 chain) {
        MediaResource resource;
        int index = 0;
        int i = this.mMaxRetry;
        while (true) {
            resource = null;
            if (index >= i) {
                return null;
            }
            if (chain != null) {
                try {
                    resource = chain.proceed(chain.getResolveParams());
                } catch (ResolveException e) {
                    if (index != this.mMaxRetry - 1) {
                        index++;
                    } else {
                        throw e;
                    }
                }
            }
            if (resource == null || (!resource.isPlayable() && resource.getExtraInfo() == null)) {
                throw new ResolveException("null or unplayable media resource");
                break;
            }
        }
        return resource;
    }
}