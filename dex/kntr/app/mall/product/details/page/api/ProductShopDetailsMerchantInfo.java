package kntr.app.mall.product.details.page.api;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.KotlinVersion;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: ProductShopApiService.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0006\n\u0002\b'\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000 \u0096\u00012\u00020\u0001:\u0010\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001B\u0087\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\r\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b,\u0010-Bß\u0002\b\u0010\u0012\u0006\u0010.\u001a\u00020\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\r\u0012\b\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010/\u001a\u0004\u0018\u000100¢\u0006\u0004\b,\u00101J\u0010\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010j\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0011\u0010k\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010FJ\u000b\u0010n\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010FJ\u000b\u0010r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010u\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010w\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\rHÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010#HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010z\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rHÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010<J\u000b\u0010|\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0090\u0003\u0010\u0081\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010\u0082\u0001J\u0015\u0010\u0083\u0001\u001a\u00020\u00032\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0014HÖ\u0001J\n\u0010\u0086\u0001\u001a\u00020\u0006HÖ\u0001J-\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u00002\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0001¢\u0006\u0003\b\u008e\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b5\u00103R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u00107R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u00107R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010A\u001a\u0004\bB\u0010?R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010G\u001a\u0004\bE\u0010FR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bJ\u00107R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bK\u00107R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010G\u001a\u0004\bL\u0010FR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bM\u00107R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bN\u00107R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bO\u00103R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010A\u001a\u0004\bQ\u0010RR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bS\u00107R\u0019\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bT\u0010?R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010$\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bW\u00107R\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bX\u0010?R\u0015\u0010&\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010=\u001a\u0004\bY\u0010<R\u0013\u0010'\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bZ\u00107R\u0013\u0010(\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b[\u00107R\u0013\u0010)\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\\\u00107R\u0015\u0010*\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010G\u001a\u0004\b]\u0010FR\u0013\u0010+\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b^\u00107R\u0013\u0010_\u001a\u0004\u0018\u00010`8F¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006\u0097\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo;", "", "assemblyComputerMerchant", "", "bindUp", "businessLicenseUrl", "", "customerLink", "fans", "h5CustomerLink", "itemsNum", "", "merchantAdvisers", "", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantAdviser;", "merchantDecorList", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantDecor;", "merchantIcon", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantIcon;", "merchantId", "", "merchantNoticeVo", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantNotice;", "merchantShopFace", "merchantShopName", "merchantType", "myCartUrl", "myOrderUrl", "noticed", "positiveRatioElement", "Lkotlinx/serialization/json/JsonElement;", "positiveRatioStr", "qualificationList", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$Qualification;", "shareInfo", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$ShareInfo;", "shopSales", "tagNames", AppKey.UID, "shopJumpLink", "upJumpLink", "upName", "upOfficialType", "upPortrait", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantIcon;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantNotice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/util/List;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$ShareInfo;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantIcon;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantNotice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/util/List;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$ShareInfo;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAssemblyComputerMerchant", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBindUp", "getBusinessLicenseUrl", "()Ljava/lang/String;", "getCustomerLink", "getFans", "getH5CustomerLink", "getItemsNum", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMerchantAdvisers", "()Ljava/util/List;", "getMerchantDecorList$annotations", "()V", "getMerchantDecorList", "getMerchantIcon", "()Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantIcon;", "getMerchantId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMerchantNoticeVo", "()Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantNotice;", "getMerchantShopFace", "getMerchantShopName", "getMerchantType", "getMyCartUrl", "getMyOrderUrl", "getNoticed", "getPositiveRatioElement$annotations", "getPositiveRatioElement", "()Lkotlinx/serialization/json/JsonElement;", "getPositiveRatioStr", "getQualificationList", "getShareInfo", "()Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$ShareInfo;", "getShopSales", "getTagNames", "getUid", "getShopJumpLink", "getUpJumpLink", "getUpName", "getUpOfficialType", "getUpPortrait", "positiveRatio", "", "getPositiveRatio", "()Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantIcon;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantNotice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/util/List;Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$ShareInfo;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "MerchantAdviser", "MerchantDecor", "MerchantIcon", "MerchantNotice", "Qualification", "ShareInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ProductShopDetailsMerchantInfo {
    private final Boolean assemblyComputerMerchant;
    private final Boolean bindUp;
    private final String businessLicenseUrl;
    private final String customerLink;
    private final String fans;
    private final String h5CustomerLink;
    private final Long itemsNum;
    private final List<MerchantAdviser> merchantAdvisers;
    private final List<MerchantDecor> merchantDecorList;
    private final MerchantIcon merchantIcon;
    private final Integer merchantId;
    private final MerchantNotice merchantNoticeVo;
    private final String merchantShopFace;
    private final String merchantShopName;
    private final Integer merchantType;
    private final String myCartUrl;
    private final String myOrderUrl;
    private final Boolean noticed;
    private final JsonElement positiveRatioElement;
    private final String positiveRatioStr;
    private final List<Qualification> qualificationList;
    private final ShareInfo shareInfo;
    private final String shopJumpLink;
    private final String shopSales;
    private final List<String> tagNames;
    private final Long uid;
    private final String upJumpLink;
    private final String upName;
    private final Integer upOfficialType;
    private final String upPortrait;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsMerchantInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ProductShopDetailsMerchantInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsMerchantInfo$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ProductShopDetailsMerchantInfo._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsMerchantInfo$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = ProductShopDetailsMerchantInfo._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsMerchantInfo$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = ProductShopDetailsMerchantInfo._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), null, null, null, null, null, null};

    public ProductShopDetailsMerchantInfo() {
        this((Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (List) null, (List) null, (MerchantIcon) null, (Integer) null, (MerchantNotice) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Boolean) null, (JsonElement) null, (String) null, (List) null, (ShareInfo) null, (String) null, (List) null, (Long) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, 1073741823, (DefaultConstructorMarker) null);
    }

    @SerialName("merchantDecor")
    public static /* synthetic */ void getMerchantDecorList$annotations() {
    }

    @SerialName("positiveRatio")
    public static /* synthetic */ void getPositiveRatioElement$annotations() {
    }

    public final Boolean component1() {
        return this.assemblyComputerMerchant;
    }

    public final MerchantIcon component10() {
        return this.merchantIcon;
    }

    public final Integer component11() {
        return this.merchantId;
    }

    public final MerchantNotice component12() {
        return this.merchantNoticeVo;
    }

    public final String component13() {
        return this.merchantShopFace;
    }

    public final String component14() {
        return this.merchantShopName;
    }

    public final Integer component15() {
        return this.merchantType;
    }

    public final String component16() {
        return this.myCartUrl;
    }

    public final String component17() {
        return this.myOrderUrl;
    }

    public final Boolean component18() {
        return this.noticed;
    }

    public final JsonElement component19() {
        return this.positiveRatioElement;
    }

    public final Boolean component2() {
        return this.bindUp;
    }

    public final String component20() {
        return this.positiveRatioStr;
    }

    public final List<Qualification> component21() {
        return this.qualificationList;
    }

    public final ShareInfo component22() {
        return this.shareInfo;
    }

    public final String component23() {
        return this.shopSales;
    }

    public final List<String> component24() {
        return this.tagNames;
    }

    public final Long component25() {
        return this.uid;
    }

    public final String component26() {
        return this.shopJumpLink;
    }

    public final String component27() {
        return this.upJumpLink;
    }

    public final String component28() {
        return this.upName;
    }

    public final Integer component29() {
        return this.upOfficialType;
    }

    public final String component3() {
        return this.businessLicenseUrl;
    }

    public final String component30() {
        return this.upPortrait;
    }

    public final String component4() {
        return this.customerLink;
    }

    public final String component5() {
        return this.fans;
    }

    public final String component6() {
        return this.h5CustomerLink;
    }

    public final Long component7() {
        return this.itemsNum;
    }

    public final List<MerchantAdviser> component8() {
        return this.merchantAdvisers;
    }

    public final List<MerchantDecor> component9() {
        return this.merchantDecorList;
    }

    public final ProductShopDetailsMerchantInfo copy(Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, Long l, List<MerchantAdviser> list, List<MerchantDecor> list2, MerchantIcon merchantIcon, Integer num, MerchantNotice merchantNotice, String str5, String str6, Integer num2, String str7, String str8, Boolean bool3, JsonElement jsonElement, String str9, List<Qualification> list3, ShareInfo shareInfo, String str10, List<String> list4, Long l2, String str11, String str12, String str13, Integer num3, String str14) {
        return new ProductShopDetailsMerchantInfo(bool, bool2, str, str2, str3, str4, l, list, list2, merchantIcon, num, merchantNotice, str5, str6, num2, str7, str8, bool3, jsonElement, str9, list3, shareInfo, str10, list4, l2, str11, str12, str13, num3, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductShopDetailsMerchantInfo) {
            ProductShopDetailsMerchantInfo productShopDetailsMerchantInfo = (ProductShopDetailsMerchantInfo) obj;
            return Intrinsics.areEqual(this.assemblyComputerMerchant, productShopDetailsMerchantInfo.assemblyComputerMerchant) && Intrinsics.areEqual(this.bindUp, productShopDetailsMerchantInfo.bindUp) && Intrinsics.areEqual(this.businessLicenseUrl, productShopDetailsMerchantInfo.businessLicenseUrl) && Intrinsics.areEqual(this.customerLink, productShopDetailsMerchantInfo.customerLink) && Intrinsics.areEqual(this.fans, productShopDetailsMerchantInfo.fans) && Intrinsics.areEqual(this.h5CustomerLink, productShopDetailsMerchantInfo.h5CustomerLink) && Intrinsics.areEqual(this.itemsNum, productShopDetailsMerchantInfo.itemsNum) && Intrinsics.areEqual(this.merchantAdvisers, productShopDetailsMerchantInfo.merchantAdvisers) && Intrinsics.areEqual(this.merchantDecorList, productShopDetailsMerchantInfo.merchantDecorList) && Intrinsics.areEqual(this.merchantIcon, productShopDetailsMerchantInfo.merchantIcon) && Intrinsics.areEqual(this.merchantId, productShopDetailsMerchantInfo.merchantId) && Intrinsics.areEqual(this.merchantNoticeVo, productShopDetailsMerchantInfo.merchantNoticeVo) && Intrinsics.areEqual(this.merchantShopFace, productShopDetailsMerchantInfo.merchantShopFace) && Intrinsics.areEqual(this.merchantShopName, productShopDetailsMerchantInfo.merchantShopName) && Intrinsics.areEqual(this.merchantType, productShopDetailsMerchantInfo.merchantType) && Intrinsics.areEqual(this.myCartUrl, productShopDetailsMerchantInfo.myCartUrl) && Intrinsics.areEqual(this.myOrderUrl, productShopDetailsMerchantInfo.myOrderUrl) && Intrinsics.areEqual(this.noticed, productShopDetailsMerchantInfo.noticed) && Intrinsics.areEqual(this.positiveRatioElement, productShopDetailsMerchantInfo.positiveRatioElement) && Intrinsics.areEqual(this.positiveRatioStr, productShopDetailsMerchantInfo.positiveRatioStr) && Intrinsics.areEqual(this.qualificationList, productShopDetailsMerchantInfo.qualificationList) && Intrinsics.areEqual(this.shareInfo, productShopDetailsMerchantInfo.shareInfo) && Intrinsics.areEqual(this.shopSales, productShopDetailsMerchantInfo.shopSales) && Intrinsics.areEqual(this.tagNames, productShopDetailsMerchantInfo.tagNames) && Intrinsics.areEqual(this.uid, productShopDetailsMerchantInfo.uid) && Intrinsics.areEqual(this.shopJumpLink, productShopDetailsMerchantInfo.shopJumpLink) && Intrinsics.areEqual(this.upJumpLink, productShopDetailsMerchantInfo.upJumpLink) && Intrinsics.areEqual(this.upName, productShopDetailsMerchantInfo.upName) && Intrinsics.areEqual(this.upOfficialType, productShopDetailsMerchantInfo.upOfficialType) && Intrinsics.areEqual(this.upPortrait, productShopDetailsMerchantInfo.upPortrait);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.assemblyComputerMerchant == null ? 0 : this.assemblyComputerMerchant.hashCode()) * 31) + (this.bindUp == null ? 0 : this.bindUp.hashCode())) * 31) + (this.businessLicenseUrl == null ? 0 : this.businessLicenseUrl.hashCode())) * 31) + (this.customerLink == null ? 0 : this.customerLink.hashCode())) * 31) + (this.fans == null ? 0 : this.fans.hashCode())) * 31) + (this.h5CustomerLink == null ? 0 : this.h5CustomerLink.hashCode())) * 31) + (this.itemsNum == null ? 0 : this.itemsNum.hashCode())) * 31) + (this.merchantAdvisers == null ? 0 : this.merchantAdvisers.hashCode())) * 31) + (this.merchantDecorList == null ? 0 : this.merchantDecorList.hashCode())) * 31) + (this.merchantIcon == null ? 0 : this.merchantIcon.hashCode())) * 31) + (this.merchantId == null ? 0 : this.merchantId.hashCode())) * 31) + (this.merchantNoticeVo == null ? 0 : this.merchantNoticeVo.hashCode())) * 31) + (this.merchantShopFace == null ? 0 : this.merchantShopFace.hashCode())) * 31) + (this.merchantShopName == null ? 0 : this.merchantShopName.hashCode())) * 31) + (this.merchantType == null ? 0 : this.merchantType.hashCode())) * 31) + (this.myCartUrl == null ? 0 : this.myCartUrl.hashCode())) * 31) + (this.myOrderUrl == null ? 0 : this.myOrderUrl.hashCode())) * 31) + (this.noticed == null ? 0 : this.noticed.hashCode())) * 31) + (this.positiveRatioElement == null ? 0 : this.positiveRatioElement.hashCode())) * 31) + (this.positiveRatioStr == null ? 0 : this.positiveRatioStr.hashCode())) * 31) + (this.qualificationList == null ? 0 : this.qualificationList.hashCode())) * 31) + (this.shareInfo == null ? 0 : this.shareInfo.hashCode())) * 31) + (this.shopSales == null ? 0 : this.shopSales.hashCode())) * 31) + (this.tagNames == null ? 0 : this.tagNames.hashCode())) * 31) + (this.uid == null ? 0 : this.uid.hashCode())) * 31) + (this.shopJumpLink == null ? 0 : this.shopJumpLink.hashCode())) * 31) + (this.upJumpLink == null ? 0 : this.upJumpLink.hashCode())) * 31) + (this.upName == null ? 0 : this.upName.hashCode())) * 31) + (this.upOfficialType == null ? 0 : this.upOfficialType.hashCode())) * 31) + (this.upPortrait != null ? this.upPortrait.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.assemblyComputerMerchant;
        Boolean bool2 = this.bindUp;
        String str = this.businessLicenseUrl;
        String str2 = this.customerLink;
        String str3 = this.fans;
        String str4 = this.h5CustomerLink;
        Long l = this.itemsNum;
        List<MerchantAdviser> list = this.merchantAdvisers;
        List<MerchantDecor> list2 = this.merchantDecorList;
        MerchantIcon merchantIcon = this.merchantIcon;
        Integer num = this.merchantId;
        MerchantNotice merchantNotice = this.merchantNoticeVo;
        String str5 = this.merchantShopFace;
        String str6 = this.merchantShopName;
        Integer num2 = this.merchantType;
        String str7 = this.myCartUrl;
        String str8 = this.myOrderUrl;
        Boolean bool3 = this.noticed;
        JsonElement jsonElement = this.positiveRatioElement;
        String str9 = this.positiveRatioStr;
        List<Qualification> list3 = this.qualificationList;
        ShareInfo shareInfo = this.shareInfo;
        String str10 = this.shopSales;
        List<String> list4 = this.tagNames;
        Long l2 = this.uid;
        String str11 = this.shopJumpLink;
        String str12 = this.upJumpLink;
        String str13 = this.upName;
        Integer num3 = this.upOfficialType;
        return "ProductShopDetailsMerchantInfo(assemblyComputerMerchant=" + bool + ", bindUp=" + bool2 + ", businessLicenseUrl=" + str + ", customerLink=" + str2 + ", fans=" + str3 + ", h5CustomerLink=" + str4 + ", itemsNum=" + l + ", merchantAdvisers=" + list + ", merchantDecorList=" + list2 + ", merchantIcon=" + merchantIcon + ", merchantId=" + num + ", merchantNoticeVo=" + merchantNotice + ", merchantShopFace=" + str5 + ", merchantShopName=" + str6 + ", merchantType=" + num2 + ", myCartUrl=" + str7 + ", myOrderUrl=" + str8 + ", noticed=" + bool3 + ", positiveRatioElement=" + jsonElement + ", positiveRatioStr=" + str9 + ", qualificationList=" + list3 + ", shareInfo=" + shareInfo + ", shopSales=" + str10 + ", tagNames=" + list4 + ", uid=" + l2 + ", shopJumpLink=" + str11 + ", upJumpLink=" + str12 + ", upName=" + str13 + ", upOfficialType=" + num3 + ", upPortrait=" + this.upPortrait + ")";
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ProductShopDetailsMerchantInfo> serializer() {
            return ProductShopDetailsMerchantInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ProductShopDetailsMerchantInfo(int seen0, Boolean assemblyComputerMerchant, Boolean bindUp, String businessLicenseUrl, String customerLink, String fans, String h5CustomerLink, Long itemsNum, List merchantAdvisers, List merchantDecorList, MerchantIcon merchantIcon, Integer merchantId, MerchantNotice merchantNoticeVo, String merchantShopFace, String merchantShopName, Integer merchantType, String myCartUrl, String myOrderUrl, Boolean noticed, JsonElement positiveRatioElement, String positiveRatioStr, List qualificationList, ShareInfo shareInfo, String shopSales, List tagNames, Long uid, String shopJumpLink, String upJumpLink, String upName, Integer upOfficialType, String upPortrait, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.assemblyComputerMerchant = null;
        } else {
            this.assemblyComputerMerchant = assemblyComputerMerchant;
        }
        if ((seen0 & 2) == 0) {
            this.bindUp = null;
        } else {
            this.bindUp = bindUp;
        }
        if ((seen0 & 4) == 0) {
            this.businessLicenseUrl = null;
        } else {
            this.businessLicenseUrl = businessLicenseUrl;
        }
        if ((seen0 & 8) == 0) {
            this.customerLink = null;
        } else {
            this.customerLink = customerLink;
        }
        if ((seen0 & 16) == 0) {
            this.fans = null;
        } else {
            this.fans = fans;
        }
        if ((seen0 & 32) == 0) {
            this.h5CustomerLink = null;
        } else {
            this.h5CustomerLink = h5CustomerLink;
        }
        if ((seen0 & 64) == 0) {
            this.itemsNum = null;
        } else {
            this.itemsNum = itemsNum;
        }
        if ((seen0 & 128) == 0) {
            this.merchantAdvisers = null;
        } else {
            this.merchantAdvisers = merchantAdvisers;
        }
        if ((seen0 & 256) == 0) {
            this.merchantDecorList = null;
        } else {
            this.merchantDecorList = merchantDecorList;
        }
        if ((seen0 & 512) == 0) {
            this.merchantIcon = null;
        } else {
            this.merchantIcon = merchantIcon;
        }
        if ((seen0 & 1024) == 0) {
            this.merchantId = null;
        } else {
            this.merchantId = merchantId;
        }
        if ((seen0 & 2048) == 0) {
            this.merchantNoticeVo = null;
        } else {
            this.merchantNoticeVo = merchantNoticeVo;
        }
        if ((seen0 & 4096) == 0) {
            this.merchantShopFace = null;
        } else {
            this.merchantShopFace = merchantShopFace;
        }
        if ((seen0 & 8192) == 0) {
            this.merchantShopName = null;
        } else {
            this.merchantShopName = merchantShopName;
        }
        if ((seen0 & 16384) == 0) {
            this.merchantType = null;
        } else {
            this.merchantType = merchantType;
        }
        if ((seen0 & 32768) == 0) {
            this.myCartUrl = null;
        } else {
            this.myCartUrl = myCartUrl;
        }
        if ((seen0 & 65536) == 0) {
            this.myOrderUrl = null;
        } else {
            this.myOrderUrl = myOrderUrl;
        }
        if ((seen0 & 131072) == 0) {
            this.noticed = null;
        } else {
            this.noticed = noticed;
        }
        if ((seen0 & 262144) == 0) {
            this.positiveRatioElement = null;
        } else {
            this.positiveRatioElement = positiveRatioElement;
        }
        if ((seen0 & 524288) == 0) {
            this.positiveRatioStr = null;
        } else {
            this.positiveRatioStr = positiveRatioStr;
        }
        if ((seen0 & 1048576) == 0) {
            this.qualificationList = null;
        } else {
            this.qualificationList = qualificationList;
        }
        if ((seen0 & 2097152) == 0) {
            this.shareInfo = null;
        } else {
            this.shareInfo = shareInfo;
        }
        if ((seen0 & 4194304) == 0) {
            this.shopSales = null;
        } else {
            this.shopSales = shopSales;
        }
        if ((seen0 & 8388608) == 0) {
            this.tagNames = null;
        } else {
            this.tagNames = tagNames;
        }
        if ((seen0 & 16777216) == 0) {
            this.uid = null;
        } else {
            this.uid = uid;
        }
        if ((seen0 & 33554432) == 0) {
            this.shopJumpLink = null;
        } else {
            this.shopJumpLink = shopJumpLink;
        }
        if ((seen0 & 67108864) == 0) {
            this.upJumpLink = null;
        } else {
            this.upJumpLink = upJumpLink;
        }
        if ((seen0 & 134217728) == 0) {
            this.upName = null;
        } else {
            this.upName = upName;
        }
        if ((seen0 & 268435456) == 0) {
            this.upOfficialType = null;
        } else {
            this.upOfficialType = upOfficialType;
        }
        if ((seen0 & 536870912) == 0) {
            this.upPortrait = null;
        } else {
            this.upPortrait = upPortrait;
        }
    }

    public ProductShopDetailsMerchantInfo(Boolean assemblyComputerMerchant, Boolean bindUp, String businessLicenseUrl, String customerLink, String fans, String h5CustomerLink, Long itemsNum, List<MerchantAdviser> list, List<MerchantDecor> list2, MerchantIcon merchantIcon, Integer merchantId, MerchantNotice merchantNoticeVo, String merchantShopFace, String merchantShopName, Integer merchantType, String myCartUrl, String myOrderUrl, Boolean noticed, JsonElement positiveRatioElement, String positiveRatioStr, List<Qualification> list3, ShareInfo shareInfo, String shopSales, List<String> list4, Long uid, String shopJumpLink, String upJumpLink, String upName, Integer upOfficialType, String upPortrait) {
        this.assemblyComputerMerchant = assemblyComputerMerchant;
        this.bindUp = bindUp;
        this.businessLicenseUrl = businessLicenseUrl;
        this.customerLink = customerLink;
        this.fans = fans;
        this.h5CustomerLink = h5CustomerLink;
        this.itemsNum = itemsNum;
        this.merchantAdvisers = list;
        this.merchantDecorList = list2;
        this.merchantIcon = merchantIcon;
        this.merchantId = merchantId;
        this.merchantNoticeVo = merchantNoticeVo;
        this.merchantShopFace = merchantShopFace;
        this.merchantShopName = merchantShopName;
        this.merchantType = merchantType;
        this.myCartUrl = myCartUrl;
        this.myOrderUrl = myOrderUrl;
        this.noticed = noticed;
        this.positiveRatioElement = positiveRatioElement;
        this.positiveRatioStr = positiveRatioStr;
        this.qualificationList = list3;
        this.shareInfo = shareInfo;
        this.shopSales = shopSales;
        this.tagNames = list4;
        this.uid = uid;
        this.shopJumpLink = shopJumpLink;
        this.upJumpLink = upJumpLink;
        this.upName = upName;
        this.upOfficialType = upOfficialType;
        this.upPortrait = upPortrait;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ProductShopDetailsMerchantInfo$MerchantAdviser$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(ProductShopDetailsMerchantInfo$MerchantDecor$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(ProductShopDetailsMerchantInfo$Qualification$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ProductShopDetailsMerchantInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.assemblyComputerMerchant != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.assemblyComputerMerchant);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.bindUp != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.bindUp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.businessLicenseUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.businessLicenseUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.customerLink != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.customerLink);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.fans != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.fans);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.h5CustomerLink != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.h5CustomerLink);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.itemsNum != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.itemsNum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.merchantAdvisers != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.merchantAdvisers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.merchantDecorList != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.merchantDecorList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.merchantIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, ProductShopDetailsMerchantInfo$MerchantIcon$$serializer.INSTANCE, self.merchantIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.merchantId != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.merchantId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.merchantNoticeVo != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, ProductShopDetailsMerchantInfo$MerchantNotice$$serializer.INSTANCE, self.merchantNoticeVo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.merchantShopFace != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.merchantShopFace);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.merchantShopName != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.merchantShopName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.merchantType != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, IntSerializer.INSTANCE, self.merchantType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.myCartUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.myCartUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.myOrderUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.myOrderUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.noticed != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, BooleanSerializer.INSTANCE, self.noticed);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.positiveRatioElement != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, JsonElementSerializer.INSTANCE, self.positiveRatioElement);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.positiveRatioStr != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.positiveRatioStr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.qualificationList != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, lazyArr[20].getValue(), self.qualificationList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.shareInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, ProductShopDetailsMerchantInfo$ShareInfo$$serializer.INSTANCE, self.shareInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.shopSales != null) {
            output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.shopSales);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.tagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, lazyArr[23].getValue(), self.tagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.uid != null) {
            output.encodeNullableSerializableElement(serialDesc, 24, LongSerializer.INSTANCE, self.uid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || self.shopJumpLink != null) {
            output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.shopJumpLink);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.upJumpLink != null) {
            output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.upJumpLink);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.upName != null) {
            output.encodeNullableSerializableElement(serialDesc, 27, StringSerializer.INSTANCE, self.upName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28) || self.upOfficialType != null) {
            output.encodeNullableSerializableElement(serialDesc, 28, IntSerializer.INSTANCE, self.upOfficialType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29) || self.upPortrait != null) {
            output.encodeNullableSerializableElement(serialDesc, 29, StringSerializer.INSTANCE, self.upPortrait);
        }
    }

    public /* synthetic */ ProductShopDetailsMerchantInfo(Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, Long l, List list, List list2, MerchantIcon merchantIcon, Integer num, MerchantNotice merchantNotice, String str5, String str6, Integer num2, String str7, String str8, Boolean bool3, JsonElement jsonElement, String str9, List list3, ShareInfo shareInfo, String str10, List list4, Long l2, String str11, String str12, String str13, Integer num3, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? null : merchantIcon, (i & 1024) != 0 ? null : num, (i & 2048) != 0 ? null : merchantNotice, (i & 4096) != 0 ? null : str5, (i & 8192) != 0 ? null : str6, (i & 16384) != 0 ? null : num2, (i & 32768) != 0 ? null : str7, (i & 65536) != 0 ? null : str8, (i & 131072) != 0 ? null : bool3, (i & 262144) != 0 ? null : jsonElement, (i & 524288) != 0 ? null : str9, (i & 1048576) != 0 ? null : list3, (i & 2097152) != 0 ? null : shareInfo, (i & 4194304) != 0 ? null : str10, (i & 8388608) != 0 ? null : list4, (i & 16777216) != 0 ? null : l2, (i & 33554432) != 0 ? null : str11, (i & 67108864) != 0 ? null : str12, (i & 134217728) != 0 ? null : str13, (i & 268435456) != 0 ? null : num3, (i & 536870912) != 0 ? null : str14);
    }

    public final Boolean getAssemblyComputerMerchant() {
        return this.assemblyComputerMerchant;
    }

    public final Boolean getBindUp() {
        return this.bindUp;
    }

    public final String getBusinessLicenseUrl() {
        return this.businessLicenseUrl;
    }

    public final String getCustomerLink() {
        return this.customerLink;
    }

    public final String getFans() {
        return this.fans;
    }

    public final String getH5CustomerLink() {
        return this.h5CustomerLink;
    }

    public final Long getItemsNum() {
        return this.itemsNum;
    }

    public final List<MerchantAdviser> getMerchantAdvisers() {
        return this.merchantAdvisers;
    }

    public final List<MerchantDecor> getMerchantDecorList() {
        return this.merchantDecorList;
    }

    public final MerchantIcon getMerchantIcon() {
        return this.merchantIcon;
    }

    public final Integer getMerchantId() {
        return this.merchantId;
    }

    public final MerchantNotice getMerchantNoticeVo() {
        return this.merchantNoticeVo;
    }

    public final String getMerchantShopFace() {
        return this.merchantShopFace;
    }

    public final String getMerchantShopName() {
        return this.merchantShopName;
    }

    public final Integer getMerchantType() {
        return this.merchantType;
    }

    public final String getMyCartUrl() {
        return this.myCartUrl;
    }

    public final String getMyOrderUrl() {
        return this.myOrderUrl;
    }

    public final Boolean getNoticed() {
        return this.noticed;
    }

    public final JsonElement getPositiveRatioElement() {
        return this.positiveRatioElement;
    }

    public final String getPositiveRatioStr() {
        return this.positiveRatioStr;
    }

    public final List<Qualification> getQualificationList() {
        return this.qualificationList;
    }

    public final ShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public final String getShopSales() {
        return this.shopSales;
    }

    public final List<String> getTagNames() {
        return this.tagNames;
    }

    public final Long getUid() {
        return this.uid;
    }

    public final String getShopJumpLink() {
        return this.shopJumpLink;
    }

    public final String getUpJumpLink() {
        return this.upJumpLink;
    }

    public final String getUpName() {
        return this.upName;
    }

    public final Integer getUpOfficialType() {
        return this.upOfficialType;
    }

    public final String getUpPortrait() {
        return this.upPortrait;
    }

    public final Double getPositiveRatio() {
        if (this.positiveRatioElement instanceof JsonPrimitive) {
            if (this.positiveRatioElement.isString()) {
                return StringsKt.toDoubleOrNull(this.positiveRatioElement.getContent());
            }
            if (JsonElementKt.getDoubleOrNull(this.positiveRatioElement) != null) {
                return Double.valueOf(JsonElementKt.getDouble(this.positiveRatioElement));
            }
            return null;
        }
        String str = this.positiveRatioStr;
        if (str != null) {
            return StringsKt.toDoubleOrNull(str);
        }
        return null;
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015Jn\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0010HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b \u0010\u0015¨\u0006:"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantAdviser;", "", "busyStartTime", "", "jumpUrl", "", "merchantFace", "merchantFaceMark", "merchantMid", "merchantNick", "online", "", "userMid", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBusyStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getJumpUrl", "()Ljava/lang/String;", "getMerchantFace", "getMerchantFaceMark", "getMerchantMid", "getMerchantNick", "getOnline", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getUserMid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantAdviser;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MerchantAdviser {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Long busyStartTime;
        private final String jumpUrl;
        private final String merchantFace;
        private final String merchantFaceMark;
        private final Long merchantMid;
        private final String merchantNick;
        private final Byte online;
        private final Long userMid;

        public MerchantAdviser() {
            this((Long) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (Byte) null, (Long) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
        }

        public final Long component1() {
            return this.busyStartTime;
        }

        public final String component2() {
            return this.jumpUrl;
        }

        public final String component3() {
            return this.merchantFace;
        }

        public final String component4() {
            return this.merchantFaceMark;
        }

        public final Long component5() {
            return this.merchantMid;
        }

        public final String component6() {
            return this.merchantNick;
        }

        public final Byte component7() {
            return this.online;
        }

        public final Long component8() {
            return this.userMid;
        }

        public final MerchantAdviser copy(Long l, String str, String str2, String str3, Long l2, String str4, Byte b, Long l3) {
            return new MerchantAdviser(l, str, str2, str3, l2, str4, b, l3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MerchantAdviser) {
                MerchantAdviser merchantAdviser = (MerchantAdviser) obj;
                return Intrinsics.areEqual(this.busyStartTime, merchantAdviser.busyStartTime) && Intrinsics.areEqual(this.jumpUrl, merchantAdviser.jumpUrl) && Intrinsics.areEqual(this.merchantFace, merchantAdviser.merchantFace) && Intrinsics.areEqual(this.merchantFaceMark, merchantAdviser.merchantFaceMark) && Intrinsics.areEqual(this.merchantMid, merchantAdviser.merchantMid) && Intrinsics.areEqual(this.merchantNick, merchantAdviser.merchantNick) && Intrinsics.areEqual(this.online, merchantAdviser.online) && Intrinsics.areEqual(this.userMid, merchantAdviser.userMid);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((this.busyStartTime == null ? 0 : this.busyStartTime.hashCode()) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.merchantFace == null ? 0 : this.merchantFace.hashCode())) * 31) + (this.merchantFaceMark == null ? 0 : this.merchantFaceMark.hashCode())) * 31) + (this.merchantMid == null ? 0 : this.merchantMid.hashCode())) * 31) + (this.merchantNick == null ? 0 : this.merchantNick.hashCode())) * 31) + (this.online == null ? 0 : this.online.hashCode())) * 31) + (this.userMid != null ? this.userMid.hashCode() : 0);
        }

        public String toString() {
            Long l = this.busyStartTime;
            String str = this.jumpUrl;
            String str2 = this.merchantFace;
            String str3 = this.merchantFaceMark;
            Long l2 = this.merchantMid;
            String str4 = this.merchantNick;
            Byte b = this.online;
            return "MerchantAdviser(busyStartTime=" + l + ", jumpUrl=" + str + ", merchantFace=" + str2 + ", merchantFaceMark=" + str3 + ", merchantMid=" + l2 + ", merchantNick=" + str4 + ", online=" + b + ", userMid=" + this.userMid + ")";
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantAdviser$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantAdviser;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MerchantAdviser> serializer() {
                return ProductShopDetailsMerchantInfo$MerchantAdviser$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MerchantAdviser(int seen0, Long busyStartTime, String jumpUrl, String merchantFace, String merchantFaceMark, Long merchantMid, String merchantNick, Byte online, Long userMid, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.busyStartTime = null;
            } else {
                this.busyStartTime = busyStartTime;
            }
            if ((seen0 & 2) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 4) == 0) {
                this.merchantFace = null;
            } else {
                this.merchantFace = merchantFace;
            }
            if ((seen0 & 8) == 0) {
                this.merchantFaceMark = null;
            } else {
                this.merchantFaceMark = merchantFaceMark;
            }
            if ((seen0 & 16) == 0) {
                this.merchantMid = null;
            } else {
                this.merchantMid = merchantMid;
            }
            if ((seen0 & 32) == 0) {
                this.merchantNick = null;
            } else {
                this.merchantNick = merchantNick;
            }
            if ((seen0 & 64) == 0) {
                this.online = null;
            } else {
                this.online = online;
            }
            if ((seen0 & 128) == 0) {
                this.userMid = null;
            } else {
                this.userMid = userMid;
            }
        }

        public MerchantAdviser(Long busyStartTime, String jumpUrl, String merchantFace, String merchantFaceMark, Long merchantMid, String merchantNick, Byte online, Long userMid) {
            this.busyStartTime = busyStartTime;
            this.jumpUrl = jumpUrl;
            this.merchantFace = merchantFace;
            this.merchantFaceMark = merchantFaceMark;
            this.merchantMid = merchantMid;
            this.merchantNick = merchantNick;
            this.online = online;
            this.userMid = userMid;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(MerchantAdviser self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.busyStartTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.busyStartTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.merchantFace != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.merchantFace);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.merchantFaceMark != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.merchantFaceMark);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.merchantMid != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.merchantMid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.merchantNick != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.merchantNick);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.online != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, ByteSerializer.INSTANCE, self.online);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.userMid != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, LongSerializer.INSTANCE, self.userMid);
            }
        }

        public /* synthetic */ MerchantAdviser(Long l, String str, String str2, String str3, Long l2, String str4, Byte b, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : b, (i & 128) == 0 ? l3 : null);
        }

        public final Long getBusyStartTime() {
            return this.busyStartTime;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final String getMerchantFace() {
            return this.merchantFace;
        }

        public final String getMerchantFaceMark() {
            return this.merchantFaceMark;
        }

        public final Long getMerchantMid() {
            return this.merchantMid;
        }

        public final String getMerchantNick() {
            return this.merchantNick;
        }

        public final Byte getOnline() {
            return this.online;
        }

        public final Long getUserMid() {
            return this.userMid;
        }
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantDecor;", "", "img", "", "jumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImg", "()Ljava/lang/String;", "getJumpUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MerchantDecor {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String img;
        private final String jumpUrl;

        public MerchantDecor() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MerchantDecor copy$default(MerchantDecor merchantDecor, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = merchantDecor.img;
            }
            if ((i & 2) != 0) {
                str2 = merchantDecor.jumpUrl;
            }
            return merchantDecor.copy(str, str2);
        }

        public final String component1() {
            return this.img;
        }

        public final String component2() {
            return this.jumpUrl;
        }

        public final MerchantDecor copy(String str, String str2) {
            return new MerchantDecor(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MerchantDecor) {
                MerchantDecor merchantDecor = (MerchantDecor) obj;
                return Intrinsics.areEqual(this.img, merchantDecor.img) && Intrinsics.areEqual(this.jumpUrl, merchantDecor.jumpUrl);
            }
            return false;
        }

        public int hashCode() {
            return ((this.img == null ? 0 : this.img.hashCode()) * 31) + (this.jumpUrl != null ? this.jumpUrl.hashCode() : 0);
        }

        public String toString() {
            String str = this.img;
            return "MerchantDecor(img=" + str + ", jumpUrl=" + this.jumpUrl + ")";
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantDecor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantDecor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MerchantDecor> serializer() {
                return ProductShopDetailsMerchantInfo$MerchantDecor$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MerchantDecor(int seen0, String img, String jumpUrl, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.img = null;
            } else {
                this.img = img;
            }
            if ((seen0 & 2) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
        }

        public MerchantDecor(String img, String jumpUrl) {
            this.img = img;
            this.jumpUrl = jumpUrl;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(MerchantDecor self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.img != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.img);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.jumpUrl);
            }
        }

        public /* synthetic */ MerchantDecor(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getImg() {
            return this.img;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantIcon;", "", "icon", "", "jumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIcon", "()Ljava/lang/String;", "getJumpUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MerchantIcon {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String icon;
        private final String jumpUrl;

        public MerchantIcon() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MerchantIcon copy$default(MerchantIcon merchantIcon, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = merchantIcon.icon;
            }
            if ((i & 2) != 0) {
                str2 = merchantIcon.jumpUrl;
            }
            return merchantIcon.copy(str, str2);
        }

        public final String component1() {
            return this.icon;
        }

        public final String component2() {
            return this.jumpUrl;
        }

        public final MerchantIcon copy(String str, String str2) {
            return new MerchantIcon(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MerchantIcon) {
                MerchantIcon merchantIcon = (MerchantIcon) obj;
                return Intrinsics.areEqual(this.icon, merchantIcon.icon) && Intrinsics.areEqual(this.jumpUrl, merchantIcon.jumpUrl);
            }
            return false;
        }

        public int hashCode() {
            return ((this.icon == null ? 0 : this.icon.hashCode()) * 31) + (this.jumpUrl != null ? this.jumpUrl.hashCode() : 0);
        }

        public String toString() {
            String str = this.icon;
            return "MerchantIcon(icon=" + str + ", jumpUrl=" + this.jumpUrl + ")";
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantIcon$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantIcon;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MerchantIcon> serializer() {
                return ProductShopDetailsMerchantInfo$MerchantIcon$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MerchantIcon(int seen0, String icon, String jumpUrl, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.icon = null;
            } else {
                this.icon = icon;
            }
            if ((seen0 & 2) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
        }

        public MerchantIcon(String icon, String jumpUrl) {
            this.icon = icon;
            this.jumpUrl = jumpUrl;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(MerchantIcon self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.icon != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.icon);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.jumpUrl);
            }
        }

        public /* synthetic */ MerchantIcon(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantNotice;", "", "content", "", "tag", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContent", "()Ljava/lang/String;", "getTag", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MerchantNotice {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String content;
        private final String tag;
        private final String title;

        public MerchantNotice() {
            this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MerchantNotice copy$default(MerchantNotice merchantNotice, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = merchantNotice.content;
            }
            if ((i & 2) != 0) {
                str2 = merchantNotice.tag;
            }
            if ((i & 4) != 0) {
                str3 = merchantNotice.title;
            }
            return merchantNotice.copy(str, str2, str3);
        }

        public final String component1() {
            return this.content;
        }

        public final String component2() {
            return this.tag;
        }

        public final String component3() {
            return this.title;
        }

        public final MerchantNotice copy(String str, String str2, String str3) {
            return new MerchantNotice(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MerchantNotice) {
                MerchantNotice merchantNotice = (MerchantNotice) obj;
                return Intrinsics.areEqual(this.content, merchantNotice.content) && Intrinsics.areEqual(this.tag, merchantNotice.tag) && Intrinsics.areEqual(this.title, merchantNotice.title);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.content == null ? 0 : this.content.hashCode()) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
        }

        public String toString() {
            String str = this.content;
            String str2 = this.tag;
            return "MerchantNotice(content=" + str + ", tag=" + str2 + ", title=" + this.title + ")";
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantNotice$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$MerchantNotice;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MerchantNotice> serializer() {
                return ProductShopDetailsMerchantInfo$MerchantNotice$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MerchantNotice(int seen0, String content, String tag, String title, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.content = null;
            } else {
                this.content = content;
            }
            if ((seen0 & 2) == 0) {
                this.tag = null;
            } else {
                this.tag = tag;
            }
            if ((seen0 & 4) == 0) {
                this.title = null;
            } else {
                this.title = title;
            }
        }

        public MerchantNotice(String content, String tag, String title) {
            this.content = content;
            this.tag = tag;
            this.title = title;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(MerchantNotice self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.content != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.content);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.tag != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.tag);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.title);
            }
        }

        public /* synthetic */ MerchantNotice(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getContent() {
            return this.content;
        }

        public final String getTag() {
            return this.tag;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$Qualification;", "", "name", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Qualification {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String name;
        private final String url;

        public Qualification() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Qualification copy$default(Qualification qualification, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = qualification.name;
            }
            if ((i & 2) != 0) {
                str2 = qualification.url;
            }
            return qualification.copy(str, str2);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.url;
        }

        public final Qualification copy(String str, String str2) {
            return new Qualification(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Qualification) {
                Qualification qualification = (Qualification) obj;
                return Intrinsics.areEqual(this.name, qualification.name) && Intrinsics.areEqual(this.url, qualification.url);
            }
            return false;
        }

        public int hashCode() {
            return ((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.url != null ? this.url.hashCode() : 0);
        }

        public String toString() {
            String str = this.name;
            return "Qualification(name=" + str + ", url=" + this.url + ")";
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$Qualification$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$Qualification;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Qualification> serializer() {
                return ProductShopDetailsMerchantInfo$Qualification$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Qualification(int seen0, String name, String url, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.name = null;
            } else {
                this.name = name;
            }
            if ((seen0 & 2) == 0) {
                this.url = null;
            } else {
                this.url = url;
            }
        }

        public Qualification(String name, String url) {
            this.name = name;
            this.url = url;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(Qualification self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.url != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.url);
            }
        }

        public /* synthetic */ Qualification(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getName() {
            return this.name;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$ShareInfo;", "", "shareDesc", "", "shareImg", "shareTitle", "shareUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShareDesc", "()Ljava/lang/String;", "getShareImg", "getShareTitle", "getShareUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShareInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String shareDesc;
        private final String shareImg;
        private final String shareTitle;
        private final String shareUrl;

        public ShareInfo() {
            this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ShareInfo copy$default(ShareInfo shareInfo, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = shareInfo.shareDesc;
            }
            if ((i & 2) != 0) {
                str2 = shareInfo.shareImg;
            }
            if ((i & 4) != 0) {
                str3 = shareInfo.shareTitle;
            }
            if ((i & 8) != 0) {
                str4 = shareInfo.shareUrl;
            }
            return shareInfo.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.shareDesc;
        }

        public final String component2() {
            return this.shareImg;
        }

        public final String component3() {
            return this.shareTitle;
        }

        public final String component4() {
            return this.shareUrl;
        }

        public final ShareInfo copy(String str, String str2, String str3, String str4) {
            return new ShareInfo(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShareInfo) {
                ShareInfo shareInfo = (ShareInfo) obj;
                return Intrinsics.areEqual(this.shareDesc, shareInfo.shareDesc) && Intrinsics.areEqual(this.shareImg, shareInfo.shareImg) && Intrinsics.areEqual(this.shareTitle, shareInfo.shareTitle) && Intrinsics.areEqual(this.shareUrl, shareInfo.shareUrl);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.shareDesc == null ? 0 : this.shareDesc.hashCode()) * 31) + (this.shareImg == null ? 0 : this.shareImg.hashCode())) * 31) + (this.shareTitle == null ? 0 : this.shareTitle.hashCode())) * 31) + (this.shareUrl != null ? this.shareUrl.hashCode() : 0);
        }

        public String toString() {
            String str = this.shareDesc;
            String str2 = this.shareImg;
            String str3 = this.shareTitle;
            return "ShareInfo(shareDesc=" + str + ", shareImg=" + str2 + ", shareTitle=" + str3 + ", shareUrl=" + this.shareUrl + ")";
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$ShareInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsMerchantInfo$ShareInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ShareInfo> serializer() {
                return ProductShopDetailsMerchantInfo$ShareInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ShareInfo(int seen0, String shareDesc, String shareImg, String shareTitle, String shareUrl, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.shareDesc = null;
            } else {
                this.shareDesc = shareDesc;
            }
            if ((seen0 & 2) == 0) {
                this.shareImg = null;
            } else {
                this.shareImg = shareImg;
            }
            if ((seen0 & 4) == 0) {
                this.shareTitle = null;
            } else {
                this.shareTitle = shareTitle;
            }
            if ((seen0 & 8) == 0) {
                this.shareUrl = null;
            } else {
                this.shareUrl = shareUrl;
            }
        }

        public ShareInfo(String shareDesc, String shareImg, String shareTitle, String shareUrl) {
            this.shareDesc = shareDesc;
            this.shareImg = shareImg;
            this.shareTitle = shareTitle;
            this.shareUrl = shareUrl;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ShareInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.shareDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.shareDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.shareImg != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.shareImg);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.shareTitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.shareTitle);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.shareUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.shareUrl);
            }
        }

        public /* synthetic */ ShareInfo(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public final String getShareDesc() {
            return this.shareDesc;
        }

        public final String getShareImg() {
            return this.shareImg;
        }

        public final String getShareTitle() {
            return this.shareTitle;
        }

        public final String getShareUrl() {
            return this.shareUrl;
        }
    }
}