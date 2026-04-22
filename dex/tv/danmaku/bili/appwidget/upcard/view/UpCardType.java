package tv.danmaku.bili.appwidget.upcard.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: UpCardWidgetView.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/appwidget/upcard/view/UpCardType;", "", "picNum", "", "type", "Ltv/danmaku/bili/appwidget/upcard/view/PicType;", "titleLines", "<init>", "(Ljava/lang/String;IILtv/danmaku/bili/appwidget/upcard/view/PicType;I)V", "getPicNum", "()I", "getType", "()Ltv/danmaku/bili/appwidget/upcard/view/PicType;", "getTitleLines", "ONE_PIC_CARD", "ONE_PIC_CARD_L", "TWO_PIC_CARD", "TWO_PIC_CARD_L", "NO_LOGIN_CARD", "NO_UPDATE_CARD", "ONE_PIC_CARD_V2", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum UpCardType {
    ONE_PIC_CARD(1, PicType.PIC_16_9, 2),
    ONE_PIC_CARD_L(1, PicType.PIC_4_3, 3),
    TWO_PIC_CARD(2, PicType.PIC_16_9, 1),
    TWO_PIC_CARD_L(2, PicType.PIC_4_3, 1),
    NO_LOGIN_CARD(0, null, 0, 6, null),
    NO_UPDATE_CARD(0, null, 0, 6, null),
    ONE_PIC_CARD_V2(1, PicType.PIC_3_4, 1);
    
    private final int picNum;
    private final int titleLines;
    private final PicType type;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<UpCardType> getEntries() {
        return $ENTRIES;
    }

    UpCardType(int picNum, PicType type, int titleLines) {
        this.picNum = picNum;
        this.type = type;
        this.titleLines = titleLines;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    /* synthetic */ UpCardType(int i, PicType picType, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, r4, r5);
        PicType picType2;
        int i4;
        if ((i3 & 2) == 0) {
            picType2 = picType;
        } else {
            picType2 = PicType.PIC_16_9;
        }
        if ((i3 & 4) == 0) {
            i4 = i2;
        } else {
            i4 = 2;
        }
    }

    public final int getPicNum() {
        return this.picNum;
    }

    public final PicType getType() {
        return this.type;
    }

    public final int getTitleLines() {
        return this.titleLines;
    }
}