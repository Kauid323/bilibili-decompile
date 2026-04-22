package kntr.watch.later.watchlater.data;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import bili.resource.favorites.FavoritesRes;
import bili.resource.playerbaseres.PlayerbaseresRes;
import com.bapis.bilibili.app.translation.v1.KTranslationBusiness;
import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.api.TranslatableData;
import kntr.watch.later.watchlater.api.TranslateInfo;
import kntr.watch.later.watchlater.api.TranslateInfo$$serializer;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kntr.watch.later.watchlater.utils.PlayTimeFormatKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.uuid.Uuid;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: WatchLaterResponse.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \u008d\u00012\u00020\u0001:\u0004\u008c\u0001\u008d\u0001Bá\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dBß\u0001\b\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 \u0012\b\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0004\b\u001c\u0010$J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010p\u001a\u00020\u0005HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010u\u001a\u00020\u0010HÆ\u0003J\t\u0010v\u001a\u00020\u0010HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010z\u001a\u00020\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010}\u001a\u00020\u0010HÆ\u0003J\t\u0010~\u001a\u00020\u0007HÆ\u0003Jã\u0001\u0010\u007f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u0007HÆ\u0001J\u0016\u0010\u0080\u0001\u001a\u00020\u00102\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001HÖ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0084\u0001\u001a\u00020\u0007HÖ\u0001J,\u0010\u0085\u0001\u001a\u00020!2\u0007\u0010\u0086\u0001\u001a\u00020\u00002\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0001¢\u0006\u0003\b\u008b\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010&\u001a\u0004\b*\u0010+R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010&\u001a\u0004\b-\u0010.R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010&\u001a\u0004\b0\u0010.R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010&\u001a\u0004\b2\u0010.R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010&\u001a\u0004\b4\u0010+R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010&\u001a\u0004\b6\u0010+R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010&\u001a\u0004\b8\u0010.R\u001c\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010&\u001a\u0004\b:\u0010(R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010&\u001a\u0004\b<\u0010.R\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010&\u001a\u0004\b>\u0010?R\u001c\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010&\u001a\u0004\bA\u0010?R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010&\u001a\u0004\bC\u0010DR\u001c\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010&\u001a\u0004\bF\u0010(R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010&\u001a\u0004\bH\u0010.R\u001c\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010&\u001a\u0004\bJ\u0010(R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010&\u001a\u0004\bL\u0010.R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010&\u001a\u0004\bN\u0010OR\u0011\u0010\u001a\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010?R\u0011\u0010\u001b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bP\u0010.R\u0011\u0010Q\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bQ\u0010?R\u0013\u0010R\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bS\u0010.R\u0014\u0010T\u001a\u00020U8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010.R\u0014\u0010Z\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010.R$\u0010]\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b^\u0010(\"\u0004\b_\u0010`R(\u0010a\u001a\u0004\u0018\u00010\u00072\b\u0010\\\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bb\u0010.\"\u0004\bc\u0010dR\u0013\u0010e\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bf\u0010.R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010j¨\u0006\u008e\u0001"}, d2 = {"Lkntr/watch/later/watchlater/data/WatchLaterItem;", "Lkntr/watch/later/watchlater/api/TranslatableData;", "cardType", "", "aid", "", "title", "", "intro", "pic", "duration", "progress", "uri", "arcState", "pgcLabel", "showUp", "", "forbidFav", "owner", "Lkntr/watch/later/watchlater/data/Owner;", "leftIconType", "leftText", "rightIconType", "rightText", "translateInfo", "Lkntr/watch/later/watchlater/api/TranslateInfo;", "isChecked", "itemId", "<init>", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;ILjava/lang/String;ZZLkntr/watch/later/watchlater/data/Owner;ILjava/lang/String;ILjava/lang/String;Lkntr/watch/later/watchlater/api/TranslateInfo;ZLjava/lang/String;)V", "seen0", "onTranslateStateChagne", "Lkotlin/Function0;", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;ILjava/lang/String;ZZLkntr/watch/later/watchlater/data/Owner;ILjava/lang/String;ILjava/lang/String;Lkntr/watch/later/watchlater/api/TranslateInfo;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardType$annotations", "()V", "getCardType", "()I", "getAid$annotations", "getAid", "()J", "getTitle$annotations", "getTitle", "()Ljava/lang/String;", "getIntro$annotations", "getIntro", "getPic$annotations", "getPic", "getDuration$annotations", "getDuration", "getProgress$annotations", "getProgress", "getUri$annotations", "getUri", "getArcState$annotations", "getArcState", "getPgcLabel$annotations", "getPgcLabel", "getShowUp$annotations", "getShowUp", "()Z", "getForbidFav$annotations", "getForbidFav", "getOwner$annotations", "getOwner", "()Lkntr/watch/later/watchlater/data/Owner;", "getLeftIconType$annotations", "getLeftIconType", "getLeftText$annotations", "getLeftText", "getRightIconType$annotations", "getRightIconType", "getRightText$annotations", "getRightText", "getTranslateInfo$annotations", "getTranslateInfo", "()Lkntr/watch/later/watchlater/api/TranslateInfo;", "getItemId", "isInvalid", "coverText", "getCoverText", "bizType", "Lcom/bapis/bilibili/app/translation/v1/KTranslationBusiness;", "getBizType", "()Lcom/bapis/bilibili/app/translation/v1/KTranslationBusiness;", "bizId", "getBizId", "originTitle", "getOriginTitle", "value", "translateStatus", "getTranslateStatus", "setTranslateStatus", "(I)V", "translateTitle", "getTranslateTitle", "setTranslateTitle", "(Ljava/lang/String;)V", "displayTitle", "getDisplayTitle", "getOnTranslateStateChagne", "()Lkotlin/jvm/functions/Function0;", "setOnTranslateStateChagne", "(Lkotlin/jvm/functions/Function0;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$watch_later_debug", "$serializer", "Companion", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class WatchLaterItem implements TranslatableData {
    private final long aid;
    private final int arcState;
    private final int cardType;
    private final long duration;
    private final boolean forbidFav;
    private final String intro;
    private final boolean isChecked;
    private final String itemId;
    private final int leftIconType;
    private final String leftText;
    private Function0<Unit> onTranslateStateChagne;
    private final Owner owner;
    private final String pgcLabel;
    private final String pic;
    private final long progress;
    private final int rightIconType;
    private final String rightText;
    private final boolean showUp;
    private final String title;
    private final TranslateInfo translateInfo;
    private final String uri;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.watch.later.watchlater.data.WatchLaterItem$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = WatchLaterItem._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public WatchLaterItem() {
        this(0, 0L, null, null, null, 0L, 0L, null, 0, null, false, false, null, 0, null, 0, null, null, false, null, 1048575, null);
    }

    @SerialName("aid")
    public static /* synthetic */ void getAid$annotations() {
    }

    @SerialName("arc_state")
    public static /* synthetic */ void getArcState$annotations() {
    }

    @SerialName("card_type")
    public static /* synthetic */ void getCardType$annotations() {
    }

    @SerialName("duration")
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("forbid_fav")
    public static /* synthetic */ void getForbidFav$annotations() {
    }

    @SerialName("intro")
    public static /* synthetic */ void getIntro$annotations() {
    }

    @SerialName("left_icon_type")
    public static /* synthetic */ void getLeftIconType$annotations() {
    }

    @SerialName("left_text")
    public static /* synthetic */ void getLeftText$annotations() {
    }

    @SerialName("owner")
    public static /* synthetic */ void getOwner$annotations() {
    }

    @SerialName("pgc_label")
    public static /* synthetic */ void getPgcLabel$annotations() {
    }

    @SerialName("pic")
    public static /* synthetic */ void getPic$annotations() {
    }

    @SerialName("progress")
    public static /* synthetic */ void getProgress$annotations() {
    }

    @SerialName("right_icon_type")
    public static /* synthetic */ void getRightIconType$annotations() {
    }

    @SerialName("right_text")
    public static /* synthetic */ void getRightText$annotations() {
    }

    @SerialName("show_up")
    public static /* synthetic */ void getShowUp$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("translate_info")
    public static /* synthetic */ void getTranslateInfo$annotations() {
    }

    @SerialName("uri")
    public static /* synthetic */ void getUri$annotations() {
    }

    public final int component1() {
        return this.cardType;
    }

    public final String component10() {
        return this.pgcLabel;
    }

    public final boolean component11() {
        return this.showUp;
    }

    public final boolean component12() {
        return this.forbidFav;
    }

    public final Owner component13() {
        return this.owner;
    }

    public final int component14() {
        return this.leftIconType;
    }

    public final String component15() {
        return this.leftText;
    }

    public final int component16() {
        return this.rightIconType;
    }

    public final String component17() {
        return this.rightText;
    }

    public final TranslateInfo component18() {
        return this.translateInfo;
    }

    public final boolean component19() {
        return this.isChecked;
    }

    public final long component2() {
        return this.aid;
    }

    public final String component20() {
        return this.itemId;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.intro;
    }

    public final String component5() {
        return this.pic;
    }

    public final long component6() {
        return this.duration;
    }

    public final long component7() {
        return this.progress;
    }

    public final String component8() {
        return this.uri;
    }

    public final int component9() {
        return this.arcState;
    }

    public final WatchLaterItem copy(int i, long j, String str, String str2, String str3, long j2, long j3, String str4, int i2, String str5, boolean z, boolean z2, Owner owner, int i3, String str6, int i4, String str7, TranslateInfo translateInfo, boolean z3, String str8) {
        Intrinsics.checkNotNullParameter(str8, "itemId");
        return new WatchLaterItem(i, j, str, str2, str3, j2, j3, str4, i2, str5, z, z2, owner, i3, str6, i4, str7, translateInfo, z3, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WatchLaterItem) {
            WatchLaterItem watchLaterItem = (WatchLaterItem) obj;
            return this.cardType == watchLaterItem.cardType && this.aid == watchLaterItem.aid && Intrinsics.areEqual(this.title, watchLaterItem.title) && Intrinsics.areEqual(this.intro, watchLaterItem.intro) && Intrinsics.areEqual(this.pic, watchLaterItem.pic) && this.duration == watchLaterItem.duration && this.progress == watchLaterItem.progress && Intrinsics.areEqual(this.uri, watchLaterItem.uri) && this.arcState == watchLaterItem.arcState && Intrinsics.areEqual(this.pgcLabel, watchLaterItem.pgcLabel) && this.showUp == watchLaterItem.showUp && this.forbidFav == watchLaterItem.forbidFav && Intrinsics.areEqual(this.owner, watchLaterItem.owner) && this.leftIconType == watchLaterItem.leftIconType && Intrinsics.areEqual(this.leftText, watchLaterItem.leftText) && this.rightIconType == watchLaterItem.rightIconType && Intrinsics.areEqual(this.rightText, watchLaterItem.rightText) && Intrinsics.areEqual(this.translateInfo, watchLaterItem.translateInfo) && this.isChecked == watchLaterItem.isChecked && Intrinsics.areEqual(this.itemId, watchLaterItem.itemId);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.cardType * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid)) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.intro == null ? 0 : this.intro.hashCode())) * 31) + (this.pic == null ? 0 : this.pic.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.progress)) * 31) + (this.uri == null ? 0 : this.uri.hashCode())) * 31) + this.arcState) * 31) + (this.pgcLabel == null ? 0 : this.pgcLabel.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showUp)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.forbidFav)) * 31) + (this.owner == null ? 0 : this.owner.hashCode())) * 31) + this.leftIconType) * 31) + (this.leftText == null ? 0 : this.leftText.hashCode())) * 31) + this.rightIconType) * 31) + (this.rightText == null ? 0 : this.rightText.hashCode())) * 31) + (this.translateInfo != null ? this.translateInfo.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isChecked)) * 31) + this.itemId.hashCode();
    }

    public String toString() {
        int i = this.cardType;
        long j = this.aid;
        String str = this.title;
        String str2 = this.intro;
        String str3 = this.pic;
        long j2 = this.duration;
        long j3 = this.progress;
        String str4 = this.uri;
        int i2 = this.arcState;
        String str5 = this.pgcLabel;
        boolean z = this.showUp;
        boolean z2 = this.forbidFav;
        Owner owner = this.owner;
        int i3 = this.leftIconType;
        String str6 = this.leftText;
        int i4 = this.rightIconType;
        String str7 = this.rightText;
        TranslateInfo translateInfo = this.translateInfo;
        boolean z3 = this.isChecked;
        return "WatchLaterItem(cardType=" + i + ", aid=" + j + ", title=" + str + ", intro=" + str2 + ", pic=" + str3 + ", duration=" + j2 + ", progress=" + j3 + ", uri=" + str4 + ", arcState=" + i2 + ", pgcLabel=" + str5 + ", showUp=" + z + ", forbidFav=" + z2 + ", owner=" + owner + ", leftIconType=" + i3 + ", leftText=" + str6 + ", rightIconType=" + i4 + ", rightText=" + str7 + ", translateInfo=" + translateInfo + ", isChecked=" + z3 + ", itemId=" + this.itemId + ")";
    }

    /* compiled from: WatchLaterResponse.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/watch/later/watchlater/data/WatchLaterItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/watch/later/watchlater/data/WatchLaterItem;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WatchLaterItem> serializer() {
            return WatchLaterItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ WatchLaterItem(int seen0, int cardType, long aid, String title, String intro, String pic, long duration, long progress, String uri, int arcState, String pgcLabel, boolean showUp, boolean forbidFav, Owner owner, int leftIconType, String leftText, int rightIconType, String rightText, TranslateInfo translateInfo, boolean isChecked, String itemId, Function0 onTranslateStateChagne, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.cardType = 0;
        } else {
            this.cardType = cardType;
        }
        if ((seen0 & 2) == 0) {
            this.aid = 0L;
        } else {
            this.aid = aid;
        }
        if ((seen0 & 4) == 0) {
            this.title = "";
        } else {
            this.title = title;
        }
        if ((seen0 & 8) == 0) {
            this.intro = null;
        } else {
            this.intro = intro;
        }
        if ((seen0 & 16) == 0) {
            this.pic = null;
        } else {
            this.pic = pic;
        }
        if ((seen0 & 32) == 0) {
            this.duration = 0L;
        } else {
            this.duration = duration;
        }
        if ((seen0 & 64) == 0) {
            this.progress = 0L;
        } else {
            this.progress = progress;
        }
        if ((seen0 & 128) == 0) {
            this.uri = null;
        } else {
            this.uri = uri;
        }
        if ((seen0 & 256) == 0) {
            this.arcState = 0;
        } else {
            this.arcState = arcState;
        }
        if ((seen0 & 512) == 0) {
            this.pgcLabel = null;
        } else {
            this.pgcLabel = pgcLabel;
        }
        if ((seen0 & 1024) == 0) {
            this.showUp = true;
        } else {
            this.showUp = showUp;
        }
        if ((seen0 & 2048) == 0) {
            this.forbidFav = false;
        } else {
            this.forbidFav = forbidFav;
        }
        if ((seen0 & 4096) == 0) {
            this.owner = null;
        } else {
            this.owner = owner;
        }
        if ((seen0 & 8192) == 0) {
            this.leftIconType = 0;
        } else {
            this.leftIconType = leftIconType;
        }
        if ((seen0 & 16384) == 0) {
            this.leftText = null;
        } else {
            this.leftText = leftText;
        }
        if ((seen0 & 32768) == 0) {
            this.rightIconType = 0;
        } else {
            this.rightIconType = rightIconType;
        }
        if ((seen0 & 65536) == 0) {
            this.rightText = null;
        } else {
            this.rightText = rightText;
        }
        if ((seen0 & 131072) == 0) {
            this.translateInfo = null;
        } else {
            this.translateInfo = translateInfo;
        }
        if ((seen0 & 262144) == 0) {
            this.isChecked = false;
        } else {
            this.isChecked = isChecked;
        }
        if ((seen0 & 524288) == 0) {
            this.itemId = Uuid.Companion.random().toString();
        } else {
            this.itemId = itemId;
        }
        if ((seen0 & 1048576) == 0) {
            this.onTranslateStateChagne = null;
        } else {
            this.onTranslateStateChagne = onTranslateStateChagne;
        }
    }

    public WatchLaterItem(int cardType, long aid, String title, String intro, String pic, long duration, long progress, String uri, int arcState, String pgcLabel, boolean showUp, boolean forbidFav, Owner owner, int leftIconType, String leftText, int rightIconType, String rightText, TranslateInfo translateInfo, boolean isChecked, String itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.cardType = cardType;
        this.aid = aid;
        this.title = title;
        this.intro = intro;
        this.pic = pic;
        this.duration = duration;
        this.progress = progress;
        this.uri = uri;
        this.arcState = arcState;
        this.pgcLabel = pgcLabel;
        this.showUp = showUp;
        this.forbidFav = forbidFav;
        this.owner = owner;
        this.leftIconType = leftIconType;
        this.leftText = leftText;
        this.rightIconType = rightIconType;
        this.rightText = rightText;
        this.translateInfo = translateInfo;
        this.isChecked = isChecked;
        this.itemId = itemId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Function0.class), new Annotation[0]);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$watch_later_debug(WatchLaterItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.cardType != 0) {
            output.encodeIntElement(serialDesc, 0, self.cardType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.aid != 0) {
            output.encodeLongElement(serialDesc, 1, self.aid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.title, "")) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.intro != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.intro);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.pic != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.pic);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.duration != 0) {
            output.encodeLongElement(serialDesc, 5, self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.progress != 0) {
            output.encodeLongElement(serialDesc, 6, self.progress);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.uri != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.uri);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.arcState != 0) {
            output.encodeIntElement(serialDesc, 8, self.arcState);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.pgcLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.pgcLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !self.showUp) {
            output.encodeBooleanElement(serialDesc, 10, self.showUp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.forbidFav) {
            output.encodeBooleanElement(serialDesc, 11, self.forbidFav);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.owner != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, Owner$$serializer.INSTANCE, self.owner);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.leftIconType != 0) {
            output.encodeIntElement(serialDesc, 13, self.leftIconType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.leftText != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.leftText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.rightIconType != 0) {
            output.encodeIntElement(serialDesc, 15, self.rightIconType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.rightText != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.rightText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.translateInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, TranslateInfo$$serializer.INSTANCE, self.translateInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.isChecked) {
            output.encodeBooleanElement(serialDesc, 18, self.isChecked);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || !Intrinsics.areEqual(self.itemId, Uuid.Companion.random().toString())) {
            output.encodeStringElement(serialDesc, 19, self.itemId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.onTranslateStateChagne != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, lazyArr[20].getValue(), self.onTranslateStateChagne);
        }
    }

    public /* synthetic */ WatchLaterItem(int i, long j, String str, String str2, String str3, long j2, long j3, String str4, int i2, String str5, boolean z, boolean z2, Owner owner, int i3, String str6, int i4, String str7, TranslateInfo translateInfo, boolean z3, String str8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0L : j, (i5 & 4) != 0 ? "" : str, (i5 & 8) != 0 ? null : str2, (i5 & 16) != 0 ? null : str3, (i5 & 32) != 0 ? 0L : j2, (i5 & 64) == 0 ? j3 : 0L, (i5 & 128) != 0 ? null : str4, (i5 & 256) != 0 ? 0 : i2, (i5 & 512) != 0 ? null : str5, (i5 & 1024) != 0 ? true : z, (i5 & 2048) != 0 ? false : z2, (i5 & 4096) != 0 ? null : owner, (i5 & 8192) != 0 ? 0 : i3, (i5 & 16384) != 0 ? null : str6, (i5 & 32768) != 0 ? 0 : i4, (i5 & 65536) != 0 ? null : str7, (i5 & 131072) != 0 ? null : translateInfo, (i5 & 262144) != 0 ? false : z3, (i5 & 524288) != 0 ? Uuid.Companion.random().toString() : str8);
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final long getAid() {
        return this.aid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getIntro() {
        return this.intro;
    }

    public final String getPic() {
        return this.pic;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final String getUri() {
        return this.uri;
    }

    public final int getArcState() {
        return this.arcState;
    }

    public final String getPgcLabel() {
        return this.pgcLabel;
    }

    public final boolean getShowUp() {
        return this.showUp;
    }

    public final boolean getForbidFav() {
        return this.forbidFav;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final int getLeftIconType() {
        return this.leftIconType;
    }

    public final String getLeftText() {
        return this.leftText;
    }

    public final int getRightIconType() {
        return this.rightIconType;
    }

    public final String getRightText() {
        return this.rightText;
    }

    public final TranslateInfo getTranslateInfo() {
        return this.translateInfo;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final boolean isInvalid() {
        return this.arcState < 0;
    }

    public final String getCoverText() {
        if (isInvalid()) {
            return CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_26(CommonRes.INSTANCE.getString()));
        }
        long j = this.progress;
        if (j == 0) {
            return PlayTimeFormatKt.formatPlayTime$default(this.duration * ((long) MediaAttrUtils.TYPE_PAY_SEASON), false, false, false, 14, null);
        }
        if (j == -1) {
            return PlayerbaseresRes.INSTANCE.getString(bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_223(FavoritesRes.INSTANCE.getString()));
        }
        long j2 = this.progress;
        long j3 = (long) MediaAttrUtils.TYPE_PAY_SEASON;
        String formatPlayTime$default = PlayTimeFormatKt.formatPlayTime$default(j2 * j3, false, false, false, 14, null);
        return formatPlayTime$default + " / " + PlayTimeFormatKt.formatPlayTime$default(this.duration * j3, false, false, false, 14, null);
    }

    @Override // kntr.watch.later.watchlater.api.TranslatableData
    public KTranslationBusiness getBizType() {
        return KTranslationBusiness.TRANS_BIZ_ARC.INSTANCE;
    }

    @Override // kntr.watch.later.watchlater.api.TranslatableData
    public String getBizId() {
        return String.valueOf(this.aid);
    }

    @Override // kntr.watch.later.watchlater.api.TranslatableData
    public String getOriginTitle() {
        String str = this.title;
        return str == null ? "" : str;
    }

    @Override // kntr.watch.later.watchlater.api.TranslatableData
    public int getTranslateStatus() {
        TranslateInfo translateInfo = this.translateInfo;
        if (translateInfo != null) {
            return translateInfo.getTranslateState();
        }
        return 0;
    }

    @Override // kntr.watch.later.watchlater.api.TranslatableData
    public void setTranslateStatus(int value) {
        TranslateInfo translateInfo = this.translateInfo;
        if (translateInfo != null) {
            translateInfo.setTranslateState(value);
        }
        Function0<Unit> function0 = this.onTranslateStateChagne;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // kntr.watch.later.watchlater.api.TranslatableData
    public String getTranslateTitle() {
        TranslateInfo translateInfo = this.translateInfo;
        if (translateInfo != null) {
            return translateInfo.getTranslateTitle();
        }
        return null;
    }

    @Override // kntr.watch.later.watchlater.api.TranslatableData
    public void setTranslateTitle(String value) {
        TranslateInfo translateInfo = this.translateInfo;
        if (translateInfo != null) {
            translateInfo.setTranslateTitle(value);
        }
    }

    public final String getDisplayTitle() {
        if (getTranslateStatus() == 2) {
            String translateTitle = getTranslateTitle();
            if (!(translateTitle == null || StringsKt.isBlank(translateTitle))) {
                return getTranslateTitle();
            }
        }
        return this.title;
    }

    public final Function0<Unit> getOnTranslateStateChagne() {
        return this.onTranslateStateChagne;
    }

    public final void setOnTranslateStateChagne(Function0<Unit> function0) {
        this.onTranslateStateChagne = function0;
    }
}