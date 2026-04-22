package kntr.app.live.room.lolracerscore;

import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: LiveLPLPlayers.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lkntr/app/live/room/lolracerscore/LPLPlayers;", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.STATUS, "Lkntr/app/live/room/lolracerscore/PlayersStatus;", "currentBo", "Lkntr/app/live/room/lolracerscore/PlayersCurrentBo;", "<init>", "(Lkntr/app/live/room/lolracerscore/PlayersStatus;Lkntr/app/live/room/lolracerscore/PlayersCurrentBo;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/live/room/lolracerscore/PlayersStatus;Lkntr/app/live/room/lolracerscore/PlayersCurrentBo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStatus$annotations", "()V", "getStatus", "()Lkntr/app/live/room/lolracerscore/PlayersStatus;", "getCurrentBo$annotations", "getCurrentBo", "()Lkntr/app/live/room/lolracerscore/PlayersCurrentBo;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$lolracerscore_debug", "$serializer", "Companion", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class LPLPlayers {
    public static final Companion Companion = new Companion(null);
    private final PlayersCurrentBo currentBo;
    private final PlayersStatus status;

    public LPLPlayers() {
        this((PlayersStatus) null, (PlayersCurrentBo) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LPLPlayers copy$default(LPLPlayers lPLPlayers, PlayersStatus playersStatus, PlayersCurrentBo playersCurrentBo, int i, Object obj) {
        if ((i & 1) != 0) {
            playersStatus = lPLPlayers.status;
        }
        if ((i & 2) != 0) {
            playersCurrentBo = lPLPlayers.currentBo;
        }
        return lPLPlayers.copy(playersStatus, playersCurrentBo);
    }

    @SerialName("current_bo")
    public static /* synthetic */ void getCurrentBo$annotations() {
    }

    @SerialName(AdAlarmExtraKey.STATUS)
    public static /* synthetic */ void getStatus$annotations() {
    }

    public final PlayersStatus component1() {
        return this.status;
    }

    public final PlayersCurrentBo component2() {
        return this.currentBo;
    }

    public final LPLPlayers copy(PlayersStatus playersStatus, PlayersCurrentBo playersCurrentBo) {
        return new LPLPlayers(playersStatus, playersCurrentBo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LPLPlayers) {
            LPLPlayers lPLPlayers = (LPLPlayers) obj;
            return Intrinsics.areEqual(this.status, lPLPlayers.status) && Intrinsics.areEqual(this.currentBo, lPLPlayers.currentBo);
        }
        return false;
    }

    public int hashCode() {
        return ((this.status == null ? 0 : this.status.hashCode()) * 31) + (this.currentBo != null ? this.currentBo.hashCode() : 0);
    }

    public String toString() {
        PlayersStatus playersStatus = this.status;
        return "LPLPlayers(status=" + playersStatus + ", currentBo=" + this.currentBo + ")";
    }

    /* compiled from: LiveLPLPlayers.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/live/room/lolracerscore/LPLPlayers$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/live/room/lolracerscore/LPLPlayers;", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LPLPlayers> serializer() {
            return new GeneratedSerializer<LPLPlayers>() { // from class: kntr.app.live.room.lolracerscore.LPLPlayers$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.live.room.lolracerscore.LPLPlayers", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.live.room.lolracerscore.LPLPlayers> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.live.room.lolracerscore.LPLPlayers> A[REMOVE]) =  kntr.app.live.room.lolracerscore.LPLPlayers$$serializer.INSTANCE kntr.app.live.room.lolracerscore.LPLPlayers$$serializer)
                         in method: kntr.app.live.room.lolracerscore.LPLPlayers.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.live.room.lolracerscore.LPLPlayers>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                          ("kntr.app.live.room.lolracerscore.LPLPlayers")
                          (wrap: kntr.app.live.room.lolracerscore.LPLPlayers$$serializer : 0x0009: SGET  (r1v0 kntr.app.live.room.lolracerscore.LPLPlayers$$serializer A[REMOVE]) =  kntr.app.live.room.lolracerscore.LPLPlayers$$serializer.INSTANCE kntr.app.live.room.lolracerscore.LPLPlayers$$serializer)
                          (2 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.live.room.lolracerscore.LPLPlayers$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.live.room.lolracerscore.LPLPlayers$$serializer
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
                        kntr.app.live.room.lolracerscore.LPLPlayers$$serializer r0 = kntr.app.live.room.lolracerscore.LPLPlayers$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.live.room.lolracerscore.LPLPlayers.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ LPLPlayers(int seen0, PlayersStatus status, PlayersCurrentBo currentBo, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.status = null;
                } else {
                    this.status = status;
                }
                if ((seen0 & 2) == 0) {
                    this.currentBo = null;
                } else {
                    this.currentBo = currentBo;
                }
            }

            public LPLPlayers(PlayersStatus status, PlayersCurrentBo currentBo) {
                this.status = status;
                this.currentBo = currentBo;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$lolracerscore_debug(LPLPlayers self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.status != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, PlayersStatus$$serializer.INSTANCE, self.status);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.currentBo != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, PlayersCurrentBo$$serializer.INSTANCE, self.currentBo);
                }
            }

            public /* synthetic */ LPLPlayers(PlayersStatus playersStatus, PlayersCurrentBo playersCurrentBo, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : playersStatus, (i & 2) != 0 ? null : playersCurrentBo);
            }

            public final PlayersStatus getStatus() {
                return this.status;
            }

            public final PlayersCurrentBo getCurrentBo() {
                return this.currentBo;
            }
        }