package tv.danmaku.video.resolver;

import android.content.Context;
import com.bilibili.lib.media.resolver.exception.ResolveMediaSourceException;
import com.bilibili.lib.media.resolver2.IMediaResolverV2;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.media.resource.Segment;
import com.bilibili.lib.media.resource.VodIndex;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UrlDefaultResolver.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Ltv/danmaku/video/resolver/UrlDefaultResolver;", "Lcom/bilibili/lib/media/resolver2/IMediaResolverV2;", "<init>", "()V", "resolveType", "", "getResolveType", "()Ljava/lang/String;", "resolveMediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "context", "Landroid/content/Context;", "resolveParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "ugcresolver_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UrlDefaultResolver implements IMediaResolverV2 {
    public String getResolveType() {
        return "direct_url";
    }

    public MediaResource resolveMediaResource(Context context, IResolveParams resolveParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resolveParams, "resolveParams");
        UrlResolveParams urlResolveParams = resolveParams instanceof UrlResolveParams ? (UrlResolveParams) resolveParams : null;
        if (urlResolveParams == null) {
            throw new ResolveMediaSourceException.ResolveInvalidCodeException("convert resourceParams to  UrlResolveParams failed ", -11);
        }
        BLog.i("start request url:" + urlResolveParams.getUrl());
        MediaResource mediaResource = new MediaResource();
        VodIndex vodIndex = new VodIndex();
        PlayIndex playIndex = new PlayIndex();
        playIndex.mFrom = "vupload";
        playIndex.mNormalMrl = urlResolveParams.getUrl();
        Segment segment = new Segment(playIndex.mNormalMrl);
        ArrayList<String> backupUrls = urlResolveParams.getBackupUrls();
        if (!(backupUrls == null || backupUrls.isEmpty())) {
            segment.mBackupUrls = new ArrayList();
            segment.mBackupUrls.addAll(urlResolveParams.getBackupUrls());
        }
        playIndex.mSegmentList.add(segment);
        vodIndex.mVodList.add(playIndex);
        mediaResource.mVodIndex = vodIndex;
        return mediaResource;
    }
}