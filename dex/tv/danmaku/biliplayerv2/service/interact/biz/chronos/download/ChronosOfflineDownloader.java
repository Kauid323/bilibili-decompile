package tv.danmaku.biliplayerv2.service.interact.biz.chronos.download;

import com.bapis.bilibili.app.viewunite.v1.UnionType;
import com.bapis.bilibili.app.viewunite.v1.ViewMoss;
import com.bapis.bilibili.app.viewunite.v1.ViewProgressReply;
import com.bapis.bilibili.app.viewunite.v1.ViewProgressReq;
import com.bilibili.lib.moss.api.CallOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.Chronos;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetailParser;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.VideoBizType;

/* compiled from: ChronosOfflineDownloader.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/download/ChronosOfflineDownloader;", "", "<init>", "()V", "downloadUrl", "", "md5", "getChronosPackageUrlFromAvid", "aid", "cid", "type", "Ltv/danmaku/videoplayer/coreV2/VideoBizType;", "getChronosMd5FromAvid", "clear", "", "requestViewProgress", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "", "parseViewProgress", "viewProgressDetail", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosOfflineDownloader {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ChronosOfflineDownloader";
    private String downloadUrl;
    private String md5;

    /* compiled from: ChronosOfflineDownloader.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/download/ChronosOfflineDownloader$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getChronosPackageUrlFromAvid(String aid, String cid, VideoBizType type) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(type, "type");
        String str = this.downloadUrl;
        if (!(str == null || str.length() == 0)) {
            return this.downloadUrl;
        }
        try {
            parseViewProgress(requestViewProgress(Long.parseLong(aid), Long.parseLong(cid), type));
            return this.downloadUrl;
        } catch (Exception e) {
            BLog.e(TAG, " offline chronos request view progress failed: " + e);
            return null;
        }
    }

    public final String getChronosMd5FromAvid(String aid, String cid, VideoBizType type) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(type, "type");
        String str = this.md5;
        if (!(str == null || str.length() == 0)) {
            return this.md5;
        }
        try {
            parseViewProgress(requestViewProgress(Long.parseLong(aid), Long.parseLong(cid), type));
            return this.md5;
        } catch (Exception e) {
            BLog.e(TAG, " offline chronos request view progress failed: " + e);
            return null;
        }
    }

    public final void clear() {
        this.downloadUrl = null;
        this.md5 = null;
    }

    private final ViewProgressDetail requestViewProgress(long aid, long cid, VideoBizType type) {
        ViewProgressReq request = ViewProgressReq.newBuilder().setAid(aid).setCid(cid).setUpMid(0L).setType(type == VideoBizType.PGC ? UnionType.OGV : UnionType.UGC).build();
        ViewMoss viewMoss = new ViewMoss("IGNORED IN 5.46 AS PLACEHOLDER", 443, (CallOptions) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(request);
        ViewProgressReply it = viewMoss.executeViewProgress(request);
        if (it != null) {
            return ViewProgressDetailParser.INSTANCE.generateUniteViewProgressDetail(it);
        }
        return null;
    }

    private final void parseViewProgress(ViewProgressDetail viewProgressDetail) {
        Chronos it;
        if (viewProgressDetail != null && (it = viewProgressDetail.getChronos()) != null) {
            String file = it.getFile();
            this.downloadUrl = file != null ? StringsKt.replace$default(file, "http://", "https://", false, 4, (Object) null) : null;
            this.md5 = it.getMd5();
        }
    }
}