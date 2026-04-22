package kntr.app.im.chat.core.model;

import com.bapis.bilibili.app.im.v1.KNavButton;
import com.bapis.bilibili.app.im.v1.KNavButton$;
import com.bapis.bilibili.app.im.v1.KSessionTag;
import com.bapis.bilibili.app.im.v1.KSessionTagSerializer;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ChatInfo.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lkntr/app/im/chat/core/model/NavigationBar;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionName", RoomRecommendViewModel.EMPTY_CURSOR, "sessionHandle", "sessionTag", "Lcom/bapis/bilibili/app/im/v1/KSessionTag;", "navButton", "Lcom/bapis/bilibili/app/im/v1/KNavButton;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KSessionTag;Lcom/bapis/bilibili/app/im/v1/KNavButton;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KSessionTag;Lcom/bapis/bilibili/app/im/v1/KNavButton;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSessionName", "()Ljava/lang/String;", "getSessionHandle", "getSessionTag", "()Lcom/bapis/bilibili/app/im/v1/KSessionTag;", "getNavButton", "()Lcom/bapis/bilibili/app/im/v1/KNavButton;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class NavigationBar {
    private final KNavButton navButton;
    private final String sessionHandle;
    private final String sessionName;
    private final KSessionTag sessionTag;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public NavigationBar() {
        this((String) null, (String) null, (KSessionTag) null, (KNavButton) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NavigationBar copy$default(NavigationBar navigationBar, String str, String str2, KSessionTag kSessionTag, KNavButton kNavButton, int i, Object obj) {
        if ((i & 1) != 0) {
            str = navigationBar.sessionName;
        }
        if ((i & 2) != 0) {
            str2 = navigationBar.sessionHandle;
        }
        if ((i & 4) != 0) {
            kSessionTag = navigationBar.sessionTag;
        }
        if ((i & 8) != 0) {
            kNavButton = navigationBar.navButton;
        }
        return navigationBar.copy(str, str2, kSessionTag, kNavButton);
    }

    public final String component1() {
        return this.sessionName;
    }

    public final String component2() {
        return this.sessionHandle;
    }

    public final KSessionTag component3() {
        return this.sessionTag;
    }

    public final KNavButton component4() {
        return this.navButton;
    }

    public final NavigationBar copy(String str, String str2, KSessionTag kSessionTag, KNavButton kNavButton) {
        Intrinsics.checkNotNullParameter(str, "sessionName");
        return new NavigationBar(str, str2, kSessionTag, kNavButton);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NavigationBar) {
            NavigationBar navigationBar = (NavigationBar) obj;
            return Intrinsics.areEqual(this.sessionName, navigationBar.sessionName) && Intrinsics.areEqual(this.sessionHandle, navigationBar.sessionHandle) && Intrinsics.areEqual(this.sessionTag, navigationBar.sessionTag) && Intrinsics.areEqual(this.navButton, navigationBar.navButton);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.sessionName.hashCode() * 31) + (this.sessionHandle == null ? 0 : this.sessionHandle.hashCode())) * 31) + (this.sessionTag == null ? 0 : this.sessionTag.hashCode())) * 31) + (this.navButton != null ? this.navButton.hashCode() : 0);
    }

    public String toString() {
        String str = this.sessionName;
        String str2 = this.sessionHandle;
        KSessionTag kSessionTag = this.sessionTag;
        return "NavigationBar(sessionName=" + str + ", sessionHandle=" + str2 + ", sessionTag=" + kSessionTag + ", navButton=" + this.navButton + ")";
    }

    /* compiled from: ChatInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/core/model/NavigationBar$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/core/model/NavigationBar;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<NavigationBar> serializer() {
            return new GeneratedSerializer<NavigationBar>() { // from class: kntr.app.im.chat.core.model.NavigationBar$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.im.chat.core.model.NavigationBar", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.im.chat.core.model.NavigationBar> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.im.chat.core.model.NavigationBar> A[REMOVE]) =  kntr.app.im.chat.core.model.NavigationBar$$serializer.INSTANCE kntr.app.im.chat.core.model.NavigationBar$$serializer)
                         in method: kntr.app.im.chat.core.model.NavigationBar.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.im.chat.core.model.NavigationBar>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                          ("kntr.app.im.chat.core.model.NavigationBar")
                          (wrap: kntr.app.im.chat.core.model.NavigationBar$$serializer : 0x0009: SGET  (r1v0 kntr.app.im.chat.core.model.NavigationBar$$serializer A[REMOVE]) =  kntr.app.im.chat.core.model.NavigationBar$$serializer.INSTANCE kntr.app.im.chat.core.model.NavigationBar$$serializer)
                          (4 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.im.chat.core.model.NavigationBar$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.im.chat.core.model.NavigationBar$$serializer
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
                        kntr.app.im.chat.core.model.NavigationBar$$serializer r0 = kntr.app.im.chat.core.model.NavigationBar$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.im.chat.core.model.NavigationBar.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ NavigationBar(int seen0, String sessionName, String sessionHandle, KSessionTag sessionTag, KNavButton navButton, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.sessionName = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.sessionName = sessionName;
                }
                if ((seen0 & 2) == 0) {
                    this.sessionHandle = null;
                } else {
                    this.sessionHandle = sessionHandle;
                }
                if ((seen0 & 4) == 0) {
                    this.sessionTag = null;
                } else {
                    this.sessionTag = sessionTag;
                }
                if ((seen0 & 8) == 0) {
                    this.navButton = null;
                } else {
                    this.navButton = navButton;
                }
            }

            public NavigationBar(String sessionName, String sessionHandle, KSessionTag sessionTag, KNavButton navButton) {
                Intrinsics.checkNotNullParameter(sessionName, "sessionName");
                this.sessionName = sessionName;
                this.sessionHandle = sessionHandle;
                this.sessionTag = sessionTag;
                this.navButton = navButton;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$core_debug(NavigationBar self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.sessionName, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 0, self.sessionName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.sessionHandle != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.sessionHandle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.sessionTag != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, KSessionTagSerializer.INSTANCE, self.sessionTag);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.navButton != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, KNavButton$.serializer.INSTANCE, self.navButton);
                }
            }

            public /* synthetic */ NavigationBar(String str, String str2, KSessionTag kSessionTag, KNavButton kNavButton, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : kSessionTag, (i & 8) != 0 ? null : kNavButton);
            }

            public final String getSessionName() {
                return this.sessionName;
            }

            public final String getSessionHandle() {
                return this.sessionHandle;
            }

            public final KSessionTag getSessionTag() {
                return this.sessionTag;
            }

            public final KNavButton getNavButton() {
                return this.navButton;
            }
        }