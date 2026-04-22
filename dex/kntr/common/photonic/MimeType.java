package kntr.common.photonic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MimeType.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0005H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lkntr/common/photonic/MimeType;", "", "type", "Lkntr/common/photonic/AssetType;", "subType", "", "<init>", "(Lkntr/common/photonic/AssetType;Ljava/lang/String;)V", "getType", "()Lkntr/common/photonic/AssetType;", "getSubType", "()Ljava/lang/String;", "toString", "validMimeType", "", "getValidMimeType", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "Companion", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MimeType {
    public static final int $stable = 0;
    private final String subType;
    private final AssetType type;
    public static final Companion Companion = new Companion(null);
    private static final MimeType UNKNOWN = new MimeType(AssetType.Unknown, "");
    private static final MimeType LivePhoto = new MimeType(AssetType.LivePhoto, "");
    private static final HashMap<String, MimeType> pool = new HashMap<>();
    private static final MimeType JPEG = new MimeType(AssetType.Image, "jpeg");
    private static final MimeType JPG = new MimeType(AssetType.Image, "jpg");
    private static final MimeType PNG = new MimeType(AssetType.Image, "png");
    private static final MimeType GIF = new MimeType(AssetType.Image, "gif");
    private static final MimeType HEIF = new MimeType(AssetType.Image, "heif");
    private static final MimeType HEIC = new MimeType(AssetType.Image, "heic");
    private static final MimeType MP4 = new MimeType(AssetType.Video, "mp4");
    private static final MimeType MPEG = new MimeType(AssetType.Video, "mpeg");
    private static final MimeType MOV = new MimeType(AssetType.Video, "mov");
    private static final MimeType MKV = new MimeType(AssetType.Video, "x-matroska");
    private static final List<MimeType> ALL = CollectionsKt.listOf(new MimeType[]{JPEG, JPG, PNG, GIF, HEIF, HEIC, MP4, MPEG, MOV, MKV});
    private static final List<MimeType> IMAGES = CollectionsKt.listOf(new MimeType[]{JPEG, JPG, PNG, GIF, HEIF, HEIC});
    private static final List<MimeType> VIDEOS = CollectionsKt.listOf(new MimeType[]{MP4, MPEG, MOV, MKV});

    public static /* synthetic */ MimeType copy$default(MimeType mimeType, AssetType assetType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            assetType = mimeType.type;
        }
        if ((i & 2) != 0) {
            str = mimeType.subType;
        }
        return mimeType.copy(assetType, str);
    }

    public final AssetType component1() {
        return this.type;
    }

    public final String component2() {
        return this.subType;
    }

    public final MimeType copy(AssetType assetType, String str) {
        Intrinsics.checkNotNullParameter(assetType, "type");
        Intrinsics.checkNotNullParameter(str, "subType");
        return new MimeType(assetType, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MimeType) {
            MimeType mimeType = (MimeType) obj;
            return this.type == mimeType.type && Intrinsics.areEqual(this.subType, mimeType.subType);
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.subType.hashCode();
    }

    public MimeType(AssetType type, String subType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subType, "subType");
        this.type = type;
        this.subType = subType;
    }

    public final AssetType getType() {
        return this.type;
    }

    public final String getSubType() {
        return this.subType;
    }

    /* compiled from: MimeType.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\b\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fJ\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050)*\b\u0012\u0004\u0012\u00020\u00050)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050)¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050)¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+¨\u00061"}, d2 = {"Lkntr/common/photonic/MimeType$Companion;", "", "<init>", "()V", "UNKNOWN", "Lkntr/common/photonic/MimeType;", "getUNKNOWN", "()Lkntr/common/photonic/MimeType;", "LivePhoto", "getLivePhoto", "pool", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "fromString", "mimeType", "obtain", "type", "Lkntr/common/photonic/AssetType;", "subType", "JPEG", "getJPEG", "JPG", "getJPG", "PNG", "getPNG", "GIF", "getGIF", "HEIF", "getHEIF", "HEIC", "getHEIC", "MP4", "getMP4", "MPEG", "getMPEG", "MOV", "getMOV", "MKV", "getMKV", "ALL", "", "getALL", "()Ljava/util/List;", "IMAGES", "getIMAGES", "VIDEOS", "getVIDEOS", "noGifs", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {

        /* compiled from: MimeType.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AssetType.values().length];
                try {
                    iArr[AssetType.Image.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[AssetType.Video.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MimeType getUNKNOWN() {
            return MimeType.UNKNOWN;
        }

        public final MimeType getLivePhoto() {
            return MimeType.LivePhoto;
        }

        public final MimeType fromString(String mimeType) {
            AssetType type;
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            MimeType cache = (MimeType) MimeType.pool.get(mimeType);
            if (cache != null) {
                return cache;
            }
            List parts = StringsKt.split$default(mimeType, new String[]{"/"}, false, 0, 6, (Object) null);
            if (parts.size() != 2) {
                return getUNKNOWN();
            }
            String str = (String) parts.get(0);
            if (Intrinsics.areEqual(str, "image")) {
                type = AssetType.Image;
            } else {
                type = Intrinsics.areEqual(str, "video") ? AssetType.Video : AssetType.Unknown;
            }
            MimeType $this$fromString_u24lambda_u240 = obtain(type, (String) parts.get(1));
            MimeType.pool.put(mimeType, $this$fromString_u24lambda_u240);
            return $this$fromString_u24lambda_u240;
        }

        public final MimeType obtain(AssetType type, String subType) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(subType, "subType");
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    switch (subType.hashCode()) {
                        case 102340:
                            if (subType.equals("gif")) {
                                return getGIF();
                            }
                            break;
                        case 105441:
                            if (subType.equals("jpg")) {
                                return getJPG();
                            }
                            break;
                        case 111145:
                            if (subType.equals("png")) {
                                return getPNG();
                            }
                            break;
                        case 3198679:
                            if (subType.equals("heic")) {
                                return getHEIC();
                            }
                            break;
                        case 3198682:
                            if (subType.equals("heif")) {
                                return getHEIF();
                            }
                            break;
                        case 3268712:
                            if (subType.equals("jpeg")) {
                                return getJPEG();
                            }
                            break;
                    }
                    return new MimeType(type, subType);
                case 2:
                    switch (subType.hashCode()) {
                        case -1526863359:
                            if (subType.equals("x-matroska")) {
                                return getMKV();
                            }
                            break;
                        case 108273:
                            if (subType.equals("mp4")) {
                                return getMP4();
                            }
                            break;
                        case 108308:
                            if (subType.equals("mov")) {
                                return getMOV();
                            }
                            break;
                        case 3358085:
                            if (subType.equals("mpeg")) {
                                return getMPEG();
                            }
                            break;
                    }
                    return new MimeType(type, subType);
                default:
                    return new MimeType(type, subType);
            }
        }

        public final MimeType getJPEG() {
            return MimeType.JPEG;
        }

        public final MimeType getJPG() {
            return MimeType.JPG;
        }

        public final MimeType getPNG() {
            return MimeType.PNG;
        }

        public final MimeType getGIF() {
            return MimeType.GIF;
        }

        public final MimeType getHEIF() {
            return MimeType.HEIF;
        }

        public final MimeType getHEIC() {
            return MimeType.HEIC;
        }

        public final MimeType getMP4() {
            return MimeType.MP4;
        }

        public final MimeType getMPEG() {
            return MimeType.MPEG;
        }

        public final MimeType getMOV() {
            return MimeType.MOV;
        }

        public final MimeType getMKV() {
            return MimeType.MKV;
        }

        public final List<MimeType> getALL() {
            return MimeType.ALL;
        }

        public final List<MimeType> getIMAGES() {
            return MimeType.IMAGES;
        }

        public final List<MimeType> getVIDEOS() {
            return MimeType.VIDEOS;
        }

        public final List<MimeType> noGifs(List<MimeType> list) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            List<MimeType> $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                MimeType it = (MimeType) element$iv$iv;
                if (!Intrinsics.areEqual(it, MimeType.Companion.getGIF())) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            return (List) destination$iv$iv;
        }
    }

    public String toString() {
        String typeString = this.type.getTypeString();
        return typeString + "/" + this.subType;
    }

    public final boolean getValidMimeType() {
        return this.type.getValidMimeType();
    }
}