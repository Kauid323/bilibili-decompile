package kntr.app.digital.preview.gift;

import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DigitalCardGift.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 22\u00020\u0001:\u000212B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\n\u0010\u000bBQ\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003JA\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0016R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001d¨\u00063"}, d2 = {"Lkntr/app/digital/preview/gift/DigitalCardGift;", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.STATUS, RoomRecommendViewModel.EMPTY_CURSOR, "jumpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "title", "contentTemplate", "highlightParams", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStatus$annotations", "()V", "getStatus", "()I", "getJumpUrl$annotations", "getJumpUrl", "()Ljava/lang/String;", "getTitle$annotations", "getTitle", "getContentTemplate$annotations", "getContentTemplate", "getHighlightParams$annotations", "getHighlightParams", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class DigitalCardGift {
    private final String contentTemplate;
    private final List<String> highlightParams;
    private final String jumpUrl;
    private final int status;
    private final String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.gift.DigitalCardGift$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DigitalCardGift._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public DigitalCardGift() {
        this(0, (String) null, (String) null, (String) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DigitalCardGift copy$default(DigitalCardGift digitalCardGift, int i, String str, String str2, String str3, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = digitalCardGift.status;
        }
        if ((i2 & 2) != 0) {
            str = digitalCardGift.jumpUrl;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = digitalCardGift.title;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = digitalCardGift.contentTemplate;
        }
        String str6 = str3;
        List<String> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = digitalCardGift.highlightParams;
        }
        return digitalCardGift.copy(i, str4, str5, str6, list2);
    }

    @SerialName("content_template")
    public static /* synthetic */ void getContentTemplate$annotations() {
    }

    @SerialName("highlight_params")
    public static /* synthetic */ void getHighlightParams$annotations() {
    }

    @SerialName("jump_url")
    public static /* synthetic */ void getJumpUrl$annotations() {
    }

    @SerialName(AdAlarmExtraKey.STATUS)
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.contentTemplate;
    }

    public final List<String> component5() {
        return this.highlightParams;
    }

    public final DigitalCardGift copy(int i, String str, String str2, String str3, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "jumpUrl");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "contentTemplate");
        Intrinsics.checkNotNullParameter(list, "highlightParams");
        return new DigitalCardGift(i, str, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DigitalCardGift) {
            DigitalCardGift digitalCardGift = (DigitalCardGift) obj;
            return this.status == digitalCardGift.status && Intrinsics.areEqual(this.jumpUrl, digitalCardGift.jumpUrl) && Intrinsics.areEqual(this.title, digitalCardGift.title) && Intrinsics.areEqual(this.contentTemplate, digitalCardGift.contentTemplate) && Intrinsics.areEqual(this.highlightParams, digitalCardGift.highlightParams);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.status * 31) + this.jumpUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.contentTemplate.hashCode()) * 31) + this.highlightParams.hashCode();
    }

    public String toString() {
        int i = this.status;
        String str = this.jumpUrl;
        String str2 = this.title;
        String str3 = this.contentTemplate;
        return "DigitalCardGift(status=" + i + ", jumpUrl=" + str + ", title=" + str2 + ", contentTemplate=" + str3 + ", highlightParams=" + this.highlightParams + ")";
    }

    /* compiled from: DigitalCardGift.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/gift/DigitalCardGift$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/gift/DigitalCardGift;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DigitalCardGift> serializer() {
            return new GeneratedSerializer<DigitalCardGift>() { // from class: kntr.app.digital.preview.gift.DigitalCardGift$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.digital.preview.gift.DigitalCardGift", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.digital.preview.gift.DigitalCardGift> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.digital.preview.gift.DigitalCardGift> A[REMOVE]) =  kntr.app.digital.preview.gift.DigitalCardGift$$serializer.INSTANCE kntr.app.digital.preview.gift.DigitalCardGift$$serializer)
                         in method: kntr.app.digital.preview.gift.DigitalCardGift.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.digital.preview.gift.DigitalCardGift>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.app.digital.preview.gift.DigitalCardGift")
                          (wrap: kntr.app.digital.preview.gift.DigitalCardGift$$serializer : 0x0009: SGET  (r1v0 kntr.app.digital.preview.gift.DigitalCardGift$$serializer A[REMOVE]) =  kntr.app.digital.preview.gift.DigitalCardGift$$serializer.INSTANCE kntr.app.digital.preview.gift.DigitalCardGift$$serializer)
                          (5 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.digital.preview.gift.DigitalCardGift$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.digital.preview.gift.DigitalCardGift$$serializer
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
                        kntr.app.digital.preview.gift.DigitalCardGift$$serializer r0 = kntr.app.digital.preview.gift.DigitalCardGift$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.digital.preview.gift.DigitalCardGift.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ DigitalCardGift(int seen0, int status, String jumpUrl, String title, String contentTemplate, List highlightParams, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.status = 0;
                } else {
                    this.status = status;
                }
                if ((seen0 & 2) == 0) {
                    this.jumpUrl = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.jumpUrl = jumpUrl;
                }
                if ((seen0 & 4) == 0) {
                    this.title = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.title = title;
                }
                if ((seen0 & 8) == 0) {
                    this.contentTemplate = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.contentTemplate = contentTemplate;
                }
                if ((seen0 & 16) == 0) {
                    this.highlightParams = CollectionsKt.emptyList();
                } else {
                    this.highlightParams = highlightParams;
                }
            }

            public DigitalCardGift(int status, String jumpUrl, String title, String contentTemplate, List<String> list) {
                Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(contentTemplate, "contentTemplate");
                Intrinsics.checkNotNullParameter(list, "highlightParams");
                this.status = status;
                this.jumpUrl = jumpUrl;
                this.title = title;
                this.contentTemplate = contentTemplate;
                this.highlightParams = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(StringSerializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$preview_debug(DigitalCardGift self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.status != 0) {
                    output.encodeIntElement(serialDesc, 0, self.status);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.jumpUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 1, self.jumpUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.title, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 2, self.title);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.contentTemplate, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 3, self.contentTemplate);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.highlightParams, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.highlightParams);
                }
            }

            public /* synthetic */ DigitalCardGift(int i, String str, String str2, String str3, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i2 & 8) == 0 ? str3 : RoomRecommendViewModel.EMPTY_CURSOR, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list);
            }

            public final int getStatus() {
                return this.status;
            }

            public final String getJumpUrl() {
                return this.jumpUrl;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getContentTemplate() {
                return this.contentTemplate;
            }

            public final List<String> getHighlightParams() {
                return this.highlightParams;
            }
        }