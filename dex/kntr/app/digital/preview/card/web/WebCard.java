package kntr.app.digital.preview.card.web;

import BottomSheetItemData$;
import kntr.app.digital.preview.card.video.WithVolume;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: WebCard.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0002'(B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006)"}, d2 = {"Lkntr/app/digital/preview/card/web/WebCard;", "Lkntr/app/digital/preview/card/video/WithVolume;", "imageUrl", RoomRecommendViewModel.EMPTY_CURSOR, "renderUrl", "volumeKeysShowing", RoomRecommendViewModel.EMPTY_CURSOR, "volumeOn", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageUrl", "()Ljava/lang/String;", "getRenderUrl", "getVolumeKeysShowing", "()Z", "getVolumeOn", "component1", "component2", "component3", "component4", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class WebCard implements WithVolume {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String imageUrl;
    private final String renderUrl;
    private final boolean volumeKeysShowing;
    private final boolean volumeOn;

    public WebCard() {
        this((String) null, (String) null, false, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WebCard copy$default(WebCard webCard, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = webCard.imageUrl;
        }
        if ((i & 2) != 0) {
            str2 = webCard.renderUrl;
        }
        if ((i & 4) != 0) {
            z = webCard.volumeKeysShowing;
        }
        if ((i & 8) != 0) {
            z2 = webCard.volumeOn;
        }
        return webCard.copy(str, str2, z, z2);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.renderUrl;
    }

    public final boolean component3() {
        return this.volumeKeysShowing;
    }

    public final boolean component4() {
        return this.volumeOn;
    }

    public final WebCard copy(String str, String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(str2, "renderUrl");
        return new WebCard(str, str2, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WebCard) {
            WebCard webCard = (WebCard) obj;
            return Intrinsics.areEqual(this.imageUrl, webCard.imageUrl) && Intrinsics.areEqual(this.renderUrl, webCard.renderUrl) && this.volumeKeysShowing == webCard.volumeKeysShowing && this.volumeOn == webCard.volumeOn;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.imageUrl.hashCode() * 31) + this.renderUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.volumeKeysShowing)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.volumeOn);
    }

    public String toString() {
        String str = this.imageUrl;
        String str2 = this.renderUrl;
        boolean z = this.volumeKeysShowing;
        return "WebCard(imageUrl=" + str + ", renderUrl=" + str2 + ", volumeKeysShowing=" + z + ", volumeOn=" + this.volumeOn + ")";
    }

    /* compiled from: WebCard.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/card/web/WebCard$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/card/web/WebCard;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WebCard> serializer() {
            return new GeneratedSerializer<WebCard>() { // from class: kntr.app.digital.preview.card.web.WebCard$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.digital.preview.card.web.WebCard", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.digital.preview.card.web.WebCard> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.digital.preview.card.web.WebCard> A[REMOVE]) =  kntr.app.digital.preview.card.web.WebCard$$serializer.INSTANCE kntr.app.digital.preview.card.web.WebCard$$serializer)
                         in method: kntr.app.digital.preview.card.web.WebCard.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.digital.preview.card.web.WebCard>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                          ("kntr.app.digital.preview.card.web.WebCard")
                          (wrap: kntr.app.digital.preview.card.web.WebCard$$serializer : 0x0009: SGET  (r1v0 kntr.app.digital.preview.card.web.WebCard$$serializer A[REMOVE]) =  kntr.app.digital.preview.card.web.WebCard$$serializer.INSTANCE kntr.app.digital.preview.card.web.WebCard$$serializer)
                          (4 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.digital.preview.card.web.WebCard$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.digital.preview.card.web.WebCard$$serializer
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
                        kntr.app.digital.preview.card.web.WebCard$$serializer r0 = kntr.app.digital.preview.card.web.WebCard$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.digital.preview.card.web.WebCard.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ WebCard(int seen0, String imageUrl, String renderUrl, boolean volumeKeysShowing, boolean volumeOn, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.imageUrl = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.imageUrl = imageUrl;
                }
                if ((seen0 & 2) == 0) {
                    this.renderUrl = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.renderUrl = renderUrl;
                }
                if ((seen0 & 4) == 0) {
                    this.volumeKeysShowing = false;
                } else {
                    this.volumeKeysShowing = volumeKeysShowing;
                }
                if ((seen0 & 8) == 0) {
                    this.volumeOn = false;
                } else {
                    this.volumeOn = volumeOn;
                }
            }

            public WebCard(String imageUrl, String renderUrl, boolean volumeKeysShowing, boolean volumeOn) {
                Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                Intrinsics.checkNotNullParameter(renderUrl, "renderUrl");
                this.imageUrl = imageUrl;
                this.renderUrl = renderUrl;
                this.volumeKeysShowing = volumeKeysShowing;
                this.volumeOn = volumeOn;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$preview_debug(WebCard self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.imageUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 0, self.imageUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.renderUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 1, self.renderUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getVolumeKeysShowing()) {
                    output.encodeBooleanElement(serialDesc, 2, self.getVolumeKeysShowing());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.getVolumeOn()) {
                    output.encodeBooleanElement(serialDesc, 3, self.getVolumeOn());
                }
            }

            public /* synthetic */ WebCard(String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
            }

            public final String getImageUrl() {
                return this.imageUrl;
            }

            public final String getRenderUrl() {
                return this.renderUrl;
            }

            @Override // kntr.app.digital.preview.card.video.WithVolume
            public boolean getVolumeKeysShowing() {
                return this.volumeKeysShowing;
            }

            @Override // kntr.app.digital.preview.card.video.WithVolume
            public boolean getVolumeOn() {
                return this.volumeOn;
            }
        }