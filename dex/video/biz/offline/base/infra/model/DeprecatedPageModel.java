package video.biz.offline.base.infra.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: DeprecatedEntryModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 S2\u00020\u0001:\u0002RSB\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014B\u008f\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\u008b\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006HÆ\u0001J\u0013\u0010F\u001a\u00020\u000b2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\rHÖ\u0001J\t\u0010I\u001a\u00020\u0006HÖ\u0001J%\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0001¢\u0006\u0002\bQR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001c\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010!R\u001c\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010!R\u001c\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010!R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010*R\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010-R\u001c\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001cR\u001c\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010\u001cR\u001c\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010\u001cR\u001c\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001a\u001a\u0004\b5\u0010!R\u001c\u0010\u0012\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u0010!¨\u0006T"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedPageModel;", "", "cid", "", "page", "from", "", "part", "link", "richVid", "hasAlias", "", "tid", "", "width", "height", "rotate", "downloadTitle", "downloadSubtitle", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIJJJLjava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIJJJLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCid$annotations", "()V", "getCid", "()J", "getPage$annotations", "getPage", "getFrom$annotations", "getFrom", "()Ljava/lang/String;", "getPart$annotations", "getPart", "getLink$annotations", "getLink", "getRichVid$annotations", "getRichVid", "getHasAlias$annotations", "getHasAlias", "()Z", "getTid$annotations", "getTid", "()I", "getWidth$annotations", "getWidth", "getHeight$annotations", "getHeight", "getRotate$annotations", "getRotate", "getDownloadTitle$annotations", "getDownloadTitle", "getDownloadSubtitle$annotations", "getDownloadSubtitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$infra_debug", "$serializer", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class DeprecatedPageModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long cid;
    private final String downloadSubtitle;
    private final String downloadTitle;
    private final String from;
    private final boolean hasAlias;
    private final long height;
    private final String link;
    private final long page;
    private final String part;
    private final String richVid;
    private final long rotate;
    private final int tid;
    private final long width;

    public DeprecatedPageModel() {
        this(0L, 0L, (String) null, (String) null, (String) null, (String) null, false, 0, 0L, 0L, 0L, (String) null, (String) null, 8191, (DefaultConstructorMarker) null);
    }

    @SerialName("cid")
    public static /* synthetic */ void getCid$annotations() {
    }

    @SerialName("download_subtitle")
    public static /* synthetic */ void getDownloadSubtitle$annotations() {
    }

    @SerialName("download_title")
    public static /* synthetic */ void getDownloadTitle$annotations() {
    }

    @SerialName("from")
    public static /* synthetic */ void getFrom$annotations() {
    }

    @SerialName("has_alias")
    public static /* synthetic */ void getHasAlias$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("link")
    public static /* synthetic */ void getLink$annotations() {
    }

    @SerialName("page")
    public static /* synthetic */ void getPage$annotations() {
    }

    @SerialName("part")
    public static /* synthetic */ void getPart$annotations() {
    }

    @SerialName("rich_vid")
    public static /* synthetic */ void getRichVid$annotations() {
    }

    @SerialName("rotate")
    public static /* synthetic */ void getRotate$annotations() {
    }

    @SerialName("tid")
    public static /* synthetic */ void getTid$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final long component1() {
        return this.cid;
    }

    public final long component10() {
        return this.height;
    }

    public final long component11() {
        return this.rotate;
    }

    public final String component12() {
        return this.downloadTitle;
    }

    public final String component13() {
        return this.downloadSubtitle;
    }

    public final long component2() {
        return this.page;
    }

    public final String component3() {
        return this.from;
    }

    public final String component4() {
        return this.part;
    }

    public final String component5() {
        return this.link;
    }

    public final String component6() {
        return this.richVid;
    }

    public final boolean component7() {
        return this.hasAlias;
    }

    public final int component8() {
        return this.tid;
    }

    public final long component9() {
        return this.width;
    }

    public final DeprecatedPageModel copy(long j, long j2, String str, String str2, String str3, String str4, boolean z, int i, long j3, long j4, long j5, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(str2, "part");
        Intrinsics.checkNotNullParameter(str3, "link");
        Intrinsics.checkNotNullParameter(str4, "richVid");
        Intrinsics.checkNotNullParameter(str5, "downloadTitle");
        Intrinsics.checkNotNullParameter(str6, "downloadSubtitle");
        return new DeprecatedPageModel(j, j2, str, str2, str3, str4, z, i, j3, j4, j5, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeprecatedPageModel) {
            DeprecatedPageModel deprecatedPageModel = (DeprecatedPageModel) obj;
            return this.cid == deprecatedPageModel.cid && this.page == deprecatedPageModel.page && Intrinsics.areEqual(this.from, deprecatedPageModel.from) && Intrinsics.areEqual(this.part, deprecatedPageModel.part) && Intrinsics.areEqual(this.link, deprecatedPageModel.link) && Intrinsics.areEqual(this.richVid, deprecatedPageModel.richVid) && this.hasAlias == deprecatedPageModel.hasAlias && this.tid == deprecatedPageModel.tid && this.width == deprecatedPageModel.width && this.height == deprecatedPageModel.height && this.rotate == deprecatedPageModel.rotate && Intrinsics.areEqual(this.downloadTitle, deprecatedPageModel.downloadTitle) && Intrinsics.areEqual(this.downloadSubtitle, deprecatedPageModel.downloadSubtitle);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.page)) * 31) + this.from.hashCode()) * 31) + this.part.hashCode()) * 31) + this.link.hashCode()) * 31) + this.richVid.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasAlias)) * 31) + this.tid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.width)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.height)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.rotate)) * 31) + this.downloadTitle.hashCode()) * 31) + this.downloadSubtitle.hashCode();
    }

    public String toString() {
        long j = this.cid;
        long j2 = this.page;
        String str = this.from;
        String str2 = this.part;
        String str3 = this.link;
        String str4 = this.richVid;
        boolean z = this.hasAlias;
        int i = this.tid;
        long j3 = this.width;
        long j4 = this.height;
        long j5 = this.rotate;
        String str5 = this.downloadTitle;
        return "DeprecatedPageModel(cid=" + j + ", page=" + j2 + ", from=" + str + ", part=" + str2 + ", link=" + str3 + ", richVid=" + str4 + ", hasAlias=" + z + ", tid=" + i + ", width=" + j3 + ", height=" + j4 + ", rotate=" + j5 + ", downloadTitle=" + str5 + ", downloadSubtitle=" + this.downloadSubtitle + ")";
    }

    /* compiled from: DeprecatedEntryModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedPageModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/infra/model/DeprecatedPageModel;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeprecatedPageModel> serializer() {
            return DeprecatedPageModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DeprecatedPageModel(int seen0, long cid, long page, String from, String part, String link, String richVid, boolean hasAlias, int tid, long width, long height, long rotate, String downloadTitle, String downloadSubtitle, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.cid = 0L;
        } else {
            this.cid = cid;
        }
        if ((seen0 & 2) == 0) {
            this.page = 0L;
        } else {
            this.page = page;
        }
        if ((seen0 & 4) == 0) {
            this.from = "";
        } else {
            this.from = from;
        }
        if ((seen0 & 8) == 0) {
            this.part = "";
        } else {
            this.part = part;
        }
        if ((seen0 & 16) == 0) {
            this.link = "";
        } else {
            this.link = link;
        }
        if ((seen0 & 32) == 0) {
            this.richVid = "";
        } else {
            this.richVid = richVid;
        }
        if ((seen0 & 64) == 0) {
            this.hasAlias = false;
        } else {
            this.hasAlias = hasAlias;
        }
        if ((seen0 & 128) == 0) {
            this.tid = 0;
        } else {
            this.tid = tid;
        }
        if ((seen0 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            this.width = 0L;
        } else {
            this.width = width;
        }
        if ((seen0 & 512) == 0) {
            this.height = 0L;
        } else {
            this.height = height;
        }
        if ((seen0 & 1024) == 0) {
            this.rotate = 0L;
        } else {
            this.rotate = rotate;
        }
        if ((seen0 & IjkMediaMeta.FF_PROFILE_H264_INTRA) == 0) {
            this.downloadTitle = "";
        } else {
            this.downloadTitle = downloadTitle;
        }
        if ((seen0 & 4096) == 0) {
            this.downloadSubtitle = "";
        } else {
            this.downloadSubtitle = downloadSubtitle;
        }
    }

    public DeprecatedPageModel(long cid, long page, String from, String part, String link, String richVid, boolean hasAlias, int tid, long width, long height, long rotate, String downloadTitle, String downloadSubtitle) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(richVid, "richVid");
        Intrinsics.checkNotNullParameter(downloadTitle, "downloadTitle");
        Intrinsics.checkNotNullParameter(downloadSubtitle, "downloadSubtitle");
        this.cid = cid;
        this.page = page;
        this.from = from;
        this.part = part;
        this.link = link;
        this.richVid = richVid;
        this.hasAlias = hasAlias;
        this.tid = tid;
        this.width = width;
        this.height = height;
        this.rotate = rotate;
        this.downloadTitle = downloadTitle;
        this.downloadSubtitle = downloadSubtitle;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$infra_debug(DeprecatedPageModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.cid != 0) {
            output.encodeLongElement(serialDesc, 0, self.cid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.page != 0) {
            output.encodeLongElement(serialDesc, 1, self.page);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.from, "")) {
            output.encodeStringElement(serialDesc, 2, self.from);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.part, "")) {
            output.encodeStringElement(serialDesc, 3, self.part);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.link, "")) {
            output.encodeStringElement(serialDesc, 4, self.link);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.richVid, "")) {
            output.encodeStringElement(serialDesc, 5, self.richVid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.hasAlias) {
            output.encodeBooleanElement(serialDesc, 6, self.hasAlias);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.tid != 0) {
            output.encodeIntElement(serialDesc, 7, self.tid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.width != 0) {
            output.encodeLongElement(serialDesc, 8, self.width);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.height != 0) {
            output.encodeLongElement(serialDesc, 9, self.height);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.rotate != 0) {
            output.encodeLongElement(serialDesc, 10, self.rotate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.downloadTitle, "")) {
            output.encodeStringElement(serialDesc, 11, self.downloadTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.downloadSubtitle, "")) {
            output.encodeStringElement(serialDesc, 12, self.downloadSubtitle);
        }
    }

    public /* synthetic */ DeprecatedPageModel(long j, long j2, String str, String str2, String str3, String str4, boolean z, int i, long j3, long j4, long j5, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 0L : j2, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? false : z, (i2 & 128) == 0 ? i : 0, (i2 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? 0L : j3, (i2 & 512) != 0 ? 0L : j4, (i2 & 1024) != 0 ? 0L : j5, (i2 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? "" : str5, (i2 & 4096) != 0 ? "" : str6);
    }

    public final long getCid() {
        return this.cid;
    }

    public final long getPage() {
        return this.page;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getPart() {
        return this.part;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getRichVid() {
        return this.richVid;
    }

    public final boolean getHasAlias() {
        return this.hasAlias;
    }

    public final int getTid() {
        return this.tid;
    }

    public final long getWidth() {
        return this.width;
    }

    public final long getHeight() {
        return this.height;
    }

    public final long getRotate() {
        return this.rotate;
    }

    public final String getDownloadTitle() {
        return this.downloadTitle;
    }

    public final String getDownloadSubtitle() {
        return this.downloadSubtitle;
    }
}