package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.ShopItem;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: ShopInfoFloor.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\bZ\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u0000  \u00012\u00020\u0001:\u0012\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001B\u0099\u0003\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010'¢\u0006\u0004\b1\u00102Bó\u0002\b\u0010\u0012\u0006\u00103\u001a\u00020'\u0012\u0006\u00104\u001a\u00020'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\u0010$\u001a\u0004\u0018\u00010\b\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010&\u001a\u0004\u0018\u00010'\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010)\u001a\u0004\u0018\u00010'\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010,\u001a\u0004\u0018\u00010'\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\b\u00100\u001a\u0004\u0018\u00010'\u0012\b\u00105\u001a\u0004\u0018\u000106¢\u0006\u0004\b1\u00107J\u0011\u0010i\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010l\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010GJ\u0010\u0010q\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010GJ\u000b\u0010r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010u\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010v\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010GJ\u000b\u0010w\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010y\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010GJ\u0010\u0010z\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010GJ\u000b\u0010{\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010#HÆ\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010GJ\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0002\u0010^J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0002\u0010^J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0002\u0010^J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0002\u0010^J¢\u0003\u0010\u008a\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00100\u001a\u0004\u0018\u00010'HÆ\u0001¢\u0006\u0003\u0010\u008b\u0001J\u0015\u0010\u008c\u0001\u001a\u00020\b2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u008e\u0001\u001a\u00020'HÖ\u0001J\n\u0010\u008f\u0001\u001a\u00020\u0006HÖ\u0001J-\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0092\u0001\u001a\u00020\u00002\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0001¢\u0006\u0003\b\u0097\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010>\u001a\u0004\b<\u0010=R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bC\u0010BR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010H\u001a\u0004\bF\u0010GR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010H\u001a\u0004\bI\u0010GR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010;R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bK\u0010;R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010>\u001a\u0004\bN\u0010=R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010H\u001a\u0004\bO\u0010GR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010>\u001a\u0004\bR\u0010=R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010H\u001a\u0004\bS\u0010GR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010H\u001a\u0004\bT\u0010GR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0015\u0010$\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010>\u001a\u0004\b[\u0010=R\u0015\u0010%\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010H\u001a\u0004\b\\\u0010GR\u0015\u0010&\u001a\u0004\u0018\u00010'¢\u0006\n\n\u0002\u0010_\u001a\u0004\b]\u0010^R\u0013\u0010(\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b`\u0010;R\u0015\u0010)\u001a\u0004\u0018\u00010'¢\u0006\n\n\u0002\u0010_\u001a\u0004\ba\u0010^R\u0013\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bb\u0010;R\u0013\u0010+\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bc\u0010;R\u0015\u0010,\u001a\u0004\u0018\u00010'¢\u0006\n\n\u0002\u0010_\u001a\u0004\bd\u0010^R\u0013\u0010-\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\be\u0010;R\u0013\u0010.\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bf\u0010;R\u0013\u0010/\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bg\u0010;R\u0015\u00100\u001a\u0004\u0018\u00010'¢\u0006\n\n\u0002\u0010_\u001a\u0004\bh\u0010^¨\u0006¡\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem;", "", "activityDTOList", "", "Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO;", "aid", "", "canAddCart", "", "coverVO", "Lkntr/app/mall/product/details/page/api/model/CoverVO;", "feedLabel", "Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;", "feedTag", "ichibanInfoVO", "Lkntr/app/mall/product/details/page/api/model/ShopItem$IchibanInfoVO;", "itemCode", "", "itemsId", "itemsIndexDesc", "itemsName", "jumpUrlVO", "Lkntr/app/mall/product/details/page/api/model/ShopItem$JumpUrlVO;", "marketItemCard", "merchantId", "merchantInfo", "Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;", "multiSku", "preSaleEndTime", "preSaleStartTime", "priceInfoVO", "Lkntr/app/mall/product/details/page/api/model/ShopItem$PriceInfoVO;", "promotionImgDto", "Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg;", "reportParams", "Lkotlinx/serialization/json/JsonObject;", "sellOut", "skuId", "soldCount", "", "soldCountDesc", "source", "sourceBizType", "sourceName", "status", "subTitle", "text", "vurl", "wishCount", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/CoverVO;Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;Lkntr/app/mall/product/details/page/api/model/ShopItem$IchibanInfoVO;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$JumpUrlVO;Ljava/lang/Boolean;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/ShopItem$PriceInfoVO;Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg;Lkotlinx/serialization/json/JsonObject;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/CoverVO;Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;Lkntr/app/mall/product/details/page/api/model/ShopItem$IchibanInfoVO;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$JumpUrlVO;Ljava/lang/Boolean;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/ShopItem$PriceInfoVO;Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg;Lkotlinx/serialization/json/JsonObject;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityDTOList", "()Ljava/util/List;", "getAid", "()Ljava/lang/String;", "getCanAddCart", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCoverVO", "()Lkntr/app/mall/product/details/page/api/model/CoverVO;", "getFeedLabel", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;", "getFeedTag", "getIchibanInfoVO", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$IchibanInfoVO;", "getItemCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getItemsId", "getItemsIndexDesc", "getItemsName", "getJumpUrlVO", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$JumpUrlVO;", "getMarketItemCard", "getMerchantId", "getMerchantInfo", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;", "getMultiSku", "getPreSaleEndTime", "getPreSaleStartTime", "getPriceInfoVO", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$PriceInfoVO;", "getPromotionImgDto", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg;", "getReportParams", "()Lkotlinx/serialization/json/JsonObject;", "getSellOut", "getSkuId", "getSoldCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSoldCountDesc", "getSource", "getSourceBizType", "getSourceName", "getStatus", "getSubTitle", "getText", "getVurl", "getWishCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/CoverVO;Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;Lkntr/app/mall/product/details/page/api/model/ShopItem$IchibanInfoVO;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$JumpUrlVO;Ljava/lang/Boolean;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/ShopItem$PriceInfoVO;Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg;Lkotlinx/serialization/json/JsonObject;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/ShopItem;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ActivityDTO", "LabelGroup", "IchibanInfoVO", "JumpUrlVO", "MerchantInfo", "PriceInfoVO", "PromotionImg", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ShopItem {
    private final List<ActivityDTO> activityDTOList;
    private final String aid;
    private final Boolean canAddCart;
    private final CoverVO coverVO;
    private final LabelGroup feedLabel;
    private final LabelGroup feedTag;
    private final IchibanInfoVO ichibanInfoVO;
    private final Long itemCode;
    private final Long itemsId;
    private final String itemsIndexDesc;
    private final String itemsName;
    private final JumpUrlVO jumpUrlVO;
    private final Boolean marketItemCard;
    private final Long merchantId;
    private final MerchantInfo merchantInfo;
    private final Boolean multiSku;
    private final Long preSaleEndTime;
    private final Long preSaleStartTime;
    private final PriceInfoVO priceInfoVO;
    private final PromotionImg promotionImgDto;
    private final JsonObject reportParams;
    private final Boolean sellOut;
    private final Long skuId;
    private final Integer soldCount;
    private final String soldCountDesc;
    private final Integer source;
    private final String sourceBizType;
    private final String sourceName;
    private final Integer status;
    private final String subTitle;
    private final String text;
    private final String vurl;
    private final Integer wishCount;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ShopItem$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ShopItem._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    public ShopItem() {
        this((List) null, (String) null, (Boolean) null, (CoverVO) null, (LabelGroup) null, (LabelGroup) null, (IchibanInfoVO) null, (Long) null, (Long) null, (String) null, (String) null, (JumpUrlVO) null, (Boolean) null, (Long) null, (MerchantInfo) null, (Boolean) null, (Long) null, (Long) null, (PriceInfoVO) null, (PromotionImg) null, (JsonObject) null, (Boolean) null, (Long) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, -1, 1, (DefaultConstructorMarker) null);
    }

    public final List<ActivityDTO> component1() {
        return this.activityDTOList;
    }

    public final String component10() {
        return this.itemsIndexDesc;
    }

    public final String component11() {
        return this.itemsName;
    }

    public final JumpUrlVO component12() {
        return this.jumpUrlVO;
    }

    public final Boolean component13() {
        return this.marketItemCard;
    }

    public final Long component14() {
        return this.merchantId;
    }

    public final MerchantInfo component15() {
        return this.merchantInfo;
    }

    public final Boolean component16() {
        return this.multiSku;
    }

    public final Long component17() {
        return this.preSaleEndTime;
    }

    public final Long component18() {
        return this.preSaleStartTime;
    }

    public final PriceInfoVO component19() {
        return this.priceInfoVO;
    }

    public final String component2() {
        return this.aid;
    }

    public final PromotionImg component20() {
        return this.promotionImgDto;
    }

    public final JsonObject component21() {
        return this.reportParams;
    }

    public final Boolean component22() {
        return this.sellOut;
    }

    public final Long component23() {
        return this.skuId;
    }

    public final Integer component24() {
        return this.soldCount;
    }

    public final String component25() {
        return this.soldCountDesc;
    }

    public final Integer component26() {
        return this.source;
    }

    public final String component27() {
        return this.sourceBizType;
    }

    public final String component28() {
        return this.sourceName;
    }

    public final Integer component29() {
        return this.status;
    }

    public final Boolean component3() {
        return this.canAddCart;
    }

    public final String component30() {
        return this.subTitle;
    }

    public final String component31() {
        return this.text;
    }

    public final String component32() {
        return this.vurl;
    }

    public final Integer component33() {
        return this.wishCount;
    }

    public final CoverVO component4() {
        return this.coverVO;
    }

    public final LabelGroup component5() {
        return this.feedLabel;
    }

    public final LabelGroup component6() {
        return this.feedTag;
    }

    public final IchibanInfoVO component7() {
        return this.ichibanInfoVO;
    }

    public final Long component8() {
        return this.itemCode;
    }

    public final Long component9() {
        return this.itemsId;
    }

    public final ShopItem copy(List<ActivityDTO> list, String str, Boolean bool, CoverVO coverVO, LabelGroup labelGroup, LabelGroup labelGroup2, IchibanInfoVO ichibanInfoVO, Long l, Long l2, String str2, String str3, JumpUrlVO jumpUrlVO, Boolean bool2, Long l3, MerchantInfo merchantInfo, Boolean bool3, Long l4, Long l5, PriceInfoVO priceInfoVO, PromotionImg promotionImg, JsonObject jsonObject, Boolean bool4, Long l6, Integer num, String str4, Integer num2, String str5, String str6, Integer num3, String str7, String str8, String str9, Integer num4) {
        return new ShopItem(list, str, bool, coverVO, labelGroup, labelGroup2, ichibanInfoVO, l, l2, str2, str3, jumpUrlVO, bool2, l3, merchantInfo, bool3, l4, l5, priceInfoVO, promotionImg, jsonObject, bool4, l6, num, str4, num2, str5, str6, num3, str7, str8, str9, num4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShopItem) {
            ShopItem shopItem = (ShopItem) obj;
            return Intrinsics.areEqual(this.activityDTOList, shopItem.activityDTOList) && Intrinsics.areEqual(this.aid, shopItem.aid) && Intrinsics.areEqual(this.canAddCart, shopItem.canAddCart) && Intrinsics.areEqual(this.coverVO, shopItem.coverVO) && Intrinsics.areEqual(this.feedLabel, shopItem.feedLabel) && Intrinsics.areEqual(this.feedTag, shopItem.feedTag) && Intrinsics.areEqual(this.ichibanInfoVO, shopItem.ichibanInfoVO) && Intrinsics.areEqual(this.itemCode, shopItem.itemCode) && Intrinsics.areEqual(this.itemsId, shopItem.itemsId) && Intrinsics.areEqual(this.itemsIndexDesc, shopItem.itemsIndexDesc) && Intrinsics.areEqual(this.itemsName, shopItem.itemsName) && Intrinsics.areEqual(this.jumpUrlVO, shopItem.jumpUrlVO) && Intrinsics.areEqual(this.marketItemCard, shopItem.marketItemCard) && Intrinsics.areEqual(this.merchantId, shopItem.merchantId) && Intrinsics.areEqual(this.merchantInfo, shopItem.merchantInfo) && Intrinsics.areEqual(this.multiSku, shopItem.multiSku) && Intrinsics.areEqual(this.preSaleEndTime, shopItem.preSaleEndTime) && Intrinsics.areEqual(this.preSaleStartTime, shopItem.preSaleStartTime) && Intrinsics.areEqual(this.priceInfoVO, shopItem.priceInfoVO) && Intrinsics.areEqual(this.promotionImgDto, shopItem.promotionImgDto) && Intrinsics.areEqual(this.reportParams, shopItem.reportParams) && Intrinsics.areEqual(this.sellOut, shopItem.sellOut) && Intrinsics.areEqual(this.skuId, shopItem.skuId) && Intrinsics.areEqual(this.soldCount, shopItem.soldCount) && Intrinsics.areEqual(this.soldCountDesc, shopItem.soldCountDesc) && Intrinsics.areEqual(this.source, shopItem.source) && Intrinsics.areEqual(this.sourceBizType, shopItem.sourceBizType) && Intrinsics.areEqual(this.sourceName, shopItem.sourceName) && Intrinsics.areEqual(this.status, shopItem.status) && Intrinsics.areEqual(this.subTitle, shopItem.subTitle) && Intrinsics.areEqual(this.text, shopItem.text) && Intrinsics.areEqual(this.vurl, shopItem.vurl) && Intrinsics.areEqual(this.wishCount, shopItem.wishCount);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.activityDTOList == null ? 0 : this.activityDTOList.hashCode()) * 31) + (this.aid == null ? 0 : this.aid.hashCode())) * 31) + (this.canAddCart == null ? 0 : this.canAddCart.hashCode())) * 31) + (this.coverVO == null ? 0 : this.coverVO.hashCode())) * 31) + (this.feedLabel == null ? 0 : this.feedLabel.hashCode())) * 31) + (this.feedTag == null ? 0 : this.feedTag.hashCode())) * 31) + (this.ichibanInfoVO == null ? 0 : this.ichibanInfoVO.hashCode())) * 31) + (this.itemCode == null ? 0 : this.itemCode.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.itemsIndexDesc == null ? 0 : this.itemsIndexDesc.hashCode())) * 31) + (this.itemsName == null ? 0 : this.itemsName.hashCode())) * 31) + (this.jumpUrlVO == null ? 0 : this.jumpUrlVO.hashCode())) * 31) + (this.marketItemCard == null ? 0 : this.marketItemCard.hashCode())) * 31) + (this.merchantId == null ? 0 : this.merchantId.hashCode())) * 31) + (this.merchantInfo == null ? 0 : this.merchantInfo.hashCode())) * 31) + (this.multiSku == null ? 0 : this.multiSku.hashCode())) * 31) + (this.preSaleEndTime == null ? 0 : this.preSaleEndTime.hashCode())) * 31) + (this.preSaleStartTime == null ? 0 : this.preSaleStartTime.hashCode())) * 31) + (this.priceInfoVO == null ? 0 : this.priceInfoVO.hashCode())) * 31) + (this.promotionImgDto == null ? 0 : this.promotionImgDto.hashCode())) * 31) + (this.reportParams == null ? 0 : this.reportParams.hashCode())) * 31) + (this.sellOut == null ? 0 : this.sellOut.hashCode())) * 31) + (this.skuId == null ? 0 : this.skuId.hashCode())) * 31) + (this.soldCount == null ? 0 : this.soldCount.hashCode())) * 31) + (this.soldCountDesc == null ? 0 : this.soldCountDesc.hashCode())) * 31) + (this.source == null ? 0 : this.source.hashCode())) * 31) + (this.sourceBizType == null ? 0 : this.sourceBizType.hashCode())) * 31) + (this.sourceName == null ? 0 : this.sourceName.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.subTitle == null ? 0 : this.subTitle.hashCode())) * 31) + (this.text == null ? 0 : this.text.hashCode())) * 31) + (this.vurl == null ? 0 : this.vurl.hashCode())) * 31) + (this.wishCount != null ? this.wishCount.hashCode() : 0);
    }

    public String toString() {
        List<ActivityDTO> list = this.activityDTOList;
        String str = this.aid;
        Boolean bool = this.canAddCart;
        CoverVO coverVO = this.coverVO;
        LabelGroup labelGroup = this.feedLabel;
        LabelGroup labelGroup2 = this.feedTag;
        IchibanInfoVO ichibanInfoVO = this.ichibanInfoVO;
        Long l = this.itemCode;
        Long l2 = this.itemsId;
        String str2 = this.itemsIndexDesc;
        String str3 = this.itemsName;
        JumpUrlVO jumpUrlVO = this.jumpUrlVO;
        Boolean bool2 = this.marketItemCard;
        Long l3 = this.merchantId;
        MerchantInfo merchantInfo = this.merchantInfo;
        Boolean bool3 = this.multiSku;
        Long l4 = this.preSaleEndTime;
        Long l5 = this.preSaleStartTime;
        PriceInfoVO priceInfoVO = this.priceInfoVO;
        PromotionImg promotionImg = this.promotionImgDto;
        JsonObject jsonObject = this.reportParams;
        Boolean bool4 = this.sellOut;
        Long l6 = this.skuId;
        Integer num = this.soldCount;
        String str4 = this.soldCountDesc;
        Integer num2 = this.source;
        String str5 = this.sourceBizType;
        String str6 = this.sourceName;
        Integer num3 = this.status;
        String str7 = this.subTitle;
        String str8 = this.text;
        String str9 = this.vurl;
        return "ShopItem(activityDTOList=" + list + ", aid=" + str + ", canAddCart=" + bool + ", coverVO=" + coverVO + ", feedLabel=" + labelGroup + ", feedTag=" + labelGroup2 + ", ichibanInfoVO=" + ichibanInfoVO + ", itemCode=" + l + ", itemsId=" + l2 + ", itemsIndexDesc=" + str2 + ", itemsName=" + str3 + ", jumpUrlVO=" + jumpUrlVO + ", marketItemCard=" + bool2 + ", merchantId=" + l3 + ", merchantInfo=" + merchantInfo + ", multiSku=" + bool3 + ", preSaleEndTime=" + l4 + ", preSaleStartTime=" + l5 + ", priceInfoVO=" + priceInfoVO + ", promotionImgDto=" + promotionImg + ", reportParams=" + jsonObject + ", sellOut=" + bool4 + ", skuId=" + l6 + ", soldCount=" + num + ", soldCountDesc=" + str4 + ", source=" + num2 + ", sourceBizType=" + str5 + ", sourceName=" + str6 + ", status=" + num3 + ", subTitle=" + str7 + ", text=" + str8 + ", vurl=" + str9 + ", wishCount=" + this.wishCount + ")";
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShopItem> serializer() {
            return ShopItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ShopItem(int seen0, int seen1, List activityDTOList, String aid, Boolean canAddCart, CoverVO coverVO, LabelGroup feedLabel, LabelGroup feedTag, IchibanInfoVO ichibanInfoVO, Long itemCode, Long itemsId, String itemsIndexDesc, String itemsName, JumpUrlVO jumpUrlVO, Boolean marketItemCard, Long merchantId, MerchantInfo merchantInfo, Boolean multiSku, Long preSaleEndTime, Long preSaleStartTime, PriceInfoVO priceInfoVO, PromotionImg promotionImgDto, JsonObject reportParams, Boolean sellOut, Long skuId, Integer soldCount, String soldCountDesc, Integer source, String sourceBizType, String sourceName, Integer status, String subTitle, String text, String vurl, Integer wishCount, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.activityDTOList = null;
        } else {
            this.activityDTOList = activityDTOList;
        }
        if ((seen0 & 2) == 0) {
            this.aid = null;
        } else {
            this.aid = aid;
        }
        if ((seen0 & 4) == 0) {
            this.canAddCart = null;
        } else {
            this.canAddCart = canAddCart;
        }
        if ((seen0 & 8) == 0) {
            this.coverVO = null;
        } else {
            this.coverVO = coverVO;
        }
        if ((seen0 & 16) == 0) {
            this.feedLabel = null;
        } else {
            this.feedLabel = feedLabel;
        }
        if ((seen0 & 32) == 0) {
            this.feedTag = null;
        } else {
            this.feedTag = feedTag;
        }
        if ((seen0 & 64) == 0) {
            this.ichibanInfoVO = null;
        } else {
            this.ichibanInfoVO = ichibanInfoVO;
        }
        if ((seen0 & 128) == 0) {
            this.itemCode = null;
        } else {
            this.itemCode = itemCode;
        }
        if ((seen0 & 256) == 0) {
            this.itemsId = null;
        } else {
            this.itemsId = itemsId;
        }
        if ((seen0 & 512) == 0) {
            this.itemsIndexDesc = null;
        } else {
            this.itemsIndexDesc = itemsIndexDesc;
        }
        if ((seen0 & 1024) == 0) {
            this.itemsName = null;
        } else {
            this.itemsName = itemsName;
        }
        if ((seen0 & 2048) == 0) {
            this.jumpUrlVO = null;
        } else {
            this.jumpUrlVO = jumpUrlVO;
        }
        if ((seen0 & 4096) == 0) {
            this.marketItemCard = null;
        } else {
            this.marketItemCard = marketItemCard;
        }
        if ((seen0 & 8192) == 0) {
            this.merchantId = null;
        } else {
            this.merchantId = merchantId;
        }
        if ((seen0 & 16384) == 0) {
            this.merchantInfo = null;
        } else {
            this.merchantInfo = merchantInfo;
        }
        if ((seen0 & 32768) == 0) {
            this.multiSku = null;
        } else {
            this.multiSku = multiSku;
        }
        if ((seen0 & 65536) == 0) {
            this.preSaleEndTime = null;
        } else {
            this.preSaleEndTime = preSaleEndTime;
        }
        if ((seen0 & 131072) == 0) {
            this.preSaleStartTime = null;
        } else {
            this.preSaleStartTime = preSaleStartTime;
        }
        if ((seen0 & 262144) == 0) {
            this.priceInfoVO = null;
        } else {
            this.priceInfoVO = priceInfoVO;
        }
        if ((seen0 & 524288) == 0) {
            this.promotionImgDto = null;
        } else {
            this.promotionImgDto = promotionImgDto;
        }
        if ((seen0 & 1048576) == 0) {
            this.reportParams = null;
        } else {
            this.reportParams = reportParams;
        }
        if ((seen0 & 2097152) == 0) {
            this.sellOut = null;
        } else {
            this.sellOut = sellOut;
        }
        if ((seen0 & 4194304) == 0) {
            this.skuId = null;
        } else {
            this.skuId = skuId;
        }
        if ((seen0 & 8388608) == 0) {
            this.soldCount = null;
        } else {
            this.soldCount = soldCount;
        }
        if ((seen0 & 16777216) == 0) {
            this.soldCountDesc = null;
        } else {
            this.soldCountDesc = soldCountDesc;
        }
        if ((seen0 & 33554432) == 0) {
            this.source = null;
        } else {
            this.source = source;
        }
        if ((seen0 & 67108864) == 0) {
            this.sourceBizType = null;
        } else {
            this.sourceBizType = sourceBizType;
        }
        if ((seen0 & 134217728) == 0) {
            this.sourceName = null;
        } else {
            this.sourceName = sourceName;
        }
        if ((seen0 & 268435456) == 0) {
            this.status = null;
        } else {
            this.status = status;
        }
        if ((seen0 & 536870912) == 0) {
            this.subTitle = null;
        } else {
            this.subTitle = subTitle;
        }
        if ((seen0 & 1073741824) == 0) {
            this.text = null;
        } else {
            this.text = text;
        }
        if ((seen0 & Integer.MIN_VALUE) == 0) {
            this.vurl = null;
        } else {
            this.vurl = vurl;
        }
        if ((seen1 & 1) == 0) {
            this.wishCount = null;
        } else {
            this.wishCount = wishCount;
        }
    }

    public ShopItem(List<ActivityDTO> list, String aid, Boolean canAddCart, CoverVO coverVO, LabelGroup feedLabel, LabelGroup feedTag, IchibanInfoVO ichibanInfoVO, Long itemCode, Long itemsId, String itemsIndexDesc, String itemsName, JumpUrlVO jumpUrlVO, Boolean marketItemCard, Long merchantId, MerchantInfo merchantInfo, Boolean multiSku, Long preSaleEndTime, Long preSaleStartTime, PriceInfoVO priceInfoVO, PromotionImg promotionImgDto, JsonObject reportParams, Boolean sellOut, Long skuId, Integer soldCount, String soldCountDesc, Integer source, String sourceBizType, String sourceName, Integer status, String subTitle, String text, String vurl, Integer wishCount) {
        this.activityDTOList = list;
        this.aid = aid;
        this.canAddCart = canAddCart;
        this.coverVO = coverVO;
        this.feedLabel = feedLabel;
        this.feedTag = feedTag;
        this.ichibanInfoVO = ichibanInfoVO;
        this.itemCode = itemCode;
        this.itemsId = itemsId;
        this.itemsIndexDesc = itemsIndexDesc;
        this.itemsName = itemsName;
        this.jumpUrlVO = jumpUrlVO;
        this.marketItemCard = marketItemCard;
        this.merchantId = merchantId;
        this.merchantInfo = merchantInfo;
        this.multiSku = multiSku;
        this.preSaleEndTime = preSaleEndTime;
        this.preSaleStartTime = preSaleStartTime;
        this.priceInfoVO = priceInfoVO;
        this.promotionImgDto = promotionImgDto;
        this.reportParams = reportParams;
        this.sellOut = sellOut;
        this.skuId = skuId;
        this.soldCount = soldCount;
        this.soldCountDesc = soldCountDesc;
        this.source = source;
        this.sourceBizType = sourceBizType;
        this.sourceName = sourceName;
        this.status = status;
        this.subTitle = subTitle;
        this.text = text;
        this.vurl = vurl;
        this.wishCount = wishCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ShopItem$ActivityDTO$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ShopItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityDTOList != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.activityDTOList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.aid != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.aid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.canAddCart != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.canAddCart);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.coverVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, CoverVO$$serializer.INSTANCE, self.coverVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.feedLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, ShopItem$LabelGroup$$serializer.INSTANCE, self.feedLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.feedTag != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, ShopItem$LabelGroup$$serializer.INSTANCE, self.feedTag);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.ichibanInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, ShopItem$IchibanInfoVO$$serializer.INSTANCE, self.ichibanInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.itemCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, LongSerializer.INSTANCE, self.itemCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.itemsId != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, LongSerializer.INSTANCE, self.itemsId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.itemsIndexDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.itemsIndexDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.itemsName != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.itemsName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.jumpUrlVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, ShopItem$JumpUrlVO$$serializer.INSTANCE, self.jumpUrlVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.marketItemCard != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, BooleanSerializer.INSTANCE, self.marketItemCard);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.merchantId != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, LongSerializer.INSTANCE, self.merchantId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.merchantInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, ShopItem$MerchantInfo$$serializer.INSTANCE, self.merchantInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.multiSku != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, BooleanSerializer.INSTANCE, self.multiSku);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.preSaleEndTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, LongSerializer.INSTANCE, self.preSaleEndTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.preSaleStartTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, LongSerializer.INSTANCE, self.preSaleStartTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.priceInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, ShopItem$PriceInfoVO$$serializer.INSTANCE, self.priceInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.promotionImgDto != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, ShopItem$PromotionImg$$serializer.INSTANCE, self.promotionImgDto);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.reportParams != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, JsonObjectSerializer.INSTANCE, self.reportParams);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.sellOut != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, BooleanSerializer.INSTANCE, self.sellOut);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.skuId != null) {
            output.encodeNullableSerializableElement(serialDesc, 22, LongSerializer.INSTANCE, self.skuId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.soldCount != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, IntSerializer.INSTANCE, self.soldCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.soldCountDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.soldCountDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || self.source != null) {
            output.encodeNullableSerializableElement(serialDesc, 25, IntSerializer.INSTANCE, self.source);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.sourceBizType != null) {
            output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.sourceBizType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.sourceName != null) {
            output.encodeNullableSerializableElement(serialDesc, 27, StringSerializer.INSTANCE, self.sourceName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || self.status != null) {
            output.encodeNullableSerializableElement(serialDesc, 28, IntSerializer.INSTANCE, self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.subTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 29, StringSerializer.INSTANCE, self.subTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 30) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 30, StringSerializer.INSTANCE, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 31) || self.vurl != null) {
            output.encodeNullableSerializableElement(serialDesc, 31, StringSerializer.INSTANCE, self.vurl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 32) || self.wishCount != null) {
            output.encodeNullableSerializableElement(serialDesc, 32, IntSerializer.INSTANCE, self.wishCount);
        }
    }

    public /* synthetic */ ShopItem(List list, String str, Boolean bool, CoverVO coverVO, LabelGroup labelGroup, LabelGroup labelGroup2, IchibanInfoVO ichibanInfoVO, Long l, Long l2, String str2, String str3, JumpUrlVO jumpUrlVO, Boolean bool2, Long l3, MerchantInfo merchantInfo, Boolean bool3, Long l4, Long l5, PriceInfoVO priceInfoVO, PromotionImg promotionImg, JsonObject jsonObject, Boolean bool4, Long l6, Integer num, String str4, Integer num2, String str5, String str6, Integer num3, String str7, String str8, String str9, Integer num4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : coverVO, (i & 16) != 0 ? null : labelGroup, (i & 32) != 0 ? null : labelGroup2, (i & 64) != 0 ? null : ichibanInfoVO, (i & 128) != 0 ? null : l, (i & 256) != 0 ? null : l2, (i & 512) != 0 ? null : str2, (i & 1024) != 0 ? null : str3, (i & 2048) != 0 ? null : jumpUrlVO, (i & 4096) != 0 ? null : bool2, (i & 8192) != 0 ? null : l3, (i & 16384) != 0 ? null : merchantInfo, (i & 32768) != 0 ? null : bool3, (i & 65536) != 0 ? null : l4, (i & 131072) != 0 ? null : l5, (i & 262144) != 0 ? null : priceInfoVO, (i & 524288) != 0 ? null : promotionImg, (i & 1048576) != 0 ? null : jsonObject, (i & 2097152) != 0 ? null : bool4, (i & 4194304) != 0 ? null : l6, (i & 8388608) != 0 ? null : num, (i & 16777216) != 0 ? null : str4, (i & 33554432) != 0 ? null : num2, (i & 67108864) != 0 ? null : str5, (i & 134217728) != 0 ? null : str6, (i & 268435456) != 0 ? null : num3, (i & 536870912) != 0 ? null : str7, (i & 1073741824) != 0 ? null : str8, (i & Integer.MIN_VALUE) != 0 ? null : str9, (i2 & 1) != 0 ? null : num4);
    }

    public final List<ActivityDTO> getActivityDTOList() {
        return this.activityDTOList;
    }

    public final String getAid() {
        return this.aid;
    }

    public final Boolean getCanAddCart() {
        return this.canAddCart;
    }

    public final CoverVO getCoverVO() {
        return this.coverVO;
    }

    public final LabelGroup getFeedLabel() {
        return this.feedLabel;
    }

    public final LabelGroup getFeedTag() {
        return this.feedTag;
    }

    public final IchibanInfoVO getIchibanInfoVO() {
        return this.ichibanInfoVO;
    }

    public final Long getItemCode() {
        return this.itemCode;
    }

    public final Long getItemsId() {
        return this.itemsId;
    }

    public final String getItemsIndexDesc() {
        return this.itemsIndexDesc;
    }

    public final String getItemsName() {
        return this.itemsName;
    }

    public final JumpUrlVO getJumpUrlVO() {
        return this.jumpUrlVO;
    }

    public final Boolean getMarketItemCard() {
        return this.marketItemCard;
    }

    public final Long getMerchantId() {
        return this.merchantId;
    }

    public final MerchantInfo getMerchantInfo() {
        return this.merchantInfo;
    }

    public final Boolean getMultiSku() {
        return this.multiSku;
    }

    public final Long getPreSaleEndTime() {
        return this.preSaleEndTime;
    }

    public final Long getPreSaleStartTime() {
        return this.preSaleStartTime;
    }

    public final PriceInfoVO getPriceInfoVO() {
        return this.priceInfoVO;
    }

    public final PromotionImg getPromotionImgDto() {
        return this.promotionImgDto;
    }

    public final JsonObject getReportParams() {
        return this.reportParams;
    }

    public final Boolean getSellOut() {
        return this.sellOut;
    }

    public final Long getSkuId() {
        return this.skuId;
    }

    public final Integer getSoldCount() {
        return this.soldCount;
    }

    public final String getSoldCountDesc() {
        return this.soldCountDesc;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final String getSourceBizType() {
        return this.sourceBizType;
    }

    public final String getSourceName() {
        return this.sourceName;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getText() {
        return this.text;
    }

    public final String getVurl() {
        return this.vurl;
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0003JKLB\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0014\u0010\u0015B\u0093\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00109\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003J\u009e\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u000e2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0005HÖ\u0001J\t\u0010A\u001a\u00020\fHÖ\u0001J%\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bIR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b#\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b$\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001eR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&¨\u0006M"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO;", "", "activityType", "", "advanceCountdownTime", "", "advancePublishTime", "discountDto", "Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO$Discount;", "endTime", "process", "showLabel", "", "soldOut", "", "startTime", "activityId", "", "activityName", "activityDesc", "<init>", "(Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO$Discount;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO$Discount;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getAdvanceCountdownTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAdvancePublishTime", "getDiscountDto", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO$Discount;", "getEndTime", "getProcess", "getShowLabel", "()Ljava/lang/String;", "getSoldOut", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStartTime", "getActivityId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getActivityName", "getActivityDesc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO$Discount;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "Discount", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ActivityDTO {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String activityDesc;
        private final Long activityId;
        private final String activityName;
        private final Byte activityType;
        private final Integer advanceCountdownTime;
        private final Integer advancePublishTime;
        private final Discount discountDto;
        private final Integer endTime;
        private final Byte process;
        private final String showLabel;
        private final Boolean soldOut;
        private final Integer startTime;

        public ActivityDTO() {
            this((Byte) null, (Integer) null, (Integer) null, (Discount) null, (Integer) null, (Byte) null, (String) null, (Boolean) null, (Integer) null, (Long) null, (String) null, (String) null, 4095, (DefaultConstructorMarker) null);
        }

        public final Byte component1() {
            return this.activityType;
        }

        public final Long component10() {
            return this.activityId;
        }

        public final String component11() {
            return this.activityName;
        }

        public final String component12() {
            return this.activityDesc;
        }

        public final Integer component2() {
            return this.advanceCountdownTime;
        }

        public final Integer component3() {
            return this.advancePublishTime;
        }

        public final Discount component4() {
            return this.discountDto;
        }

        public final Integer component5() {
            return this.endTime;
        }

        public final Byte component6() {
            return this.process;
        }

        public final String component7() {
            return this.showLabel;
        }

        public final Boolean component8() {
            return this.soldOut;
        }

        public final Integer component9() {
            return this.startTime;
        }

        public final ActivityDTO copy(Byte b, Integer num, Integer num2, Discount discount, Integer num3, Byte b2, String str, Boolean bool, Integer num4, Long l, String str2, String str3) {
            return new ActivityDTO(b, num, num2, discount, num3, b2, str, bool, num4, l, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActivityDTO) {
                ActivityDTO activityDTO = (ActivityDTO) obj;
                return Intrinsics.areEqual(this.activityType, activityDTO.activityType) && Intrinsics.areEqual(this.advanceCountdownTime, activityDTO.advanceCountdownTime) && Intrinsics.areEqual(this.advancePublishTime, activityDTO.advancePublishTime) && Intrinsics.areEqual(this.discountDto, activityDTO.discountDto) && Intrinsics.areEqual(this.endTime, activityDTO.endTime) && Intrinsics.areEqual(this.process, activityDTO.process) && Intrinsics.areEqual(this.showLabel, activityDTO.showLabel) && Intrinsics.areEqual(this.soldOut, activityDTO.soldOut) && Intrinsics.areEqual(this.startTime, activityDTO.startTime) && Intrinsics.areEqual(this.activityId, activityDTO.activityId) && Intrinsics.areEqual(this.activityName, activityDTO.activityName) && Intrinsics.areEqual(this.activityDesc, activityDTO.activityDesc);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((this.activityType == null ? 0 : this.activityType.hashCode()) * 31) + (this.advanceCountdownTime == null ? 0 : this.advanceCountdownTime.hashCode())) * 31) + (this.advancePublishTime == null ? 0 : this.advancePublishTime.hashCode())) * 31) + (this.discountDto == null ? 0 : this.discountDto.hashCode())) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + (this.process == null ? 0 : this.process.hashCode())) * 31) + (this.showLabel == null ? 0 : this.showLabel.hashCode())) * 31) + (this.soldOut == null ? 0 : this.soldOut.hashCode())) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.activityId == null ? 0 : this.activityId.hashCode())) * 31) + (this.activityName == null ? 0 : this.activityName.hashCode())) * 31) + (this.activityDesc != null ? this.activityDesc.hashCode() : 0);
        }

        public String toString() {
            Byte b = this.activityType;
            Integer num = this.advanceCountdownTime;
            Integer num2 = this.advancePublishTime;
            Discount discount = this.discountDto;
            Integer num3 = this.endTime;
            Byte b2 = this.process;
            String str = this.showLabel;
            Boolean bool = this.soldOut;
            Integer num4 = this.startTime;
            Long l = this.activityId;
            String str2 = this.activityName;
            return "ActivityDTO(activityType=" + b + ", advanceCountdownTime=" + num + ", advancePublishTime=" + num2 + ", discountDto=" + discount + ", endTime=" + num3 + ", process=" + b2 + ", showLabel=" + str + ", soldOut=" + bool + ", startTime=" + num4 + ", activityId=" + l + ", activityName=" + str2 + ", activityDesc=" + this.activityDesc + ")";
        }

        /* compiled from: ShopInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ActivityDTO> serializer() {
                return ShopItem$ActivityDTO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ActivityDTO(int seen0, Byte activityType, Integer advanceCountdownTime, Integer advancePublishTime, Discount discountDto, Integer endTime, Byte process, String showLabel, Boolean soldOut, Integer startTime, Long activityId, String activityName, String activityDesc, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.activityType = null;
            } else {
                this.activityType = activityType;
            }
            if ((seen0 & 2) == 0) {
                this.advanceCountdownTime = null;
            } else {
                this.advanceCountdownTime = advanceCountdownTime;
            }
            if ((seen0 & 4) == 0) {
                this.advancePublishTime = null;
            } else {
                this.advancePublishTime = advancePublishTime;
            }
            if ((seen0 & 8) == 0) {
                this.discountDto = null;
            } else {
                this.discountDto = discountDto;
            }
            if ((seen0 & 16) == 0) {
                this.endTime = null;
            } else {
                this.endTime = endTime;
            }
            if ((seen0 & 32) == 0) {
                this.process = null;
            } else {
                this.process = process;
            }
            if ((seen0 & 64) == 0) {
                this.showLabel = null;
            } else {
                this.showLabel = showLabel;
            }
            if ((seen0 & 128) == 0) {
                this.soldOut = null;
            } else {
                this.soldOut = soldOut;
            }
            if ((seen0 & 256) == 0) {
                this.startTime = null;
            } else {
                this.startTime = startTime;
            }
            if ((seen0 & 512) == 0) {
                this.activityId = null;
            } else {
                this.activityId = activityId;
            }
            if ((seen0 & 1024) == 0) {
                this.activityName = null;
            } else {
                this.activityName = activityName;
            }
            if ((seen0 & 2048) == 0) {
                this.activityDesc = null;
            } else {
                this.activityDesc = activityDesc;
            }
        }

        public ActivityDTO(Byte activityType, Integer advanceCountdownTime, Integer advancePublishTime, Discount discountDto, Integer endTime, Byte process, String showLabel, Boolean soldOut, Integer startTime, Long activityId, String activityName, String activityDesc) {
            this.activityType = activityType;
            this.advanceCountdownTime = advanceCountdownTime;
            this.advancePublishTime = advancePublishTime;
            this.discountDto = discountDto;
            this.endTime = endTime;
            this.process = process;
            this.showLabel = showLabel;
            this.soldOut = soldOut;
            this.startTime = startTime;
            this.activityId = activityId;
            this.activityName = activityName;
            this.activityDesc = activityDesc;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ActivityDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityType != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, ByteSerializer.INSTANCE, self.activityType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.advanceCountdownTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.advanceCountdownTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.advancePublishTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.advancePublishTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.discountDto != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, ShopItem$ActivityDTO$Discount$$serializer.INSTANCE, self.discountDto);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.endTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.endTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.process != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, ByteSerializer.INSTANCE, self.process);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.showLabel != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.showLabel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.soldOut != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.soldOut);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.startTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.startTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.activityId != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, LongSerializer.INSTANCE, self.activityId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.activityName != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.activityName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.activityDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.activityDesc);
            }
        }

        public /* synthetic */ ActivityDTO(Byte b, Integer num, Integer num2, Discount discount, Integer num3, Byte b2, String str, Boolean bool, Integer num4, Long l, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : b, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : discount, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : b2, (i & 64) != 0 ? null : str, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : num4, (i & 512) != 0 ? null : l, (i & 1024) != 0 ? null : str2, (i & 2048) == 0 ? str3 : null);
        }

        public final Byte getActivityType() {
            return this.activityType;
        }

        public final Integer getAdvanceCountdownTime() {
            return this.advanceCountdownTime;
        }

        public final Integer getAdvancePublishTime() {
            return this.advancePublishTime;
        }

        public final Discount getDiscountDto() {
            return this.discountDto;
        }

        public final Integer getEndTime() {
            return this.endTime;
        }

        public final Byte getProcess() {
            return this.process;
        }

        public final String getShowLabel() {
            return this.showLabel;
        }

        public final Boolean getSoldOut() {
            return this.soldOut;
        }

        public final Integer getStartTime() {
            return this.startTime;
        }

        public final Long getActivityId() {
            return this.activityId;
        }

        public final String getActivityName() {
            return this.activityName;
        }

        /* compiled from: ShopInfoFloor.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO$Discount;", "", "maxDiscountPrice", "", "maxDiscountPriceDeposit", "minDiscountPrice", "minDiscountPriceDeposit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMaxDiscountPrice", "()Ljava/lang/String;", "getMaxDiscountPriceDeposit", "getMinDiscountPrice", "getMinDiscountPriceDeposit", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Discount {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String maxDiscountPrice;
            private final String maxDiscountPriceDeposit;
            private final String minDiscountPrice;
            private final String minDiscountPriceDeposit;

            public Discount() {
                this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Discount copy$default(Discount discount, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = discount.maxDiscountPrice;
                }
                if ((i & 2) != 0) {
                    str2 = discount.maxDiscountPriceDeposit;
                }
                if ((i & 4) != 0) {
                    str3 = discount.minDiscountPrice;
                }
                if ((i & 8) != 0) {
                    str4 = discount.minDiscountPriceDeposit;
                }
                return discount.copy(str, str2, str3, str4);
            }

            public final String component1() {
                return this.maxDiscountPrice;
            }

            public final String component2() {
                return this.maxDiscountPriceDeposit;
            }

            public final String component3() {
                return this.minDiscountPrice;
            }

            public final String component4() {
                return this.minDiscountPriceDeposit;
            }

            public final Discount copy(String str, String str2, String str3, String str4) {
                return new Discount(str, str2, str3, str4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Discount) {
                    Discount discount = (Discount) obj;
                    return Intrinsics.areEqual(this.maxDiscountPrice, discount.maxDiscountPrice) && Intrinsics.areEqual(this.maxDiscountPriceDeposit, discount.maxDiscountPriceDeposit) && Intrinsics.areEqual(this.minDiscountPrice, discount.minDiscountPrice) && Intrinsics.areEqual(this.minDiscountPriceDeposit, discount.minDiscountPriceDeposit);
                }
                return false;
            }

            public int hashCode() {
                return ((((((this.maxDiscountPrice == null ? 0 : this.maxDiscountPrice.hashCode()) * 31) + (this.maxDiscountPriceDeposit == null ? 0 : this.maxDiscountPriceDeposit.hashCode())) * 31) + (this.minDiscountPrice == null ? 0 : this.minDiscountPrice.hashCode())) * 31) + (this.minDiscountPriceDeposit != null ? this.minDiscountPriceDeposit.hashCode() : 0);
            }

            public String toString() {
                String str = this.maxDiscountPrice;
                String str2 = this.maxDiscountPriceDeposit;
                String str3 = this.minDiscountPrice;
                return "Discount(maxDiscountPrice=" + str + ", maxDiscountPriceDeposit=" + str2 + ", minDiscountPrice=" + str3 + ", minDiscountPriceDeposit=" + this.minDiscountPriceDeposit + ")";
            }

            /* compiled from: ShopInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO$Discount$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$ActivityDTO$Discount;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Discount> serializer() {
                    return ShopItem$ActivityDTO$Discount$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ Discount(int seen0, String maxDiscountPrice, String maxDiscountPriceDeposit, String minDiscountPrice, String minDiscountPriceDeposit, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.maxDiscountPrice = null;
                } else {
                    this.maxDiscountPrice = maxDiscountPrice;
                }
                if ((seen0 & 2) == 0) {
                    this.maxDiscountPriceDeposit = null;
                } else {
                    this.maxDiscountPriceDeposit = maxDiscountPriceDeposit;
                }
                if ((seen0 & 4) == 0) {
                    this.minDiscountPrice = null;
                } else {
                    this.minDiscountPrice = minDiscountPrice;
                }
                if ((seen0 & 8) == 0) {
                    this.minDiscountPriceDeposit = null;
                } else {
                    this.minDiscountPriceDeposit = minDiscountPriceDeposit;
                }
            }

            public Discount(String maxDiscountPrice, String maxDiscountPriceDeposit, String minDiscountPrice, String minDiscountPriceDeposit) {
                this.maxDiscountPrice = maxDiscountPrice;
                this.maxDiscountPriceDeposit = maxDiscountPriceDeposit;
                this.minDiscountPrice = minDiscountPrice;
                this.minDiscountPriceDeposit = minDiscountPriceDeposit;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(Discount self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.maxDiscountPrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.maxDiscountPrice);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.maxDiscountPriceDeposit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.maxDiscountPriceDeposit);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.minDiscountPrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.minDiscountPrice);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.minDiscountPriceDeposit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.minDiscountPriceDeposit);
                }
            }

            public /* synthetic */ Discount(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
            }

            public final String getMaxDiscountPrice() {
                return this.maxDiscountPrice;
            }

            public final String getMaxDiscountPriceDeposit() {
                return this.maxDiscountPriceDeposit;
            }

            public final String getMinDiscountPrice() {
                return this.minDiscountPrice;
            }

            public final String getMinDiscountPriceDeposit() {
                return this.minDiscountPriceDeposit;
            }
        }

        public final String getActivityDesc() {
            return this.activityDesc;
        }
    }

    public final Integer getWishCount() {
        return this.wishCount;
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B;\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\tHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006#"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;", "", "frontTag", "", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "underTag", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFrontTag", "()Ljava/util/List;", "getUnderTag", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LabelGroup {
        private final List<LabelObject> frontTag;
        private final List<LabelObject> underTag;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ShopItem$LabelGroup$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = ShopItem.LabelGroup._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ShopItem$LabelGroup$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = ShopItem.LabelGroup._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        })};

        public LabelGroup() {
            this((List) null, (List) null, 3, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LabelGroup copy$default(LabelGroup labelGroup, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = labelGroup.frontTag;
            }
            if ((i & 2) != 0) {
                list2 = labelGroup.underTag;
            }
            return labelGroup.copy(list, list2);
        }

        public final List<LabelObject> component1() {
            return this.frontTag;
        }

        public final List<LabelObject> component2() {
            return this.underTag;
        }

        public final LabelGroup copy(List<LabelObject> list, List<LabelObject> list2) {
            return new LabelGroup(list, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LabelGroup) {
                LabelGroup labelGroup = (LabelGroup) obj;
                return Intrinsics.areEqual(this.frontTag, labelGroup.frontTag) && Intrinsics.areEqual(this.underTag, labelGroup.underTag);
            }
            return false;
        }

        public int hashCode() {
            return ((this.frontTag == null ? 0 : this.frontTag.hashCode()) * 31) + (this.underTag != null ? this.underTag.hashCode() : 0);
        }

        public String toString() {
            List<LabelObject> list = this.frontTag;
            return "LabelGroup(frontTag=" + list + ", underTag=" + this.underTag + ")";
        }

        /* compiled from: ShopInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$LabelGroup;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LabelGroup> serializer() {
                return ShopItem$LabelGroup$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ LabelGroup(int seen0, List frontTag, List underTag, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.frontTag = null;
            } else {
                this.frontTag = frontTag;
            }
            if ((seen0 & 2) == 0) {
                this.underTag = null;
            } else {
                this.underTag = underTag;
            }
        }

        public LabelGroup(List<LabelObject> list, List<LabelObject> list2) {
            this.frontTag = list;
            this.underTag = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(LabelObject$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(LabelObject$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(LabelGroup self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.frontTag != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.frontTag);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.underTag != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.underTag);
            }
        }

        public /* synthetic */ LabelGroup(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
        }

        public final List<LabelObject> getFrontTag() {
            return this.frontTag;
        }

        public final List<LabelObject> getUnderTag() {
            return this.underTag;
        }
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018¨\u00062"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$IchibanInfoVO;", "", "ichibanItem", "", "lrprice", "", "lrpriceDesc", "", "lrpriceStr", "remainBox", "remainBoxDesc", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIchibanItem", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLrprice", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLrpriceDesc", "()Ljava/lang/String;", "getLrpriceStr", "getRemainBox", "getRemainBoxDesc", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ShopItem$IchibanInfoVO;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class IchibanInfoVO {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Boolean ichibanItem;
        private final Integer lrprice;
        private final String lrpriceDesc;
        private final String lrpriceStr;
        private final Integer remainBox;
        private final String remainBoxDesc;

        public IchibanInfoVO() {
            this((Boolean) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ IchibanInfoVO copy$default(IchibanInfoVO ichibanInfoVO, Boolean bool, Integer num, String str, String str2, Integer num2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = ichibanInfoVO.ichibanItem;
            }
            if ((i & 2) != 0) {
                num = ichibanInfoVO.lrprice;
            }
            Integer num3 = num;
            if ((i & 4) != 0) {
                str = ichibanInfoVO.lrpriceDesc;
            }
            String str4 = str;
            if ((i & 8) != 0) {
                str2 = ichibanInfoVO.lrpriceStr;
            }
            String str5 = str2;
            if ((i & 16) != 0) {
                num2 = ichibanInfoVO.remainBox;
            }
            Integer num4 = num2;
            if ((i & 32) != 0) {
                str3 = ichibanInfoVO.remainBoxDesc;
            }
            return ichibanInfoVO.copy(bool, num3, str4, str5, num4, str3);
        }

        public final Boolean component1() {
            return this.ichibanItem;
        }

        public final Integer component2() {
            return this.lrprice;
        }

        public final String component3() {
            return this.lrpriceDesc;
        }

        public final String component4() {
            return this.lrpriceStr;
        }

        public final Integer component5() {
            return this.remainBox;
        }

        public final String component6() {
            return this.remainBoxDesc;
        }

        public final IchibanInfoVO copy(Boolean bool, Integer num, String str, String str2, Integer num2, String str3) {
            return new IchibanInfoVO(bool, num, str, str2, num2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IchibanInfoVO) {
                IchibanInfoVO ichibanInfoVO = (IchibanInfoVO) obj;
                return Intrinsics.areEqual(this.ichibanItem, ichibanInfoVO.ichibanItem) && Intrinsics.areEqual(this.lrprice, ichibanInfoVO.lrprice) && Intrinsics.areEqual(this.lrpriceDesc, ichibanInfoVO.lrpriceDesc) && Intrinsics.areEqual(this.lrpriceStr, ichibanInfoVO.lrpriceStr) && Intrinsics.areEqual(this.remainBox, ichibanInfoVO.remainBox) && Intrinsics.areEqual(this.remainBoxDesc, ichibanInfoVO.remainBoxDesc);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((this.ichibanItem == null ? 0 : this.ichibanItem.hashCode()) * 31) + (this.lrprice == null ? 0 : this.lrprice.hashCode())) * 31) + (this.lrpriceDesc == null ? 0 : this.lrpriceDesc.hashCode())) * 31) + (this.lrpriceStr == null ? 0 : this.lrpriceStr.hashCode())) * 31) + (this.remainBox == null ? 0 : this.remainBox.hashCode())) * 31) + (this.remainBoxDesc != null ? this.remainBoxDesc.hashCode() : 0);
        }

        public String toString() {
            Boolean bool = this.ichibanItem;
            Integer num = this.lrprice;
            String str = this.lrpriceDesc;
            String str2 = this.lrpriceStr;
            Integer num2 = this.remainBox;
            return "IchibanInfoVO(ichibanItem=" + bool + ", lrprice=" + num + ", lrpriceDesc=" + str + ", lrpriceStr=" + str2 + ", remainBox=" + num2 + ", remainBoxDesc=" + this.remainBoxDesc + ")";
        }

        /* compiled from: ShopInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$IchibanInfoVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$IchibanInfoVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<IchibanInfoVO> serializer() {
                return ShopItem$IchibanInfoVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ IchibanInfoVO(int seen0, Boolean ichibanItem, Integer lrprice, String lrpriceDesc, String lrpriceStr, Integer remainBox, String remainBoxDesc, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.ichibanItem = null;
            } else {
                this.ichibanItem = ichibanItem;
            }
            if ((seen0 & 2) == 0) {
                this.lrprice = null;
            } else {
                this.lrprice = lrprice;
            }
            if ((seen0 & 4) == 0) {
                this.lrpriceDesc = null;
            } else {
                this.lrpriceDesc = lrpriceDesc;
            }
            if ((seen0 & 8) == 0) {
                this.lrpriceStr = null;
            } else {
                this.lrpriceStr = lrpriceStr;
            }
            if ((seen0 & 16) == 0) {
                this.remainBox = null;
            } else {
                this.remainBox = remainBox;
            }
            if ((seen0 & 32) == 0) {
                this.remainBoxDesc = null;
            } else {
                this.remainBoxDesc = remainBoxDesc;
            }
        }

        public IchibanInfoVO(Boolean ichibanItem, Integer lrprice, String lrpriceDesc, String lrpriceStr, Integer remainBox, String remainBoxDesc) {
            this.ichibanItem = ichibanItem;
            this.lrprice = lrprice;
            this.lrpriceDesc = lrpriceDesc;
            this.lrpriceStr = lrpriceStr;
            this.remainBox = remainBox;
            this.remainBoxDesc = remainBoxDesc;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(IchibanInfoVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ichibanItem != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.ichibanItem);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.lrprice != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.lrprice);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.lrpriceDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.lrpriceDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.lrpriceStr != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.lrpriceStr);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.remainBox != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.remainBox);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.remainBoxDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.remainBoxDesc);
            }
        }

        public /* synthetic */ IchibanInfoVO(Boolean bool, Integer num, String str, String str2, Integer num2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str3);
        }

        public final Boolean getIchibanItem() {
            return this.ichibanItem;
        }

        public final Integer getLrprice() {
            return this.lrprice;
        }

        public final String getLrpriceDesc() {
            return this.lrpriceDesc;
        }

        public final String getLrpriceStr() {
            return this.lrpriceStr;
        }

        public final Integer getRemainBox() {
            return this.remainBox;
        }

        public final String getRemainBoxDesc() {
            return this.remainBoxDesc;
        }
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$JumpUrlVO;", "", "jumpUrlH5", "", "jumpUrlNA", "outSchemaUrl", "guideIndexUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getJumpUrlH5", "()Ljava/lang/String;", "getJumpUrlNA", "getOutSchemaUrl", "getGuideIndexUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class JumpUrlVO {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String guideIndexUrl;
        private final String jumpUrlH5;
        private final String jumpUrlNA;
        private final String outSchemaUrl;

        public JumpUrlVO() {
            this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ JumpUrlVO copy$default(JumpUrlVO jumpUrlVO, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = jumpUrlVO.jumpUrlH5;
            }
            if ((i & 2) != 0) {
                str2 = jumpUrlVO.jumpUrlNA;
            }
            if ((i & 4) != 0) {
                str3 = jumpUrlVO.outSchemaUrl;
            }
            if ((i & 8) != 0) {
                str4 = jumpUrlVO.guideIndexUrl;
            }
            return jumpUrlVO.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.jumpUrlH5;
        }

        public final String component2() {
            return this.jumpUrlNA;
        }

        public final String component3() {
            return this.outSchemaUrl;
        }

        public final String component4() {
            return this.guideIndexUrl;
        }

        public final JumpUrlVO copy(String str, String str2, String str3, String str4) {
            return new JumpUrlVO(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof JumpUrlVO) {
                JumpUrlVO jumpUrlVO = (JumpUrlVO) obj;
                return Intrinsics.areEqual(this.jumpUrlH5, jumpUrlVO.jumpUrlH5) && Intrinsics.areEqual(this.jumpUrlNA, jumpUrlVO.jumpUrlNA) && Intrinsics.areEqual(this.outSchemaUrl, jumpUrlVO.outSchemaUrl) && Intrinsics.areEqual(this.guideIndexUrl, jumpUrlVO.guideIndexUrl);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.jumpUrlH5 == null ? 0 : this.jumpUrlH5.hashCode()) * 31) + (this.jumpUrlNA == null ? 0 : this.jumpUrlNA.hashCode())) * 31) + (this.outSchemaUrl == null ? 0 : this.outSchemaUrl.hashCode())) * 31) + (this.guideIndexUrl != null ? this.guideIndexUrl.hashCode() : 0);
        }

        public String toString() {
            String str = this.jumpUrlH5;
            String str2 = this.jumpUrlNA;
            String str3 = this.outSchemaUrl;
            return "JumpUrlVO(jumpUrlH5=" + str + ", jumpUrlNA=" + str2 + ", outSchemaUrl=" + str3 + ", guideIndexUrl=" + this.guideIndexUrl + ")";
        }

        /* compiled from: ShopInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$JumpUrlVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$JumpUrlVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<JumpUrlVO> serializer() {
                return ShopItem$JumpUrlVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ JumpUrlVO(int seen0, String jumpUrlH5, String jumpUrlNA, String outSchemaUrl, String guideIndexUrl, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.jumpUrlH5 = null;
            } else {
                this.jumpUrlH5 = jumpUrlH5;
            }
            if ((seen0 & 2) == 0) {
                this.jumpUrlNA = null;
            } else {
                this.jumpUrlNA = jumpUrlNA;
            }
            if ((seen0 & 4) == 0) {
                this.outSchemaUrl = null;
            } else {
                this.outSchemaUrl = outSchemaUrl;
            }
            if ((seen0 & 8) == 0) {
                this.guideIndexUrl = null;
            } else {
                this.guideIndexUrl = guideIndexUrl;
            }
        }

        public JumpUrlVO(String jumpUrlH5, String jumpUrlNA, String outSchemaUrl, String guideIndexUrl) {
            this.jumpUrlH5 = jumpUrlH5;
            this.jumpUrlNA = jumpUrlNA;
            this.outSchemaUrl = outSchemaUrl;
            this.guideIndexUrl = guideIndexUrl;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(JumpUrlVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.jumpUrlH5 != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.jumpUrlH5);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.jumpUrlNA != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.jumpUrlNA);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.outSchemaUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.outSchemaUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.guideIndexUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.guideIndexUrl);
            }
        }

        public /* synthetic */ JumpUrlVO(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public final String getJumpUrlH5() {
            return this.jumpUrlH5;
        }

        public final String getJumpUrlNA() {
            return this.jumpUrlNA;
        }

        public final String getOutSchemaUrl() {
            return this.outSchemaUrl;
        }

        public final String getGuideIndexUrl() {
            return this.guideIndexUrl;
        }
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fBa\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u000eHÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016¨\u00064"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;", "", "merchantId", "", "merchantName", "", "merchantShopName", "merchantUrl", AppKey.UID, "uname", "uName", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMerchantId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMerchantName", "()Ljava/lang/String;", "getMerchantShopName", "getMerchantUrl", "getUid", "getUname", "getUName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MerchantInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Long merchantId;
        private final String merchantName;
        private final String merchantShopName;
        private final String merchantUrl;
        private final String uName;
        private final Long uid;
        private final String uname;

        public MerchantInfo() {
            this((Long) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MerchantInfo copy$default(MerchantInfo merchantInfo, Long l, String str, String str2, String str3, Long l2, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                l = merchantInfo.merchantId;
            }
            if ((i & 2) != 0) {
                str = merchantInfo.merchantName;
            }
            String str6 = str;
            if ((i & 4) != 0) {
                str2 = merchantInfo.merchantShopName;
            }
            String str7 = str2;
            if ((i & 8) != 0) {
                str3 = merchantInfo.merchantUrl;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                l2 = merchantInfo.uid;
            }
            Long l3 = l2;
            if ((i & 32) != 0) {
                str4 = merchantInfo.uname;
            }
            String str9 = str4;
            if ((i & 64) != 0) {
                str5 = merchantInfo.uName;
            }
            return merchantInfo.copy(l, str6, str7, str8, l3, str9, str5);
        }

        public final Long component1() {
            return this.merchantId;
        }

        public final String component2() {
            return this.merchantName;
        }

        public final String component3() {
            return this.merchantShopName;
        }

        public final String component4() {
            return this.merchantUrl;
        }

        public final Long component5() {
            return this.uid;
        }

        public final String component6() {
            return this.uname;
        }

        public final String component7() {
            return this.uName;
        }

        public final MerchantInfo copy(Long l, String str, String str2, String str3, Long l2, String str4, String str5) {
            return new MerchantInfo(l, str, str2, str3, l2, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MerchantInfo) {
                MerchantInfo merchantInfo = (MerchantInfo) obj;
                return Intrinsics.areEqual(this.merchantId, merchantInfo.merchantId) && Intrinsics.areEqual(this.merchantName, merchantInfo.merchantName) && Intrinsics.areEqual(this.merchantShopName, merchantInfo.merchantShopName) && Intrinsics.areEqual(this.merchantUrl, merchantInfo.merchantUrl) && Intrinsics.areEqual(this.uid, merchantInfo.uid) && Intrinsics.areEqual(this.uname, merchantInfo.uname) && Intrinsics.areEqual(this.uName, merchantInfo.uName);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((this.merchantId == null ? 0 : this.merchantId.hashCode()) * 31) + (this.merchantName == null ? 0 : this.merchantName.hashCode())) * 31) + (this.merchantShopName == null ? 0 : this.merchantShopName.hashCode())) * 31) + (this.merchantUrl == null ? 0 : this.merchantUrl.hashCode())) * 31) + (this.uid == null ? 0 : this.uid.hashCode())) * 31) + (this.uname == null ? 0 : this.uname.hashCode())) * 31) + (this.uName != null ? this.uName.hashCode() : 0);
        }

        public String toString() {
            Long l = this.merchantId;
            String str = this.merchantName;
            String str2 = this.merchantShopName;
            String str3 = this.merchantUrl;
            Long l2 = this.uid;
            String str4 = this.uname;
            return "MerchantInfo(merchantId=" + l + ", merchantName=" + str + ", merchantShopName=" + str2 + ", merchantUrl=" + str3 + ", uid=" + l2 + ", uname=" + str4 + ", uName=" + this.uName + ")";
        }

        /* compiled from: ShopInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$MerchantInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MerchantInfo> serializer() {
                return ShopItem$MerchantInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MerchantInfo(int seen0, Long merchantId, String merchantName, String merchantShopName, String merchantUrl, Long uid, String uname, String uName, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.merchantId = null;
            } else {
                this.merchantId = merchantId;
            }
            if ((seen0 & 2) == 0) {
                this.merchantName = null;
            } else {
                this.merchantName = merchantName;
            }
            if ((seen0 & 4) == 0) {
                this.merchantShopName = null;
            } else {
                this.merchantShopName = merchantShopName;
            }
            if ((seen0 & 8) == 0) {
                this.merchantUrl = null;
            } else {
                this.merchantUrl = merchantUrl;
            }
            if ((seen0 & 16) == 0) {
                this.uid = null;
            } else {
                this.uid = uid;
            }
            if ((seen0 & 32) == 0) {
                this.uname = null;
            } else {
                this.uname = uname;
            }
            if ((seen0 & 64) == 0) {
                this.uName = null;
            } else {
                this.uName = uName;
            }
        }

        public MerchantInfo(Long merchantId, String merchantName, String merchantShopName, String merchantUrl, Long uid, String uname, String uName) {
            this.merchantId = merchantId;
            this.merchantName = merchantName;
            this.merchantShopName = merchantShopName;
            this.merchantUrl = merchantUrl;
            this.uid = uid;
            this.uname = uname;
            this.uName = uName;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(MerchantInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.merchantId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.merchantId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.merchantName != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.merchantName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.merchantShopName != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.merchantShopName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.merchantUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.merchantUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.uid != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.uid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.uname != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.uname);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.uName != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.uName);
            }
        }

        public /* synthetic */ MerchantInfo(Long l, String str, String str2, String str3, Long l2, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
        }

        public final Long getMerchantId() {
            return this.merchantId;
        }

        public final String getMerchantName() {
            return this.merchantName;
        }

        public final String getMerchantShopName() {
            return this.merchantShopName;
        }

        public final String getMerchantUrl() {
            return this.merchantUrl;
        }

        public final Long getUid() {
            return this.uid;
        }

        public final String getUname() {
            return this.uname;
        }

        public final String getUName() {
            return this.uName;
        }
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bB]\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$PriceInfoVO;", "", "netPrice", "", "priceDesc", "", "pricePrefix", "priceSuffix", "priceSymbol", "strikePrice", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNetPrice", "()Ljava/lang/String;", "getPriceDesc", "()Ljava/util/List;", "getPricePrefix", "getPriceSuffix", "getPriceSymbol", "getStrikePrice", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class PriceInfoVO {
        private final String netPrice;
        private final List<String> priceDesc;
        private final String pricePrefix;
        private final String priceSuffix;
        private final String priceSymbol;
        private final String strikePrice;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ShopItem$PriceInfoVO$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = ShopItem.PriceInfoVO._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null};

        public PriceInfoVO() {
            this((String) null, (List) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PriceInfoVO copy$default(PriceInfoVO priceInfoVO, String str, List list, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = priceInfoVO.netPrice;
            }
            List<String> list2 = list;
            if ((i & 2) != 0) {
                list2 = priceInfoVO.priceDesc;
            }
            List list3 = list2;
            if ((i & 4) != 0) {
                str2 = priceInfoVO.pricePrefix;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = priceInfoVO.priceSuffix;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = priceInfoVO.priceSymbol;
            }
            String str8 = str4;
            if ((i & 32) != 0) {
                str5 = priceInfoVO.strikePrice;
            }
            return priceInfoVO.copy(str, list3, str6, str7, str8, str5);
        }

        public final String component1() {
            return this.netPrice;
        }

        public final List<String> component2() {
            return this.priceDesc;
        }

        public final String component3() {
            return this.pricePrefix;
        }

        public final String component4() {
            return this.priceSuffix;
        }

        public final String component5() {
            return this.priceSymbol;
        }

        public final String component6() {
            return this.strikePrice;
        }

        public final PriceInfoVO copy(String str, List<String> list, String str2, String str3, String str4, String str5) {
            return new PriceInfoVO(str, list, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PriceInfoVO) {
                PriceInfoVO priceInfoVO = (PriceInfoVO) obj;
                return Intrinsics.areEqual(this.netPrice, priceInfoVO.netPrice) && Intrinsics.areEqual(this.priceDesc, priceInfoVO.priceDesc) && Intrinsics.areEqual(this.pricePrefix, priceInfoVO.pricePrefix) && Intrinsics.areEqual(this.priceSuffix, priceInfoVO.priceSuffix) && Intrinsics.areEqual(this.priceSymbol, priceInfoVO.priceSymbol) && Intrinsics.areEqual(this.strikePrice, priceInfoVO.strikePrice);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((this.netPrice == null ? 0 : this.netPrice.hashCode()) * 31) + (this.priceDesc == null ? 0 : this.priceDesc.hashCode())) * 31) + (this.pricePrefix == null ? 0 : this.pricePrefix.hashCode())) * 31) + (this.priceSuffix == null ? 0 : this.priceSuffix.hashCode())) * 31) + (this.priceSymbol == null ? 0 : this.priceSymbol.hashCode())) * 31) + (this.strikePrice != null ? this.strikePrice.hashCode() : 0);
        }

        public String toString() {
            String str = this.netPrice;
            List<String> list = this.priceDesc;
            String str2 = this.pricePrefix;
            String str3 = this.priceSuffix;
            String str4 = this.priceSymbol;
            return "PriceInfoVO(netPrice=" + str + ", priceDesc=" + list + ", pricePrefix=" + str2 + ", priceSuffix=" + str3 + ", priceSymbol=" + str4 + ", strikePrice=" + this.strikePrice + ")";
        }

        /* compiled from: ShopInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$PriceInfoVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$PriceInfoVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<PriceInfoVO> serializer() {
                return ShopItem$PriceInfoVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ PriceInfoVO(int seen0, String netPrice, List priceDesc, String pricePrefix, String priceSuffix, String priceSymbol, String strikePrice, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.netPrice = null;
            } else {
                this.netPrice = netPrice;
            }
            if ((seen0 & 2) == 0) {
                this.priceDesc = null;
            } else {
                this.priceDesc = priceDesc;
            }
            if ((seen0 & 4) == 0) {
                this.pricePrefix = null;
            } else {
                this.pricePrefix = pricePrefix;
            }
            if ((seen0 & 8) == 0) {
                this.priceSuffix = null;
            } else {
                this.priceSuffix = priceSuffix;
            }
            if ((seen0 & 16) == 0) {
                this.priceSymbol = null;
            } else {
                this.priceSymbol = priceSymbol;
            }
            if ((seen0 & 32) == 0) {
                this.strikePrice = null;
            } else {
                this.strikePrice = strikePrice;
            }
        }

        public PriceInfoVO(String netPrice, List<String> list, String pricePrefix, String priceSuffix, String priceSymbol, String strikePrice) {
            this.netPrice = netPrice;
            this.priceDesc = list;
            this.pricePrefix = pricePrefix;
            this.priceSuffix = priceSuffix;
            this.priceSymbol = priceSymbol;
            this.strikePrice = strikePrice;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(PriceInfoVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.netPrice != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.netPrice);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.priceDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.priceDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.pricePrefix != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.pricePrefix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.priceSuffix != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.priceSuffix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.priceSymbol != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.priceSymbol);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.strikePrice != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.strikePrice);
            }
        }

        public /* synthetic */ PriceInfoVO(String str, List list, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
        }

        public final String getNetPrice() {
            return this.netPrice;
        }

        public final List<String> getPriceDesc() {
            return this.priceDesc;
        }

        public final String getPricePrefix() {
            return this.pricePrefix;
        }

        public final String getPriceSuffix() {
            return this.priceSuffix;
        }

        public final String getPriceSymbol() {
            return this.priceSymbol;
        }

        public final String getStrikePrice() {
            return this.strikePrice;
        }
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0003$%&B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg;", "", "actTagName", "", "actThereMaterial", "Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial;", "promotionImg", "<init>", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActTagName", "()Ljava/lang/String;", "getActThereMaterial", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial;", "getPromotionImg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ActThereMaterial", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class PromotionImg {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String actTagName;
        private final ActThereMaterial actThereMaterial;
        private final String promotionImg;

        public PromotionImg() {
            this((String) null, (ActThereMaterial) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PromotionImg copy$default(PromotionImg promotionImg, String str, ActThereMaterial actThereMaterial, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = promotionImg.actTagName;
            }
            if ((i & 2) != 0) {
                actThereMaterial = promotionImg.actThereMaterial;
            }
            if ((i & 4) != 0) {
                str2 = promotionImg.promotionImg;
            }
            return promotionImg.copy(str, actThereMaterial, str2);
        }

        public final String component1() {
            return this.actTagName;
        }

        public final ActThereMaterial component2() {
            return this.actThereMaterial;
        }

        public final String component3() {
            return this.promotionImg;
        }

        public final PromotionImg copy(String str, ActThereMaterial actThereMaterial, String str2) {
            return new PromotionImg(str, actThereMaterial, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PromotionImg) {
                PromotionImg promotionImg = (PromotionImg) obj;
                return Intrinsics.areEqual(this.actTagName, promotionImg.actTagName) && Intrinsics.areEqual(this.actThereMaterial, promotionImg.actThereMaterial) && Intrinsics.areEqual(this.promotionImg, promotionImg.promotionImg);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.actTagName == null ? 0 : this.actTagName.hashCode()) * 31) + (this.actThereMaterial == null ? 0 : this.actThereMaterial.hashCode())) * 31) + (this.promotionImg != null ? this.promotionImg.hashCode() : 0);
        }

        public String toString() {
            String str = this.actTagName;
            ActThereMaterial actThereMaterial = this.actThereMaterial;
            return "PromotionImg(actTagName=" + str + ", actThereMaterial=" + actThereMaterial + ", promotionImg=" + this.promotionImg + ")";
        }

        /* compiled from: ShopInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<PromotionImg> serializer() {
                return ShopItem$PromotionImg$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ PromotionImg(int seen0, String actTagName, ActThereMaterial actThereMaterial, String promotionImg, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.actTagName = null;
            } else {
                this.actTagName = actTagName;
            }
            if ((seen0 & 2) == 0) {
                this.actThereMaterial = null;
            } else {
                this.actThereMaterial = actThereMaterial;
            }
            if ((seen0 & 4) == 0) {
                this.promotionImg = null;
            } else {
                this.promotionImg = promotionImg;
            }
        }

        public PromotionImg(String actTagName, ActThereMaterial actThereMaterial, String promotionImg) {
            this.actTagName = actTagName;
            this.actThereMaterial = actThereMaterial;
            this.promotionImg = promotionImg;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(PromotionImg self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.actTagName != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.actTagName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.actThereMaterial != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, ShopItem$PromotionImg$ActThereMaterial$$serializer.INSTANCE, self.actThereMaterial);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.promotionImg != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.promotionImg);
            }
        }

        public /* synthetic */ PromotionImg(String str, ActThereMaterial actThereMaterial, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : actThereMaterial, (i & 4) != 0 ? null : str2);
        }

        public final String getActTagName() {
            return this.actTagName;
        }

        public final ActThereMaterial getActThereMaterial() {
            return this.actThereMaterial;
        }

        /* compiled from: ShopInfoFloor.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0003$%&B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial;", "", "cardBgImg", "", "promotionTagStyle", "Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial$PromotionTagStyle;", "rightIconImg", "<init>", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial$PromotionTagStyle;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial$PromotionTagStyle;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardBgImg", "()Ljava/lang/String;", "getPromotionTagStyle", "()Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial$PromotionTagStyle;", "getRightIconImg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "PromotionTagStyle", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class ActThereMaterial {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String cardBgImg;
            private final PromotionTagStyle promotionTagStyle;
            private final String rightIconImg;

            public ActThereMaterial() {
                this((String) null, (PromotionTagStyle) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ ActThereMaterial copy$default(ActThereMaterial actThereMaterial, String str, PromotionTagStyle promotionTagStyle, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = actThereMaterial.cardBgImg;
                }
                if ((i & 2) != 0) {
                    promotionTagStyle = actThereMaterial.promotionTagStyle;
                }
                if ((i & 4) != 0) {
                    str2 = actThereMaterial.rightIconImg;
                }
                return actThereMaterial.copy(str, promotionTagStyle, str2);
            }

            public final String component1() {
                return this.cardBgImg;
            }

            public final PromotionTagStyle component2() {
                return this.promotionTagStyle;
            }

            public final String component3() {
                return this.rightIconImg;
            }

            public final ActThereMaterial copy(String str, PromotionTagStyle promotionTagStyle, String str2) {
                return new ActThereMaterial(str, promotionTagStyle, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ActThereMaterial) {
                    ActThereMaterial actThereMaterial = (ActThereMaterial) obj;
                    return Intrinsics.areEqual(this.cardBgImg, actThereMaterial.cardBgImg) && Intrinsics.areEqual(this.promotionTagStyle, actThereMaterial.promotionTagStyle) && Intrinsics.areEqual(this.rightIconImg, actThereMaterial.rightIconImg);
                }
                return false;
            }

            public int hashCode() {
                return ((((this.cardBgImg == null ? 0 : this.cardBgImg.hashCode()) * 31) + (this.promotionTagStyle == null ? 0 : this.promotionTagStyle.hashCode())) * 31) + (this.rightIconImg != null ? this.rightIconImg.hashCode() : 0);
            }

            public String toString() {
                String str = this.cardBgImg;
                PromotionTagStyle promotionTagStyle = this.promotionTagStyle;
                return "ActThereMaterial(cardBgImg=" + str + ", promotionTagStyle=" + promotionTagStyle + ", rightIconImg=" + this.rightIconImg + ")";
            }

            /* compiled from: ShopInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ActThereMaterial> serializer() {
                    return ShopItem$PromotionImg$ActThereMaterial$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ActThereMaterial(int seen0, String cardBgImg, PromotionTagStyle promotionTagStyle, String rightIconImg, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.cardBgImg = null;
                } else {
                    this.cardBgImg = cardBgImg;
                }
                if ((seen0 & 2) == 0) {
                    this.promotionTagStyle = null;
                } else {
                    this.promotionTagStyle = promotionTagStyle;
                }
                if ((seen0 & 4) == 0) {
                    this.rightIconImg = null;
                } else {
                    this.rightIconImg = rightIconImg;
                }
            }

            public ActThereMaterial(String cardBgImg, PromotionTagStyle promotionTagStyle, String rightIconImg) {
                this.cardBgImg = cardBgImg;
                this.promotionTagStyle = promotionTagStyle;
                this.rightIconImg = rightIconImg;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(ActThereMaterial self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.cardBgImg != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.cardBgImg);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.promotionTagStyle != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, ShopItem$PromotionImg$ActThereMaterial$PromotionTagStyle$$serializer.INSTANCE, self.promotionTagStyle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.rightIconImg != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.rightIconImg);
                }
            }

            public /* synthetic */ ActThereMaterial(String str, PromotionTagStyle promotionTagStyle, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : promotionTagStyle, (i & 4) != 0 ? null : str2);
            }

            public final String getCardBgImg() {
                return this.cardBgImg;
            }

            public final PromotionTagStyle getPromotionTagStyle() {
                return this.promotionTagStyle;
            }

            /* compiled from: ShopInfoFloor.kt */
            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial$PromotionTagStyle;", "", "tagNameBgColor", "", "tagNameBgColorDark", "tagNameColor", "tagNameColorDark", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTagNameBgColor", "()Ljava/lang/String;", "getTagNameBgColorDark", "getTagNameColor", "getTagNameColorDark", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class PromotionTagStyle {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String tagNameBgColor;
                private final String tagNameBgColorDark;
                private final String tagNameColor;
                private final String tagNameColorDark;

                public PromotionTagStyle() {
                    this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ PromotionTagStyle copy$default(PromotionTagStyle promotionTagStyle, String str, String str2, String str3, String str4, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = promotionTagStyle.tagNameBgColor;
                    }
                    if ((i & 2) != 0) {
                        str2 = promotionTagStyle.tagNameBgColorDark;
                    }
                    if ((i & 4) != 0) {
                        str3 = promotionTagStyle.tagNameColor;
                    }
                    if ((i & 8) != 0) {
                        str4 = promotionTagStyle.tagNameColorDark;
                    }
                    return promotionTagStyle.copy(str, str2, str3, str4);
                }

                public final String component1() {
                    return this.tagNameBgColor;
                }

                public final String component2() {
                    return this.tagNameBgColorDark;
                }

                public final String component3() {
                    return this.tagNameColor;
                }

                public final String component4() {
                    return this.tagNameColorDark;
                }

                public final PromotionTagStyle copy(String str, String str2, String str3, String str4) {
                    return new PromotionTagStyle(str, str2, str3, str4);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof PromotionTagStyle) {
                        PromotionTagStyle promotionTagStyle = (PromotionTagStyle) obj;
                        return Intrinsics.areEqual(this.tagNameBgColor, promotionTagStyle.tagNameBgColor) && Intrinsics.areEqual(this.tagNameBgColorDark, promotionTagStyle.tagNameBgColorDark) && Intrinsics.areEqual(this.tagNameColor, promotionTagStyle.tagNameColor) && Intrinsics.areEqual(this.tagNameColorDark, promotionTagStyle.tagNameColorDark);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((this.tagNameBgColor == null ? 0 : this.tagNameBgColor.hashCode()) * 31) + (this.tagNameBgColorDark == null ? 0 : this.tagNameBgColorDark.hashCode())) * 31) + (this.tagNameColor == null ? 0 : this.tagNameColor.hashCode())) * 31) + (this.tagNameColorDark != null ? this.tagNameColorDark.hashCode() : 0);
                }

                public String toString() {
                    String str = this.tagNameBgColor;
                    String str2 = this.tagNameBgColorDark;
                    String str3 = this.tagNameColor;
                    return "PromotionTagStyle(tagNameBgColor=" + str + ", tagNameBgColorDark=" + str2 + ", tagNameColor=" + str3 + ", tagNameColorDark=" + this.tagNameColorDark + ")";
                }

                /* compiled from: ShopInfoFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial$PromotionTagStyle$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopItem$PromotionImg$ActThereMaterial$PromotionTagStyle;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<PromotionTagStyle> serializer() {
                        return ShopItem$PromotionImg$ActThereMaterial$PromotionTagStyle$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ PromotionTagStyle(int seen0, String tagNameBgColor, String tagNameBgColorDark, String tagNameColor, String tagNameColorDark, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.tagNameBgColor = null;
                    } else {
                        this.tagNameBgColor = tagNameBgColor;
                    }
                    if ((seen0 & 2) == 0) {
                        this.tagNameBgColorDark = null;
                    } else {
                        this.tagNameBgColorDark = tagNameBgColorDark;
                    }
                    if ((seen0 & 4) == 0) {
                        this.tagNameColor = null;
                    } else {
                        this.tagNameColor = tagNameColor;
                    }
                    if ((seen0 & 8) == 0) {
                        this.tagNameColorDark = null;
                    } else {
                        this.tagNameColorDark = tagNameColorDark;
                    }
                }

                public PromotionTagStyle(String tagNameBgColor, String tagNameBgColorDark, String tagNameColor, String tagNameColorDark) {
                    this.tagNameBgColor = tagNameBgColor;
                    this.tagNameBgColorDark = tagNameBgColorDark;
                    this.tagNameColor = tagNameColor;
                    this.tagNameColorDark = tagNameColorDark;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(PromotionTagStyle self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.tagNameBgColor != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.tagNameBgColor);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.tagNameBgColorDark != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.tagNameBgColorDark);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.tagNameColor != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.tagNameColor);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.tagNameColorDark != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.tagNameColorDark);
                    }
                }

                public /* synthetic */ PromotionTagStyle(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
                }

                public final String getTagNameBgColor() {
                    return this.tagNameBgColor;
                }

                public final String getTagNameBgColorDark() {
                    return this.tagNameBgColorDark;
                }

                public final String getTagNameColor() {
                    return this.tagNameColor;
                }

                public final String getTagNameColorDark() {
                    return this.tagNameColorDark;
                }
            }

            public final String getRightIconImg() {
                return this.rightIconImg;
            }
        }

        public final String getPromotionImg() {
            return this.promotionImg;
        }
    }
}