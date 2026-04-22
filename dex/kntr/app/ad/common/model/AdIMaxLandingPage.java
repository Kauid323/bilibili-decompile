package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.ad.common.model.AdIMaxLandingPage;
import kntr.app.game.base.router.RouterHelperKt;
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

/* compiled from: AdIMaxLandingPage.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 22\u00020\u0001:\u0005./012BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBQ\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003JG\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000eHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b¨\u00063"}, d2 = {"Lkntr/app/ad/common/model/AdIMaxLandingPage;", RoomRecommendViewModel.EMPTY_CURSOR, "templateStyle", RoomRecommendViewModel.EMPTY_CURSOR, "showUrls", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "configs", "Lkntr/app/ad/common/model/AdIMaxLandingPage$ConfigBean;", "like", "Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxLike;", "<init>", "(JLjava/util/List;Ljava/util/List;Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxLike;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/util/List;Ljava/util/List;Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxLike;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTemplateStyle", "()J", "getShowUrls", "()Ljava/util/List;", "getConfigs$annotations", "()V", "getConfigs", "getLike$annotations", "getLike", "()Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxLike;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "ConfigBean", "IMaxLike", "IMaxTag", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdIMaxLandingPage {
    private final List<ConfigBean> configs;
    private final IMaxLike like;
    private final List<String> showUrls;
    private final long templateStyle;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdIMaxLandingPage$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdIMaxLandingPage._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdIMaxLandingPage$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = AdIMaxLandingPage._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null};

    public AdIMaxLandingPage() {
        this(0L, (List) null, (List) null, (IMaxLike) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdIMaxLandingPage copy$default(AdIMaxLandingPage adIMaxLandingPage, long j2, List list, List list2, IMaxLike iMaxLike, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = adIMaxLandingPage.templateStyle;
        }
        long j3 = j2;
        List<String> list3 = list;
        if ((i & 2) != 0) {
            list3 = adIMaxLandingPage.showUrls;
        }
        List list4 = list3;
        List<ConfigBean> list5 = list2;
        if ((i & 4) != 0) {
            list5 = adIMaxLandingPage.configs;
        }
        List list6 = list5;
        if ((i & 8) != 0) {
            iMaxLike = adIMaxLandingPage.like;
        }
        return adIMaxLandingPage.copy(j3, list4, list6, iMaxLike);
    }

    @SerialName("config")
    public static /* synthetic */ void getConfigs$annotations() {
    }

    @SerialName("archive_like")
    public static /* synthetic */ void getLike$annotations() {
    }

    public final long component1() {
        return this.templateStyle;
    }

    public final List<String> component2() {
        return this.showUrls;
    }

    public final List<ConfigBean> component3() {
        return this.configs;
    }

    public final IMaxLike component4() {
        return this.like;
    }

    public final AdIMaxLandingPage copy(long j2, List<String> list, List<ConfigBean> list2, IMaxLike iMaxLike) {
        return new AdIMaxLandingPage(j2, list, list2, iMaxLike);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdIMaxLandingPage) {
            AdIMaxLandingPage adIMaxLandingPage = (AdIMaxLandingPage) obj;
            return this.templateStyle == adIMaxLandingPage.templateStyle && Intrinsics.areEqual(this.showUrls, adIMaxLandingPage.showUrls) && Intrinsics.areEqual(this.configs, adIMaxLandingPage.configs) && Intrinsics.areEqual(this.like, adIMaxLandingPage.like);
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.templateStyle) * 31) + (this.showUrls == null ? 0 : this.showUrls.hashCode())) * 31) + (this.configs == null ? 0 : this.configs.hashCode())) * 31) + (this.like != null ? this.like.hashCode() : 0);
    }

    public String toString() {
        long j2 = this.templateStyle;
        List<String> list = this.showUrls;
        List<ConfigBean> list2 = this.configs;
        return "AdIMaxLandingPage(templateStyle=" + j2 + ", showUrls=" + list + ", configs=" + list2 + ", like=" + this.like + ")";
    }

    /* compiled from: AdIMaxLandingPage.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdIMaxLandingPage$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdIMaxLandingPage;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdIMaxLandingPage> serializer() {
            return AdIMaxLandingPage$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdIMaxLandingPage(int seen0, long templateStyle, List showUrls, List configs, IMaxLike like, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.templateStyle = 0L;
        } else {
            this.templateStyle = templateStyle;
        }
        if ((seen0 & 2) == 0) {
            this.showUrls = null;
        } else {
            this.showUrls = showUrls;
        }
        if ((seen0 & 4) == 0) {
            this.configs = null;
        } else {
            this.configs = configs;
        }
        if ((seen0 & 8) == 0) {
            this.like = null;
        } else {
            this.like = like;
        }
    }

    public AdIMaxLandingPage(long templateStyle, List<String> list, List<ConfigBean> list2, IMaxLike like) {
        this.templateStyle = templateStyle;
        this.showUrls = list;
        this.configs = list2;
        this.like = like;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdIMaxLandingPage$ConfigBean$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdIMaxLandingPage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.templateStyle != 0) {
            output.encodeLongElement(serialDesc, 0, self.templateStyle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.showUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.showUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.configs != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.configs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.like != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, AdIMaxLandingPage$IMaxLike$$serializer.INSTANCE, self.like);
        }
    }

    public /* synthetic */ AdIMaxLandingPage(long j2, List list, List list2, IMaxLike iMaxLike, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j2, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : iMaxLike);
    }

    public final long getTemplateStyle() {
        return this.templateStyle;
    }

    public final List<String> getShowUrls() {
        return this.showUrls;
    }

    public final List<ConfigBean> getConfigs() {
        return this.configs;
    }

    /* compiled from: AdIMaxLandingPage.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Y2\u00020\u0001:\u0002XYBß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bBÑ\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001a\u0010\u001fJ\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010?\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010C\u001a\u00020\u0012HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0016HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003Já\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u0016HÖ\u0001J\t\u0010O\u001a\u00020\u0003HÖ\u0001J%\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0001¢\u0006\u0002\bWR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R&\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u001b\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010!¨\u0006Z"}, d2 = {"Lkntr/app/ad/common/model/AdIMaxLandingPage$ConfigBean;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "icon", "tagList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxTag;", "cover", "jumpUrl", "callupUrl", "reportUrls", "desc", "button", "Lkntr/app/ad/common/model/AdButton;", "video", "Lkntr/app/ad/common/model/AdVideo;", "reportTime", RoomRecommendViewModel.EMPTY_CURSOR, "avid", "weburl", "gameId", RoomRecommendViewModel.EMPTY_CURSOR, "gameMonitorParam", "source", RouterHelperKt.PARAM_SOURCE_FROM, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkntr/app/ad/common/model/AdButton;Lkntr/app/ad/common/model/AdVideo;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkntr/app/ad/common/model/AdButton;Lkntr/app/ad/common/model/AdVideo;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "getTagList$annotations", "()V", "getTagList", "()Ljava/util/List;", "getCover", "getJumpUrl", "getCallupUrl", "getReportUrls", "getDesc", "getButton", "()Lkntr/app/ad/common/model/AdButton;", "getVideo", "()Lkntr/app/ad/common/model/AdVideo;", "getReportTime", "()J", "getAvid", "getWeburl", "getGameId", "()I", "getGameMonitorParam", "getSource", "getSourceFrom", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ConfigBean {
        private final String avid;
        private final AdButton button;
        private final String callupUrl;
        private final String cover;
        private final String desc;
        private final int gameId;
        private final String gameMonitorParam;
        private final String icon;
        private final String jumpUrl;
        private final long reportTime;
        private final List<String> reportUrls;
        private final String source;
        private final String sourceFrom;
        private final List<IMaxTag> tagList;
        private final String title;
        private final AdVideo video;
        private final String weburl;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdIMaxLandingPage$ConfigBean$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = AdIMaxLandingPage.ConfigBean._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdIMaxLandingPage$ConfigBean$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = AdIMaxLandingPage.ConfigBean._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), null, null, null, null, null, null, null, null, null, null};

        public ConfigBean() {
            this((String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (List) null, (String) null, (AdButton) null, (AdVideo) null, 0L, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 131071, (DefaultConstructorMarker) null);
        }

        @SerialName("tags")
        public static /* synthetic */ void getTagList$annotations() {
        }

        public final String component1() {
            return this.title;
        }

        public final AdVideo component10() {
            return this.video;
        }

        public final long component11() {
            return this.reportTime;
        }

        public final String component12() {
            return this.avid;
        }

        public final String component13() {
            return this.weburl;
        }

        public final int component14() {
            return this.gameId;
        }

        public final String component15() {
            return this.gameMonitorParam;
        }

        public final String component16() {
            return this.source;
        }

        public final String component17() {
            return this.sourceFrom;
        }

        public final String component2() {
            return this.icon;
        }

        public final List<IMaxTag> component3() {
            return this.tagList;
        }

        public final String component4() {
            return this.cover;
        }

        public final String component5() {
            return this.jumpUrl;
        }

        public final String component6() {
            return this.callupUrl;
        }

        public final List<String> component7() {
            return this.reportUrls;
        }

        public final String component8() {
            return this.desc;
        }

        public final AdButton component9() {
            return this.button;
        }

        public final ConfigBean copy(String str, String str2, List<IMaxTag> list, String str3, String str4, String str5, List<String> list2, String str6, AdButton adButton, AdVideo adVideo, long j2, String str7, String str8, int i, String str9, String str10, String str11) {
            return new ConfigBean(str, str2, list, str3, str4, str5, list2, str6, adButton, adVideo, j2, str7, str8, i, str9, str10, str11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ConfigBean) {
                ConfigBean configBean = (ConfigBean) obj;
                return Intrinsics.areEqual(this.title, configBean.title) && Intrinsics.areEqual(this.icon, configBean.icon) && Intrinsics.areEqual(this.tagList, configBean.tagList) && Intrinsics.areEqual(this.cover, configBean.cover) && Intrinsics.areEqual(this.jumpUrl, configBean.jumpUrl) && Intrinsics.areEqual(this.callupUrl, configBean.callupUrl) && Intrinsics.areEqual(this.reportUrls, configBean.reportUrls) && Intrinsics.areEqual(this.desc, configBean.desc) && Intrinsics.areEqual(this.button, configBean.button) && Intrinsics.areEqual(this.video, configBean.video) && this.reportTime == configBean.reportTime && Intrinsics.areEqual(this.avid, configBean.avid) && Intrinsics.areEqual(this.weburl, configBean.weburl) && this.gameId == configBean.gameId && Intrinsics.areEqual(this.gameMonitorParam, configBean.gameMonitorParam) && Intrinsics.areEqual(this.source, configBean.source) && Intrinsics.areEqual(this.sourceFrom, configBean.sourceFrom);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.tagList == null ? 0 : this.tagList.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.callupUrl == null ? 0 : this.callupUrl.hashCode())) * 31) + (this.reportUrls == null ? 0 : this.reportUrls.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.button == null ? 0 : this.button.hashCode())) * 31) + (this.video == null ? 0 : this.video.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.reportTime)) * 31) + (this.avid == null ? 0 : this.avid.hashCode())) * 31) + (this.weburl == null ? 0 : this.weburl.hashCode())) * 31) + this.gameId) * 31) + (this.gameMonitorParam == null ? 0 : this.gameMonitorParam.hashCode())) * 31) + (this.source == null ? 0 : this.source.hashCode())) * 31) + (this.sourceFrom != null ? this.sourceFrom.hashCode() : 0);
        }

        public String toString() {
            String str = this.title;
            String str2 = this.icon;
            List<IMaxTag> list = this.tagList;
            String str3 = this.cover;
            String str4 = this.jumpUrl;
            String str5 = this.callupUrl;
            List<String> list2 = this.reportUrls;
            String str6 = this.desc;
            AdButton adButton = this.button;
            AdVideo adVideo = this.video;
            long j2 = this.reportTime;
            String str7 = this.avid;
            String str8 = this.weburl;
            int i = this.gameId;
            String str9 = this.gameMonitorParam;
            String str10 = this.source;
            return "ConfigBean(title=" + str + ", icon=" + str2 + ", tagList=" + list + ", cover=" + str3 + ", jumpUrl=" + str4 + ", callupUrl=" + str5 + ", reportUrls=" + list2 + ", desc=" + str6 + ", button=" + adButton + ", video=" + adVideo + ", reportTime=" + j2 + ", avid=" + str7 + ", weburl=" + str8 + ", gameId=" + i + ", gameMonitorParam=" + str9 + ", source=" + str10 + ", sourceFrom=" + this.sourceFrom + ")";
        }

        /* compiled from: AdIMaxLandingPage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdIMaxLandingPage$ConfigBean$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdIMaxLandingPage$ConfigBean;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ConfigBean> serializer() {
                return AdIMaxLandingPage$ConfigBean$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ConfigBean(int seen0, String title, String icon, List tagList, String cover, String jumpUrl, String callupUrl, List reportUrls, String desc, AdButton button, AdVideo video, long reportTime, String avid, String weburl, int gameId, String gameMonitorParam, String source, String sourceFrom, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.title = null;
            } else {
                this.title = title;
            }
            if ((seen0 & 2) == 0) {
                this.icon = null;
            } else {
                this.icon = icon;
            }
            if ((seen0 & 4) == 0) {
                this.tagList = null;
            } else {
                this.tagList = tagList;
            }
            if ((seen0 & 8) == 0) {
                this.cover = null;
            } else {
                this.cover = cover;
            }
            if ((seen0 & 16) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 32) == 0) {
                this.callupUrl = null;
            } else {
                this.callupUrl = callupUrl;
            }
            if ((seen0 & 64) == 0) {
                this.reportUrls = null;
            } else {
                this.reportUrls = reportUrls;
            }
            if ((seen0 & 128) == 0) {
                this.desc = null;
            } else {
                this.desc = desc;
            }
            if ((seen0 & 256) == 0) {
                this.button = null;
            } else {
                this.button = button;
            }
            if ((seen0 & 512) == 0) {
                this.video = null;
            } else {
                this.video = video;
            }
            if ((seen0 & 1024) == 0) {
                this.reportTime = 0L;
            } else {
                this.reportTime = reportTime;
            }
            if ((seen0 & 2048) == 0) {
                this.avid = null;
            } else {
                this.avid = avid;
            }
            if ((seen0 & 4096) == 0) {
                this.weburl = null;
            } else {
                this.weburl = weburl;
            }
            if ((seen0 & 8192) == 0) {
                this.gameId = 0;
            } else {
                this.gameId = gameId;
            }
            if ((seen0 & 16384) == 0) {
                this.gameMonitorParam = null;
            } else {
                this.gameMonitorParam = gameMonitorParam;
            }
            if ((seen0 & 32768) == 0) {
                this.source = null;
            } else {
                this.source = source;
            }
            if ((seen0 & 65536) == 0) {
                this.sourceFrom = null;
            } else {
                this.sourceFrom = sourceFrom;
            }
        }

        public ConfigBean(String title, String icon, List<IMaxTag> list, String cover, String jumpUrl, String callupUrl, List<String> list2, String desc, AdButton button, AdVideo video, long reportTime, String avid, String weburl, int gameId, String gameMonitorParam, String source, String sourceFrom) {
            this.title = title;
            this.icon = icon;
            this.tagList = list;
            this.cover = cover;
            this.jumpUrl = jumpUrl;
            this.callupUrl = callupUrl;
            this.reportUrls = list2;
            this.desc = desc;
            this.button = button;
            this.video = video;
            this.reportTime = reportTime;
            this.avid = avid;
            this.weburl = weburl;
            this.gameId = gameId;
            this.gameMonitorParam = gameMonitorParam;
            this.source = source;
            this.sourceFrom = sourceFrom;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdIMaxLandingPage$IMaxTag$$serializer.INSTANCE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$dto_debug(ConfigBean self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.title);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.icon != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.icon);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.tagList != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.tagList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.cover != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.cover);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.callupUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.callupUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.reportUrls != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.reportUrls);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.desc != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.desc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.button != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, AdButton$$serializer.INSTANCE, self.button);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.video != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, AdVideo$$serializer.INSTANCE, self.video);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.reportTime != 0) {
                output.encodeLongElement(serialDesc, 10, self.reportTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.avid != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.avid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.weburl != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.weburl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.gameId != 0) {
                output.encodeIntElement(serialDesc, 13, self.gameId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.gameMonitorParam != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.gameMonitorParam);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.source != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.source);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.sourceFrom != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.sourceFrom);
            }
        }

        public /* synthetic */ ConfigBean(String str, String str2, List list, String str3, String str4, String str5, List list2, String str6, AdButton adButton, AdVideo adVideo, long j2, String str7, String str8, int i, String str9, String str10, String str11, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : list2, (i2 & 128) != 0 ? null : str6, (i2 & 256) != 0 ? null : adButton, (i2 & 512) != 0 ? null : adVideo, (i2 & 1024) != 0 ? 0L : j2, (i2 & 2048) != 0 ? null : str7, (i2 & 4096) != 0 ? null : str8, (i2 & 8192) != 0 ? 0 : i, (i2 & 16384) != 0 ? null : str9, (i2 & 32768) != 0 ? null : str10, (i2 & 65536) != 0 ? null : str11);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final List<IMaxTag> getTagList() {
            return this.tagList;
        }

        public final String getCover() {
            return this.cover;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final String getCallupUrl() {
            return this.callupUrl;
        }

        public final List<String> getReportUrls() {
            return this.reportUrls;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final AdButton getButton() {
            return this.button;
        }

        public final AdVideo getVideo() {
            return this.video;
        }

        public final long getReportTime() {
            return this.reportTime;
        }

        public final String getAvid() {
            return this.avid;
        }

        public final String getWeburl() {
            return this.weburl;
        }

        public final int getGameId() {
            return this.gameId;
        }

        public final String getGameMonitorParam() {
            return this.gameMonitorParam;
        }

        public final String getSource() {
            return this.source;
        }

        public final String getSourceFrom() {
            return this.sourceFrom;
        }
    }

    public final IMaxLike getLike() {
        return this.like;
    }

    /* compiled from: AdIMaxLandingPage.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006."}, d2 = {"Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxLike;", RoomRecommendViewModel.EMPTY_CURSOR, "avId", RoomRecommendViewModel.EMPTY_CURSOR, "likeNumber", RoomRecommendViewModel.EMPTY_CURSOR, "dislikeNumber", "hasLike", "hasDislike", "<init>", "(JIIII)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJIIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAvId$annotations", "()V", "getAvId", "()J", "getLikeNumber", "()I", "getDislikeNumber", "getHasLike", "getHasDislike", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class IMaxLike {
        public static final Companion Companion = new Companion(null);
        private final long avId;
        private final int dislikeNumber;
        private final int hasDislike;
        private final int hasLike;
        private final int likeNumber;

        public IMaxLike() {
            this(0L, 0, 0, 0, 0, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ IMaxLike copy$default(IMaxLike iMaxLike, long j2, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                j2 = iMaxLike.avId;
            }
            long j3 = j2;
            if ((i5 & 2) != 0) {
                i = iMaxLike.likeNumber;
            }
            int i6 = i;
            if ((i5 & 4) != 0) {
                i2 = iMaxLike.dislikeNumber;
            }
            int i7 = i2;
            if ((i5 & 8) != 0) {
                i3 = iMaxLike.hasLike;
            }
            int i8 = i3;
            if ((i5 & 16) != 0) {
                i4 = iMaxLike.hasDislike;
            }
            return iMaxLike.copy(j3, i6, i7, i8, i4);
        }

        @SerialName("avid")
        public static /* synthetic */ void getAvId$annotations() {
        }

        public final long component1() {
            return this.avId;
        }

        public final int component2() {
            return this.likeNumber;
        }

        public final int component3() {
            return this.dislikeNumber;
        }

        public final int component4() {
            return this.hasLike;
        }

        public final int component5() {
            return this.hasDislike;
        }

        public final IMaxLike copy(long j2, int i, int i2, int i3, int i4) {
            return new IMaxLike(j2, i, i2, i3, i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IMaxLike) {
                IMaxLike iMaxLike = (IMaxLike) obj;
                return this.avId == iMaxLike.avId && this.likeNumber == iMaxLike.likeNumber && this.dislikeNumber == iMaxLike.dislikeNumber && this.hasLike == iMaxLike.hasLike && this.hasDislike == iMaxLike.hasDislike;
            }
            return false;
        }

        public int hashCode() {
            return (((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avId) * 31) + this.likeNumber) * 31) + this.dislikeNumber) * 31) + this.hasLike) * 31) + this.hasDislike;
        }

        public String toString() {
            long j2 = this.avId;
            int i = this.likeNumber;
            int i2 = this.dislikeNumber;
            int i3 = this.hasLike;
            return "IMaxLike(avId=" + j2 + ", likeNumber=" + i + ", dislikeNumber=" + i2 + ", hasLike=" + i3 + ", hasDislike=" + this.hasDislike + ")";
        }

        /* compiled from: AdIMaxLandingPage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxLike$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxLike;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<IMaxLike> serializer() {
                return AdIMaxLandingPage$IMaxLike$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ IMaxLike(int seen0, long avId, int likeNumber, int dislikeNumber, int hasLike, int hasDislike, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.avId = 0L;
            } else {
                this.avId = avId;
            }
            if ((seen0 & 2) == 0) {
                this.likeNumber = 0;
            } else {
                this.likeNumber = likeNumber;
            }
            if ((seen0 & 4) == 0) {
                this.dislikeNumber = 0;
            } else {
                this.dislikeNumber = dislikeNumber;
            }
            if ((seen0 & 8) == 0) {
                this.hasLike = 0;
            } else {
                this.hasLike = hasLike;
            }
            if ((seen0 & 16) == 0) {
                this.hasDislike = 0;
            } else {
                this.hasDislike = hasDislike;
            }
        }

        public IMaxLike(long avId, int likeNumber, int dislikeNumber, int hasLike, int hasDislike) {
            this.avId = avId;
            this.likeNumber = likeNumber;
            this.dislikeNumber = dislikeNumber;
            this.hasLike = hasLike;
            this.hasDislike = hasDislike;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$dto_debug(IMaxLike self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.avId != 0) {
                output.encodeLongElement(serialDesc, 0, self.avId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.likeNumber != 0) {
                output.encodeIntElement(serialDesc, 1, self.likeNumber);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.dislikeNumber != 0) {
                output.encodeIntElement(serialDesc, 2, self.dislikeNumber);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.hasLike != 0) {
                output.encodeIntElement(serialDesc, 3, self.hasLike);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.hasDislike != 0) {
                output.encodeIntElement(serialDesc, 4, self.hasDislike);
            }
        }

        public /* synthetic */ IMaxLike(long j2, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? 0L : j2, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 0 : i4);
        }

        public final long getAvId() {
            return this.avId;
        }

        public final int getLikeNumber() {
            return this.likeNumber;
        }

        public final int getDislikeNumber() {
            return this.dislikeNumber;
        }

        public final int getHasLike() {
            return this.hasLike;
        }

        public final int getHasDislike() {
            return this.hasDislike;
        }
    }

    /* compiled from: AdIMaxLandingPage.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBQ\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tHÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\rHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxTag;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "positionX", RoomRecommendViewModel.EMPTY_CURSOR, "positionY", "jumpUrl", "reportUrls", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;FFLjava/lang/String;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;FFLjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getPositionX", "()F", "getPositionY", "getJumpUrl", "getReportUrls", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class IMaxTag {
        private final String jumpUrl;
        private final float positionX;
        private final float positionY;
        private final List<String> reportUrls;
        private final String text;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdIMaxLandingPage$IMaxTag$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = AdIMaxLandingPage.IMaxTag._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public IMaxTag() {
            this((String) null, 0.0f, 0.0f, (String) null, (List) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ IMaxTag copy$default(IMaxTag iMaxTag, String str, float f, float f2, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = iMaxTag.text;
            }
            if ((i & 2) != 0) {
                f = iMaxTag.positionX;
            }
            float f3 = f;
            if ((i & 4) != 0) {
                f2 = iMaxTag.positionY;
            }
            float f4 = f2;
            if ((i & 8) != 0) {
                str2 = iMaxTag.jumpUrl;
            }
            String str3 = str2;
            List<String> list2 = list;
            if ((i & 16) != 0) {
                list2 = iMaxTag.reportUrls;
            }
            return iMaxTag.copy(str, f3, f4, str3, list2);
        }

        public final String component1() {
            return this.text;
        }

        public final float component2() {
            return this.positionX;
        }

        public final float component3() {
            return this.positionY;
        }

        public final String component4() {
            return this.jumpUrl;
        }

        public final List<String> component5() {
            return this.reportUrls;
        }

        public final IMaxTag copy(String str, float f, float f2, String str2, List<String> list) {
            return new IMaxTag(str, f, f2, str2, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IMaxTag) {
                IMaxTag iMaxTag = (IMaxTag) obj;
                return Intrinsics.areEqual(this.text, iMaxTag.text) && Float.compare(this.positionX, iMaxTag.positionX) == 0 && Float.compare(this.positionY, iMaxTag.positionY) == 0 && Intrinsics.areEqual(this.jumpUrl, iMaxTag.jumpUrl) && Intrinsics.areEqual(this.reportUrls, iMaxTag.reportUrls);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.text == null ? 0 : this.text.hashCode()) * 31) + Float.floatToIntBits(this.positionX)) * 31) + Float.floatToIntBits(this.positionY)) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.reportUrls != null ? this.reportUrls.hashCode() : 0);
        }

        public String toString() {
            String str = this.text;
            float f = this.positionX;
            float f2 = this.positionY;
            String str2 = this.jumpUrl;
            return "IMaxTag(text=" + str + ", positionX=" + f + ", positionY=" + f2 + ", jumpUrl=" + str2 + ", reportUrls=" + this.reportUrls + ")";
        }

        /* compiled from: AdIMaxLandingPage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxTag$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxTag;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<IMaxTag> serializer() {
                return AdIMaxLandingPage$IMaxTag$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ IMaxTag(int seen0, String text, float positionX, float positionY, String jumpUrl, List reportUrls, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.text = null;
            } else {
                this.text = text;
            }
            if ((seen0 & 2) == 0) {
                this.positionX = 0.0f;
            } else {
                this.positionX = positionX;
            }
            if ((seen0 & 4) == 0) {
                this.positionY = 0.0f;
            } else {
                this.positionY = positionY;
            }
            if ((seen0 & 8) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 16) == 0) {
                this.reportUrls = null;
            } else {
                this.reportUrls = reportUrls;
            }
        }

        public IMaxTag(String text, float positionX, float positionY, String jumpUrl, List<String> list) {
            this.text = text;
            this.positionX = positionX;
            this.positionY = positionY;
            this.jumpUrl = jumpUrl;
            this.reportUrls = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$dto_debug(IMaxTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.text != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.text);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || Float.compare(self.positionX, 0.0f) != 0) {
                output.encodeFloatElement(serialDesc, 1, self.positionX);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || Float.compare(self.positionY, 0.0f) != 0) {
                output.encodeFloatElement(serialDesc, 2, self.positionY);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.reportUrls != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.reportUrls);
            }
        }

        public /* synthetic */ IMaxTag(String str, float f, float f2, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0.0f : f, (i & 4) == 0 ? f2 : 0.0f, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : list);
        }

        public final String getText() {
            return this.text;
        }

        public final float getPositionX() {
            return this.positionX;
        }

        public final float getPositionY() {
            return this.positionY;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final List<String> getReportUrls() {
            return this.reportUrls;
        }
    }
}