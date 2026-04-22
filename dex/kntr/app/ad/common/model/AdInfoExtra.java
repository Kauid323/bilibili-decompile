package kntr.app.ad.common.model;

import java.util.List;
import kntr.app.ad.common.protocol.IExtraInfo;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.report.SubmitActionFrom;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdInfoExtra.kt */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u008d\u0001\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ï\u00012\u00020\u0001:\u0004î\u0001ï\u0001Bñ\u0005\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010!\u001a\u00020\u0012\u0012\b\b\u0002\u0010\"\u001a\u00020\u0012\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012\b\b\u0002\u0010)\u001a\u00020&\u0012\b\b\u0002\u0010*\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010-\u001a\u00020\u0012\u0012\b\b\u0002\u0010.\u001a\u00020\u0012\u0012\b\b\u0002\u0010/\u001a\u00020\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u00101\u001a\u00020\u0012\u0012\b\b\u0002\u00102\u001a\u00020\u0012\u0012\b\b\u0002\u00103\u001a\u00020\u0012\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u00106\u001a\u00020\u0012\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010=\u001a\u00020&\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010?\u001a\u00020\u0012\u0012\b\b\u0002\u0010@\u001a\u00020\u0012\u0012\b\b\u0002\u0010A\u001a\u00020\u0003\u0012\b\b\u0002\u0010B\u001a\u00020&\u0012\b\b\u0002\u0010C\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010D\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010E\u0018\u00010\u0005\u0012\b\b\u0002\u0010F\u001a\u00020\u0012\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bJ\u0010KBÝ\u0005\b\u0010\u0012\u0006\u0010L\u001a\u00020\u0012\u0012\u0006\u0010M\u001a\u00020\u0012\u0012\u0006\u0010N\u001a\u00020\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0005\u0012\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u0006\u0010!\u001a\u00020\u0012\u0012\u0006\u0010\"\u001a\u00020\u0012\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010(\u001a\u00020\u0012\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0010\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010-\u001a\u00020\u0012\u0012\u0006\u0010.\u001a\u00020\u0012\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u00101\u001a\u00020\u0012\u0012\u0006\u00102\u001a\u00020\u0012\u0012\u0006\u00103\u001a\u00020\u0012\u0012\u0006\u00104\u001a\u00020\u0003\u0012\b\u00105\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u00106\u001a\u00020\u0012\u0012\b\u00107\u001a\u0004\u0018\u000108\u0012\b\u00109\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010;\u001a\u0004\u0018\u00010<\u0012\u0006\u0010=\u001a\u00020&\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010?\u001a\u00020\u0012\u0012\u0006\u0010@\u001a\u00020\u0012\u0012\u0006\u0010A\u001a\u00020\u0003\u0012\u0006\u0010B\u001a\u00020&\u0012\u0006\u0010C\u001a\u00020\u0003\u0012\u0010\u0010D\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010E\u0018\u00010\u0005\u0012\u0006\u0010F\u001a\u00020\u0012\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010O\u001a\u00020\u0003\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010R\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010S\u001a\u00020\u0003\u0012\b\u0010T\u001a\u0004\u0018\u00010U\u0012\b\u0010V\u001a\u0004\u0018\u00010W\u0012\b\u0010X\u001a\u0004\u0018\u00010Y¢\u0006\u0004\bJ\u0010ZJ-\u0010æ\u0001\u001a\u00030ç\u00012\u0007\u0010è\u0001\u001a\u00020\u00002\b\u0010é\u0001\u001a\u00030ê\u00012\b\u0010ë\u0001\u001a\u00030ì\u0001H\u0001¢\u0006\u0003\bí\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R&\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b_\u0010\\\u001a\u0004\b`\u0010aR&\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bb\u0010\\\u001a\u0004\bc\u0010aR&\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bd\u0010\\\u001a\u0004\be\u0010aR&\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bf\u0010\\\u001a\u0004\bg\u0010aR&\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010\\\u001a\u0004\bi\u0010aR&\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bj\u0010\\\u001a\u0004\bk\u0010aR&\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bl\u0010\\\u001a\u0004\bm\u0010aR&\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bn\u0010\\\u001a\u0004\bo\u0010aR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bp\u0010\\\u001a\u0004\bq\u0010rR\u001c\u0010\u0011\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bs\u0010\\\u001a\u0004\bt\u0010uR\u001c\u0010\u0013\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bv\u0010\\\u001a\u0004\bw\u0010uR\u001c\u0010\u0014\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bx\u0010\\\u001a\u0004\by\u0010^R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bz\u0010\\\u001a\u0004\b{\u0010|R\u001c\u0010\u0016\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b}\u0010\\\u001a\u0004\b~\u0010uR\u001d\u0010\u0017\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000f\n\u0000\u0012\u0004\b\u007f\u0010\\\u001a\u0005\b\u0080\u0001\u0010^R \u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0081\u0001\u0010\\\u001a\u0005\b\u0082\u0001\u0010|R\u001e\u0010\u0019\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0083\u0001\u0010\\\u001a\u0005\b\u0084\u0001\u0010uR\u001e\u0010\u001a\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0085\u0001\u0010\\\u001a\u0005\b\u0086\u0001\u0010uR \u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0087\u0001\u0010\\\u001a\u0005\b\u0088\u0001\u0010|R\u001e\u0010\u001c\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0089\u0001\u0010\\\u001a\u0005\b\u008a\u0001\u0010uR\u001e\u0010\u001d\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008b\u0001\u0010\\\u001a\u0005\b\u008c\u0001\u0010^R\u001e\u0010\u001e\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008d\u0001\u0010\\\u001a\u0005\b\u008e\u0001\u0010^R!\u0010\u001f\u001a\u0004\u0018\u00010 8\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u008f\u0001\u0010\\\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001e\u0010!\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0092\u0001\u0010\\\u001a\u0005\b\u0093\u0001\u0010uR\u001e\u0010\"\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0094\u0001\u0010\\\u001a\u0005\b\u0095\u0001\u0010uR \u0010#\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0096\u0001\u0010\\\u001a\u0005\b\u0097\u0001\u0010|R \u0010$\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0098\u0001\u0010\\\u001a\u0005\b\u0099\u0001\u0010|R\u001f\u0010%\u001a\u00020&8\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u009a\u0001\u0010\\\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001f\u0010'\u001a\u00020&8\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u009d\u0001\u0010\\\u001a\u0006\b\u009e\u0001\u0010\u009c\u0001R\u001e\u0010(\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u009f\u0001\u0010\\\u001a\u0005\b \u0001\u0010uR\u001f\u0010)\u001a\u00020&8\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b¡\u0001\u0010\\\u001a\u0006\b¢\u0001\u0010\u009c\u0001R\u001e\u0010*\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b£\u0001\u0010\\\u001a\u0005\b¤\u0001\u0010^R(\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b¥\u0001\u0010\\\u001a\u0005\b¦\u0001\u0010aR \u0010,\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b§\u0001\u0010\\\u001a\u0005\b¨\u0001\u0010|R\u001e\u0010-\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b©\u0001\u0010\\\u001a\u0005\bª\u0001\u0010uR\u001e\u0010.\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b«\u0001\u0010\\\u001a\u0005\b¬\u0001\u0010uR\u001e\u0010/\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u00ad\u0001\u0010\\\u001a\u0005\b®\u0001\u0010^R \u00100\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b¯\u0001\u0010\\\u001a\u0005\b°\u0001\u0010|R\u001e\u00101\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b±\u0001\u0010\\\u001a\u0005\b²\u0001\u0010uR\u001e\u00102\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b³\u0001\u0010\\\u001a\u0005\b´\u0001\u0010uR\u001e\u00103\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bµ\u0001\u0010\\\u001a\u0005\b¶\u0001\u0010uR\u001d\u00104\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000f\n\u0000\u0012\u0005\b·\u0001\u0010\\\u001a\u0004\b4\u0010^R \u00105\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b¸\u0001\u0010\\\u001a\u0005\b¹\u0001\u0010|R\u001e\u00106\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bº\u0001\u0010\\\u001a\u0005\b»\u0001\u0010uR!\u00107\u001a\u0004\u0018\u0001088\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b¼\u0001\u0010\\\u001a\u0006\b½\u0001\u0010¾\u0001R \u00109\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b¿\u0001\u0010\\\u001a\u0005\bÀ\u0001\u0010|R \u0010:\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bÁ\u0001\u0010\\\u001a\u0005\bÂ\u0001\u0010|R!\u0010;\u001a\u0004\u0018\u00010<8\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\bÃ\u0001\u0010\\\u001a\u0006\bÄ\u0001\u0010Å\u0001R\u001f\u0010=\u001a\u00020&8\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\bÆ\u0001\u0010\\\u001a\u0006\bÇ\u0001\u0010\u009c\u0001R \u0010>\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bÈ\u0001\u0010\\\u001a\u0005\bÉ\u0001\u0010|R\u001e\u0010?\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bÊ\u0001\u0010\\\u001a\u0005\bË\u0001\u0010uR\u001d\u0010@\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u000f\n\u0000\u0012\u0005\bÌ\u0001\u0010\\\u001a\u0004\b@\u0010uR\u001e\u0010A\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bÍ\u0001\u0010\\\u001a\u0005\bÎ\u0001\u0010^R\u001f\u0010B\u001a\u00020&8\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\bÏ\u0001\u0010\\\u001a\u0006\bÐ\u0001\u0010\u009c\u0001R\u001e\u0010C\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bÑ\u0001\u0010\\\u001a\u0005\bÒ\u0001\u0010^R(\u0010D\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010E\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bÓ\u0001\u0010\\\u001a\u0005\bÔ\u0001\u0010aR\u001e\u0010F\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bÕ\u0001\u0010\\\u001a\u0005\bÖ\u0001\u0010uR \u0010G\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b×\u0001\u0010\\\u001a\u0005\bØ\u0001\u0010|R \u0010H\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bÙ\u0001\u0010\\\u001a\u0005\bÚ\u0001\u0010|R \u0010I\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bÛ\u0001\u0010\\\u001a\u0005\bÜ\u0001\u0010|R\u0015\u0010O\u001a\u00020\u0003X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bÝ\u0001\u0010^R\u0017\u0010P\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bÞ\u0001\u0010|R\u0017\u0010Q\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bß\u0001\u0010|R\u0017\u0010R\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bà\u0001\u0010|R\u0015\u0010S\u001a\u00020\u0003X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bá\u0001\u0010^R\u0018\u0010T\u001a\u0004\u0018\u00010UX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bâ\u0001\u0010ã\u0001R\u0018\u0010V\u001a\u0004\u0018\u00010WX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bä\u0001\u0010å\u0001¨\u0006ð\u0001"}, d2 = {"Lkntr/app/ad/common/model/AdInfoExtra;", "Lkntr/app/ad/common/protocol/IExtraInfo;", "useAdWebV2", RoomRecommendViewModel.EMPTY_CURSOR, "showUrls", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "clickUrls", "dmListShowUrls", "dmListClickUrls", "dmDetailShowUrls", "dmTrolleyAddUrls", "downloadWhitelist", "Lkntr/app/ad/common/model/AdWhiteApk;", "openWhitelist", "card", "Lkntr/app/ad/common/model/AdInfoCard;", "reportTime", RoomRecommendViewModel.EMPTY_CURSOR, "salesType", "specialIndustry", "specialIndustryTips", "specialIndustryStyle", "enableH5Alert", "externalLinkWarning", "preloadLandingPage", "enableH5PreLoad", "h5PreLoadUrl", "enableAutoCallUp", "enableDownloadDialog", "enableShare", "shareInfo", "Lkntr/app/ad/common/model/AdShareInfo;", "upZoneEntranceType", "upZoneEntranceReportId", "trackId", "liveTrackId", "upMid", RoomRecommendViewModel.EMPTY_CURSOR, "shopId", "storeDirectLaunch", "productId", "enableDoubleJump", "show1sUrls", "fromTrackId", "landingPageDownloadStyle", "downloadUrlType", "enableMarketDownloadWhenFirstJump", "tabUrl", "macroReplacePriority", "feedbackPanelStyle", "adContentType", "isDanmukuOpened", "cmFromTrackId", "commentToastOpen", "commentToast", "Lkntr/app/ad/common/model/AdCommentToast;", "ocpxTargetType", "abtest", "splashTouch", "Lkntr/app/ad/common/model/AdTouchReport;", "liveBookingId", "marketDownloadUrlXM", "topLiveStayTimeSeconds", "isMallPreloadSupported", "topAvatarShow", "lotteryId", "enableOpenApkDialog", "liveBookingInfos", "Lkntr/app/ad/common/model/AdLiveBookInfo;", "userCancelJumpType", "userCancelJumpUrl", "disableComponentClickUrl", "appExpParams", "<init>", "(ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkntr/app/ad/common/model/AdInfoCard;IIZLjava/lang/String;IZLjava/lang/String;IILjava/lang/String;IZZLkntr/app/ad/common/model/AdShareInfo;IILjava/lang/String;Ljava/lang/String;JJIJZLjava/util/List;Ljava/lang/String;IIZLjava/lang/String;IIIZLjava/lang/String;ILkntr/app/ad/common/model/AdCommentToast;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdTouchReport;JLjava/lang/String;IIZJZLjava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "seen1", "seen2", "enableMarketDownload", "callUpUrl", "jumpUrl", "callUpCancelUrl", "enableCallUpCancelToH5", "wxProgramInfo", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "button", "Lkntr/app/ad/common/model/AdButton;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkntr/app/ad/common/model/AdInfoCard;IIZLjava/lang/String;IZLjava/lang/String;IILjava/lang/String;IZZLkntr/app/ad/common/model/AdShareInfo;IILjava/lang/String;Ljava/lang/String;JJIJZLjava/util/List;Ljava/lang/String;IIZLjava/lang/String;IIIZLjava/lang/String;ILkntr/app/ad/common/model/AdCommentToast;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdTouchReport;JLjava/lang/String;IIZJZLjava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkntr/app/ad/common/model/AdWxProgramInfo;Lkntr/app/ad/common/model/AdButton;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUseAdWebV2$annotations", "()V", "getUseAdWebV2", "()Z", "getShowUrls$annotations", "getShowUrls", "()Ljava/util/List;", "getClickUrls$annotations", "getClickUrls", "getDmListShowUrls$annotations", "getDmListShowUrls", "getDmListClickUrls$annotations", "getDmListClickUrls", "getDmDetailShowUrls$annotations", "getDmDetailShowUrls", "getDmTrolleyAddUrls$annotations", "getDmTrolleyAddUrls", "getDownloadWhitelist$annotations", "getDownloadWhitelist", "getOpenWhitelist$annotations", "getOpenWhitelist", "getCard$annotations", "getCard", "()Lkntr/app/ad/common/model/AdInfoCard;", "getReportTime$annotations", "getReportTime", "()I", "getSalesType$annotations", "getSalesType", "getSpecialIndustry$annotations", "getSpecialIndustry", "getSpecialIndustryTips$annotations", "getSpecialIndustryTips", "()Ljava/lang/String;", "getSpecialIndustryStyle$annotations", "getSpecialIndustryStyle", "getEnableH5Alert$annotations", "getEnableH5Alert", "getExternalLinkWarning$annotations", "getExternalLinkWarning", "getPreloadLandingPage$annotations", "getPreloadLandingPage", "getEnableH5PreLoad$annotations", "getEnableH5PreLoad", "getH5PreLoadUrl$annotations", "getH5PreLoadUrl", "getEnableAutoCallUp$annotations", "getEnableAutoCallUp", "getEnableDownloadDialog$annotations", "getEnableDownloadDialog", "getEnableShare$annotations", "getEnableShare", "getShareInfo$annotations", "getShareInfo", "()Lkntr/app/ad/common/model/AdShareInfo;", "getUpZoneEntranceType$annotations", "getUpZoneEntranceType", "getUpZoneEntranceReportId$annotations", "getUpZoneEntranceReportId", "getTrackId$annotations", "getTrackId", "getLiveTrackId$annotations", "getLiveTrackId", "getUpMid$annotations", "getUpMid", "()J", "getShopId$annotations", "getShopId", "getStoreDirectLaunch$annotations", "getStoreDirectLaunch", "getProductId$annotations", "getProductId", "getEnableDoubleJump$annotations", "getEnableDoubleJump", "getShow1sUrls$annotations", "getShow1sUrls", "getFromTrackId$annotations", "getFromTrackId", "getLandingPageDownloadStyle$annotations", "getLandingPageDownloadStyle", "getDownloadUrlType$annotations", "getDownloadUrlType", "getEnableMarketDownloadWhenFirstJump$annotations", "getEnableMarketDownloadWhenFirstJump", "getTabUrl$annotations", "getTabUrl", "getMacroReplacePriority$annotations", "getMacroReplacePriority", "getFeedbackPanelStyle$annotations", "getFeedbackPanelStyle", "getAdContentType$annotations", "getAdContentType", "isDanmukuOpened$annotations", "getCmFromTrackId$annotations", "getCmFromTrackId", "getCommentToastOpen$annotations", "getCommentToastOpen", "getCommentToast$annotations", "getCommentToast", "()Lkntr/app/ad/common/model/AdCommentToast;", "getOcpxTargetType$annotations", "getOcpxTargetType", "getAbtest$annotations", "getAbtest", "getSplashTouch$annotations", "getSplashTouch", "()Lkntr/app/ad/common/model/AdTouchReport;", "getLiveBookingId$annotations", "getLiveBookingId", "getMarketDownloadUrlXM$annotations", "getMarketDownloadUrlXM", "getTopLiveStayTimeSeconds$annotations", "getTopLiveStayTimeSeconds", "isMallPreloadSupported$annotations", "getTopAvatarShow$annotations", "getTopAvatarShow", "getLotteryId$annotations", "getLotteryId", "getEnableOpenApkDialog$annotations", "getEnableOpenApkDialog", "getLiveBookingInfos$annotations", "getLiveBookingInfos", "getUserCancelJumpType$annotations", "getUserCancelJumpType", "getUserCancelJumpUrl$annotations", "getUserCancelJumpUrl", "getDisableComponentClickUrl$annotations", "getDisableComponentClickUrl", "getAppExpParams$annotations", "getAppExpParams", "getEnableMarketDownload", "getCallUpUrl", "getJumpUrl", "getCallUpCancelUrl", "getEnableCallUpCancelToH5", "getWxProgramInfo", "()Lkntr/app/ad/common/model/AdWxProgramInfo;", "getButton", "()Lkntr/app/ad/common/model/AdButton;", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdInfoExtra implements IExtraInfo {
    private final String abtest;
    private final int adContentType;
    private final String appExpParams;
    private final AdButton button;
    private final String callUpCancelUrl;
    private final String callUpUrl;
    private final AdInfoCard card;
    private final List<String> clickUrls;
    private final String cmFromTrackId;
    private final AdCommentToast commentToast;
    private final int commentToastOpen;
    private final String disableComponentClickUrl;
    private final List<String> dmDetailShowUrls;
    private final List<String> dmListClickUrls;
    private final List<String> dmListShowUrls;
    private final List<String> dmTrolleyAddUrls;
    private final int downloadUrlType;
    private final List<AdWhiteApk> downloadWhitelist;
    private final int enableAutoCallUp;
    private final boolean enableCallUpCancelToH5;
    private final boolean enableDoubleJump;
    private final boolean enableDownloadDialog;
    private final boolean enableH5Alert;
    private final int enableH5PreLoad;
    private final boolean enableMarketDownload;
    private final boolean enableMarketDownloadWhenFirstJump;
    private final boolean enableOpenApkDialog;
    private final boolean enableShare;
    private final String externalLinkWarning;
    private final int feedbackPanelStyle;
    private final String fromTrackId;
    private final String h5PreLoadUrl;
    private final boolean isDanmukuOpened;
    private final int isMallPreloadSupported;
    private final String jumpUrl;
    private final int landingPageDownloadStyle;
    private final long liveBookingId;
    private final List<AdLiveBookInfo> liveBookingInfos;
    private final String liveTrackId;
    private final long lotteryId;
    private final int macroReplacePriority;
    private final String marketDownloadUrlXM;
    private final String ocpxTargetType;
    private final List<String> openWhitelist;
    private final int preloadLandingPage;
    private final long productId;
    private final int reportTime;
    private final int salesType;
    private final AdShareInfo shareInfo;
    private final long shopId;
    private final List<String> show1sUrls;
    private final List<String> showUrls;
    private final boolean specialIndustry;
    private final int specialIndustryStyle;
    private final String specialIndustryTips;
    private final AdTouchReport splashTouch;
    private final int storeDirectLaunch;
    private final String tabUrl;
    private final boolean topAvatarShow;
    private final int topLiveStayTimeSeconds;
    private final String trackId;
    private final long upMid;
    private final int upZoneEntranceReportId;
    private final int upZoneEntranceType;
    private final boolean useAdWebV2;
    private final int userCancelJumpType;
    private final String userCancelJumpUrl;
    private final AdWxProgramInfo wxProgramInfo;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdInfoExtra$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdInfoExtra._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdInfoExtra$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = AdInfoExtra._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdInfoExtra$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = AdInfoExtra._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdInfoExtra$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = AdInfoExtra._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdInfoExtra$$ExternalSyntheticLambda4
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$3;
            _childSerializers$_anonymous_$3 = AdInfoExtra._childSerializers$_anonymous_$3();
            return _childSerializers$_anonymous_$3;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdInfoExtra$$ExternalSyntheticLambda5
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$4;
            _childSerializers$_anonymous_$4 = AdInfoExtra._childSerializers$_anonymous_$4();
            return _childSerializers$_anonymous_$4;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdInfoExtra$$ExternalSyntheticLambda6
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$5;
            _childSerializers$_anonymous_$5 = AdInfoExtra._childSerializers$_anonymous_$5();
            return _childSerializers$_anonymous_$5;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdInfoExtra$$ExternalSyntheticLambda7
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$6;
            _childSerializers$_anonymous_$6 = AdInfoExtra._childSerializers$_anonymous_$6();
            return _childSerializers$_anonymous_$6;
        }
    }), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdInfoExtra$$ExternalSyntheticLambda8
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$7;
            _childSerializers$_anonymous_$7 = AdInfoExtra._childSerializers$_anonymous_$7();
            return _childSerializers$_anonymous_$7;
        }
    }), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdInfoExtra$$ExternalSyntheticLambda9
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$8;
            _childSerializers$_anonymous_$8 = AdInfoExtra._childSerializers$_anonymous_$8();
            return _childSerializers$_anonymous_$8;
        }
    }), null, null, null, null, null, null, null, null, null, null, null};

    public AdInfoExtra() {
        this(false, null, null, null, null, null, null, null, null, null, 0, 0, false, null, 0, false, null, 0, 0, null, 0, false, false, null, 0, 0, null, null, 0L, 0L, 0, 0L, false, null, null, 0, 0, false, null, 0, 0, 0, false, null, 0, null, null, null, null, 0L, null, 0, 0, false, 0L, false, null, 0, null, null, null, -1, 536870911, null);
    }

    @SerialName("abtest")
    public static /* synthetic */ void getAbtest$annotations() {
    }

    @SerialName("ad_content_type")
    public static /* synthetic */ void getAdContentType$annotations() {
    }

    @SerialName("app_exp_params")
    public static /* synthetic */ void getAppExpParams$annotations() {
    }

    @SerialName("card")
    public static /* synthetic */ void getCard$annotations() {
    }

    @SerialName(SubmitActionFrom.MMA_KEY_CLICK_URLS)
    public static /* synthetic */ void getClickUrls$annotations() {
    }

    @SerialName("cm_from_track_id")
    public static /* synthetic */ void getCmFromTrackId$annotations() {
    }

    @SerialName("comment_toast")
    public static /* synthetic */ void getCommentToast$annotations() {
    }

    @SerialName("comment_toast_open")
    public static /* synthetic */ void getCommentToastOpen$annotations() {
    }

    @SerialName("disable_component_click_url")
    public static /* synthetic */ void getDisableComponentClickUrl$annotations() {
    }

    @SerialName("danmu_detail_show_urls")
    public static /* synthetic */ void getDmDetailShowUrls$annotations() {
    }

    @SerialName("danmu_list_click_urls")
    public static /* synthetic */ void getDmListClickUrls$annotations() {
    }

    @SerialName("danmu_list_show_urls")
    public static /* synthetic */ void getDmListShowUrls$annotations() {
    }

    @SerialName("danmu_trolley_add_urls")
    public static /* synthetic */ void getDmTrolleyAddUrls$annotations() {
    }

    @SerialName("download_url_type")
    public static /* synthetic */ void getDownloadUrlType$annotations() {
    }

    @SerialName("download_whitelist")
    public static /* synthetic */ void getDownloadWhitelist$annotations() {
    }

    @SerialName("enable_auto_callup")
    public static /* synthetic */ void getEnableAutoCallUp$annotations() {
    }

    @SerialName("enable_double_jump")
    public static /* synthetic */ void getEnableDoubleJump$annotations() {
    }

    @SerialName("enable_download_dialog")
    public static /* synthetic */ void getEnableDownloadDialog$annotations() {
    }

    @SerialName("enable_h5_alert")
    public static /* synthetic */ void getEnableH5Alert$annotations() {
    }

    @SerialName("enable_h5_pre_load")
    public static /* synthetic */ void getEnableH5PreLoad$annotations() {
    }

    @SerialName("store_callup_card")
    public static /* synthetic */ void getEnableMarketDownloadWhenFirstJump$annotations() {
    }

    @SerialName("enable_openapk_dialog")
    public static /* synthetic */ void getEnableOpenApkDialog$annotations() {
    }

    @SerialName("enable_share")
    public static /* synthetic */ void getEnableShare$annotations() {
    }

    @SerialName("external_link_warning")
    public static /* synthetic */ void getExternalLinkWarning$annotations() {
    }

    @SerialName("feedback_panel_style")
    public static /* synthetic */ void getFeedbackPanelStyle$annotations() {
    }

    @SerialName(ReportBuildInParam.FROM_TRACK_ID)
    public static /* synthetic */ void getFromTrackId$annotations() {
    }

    @SerialName("h5_pre_load_url")
    public static /* synthetic */ void getH5PreLoadUrl$annotations() {
    }

    @SerialName("landingpage_download_style")
    public static /* synthetic */ void getLandingPageDownloadStyle$annotations() {
    }

    @SerialName("live_booking_id")
    public static /* synthetic */ void getLiveBookingId$annotations() {
    }

    @SerialName("live_booking_infos")
    public static /* synthetic */ void getLiveBookingInfos$annotations() {
    }

    @SerialName("live_track_id")
    public static /* synthetic */ void getLiveTrackId$annotations() {
    }

    @SerialName("lottery_id")
    public static /* synthetic */ void getLotteryId$annotations() {
    }

    @SerialName("macro_replace_priority")
    public static /* synthetic */ void getMacroReplacePriority$annotations() {
    }

    @SerialName("store_dplink_xiaomi")
    public static /* synthetic */ void getMarketDownloadUrlXM$annotations() {
    }

    @SerialName("ocpx_target_type")
    public static /* synthetic */ void getOcpxTargetType$annotations() {
    }

    @SerialName("open_whitelist")
    public static /* synthetic */ void getOpenWhitelist$annotations() {
    }

    @SerialName("preload_landingpage")
    public static /* synthetic */ void getPreloadLandingPage$annotations() {
    }

    @SerialName(ReportBuildInParam.PRODUCT_ID)
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName("report_time")
    public static /* synthetic */ void getReportTime$annotations() {
    }

    @SerialName("sales_type")
    public static /* synthetic */ void getSalesType$annotations() {
    }

    @SerialName("share_info")
    public static /* synthetic */ void getShareInfo$annotations() {
    }

    @SerialName(ReportBuildInParam.SHOP_ID)
    public static /* synthetic */ void getShopId$annotations() {
    }

    @SerialName(SubmitActionFrom.MMA_KEY_SHOW_1S_URLS)
    public static /* synthetic */ void getShow1sUrls$annotations() {
    }

    @SerialName(SubmitActionFrom.MMA_KEY_SHOW_URLS)
    public static /* synthetic */ void getShowUrls$annotations() {
    }

    @SerialName("special_industry")
    public static /* synthetic */ void getSpecialIndustry$annotations() {
    }

    @SerialName("special_industry_style")
    public static /* synthetic */ void getSpecialIndustryStyle$annotations() {
    }

    @SerialName("special_industry_tips")
    public static /* synthetic */ void getSpecialIndustryTips$annotations() {
    }

    @SerialName("splash_touch")
    public static /* synthetic */ void getSplashTouch$annotations() {
    }

    @SerialName("enable_store_direct_launch")
    public static /* synthetic */ void getStoreDirectLaunch$annotations() {
    }

    @SerialName("tab_url")
    public static /* synthetic */ void getTabUrl$annotations() {
    }

    @SerialName("top_avatar_show")
    public static /* synthetic */ void getTopAvatarShow$annotations() {
    }

    @SerialName("top_live_stay_time_seconds")
    public static /* synthetic */ void getTopLiveStayTimeSeconds$annotations() {
    }

    @SerialName("track_id")
    public static /* synthetic */ void getTrackId$annotations() {
    }

    @SerialName(ReportBuildInParam.UP_MID)
    public static /* synthetic */ void getUpMid$annotations() {
    }

    @SerialName("upzone_entrance_report_id")
    public static /* synthetic */ void getUpZoneEntranceReportId$annotations() {
    }

    @SerialName("upzone_entrance_type")
    public static /* synthetic */ void getUpZoneEntranceType$annotations() {
    }

    @SerialName("use_ad_web_v2")
    public static /* synthetic */ void getUseAdWebV2$annotations() {
    }

    @SerialName("user_cancel_jump_type")
    public static /* synthetic */ void getUserCancelJumpType$annotations() {
    }

    @SerialName("user_cancel_jump_url")
    public static /* synthetic */ void getUserCancelJumpUrl$annotations() {
    }

    @SerialName("enable_open_danmuku")
    public static /* synthetic */ void isDanmukuOpened$annotations() {
    }

    @SerialName("vipshop_fast_framework")
    public static /* synthetic */ void isMallPreloadSupported$annotations() {
    }

    /* compiled from: AdInfoExtra.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdInfoExtra$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdInfoExtra;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdInfoExtra> serializer() {
            return AdInfoExtra$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdInfoExtra(int seen0, int seen1, int seen2, boolean useAdWebV2, List showUrls, List clickUrls, List dmListShowUrls, List dmListClickUrls, List dmDetailShowUrls, List dmTrolleyAddUrls, List downloadWhitelist, List openWhitelist, AdInfoCard card, int reportTime, int salesType, boolean specialIndustry, String specialIndustryTips, int specialIndustryStyle, boolean enableH5Alert, String externalLinkWarning, int preloadLandingPage, int enableH5PreLoad, String h5PreLoadUrl, int enableAutoCallUp, boolean enableDownloadDialog, boolean enableShare, AdShareInfo shareInfo, int upZoneEntranceType, int upZoneEntranceReportId, String trackId, String liveTrackId, long upMid, long shopId, int storeDirectLaunch, long productId, boolean enableDoubleJump, List show1sUrls, String fromTrackId, int landingPageDownloadStyle, int downloadUrlType, boolean enableMarketDownloadWhenFirstJump, String tabUrl, int macroReplacePriority, int feedbackPanelStyle, int adContentType, boolean isDanmukuOpened, String cmFromTrackId, int commentToastOpen, AdCommentToast commentToast, String ocpxTargetType, String abtest, AdTouchReport splashTouch, long liveBookingId, String marketDownloadUrlXM, int topLiveStayTimeSeconds, int isMallPreloadSupported, boolean topAvatarShow, long lotteryId, boolean enableOpenApkDialog, List liveBookingInfos, int userCancelJumpType, String userCancelJumpUrl, String disableComponentClickUrl, String appExpParams, boolean enableMarketDownload, String callUpUrl, String jumpUrl, String callUpCancelUrl, boolean enableCallUpCancelToH5, AdWxProgramInfo wxProgramInfo, AdButton button, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.useAdWebV2 = false;
        } else {
            this.useAdWebV2 = useAdWebV2;
        }
        if ((seen0 & 2) == 0) {
            this.showUrls = null;
        } else {
            this.showUrls = showUrls;
        }
        if ((seen0 & 4) == 0) {
            this.clickUrls = null;
        } else {
            this.clickUrls = clickUrls;
        }
        if ((seen0 & 8) == 0) {
            this.dmListShowUrls = null;
        } else {
            this.dmListShowUrls = dmListShowUrls;
        }
        if ((seen0 & 16) == 0) {
            this.dmListClickUrls = null;
        } else {
            this.dmListClickUrls = dmListClickUrls;
        }
        if ((seen0 & 32) == 0) {
            this.dmDetailShowUrls = null;
        } else {
            this.dmDetailShowUrls = dmDetailShowUrls;
        }
        if ((seen0 & 64) == 0) {
            this.dmTrolleyAddUrls = null;
        } else {
            this.dmTrolleyAddUrls = dmTrolleyAddUrls;
        }
        if ((seen0 & 128) == 0) {
            this.downloadWhitelist = null;
        } else {
            this.downloadWhitelist = downloadWhitelist;
        }
        if ((seen0 & 256) == 0) {
            this.openWhitelist = null;
        } else {
            this.openWhitelist = openWhitelist;
        }
        if ((seen0 & 512) == 0) {
            this.card = null;
        } else {
            this.card = card;
        }
        if ((seen0 & 1024) == 0) {
            this.reportTime = 0;
        } else {
            this.reportTime = reportTime;
        }
        if ((seen0 & 2048) == 0) {
            this.salesType = 0;
        } else {
            this.salesType = salesType;
        }
        if ((seen0 & 4096) == 0) {
            this.specialIndustry = false;
        } else {
            this.specialIndustry = specialIndustry;
        }
        if ((seen0 & 8192) == 0) {
            this.specialIndustryTips = null;
        } else {
            this.specialIndustryTips = specialIndustryTips;
        }
        if ((seen0 & 16384) == 0) {
            this.specialIndustryStyle = 0;
        } else {
            this.specialIndustryStyle = specialIndustryStyle;
        }
        if ((seen0 & 32768) == 0) {
            this.enableH5Alert = false;
        } else {
            this.enableH5Alert = enableH5Alert;
        }
        if ((seen0 & 65536) == 0) {
            this.externalLinkWarning = null;
        } else {
            this.externalLinkWarning = externalLinkWarning;
        }
        if ((seen0 & 131072) == 0) {
            this.preloadLandingPage = 0;
        } else {
            this.preloadLandingPage = preloadLandingPage;
        }
        if ((seen0 & 262144) == 0) {
            this.enableH5PreLoad = 0;
        } else {
            this.enableH5PreLoad = enableH5PreLoad;
        }
        if ((seen0 & 524288) == 0) {
            this.h5PreLoadUrl = null;
        } else {
            this.h5PreLoadUrl = h5PreLoadUrl;
        }
        if ((seen0 & 1048576) == 0) {
            this.enableAutoCallUp = 0;
        } else {
            this.enableAutoCallUp = enableAutoCallUp;
        }
        if ((seen0 & 2097152) == 0) {
            this.enableDownloadDialog = false;
        } else {
            this.enableDownloadDialog = enableDownloadDialog;
        }
        if ((seen0 & 4194304) == 0) {
            this.enableShare = false;
        } else {
            this.enableShare = enableShare;
        }
        if ((seen0 & 8388608) == 0) {
            this.shareInfo = null;
        } else {
            this.shareInfo = shareInfo;
        }
        if ((seen0 & 16777216) == 0) {
            this.upZoneEntranceType = 0;
        } else {
            this.upZoneEntranceType = upZoneEntranceType;
        }
        if ((seen0 & 33554432) == 0) {
            this.upZoneEntranceReportId = 0;
        } else {
            this.upZoneEntranceReportId = upZoneEntranceReportId;
        }
        if ((seen0 & 67108864) == 0) {
            this.trackId = null;
        } else {
            this.trackId = trackId;
        }
        if ((seen0 & 134217728) == 0) {
            this.liveTrackId = null;
        } else {
            this.liveTrackId = liveTrackId;
        }
        if ((seen0 & 268435456) == 0) {
            this.upMid = 0L;
        } else {
            this.upMid = upMid;
        }
        if ((seen0 & 536870912) == 0) {
            this.shopId = 0L;
        } else {
            this.shopId = shopId;
        }
        if ((seen0 & 1073741824) == 0) {
            this.storeDirectLaunch = 0;
        } else {
            this.storeDirectLaunch = storeDirectLaunch;
        }
        if ((Integer.MIN_VALUE & seen0) == 0) {
            this.productId = 0L;
        } else {
            this.productId = productId;
        }
        if ((seen1 & 1) == 0) {
            this.enableDoubleJump = false;
        } else {
            this.enableDoubleJump = enableDoubleJump;
        }
        if ((seen1 & 2) == 0) {
            this.show1sUrls = null;
        } else {
            this.show1sUrls = show1sUrls;
        }
        if ((seen1 & 4) == 0) {
            this.fromTrackId = null;
        } else {
            this.fromTrackId = fromTrackId;
        }
        if ((seen1 & 8) == 0) {
            this.landingPageDownloadStyle = 0;
        } else {
            this.landingPageDownloadStyle = landingPageDownloadStyle;
        }
        if ((seen1 & 16) == 0) {
            this.downloadUrlType = 0;
        } else {
            this.downloadUrlType = downloadUrlType;
        }
        if ((seen1 & 32) == 0) {
            this.enableMarketDownloadWhenFirstJump = false;
        } else {
            this.enableMarketDownloadWhenFirstJump = enableMarketDownloadWhenFirstJump;
        }
        if ((seen1 & 64) == 0) {
            this.tabUrl = null;
        } else {
            this.tabUrl = tabUrl;
        }
        if ((seen1 & 128) == 0) {
            this.macroReplacePriority = 0;
        } else {
            this.macroReplacePriority = macroReplacePriority;
        }
        if ((seen1 & 256) == 0) {
            this.feedbackPanelStyle = 0;
        } else {
            this.feedbackPanelStyle = feedbackPanelStyle;
        }
        if ((seen1 & 512) == 0) {
            this.adContentType = 0;
        } else {
            this.adContentType = adContentType;
        }
        if ((seen1 & 1024) == 0) {
            this.isDanmukuOpened = false;
        } else {
            this.isDanmukuOpened = isDanmukuOpened;
        }
        if ((seen1 & 2048) == 0) {
            this.cmFromTrackId = null;
        } else {
            this.cmFromTrackId = cmFromTrackId;
        }
        if ((seen1 & 4096) == 0) {
            this.commentToastOpen = 0;
        } else {
            this.commentToastOpen = commentToastOpen;
        }
        if ((seen1 & 8192) == 0) {
            this.commentToast = null;
        } else {
            this.commentToast = commentToast;
        }
        if ((seen1 & 16384) == 0) {
            this.ocpxTargetType = null;
        } else {
            this.ocpxTargetType = ocpxTargetType;
        }
        if ((seen1 & 32768) == 0) {
            this.abtest = null;
        } else {
            this.abtest = abtest;
        }
        if ((seen1 & 65536) == 0) {
            this.splashTouch = null;
        } else {
            this.splashTouch = splashTouch;
        }
        if ((seen1 & 131072) == 0) {
            this.liveBookingId = 0L;
        } else {
            this.liveBookingId = liveBookingId;
        }
        if ((seen1 & 262144) == 0) {
            this.marketDownloadUrlXM = null;
        } else {
            this.marketDownloadUrlXM = marketDownloadUrlXM;
        }
        if ((seen1 & 524288) == 0) {
            this.topLiveStayTimeSeconds = 0;
        } else {
            this.topLiveStayTimeSeconds = topLiveStayTimeSeconds;
        }
        if ((seen1 & 1048576) == 0) {
            this.isMallPreloadSupported = 0;
        } else {
            this.isMallPreloadSupported = isMallPreloadSupported;
        }
        if ((seen1 & 2097152) == 0) {
            this.topAvatarShow = false;
        } else {
            this.topAvatarShow = topAvatarShow;
        }
        if ((seen1 & 4194304) == 0) {
            this.lotteryId = 0L;
        } else {
            this.lotteryId = lotteryId;
        }
        if ((seen1 & 8388608) == 0) {
            this.enableOpenApkDialog = false;
        } else {
            this.enableOpenApkDialog = enableOpenApkDialog;
        }
        if ((seen1 & 16777216) == 0) {
            this.liveBookingInfos = null;
        } else {
            this.liveBookingInfos = liveBookingInfos;
        }
        if ((seen1 & 33554432) == 0) {
            this.userCancelJumpType = 0;
        } else {
            this.userCancelJumpType = userCancelJumpType;
        }
        if ((seen1 & 67108864) == 0) {
            this.userCancelJumpUrl = null;
        } else {
            this.userCancelJumpUrl = userCancelJumpUrl;
        }
        if ((seen1 & 134217728) == 0) {
            this.disableComponentClickUrl = null;
        } else {
            this.disableComponentClickUrl = disableComponentClickUrl;
        }
        if ((seen1 & 268435456) == 0) {
            this.appExpParams = null;
        } else {
            this.appExpParams = appExpParams;
        }
        if ((seen1 & 536870912) == 0) {
            this.enableMarketDownload = getStoreDirectLaunch() == 1;
        } else {
            this.enableMarketDownload = enableMarketDownload;
        }
        if ((1073741824 & seen1) == 0) {
            AdInfoCard card2 = getCard();
            this.callUpUrl = card2 != null ? card2.getCallUpUrl() : null;
        } else {
            this.callUpUrl = callUpUrl;
        }
        if ((seen1 & Integer.MIN_VALUE) == 0) {
            AdInfoCard card3 = getCard();
            this.jumpUrl = card3 != null ? card3.getJumpUrl() : null;
        } else {
            this.jumpUrl = jumpUrl;
        }
        if ((seen2 & 1) == 0) {
            this.callUpCancelUrl = getUserCancelJumpUrl();
        } else {
            this.callUpCancelUrl = callUpCancelUrl;
        }
        if ((seen2 & 2) == 0) {
            this.enableCallUpCancelToH5 = getUserCancelJumpType() == 1;
        } else {
            this.enableCallUpCancelToH5 = enableCallUpCancelToH5;
        }
        if ((seen2 & 4) == 0) {
            AdInfoCard card4 = getCard();
            this.wxProgramInfo = card4 != null ? card4.getWxProgramInfo() : null;
        } else {
            this.wxProgramInfo = wxProgramInfo;
        }
        if ((seen2 & 8) != 0) {
            this.button = button;
            return;
        }
        AdInfoCard card5 = getCard();
        this.button = card5 != null ? card5.getButton() : null;
    }

    public AdInfoExtra(boolean useAdWebV2, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<AdWhiteApk> list7, List<String> list8, AdInfoCard card, int reportTime, int salesType, boolean specialIndustry, String specialIndustryTips, int specialIndustryStyle, boolean enableH5Alert, String externalLinkWarning, int preloadLandingPage, int enableH5PreLoad, String h5PreLoadUrl, int enableAutoCallUp, boolean enableDownloadDialog, boolean enableShare, AdShareInfo shareInfo, int upZoneEntranceType, int upZoneEntranceReportId, String trackId, String liveTrackId, long upMid, long shopId, int storeDirectLaunch, long productId, boolean enableDoubleJump, List<String> list9, String fromTrackId, int landingPageDownloadStyle, int downloadUrlType, boolean enableMarketDownloadWhenFirstJump, String tabUrl, int macroReplacePriority, int feedbackPanelStyle, int adContentType, boolean isDanmukuOpened, String cmFromTrackId, int commentToastOpen, AdCommentToast commentToast, String ocpxTargetType, String abtest, AdTouchReport splashTouch, long liveBookingId, String marketDownloadUrlXM, int topLiveStayTimeSeconds, int isMallPreloadSupported, boolean topAvatarShow, long lotteryId, boolean enableOpenApkDialog, List<AdLiveBookInfo> list10, int userCancelJumpType, String userCancelJumpUrl, String disableComponentClickUrl, String appExpParams) {
        this.useAdWebV2 = useAdWebV2;
        this.showUrls = list;
        this.clickUrls = list2;
        this.dmListShowUrls = list3;
        this.dmListClickUrls = list4;
        this.dmDetailShowUrls = list5;
        this.dmTrolleyAddUrls = list6;
        this.downloadWhitelist = list7;
        this.openWhitelist = list8;
        this.card = card;
        this.reportTime = reportTime;
        this.salesType = salesType;
        this.specialIndustry = specialIndustry;
        this.specialIndustryTips = specialIndustryTips;
        this.specialIndustryStyle = specialIndustryStyle;
        this.enableH5Alert = enableH5Alert;
        this.externalLinkWarning = externalLinkWarning;
        this.preloadLandingPage = preloadLandingPage;
        this.enableH5PreLoad = enableH5PreLoad;
        this.h5PreLoadUrl = h5PreLoadUrl;
        this.enableAutoCallUp = enableAutoCallUp;
        this.enableDownloadDialog = enableDownloadDialog;
        this.enableShare = enableShare;
        this.shareInfo = shareInfo;
        this.upZoneEntranceType = upZoneEntranceType;
        this.upZoneEntranceReportId = upZoneEntranceReportId;
        this.trackId = trackId;
        this.liveTrackId = liveTrackId;
        this.upMid = upMid;
        this.shopId = shopId;
        this.storeDirectLaunch = storeDirectLaunch;
        this.productId = productId;
        this.enableDoubleJump = enableDoubleJump;
        this.show1sUrls = list9;
        this.fromTrackId = fromTrackId;
        this.landingPageDownloadStyle = landingPageDownloadStyle;
        this.downloadUrlType = downloadUrlType;
        this.enableMarketDownloadWhenFirstJump = enableMarketDownloadWhenFirstJump;
        this.tabUrl = tabUrl;
        this.macroReplacePriority = macroReplacePriority;
        this.feedbackPanelStyle = feedbackPanelStyle;
        this.adContentType = adContentType;
        this.isDanmukuOpened = isDanmukuOpened;
        this.cmFromTrackId = cmFromTrackId;
        this.commentToastOpen = commentToastOpen;
        this.commentToast = commentToast;
        this.ocpxTargetType = ocpxTargetType;
        this.abtest = abtest;
        this.splashTouch = splashTouch;
        this.liveBookingId = liveBookingId;
        this.marketDownloadUrlXM = marketDownloadUrlXM;
        this.topLiveStayTimeSeconds = topLiveStayTimeSeconds;
        this.isMallPreloadSupported = isMallPreloadSupported;
        this.topAvatarShow = topAvatarShow;
        this.lotteryId = lotteryId;
        this.enableOpenApkDialog = enableOpenApkDialog;
        this.liveBookingInfos = list10;
        this.userCancelJumpType = userCancelJumpType;
        this.userCancelJumpUrl = userCancelJumpUrl;
        this.disableComponentClickUrl = disableComponentClickUrl;
        this.appExpParams = appExpParams;
        this.enableMarketDownload = getStoreDirectLaunch() == 1;
        AdInfoCard card2 = getCard();
        this.callUpUrl = card2 != null ? card2.getCallUpUrl() : null;
        AdInfoCard card3 = getCard();
        this.jumpUrl = card3 != null ? card3.getJumpUrl() : null;
        this.callUpCancelUrl = getUserCancelJumpUrl();
        this.enableCallUpCancelToH5 = getUserCancelJumpType() == 1;
        AdInfoCard card4 = getCard();
        this.wxProgramInfo = card4 != null ? card4.getWxProgramInfo() : null;
        AdInfoCard card5 = getCard();
        this.button = card5 != null ? card5.getButton() : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdWhiteApk$$serializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$6() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$7() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$8() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdLiveBookInfo$$serializer.INSTANCE));
    }

    /* JADX WARN: Code restructure failed: missing block: B:630:0x089f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r4 != null ? r4.getButton() : null) == false) goto L338;
     */
    /* JADX WARN: Removed duplicated region for block: B:562:0x078d  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x07a1  */
    /* JADX WARN: Removed duplicated region for block: B:575:0x07bd  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:588:0x07f0  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x0807  */
    /* JADX WARN: Removed duplicated region for block: B:597:0x0819  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x0830  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x0845  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0858  */
    /* JADX WARN: Removed duplicated region for block: B:622:0x0874  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x088b  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x08a4  */
    /* JADX WARN: Removed duplicated region for block: B:635:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void write$Self$dto_debug(AdInfoExtra self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        boolean z6 = false;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getUseAdWebV2()) {
            output.encodeBooleanElement(serialDesc, 0, self.getUseAdWebV2());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getShowUrls() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.getShowUrls());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getClickUrls() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.getClickUrls());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.getDmListShowUrls() != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.getDmListShowUrls());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.getDmListClickUrls() != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.getDmListClickUrls());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.getDmDetailShowUrls() != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.getDmDetailShowUrls());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.getDmTrolleyAddUrls() != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.getDmTrolleyAddUrls());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.getDownloadWhitelist() != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.getDownloadWhitelist());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.getOpenWhitelist() != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) lazyArr[8].getValue(), self.getOpenWhitelist());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.getCard() != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, AdInfoCard$$serializer.INSTANCE, self.getCard());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.getReportTime() != 0) {
            output.encodeIntElement(serialDesc, 10, self.getReportTime());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.getSalesType() != 0) {
            output.encodeIntElement(serialDesc, 11, self.getSalesType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.getSpecialIndustry()) {
            output.encodeBooleanElement(serialDesc, 12, self.getSpecialIndustry());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.getSpecialIndustryTips() != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.getSpecialIndustryTips());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.getSpecialIndustryStyle() != 0) {
            output.encodeIntElement(serialDesc, 14, self.getSpecialIndustryStyle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.getEnableH5Alert()) {
            output.encodeBooleanElement(serialDesc, 15, self.getEnableH5Alert());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.getExternalLinkWarning() != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.getExternalLinkWarning());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.getPreloadLandingPage() != 0) {
            output.encodeIntElement(serialDesc, 17, self.getPreloadLandingPage());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.getEnableH5PreLoad() != 0) {
            output.encodeIntElement(serialDesc, 18, self.getEnableH5PreLoad());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.getH5PreLoadUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.getH5PreLoadUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.getEnableAutoCallUp() != 0) {
            output.encodeIntElement(serialDesc, 20, self.getEnableAutoCallUp());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.getEnableDownloadDialog()) {
            output.encodeBooleanElement(serialDesc, 21, self.getEnableDownloadDialog());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.getEnableShare()) {
            output.encodeBooleanElement(serialDesc, 22, self.getEnableShare());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.getShareInfo() != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, AdShareInfo$$serializer.INSTANCE, self.getShareInfo());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.getUpZoneEntranceType() != 0) {
            output.encodeIntElement(serialDesc, 24, self.getUpZoneEntranceType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || self.getUpZoneEntranceReportId() != 0) {
            output.encodeIntElement(serialDesc, 25, self.getUpZoneEntranceReportId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.getTrackId() != null) {
            output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.getTrackId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.getLiveTrackId() != null) {
            output.encodeNullableSerializableElement(serialDesc, 27, StringSerializer.INSTANCE, self.getLiveTrackId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || self.getUpMid() != 0) {
            output.encodeLongElement(serialDesc, 28, self.getUpMid());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.getShopId() != 0) {
            output.encodeLongElement(serialDesc, 29, self.getShopId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.getStoreDirectLaunch() != 0) {
            output.encodeIntElement(serialDesc, 30, self.getStoreDirectLaunch());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.getProductId() != 0) {
            output.encodeLongElement(serialDesc, 31, self.getProductId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.getEnableDoubleJump()) {
            output.encodeBooleanElement(serialDesc, 32, self.getEnableDoubleJump());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 33) || self.getShow1sUrls() != null) {
            output.encodeNullableSerializableElement(serialDesc, 33, (SerializationStrategy) lazyArr[33].getValue(), self.getShow1sUrls());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 34) || self.getFromTrackId() != null) {
            output.encodeNullableSerializableElement(serialDesc, 34, StringSerializer.INSTANCE, self.getFromTrackId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 35) || self.getLandingPageDownloadStyle() != 0) {
            output.encodeIntElement(serialDesc, 35, self.getLandingPageDownloadStyle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 36) || self.getDownloadUrlType() != 0) {
            output.encodeIntElement(serialDesc, 36, self.getDownloadUrlType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 37) || self.getEnableMarketDownloadWhenFirstJump()) {
            output.encodeBooleanElement(serialDesc, 37, self.getEnableMarketDownloadWhenFirstJump());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 38) || self.getTabUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 38, StringSerializer.INSTANCE, self.getTabUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 39) || self.getMacroReplacePriority() != 0) {
            output.encodeIntElement(serialDesc, 39, self.getMacroReplacePriority());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 40) || self.getFeedbackPanelStyle() != 0) {
            output.encodeIntElement(serialDesc, 40, self.getFeedbackPanelStyle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 41) || self.getAdContentType() != 0) {
            output.encodeIntElement(serialDesc, 41, self.getAdContentType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 42) || self.isDanmukuOpened()) {
            output.encodeBooleanElement(serialDesc, 42, self.isDanmukuOpened());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 43) || self.getCmFromTrackId() != null) {
            output.encodeNullableSerializableElement(serialDesc, 43, StringSerializer.INSTANCE, self.getCmFromTrackId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 44) || self.getCommentToastOpen() != 0) {
            output.encodeIntElement(serialDesc, 44, self.getCommentToastOpen());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 45) || self.getCommentToast() != null) {
            output.encodeNullableSerializableElement(serialDesc, 45, AdCommentToast$$serializer.INSTANCE, self.getCommentToast());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 46) || self.getOcpxTargetType() != null) {
            output.encodeNullableSerializableElement(serialDesc, 46, StringSerializer.INSTANCE, self.getOcpxTargetType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 47) || self.getAbtest() != null) {
            output.encodeNullableSerializableElement(serialDesc, 47, StringSerializer.INSTANCE, self.getAbtest());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 48) || self.getSplashTouch() != null) {
            output.encodeNullableSerializableElement(serialDesc, 48, AdTouchReport$$serializer.INSTANCE, self.getSplashTouch());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 49) || self.getLiveBookingId() != 0) {
            output.encodeLongElement(serialDesc, 49, self.getLiveBookingId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 50) || self.getMarketDownloadUrlXM() != null) {
            output.encodeNullableSerializableElement(serialDesc, 50, StringSerializer.INSTANCE, self.getMarketDownloadUrlXM());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 51) || self.getTopLiveStayTimeSeconds() != 0) {
            output.encodeIntElement(serialDesc, 51, self.getTopLiveStayTimeSeconds());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 52) || self.isMallPreloadSupported() != 0) {
            output.encodeIntElement(serialDesc, 52, self.isMallPreloadSupported());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 53) || self.getTopAvatarShow()) {
            output.encodeBooleanElement(serialDesc, 53, self.getTopAvatarShow());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 54) || self.getLotteryId() != 0) {
            output.encodeLongElement(serialDesc, 54, self.getLotteryId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 55) || self.getEnableOpenApkDialog()) {
            output.encodeBooleanElement(serialDesc, 55, self.getEnableOpenApkDialog());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 56) || self.getLiveBookingInfos() != null) {
            output.encodeNullableSerializableElement(serialDesc, 56, (SerializationStrategy) lazyArr[56].getValue(), self.getLiveBookingInfos());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 57) || self.getUserCancelJumpType() != 0) {
            output.encodeIntElement(serialDesc, 57, self.getUserCancelJumpType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 58) || self.getUserCancelJumpUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 58, StringSerializer.INSTANCE, self.getUserCancelJumpUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 59) || self.getDisableComponentClickUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 59, StringSerializer.INSTANCE, self.getDisableComponentClickUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 60) || self.getAppExpParams() != null) {
            output.encodeNullableSerializableElement(serialDesc, 60, StringSerializer.INSTANCE, self.getAppExpParams());
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 61)) {
            if (self.getEnableMarketDownload() == (self.getStoreDirectLaunch() == 1)) {
                z = false;
                if (z) {
                    output.encodeBooleanElement(serialDesc, 61, self.getEnableMarketDownload());
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 62)) {
                    String callUpUrl = self.getCallUpUrl();
                    AdInfoCard card = self.getCard();
                    if (Intrinsics.areEqual(callUpUrl, card != null ? card.getCallUpUrl() : null)) {
                        z2 = false;
                        if (z2) {
                            output.encodeNullableSerializableElement(serialDesc, 62, StringSerializer.INSTANCE, self.getCallUpUrl());
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 63)) {
                            String jumpUrl = self.getJumpUrl();
                            AdInfoCard card2 = self.getCard();
                            if (Intrinsics.areEqual(jumpUrl, card2 != null ? card2.getJumpUrl() : null)) {
                                z3 = false;
                                if (z3) {
                                    output.encodeNullableSerializableElement(serialDesc, 63, StringSerializer.INSTANCE, self.getJumpUrl());
                                }
                                if (output.shouldEncodeElementDefault(serialDesc, 64) || !Intrinsics.areEqual(self.getCallUpCancelUrl(), self.getUserCancelJumpUrl())) {
                                    output.encodeNullableSerializableElement(serialDesc, 64, StringSerializer.INSTANCE, self.getCallUpCancelUrl());
                                }
                                if (!output.shouldEncodeElementDefault(serialDesc, 65)) {
                                    if (self.getEnableCallUpCancelToH5() == (self.getUserCancelJumpType() == 1)) {
                                        z4 = false;
                                        if (z4) {
                                            output.encodeBooleanElement(serialDesc, 65, self.getEnableCallUpCancelToH5());
                                        }
                                        if (!output.shouldEncodeElementDefault(serialDesc, 66)) {
                                            AdWxProgramInfo wxProgramInfo = self.getWxProgramInfo();
                                            AdInfoCard card3 = self.getCard();
                                            if (Intrinsics.areEqual(wxProgramInfo, card3 != null ? card3.getWxProgramInfo() : null)) {
                                                z5 = false;
                                                if (z5) {
                                                    output.encodeNullableSerializableElement(serialDesc, 66, AdWxProgramInfo$$serializer.INSTANCE, self.getWxProgramInfo());
                                                }
                                                if (!output.shouldEncodeElementDefault(serialDesc, 67)) {
                                                    AdButton button = self.getButton();
                                                    AdInfoCard card4 = self.getCard();
                                                }
                                                z6 = true;
                                                if (z6) {
                                                    output.encodeNullableSerializableElement(serialDesc, 67, AdButton$$serializer.INSTANCE, self.getButton());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        z5 = true;
                                        if (z5) {
                                        }
                                        if (!output.shouldEncodeElementDefault(serialDesc, 67)) {
                                        }
                                        z6 = true;
                                        if (z6) {
                                        }
                                    }
                                }
                                z4 = true;
                                if (z4) {
                                }
                                if (!output.shouldEncodeElementDefault(serialDesc, 66)) {
                                }
                                z5 = true;
                                if (z5) {
                                }
                                if (!output.shouldEncodeElementDefault(serialDesc, 67)) {
                                }
                                z6 = true;
                                if (z6) {
                                }
                            }
                        }
                        z3 = true;
                        if (z3) {
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 64)) {
                            if (output.shouldEncodeElementDefault(serialDesc, 64) || !Intrinsics.areEqual(self.getCallUpCancelUrl(), self.getUserCancelJumpUrl())) {
                            }
                            if (!output.shouldEncodeElementDefault(serialDesc, 65)) {
                            }
                            z4 = true;
                            if (z4) {
                            }
                            if (!output.shouldEncodeElementDefault(serialDesc, 66)) {
                            }
                            z5 = true;
                            if (z5) {
                            }
                            if (!output.shouldEncodeElementDefault(serialDesc, 67)) {
                            }
                            z6 = true;
                            if (z6) {
                            }
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 64) || !Intrinsics.areEqual(self.getCallUpCancelUrl(), self.getUserCancelJumpUrl())) {
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 65)) {
                        }
                        z4 = true;
                        if (z4) {
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 66)) {
                        }
                        z5 = true;
                        if (z5) {
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 67)) {
                        }
                        z6 = true;
                        if (z6) {
                        }
                    }
                }
                z2 = true;
                if (z2) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 63)) {
                }
                z3 = true;
                if (z3) {
                }
                if (output.shouldEncodeElementDefault(serialDesc, 64) || !Intrinsics.areEqual(self.getCallUpCancelUrl(), self.getUserCancelJumpUrl())) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 65)) {
                }
                z4 = true;
                if (z4) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 66)) {
                }
                z5 = true;
                if (z5) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 67)) {
                }
                z6 = true;
                if (z6) {
                }
            }
        }
        z = true;
        if (z) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 62)) {
        }
        z2 = true;
        if (z2) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 63)) {
        }
        z3 = true;
        if (z3) {
        }
        if (output.shouldEncodeElementDefault(serialDesc, 64) || !Intrinsics.areEqual(self.getCallUpCancelUrl(), self.getUserCancelJumpUrl())) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 65)) {
        }
        z4 = true;
        if (z4) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 66)) {
        }
        z5 = true;
        if (z5) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 67)) {
        }
        z6 = true;
        if (z6) {
        }
    }

    public /* synthetic */ AdInfoExtra(boolean z, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, AdInfoCard adInfoCard, int i, int i2, boolean z2, String str, int i3, boolean z3, String str2, int i4, int i5, String str3, int i6, boolean z4, boolean z5, AdShareInfo adShareInfo, int i7, int i8, String str4, String str5, long j2, long j3, int i9, long j4, boolean z6, List list9, String str6, int i10, int i11, boolean z7, String str7, int i12, int i13, int i14, boolean z8, String str8, int i15, AdCommentToast adCommentToast, String str9, String str10, AdTouchReport adTouchReport, long j5, String str11, int i16, int i17, boolean z9, long j6, boolean z10, List list10, int i18, String str12, String str13, String str14, int i19, int i20, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? false : z, (i19 & 2) != 0 ? null : list, (i19 & 4) != 0 ? null : list2, (i19 & 8) != 0 ? null : list3, (i19 & 16) != 0 ? null : list4, (i19 & 32) != 0 ? null : list5, (i19 & 64) != 0 ? null : list6, (i19 & 128) != 0 ? null : list7, (i19 & 256) != 0 ? null : list8, (i19 & 512) != 0 ? null : adInfoCard, (i19 & 1024) != 0 ? 0 : i, (i19 & 2048) != 0 ? 0 : i2, (i19 & 4096) != 0 ? false : z2, (i19 & 8192) != 0 ? null : str, (i19 & 16384) != 0 ? 0 : i3, (i19 & 32768) != 0 ? false : z3, (i19 & 65536) != 0 ? null : str2, (i19 & 131072) != 0 ? 0 : i4, (i19 & 262144) != 0 ? 0 : i5, (i19 & 524288) != 0 ? null : str3, (i19 & 1048576) != 0 ? 0 : i6, (i19 & 2097152) != 0 ? false : z4, (i19 & 4194304) != 0 ? false : z5, (i19 & 8388608) != 0 ? null : adShareInfo, (i19 & 16777216) != 0 ? 0 : i7, (i19 & 33554432) != 0 ? 0 : i8, (i19 & 67108864) != 0 ? null : str4, (i19 & 134217728) != 0 ? null : str5, (i19 & 268435456) != 0 ? 0L : j2, (i19 & 536870912) != 0 ? 0L : j3, (i19 & 1073741824) != 0 ? 0 : i9, (i19 & Integer.MIN_VALUE) != 0 ? 0L : j4, (i20 & 1) != 0 ? false : z6, (i20 & 2) != 0 ? null : list9, (i20 & 4) != 0 ? null : str6, (i20 & 8) != 0 ? 0 : i10, (i20 & 16) != 0 ? 0 : i11, (i20 & 32) != 0 ? false : z7, (i20 & 64) != 0 ? null : str7, (i20 & 128) != 0 ? 0 : i12, (i20 & 256) != 0 ? 0 : i13, (i20 & 512) != 0 ? 0 : i14, (i20 & 1024) != 0 ? false : z8, (i20 & 2048) != 0 ? null : str8, (i20 & 4096) != 0 ? 0 : i15, (i20 & 8192) != 0 ? null : adCommentToast, (i20 & 16384) != 0 ? null : str9, (i20 & 32768) != 0 ? null : str10, (i20 & 65536) != 0 ? null : adTouchReport, (i20 & 131072) != 0 ? 0L : j5, (i20 & 262144) != 0 ? null : str11, (i20 & 524288) != 0 ? 0 : i16, (i20 & 1048576) != 0 ? 0 : i17, (i20 & 2097152) != 0 ? false : z9, (i20 & 4194304) == 0 ? j6 : 0L, (i20 & 8388608) != 0 ? false : z10, (i20 & 16777216) != 0 ? null : list10, (i20 & 33554432) != 0 ? 0 : i18, (i20 & 67108864) != 0 ? null : str12, (i20 & 134217728) != 0 ? null : str13, (i20 & 268435456) != 0 ? null : str14);
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public boolean getUseAdWebV2() {
        return this.useAdWebV2;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public List<String> getShowUrls() {
        return this.showUrls;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public List<String> getClickUrls() {
        return this.clickUrls;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public List<String> getDmListShowUrls() {
        return this.dmListShowUrls;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public List<String> getDmListClickUrls() {
        return this.dmListClickUrls;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public List<String> getDmDetailShowUrls() {
        return this.dmDetailShowUrls;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public List<String> getDmTrolleyAddUrls() {
        return this.dmTrolleyAddUrls;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public List<AdWhiteApk> getDownloadWhitelist() {
        return this.downloadWhitelist;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public List<String> getOpenWhitelist() {
        return this.openWhitelist;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public AdInfoCard getCard() {
        return this.card;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getReportTime() {
        return this.reportTime;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getSalesType() {
        return this.salesType;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public boolean getSpecialIndustry() {
        return this.specialIndustry;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getSpecialIndustryTips() {
        return this.specialIndustryTips;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getSpecialIndustryStyle() {
        return this.specialIndustryStyle;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public boolean getEnableH5Alert() {
        return this.enableH5Alert;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getExternalLinkWarning() {
        return this.externalLinkWarning;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getPreloadLandingPage() {
        return this.preloadLandingPage;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getEnableH5PreLoad() {
        return this.enableH5PreLoad;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getH5PreLoadUrl() {
        return this.h5PreLoadUrl;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getEnableAutoCallUp() {
        return this.enableAutoCallUp;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public boolean getEnableDownloadDialog() {
        return this.enableDownloadDialog;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public boolean getEnableShare() {
        return this.enableShare;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public AdShareInfo getShareInfo() {
        return this.shareInfo;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getUpZoneEntranceType() {
        return this.upZoneEntranceType;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getUpZoneEntranceReportId() {
        return this.upZoneEntranceReportId;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getTrackId() {
        return this.trackId;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getLiveTrackId() {
        return this.liveTrackId;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public long getUpMid() {
        return this.upMid;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public long getShopId() {
        return this.shopId;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getStoreDirectLaunch() {
        return this.storeDirectLaunch;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public long getProductId() {
        return this.productId;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public boolean getEnableDoubleJump() {
        return this.enableDoubleJump;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public List<String> getShow1sUrls() {
        return this.show1sUrls;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getFromTrackId() {
        return this.fromTrackId;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public int getLandingPageDownloadStyle() {
        return this.landingPageDownloadStyle;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public int getDownloadUrlType() {
        return this.downloadUrlType;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public boolean getEnableMarketDownloadWhenFirstJump() {
        return this.enableMarketDownloadWhenFirstJump;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getTabUrl() {
        return this.tabUrl;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getMacroReplacePriority() {
        return this.macroReplacePriority;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getFeedbackPanelStyle() {
        return this.feedbackPanelStyle;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getAdContentType() {
        return this.adContentType;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public boolean isDanmukuOpened() {
        return this.isDanmukuOpened;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getCmFromTrackId() {
        return this.cmFromTrackId;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getCommentToastOpen() {
        return this.commentToastOpen;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public AdCommentToast getCommentToast() {
        return this.commentToast;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getOcpxTargetType() {
        return this.ocpxTargetType;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getAbtest() {
        return this.abtest;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public AdTouchReport getSplashTouch() {
        return this.splashTouch;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public long getLiveBookingId() {
        return this.liveBookingId;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public String getMarketDownloadUrlXM() {
        return this.marketDownloadUrlXM;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getTopLiveStayTimeSeconds() {
        return this.topLiveStayTimeSeconds;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int isMallPreloadSupported() {
        return this.isMallPreloadSupported;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public boolean getTopAvatarShow() {
        return this.topAvatarShow;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public long getLotteryId() {
        return this.lotteryId;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public boolean getEnableOpenApkDialog() {
        return this.enableOpenApkDialog;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public List<AdLiveBookInfo> getLiveBookingInfos() {
        return this.liveBookingInfos;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public int getUserCancelJumpType() {
        return this.userCancelJumpType;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getUserCancelJumpUrl() {
        return this.userCancelJumpUrl;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getDisableComponentClickUrl() {
        return this.disableComponentClickUrl;
    }

    @Override // kntr.app.ad.common.protocol.IExtraInfo
    public String getAppExpParams() {
        return this.appExpParams;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public boolean getEnableMarketDownload() {
        return this.enableMarketDownload;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public String getCallUpUrl() {
        return this.callUpUrl;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public String getJumpUrl() {
        return this.jumpUrl;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public String getCallUpCancelUrl() {
        return this.callUpCancelUrl;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public boolean getEnableCallUpCancelToH5() {
        return this.enableCallUpCancelToH5;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public AdWxProgramInfo getWxProgramInfo() {
        return this.wxProgramInfo;
    }

    @Override // kntr.app.ad.common.protocol.IClickable
    public AdButton getButton() {
        return this.button;
    }
}