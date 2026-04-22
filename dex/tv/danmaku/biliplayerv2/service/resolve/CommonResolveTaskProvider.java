package tv.danmaku.biliplayerv2.service.resolve;

import android.content.Context;
import com.bilibili.lib.media.resolver2.BiliCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: CommonResolveTasks.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&JY\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/CommonResolveTaskProvider;", "", "provideMediaSourceResolveTask", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask;", "context", "Landroid/content/Context;", "useDownload", "", "useFlashStr", "playableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "expectedFormat", "", "expectedCodec", "Lcom/bilibili/lib/media/resolver2/BiliCodec;", IjkMediaMeta.IJKM_KEY_LANGUAGE, "", "productionType", "provideMediaSourceResolveTask-9jpZhns", "(Landroid/content/Context;ZZLtv/danmaku/biliplayerv2/service/Video$PlayableParams;IILjava/lang/String;I)Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface CommonResolveTaskProvider {
    AbsMediaResourceResolveTask provideMediaSourceResolveTask(Context context, boolean z, boolean z2, Video.PlayableParams playableParams);

    /* renamed from: provideMediaSourceResolveTask-9jpZhns  reason: not valid java name */
    AbsMediaResourceResolveTask mo2282provideMediaSourceResolveTask9jpZhns(Context context, boolean z, boolean z2, Video.PlayableParams playableParams, int i, int i2, String str, int i3);

    /* compiled from: CommonResolveTasks.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.resolve.CommonResolveTaskProvider$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        /* renamed from: provideMediaSourceResolveTask-9jpZhns$default  reason: not valid java name */
        public static /* synthetic */ AbsMediaResourceResolveTask m2285provideMediaSourceResolveTask9jpZhns$default(CommonResolveTaskProvider commonResolveTaskProvider, Context context, boolean z, boolean z2, Video.PlayableParams playableParams, int i, int i2, String str, int i3, int i4, Object obj) {
            if (obj == null) {
                return commonResolveTaskProvider.mo2282provideMediaSourceResolveTask9jpZhns(context, z, z2, playableParams, (i4 & 16) != 0 ? 0 : i, (i4 & 32) != 0 ? BiliCodec.Companion.getDEFAULT-eY-7Wcs() : i2, (i4 & 64) != 0 ? null : str, (i4 & 128) != 0 ? 0 : i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: provideMediaSourceResolveTask-9jpZhns");
        }

        /* renamed from: $default$provideMediaSourceResolveTask-9jpZhns  reason: not valid java name */
        public static AbsMediaResourceResolveTask m2283$default$provideMediaSourceResolveTask9jpZhns(CommonResolveTaskProvider _this, Context context, boolean useDownload, boolean useFlashStr, Video.PlayableParams playableParams, int expectedFormat, int i, String language, int productionType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
            return _this.provideMediaSourceResolveTask(context, useDownload, useFlashStr, playableParams);
        }
    }

    /* compiled from: CommonResolveTasks.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: provideMediaSourceResolveTask-9jpZhns  reason: not valid java name */
        public static AbsMediaResourceResolveTask m2286provideMediaSourceResolveTask9jpZhns(CommonResolveTaskProvider $this, Context context, boolean useDownload, boolean useFlashStr, Video.PlayableParams playableParams, int expectedFormat, int i, String language, int productionType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
            return CC.m2283$default$provideMediaSourceResolveTask9jpZhns($this, context, useDownload, useFlashStr, playableParams, expectedFormat, i, language, productionType);
        }
    }
}