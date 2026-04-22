package kntr.app.mall.mallDynamicPage.component.business.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MallFeedsModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 o2\u00020\u0001:\u0002noB÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019Bã\u0001\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0018\u0010\u001dJ\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jþ\u0001\u0010_\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010`J\u0013\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010d\u001a\u00020\u0003HÖ\u0001J\t\u0010e\u001a\u00020\u0005HÖ\u0001J%\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u00002\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020lH\u0001¢\u0006\u0002\bmR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010$\"\u0004\bF\u0010&R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010$\"\u0004\bH\u0010&R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&¨\u0006p"}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/business/bean/TagInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "tagType", RoomRecommendViewModel.EMPTY_CURSOR, "backImgUrl", RoomRecommendViewModel.EMPTY_CURSOR, "backImgWidth", "backImgHeight", "title", "cornerRadius", "useBoard", "boardDayColor1", "boardDayColor2", "boardNightColor1", "boardNightColor2", "backDayColor1", "backDayColor2", "backNightColor1", "backNightColor2", "titleDayColor1", "titleDayColor2", "titleNightColor1", "titleNightColor2", "location", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTagType", "()Ljava/lang/Integer;", "setTagType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBackImgUrl", "()Ljava/lang/String;", "setBackImgUrl", "(Ljava/lang/String;)V", "getBackImgWidth", "setBackImgWidth", "getBackImgHeight", "setBackImgHeight", "getTitle", "setTitle", "getCornerRadius", "setCornerRadius", "getUseBoard", "setUseBoard", "getBoardDayColor1", "setBoardDayColor1", "getBoardDayColor2", "setBoardDayColor2", "getBoardNightColor1", "setBoardNightColor1", "getBoardNightColor2", "setBoardNightColor2", "getBackDayColor1", "setBackDayColor1", "getBackDayColor2", "setBackDayColor2", "getBackNightColor1", "setBackNightColor1", "getBackNightColor2", "setBackNightColor2", "getTitleDayColor1", "setTitleDayColor1", "getTitleDayColor2", "setTitleDayColor2", "getTitleNightColor1", "setTitleNightColor1", "getTitleNightColor2", "setTitleNightColor2", "getLocation", "setLocation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/mallDynamicPage/component/business/bean/TagInfo;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class TagInfo {
    private String backDayColor1;
    private String backDayColor2;
    private Integer backImgHeight;
    private String backImgUrl;
    private Integer backImgWidth;
    private String backNightColor1;
    private String backNightColor2;
    private String boardDayColor1;
    private String boardDayColor2;
    private String boardNightColor1;
    private String boardNightColor2;
    private Integer cornerRadius;
    private String location;
    private Integer tagType;
    private String title;
    private String titleDayColor1;
    private String titleDayColor2;
    private String titleNightColor1;
    private String titleNightColor2;
    private Integer useBoard;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TagInfo() {
        this((Integer) null, (String) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1048575, (DefaultConstructorMarker) null);
    }

    public final Integer component1() {
        return this.tagType;
    }

    public final String component10() {
        return this.boardNightColor1;
    }

    public final String component11() {
        return this.boardNightColor2;
    }

    public final String component12() {
        return this.backDayColor1;
    }

    public final String component13() {
        return this.backDayColor2;
    }

    public final String component14() {
        return this.backNightColor1;
    }

    public final String component15() {
        return this.backNightColor2;
    }

    public final String component16() {
        return this.titleDayColor1;
    }

    public final String component17() {
        return this.titleDayColor2;
    }

    public final String component18() {
        return this.titleNightColor1;
    }

    public final String component19() {
        return this.titleNightColor2;
    }

    public final String component2() {
        return this.backImgUrl;
    }

    public final String component20() {
        return this.location;
    }

    public final Integer component3() {
        return this.backImgWidth;
    }

    public final Integer component4() {
        return this.backImgHeight;
    }

    public final String component5() {
        return this.title;
    }

    public final Integer component6() {
        return this.cornerRadius;
    }

    public final Integer component7() {
        return this.useBoard;
    }

    public final String component8() {
        return this.boardDayColor1;
    }

    public final String component9() {
        return this.boardDayColor2;
    }

    public final TagInfo copy(Integer num, String str, Integer num2, Integer num3, String str2, Integer num4, Integer num5, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        return new TagInfo(num, str, num2, num3, str2, num4, num5, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TagInfo) {
            TagInfo tagInfo = (TagInfo) obj;
            return Intrinsics.areEqual(this.tagType, tagInfo.tagType) && Intrinsics.areEqual(this.backImgUrl, tagInfo.backImgUrl) && Intrinsics.areEqual(this.backImgWidth, tagInfo.backImgWidth) && Intrinsics.areEqual(this.backImgHeight, tagInfo.backImgHeight) && Intrinsics.areEqual(this.title, tagInfo.title) && Intrinsics.areEqual(this.cornerRadius, tagInfo.cornerRadius) && Intrinsics.areEqual(this.useBoard, tagInfo.useBoard) && Intrinsics.areEqual(this.boardDayColor1, tagInfo.boardDayColor1) && Intrinsics.areEqual(this.boardDayColor2, tagInfo.boardDayColor2) && Intrinsics.areEqual(this.boardNightColor1, tagInfo.boardNightColor1) && Intrinsics.areEqual(this.boardNightColor2, tagInfo.boardNightColor2) && Intrinsics.areEqual(this.backDayColor1, tagInfo.backDayColor1) && Intrinsics.areEqual(this.backDayColor2, tagInfo.backDayColor2) && Intrinsics.areEqual(this.backNightColor1, tagInfo.backNightColor1) && Intrinsics.areEqual(this.backNightColor2, tagInfo.backNightColor2) && Intrinsics.areEqual(this.titleDayColor1, tagInfo.titleDayColor1) && Intrinsics.areEqual(this.titleDayColor2, tagInfo.titleDayColor2) && Intrinsics.areEqual(this.titleNightColor1, tagInfo.titleNightColor1) && Intrinsics.areEqual(this.titleNightColor2, tagInfo.titleNightColor2) && Intrinsics.areEqual(this.location, tagInfo.location);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((this.tagType == null ? 0 : this.tagType.hashCode()) * 31) + (this.backImgUrl == null ? 0 : this.backImgUrl.hashCode())) * 31) + (this.backImgWidth == null ? 0 : this.backImgWidth.hashCode())) * 31) + (this.backImgHeight == null ? 0 : this.backImgHeight.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.cornerRadius == null ? 0 : this.cornerRadius.hashCode())) * 31) + (this.useBoard == null ? 0 : this.useBoard.hashCode())) * 31) + (this.boardDayColor1 == null ? 0 : this.boardDayColor1.hashCode())) * 31) + (this.boardDayColor2 == null ? 0 : this.boardDayColor2.hashCode())) * 31) + (this.boardNightColor1 == null ? 0 : this.boardNightColor1.hashCode())) * 31) + (this.boardNightColor2 == null ? 0 : this.boardNightColor2.hashCode())) * 31) + (this.backDayColor1 == null ? 0 : this.backDayColor1.hashCode())) * 31) + (this.backDayColor2 == null ? 0 : this.backDayColor2.hashCode())) * 31) + (this.backNightColor1 == null ? 0 : this.backNightColor1.hashCode())) * 31) + (this.backNightColor2 == null ? 0 : this.backNightColor2.hashCode())) * 31) + (this.titleDayColor1 == null ? 0 : this.titleDayColor1.hashCode())) * 31) + (this.titleDayColor2 == null ? 0 : this.titleDayColor2.hashCode())) * 31) + (this.titleNightColor1 == null ? 0 : this.titleNightColor1.hashCode())) * 31) + (this.titleNightColor2 == null ? 0 : this.titleNightColor2.hashCode())) * 31) + (this.location != null ? this.location.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.tagType;
        String str = this.backImgUrl;
        Integer num2 = this.backImgWidth;
        Integer num3 = this.backImgHeight;
        String str2 = this.title;
        Integer num4 = this.cornerRadius;
        Integer num5 = this.useBoard;
        String str3 = this.boardDayColor1;
        String str4 = this.boardDayColor2;
        String str5 = this.boardNightColor1;
        String str6 = this.boardNightColor2;
        String str7 = this.backDayColor1;
        String str8 = this.backDayColor2;
        String str9 = this.backNightColor1;
        String str10 = this.backNightColor2;
        String str11 = this.titleDayColor1;
        String str12 = this.titleDayColor2;
        String str13 = this.titleNightColor1;
        String str14 = this.titleNightColor2;
        return "TagInfo(tagType=" + num + ", backImgUrl=" + str + ", backImgWidth=" + num2 + ", backImgHeight=" + num3 + ", title=" + str2 + ", cornerRadius=" + num4 + ", useBoard=" + num5 + ", boardDayColor1=" + str3 + ", boardDayColor2=" + str4 + ", boardNightColor1=" + str5 + ", boardNightColor2=" + str6 + ", backDayColor1=" + str7 + ", backDayColor2=" + str8 + ", backNightColor1=" + str9 + ", backNightColor2=" + str10 + ", titleDayColor1=" + str11 + ", titleDayColor2=" + str12 + ", titleNightColor1=" + str13 + ", titleNightColor2=" + str14 + ", location=" + this.location + ")";
    }

    /* compiled from: MallFeedsModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/business/bean/TagInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/component/business/bean/TagInfo;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TagInfo> serializer() {
            return TagInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ TagInfo(int seen0, Integer tagType, String backImgUrl, Integer backImgWidth, Integer backImgHeight, String title, Integer cornerRadius, Integer useBoard, String boardDayColor1, String boardDayColor2, String boardNightColor1, String boardNightColor2, String backDayColor1, String backDayColor2, String backNightColor1, String backNightColor2, String titleDayColor1, String titleDayColor2, String titleNightColor1, String titleNightColor2, String location, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.tagType = null;
        } else {
            this.tagType = tagType;
        }
        if ((seen0 & 2) == 0) {
            this.backImgUrl = null;
        } else {
            this.backImgUrl = backImgUrl;
        }
        if ((seen0 & 4) == 0) {
            this.backImgWidth = null;
        } else {
            this.backImgWidth = backImgWidth;
        }
        if ((seen0 & 8) == 0) {
            this.backImgHeight = null;
        } else {
            this.backImgHeight = backImgHeight;
        }
        if ((seen0 & 16) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 32) == 0) {
            this.cornerRadius = null;
        } else {
            this.cornerRadius = cornerRadius;
        }
        if ((seen0 & 64) == 0) {
            this.useBoard = null;
        } else {
            this.useBoard = useBoard;
        }
        if ((seen0 & 128) == 0) {
            this.boardDayColor1 = null;
        } else {
            this.boardDayColor1 = boardDayColor1;
        }
        if ((seen0 & 256) == 0) {
            this.boardDayColor2 = null;
        } else {
            this.boardDayColor2 = boardDayColor2;
        }
        if ((seen0 & 512) == 0) {
            this.boardNightColor1 = null;
        } else {
            this.boardNightColor1 = boardNightColor1;
        }
        if ((seen0 & 1024) == 0) {
            this.boardNightColor2 = null;
        } else {
            this.boardNightColor2 = boardNightColor2;
        }
        if ((seen0 & 2048) == 0) {
            this.backDayColor1 = null;
        } else {
            this.backDayColor1 = backDayColor1;
        }
        if ((seen0 & 4096) == 0) {
            this.backDayColor2 = null;
        } else {
            this.backDayColor2 = backDayColor2;
        }
        if ((seen0 & 8192) == 0) {
            this.backNightColor1 = null;
        } else {
            this.backNightColor1 = backNightColor1;
        }
        if ((seen0 & 16384) == 0) {
            this.backNightColor2 = null;
        } else {
            this.backNightColor2 = backNightColor2;
        }
        if ((seen0 & 32768) == 0) {
            this.titleDayColor1 = null;
        } else {
            this.titleDayColor1 = titleDayColor1;
        }
        if ((seen0 & 65536) == 0) {
            this.titleDayColor2 = null;
        } else {
            this.titleDayColor2 = titleDayColor2;
        }
        if ((seen0 & 131072) == 0) {
            this.titleNightColor1 = null;
        } else {
            this.titleNightColor1 = titleNightColor1;
        }
        if ((seen0 & 262144) == 0) {
            this.titleNightColor2 = null;
        } else {
            this.titleNightColor2 = titleNightColor2;
        }
        if ((seen0 & 524288) == 0) {
            this.location = null;
        } else {
            this.location = location;
        }
    }

    public TagInfo(Integer tagType, String backImgUrl, Integer backImgWidth, Integer backImgHeight, String title, Integer cornerRadius, Integer useBoard, String boardDayColor1, String boardDayColor2, String boardNightColor1, String boardNightColor2, String backDayColor1, String backDayColor2, String backNightColor1, String backNightColor2, String titleDayColor1, String titleDayColor2, String titleNightColor1, String titleNightColor2, String location) {
        this.tagType = tagType;
        this.backImgUrl = backImgUrl;
        this.backImgWidth = backImgWidth;
        this.backImgHeight = backImgHeight;
        this.title = title;
        this.cornerRadius = cornerRadius;
        this.useBoard = useBoard;
        this.boardDayColor1 = boardDayColor1;
        this.boardDayColor2 = boardDayColor2;
        this.boardNightColor1 = boardNightColor1;
        this.boardNightColor2 = boardNightColor2;
        this.backDayColor1 = backDayColor1;
        this.backDayColor2 = backDayColor2;
        this.backNightColor1 = backNightColor1;
        this.backNightColor2 = backNightColor2;
        this.titleDayColor1 = titleDayColor1;
        this.titleDayColor2 = titleDayColor2;
        this.titleNightColor1 = titleNightColor1;
        this.titleNightColor2 = titleNightColor2;
        this.location = location;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$mallDynamicPage_debug(TagInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.tagType != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.tagType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.backImgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.backImgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.backImgWidth != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.backImgWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.backImgHeight != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.backImgHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.cornerRadius != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.cornerRadius);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.useBoard != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.useBoard);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.boardDayColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.boardDayColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.boardDayColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.boardDayColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.boardNightColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.boardNightColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.boardNightColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.boardNightColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.backDayColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.backDayColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.backDayColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.backDayColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.backNightColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.backNightColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.backNightColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.backNightColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.titleDayColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.titleDayColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.titleDayColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.titleDayColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.titleNightColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.titleNightColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.titleNightColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.titleNightColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.location != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.location);
        }
    }

    public /* synthetic */ TagInfo(Integer num, String str, Integer num2, Integer num3, String str2, Integer num4, Integer num5, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : num4, (i & 64) != 0 ? null : num5, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : str7, (i & 4096) != 0 ? null : str8, (i & 8192) != 0 ? null : str9, (i & 16384) != 0 ? null : str10, (i & 32768) != 0 ? null : str11, (i & 65536) != 0 ? null : str12, (i & 131072) != 0 ? null : str13, (i & 262144) != 0 ? null : str14, (i & 524288) != 0 ? null : str15);
    }

    public final Integer getTagType() {
        return this.tagType;
    }

    public final void setTagType(Integer num) {
        this.tagType = num;
    }

    public final String getBackImgUrl() {
        return this.backImgUrl;
    }

    public final void setBackImgUrl(String str) {
        this.backImgUrl = str;
    }

    public final Integer getBackImgWidth() {
        return this.backImgWidth;
    }

    public final void setBackImgWidth(Integer num) {
        this.backImgWidth = num;
    }

    public final Integer getBackImgHeight() {
        return this.backImgHeight;
    }

    public final void setBackImgHeight(Integer num) {
        this.backImgHeight = num;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    public final void setCornerRadius(Integer num) {
        this.cornerRadius = num;
    }

    public final Integer getUseBoard() {
        return this.useBoard;
    }

    public final void setUseBoard(Integer num) {
        this.useBoard = num;
    }

    public final String getBoardDayColor1() {
        return this.boardDayColor1;
    }

    public final void setBoardDayColor1(String str) {
        this.boardDayColor1 = str;
    }

    public final String getBoardDayColor2() {
        return this.boardDayColor2;
    }

    public final void setBoardDayColor2(String str) {
        this.boardDayColor2 = str;
    }

    public final String getBoardNightColor1() {
        return this.boardNightColor1;
    }

    public final void setBoardNightColor1(String str) {
        this.boardNightColor1 = str;
    }

    public final String getBoardNightColor2() {
        return this.boardNightColor2;
    }

    public final void setBoardNightColor2(String str) {
        this.boardNightColor2 = str;
    }

    public final String getBackDayColor1() {
        return this.backDayColor1;
    }

    public final void setBackDayColor1(String str) {
        this.backDayColor1 = str;
    }

    public final String getBackDayColor2() {
        return this.backDayColor2;
    }

    public final void setBackDayColor2(String str) {
        this.backDayColor2 = str;
    }

    public final String getBackNightColor1() {
        return this.backNightColor1;
    }

    public final void setBackNightColor1(String str) {
        this.backNightColor1 = str;
    }

    public final String getBackNightColor2() {
        return this.backNightColor2;
    }

    public final void setBackNightColor2(String str) {
        this.backNightColor2 = str;
    }

    public final String getTitleDayColor1() {
        return this.titleDayColor1;
    }

    public final void setTitleDayColor1(String str) {
        this.titleDayColor1 = str;
    }

    public final String getTitleDayColor2() {
        return this.titleDayColor2;
    }

    public final void setTitleDayColor2(String str) {
        this.titleDayColor2 = str;
    }

    public final String getTitleNightColor1() {
        return this.titleNightColor1;
    }

    public final void setTitleNightColor1(String str) {
        this.titleNightColor1 = str;
    }

    public final String getTitleNightColor2() {
        return this.titleNightColor2;
    }

    public final void setTitleNightColor2(String str) {
        this.titleNightColor2 = str;
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setLocation(String str) {
        this.location = str;
    }
}