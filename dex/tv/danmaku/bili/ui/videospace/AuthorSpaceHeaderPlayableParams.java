package tv.danmaku.bili.ui.videospace;

import com.bilibili.lib.media.resolver2.IResolveParams;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.DisplayOrientation;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.resolver.UGCResolverParams;
import tv.danmaku.video.resolver.UrlResolveParams;

/* compiled from: AuthorSpaceHeaderPlayableParams.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00100\u001a\u00020\u0011H\u0016J\n\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020/H\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020\u0011H\u0016J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020:H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R*\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00110(j\b\u0012\u0004\u0012\u00020\u0011`)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayableParams;", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "<init>", "()V", "avid", "", "getAvid", "()J", "setAvid", "(J)V", "cid", "getCid", "setCid", RankRouter.BundleKey.AUTHOR_SPACE_MID, "getMid", "setMid", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "author", "getAuthor", "setAuthor", "displayRotate", "", "getDisplayRotate", "()F", "setDisplayRotate", "(F)V", "isDirectUrl", "", "()Z", "setDirectUrl", "(Z)V", "directPlayUrl", "getDirectPlayUrl", "setDirectPlayUrl", "backupUrls", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getBackupUrls", "()Ljava/util/ArrayList;", "setBackupUrls", "(Ljava/util/ArrayList;)V", "mDisplayParams", "Ltv/danmaku/biliplayerv2/service/Video$DisplayParams;", "id", "getDanmakuResolveParams", "Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;", "getDisplayParams", "getResolveParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "getLogDescription", "getFeedbackParams", "Ltv/danmaku/biliplayerv2/service/Video$FeedbackParams;", "getReportCommonParams", "Ltv/danmaku/biliplayerv2/service/Video$ReportCommonParams;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthorSpaceHeaderPlayableParams extends Video.PlayableParams {
    public static final int AUTHOR_SPACE_HEADER_PLAYER_REPORT_AUTO_PLAY = 99;
    private String author;
    private long avid;
    private ArrayList<String> backupUrls = new ArrayList<>();
    private long cid;
    private String directPlayUrl;
    private float displayRotate;
    private boolean isDirectUrl;
    private Video.DisplayParams mDisplayParams;
    private long mid;
    private String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public final long getAvid() {
        return this.avid;
    }

    public final void setAvid(long j) {
        this.avid = j;
    }

    public final long getCid() {
        return this.cid;
    }

    public final void setCid(long j) {
        this.cid = j;
    }

    public final long getMid() {
        return this.mid;
    }

    public final void setMid(long j) {
        this.mid = j;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final void setAuthor(String str) {
        this.author = str;
    }

    public final float getDisplayRotate() {
        return this.displayRotate;
    }

    public final void setDisplayRotate(float f) {
        this.displayRotate = f;
    }

    public final boolean isDirectUrl() {
        return this.isDirectUrl;
    }

    public final void setDirectUrl(boolean z) {
        this.isDirectUrl = z;
    }

    public final String getDirectPlayUrl() {
        return this.directPlayUrl;
    }

    public final void setDirectPlayUrl(String str) {
        this.directPlayUrl = str;
    }

    public final ArrayList<String> getBackupUrls() {
        return this.backupUrls;
    }

    public final void setBackupUrls(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.backupUrls = arrayList;
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public String id() {
        long j = this.avid;
        return j + ";" + this.cid;
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public Video.DanmakuResolveParams getDanmakuResolveParams() {
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public Video.DisplayParams getDisplayParams() {
        if (this.mDisplayParams != null) {
            Video.DisplayParams params = this.mDisplayParams;
            Intrinsics.checkNotNull(params);
            return params;
        }
        Video.DisplayParams params2 = new Video.DisplayParams();
        String str = this.title;
        if (str == null) {
            str = "";
        }
        params2.setTitle(str);
        params2.setMid(this.mid);
        String str2 = this.author;
        if (str2 == null) {
            str2 = "";
        }
        params2.setAuthor(str2);
        String from = getFrom();
        params2.setFrom(from != null ? from : "");
        params2.setAvid(this.avid);
        params2.setCid(this.cid);
        params2.setDisplayRotate(this.displayRotate);
        params2.setDisplayOrientation(this.displayRotate <= 1.0f ? DisplayOrientation.VERTICAL : DisplayOrientation.LANDSCAPE);
        this.mDisplayParams = params2;
        return params2;
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public IResolveParams getResolveParams() {
        if (this.isDirectUrl) {
            UrlResolveParams rp = new UrlResolveParams();
            rp.setUrl(this.directPlayUrl);
            ArrayList<String> arrayList = this.backupUrls;
            if (((arrayList == null || arrayList.isEmpty()) ? 1 : 1) == 0) {
                rp.getBackupUrls().addAll(this.backupUrls);
            }
            return rp;
        }
        UGCResolverParams rp2 = new UGCResolverParams();
        rp2.setMFrom("vupload");
        rp2.setAvid(this.avid);
        rp2.setCid(this.cid);
        rp2.setRealQuality(getExpectedQuality());
        rp2.setDomainParams(isEnableSafeConnection() ? 2 : 0);
        rp2.setFromSpmid(getFromSpmid());
        rp2.setSpmid(getSpmid());
        return rp2;
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public String getLogDescription() {
        String str = this.title;
        return "title: " + str + ", id: " + this.cid;
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public Video.FeedbackParams getFeedbackParams() {
        Video.FeedbackParams params = new Video.FeedbackParams();
        params.setAId(this.cid);
        params.setCId(this.cid);
        String spmid = getSpmid();
        if (spmid == null) {
            spmid = "";
        }
        params.setSpmid(spmid);
        String fromSpmid = getFromSpmid();
        params.setFromSpmid(fromSpmid != null ? fromSpmid : "");
        return params;
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public Video.ReportCommonParams getReportCommonParams() {
        Video.ReportCommonParams params = new Video.ReportCommonParams();
        params.setAvid(this.avid);
        params.setCid(this.cid);
        String jumpFrom = getJumpFrom();
        if (jumpFrom == null) {
            jumpFrom = "";
        }
        params.setJumpFrom(jumpFrom);
        String spmid = getSpmid();
        if (spmid == null) {
            spmid = "";
        }
        params.setSpmid(spmid);
        String fromSpmid = getFromSpmid();
        params.setFromSpmid(fromSpmid != null ? fromSpmid : "");
        params.setType(3);
        params.setFromAutoPlay(getFromAutoPlay());
        params.setPlayType("1");
        params.setPlayStatus("0");
        return params;
    }

    /* compiled from: AuthorSpaceHeaderPlayableParams.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayableParams$Companion;", "", "<init>", "()V", "AUTHOR_SPACE_HEADER_PLAYER_REPORT_AUTO_PLAY", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}