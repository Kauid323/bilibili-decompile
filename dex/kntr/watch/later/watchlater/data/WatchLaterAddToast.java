package kntr.watch.later.watchlater.data;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: WatchLaterAddToast.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 >2\u00020\u0001:\u0002=>BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003JM\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\t\u00104\u001a\u00020\u0007HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R&\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R&\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 ¨\u0006?"}, d2 = {"Lkntr/watch/later/watchlater/data/WatchLaterAddToast;", "", "showToast", "", "iconType", "", "toast", "", "jumpText", "appJumpLink", "avids", "<init>", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShowToast$annotations", "()V", "getShowToast", "()Z", "setShowToast", "(Z)V", "getIconType$annotations", "getIconType", "()I", "setIconType", "(I)V", "getToast$annotations", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "getJumpText$annotations", "getJumpText", "setJumpText", "getAppJumpLink$annotations", "getAppJumpLink", "setAppJumpLink", "getAvids$annotations", "getAvids", "setAvids", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$watch_later_debug", "$serializer", "Companion", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class WatchLaterAddToast {
    private String appJumpLink;
    private String avids;
    private int iconType;
    private String jumpText;
    private boolean showToast;
    private String toast;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public WatchLaterAddToast() {
        this(false, 0, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WatchLaterAddToast copy$default(WatchLaterAddToast watchLaterAddToast, boolean z, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = watchLaterAddToast.showToast;
        }
        if ((i2 & 2) != 0) {
            i = watchLaterAddToast.iconType;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str = watchLaterAddToast.toast;
        }
        String str5 = str;
        if ((i2 & 8) != 0) {
            str2 = watchLaterAddToast.jumpText;
        }
        String str6 = str2;
        if ((i2 & 16) != 0) {
            str3 = watchLaterAddToast.appJumpLink;
        }
        String str7 = str3;
        if ((i2 & 32) != 0) {
            str4 = watchLaterAddToast.avids;
        }
        return watchLaterAddToast.copy(z, i3, str5, str6, str7, str4);
    }

    @SerialName("app_jump_link")
    public static /* synthetic */ void getAppJumpLink$annotations() {
    }

    @SerialName("avids")
    public static /* synthetic */ void getAvids$annotations() {
    }

    @SerialName("icon_type")
    public static /* synthetic */ void getIconType$annotations() {
    }

    @SerialName("jump_text")
    public static /* synthetic */ void getJumpText$annotations() {
    }

    @SerialName("show_toast")
    public static /* synthetic */ void getShowToast$annotations() {
    }

    @SerialName("toast")
    public static /* synthetic */ void getToast$annotations() {
    }

    public final boolean component1() {
        return this.showToast;
    }

    public final int component2() {
        return this.iconType;
    }

    public final String component3() {
        return this.toast;
    }

    public final String component4() {
        return this.jumpText;
    }

    public final String component5() {
        return this.appJumpLink;
    }

    public final String component6() {
        return this.avids;
    }

    public final WatchLaterAddToast copy(boolean z, int i, String str, String str2, String str3, String str4) {
        return new WatchLaterAddToast(z, i, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WatchLaterAddToast) {
            WatchLaterAddToast watchLaterAddToast = (WatchLaterAddToast) obj;
            return this.showToast == watchLaterAddToast.showToast && this.iconType == watchLaterAddToast.iconType && Intrinsics.areEqual(this.toast, watchLaterAddToast.toast) && Intrinsics.areEqual(this.jumpText, watchLaterAddToast.jumpText) && Intrinsics.areEqual(this.appJumpLink, watchLaterAddToast.appJumpLink) && Intrinsics.areEqual(this.avids, watchLaterAddToast.avids);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showToast) * 31) + this.iconType) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + (this.jumpText == null ? 0 : this.jumpText.hashCode())) * 31) + (this.appJumpLink == null ? 0 : this.appJumpLink.hashCode())) * 31) + (this.avids != null ? this.avids.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.showToast;
        int i = this.iconType;
        String str = this.toast;
        String str2 = this.jumpText;
        String str3 = this.appJumpLink;
        return "WatchLaterAddToast(showToast=" + z + ", iconType=" + i + ", toast=" + str + ", jumpText=" + str2 + ", appJumpLink=" + str3 + ", avids=" + this.avids + ")";
    }

    /* compiled from: WatchLaterAddToast.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/watch/later/watchlater/data/WatchLaterAddToast$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/watch/later/watchlater/data/WatchLaterAddToast;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WatchLaterAddToast> serializer() {
            return new GeneratedSerializer<WatchLaterAddToast>() { // from class: kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.watch.later.watchlater.data.WatchLaterAddToast", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.watch.later.watchlater.data.WatchLaterAddToast> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.watch.later.watchlater.data.WatchLaterAddToast> A[REMOVE]) =  kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer.INSTANCE kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer)
                         in method: kntr.watch.later.watchlater.data.WatchLaterAddToast.Companion.serializer():kotlinx.serialization.KSerializer<kntr.watch.later.watchlater.data.WatchLaterAddToast>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.watch.later.watchlater.data.WatchLaterAddToast")
                          (wrap: kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer : 0x0009: SGET  (r1v0 kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer A[REMOVE]) =  kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer.INSTANCE kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer)
                          (6 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer
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
                        kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer r0 = kntr.watch.later.watchlater.data.WatchLaterAddToast$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.watch.later.watchlater.data.WatchLaterAddToast.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ WatchLaterAddToast(int seen0, boolean showToast, int iconType, String toast, String jumpText, String appJumpLink, String avids, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.showToast = false;
                } else {
                    this.showToast = showToast;
                }
                if ((seen0 & 2) == 0) {
                    this.iconType = 0;
                } else {
                    this.iconType = iconType;
                }
                if ((seen0 & 4) == 0) {
                    this.toast = null;
                } else {
                    this.toast = toast;
                }
                if ((seen0 & 8) == 0) {
                    this.jumpText = null;
                } else {
                    this.jumpText = jumpText;
                }
                if ((seen0 & 16) == 0) {
                    this.appJumpLink = null;
                } else {
                    this.appJumpLink = appJumpLink;
                }
                if ((seen0 & 32) == 0) {
                    this.avids = null;
                } else {
                    this.avids = avids;
                }
            }

            public WatchLaterAddToast(boolean showToast, int iconType, String toast, String jumpText, String appJumpLink, String avids) {
                this.showToast = showToast;
                this.iconType = iconType;
                this.toast = toast;
                this.jumpText = jumpText;
                this.appJumpLink = appJumpLink;
                this.avids = avids;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$watch_later_debug(WatchLaterAddToast self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.showToast) {
                    output.encodeBooleanElement(serialDesc, 0, self.showToast);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.iconType != 0) {
                    output.encodeIntElement(serialDesc, 1, self.iconType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.toast != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.toast);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.jumpText != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.jumpText);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.appJumpLink != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.appJumpLink);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.avids != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.avids);
                }
            }

            public /* synthetic */ WatchLaterAddToast(boolean z, int i, String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? false : z, (i2 & 2) == 0 ? i : 0, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4);
            }

            public final boolean getShowToast() {
                return this.showToast;
            }

            public final void setShowToast(boolean z) {
                this.showToast = z;
            }

            public final int getIconType() {
                return this.iconType;
            }

            public final void setIconType(int i) {
                this.iconType = i;
            }

            public final String getToast() {
                return this.toast;
            }

            public final void setToast(String str) {
                this.toast = str;
            }

            public final String getJumpText() {
                return this.jumpText;
            }

            public final void setJumpText(String str) {
                this.jumpText = str;
            }

            public final String getAppJumpLink() {
                return this.appJumpLink;
            }

            public final void setAppJumpLink(String str) {
                this.appJumpLink = str;
            }

            public final String getAvids() {
                return this.avids;
            }

            public final void setAvids(String str) {
                this.avids = str;
            }
        }