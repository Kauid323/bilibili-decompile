package kntr.app.mall.product.details.page.api.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: UserInteractInfo.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002;<Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bu\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\"Jz\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u000eHÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"¨\u0006="}, d2 = {"Lkntr/app/mall/product/details/page/api/model/UserInteractInfo;", "", "active", "", "activeIcon", "", "activeNightIcon", "desc", "icon", "jumpUrl", "nightIcon", "shareExtra", "Lkntr/app/mall/product/details/page/api/model/ShareExtra;", "type", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShareExtra;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShareExtra;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getActiveIcon", "()Ljava/lang/String;", "getActiveNightIcon", "getDesc", "getIcon", "getJumpUrl", "getNightIcon", "getShareExtra", "()Lkntr/app/mall/product/details/page/api/model/ShareExtra;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShareExtra;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/UserInteractInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class UserInteractInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Boolean active;
    private final String activeIcon;
    private final String activeNightIcon;
    private final String desc;
    private final String icon;
    private final String jumpUrl;
    private final String nightIcon;
    private final ShareExtra shareExtra;
    private final Integer type;

    public UserInteractInfo() {
        this((Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ShareExtra) null, (Integer) null, 511, (DefaultConstructorMarker) null);
    }

    public final Boolean component1() {
        return this.active;
    }

    public final String component2() {
        return this.activeIcon;
    }

    public final String component3() {
        return this.activeNightIcon;
    }

    public final String component4() {
        return this.desc;
    }

    public final String component5() {
        return this.icon;
    }

    public final String component6() {
        return this.jumpUrl;
    }

    public final String component7() {
        return this.nightIcon;
    }

    public final ShareExtra component8() {
        return this.shareExtra;
    }

    public final Integer component9() {
        return this.type;
    }

    public final UserInteractInfo copy(Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, ShareExtra shareExtra, Integer num) {
        return new UserInteractInfo(bool, str, str2, str3, str4, str5, str6, shareExtra, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserInteractInfo) {
            UserInteractInfo userInteractInfo = (UserInteractInfo) obj;
            return Intrinsics.areEqual(this.active, userInteractInfo.active) && Intrinsics.areEqual(this.activeIcon, userInteractInfo.activeIcon) && Intrinsics.areEqual(this.activeNightIcon, userInteractInfo.activeNightIcon) && Intrinsics.areEqual(this.desc, userInteractInfo.desc) && Intrinsics.areEqual(this.icon, userInteractInfo.icon) && Intrinsics.areEqual(this.jumpUrl, userInteractInfo.jumpUrl) && Intrinsics.areEqual(this.nightIcon, userInteractInfo.nightIcon) && Intrinsics.areEqual(this.shareExtra, userInteractInfo.shareExtra) && Intrinsics.areEqual(this.type, userInteractInfo.type);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.active == null ? 0 : this.active.hashCode()) * 31) + (this.activeIcon == null ? 0 : this.activeIcon.hashCode())) * 31) + (this.activeNightIcon == null ? 0 : this.activeNightIcon.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.nightIcon == null ? 0 : this.nightIcon.hashCode())) * 31) + (this.shareExtra == null ? 0 : this.shareExtra.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.active;
        String str = this.activeIcon;
        String str2 = this.activeNightIcon;
        String str3 = this.desc;
        String str4 = this.icon;
        String str5 = this.jumpUrl;
        String str6 = this.nightIcon;
        ShareExtra shareExtra = this.shareExtra;
        return "UserInteractInfo(active=" + bool + ", activeIcon=" + str + ", activeNightIcon=" + str2 + ", desc=" + str3 + ", icon=" + str4 + ", jumpUrl=" + str5 + ", nightIcon=" + str6 + ", shareExtra=" + shareExtra + ", type=" + this.type + ")";
    }

    /* compiled from: UserInteractInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/UserInteractInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/UserInteractInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UserInteractInfo> serializer() {
            return new GeneratedSerializer<UserInteractInfo>() { // from class: kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.mall.product.details.page.api.model.UserInteractInfo", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.model.UserInteractInfo> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.model.UserInteractInfo> A[REMOVE]) =  kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer.INSTANCE kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer)
                         in method: kntr.app.mall.product.details.page.api.model.UserInteractInfo.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.mall.product.details.page.api.model.UserInteractInfo>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.app.mall.product.details.page.api.model.UserInteractInfo")
                          (wrap: kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer : 0x0009: SGET  (r1v0 kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer A[REMOVE]) =  kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer.INSTANCE kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer)
                          (9 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer
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
                        kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer r0 = kntr.app.mall.product.details.page.api.model.UserInteractInfo$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.api.model.UserInteractInfo.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ UserInteractInfo(int seen0, Boolean active, String activeIcon, String activeNightIcon, String desc, String icon, String jumpUrl, String nightIcon, ShareExtra shareExtra, Integer type, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.active = null;
                } else {
                    this.active = active;
                }
                if ((seen0 & 2) == 0) {
                    this.activeIcon = null;
                } else {
                    this.activeIcon = activeIcon;
                }
                if ((seen0 & 4) == 0) {
                    this.activeNightIcon = null;
                } else {
                    this.activeNightIcon = activeNightIcon;
                }
                if ((seen0 & 8) == 0) {
                    this.desc = null;
                } else {
                    this.desc = desc;
                }
                if ((seen0 & 16) == 0) {
                    this.icon = null;
                } else {
                    this.icon = icon;
                }
                if ((seen0 & 32) == 0) {
                    this.jumpUrl = null;
                } else {
                    this.jumpUrl = jumpUrl;
                }
                if ((seen0 & 64) == 0) {
                    this.nightIcon = null;
                } else {
                    this.nightIcon = nightIcon;
                }
                if ((seen0 & 128) == 0) {
                    this.shareExtra = null;
                } else {
                    this.shareExtra = shareExtra;
                }
                if ((seen0 & 256) == 0) {
                    this.type = null;
                } else {
                    this.type = type;
                }
            }

            public UserInteractInfo(Boolean active, String activeIcon, String activeNightIcon, String desc, String icon, String jumpUrl, String nightIcon, ShareExtra shareExtra, Integer type) {
                this.active = active;
                this.activeIcon = activeIcon;
                this.activeNightIcon = activeNightIcon;
                this.desc = desc;
                this.icon = icon;
                this.jumpUrl = jumpUrl;
                this.nightIcon = nightIcon;
                this.shareExtra = shareExtra;
                this.type = type;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(UserInteractInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.active != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.active);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.activeIcon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.activeIcon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.activeNightIcon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.activeNightIcon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.desc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.desc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.icon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.icon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.jumpUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.jumpUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.nightIcon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.nightIcon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.shareExtra != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, ShareExtra$$serializer.INSTANCE, self.shareExtra);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.type != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.type);
                }
            }

            public /* synthetic */ UserInteractInfo(Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, ShareExtra shareExtra, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : shareExtra, (i & 256) == 0 ? num : null);
            }

            public final Boolean getActive() {
                return this.active;
            }

            public final String getActiveIcon() {
                return this.activeIcon;
            }

            public final String getActiveNightIcon() {
                return this.activeNightIcon;
            }

            public final String getDesc() {
                return this.desc;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getJumpUrl() {
                return this.jumpUrl;
            }

            public final String getNightIcon() {
                return this.nightIcon;
            }

            public final ShareExtra getShareExtra() {
                return this.shareExtra;
            }

            public final Integer getType() {
                return this.type;
            }
        }