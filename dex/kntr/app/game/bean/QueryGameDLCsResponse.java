package kntr.app.game.bean;

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

/* compiled from: SteamGameDLCBean.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Lkntr/app/game/bean/QueryGameDLCsResponse;", RoomRecommendViewModel.EMPTY_CURSOR, "code", RoomRecommendViewModel.EMPTY_CURSOR, "message", RoomRecommendViewModel.EMPTY_CURSOR, "data", "Lkntr/app/game/bean/GameDLCsData;", "<init>", "(ILjava/lang/String;Lkntr/app/game/bean/GameDLCsData;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Lkntr/app/game/bean/GameDLCsData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode$annotations", "()V", "getCode", "()I", "getMessage$annotations", "getMessage", "()Ljava/lang/String;", "getData$annotations", "getData", "()Lkntr/app/game/bean/GameDLCsData;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class QueryGameDLCsResponse {
    private final int code;
    private final GameDLCsData data;
    private final String message;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public QueryGameDLCsResponse() {
        this(0, (String) null, (GameDLCsData) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ QueryGameDLCsResponse copy$default(QueryGameDLCsResponse queryGameDLCsResponse, int i, String str, GameDLCsData gameDLCsData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = queryGameDLCsResponse.code;
        }
        if ((i2 & 2) != 0) {
            str = queryGameDLCsResponse.message;
        }
        if ((i2 & 4) != 0) {
            gameDLCsData = queryGameDLCsResponse.data;
        }
        return queryGameDLCsResponse.copy(i, str, gameDLCsData);
    }

    @SerialName("code")
    public static /* synthetic */ void getCode$annotations() {
    }

    @SerialName("data")
    public static /* synthetic */ void getData$annotations() {
    }

    @SerialName("message")
    public static /* synthetic */ void getMessage$annotations() {
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final GameDLCsData component3() {
        return this.data;
    }

    public final QueryGameDLCsResponse copy(int i, String str, GameDLCsData gameDLCsData) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new QueryGameDLCsResponse(i, str, gameDLCsData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QueryGameDLCsResponse) {
            QueryGameDLCsResponse queryGameDLCsResponse = (QueryGameDLCsResponse) obj;
            return this.code == queryGameDLCsResponse.code && Intrinsics.areEqual(this.message, queryGameDLCsResponse.message) && Intrinsics.areEqual(this.data, queryGameDLCsResponse.data);
        }
        return false;
    }

    public int hashCode() {
        return (((this.code * 31) + this.message.hashCode()) * 31) + (this.data == null ? 0 : this.data.hashCode());
    }

    public String toString() {
        int i = this.code;
        String str = this.message;
        return "QueryGameDLCsResponse(code=" + i + ", message=" + str + ", data=" + this.data + ")";
    }

    /* compiled from: SteamGameDLCBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/QueryGameDLCsResponse$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/QueryGameDLCsResponse;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<QueryGameDLCsResponse> serializer() {
            return new GeneratedSerializer<QueryGameDLCsResponse>() { // from class: kntr.app.game.bean.QueryGameDLCsResponse$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.bean.QueryGameDLCsResponse", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.game.bean.QueryGameDLCsResponse> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.game.bean.QueryGameDLCsResponse> A[REMOVE]) =  kntr.app.game.bean.QueryGameDLCsResponse$$serializer.INSTANCE kntr.app.game.bean.QueryGameDLCsResponse$$serializer)
                         in method: kntr.app.game.bean.QueryGameDLCsResponse.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.game.bean.QueryGameDLCsResponse>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                          ("kntr.app.game.bean.QueryGameDLCsResponse")
                          (wrap: kntr.app.game.bean.QueryGameDLCsResponse$$serializer : 0x0009: SGET  (r1v0 kntr.app.game.bean.QueryGameDLCsResponse$$serializer A[REMOVE]) =  kntr.app.game.bean.QueryGameDLCsResponse$$serializer.INSTANCE kntr.app.game.bean.QueryGameDLCsResponse$$serializer)
                          (3 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.game.bean.QueryGameDLCsResponse$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.game.bean.QueryGameDLCsResponse$$serializer
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
                        kntr.app.game.bean.QueryGameDLCsResponse$$serializer r0 = kntr.app.game.bean.QueryGameDLCsResponse$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.bean.QueryGameDLCsResponse.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ QueryGameDLCsResponse(int seen0, int code, String message, GameDLCsData data, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.code = 0;
                } else {
                    this.code = code;
                }
                if ((seen0 & 2) == 0) {
                    this.message = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.message = message;
                }
                if ((seen0 & 4) == 0) {
                    this.data = null;
                } else {
                    this.data = data;
                }
            }

            public QueryGameDLCsResponse(int code, String message, GameDLCsData data) {
                Intrinsics.checkNotNullParameter(message, "message");
                this.code = code;
                this.message = message;
                this.data = data;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$gamebiz_debug(QueryGameDLCsResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != 0) {
                    output.encodeIntElement(serialDesc, 0, self.code);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.message, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 1, self.message);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.data != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, GameDLCsData$$serializer.INSTANCE, self.data);
                }
            }

            public /* synthetic */ QueryGameDLCsResponse(int i, String str, GameDLCsData gameDLCsData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 4) != 0 ? null : gameDLCsData);
            }

            public final int getCode() {
                return this.code;
            }

            public final String getMessage() {
                return this.message;
            }

            public final GameDLCsData getData() {
                return this.data;
            }
        }