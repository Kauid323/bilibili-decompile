package tv.danmaku.biliplayerv2.service.resolve;

import android.content.Context;
import com.bilibili.lib.media.resolver2.BiliCodec;
import com.bilibili.lib.media.resolver2.IInternationalizedParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.resolve.CommonResolveTaskProvider;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: CommonResolveTasks.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016JQ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/DefaultCommonResolveTaskProvider;", "Ltv/danmaku/biliplayerv2/service/resolve/CommonResolveTaskProvider;", "<init>", "()V", "provideMediaSourceResolveTask", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask;", "context", "Landroid/content/Context;", "useDownload", "", "useFlashStr", "playableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "expectedFormat", "", "expectedCodec", "Lcom/bilibili/lib/media/resolver2/BiliCodec;", IjkMediaMeta.IJKM_KEY_LANGUAGE, "", "productionType", "provideMediaSourceResolveTask-9jpZhns", "(Landroid/content/Context;ZZLtv/danmaku/biliplayerv2/service/Video$PlayableParams;IILjava/lang/String;I)Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DefaultCommonResolveTaskProvider implements CommonResolveTaskProvider {
    @Override // tv.danmaku.biliplayerv2.service.resolve.CommonResolveTaskProvider
    public AbsMediaResourceResolveTask provideMediaSourceResolveTask(Context context, boolean useDownload, boolean useFlashStr, Video.PlayableParams playableParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        return CommonResolveTaskProvider.CC.m2285provideMediaSourceResolveTask9jpZhns$default(this, context, useDownload, useFlashStr, playableParams, 0, BiliCodec.Companion.getDEFAULT-eY-7Wcs(), null, 0, 128, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.CommonResolveTaskProvider
    /* renamed from: provideMediaSourceResolveTask-9jpZhns */
    public AbsMediaResourceResolveTask mo2282provideMediaSourceResolveTask9jpZhns(Context context, boolean useDownload, boolean useFlashStr, Video.PlayableParams playableParams, int expectedFormat, int i, String language, int productionType) {
        String flashJsonStr;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        if (useFlashStr) {
            flashJsonStr = playableParams.getFlashJsonStr();
        } else {
            flashJsonStr = null;
        }
        IInternationalizedParams resolveParams = playableParams.getResolveParams();
        if (resolveParams != null) {
            resolveParams.setFormat(expectedFormat);
            resolveParams.setCodecType-N6j8eWo(i);
            if (resolveParams instanceof IInternationalizedParams) {
                resolveParams.setLanguage(language);
                resolveParams.setProductionType(productionType);
            }
            String str = flashJsonStr;
            if (!(str == null || str.length() == 0)) {
                AbsMediaResourceResolveTask resultTask = new FlashMediaResourceResolveTask(resolveParams, flashJsonStr);
                AbsMediaResourceResolveTask resultTask2 = resultTask;
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                resultTask2.setBackupTask(new NormalMediaResourceResolveTask(false, applicationContext, false, resolveParams, null));
                return resultTask2;
            }
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            AbsMediaResourceResolveTask resultTask3 = new NormalMediaResourceResolveTask(true, applicationContext2, false, resolveParams, null);
            return resultTask3;
        }
        throw new IllegalArgumentException("PlayableParams return null resolveParams");
    }
}