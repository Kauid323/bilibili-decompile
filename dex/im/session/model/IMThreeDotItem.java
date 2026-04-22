package im.session.model;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KThreeDotItemType;
import com.bapis.bilibili.app.im.v1.KThreeDotItemTypeSerializer;
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
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: IMThreeDotItem.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\tHÂ\u0003J\u000e\u0010)\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b*JE\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u000eHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0013R\u0014\u0010\n\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001f¨\u0006:"}, d2 = {"Lim/session/model/IMThreeDotItem;", "", "title", "", "icon", "url", "type", "Lcom/bapis/bilibili/app/im/v1/KThreeDotItemType;", "hasRedDot_server", "", "isRedDotConsumed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KThreeDotItemType;ZZ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KThreeDotItemType;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "getIcon$annotations", "getIcon", "getUrl$annotations", "getUrl", "getType$annotations", "getType", "()Lcom/bapis/bilibili/app/im/v1/KThreeDotItemType;", "getHasRedDot_server$annotations", "isRedDotConsumed$session_debug", "()Z", "hasRedDot", "getHasRedDot", "hasRedDot_client", "getHasRedDot_client", "component1", "component2", "component3", "component4", "component5", "component6", "component6$session_debug", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$session_debug", "$serializer", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class IMThreeDotItem {
    public static final Companion Companion = new Companion(null);
    private final boolean hasRedDot_server;
    private final String icon;
    private final boolean isRedDotConsumed;
    private final String title;
    private final KThreeDotItemType type;
    private final String url;

    public IMThreeDotItem() {
        this((String) null, (String) null, (String) null, (KThreeDotItemType) null, false, false, 63, (DefaultConstructorMarker) null);
    }

    private final boolean component5() {
        return this.hasRedDot_server;
    }

    public static /* synthetic */ IMThreeDotItem copy$default(IMThreeDotItem iMThreeDotItem, String str, String str2, String str3, KThreeDotItemType kThreeDotItemType, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = iMThreeDotItem.title;
        }
        if ((i2 & 2) != 0) {
            str2 = iMThreeDotItem.icon;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = iMThreeDotItem.url;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            kThreeDotItemType = iMThreeDotItem.type;
        }
        KThreeDotItemType kThreeDotItemType2 = kThreeDotItemType;
        if ((i2 & 16) != 0) {
            z = iMThreeDotItem.hasRedDot_server;
        }
        boolean z3 = z;
        if ((i2 & 32) != 0) {
            z2 = iMThreeDotItem.isRedDotConsumed;
        }
        return iMThreeDotItem.copy(str, str4, str5, kThreeDotItemType2, z3, z2);
    }

    @ProtoNumber(number = 5)
    private static /* synthetic */ void getHasRedDot_server$annotations() {
    }

    @ProtoNumber(number = 2)
    public static /* synthetic */ void getIcon$annotations() {
    }

    @ProtoNumber(number = 1)
    public static /* synthetic */ void getTitle$annotations() {
    }

    @ProtoNumber(number = 4)
    public static /* synthetic */ void getType$annotations() {
    }

    @ProtoNumber(number = 3)
    public static /* synthetic */ void getUrl$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.url;
    }

    public final KThreeDotItemType component4() {
        return this.type;
    }

    public final boolean component6$session_debug() {
        return this.isRedDotConsumed;
    }

    public final IMThreeDotItem copy(String str, String str2, String str3, KThreeDotItemType kThreeDotItemType, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "icon");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(kThreeDotItemType, "type");
        return new IMThreeDotItem(str, str2, str3, kThreeDotItemType, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMThreeDotItem) {
            IMThreeDotItem iMThreeDotItem = (IMThreeDotItem) obj;
            return Intrinsics.areEqual(this.title, iMThreeDotItem.title) && Intrinsics.areEqual(this.icon, iMThreeDotItem.icon) && Intrinsics.areEqual(this.url, iMThreeDotItem.url) && Intrinsics.areEqual(this.type, iMThreeDotItem.type) && this.hasRedDot_server == iMThreeDotItem.hasRedDot_server && this.isRedDotConsumed == iMThreeDotItem.isRedDotConsumed;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.icon.hashCode()) * 31) + this.url.hashCode()) * 31) + this.type.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasRedDot_server)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRedDotConsumed);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.icon;
        String str3 = this.url;
        KThreeDotItemType kThreeDotItemType = this.type;
        boolean z = this.hasRedDot_server;
        return "IMThreeDotItem(title=" + str + ", icon=" + str2 + ", url=" + str3 + ", type=" + kThreeDotItemType + ", hasRedDot_server=" + z + ", isRedDotConsumed=" + this.isRedDotConsumed + ")";
    }

    /* compiled from: IMThreeDotItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/session/model/IMThreeDotItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/session/model/IMThreeDotItem;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IMThreeDotItem> serializer() {
            return new GeneratedSerializer<IMThreeDotItem>() { // from class: im.session.model.IMThreeDotItem$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("im.session.model.IMThreeDotItem", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<im.session.model.IMThreeDotItem> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<im.session.model.IMThreeDotItem> A[REMOVE]) =  im.session.model.IMThreeDotItem$$serializer.INSTANCE im.session.model.IMThreeDotItem$$serializer)
                         in method: im.session.model.IMThreeDotItem.Companion.serializer():kotlinx.serialization.KSerializer<im.session.model.IMThreeDotItem>, file: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex
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
                          ("im.session.model.IMThreeDotItem")
                          (wrap: im.session.model.IMThreeDotItem$$serializer : 0x0009: SGET  (r1v0 im.session.model.IMThreeDotItem$$serializer A[REMOVE]) =  im.session.model.IMThreeDotItem$$serializer.INSTANCE im.session.model.IMThreeDotItem$$serializer)
                          (6 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: im.session.model.IMThreeDotItem$$serializer.<clinit>():void, file: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: im.session.model.IMThreeDotItem$$serializer
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
                        im.session.model.IMThreeDotItem$$serializer r0 = im.session.model.IMThreeDotItem$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: im.session.model.IMThreeDotItem.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ IMThreeDotItem(int seen0, String title, String icon, String url, KThreeDotItemType type, boolean hasRedDot_server, boolean isRedDotConsumed, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.title = "";
                } else {
                    this.title = title;
                }
                if ((seen0 & 2) == 0) {
                    this.icon = "";
                } else {
                    this.icon = icon;
                }
                if ((seen0 & 4) == 0) {
                    this.url = "";
                } else {
                    this.url = url;
                }
                if ((seen0 & 8) == 0) {
                    this.type = KThreeDotItemType.Companion.fromValue(0);
                } else {
                    this.type = type;
                }
                if ((seen0 & 16) == 0) {
                    this.hasRedDot_server = false;
                } else {
                    this.hasRedDot_server = hasRedDot_server;
                }
                if ((seen0 & 32) == 0) {
                    this.isRedDotConsumed = false;
                } else {
                    this.isRedDotConsumed = isRedDotConsumed;
                }
            }

            public IMThreeDotItem(String title, String icon, String url, KThreeDotItemType type, boolean hasRedDot_server, boolean isRedDotConsumed) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(icon, "icon");
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(type, "type");
                this.title = title;
                this.icon = icon;
                this.url = url;
                this.type = type;
                this.hasRedDot_server = hasRedDot_server;
                this.isRedDotConsumed = isRedDotConsumed;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$session_debug(IMThreeDotItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.title, "")) {
                    output.encodeStringElement(serialDesc, 0, self.title);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.icon, "")) {
                    output.encodeStringElement(serialDesc, 1, self.icon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.url, "")) {
                    output.encodeStringElement(serialDesc, 2, self.url);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.type, KThreeDotItemType.Companion.fromValue(0))) {
                    output.encodeSerializableElement(serialDesc, 3, KThreeDotItemTypeSerializer.INSTANCE, self.type);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.hasRedDot_server) {
                    output.encodeBooleanElement(serialDesc, 4, self.hasRedDot_server);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isRedDotConsumed) {
                    output.encodeBooleanElement(serialDesc, 5, self.isRedDotConsumed);
                }
            }

            public /* synthetic */ IMThreeDotItem(String str, String str2, String str3, KThreeDotItemType kThreeDotItemType, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) == 0 ? str3 : "", (i2 & 8) != 0 ? KThreeDotItemType.Companion.fromValue(0) : kThreeDotItemType, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? false : z2);
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getUrl() {
                return this.url;
            }

            public final KThreeDotItemType getType() {
                return this.type;
            }

            public final boolean isRedDotConsumed$session_debug() {
                return this.isRedDotConsumed;
            }

            public final boolean getHasRedDot() {
                return (this.hasRedDot_server || getHasRedDot_client()) && !this.isRedDotConsumed;
            }

            private final boolean getHasRedDot_client() {
                return Intrinsics.areEqual(this.type, KThreeDotItemType.THREE_DOT_ITEM_TYPE_CONTRIBUTION_PUSH.INSTANCE) && !new ThreeDotPreference().getHasVisitPushMsg();
            }
        }