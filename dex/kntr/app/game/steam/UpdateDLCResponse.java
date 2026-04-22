package kntr.app.game.steam;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SteamGameVM.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lkntr/app/game/steam/UpdateDLCResponse;", RoomRecommendViewModel.EMPTY_CURSOR, "updateTime", RoomRecommendViewModel.EMPTY_CURSOR, "success", RoomRecommendViewModel.EMPTY_CURSOR, "message", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUpdateTime$annotations", "()V", "getUpdateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)Lkntr/app/game/steam/UpdateDLCResponse;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class UpdateDLCResponse {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String message;
    private final Boolean success;
    private final Long updateTime;

    public UpdateDLCResponse() {
        this((Long) null, (Boolean) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UpdateDLCResponse copy$default(UpdateDLCResponse updateDLCResponse, Long l, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = updateDLCResponse.updateTime;
        }
        if ((i & 2) != 0) {
            bool = updateDLCResponse.success;
        }
        if ((i & 4) != 0) {
            str = updateDLCResponse.message;
        }
        return updateDLCResponse.copy(l, bool, str);
    }

    @SerialName("update_time")
    public static /* synthetic */ void getUpdateTime$annotations() {
    }

    public final Long component1() {
        return this.updateTime;
    }

    public final Boolean component2() {
        return this.success;
    }

    public final String component3() {
        return this.message;
    }

    public final UpdateDLCResponse copy(Long l, Boolean bool, String str) {
        return new UpdateDLCResponse(l, bool, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdateDLCResponse) {
            UpdateDLCResponse updateDLCResponse = (UpdateDLCResponse) obj;
            return Intrinsics.areEqual(this.updateTime, updateDLCResponse.updateTime) && Intrinsics.areEqual(this.success, updateDLCResponse.success) && Intrinsics.areEqual(this.message, updateDLCResponse.message);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.updateTime == null ? 0 : this.updateTime.hashCode()) * 31) + (this.success == null ? 0 : this.success.hashCode())) * 31) + (this.message != null ? this.message.hashCode() : 0);
    }

    public String toString() {
        Long l = this.updateTime;
        Boolean bool = this.success;
        return "UpdateDLCResponse(updateTime=" + l + ", success=" + bool + ", message=" + this.message + ")";
    }

    /* compiled from: SteamGameVM.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/steam/UpdateDLCResponse$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/steam/UpdateDLCResponse;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UpdateDLCResponse> serializer() {
            return new GeneratedSerializer<UpdateDLCResponse>() { // from class: kntr.app.game.steam.UpdateDLCResponse$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.steam.UpdateDLCResponse", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.game.steam.UpdateDLCResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.game.steam.UpdateDLCResponse> A[REMOVE]) =  kntr.app.game.steam.UpdateDLCResponse$$serializer.INSTANCE kntr.app.game.steam.UpdateDLCResponse$$serializer)
                         in method: kntr.app.game.steam.UpdateDLCResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.game.steam.UpdateDLCResponse>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                          ("kntr.app.game.steam.UpdateDLCResponse")
                          (wrap: kntr.app.game.steam.UpdateDLCResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.game.steam.UpdateDLCResponse$$serializer A[REMOVE]) =  kntr.app.game.steam.UpdateDLCResponse$$serializer.INSTANCE kntr.app.game.steam.UpdateDLCResponse$$serializer)
                          (3 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.game.steam.UpdateDLCResponse$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.game.steam.UpdateDLCResponse$$serializer
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
                        kntr.app.game.steam.UpdateDLCResponse$$serializer r0 = kntr.app.game.steam.UpdateDLCResponse$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.steam.UpdateDLCResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ UpdateDLCResponse(int seen0, Long updateTime, Boolean success, String message, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.updateTime = null;
                } else {
                    this.updateTime = updateTime;
                }
                if ((seen0 & 2) == 0) {
                    this.success = null;
                } else {
                    this.success = success;
                }
                if ((seen0 & 4) == 0) {
                    this.message = null;
                } else {
                    this.message = message;
                }
            }

            public UpdateDLCResponse(Long updateTime, Boolean success, String message) {
                this.updateTime = updateTime;
                this.success = success;
                this.message = message;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$gamebiz_debug(UpdateDLCResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.updateTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.updateTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.success != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.success);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.message != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.message);
                }
            }

            public /* synthetic */ UpdateDLCResponse(Long l, Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str);
            }

            public final Long getUpdateTime() {
                return this.updateTime;
            }

            public final Boolean getSuccess() {
                return this.success;
            }

            public final String getMessage() {
                return this.message;
            }
        }