package tv.danmaku.bili.ui.favorites.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.translation.v1.TranslationBusiness;
import com.bilibili.playset.api.FavoritesTranslateKt;
import com.bilibili.playset.api.TranslatableData;
import com.bilibili.playset.api.TranslateInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.favorites.adapter.FavFooterHolder;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B£\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\b\u0012\b\b\u0002\u0010!\u001a\u00020\u001e\u0012\b\b\u0002\u0010\"\u001a\u00020\u001e\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0004\b&\u0010'J\u0006\u0010J\u001a\u00020\u001eJ\u000b\u0010d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010f\u001a\u00020\bHÆ\u0003J\t\u0010g\u001a\u00020\nHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010l\u001a\u00020\bHÆ\u0003J\t\u0010m\u001a\u00020\bHÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010p\u001a\u00020\bHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010s\u001a\u00020\bHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010u\u001a\u00020\bHÆ\u0003J\t\u0010v\u001a\u00020\bHÆ\u0003J\t\u0010w\u001a\u00020\u001eHÆ\u0003J\t\u0010x\u001a\u00020\u001eHÆ\u0003J\t\u0010y\u001a\u00020\bHÆ\u0003J\t\u0010z\u001a\u00020\u001eHÆ\u0003J\t\u0010{\u001a\u00020\u001eHÆ\u0003J\t\u0010|\u001a\u00020\u001eHÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010%HÆ\u0003J¥\u0002\u0010~\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0019\u001a\u00020\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\u001e2\b\b\u0002\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\u001e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%HÆ\u0001J\u0015\u0010\u007f\u001a\u00020\u001e2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001HÖ\u0003J\n\u0010\u0082\u0001\u001a\u00020\bHÖ\u0001J\n\u0010\u0083\u0001\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010+R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0016\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010-R\u0016\u0010\u0012\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010+R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0016\u0010\u0015\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010-R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0016\u0010\u0019\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010-R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0016\u0010\u001b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010-R\u0016\u0010\u001c\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010-R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010BR\u0011\u0010\u001f\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010BR\u0016\u0010 \u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010-R\u0011\u0010!\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010BR\u0011\u0010\"\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010BR\u0016\u0010#\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010BR\u0018\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010H\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bI\u0010+R\u001a\u0010K\u001a\u00020LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020R8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010+R\u0014\u0010W\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010+R$\u0010Z\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010-\"\u0004\b\\\u0010]R(\u0010^\u001a\u0004\u0018\u00010\u00062\b\u0010Y\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b_\u0010+\"\u0004\b`\u0010aR\u0011\u0010b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bc\u0010+¨\u0006\u0084\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "Ltv/danmaku/bili/ui/favorites/model/BaseFavItem;", "Lcom/bilibili/playset/api/TranslatableData;", "cntInfo", "Ltv/danmaku/bili/ui/favorites/model/CntInfo;", ReportUtilKt.POS_COVER, "", "favTime", "", "oid", "", "intro", "link", ReportUtilKt.CONTENT_TYPE_OGV, "Ltv/danmaku/bili/ui/favorites/model/Ogv;", "ugc", "Lcom/bilibili/playset/api/Ugc;", LoginReporterV2.PAGE_FROM_KEY, "playbackPosition", "playbackDesc", ReportUtilKt.POS_TITLE, "otype", "upper", "Ltv/danmaku/bili/ui/favorites/model/Upper;", "leftText", "leftIconType", "rightText", "rightIconType", "userState", "isCheckMode", "", "isChecked", "cardType", "enableDrag", "canDrag", "isInvalid", "translateInfo", "Lcom/bilibili/playset/api/TranslateInfo;", "<init>", "(Ltv/danmaku/bili/ui/favorites/model/CntInfo;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/favorites/model/Ogv;Lcom/bilibili/playset/api/Ugc;IILjava/lang/String;Ljava/lang/String;ILtv/danmaku/bili/ui/favorites/model/Upper;Ljava/lang/String;ILjava/lang/String;IIZZIZZZLcom/bilibili/playset/api/TranslateInfo;)V", "getCntInfo", "()Ltv/danmaku/bili/ui/favorites/model/CntInfo;", "getCover", "()Ljava/lang/String;", "getFavTime", "()I", "getOid", "()J", "getIntro", "getLink", "getOgv", "()Ltv/danmaku/bili/ui/favorites/model/Ogv;", "getUgc", "()Lcom/bilibili/playset/api/Ugc;", "getPage", "getPlaybackPosition", "getPlaybackDesc", "getTitle", "getOtype", "getUpper", "()Ltv/danmaku/bili/ui/favorites/model/Upper;", "getLeftText", "getLeftIconType", "getRightText", "getRightIconType", "getUserState", "()Z", "getCardType", "getEnableDrag", "getCanDrag", "getTranslateInfo", "()Lcom/bilibili/playset/api/TranslateInfo;", "userStateStr", "getUserStateStr", "isAudioCard", "loadState", "Ltv/danmaku/bili/ui/favorites/adapter/FavFooterHolder$Companion$FavLoadMoreType;", "getLoadState", "()Ltv/danmaku/bili/ui/favorites/adapter/FavFooterHolder$Companion$FavLoadMoreType;", "setLoadState", "(Ltv/danmaku/bili/ui/favorites/adapter/FavFooterHolder$Companion$FavLoadMoreType;)V", "bizType", "Lcom/bapis/bilibili/app/translation/v1/TranslationBusiness;", "getBizType", "()Lcom/bapis/bilibili/app/translation/v1/TranslationBusiness;", "bizId", "getBizId", "originTitle", "getOriginTitle", "value", "translateStatus", "getTranslateStatus", "setTranslateStatus", "(I)V", "translateTitle", "getTranslateTitle", "setTranslateTitle", "(Ljava/lang/String;)V", "displayTitle", "getDisplayTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "equals", "other", "", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesMediasItem extends BaseFavItem implements TranslatableData {
    public static final int $stable = 8;
    private final boolean canDrag;
    @SerializedName("card_type")
    private final int cardType;
    @SerializedName("cnt_info")
    private final CntInfo cntInfo;
    @SerializedName(ReportUtilKt.POS_COVER)
    private final String cover;
    private final boolean enableDrag;
    @SerializedName("fav_time")
    private final int favTime;
    @SerializedName("intro")
    private final String intro;
    private final boolean isCheckMode;
    private final boolean isChecked;
    @SerializedName("is_invalid")
    private final boolean isInvalid;
    @SerializedName("left_icon_type")
    private final int leftIconType;
    @SerializedName("left_text")
    private final String leftText;
    @SerializedName("link")
    private final String link;
    private FavFooterHolder.Companion.FavLoadMoreType loadState;
    @SerializedName(ReportUtilKt.CONTENT_TYPE_OGV)
    private final Ogv ogv;
    @SerializedName("oid")
    private final long oid;
    @SerializedName("otype")
    private final int otype;
    @SerializedName("count")
    private final int page;
    @SerializedName("playback_desc")
    private final String playbackDesc;
    @SerializedName("playback_position")
    private final int playbackPosition;
    @SerializedName("right_icon_type")
    private final int rightIconType;
    @SerializedName("right_text")
    private final String rightText;
    @SerializedName(ReportUtilKt.POS_TITLE)
    private final String title;
    @SerializedName("translate_info")
    private final TranslateInfo translateInfo;
    @SerializedName("ugc")
    private final com.bilibili.playset.api.Ugc ugc;
    @SerializedName("upper")
    private final Upper upper;
    @SerializedName(FavoritesConstsKt.USER_STATE)
    private final int userState;

    public FavoritesMediasItem() {
        this(null, null, 0, 0L, null, null, null, null, 0, 0, null, null, 0, null, null, 0, null, 0, 0, false, false, 0, false, false, false, null, 67108863, null);
    }

    public final CntInfo component1() {
        return this.cntInfo;
    }

    public final int component10() {
        return this.playbackPosition;
    }

    public final String component11() {
        return this.playbackDesc;
    }

    public final String component12() {
        return this.title;
    }

    public final int component13() {
        return this.otype;
    }

    public final Upper component14() {
        return this.upper;
    }

    public final String component15() {
        return this.leftText;
    }

    public final int component16() {
        return this.leftIconType;
    }

    public final String component17() {
        return this.rightText;
    }

    public final int component18() {
        return this.rightIconType;
    }

    public final int component19() {
        return this.userState;
    }

    public final String component2() {
        return this.cover;
    }

    public final boolean component20() {
        return this.isCheckMode;
    }

    public final boolean component21() {
        return this.isChecked;
    }

    public final int component22() {
        return this.cardType;
    }

    public final boolean component23() {
        return this.enableDrag;
    }

    public final boolean component24() {
        return this.canDrag;
    }

    public final boolean component25() {
        return this.isInvalid;
    }

    public final TranslateInfo component26() {
        return this.translateInfo;
    }

    public final int component3() {
        return this.favTime;
    }

    public final long component4() {
        return this.oid;
    }

    public final String component5() {
        return this.intro;
    }

    public final String component6() {
        return this.link;
    }

    public final Ogv component7() {
        return this.ogv;
    }

    public final com.bilibili.playset.api.Ugc component8() {
        return this.ugc;
    }

    public final int component9() {
        return this.page;
    }

    public final FavoritesMediasItem copy(CntInfo cntInfo, String str, int i, long j, String str2, String str3, Ogv ogv, com.bilibili.playset.api.Ugc ugc, int i2, int i3, String str4, String str5, int i4, Upper upper, String str6, int i5, String str7, int i6, int i7, boolean z, boolean z2, int i8, boolean z3, boolean z4, boolean z5, TranslateInfo translateInfo) {
        return new FavoritesMediasItem(cntInfo, str, i, j, str2, str3, ogv, ugc, i2, i3, str4, str5, i4, upper, str6, i5, str7, i6, i7, z, z2, i8, z3, z4, z5, translateInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavoritesMediasItem) {
            FavoritesMediasItem favoritesMediasItem = (FavoritesMediasItem) obj;
            return Intrinsics.areEqual(this.cntInfo, favoritesMediasItem.cntInfo) && Intrinsics.areEqual(this.cover, favoritesMediasItem.cover) && this.favTime == favoritesMediasItem.favTime && this.oid == favoritesMediasItem.oid && Intrinsics.areEqual(this.intro, favoritesMediasItem.intro) && Intrinsics.areEqual(this.link, favoritesMediasItem.link) && Intrinsics.areEqual(this.ogv, favoritesMediasItem.ogv) && Intrinsics.areEqual(this.ugc, favoritesMediasItem.ugc) && this.page == favoritesMediasItem.page && this.playbackPosition == favoritesMediasItem.playbackPosition && Intrinsics.areEqual(this.playbackDesc, favoritesMediasItem.playbackDesc) && Intrinsics.areEqual(this.title, favoritesMediasItem.title) && this.otype == favoritesMediasItem.otype && Intrinsics.areEqual(this.upper, favoritesMediasItem.upper) && Intrinsics.areEqual(this.leftText, favoritesMediasItem.leftText) && this.leftIconType == favoritesMediasItem.leftIconType && Intrinsics.areEqual(this.rightText, favoritesMediasItem.rightText) && this.rightIconType == favoritesMediasItem.rightIconType && this.userState == favoritesMediasItem.userState && this.isCheckMode == favoritesMediasItem.isCheckMode && this.isChecked == favoritesMediasItem.isChecked && this.cardType == favoritesMediasItem.cardType && this.enableDrag == favoritesMediasItem.enableDrag && this.canDrag == favoritesMediasItem.canDrag && this.isInvalid == favoritesMediasItem.isInvalid && Intrinsics.areEqual(this.translateInfo, favoritesMediasItem.translateInfo);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.cntInfo == null ? 0 : this.cntInfo.hashCode()) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + this.favTime) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.oid)) * 31) + (this.intro == null ? 0 : this.intro.hashCode())) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.ogv == null ? 0 : this.ogv.hashCode())) * 31) + (this.ugc == null ? 0 : this.ugc.hashCode())) * 31) + this.page) * 31) + this.playbackPosition) * 31) + (this.playbackDesc == null ? 0 : this.playbackDesc.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + this.otype) * 31) + (this.upper == null ? 0 : this.upper.hashCode())) * 31) + (this.leftText == null ? 0 : this.leftText.hashCode())) * 31) + this.leftIconType) * 31) + (this.rightText == null ? 0 : this.rightText.hashCode())) * 31) + this.rightIconType) * 31) + this.userState) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCheckMode)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isChecked)) * 31) + this.cardType) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableDrag)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.canDrag)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isInvalid)) * 31) + (this.translateInfo != null ? this.translateInfo.hashCode() : 0);
    }

    public String toString() {
        CntInfo cntInfo = this.cntInfo;
        String str = this.cover;
        int i = this.favTime;
        long j = this.oid;
        String str2 = this.intro;
        String str3 = this.link;
        Ogv ogv = this.ogv;
        com.bilibili.playset.api.Ugc ugc = this.ugc;
        int i2 = this.page;
        int i3 = this.playbackPosition;
        String str4 = this.playbackDesc;
        String str5 = this.title;
        int i4 = this.otype;
        Upper upper = this.upper;
        String str6 = this.leftText;
        int i5 = this.leftIconType;
        String str7 = this.rightText;
        int i6 = this.rightIconType;
        int i7 = this.userState;
        boolean z = this.isCheckMode;
        boolean z2 = this.isChecked;
        int i8 = this.cardType;
        boolean z3 = this.enableDrag;
        boolean z4 = this.canDrag;
        boolean z5 = this.isInvalid;
        return "FavoritesMediasItem(cntInfo=" + cntInfo + ", cover=" + str + ", favTime=" + i + ", oid=" + j + ", intro=" + str2 + ", link=" + str3 + ", ogv=" + ogv + ", ugc=" + ugc + ", page=" + i2 + ", playbackPosition=" + i3 + ", playbackDesc=" + str4 + ", title=" + str5 + ", otype=" + i4 + ", upper=" + upper + ", leftText=" + str6 + ", leftIconType=" + i5 + ", rightText=" + str7 + ", rightIconType=" + i6 + ", userState=" + i7 + ", isCheckMode=" + z + ", isChecked=" + z2 + ", cardType=" + i8 + ", enableDrag=" + z3 + ", canDrag=" + z4 + ", isInvalid=" + z5 + ", translateInfo=" + this.translateInfo + ")";
    }

    public FavoritesMediasItem(CntInfo cntInfo, String cover, int favTime, long oid, String intro, String link, Ogv ogv, com.bilibili.playset.api.Ugc ugc, int page, int playbackPosition, String playbackDesc, String title, int otype, Upper upper, String leftText, int leftIconType, String rightText, int rightIconType, int userState, boolean isCheckMode, boolean isChecked, int cardType, boolean enableDrag, boolean canDrag, boolean isInvalid, TranslateInfo translateInfo) {
        super(false, 1, null);
        this.cntInfo = cntInfo;
        this.cover = cover;
        this.favTime = favTime;
        this.oid = oid;
        this.intro = intro;
        this.link = link;
        this.ogv = ogv;
        this.ugc = ugc;
        this.page = page;
        this.playbackPosition = playbackPosition;
        this.playbackDesc = playbackDesc;
        this.title = title;
        this.otype = otype;
        this.upper = upper;
        this.leftText = leftText;
        this.leftIconType = leftIconType;
        this.rightText = rightText;
        this.rightIconType = rightIconType;
        this.userState = userState;
        this.isCheckMode = isCheckMode;
        this.isChecked = isChecked;
        this.cardType = cardType;
        this.enableDrag = enableDrag;
        this.canDrag = canDrag;
        this.isInvalid = isInvalid;
        this.translateInfo = translateInfo;
        this.loadState = FavFooterHolder.Companion.FavLoadMoreType.LOAD_MORE_STATUS_GONE;
    }

    public /* synthetic */ FavoritesMediasItem(CntInfo cntInfo, String str, int i, long j, String str2, String str3, Ogv ogv, com.bilibili.playset.api.Ugc ugc, int i2, int i3, String str4, String str5, int i4, Upper upper, String str6, int i5, String str7, int i6, int i7, boolean z, boolean z2, int i8, boolean z3, boolean z4, boolean z5, TranslateInfo translateInfo, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? null : cntInfo, (i9 & 2) != 0 ? null : str, (i9 & 4) != 0 ? 0 : i, (i9 & 8) != 0 ? 0L : j, (i9 & 16) != 0 ? null : str2, (i9 & 32) != 0 ? null : str3, (i9 & 64) != 0 ? null : ogv, (i9 & BR.cover) != 0 ? null : ugc, (i9 & BR.hallEnterHotText) != 0 ? 0 : i2, (i9 & BR.roleType) != 0 ? 0 : i3, (i9 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? null : str4, (i9 & 2048) != 0 ? null : str5, (i9 & 4096) != 0 ? 0 : i4, (i9 & 8192) != 0 ? null : upper, (i9 & RingBuffer.CONSUME_SIZE) != 0 ? null : str6, (i9 & 32768) != 0 ? 0 : i5, (i9 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? null : str7, (i9 & 131072) != 0 ? 0 : i6, (i9 & 262144) != 0 ? 0 : i7, (i9 & 524288) != 0 ? false : z, (i9 & 1048576) != 0 ? false : z2, (i9 & 2097152) != 0 ? 0 : i8, (i9 & 4194304) != 0 ? false : z3, (i9 & 8388608) != 0 ? false : z4, (i9 & 16777216) != 0 ? false : z5, (i9 & 33554432) != 0 ? null : translateInfo);
    }

    public final CntInfo getCntInfo() {
        return this.cntInfo;
    }

    public final String getCover() {
        return this.cover;
    }

    public final int getFavTime() {
        return this.favTime;
    }

    public final long getOid() {
        return this.oid;
    }

    public final String getIntro() {
        return this.intro;
    }

    public final String getLink() {
        return this.link;
    }

    public final Ogv getOgv() {
        return this.ogv;
    }

    public final com.bilibili.playset.api.Ugc getUgc() {
        return this.ugc;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPlaybackPosition() {
        return this.playbackPosition;
    }

    public final String getPlaybackDesc() {
        return this.playbackDesc;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getOtype() {
        return this.otype;
    }

    public final Upper getUpper() {
        return this.upper;
    }

    public final String getLeftText() {
        return this.leftText;
    }

    public final int getLeftIconType() {
        return this.leftIconType;
    }

    public final String getRightText() {
        return this.rightText;
    }

    public final int getRightIconType() {
        return this.rightIconType;
    }

    public final int getUserState() {
        return this.userState;
    }

    public final boolean isCheckMode() {
        return this.isCheckMode;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final boolean getEnableDrag() {
        return this.enableDrag;
    }

    public final boolean getCanDrag() {
        return this.canDrag;
    }

    public final boolean isInvalid() {
        return this.isInvalid;
    }

    public final TranslateInfo getTranslateInfo() {
        return this.translateInfo;
    }

    public final String getUserStateStr() {
        return this.userState == 1 ? "finished" : this.userState == 2 ? "watching" : "";
    }

    public final boolean isAudioCard() {
        return this.otype == 12;
    }

    public final FavFooterHolder.Companion.FavLoadMoreType getLoadState() {
        return this.loadState;
    }

    public final void setLoadState(FavFooterHolder.Companion.FavLoadMoreType favLoadMoreType) {
        Intrinsics.checkNotNullParameter(favLoadMoreType, "<set-?>");
        this.loadState = favLoadMoreType;
    }

    public TranslationBusiness getBizType() {
        return TranslationBusiness.TRANS_BIZ_ARC;
    }

    public String getBizId() {
        return this.oid > 0 ? String.valueOf(this.oid) : "";
    }

    public String getOriginTitle() {
        String str = this.title;
        return str == null ? "" : str;
    }

    public int getTranslateStatus() {
        TranslateInfo translateInfo = this.translateInfo;
        if (translateInfo != null) {
            return translateInfo.getTranslateState();
        }
        return 0;
    }

    public void setTranslateStatus(int value) {
        TranslateInfo translateInfo = this.translateInfo;
        if (translateInfo != null) {
            translateInfo.setTranslateState(value);
        }
    }

    public String getTranslateTitle() {
        String translateTitle;
        TranslateInfo translateInfo = this.translateInfo;
        return (translateInfo == null || (translateTitle = translateInfo.getTranslateTitle()) == null) ? "" : translateTitle;
    }

    public void setTranslateTitle(String value) {
        TranslateInfo translateInfo = this.translateInfo;
        if (translateInfo != null) {
            translateInfo.setTranslateTitle(value);
        }
    }

    public final String getDisplayTitle() {
        String str;
        TranslateInfo translateInfo = this.translateInfo;
        String translateTitle = translateInfo != null ? translateInfo.getTranslateTitle() : null;
        if (!(translateTitle == null || translateTitle.length() == 0) && FavoritesTranslateKt.isTranslated(this)) {
            TranslateInfo translateInfo2 = this.translateInfo;
            return ((translateInfo2 == null || (str = translateInfo2.getTranslateTitle()) == null) && (str = this.title) == null) ? "" : str;
        }
        String str2 = this.title;
        return str2 == null ? "" : str2;
    }
}