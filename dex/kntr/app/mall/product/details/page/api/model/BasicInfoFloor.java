package kntr.app.mall.product.details.page.api.model;

import java.util.ArrayList;
import java.util.List;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$$serializer;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.config.FlowControlConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: BasicInfoFloor.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b[\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 §\u00012\u00020\u0001:\u0016\u009d\u0001\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001¦\u0001§\u0001B\u009f\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0007\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0007\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b2\u00103Bõ\u0002\b\u0010\u0012\u0006\u00104\u001a\u00020\u001e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u0012\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0007\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0007\u0012\b\u0010*\u001a\u0004\u0018\u00010+\u0012\b\u0010,\u001a\u0004\u0018\u00010-\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010/\u001a\u0004\u0018\u00010\u000f\u0012\b\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010\u001e\u0012\b\u00105\u001a\u0004\u0018\u000106¢\u0006\u0004\b2\u00107J\u000f\u0010i\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\bjJ\r\u0010k\u001a\u00020\u000fH\u0000¢\u0006\u0002\blJ\u000f\u0010m\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\bnJ\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010s\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010v\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010CJ\u000b\u0010x\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0011\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010NJ\u0010\u0010}\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010NJ\u0010\u0010~\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010NJ\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\u0012\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010CJ\u0012\u0010\u0087\u0001\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010+HÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010CJ\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010VJ¨\u0003\u0010\u008e\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0003\u0010\u008f\u0001J\u0016\u0010\u0090\u0001\u001a\u00020\u000f2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001HÖ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u001eHÖ\u0001J\n\u0010\u0094\u0001\u001a\u00020\u0003HÖ\u0001J-\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\u00002\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0001¢\u0006\u0003\b\u009c\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00109R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00109R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u00109R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010=R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010CR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u00109R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bL\u0010=R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010O\u001a\u0004\bM\u0010NR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010O\u001a\u0004\bP\u0010NR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010O\u001a\u0004\bQ\u0010NR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u00109R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010W\u001a\u0004\bU\u0010VR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b^\u0010=R\u0015\u0010'\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010D\u001a\u0004\b_\u0010CR\u0019\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b`\u0010=R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0013\u0010.\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\be\u0010KR\u0015\u0010/\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010D\u001a\u0004\bf\u0010CR\u0013\u00100\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bg\u00109R\u0015\u00101\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010W\u001a\u0004\bh\u0010V¨\u0006¨\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "atmosphereImgList", "", "Lkntr/app/mall/product/details/page/api/model/ImageColorModel;", "benefitInfos", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BenefitInfo;", "brief", "commentBgUrl", "commitmentTags", "couponReceiveAble", "", "crowdfundingBulletScreenVO", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen;", "extBrief", "headAvDTO", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;", "imageList", "shopId", "", "oneShopId", "itemsId", "itemsBenefitsInfo", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo;", "itemsName", "itemsStatus", "", "liveInfo", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$LiveInfo;", "mainImgScale", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$MainImageScale;", "newUpSayVO", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel;", "promoInfoVOS", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$PromotionInfoVO;", "reserveAble", "salePoint", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$SalePoint;", "serviceRightTag", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "titlePrefix", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "verticalHeadAvDTO", "newCustomer", "guideIndexUrl", "retainDaysFreq", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo;Ljava/lang/String;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$LiveInfo;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$MainImageScale;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/LabelObject;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo;Ljava/lang/String;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$LiveInfo;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$MainImageScale;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/LabelObject;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getAtmosphereImgList", "()Ljava/util/List;", "getBenefitInfos", "getBrief", "getCommentBgUrl", "getCommitmentTags", "getCouponReceiveAble", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCrowdfundingBulletScreenVO$annotations", "()V", "getCrowdfundingBulletScreenVO", "()Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen;", "getExtBrief", "getHeadAvDTO", "()Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;", "getImageList", "getShopId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOneShopId", "getItemsId", "getItemsBenefitsInfo", "()Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo;", "getItemsName", "getItemsStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLiveInfo", "()Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$LiveInfo;", "getMainImgScale", "()Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$MainImageScale;", "getNewUpSayVO", "()Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel;", "getPromoInfoVOS", "getReserveAble", "getSalePoint", "getServiceRightTag", "()Lkntr/app/mall/product/details/page/api/model/LabelObject;", "getTitlePrefix", "()Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "getVerticalHeadAvDTO", "getNewCustomer", "getGuideIndexUrl", "getRetainDaysFreq", "generateBenefitTextString", "generateBenefitTextString$product_details_page_debug", "hasVideo", "hasVideo$product_details_page_debug", "getVideoUrl", "getVideoUrl$product_details_page_debug", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo;Ljava/lang/String;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$LiveInfo;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$MainImageScale;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/LabelObject;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "BenefitInfo", "MainImageScale", "BulletScreen", "HeadAvModel", "LiveInfo", "ItemsBenefitsInfo", "NewUpSayModel", "PromotionInfoVO", "SalePoint", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class BasicInfoFloor implements FloorModel {
    private final List<ImageColorModel> atmosphereImgList;
    private final List<BenefitInfo> benefitInfos;
    private final String bgImgUrl;
    private final String brief;
    private final String commentBgUrl;
    private final List<String> commitmentTags;
    private final Boolean couponReceiveAble;
    private final BulletScreen crowdfundingBulletScreenVO;
    private final String extBrief;
    private final String floorIcon;
    private final String floorKey;
    private final String guideIndexUrl;
    private final HeadAvModel headAvDTO;
    private final List<String> imageList;
    private final ItemsBenefitsInfo itemsBenefitsInfo;
    private final Long itemsId;
    private final String itemsName;
    private final Integer itemsStatus;
    private final LiveInfo liveInfo;
    private final MainImageScale mainImgScale;
    private final Boolean newCustomer;
    private final NewUpSayModel newUpSayVO;
    private final Long oneShopId;
    private final List<PromotionInfoVO> promoInfoVOS;
    private final Boolean reserveAble;
    private final Integer retainDaysFreq;
    private final List<SalePoint> salePoint;
    private final LabelObject serviceRightTag;
    private final Long shopId;
    private final TextColorModel titlePrefix;
    private final HeadAvModel verticalHeadAvDTO;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = BasicInfoFloor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = BasicInfoFloor._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = BasicInfoFloor._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = BasicInfoFloor._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$$ExternalSyntheticLambda4
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$3;
            _childSerializers$_anonymous_$3 = BasicInfoFloor._childSerializers$_anonymous_$3();
            return _childSerializers$_anonymous_$3;
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$$ExternalSyntheticLambda5
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$4;
            _childSerializers$_anonymous_$4 = BasicInfoFloor._childSerializers$_anonymous_$4();
            return _childSerializers$_anonymous_$4;
        }
    }), null, null, null, null, null, null};

    public BasicInfoFloor() {
        this((String) null, (String) null, (String) null, (List) null, (List) null, (String) null, (String) null, (List) null, (Boolean) null, (BulletScreen) null, (String) null, (HeadAvModel) null, (List) null, (Long) null, (Long) null, (Long) null, (ItemsBenefitsInfo) null, (String) null, (Integer) null, (LiveInfo) null, (MainImageScale) null, (NewUpSayModel) null, (List) null, (Boolean) null, (List) null, (LabelObject) null, (TextColorModel) null, (HeadAvModel) null, (Boolean) null, (String) null, (Integer) null, (int) FlowControlConfig.RETRY_MAX_TIMES, (DefaultConstructorMarker) null);
    }

    @SerialName("crowdFundingBulletScreenVO")
    public static /* synthetic */ void getCrowdfundingBulletScreenVO$annotations() {
    }

    public final String component1() {
        return this.floorKey;
    }

    public final BulletScreen component10() {
        return this.crowdfundingBulletScreenVO;
    }

    public final String component11() {
        return this.extBrief;
    }

    public final HeadAvModel component12() {
        return this.headAvDTO;
    }

    public final List<String> component13() {
        return this.imageList;
    }

    public final Long component14() {
        return this.shopId;
    }

    public final Long component15() {
        return this.oneShopId;
    }

    public final Long component16() {
        return this.itemsId;
    }

    public final ItemsBenefitsInfo component17() {
        return this.itemsBenefitsInfo;
    }

    public final String component18() {
        return this.itemsName;
    }

    public final Integer component19() {
        return this.itemsStatus;
    }

    public final String component2() {
        return this.floorIcon;
    }

    public final LiveInfo component20() {
        return this.liveInfo;
    }

    public final MainImageScale component21() {
        return this.mainImgScale;
    }

    public final NewUpSayModel component22() {
        return this.newUpSayVO;
    }

    public final List<PromotionInfoVO> component23() {
        return this.promoInfoVOS;
    }

    public final Boolean component24() {
        return this.reserveAble;
    }

    public final List<SalePoint> component25() {
        return this.salePoint;
    }

    public final LabelObject component26() {
        return this.serviceRightTag;
    }

    public final TextColorModel component27() {
        return this.titlePrefix;
    }

    public final HeadAvModel component28() {
        return this.verticalHeadAvDTO;
    }

    public final Boolean component29() {
        return this.newCustomer;
    }

    public final String component3() {
        return this.bgImgUrl;
    }

    public final String component30() {
        return this.guideIndexUrl;
    }

    public final Integer component31() {
        return this.retainDaysFreq;
    }

    public final List<ImageColorModel> component4() {
        return this.atmosphereImgList;
    }

    public final List<BenefitInfo> component5() {
        return this.benefitInfos;
    }

    public final String component6() {
        return this.brief;
    }

    public final String component7() {
        return this.commentBgUrl;
    }

    public final List<String> component8() {
        return this.commitmentTags;
    }

    public final Boolean component9() {
        return this.couponReceiveAble;
    }

    public final BasicInfoFloor copy(String str, String str2, String str3, List<ImageColorModel> list, List<BenefitInfo> list2, String str4, String str5, List<String> list3, Boolean bool, BulletScreen bulletScreen, String str6, HeadAvModel headAvModel, List<String> list4, Long l, Long l2, Long l3, ItemsBenefitsInfo itemsBenefitsInfo, String str7, Integer num, LiveInfo liveInfo, MainImageScale mainImageScale, NewUpSayModel newUpSayModel, List<PromotionInfoVO> list5, Boolean bool2, List<SalePoint> list6, LabelObject labelObject, TextColorModel textColorModel, HeadAvModel headAvModel2, Boolean bool3, String str8, Integer num2) {
        return new BasicInfoFloor(str, str2, str3, list, list2, str4, str5, list3, bool, bulletScreen, str6, headAvModel, list4, l, l2, l3, itemsBenefitsInfo, str7, num, liveInfo, mainImageScale, newUpSayModel, list5, bool2, list6, labelObject, textColorModel, headAvModel2, bool3, str8, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BasicInfoFloor) {
            BasicInfoFloor basicInfoFloor = (BasicInfoFloor) obj;
            return Intrinsics.areEqual(this.floorKey, basicInfoFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, basicInfoFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, basicInfoFloor.bgImgUrl) && Intrinsics.areEqual(this.atmosphereImgList, basicInfoFloor.atmosphereImgList) && Intrinsics.areEqual(this.benefitInfos, basicInfoFloor.benefitInfos) && Intrinsics.areEqual(this.brief, basicInfoFloor.brief) && Intrinsics.areEqual(this.commentBgUrl, basicInfoFloor.commentBgUrl) && Intrinsics.areEqual(this.commitmentTags, basicInfoFloor.commitmentTags) && Intrinsics.areEqual(this.couponReceiveAble, basicInfoFloor.couponReceiveAble) && Intrinsics.areEqual(this.crowdfundingBulletScreenVO, basicInfoFloor.crowdfundingBulletScreenVO) && Intrinsics.areEqual(this.extBrief, basicInfoFloor.extBrief) && Intrinsics.areEqual(this.headAvDTO, basicInfoFloor.headAvDTO) && Intrinsics.areEqual(this.imageList, basicInfoFloor.imageList) && Intrinsics.areEqual(this.shopId, basicInfoFloor.shopId) && Intrinsics.areEqual(this.oneShopId, basicInfoFloor.oneShopId) && Intrinsics.areEqual(this.itemsId, basicInfoFloor.itemsId) && Intrinsics.areEqual(this.itemsBenefitsInfo, basicInfoFloor.itemsBenefitsInfo) && Intrinsics.areEqual(this.itemsName, basicInfoFloor.itemsName) && Intrinsics.areEqual(this.itemsStatus, basicInfoFloor.itemsStatus) && Intrinsics.areEqual(this.liveInfo, basicInfoFloor.liveInfo) && Intrinsics.areEqual(this.mainImgScale, basicInfoFloor.mainImgScale) && Intrinsics.areEqual(this.newUpSayVO, basicInfoFloor.newUpSayVO) && Intrinsics.areEqual(this.promoInfoVOS, basicInfoFloor.promoInfoVOS) && Intrinsics.areEqual(this.reserveAble, basicInfoFloor.reserveAble) && Intrinsics.areEqual(this.salePoint, basicInfoFloor.salePoint) && Intrinsics.areEqual(this.serviceRightTag, basicInfoFloor.serviceRightTag) && Intrinsics.areEqual(this.titlePrefix, basicInfoFloor.titlePrefix) && Intrinsics.areEqual(this.verticalHeadAvDTO, basicInfoFloor.verticalHeadAvDTO) && Intrinsics.areEqual(this.newCustomer, basicInfoFloor.newCustomer) && Intrinsics.areEqual(this.guideIndexUrl, basicInfoFloor.guideIndexUrl) && Intrinsics.areEqual(this.retainDaysFreq, basicInfoFloor.retainDaysFreq);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.atmosphereImgList == null ? 0 : this.atmosphereImgList.hashCode())) * 31) + (this.benefitInfos == null ? 0 : this.benefitInfos.hashCode())) * 31) + (this.brief == null ? 0 : this.brief.hashCode())) * 31) + (this.commentBgUrl == null ? 0 : this.commentBgUrl.hashCode())) * 31) + (this.commitmentTags == null ? 0 : this.commitmentTags.hashCode())) * 31) + (this.couponReceiveAble == null ? 0 : this.couponReceiveAble.hashCode())) * 31) + (this.crowdfundingBulletScreenVO == null ? 0 : this.crowdfundingBulletScreenVO.hashCode())) * 31) + (this.extBrief == null ? 0 : this.extBrief.hashCode())) * 31) + (this.headAvDTO == null ? 0 : this.headAvDTO.hashCode())) * 31) + (this.imageList == null ? 0 : this.imageList.hashCode())) * 31) + (this.shopId == null ? 0 : this.shopId.hashCode())) * 31) + (this.oneShopId == null ? 0 : this.oneShopId.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.itemsBenefitsInfo == null ? 0 : this.itemsBenefitsInfo.hashCode())) * 31) + (this.itemsName == null ? 0 : this.itemsName.hashCode())) * 31) + (this.itemsStatus == null ? 0 : this.itemsStatus.hashCode())) * 31) + (this.liveInfo == null ? 0 : this.liveInfo.hashCode())) * 31) + (this.mainImgScale == null ? 0 : this.mainImgScale.hashCode())) * 31) + (this.newUpSayVO == null ? 0 : this.newUpSayVO.hashCode())) * 31) + (this.promoInfoVOS == null ? 0 : this.promoInfoVOS.hashCode())) * 31) + (this.reserveAble == null ? 0 : this.reserveAble.hashCode())) * 31) + (this.salePoint == null ? 0 : this.salePoint.hashCode())) * 31) + (this.serviceRightTag == null ? 0 : this.serviceRightTag.hashCode())) * 31) + (this.titlePrefix == null ? 0 : this.titlePrefix.hashCode())) * 31) + (this.verticalHeadAvDTO == null ? 0 : this.verticalHeadAvDTO.hashCode())) * 31) + (this.newCustomer == null ? 0 : this.newCustomer.hashCode())) * 31) + (this.guideIndexUrl == null ? 0 : this.guideIndexUrl.hashCode())) * 31) + (this.retainDaysFreq != null ? this.retainDaysFreq.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        List<ImageColorModel> list = this.atmosphereImgList;
        List<BenefitInfo> list2 = this.benefitInfos;
        String str4 = this.brief;
        String str5 = this.commentBgUrl;
        List<String> list3 = this.commitmentTags;
        Boolean bool = this.couponReceiveAble;
        BulletScreen bulletScreen = this.crowdfundingBulletScreenVO;
        String str6 = this.extBrief;
        HeadAvModel headAvModel = this.headAvDTO;
        List<String> list4 = this.imageList;
        Long l = this.shopId;
        Long l2 = this.oneShopId;
        Long l3 = this.itemsId;
        ItemsBenefitsInfo itemsBenefitsInfo = this.itemsBenefitsInfo;
        String str7 = this.itemsName;
        Integer num = this.itemsStatus;
        LiveInfo liveInfo = this.liveInfo;
        MainImageScale mainImageScale = this.mainImgScale;
        NewUpSayModel newUpSayModel = this.newUpSayVO;
        List<PromotionInfoVO> list5 = this.promoInfoVOS;
        Boolean bool2 = this.reserveAble;
        List<SalePoint> list6 = this.salePoint;
        LabelObject labelObject = this.serviceRightTag;
        TextColorModel textColorModel = this.titlePrefix;
        HeadAvModel headAvModel2 = this.verticalHeadAvDTO;
        Boolean bool3 = this.newCustomer;
        String str8 = this.guideIndexUrl;
        return "BasicInfoFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", atmosphereImgList=" + list + ", benefitInfos=" + list2 + ", brief=" + str4 + ", commentBgUrl=" + str5 + ", commitmentTags=" + list3 + ", couponReceiveAble=" + bool + ", crowdfundingBulletScreenVO=" + bulletScreen + ", extBrief=" + str6 + ", headAvDTO=" + headAvModel + ", imageList=" + list4 + ", shopId=" + l + ", oneShopId=" + l2 + ", itemsId=" + l3 + ", itemsBenefitsInfo=" + itemsBenefitsInfo + ", itemsName=" + str7 + ", itemsStatus=" + num + ", liveInfo=" + liveInfo + ", mainImgScale=" + mainImageScale + ", newUpSayVO=" + newUpSayModel + ", promoInfoVOS=" + list5 + ", reserveAble=" + bool2 + ", salePoint=" + list6 + ", serviceRightTag=" + labelObject + ", titlePrefix=" + textColorModel + ", verticalHeadAvDTO=" + headAvModel2 + ", newCustomer=" + bool3 + ", guideIndexUrl=" + str8 + ", retainDaysFreq=" + this.retainDaysFreq + ")";
    }

    /* compiled from: BasicInfoFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BasicInfoFloor> serializer() {
            return BasicInfoFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ BasicInfoFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, List atmosphereImgList, List benefitInfos, String brief, String commentBgUrl, List commitmentTags, Boolean couponReceiveAble, BulletScreen crowdfundingBulletScreenVO, String extBrief, HeadAvModel headAvDTO, List imageList, Long shopId, Long oneShopId, Long itemsId, ItemsBenefitsInfo itemsBenefitsInfo, String itemsName, Integer itemsStatus, LiveInfo liveInfo, MainImageScale mainImgScale, NewUpSayModel newUpSayVO, List promoInfoVOS, Boolean reserveAble, List salePoint, LabelObject serviceRightTag, TextColorModel titlePrefix, HeadAvModel verticalHeadAvDTO, Boolean newCustomer, String guideIndexUrl, Integer retainDaysFreq, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.floorKey = null;
        } else {
            this.floorKey = floorKey;
        }
        if ((seen0 & 2) == 0) {
            this.floorIcon = null;
        } else {
            this.floorIcon = floorIcon;
        }
        if ((seen0 & 4) == 0) {
            this.bgImgUrl = null;
        } else {
            this.bgImgUrl = bgImgUrl;
        }
        if ((seen0 & 8) == 0) {
            this.atmosphereImgList = null;
        } else {
            this.atmosphereImgList = atmosphereImgList;
        }
        if ((seen0 & 16) == 0) {
            this.benefitInfos = null;
        } else {
            this.benefitInfos = benefitInfos;
        }
        if ((seen0 & 32) == 0) {
            this.brief = null;
        } else {
            this.brief = brief;
        }
        if ((seen0 & 64) == 0) {
            this.commentBgUrl = null;
        } else {
            this.commentBgUrl = commentBgUrl;
        }
        if ((seen0 & 128) == 0) {
            this.commitmentTags = null;
        } else {
            this.commitmentTags = commitmentTags;
        }
        if ((seen0 & 256) == 0) {
            this.couponReceiveAble = null;
        } else {
            this.couponReceiveAble = couponReceiveAble;
        }
        if ((seen0 & 512) == 0) {
            this.crowdfundingBulletScreenVO = null;
        } else {
            this.crowdfundingBulletScreenVO = crowdfundingBulletScreenVO;
        }
        if ((seen0 & 1024) == 0) {
            this.extBrief = null;
        } else {
            this.extBrief = extBrief;
        }
        if ((seen0 & 2048) == 0) {
            this.headAvDTO = null;
        } else {
            this.headAvDTO = headAvDTO;
        }
        if ((seen0 & 4096) == 0) {
            this.imageList = null;
        } else {
            this.imageList = imageList;
        }
        if ((seen0 & 8192) == 0) {
            this.shopId = null;
        } else {
            this.shopId = shopId;
        }
        if ((seen0 & 16384) == 0) {
            this.oneShopId = null;
        } else {
            this.oneShopId = oneShopId;
        }
        if ((seen0 & 32768) == 0) {
            this.itemsId = null;
        } else {
            this.itemsId = itemsId;
        }
        if ((seen0 & 65536) == 0) {
            this.itemsBenefitsInfo = null;
        } else {
            this.itemsBenefitsInfo = itemsBenefitsInfo;
        }
        if ((seen0 & 131072) == 0) {
            this.itemsName = null;
        } else {
            this.itemsName = itemsName;
        }
        if ((seen0 & 262144) == 0) {
            this.itemsStatus = null;
        } else {
            this.itemsStatus = itemsStatus;
        }
        if ((seen0 & 524288) == 0) {
            this.liveInfo = null;
        } else {
            this.liveInfo = liveInfo;
        }
        if ((seen0 & 1048576) == 0) {
            this.mainImgScale = null;
        } else {
            this.mainImgScale = mainImgScale;
        }
        if ((seen0 & 2097152) == 0) {
            this.newUpSayVO = null;
        } else {
            this.newUpSayVO = newUpSayVO;
        }
        if ((seen0 & 4194304) == 0) {
            this.promoInfoVOS = null;
        } else {
            this.promoInfoVOS = promoInfoVOS;
        }
        if ((seen0 & 8388608) == 0) {
            this.reserveAble = null;
        } else {
            this.reserveAble = reserveAble;
        }
        if ((seen0 & 16777216) == 0) {
            this.salePoint = null;
        } else {
            this.salePoint = salePoint;
        }
        if ((seen0 & 33554432) == 0) {
            this.serviceRightTag = null;
        } else {
            this.serviceRightTag = serviceRightTag;
        }
        if ((seen0 & 67108864) == 0) {
            this.titlePrefix = null;
        } else {
            this.titlePrefix = titlePrefix;
        }
        if ((seen0 & 134217728) == 0) {
            this.verticalHeadAvDTO = null;
        } else {
            this.verticalHeadAvDTO = verticalHeadAvDTO;
        }
        if ((seen0 & 268435456) == 0) {
            this.newCustomer = null;
        } else {
            this.newCustomer = newCustomer;
        }
        if ((seen0 & 536870912) == 0) {
            this.guideIndexUrl = null;
        } else {
            this.guideIndexUrl = guideIndexUrl;
        }
        if ((seen0 & 1073741824) == 0) {
            this.retainDaysFreq = null;
        } else {
            this.retainDaysFreq = retainDaysFreq;
        }
    }

    public BasicInfoFloor(String floorKey, String floorIcon, String bgImgUrl, List<ImageColorModel> list, List<BenefitInfo> list2, String brief, String commentBgUrl, List<String> list3, Boolean couponReceiveAble, BulletScreen crowdfundingBulletScreenVO, String extBrief, HeadAvModel headAvDTO, List<String> list4, Long shopId, Long oneShopId, Long itemsId, ItemsBenefitsInfo itemsBenefitsInfo, String itemsName, Integer itemsStatus, LiveInfo liveInfo, MainImageScale mainImgScale, NewUpSayModel newUpSayVO, List<PromotionInfoVO> list5, Boolean reserveAble, List<SalePoint> list6, LabelObject serviceRightTag, TextColorModel titlePrefix, HeadAvModel verticalHeadAvDTO, Boolean newCustomer, String guideIndexUrl, Integer retainDaysFreq) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.atmosphereImgList = list;
        this.benefitInfos = list2;
        this.brief = brief;
        this.commentBgUrl = commentBgUrl;
        this.commitmentTags = list3;
        this.couponReceiveAble = couponReceiveAble;
        this.crowdfundingBulletScreenVO = crowdfundingBulletScreenVO;
        this.extBrief = extBrief;
        this.headAvDTO = headAvDTO;
        this.imageList = list4;
        this.shopId = shopId;
        this.oneShopId = oneShopId;
        this.itemsId = itemsId;
        this.itemsBenefitsInfo = itemsBenefitsInfo;
        this.itemsName = itemsName;
        this.itemsStatus = itemsStatus;
        this.liveInfo = liveInfo;
        this.mainImgScale = mainImgScale;
        this.newUpSayVO = newUpSayVO;
        this.promoInfoVOS = list5;
        this.reserveAble = reserveAble;
        this.salePoint = list6;
        this.serviceRightTag = serviceRightTag;
        this.titlePrefix = titlePrefix;
        this.verticalHeadAvDTO = verticalHeadAvDTO;
        this.newCustomer = newCustomer;
        this.guideIndexUrl = guideIndexUrl;
        this.retainDaysFreq = retainDaysFreq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ImageColorModel$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(BasicInfoFloor$BenefitInfo$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new ArrayListSerializer(BasicInfoFloor$PromotionInfoVO$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new ArrayListSerializer(BasicInfoFloor$SalePoint$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(BasicInfoFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.atmosphereImgList != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.atmosphereImgList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.benefitInfos != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.benefitInfos);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.brief != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.brief);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.commentBgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.commentBgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.commitmentTags != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.commitmentTags);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.couponReceiveAble != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.couponReceiveAble);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.crowdfundingBulletScreenVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, BasicInfoFloor$BulletScreen$$serializer.INSTANCE, self.crowdfundingBulletScreenVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.extBrief != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.extBrief);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.headAvDTO != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, BasicInfoFloor$HeadAvModel$$serializer.INSTANCE, self.headAvDTO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.imageList != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, lazyArr[12].getValue(), self.imageList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.shopId != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, LongSerializer.INSTANCE, self.shopId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.oneShopId != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, LongSerializer.INSTANCE, self.oneShopId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.itemsId != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, LongSerializer.INSTANCE, self.itemsId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.itemsBenefitsInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, BasicInfoFloor$ItemsBenefitsInfo$$serializer.INSTANCE, self.itemsBenefitsInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.itemsName != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.itemsName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.itemsStatus != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, IntSerializer.INSTANCE, self.itemsStatus);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.liveInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, BasicInfoFloor$LiveInfo$$serializer.INSTANCE, self.liveInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.mainImgScale != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, BasicInfoFloor$MainImageScale$$serializer.INSTANCE, self.mainImgScale);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.newUpSayVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, BasicInfoFloor$NewUpSayModel$$serializer.INSTANCE, self.newUpSayVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.promoInfoVOS != null) {
            output.encodeNullableSerializableElement(serialDesc, 22, lazyArr[22].getValue(), self.promoInfoVOS);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.reserveAble != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, BooleanSerializer.INSTANCE, self.reserveAble);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.salePoint != null) {
            output.encodeNullableSerializableElement(serialDesc, 24, lazyArr[24].getValue(), self.salePoint);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || self.serviceRightTag != null) {
            output.encodeNullableSerializableElement(serialDesc, 25, LabelObject$$serializer.INSTANCE, self.serviceRightTag);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.titlePrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 26, TextColorModel$$serializer.INSTANCE, self.titlePrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.verticalHeadAvDTO != null) {
            output.encodeNullableSerializableElement(serialDesc, 27, BasicInfoFloor$HeadAvModel$$serializer.INSTANCE, self.verticalHeadAvDTO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || self.newCustomer != null) {
            output.encodeNullableSerializableElement(serialDesc, 28, BooleanSerializer.INSTANCE, self.newCustomer);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.guideIndexUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 29, StringSerializer.INSTANCE, self.guideIndexUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.retainDaysFreq != null) {
            output.encodeNullableSerializableElement(serialDesc, 30, IntSerializer.INSTANCE, self.retainDaysFreq);
        }
    }

    public /* synthetic */ BasicInfoFloor(String str, String str2, String str3, List list, List list2, String str4, String str5, List list3, Boolean bool, BulletScreen bulletScreen, String str6, HeadAvModel headAvModel, List list4, Long l, Long l2, Long l3, ItemsBenefitsInfo itemsBenefitsInfo, String str7, Integer num, LiveInfo liveInfo, MainImageScale mainImageScale, NewUpSayModel newUpSayModel, List list5, Boolean bool2, List list6, LabelObject labelObject, TextColorModel textColorModel, HeadAvModel headAvModel2, Boolean bool3, String str8, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : list3, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? null : bulletScreen, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : headAvModel, (i & 4096) != 0 ? null : list4, (i & 8192) != 0 ? null : l, (i & 16384) != 0 ? null : l2, (i & 32768) != 0 ? null : l3, (i & 65536) != 0 ? null : itemsBenefitsInfo, (i & 131072) != 0 ? null : str7, (i & 262144) != 0 ? null : num, (i & 524288) != 0 ? null : liveInfo, (i & 1048576) != 0 ? null : mainImageScale, (i & 2097152) != 0 ? null : newUpSayModel, (i & 4194304) != 0 ? null : list5, (i & 8388608) != 0 ? null : bool2, (i & 16777216) != 0 ? null : list6, (i & 33554432) != 0 ? null : labelObject, (i & 67108864) != 0 ? null : textColorModel, (i & 134217728) != 0 ? null : headAvModel2, (i & 268435456) != 0 ? null : bool3, (i & 536870912) != 0 ? null : str8, (i & 1073741824) != 0 ? null : num2);
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorKey() {
        return this.floorKey;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorIcon() {
        return this.floorIcon;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getBgImgUrl() {
        return this.bgImgUrl;
    }

    public final List<ImageColorModel> getAtmosphereImgList() {
        return this.atmosphereImgList;
    }

    public final List<BenefitInfo> getBenefitInfos() {
        return this.benefitInfos;
    }

    public final String getBrief() {
        return this.brief;
    }

    public final String getCommentBgUrl() {
        return this.commentBgUrl;
    }

    public final List<String> getCommitmentTags() {
        return this.commitmentTags;
    }

    public final Boolean getCouponReceiveAble() {
        return this.couponReceiveAble;
    }

    public final BulletScreen getCrowdfundingBulletScreenVO() {
        return this.crowdfundingBulletScreenVO;
    }

    public final String getExtBrief() {
        return this.extBrief;
    }

    public final HeadAvModel getHeadAvDTO() {
        return this.headAvDTO;
    }

    public final List<String> getImageList() {
        return this.imageList;
    }

    public final Long getShopId() {
        return this.shopId;
    }

    public final Long getOneShopId() {
        return this.oneShopId;
    }

    public final Long getItemsId() {
        return this.itemsId;
    }

    public final ItemsBenefitsInfo getItemsBenefitsInfo() {
        return this.itemsBenefitsInfo;
    }

    public final String getItemsName() {
        return this.itemsName;
    }

    public final Integer getItemsStatus() {
        return this.itemsStatus;
    }

    public final LiveInfo getLiveInfo() {
        return this.liveInfo;
    }

    public final MainImageScale getMainImgScale() {
        return this.mainImgScale;
    }

    public final NewUpSayModel getNewUpSayVO() {
        return this.newUpSayVO;
    }

    public final List<PromotionInfoVO> getPromoInfoVOS() {
        return this.promoInfoVOS;
    }

    public final Boolean getReserveAble() {
        return this.reserveAble;
    }

    public final List<SalePoint> getSalePoint() {
        return this.salePoint;
    }

    public final LabelObject getServiceRightTag() {
        return this.serviceRightTag;
    }

    public final TextColorModel getTitlePrefix() {
        return this.titlePrefix;
    }

    public final HeadAvModel getVerticalHeadAvDTO() {
        return this.verticalHeadAvDTO;
    }

    public final Boolean getNewCustomer() {
        return this.newCustomer;
    }

    public final String getGuideIndexUrl() {
        return this.guideIndexUrl;
    }

    public final Integer getRetainDaysFreq() {
        return this.retainDaysFreq;
    }

    /* compiled from: BasicInfoFloor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BenefitInfo;", "", "amount", "", "prefix", "suffix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAmount", "()Ljava/lang/String;", "getPrefix", "getSuffix", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class BenefitInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String amount;
        private final String prefix;
        private final String suffix;

        public BenefitInfo() {
            this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ BenefitInfo copy$default(BenefitInfo benefitInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = benefitInfo.amount;
            }
            if ((i & 2) != 0) {
                str2 = benefitInfo.prefix;
            }
            if ((i & 4) != 0) {
                str3 = benefitInfo.suffix;
            }
            return benefitInfo.copy(str, str2, str3);
        }

        public final String component1() {
            return this.amount;
        }

        public final String component2() {
            return this.prefix;
        }

        public final String component3() {
            return this.suffix;
        }

        public final BenefitInfo copy(String str, String str2, String str3) {
            return new BenefitInfo(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BenefitInfo) {
                BenefitInfo benefitInfo = (BenefitInfo) obj;
                return Intrinsics.areEqual(this.amount, benefitInfo.amount) && Intrinsics.areEqual(this.prefix, benefitInfo.prefix) && Intrinsics.areEqual(this.suffix, benefitInfo.suffix);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.amount == null ? 0 : this.amount.hashCode()) * 31) + (this.prefix == null ? 0 : this.prefix.hashCode())) * 31) + (this.suffix != null ? this.suffix.hashCode() : 0);
        }

        public String toString() {
            String str = this.amount;
            String str2 = this.prefix;
            return "BenefitInfo(amount=" + str + ", prefix=" + str2 + ", suffix=" + this.suffix + ")";
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BenefitInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BenefitInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<BenefitInfo> serializer() {
                return BasicInfoFloor$BenefitInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ BenefitInfo(int seen0, String amount, String prefix, String suffix, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.amount = null;
            } else {
                this.amount = amount;
            }
            if ((seen0 & 2) == 0) {
                this.prefix = null;
            } else {
                this.prefix = prefix;
            }
            if ((seen0 & 4) == 0) {
                this.suffix = null;
            } else {
                this.suffix = suffix;
            }
        }

        public BenefitInfo(String amount, String prefix, String suffix) {
            this.amount = amount;
            this.prefix = prefix;
            this.suffix = suffix;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(BenefitInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.amount != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.amount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.prefix != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.prefix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.suffix != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.suffix);
            }
        }

        public /* synthetic */ BenefitInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getAmount() {
            return this.amount;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getSuffix() {
            return this.suffix;
        }
    }

    /* compiled from: BasicInfoFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006("}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$MainImageScale;", "", "imgScale", "", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImgScale", "()Ljava/lang/String;", "getWidth", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeight", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$MainImageScale;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MainImageScale {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Double height;
        private final String imgScale;
        private final Double width;

        public MainImageScale() {
            this((String) null, (Double) null, (Double) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MainImageScale copy$default(MainImageScale mainImageScale, String str, Double d, Double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mainImageScale.imgScale;
            }
            if ((i & 2) != 0) {
                d = mainImageScale.width;
            }
            if ((i & 4) != 0) {
                d2 = mainImageScale.height;
            }
            return mainImageScale.copy(str, d, d2);
        }

        public final String component1() {
            return this.imgScale;
        }

        public final Double component2() {
            return this.width;
        }

        public final Double component3() {
            return this.height;
        }

        public final MainImageScale copy(String str, Double d, Double d2) {
            return new MainImageScale(str, d, d2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MainImageScale) {
                MainImageScale mainImageScale = (MainImageScale) obj;
                return Intrinsics.areEqual(this.imgScale, mainImageScale.imgScale) && Intrinsics.areEqual(this.width, mainImageScale.width) && Intrinsics.areEqual(this.height, mainImageScale.height);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.imgScale == null ? 0 : this.imgScale.hashCode()) * 31) + (this.width == null ? 0 : this.width.hashCode())) * 31) + (this.height != null ? this.height.hashCode() : 0);
        }

        public String toString() {
            String str = this.imgScale;
            Double d = this.width;
            return "MainImageScale(imgScale=" + str + ", width=" + d + ", height=" + this.height + ")";
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$MainImageScale$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$MainImageScale;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MainImageScale> serializer() {
                return BasicInfoFloor$MainImageScale$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MainImageScale(int seen0, String imgScale, Double width, Double height, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.imgScale = null;
            } else {
                this.imgScale = imgScale;
            }
            if ((seen0 & 2) == 0) {
                this.width = null;
            } else {
                this.width = width;
            }
            if ((seen0 & 4) == 0) {
                this.height = null;
            } else {
                this.height = height;
            }
        }

        public MainImageScale(String imgScale, Double width, Double height) {
            this.imgScale = imgScale;
            this.width = width;
            this.height = height;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(MainImageScale self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.imgScale != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.imgScale);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.width != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, DoubleSerializer.INSTANCE, self.width);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.height != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, DoubleSerializer.INSTANCE, self.height);
            }
        }

        public /* synthetic */ MainImageScale(String str, Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : d2);
        }

        public final String getImgScale() {
            return this.imgScale;
        }

        public final Double getWidth() {
            return this.width;
        }

        public final Double getHeight() {
            return this.height;
        }
    }

    /* compiled from: BasicInfoFloor.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen;", "", "bulletScreenList", "", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen$BulletItem;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBulletScreenList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "BulletItem", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class BulletScreen {
        private final List<BulletItem> bulletScreenList;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$BulletScreen$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = BasicInfoFloor.BulletScreen._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public BulletScreen() {
            this((List) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BulletScreen copy$default(BulletScreen bulletScreen, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = bulletScreen.bulletScreenList;
            }
            return bulletScreen.copy(list);
        }

        public final List<BulletItem> component1() {
            return this.bulletScreenList;
        }

        public final BulletScreen copy(List<BulletItem> list) {
            return new BulletScreen(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BulletScreen) && Intrinsics.areEqual(this.bulletScreenList, ((BulletScreen) obj).bulletScreenList);
        }

        public int hashCode() {
            if (this.bulletScreenList == null) {
                return 0;
            }
            return this.bulletScreenList.hashCode();
        }

        public String toString() {
            return "BulletScreen(bulletScreenList=" + this.bulletScreenList + ")";
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<BulletScreen> serializer() {
                return BasicInfoFloor$BulletScreen$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ BulletScreen(int seen0, List bulletScreenList, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.bulletScreenList = null;
            } else {
                this.bulletScreenList = bulletScreenList;
            }
        }

        public BulletScreen(List<BulletItem> list) {
            this.bulletScreenList = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(BasicInfoFloor$BulletScreen$BulletItem$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(BulletScreen self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            boolean z = true;
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.bulletScreenList == null) {
                z = false;
            }
            if (z) {
                output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.bulletScreenList);
            }
        }

        public /* synthetic */ BulletScreen(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen$BulletItem;", "", "avatar", "", "message", "uname", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAvatar", "()Ljava/lang/String;", "getMessage", "getUname", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class BulletItem {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String avatar;
            private final String message;
            private final String uname;

            public BulletItem() {
                this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ BulletItem copy$default(BulletItem bulletItem, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = bulletItem.avatar;
                }
                if ((i & 2) != 0) {
                    str2 = bulletItem.message;
                }
                if ((i & 4) != 0) {
                    str3 = bulletItem.uname;
                }
                return bulletItem.copy(str, str2, str3);
            }

            public final String component1() {
                return this.avatar;
            }

            public final String component2() {
                return this.message;
            }

            public final String component3() {
                return this.uname;
            }

            public final BulletItem copy(String str, String str2, String str3) {
                return new BulletItem(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BulletItem) {
                    BulletItem bulletItem = (BulletItem) obj;
                    return Intrinsics.areEqual(this.avatar, bulletItem.avatar) && Intrinsics.areEqual(this.message, bulletItem.message) && Intrinsics.areEqual(this.uname, bulletItem.uname);
                }
                return false;
            }

            public int hashCode() {
                return ((((this.avatar == null ? 0 : this.avatar.hashCode()) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.uname != null ? this.uname.hashCode() : 0);
            }

            public String toString() {
                String str = this.avatar;
                String str2 = this.message;
                return "BulletItem(avatar=" + str + ", message=" + str2 + ", uname=" + this.uname + ")";
            }

            /* compiled from: BasicInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen$BulletItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen$BulletItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<BulletItem> serializer() {
                    return BasicInfoFloor$BulletScreen$BulletItem$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ BulletItem(int seen0, String avatar, String message, String uname, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.avatar = null;
                } else {
                    this.avatar = avatar;
                }
                if ((seen0 & 2) == 0) {
                    this.message = null;
                } else {
                    this.message = message;
                }
                if ((seen0 & 4) == 0) {
                    this.uname = null;
                } else {
                    this.uname = uname;
                }
            }

            public BulletItem(String avatar, String message, String uname) {
                this.avatar = avatar;
                this.message = message;
                this.uname = uname;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(BulletItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.avatar != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.avatar);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.message != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.message);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.uname != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.uname);
                }
            }

            public /* synthetic */ BulletItem(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getAvatar() {
                return this.avatar;
            }

            public final String getMessage() {
                return this.message;
            }

            public final String getUname() {
                return this.uname;
            }
        }

        public final List<BulletItem> getBulletScreenList() {
            return this.bulletScreenList;
        }
    }

    /* compiled from: BasicInfoFloor.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,BI\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fBU\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003JP\u0010\u001c\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\nHÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;", "", "longVideoIds", "", "", "videoIds", "", "videoType", "", "videoUrls", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Byte;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/lang/Byte;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLongVideoIds", "()Ljava/util/List;", "getVideoIds", "getVideoType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getVideoUrls", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Byte;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class HeadAvModel {
        private final List<Long> longVideoIds;
        private final List<Integer> videoIds;
        private final Byte videoType;
        private final List<String> videoUrls;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$HeadAvModel$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = BasicInfoFloor.HeadAvModel._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$HeadAvModel$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = BasicInfoFloor.HeadAvModel._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$HeadAvModel$$ExternalSyntheticLambda2
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$1;
                _childSerializers$_anonymous_$1 = BasicInfoFloor.HeadAvModel._childSerializers$_anonymous_$1();
                return _childSerializers$_anonymous_$1;
            }
        })};

        public HeadAvModel() {
            this((List) null, (List) null, (Byte) null, (List) null, 15, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HeadAvModel copy$default(HeadAvModel headAvModel, List list, List list2, Byte b, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = headAvModel.longVideoIds;
            }
            if ((i & 2) != 0) {
                list2 = headAvModel.videoIds;
            }
            if ((i & 4) != 0) {
                b = headAvModel.videoType;
            }
            if ((i & 8) != 0) {
                list3 = headAvModel.videoUrls;
            }
            return headAvModel.copy(list, list2, b, list3);
        }

        public final List<Long> component1() {
            return this.longVideoIds;
        }

        public final List<Integer> component2() {
            return this.videoIds;
        }

        public final Byte component3() {
            return this.videoType;
        }

        public final List<String> component4() {
            return this.videoUrls;
        }

        public final HeadAvModel copy(List<Long> list, List<Integer> list2, Byte b, List<String> list3) {
            return new HeadAvModel(list, list2, b, list3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HeadAvModel) {
                HeadAvModel headAvModel = (HeadAvModel) obj;
                return Intrinsics.areEqual(this.longVideoIds, headAvModel.longVideoIds) && Intrinsics.areEqual(this.videoIds, headAvModel.videoIds) && Intrinsics.areEqual(this.videoType, headAvModel.videoType) && Intrinsics.areEqual(this.videoUrls, headAvModel.videoUrls);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.longVideoIds == null ? 0 : this.longVideoIds.hashCode()) * 31) + (this.videoIds == null ? 0 : this.videoIds.hashCode())) * 31) + (this.videoType == null ? 0 : this.videoType.hashCode())) * 31) + (this.videoUrls != null ? this.videoUrls.hashCode() : 0);
        }

        public String toString() {
            List<Long> list = this.longVideoIds;
            List<Integer> list2 = this.videoIds;
            Byte b = this.videoType;
            return "HeadAvModel(longVideoIds=" + list + ", videoIds=" + list2 + ", videoType=" + b + ", videoUrls=" + this.videoUrls + ")";
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$HeadAvModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<HeadAvModel> serializer() {
                return BasicInfoFloor$HeadAvModel$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ HeadAvModel(int seen0, List longVideoIds, List videoIds, Byte videoType, List videoUrls, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.longVideoIds = null;
            } else {
                this.longVideoIds = longVideoIds;
            }
            if ((seen0 & 2) == 0) {
                this.videoIds = null;
            } else {
                this.videoIds = videoIds;
            }
            if ((seen0 & 4) == 0) {
                this.videoType = null;
            } else {
                this.videoType = videoType;
            }
            if ((seen0 & 8) == 0) {
                this.videoUrls = null;
            } else {
                this.videoUrls = videoUrls;
            }
        }

        public HeadAvModel(List<Long> list, List<Integer> list2, Byte videoType, List<String> list3) {
            this.longVideoIds = list;
            this.videoIds = list2;
            this.videoType = videoType;
            this.videoUrls = list3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(LongSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(IntSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(HeadAvModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.longVideoIds != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.longVideoIds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.videoIds != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.videoIds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.videoType != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, ByteSerializer.INSTANCE, self.videoType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.videoUrls != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.videoUrls);
            }
        }

        public /* synthetic */ HeadAvModel(List list, List list2, Byte b, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : b, (i & 8) != 0 ? null : list3);
        }

        public final List<Long> getLongVideoIds() {
            return this.longVideoIds;
        }

        public final List<Integer> getVideoIds() {
            return this.videoIds;
        }

        public final Byte getVideoType() {
            return this.videoType;
        }

        public final List<String> getVideoUrls() {
            return this.videoUrls;
        }
    }

    /* compiled from: BasicInfoFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006&"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$LiveInfo;", "", "jumpUrl", "", "liveIcon", "Lkntr/app/mall/product/details/page/api/model/ImageModel;", "text", "<init>", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ImageModel;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/mall/product/details/page/api/model/ImageModel;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getJumpUrl", "()Ljava/lang/String;", "getLiveIcon", "()Lkntr/app/mall/product/details/page/api/model/ImageModel;", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LiveInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String jumpUrl;
        private final ImageModel liveIcon;
        private final String text;

        public LiveInfo() {
            this((String) null, (ImageModel) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ LiveInfo copy$default(LiveInfo liveInfo, String str, ImageModel imageModel, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = liveInfo.jumpUrl;
            }
            if ((i & 2) != 0) {
                imageModel = liveInfo.liveIcon;
            }
            if ((i & 4) != 0) {
                str2 = liveInfo.text;
            }
            return liveInfo.copy(str, imageModel, str2);
        }

        public final String component1() {
            return this.jumpUrl;
        }

        public final ImageModel component2() {
            return this.liveIcon;
        }

        public final String component3() {
            return this.text;
        }

        public final LiveInfo copy(String str, ImageModel imageModel, String str2) {
            return new LiveInfo(str, imageModel, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LiveInfo) {
                LiveInfo liveInfo = (LiveInfo) obj;
                return Intrinsics.areEqual(this.jumpUrl, liveInfo.jumpUrl) && Intrinsics.areEqual(this.liveIcon, liveInfo.liveIcon) && Intrinsics.areEqual(this.text, liveInfo.text);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.jumpUrl == null ? 0 : this.jumpUrl.hashCode()) * 31) + (this.liveIcon == null ? 0 : this.liveIcon.hashCode())) * 31) + (this.text != null ? this.text.hashCode() : 0);
        }

        public String toString() {
            String str = this.jumpUrl;
            ImageModel imageModel = this.liveIcon;
            return "LiveInfo(jumpUrl=" + str + ", liveIcon=" + imageModel + ", text=" + this.text + ")";
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$LiveInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$LiveInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LiveInfo> serializer() {
                return BasicInfoFloor$LiveInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ LiveInfo(int seen0, String jumpUrl, ImageModel liveIcon, String text, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 2) == 0) {
                this.liveIcon = null;
            } else {
                this.liveIcon = liveIcon;
            }
            if ((seen0 & 4) == 0) {
                this.text = null;
            } else {
                this.text = text;
            }
        }

        public LiveInfo(String jumpUrl, ImageModel liveIcon, String text) {
            this.jumpUrl = jumpUrl;
            this.liveIcon = liveIcon;
            this.text = text;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(LiveInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.liveIcon != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, ImageModel$$serializer.INSTANCE, self.liveIcon);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.text != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.text);
            }
        }

        public /* synthetic */ LiveInfo(String str, ImageModel imageModel, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : imageModel, (i & 4) != 0 ? null : str2);
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final ImageModel getLiveIcon() {
            return this.liveIcon;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: BasicInfoFloor.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0004,-./BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fBY\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u000eHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u00060"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo;", "", "backupImgUrl", "", "benefitsDesc", "benefitsExplain", "benefitsSkuList", "", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo$BenefitsSku;", "benefitsTags", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo$BenefitsTag;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBackupImgUrl", "()Ljava/lang/String;", "getBenefitsDesc", "getBenefitsExplain", "getBenefitsSkuList", "()Ljava/util/List;", "getBenefitsTags", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "BenefitsSku", "BenefitsTag", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ItemsBenefitsInfo {
        private final String backupImgUrl;
        private final String benefitsDesc;
        private final String benefitsExplain;
        private final List<BenefitsSku> benefitsSkuList;
        private final List<BenefitsTag> benefitsTags;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$ItemsBenefitsInfo$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = BasicInfoFloor.ItemsBenefitsInfo._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.BasicInfoFloor$ItemsBenefitsInfo$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = BasicInfoFloor.ItemsBenefitsInfo._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        })};

        public ItemsBenefitsInfo() {
            this((String) null, (String) null, (String) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ItemsBenefitsInfo copy$default(ItemsBenefitsInfo itemsBenefitsInfo, String str, String str2, String str3, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemsBenefitsInfo.backupImgUrl;
            }
            if ((i & 2) != 0) {
                str2 = itemsBenefitsInfo.benefitsDesc;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = itemsBenefitsInfo.benefitsExplain;
            }
            String str5 = str3;
            List<BenefitsSku> list3 = list;
            if ((i & 8) != 0) {
                list3 = itemsBenefitsInfo.benefitsSkuList;
            }
            List list4 = list3;
            List<BenefitsTag> list5 = list2;
            if ((i & 16) != 0) {
                list5 = itemsBenefitsInfo.benefitsTags;
            }
            return itemsBenefitsInfo.copy(str, str4, str5, list4, list5);
        }

        public final String component1() {
            return this.backupImgUrl;
        }

        public final String component2() {
            return this.benefitsDesc;
        }

        public final String component3() {
            return this.benefitsExplain;
        }

        public final List<BenefitsSku> component4() {
            return this.benefitsSkuList;
        }

        public final List<BenefitsTag> component5() {
            return this.benefitsTags;
        }

        public final ItemsBenefitsInfo copy(String str, String str2, String str3, List<BenefitsSku> list, List<BenefitsTag> list2) {
            return new ItemsBenefitsInfo(str, str2, str3, list, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ItemsBenefitsInfo) {
                ItemsBenefitsInfo itemsBenefitsInfo = (ItemsBenefitsInfo) obj;
                return Intrinsics.areEqual(this.backupImgUrl, itemsBenefitsInfo.backupImgUrl) && Intrinsics.areEqual(this.benefitsDesc, itemsBenefitsInfo.benefitsDesc) && Intrinsics.areEqual(this.benefitsExplain, itemsBenefitsInfo.benefitsExplain) && Intrinsics.areEqual(this.benefitsSkuList, itemsBenefitsInfo.benefitsSkuList) && Intrinsics.areEqual(this.benefitsTags, itemsBenefitsInfo.benefitsTags);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.backupImgUrl == null ? 0 : this.backupImgUrl.hashCode()) * 31) + (this.benefitsDesc == null ? 0 : this.benefitsDesc.hashCode())) * 31) + (this.benefitsExplain == null ? 0 : this.benefitsExplain.hashCode())) * 31) + (this.benefitsSkuList == null ? 0 : this.benefitsSkuList.hashCode())) * 31) + (this.benefitsTags != null ? this.benefitsTags.hashCode() : 0);
        }

        public String toString() {
            String str = this.backupImgUrl;
            String str2 = this.benefitsDesc;
            String str3 = this.benefitsExplain;
            List<BenefitsSku> list = this.benefitsSkuList;
            return "ItemsBenefitsInfo(backupImgUrl=" + str + ", benefitsDesc=" + str2 + ", benefitsExplain=" + str3 + ", benefitsSkuList=" + list + ", benefitsTags=" + this.benefitsTags + ")";
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ItemsBenefitsInfo> serializer() {
                return BasicInfoFloor$ItemsBenefitsInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ItemsBenefitsInfo(int seen0, String backupImgUrl, String benefitsDesc, String benefitsExplain, List benefitsSkuList, List benefitsTags, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.backupImgUrl = null;
            } else {
                this.backupImgUrl = backupImgUrl;
            }
            if ((seen0 & 2) == 0) {
                this.benefitsDesc = null;
            } else {
                this.benefitsDesc = benefitsDesc;
            }
            if ((seen0 & 4) == 0) {
                this.benefitsExplain = null;
            } else {
                this.benefitsExplain = benefitsExplain;
            }
            if ((seen0 & 8) == 0) {
                this.benefitsSkuList = null;
            } else {
                this.benefitsSkuList = benefitsSkuList;
            }
            if ((seen0 & 16) == 0) {
                this.benefitsTags = null;
            } else {
                this.benefitsTags = benefitsTags;
            }
        }

        public ItemsBenefitsInfo(String backupImgUrl, String benefitsDesc, String benefitsExplain, List<BenefitsSku> list, List<BenefitsTag> list2) {
            this.backupImgUrl = backupImgUrl;
            this.benefitsDesc = benefitsDesc;
            this.benefitsExplain = benefitsExplain;
            this.benefitsSkuList = list;
            this.benefitsTags = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(BasicInfoFloor$ItemsBenefitsInfo$BenefitsSku$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(BasicInfoFloor$ItemsBenefitsInfo$BenefitsTag$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ItemsBenefitsInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.backupImgUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.backupImgUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.benefitsDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.benefitsDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.benefitsExplain != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.benefitsExplain);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.benefitsSkuList != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.benefitsSkuList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.benefitsTags != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.benefitsTags);
            }
        }

        public /* synthetic */ ItemsBenefitsInfo(String str, String str2, String str3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : list2);
        }

        public final String getBackupImgUrl() {
            return this.backupImgUrl;
        }

        public final String getBenefitsDesc() {
            return this.benefitsDesc;
        }

        public final String getBenefitsExplain() {
            return this.benefitsExplain;
        }

        public final List<BenefitsSku> getBenefitsSkuList() {
            return this.benefitsSkuList;
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo$BenefitsSku;", "", "specImg", "", "specName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSpecImg", "()Ljava/lang/String;", "getSpecName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class BenefitsSku {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String specImg;
            private final String specName;

            public BenefitsSku() {
                this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ BenefitsSku copy$default(BenefitsSku benefitsSku, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = benefitsSku.specImg;
                }
                if ((i & 2) != 0) {
                    str2 = benefitsSku.specName;
                }
                return benefitsSku.copy(str, str2);
            }

            public final String component1() {
                return this.specImg;
            }

            public final String component2() {
                return this.specName;
            }

            public final BenefitsSku copy(String str, String str2) {
                return new BenefitsSku(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BenefitsSku) {
                    BenefitsSku benefitsSku = (BenefitsSku) obj;
                    return Intrinsics.areEqual(this.specImg, benefitsSku.specImg) && Intrinsics.areEqual(this.specName, benefitsSku.specName);
                }
                return false;
            }

            public int hashCode() {
                return ((this.specImg == null ? 0 : this.specImg.hashCode()) * 31) + (this.specName != null ? this.specName.hashCode() : 0);
            }

            public String toString() {
                String str = this.specImg;
                return "BenefitsSku(specImg=" + str + ", specName=" + this.specName + ")";
            }

            /* compiled from: BasicInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo$BenefitsSku$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo$BenefitsSku;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<BenefitsSku> serializer() {
                    return BasicInfoFloor$ItemsBenefitsInfo$BenefitsSku$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ BenefitsSku(int seen0, String specImg, String specName, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.specImg = null;
                } else {
                    this.specImg = specImg;
                }
                if ((seen0 & 2) == 0) {
                    this.specName = null;
                } else {
                    this.specName = specName;
                }
            }

            public BenefitsSku(String specImg, String specName) {
                this.specImg = specImg;
                this.specName = specName;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(BenefitsSku self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.specImg != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.specImg);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.specName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.specName);
                }
            }

            public /* synthetic */ BenefitsSku(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            public final String getSpecImg() {
                return this.specImg;
            }

            public final String getSpecName() {
                return this.specName;
            }
        }

        public final List<BenefitsTag> getBenefitsTags() {
            return this.benefitsTags;
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bBW\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u00060"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo$BenefitsTag;", "", "actionType", "", "bgSrc", "", "bgType", "jumpUrl", "ruleDesc", "tagName", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBgSrc", "()Ljava/lang/String;", "getBgType", "getJumpUrl", "getRuleDesc", "getTagName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo$BenefitsTag;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class BenefitsTag {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final Integer actionType;
            private final String bgSrc;
            private final Integer bgType;
            private final String jumpUrl;
            private final String ruleDesc;
            private final String tagName;

            public BenefitsTag() {
                this((Integer) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ BenefitsTag copy$default(BenefitsTag benefitsTag, Integer num, String str, Integer num2, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = benefitsTag.actionType;
                }
                if ((i & 2) != 0) {
                    str = benefitsTag.bgSrc;
                }
                String str5 = str;
                if ((i & 4) != 0) {
                    num2 = benefitsTag.bgType;
                }
                Integer num3 = num2;
                if ((i & 8) != 0) {
                    str2 = benefitsTag.jumpUrl;
                }
                String str6 = str2;
                if ((i & 16) != 0) {
                    str3 = benefitsTag.ruleDesc;
                }
                String str7 = str3;
                if ((i & 32) != 0) {
                    str4 = benefitsTag.tagName;
                }
                return benefitsTag.copy(num, str5, num3, str6, str7, str4);
            }

            public final Integer component1() {
                return this.actionType;
            }

            public final String component2() {
                return this.bgSrc;
            }

            public final Integer component3() {
                return this.bgType;
            }

            public final String component4() {
                return this.jumpUrl;
            }

            public final String component5() {
                return this.ruleDesc;
            }

            public final String component6() {
                return this.tagName;
            }

            public final BenefitsTag copy(Integer num, String str, Integer num2, String str2, String str3, String str4) {
                return new BenefitsTag(num, str, num2, str2, str3, str4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BenefitsTag) {
                    BenefitsTag benefitsTag = (BenefitsTag) obj;
                    return Intrinsics.areEqual(this.actionType, benefitsTag.actionType) && Intrinsics.areEqual(this.bgSrc, benefitsTag.bgSrc) && Intrinsics.areEqual(this.bgType, benefitsTag.bgType) && Intrinsics.areEqual(this.jumpUrl, benefitsTag.jumpUrl) && Intrinsics.areEqual(this.ruleDesc, benefitsTag.ruleDesc) && Intrinsics.areEqual(this.tagName, benefitsTag.tagName);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((this.actionType == null ? 0 : this.actionType.hashCode()) * 31) + (this.bgSrc == null ? 0 : this.bgSrc.hashCode())) * 31) + (this.bgType == null ? 0 : this.bgType.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.ruleDesc == null ? 0 : this.ruleDesc.hashCode())) * 31) + (this.tagName != null ? this.tagName.hashCode() : 0);
            }

            public String toString() {
                Integer num = this.actionType;
                String str = this.bgSrc;
                Integer num2 = this.bgType;
                String str2 = this.jumpUrl;
                String str3 = this.ruleDesc;
                return "BenefitsTag(actionType=" + num + ", bgSrc=" + str + ", bgType=" + num2 + ", jumpUrl=" + str2 + ", ruleDesc=" + str3 + ", tagName=" + this.tagName + ")";
            }

            /* compiled from: BasicInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo$BenefitsTag$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$ItemsBenefitsInfo$BenefitsTag;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<BenefitsTag> serializer() {
                    return BasicInfoFloor$ItemsBenefitsInfo$BenefitsTag$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ BenefitsTag(int seen0, Integer actionType, String bgSrc, Integer bgType, String jumpUrl, String ruleDesc, String tagName, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.actionType = null;
                } else {
                    this.actionType = actionType;
                }
                if ((seen0 & 2) == 0) {
                    this.bgSrc = null;
                } else {
                    this.bgSrc = bgSrc;
                }
                if ((seen0 & 4) == 0) {
                    this.bgType = null;
                } else {
                    this.bgType = bgType;
                }
                if ((seen0 & 8) == 0) {
                    this.jumpUrl = null;
                } else {
                    this.jumpUrl = jumpUrl;
                }
                if ((seen0 & 16) == 0) {
                    this.ruleDesc = null;
                } else {
                    this.ruleDesc = ruleDesc;
                }
                if ((seen0 & 32) == 0) {
                    this.tagName = null;
                } else {
                    this.tagName = tagName;
                }
            }

            public BenefitsTag(Integer actionType, String bgSrc, Integer bgType, String jumpUrl, String ruleDesc, String tagName) {
                this.actionType = actionType;
                this.bgSrc = bgSrc;
                this.bgType = bgType;
                this.jumpUrl = jumpUrl;
                this.ruleDesc = ruleDesc;
                this.tagName = tagName;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(BenefitsTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.actionType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.actionType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.bgSrc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.bgSrc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.bgType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.bgType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.jumpUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.jumpUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.ruleDesc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.ruleDesc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.tagName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.tagName);
                }
            }

            public /* synthetic */ BenefitsTag(Integer num, String str, Integer num2, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
            }

            public final Integer getActionType() {
                return this.actionType;
            }

            public final String getBgSrc() {
                return this.bgSrc;
            }

            public final Integer getBgType() {
                return this.bgType;
            }

            public final String getJumpUrl() {
                return this.jumpUrl;
            }

            public final String getRuleDesc() {
                return this.ruleDesc;
            }

            public final String getTagName() {
                return this.tagName;
            }
        }
    }

    /* compiled from: BasicInfoFloor.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u00065"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel;", "", "aid", "", "jumpUrl", "type", "", "userInfoDTO", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;", "videoRatio", "", "videoUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;Ljava/lang/Double;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;Ljava/lang/Double;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAid", "()Ljava/lang/String;", "getJumpUrl", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserInfoDTO", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;", "getVideoRatio", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVideoUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo;Ljava/lang/Double;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class NewUpSayModel {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String aid;
        private final String jumpUrl;
        private final Integer type;
        private final CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo userInfoDTO;
        private final Double videoRatio;
        private final String videoUrl;

        public NewUpSayModel() {
            this((String) null, (String) null, (Integer) null, (CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo) null, (Double) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ NewUpSayModel copy$default(NewUpSayModel newUpSayModel, String str, String str2, Integer num, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo userInfo, Double d, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = newUpSayModel.aid;
            }
            if ((i & 2) != 0) {
                str2 = newUpSayModel.jumpUrl;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                num = newUpSayModel.type;
            }
            Integer num2 = num;
            if ((i & 8) != 0) {
                userInfo = newUpSayModel.userInfoDTO;
            }
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo userInfo2 = userInfo;
            if ((i & 16) != 0) {
                d = newUpSayModel.videoRatio;
            }
            Double d2 = d;
            if ((i & 32) != 0) {
                str3 = newUpSayModel.videoUrl;
            }
            return newUpSayModel.copy(str, str4, num2, userInfo2, d2, str3);
        }

        public final String component1() {
            return this.aid;
        }

        public final String component2() {
            return this.jumpUrl;
        }

        public final Integer component3() {
            return this.type;
        }

        public final CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo component4() {
            return this.userInfoDTO;
        }

        public final Double component5() {
            return this.videoRatio;
        }

        public final String component6() {
            return this.videoUrl;
        }

        public final NewUpSayModel copy(String str, String str2, Integer num, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo userInfo, Double d, String str3) {
            return new NewUpSayModel(str, str2, num, userInfo, d, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NewUpSayModel) {
                NewUpSayModel newUpSayModel = (NewUpSayModel) obj;
                return Intrinsics.areEqual(this.aid, newUpSayModel.aid) && Intrinsics.areEqual(this.jumpUrl, newUpSayModel.jumpUrl) && Intrinsics.areEqual(this.type, newUpSayModel.type) && Intrinsics.areEqual(this.userInfoDTO, newUpSayModel.userInfoDTO) && Intrinsics.areEqual(this.videoRatio, newUpSayModel.videoRatio) && Intrinsics.areEqual(this.videoUrl, newUpSayModel.videoUrl);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((this.aid == null ? 0 : this.aid.hashCode()) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.userInfoDTO == null ? 0 : this.userInfoDTO.hashCode())) * 31) + (this.videoRatio == null ? 0 : this.videoRatio.hashCode())) * 31) + (this.videoUrl != null ? this.videoUrl.hashCode() : 0);
        }

        public String toString() {
            String str = this.aid;
            String str2 = this.jumpUrl;
            Integer num = this.type;
            CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo userInfo = this.userInfoDTO;
            Double d = this.videoRatio;
            return "NewUpSayModel(aid=" + str + ", jumpUrl=" + str2 + ", type=" + num + ", userInfoDTO=" + userInfo + ", videoRatio=" + d + ", videoUrl=" + this.videoUrl + ")";
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<NewUpSayModel> serializer() {
                return BasicInfoFloor$NewUpSayModel$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ NewUpSayModel(int seen0, String aid, String jumpUrl, Integer type, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo userInfoDTO, Double videoRatio, String videoUrl, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.aid = null;
            } else {
                this.aid = aid;
            }
            if ((seen0 & 2) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 4) == 0) {
                this.type = null;
            } else {
                this.type = type;
            }
            if ((seen0 & 8) == 0) {
                this.userInfoDTO = null;
            } else {
                this.userInfoDTO = userInfoDTO;
            }
            if ((seen0 & 16) == 0) {
                this.videoRatio = null;
            } else {
                this.videoRatio = videoRatio;
            }
            if ((seen0 & 32) == 0) {
                this.videoUrl = null;
            } else {
                this.videoUrl = videoUrl;
            }
        }

        public NewUpSayModel(String aid, String jumpUrl, Integer type, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo userInfoDTO, Double videoRatio, String videoUrl) {
            this.aid = aid;
            this.jumpUrl = jumpUrl;
            this.type = type;
            this.userInfoDTO = userInfoDTO;
            this.videoRatio = videoRatio;
            this.videoUrl = videoUrl;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(NewUpSayModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.aid != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.aid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.userInfoDTO != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel$UserInfo$$serializer.INSTANCE, self.userInfoDTO);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.videoRatio != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, DoubleSerializer.INSTANCE, self.videoRatio);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.videoUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.videoUrl);
            }
        }

        public /* synthetic */ NewUpSayModel(String str, String str2, Integer num, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo userInfo, Double d, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : userInfo, (i & 16) != 0 ? null : d, (i & 32) != 0 ? null : str3);
        }

        public final String getAid() {
            return this.aid;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final Integer getType() {
            return this.type;
        }

        public final CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel.UserInfo getUserInfoDTO() {
            return this.userInfoDTO;
        }

        public final Double getVideoRatio() {
            return this.videoRatio;
        }

        public final String getVideoUrl() {
            return this.videoUrl;
        }
    }

    /* compiled from: BasicInfoFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006&"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$PromotionInfoVO;", "", "promoId", "", "promoTag", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "promoUrl", "<init>", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPromoId", "()Ljava/lang/String;", "getPromoTag", "()Lkntr/app/mall/product/details/page/api/model/LabelObject;", "getPromoUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class PromotionInfoVO {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String promoId;
        private final LabelObject promoTag;
        private final String promoUrl;

        public PromotionInfoVO() {
            this((String) null, (LabelObject) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PromotionInfoVO copy$default(PromotionInfoVO promotionInfoVO, String str, LabelObject labelObject, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = promotionInfoVO.promoId;
            }
            if ((i & 2) != 0) {
                labelObject = promotionInfoVO.promoTag;
            }
            if ((i & 4) != 0) {
                str2 = promotionInfoVO.promoUrl;
            }
            return promotionInfoVO.copy(str, labelObject, str2);
        }

        public final String component1() {
            return this.promoId;
        }

        public final LabelObject component2() {
            return this.promoTag;
        }

        public final String component3() {
            return this.promoUrl;
        }

        public final PromotionInfoVO copy(String str, LabelObject labelObject, String str2) {
            return new PromotionInfoVO(str, labelObject, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PromotionInfoVO) {
                PromotionInfoVO promotionInfoVO = (PromotionInfoVO) obj;
                return Intrinsics.areEqual(this.promoId, promotionInfoVO.promoId) && Intrinsics.areEqual(this.promoTag, promotionInfoVO.promoTag) && Intrinsics.areEqual(this.promoUrl, promotionInfoVO.promoUrl);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.promoId == null ? 0 : this.promoId.hashCode()) * 31) + (this.promoTag == null ? 0 : this.promoTag.hashCode())) * 31) + (this.promoUrl != null ? this.promoUrl.hashCode() : 0);
        }

        public String toString() {
            String str = this.promoId;
            LabelObject labelObject = this.promoTag;
            return "PromotionInfoVO(promoId=" + str + ", promoTag=" + labelObject + ", promoUrl=" + this.promoUrl + ")";
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$PromotionInfoVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$PromotionInfoVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<PromotionInfoVO> serializer() {
                return BasicInfoFloor$PromotionInfoVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ PromotionInfoVO(int seen0, String promoId, LabelObject promoTag, String promoUrl, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.promoId = null;
            } else {
                this.promoId = promoId;
            }
            if ((seen0 & 2) == 0) {
                this.promoTag = null;
            } else {
                this.promoTag = promoTag;
            }
            if ((seen0 & 4) == 0) {
                this.promoUrl = null;
            } else {
                this.promoUrl = promoUrl;
            }
        }

        public PromotionInfoVO(String promoId, LabelObject promoTag, String promoUrl) {
            this.promoId = promoId;
            this.promoTag = promoTag;
            this.promoUrl = promoUrl;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(PromotionInfoVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.promoId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.promoId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.promoTag != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, LabelObject$$serializer.INSTANCE, self.promoTag);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.promoUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.promoUrl);
            }
        }

        public /* synthetic */ PromotionInfoVO(String str, LabelObject labelObject, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : labelObject, (i & 4) != 0 ? null : str2);
        }

        public final String getPromoId() {
            return this.promoId;
        }

        public final LabelObject getPromoTag() {
            return this.promoTag;
        }

        public final String getPromoUrl() {
            return this.promoUrl;
        }
    }

    /* compiled from: BasicInfoFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006&"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$SalePoint;", "", "jumpUrl", "", "salePoint", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "tagText", "<init>", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getJumpUrl", "()Ljava/lang/String;", "getSalePoint", "()Lkntr/app/mall/product/details/page/api/model/LabelObject;", "getTagText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SalePoint {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String jumpUrl;
        private final LabelObject salePoint;
        private final String tagText;

        public SalePoint() {
            this((String) null, (LabelObject) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SalePoint copy$default(SalePoint salePoint, String str, LabelObject labelObject, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = salePoint.jumpUrl;
            }
            if ((i & 2) != 0) {
                labelObject = salePoint.salePoint;
            }
            if ((i & 4) != 0) {
                str2 = salePoint.tagText;
            }
            return salePoint.copy(str, labelObject, str2);
        }

        public final String component1() {
            return this.jumpUrl;
        }

        public final LabelObject component2() {
            return this.salePoint;
        }

        public final String component3() {
            return this.tagText;
        }

        public final SalePoint copy(String str, LabelObject labelObject, String str2) {
            return new SalePoint(str, labelObject, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SalePoint) {
                SalePoint salePoint = (SalePoint) obj;
                return Intrinsics.areEqual(this.jumpUrl, salePoint.jumpUrl) && Intrinsics.areEqual(this.salePoint, salePoint.salePoint) && Intrinsics.areEqual(this.tagText, salePoint.tagText);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.jumpUrl == null ? 0 : this.jumpUrl.hashCode()) * 31) + (this.salePoint == null ? 0 : this.salePoint.hashCode())) * 31) + (this.tagText != null ? this.tagText.hashCode() : 0);
        }

        public String toString() {
            String str = this.jumpUrl;
            LabelObject labelObject = this.salePoint;
            return "SalePoint(jumpUrl=" + str + ", salePoint=" + labelObject + ", tagText=" + this.tagText + ")";
        }

        /* compiled from: BasicInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$SalePoint$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$SalePoint;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<SalePoint> serializer() {
                return BasicInfoFloor$SalePoint$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SalePoint(int seen0, String jumpUrl, LabelObject salePoint, String tagText, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 2) == 0) {
                this.salePoint = null;
            } else {
                this.salePoint = salePoint;
            }
            if ((seen0 & 4) == 0) {
                this.tagText = null;
            } else {
                this.tagText = tagText;
            }
        }

        public SalePoint(String jumpUrl, LabelObject salePoint, String tagText) {
            this.jumpUrl = jumpUrl;
            this.salePoint = salePoint;
            this.tagText = tagText;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(SalePoint self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.salePoint != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, LabelObject$$serializer.INSTANCE, self.salePoint);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.tagText != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.tagText);
            }
        }

        public /* synthetic */ SalePoint(String str, LabelObject labelObject, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : labelObject, (i & 4) != 0 ? null : str2);
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final LabelObject getSalePoint() {
            return this.salePoint;
        }

        public final String getTagText() {
            return this.tagText;
        }
    }

    public final String generateBenefitTextString$product_details_page_debug() {
        List displayParts = new ArrayList();
        Iterable iterable = this.commitmentTags;
        boolean z = false;
        if (iterable != null) {
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String) element$iv;
                String str = it;
                if (!(str == null || str.length() == 0)) {
                    displayParts.add(it);
                }
            }
        }
        String str2 = this.brief;
        if (!((str2 == null || str2.length() == 0) ? true : true)) {
            displayParts.add(this.brief);
        }
        return CollectionsKt.joinToString$default(displayParts, " | ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final boolean hasVideo$product_details_page_debug() {
        HeadAvModel headAvModel = this.headAvDTO;
        List<String> videoUrls = headAvModel != null ? headAvModel.getVideoUrls() : null;
        return !(videoUrls == null || videoUrls.isEmpty());
    }

    public final String getVideoUrl$product_details_page_debug() {
        List<String> videoUrls;
        HeadAvModel headAvModel = this.headAvDTO;
        if (headAvModel == null || (videoUrls = headAvModel.getVideoUrls()) == null) {
            return null;
        }
        return (String) CollectionsKt.firstOrNull(videoUrls);
    }
}