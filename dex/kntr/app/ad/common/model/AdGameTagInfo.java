package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkntr/app/ad/common/model/AdGameTagInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdGameTagInfo {
    private final String text;

    public static /* synthetic */ AdGameTagInfo copy$default(AdGameTagInfo adGameTagInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adGameTagInfo.text;
        }
        return adGameTagInfo.copy(str);
    }

    public final String component1() {
        return this.text;
    }

    public final AdGameTagInfo copy(String str) {
        return new AdGameTagInfo(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AdGameTagInfo) && Intrinsics.areEqual(this.text, ((AdGameTagInfo) obj).text);
    }

    public int hashCode() {
        if (this.text == null) {
            return 0;
        }
        return this.text.hashCode();
    }

    public String toString() {
        return "AdGameTagInfo(text=" + this.text + ")";
    }

    public AdGameTagInfo(String text) {
        this.text = text;
    }

    public final String getText() {
        return this.text;
    }
}