package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdSubCardModule.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b[\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0099\u00012\u00020\u0001:\u0004\u0098\u0001\u0099\u0001B£\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010*\u001a\u00020 \u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.¢\u0006\u0004\b/\u00100Bÿ\u0002\b\u0010\u0012\u0006\u00101\u001a\u000202\u0012\u0006\u00103\u001a\u000202\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000b\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\b\u0010&\u001a\u0004\u0018\u00010'\u0012\b\u0010(\u001a\u0004\u0018\u00010)\u0012\u0006\u0010*\u001a\u00020 \u0012\b\u0010+\u001a\u0004\u0018\u00010,\u0012\b\u0010-\u001a\u0004\u0018\u00010.\u0012\b\u00104\u001a\u0004\u0018\u000105¢\u0006\u0004\b/\u00106J\u000b\u0010j\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0013\u0010q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0013\u0010u\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000bHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0013\u0010|\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000bHÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0013\u0010\u007f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000bHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020 HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010'HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010)HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020 HÆ\u0003J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010,HÆ\u0003¢\u0006\u0002\u0010fJ\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J¬\u0003\u0010\u008a\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010*\u001a\u00020 2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.HÆ\u0001¢\u0006\u0003\u0010\u008b\u0001J\u0015\u0010\u008c\u0001\u001a\u00020,2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u008e\u0001\u001a\u000202HÖ\u0001J\n\u0010\u008f\u0001\u001a\u00020\u0004HÖ\u0001J-\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0092\u0001\u001a\u00020\u00002\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0001¢\u0006\u0003\b\u0097\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u00108\u001a\u0004\b<\u0010=R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010=R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010=R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010=R\u001b\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010=R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010=R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001b\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bI\u0010DR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010=R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010=R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010=R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010=R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u00108\u001a\u0004\bO\u0010=R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010=R&\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u00108\u001a\u0004\bR\u0010DR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010=R&\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u00108\u001a\u0004\bW\u0010DR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0013\u0010!\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010=R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b[\u00108\u001a\u0004\b\\\u0010=R\u0013\u0010#\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010=R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0011\u0010*\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bd\u0010YR\u0015\u0010+\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010g\u001a\u0004\be\u0010fR\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\bh\u0010i¨\u0006\u009a\u0001"}, d2 = {"Lkntr/app/ad/common/model/AdSubCardModule;", RoomRecommendViewModel.EMPTY_CURSOR, "nextSubCardModule", "type", RoomRecommendViewModel.EMPTY_CURSOR, "icon", "nightIcon", "avatar", "title", "desc", "tagInfos", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdTagStyle;", "rankStars", "amountNumber", "button", "Lkntr/app/ad/common/model/AdButton;", "qualityInfos", "Lkntr/app/ad/common/model/AdQualityInfo;", "subDesc", "starRating", "priceDesc", "priceSymbol", "priceOri", "goodsPrice", "comments", "Lkntr/app/ad/common/model/AdComment;", "giftCardInfo", "Lkntr/app/ad/common/model/AdGiftCardInfo;", "extraImg", "chooseBtnList", "popDelayTime", RoomRecommendViewModel.EMPTY_CURSOR, "jumpUrl", "callUpUrl", "adImgTag", "fullText", "Lkntr/app/ad/common/model/AdFullText;", "wxProgramInfo", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "forwardReply", "Lkntr/app/ad/common/model/AdForwardReply;", "animDelayTime", "showCloseButton", RoomRecommendViewModel.EMPTY_CURSOR, "easterEggVideo", "Lkntr/app/ad/common/model/AdVideo;", "<init>", "(Lkntr/app/ad/common/model/AdSubCardModule;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdButton;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkntr/app/ad/common/model/AdGiftCardInfo;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdFullText;Lkntr/app/ad/common/model/AdWxProgramInfo;Lkntr/app/ad/common/model/AdForwardReply;JLjava/lang/Boolean;Lkntr/app/ad/common/model/AdVideo;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkntr/app/ad/common/model/AdSubCardModule;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdButton;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkntr/app/ad/common/model/AdGiftCardInfo;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdFullText;Lkntr/app/ad/common/model/AdWxProgramInfo;Lkntr/app/ad/common/model/AdForwardReply;JLjava/lang/Boolean;Lkntr/app/ad/common/model/AdVideo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNextSubCardModule$annotations", "()V", "getNextSubCardModule", "()Lkntr/app/ad/common/model/AdSubCardModule;", "getType$annotations", "getType", "()Ljava/lang/String;", "getIcon", "getNightIcon", "getAvatar", "getTitle", "getDesc", "getTagInfos", "()Ljava/util/List;", "getRankStars", "getAmountNumber", "getButton", "()Lkntr/app/ad/common/model/AdButton;", "getQualityInfos", "getSubDesc", "getStarRating", "getPriceDesc", "getPriceSymbol", "getPriceOri$annotations", "getPriceOri", "getGoodsPrice", "getComments$annotations", "getComments", "getGiftCardInfo", "()Lkntr/app/ad/common/model/AdGiftCardInfo;", "getExtraImg", "getChooseBtnList$annotations", "getChooseBtnList", "getPopDelayTime", "()J", "getJumpUrl", "getCallUpUrl$annotations", "getCallUpUrl", "getAdImgTag", "getFullText", "()Lkntr/app/ad/common/model/AdFullText;", "getWxProgramInfo", "()Lkntr/app/ad/common/model/AdWxProgramInfo;", "getForwardReply", "()Lkntr/app/ad/common/model/AdForwardReply;", "getAnimDelayTime", "getShowCloseButton", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEasterEggVideo", "()Lkntr/app/ad/common/model/AdVideo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "copy", "(Lkntr/app/ad/common/model/AdSubCardModule;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdButton;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkntr/app/ad/common/model/AdGiftCardInfo;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdFullText;Lkntr/app/ad/common/model/AdWxProgramInfo;Lkntr/app/ad/common/model/AdForwardReply;JLjava/lang/Boolean;Lkntr/app/ad/common/model/AdVideo;)Lkntr/app/ad/common/model/AdSubCardModule;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdSubCardModule {
    private final String adImgTag;
    private final String amountNumber;
    private final long animDelayTime;
    private final String avatar;
    private final AdButton button;
    private final String callUpUrl;
    private final List<AdButton> chooseBtnList;
    private final List<AdComment> comments;
    private final String desc;
    private final AdVideo easterEggVideo;
    private final String extraImg;
    private final AdForwardReply forwardReply;
    private final AdFullText fullText;
    private final AdGiftCardInfo giftCardInfo;
    private final String goodsPrice;
    private final String icon;
    private final String jumpUrl;
    private final AdSubCardModule nextSubCardModule;
    private final String nightIcon;
    private final long popDelayTime;
    private final String priceDesc;
    private final String priceOri;
    private final String priceSymbol;
    private final List<AdQualityInfo> qualityInfos;
    private final String rankStars;
    private final Boolean showCloseButton;
    private final String starRating;
    private final String subDesc;
    private final List<AdTagStyle> tagInfos;
    private final String title;
    private final String type;
    private final AdWxProgramInfo wxProgramInfo;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdSubCardModule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdSubCardModule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdSubCardModule$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = AdSubCardModule._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdSubCardModule$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = AdSubCardModule._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdSubCardModule$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = AdSubCardModule._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), null, null, null, null, null, null, null, null, null, null};

    public AdSubCardModule() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, 0L, null, null, -1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdSubCardModule copy$default(AdSubCardModule adSubCardModule, AdSubCardModule adSubCardModule2, String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, AdButton adButton, List list2, String str9, String str10, String str11, String str12, String str13, String str14, List list3, AdGiftCardInfo adGiftCardInfo, String str15, List list4, long j2, String str16, String str17, String str18, AdFullText adFullText, AdWxProgramInfo adWxProgramInfo, AdForwardReply adForwardReply, long j3, Boolean bool, AdVideo adVideo, int i, Object obj) {
        AdSubCardModule adSubCardModule3 = (i & 1) != 0 ? adSubCardModule.nextSubCardModule : adSubCardModule2;
        String str19 = (i & 2) != 0 ? adSubCardModule.type : str;
        String str20 = (i & 4) != 0 ? adSubCardModule.icon : str2;
        String str21 = (i & 8) != 0 ? adSubCardModule.nightIcon : str3;
        String str22 = (i & 16) != 0 ? adSubCardModule.avatar : str4;
        String str23 = (i & 32) != 0 ? adSubCardModule.title : str5;
        String str24 = (i & 64) != 0 ? adSubCardModule.desc : str6;
        List<AdTagStyle> list5 = (i & 128) != 0 ? adSubCardModule.tagInfos : list;
        String str25 = (i & 256) != 0 ? adSubCardModule.rankStars : str7;
        String str26 = (i & 512) != 0 ? adSubCardModule.amountNumber : str8;
        AdButton adButton2 = (i & 1024) != 0 ? adSubCardModule.button : adButton;
        List<AdQualityInfo> list6 = (i & 2048) != 0 ? adSubCardModule.qualityInfos : list2;
        String str27 = (i & 4096) != 0 ? adSubCardModule.subDesc : str9;
        return adSubCardModule.copy(adSubCardModule3, str19, str20, str21, str22, str23, str24, list5, str25, str26, adButton2, list6, str27, (i & 8192) != 0 ? adSubCardModule.starRating : str10, (i & 16384) != 0 ? adSubCardModule.priceDesc : str11, (i & 32768) != 0 ? adSubCardModule.priceSymbol : str12, (i & 65536) != 0 ? adSubCardModule.priceOri : str13, (i & 131072) != 0 ? adSubCardModule.goodsPrice : str14, (i & 262144) != 0 ? adSubCardModule.comments : list3, (i & 524288) != 0 ? adSubCardModule.giftCardInfo : adGiftCardInfo, (i & 1048576) != 0 ? adSubCardModule.extraImg : str15, (i & 2097152) != 0 ? adSubCardModule.chooseBtnList : list4, (i & 4194304) != 0 ? adSubCardModule.popDelayTime : j2, (i & 8388608) != 0 ? adSubCardModule.jumpUrl : str16, (16777216 & i) != 0 ? adSubCardModule.callUpUrl : str17, (i & 33554432) != 0 ? adSubCardModule.adImgTag : str18, (i & 67108864) != 0 ? adSubCardModule.fullText : adFullText, (i & 134217728) != 0 ? adSubCardModule.wxProgramInfo : adWxProgramInfo, (i & 268435456) != 0 ? adSubCardModule.forwardReply : adForwardReply, (i & 536870912) != 0 ? adSubCardModule.animDelayTime : j3, (i & 1073741824) != 0 ? adSubCardModule.showCloseButton : bool, (i & Integer.MIN_VALUE) != 0 ? adSubCardModule.easterEggVideo : adVideo);
    }

    @SerialName("callup_url")
    public static /* synthetic */ void getCallUpUrl$annotations() {
    }

    @SerialName("choose_button_list")
    public static /* synthetic */ void getChooseBtnList$annotations() {
    }

    @SerialName("comment_list")
    public static /* synthetic */ void getComments$annotations() {
    }

    @SerialName("next_subcard")
    public static /* synthetic */ void getNextSubCardModule$annotations() {
    }

    @SerialName("ori_price")
    public static /* synthetic */ void getPriceOri$annotations() {
    }

    @SerialName("subcard_type")
    public static /* synthetic */ void getType$annotations() {
    }

    public final AdSubCardModule component1() {
        return this.nextSubCardModule;
    }

    public final String component10() {
        return this.amountNumber;
    }

    public final AdButton component11() {
        return this.button;
    }

    public final List<AdQualityInfo> component12() {
        return this.qualityInfos;
    }

    public final String component13() {
        return this.subDesc;
    }

    public final String component14() {
        return this.starRating;
    }

    public final String component15() {
        return this.priceDesc;
    }

    public final String component16() {
        return this.priceSymbol;
    }

    public final String component17() {
        return this.priceOri;
    }

    public final String component18() {
        return this.goodsPrice;
    }

    public final List<AdComment> component19() {
        return this.comments;
    }

    public final String component2() {
        return this.type;
    }

    public final AdGiftCardInfo component20() {
        return this.giftCardInfo;
    }

    public final String component21() {
        return this.extraImg;
    }

    public final List<AdButton> component22() {
        return this.chooseBtnList;
    }

    public final long component23() {
        return this.popDelayTime;
    }

    public final String component24() {
        return this.jumpUrl;
    }

    public final String component25() {
        return this.callUpUrl;
    }

    public final String component26() {
        return this.adImgTag;
    }

    public final AdFullText component27() {
        return this.fullText;
    }

    public final AdWxProgramInfo component28() {
        return this.wxProgramInfo;
    }

    public final AdForwardReply component29() {
        return this.forwardReply;
    }

    public final String component3() {
        return this.icon;
    }

    public final long component30() {
        return this.animDelayTime;
    }

    public final Boolean component31() {
        return this.showCloseButton;
    }

    public final AdVideo component32() {
        return this.easterEggVideo;
    }

    public final String component4() {
        return this.nightIcon;
    }

    public final String component5() {
        return this.avatar;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.desc;
    }

    public final List<AdTagStyle> component8() {
        return this.tagInfos;
    }

    public final String component9() {
        return this.rankStars;
    }

    public final AdSubCardModule copy(AdSubCardModule adSubCardModule, String str, String str2, String str3, String str4, String str5, String str6, List<AdTagStyle> list, String str7, String str8, AdButton adButton, List<AdQualityInfo> list2, String str9, String str10, String str11, String str12, String str13, String str14, List<AdComment> list3, AdGiftCardInfo adGiftCardInfo, String str15, List<AdButton> list4, long j2, String str16, String str17, String str18, AdFullText adFullText, AdWxProgramInfo adWxProgramInfo, AdForwardReply adForwardReply, long j3, Boolean bool, AdVideo adVideo) {
        return new AdSubCardModule(adSubCardModule, str, str2, str3, str4, str5, str6, list, str7, str8, adButton, list2, str9, str10, str11, str12, str13, str14, list3, adGiftCardInfo, str15, list4, j2, str16, str17, str18, adFullText, adWxProgramInfo, adForwardReply, j3, bool, adVideo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdSubCardModule) {
            AdSubCardModule adSubCardModule = (AdSubCardModule) obj;
            return Intrinsics.areEqual(this.nextSubCardModule, adSubCardModule.nextSubCardModule) && Intrinsics.areEqual(this.type, adSubCardModule.type) && Intrinsics.areEqual(this.icon, adSubCardModule.icon) && Intrinsics.areEqual(this.nightIcon, adSubCardModule.nightIcon) && Intrinsics.areEqual(this.avatar, adSubCardModule.avatar) && Intrinsics.areEqual(this.title, adSubCardModule.title) && Intrinsics.areEqual(this.desc, adSubCardModule.desc) && Intrinsics.areEqual(this.tagInfos, adSubCardModule.tagInfos) && Intrinsics.areEqual(this.rankStars, adSubCardModule.rankStars) && Intrinsics.areEqual(this.amountNumber, adSubCardModule.amountNumber) && Intrinsics.areEqual(this.button, adSubCardModule.button) && Intrinsics.areEqual(this.qualityInfos, adSubCardModule.qualityInfos) && Intrinsics.areEqual(this.subDesc, adSubCardModule.subDesc) && Intrinsics.areEqual(this.starRating, adSubCardModule.starRating) && Intrinsics.areEqual(this.priceDesc, adSubCardModule.priceDesc) && Intrinsics.areEqual(this.priceSymbol, adSubCardModule.priceSymbol) && Intrinsics.areEqual(this.priceOri, adSubCardModule.priceOri) && Intrinsics.areEqual(this.goodsPrice, adSubCardModule.goodsPrice) && Intrinsics.areEqual(this.comments, adSubCardModule.comments) && Intrinsics.areEqual(this.giftCardInfo, adSubCardModule.giftCardInfo) && Intrinsics.areEqual(this.extraImg, adSubCardModule.extraImg) && Intrinsics.areEqual(this.chooseBtnList, adSubCardModule.chooseBtnList) && this.popDelayTime == adSubCardModule.popDelayTime && Intrinsics.areEqual(this.jumpUrl, adSubCardModule.jumpUrl) && Intrinsics.areEqual(this.callUpUrl, adSubCardModule.callUpUrl) && Intrinsics.areEqual(this.adImgTag, adSubCardModule.adImgTag) && Intrinsics.areEqual(this.fullText, adSubCardModule.fullText) && Intrinsics.areEqual(this.wxProgramInfo, adSubCardModule.wxProgramInfo) && Intrinsics.areEqual(this.forwardReply, adSubCardModule.forwardReply) && this.animDelayTime == adSubCardModule.animDelayTime && Intrinsics.areEqual(this.showCloseButton, adSubCardModule.showCloseButton) && Intrinsics.areEqual(this.easterEggVideo, adSubCardModule.easterEggVideo);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.nextSubCardModule == null ? 0 : this.nextSubCardModule.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.nightIcon == null ? 0 : this.nightIcon.hashCode())) * 31) + (this.avatar == null ? 0 : this.avatar.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.tagInfos == null ? 0 : this.tagInfos.hashCode())) * 31) + (this.rankStars == null ? 0 : this.rankStars.hashCode())) * 31) + (this.amountNumber == null ? 0 : this.amountNumber.hashCode())) * 31) + (this.button == null ? 0 : this.button.hashCode())) * 31) + (this.qualityInfos == null ? 0 : this.qualityInfos.hashCode())) * 31) + (this.subDesc == null ? 0 : this.subDesc.hashCode())) * 31) + (this.starRating == null ? 0 : this.starRating.hashCode())) * 31) + (this.priceDesc == null ? 0 : this.priceDesc.hashCode())) * 31) + (this.priceSymbol == null ? 0 : this.priceSymbol.hashCode())) * 31) + (this.priceOri == null ? 0 : this.priceOri.hashCode())) * 31) + (this.goodsPrice == null ? 0 : this.goodsPrice.hashCode())) * 31) + (this.comments == null ? 0 : this.comments.hashCode())) * 31) + (this.giftCardInfo == null ? 0 : this.giftCardInfo.hashCode())) * 31) + (this.extraImg == null ? 0 : this.extraImg.hashCode())) * 31) + (this.chooseBtnList == null ? 0 : this.chooseBtnList.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.popDelayTime)) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.callUpUrl == null ? 0 : this.callUpUrl.hashCode())) * 31) + (this.adImgTag == null ? 0 : this.adImgTag.hashCode())) * 31) + (this.fullText == null ? 0 : this.fullText.hashCode())) * 31) + (this.wxProgramInfo == null ? 0 : this.wxProgramInfo.hashCode())) * 31) + (this.forwardReply == null ? 0 : this.forwardReply.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.animDelayTime)) * 31) + (this.showCloseButton == null ? 0 : this.showCloseButton.hashCode())) * 31) + (this.easterEggVideo != null ? this.easterEggVideo.hashCode() : 0);
    }

    public String toString() {
        AdSubCardModule adSubCardModule = this.nextSubCardModule;
        String str = this.type;
        String str2 = this.icon;
        String str3 = this.nightIcon;
        String str4 = this.avatar;
        String str5 = this.title;
        String str6 = this.desc;
        List<AdTagStyle> list = this.tagInfos;
        String str7 = this.rankStars;
        String str8 = this.amountNumber;
        AdButton adButton = this.button;
        List<AdQualityInfo> list2 = this.qualityInfos;
        String str9 = this.subDesc;
        String str10 = this.starRating;
        String str11 = this.priceDesc;
        String str12 = this.priceSymbol;
        String str13 = this.priceOri;
        String str14 = this.goodsPrice;
        List<AdComment> list3 = this.comments;
        AdGiftCardInfo adGiftCardInfo = this.giftCardInfo;
        String str15 = this.extraImg;
        List<AdButton> list4 = this.chooseBtnList;
        long j2 = this.popDelayTime;
        String str16 = this.jumpUrl;
        String str17 = this.callUpUrl;
        String str18 = this.adImgTag;
        AdFullText adFullText = this.fullText;
        AdWxProgramInfo adWxProgramInfo = this.wxProgramInfo;
        AdForwardReply adForwardReply = this.forwardReply;
        long j3 = this.animDelayTime;
        Boolean bool = this.showCloseButton;
        return "AdSubCardModule(nextSubCardModule=" + adSubCardModule + ", type=" + str + ", icon=" + str2 + ", nightIcon=" + str3 + ", avatar=" + str4 + ", title=" + str5 + ", desc=" + str6 + ", tagInfos=" + list + ", rankStars=" + str7 + ", amountNumber=" + str8 + ", button=" + adButton + ", qualityInfos=" + list2 + ", subDesc=" + str9 + ", starRating=" + str10 + ", priceDesc=" + str11 + ", priceSymbol=" + str12 + ", priceOri=" + str13 + ", goodsPrice=" + str14 + ", comments=" + list3 + ", giftCardInfo=" + adGiftCardInfo + ", extraImg=" + str15 + ", chooseBtnList=" + list4 + ", popDelayTime=" + j2 + ", jumpUrl=" + str16 + ", callUpUrl=" + str17 + ", adImgTag=" + str18 + ", fullText=" + adFullText + ", wxProgramInfo=" + adWxProgramInfo + ", forwardReply=" + adForwardReply + ", animDelayTime=" + j3 + ", showCloseButton=" + bool + ", easterEggVideo=" + this.easterEggVideo + ")";
    }

    /* compiled from: AdSubCardModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdSubCardModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdSubCardModule;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdSubCardModule> serializer() {
            return AdSubCardModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdSubCardModule(int seen0, int seen1, AdSubCardModule nextSubCardModule, String type, String icon, String nightIcon, String avatar, String title, String desc, List tagInfos, String rankStars, String amountNumber, AdButton button, List qualityInfos, String subDesc, String starRating, String priceDesc, String priceSymbol, String priceOri, String goodsPrice, List comments, AdGiftCardInfo giftCardInfo, String extraImg, List chooseBtnList, long popDelayTime, String jumpUrl, String callUpUrl, String adImgTag, AdFullText fullText, AdWxProgramInfo wxProgramInfo, AdForwardReply forwardReply, long animDelayTime, Boolean showCloseButton, AdVideo easterEggVideo, SerializationConstructorMarker serializationConstructorMarker) {
        String str;
        AdVideo adVideo;
        if ((seen0 & 1) == 0) {
            this.nextSubCardModule = null;
        } else {
            this.nextSubCardModule = nextSubCardModule;
        }
        if ((seen0 & 2) == 0) {
            this.type = null;
        } else {
            this.type = type;
        }
        if ((seen0 & 4) == 0) {
            this.icon = null;
        } else {
            this.icon = icon;
        }
        if ((seen0 & 8) == 0) {
            this.nightIcon = null;
        } else {
            this.nightIcon = nightIcon;
        }
        if ((seen0 & 16) == 0) {
            this.avatar = null;
        } else {
            this.avatar = avatar;
        }
        if ((seen0 & 32) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 64) == 0) {
            this.desc = null;
        } else {
            this.desc = desc;
        }
        if ((seen0 & 128) == 0) {
            this.tagInfos = null;
        } else {
            this.tagInfos = tagInfos;
        }
        if ((seen0 & 256) == 0) {
            this.rankStars = null;
        } else {
            this.rankStars = rankStars;
        }
        if ((seen0 & 512) == 0) {
            this.amountNumber = null;
        } else {
            this.amountNumber = amountNumber;
        }
        if ((seen0 & 1024) == 0) {
            this.button = null;
        } else {
            this.button = button;
        }
        if ((seen0 & 2048) == 0) {
            this.qualityInfos = null;
        } else {
            this.qualityInfos = qualityInfos;
        }
        if ((seen0 & 4096) == 0) {
            this.subDesc = null;
        } else {
            this.subDesc = subDesc;
        }
        if ((seen0 & 8192) == 0) {
            this.starRating = null;
        } else {
            this.starRating = starRating;
        }
        if ((seen0 & 16384) == 0) {
            this.priceDesc = null;
        } else {
            this.priceDesc = priceDesc;
        }
        if ((seen0 & 32768) == 0) {
            this.priceSymbol = null;
        } else {
            this.priceSymbol = priceSymbol;
        }
        if ((seen0 & 65536) == 0) {
            this.priceOri = null;
        } else {
            this.priceOri = priceOri;
        }
        if ((seen0 & 131072) == 0) {
            this.goodsPrice = null;
        } else {
            this.goodsPrice = goodsPrice;
        }
        if ((seen0 & 262144) == 0) {
            this.comments = null;
        } else {
            this.comments = comments;
        }
        if ((seen0 & 524288) == 0) {
            this.giftCardInfo = null;
        } else {
            this.giftCardInfo = giftCardInfo;
        }
        if ((seen0 & 1048576) == 0) {
            this.extraImg = null;
        } else {
            this.extraImg = extraImg;
        }
        if ((seen0 & 2097152) == 0) {
            this.chooseBtnList = null;
        } else {
            this.chooseBtnList = chooseBtnList;
        }
        if ((seen0 & 4194304) == 0) {
            this.popDelayTime = 0L;
        } else {
            this.popDelayTime = popDelayTime;
        }
        if ((seen0 & 8388608) == 0) {
            str = null;
            this.jumpUrl = null;
        } else {
            str = null;
            this.jumpUrl = jumpUrl;
        }
        if ((seen0 & 16777216) == 0) {
            this.callUpUrl = str;
        } else {
            this.callUpUrl = callUpUrl;
        }
        if ((seen0 & 33554432) == 0) {
            this.adImgTag = null;
        } else {
            this.adImgTag = adImgTag;
        }
        if ((seen0 & 67108864) == 0) {
            this.fullText = null;
        } else {
            this.fullText = fullText;
        }
        if ((seen0 & 134217728) == 0) {
            this.wxProgramInfo = null;
        } else {
            this.wxProgramInfo = wxProgramInfo;
        }
        if ((seen0 & 268435456) == 0) {
            this.forwardReply = null;
        } else {
            this.forwardReply = forwardReply;
        }
        if ((seen0 & 536870912) == 0) {
            this.animDelayTime = 0L;
        } else {
            this.animDelayTime = animDelayTime;
        }
        if ((seen0 & 1073741824) == 0) {
            adVideo = null;
            this.showCloseButton = null;
        } else {
            adVideo = null;
            this.showCloseButton = showCloseButton;
        }
        if ((seen0 & Integer.MIN_VALUE) == 0) {
            this.easterEggVideo = adVideo;
        } else {
            this.easterEggVideo = easterEggVideo;
        }
    }

    public AdSubCardModule(AdSubCardModule nextSubCardModule, String type, String icon, String nightIcon, String avatar, String title, String desc, List<AdTagStyle> list, String rankStars, String amountNumber, AdButton button, List<AdQualityInfo> list2, String subDesc, String starRating, String priceDesc, String priceSymbol, String priceOri, String goodsPrice, List<AdComment> list3, AdGiftCardInfo giftCardInfo, String extraImg, List<AdButton> list4, long popDelayTime, String jumpUrl, String callUpUrl, String adImgTag, AdFullText fullText, AdWxProgramInfo wxProgramInfo, AdForwardReply forwardReply, long animDelayTime, Boolean showCloseButton, AdVideo easterEggVideo) {
        this.nextSubCardModule = nextSubCardModule;
        this.type = type;
        this.icon = icon;
        this.nightIcon = nightIcon;
        this.avatar = avatar;
        this.title = title;
        this.desc = desc;
        this.tagInfos = list;
        this.rankStars = rankStars;
        this.amountNumber = amountNumber;
        this.button = button;
        this.qualityInfos = list2;
        this.subDesc = subDesc;
        this.starRating = starRating;
        this.priceDesc = priceDesc;
        this.priceSymbol = priceSymbol;
        this.priceOri = priceOri;
        this.goodsPrice = goodsPrice;
        this.comments = list3;
        this.giftCardInfo = giftCardInfo;
        this.extraImg = extraImg;
        this.chooseBtnList = list4;
        this.popDelayTime = popDelayTime;
        this.jumpUrl = jumpUrl;
        this.callUpUrl = callUpUrl;
        this.adImgTag = adImgTag;
        this.fullText = fullText;
        this.wxProgramInfo = wxProgramInfo;
        this.forwardReply = forwardReply;
        this.animDelayTime = animDelayTime;
        this.showCloseButton = showCloseButton;
        this.easterEggVideo = easterEggVideo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdTagStyle$$serializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdQualityInfo$$serializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdComment$$serializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdButton$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdSubCardModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.nextSubCardModule != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, AdSubCardModule$$serializer.INSTANCE, self.nextSubCardModule);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.icon != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.nightIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.nightIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.avatar != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.avatar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.desc != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.desc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.tagInfos != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.tagInfos);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.rankStars != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.rankStars);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.amountNumber != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.amountNumber);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.button != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, AdButton$$serializer.INSTANCE, self.button);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.qualityInfos != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy) lazyArr[11].getValue(), self.qualityInfos);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.subDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.subDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.starRating != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.starRating);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.priceDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.priceDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.priceSymbol != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.priceSymbol);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.priceOri != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.priceOri);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.goodsPrice != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.goodsPrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.comments != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, (SerializationStrategy) lazyArr[18].getValue(), self.comments);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.giftCardInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, AdGiftCardInfo$$serializer.INSTANCE, self.giftCardInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.extraImg != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.extraImg);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.chooseBtnList != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, (SerializationStrategy) lazyArr[21].getValue(), self.chooseBtnList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.popDelayTime != 0) {
            output.encodeLongElement(serialDesc, 22, self.popDelayTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.jumpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.callUpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.callUpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || self.adImgTag != null) {
            output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.adImgTag);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.fullText != null) {
            output.encodeNullableSerializableElement(serialDesc, 26, AdFullText$$serializer.INSTANCE, self.fullText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.wxProgramInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 27, AdWxProgramInfo$$serializer.INSTANCE, self.wxProgramInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || self.forwardReply != null) {
            output.encodeNullableSerializableElement(serialDesc, 28, AdForwardReply$$serializer.INSTANCE, self.forwardReply);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.animDelayTime != 0) {
            output.encodeLongElement(serialDesc, 29, self.animDelayTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.showCloseButton != null) {
            output.encodeNullableSerializableElement(serialDesc, 30, BooleanSerializer.INSTANCE, self.showCloseButton);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.easterEggVideo != null) {
            output.encodeNullableSerializableElement(serialDesc, 31, AdVideo$$serializer.INSTANCE, self.easterEggVideo);
        }
    }

    public /* synthetic */ AdSubCardModule(AdSubCardModule adSubCardModule, String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, AdButton adButton, List list2, String str9, String str10, String str11, String str12, String str13, String str14, List list3, AdGiftCardInfo adGiftCardInfo, String str15, List list4, long j2, String str16, String str17, String str18, AdFullText adFullText, AdWxProgramInfo adWxProgramInfo, AdForwardReply adForwardReply, long j3, Boolean bool, AdVideo adVideo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : adSubCardModule, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : adButton, (i & 2048) != 0 ? null : list2, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : str12, (i & 65536) != 0 ? null : str13, (i & 131072) != 0 ? null : str14, (i & 262144) != 0 ? null : list3, (i & 524288) != 0 ? null : adGiftCardInfo, (i & 1048576) != 0 ? null : str15, (i & 2097152) != 0 ? null : list4, (i & 4194304) != 0 ? 0L : j2, (i & 8388608) != 0 ? null : str16, (i & 16777216) != 0 ? null : str17, (i & 33554432) != 0 ? null : str18, (i & 67108864) != 0 ? null : adFullText, (i & 134217728) != 0 ? null : adWxProgramInfo, (i & 268435456) != 0 ? null : adForwardReply, (i & 536870912) == 0 ? j3 : 0L, (i & 1073741824) != 0 ? null : bool, (i & Integer.MIN_VALUE) != 0 ? null : adVideo);
    }

    public final AdSubCardModule getNextSubCardModule() {
        return this.nextSubCardModule;
    }

    public final String getType() {
        return this.type;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getNightIcon() {
        return this.nightIcon;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final List<AdTagStyle> getTagInfos() {
        return this.tagInfos;
    }

    public final String getRankStars() {
        return this.rankStars;
    }

    public final String getAmountNumber() {
        return this.amountNumber;
    }

    public final AdButton getButton() {
        return this.button;
    }

    public final List<AdQualityInfo> getQualityInfos() {
        return this.qualityInfos;
    }

    public final String getSubDesc() {
        return this.subDesc;
    }

    public final String getStarRating() {
        return this.starRating;
    }

    public final String getPriceDesc() {
        return this.priceDesc;
    }

    public final String getPriceSymbol() {
        return this.priceSymbol;
    }

    public final String getPriceOri() {
        return this.priceOri;
    }

    public final String getGoodsPrice() {
        return this.goodsPrice;
    }

    public final List<AdComment> getComments() {
        return this.comments;
    }

    public final AdGiftCardInfo getGiftCardInfo() {
        return this.giftCardInfo;
    }

    public final String getExtraImg() {
        return this.extraImg;
    }

    public final List<AdButton> getChooseBtnList() {
        return this.chooseBtnList;
    }

    public final long getPopDelayTime() {
        return this.popDelayTime;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getCallUpUrl() {
        return this.callUpUrl;
    }

    public final String getAdImgTag() {
        return this.adImgTag;
    }

    public final AdFullText getFullText() {
        return this.fullText;
    }

    public final AdWxProgramInfo getWxProgramInfo() {
        return this.wxProgramInfo;
    }

    public final AdForwardReply getForwardReply() {
        return this.forwardReply;
    }

    public final long getAnimDelayTime() {
        return this.animDelayTime;
    }

    public final Boolean getShowCloseButton() {
        return this.showCloseButton;
    }

    public final AdVideo getEasterEggVideo() {
        return this.easterEggVideo;
    }
}