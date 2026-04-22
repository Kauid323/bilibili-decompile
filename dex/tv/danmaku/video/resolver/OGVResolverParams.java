package tv.danmaku.video.resolver;

import android.os.Parcel;
import android.os.Parcelable;
import com.bapis.bilibili.pgc.gateway.player.v2.InlineScene;
import com.bilibili.lib.media.resolver2.BiliCodec;
import com.bilibili.lib.media.resolver2.IResolveParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.view.ViewHolderUgcKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: OGVResolverParams.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 |2\u00020\u0001:\u0001|B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u000eJ\u0018\u0010y\u001a\u00020w2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010z\u001a\u00020\u000eH\u0016J\b\u0010{\u001a\u00020\u000eH\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u0015X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010+\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R\u001a\u0010.\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u0010\u0013R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\n\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\n\"\u0004\b=\u0010:R\u001a\u0010>\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001a\u0010@\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010$R\u001c\u0010C\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\n\"\u0004\bE\u0010:R\u001e\u0010F\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010L\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\n\"\u0004\bN\u0010:R\u001a\u0010O\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00104\"\u0004\bP\u00106R\u001a\u0010Q\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00104\"\u0004\bS\u00106R\u001a\u0010T\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00104\"\u0004\bU\u00106R\u001c\u0010V\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\n\"\u0004\bX\u0010:R\u001a\u0010Y\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00104\"\u0004\bZ\u00106R\u001a\u0010[\u001a\u00020\\X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001a\u0010a\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\"\"\u0004\bc\u0010$R\u001c\u0010d\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\n\"\u0004\bf\u0010:R\u001a\u0010g\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00104\"\u0004\bi\u00106R\u001a\u0010j\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0011\"\u0004\bl\u0010\u0013R\u001a\u0010m\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u00104\"\u0004\bo\u00106R\u001c\u0010p\u001a\u0004\u0018\u00010qX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010u¨\u0006}"}, d2 = {"Ltv/danmaku/video/resolver/OGVResolverParams;", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "from", "", "getFrom", "()Ljava/lang/String;", "id", "getId", "value", "", "domainParams", "getDomainParams", "()I", "setDomainParams", "(I)V", "codecType", "Lcom/bilibili/lib/media/resolver2/BiliCodec;", "getCodecType-eY-7Wcs", "setCodecType-N6j8eWo", "I", IjkMediaMeta.IJKM_KEY_FORMAT, "getFormat", "setFormat", "expectedQuality", "getExpectedQuality", "setExpectedQuality", "epId", "", "getEpId", "()J", "setEpId", "(J)V", "seasonId", "getSeasonId", "setSeasonId", "cid", "getCid", "setCid", "fnVer", "getFnVer", "setFnVer", "fnVal", "getFnVal", "setFnVal", "requestFromDownloader", "", "getRequestFromDownloader", "()Z", "setRequestFromDownloader", "(Z)V", "spmid", "getSpmid", "setSpmid", "(Ljava/lang/String;)V", "fromSpmid", "getFromSpmid", "setFromSpmid", "isNeedViewInfo", "setNeedViewInfo", "roomId", "getRoomId", "setRoomId", "entryFrom", "getEntryFrom", "setEntryFrom", "avid", "getAvid", "()Ljava/lang/Long;", "setAvid", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "rawVid", "getRawVid", "setRawVid", "isPlaylist", "setPlaylist", "smallWindow", "getSmallWindow", "setSmallWindow", "isPip", "setPip", "vid", "getVid", "setVid", "isHeInline", "setHeInline", "inlineScene", "Lcom/bapis/bilibili/pgc/gateway/player/v2/InlineScene;", "getInlineScene", "()Lcom/bapis/bilibili/pgc/gateway/player/v2/InlineScene;", "setInlineScene", "(Lcom/bapis/bilibili/pgc/gateway/player/v2/InlineScene;)V", "materialId", "getMaterialId", "setMaterialId", "sessionId", "getSessionId", "setSessionId", "qualityTrial", "getQualityTrial", "setQualityTrial", "page", "getPage", "setPage", "resolveFromDownloadedFile", "getResolveFromDownloadedFile", "setResolveFromDownloadedFile", "preloadedResolveResult", "", "getPreloadedResolveResult", "()Ljava/lang/Object;", "setPreloadedResolveResult", "(Ljava/lang/Object;)V", "setInlineSceneByNumber", "", "number", "writeToParcel", "flags", "describeContents", "CREATOR", "ugcresolver_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OGVResolverParams implements IResolveParams {
    public static final CREATOR CREATOR = new CREATOR(null);
    private Long avid;
    private long cid;
    private int codecType;
    private String entryFrom;
    private long epId;
    private int expectedQuality;
    private int fnVal;
    private int fnVer;
    private int format;
    private final String from;
    private String fromSpmid;
    private InlineScene inlineScene;
    private boolean isHeInline;
    private boolean isNeedViewInfo;
    private boolean isPip;
    private boolean isPlaylist;
    private long materialId;
    private int page;
    private Object preloadedResolveResult;
    private boolean qualityTrial;
    private String rawVid;
    private boolean requestFromDownloader;
    private boolean resolveFromDownloadedFile;
    private long roomId;
    private long seasonId;
    private String sessionId;
    private boolean smallWindow;
    private String spmid;
    private String vid;

    public OGVResolverParams() {
        this.from = ViewHolderUgcKt.GOTO_BANGUMI;
        this.codecType = BiliCodec.Companion.getDEFAULT-eY-7Wcs();
        this.isNeedViewInfo = true;
        this.inlineScene = InlineScene.UNKNOWN;
        this.page = 1;
    }

    public String getFrom() {
        return this.from;
    }

    public String getId() {
        long j = this.cid;
        String from = getFrom();
        int i = this.expectedQuality;
        return j + from + i + this.requestFromDownloader;
    }

    public int getDomainParams() {
        return 0;
    }

    public void setDomainParams(int value) {
    }

    /* renamed from: getCodecType-eY-7Wcs  reason: not valid java name */
    public int m2696getCodecTypeeY7Wcs() {
        return this.codecType;
    }

    /* renamed from: setCodecType-N6j8eWo  reason: not valid java name */
    public void m2697setCodecTypeN6j8eWo(int i) {
        this.codecType = i;
    }

    public int getFormat() {
        return this.format;
    }

    public void setFormat(int i) {
        this.format = i;
    }

    public final int getExpectedQuality() {
        return this.expectedQuality;
    }

    public final void setExpectedQuality(int i) {
        this.expectedQuality = i;
    }

    public final long getEpId() {
        return this.epId;
    }

    public final void setEpId(long j) {
        this.epId = j;
    }

    public final long getSeasonId() {
        return this.seasonId;
    }

    public final void setSeasonId(long j) {
        this.seasonId = j;
    }

    public final long getCid() {
        return this.cid;
    }

    public final void setCid(long j) {
        this.cid = j;
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

    public final boolean getRequestFromDownloader() {
        return this.requestFromDownloader;
    }

    public final void setRequestFromDownloader(boolean z) {
        this.requestFromDownloader = z;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final void setSpmid(String str) {
        this.spmid = str;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final void setFromSpmid(String str) {
        this.fromSpmid = str;
    }

    public final boolean isNeedViewInfo() {
        return this.isNeedViewInfo;
    }

    public final void setNeedViewInfo(boolean z) {
        this.isNeedViewInfo = z;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final void setRoomId(long j) {
        this.roomId = j;
    }

    public final String getEntryFrom() {
        return this.entryFrom;
    }

    public final void setEntryFrom(String str) {
        this.entryFrom = str;
    }

    public final Long getAvid() {
        return this.avid;
    }

    public final void setAvid(Long l) {
        this.avid = l;
    }

    public final String getRawVid() {
        return this.rawVid;
    }

    public final void setRawVid(String str) {
        this.rawVid = str;
    }

    public final boolean isPlaylist() {
        return this.isPlaylist;
    }

    public final void setPlaylist(boolean z) {
        this.isPlaylist = z;
    }

    public final boolean getSmallWindow() {
        return this.smallWindow;
    }

    public final void setSmallWindow(boolean z) {
        this.smallWindow = z;
    }

    public final boolean isPip() {
        return this.isPip;
    }

    public final void setPip(boolean z) {
        this.isPip = z;
    }

    public final String getVid() {
        return this.vid;
    }

    public final void setVid(String str) {
        this.vid = str;
    }

    public final boolean isHeInline() {
        return this.isHeInline;
    }

    public final void setHeInline(boolean z) {
        this.isHeInline = z;
    }

    public final InlineScene getInlineScene() {
        return this.inlineScene;
    }

    public final void setInlineScene(InlineScene inlineScene) {
        Intrinsics.checkNotNullParameter(inlineScene, "<set-?>");
        this.inlineScene = inlineScene;
    }

    public final long getMaterialId() {
        return this.materialId;
    }

    public final void setMaterialId(long j) {
        this.materialId = j;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final boolean getQualityTrial() {
        return this.qualityTrial;
    }

    public final void setQualityTrial(boolean z) {
        this.qualityTrial = z;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    public final boolean getResolveFromDownloadedFile() {
        return this.resolveFromDownloadedFile;
    }

    public final void setResolveFromDownloadedFile(boolean z) {
        this.resolveFromDownloadedFile = z;
    }

    public final Object getPreloadedResolveResult() {
        return this.preloadedResolveResult;
    }

    public final void setPreloadedResolveResult(Object obj) {
        this.preloadedResolveResult = obj;
    }

    public final void setInlineSceneByNumber(int number) {
        InlineScene forNumber = InlineScene.forNumber(number);
        if (forNumber == null) {
            forNumber = InlineScene.UNKNOWN;
        }
        this.inlineScene = forNumber;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OGVResolverParams(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.expectedQuality = parcel.readInt();
        this.epId = parcel.readLong();
        this.cid = parcel.readLong();
        this.fnVer = parcel.readInt();
        this.fnVal = parcel.readInt();
        this.requestFromDownloader = parcel.readByte() != 0;
        this.spmid = parcel.readString();
        this.fromSpmid = parcel.readString();
        this.isNeedViewInfo = parcel.readByte() != 0;
        this.roomId = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.expectedQuality);
        parcel.writeLong(this.epId);
        parcel.writeLong(this.cid);
        parcel.writeInt(this.fnVer);
        parcel.writeInt(this.fnVal);
        parcel.writeByte(this.requestFromDownloader ? (byte) 1 : (byte) 0);
        parcel.writeString(this.spmid);
        parcel.writeString(this.fromSpmid);
        parcel.writeByte(this.isNeedViewInfo ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.roomId);
    }

    public int describeContents() {
        return 0;
    }

    /* compiled from: OGVResolverParams.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/video/resolver/OGVResolverParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/video/resolver/OGVResolverParams;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/video/resolver/OGVResolverParams;", "ugcresolver_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CREATOR implements Parcelable.Creator<OGVResolverParams> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public OGVResolverParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OGVResolverParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public OGVResolverParams[] newArray(int size) {
            return new OGVResolverParams[size];
        }
    }
}