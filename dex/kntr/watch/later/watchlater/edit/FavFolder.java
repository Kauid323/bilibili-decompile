package kntr.watch.later.watchlater.edit;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FavFolder.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0081\b\u0018\u0000 s2\u00020\u0001:\u0004stuvB¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019B±\u0001\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0018\u0010\u001dJ\u0006\u0010Q\u001a\u00020\u0005J\u0006\u0010R\u001a\u00020SJ\u0006\u0010*\u001a\u00020TJ\t\u0010U\u001a\u00020\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\tHÆ\u0003J\t\u0010Z\u001a\u00020\tHÆ\u0003J\t\u0010[\u001a\u00020\tHÆ\u0003J\t\u0010\\\u001a\u00020\tHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010c\u001a\u00020\tHÆ\u0003J\t\u0010d\u001a\u00020\tHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÁ\u0001\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010g\u001a\u00020G2\b\u0010h\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010i\u001a\u00020\tHÖ\u0001J\t\u0010j\u001a\u00020\u0005HÖ\u0001J%\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00002\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0001¢\u0006\u0002\brR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010$R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010$R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010$R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010+R\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010+R\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010+R\u001c\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001f\u001a\u0004\b1\u0010+R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001f\u001a\u0004\b3\u00104R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u001f\u001a\u0004\b6\u00107R\u001c\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u001f\u001a\u0004\b9\u0010+R\u001c\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u001f\u001a\u0004\b;\u0010!R\u001c\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u001f\u001a\u0004\b=\u0010!R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u001f\u001a\u0004\b?\u0010$R\u001c\u0010\u0015\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u001f\u001a\u0004\bA\u0010+R\u001c\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010\u001f\u001a\u0004\bC\u0010+R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010\u001f\u001a\u0004\bE\u0010$R\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bF\u0010HR\u0011\u0010I\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bI\u0010HR\u0011\u0010J\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bJ\u0010HR\u0011\u0010K\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bL\u0010HR\u0011\u0010M\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bN\u0010!R\u0011\u0010O\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bP\u0010$¨\u0006w"}, d2 = {"Lkntr/watch/later/watchlater/edit/FavFolder;", "", "id", "", "title", "", "cover", "intro", "coverType", "", "valid", "count", "favorite", "upper", "Lkntr/watch/later/watchlater/edit/FavFolder$Upper;", "ogv", "Lkntr/watch/later/watchlater/edit/FavFolder$OGV;", "attr", "playCount", "vt", "viewText1", "playSwitch", "type", "link", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILkntr/watch/later/watchlater/edit/FavFolder$Upper;Lkntr/watch/later/watchlater/edit/FavFolder$OGV;IJJLjava/lang/String;IILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILkntr/watch/later/watchlater/edit/FavFolder$Upper;Lkntr/watch/later/watchlater/edit/FavFolder$OGV;IJJLjava/lang/String;IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "getTitle$annotations", "getTitle", "()Ljava/lang/String;", "getCover$annotations", "getCover", "getIntro$annotations", "getIntro", "getCoverType$annotations", "getCoverType", "()I", "getValid$annotations", "getValid", "getCount$annotations", "getCount", "getFavorite$annotations", "getFavorite", "getUpper$annotations", "getUpper", "()Lkntr/watch/later/watchlater/edit/FavFolder$Upper;", "getOgv$annotations", "getOgv", "()Lkntr/watch/later/watchlater/edit/FavFolder$OGV;", "getAttr$annotations", "getAttr", "getPlayCount$annotations", "getPlayCount", "getVt$annotations", "getVt", "getViewText1$annotations", "getViewText1", "getPlaySwitch$annotations", "getPlaySwitch", "getType$annotations", "getType", "getLink$annotations", "getLink", "isPublic", "", "()Z", "isDefault", "isValid", "hasCurrentVideo", "getHasCurrentVideo", "authorId", "getAuthorId", "authorName", "getAuthorName", "getKey", "getCardType", "Lkntr/watch/later/watchlater/edit/CollectionTypeEnum;", "Lkntr/watch/later/watchlater/edit/CollectionCoverEnum;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$watch_later_debug", "Companion", "Upper", "OGV", "$serializer", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class FavFolder {
    public static final int $stable = 0;
    private static final int ATTR_CHECKED_NO = 4;
    private static final int ATTR_COVER_UPDATE_YES = 64;
    private static final int ATTR_DEFAULT_NO = 2;
    private static final int ATTR_DESC_UPDATE_YES = 32;
    private static final int ATTR_PUBLIC_NO = 1;
    private static final int ATTR_TITLE_UPDATE_YES = 16;
    private static final int ATTR_VALIDE_NO = 8;
    public static final int COVER_TYPE_AUDIO = 12;
    public static final int COVER_TYPE_CUSTOM = 0;
    public static final int COVER_TYPE_OGV = 24;
    public static final int COVER_TYPE_OGV_AVID = 42;
    public static final int COVER_TYPE_SEASON = 21;
    public static final int COVER_TYPE_VIDEO = 2;
    public static final Companion Companion = new Companion(null);
    private final int attr;
    private final int count;
    private final String cover;
    private final int coverType;
    private final int favorite;
    private final long id;
    private final String intro;
    private final String link;
    private final OGV ogv;
    private final long playCount;
    private final int playSwitch;
    private final String title;
    private final int type;
    private final Upper upper;
    private final int valid;
    private final String viewText1;
    private final long vt;

    public FavFolder() {
        this(0L, (String) null, (String) null, (String) null, 0, 0, 0, 0, (Upper) null, (OGV) null, 0, 0L, 0L, (String) null, 0, 0, (String) null, 131071, (DefaultConstructorMarker) null);
    }

    @SerialName("attr")
    public static /* synthetic */ void getAttr$annotations() {
    }

    @SerialName("media_count")
    public static /* synthetic */ void getCount$annotations() {
    }

    @SerialName("cover")
    public static /* synthetic */ void getCover$annotations() {
    }

    @SerialName("cover_type")
    public static /* synthetic */ void getCoverType$annotations() {
    }

    @SerialName("fav_state")
    public static /* synthetic */ void getFavorite$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("intro")
    public static /* synthetic */ void getIntro$annotations() {
    }

    @SerialName("link")
    public static /* synthetic */ void getLink$annotations() {
    }

    @SerialName("ogv")
    public static /* synthetic */ void getOgv$annotations() {
    }

    @SerialName("view_count")
    public static /* synthetic */ void getPlayCount$annotations() {
    }

    @SerialName("play_switch")
    public static /* synthetic */ void getPlaySwitch$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("upper")
    public static /* synthetic */ void getUpper$annotations() {
    }

    @SerialName("state")
    public static /* synthetic */ void getValid$annotations() {
    }

    @SerialName("view_text_1")
    public static /* synthetic */ void getViewText1$annotations() {
    }

    @SerialName("vt")
    public static /* synthetic */ void getVt$annotations() {
    }

    public final long component1() {
        return this.id;
    }

    public final OGV component10() {
        return this.ogv;
    }

    public final int component11() {
        return this.attr;
    }

    public final long component12() {
        return this.playCount;
    }

    public final long component13() {
        return this.vt;
    }

    public final String component14() {
        return this.viewText1;
    }

    public final int component15() {
        return this.playSwitch;
    }

    public final int component16() {
        return this.type;
    }

    public final String component17() {
        return this.link;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.cover;
    }

    public final String component4() {
        return this.intro;
    }

    public final int component5() {
        return this.coverType;
    }

    public final int component6() {
        return this.valid;
    }

    public final int component7() {
        return this.count;
    }

    public final int component8() {
        return this.favorite;
    }

    public final Upper component9() {
        return this.upper;
    }

    public final FavFolder copy(long j, String str, String str2, String str3, int i, int i2, int i3, int i4, Upper upper, OGV ogv, int i5, long j2, long j3, String str4, int i6, int i7, String str5) {
        return new FavFolder(j, str, str2, str3, i, i2, i3, i4, upper, ogv, i5, j2, j3, str4, i6, i7, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavFolder) {
            FavFolder favFolder = (FavFolder) obj;
            return this.id == favFolder.id && Intrinsics.areEqual(this.title, favFolder.title) && Intrinsics.areEqual(this.cover, favFolder.cover) && Intrinsics.areEqual(this.intro, favFolder.intro) && this.coverType == favFolder.coverType && this.valid == favFolder.valid && this.count == favFolder.count && this.favorite == favFolder.favorite && Intrinsics.areEqual(this.upper, favFolder.upper) && Intrinsics.areEqual(this.ogv, favFolder.ogv) && this.attr == favFolder.attr && this.playCount == favFolder.playCount && this.vt == favFolder.vt && Intrinsics.areEqual(this.viewText1, favFolder.viewText1) && this.playSwitch == favFolder.playSwitch && this.type == favFolder.type && Intrinsics.areEqual(this.link, favFolder.link);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.intro == null ? 0 : this.intro.hashCode())) * 31) + this.coverType) * 31) + this.valid) * 31) + this.count) * 31) + this.favorite) * 31) + (this.upper == null ? 0 : this.upper.hashCode())) * 31) + (this.ogv == null ? 0 : this.ogv.hashCode())) * 31) + this.attr) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.playCount)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.vt)) * 31) + (this.viewText1 == null ? 0 : this.viewText1.hashCode())) * 31) + this.playSwitch) * 31) + this.type) * 31) + (this.link != null ? this.link.hashCode() : 0);
    }

    public String toString() {
        long j = this.id;
        String str = this.title;
        String str2 = this.cover;
        String str3 = this.intro;
        int i = this.coverType;
        int i2 = this.valid;
        int i3 = this.count;
        int i4 = this.favorite;
        Upper upper = this.upper;
        OGV ogv = this.ogv;
        int i5 = this.attr;
        long j2 = this.playCount;
        long j3 = this.vt;
        String str4 = this.viewText1;
        int i6 = this.playSwitch;
        int i7 = this.type;
        return "FavFolder(id=" + j + ", title=" + str + ", cover=" + str2 + ", intro=" + str3 + ", coverType=" + i + ", valid=" + i2 + ", count=" + i3 + ", favorite=" + i4 + ", upper=" + upper + ", ogv=" + ogv + ", attr=" + i5 + ", playCount=" + j2 + ", vt=" + j3 + ", viewText1=" + str4 + ", playSwitch=" + i6 + ", type=" + i7 + ", link=" + this.link + ")";
    }

    public /* synthetic */ FavFolder(int seen0, long id, String title, String cover, String intro, int coverType, int valid, int count, int favorite, Upper upper, OGV ogv, int attr, long playCount, long vt, String viewText1, int playSwitch, int type, String link, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.id = 0L;
        } else {
            this.id = id;
        }
        if ((seen0 & 2) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 4) == 0) {
            this.cover = null;
        } else {
            this.cover = cover;
        }
        if ((seen0 & 8) == 0) {
            this.intro = null;
        } else {
            this.intro = intro;
        }
        if ((seen0 & 16) == 0) {
            this.coverType = 0;
        } else {
            this.coverType = coverType;
        }
        if ((seen0 & 32) == 0) {
            this.valid = 0;
        } else {
            this.valid = valid;
        }
        if ((seen0 & 64) == 0) {
            this.count = 0;
        } else {
            this.count = count;
        }
        if ((seen0 & 128) == 0) {
            this.favorite = 0;
        } else {
            this.favorite = favorite;
        }
        if ((seen0 & 256) == 0) {
            this.upper = null;
        } else {
            this.upper = upper;
        }
        if ((seen0 & 512) == 0) {
            this.ogv = null;
        } else {
            this.ogv = ogv;
        }
        if ((seen0 & 1024) == 0) {
            this.attr = 0;
        } else {
            this.attr = attr;
        }
        if ((seen0 & 2048) == 0) {
            this.playCount = 0L;
        } else {
            this.playCount = playCount;
        }
        if ((seen0 & 4096) == 0) {
            this.vt = 0L;
        } else {
            this.vt = vt;
        }
        if ((seen0 & 8192) == 0) {
            this.viewText1 = null;
        } else {
            this.viewText1 = viewText1;
        }
        if ((seen0 & 16384) == 0) {
            this.playSwitch = 0;
        } else {
            this.playSwitch = playSwitch;
        }
        if ((seen0 & 32768) == 0) {
            this.type = 0;
        } else {
            this.type = type;
        }
        if ((seen0 & 65536) == 0) {
            this.link = null;
        } else {
            this.link = link;
        }
    }

    public FavFolder(long id, String title, String cover, String intro, int coverType, int valid, int count, int favorite, Upper upper, OGV ogv, int attr, long playCount, long vt, String viewText1, int playSwitch, int type, String link) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.intro = intro;
        this.coverType = coverType;
        this.valid = valid;
        this.count = count;
        this.favorite = favorite;
        this.upper = upper;
        this.ogv = ogv;
        this.attr = attr;
        this.playCount = playCount;
        this.vt = vt;
        this.viewText1 = viewText1;
        this.playSwitch = playSwitch;
        this.type = type;
        this.link = link;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$watch_later_debug(FavFolder self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeLongElement(serialDesc, 0, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.cover != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.intro != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.intro);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.coverType != 0) {
            output.encodeIntElement(serialDesc, 4, self.coverType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.valid != 0) {
            output.encodeIntElement(serialDesc, 5, self.valid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.count != 0) {
            output.encodeIntElement(serialDesc, 6, self.count);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.favorite != 0) {
            output.encodeIntElement(serialDesc, 7, self.favorite);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.upper != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, FavFolder$Upper$$serializer.INSTANCE, self.upper);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.ogv != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, FavFolder$OGV$$serializer.INSTANCE, self.ogv);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.attr != 0) {
            output.encodeIntElement(serialDesc, 10, self.attr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.playCount != 0) {
            output.encodeLongElement(serialDesc, 11, self.playCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.vt != 0) {
            output.encodeLongElement(serialDesc, 12, self.vt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.viewText1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.viewText1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.playSwitch != 0) {
            output.encodeIntElement(serialDesc, 14, self.playSwitch);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.type != 0) {
            output.encodeIntElement(serialDesc, 15, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.link != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.link);
        }
    }

    public /* synthetic */ FavFolder(long j, String str, String str2, String str3, int i, int i2, int i3, int i4, Upper upper, OGV ogv, int i5, long j2, long j3, String str4, int i6, int i7, String str5, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0L : j, (i8 & 2) != 0 ? null : str, (i8 & 4) != 0 ? null : str2, (i8 & 8) != 0 ? null : str3, (i8 & 16) != 0 ? 0 : i, (i8 & 32) != 0 ? 0 : i2, (i8 & 64) != 0 ? 0 : i3, (i8 & 128) != 0 ? 0 : i4, (i8 & 256) != 0 ? null : upper, (i8 & 512) != 0 ? null : ogv, (i8 & 1024) != 0 ? 0 : i5, (i8 & 2048) != 0 ? 0L : j2, (i8 & 4096) != 0 ? 0L : j3, (i8 & 8192) != 0 ? null : str4, (i8 & 16384) != 0 ? 0 : i6, (i8 & 32768) == 0 ? i7 : 0, (i8 & 65536) != 0 ? null : str5);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getIntro() {
        return this.intro;
    }

    public final int getCoverType() {
        return this.coverType;
    }

    public final int getValid() {
        return this.valid;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getFavorite() {
        return this.favorite;
    }

    public final Upper getUpper() {
        return this.upper;
    }

    public final OGV getOgv() {
        return this.ogv;
    }

    public final int getAttr() {
        return this.attr;
    }

    public final long getPlayCount() {
        return this.playCount;
    }

    public final long getVt() {
        return this.vt;
    }

    public final String getViewText1() {
        return this.viewText1;
    }

    public final int getPlaySwitch() {
        return this.playSwitch;
    }

    public final int getType() {
        return this.type;
    }

    public final String getLink() {
        return this.link;
    }

    /* compiled from: FavFolder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/watch/later/watchlater/edit/FavFolder$Companion;", "", "<init>", "()V", "COVER_TYPE_CUSTOM", "", "COVER_TYPE_VIDEO", "COVER_TYPE_AUDIO", "COVER_TYPE_SEASON", "COVER_TYPE_OGV", "COVER_TYPE_OGV_AVID", "ATTR_PUBLIC_NO", "ATTR_DEFAULT_NO", "ATTR_CHECKED_NO", "ATTR_VALIDE_NO", "ATTR_TITLE_UPDATE_YES", "ATTR_DESC_UPDATE_YES", "ATTR_COVER_UPDATE_YES", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/watch/later/watchlater/edit/FavFolder;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FavFolder> serializer() {
            return FavFolder$$serializer.INSTANCE;
        }
    }

    public final boolean isPublic() {
        return (this.attr & 1) == 0;
    }

    public final boolean isDefault() {
        return (this.attr & 2) == 0;
    }

    public final boolean isValid() {
        return this.valid == 0;
    }

    public final boolean getHasCurrentVideo() {
        return this.favorite == 1;
    }

    public final long getAuthorId() {
        Upper upper = this.upper;
        if (upper != null) {
            return upper.getMid();
        }
        return 0L;
    }

    public final String getAuthorName() {
        String name;
        Upper upper = this.upper;
        return (upper == null || (name = upper.getName()) == null) ? "" : name;
    }

    public final String getKey() {
        return String.valueOf(this.id);
    }

    public final CollectionTypeEnum getCardType() {
        switch (this.type) {
            case 21:
                return CollectionTypeEnum.SEASON;
            case MediaAttrUtils.TYPE_PAY_SEASON /* 1000 */:
                return CollectionTypeEnum.PAY_SEASON;
            default:
                return CollectionTypeEnum.FOLDER;
        }
    }

    /* compiled from: FavFolder.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lkntr/watch/later/watchlater/edit/FavFolder$Upper;", "", "mid", "", "name", "", "<init>", "(JLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMid$annotations", "()V", "getMid", "()J", "getName$annotations", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$watch_later_debug", "$serializer", "Companion", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Upper {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final long mid;
        private final String name;

        public Upper() {
            this(0L, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Upper copy$default(Upper upper, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = upper.mid;
            }
            if ((i & 2) != 0) {
                str = upper.name;
            }
            return upper.copy(j, str);
        }

        @SerialName("mid")
        public static /* synthetic */ void getMid$annotations() {
        }

        @SerialName("name")
        public static /* synthetic */ void getName$annotations() {
        }

        public final long component1() {
            return this.mid;
        }

        public final String component2() {
            return this.name;
        }

        public final Upper copy(long j, String str) {
            return new Upper(j, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Upper) {
                Upper upper = (Upper) obj;
                return this.mid == upper.mid && Intrinsics.areEqual(this.name, upper.name);
            }
            return false;
        }

        public int hashCode() {
            return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid) * 31) + (this.name == null ? 0 : this.name.hashCode());
        }

        public String toString() {
            long j = this.mid;
            return "Upper(mid=" + j + ", name=" + this.name + ")";
        }

        /* compiled from: FavFolder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/watch/later/watchlater/edit/FavFolder$Upper$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/watch/later/watchlater/edit/FavFolder$Upper;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Upper> serializer() {
                return FavFolder$Upper$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Upper(int seen0, long mid, String name, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.mid = 0L;
            } else {
                this.mid = mid;
            }
            if ((seen0 & 2) == 0) {
                this.name = null;
            } else {
                this.name = name;
            }
        }

        public Upper(long mid, String name) {
            this.mid = mid;
            this.name = name;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$watch_later_debug(Upper self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.mid != 0) {
                output.encodeLongElement(serialDesc, 0, self.mid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.name != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
            }
        }

        public /* synthetic */ Upper(long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str);
        }

        public final long getMid() {
            return this.mid;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* renamed from: getCoverType  reason: collision with other method in class */
    public final CollectionCoverEnum m2612getCoverType() {
        return CollectionCoverEnum.Companion.get(this.coverType);
    }

    /* compiled from: FavFolder.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lkntr/watch/later/watchlater/edit/FavFolder$OGV;", "", "typeName", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTypeName$annotations", "()V", "getTypeName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$watch_later_debug", "$serializer", "Companion", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class OGV {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String typeName;

        public OGV() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ OGV copy$default(OGV ogv, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ogv.typeName;
            }
            return ogv.copy(str);
        }

        @SerialName("type_name")
        public static /* synthetic */ void getTypeName$annotations() {
        }

        public final String component1() {
            return this.typeName;
        }

        public final OGV copy(String str) {
            return new OGV(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OGV) && Intrinsics.areEqual(this.typeName, ((OGV) obj).typeName);
        }

        public int hashCode() {
            if (this.typeName == null) {
                return 0;
            }
            return this.typeName.hashCode();
        }

        public String toString() {
            return "OGV(typeName=" + this.typeName + ")";
        }

        /* compiled from: FavFolder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/watch/later/watchlater/edit/FavFolder$OGV$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/watch/later/watchlater/edit/FavFolder$OGV;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<OGV> serializer() {
                return FavFolder$OGV$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ OGV(int seen0, String typeName, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.typeName = null;
            } else {
                this.typeName = typeName;
            }
        }

        public OGV(String typeName) {
            this.typeName = typeName;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$watch_later_debug(OGV self, CompositeEncoder output, SerialDescriptor serialDesc) {
            boolean z = true;
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.typeName == null) {
                z = false;
            }
            if (z) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.typeName);
            }
        }

        public /* synthetic */ OGV(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getTypeName() {
            return this.typeName;
        }
    }
}