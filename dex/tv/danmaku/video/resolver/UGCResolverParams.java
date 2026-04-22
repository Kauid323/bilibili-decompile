package tv.danmaku.video.resolver;

import android.os.Parcel;
import android.os.Parcelable;
import com.bapis.bilibili.app.playurl.v1.Business;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.media.resolver2.BiliCodec;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.teenagersmode.TeenagersMode;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaAsset;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import tv.danmaku.videoplayer.core.media.ijk.IjkOptionsHelper;

/* compiled from: UGCResolverParams.kt */
@Deprecated(message = "use GeminiCommonResolverParams，盖解析后续不在维护")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010Z\u001a\u00020[2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u000fH\u0016J\b\u0010]\u001a\u00020\u000fH\u0016R\u001c\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\fR\u001a\u0010$\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001a\u0010'\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\n\"\u0004\b)\u0010\fR\u001a\u0010*\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\n\"\u0004\b,\u0010\fR\u001a\u0010-\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\n\"\u0004\b/\u0010\fR\u001c\u00100\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001c\u00103\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R\u001a\u00106\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\n\"\u0004\b8\u0010\fR\u001a\u00109\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\u001a\u0010<\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0011\u0010B\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\bC\u0010?R\u001a\u0010D\u001a\u00020EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR\u0014\u0010S\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u0015R\u0014\u0010U\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0015R\u001a\u0010W\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\n\"\u0004\bY\u0010\f¨\u0006_"}, d2 = {"Ltv/danmaku/video/resolver/UGCResolverParams;", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "codecType", "Lcom/bilibili/lib/media/resolver2/BiliCodec;", "getCodecType-eY-7Wcs", "()I", "setCodecType-N6j8eWo", "(I)V", "I", IjkMediaMeta.IJKM_KEY_FORMAT, "", "getFormat", "setFormat", "mFrom", "", "getMFrom", "()Ljava/lang/String;", "setMFrom", "(Ljava/lang/String;)V", "avid", "", "getAvid", "()J", "setAvid", "(J)V", "cid", "getCid", "setCid", "page", "getPage", "setPage", "realQuality", "getRealQuality", "setRealQuality", "fnVer", "getFnVer", "setFnVer", "fnVal", "getFnVal", "setFnVal", "requestFromDownloader", "getRequestFromDownloader", "setRequestFromDownloader", "fromSpmid", "getFromSpmid", "setFromSpmid", "spmid", "getSpmid", "setSpmid", "teenagerMode", "getTeenagerMode", "setTeenagerMode", "volumeBalance", "getVolumeBalance", "setVolumeBalance", "preferCodecType", "Ltv/danmaku/ijk/media/player/IjkMediaAsset$VideoCodecType;", "getPreferCodecType", "()Ltv/danmaku/ijk/media/player/IjkMediaAsset$VideoCodecType;", "setPreferCodecType", "(Ltv/danmaku/ijk/media/player/IjkMediaAsset$VideoCodecType;)V", "finalCodecType", "getFinalCodecType", LoginSceneProcessor.BIZ_KEY, "Lcom/bapis/bilibili/app/playurl/v1/Business;", "getBusiness", "()Lcom/bapis/bilibili/app/playurl/v1/Business;", "setBusiness", "(Lcom/bapis/bilibili/app/playurl/v1/Business;)V", "resolveFromDownloadedFile", "", "getResolveFromDownloadedFile", "()Z", "setResolveFromDownloadedFile", "(Z)V", "forceLocalOnly", "getForceLocalOnly", "setForceLocalOnly", "id", "getId", "from", "getFrom", "domainParams", "getDomainParams", "setDomainParams", "writeToParcel", "", "flags", "describeContents", "CREATOR", "ugcresolver_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UGCResolverParams implements IResolveParams {
    public static final CREATOR CREATOR = new CREATOR(null);
    private long avid;
    private Business business;
    private long cid;
    private int codecType;
    private int domainParams;
    private int fnVal;
    private int fnVer;
    private boolean forceLocalOnly;
    private int format;
    private String fromSpmid;
    private String mFrom;
    private int page;
    private IjkMediaAsset.VideoCodecType preferCodecType;
    private long realQuality;
    private int requestFromDownloader;
    private boolean resolveFromDownloadedFile;
    private String spmid;
    private int teenagerMode;
    private long volumeBalance;

    public UGCResolverParams() {
        IjkMediaAsset.VideoCodecType videoCodecType;
        this.codecType = BiliCodec.Companion.getDEFAULT-eY-7Wcs();
        this.mFrom = "vupload";
        this.fnVer = IjkFnHelper.INSTANCE.getFnVer();
        this.fnVal = IjkFnHelper.INSTANCE.getFnVal();
        this.teenagerMode = TeenagersMode.getInstance().isEnable() ? 1 : 0;
        this.volumeBalance = IjkOptionsHelper.getVolumeBalance() ? 1L : 0L;
        if (!IjkFnHelper.INSTANCE.getAv1Support() || IjkFnHelper.INSTANCE.getAv1SupportSoft()) {
            videoCodecType = IjkOptionsHelper.isHevcEnable(BiliContext.application()) ? IjkMediaAsset.VideoCodecType.H265 : IjkMediaAsset.VideoCodecType.H264;
        } else {
            videoCodecType = IjkMediaAsset.VideoCodecType.AV1;
        }
        this.preferCodecType = videoCodecType;
        this.business = Business.UNKNOWN;
    }

    /* renamed from: getCodecType-eY-7Wcs  reason: not valid java name */
    public int m2698getCodecTypeeY7Wcs() {
        return this.codecType;
    }

    /* renamed from: setCodecType-N6j8eWo  reason: not valid java name */
    public void m2699setCodecTypeN6j8eWo(int i) {
        this.codecType = i;
    }

    public int getFormat() {
        return this.format;
    }

    public void setFormat(int i) {
        this.format = i;
    }

    public final String getMFrom() {
        return this.mFrom;
    }

    public final void setMFrom(String str) {
        this.mFrom = str;
    }

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

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    public final long getRealQuality() {
        return this.realQuality;
    }

    public final void setRealQuality(long j) {
        this.realQuality = j;
    }

    public final int getFnVer() {
        return this.fnVer;
    }

    public final void setFnVer(int i) {
        this.fnVer = i;
    }

    public final int getFnVal() {
        return this.fnVal;
    }

    public final void setFnVal(int i) {
        this.fnVal = i;
    }

    public final int getRequestFromDownloader() {
        return this.requestFromDownloader;
    }

    public final void setRequestFromDownloader(int i) {
        this.requestFromDownloader = i;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final void setFromSpmid(String str) {
        this.fromSpmid = str;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final void setSpmid(String str) {
        this.spmid = str;
    }

    public final int getTeenagerMode() {
        return this.teenagerMode;
    }

    public final void setTeenagerMode(int i) {
        this.teenagerMode = i;
    }

    public final long getVolumeBalance() {
        return this.volumeBalance;
    }

    public final void setVolumeBalance(long j) {
        this.volumeBalance = j;
    }

    public final IjkMediaAsset.VideoCodecType getPreferCodecType() {
        return this.preferCodecType;
    }

    public final void setPreferCodecType(IjkMediaAsset.VideoCodecType videoCodecType) {
        Intrinsics.checkNotNullParameter(videoCodecType, "<set-?>");
        this.preferCodecType = videoCodecType;
    }

    public final IjkMediaAsset.VideoCodecType getFinalCodecType() {
        int m2698getCodecTypeeY7Wcs = m2698getCodecTypeeY7Wcs();
        return BiliCodec.equals-impl0(m2698getCodecTypeeY7Wcs, BiliCodec.Companion.getH264-eY-7Wcs()) ? IjkMediaAsset.VideoCodecType.H264 : BiliCodec.equals-impl0(m2698getCodecTypeeY7Wcs, BiliCodec.Companion.getH265-eY-7Wcs()) ? IjkMediaAsset.VideoCodecType.H265 : this.preferCodecType;
    }

    public final Business getBusiness() {
        return this.business;
    }

    public final void setBusiness(Business business) {
        Intrinsics.checkNotNullParameter(business, "<set-?>");
        this.business = business;
    }

    public final boolean getResolveFromDownloadedFile() {
        return this.resolveFromDownloadedFile;
    }

    public final void setResolveFromDownloadedFile(boolean z) {
        this.resolveFromDownloadedFile = z;
    }

    public final boolean getForceLocalOnly() {
        return this.forceLocalOnly;
    }

    public final void setForceLocalOnly(boolean z) {
        this.forceLocalOnly = z;
    }

    public String getId() {
        long j = this.avid;
        return j + "+" + this.cid;
    }

    public String getFrom() {
        String str = this.mFrom;
        return str == null ? "vupload" : str;
    }

    public int getDomainParams() {
        return this.domainParams;
    }

    public void setDomainParams(int i) {
        this.domainParams = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCResolverParams(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.mFrom = parcel.readString();
        this.avid = parcel.readLong();
        this.cid = parcel.readLong();
        this.page = parcel.readInt();
        this.realQuality = parcel.readLong();
        this.fnVer = parcel.readInt();
        this.fnVal = parcel.readInt();
        this.requestFromDownloader = parcel.readInt();
        setDomainParams(parcel.readInt());
        this.fromSpmid = parcel.readString();
        this.spmid = parcel.readString();
        this.teenagerMode = parcel.readInt();
        this.volumeBalance = parcel.readLong();
        int preferCodecTypeOrdinal = parcel.readInt();
        this.preferCodecType = IjkMediaAsset.VideoCodecType.values()[preferCodecTypeOrdinal];
        int businessOrdinal = parcel.readInt();
        this.business = Business.values()[businessOrdinal];
    }

    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.mFrom);
        parcel.writeLong(this.avid);
        parcel.writeLong(this.cid);
        parcel.writeInt(this.page);
        parcel.writeLong(this.realQuality);
        parcel.writeInt(this.fnVer);
        parcel.writeInt(this.fnVal);
        parcel.writeInt(this.requestFromDownloader);
        parcel.writeInt(getDomainParams());
        parcel.writeString(this.fromSpmid);
        parcel.writeString(this.spmid);
        parcel.writeInt(this.teenagerMode);
        parcel.writeLong(this.volumeBalance);
        parcel.writeInt(this.preferCodecType.ordinal());
        parcel.writeInt(this.business.ordinal());
    }

    public int describeContents() {
        return 0;
    }

    /* compiled from: UGCResolverParams.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/video/resolver/UGCResolverParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/video/resolver/UGCResolverParams;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/video/resolver/UGCResolverParams;", "ugcresolver_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CREATOR implements Parcelable.Creator<UGCResolverParams> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public UGCResolverParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UGCResolverParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UGCResolverParams[] newArray(int size) {
            return new UGCResolverParams[size];
        }
    }
}