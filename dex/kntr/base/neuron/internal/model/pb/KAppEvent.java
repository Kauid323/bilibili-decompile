package kntr.base.neuron.internal.model.pb;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: info_raw.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u0011\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u007f2\u00020\u0001:\u0007\u007f\u0080\u0001\u0081\u0001\u0082\u0001BÛ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0019¢\u0006\u0004\b\"\u0010#B×\u0001\b\u0010\u0012\u0006\u0010$\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0019\u0012\b\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0004\b\"\u0010'J\u0011\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001a0[¢\u0006\u0002\u0010\\J\u0011\u0010]\u001a\b\u0012\u0004\u0012\u00020!0[¢\u0006\u0002\u0010^J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\nHÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\rHÆ\u0003J\t\u0010f\u001a\u00020\nHÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0011HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003J\t\u0010m\u001a\u00020\rHÆ\u0003J\t\u0010n\u001a\u00020\nHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\t\u0010p\u001a\u00020\rHÆ\u0003J\u000f\u0010q\u001a\b\u0012\u0004\u0012\u00020!0\u0019HÆ\u0003JÝ\u0001\u0010r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\r2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0019HÆ\u0001J\u0013\u0010s\u001a\u00020\u00052\b\u0010t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010u\u001a\u00020\rHÖ\u0001J\t\u0010v\u001a\u00020\u0003HÖ\u0001J%\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020\u00002\u0006\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}H\u0001¢\u0006\u0002\b~R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010)\u001a\u0004\b-\u0010.R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010)\u001a\u0004\b0\u00101R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010)\u001a\u0004\b3\u0010+R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010)\u001a\u0004\b5\u00106R\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010)\u001a\u0004\b8\u0010+R\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010)\u001a\u0004\b:\u0010;R\u001c\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010)\u001a\u0004\b=\u00106R\u001c\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010)\u001a\u0004\b?\u0010+R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010)\u001a\u0004\bA\u0010BR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010)\u001a\u0004\bD\u0010ER\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010)\u001a\u0004\bG\u0010HR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010)\u001a\u0004\bJ\u0010KR\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010)\u001a\u0004\bM\u0010NR\u001c\u0010\u001b\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010)\u001a\u0004\bP\u0010;R\u001c\u0010\u001c\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u0010)\u001a\u0004\bR\u00106R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bS\u0010)\u001a\u0004\bT\u0010UR\u001c\u0010\u001f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010)\u001a\u0004\bW\u0010;R\"\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010)\u001a\u0004\bY\u0010N¨\u0006\u0083\u0001"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppEvent;", "", "eventId", "", "force", "", "runtimeInfo", "Lkntr/base/neuron/internal/model/pb/KAppRuntimeInfo;", "mid", "ctime", "", "logId", "retrySendCount", "", "sn", "filePath", "eventCategory", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "appPageViewInfo", "Lkntr/base/neuron/internal/model/pb/KAppPageViewInfo;", "appClickInfo", "Lkntr/base/neuron/internal/model/pb/KAppClickInfo;", "appExposureInfo", "Lkntr/base/neuron/internal/model/pb/KAppExposureInfo;", "extendedFields", "", "Lkntr/base/neuron/internal/model/pb/KAppEvent$KExtendedFieldsEntry;", "pageType", "snGenTime", "appPlayerInfo", "Lkntr/base/neuron/internal/model/pb/KAppPlayerInfo;", "policy", "extra", "Lkntr/base/neuron/internal/model/pb/KAppEvent$KExtraEntry;", "<init>", "(Ljava/lang/String;ZLkntr/base/neuron/internal/model/pb/KAppRuntimeInfo;Ljava/lang/String;JLjava/lang/String;IJLjava/lang/String;Lkntr/base/neuron/internal/model/pb/KEventCategory;Lkntr/base/neuron/internal/model/pb/KAppPageViewInfo;Lkntr/base/neuron/internal/model/pb/KAppClickInfo;Lkntr/base/neuron/internal/model/pb/KAppExposureInfo;Ljava/util/List;IJLkntr/base/neuron/internal/model/pb/KAppPlayerInfo;ILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLkntr/base/neuron/internal/model/pb/KAppRuntimeInfo;Ljava/lang/String;JLjava/lang/String;IJLjava/lang/String;Lkntr/base/neuron/internal/model/pb/KEventCategory;Lkntr/base/neuron/internal/model/pb/KAppPageViewInfo;Lkntr/base/neuron/internal/model/pb/KAppClickInfo;Lkntr/base/neuron/internal/model/pb/KAppExposureInfo;Ljava/util/List;IJLkntr/base/neuron/internal/model/pb/KAppPlayerInfo;ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEventId$annotations", "()V", "getEventId", "()Ljava/lang/String;", "getForce$annotations", "getForce", "()Z", "getRuntimeInfo$annotations", "getRuntimeInfo", "()Lkntr/base/neuron/internal/model/pb/KAppRuntimeInfo;", "getMid$annotations", "getMid", "getCtime$annotations", "getCtime", "()J", "getLogId$annotations", "getLogId", "getRetrySendCount$annotations", "getRetrySendCount", "()I", "getSn$annotations", "getSn", "getFilePath$annotations", "getFilePath", "getEventCategory$annotations", "getEventCategory", "()Lkntr/base/neuron/internal/model/pb/KEventCategory;", "getAppPageViewInfo$annotations", "getAppPageViewInfo", "()Lkntr/base/neuron/internal/model/pb/KAppPageViewInfo;", "getAppClickInfo$annotations", "getAppClickInfo", "()Lkntr/base/neuron/internal/model/pb/KAppClickInfo;", "getAppExposureInfo$annotations", "getAppExposureInfo", "()Lkntr/base/neuron/internal/model/pb/KAppExposureInfo;", "getExtendedFields$annotations", "getExtendedFields", "()Ljava/util/List;", "getPageType$annotations", "getPageType", "getSnGenTime$annotations", "getSnGenTime", "getAppPlayerInfo$annotations", "getAppPlayerInfo", "()Lkntr/base/neuron/internal/model/pb/KAppPlayerInfo;", "getPolicy$annotations", "getPolicy", "getExtra$annotations", "getExtra", "extendedFieldsArray", "", "()[Lkntr/base/neuron/internal/model/pb/KAppEvent$KExtendedFieldsEntry;", "extraArray", "()[Lkntr/base/neuron/internal/model/pb/KAppEvent$KExtraEntry;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "KExtendedFieldsEntry", "KExtraEntry", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class KAppEvent {
    public static final String targetPath = "/AppEvent";
    private final KAppClickInfo appClickInfo;
    private final KAppExposureInfo appExposureInfo;
    private final KAppPageViewInfo appPageViewInfo;
    private final KAppPlayerInfo appPlayerInfo;
    private final long ctime;
    private final KEventCategory eventCategory;
    private final String eventId;
    private final List<KExtendedFieldsEntry> extendedFields;
    private final List<KExtraEntry> extra;
    private final String filePath;
    private final boolean force;
    private final String logId;
    private final String mid;
    private final int pageType;
    private final int policy;
    private final int retrySendCount;
    private final KAppRuntimeInfo runtimeInfo;
    private final long sn;
    private final long snGenTime;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KAppEvent$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = KAppEvent._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KAppEvent$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = KAppEvent._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public KAppEvent() {
        this((String) null, false, (KAppRuntimeInfo) null, (String) null, 0L, (String) null, 0, 0L, (String) null, (KEventCategory) null, (KAppPageViewInfo) null, (KAppClickInfo) null, (KAppExposureInfo) null, (List) null, 0, 0L, (KAppPlayerInfo) null, 0, (List) null, 524287, (DefaultConstructorMarker) null);
    }

    @SerialName("appClickInfo")
    @ProtoNumber(number = 12)
    public static /* synthetic */ void getAppClickInfo$annotations() {
    }

    @SerialName("appExposureInfo")
    @ProtoNumber(number = 13)
    public static /* synthetic */ void getAppExposureInfo$annotations() {
    }

    @SerialName("appPageViewInfo")
    @ProtoNumber(number = MediaAttrUtils.TYPE_MENU)
    public static /* synthetic */ void getAppPageViewInfo$annotations() {
    }

    @SerialName("appPlayerInfo")
    @ProtoNumber(number = 17)
    public static /* synthetic */ void getAppPlayerInfo$annotations() {
    }

    @SerialName("ctime")
    @ProtoNumber(number = 5)
    public static /* synthetic */ void getCtime$annotations() {
    }

    @SerialName("eventCategory")
    @ProtoNumber(number = 10)
    public static /* synthetic */ void getEventCategory$annotations() {
    }

    @SerialName("eventId")
    @ProtoNumber(number = 1)
    public static /* synthetic */ void getEventId$annotations() {
    }

    @SerialName("extendedFields")
    @ProtoNumber(number = ConstantsKt.SPACER_14)
    @ProtoPacked
    public static /* synthetic */ void getExtendedFields$annotations() {
    }

    @SerialName("extra")
    @ProtoNumber(number = 19)
    @ProtoPacked
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("filePath")
    @ProtoNumber(number = ConstantsKt.SPACER_9)
    public static /* synthetic */ void getFilePath$annotations() {
    }

    @SerialName("force")
    @ProtoNumber(number = 2)
    public static /* synthetic */ void getForce$annotations() {
    }

    @SerialName("logId")
    @ProtoNumber(number = 6)
    public static /* synthetic */ void getLogId$annotations() {
    }

    @SerialName("mid")
    @ProtoNumber(number = 4)
    public static /* synthetic */ void getMid$annotations() {
    }

    @SerialName("pageType")
    @ProtoNumber(number = 15)
    public static /* synthetic */ void getPageType$annotations() {
    }

    @SerialName("policy")
    @ProtoNumber(number = 18)
    public static /* synthetic */ void getPolicy$annotations() {
    }

    @SerialName("retrySendCount")
    @ProtoNumber(number = AdditionalButton.CLICK_TYPE_FIELD_NUMBER)
    public static /* synthetic */ void getRetrySendCount$annotations() {
    }

    @SerialName("runtimeInfo")
    @ProtoNumber(number = 3)
    public static /* synthetic */ void getRuntimeInfo$annotations() {
    }

    @SerialName("sn")
    @ProtoNumber(number = 8)
    public static /* synthetic */ void getSn$annotations() {
    }

    @SerialName("snGenTime")
    @ProtoNumber(number = 16)
    public static /* synthetic */ void getSnGenTime$annotations() {
    }

    public final String component1() {
        return this.eventId;
    }

    public final KEventCategory component10() {
        return this.eventCategory;
    }

    public final KAppPageViewInfo component11() {
        return this.appPageViewInfo;
    }

    public final KAppClickInfo component12() {
        return this.appClickInfo;
    }

    public final KAppExposureInfo component13() {
        return this.appExposureInfo;
    }

    public final List<KExtendedFieldsEntry> component14() {
        return this.extendedFields;
    }

    public final int component15() {
        return this.pageType;
    }

    public final long component16() {
        return this.snGenTime;
    }

    public final KAppPlayerInfo component17() {
        return this.appPlayerInfo;
    }

    public final int component18() {
        return this.policy;
    }

    public final List<KExtraEntry> component19() {
        return this.extra;
    }

    public final boolean component2() {
        return this.force;
    }

    public final KAppRuntimeInfo component3() {
        return this.runtimeInfo;
    }

    public final String component4() {
        return this.mid;
    }

    public final long component5() {
        return this.ctime;
    }

    public final String component6() {
        return this.logId;
    }

    public final int component7() {
        return this.retrySendCount;
    }

    public final long component8() {
        return this.sn;
    }

    public final String component9() {
        return this.filePath;
    }

    public final KAppEvent copy(String str, boolean z, KAppRuntimeInfo kAppRuntimeInfo, String str2, long j, String str3, int i, long j2, String str4, KEventCategory kEventCategory, KAppPageViewInfo kAppPageViewInfo, KAppClickInfo kAppClickInfo, KAppExposureInfo kAppExposureInfo, List<KExtendedFieldsEntry> list, int i2, long j3, KAppPlayerInfo kAppPlayerInfo, int i3, List<KExtraEntry> list2) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(str2, "mid");
        Intrinsics.checkNotNullParameter(str3, "logId");
        Intrinsics.checkNotNullParameter(str4, "filePath");
        Intrinsics.checkNotNullParameter(kEventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(list, "extendedFields");
        Intrinsics.checkNotNullParameter(list2, "extra");
        return new KAppEvent(str, z, kAppRuntimeInfo, str2, j, str3, i, j2, str4, kEventCategory, kAppPageViewInfo, kAppClickInfo, kAppExposureInfo, list, i2, j3, kAppPlayerInfo, i3, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KAppEvent) {
            KAppEvent kAppEvent = (KAppEvent) obj;
            return Intrinsics.areEqual(this.eventId, kAppEvent.eventId) && this.force == kAppEvent.force && Intrinsics.areEqual(this.runtimeInfo, kAppEvent.runtimeInfo) && Intrinsics.areEqual(this.mid, kAppEvent.mid) && this.ctime == kAppEvent.ctime && Intrinsics.areEqual(this.logId, kAppEvent.logId) && this.retrySendCount == kAppEvent.retrySendCount && this.sn == kAppEvent.sn && Intrinsics.areEqual(this.filePath, kAppEvent.filePath) && Intrinsics.areEqual(this.eventCategory, kAppEvent.eventCategory) && Intrinsics.areEqual(this.appPageViewInfo, kAppEvent.appPageViewInfo) && Intrinsics.areEqual(this.appClickInfo, kAppEvent.appClickInfo) && Intrinsics.areEqual(this.appExposureInfo, kAppEvent.appExposureInfo) && Intrinsics.areEqual(this.extendedFields, kAppEvent.extendedFields) && this.pageType == kAppEvent.pageType && this.snGenTime == kAppEvent.snGenTime && Intrinsics.areEqual(this.appPlayerInfo, kAppEvent.appPlayerInfo) && this.policy == kAppEvent.policy && Intrinsics.areEqual(this.extra, kAppEvent.extra);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((this.eventId.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.force)) * 31) + (this.runtimeInfo == null ? 0 : this.runtimeInfo.hashCode())) * 31) + this.mid.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.ctime)) * 31) + this.logId.hashCode()) * 31) + this.retrySendCount) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sn)) * 31) + this.filePath.hashCode()) * 31) + this.eventCategory.hashCode()) * 31) + (this.appPageViewInfo == null ? 0 : this.appPageViewInfo.hashCode())) * 31) + (this.appClickInfo == null ? 0 : this.appClickInfo.hashCode())) * 31) + (this.appExposureInfo == null ? 0 : this.appExposureInfo.hashCode())) * 31) + this.extendedFields.hashCode()) * 31) + this.pageType) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.snGenTime)) * 31) + (this.appPlayerInfo != null ? this.appPlayerInfo.hashCode() : 0)) * 31) + this.policy) * 31) + this.extra.hashCode();
    }

    public String toString() {
        String str = this.eventId;
        boolean z = this.force;
        KAppRuntimeInfo kAppRuntimeInfo = this.runtimeInfo;
        String str2 = this.mid;
        long j = this.ctime;
        String str3 = this.logId;
        int i = this.retrySendCount;
        long j2 = this.sn;
        String str4 = this.filePath;
        KEventCategory kEventCategory = this.eventCategory;
        KAppPageViewInfo kAppPageViewInfo = this.appPageViewInfo;
        KAppClickInfo kAppClickInfo = this.appClickInfo;
        KAppExposureInfo kAppExposureInfo = this.appExposureInfo;
        List<KExtendedFieldsEntry> list = this.extendedFields;
        int i2 = this.pageType;
        long j3 = this.snGenTime;
        KAppPlayerInfo kAppPlayerInfo = this.appPlayerInfo;
        int i3 = this.policy;
        return "KAppEvent(eventId=" + str + ", force=" + z + ", runtimeInfo=" + kAppRuntimeInfo + ", mid=" + str2 + ", ctime=" + j + ", logId=" + str3 + ", retrySendCount=" + i + ", sn=" + j2 + ", filePath=" + str4 + ", eventCategory=" + kEventCategory + ", appPageViewInfo=" + kAppPageViewInfo + ", appClickInfo=" + kAppClickInfo + ", appExposureInfo=" + kAppExposureInfo + ", extendedFields=" + list + ", pageType=" + i2 + ", snGenTime=" + j3 + ", appPlayerInfo=" + kAppPlayerInfo + ", policy=" + i3 + ", extra=" + this.extra + ")";
    }

    public /* synthetic */ KAppEvent(int seen0, String eventId, boolean force, KAppRuntimeInfo runtimeInfo, String mid, long ctime, String logId, int retrySendCount, long sn, String filePath, KEventCategory eventCategory, KAppPageViewInfo appPageViewInfo, KAppClickInfo appClickInfo, KAppExposureInfo appExposureInfo, List extendedFields, int pageType, long snGenTime, KAppPlayerInfo appPlayerInfo, int policy, List extra, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.eventId = "";
        } else {
            this.eventId = eventId;
        }
        if ((seen0 & 2) == 0) {
            this.force = false;
        } else {
            this.force = force;
        }
        if ((seen0 & 4) == 0) {
            this.runtimeInfo = null;
        } else {
            this.runtimeInfo = runtimeInfo;
        }
        if ((seen0 & 8) == 0) {
            this.mid = "";
        } else {
            this.mid = mid;
        }
        if ((seen0 & 16) == 0) {
            this.ctime = 0L;
        } else {
            this.ctime = ctime;
        }
        if ((seen0 & 32) == 0) {
            this.logId = "";
        } else {
            this.logId = logId;
        }
        if ((seen0 & 64) == 0) {
            this.retrySendCount = 0;
        } else {
            this.retrySendCount = retrySendCount;
        }
        if ((seen0 & 128) == 0) {
            this.sn = 0L;
        } else {
            this.sn = sn;
        }
        if ((seen0 & 256) == 0) {
            this.filePath = "";
        } else {
            this.filePath = filePath;
        }
        if ((seen0 & 512) == 0) {
            this.eventCategory = KEventCategory.Companion.fromValue(0);
        } else {
            this.eventCategory = eventCategory;
        }
        if ((seen0 & 1024) == 0) {
            this.appPageViewInfo = null;
        } else {
            this.appPageViewInfo = appPageViewInfo;
        }
        if ((seen0 & 2048) == 0) {
            this.appClickInfo = null;
        } else {
            this.appClickInfo = appClickInfo;
        }
        if ((seen0 & 4096) == 0) {
            this.appExposureInfo = null;
        } else {
            this.appExposureInfo = appExposureInfo;
        }
        if ((seen0 & 8192) == 0) {
            this.extendedFields = CollectionsKt.emptyList();
        } else {
            this.extendedFields = extendedFields;
        }
        if ((seen0 & 16384) == 0) {
            this.pageType = 0;
        } else {
            this.pageType = pageType;
        }
        if ((seen0 & 32768) == 0) {
            this.snGenTime = 0L;
        } else {
            this.snGenTime = snGenTime;
        }
        if ((seen0 & 65536) == 0) {
            this.appPlayerInfo = null;
        } else {
            this.appPlayerInfo = appPlayerInfo;
        }
        if ((131072 & seen0) == 0) {
            this.policy = 0;
        } else {
            this.policy = policy;
        }
        if ((seen0 & 262144) == 0) {
            this.extra = CollectionsKt.emptyList();
        } else {
            this.extra = extra;
        }
    }

    public KAppEvent(String eventId, boolean force, KAppRuntimeInfo runtimeInfo, String mid, long ctime, String logId, int retrySendCount, long sn, String filePath, KEventCategory eventCategory, KAppPageViewInfo appPageViewInfo, KAppClickInfo appClickInfo, KAppExposureInfo appExposureInfo, List<KExtendedFieldsEntry> list, int pageType, long snGenTime, KAppPlayerInfo appPlayerInfo, int policy, List<KExtraEntry> list2) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(mid, "mid");
        Intrinsics.checkNotNullParameter(logId, "logId");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(list, "extendedFields");
        Intrinsics.checkNotNullParameter(list2, "extra");
        this.eventId = eventId;
        this.force = force;
        this.runtimeInfo = runtimeInfo;
        this.mid = mid;
        this.ctime = ctime;
        this.logId = logId;
        this.retrySendCount = retrySendCount;
        this.sn = sn;
        this.filePath = filePath;
        this.eventCategory = eventCategory;
        this.appPageViewInfo = appPageViewInfo;
        this.appClickInfo = appClickInfo;
        this.appExposureInfo = appExposureInfo;
        this.extendedFields = list;
        this.pageType = pageType;
        this.snGenTime = snGenTime;
        this.appPlayerInfo = appPlayerInfo;
        this.policy = policy;
        this.extra = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(KAppEvent$KExtendedFieldsEntry$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(KAppEvent$KExtraEntry$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$neuron_debug(KAppEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.eventId, "")) {
            output.encodeStringElement(serialDesc, 0, self.eventId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.force) {
            output.encodeBooleanElement(serialDesc, 1, self.force);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.runtimeInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, KAppRuntimeInfo$$serializer.INSTANCE, self.runtimeInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.mid, "")) {
            output.encodeStringElement(serialDesc, 3, self.mid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.ctime != 0) {
            output.encodeLongElement(serialDesc, 4, self.ctime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.logId, "")) {
            output.encodeStringElement(serialDesc, 5, self.logId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.retrySendCount != 0) {
            output.encodeIntElement(serialDesc, 6, self.retrySendCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.sn != 0) {
            output.encodeLongElement(serialDesc, 7, self.sn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.filePath, "")) {
            output.encodeStringElement(serialDesc, 8, self.filePath);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.eventCategory, KEventCategory.Companion.fromValue(0))) {
            output.encodeSerializableElement(serialDesc, 9, KEventCategorySerializer.INSTANCE, self.eventCategory);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.appPageViewInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, KAppPageViewInfo$$serializer.INSTANCE, self.appPageViewInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.appClickInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, KAppClickInfo$$serializer.INSTANCE, self.appClickInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.appExposureInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, KAppExposureInfo$$serializer.INSTANCE, self.appExposureInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.extendedFields, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 13, lazyArr[13].getValue(), self.extendedFields);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.pageType != 0) {
            output.encodeIntElement(serialDesc, 14, self.pageType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.snGenTime != 0) {
            output.encodeLongElement(serialDesc, 15, self.snGenTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.appPlayerInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, KAppPlayerInfo$$serializer.INSTANCE, self.appPlayerInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.policy != 0) {
            output.encodeIntElement(serialDesc, 17, self.policy);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || !Intrinsics.areEqual(self.extra, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 18, lazyArr[18].getValue(), self.extra);
        }
    }

    public /* synthetic */ KAppEvent(String str, boolean z, KAppRuntimeInfo kAppRuntimeInfo, String str2, long j, String str3, int i, long j2, String str4, KEventCategory kEventCategory, KAppPageViewInfo kAppPageViewInfo, KAppClickInfo kAppClickInfo, KAppExposureInfo kAppExposureInfo, List list, int i2, long j3, KAppPlayerInfo kAppPlayerInfo, int i3, List list2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? false : z, (i4 & 4) != 0 ? null : kAppRuntimeInfo, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? 0L : j, (i4 & 32) != 0 ? "" : str3, (i4 & 64) != 0 ? 0 : i, (i4 & 128) != 0 ? 0L : j2, (i4 & 256) == 0 ? str4 : "", (i4 & 512) != 0 ? KEventCategory.Companion.fromValue(0) : kEventCategory, (i4 & 1024) != 0 ? null : kAppPageViewInfo, (i4 & 2048) != 0 ? null : kAppClickInfo, (i4 & 4096) != 0 ? null : kAppExposureInfo, (i4 & 8192) != 0 ? CollectionsKt.emptyList() : list, (i4 & 16384) != 0 ? 0 : i2, (i4 & 32768) != 0 ? 0L : j3, (i4 & 65536) != 0 ? null : kAppPlayerInfo, (i4 & 131072) != 0 ? 0 : i3, (i4 & 262144) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final boolean getForce() {
        return this.force;
    }

    public final KAppRuntimeInfo getRuntimeInfo() {
        return this.runtimeInfo;
    }

    public final String getMid() {
        return this.mid;
    }

    public final long getCtime() {
        return this.ctime;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final int getRetrySendCount() {
        return this.retrySendCount;
    }

    public final long getSn() {
        return this.sn;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final KEventCategory getEventCategory() {
        return this.eventCategory;
    }

    public final KAppPageViewInfo getAppPageViewInfo() {
        return this.appPageViewInfo;
    }

    public final KAppClickInfo getAppClickInfo() {
        return this.appClickInfo;
    }

    public final KAppExposureInfo getAppExposureInfo() {
        return this.appExposureInfo;
    }

    public final List<KExtendedFieldsEntry> getExtendedFields() {
        return this.extendedFields;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final long getSnGenTime() {
        return this.snGenTime;
    }

    public final KAppPlayerInfo getAppPlayerInfo() {
        return this.appPlayerInfo;
    }

    public final int getPolicy() {
        return this.policy;
    }

    public final List<KExtraEntry> getExtra() {
        return this.extra;
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppEvent$Companion;", "", "<init>", "()V", "targetPath", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppEvent;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<KAppEvent> serializer() {
            return new GeneratedSerializer<KAppEvent>() { // from class: kntr.base.neuron.internal.model.pb.KAppEvent$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.neuron.internal.model.pb.KAppEvent", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.base.neuron.internal.model.pb.KAppEvent> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.base.neuron.internal.model.pb.KAppEvent> A[REMOVE]) =  kntr.base.neuron.internal.model.pb.KAppEvent$$serializer.INSTANCE kntr.base.neuron.internal.model.pb.KAppEvent$$serializer)
                         in method: kntr.base.neuron.internal.model.pb.KAppEvent.Companion.serializer():kotlinx.serialization.KSerializer<kntr.base.neuron.internal.model.pb.KAppEvent>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.util.ArrayList.forEach(ArrayList.java:1257)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.base.neuron.internal.model.pb.KAppEvent")
                          (wrap: kntr.base.neuron.internal.model.pb.KAppEvent$$serializer : 0x0009: SGET  (r1v0 kntr.base.neuron.internal.model.pb.KAppEvent$$serializer A[REMOVE]) =  kntr.base.neuron.internal.model.pb.KAppEvent$$serializer.INSTANCE kntr.base.neuron.internal.model.pb.KAppEvent$$serializer)
                          (19 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.base.neuron.internal.model.pb.KAppEvent$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.base.neuron.internal.model.pb.KAppEvent$$serializer
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:775)
                        	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:765)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 15 more
                        */
                    /*
                        this = this;
                        kntr.base.neuron.internal.model.pb.KAppEvent$$serializer r0 = kntr.base.neuron.internal.model.pb.KAppEvent$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.base.neuron.internal.model.pb.KAppEvent.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public final KExtendedFieldsEntry[] extendedFieldsArray() {
                Collection $this$toTypedArray$iv = this.extendedFields;
                return (KExtendedFieldsEntry[]) $this$toTypedArray$iv.toArray(new KExtendedFieldsEntry[0]);
            }

            public final KExtraEntry[] extraArray() {
                Collection $this$toTypedArray$iv = this.extra;
                return (KExtraEntry[]) $this$toTypedArray$iv.toArray(new KExtraEntry[0]);
            }

            /* compiled from: info_raw.kt */
            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppEvent$KExtendedFieldsEntry;", "", "key", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey$annotations", "()V", "getKey", "()Ljava/lang/String;", "getValue$annotations", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class KExtendedFieldsEntry {
                public static final Companion Companion = new Companion(null);
                public static final String targetPath = "/AppEvent.ExtendedFieldsEntry";
                private final String key;
                private final String value;

                public KExtendedFieldsEntry() {
                    this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ KExtendedFieldsEntry copy$default(KExtendedFieldsEntry kExtendedFieldsEntry, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = kExtendedFieldsEntry.key;
                    }
                    if ((i & 2) != 0) {
                        str2 = kExtendedFieldsEntry.value;
                    }
                    return kExtendedFieldsEntry.copy(str, str2);
                }

                @SerialName("key")
                @ProtoNumber(number = 1)
                public static /* synthetic */ void getKey$annotations() {
                }

                @SerialName("value")
                @ProtoNumber(number = 2)
                public static /* synthetic */ void getValue$annotations() {
                }

                public final String component1() {
                    return this.key;
                }

                public final String component2() {
                    return this.value;
                }

                public final KExtendedFieldsEntry copy(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, "key");
                    Intrinsics.checkNotNullParameter(str2, "value");
                    return new KExtendedFieldsEntry(str, str2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof KExtendedFieldsEntry) {
                        KExtendedFieldsEntry kExtendedFieldsEntry = (KExtendedFieldsEntry) obj;
                        return Intrinsics.areEqual(this.key, kExtendedFieldsEntry.key) && Intrinsics.areEqual(this.value, kExtendedFieldsEntry.value);
                    }
                    return false;
                }

                public int hashCode() {
                    return (this.key.hashCode() * 31) + this.value.hashCode();
                }

                public String toString() {
                    String str = this.key;
                    return "KExtendedFieldsEntry(key=" + str + ", value=" + this.value + ")";
                }

                public /* synthetic */ KExtendedFieldsEntry(int seen0, String key, String value, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.key = "";
                    } else {
                        this.key = key;
                    }
                    if ((seen0 & 2) == 0) {
                        this.value = "";
                    } else {
                        this.value = value;
                    }
                }

                public KExtendedFieldsEntry(String key, String value) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(value, "value");
                    this.key = key;
                    this.value = value;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$neuron_debug(KExtendedFieldsEntry self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.key, "")) {
                        output.encodeStringElement(serialDesc, 0, self.key);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.value, "")) {
                        output.encodeStringElement(serialDesc, 1, self.value);
                    }
                }

                public /* synthetic */ KExtendedFieldsEntry(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
                }

                public final String getKey() {
                    return this.key;
                }

                public final String getValue() {
                    return this.value;
                }

                /* compiled from: info_raw.kt */
                @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppEvent$KExtendedFieldsEntry$Companion;", "", "<init>", "()V", "targetPath", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppEvent$KExtendedFieldsEntry;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<KExtendedFieldsEntry> serializer() {
                        return KAppEvent$KExtendedFieldsEntry$$serializer.INSTANCE;
                    }
                }
            }

            /* compiled from: info_raw.kt */
            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppEvent$KExtraEntry;", "", "key", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey$annotations", "()V", "getKey", "()Ljava/lang/String;", "getValue$annotations", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class KExtraEntry {
                public static final Companion Companion = new Companion(null);
                public static final String targetPath = "/AppEvent.ExtraEntry";
                private final String key;
                private final String value;

                public KExtraEntry() {
                    this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ KExtraEntry copy$default(KExtraEntry kExtraEntry, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = kExtraEntry.key;
                    }
                    if ((i & 2) != 0) {
                        str2 = kExtraEntry.value;
                    }
                    return kExtraEntry.copy(str, str2);
                }

                @SerialName("key")
                @ProtoNumber(number = 1)
                public static /* synthetic */ void getKey$annotations() {
                }

                @SerialName("value")
                @ProtoNumber(number = 2)
                public static /* synthetic */ void getValue$annotations() {
                }

                public final String component1() {
                    return this.key;
                }

                public final String component2() {
                    return this.value;
                }

                public final KExtraEntry copy(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, "key");
                    Intrinsics.checkNotNullParameter(str2, "value");
                    return new KExtraEntry(str, str2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof KExtraEntry) {
                        KExtraEntry kExtraEntry = (KExtraEntry) obj;
                        return Intrinsics.areEqual(this.key, kExtraEntry.key) && Intrinsics.areEqual(this.value, kExtraEntry.value);
                    }
                    return false;
                }

                public int hashCode() {
                    return (this.key.hashCode() * 31) + this.value.hashCode();
                }

                public String toString() {
                    String str = this.key;
                    return "KExtraEntry(key=" + str + ", value=" + this.value + ")";
                }

                public /* synthetic */ KExtraEntry(int seen0, String key, String value, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.key = "";
                    } else {
                        this.key = key;
                    }
                    if ((seen0 & 2) == 0) {
                        this.value = "";
                    } else {
                        this.value = value;
                    }
                }

                public KExtraEntry(String key, String value) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(value, "value");
                    this.key = key;
                    this.value = value;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$neuron_debug(KExtraEntry self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.key, "")) {
                        output.encodeStringElement(serialDesc, 0, self.key);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.value, "")) {
                        output.encodeStringElement(serialDesc, 1, self.value);
                    }
                }

                public /* synthetic */ KExtraEntry(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
                }

                public final String getKey() {
                    return this.key;
                }

                public final String getValue() {
                    return this.value;
                }

                /* compiled from: info_raw.kt */
                @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppEvent$KExtraEntry$Companion;", "", "<init>", "()V", "targetPath", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppEvent$KExtraEntry;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<KExtraEntry> serializer() {
                        return KAppEvent$KExtraEntry$$serializer.INSTANCE;
                    }
                }
            }
        }