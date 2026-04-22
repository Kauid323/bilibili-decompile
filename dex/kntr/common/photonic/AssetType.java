package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MimeType.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lkntr/common/photonic/AssetType;", "", "typeString", "", "validMimeType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getTypeString", "()Ljava/lang/String;", "getValidMimeType", "()Z", "Unknown", "Image", "Video", "LivePhoto", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum AssetType {
    Unknown("unknown", false),
    Image("image", false, 2, null),
    Video("video", false, 2, null),
    LivePhoto("unknown", false);
    
    private final String typeString;
    private final boolean validMimeType;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<AssetType> getEntries() {
        return $ENTRIES;
    }

    AssetType(String typeString, boolean validMimeType) {
        this.typeString = typeString;
        this.validMimeType = validMimeType;
    }

    /* synthetic */ AssetType(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    public final String getTypeString() {
        return this.typeString;
    }

    public final boolean getValidMimeType() {
        return this.validMimeType;
    }
}