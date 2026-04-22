package kntr.base.net.comm.flowcontrol.internal.backoff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
import kotlinx.serialization.json.Json;

/* compiled from: PathBackoff.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002)*B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/backoff/PathBackoff;", "", "path", "Lkntr/base/net/comm/flowcontrol/internal/backoff/PathRule;", "backoff", "Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig;", "<init>", "(Lkntr/base/net/comm/flowcontrol/internal/backoff/PathRule;Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/base/net/comm/flowcontrol/internal/backoff/PathRule;Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPath$annotations", "()V", "getPath", "()Lkntr/base/net/comm/flowcontrol/internal/backoff/PathRule;", "setPath", "(Lkntr/base/net/comm/flowcontrol/internal/backoff/PathRule;)V", "getBackoff$annotations", "getBackoff", "()Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig;", "setBackoff", "(Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$flow_control_debug", "Companion", "$serializer", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class PathBackoff {
    public static final Companion Companion = new Companion(null);
    private BackoffConfig backoff;
    private PathRule path;

    public PathBackoff() {
        this((PathRule) null, (BackoffConfig) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PathBackoff copy$default(PathBackoff pathBackoff, PathRule pathRule, BackoffConfig backoffConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            pathRule = pathBackoff.path;
        }
        if ((i & 2) != 0) {
            backoffConfig = pathBackoff.backoff;
        }
        return pathBackoff.copy(pathRule, backoffConfig);
    }

    @SerialName("backoff")
    public static /* synthetic */ void getBackoff$annotations() {
    }

    @SerialName("path")
    public static /* synthetic */ void getPath$annotations() {
    }

    public final PathRule component1() {
        return this.path;
    }

    public final BackoffConfig component2() {
        return this.backoff;
    }

    public final PathBackoff copy(PathRule pathRule, BackoffConfig backoffConfig) {
        Intrinsics.checkNotNullParameter(pathRule, "path");
        Intrinsics.checkNotNullParameter(backoffConfig, "backoff");
        return new PathBackoff(pathRule, backoffConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PathBackoff) {
            PathBackoff pathBackoff = (PathBackoff) obj;
            return Intrinsics.areEqual(this.path, pathBackoff.path) && Intrinsics.areEqual(this.backoff, pathBackoff.backoff);
        }
        return false;
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + this.backoff.hashCode();
    }

    public String toString() {
        PathRule pathRule = this.path;
        return "PathBackoff(path=" + pathRule + ", backoff=" + this.backoff + ")";
    }

    public /* synthetic */ PathBackoff(int seen0, PathRule path, BackoffConfig backoff, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.path = new PathRule((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        } else {
            this.path = path;
        }
        if ((seen0 & 2) == 0) {
            this.backoff = new BackoffConfig(0, 0, 0, 0.0f, 0.0f, 31, (DefaultConstructorMarker) null);
        } else {
            this.backoff = backoff;
        }
    }

    public PathBackoff(PathRule path, BackoffConfig backoff) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(backoff, "backoff");
        this.path = path;
        this.backoff = backoff;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$flow_control_debug(PathBackoff self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.path, new PathRule((String) null, (String) null, 3, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 0, PathRule$$serializer.INSTANCE, self.path);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.backoff, new BackoffConfig(0, 0, 0, 0.0f, 0.0f, 31, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 1, BackoffConfig$$serializer.INSTANCE, self.backoff);
        }
    }

    public /* synthetic */ PathBackoff(PathRule pathRule, BackoffConfig backoffConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new PathRule((String) null, (String) null, 3, (DefaultConstructorMarker) null) : pathRule, (i & 2) != 0 ? new BackoffConfig(0, 0, 0, 0.0f, 0.0f, 31, (DefaultConstructorMarker) null) : backoffConfig);
    }

    public final PathRule getPath() {
        return this.path;
    }

    public final void setPath(PathRule pathRule) {
        Intrinsics.checkNotNullParameter(pathRule, "<set-?>");
        this.path = pathRule;
    }

    public final BackoffConfig getBackoff() {
        return this.backoff;
    }

    public final void setBackoff(BackoffConfig backoffConfig) {
        Intrinsics.checkNotNullParameter(backoffConfig, "<set-?>");
        this.backoff = backoffConfig;
    }

    /* compiled from: PathBackoff.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¨\u0006\u000f"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/backoff/PathBackoff$Companion;", "", "<init>", "()V", "parse", "", "Lkntr/base/net/comm/flowcontrol/internal/backoff/PathBackoff;", RedirectImpKt.REDIRECT_KV_CONFIG, "", "matches", "host", "path", "rules", "serializer", "Lkotlinx/serialization/KSerializer;", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PathBackoff> serializer() {
            return new GeneratedSerializer<PathBackoff>() { // from class: kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff> A[REMOVE]) =  kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer.INSTANCE kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer)
                         in method: kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff.Companion.serializer():kotlinx.serialization.KSerializer<kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff")
                          (wrap: kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer : 0x0009: SGET  (r1v0 kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer A[REMOVE]) =  kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer.INSTANCE kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer)
                          (2 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer
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
                        kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer r0 = kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff.Companion.serializer():kotlinx.serialization.KSerializer");
                }

                public final List<PathBackoff> parse(String config) {
                    Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
                    try {
                        Json this_$iv = Json.Default;
                        this_$iv.getSerializersModule();
                        Iterable list = (List) this_$iv.decodeFromString(new ArrayListSerializer(PathBackoff.Companion.serializer()), config);
                        Iterable $this$filterNot$iv = list;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filterNot$iv) {
                            PathBackoff it = (PathBackoff) element$iv$iv;
                            if (!it.getPath().invalid()) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        return (List) destination$iv$iv;
                    } catch (Exception e) {
                        return null;
                    }
                }

                public final PathBackoff matches(String host, String path, List<PathBackoff> list) {
                    Object element$iv;
                    Intrinsics.checkNotNullParameter(host, "host");
                    Intrinsics.checkNotNullParameter(path, "path");
                    Intrinsics.checkNotNullParameter(list, "rules");
                    List<PathBackoff> $this$firstOrNull$iv = list;
                    Iterator<T> it = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            element$iv = it.next();
                            PathBackoff it2 = (PathBackoff) element$iv;
                            if (it2.getPath().matches(host, path)) {
                                break;
                            }
                        } else {
                            element$iv = null;
                            break;
                        }
                    }
                    return (PathBackoff) element$iv;
                }
            }
        }