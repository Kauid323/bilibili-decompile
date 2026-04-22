package im.session.model;

import com.bapis.bilibili.app.im.v1.KMsgSummary;
import com.bapis.bilibili.app.im.v1.KMsgSummary$;
import com.bapis.bilibili.app.im.v1.KPrivateId;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSessionIdSerializer;
import com.bapis.bilibili.app.im.v1.KSessionOperation;
import com.bapis.bilibili.app.im.v1.KSessionOperation$;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.bapis.bilibili.app.im.v1.KUnread$;
import com.bapis.bilibili.app.im.v1.KUnreadStyle;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import com.tencent.open.SocialConstants;
import im.base.serializer.InstantMicroSecondSerializer;
import im.session.service.IMMessageSummaryServiceKt;
import im.session.service.Summary;
import im.session.service.Summary$$serializer;
import im.session.service.SummaryPrefix;
import io.ktor.client.utils.CIOKt;
import java.lang.annotation.Annotation;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kntr.base.localization.DateTimeFormatKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.datetime.Instant;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: IMSessionCard.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 {2\u00020\u0001:\u0002{|B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aB£\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u0019\u0010!J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020\u0000J\u0013\u0010]\u001a\u00020\r2\b\u0010^\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010_\u001a\u00020\u001cH\u0016J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0007HÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0002\bdJ\u000e\u0010e\u001a\u00020\u000bHÀ\u0003¢\u0006\u0002\bfJ\t\u0010g\u001a\u00020\rHÆ\u0003J\u000e\u0010h\u001a\u00020\u000fHÀ\u0003¢\u0006\u0002\biJ\t\u0010j\u001a\u00020\rHÆ\u0003J\t\u0010k\u001a\u00020\u0012HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0014HÀ\u0003¢\u0006\u0002\bmJ\u0015\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0016HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0018HÀ\u0003¢\u0006\u0002\bpJ\u0095\u0001\u0010q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001J\t\u0010r\u001a\u00020\u0012HÖ\u0001J%\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u00002\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020yH\u0001¢\u0006\u0002\bzR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010#\u001a\u0004\b'\u0010(R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010#\u001a\u0004\b*\u0010+R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010#\u001a\u0004\b-\u0010.R\u001c\u0010\n\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010#\u001a\u0004\b0\u00101R\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010#\u001a\u0004\b\f\u00103R\u001c\u0010\u000e\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010#\u001a\u0004\b5\u00106R\u001c\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010#\u001a\u0004\b\u0010\u00103R\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010#\u001a\u0004\b9\u0010:R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010#\u001a\u0004\b<\u0010=R(\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010#\u001a\u0004\b?\u0010@R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010#\u001a\u0004\bB\u0010CR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0019\u0010F\u001a\u0004\u0018\u00010\u00188F¢\u0006\f\u0012\u0004\bG\u0010#\u001a\u0004\bH\u0010CR\u0017\u0010I\u001a\u00020\u00128F¢\u0006\f\u0012\u0004\bJ\u0010#\u001a\u0004\bK\u0010:R'\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bR\u0010S\u0012\u0004\bO\u0010#\u001a\u0004\bP\u0010QR\u001c\u0010T\u001a\u00020U8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010#\u001a\u0004\bW\u0010XR\u0011\u0010[\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\\\u0010:¨\u0006}"}, d2 = {"Lim/session/model/IMSessionCard;", "", "id", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "sessionInfo", "Lim/session/model/IMSessionInfo;", "unread", "Lcom/bapis/bilibili/app/im/v1/KUnread;", "msgSummary", "Lcom/bapis/bilibili/app/im/v1/KMsgSummary;", "timestamp", "Lkotlinx/datetime/Instant;", "isPinned", "", "sequenceNumber", "", "isMuted", "chatURL", "", "operation", "Lcom/bapis/bilibili/app/im/v1/KSessionOperation;", "traceParams", "", "clientSummary", "Lim/session/service/Summary;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Lim/session/model/IMSessionInfo;Lcom/bapis/bilibili/app/im/v1/KUnread;Lcom/bapis/bilibili/app/im/v1/KMsgSummary;Lkotlinx/datetime/Instant;ZJZLjava/lang/String;Lcom/bapis/bilibili/app/im/v1/KSessionOperation;Ljava/util/Map;Lim/session/service/Summary;)V", "seen0", "", "urlWithParam", "Lcom/bilibili/lib/brouter/uri/Uri;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bapis/bilibili/app/im/v1/KSessionId;Lim/session/model/IMSessionInfo;Lcom/bapis/bilibili/app/im/v1/KUnread;Lcom/bapis/bilibili/app/im/v1/KMsgSummary;Lkotlinx/datetime/Instant;ZJZLjava/lang/String;Lcom/bapis/bilibili/app/im/v1/KSessionOperation;Ljava/util/Map;Lim/session/service/Summary;Lcom/bilibili/lib/brouter/uri/Uri;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Lcom/bapis/bilibili/app/im/v1/KSessionId;", "getSessionInfo$annotations", "getSessionInfo", "()Lim/session/model/IMSessionInfo;", "getUnread$annotations", "getUnread", "()Lcom/bapis/bilibili/app/im/v1/KUnread;", "getMsgSummary$session_debug$annotations", "getMsgSummary$session_debug", "()Lcom/bapis/bilibili/app/im/v1/KMsgSummary;", "getTimestamp$session_debug$annotations", "getTimestamp$session_debug", "()Lkotlinx/datetime/Instant;", "isPinned$annotations", "()Z", "getSequenceNumber$session_debug$annotations", "getSequenceNumber$session_debug", "()J", "isMuted$annotations", "getChatURL$annotations", "getChatURL", "()Ljava/lang/String;", "getOperation$session_debug$annotations", "getOperation$session_debug", "()Lcom/bapis/bilibili/app/im/v1/KSessionOperation;", "getTraceParams$annotations", "getTraceParams", "()Ljava/util/Map;", "getClientSummary$session_debug$annotations", "getClientSummary$session_debug", "()Lim/session/service/Summary;", "getUrlWithParam", "()Lcom/bilibili/lib/brouter/uri/Uri;", SocialConstants.PARAM_SUMMARY, "getSummary$annotations", "getSummary", "timeDescription", "getTimeDescription$annotations", "getTimeDescription", "cardOperations", "", "Lim/session/model/IMSessionCardOperation;", "getCardOperations$annotations", "getCardOperations", "()Ljava/util/List;", "cardOperations$delegate", "Lkotlin/Lazy;", "extraData", "Lim/session/model/IMSessionCardExtraData;", "getExtraData$annotations", "getExtraData", "()Lim/session/model/IMSessionCardExtraData;", "mergeFrom", "original", "logString", "getLogString", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component4$session_debug", "component5", "component5$session_debug", "component6", "component7", "component7$session_debug", "component8", "component9", "component10", "component10$session_debug", "component11", "component12", "component12$session_debug", "copy", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$session_debug", "Companion", "$serializer", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class IMSessionCard {
    private static final Comparator<IMSessionCard> COMPARATOR;
    private final Lazy cardOperations$delegate;
    private final String chatURL;
    private final Summary clientSummary;
    private final IMSessionCardExtraData extraData;
    private final KSessionId id;
    private final boolean isMuted;
    private final boolean isPinned;
    private final KMsgSummary msgSummary;
    private final KSessionOperation operation;
    private final long sequenceNumber;
    private final IMSessionInfo sessionInfo;
    private final Instant timestamp;
    private final Map<String, String> traceParams;
    private final KUnread unread;
    private final Uri urlWithParam;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.session.model.IMSessionCard$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = IMSessionCard._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.session.model.IMSessionCard$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = IMSessionCard._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.session.model.IMSessionCard$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = IMSessionCard._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    })};

    public IMSessionCard() {
        this(null, null, null, null, null, false, 0L, false, null, null, null, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMSessionCard copy$default(IMSessionCard iMSessionCard, KSessionId kSessionId, IMSessionInfo iMSessionInfo, KUnread kUnread, KMsgSummary kMsgSummary, Instant instant, boolean z, long j, boolean z2, String str, KSessionOperation kSessionOperation, Map map, Summary summary, int i2, Object obj) {
        return iMSessionCard.copy((i2 & 1) != 0 ? iMSessionCard.id : kSessionId, (i2 & 2) != 0 ? iMSessionCard.sessionInfo : iMSessionInfo, (i2 & 4) != 0 ? iMSessionCard.unread : kUnread, (i2 & 8) != 0 ? iMSessionCard.msgSummary : kMsgSummary, (i2 & 16) != 0 ? iMSessionCard.timestamp : instant, (i2 & 32) != 0 ? iMSessionCard.isPinned : z, (i2 & 64) != 0 ? iMSessionCard.sequenceNumber : j, (i2 & 128) != 0 ? iMSessionCard.isMuted : z2, (i2 & 256) != 0 ? iMSessionCard.chatURL : str, (i2 & 512) != 0 ? iMSessionCard.operation : kSessionOperation, (i2 & 1024) != 0 ? iMSessionCard.traceParams : map, (i2 & 2048) != 0 ? iMSessionCard.clientSummary : summary);
    }

    public static /* synthetic */ void getCardOperations$annotations() {
    }

    @ProtoNumber(number = 9)
    public static /* synthetic */ void getChatURL$annotations() {
    }

    @ProtoNumber(number = 100)
    public static /* synthetic */ void getClientSummary$session_debug$annotations() {
    }

    @Transient
    public static /* synthetic */ void getExtraData$annotations() {
    }

    @ProtoNumber(number = 1)
    public static /* synthetic */ void getId$annotations() {
    }

    @ProtoNumber(number = 4)
    public static /* synthetic */ void getMsgSummary$session_debug$annotations() {
    }

    @ProtoNumber(number = 10)
    public static /* synthetic */ void getOperation$session_debug$annotations() {
    }

    @ProtoNumber(number = 7)
    public static /* synthetic */ void getSequenceNumber$session_debug$annotations() {
    }

    @ProtoNumber(number = 2)
    public static /* synthetic */ void getSessionInfo$annotations() {
    }

    public static /* synthetic */ void getSummary$annotations() {
    }

    public static /* synthetic */ void getTimeDescription$annotations() {
    }

    @ProtoNumber(number = 5)
    @Serializable(with = InstantMicroSecondSerializer.class)
    public static /* synthetic */ void getTimestamp$session_debug$annotations() {
    }

    @ProtoNumber(number = 11)
    @ProtoPacked
    public static /* synthetic */ void getTraceParams$annotations() {
    }

    @ProtoNumber(number = 3)
    public static /* synthetic */ void getUnread$annotations() {
    }

    @ProtoNumber(number = 8)
    public static /* synthetic */ void isMuted$annotations() {
    }

    @ProtoNumber(number = 6)
    public static /* synthetic */ void isPinned$annotations() {
    }

    public final KSessionId component1() {
        return this.id;
    }

    public final KSessionOperation component10$session_debug() {
        return this.operation;
    }

    public final Map<String, String> component11() {
        return this.traceParams;
    }

    public final Summary component12$session_debug() {
        return this.clientSummary;
    }

    public final IMSessionInfo component2() {
        return this.sessionInfo;
    }

    public final KUnread component3() {
        return this.unread;
    }

    public final KMsgSummary component4$session_debug() {
        return this.msgSummary;
    }

    public final Instant component5$session_debug() {
        return this.timestamp;
    }

    public final boolean component6() {
        return this.isPinned;
    }

    public final long component7$session_debug() {
        return this.sequenceNumber;
    }

    public final boolean component8() {
        return this.isMuted;
    }

    public final String component9() {
        return this.chatURL;
    }

    public final IMSessionCard copy(KSessionId kSessionId, IMSessionInfo iMSessionInfo, KUnread kUnread, KMsgSummary kMsgSummary, Instant instant, boolean z, long j, boolean z2, String str, KSessionOperation kSessionOperation, Map<String, String> map, Summary summary) {
        Intrinsics.checkNotNullParameter(kSessionId, "id");
        Intrinsics.checkNotNullParameter(kUnread, "unread");
        Intrinsics.checkNotNullParameter(instant, "timestamp");
        Intrinsics.checkNotNullParameter(str, "chatURL");
        Intrinsics.checkNotNullParameter(map, "traceParams");
        return new IMSessionCard(kSessionId, iMSessionInfo, kUnread, kMsgSummary, instant, z, j, z2, str, kSessionOperation, map, summary);
    }

    public String toString() {
        KSessionId kSessionId = this.id;
        IMSessionInfo iMSessionInfo = this.sessionInfo;
        KUnread kUnread = this.unread;
        KMsgSummary kMsgSummary = this.msgSummary;
        Instant instant = this.timestamp;
        boolean z = this.isPinned;
        long j = this.sequenceNumber;
        boolean z2 = this.isMuted;
        String str = this.chatURL;
        KSessionOperation kSessionOperation = this.operation;
        Map<String, String> map = this.traceParams;
        return "IMSessionCard(id=" + kSessionId + ", sessionInfo=" + iMSessionInfo + ", unread=" + kUnread + ", msgSummary=" + kMsgSummary + ", timestamp=" + instant + ", isPinned=" + z + ", sequenceNumber=" + j + ", isMuted=" + z2 + ", chatURL=" + str + ", operation=" + kSessionOperation + ", traceParams=" + map + ", clientSummary=" + this.clientSummary + ")";
    }

    public /* synthetic */ IMSessionCard(int seen0, KSessionId id, IMSessionInfo sessionInfo, KUnread unread, KMsgSummary msgSummary, Instant timestamp, boolean isPinned, long sequenceNumber, boolean isMuted, String chatURL, KSessionOperation operation, Map traceParams, Summary clientSummary, Uri urlWithParam, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.id = new KSessionId(new KSessionId.KPrivateId(new KPrivateId(0L)));
        } else {
            this.id = id;
        }
        if ((seen0 & 2) == 0) {
            this.sessionInfo = null;
        } else {
            this.sessionInfo = sessionInfo;
        }
        if ((seen0 & 4) == 0) {
            this.unread = new KUnread((KUnreadStyle) null, 0L, (String) null, 7, (DefaultConstructorMarker) null);
        } else {
            this.unread = unread;
        }
        if ((seen0 & 8) == 0) {
            this.msgSummary = null;
        } else {
            this.msgSummary = msgSummary;
        }
        if ((seen0 & 16) == 0) {
            this.timestamp = Instant.Companion.fromEpochMilliseconds(0L);
        } else {
            this.timestamp = timestamp;
        }
        if ((seen0 & 32) == 0) {
            this.isPinned = false;
        } else {
            this.isPinned = isPinned;
        }
        if ((seen0 & 64) == 0) {
            this.sequenceNumber = 0L;
        } else {
            this.sequenceNumber = sequenceNumber;
        }
        if ((seen0 & 128) == 0) {
            this.isMuted = false;
        } else {
            this.isMuted = isMuted;
        }
        if ((seen0 & 256) == 0) {
            this.chatURL = "";
        } else {
            this.chatURL = chatURL;
        }
        if ((seen0 & 512) == 0) {
            this.operation = null;
        } else {
            this.operation = operation;
        }
        if ((seen0 & 1024) == 0) {
            this.traceParams = MapsKt.emptyMap();
        } else {
            this.traceParams = traceParams;
        }
        if ((seen0 & 2048) == 0) {
            this.clientSummary = null;
        } else {
            this.clientSummary = clientSummary;
        }
        if ((seen0 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) == 0) {
            Builder $this$_init__u24lambda_u240 = Uri.Companion.parse(this.chatURL).buildUpon();
            $this$_init__u24lambda_u240.appendQueryParameter("msg_new", this.isMuted ? "notice" : Intrinsics.areEqual(this.unread.getStyle(), KUnreadStyle.UNREAD_STYLE_DOT.INSTANCE) ? "redpoint" : this.unread.getNumberShow());
            this.urlWithParam = $this$_init__u24lambda_u240.build();
        } else {
            this.urlWithParam = urlWithParam;
        }
        this.cardOperations$delegate = LazyKt.lazy(new Function0() { // from class: im.session.model.IMSessionCard$$ExternalSyntheticLambda4
            public final Object invoke() {
                List _init_$lambda$1;
                _init_$lambda$1 = IMSessionCard._init_$lambda$1(IMSessionCard.this);
                return _init_$lambda$1;
            }
        });
        this.extraData = IMSessionCardExtraData_androidKt.IMSessionCardExtraData(this);
    }

    public IMSessionCard(KSessionId id, IMSessionInfo sessionInfo, KUnread unread, KMsgSummary msgSummary, Instant timestamp, boolean isPinned, long sequenceNumber, boolean isMuted, String chatURL, KSessionOperation operation, Map<String, String> map, Summary clientSummary) {
        String numberShow;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(unread, "unread");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(chatURL, "chatURL");
        Intrinsics.checkNotNullParameter(map, "traceParams");
        this.id = id;
        this.sessionInfo = sessionInfo;
        this.unread = unread;
        this.msgSummary = msgSummary;
        this.timestamp = timestamp;
        this.isPinned = isPinned;
        this.sequenceNumber = sequenceNumber;
        this.isMuted = isMuted;
        this.chatURL = chatURL;
        this.operation = operation;
        this.traceParams = map;
        this.clientSummary = clientSummary;
        Builder $this$urlWithParam_u24lambda_u240 = Uri.Companion.parse(this.chatURL).buildUpon();
        if (this.isMuted) {
            numberShow = "notice";
        } else if (Intrinsics.areEqual(this.unread.getStyle(), KUnreadStyle.UNREAD_STYLE_DOT.INSTANCE)) {
            numberShow = "redpoint";
        } else {
            numberShow = this.unread.getNumberShow();
        }
        $this$urlWithParam_u24lambda_u240.appendQueryParameter("msg_new", numberShow);
        this.urlWithParam = $this$urlWithParam_u24lambda_u240.build();
        this.cardOperations$delegate = LazyKt.lazy(new Function0() { // from class: im.session.model.IMSessionCard$$ExternalSyntheticLambda0
            public final Object invoke() {
                List cardOperations_delegate$lambda$0;
                cardOperations_delegate$lambda$0 = IMSessionCard.cardOperations_delegate$lambda$0(IMSessionCard.this);
                return cardOperations_delegate$lambda$0;
            }
        });
        this.extraData = IMSessionCardExtraData_androidKt.IMSessionCardExtraData(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new InstantMicroSecondSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Uri.class), new Annotation[0]);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$session_debug(IMSessionCard self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        boolean z = true;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.id, new KSessionId(new KSessionId.KPrivateId(new KPrivateId(0L))))) {
            output.encodeSerializableElement(serialDesc, 0, KSessionIdSerializer.INSTANCE, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.sessionInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, IMSessionInfo$$serializer.INSTANCE, self.sessionInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.unread, new KUnread((KUnreadStyle) null, 0L, (String) null, 7, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 2, KUnread$.serializer.INSTANCE, self.unread);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.msgSummary != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, KMsgSummary$.serializer.INSTANCE, self.msgSummary);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.timestamp, Instant.Companion.fromEpochMilliseconds(0L))) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.timestamp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isPinned) {
            output.encodeBooleanElement(serialDesc, 5, self.isPinned);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.sequenceNumber != 0) {
            output.encodeLongElement(serialDesc, 6, self.sequenceNumber);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.isMuted) {
            output.encodeBooleanElement(serialDesc, 7, self.isMuted);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.chatURL, "")) {
            output.encodeStringElement(serialDesc, 8, self.chatURL);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.operation != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, KSessionOperation$.serializer.INSTANCE, self.operation);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.traceParams, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 10, (SerializationStrategy) lazyArr[10].getValue(), self.traceParams);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.clientSummary != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, Summary$$serializer.INSTANCE, self.clientSummary);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 12)) {
            Uri uri = self.urlWithParam;
            Builder $this$write_Self_u24lambda_u240 = Uri.Companion.parse(self.chatURL).buildUpon();
            $this$write_Self_u24lambda_u240.appendQueryParameter("msg_new", self.isMuted ? "notice" : Intrinsics.areEqual(self.unread.getStyle(), KUnreadStyle.UNREAD_STYLE_DOT.INSTANCE) ? "redpoint" : self.unread.getNumberShow());
            if (Intrinsics.areEqual(uri, $this$write_Self_u24lambda_u240.build())) {
                z = false;
            }
        }
        if (z) {
            output.encodeSerializableElement(serialDesc, 12, (SerializationStrategy) lazyArr[12].getValue(), self.urlWithParam);
        }
    }

    public /* synthetic */ IMSessionCard(KSessionId kSessionId, IMSessionInfo iMSessionInfo, KUnread kUnread, KMsgSummary kMsgSummary, Instant instant, boolean z, long j, boolean z2, String str, KSessionOperation kSessionOperation, Map map, Summary summary, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new KSessionId(new KSessionId.KPrivateId(new KPrivateId(0L))) : kSessionId, (i2 & 2) != 0 ? null : iMSessionInfo, (i2 & 4) != 0 ? new KUnread((KUnreadStyle) null, 0L, (String) null, 7, (DefaultConstructorMarker) null) : kUnread, (i2 & 8) != 0 ? null : kMsgSummary, (i2 & 16) != 0 ? Instant.Companion.fromEpochMilliseconds(0L) : instant, (i2 & 32) != 0 ? false : z, (i2 & 64) == 0 ? j : 0L, (i2 & 128) == 0 ? z2 : false, (i2 & 256) != 0 ? "" : str, (i2 & 512) != 0 ? null : kSessionOperation, (i2 & 1024) != 0 ? MapsKt.emptyMap() : map, (i2 & 2048) == 0 ? summary : null);
    }

    public final KSessionId getId() {
        return this.id;
    }

    public final IMSessionInfo getSessionInfo() {
        return this.sessionInfo;
    }

    public final KUnread getUnread() {
        return this.unread;
    }

    public final KMsgSummary getMsgSummary$session_debug() {
        return this.msgSummary;
    }

    public final Instant getTimestamp$session_debug() {
        return this.timestamp;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final long getSequenceNumber$session_debug() {
        return this.sequenceNumber;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final String getChatURL() {
        return this.chatURL;
    }

    public final KSessionOperation getOperation$session_debug() {
        return this.operation;
    }

    public final Map<String, String> getTraceParams() {
        return this.traceParams;
    }

    public final Summary getClientSummary$session_debug() {
        return this.clientSummary;
    }

    public final Uri getUrlWithParam() {
        return this.urlWithParam;
    }

    public final Summary getSummary() {
        KMsgSummary msgSummary = this.msgSummary;
        Summary serverSummary = msgSummary != null ? new Summary(SummaryPrefix.Companion.from(msgSummary), msgSummary.getRawMsg()) : null;
        if (this.clientSummary != null && serverSummary != null) {
            return IMMessageSummaryServiceKt.or(this.clientSummary, serverSummary);
        }
        Summary summary = this.clientSummary;
        return summary == null ? serverSummary : summary;
    }

    public final String getTimeDescription() {
        String formatRelativeDateTime;
        Long valueOf = Long.valueOf(this.timestamp.toEpochMilliseconds());
        long it = valueOf.longValue();
        if (!(it > 0)) {
            valueOf = null;
        }
        return (valueOf == null || (formatRelativeDateTime = DateTimeFormatKt.formatRelativeDateTime(valueOf.longValue())) == null) ? "" : formatRelativeDateTime;
    }

    public final List<IMSessionCardOperation> getCardOperations() {
        return (List) this.cardOperations$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _init_$lambda$1(IMSessionCard this$0) {
        List access$toOperations;
        KSessionOperation kSessionOperation = this$0.operation;
        return (kSessionOperation == null || (access$toOperations = IMSessionCardKt.access$toOperations(kSessionOperation, this$0)) == null) ? CollectionsKt.emptyList() : access$toOperations;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List cardOperations_delegate$lambda$0(IMSessionCard this$0) {
        List access$toOperations;
        KSessionOperation kSessionOperation = this$0.operation;
        return (kSessionOperation == null || (access$toOperations = IMSessionCardKt.access$toOperations(kSessionOperation, this$0)) == null) ? CollectionsKt.emptyList() : access$toOperations;
    }

    public final IMSessionCardExtraData getExtraData() {
        return this.extraData;
    }

    /* compiled from: IMSessionCard.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lim/session/model/IMSessionCard$Companion;", "", "<init>", "()V", "COMPARATOR", "Ljava/util/Comparator;", "Lim/session/model/IMSessionCard;", "Lkotlin/Comparator;", "getCOMPARATOR", "()Ljava/util/Comparator;", "serializer", "Lkotlinx/serialization/KSerializer;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IMSessionCard> serializer() {
            return IMSessionCard$$serializer.INSTANCE;
        }

        public final Comparator<IMSessionCard> getCOMPARATOR() {
            return IMSessionCard.COMPARATOR;
        }
    }

    static {
        final Comparator comparator = new Comparator() { // from class: im.session.model.IMSessionCard$special$$inlined$compareByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                IMSessionCard p0 = (IMSessionCard) t2;
                IMSessionCard p02 = (IMSessionCard) t;
                return ComparisonsKt.compareValues(Boolean.valueOf(p0.isPinned()), Boolean.valueOf(p02.isPinned()));
            }
        };
        COMPARATOR = new Comparator() { // from class: im.session.model.IMSessionCard$special$$inlined$thenByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = comparator.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                IMSessionCard p0 = (IMSessionCard) t2;
                IMSessionCard p02 = (IMSessionCard) t;
                return ComparisonsKt.compareValues(Long.valueOf(p0.getSequenceNumber$session_debug()), Long.valueOf(p02.getSequenceNumber$session_debug()));
            }
        };
    }

    public final IMSessionCard mergeFrom(IMSessionCard original) {
        Intrinsics.checkNotNullParameter(original, "original");
        if (Intrinsics.areEqual(original.id, this.id)) {
            return copy$default(this, null, null, null, null, null, false, 0L, false, null, null, null, original.clientSummary, 2047, null);
        }
        return this;
    }

    public final String getLogString() {
        return "IMSessionCard(id = " + IMSessionCardKt.getStringId(this.id) + ")";
    }

    public boolean equals(Object other) {
        return super.equals(other);
    }

    public int hashCode() {
        return super.hashCode();
    }
}