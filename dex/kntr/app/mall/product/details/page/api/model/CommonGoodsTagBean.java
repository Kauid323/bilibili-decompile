package kntr.app.mall.product.details.page.api.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CommonGoodsTagBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\bQ\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u007f2\u00020\u0001:\u0002~\u007fB\u009b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dB\u0081\u0002\b\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001c\u0010!J\u0010\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010_\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¢\u0002\u0010o\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010pJ\u0013\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010t\u001a\u00020\u0003HÖ\u0001J\t\u0010u\u001a\u00020\u0005HÖ\u0001J%\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00002\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|H\u0001¢\u0006\u0002\b}R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010(\"\u0004\b;\u0010*R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b<\u00104\"\u0004\b=\u00106R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010(\"\u0004\bA\u0010*R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010(\"\u0004\bC\u0010*R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010(\"\u0004\bE\u0010*R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010(\"\u0004\bG\u0010*R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010(\"\u0004\bI\u0010*R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010(\"\u0004\bK\u0010*R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010(\"\u0004\bM\u0010*R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010(\"\u0004\bO\u0010*R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010(\"\u0004\bQ\u0010*R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010(\"\u0004\bS\u0010*R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010(\"\u0004\bU\u0010*R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010(\"\u0004\bW\u0010*¨\u0006\u0080\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CommonGoodsTagBean;", "", "tagVersion", "", "backImgUrlDay", "", "backImgUrlNight", "tagType", "backImgUrl", "backNightImgUrl", "backImgWidth", "", "backImgHeight", "title", "cornerRadius", "useBoard", "boardDayColor1", "boardDayColor2", "boardNightColor1", "boardNightColor2", "backDayColor1", "backDayColor2", "backNightColor1", "backNightColor2", "titleDayColor1", "titleDayColor2", "titleNightColor1", "titleNightColor2", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTagVersion", "()Ljava/lang/Integer;", "setTagVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBackImgUrlDay", "()Ljava/lang/String;", "setBackImgUrlDay", "(Ljava/lang/String;)V", "getBackImgUrlNight", "setBackImgUrlNight", "getTagType", "setTagType", "getBackImgUrl", "setBackImgUrl", "getBackNightImgUrl", "setBackNightImgUrl", "getBackImgWidth", "()Ljava/lang/Double;", "setBackImgWidth", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getBackImgHeight", "setBackImgHeight", "getTitle", "setTitle", "getCornerRadius", "setCornerRadius", "getUseBoard", "setUseBoard", "getBoardDayColor1", "setBoardDayColor1", "getBoardDayColor2", "setBoardDayColor2", "getBoardNightColor1", "setBoardNightColor1", "getBoardNightColor2", "setBoardNightColor2", "getBackDayColor1", "setBackDayColor1", "getBackDayColor2", "setBackDayColor2", "getBackNightColor1", "setBackNightColor1", "getBackNightColor2", "setBackNightColor2", "getTitleDayColor1", "setTitleDayColor1", "getTitleDayColor2", "setTitleDayColor2", "getTitleNightColor1", "setTitleNightColor1", "getTitleNightColor2", "setTitleNightColor2", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/CommonGoodsTagBean;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CommonGoodsTagBean {
    private String backDayColor1;
    private String backDayColor2;
    private Double backImgHeight;
    private String backImgUrl;
    private String backImgUrlDay;
    private String backImgUrlNight;
    private Double backImgWidth;
    private String backNightColor1;
    private String backNightColor2;
    private String backNightImgUrl;
    private String boardDayColor1;
    private String boardDayColor2;
    private String boardNightColor1;
    private String boardNightColor2;
    private Double cornerRadius;
    private Integer tagType;
    private Integer tagVersion;
    private String title;
    private String titleDayColor1;
    private String titleDayColor2;
    private String titleNightColor1;
    private String titleNightColor2;
    private Integer useBoard;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CommonGoodsTagBean() {
        this((Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Double) null, (Double) null, (String) null, (Double) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 8388607, (DefaultConstructorMarker) null);
    }

    public final Integer component1() {
        return this.tagVersion;
    }

    public final Double component10() {
        return this.cornerRadius;
    }

    public final Integer component11() {
        return this.useBoard;
    }

    public final String component12() {
        return this.boardDayColor1;
    }

    public final String component13() {
        return this.boardDayColor2;
    }

    public final String component14() {
        return this.boardNightColor1;
    }

    public final String component15() {
        return this.boardNightColor2;
    }

    public final String component16() {
        return this.backDayColor1;
    }

    public final String component17() {
        return this.backDayColor2;
    }

    public final String component18() {
        return this.backNightColor1;
    }

    public final String component19() {
        return this.backNightColor2;
    }

    public final String component2() {
        return this.backImgUrlDay;
    }

    public final String component20() {
        return this.titleDayColor1;
    }

    public final String component21() {
        return this.titleDayColor2;
    }

    public final String component22() {
        return this.titleNightColor1;
    }

    public final String component23() {
        return this.titleNightColor2;
    }

    public final String component3() {
        return this.backImgUrlNight;
    }

    public final Integer component4() {
        return this.tagType;
    }

    public final String component5() {
        return this.backImgUrl;
    }

    public final String component6() {
        return this.backNightImgUrl;
    }

    public final Double component7() {
        return this.backImgWidth;
    }

    public final Double component8() {
        return this.backImgHeight;
    }

    public final String component9() {
        return this.title;
    }

    public final CommonGoodsTagBean copy(Integer num, String str, String str2, Integer num2, String str3, String str4, Double d, Double d2, String str5, Double d3, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        return new CommonGoodsTagBean(num, str, str2, num2, str3, str4, d, d2, str5, d3, num3, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommonGoodsTagBean) {
            CommonGoodsTagBean commonGoodsTagBean = (CommonGoodsTagBean) obj;
            return Intrinsics.areEqual(this.tagVersion, commonGoodsTagBean.tagVersion) && Intrinsics.areEqual(this.backImgUrlDay, commonGoodsTagBean.backImgUrlDay) && Intrinsics.areEqual(this.backImgUrlNight, commonGoodsTagBean.backImgUrlNight) && Intrinsics.areEqual(this.tagType, commonGoodsTagBean.tagType) && Intrinsics.areEqual(this.backImgUrl, commonGoodsTagBean.backImgUrl) && Intrinsics.areEqual(this.backNightImgUrl, commonGoodsTagBean.backNightImgUrl) && Intrinsics.areEqual(this.backImgWidth, commonGoodsTagBean.backImgWidth) && Intrinsics.areEqual(this.backImgHeight, commonGoodsTagBean.backImgHeight) && Intrinsics.areEqual(this.title, commonGoodsTagBean.title) && Intrinsics.areEqual(this.cornerRadius, commonGoodsTagBean.cornerRadius) && Intrinsics.areEqual(this.useBoard, commonGoodsTagBean.useBoard) && Intrinsics.areEqual(this.boardDayColor1, commonGoodsTagBean.boardDayColor1) && Intrinsics.areEqual(this.boardDayColor2, commonGoodsTagBean.boardDayColor2) && Intrinsics.areEqual(this.boardNightColor1, commonGoodsTagBean.boardNightColor1) && Intrinsics.areEqual(this.boardNightColor2, commonGoodsTagBean.boardNightColor2) && Intrinsics.areEqual(this.backDayColor1, commonGoodsTagBean.backDayColor1) && Intrinsics.areEqual(this.backDayColor2, commonGoodsTagBean.backDayColor2) && Intrinsics.areEqual(this.backNightColor1, commonGoodsTagBean.backNightColor1) && Intrinsics.areEqual(this.backNightColor2, commonGoodsTagBean.backNightColor2) && Intrinsics.areEqual(this.titleDayColor1, commonGoodsTagBean.titleDayColor1) && Intrinsics.areEqual(this.titleDayColor2, commonGoodsTagBean.titleDayColor2) && Intrinsics.areEqual(this.titleNightColor1, commonGoodsTagBean.titleNightColor1) && Intrinsics.areEqual(this.titleNightColor2, commonGoodsTagBean.titleNightColor2);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((this.tagVersion == null ? 0 : this.tagVersion.hashCode()) * 31) + (this.backImgUrlDay == null ? 0 : this.backImgUrlDay.hashCode())) * 31) + (this.backImgUrlNight == null ? 0 : this.backImgUrlNight.hashCode())) * 31) + (this.tagType == null ? 0 : this.tagType.hashCode())) * 31) + (this.backImgUrl == null ? 0 : this.backImgUrl.hashCode())) * 31) + (this.backNightImgUrl == null ? 0 : this.backNightImgUrl.hashCode())) * 31) + (this.backImgWidth == null ? 0 : this.backImgWidth.hashCode())) * 31) + (this.backImgHeight == null ? 0 : this.backImgHeight.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.cornerRadius == null ? 0 : this.cornerRadius.hashCode())) * 31) + (this.useBoard == null ? 0 : this.useBoard.hashCode())) * 31) + (this.boardDayColor1 == null ? 0 : this.boardDayColor1.hashCode())) * 31) + (this.boardDayColor2 == null ? 0 : this.boardDayColor2.hashCode())) * 31) + (this.boardNightColor1 == null ? 0 : this.boardNightColor1.hashCode())) * 31) + (this.boardNightColor2 == null ? 0 : this.boardNightColor2.hashCode())) * 31) + (this.backDayColor1 == null ? 0 : this.backDayColor1.hashCode())) * 31) + (this.backDayColor2 == null ? 0 : this.backDayColor2.hashCode())) * 31) + (this.backNightColor1 == null ? 0 : this.backNightColor1.hashCode())) * 31) + (this.backNightColor2 == null ? 0 : this.backNightColor2.hashCode())) * 31) + (this.titleDayColor1 == null ? 0 : this.titleDayColor1.hashCode())) * 31) + (this.titleDayColor2 == null ? 0 : this.titleDayColor2.hashCode())) * 31) + (this.titleNightColor1 == null ? 0 : this.titleNightColor1.hashCode())) * 31) + (this.titleNightColor2 != null ? this.titleNightColor2.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.tagVersion;
        String str = this.backImgUrlDay;
        String str2 = this.backImgUrlNight;
        Integer num2 = this.tagType;
        String str3 = this.backImgUrl;
        String str4 = this.backNightImgUrl;
        Double d = this.backImgWidth;
        Double d2 = this.backImgHeight;
        String str5 = this.title;
        Double d3 = this.cornerRadius;
        Integer num3 = this.useBoard;
        String str6 = this.boardDayColor1;
        String str7 = this.boardDayColor2;
        String str8 = this.boardNightColor1;
        String str9 = this.boardNightColor2;
        String str10 = this.backDayColor1;
        String str11 = this.backDayColor2;
        String str12 = this.backNightColor1;
        String str13 = this.backNightColor2;
        String str14 = this.titleDayColor1;
        String str15 = this.titleDayColor2;
        String str16 = this.titleNightColor1;
        return "CommonGoodsTagBean(tagVersion=" + num + ", backImgUrlDay=" + str + ", backImgUrlNight=" + str2 + ", tagType=" + num2 + ", backImgUrl=" + str3 + ", backNightImgUrl=" + str4 + ", backImgWidth=" + d + ", backImgHeight=" + d2 + ", title=" + str5 + ", cornerRadius=" + d3 + ", useBoard=" + num3 + ", boardDayColor1=" + str6 + ", boardDayColor2=" + str7 + ", boardNightColor1=" + str8 + ", boardNightColor2=" + str9 + ", backDayColor1=" + str10 + ", backDayColor2=" + str11 + ", backNightColor1=" + str12 + ", backNightColor2=" + str13 + ", titleDayColor1=" + str14 + ", titleDayColor2=" + str15 + ", titleNightColor1=" + str16 + ", titleNightColor2=" + this.titleNightColor2 + ")";
    }

    /* compiled from: CommonGoodsTagBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CommonGoodsTagBean$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CommonGoodsTagBean;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CommonGoodsTagBean> serializer() {
            return CommonGoodsTagBean$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CommonGoodsTagBean(int seen0, Integer tagVersion, String backImgUrlDay, String backImgUrlNight, Integer tagType, String backImgUrl, String backNightImgUrl, Double backImgWidth, Double backImgHeight, String title, Double cornerRadius, Integer useBoard, String boardDayColor1, String boardDayColor2, String boardNightColor1, String boardNightColor2, String backDayColor1, String backDayColor2, String backNightColor1, String backNightColor2, String titleDayColor1, String titleDayColor2, String titleNightColor1, String titleNightColor2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.tagVersion = null;
        } else {
            this.tagVersion = tagVersion;
        }
        if ((seen0 & 2) == 0) {
            this.backImgUrlDay = null;
        } else {
            this.backImgUrlDay = backImgUrlDay;
        }
        if ((seen0 & 4) == 0) {
            this.backImgUrlNight = null;
        } else {
            this.backImgUrlNight = backImgUrlNight;
        }
        if ((seen0 & 8) == 0) {
            this.tagType = null;
        } else {
            this.tagType = tagType;
        }
        if ((seen0 & 16) == 0) {
            this.backImgUrl = null;
        } else {
            this.backImgUrl = backImgUrl;
        }
        if ((seen0 & 32) == 0) {
            this.backNightImgUrl = null;
        } else {
            this.backNightImgUrl = backNightImgUrl;
        }
        if ((seen0 & 64) == 0) {
            this.backImgWidth = Double.valueOf(0.0d);
        } else {
            this.backImgWidth = backImgWidth;
        }
        if ((seen0 & 128) == 0) {
            this.backImgHeight = Double.valueOf(0.0d);
        } else {
            this.backImgHeight = backImgHeight;
        }
        if ((seen0 & 256) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 512) == 0) {
            this.cornerRadius = Double.valueOf(0.0d);
        } else {
            this.cornerRadius = cornerRadius;
        }
        if ((seen0 & 1024) == 0) {
            this.useBoard = 0;
        } else {
            this.useBoard = useBoard;
        }
        if ((seen0 & 2048) == 0) {
            this.boardDayColor1 = null;
        } else {
            this.boardDayColor1 = boardDayColor1;
        }
        if ((seen0 & 4096) == 0) {
            this.boardDayColor2 = null;
        } else {
            this.boardDayColor2 = boardDayColor2;
        }
        if ((seen0 & 8192) == 0) {
            this.boardNightColor1 = null;
        } else {
            this.boardNightColor1 = boardNightColor1;
        }
        if ((seen0 & 16384) == 0) {
            this.boardNightColor2 = null;
        } else {
            this.boardNightColor2 = boardNightColor2;
        }
        if ((seen0 & 32768) == 0) {
            this.backDayColor1 = null;
        } else {
            this.backDayColor1 = backDayColor1;
        }
        if ((seen0 & 65536) == 0) {
            this.backDayColor2 = null;
        } else {
            this.backDayColor2 = backDayColor2;
        }
        if ((seen0 & 131072) == 0) {
            this.backNightColor1 = null;
        } else {
            this.backNightColor1 = backNightColor1;
        }
        if ((seen0 & 262144) == 0) {
            this.backNightColor2 = null;
        } else {
            this.backNightColor2 = backNightColor2;
        }
        if ((seen0 & 524288) == 0) {
            this.titleDayColor1 = null;
        } else {
            this.titleDayColor1 = titleDayColor1;
        }
        if ((seen0 & 1048576) == 0) {
            this.titleDayColor2 = null;
        } else {
            this.titleDayColor2 = titleDayColor2;
        }
        if ((seen0 & 2097152) == 0) {
            this.titleNightColor1 = null;
        } else {
            this.titleNightColor1 = titleNightColor1;
        }
        if ((seen0 & 4194304) == 0) {
            this.titleNightColor2 = null;
        } else {
            this.titleNightColor2 = titleNightColor2;
        }
    }

    public CommonGoodsTagBean(Integer tagVersion, String backImgUrlDay, String backImgUrlNight, Integer tagType, String backImgUrl, String backNightImgUrl, Double backImgWidth, Double backImgHeight, String title, Double cornerRadius, Integer useBoard, String boardDayColor1, String boardDayColor2, String boardNightColor1, String boardNightColor2, String backDayColor1, String backDayColor2, String backNightColor1, String backNightColor2, String titleDayColor1, String titleDayColor2, String titleNightColor1, String titleNightColor2) {
        this.tagVersion = tagVersion;
        this.backImgUrlDay = backImgUrlDay;
        this.backImgUrlNight = backImgUrlNight;
        this.tagType = tagType;
        this.backImgUrl = backImgUrl;
        this.backNightImgUrl = backNightImgUrl;
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
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CommonGoodsTagBean self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Integer num;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.tagVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.tagVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.backImgUrlDay != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.backImgUrlDay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.backImgUrlNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.backImgUrlNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.tagType != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.tagType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.backImgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.backImgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.backNightImgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.backNightImgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.backImgWidth, Double.valueOf(0.0d))) {
            output.encodeNullableSerializableElement(serialDesc, 6, DoubleSerializer.INSTANCE, self.backImgWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.backImgHeight, Double.valueOf(0.0d))) {
            output.encodeNullableSerializableElement(serialDesc, 7, DoubleSerializer.INSTANCE, self.backImgHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.cornerRadius, Double.valueOf(0.0d))) {
            output.encodeNullableSerializableElement(serialDesc, 9, DoubleSerializer.INSTANCE, self.cornerRadius);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || (num = self.useBoard) == null || num.intValue() != 0) {
            output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.useBoard);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.boardDayColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.boardDayColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.boardDayColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.boardDayColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.boardNightColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.boardNightColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.boardNightColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.boardNightColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.backDayColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.backDayColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.backDayColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.backDayColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.backNightColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.backNightColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.backNightColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.backNightColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.titleDayColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.titleDayColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.titleDayColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.titleDayColor2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.titleNightColor1 != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.titleNightColor1);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.titleNightColor2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.titleNightColor2);
        }
    }

    public /* synthetic */ CommonGoodsTagBean(Integer num, String str, String str2, Integer num2, String str3, String str4, Double d, Double d2, String str5, Double d3, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? Double.valueOf(0.0d) : d, (i & 128) != 0 ? Double.valueOf(0.0d) : d2, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? Double.valueOf(0.0d) : d3, (i & 1024) != 0 ? 0 : num3, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : str9, (i & 32768) != 0 ? null : str10, (i & 65536) != 0 ? null : str11, (i & 131072) != 0 ? null : str12, (i & 262144) != 0 ? null : str13, (i & 524288) != 0 ? null : str14, (i & 1048576) != 0 ? null : str15, (i & 2097152) != 0 ? null : str16, (i & 4194304) != 0 ? null : str17);
    }

    public final Integer getTagVersion() {
        return this.tagVersion;
    }

    public final void setTagVersion(Integer num) {
        this.tagVersion = num;
    }

    public final String getBackImgUrlDay() {
        return this.backImgUrlDay;
    }

    public final void setBackImgUrlDay(String str) {
        this.backImgUrlDay = str;
    }

    public final String getBackImgUrlNight() {
        return this.backImgUrlNight;
    }

    public final void setBackImgUrlNight(String str) {
        this.backImgUrlNight = str;
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

    public final String getBackNightImgUrl() {
        return this.backNightImgUrl;
    }

    public final void setBackNightImgUrl(String str) {
        this.backNightImgUrl = str;
    }

    public final Double getBackImgWidth() {
        return this.backImgWidth;
    }

    public final void setBackImgWidth(Double d) {
        this.backImgWidth = d;
    }

    public final Double getBackImgHeight() {
        return this.backImgHeight;
    }

    public final void setBackImgHeight(Double d) {
        this.backImgHeight = d;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final Double getCornerRadius() {
        return this.cornerRadius;
    }

    public final void setCornerRadius(Double d) {
        this.cornerRadius = d;
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
}