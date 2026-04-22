package tv.danmaku.bili.auth.modify;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: SelectPhotoAdapter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/modify/PhotoType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PHOTO", "ALBUM", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum PhotoType {
    PHOTO(0),
    ALBUM(1);
    
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<PhotoType> getEntries() {
        return $ENTRIES;
    }

    PhotoType(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }
}