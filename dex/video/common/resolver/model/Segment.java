package video.common.resolver.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashDataKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SegmentVideo.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003JK\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\bHÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018¨\u00064"}, d2 = {"Lvideo/common/resolver/model/Segment;", "", BrandSplashDataKt.ORDER_RULE, "", "duration", "", "bytes", "url", "", "backupUrl", "", "md5", "<init>", "(IJJLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJJLjava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOrder", "()I", "getDuration", "()J", "getBytes", "getUrl", "()Ljava/lang/String;", "getBackupUrl$annotations", "()V", "getBackupUrl", "()Ljava/util/List;", "getMd5", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$resolver_debug", "$serializer", "Companion", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class Segment {
    private final List<String> backupUrl;
    private final long bytes;
    private final long duration;
    private final String md5;
    private final int order;
    private final String url;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.common.resolver.model.Segment$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = Segment._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    public Segment() {
        this(0, 0L, 0L, (String) null, (List) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    @SerialName("backup_urls")
    public static /* synthetic */ void getBackupUrl$annotations() {
    }

    public final int component1() {
        return this.order;
    }

    public final long component2() {
        return this.duration;
    }

    public final long component3() {
        return this.bytes;
    }

    public final String component4() {
        return this.url;
    }

    public final List<String> component5() {
        return this.backupUrl;
    }

    public final String component6() {
        return this.md5;
    }

    public final Segment copy(int i, long j, long j2, String str, List<String> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(list, "backupUrl");
        Intrinsics.checkNotNullParameter(str2, "md5");
        return new Segment(i, j, j2, str, list, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Segment) {
            Segment segment = (Segment) obj;
            return this.order == segment.order && this.duration == segment.duration && this.bytes == segment.bytes && Intrinsics.areEqual(this.url, segment.url) && Intrinsics.areEqual(this.backupUrl, segment.backupUrl) && Intrinsics.areEqual(this.md5, segment.md5);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.order * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.bytes)) * 31) + this.url.hashCode()) * 31) + this.backupUrl.hashCode()) * 31) + this.md5.hashCode();
    }

    public String toString() {
        int i = this.order;
        long j = this.duration;
        long j2 = this.bytes;
        String str = this.url;
        List<String> list = this.backupUrl;
        return "Segment(order=" + i + ", duration=" + j + ", bytes=" + j2 + ", url=" + str + ", backupUrl=" + list + ", md5=" + this.md5 + ")";
    }

    /* compiled from: SegmentVideo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/common/resolver/model/Segment$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/common/resolver/model/Segment;", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Segment> serializer() {
            return Segment$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Segment(int seen0, int order, long duration, long bytes, String url, List backupUrl, String md5, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.order = 0;
        } else {
            this.order = order;
        }
        if ((seen0 & 2) == 0) {
            this.duration = 0L;
        } else {
            this.duration = duration;
        }
        if ((seen0 & 4) == 0) {
            this.bytes = 0L;
        } else {
            this.bytes = bytes;
        }
        if ((seen0 & 8) == 0) {
            this.url = "";
        } else {
            this.url = url;
        }
        if ((seen0 & 16) == 0) {
            this.backupUrl = CollectionsKt.emptyList();
        } else {
            this.backupUrl = backupUrl;
        }
        if ((seen0 & 32) == 0) {
            this.md5 = "";
        } else {
            this.md5 = md5;
        }
    }

    public Segment(int order, long duration, long bytes, String url, List<String> list, String md5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(list, "backupUrl");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.order = order;
        this.duration = duration;
        this.bytes = bytes;
        this.url = url;
        this.backupUrl = list;
        this.md5 = md5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$resolver_debug(Segment self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.order != 0) {
            output.encodeIntElement(serialDesc, 0, self.order);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.duration != 0) {
            output.encodeLongElement(serialDesc, 1, self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.bytes != 0) {
            output.encodeLongElement(serialDesc, 2, self.bytes);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.url, "")) {
            output.encodeStringElement(serialDesc, 3, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.backupUrl, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.backupUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.md5, "")) {
            output.encodeStringElement(serialDesc, 5, self.md5);
        }
    }

    public /* synthetic */ Segment(int i, long j, long j2, String str, List list, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) == 0 ? j2 : 0L, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list, (i2 & 32) == 0 ? str2 : "");
    }

    public final int getOrder() {
        return this.order;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getBytes() {
        return this.bytes;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<String> getBackupUrl() {
        return this.backupUrl;
    }

    public final String getMd5() {
        return this.md5;
    }
}