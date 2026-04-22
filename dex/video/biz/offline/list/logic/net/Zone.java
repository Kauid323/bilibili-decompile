package video.biz.offline.list.logic.net;

import ComposableSingletons$CustomBottomSheetKt$;
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
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IpTask.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002<=BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bBU\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003JO\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\rHÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001J%\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\b;R$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR&\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR&\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR&\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001b¨\u0006>"}, d2 = {"Lvideo/biz/offline/list/logic/net/Zone;", "", "id", "", "ip", "", "isp", "country", "province", "city", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "setId", "(J)V", "getIp$annotations", "getIp", "()Ljava/lang/String;", "setIp", "(Ljava/lang/String;)V", "getIsp$annotations", "getIsp", "setIsp", "getCountry$annotations", "getCountry", "setCountry", "getProvince$annotations", "getProvince", "setProvince", "getCity$annotations", "getCity", "setCity", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$logic_debug", "$serializer", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class Zone {
    private String city;
    private String country;
    private long id;
    private String ip;
    private String isp;
    private String province;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public Zone() {
        this(0L, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    @SerialName("city")
    public static /* synthetic */ void getCity$annotations() {
    }

    @SerialName("country")
    public static /* synthetic */ void getCountry$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("addr")
    public static /* synthetic */ void getIp$annotations() {
    }

    @SerialName("isp")
    public static /* synthetic */ void getIsp$annotations() {
    }

    @SerialName("province")
    public static /* synthetic */ void getProvince$annotations() {
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.ip;
    }

    public final String component3() {
        return this.isp;
    }

    public final String component4() {
        return this.country;
    }

    public final String component5() {
        return this.province;
    }

    public final String component6() {
        return this.city;
    }

    public final Zone copy(long j, String str, String str2, String str3, String str4, String str5) {
        return new Zone(j, str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Zone) {
            Zone zone = (Zone) obj;
            return this.id == zone.id && Intrinsics.areEqual(this.ip, zone.ip) && Intrinsics.areEqual(this.isp, zone.isp) && Intrinsics.areEqual(this.country, zone.country) && Intrinsics.areEqual(this.province, zone.province) && Intrinsics.areEqual(this.city, zone.city);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + (this.ip == null ? 0 : this.ip.hashCode())) * 31) + (this.isp == null ? 0 : this.isp.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.province == null ? 0 : this.province.hashCode())) * 31) + (this.city != null ? this.city.hashCode() : 0);
    }

    public String toString() {
        long j = this.id;
        String str = this.ip;
        String str2 = this.isp;
        String str3 = this.country;
        String str4 = this.province;
        return "Zone(id=" + j + ", ip=" + str + ", isp=" + str2 + ", country=" + str3 + ", province=" + str4 + ", city=" + this.city + ")";
    }

    /* compiled from: IpTask.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/list/logic/net/Zone$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/list/logic/net/Zone;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Zone> serializer() {
            return new GeneratedSerializer<Zone>() { // from class: video.biz.offline.list.logic.net.Zone$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.list.logic.net.Zone", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<video.biz.offline.list.logic.net.Zone> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<video.biz.offline.list.logic.net.Zone> A[REMOVE]) =  video.biz.offline.list.logic.net.Zone$$serializer.INSTANCE video.biz.offline.list.logic.net.Zone$$serializer)
                         in method: video.biz.offline.list.logic.net.Zone.Companion.serializer():kotlinx.serialization.KSerializer<video.biz.offline.list.logic.net.Zone>, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                          ("video.biz.offline.list.logic.net.Zone")
                          (wrap: video.biz.offline.list.logic.net.Zone$$serializer : 0x0009: SGET  (r1v0 video.biz.offline.list.logic.net.Zone$$serializer A[REMOVE]) =  video.biz.offline.list.logic.net.Zone$$serializer.INSTANCE video.biz.offline.list.logic.net.Zone$$serializer)
                          (6 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: video.biz.offline.list.logic.net.Zone$$serializer.<clinit>():void, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: video.biz.offline.list.logic.net.Zone$$serializer
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
                        video.biz.offline.list.logic.net.Zone$$serializer r0 = video.biz.offline.list.logic.net.Zone$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: video.biz.offline.list.logic.net.Zone.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ Zone(int seen0, long id, String ip, String isp, String country, String province, String city, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.id = 0L;
                } else {
                    this.id = id;
                }
                if ((seen0 & 2) == 0) {
                    this.ip = null;
                } else {
                    this.ip = ip;
                }
                if ((seen0 & 4) == 0) {
                    this.isp = null;
                } else {
                    this.isp = isp;
                }
                if ((seen0 & 8) == 0) {
                    this.country = null;
                } else {
                    this.country = country;
                }
                if ((seen0 & 16) == 0) {
                    this.province = null;
                } else {
                    this.province = province;
                }
                if ((seen0 & 32) == 0) {
                    this.city = null;
                } else {
                    this.city = city;
                }
            }

            public Zone(long id, String ip, String isp, String country, String province, String city) {
                this.id = id;
                this.ip = ip;
                this.isp = isp;
                this.country = country;
                this.province = province;
                this.city = city;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$logic_debug(Zone self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
                    output.encodeLongElement(serialDesc, 0, self.id);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.ip != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.ip);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isp != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.isp);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.country != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.country);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.province != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.province);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.city != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.city);
                }
            }

            public /* synthetic */ Zone(long j, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) == 0 ? str5 : null);
            }

            public final long getId() {
                return this.id;
            }

            public final void setId(long j) {
                this.id = j;
            }

            public final String getIp() {
                return this.ip;
            }

            public final void setIp(String str) {
                this.ip = str;
            }

            public final String getIsp() {
                return this.isp;
            }

            public final void setIsp(String str) {
                this.isp = str;
            }

            public final String getCountry() {
                return this.country;
            }

            public final void setCountry(String str) {
                this.country = str;
            }

            public final String getProvince() {
                return this.province;
            }

            public final void setProvince(String str) {
                this.province = str;
            }

            public final String getCity() {
                return this.city;
            }

            public final void setCity(String str) {
                this.city = str;
            }
        }