package kntr.app.mall.product.details.page.api;

import ComposableSingletons$CustomBottomSheetKt$;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kntr.app.mall.product.details.page.api.WishApiService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: WishApiService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u000e\bÁ\u0002\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0080@¢\u0006\u0004\b\u000b\u0010\fJ`\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\u0016\u0010\u0017Jl\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0080@¢\u0006\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkntr/app/mall/product/details/page/api/WishApiService;", "", "<init>", "()V", "K_LOG_TAG", "", "getWish", "Lkntr/app/mall/product/details/page/api/WishApiService$WishResponse;", "itemsId", "", AppKey.VERSION, "getWish$product_details_page_debug", "(ILjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setWish", "", "shopId", "wishType", "", "track_id", "from", "msource", "is_ad", "setWish$product_details_page_debug", "(JLjava/lang/Integer;Ljava/lang/Integer;BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mallKntrSetWish", "subjectType", "mallKntrSetWish$product_details_page_debug", "(JLjava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "WishData", "WishResponse", "WishSetRequest", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WishApiService {
    public static final int $stable = 0;
    public static final WishApiService INSTANCE = new WishApiService();
    private static final String K_LOG_TAG = "NA_WR_WishApiService";

    private WishApiService() {
    }

    /* compiled from: WishApiService.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0003,-.BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fBO\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/WishApiService$WishData;", "", "count", "", "hasLiked", "", "userVOS", "", "Lkntr/app/mall/product/details/page/api/WishApiService$WishData$UserVO;", "users", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasLiked", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserVOS", "()Ljava/util/List;", "getUsers", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/WishApiService$WishData;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "UserVO", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class WishData {
        private final Integer count;
        private final Boolean hasLiked;
        private final List<UserVO> userVOS;
        private final List<String> users;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.WishApiService$WishData$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = WishApiService.WishData._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.WishApiService$WishData$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = WishApiService.WishData._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        })};

        public WishData() {
            this((Integer) null, (Boolean) null, (List) null, (List) null, 15, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WishData copy$default(WishData wishData, Integer num, Boolean bool, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = wishData.count;
            }
            if ((i & 2) != 0) {
                bool = wishData.hasLiked;
            }
            if ((i & 4) != 0) {
                list = wishData.userVOS;
            }
            if ((i & 8) != 0) {
                list2 = wishData.users;
            }
            return wishData.copy(num, bool, list, list2);
        }

        public final Integer component1() {
            return this.count;
        }

        public final Boolean component2() {
            return this.hasLiked;
        }

        public final List<UserVO> component3() {
            return this.userVOS;
        }

        public final List<String> component4() {
            return this.users;
        }

        public final WishData copy(Integer num, Boolean bool, List<UserVO> list, List<String> list2) {
            return new WishData(num, bool, list, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WishData) {
                WishData wishData = (WishData) obj;
                return Intrinsics.areEqual(this.count, wishData.count) && Intrinsics.areEqual(this.hasLiked, wishData.hasLiked) && Intrinsics.areEqual(this.userVOS, wishData.userVOS) && Intrinsics.areEqual(this.users, wishData.users);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.count == null ? 0 : this.count.hashCode()) * 31) + (this.hasLiked == null ? 0 : this.hasLiked.hashCode())) * 31) + (this.userVOS == null ? 0 : this.userVOS.hashCode())) * 31) + (this.users != null ? this.users.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.count;
            Boolean bool = this.hasLiked;
            List<UserVO> list = this.userVOS;
            return "WishData(count=" + num + ", hasLiked=" + bool + ", userVOS=" + list + ", users=" + this.users + ")";
        }

        /* compiled from: WishApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/WishApiService$WishData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/WishApiService$WishData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<WishData> serializer() {
                return WishApiService$WishData$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ WishData(int seen0, Integer count, Boolean hasLiked, List userVOS, List users, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.count = null;
            } else {
                this.count = count;
            }
            if ((seen0 & 2) == 0) {
                this.hasLiked = null;
            } else {
                this.hasLiked = hasLiked;
            }
            if ((seen0 & 4) == 0) {
                this.userVOS = null;
            } else {
                this.userVOS = userVOS;
            }
            if ((seen0 & 8) == 0) {
                this.users = null;
            } else {
                this.users = users;
            }
        }

        public WishData(Integer count, Boolean hasLiked, List<UserVO> list, List<String> list2) {
            this.count = count;
            this.hasLiked = hasLiked;
            this.userVOS = list;
            this.users = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(WishApiService$WishData$UserVO$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(WishData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.count != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.count);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasLiked != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.hasLiked);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.userVOS != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.userVOS);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.users != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.users);
            }
        }

        public /* synthetic */ WishData(Integer num, Boolean bool, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2);
        }

        public final Integer getCount() {
            return this.count;
        }

        public final Boolean getHasLiked() {
            return this.hasLiked;
        }

        public final List<UserVO> getUserVOS() {
            return this.userVOS;
        }

        /* compiled from: WishApiService.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/WishApiService$WishData$UserVO;", "", "mid", "", "uname", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMid", "()Ljava/lang/String;", "getUname", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class UserVO {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String mid;
            private final String uname;

            public UserVO() {
                this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ UserVO copy$default(UserVO userVO, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = userVO.mid;
                }
                if ((i & 2) != 0) {
                    str2 = userVO.uname;
                }
                return userVO.copy(str, str2);
            }

            public final String component1() {
                return this.mid;
            }

            public final String component2() {
                return this.uname;
            }

            public final UserVO copy(String str, String str2) {
                return new UserVO(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof UserVO) {
                    UserVO userVO = (UserVO) obj;
                    return Intrinsics.areEqual(this.mid, userVO.mid) && Intrinsics.areEqual(this.uname, userVO.uname);
                }
                return false;
            }

            public int hashCode() {
                return ((this.mid == null ? 0 : this.mid.hashCode()) * 31) + (this.uname != null ? this.uname.hashCode() : 0);
            }

            public String toString() {
                String str = this.mid;
                return "UserVO(mid=" + str + ", uname=" + this.uname + ")";
            }

            /* compiled from: WishApiService.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/WishApiService$WishData$UserVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/WishApiService$WishData$UserVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<UserVO> serializer() {
                    return WishApiService$WishData$UserVO$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ UserVO(int seen0, String mid, String uname, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.mid = null;
                } else {
                    this.mid = mid;
                }
                if ((seen0 & 2) == 0) {
                    this.uname = null;
                } else {
                    this.uname = uname;
                }
            }

            public UserVO(String mid, String uname) {
                this.mid = mid;
                this.uname = uname;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(UserVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.mid != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.mid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.uname != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.uname);
                }
            }

            public /* synthetic */ UserVO(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            public final String getMid() {
                return this.mid;
            }

            public final String getUname() {
                return this.uname;
            }
        }

        public final List<String> getUsers() {
            return this.users;
        }
    }

    /* compiled from: WishApiService.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lkntr/app/mall/product/details/page/api/WishApiService$WishResponse;", "", "code", "", "message", "", "errtag", "data", "Lkntr/app/mall/product/details/page/api/WishApiService$WishData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/WishApiService$WishData;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/WishApiService$WishData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getErrtag", "getData", "()Lkntr/app/mall/product/details/page/api/WishApiService$WishData;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/WishApiService$WishData;)Lkntr/app/mall/product/details/page/api/WishApiService$WishResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class WishResponse {
        private final Integer code;
        private final WishData data;
        private final String errtag;
        private final String message;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public WishResponse() {
            this((Integer) null, (String) null, (String) null, (WishData) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ WishResponse copy$default(WishResponse wishResponse, Integer num, String str, String str2, WishData wishData, int i, Object obj) {
            if ((i & 1) != 0) {
                num = wishResponse.code;
            }
            if ((i & 2) != 0) {
                str = wishResponse.message;
            }
            if ((i & 4) != 0) {
                str2 = wishResponse.errtag;
            }
            if ((i & 8) != 0) {
                wishData = wishResponse.data;
            }
            return wishResponse.copy(num, str, str2, wishData);
        }

        public final Integer component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final String component3() {
            return this.errtag;
        }

        public final WishData component4() {
            return this.data;
        }

        public final WishResponse copy(Integer num, String str, String str2, WishData wishData) {
            return new WishResponse(num, str, str2, wishData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WishResponse) {
                WishResponse wishResponse = (WishResponse) obj;
                return Intrinsics.areEqual(this.code, wishResponse.code) && Intrinsics.areEqual(this.message, wishResponse.message) && Intrinsics.areEqual(this.errtag, wishResponse.errtag) && Intrinsics.areEqual(this.data, wishResponse.data);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.errtag == null ? 0 : this.errtag.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.code;
            String str = this.message;
            String str2 = this.errtag;
            return "WishResponse(code=" + num + ", message=" + str + ", errtag=" + str2 + ", data=" + this.data + ")";
        }

        /* compiled from: WishApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/WishApiService$WishResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/WishApiService$WishResponse;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<WishResponse> serializer() {
                return new GeneratedSerializer<WishResponse>() { // from class: kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.WishApiService.WishResponse", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.WishApiService$WishResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.WishApiService$WishResponse> A[REMOVE]) =  kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer)
                             in method: kntr.app.mall.product.details.page.api.WishApiService.WishResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.WishApiService$WishResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                              ("kntr.app.mall.product.details.page.api.WishApiService.WishResponse")
                              (wrap: kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer.INSTANCE kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer
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
                            kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer r0 = kntr.app.mall.product.details.page.api.WishApiService$WishResponse$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.WishApiService.WishResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ WishResponse(int seen0, Integer code, String message, String errtag, WishData data, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.code = 0;
                    } else {
                        this.code = code;
                    }
                    if ((seen0 & 2) == 0) {
                        this.message = "";
                    } else {
                        this.message = message;
                    }
                    if ((seen0 & 4) == 0) {
                        this.errtag = null;
                    } else {
                        this.errtag = errtag;
                    }
                    if ((seen0 & 8) == 0) {
                        this.data = null;
                    } else {
                        this.data = data;
                    }
                }

                public WishResponse(Integer code, String message, String errtag, WishData data) {
                    this.code = code;
                    this.message = message;
                    this.errtag = errtag;
                    this.data = data;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(WishResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Integer num;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || (num = self.code) == null || num.intValue() != 0) {
                        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.code);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.message, "")) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.message);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.errtag != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.errtag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.data != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, WishApiService$WishData$$serializer.INSTANCE, self.data);
                    }
                }

                public /* synthetic */ WishResponse(Integer num, String str, String str2, WishData wishData, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : wishData);
                }

                public final Integer getCode() {
                    return this.code;
                }

                public final String getMessage() {
                    return this.message;
                }

                public final String getErrtag() {
                    return this.errtag;
                }

                public final WishData getData() {
                    return this.data;
                }
            }

            public static /* synthetic */ Object getWish$product_details_page_debug$default(WishApiService wishApiService, int i, Integer num, Continuation continuation, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    num = null;
                }
                return wishApiService.getWish$product_details_page_debug(i, num, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x011b A[Catch: Exception -> 0x0085, TryCatch #3 {Exception -> 0x0085, blocks: (B:44:0x0179, B:46:0x017d, B:47:0x0185, B:18:0x007d, B:28:0x0108, B:30:0x011b, B:32:0x012f, B:39:0x0149), top: B:61:0x007d }] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x012f A[Catch: Exception -> 0x0085, TRY_LEAVE, TryCatch #3 {Exception -> 0x0085, blocks: (B:44:0x0179, B:46:0x017d, B:47:0x0185, B:18:0x007d, B:28:0x0108, B:30:0x011b, B:32:0x012f, B:39:0x0149), top: B:61:0x007d }] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0179 A[Catch: Exception -> 0x0085, TryCatch #3 {Exception -> 0x0085, blocks: (B:44:0x0179, B:46:0x017d, B:47:0x0185, B:18:0x007d, B:28:0x0108, B:30:0x011b, B:32:0x012f, B:39:0x0149), top: B:61:0x007d }] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x017d A[Catch: Exception -> 0x0085, TryCatch #3 {Exception -> 0x0085, blocks: (B:44:0x0179, B:46:0x017d, B:47:0x0185, B:18:0x007d, B:28:0x0108, B:30:0x011b, B:32:0x012f, B:39:0x0149), top: B:61:0x007d }] */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0196  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object getWish$product_details_page_debug(int itemsId, final Integer version, Continuation<? super WishResponse> continuation) {
                WishApiService$getWish$1 wishApiService$getWish$1;
                WishApiService$getWish$1 wishApiService$getWish$12;
                Object execute;
                Integer version2;
                HttpResponse response;
                KType kType;
                Object bodyNullable;
                String message;
                final int itemsId2 = itemsId;
                if (continuation instanceof WishApiService$getWish$1) {
                    wishApiService$getWish$1 = (WishApiService$getWish$1) continuation;
                    if ((wishApiService$getWish$1.label & Integer.MIN_VALUE) != 0) {
                        wishApiService$getWish$1.label -= Integer.MIN_VALUE;
                        wishApiService$getWish$12 = wishApiService$getWish$1;
                        Object $result = wishApiService$getWish$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (wishApiService$getWish$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                try {
                                    HttpClient $this$get$iv = Client.INSTANCE.getHttpClient();
                                    HttpRequestBuilder $this$get_u24lambda_u244$iv = new HttpRequestBuilder();
                                    HttpRequestKt.url($this$get_u24lambda_u244$iv, "https://mall.bilibili.com/mall-c/items/wish");
                                    ParametersKt.parameters(new Function1() { // from class: kntr.app.mall.product.details.page.api.WishApiService$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj) {
                                            Unit wish$lambda$0$0;
                                            wish$lambda$0$0 = WishApiService.getWish$lambda$0$0(itemsId2, version, (ParametersBuilder) obj);
                                            return wish$lambda$0$0;
                                        }
                                    });
                                    $this$get_u24lambda_u244$iv.setMethod(HttpMethod.Companion.getGet());
                                    HttpStatement httpStatement = new HttpStatement($this$get_u24lambda_u244$iv, $this$get$iv);
                                    wishApiService$getWish$12.L$0 = SpillingKt.nullOutSpilledVariable(version);
                                    wishApiService$getWish$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                    wishApiService$getWish$12.L$2 = SpillingKt.nullOutSpilledVariable("https://mall.bilibili.com/mall-c/items/wish");
                                    wishApiService$getWish$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                    wishApiService$getWish$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                    wishApiService$getWish$12.L$5 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u244$iv);
                                    wishApiService$getWish$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                    wishApiService$getWish$12.I$0 = itemsId2;
                                    wishApiService$getWish$12.I$1 = 0;
                                    wishApiService$getWish$12.I$2 = 0;
                                    wishApiService$getWish$12.I$3 = 0;
                                    wishApiService$getWish$12.I$4 = 0;
                                    wishApiService$getWish$12.label = 1;
                                    execute = httpStatement.execute(wishApiService$getWish$12);
                                    if (execute == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    version2 = version;
                                    response = (HttpResponse) execute;
                                    if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                        return new WishResponse(Boxing.boxInt(-1), "Network error", "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                    }
                                    HttpClientCall call = response.getCall();
                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WishResponse.class);
                                    try {
                                        kType = Reflection.typeOf(WishResponse.class);
                                    } catch (Throwable th) {
                                        kType = null;
                                    }
                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                    wishApiService$getWish$12.L$0 = SpillingKt.nullOutSpilledVariable(version2);
                                    wishApiService$getWish$12.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                    wishApiService$getWish$12.L$2 = SpillingKt.nullOutSpilledVariable(response);
                                    wishApiService$getWish$12.L$3 = null;
                                    wishApiService$getWish$12.L$4 = null;
                                    wishApiService$getWish$12.L$5 = null;
                                    wishApiService$getWish$12.L$6 = null;
                                    wishApiService$getWish$12.I$0 = itemsId2;
                                    wishApiService$getWish$12.I$1 = 0;
                                    wishApiService$getWish$12.label = 2;
                                    bodyNullable = call.bodyNullable(typeInfo, wishApiService$getWish$12);
                                    if (bodyNullable == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    if (bodyNullable == null) {
                                        WishResponse rtValue = (WishResponse) bodyNullable;
                                        return rtValue;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.WishApiService.WishResponse");
                                } catch (Exception e) {
                                    e = e;
                                    Integer boxInt = Boxing.boxInt(-1);
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    return new WishResponse(boxInt, message, "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                }
                            case 1:
                                int i = wishApiService$getWish$12.I$4;
                                int i2 = wishApiService$getWish$12.I$3;
                                int i3 = wishApiService$getWish$12.I$2;
                                int i4 = wishApiService$getWish$12.I$1;
                                itemsId2 = wishApiService$getWish$12.I$0;
                                HttpClient httpClient = (HttpClient) wishApiService$getWish$12.L$6;
                                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) wishApiService$getWish$12.L$5;
                                HttpClient httpClient2 = (HttpClient) wishApiService$getWish$12.L$4;
                                HttpClient httpClient3 = (HttpClient) wishApiService$getWish$12.L$3;
                                String str = (String) wishApiService$getWish$12.L$2;
                                HttpClient httpClient4 = (HttpClient) wishApiService$getWish$12.L$1;
                                version2 = (Integer) wishApiService$getWish$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    execute = $result;
                                    response = (HttpResponse) execute;
                                    if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    Integer boxInt2 = Boxing.boxInt(-1);
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    return new WishResponse(boxInt2, message, "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                }
                                break;
                            case 2:
                                int i5 = wishApiService$getWish$12.I$1;
                                int i6 = wishApiService$getWish$12.I$0;
                                HttpResponse httpResponse = (HttpResponse) wishApiService$getWish$12.L$2;
                                HttpResponse httpResponse2 = (HttpResponse) wishApiService$getWish$12.L$1;
                                Integer num = (Integer) wishApiService$getWish$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    bodyNullable = $result;
                                    if (bodyNullable == null) {
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    Integer boxInt22 = Boxing.boxInt(-1);
                                    message = e.getMessage();
                                    if (message == null) {
                                        message = "Unknown error";
                                    }
                                    return new WishResponse(boxInt22, message, "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                }
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                wishApiService$getWish$1 = new WishApiService$getWish$1(this, continuation);
                wishApiService$getWish$12 = wishApiService$getWish$1;
                Object $result2 = wishApiService$getWish$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (wishApiService$getWish$12.label) {
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit getWish$lambda$0$0(int $itemsId, Integer $version, ParametersBuilder $this$parameters) {
                Intrinsics.checkNotNullParameter($this$parameters, "$this$parameters");
                $this$parameters.append("itemsId", String.valueOf($itemsId));
                if ($version != null) {
                    int it = $version.intValue();
                    $this$parameters.append(AppKey.VERSION, String.valueOf(it));
                }
                return Unit.INSTANCE;
            }

            /* compiled from: WishApiService.kt */
            @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fBg\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003Jj\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\nHÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001d¨\u00069"}, d2 = {"Lkntr/app/mall/product/details/page/api/WishApiService$WishSetRequest;", "", "itemsId", "", "shopId", "", "wishType", "", AppKey.VERSION, "trackId", "", "from", "msource", "isAd", "<init>", "(JLjava/lang/Integer;BLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/Integer;BLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItemsId", "()J", "getShopId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWishType", "()B", "getVersion", "getTrackId", "()Ljava/lang/String;", "getFrom", "getMsource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/Integer;BLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/WishApiService$WishSetRequest;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class WishSetRequest {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String from;
                private final String isAd;
                private final long itemsId;
                private final String msource;
                private final Integer shopId;
                private final String trackId;
                private final Integer version;
                private final byte wishType;

                public final long component1() {
                    return this.itemsId;
                }

                public final Integer component2() {
                    return this.shopId;
                }

                public final byte component3() {
                    return this.wishType;
                }

                public final Integer component4() {
                    return this.version;
                }

                public final String component5() {
                    return this.trackId;
                }

                public final String component6() {
                    return this.from;
                }

                public final String component7() {
                    return this.msource;
                }

                public final String component8() {
                    return this.isAd;
                }

                public final WishSetRequest copy(long j, Integer num, byte b, Integer num2, String str, String str2, String str3, String str4) {
                    return new WishSetRequest(j, num, b, num2, str, str2, str3, str4);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof WishSetRequest) {
                        WishSetRequest wishSetRequest = (WishSetRequest) obj;
                        return this.itemsId == wishSetRequest.itemsId && Intrinsics.areEqual(this.shopId, wishSetRequest.shopId) && this.wishType == wishSetRequest.wishType && Intrinsics.areEqual(this.version, wishSetRequest.version) && Intrinsics.areEqual(this.trackId, wishSetRequest.trackId) && Intrinsics.areEqual(this.from, wishSetRequest.from) && Intrinsics.areEqual(this.msource, wishSetRequest.msource) && Intrinsics.areEqual(this.isAd, wishSetRequest.isAd);
                    }
                    return false;
                }

                public int hashCode() {
                    return (((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.itemsId) * 31) + (this.shopId == null ? 0 : this.shopId.hashCode())) * 31) + this.wishType) * 31) + (this.version == null ? 0 : this.version.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.from == null ? 0 : this.from.hashCode())) * 31) + (this.msource == null ? 0 : this.msource.hashCode())) * 31) + (this.isAd != null ? this.isAd.hashCode() : 0);
                }

                public String toString() {
                    long j = this.itemsId;
                    Integer num = this.shopId;
                    byte b = this.wishType;
                    Integer num2 = this.version;
                    String str = this.trackId;
                    String str2 = this.from;
                    String str3 = this.msource;
                    return "WishSetRequest(itemsId=" + j + ", shopId=" + num + ", wishType=" + ((int) b) + ", version=" + num2 + ", trackId=" + str + ", from=" + str2 + ", msource=" + str3 + ", isAd=" + this.isAd + ")";
                }

                /* compiled from: WishApiService.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/WishApiService$WishSetRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/WishApiService$WishSetRequest;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<WishSetRequest> serializer() {
                        return WishApiService$WishSetRequest$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ WishSetRequest(int seen0, long itemsId, Integer shopId, byte wishType, Integer version, String trackId, String from, String msource, String isAd, SerializationConstructorMarker serializationConstructorMarker) {
                    if (5 != (seen0 & 5)) {
                        PluginExceptionsKt.throwMissingFieldException(seen0, 5, WishApiService$WishSetRequest$$serializer.INSTANCE.getDescriptor());
                    }
                    this.itemsId = itemsId;
                    if ((seen0 & 2) == 0) {
                        this.shopId = null;
                    } else {
                        this.shopId = shopId;
                    }
                    this.wishType = wishType;
                    if ((seen0 & 8) == 0) {
                        this.version = null;
                    } else {
                        this.version = version;
                    }
                    if ((seen0 & 16) == 0) {
                        this.trackId = "";
                    } else {
                        this.trackId = trackId;
                    }
                    if ((seen0 & 32) == 0) {
                        this.from = "";
                    } else {
                        this.from = from;
                    }
                    if ((seen0 & 64) == 0) {
                        this.msource = "";
                    } else {
                        this.msource = msource;
                    }
                    if ((seen0 & 128) == 0) {
                        this.isAd = "";
                    } else {
                        this.isAd = isAd;
                    }
                }

                public WishSetRequest(long itemsId, Integer shopId, byte wishType, Integer version, String trackId, String from, String msource, String isAd) {
                    this.itemsId = itemsId;
                    this.shopId = shopId;
                    this.wishType = wishType;
                    this.version = version;
                    this.trackId = trackId;
                    this.from = from;
                    this.msource = msource;
                    this.isAd = isAd;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(WishSetRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    output.encodeLongElement(serialDesc, 0, self.itemsId);
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.shopId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.shopId);
                    }
                    output.encodeByteElement(serialDesc, 2, self.wishType);
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.version != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.version);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.trackId, "")) {
                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.trackId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.from, "")) {
                        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.from);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.msource, "")) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.msource);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.isAd, "")) {
                        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.isAd);
                    }
                }

                public /* synthetic */ WishSetRequest(long j, Integer num, byte b, Integer num2, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this(j, (i & 2) != 0 ? null : num, b, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? "" : str2, (i & 64) != 0 ? "" : str3, (i & 128) != 0 ? "" : str4);
                }

                public final long getItemsId() {
                    return this.itemsId;
                }

                public final Integer getShopId() {
                    return this.shopId;
                }

                public final byte getWishType() {
                    return this.wishType;
                }

                public final Integer getVersion() {
                    return this.version;
                }

                public final String getTrackId() {
                    return this.trackId;
                }

                public final String getFrom() {
                    return this.from;
                }

                public final String getMsource() {
                    return this.msource;
                }

                public final String isAd() {
                    return this.isAd;
                }
            }

            public static /* synthetic */ Object setWish$product_details_page_debug$default(WishApiService wishApiService, long j, Integer num, Integer num2, byte b, String str, String str2, String str3, String str4, Continuation continuation, int i, Object obj) {
                Integer num3;
                Integer num4;
                if ((i & 2) == 0) {
                    num3 = num;
                } else {
                    num3 = null;
                }
                if ((i & 4) == 0) {
                    num4 = num2;
                } else {
                    num4 = null;
                }
                return wishApiService.setWish$product_details_page_debug(j, num3, num4, b, str, str2, str3, str4, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00ed  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x021c A[Catch: Exception -> 0x02bc, TryCatch #8 {Exception -> 0x02bc, blocks: (B:46:0x0209, B:48:0x021c, B:50:0x023d, B:57:0x0256), top: B:98:0x0209 }] */
            /* JADX WARN: Removed duplicated region for block: B:50:0x023d A[Catch: Exception -> 0x02bc, TRY_LEAVE, TryCatch #8 {Exception -> 0x02bc, blocks: (B:46:0x0209, B:48:0x021c, B:50:0x023d, B:57:0x0256), top: B:98:0x0209 }] */
            /* JADX WARN: Removed duplicated region for block: B:62:0x02aa A[Catch: Exception -> 0x02ae, TRY_ENTER, TryCatch #5 {Exception -> 0x02ae, blocks: (B:62:0x02aa, B:66:0x02b3, B:67:0x02bb), top: B:93:0x02a8 }] */
            /* JADX WARN: Removed duplicated region for block: B:66:0x02b3 A[Catch: Exception -> 0x02ae, TryCatch #5 {Exception -> 0x02ae, blocks: (B:62:0x02aa, B:66:0x02b3, B:67:0x02bb), top: B:93:0x02a8 }] */
            /* JADX WARN: Removed duplicated region for block: B:80:0x02ee  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object setWish$product_details_page_debug(long itemsId, Integer shopId, Integer version, byte wishType, String track_id, String from, String msource, String is_ad, Continuation<? super WishResponse> continuation) {
                WishApiService$setWish$1 wishApiService$setWish$1;
                WishApiService$setWish$1 wishApiService$setWish$12;
                KType kType;
                HttpStatement httpStatement;
                long itemsId2;
                Integer shopId2;
                Integer version2;
                String track_id2;
                String from2;
                String msource2;
                Object obj;
                String is_ad2;
                HttpResponse response;
                KType kType2;
                Object bodyNullable;
                String is_ad3;
                String msource3;
                String message;
                byte wishType2 = wishType;
                if (continuation instanceof WishApiService$setWish$1) {
                    wishApiService$setWish$1 = (WishApiService$setWish$1) continuation;
                    if ((wishApiService$setWish$1.label & Integer.MIN_VALUE) != 0) {
                        wishApiService$setWish$1.label -= Integer.MIN_VALUE;
                        wishApiService$setWish$12 = wishApiService$setWish$1;
                        Object $result = wishApiService$setWish$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (wishApiService$setWish$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                try {
                                    HttpClient $this$post$iv = Client.INSTANCE.getHttpClient();
                                    HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                                    HttpRequestKt.url(httpRequestBuilder, "https://mall.bilibili.com/mall-c/items/wish/set");
                                    HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                                    Object body$iv = new WishSetRequest(itemsId, shopId, wishType2, version, track_id, from, msource, is_ad);
                                    try {
                                        if (body$iv instanceof OutgoingContent) {
                                            try {
                                                httpRequestBuilder.setBody(body$iv);
                                                httpRequestBuilder.setBodyType((TypeInfo) null);
                                            } catch (Exception e) {
                                                e = e;
                                                Integer boxInt = Boxing.boxInt(-1);
                                                message = e.getMessage();
                                                if (message == null) {
                                                    message = "Unknown error";
                                                }
                                                return new WishResponse(boxInt, message, "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                            }
                                        } else {
                                            httpRequestBuilder.setBody(body$iv);
                                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WishSetRequest.class);
                                            try {
                                                kType = Reflection.typeOf(WishSetRequest.class);
                                            } catch (Throwable th) {
                                                kType = null;
                                            }
                                            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                        }
                                        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                        httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                        wishApiService$setWish$12.L$0 = SpillingKt.nullOutSpilledVariable(shopId);
                                        wishApiService$setWish$12.L$1 = SpillingKt.nullOutSpilledVariable(version);
                                        wishApiService$setWish$12.L$2 = SpillingKt.nullOutSpilledVariable(track_id);
                                        wishApiService$setWish$12.L$3 = SpillingKt.nullOutSpilledVariable(from);
                                        wishApiService$setWish$12.L$4 = SpillingKt.nullOutSpilledVariable(msource);
                                        wishApiService$setWish$12.L$5 = SpillingKt.nullOutSpilledVariable(is_ad);
                                        wishApiService$setWish$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        wishApiService$setWish$12.L$7 = SpillingKt.nullOutSpilledVariable("https://mall.bilibili.com/mall-c/items/wish/set");
                                        wishApiService$setWish$12.L$8 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        wishApiService$setWish$12.L$9 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        wishApiService$setWish$12.L$10 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                        wishApiService$setWish$12.L$11 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                        itemsId2 = itemsId;
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                }
                                try {
                                    wishApiService$setWish$12.J$0 = itemsId2;
                                    wishApiService$setWish$12.B$0 = wishType2;
                                    wishApiService$setWish$12.I$0 = 0;
                                    wishApiService$setWish$12.I$1 = 0;
                                    wishApiService$setWish$12.I$2 = 0;
                                    wishApiService$setWish$12.I$3 = 0;
                                    wishApiService$setWish$12.label = 1;
                                    Object execute = httpStatement.execute(wishApiService$setWish$12);
                                    if (execute == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    shopId2 = shopId;
                                    version2 = version;
                                    track_id2 = track_id;
                                    from2 = from;
                                    msource2 = msource;
                                    obj = execute;
                                    is_ad2 = is_ad;
                                    try {
                                        response = (HttpResponse) obj;
                                        if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                            return new WishResponse(Boxing.boxInt(-1), "Network error", "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                        }
                                        HttpClientCall call = response.getCall();
                                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(WishResponse.class);
                                        try {
                                            kType2 = Reflection.typeOf(WishResponse.class);
                                        } catch (Throwable th2) {
                                            kType2 = null;
                                        }
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass2, kType2);
                                        wishApiService$setWish$12.L$0 = SpillingKt.nullOutSpilledVariable(shopId2);
                                        wishApiService$setWish$12.L$1 = SpillingKt.nullOutSpilledVariable(version2);
                                        wishApiService$setWish$12.L$2 = SpillingKt.nullOutSpilledVariable(track_id2);
                                        wishApiService$setWish$12.L$3 = SpillingKt.nullOutSpilledVariable(from2);
                                        wishApiService$setWish$12.L$4 = SpillingKt.nullOutSpilledVariable(msource2);
                                        wishApiService$setWish$12.L$5 = SpillingKt.nullOutSpilledVariable(is_ad2);
                                        wishApiService$setWish$12.L$6 = SpillingKt.nullOutSpilledVariable(response);
                                        wishApiService$setWish$12.L$7 = SpillingKt.nullOutSpilledVariable(response);
                                        wishApiService$setWish$12.L$8 = null;
                                        wishApiService$setWish$12.L$9 = null;
                                        wishApiService$setWish$12.L$10 = null;
                                        wishApiService$setWish$12.L$11 = null;
                                        wishApiService$setWish$12.J$0 = itemsId2;
                                        wishApiService$setWish$12.B$0 = wishType2;
                                        wishApiService$setWish$12.I$0 = 0;
                                        wishApiService$setWish$12.label = 2;
                                        bodyNullable = call.bodyNullable(typeInfo, wishApiService$setWish$12);
                                        if (bodyNullable == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        is_ad3 = is_ad2;
                                        msource3 = msource2;
                                        try {
                                            if (bodyNullable == null) {
                                                WishResponse rtValue = (WishResponse) bodyNullable;
                                                return rtValue;
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type kntr.app.mall.product.details.page.api.WishApiService.WishResponse");
                                        } catch (Exception e4) {
                                            e = e4;
                                            Integer boxInt2 = Boxing.boxInt(-1);
                                            message = e.getMessage();
                                            if (message == null) {
                                            }
                                            return new WishResponse(boxInt2, message, "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        Integer boxInt22 = Boxing.boxInt(-1);
                                        message = e.getMessage();
                                        if (message == null) {
                                        }
                                        return new WishResponse(boxInt22, message, "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    Integer boxInt222 = Boxing.boxInt(-1);
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    return new WishResponse(boxInt222, message, "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                }
                            case 1:
                                int i = wishApiService$setWish$12.I$3;
                                int i2 = wishApiService$setWish$12.I$2;
                                int i3 = wishApiService$setWish$12.I$1;
                                int i4 = wishApiService$setWish$12.I$0;
                                wishType2 = wishApiService$setWish$12.B$0;
                                long itemsId3 = wishApiService$setWish$12.J$0;
                                HttpClient httpClient = (HttpClient) wishApiService$setWish$12.L$11;
                                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) wishApiService$setWish$12.L$10;
                                HttpClient httpClient2 = (HttpClient) wishApiService$setWish$12.L$9;
                                HttpClient httpClient3 = (HttpClient) wishApiService$setWish$12.L$8;
                                String str = (String) wishApiService$setWish$12.L$7;
                                HttpClient httpClient4 = (HttpClient) wishApiService$setWish$12.L$6;
                                String is_ad4 = (String) wishApiService$setWish$12.L$5;
                                msource2 = (String) wishApiService$setWish$12.L$4;
                                from2 = (String) wishApiService$setWish$12.L$3;
                                track_id2 = (String) wishApiService$setWish$12.L$2;
                                version2 = (Integer) wishApiService$setWish$12.L$1;
                                shopId2 = (Integer) wishApiService$setWish$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    obj = $result;
                                    is_ad2 = is_ad4;
                                    itemsId2 = itemsId3;
                                    response = (HttpResponse) obj;
                                    if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getOK())) {
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    Integer boxInt2222 = Boxing.boxInt(-1);
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    return new WishResponse(boxInt2222, message, "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                }
                                break;
                            case 2:
                                int i5 = wishApiService$setWish$12.I$0;
                                byte b = wishApiService$setWish$12.B$0;
                                long j = wishApiService$setWish$12.J$0;
                                HttpResponse httpResponse = (HttpResponse) wishApiService$setWish$12.L$7;
                                HttpResponse httpResponse2 = (HttpResponse) wishApiService$setWish$12.L$6;
                                is_ad3 = (String) wishApiService$setWish$12.L$5;
                                msource3 = (String) wishApiService$setWish$12.L$4;
                                String str2 = (String) wishApiService$setWish$12.L$3;
                                String str3 = (String) wishApiService$setWish$12.L$2;
                                Integer num = (Integer) wishApiService$setWish$12.L$1;
                                Integer num2 = (Integer) wishApiService$setWish$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    bodyNullable = $result;
                                    if (bodyNullable == null) {
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    Integer boxInt22222 = Boxing.boxInt(-1);
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    return new WishResponse(boxInt22222, message, "error", (WishData) null, 8, (DefaultConstructorMarker) null);
                                }
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                wishApiService$setWish$1 = new WishApiService$setWish$1(this, continuation);
                wishApiService$setWish$12 = wishApiService$setWish$1;
                Object $result2 = wishApiService$setWish$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (wishApiService$setWish$12.label) {
                }
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:68:0x0273
                	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                */
            public final java.lang.Object mallKntrSetWish$product_details_page_debug(long r26, java.lang.Integer r28, java.lang.Byte r29, java.lang.Integer r30, byte r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, kotlin.coroutines.Continuation<? super kntr.app.mall.product.details.page.api.WishApiService.WishResponse> r36) {
                /*
                    Method dump skipped, instructions count: 740
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.WishApiService.mallKntrSetWish$product_details_page_debug(long, java.lang.Integer, java.lang.Byte, java.lang.Integer, byte, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }