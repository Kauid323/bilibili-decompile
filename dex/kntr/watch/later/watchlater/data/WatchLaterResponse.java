package kntr.watch.later.watchlater.data;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: WatchLaterResponse.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 72\u00020\u0001:\u000267BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rB[\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JS\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u000fHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\"¨\u00068"}, d2 = {"Lkntr/watch/later/watchlater/data/WatchLaterResponse;", "", "showCount", "", "hasMore", "", "nextKey", "splitKey", "playUrl", "list", "", "Lkntr/watch/later/watchlater/data/WatchLaterItem;", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShowCount$annotations", "()V", "getShowCount", "()Ljava/lang/String;", "getHasMore$annotations", "getHasMore", "()Z", "getNextKey$annotations", "getNextKey", "getSplitKey$annotations", "getSplitKey", "getPlayUrl$annotations", "getPlayUrl", "getList$annotations", "getList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$watch_later_debug", "$serializer", "Companion", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class WatchLaterResponse {
    private final boolean hasMore;
    private final List<WatchLaterItem> list;
    private final String nextKey;
    private final String playUrl;
    private final String showCount;
    private final String splitKey;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.watch.later.watchlater.data.WatchLaterResponse$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = WatchLaterResponse._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public WatchLaterResponse() {
        this((String) null, false, (String) null, (String) null, (String) null, (List) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WatchLaterResponse copy$default(WatchLaterResponse watchLaterResponse, String str, boolean z, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = watchLaterResponse.showCount;
        }
        if ((i & 2) != 0) {
            z = watchLaterResponse.hasMore;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str2 = watchLaterResponse.nextKey;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = watchLaterResponse.splitKey;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = watchLaterResponse.playUrl;
        }
        String str7 = str4;
        List<WatchLaterItem> list2 = list;
        if ((i & 32) != 0) {
            list2 = watchLaterResponse.list;
        }
        return watchLaterResponse.copy(str, z2, str5, str6, str7, list2);
    }

    @SerialName("has_more")
    public static /* synthetic */ void getHasMore$annotations() {
    }

    @SerialName("list")
    public static /* synthetic */ void getList$annotations() {
    }

    @SerialName("next_key")
    public static /* synthetic */ void getNextKey$annotations() {
    }

    @SerialName("play_url")
    public static /* synthetic */ void getPlayUrl$annotations() {
    }

    @SerialName("show_count")
    public static /* synthetic */ void getShowCount$annotations() {
    }

    @SerialName("split_key")
    public static /* synthetic */ void getSplitKey$annotations() {
    }

    public final String component1() {
        return this.showCount;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final String component3() {
        return this.nextKey;
    }

    public final String component4() {
        return this.splitKey;
    }

    public final String component5() {
        return this.playUrl;
    }

    public final List<WatchLaterItem> component6() {
        return this.list;
    }

    public final WatchLaterResponse copy(String str, boolean z, String str2, String str3, String str4, List<WatchLaterItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new WatchLaterResponse(str, z, str2, str3, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WatchLaterResponse) {
            WatchLaterResponse watchLaterResponse = (WatchLaterResponse) obj;
            return Intrinsics.areEqual(this.showCount, watchLaterResponse.showCount) && this.hasMore == watchLaterResponse.hasMore && Intrinsics.areEqual(this.nextKey, watchLaterResponse.nextKey) && Intrinsics.areEqual(this.splitKey, watchLaterResponse.splitKey) && Intrinsics.areEqual(this.playUrl, watchLaterResponse.playUrl) && Intrinsics.areEqual(this.list, watchLaterResponse.list);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.showCount == null ? 0 : this.showCount.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMore)) * 31) + (this.nextKey == null ? 0 : this.nextKey.hashCode())) * 31) + (this.splitKey == null ? 0 : this.splitKey.hashCode())) * 31) + (this.playUrl != null ? this.playUrl.hashCode() : 0)) * 31) + this.list.hashCode();
    }

    public String toString() {
        String str = this.showCount;
        boolean z = this.hasMore;
        String str2 = this.nextKey;
        String str3 = this.splitKey;
        String str4 = this.playUrl;
        return "WatchLaterResponse(showCount=" + str + ", hasMore=" + z + ", nextKey=" + str2 + ", splitKey=" + str3 + ", playUrl=" + str4 + ", list=" + this.list + ")";
    }

    /* compiled from: WatchLaterResponse.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/watch/later/watchlater/data/WatchLaterResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/watch/later/watchlater/data/WatchLaterResponse;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WatchLaterResponse> serializer() {
            return new GeneratedSerializer<WatchLaterResponse>() { // from class: kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.watch.later.watchlater.data.WatchLaterResponse", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.watch.later.watchlater.data.WatchLaterResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.watch.later.watchlater.data.WatchLaterResponse> A[REMOVE]) =  kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer.INSTANCE kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer)
                         in method: kntr.watch.later.watchlater.data.WatchLaterResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.watch.later.watchlater.data.WatchLaterResponse>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.watch.later.watchlater.data.WatchLaterResponse")
                          (wrap: kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer : 0x0009: SGET  (r1v0 kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer A[REMOVE]) =  kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer.INSTANCE kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer)
                          (6 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer
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
                        kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer r0 = kntr.watch.later.watchlater.data.WatchLaterResponse$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.watch.later.watchlater.data.WatchLaterResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ WatchLaterResponse(int seen0, String showCount, boolean hasMore, String nextKey, String splitKey, String playUrl, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.showCount = null;
                } else {
                    this.showCount = showCount;
                }
                if ((seen0 & 2) == 0) {
                    this.hasMore = false;
                } else {
                    this.hasMore = hasMore;
                }
                if ((seen0 & 4) == 0) {
                    this.nextKey = null;
                } else {
                    this.nextKey = nextKey;
                }
                if ((seen0 & 8) == 0) {
                    this.splitKey = null;
                } else {
                    this.splitKey = splitKey;
                }
                if ((seen0 & 16) == 0) {
                    this.playUrl = null;
                } else {
                    this.playUrl = playUrl;
                }
                if ((seen0 & 32) == 0) {
                    this.list = CollectionsKt.emptyList();
                } else {
                    this.list = list;
                }
            }

            public WatchLaterResponse(String showCount, boolean hasMore, String nextKey, String splitKey, String playUrl, List<WatchLaterItem> list) {
                Intrinsics.checkNotNullParameter(list, "list");
                this.showCount = showCount;
                this.hasMore = hasMore;
                this.nextKey = nextKey;
                this.splitKey = splitKey;
                this.playUrl = playUrl;
                this.list = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(WatchLaterItem$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$watch_later_debug(WatchLaterResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.showCount != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.showCount);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasMore) {
                    output.encodeBooleanElement(serialDesc, 1, self.hasMore);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.nextKey != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.nextKey);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.splitKey != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.splitKey);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.playUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.playUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.list, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.list);
                }
            }

            public /* synthetic */ WatchLaterResponse(String str, boolean z, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) == 0 ? str4 : null, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
            }

            public final String getShowCount() {
                return this.showCount;
            }

            public final boolean getHasMore() {
                return this.hasMore;
            }

            public final String getNextKey() {
                return this.nextKey;
            }

            public final String getSplitKey() {
                return this.splitKey;
            }

            public final String getPlayUrl() {
                return this.playUrl;
            }

            public final List<WatchLaterItem> getList() {
                return this.list;
            }
        }