package kntr.app.ad.common.model;

import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdVideo.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bS\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0086\u00012\u00020\u0001:\u0004\u0085\u0001\u0086\u0001B¯\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0019\u0012\b\b\u0002\u0010!\u001a\u00020\u0019\u0012\b\b\u0002\u0010\"\u001a\u00020\u0019\u0012\b\b\u0002\u0010#\u001a\u00020\u0019\u0012\u0012\b\u0002\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u000f¢\u0006\u0004\b&\u0010'B\u0087\u0003\b\u0010\u0012\u0006\u0010(\u001a\u00020\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010 \u001a\u00020\u0019\u0012\u0006\u0010!\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u0019\u0012\u0006\u0010#\u001a\u00020\u0019\u0012\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u000f\u0012\b\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0004\b&\u0010+J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010`\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u0013\u0010d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u0013\u0010e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u0013\u0010f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u0013\u0010g\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u0013\u0010h\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u0013\u0010i\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u0013\u0010j\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u0013\u0010k\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\t\u0010l\u001a\u00020\u0019HÆ\u0003J\t\u0010m\u001a\u00020\u0019HÆ\u0003J\t\u0010n\u001a\u00020\u0019HÆ\u0003J\t\u0010o\u001a\u00020\u0019HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010r\u001a\u00020\u0019HÆ\u0003J\t\u0010s\u001a\u00020\u0019HÆ\u0003J\t\u0010t\u001a\u00020\u0019HÆ\u0003J\t\u0010u\u001a\u00020\u0019HÆ\u0003J\u0013\u0010v\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u000fHÆ\u0003J¶\u0003\u0010w\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010 \u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\u0012\b\u0002\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010xJ\u0013\u0010y\u001a\u00020\n2\b\u0010z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010{\u001a\u00020\u0019HÖ\u0001J\t\u0010|\u001a\u00020\u0003HÖ\u0001J*\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\u00002\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0001¢\u0006\u0003\b\u0084\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010-R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00107\u001a\u0004\b8\u00106R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010-R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010-R&\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u00104\u001a\u0004\b<\u0010=R\u001b\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u001b\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u001b\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b@\u0010=R\u001b\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bA\u0010=R&\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u00104\u001a\u0004\bC\u0010=R&\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u00104\u001a\u0004\bE\u0010=R&\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u00104\u001a\u0004\bG\u0010=R&\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u00104\u001a\u0004\bI\u0010=R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010\u001a\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bL\u0010KR\u0011\u0010\u001b\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bM\u0010KR\u001c\u0010\u001c\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u00104\u001a\u0004\bO\u0010KR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u00104\u001a\u0004\bQ\u0010RR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010-R\u0011\u0010 \u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bT\u0010KR\u0011\u0010!\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bU\u0010KR\u0011\u0010\"\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bV\u0010KR\u0011\u0010#\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bW\u0010KR\u001b\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bX\u0010=¨\u0006\u0087\u0001"}, d2 = {"Lkntr/app/ad/common/model/AdVideo;", RoomRecommendViewModel.EMPTY_CURSOR, "avid", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.CID, "page", "from", "url", "cover", "canAutoPlay", RoomRecommendViewModel.EMPTY_CURSOR, "btnDycColor", "btnDycTime", "bizId", "playStartUrls", RoomRecommendViewModel.EMPTY_CURSOR, "play3sUrls", "play5sUrls", "play10sUrls", "play15sUrls", "play25pUrls", "play50pUrls", "play75pUrls", "play100pUrls", "muteButton", RoomRecommendViewModel.EMPTY_CURSOR, "progressBar", "mutePlay", "hasEndPage", "endPageInfo", "Lkntr/app/ad/common/model/AdVideoEndPage;", "fromSpmid", "autoPlayValue", "eggStartTime", "eggEndTime", "pressTriggerTime", "customPlayUrls", "Lkntr/app/ad/common/model/AdCustomPlayUrl;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIILkntr/app/ad/common/model/AdVideoEndPage;Ljava/lang/String;IIIILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIILkntr/app/ad/common/model/AdVideoEndPage;Ljava/lang/String;IIIILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAvid", "()Ljava/lang/String;", "getCid", "getPage", "getFrom", "getUrl", "getCover", "getCanAutoPlay$annotations", "()V", "getCanAutoPlay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBtnDycColor", "getBtnDycTime", "getBizId", "getPlayStartUrls$annotations", "getPlayStartUrls", "()Ljava/util/List;", "getPlay3sUrls", "getPlay5sUrls", "getPlay10sUrls", "getPlay15sUrls", "getPlay25pUrls$annotations", "getPlay25pUrls", "getPlay50pUrls$annotations", "getPlay50pUrls", "getPlay75pUrls$annotations", "getPlay75pUrls", "getPlay100pUrls$annotations", "getPlay100pUrls", "getMuteButton", "()I", "getProgressBar", "getMutePlay", "getHasEndPage$annotations", "getHasEndPage", "getEndPageInfo$annotations", "getEndPageInfo", "()Lkntr/app/ad/common/model/AdVideoEndPage;", "getFromSpmid", "getAutoPlayValue", "getEggStartTime", "getEggEndTime", "getPressTriggerTime", "getCustomPlayUrls", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIILkntr/app/ad/common/model/AdVideoEndPage;Ljava/lang/String;IIIILjava/util/List;)Lkntr/app/ad/common/model/AdVideo;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdVideo {
    private final int autoPlayValue;
    private final String avid;
    private final String bizId;
    private final Boolean btnDycColor;
    private final String btnDycTime;
    private final Boolean canAutoPlay;
    private final String cid;
    private final String cover;
    private final List<AdCustomPlayUrl> customPlayUrls;
    private final int eggEndTime;
    private final int eggStartTime;
    private final AdVideoEndPage endPageInfo;
    private final String from;
    private final String fromSpmid;
    private final int hasEndPage;
    private final int muteButton;
    private final int mutePlay;
    private final String page;
    private final List<String> play100pUrls;
    private final List<String> play10sUrls;
    private final List<String> play15sUrls;
    private final List<String> play25pUrls;
    private final List<String> play3sUrls;
    private final List<String> play50pUrls;
    private final List<String> play5sUrls;
    private final List<String> play75pUrls;
    private final List<String> playStartUrls;
    private final int pressTriggerTime;
    private final int progressBar;
    private final String url;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdVideo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdVideo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdVideo$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = AdVideo._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdVideo$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = AdVideo._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdVideo$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = AdVideo._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdVideo$$ExternalSyntheticLambda4
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$3;
            _childSerializers$_anonymous_$3 = AdVideo._childSerializers$_anonymous_$3();
            return _childSerializers$_anonymous_$3;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdVideo$$ExternalSyntheticLambda5
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$4;
            _childSerializers$_anonymous_$4 = AdVideo._childSerializers$_anonymous_$4();
            return _childSerializers$_anonymous_$4;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdVideo$$ExternalSyntheticLambda6
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$5;
            _childSerializers$_anonymous_$5 = AdVideo._childSerializers$_anonymous_$5();
            return _childSerializers$_anonymous_$5;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdVideo$$ExternalSyntheticLambda7
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$6;
            _childSerializers$_anonymous_$6 = AdVideo._childSerializers$_anonymous_$6();
            return _childSerializers$_anonymous_$6;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdVideo$$ExternalSyntheticLambda8
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$7;
            _childSerializers$_anonymous_$7 = AdVideo._childSerializers$_anonymous_$7();
            return _childSerializers$_anonymous_$7;
        }
    }), null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdVideo$$ExternalSyntheticLambda9
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$8;
            _childSerializers$_anonymous_$8 = AdVideo._childSerializers$_anonymous_$8();
            return _childSerializers$_anonymous_$8;
        }
    })};

    public AdVideo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, 0, 0, 0, 0, (AdVideoEndPage) null, (String) null, 0, 0, 0, 0, (List) null, 1073741823, (DefaultConstructorMarker) null);
    }

    @SerialName("auto_play")
    public static /* synthetic */ void getCanAutoPlay$annotations() {
    }

    @SerialName("endplay")
    public static /* synthetic */ void getEndPageInfo$annotations() {
    }

    @SerialName("has_endpage")
    public static /* synthetic */ void getHasEndPage$annotations() {
    }

    @SerialName(SubmitActionFrom.MMA_KEY_PROCESS4_URLS)
    public static /* synthetic */ void getPlay100pUrls$annotations() {
    }

    @SerialName(SubmitActionFrom.MMA_KEY_PROCESS1_URLS)
    public static /* synthetic */ void getPlay25pUrls$annotations() {
    }

    @SerialName(SubmitActionFrom.MMA_KEY_PROCESS2_URLS)
    public static /* synthetic */ void getPlay50pUrls$annotations() {
    }

    @SerialName(SubmitActionFrom.MMA_KEY_PROCESS3_URLS)
    public static /* synthetic */ void getPlay75pUrls$annotations() {
    }

    @SerialName(SubmitActionFrom.MMA_KEY_PROCESS0_URLS)
    public static /* synthetic */ void getPlayStartUrls$annotations() {
    }

    public final String component1() {
        return this.avid;
    }

    public final String component10() {
        return this.bizId;
    }

    public final List<String> component11() {
        return this.playStartUrls;
    }

    public final List<String> component12() {
        return this.play3sUrls;
    }

    public final List<String> component13() {
        return this.play5sUrls;
    }

    public final List<String> component14() {
        return this.play10sUrls;
    }

    public final List<String> component15() {
        return this.play15sUrls;
    }

    public final List<String> component16() {
        return this.play25pUrls;
    }

    public final List<String> component17() {
        return this.play50pUrls;
    }

    public final List<String> component18() {
        return this.play75pUrls;
    }

    public final List<String> component19() {
        return this.play100pUrls;
    }

    public final String component2() {
        return this.cid;
    }

    public final int component20() {
        return this.muteButton;
    }

    public final int component21() {
        return this.progressBar;
    }

    public final int component22() {
        return this.mutePlay;
    }

    public final int component23() {
        return this.hasEndPage;
    }

    public final AdVideoEndPage component24() {
        return this.endPageInfo;
    }

    public final String component25() {
        return this.fromSpmid;
    }

    public final int component26() {
        return this.autoPlayValue;
    }

    public final int component27() {
        return this.eggStartTime;
    }

    public final int component28() {
        return this.eggEndTime;
    }

    public final int component29() {
        return this.pressTriggerTime;
    }

    public final String component3() {
        return this.page;
    }

    public final List<AdCustomPlayUrl> component30() {
        return this.customPlayUrls;
    }

    public final String component4() {
        return this.from;
    }

    public final String component5() {
        return this.url;
    }

    public final String component6() {
        return this.cover;
    }

    public final Boolean component7() {
        return this.canAutoPlay;
    }

    public final Boolean component8() {
        return this.btnDycColor;
    }

    public final String component9() {
        return this.btnDycTime;
    }

    public final AdVideo copy(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, String str8, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<String> list7, List<String> list8, List<String> list9, int i, int i2, int i3, int i4, AdVideoEndPage adVideoEndPage, String str9, int i5, int i6, int i7, int i8, List<AdCustomPlayUrl> list10) {
        return new AdVideo(str, str2, str3, str4, str5, str6, bool, bool2, str7, str8, list, list2, list3, list4, list5, list6, list7, list8, list9, i, i2, i3, i4, adVideoEndPage, str9, i5, i6, i7, i8, list10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdVideo) {
            AdVideo adVideo = (AdVideo) obj;
            return Intrinsics.areEqual(this.avid, adVideo.avid) && Intrinsics.areEqual(this.cid, adVideo.cid) && Intrinsics.areEqual(this.page, adVideo.page) && Intrinsics.areEqual(this.from, adVideo.from) && Intrinsics.areEqual(this.url, adVideo.url) && Intrinsics.areEqual(this.cover, adVideo.cover) && Intrinsics.areEqual(this.canAutoPlay, adVideo.canAutoPlay) && Intrinsics.areEqual(this.btnDycColor, adVideo.btnDycColor) && Intrinsics.areEqual(this.btnDycTime, adVideo.btnDycTime) && Intrinsics.areEqual(this.bizId, adVideo.bizId) && Intrinsics.areEqual(this.playStartUrls, adVideo.playStartUrls) && Intrinsics.areEqual(this.play3sUrls, adVideo.play3sUrls) && Intrinsics.areEqual(this.play5sUrls, adVideo.play5sUrls) && Intrinsics.areEqual(this.play10sUrls, adVideo.play10sUrls) && Intrinsics.areEqual(this.play15sUrls, adVideo.play15sUrls) && Intrinsics.areEqual(this.play25pUrls, adVideo.play25pUrls) && Intrinsics.areEqual(this.play50pUrls, adVideo.play50pUrls) && Intrinsics.areEqual(this.play75pUrls, adVideo.play75pUrls) && Intrinsics.areEqual(this.play100pUrls, adVideo.play100pUrls) && this.muteButton == adVideo.muteButton && this.progressBar == adVideo.progressBar && this.mutePlay == adVideo.mutePlay && this.hasEndPage == adVideo.hasEndPage && Intrinsics.areEqual(this.endPageInfo, adVideo.endPageInfo) && Intrinsics.areEqual(this.fromSpmid, adVideo.fromSpmid) && this.autoPlayValue == adVideo.autoPlayValue && this.eggStartTime == adVideo.eggStartTime && this.eggEndTime == adVideo.eggEndTime && this.pressTriggerTime == adVideo.pressTriggerTime && Intrinsics.areEqual(this.customPlayUrls, adVideo.customPlayUrls);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.avid == null ? 0 : this.avid.hashCode()) * 31) + (this.cid == null ? 0 : this.cid.hashCode())) * 31) + (this.page == null ? 0 : this.page.hashCode())) * 31) + (this.from == null ? 0 : this.from.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.canAutoPlay == null ? 0 : this.canAutoPlay.hashCode())) * 31) + (this.btnDycColor == null ? 0 : this.btnDycColor.hashCode())) * 31) + (this.btnDycTime == null ? 0 : this.btnDycTime.hashCode())) * 31) + (this.bizId == null ? 0 : this.bizId.hashCode())) * 31) + (this.playStartUrls == null ? 0 : this.playStartUrls.hashCode())) * 31) + (this.play3sUrls == null ? 0 : this.play3sUrls.hashCode())) * 31) + (this.play5sUrls == null ? 0 : this.play5sUrls.hashCode())) * 31) + (this.play10sUrls == null ? 0 : this.play10sUrls.hashCode())) * 31) + (this.play15sUrls == null ? 0 : this.play15sUrls.hashCode())) * 31) + (this.play25pUrls == null ? 0 : this.play25pUrls.hashCode())) * 31) + (this.play50pUrls == null ? 0 : this.play50pUrls.hashCode())) * 31) + (this.play75pUrls == null ? 0 : this.play75pUrls.hashCode())) * 31) + (this.play100pUrls == null ? 0 : this.play100pUrls.hashCode())) * 31) + this.muteButton) * 31) + this.progressBar) * 31) + this.mutePlay) * 31) + this.hasEndPage) * 31) + (this.endPageInfo == null ? 0 : this.endPageInfo.hashCode())) * 31) + (this.fromSpmid == null ? 0 : this.fromSpmid.hashCode())) * 31) + this.autoPlayValue) * 31) + this.eggStartTime) * 31) + this.eggEndTime) * 31) + this.pressTriggerTime) * 31) + (this.customPlayUrls != null ? this.customPlayUrls.hashCode() : 0);
    }

    public String toString() {
        String str = this.avid;
        String str2 = this.cid;
        String str3 = this.page;
        String str4 = this.from;
        String str5 = this.url;
        String str6 = this.cover;
        Boolean bool = this.canAutoPlay;
        Boolean bool2 = this.btnDycColor;
        String str7 = this.btnDycTime;
        String str8 = this.bizId;
        List<String> list = this.playStartUrls;
        List<String> list2 = this.play3sUrls;
        List<String> list3 = this.play5sUrls;
        List<String> list4 = this.play10sUrls;
        List<String> list5 = this.play15sUrls;
        List<String> list6 = this.play25pUrls;
        List<String> list7 = this.play50pUrls;
        List<String> list8 = this.play75pUrls;
        List<String> list9 = this.play100pUrls;
        int i = this.muteButton;
        int i2 = this.progressBar;
        int i3 = this.mutePlay;
        int i4 = this.hasEndPage;
        AdVideoEndPage adVideoEndPage = this.endPageInfo;
        String str9 = this.fromSpmid;
        int i5 = this.autoPlayValue;
        int i6 = this.eggStartTime;
        int i7 = this.eggEndTime;
        int i8 = this.pressTriggerTime;
        return "AdVideo(avid=" + str + ", cid=" + str2 + ", page=" + str3 + ", from=" + str4 + ", url=" + str5 + ", cover=" + str6 + ", canAutoPlay=" + bool + ", btnDycColor=" + bool2 + ", btnDycTime=" + str7 + ", bizId=" + str8 + ", playStartUrls=" + list + ", play3sUrls=" + list2 + ", play5sUrls=" + list3 + ", play10sUrls=" + list4 + ", play15sUrls=" + list5 + ", play25pUrls=" + list6 + ", play50pUrls=" + list7 + ", play75pUrls=" + list8 + ", play100pUrls=" + list9 + ", muteButton=" + i + ", progressBar=" + i2 + ", mutePlay=" + i3 + ", hasEndPage=" + i4 + ", endPageInfo=" + adVideoEndPage + ", fromSpmid=" + str9 + ", autoPlayValue=" + i5 + ", eggStartTime=" + i6 + ", eggEndTime=" + i7 + ", pressTriggerTime=" + i8 + ", customPlayUrls=" + this.customPlayUrls + ")";
    }

    /* compiled from: AdVideo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdVideo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdVideo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdVideo> serializer() {
            return AdVideo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdVideo(int seen0, String avid, String cid, String page, String from, String url, String cover, Boolean canAutoPlay, Boolean btnDycColor, String btnDycTime, String bizId, List playStartUrls, List play3sUrls, List play5sUrls, List play10sUrls, List play15sUrls, List play25pUrls, List play50pUrls, List play75pUrls, List play100pUrls, int muteButton, int progressBar, int mutePlay, int hasEndPage, AdVideoEndPage endPageInfo, String fromSpmid, int autoPlayValue, int eggStartTime, int eggEndTime, int pressTriggerTime, List customPlayUrls, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.avid = null;
        } else {
            this.avid = avid;
        }
        if ((seen0 & 2) == 0) {
            this.cid = null;
        } else {
            this.cid = cid;
        }
        if ((seen0 & 4) == 0) {
            this.page = null;
        } else {
            this.page = page;
        }
        if ((seen0 & 8) == 0) {
            this.from = null;
        } else {
            this.from = from;
        }
        if ((seen0 & 16) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 32) == 0) {
            this.cover = null;
        } else {
            this.cover = cover;
        }
        if ((seen0 & 64) == 0) {
            this.canAutoPlay = null;
        } else {
            this.canAutoPlay = canAutoPlay;
        }
        if ((seen0 & 128) == 0) {
            this.btnDycColor = null;
        } else {
            this.btnDycColor = btnDycColor;
        }
        if ((seen0 & 256) == 0) {
            this.btnDycTime = null;
        } else {
            this.btnDycTime = btnDycTime;
        }
        if ((seen0 & 512) == 0) {
            this.bizId = null;
        } else {
            this.bizId = bizId;
        }
        if ((seen0 & 1024) == 0) {
            this.playStartUrls = null;
        } else {
            this.playStartUrls = playStartUrls;
        }
        if ((seen0 & 2048) == 0) {
            this.play3sUrls = null;
        } else {
            this.play3sUrls = play3sUrls;
        }
        if ((seen0 & 4096) == 0) {
            this.play5sUrls = null;
        } else {
            this.play5sUrls = play5sUrls;
        }
        if ((seen0 & 8192) == 0) {
            this.play10sUrls = null;
        } else {
            this.play10sUrls = play10sUrls;
        }
        if ((seen0 & 16384) == 0) {
            this.play15sUrls = null;
        } else {
            this.play15sUrls = play15sUrls;
        }
        if ((seen0 & 32768) == 0) {
            this.play25pUrls = null;
        } else {
            this.play25pUrls = play25pUrls;
        }
        if ((seen0 & 65536) == 0) {
            this.play50pUrls = null;
        } else {
            this.play50pUrls = play50pUrls;
        }
        if ((seen0 & 131072) == 0) {
            this.play75pUrls = null;
        } else {
            this.play75pUrls = play75pUrls;
        }
        if ((seen0 & 262144) == 0) {
            this.play100pUrls = null;
        } else {
            this.play100pUrls = play100pUrls;
        }
        if ((seen0 & 524288) == 0) {
            this.muteButton = 1;
        } else {
            this.muteButton = muteButton;
        }
        if ((seen0 & 1048576) == 0) {
            this.progressBar = 1;
        } else {
            this.progressBar = progressBar;
        }
        if ((seen0 & 2097152) == 0) {
            this.mutePlay = 0;
        } else {
            this.mutePlay = mutePlay;
        }
        if ((seen0 & 4194304) == 0) {
            this.hasEndPage = 0;
        } else {
            this.hasEndPage = hasEndPage;
        }
        if ((seen0 & 8388608) == 0) {
            this.endPageInfo = null;
        } else {
            this.endPageInfo = endPageInfo;
        }
        if ((seen0 & 16777216) == 0) {
            this.fromSpmid = null;
        } else {
            this.fromSpmid = fromSpmid;
        }
        if ((seen0 & 33554432) == 0) {
            this.autoPlayValue = 0;
        } else {
            this.autoPlayValue = autoPlayValue;
        }
        if ((seen0 & 67108864) == 0) {
            this.eggStartTime = 0;
        } else {
            this.eggStartTime = eggStartTime;
        }
        if ((seen0 & 134217728) == 0) {
            this.eggEndTime = 0;
        } else {
            this.eggEndTime = eggEndTime;
        }
        if ((seen0 & 268435456) == 0) {
            this.pressTriggerTime = 0;
        } else {
            this.pressTriggerTime = pressTriggerTime;
        }
        if ((seen0 & 536870912) == 0) {
            this.customPlayUrls = null;
        } else {
            this.customPlayUrls = customPlayUrls;
        }
    }

    public AdVideo(String avid, String cid, String page, String from, String url, String cover, Boolean canAutoPlay, Boolean btnDycColor, String btnDycTime, String bizId, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<String> list7, List<String> list8, List<String> list9, int muteButton, int progressBar, int mutePlay, int hasEndPage, AdVideoEndPage endPageInfo, String fromSpmid, int autoPlayValue, int eggStartTime, int eggEndTime, int pressTriggerTime, List<AdCustomPlayUrl> list10) {
        this.avid = avid;
        this.cid = cid;
        this.page = page;
        this.from = from;
        this.url = url;
        this.cover = cover;
        this.canAutoPlay = canAutoPlay;
        this.btnDycColor = btnDycColor;
        this.btnDycTime = btnDycTime;
        this.bizId = bizId;
        this.playStartUrls = list;
        this.play3sUrls = list2;
        this.play5sUrls = list3;
        this.play10sUrls = list4;
        this.play15sUrls = list5;
        this.play25pUrls = list6;
        this.play50pUrls = list7;
        this.play75pUrls = list8;
        this.play100pUrls = list9;
        this.muteButton = muteButton;
        this.progressBar = progressBar;
        this.mutePlay = mutePlay;
        this.hasEndPage = hasEndPage;
        this.endPageInfo = endPageInfo;
        this.fromSpmid = fromSpmid;
        this.autoPlayValue = autoPlayValue;
        this.eggStartTime = eggStartTime;
        this.eggEndTime = eggEndTime;
        this.pressTriggerTime = pressTriggerTime;
        this.customPlayUrls = list10;
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
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
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
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdCustomPlayUrl$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdVideo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.avid != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.avid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.cid != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.cid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.page != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.page);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.from != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.from);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.cover != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.canAutoPlay != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.canAutoPlay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.btnDycColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.btnDycColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.btnDycTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.btnDycTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.bizId != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.bizId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.playStartUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy) lazyArr[10].getValue(), self.playStartUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.play3sUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy) lazyArr[11].getValue(), self.play3sUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.play5sUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, (SerializationStrategy) lazyArr[12].getValue(), self.play5sUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.play10sUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, (SerializationStrategy) lazyArr[13].getValue(), self.play10sUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.play15sUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, (SerializationStrategy) lazyArr[14].getValue(), self.play15sUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.play25pUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, (SerializationStrategy) lazyArr[15].getValue(), self.play25pUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.play50pUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, (SerializationStrategy) lazyArr[16].getValue(), self.play50pUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.play75pUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, (SerializationStrategy) lazyArr[17].getValue(), self.play75pUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.play100pUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, (SerializationStrategy) lazyArr[18].getValue(), self.play100pUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.muteButton != 1) {
            output.encodeIntElement(serialDesc, 19, self.muteButton);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.progressBar != 1) {
            output.encodeIntElement(serialDesc, 20, self.progressBar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.mutePlay != 0) {
            output.encodeIntElement(serialDesc, 21, self.mutePlay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.hasEndPage != 0) {
            output.encodeIntElement(serialDesc, 22, self.hasEndPage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.endPageInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, AdVideoEndPage$$serializer.INSTANCE, self.endPageInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.fromSpmid != null) {
            output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.fromSpmid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || self.autoPlayValue != 0) {
            output.encodeIntElement(serialDesc, 25, self.autoPlayValue);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.eggStartTime != 0) {
            output.encodeIntElement(serialDesc, 26, self.eggStartTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.eggEndTime != 0) {
            output.encodeIntElement(serialDesc, 27, self.eggEndTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || self.pressTriggerTime != 0) {
            output.encodeIntElement(serialDesc, 28, self.pressTriggerTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.customPlayUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 29, (SerializationStrategy) lazyArr[29].getValue(), self.customPlayUrls);
        }
    }

    public /* synthetic */ AdVideo(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, String str8, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, int i, int i2, int i3, int i4, AdVideoEndPage adVideoEndPage, String str9, int i5, int i6, int i7, int i8, List list10, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? null : str, (i9 & 2) != 0 ? null : str2, (i9 & 4) != 0 ? null : str3, (i9 & 8) != 0 ? null : str4, (i9 & 16) != 0 ? null : str5, (i9 & 32) != 0 ? null : str6, (i9 & 64) != 0 ? null : bool, (i9 & 128) != 0 ? null : bool2, (i9 & 256) != 0 ? null : str7, (i9 & 512) != 0 ? null : str8, (i9 & 1024) != 0 ? null : list, (i9 & 2048) != 0 ? null : list2, (i9 & 4096) != 0 ? null : list3, (i9 & 8192) != 0 ? null : list4, (i9 & 16384) != 0 ? null : list5, (i9 & 32768) != 0 ? null : list6, (i9 & 65536) != 0 ? null : list7, (i9 & 131072) != 0 ? null : list8, (i9 & 262144) != 0 ? null : list9, (i9 & 524288) != 0 ? 1 : i, (i9 & 1048576) == 0 ? i2 : 1, (i9 & 2097152) != 0 ? 0 : i3, (i9 & 4194304) != 0 ? 0 : i4, (i9 & 8388608) != 0 ? null : adVideoEndPage, (i9 & 16777216) != 0 ? null : str9, (i9 & 33554432) != 0 ? 0 : i5, (i9 & 67108864) != 0 ? 0 : i6, (i9 & 134217728) != 0 ? 0 : i7, (i9 & 268435456) == 0 ? i8 : 0, (i9 & 536870912) != 0 ? null : list10);
    }

    public final String getAvid() {
        return this.avid;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getPage() {
        return this.page;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getCover() {
        return this.cover;
    }

    public final Boolean getCanAutoPlay() {
        return this.canAutoPlay;
    }

    public final Boolean getBtnDycColor() {
        return this.btnDycColor;
    }

    public final String getBtnDycTime() {
        return this.btnDycTime;
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final List<String> getPlayStartUrls() {
        return this.playStartUrls;
    }

    public final List<String> getPlay3sUrls() {
        return this.play3sUrls;
    }

    public final List<String> getPlay5sUrls() {
        return this.play5sUrls;
    }

    public final List<String> getPlay10sUrls() {
        return this.play10sUrls;
    }

    public final List<String> getPlay15sUrls() {
        return this.play15sUrls;
    }

    public final List<String> getPlay25pUrls() {
        return this.play25pUrls;
    }

    public final List<String> getPlay50pUrls() {
        return this.play50pUrls;
    }

    public final List<String> getPlay75pUrls() {
        return this.play75pUrls;
    }

    public final List<String> getPlay100pUrls() {
        return this.play100pUrls;
    }

    public final int getMuteButton() {
        return this.muteButton;
    }

    public final int getProgressBar() {
        return this.progressBar;
    }

    public final int getMutePlay() {
        return this.mutePlay;
    }

    public final int getHasEndPage() {
        return this.hasEndPage;
    }

    public final AdVideoEndPage getEndPageInfo() {
        return this.endPageInfo;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final int getAutoPlayValue() {
        return this.autoPlayValue;
    }

    public final int getEggStartTime() {
        return this.eggStartTime;
    }

    public final int getEggEndTime() {
        return this.eggEndTime;
    }

    public final int getPressTriggerTime() {
        return this.pressTriggerTime;
    }

    public final List<AdCustomPlayUrl> getCustomPlayUrls() {
        return this.customPlayUrls;
    }
}