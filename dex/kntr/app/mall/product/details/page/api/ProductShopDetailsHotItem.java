package kntr.app.mall.product.details.page.api;

import java.util.List;
import kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem;
import kntr.app.mall.product.details.page.api.model.AttrListItem;
import kntr.app.mall.product.details.page.api.model.AttrListItem$$serializer;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ProductShopApiService.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 ~2\u00020\u0001:\u0003|}~Bé\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b%\u0010&BÅ\u0002\b\u0010\u0012\u0006\u0010'\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0004\b%\u0010*J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010S\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00105J\u0011\u0010V\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\tHÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010X\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010i\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010j\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010k\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010.Jð\u0002\u0010m\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010nJ\u0013\u0010o\u001a\u00020p2\b\u0010q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010r\u001a\u00020\u0007HÖ\u0001J\t\u0010s\u001a\u00020\u0003HÖ\u0001J%\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\u00002\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020zH\u0001¢\u0006\u0002\b{R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00106\u001a\u0004\b\n\u00105R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b7\u00104R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010/\u001a\u0004\b8\u0010.R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00102\u001a\u0004\b=\u00101R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010,R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00102\u001a\u0004\b@\u00101R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010,R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010,R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010,R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00106\u001a\u0004\bD\u00105R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010,R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bF\u00104R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010,R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010,R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00102\u001a\u0004\bI\u00101R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00102\u001a\u0004\bJ\u00101R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010,R\u0015\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00106\u001a\u0004\bL\u00105R\u0015\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00102\u001a\u0004\bM\u00101R\u0015\u0010\"\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00106\u001a\u0004\bN\u00105R\u0015\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00102\u001a\u0004\bO\u00101R\u0015\u0010$\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010/\u001a\u0004\bP\u0010.¨\u0006\u007f"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem;", "", "coin", "", "d7Pv", "", "depositType", "", "img", "", "isMagnetic", "", "itemsAttrList", "Lkntr/app/mall/product/details/page/api/model/AttrListItem;", "itemsId", "itemsTag", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag;", "itemsType", "jumpUrl", "lastRewardPrice", "like", "logData", "maxPrice", "name", "payType", "price", "priceDesc", "pricePrefix", "priceSymbol", "pubTime", "rareNum", "recId", "saleType", "shopId", "subSaleType", "totalNum", "wishSuccessNum", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCoin", "()Ljava/lang/String;", "getD7Pv", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDepositType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImg", "()Ljava/util/List;", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getItemsAttrList", "getItemsId", "getItemsTag$annotations", "()V", "getItemsTag", "()Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag;", "getItemsType", "getJumpUrl", "getLastRewardPrice", "getLike", "getLogData", "getMaxPrice", "getName", "getPayType", "getPrice", "getPriceDesc", "getPricePrefix", "getPriceSymbol", "getPubTime", "getRareNum", "getRecId", "getSaleType", "getShopId", "getSubSaleType", "getTotalNum", "getWishSuccessNum", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ItemsTag", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ProductShopDetailsHotItem {
    private final String coin;
    private final Long d7Pv;
    private final Integer depositType;
    private final List<String> img;
    private final Byte isMagnetic;
    private final List<AttrListItem> itemsAttrList;
    private final Long itemsId;
    private final ItemsTag itemsTag;
    private final Integer itemsType;
    private final String jumpUrl;
    private final String lastRewardPrice;
    private final Integer like;
    private final String logData;
    private final String maxPrice;
    private final String name;
    private final Byte payType;
    private final String price;
    private final List<String> priceDesc;
    private final String pricePrefix;
    private final String priceSymbol;
    private final Integer pubTime;
    private final Integer rareNum;
    private final String recId;
    private final Byte saleType;
    private final Integer shopId;
    private final Byte subSaleType;
    private final Integer totalNum;
    private final Long wishSuccessNum;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ProductShopDetailsHotItem._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ProductShopDetailsHotItem._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = ProductShopDetailsHotItem._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), null, null, null, null, null, null, null, null, null, null};

    public ProductShopDetailsHotItem() {
        this((String) null, (Long) null, (Integer) null, (List) null, (Byte) null, (List) null, (Long) null, (ItemsTag) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Byte) null, (String) null, (List) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (Byte) null, (Integer) null, (Byte) null, (Integer) null, (Long) null, 268435455, (DefaultConstructorMarker) null);
    }

    @SerialName("itemsTagVO")
    public static /* synthetic */ void getItemsTag$annotations() {
    }

    public final String component1() {
        return this.coin;
    }

    public final String component10() {
        return this.jumpUrl;
    }

    public final String component11() {
        return this.lastRewardPrice;
    }

    public final Integer component12() {
        return this.like;
    }

    public final String component13() {
        return this.logData;
    }

    public final String component14() {
        return this.maxPrice;
    }

    public final String component15() {
        return this.name;
    }

    public final Byte component16() {
        return this.payType;
    }

    public final String component17() {
        return this.price;
    }

    public final List<String> component18() {
        return this.priceDesc;
    }

    public final String component19() {
        return this.pricePrefix;
    }

    public final Long component2() {
        return this.d7Pv;
    }

    public final String component20() {
        return this.priceSymbol;
    }

    public final Integer component21() {
        return this.pubTime;
    }

    public final Integer component22() {
        return this.rareNum;
    }

    public final String component23() {
        return this.recId;
    }

    public final Byte component24() {
        return this.saleType;
    }

    public final Integer component25() {
        return this.shopId;
    }

    public final Byte component26() {
        return this.subSaleType;
    }

    public final Integer component27() {
        return this.totalNum;
    }

    public final Long component28() {
        return this.wishSuccessNum;
    }

    public final Integer component3() {
        return this.depositType;
    }

    public final List<String> component4() {
        return this.img;
    }

    public final Byte component5() {
        return this.isMagnetic;
    }

    public final List<AttrListItem> component6() {
        return this.itemsAttrList;
    }

    public final Long component7() {
        return this.itemsId;
    }

    public final ItemsTag component8() {
        return this.itemsTag;
    }

    public final Integer component9() {
        return this.itemsType;
    }

    public final ProductShopDetailsHotItem copy(String str, Long l, Integer num, List<String> list, Byte b, List<AttrListItem> list2, Long l2, ItemsTag itemsTag, Integer num2, String str2, String str3, Integer num3, String str4, String str5, String str6, Byte b2, String str7, List<String> list3, String str8, String str9, Integer num4, Integer num5, String str10, Byte b3, Integer num6, Byte b4, Integer num7, Long l3) {
        return new ProductShopDetailsHotItem(str, l, num, list, b, list2, l2, itemsTag, num2, str2, str3, num3, str4, str5, str6, b2, str7, list3, str8, str9, num4, num5, str10, b3, num6, b4, num7, l3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductShopDetailsHotItem) {
            ProductShopDetailsHotItem productShopDetailsHotItem = (ProductShopDetailsHotItem) obj;
            return Intrinsics.areEqual(this.coin, productShopDetailsHotItem.coin) && Intrinsics.areEqual(this.d7Pv, productShopDetailsHotItem.d7Pv) && Intrinsics.areEqual(this.depositType, productShopDetailsHotItem.depositType) && Intrinsics.areEqual(this.img, productShopDetailsHotItem.img) && Intrinsics.areEqual(this.isMagnetic, productShopDetailsHotItem.isMagnetic) && Intrinsics.areEqual(this.itemsAttrList, productShopDetailsHotItem.itemsAttrList) && Intrinsics.areEqual(this.itemsId, productShopDetailsHotItem.itemsId) && Intrinsics.areEqual(this.itemsTag, productShopDetailsHotItem.itemsTag) && Intrinsics.areEqual(this.itemsType, productShopDetailsHotItem.itemsType) && Intrinsics.areEqual(this.jumpUrl, productShopDetailsHotItem.jumpUrl) && Intrinsics.areEqual(this.lastRewardPrice, productShopDetailsHotItem.lastRewardPrice) && Intrinsics.areEqual(this.like, productShopDetailsHotItem.like) && Intrinsics.areEqual(this.logData, productShopDetailsHotItem.logData) && Intrinsics.areEqual(this.maxPrice, productShopDetailsHotItem.maxPrice) && Intrinsics.areEqual(this.name, productShopDetailsHotItem.name) && Intrinsics.areEqual(this.payType, productShopDetailsHotItem.payType) && Intrinsics.areEqual(this.price, productShopDetailsHotItem.price) && Intrinsics.areEqual(this.priceDesc, productShopDetailsHotItem.priceDesc) && Intrinsics.areEqual(this.pricePrefix, productShopDetailsHotItem.pricePrefix) && Intrinsics.areEqual(this.priceSymbol, productShopDetailsHotItem.priceSymbol) && Intrinsics.areEqual(this.pubTime, productShopDetailsHotItem.pubTime) && Intrinsics.areEqual(this.rareNum, productShopDetailsHotItem.rareNum) && Intrinsics.areEqual(this.recId, productShopDetailsHotItem.recId) && Intrinsics.areEqual(this.saleType, productShopDetailsHotItem.saleType) && Intrinsics.areEqual(this.shopId, productShopDetailsHotItem.shopId) && Intrinsics.areEqual(this.subSaleType, productShopDetailsHotItem.subSaleType) && Intrinsics.areEqual(this.totalNum, productShopDetailsHotItem.totalNum) && Intrinsics.areEqual(this.wishSuccessNum, productShopDetailsHotItem.wishSuccessNum);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((this.coin == null ? 0 : this.coin.hashCode()) * 31) + (this.d7Pv == null ? 0 : this.d7Pv.hashCode())) * 31) + (this.depositType == null ? 0 : this.depositType.hashCode())) * 31) + (this.img == null ? 0 : this.img.hashCode())) * 31) + (this.isMagnetic == null ? 0 : this.isMagnetic.hashCode())) * 31) + (this.itemsAttrList == null ? 0 : this.itemsAttrList.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.itemsTag == null ? 0 : this.itemsTag.hashCode())) * 31) + (this.itemsType == null ? 0 : this.itemsType.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.lastRewardPrice == null ? 0 : this.lastRewardPrice.hashCode())) * 31) + (this.like == null ? 0 : this.like.hashCode())) * 31) + (this.logData == null ? 0 : this.logData.hashCode())) * 31) + (this.maxPrice == null ? 0 : this.maxPrice.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.payType == null ? 0 : this.payType.hashCode())) * 31) + (this.price == null ? 0 : this.price.hashCode())) * 31) + (this.priceDesc == null ? 0 : this.priceDesc.hashCode())) * 31) + (this.pricePrefix == null ? 0 : this.pricePrefix.hashCode())) * 31) + (this.priceSymbol == null ? 0 : this.priceSymbol.hashCode())) * 31) + (this.pubTime == null ? 0 : this.pubTime.hashCode())) * 31) + (this.rareNum == null ? 0 : this.rareNum.hashCode())) * 31) + (this.recId == null ? 0 : this.recId.hashCode())) * 31) + (this.saleType == null ? 0 : this.saleType.hashCode())) * 31) + (this.shopId == null ? 0 : this.shopId.hashCode())) * 31) + (this.subSaleType == null ? 0 : this.subSaleType.hashCode())) * 31) + (this.totalNum == null ? 0 : this.totalNum.hashCode())) * 31) + (this.wishSuccessNum != null ? this.wishSuccessNum.hashCode() : 0);
    }

    public String toString() {
        String str = this.coin;
        Long l = this.d7Pv;
        Integer num = this.depositType;
        List<String> list = this.img;
        Byte b = this.isMagnetic;
        List<AttrListItem> list2 = this.itemsAttrList;
        Long l2 = this.itemsId;
        ItemsTag itemsTag = this.itemsTag;
        Integer num2 = this.itemsType;
        String str2 = this.jumpUrl;
        String str3 = this.lastRewardPrice;
        Integer num3 = this.like;
        String str4 = this.logData;
        String str5 = this.maxPrice;
        String str6 = this.name;
        Byte b2 = this.payType;
        String str7 = this.price;
        List<String> list3 = this.priceDesc;
        String str8 = this.pricePrefix;
        String str9 = this.priceSymbol;
        Integer num4 = this.pubTime;
        Integer num5 = this.rareNum;
        String str10 = this.recId;
        Byte b3 = this.saleType;
        Integer num6 = this.shopId;
        Byte b4 = this.subSaleType;
        Integer num7 = this.totalNum;
        return "ProductShopDetailsHotItem(coin=" + str + ", d7Pv=" + l + ", depositType=" + num + ", img=" + list + ", isMagnetic=" + b + ", itemsAttrList=" + list2 + ", itemsId=" + l2 + ", itemsTag=" + itemsTag + ", itemsType=" + num2 + ", jumpUrl=" + str2 + ", lastRewardPrice=" + str3 + ", like=" + num3 + ", logData=" + str4 + ", maxPrice=" + str5 + ", name=" + str6 + ", payType=" + b2 + ", price=" + str7 + ", priceDesc=" + list3 + ", pricePrefix=" + str8 + ", priceSymbol=" + str9 + ", pubTime=" + num4 + ", rareNum=" + num5 + ", recId=" + str10 + ", saleType=" + b3 + ", shopId=" + num6 + ", subSaleType=" + b4 + ", totalNum=" + num7 + ", wishSuccessNum=" + this.wishSuccessNum + ")";
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ProductShopDetailsHotItem> serializer() {
            return ProductShopDetailsHotItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ProductShopDetailsHotItem(int seen0, String coin, Long d7Pv, Integer depositType, List img, Byte isMagnetic, List itemsAttrList, Long itemsId, ItemsTag itemsTag, Integer itemsType, String jumpUrl, String lastRewardPrice, Integer like, String logData, String maxPrice, String name, Byte payType, String price, List priceDesc, String pricePrefix, String priceSymbol, Integer pubTime, Integer rareNum, String recId, Byte saleType, Integer shopId, Byte subSaleType, Integer totalNum, Long wishSuccessNum, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.coin = null;
        } else {
            this.coin = coin;
        }
        if ((seen0 & 2) == 0) {
            this.d7Pv = null;
        } else {
            this.d7Pv = d7Pv;
        }
        if ((seen0 & 4) == 0) {
            this.depositType = null;
        } else {
            this.depositType = depositType;
        }
        if ((seen0 & 8) == 0) {
            this.img = null;
        } else {
            this.img = img;
        }
        if ((seen0 & 16) == 0) {
            this.isMagnetic = null;
        } else {
            this.isMagnetic = isMagnetic;
        }
        if ((seen0 & 32) == 0) {
            this.itemsAttrList = null;
        } else {
            this.itemsAttrList = itemsAttrList;
        }
        if ((seen0 & 64) == 0) {
            this.itemsId = null;
        } else {
            this.itemsId = itemsId;
        }
        if ((seen0 & 128) == 0) {
            this.itemsTag = null;
        } else {
            this.itemsTag = itemsTag;
        }
        if ((seen0 & 256) == 0) {
            this.itemsType = null;
        } else {
            this.itemsType = itemsType;
        }
        if ((seen0 & 512) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
        if ((seen0 & 1024) == 0) {
            this.lastRewardPrice = null;
        } else {
            this.lastRewardPrice = lastRewardPrice;
        }
        if ((seen0 & 2048) == 0) {
            this.like = null;
        } else {
            this.like = like;
        }
        if ((seen0 & 4096) == 0) {
            this.logData = null;
        } else {
            this.logData = logData;
        }
        if ((seen0 & 8192) == 0) {
            this.maxPrice = null;
        } else {
            this.maxPrice = maxPrice;
        }
        if ((seen0 & 16384) == 0) {
            this.name = null;
        } else {
            this.name = name;
        }
        if ((seen0 & 32768) == 0) {
            this.payType = null;
        } else {
            this.payType = payType;
        }
        if ((seen0 & 65536) == 0) {
            this.price = null;
        } else {
            this.price = price;
        }
        if ((seen0 & 131072) == 0) {
            this.priceDesc = null;
        } else {
            this.priceDesc = priceDesc;
        }
        if ((seen0 & 262144) == 0) {
            this.pricePrefix = null;
        } else {
            this.pricePrefix = pricePrefix;
        }
        if ((seen0 & 524288) == 0) {
            this.priceSymbol = null;
        } else {
            this.priceSymbol = priceSymbol;
        }
        if ((seen0 & 1048576) == 0) {
            this.pubTime = null;
        } else {
            this.pubTime = pubTime;
        }
        if ((seen0 & 2097152) == 0) {
            this.rareNum = null;
        } else {
            this.rareNum = rareNum;
        }
        if ((seen0 & 4194304) == 0) {
            this.recId = null;
        } else {
            this.recId = recId;
        }
        if ((seen0 & 8388608) == 0) {
            this.saleType = null;
        } else {
            this.saleType = saleType;
        }
        if ((seen0 & 16777216) == 0) {
            this.shopId = null;
        } else {
            this.shopId = shopId;
        }
        if ((seen0 & 33554432) == 0) {
            this.subSaleType = null;
        } else {
            this.subSaleType = subSaleType;
        }
        if ((seen0 & 67108864) == 0) {
            this.totalNum = null;
        } else {
            this.totalNum = totalNum;
        }
        if ((seen0 & 134217728) == 0) {
            this.wishSuccessNum = null;
        } else {
            this.wishSuccessNum = wishSuccessNum;
        }
    }

    public ProductShopDetailsHotItem(String coin, Long d7Pv, Integer depositType, List<String> list, Byte isMagnetic, List<AttrListItem> list2, Long itemsId, ItemsTag itemsTag, Integer itemsType, String jumpUrl, String lastRewardPrice, Integer like, String logData, String maxPrice, String name, Byte payType, String price, List<String> list3, String pricePrefix, String priceSymbol, Integer pubTime, Integer rareNum, String recId, Byte saleType, Integer shopId, Byte subSaleType, Integer totalNum, Long wishSuccessNum) {
        this.coin = coin;
        this.d7Pv = d7Pv;
        this.depositType = depositType;
        this.img = list;
        this.isMagnetic = isMagnetic;
        this.itemsAttrList = list2;
        this.itemsId = itemsId;
        this.itemsTag = itemsTag;
        this.itemsType = itemsType;
        this.jumpUrl = jumpUrl;
        this.lastRewardPrice = lastRewardPrice;
        this.like = like;
        this.logData = logData;
        this.maxPrice = maxPrice;
        this.name = name;
        this.payType = payType;
        this.price = price;
        this.priceDesc = list3;
        this.pricePrefix = pricePrefix;
        this.priceSymbol = priceSymbol;
        this.pubTime = pubTime;
        this.rareNum = rareNum;
        this.recId = recId;
        this.saleType = saleType;
        this.shopId = shopId;
        this.subSaleType = subSaleType;
        this.totalNum = totalNum;
        this.wishSuccessNum = wishSuccessNum;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(AttrListItem$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ProductShopDetailsHotItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.coin != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.coin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.d7Pv != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.d7Pv);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.depositType != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.depositType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.img != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.img);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isMagnetic != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, ByteSerializer.INSTANCE, self.isMagnetic);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.itemsAttrList != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.itemsAttrList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.itemsId != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.itemsId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.itemsTag != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, ProductShopDetailsHotItem$ItemsTag$$serializer.INSTANCE, self.itemsTag);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.itemsType != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.itemsType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.jumpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.lastRewardPrice != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.lastRewardPrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.like != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.like);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.logData != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.logData);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.maxPrice != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.maxPrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.payType != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, ByteSerializer.INSTANCE, self.payType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.price);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.priceDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, lazyArr[17].getValue(), self.priceDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.pricePrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.pricePrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.priceSymbol != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.priceSymbol);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.pubTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, IntSerializer.INSTANCE, self.pubTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.rareNum != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, IntSerializer.INSTANCE, self.rareNum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.recId != null) {
            output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.recId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.saleType != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, ByteSerializer.INSTANCE, self.saleType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || self.shopId != null) {
            output.encodeNullableSerializableElement(serialDesc, 24, IntSerializer.INSTANCE, self.shopId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) || self.subSaleType != null) {
            output.encodeNullableSerializableElement(serialDesc, 25, ByteSerializer.INSTANCE, self.subSaleType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) || self.totalNum != null) {
            output.encodeNullableSerializableElement(serialDesc, 26, IntSerializer.INSTANCE, self.totalNum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) || self.wishSuccessNum != null) {
            output.encodeNullableSerializableElement(serialDesc, 27, LongSerializer.INSTANCE, self.wishSuccessNum);
        }
    }

    public /* synthetic */ ProductShopDetailsHotItem(String str, Long l, Integer num, List list, Byte b, List list2, Long l2, ItemsTag itemsTag, Integer num2, String str2, String str3, Integer num3, String str4, String str5, String str6, Byte b2, String str7, List list3, String str8, String str9, Integer num4, Integer num5, String str10, Byte b3, Integer num6, Byte b4, Integer num7, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : b, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : l2, (i & 128) != 0 ? null : itemsTag, (i & 256) != 0 ? null : num2, (i & 512) != 0 ? null : str2, (i & 1024) != 0 ? null : str3, (i & 2048) != 0 ? null : num3, (i & 4096) != 0 ? null : str4, (i & 8192) != 0 ? null : str5, (i & 16384) != 0 ? null : str6, (i & 32768) != 0 ? null : b2, (i & 65536) != 0 ? null : str7, (i & 131072) != 0 ? null : list3, (i & 262144) != 0 ? null : str8, (i & 524288) != 0 ? null : str9, (i & 1048576) != 0 ? null : num4, (i & 2097152) != 0 ? null : num5, (i & 4194304) != 0 ? null : str10, (i & 8388608) != 0 ? null : b3, (i & 16777216) != 0 ? null : num6, (i & 33554432) != 0 ? null : b4, (i & 67108864) != 0 ? null : num7, (i & 134217728) != 0 ? null : l3);
    }

    public final String getCoin() {
        return this.coin;
    }

    public final Long getD7Pv() {
        return this.d7Pv;
    }

    public final Integer getDepositType() {
        return this.depositType;
    }

    public final List<String> getImg() {
        return this.img;
    }

    public final Byte isMagnetic() {
        return this.isMagnetic;
    }

    public final List<AttrListItem> getItemsAttrList() {
        return this.itemsAttrList;
    }

    public final Long getItemsId() {
        return this.itemsId;
    }

    public final ItemsTag getItemsTag() {
        return this.itemsTag;
    }

    public final Integer getItemsType() {
        return this.itemsType;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getLastRewardPrice() {
        return this.lastRewardPrice;
    }

    public final Integer getLike() {
        return this.like;
    }

    public final String getLogData() {
        return this.logData;
    }

    public final String getMaxPrice() {
        return this.maxPrice;
    }

    public final String getName() {
        return this.name;
    }

    public final Byte getPayType() {
        return this.payType;
    }

    public final String getPrice() {
        return this.price;
    }

    public final List<String> getPriceDesc() {
        return this.priceDesc;
    }

    public final String getPricePrefix() {
        return this.pricePrefix;
    }

    public final String getPriceSymbol() {
        return this.priceSymbol;
    }

    public final Integer getPubTime() {
        return this.pubTime;
    }

    public final Integer getRareNum() {
        return this.rareNum;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final Byte getSaleType() {
        return this.saleType;
    }

    public final Integer getShopId() {
        return this.shopId;
    }

    public final Byte getSubSaleType() {
        return this.subSaleType;
    }

    public final Integer getTotalNum() {
        return this.totalNum;
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 g2\u00020\u0001:\u0005cdefgBû\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001d\u0010\u001eBã\u0002\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b\u001d\u0010#J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jý\u0002\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020 HÖ\u0001J\t\u0010Z\u001a\u00020\u0006HÖ\u0001J%\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0001¢\u0006\u0002\bbR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010'R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010'R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>¨\u0006h"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag;", "", "actThereMaterial", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial;", "actionTags", "", "", "adTagNames", "attributeTagNames", "blindBoxCommendTags", "blindBoxEuroNames", "blindBoxHasWishNames", "blindBoxHideTypeNames", "drainageTags", "exclusiveSalePoints", "feedBoardTag", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$FeedBoardTag;", "godlikeTag", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$GodlikeTag;", "itemTagNames", "marketingTagNames", "otherSalePoints", "promotionTagNames", "recommendTagNames", "saleTypeTagNames", "serviceTagNames", "tagsSort", "titleTagNames", "typeAndLimitTagName", "<init>", "(Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$FeedBoardTag;Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$GodlikeTag;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$FeedBoardTag;Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$GodlikeTag;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActThereMaterial", "()Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial;", "getActionTags", "()Ljava/util/List;", "getAdTagNames", "getAttributeTagNames", "getBlindBoxCommendTags", "getBlindBoxEuroNames", "getBlindBoxHasWishNames", "getBlindBoxHideTypeNames", "getDrainageTags", "getExclusiveSalePoints", "getFeedBoardTag", "()Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$FeedBoardTag;", "getGodlikeTag", "()Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$GodlikeTag;", "getItemTagNames", "getMarketingTagNames", "getOtherSalePoints", "getPromotionTagNames", "getRecommendTagNames", "getSaleTypeTagNames", "getServiceTagNames", "getTagsSort", "getTitleTagNames", "getTypeAndLimitTagName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ActThereMaterial", "FeedBoardTag", "GodlikeTag", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ItemsTag {
        private final ActThereMaterial actThereMaterial;
        private final List<String> actionTags;
        private final List<String> adTagNames;
        private final List<String> attributeTagNames;
        private final List<String> blindBoxCommendTags;
        private final List<String> blindBoxEuroNames;
        private final List<String> blindBoxHasWishNames;
        private final List<String> blindBoxHideTypeNames;
        private final List<String> drainageTags;
        private final List<String> exclusiveSalePoints;
        private final FeedBoardTag feedBoardTag;
        private final GodlikeTag godlikeTag;
        private final List<String> itemTagNames;
        private final List<String> marketingTagNames;
        private final List<String> otherSalePoints;
        private final List<String> promotionTagNames;
        private final List<String> recommendTagNames;
        private final List<String> saleTypeTagNames;
        private final List<String> serviceTagNames;
        private final List<String> tagsSort;
        private final List<String> titleTagNames;
        private final String typeAndLimitTagName;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda17
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$1;
                _childSerializers$_anonymous_$1 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$1();
                return _childSerializers$_anonymous_$1;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda2
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$2;
                _childSerializers$_anonymous_$2 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$2();
                return _childSerializers$_anonymous_$2;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda3
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$3;
                _childSerializers$_anonymous_$3 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$3();
                return _childSerializers$_anonymous_$3;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda4
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$4;
                _childSerializers$_anonymous_$4 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$4();
                return _childSerializers$_anonymous_$4;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda5
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$5;
                _childSerializers$_anonymous_$5 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$5();
                return _childSerializers$_anonymous_$5;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda6
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$6;
                _childSerializers$_anonymous_$6 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$6();
                return _childSerializers$_anonymous_$6;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda7
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$7;
                _childSerializers$_anonymous_$7 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$7();
                return _childSerializers$_anonymous_$7;
            }
        }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda8
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$8;
                _childSerializers$_anonymous_$8 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$8();
                return _childSerializers$_anonymous_$8;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda9
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$9;
                _childSerializers$_anonymous_$9 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$9();
                return _childSerializers$_anonymous_$9;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda10
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$10;
                _childSerializers$_anonymous_$10 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$10();
                return _childSerializers$_anonymous_$10;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda11
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$11;
                _childSerializers$_anonymous_$11 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$11();
                return _childSerializers$_anonymous_$11;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda12
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$12;
                _childSerializers$_anonymous_$12 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$12();
                return _childSerializers$_anonymous_$12;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda13
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$13;
                _childSerializers$_anonymous_$13 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$13();
                return _childSerializers$_anonymous_$13;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda14
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$14;
                _childSerializers$_anonymous_$14 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$14();
                return _childSerializers$_anonymous_$14;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda15
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$15;
                _childSerializers$_anonymous_$15 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$15();
                return _childSerializers$_anonymous_$15;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.ProductShopDetailsHotItem$ItemsTag$$ExternalSyntheticLambda16
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$16;
                _childSerializers$_anonymous_$16 = ProductShopDetailsHotItem.ItemsTag._childSerializers$_anonymous_$16();
                return _childSerializers$_anonymous_$16;
            }
        }), null};

        public ItemsTag() {
            this((ActThereMaterial) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (FeedBoardTag) null, (GodlikeTag) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (String) null, 4194303, (DefaultConstructorMarker) null);
        }

        public final ActThereMaterial component1() {
            return this.actThereMaterial;
        }

        public final List<String> component10() {
            return this.exclusiveSalePoints;
        }

        public final FeedBoardTag component11() {
            return this.feedBoardTag;
        }

        public final GodlikeTag component12() {
            return this.godlikeTag;
        }

        public final List<String> component13() {
            return this.itemTagNames;
        }

        public final List<String> component14() {
            return this.marketingTagNames;
        }

        public final List<String> component15() {
            return this.otherSalePoints;
        }

        public final List<String> component16() {
            return this.promotionTagNames;
        }

        public final List<String> component17() {
            return this.recommendTagNames;
        }

        public final List<String> component18() {
            return this.saleTypeTagNames;
        }

        public final List<String> component19() {
            return this.serviceTagNames;
        }

        public final List<String> component2() {
            return this.actionTags;
        }

        public final List<String> component20() {
            return this.tagsSort;
        }

        public final List<String> component21() {
            return this.titleTagNames;
        }

        public final String component22() {
            return this.typeAndLimitTagName;
        }

        public final List<String> component3() {
            return this.adTagNames;
        }

        public final List<String> component4() {
            return this.attributeTagNames;
        }

        public final List<String> component5() {
            return this.blindBoxCommendTags;
        }

        public final List<String> component6() {
            return this.blindBoxEuroNames;
        }

        public final List<String> component7() {
            return this.blindBoxHasWishNames;
        }

        public final List<String> component8() {
            return this.blindBoxHideTypeNames;
        }

        public final List<String> component9() {
            return this.drainageTags;
        }

        public final ItemsTag copy(ActThereMaterial actThereMaterial, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<String> list7, List<String> list8, List<String> list9, FeedBoardTag feedBoardTag, GodlikeTag godlikeTag, List<String> list10, List<String> list11, List<String> list12, List<String> list13, List<String> list14, List<String> list15, List<String> list16, List<String> list17, List<String> list18, String str) {
            return new ItemsTag(actThereMaterial, list, list2, list3, list4, list5, list6, list7, list8, list9, feedBoardTag, godlikeTag, list10, list11, list12, list13, list14, list15, list16, list17, list18, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ItemsTag) {
                ItemsTag itemsTag = (ItemsTag) obj;
                return Intrinsics.areEqual(this.actThereMaterial, itemsTag.actThereMaterial) && Intrinsics.areEqual(this.actionTags, itemsTag.actionTags) && Intrinsics.areEqual(this.adTagNames, itemsTag.adTagNames) && Intrinsics.areEqual(this.attributeTagNames, itemsTag.attributeTagNames) && Intrinsics.areEqual(this.blindBoxCommendTags, itemsTag.blindBoxCommendTags) && Intrinsics.areEqual(this.blindBoxEuroNames, itemsTag.blindBoxEuroNames) && Intrinsics.areEqual(this.blindBoxHasWishNames, itemsTag.blindBoxHasWishNames) && Intrinsics.areEqual(this.blindBoxHideTypeNames, itemsTag.blindBoxHideTypeNames) && Intrinsics.areEqual(this.drainageTags, itemsTag.drainageTags) && Intrinsics.areEqual(this.exclusiveSalePoints, itemsTag.exclusiveSalePoints) && Intrinsics.areEqual(this.feedBoardTag, itemsTag.feedBoardTag) && Intrinsics.areEqual(this.godlikeTag, itemsTag.godlikeTag) && Intrinsics.areEqual(this.itemTagNames, itemsTag.itemTagNames) && Intrinsics.areEqual(this.marketingTagNames, itemsTag.marketingTagNames) && Intrinsics.areEqual(this.otherSalePoints, itemsTag.otherSalePoints) && Intrinsics.areEqual(this.promotionTagNames, itemsTag.promotionTagNames) && Intrinsics.areEqual(this.recommendTagNames, itemsTag.recommendTagNames) && Intrinsics.areEqual(this.saleTypeTagNames, itemsTag.saleTypeTagNames) && Intrinsics.areEqual(this.serviceTagNames, itemsTag.serviceTagNames) && Intrinsics.areEqual(this.tagsSort, itemsTag.tagsSort) && Intrinsics.areEqual(this.titleTagNames, itemsTag.titleTagNames) && Intrinsics.areEqual(this.typeAndLimitTagName, itemsTag.typeAndLimitTagName);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((this.actThereMaterial == null ? 0 : this.actThereMaterial.hashCode()) * 31) + (this.actionTags == null ? 0 : this.actionTags.hashCode())) * 31) + (this.adTagNames == null ? 0 : this.adTagNames.hashCode())) * 31) + (this.attributeTagNames == null ? 0 : this.attributeTagNames.hashCode())) * 31) + (this.blindBoxCommendTags == null ? 0 : this.blindBoxCommendTags.hashCode())) * 31) + (this.blindBoxEuroNames == null ? 0 : this.blindBoxEuroNames.hashCode())) * 31) + (this.blindBoxHasWishNames == null ? 0 : this.blindBoxHasWishNames.hashCode())) * 31) + (this.blindBoxHideTypeNames == null ? 0 : this.blindBoxHideTypeNames.hashCode())) * 31) + (this.drainageTags == null ? 0 : this.drainageTags.hashCode())) * 31) + (this.exclusiveSalePoints == null ? 0 : this.exclusiveSalePoints.hashCode())) * 31) + (this.feedBoardTag == null ? 0 : this.feedBoardTag.hashCode())) * 31) + (this.godlikeTag == null ? 0 : this.godlikeTag.hashCode())) * 31) + (this.itemTagNames == null ? 0 : this.itemTagNames.hashCode())) * 31) + (this.marketingTagNames == null ? 0 : this.marketingTagNames.hashCode())) * 31) + (this.otherSalePoints == null ? 0 : this.otherSalePoints.hashCode())) * 31) + (this.promotionTagNames == null ? 0 : this.promotionTagNames.hashCode())) * 31) + (this.recommendTagNames == null ? 0 : this.recommendTagNames.hashCode())) * 31) + (this.saleTypeTagNames == null ? 0 : this.saleTypeTagNames.hashCode())) * 31) + (this.serviceTagNames == null ? 0 : this.serviceTagNames.hashCode())) * 31) + (this.tagsSort == null ? 0 : this.tagsSort.hashCode())) * 31) + (this.titleTagNames == null ? 0 : this.titleTagNames.hashCode())) * 31) + (this.typeAndLimitTagName != null ? this.typeAndLimitTagName.hashCode() : 0);
        }

        public String toString() {
            ActThereMaterial actThereMaterial = this.actThereMaterial;
            List<String> list = this.actionTags;
            List<String> list2 = this.adTagNames;
            List<String> list3 = this.attributeTagNames;
            List<String> list4 = this.blindBoxCommendTags;
            List<String> list5 = this.blindBoxEuroNames;
            List<String> list6 = this.blindBoxHasWishNames;
            List<String> list7 = this.blindBoxHideTypeNames;
            List<String> list8 = this.drainageTags;
            List<String> list9 = this.exclusiveSalePoints;
            FeedBoardTag feedBoardTag = this.feedBoardTag;
            GodlikeTag godlikeTag = this.godlikeTag;
            List<String> list10 = this.itemTagNames;
            List<String> list11 = this.marketingTagNames;
            List<String> list12 = this.otherSalePoints;
            List<String> list13 = this.promotionTagNames;
            List<String> list14 = this.recommendTagNames;
            List<String> list15 = this.saleTypeTagNames;
            List<String> list16 = this.serviceTagNames;
            List<String> list17 = this.tagsSort;
            List<String> list18 = this.titleTagNames;
            return "ItemsTag(actThereMaterial=" + actThereMaterial + ", actionTags=" + list + ", adTagNames=" + list2 + ", attributeTagNames=" + list3 + ", blindBoxCommendTags=" + list4 + ", blindBoxEuroNames=" + list5 + ", blindBoxHasWishNames=" + list6 + ", blindBoxHideTypeNames=" + list7 + ", drainageTags=" + list8 + ", exclusiveSalePoints=" + list9 + ", feedBoardTag=" + feedBoardTag + ", godlikeTag=" + godlikeTag + ", itemTagNames=" + list10 + ", marketingTagNames=" + list11 + ", otherSalePoints=" + list12 + ", promotionTagNames=" + list13 + ", recommendTagNames=" + list14 + ", saleTypeTagNames=" + list15 + ", serviceTagNames=" + list16 + ", tagsSort=" + list17 + ", titleTagNames=" + list18 + ", typeAndLimitTagName=" + this.typeAndLimitTagName + ")";
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ItemsTag> serializer() {
                return ProductShopDetailsHotItem$ItemsTag$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ItemsTag(int seen0, ActThereMaterial actThereMaterial, List actionTags, List adTagNames, List attributeTagNames, List blindBoxCommendTags, List blindBoxEuroNames, List blindBoxHasWishNames, List blindBoxHideTypeNames, List drainageTags, List exclusiveSalePoints, FeedBoardTag feedBoardTag, GodlikeTag godlikeTag, List itemTagNames, List marketingTagNames, List otherSalePoints, List promotionTagNames, List recommendTagNames, List saleTypeTagNames, List serviceTagNames, List tagsSort, List titleTagNames, String typeAndLimitTagName, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.actThereMaterial = null;
            } else {
                this.actThereMaterial = actThereMaterial;
            }
            if ((seen0 & 2) == 0) {
                this.actionTags = null;
            } else {
                this.actionTags = actionTags;
            }
            if ((seen0 & 4) == 0) {
                this.adTagNames = null;
            } else {
                this.adTagNames = adTagNames;
            }
            if ((seen0 & 8) == 0) {
                this.attributeTagNames = null;
            } else {
                this.attributeTagNames = attributeTagNames;
            }
            if ((seen0 & 16) == 0) {
                this.blindBoxCommendTags = null;
            } else {
                this.blindBoxCommendTags = blindBoxCommendTags;
            }
            if ((seen0 & 32) == 0) {
                this.blindBoxEuroNames = null;
            } else {
                this.blindBoxEuroNames = blindBoxEuroNames;
            }
            if ((seen0 & 64) == 0) {
                this.blindBoxHasWishNames = null;
            } else {
                this.blindBoxHasWishNames = blindBoxHasWishNames;
            }
            if ((seen0 & 128) == 0) {
                this.blindBoxHideTypeNames = null;
            } else {
                this.blindBoxHideTypeNames = blindBoxHideTypeNames;
            }
            if ((seen0 & 256) == 0) {
                this.drainageTags = null;
            } else {
                this.drainageTags = drainageTags;
            }
            if ((seen0 & 512) == 0) {
                this.exclusiveSalePoints = null;
            } else {
                this.exclusiveSalePoints = exclusiveSalePoints;
            }
            if ((seen0 & 1024) == 0) {
                this.feedBoardTag = null;
            } else {
                this.feedBoardTag = feedBoardTag;
            }
            if ((seen0 & 2048) == 0) {
                this.godlikeTag = null;
            } else {
                this.godlikeTag = godlikeTag;
            }
            if ((seen0 & 4096) == 0) {
                this.itemTagNames = null;
            } else {
                this.itemTagNames = itemTagNames;
            }
            if ((seen0 & 8192) == 0) {
                this.marketingTagNames = null;
            } else {
                this.marketingTagNames = marketingTagNames;
            }
            if ((seen0 & 16384) == 0) {
                this.otherSalePoints = null;
            } else {
                this.otherSalePoints = otherSalePoints;
            }
            if ((seen0 & 32768) == 0) {
                this.promotionTagNames = null;
            } else {
                this.promotionTagNames = promotionTagNames;
            }
            if ((seen0 & 65536) == 0) {
                this.recommendTagNames = null;
            } else {
                this.recommendTagNames = recommendTagNames;
            }
            if ((seen0 & 131072) == 0) {
                this.saleTypeTagNames = null;
            } else {
                this.saleTypeTagNames = saleTypeTagNames;
            }
            if ((seen0 & 262144) == 0) {
                this.serviceTagNames = null;
            } else {
                this.serviceTagNames = serviceTagNames;
            }
            if ((seen0 & 524288) == 0) {
                this.tagsSort = null;
            } else {
                this.tagsSort = tagsSort;
            }
            if ((seen0 & 1048576) == 0) {
                this.titleTagNames = null;
            } else {
                this.titleTagNames = titleTagNames;
            }
            if ((seen0 & 2097152) == 0) {
                this.typeAndLimitTagName = null;
            } else {
                this.typeAndLimitTagName = typeAndLimitTagName;
            }
        }

        public ItemsTag(ActThereMaterial actThereMaterial, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<String> list7, List<String> list8, List<String> list9, FeedBoardTag feedBoardTag, GodlikeTag godlikeTag, List<String> list10, List<String> list11, List<String> list12, List<String> list13, List<String> list14, List<String> list15, List<String> list16, List<String> list17, List<String> list18, String typeAndLimitTagName) {
            this.actThereMaterial = actThereMaterial;
            this.actionTags = list;
            this.adTagNames = list2;
            this.attributeTagNames = list3;
            this.blindBoxCommendTags = list4;
            this.blindBoxEuroNames = list5;
            this.blindBoxHasWishNames = list6;
            this.blindBoxHideTypeNames = list7;
            this.drainageTags = list8;
            this.exclusiveSalePoints = list9;
            this.feedBoardTag = feedBoardTag;
            this.godlikeTag = godlikeTag;
            this.itemTagNames = list10;
            this.marketingTagNames = list11;
            this.otherSalePoints = list12;
            this.promotionTagNames = list13;
            this.recommendTagNames = list14;
            this.saleTypeTagNames = list15;
            this.serviceTagNames = list16;
            this.tagsSort = list17;
            this.titleTagNames = list18;
            this.typeAndLimitTagName = typeAndLimitTagName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$10() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$11() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$12() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$13() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$14() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$15() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$16() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$6() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$7() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$8() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$9() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ItemsTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.actThereMaterial != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$$serializer.INSTANCE, self.actThereMaterial);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.actionTags != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.actionTags);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.adTagNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.adTagNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.attributeTagNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.attributeTagNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.blindBoxCommendTags != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.blindBoxCommendTags);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.blindBoxEuroNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.blindBoxEuroNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.blindBoxHasWishNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.blindBoxHasWishNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.blindBoxHideTypeNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.blindBoxHideTypeNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.drainageTags != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.drainageTags);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.exclusiveSalePoints != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.exclusiveSalePoints);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.feedBoardTag != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, ProductShopDetailsHotItem$ItemsTag$FeedBoardTag$$serializer.INSTANCE, self.feedBoardTag);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.godlikeTag != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, ProductShopDetailsHotItem$ItemsTag$GodlikeTag$$serializer.INSTANCE, self.godlikeTag);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.itemTagNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, lazyArr[12].getValue(), self.itemTagNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.marketingTagNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, lazyArr[13].getValue(), self.marketingTagNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.otherSalePoints != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, lazyArr[14].getValue(), self.otherSalePoints);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.promotionTagNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, lazyArr[15].getValue(), self.promotionTagNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.recommendTagNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, lazyArr[16].getValue(), self.recommendTagNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.saleTypeTagNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, lazyArr[17].getValue(), self.saleTypeTagNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.serviceTagNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, lazyArr[18].getValue(), self.serviceTagNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.tagsSort != null) {
                output.encodeNullableSerializableElement(serialDesc, 19, lazyArr[19].getValue(), self.tagsSort);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || self.titleTagNames != null) {
                output.encodeNullableSerializableElement(serialDesc, 20, lazyArr[20].getValue(), self.titleTagNames);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.typeAndLimitTagName != null) {
                output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.typeAndLimitTagName);
            }
        }

        public /* synthetic */ ItemsTag(ActThereMaterial actThereMaterial, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, FeedBoardTag feedBoardTag, GodlikeTag godlikeTag, List list10, List list11, List list12, List list13, List list14, List list15, List list16, List list17, List list18, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : actThereMaterial, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3, (i & 16) != 0 ? null : list4, (i & 32) != 0 ? null : list5, (i & 64) != 0 ? null : list6, (i & 128) != 0 ? null : list7, (i & 256) != 0 ? null : list8, (i & 512) != 0 ? null : list9, (i & 1024) != 0 ? null : feedBoardTag, (i & 2048) != 0 ? null : godlikeTag, (i & 4096) != 0 ? null : list10, (i & 8192) != 0 ? null : list11, (i & 16384) != 0 ? null : list12, (i & 32768) != 0 ? null : list13, (i & 65536) != 0 ? null : list14, (i & 131072) != 0 ? null : list15, (i & 262144) != 0 ? null : list16, (i & 524288) != 0 ? null : list17, (i & 1048576) != 0 ? null : list18, (i & 2097152) != 0 ? null : str);
        }

        public final ActThereMaterial getActThereMaterial() {
            return this.actThereMaterial;
        }

        public final List<String> getActionTags() {
            return this.actionTags;
        }

        public final List<String> getAdTagNames() {
            return this.adTagNames;
        }

        public final List<String> getAttributeTagNames() {
            return this.attributeTagNames;
        }

        public final List<String> getBlindBoxCommendTags() {
            return this.blindBoxCommendTags;
        }

        public final List<String> getBlindBoxEuroNames() {
            return this.blindBoxEuroNames;
        }

        public final List<String> getBlindBoxHasWishNames() {
            return this.blindBoxHasWishNames;
        }

        public final List<String> getBlindBoxHideTypeNames() {
            return this.blindBoxHideTypeNames;
        }

        public final List<String> getDrainageTags() {
            return this.drainageTags;
        }

        public final List<String> getExclusiveSalePoints() {
            return this.exclusiveSalePoints;
        }

        public final FeedBoardTag getFeedBoardTag() {
            return this.feedBoardTag;
        }

        public final GodlikeTag getGodlikeTag() {
            return this.godlikeTag;
        }

        public final List<String> getItemTagNames() {
            return this.itemTagNames;
        }

        public final List<String> getMarketingTagNames() {
            return this.marketingTagNames;
        }

        public final List<String> getOtherSalePoints() {
            return this.otherSalePoints;
        }

        public final List<String> getPromotionTagNames() {
            return this.promotionTagNames;
        }

        public final List<String> getRecommendTagNames() {
            return this.recommendTagNames;
        }

        public final List<String> getSaleTypeTagNames() {
            return this.saleTypeTagNames;
        }

        public final List<String> getServiceTagNames() {
            return this.serviceTagNames;
        }

        public final List<String> getTagsSort() {
            return this.tagsSort;
        }

        public final List<String> getTitleTagNames() {
            return this.titleTagNames;
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0003$%&B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial;", "", "cardBgImg", "", "promotionTagStyle", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$TagStyle;", "rightIconImg", "<init>", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$TagStyle;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$TagStyle;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardBgImg", "()Ljava/lang/String;", "getPromotionTagStyle", "()Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$TagStyle;", "getRightIconImg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "TagStyle", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class ActThereMaterial {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String cardBgImg;
            private final TagStyle promotionTagStyle;
            private final String rightIconImg;

            public ActThereMaterial() {
                this((String) null, (TagStyle) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ ActThereMaterial copy$default(ActThereMaterial actThereMaterial, String str, TagStyle tagStyle, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = actThereMaterial.cardBgImg;
                }
                if ((i & 2) != 0) {
                    tagStyle = actThereMaterial.promotionTagStyle;
                }
                if ((i & 4) != 0) {
                    str2 = actThereMaterial.rightIconImg;
                }
                return actThereMaterial.copy(str, tagStyle, str2);
            }

            public final String component1() {
                return this.cardBgImg;
            }

            public final TagStyle component2() {
                return this.promotionTagStyle;
            }

            public final String component3() {
                return this.rightIconImg;
            }

            public final ActThereMaterial copy(String str, TagStyle tagStyle, String str2) {
                return new ActThereMaterial(str, tagStyle, str2);
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
                TagStyle tagStyle = this.promotionTagStyle;
                return "ActThereMaterial(cardBgImg=" + str + ", promotionTagStyle=" + tagStyle + ", rightIconImg=" + this.rightIconImg + ")";
            }

            /* compiled from: ProductShopApiService.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ActThereMaterial> serializer() {
                    return ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ActThereMaterial(int seen0, String cardBgImg, TagStyle promotionTagStyle, String rightIconImg, SerializationConstructorMarker serializationConstructorMarker) {
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

            public ActThereMaterial(String cardBgImg, TagStyle promotionTagStyle, String rightIconImg) {
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
                    output.encodeNullableSerializableElement(serialDesc, 1, ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$TagStyle$$serializer.INSTANCE, self.promotionTagStyle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.rightIconImg != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.rightIconImg);
                }
            }

            public /* synthetic */ ActThereMaterial(String str, TagStyle tagStyle, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : tagStyle, (i & 4) != 0 ? null : str2);
            }

            public final String getCardBgImg() {
                return this.cardBgImg;
            }

            public final TagStyle getPromotionTagStyle() {
                return this.promotionTagStyle;
            }

            /* compiled from: ProductShopApiService.kt */
            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$TagStyle;", "", "tagNameBgColor", "", "tagNameBgColorDark", "tagNameColor", "tagNameColorDark", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTagNameBgColor", "()Ljava/lang/String;", "getTagNameBgColorDark", "getTagNameColor", "getTagNameColorDark", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class TagStyle {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String tagNameBgColor;
                private final String tagNameBgColorDark;
                private final String tagNameColor;
                private final String tagNameColorDark;

                public TagStyle() {
                    this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ TagStyle copy$default(TagStyle tagStyle, String str, String str2, String str3, String str4, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = tagStyle.tagNameBgColor;
                    }
                    if ((i & 2) != 0) {
                        str2 = tagStyle.tagNameBgColorDark;
                    }
                    if ((i & 4) != 0) {
                        str3 = tagStyle.tagNameColor;
                    }
                    if ((i & 8) != 0) {
                        str4 = tagStyle.tagNameColorDark;
                    }
                    return tagStyle.copy(str, str2, str3, str4);
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

                public final TagStyle copy(String str, String str2, String str3, String str4) {
                    return new TagStyle(str, str2, str3, str4);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof TagStyle) {
                        TagStyle tagStyle = (TagStyle) obj;
                        return Intrinsics.areEqual(this.tagNameBgColor, tagStyle.tagNameBgColor) && Intrinsics.areEqual(this.tagNameBgColorDark, tagStyle.tagNameBgColorDark) && Intrinsics.areEqual(this.tagNameColor, tagStyle.tagNameColor) && Intrinsics.areEqual(this.tagNameColorDark, tagStyle.tagNameColorDark);
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
                    return "TagStyle(tagNameBgColor=" + str + ", tagNameBgColorDark=" + str2 + ", tagNameColor=" + str3 + ", tagNameColorDark=" + this.tagNameColorDark + ")";
                }

                /* compiled from: ProductShopApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$TagStyle$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$TagStyle;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<TagStyle> serializer() {
                        return ProductShopDetailsHotItem$ItemsTag$ActThereMaterial$TagStyle$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ TagStyle(int seen0, String tagNameBgColor, String tagNameBgColorDark, String tagNameColor, String tagNameColorDark, SerializationConstructorMarker serializationConstructorMarker) {
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

                public TagStyle(String tagNameBgColor, String tagNameBgColorDark, String tagNameColor, String tagNameColorDark) {
                    this.tagNameBgColor = tagNameBgColor;
                    this.tagNameBgColorDark = tagNameBgColorDark;
                    this.tagNameColor = tagNameColor;
                    this.tagNameColorDark = tagNameColorDark;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(TagStyle self, CompositeEncoder output, SerialDescriptor serialDesc) {
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

                public /* synthetic */ TagStyle(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

        public final String getTypeAndLimitTagName() {
            return this.typeAndLimitTagName;
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$FeedBoardTag;", "", "boardJumpUrl", "", "boardName", "boardNum", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBoardJumpUrl", "()Ljava/lang/String;", "getBoardName", "getBoardNum", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class FeedBoardTag {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String boardJumpUrl;
            private final String boardName;
            private final String boardNum;

            public FeedBoardTag() {
                this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ FeedBoardTag copy$default(FeedBoardTag feedBoardTag, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = feedBoardTag.boardJumpUrl;
                }
                if ((i & 2) != 0) {
                    str2 = feedBoardTag.boardName;
                }
                if ((i & 4) != 0) {
                    str3 = feedBoardTag.boardNum;
                }
                return feedBoardTag.copy(str, str2, str3);
            }

            public final String component1() {
                return this.boardJumpUrl;
            }

            public final String component2() {
                return this.boardName;
            }

            public final String component3() {
                return this.boardNum;
            }

            public final FeedBoardTag copy(String str, String str2, String str3) {
                return new FeedBoardTag(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof FeedBoardTag) {
                    FeedBoardTag feedBoardTag = (FeedBoardTag) obj;
                    return Intrinsics.areEqual(this.boardJumpUrl, feedBoardTag.boardJumpUrl) && Intrinsics.areEqual(this.boardName, feedBoardTag.boardName) && Intrinsics.areEqual(this.boardNum, feedBoardTag.boardNum);
                }
                return false;
            }

            public int hashCode() {
                return ((((this.boardJumpUrl == null ? 0 : this.boardJumpUrl.hashCode()) * 31) + (this.boardName == null ? 0 : this.boardName.hashCode())) * 31) + (this.boardNum != null ? this.boardNum.hashCode() : 0);
            }

            public String toString() {
                String str = this.boardJumpUrl;
                String str2 = this.boardName;
                return "FeedBoardTag(boardJumpUrl=" + str + ", boardName=" + str2 + ", boardNum=" + this.boardNum + ")";
            }

            /* compiled from: ProductShopApiService.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$FeedBoardTag$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$FeedBoardTag;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<FeedBoardTag> serializer() {
                    return ProductShopDetailsHotItem$ItemsTag$FeedBoardTag$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ FeedBoardTag(int seen0, String boardJumpUrl, String boardName, String boardNum, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.boardJumpUrl = null;
                } else {
                    this.boardJumpUrl = boardJumpUrl;
                }
                if ((seen0 & 2) == 0) {
                    this.boardName = null;
                } else {
                    this.boardName = boardName;
                }
                if ((seen0 & 4) == 0) {
                    this.boardNum = null;
                } else {
                    this.boardNum = boardNum;
                }
            }

            public FeedBoardTag(String boardJumpUrl, String boardName, String boardNum) {
                this.boardJumpUrl = boardJumpUrl;
                this.boardName = boardName;
                this.boardNum = boardNum;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(FeedBoardTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.boardJumpUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.boardJumpUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.boardName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.boardName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.boardNum != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.boardNum);
                }
            }

            public /* synthetic */ FeedBoardTag(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getBoardJumpUrl() {
                return this.boardJumpUrl;
            }

            public final String getBoardName() {
                return this.boardName;
            }

            public final String getBoardNum() {
                return this.boardNum;
            }
        }

        /* compiled from: ProductShopApiService.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$GodlikeTag;", "", "price", "", "pricePrefix", "priceSymbol", "priceSymbolImg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPrice", "()Ljava/lang/String;", "getPricePrefix", "getPriceSymbol", "getPriceSymbolImg", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class GodlikeTag {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String price;
            private final String pricePrefix;
            private final String priceSymbol;
            private final String priceSymbolImg;

            public GodlikeTag() {
                this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ GodlikeTag copy$default(GodlikeTag godlikeTag, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = godlikeTag.price;
                }
                if ((i & 2) != 0) {
                    str2 = godlikeTag.pricePrefix;
                }
                if ((i & 4) != 0) {
                    str3 = godlikeTag.priceSymbol;
                }
                if ((i & 8) != 0) {
                    str4 = godlikeTag.priceSymbolImg;
                }
                return godlikeTag.copy(str, str2, str3, str4);
            }

            public final String component1() {
                return this.price;
            }

            public final String component2() {
                return this.pricePrefix;
            }

            public final String component3() {
                return this.priceSymbol;
            }

            public final String component4() {
                return this.priceSymbolImg;
            }

            public final GodlikeTag copy(String str, String str2, String str3, String str4) {
                return new GodlikeTag(str, str2, str3, str4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof GodlikeTag) {
                    GodlikeTag godlikeTag = (GodlikeTag) obj;
                    return Intrinsics.areEqual(this.price, godlikeTag.price) && Intrinsics.areEqual(this.pricePrefix, godlikeTag.pricePrefix) && Intrinsics.areEqual(this.priceSymbol, godlikeTag.priceSymbol) && Intrinsics.areEqual(this.priceSymbolImg, godlikeTag.priceSymbolImg);
                }
                return false;
            }

            public int hashCode() {
                return ((((((this.price == null ? 0 : this.price.hashCode()) * 31) + (this.pricePrefix == null ? 0 : this.pricePrefix.hashCode())) * 31) + (this.priceSymbol == null ? 0 : this.priceSymbol.hashCode())) * 31) + (this.priceSymbolImg != null ? this.priceSymbolImg.hashCode() : 0);
            }

            public String toString() {
                String str = this.price;
                String str2 = this.pricePrefix;
                String str3 = this.priceSymbol;
                return "GodlikeTag(price=" + str + ", pricePrefix=" + str2 + ", priceSymbol=" + str3 + ", priceSymbolImg=" + this.priceSymbolImg + ")";
            }

            /* compiled from: ProductShopApiService.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$GodlikeTag$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsHotItem$ItemsTag$GodlikeTag;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<GodlikeTag> serializer() {
                    return ProductShopDetailsHotItem$ItemsTag$GodlikeTag$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ GodlikeTag(int seen0, String price, String pricePrefix, String priceSymbol, String priceSymbolImg, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.price = null;
                } else {
                    this.price = price;
                }
                if ((seen0 & 2) == 0) {
                    this.pricePrefix = null;
                } else {
                    this.pricePrefix = pricePrefix;
                }
                if ((seen0 & 4) == 0) {
                    this.priceSymbol = null;
                } else {
                    this.priceSymbol = priceSymbol;
                }
                if ((seen0 & 8) == 0) {
                    this.priceSymbolImg = null;
                } else {
                    this.priceSymbolImg = priceSymbolImg;
                }
            }

            public GodlikeTag(String price, String pricePrefix, String priceSymbol, String priceSymbolImg) {
                this.price = price;
                this.pricePrefix = pricePrefix;
                this.priceSymbol = priceSymbol;
                this.priceSymbolImg = priceSymbolImg;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(GodlikeTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.price != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.price);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.pricePrefix != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.pricePrefix);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.priceSymbol != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.priceSymbol);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.priceSymbolImg != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.priceSymbolImg);
                }
            }

            public /* synthetic */ GodlikeTag(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
            }

            public final String getPrice() {
                return this.price;
            }

            public final String getPricePrefix() {
                return this.pricePrefix;
            }

            public final String getPriceSymbol() {
                return this.priceSymbol;
            }

            public final String getPriceSymbolImg() {
                return this.priceSymbolImg;
            }
        }
    }

    public final Long getWishSuccessNum() {
        return this.wishSuccessNum;
    }
}