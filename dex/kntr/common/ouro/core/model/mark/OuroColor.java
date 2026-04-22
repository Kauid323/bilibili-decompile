package kntr.common.ouro.core.model.mark;

import com.bilibili.compose.theme.ThemeDayNight;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroColor.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002()B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\nB5\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0007\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J'\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006*"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroColor;", "", "lightColor", "", "darkColor", "name", "", "<init>", "(IILjava/lang/String;)V", "", "(JJLjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLightColor", "()I", "getDarkColor", "getName", "()Ljava/lang/String;", "colorForTheme", "theme", "Lcom/bilibili/compose/theme/ThemeDayNight;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Companion", "$serializer", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroColor {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<Map<Pair<Integer, Integer>, OuroColor>> dayAndNightColorMap$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.mark.OuroColor$$ExternalSyntheticLambda0
        public final Object invoke() {
            Map dayAndNightColorMap_delegate$lambda$0;
            dayAndNightColorMap_delegate$lambda$0 = OuroColor.dayAndNightColorMap_delegate$lambda$0();
            return dayAndNightColorMap_delegate$lambda$0;
        }
    });
    private static final Lazy<Map<Integer, OuroColor>> dayColorMap$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.mark.OuroColor$$ExternalSyntheticLambda1
        public final Object invoke() {
            Map dayColorMap_delegate$lambda$0;
            dayColorMap_delegate$lambda$0 = OuroColor.dayColorMap_delegate$lambda$0();
            return dayColorMap_delegate$lambda$0;
        }
    });
    private final int darkColor;
    private final int lightColor;
    private final String name;

    /* compiled from: OuroColor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThemeDayNight.values().length];
            try {
                iArr[ThemeDayNight.Day.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ThemeDayNight.Night.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ OuroColor copy$default(OuroColor ouroColor, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ouroColor.lightColor;
        }
        if ((i3 & 2) != 0) {
            i2 = ouroColor.darkColor;
        }
        if ((i3 & 4) != 0) {
            str = ouroColor.name;
        }
        return ouroColor.copy(i, i2, str);
    }

    public final int component1() {
        return this.lightColor;
    }

    public final int component2() {
        return this.darkColor;
    }

    public final String component3() {
        return this.name;
    }

    public final OuroColor copy(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new OuroColor(i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroColor) {
            OuroColor ouroColor = (OuroColor) obj;
            return this.lightColor == ouroColor.lightColor && this.darkColor == ouroColor.darkColor && Intrinsics.areEqual(this.name, ouroColor.name);
        }
        return false;
    }

    public int hashCode() {
        return (((this.lightColor * 31) + this.darkColor) * 31) + this.name.hashCode();
    }

    public /* synthetic */ OuroColor(int seen0, int lightColor, int darkColor, String name, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen0 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, OuroColor$$serializer.INSTANCE.getDescriptor());
        }
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        this.name = name;
    }

    public OuroColor(int lightColor, int darkColor, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        this.name = name;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroColor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.lightColor);
        output.encodeIntElement(serialDesc, 1, self.darkColor);
        output.encodeStringElement(serialDesc, 2, self.name);
    }

    public final int getLightColor() {
        return this.lightColor;
    }

    public final int getDarkColor() {
        return this.darkColor;
    }

    public final String getName() {
        return this.name;
    }

    /* compiled from: OuroColor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u000204H\u0002J\u001a\u0010B\u001a\u0004\u0018\u00010\u00052\u0006\u0010C\u001a\u0002092\u0006\u0010D\u001a\u000209H\u0002J\u001e\u0010E\u001a\u00020\u00052\u0006\u0010C\u001a\u0002092\u0006\u0010D\u001a\u0002092\u0006\u0010A\u001a\u000204J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050GR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b1\u0010\u0007R \u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0005038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R3\u00107\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020908\u0012\u0004\u0012\u00020\u0005038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b:\u00106R'\u0010=\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0005038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b>\u00106¨\u0006H"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroColor$Companion;", "", "<init>", "()V", "Ga9", "Lkntr/common/ouro/core/model/mark/OuroColor;", "getGa9", "()Lkntr/common/ouro/core/model/mark/OuroColor;", "Ga7", "getGa7", "Ga5", "getGa5", "Ga3", "getGa3", "Ga1", "getGa1", "Pu6", "getPu6", "Re5", "getRe5", "Or5", "getOr5", "Ye5", "getYe5", "Gr5", "getGr5", "Lb5", "getLb5", "Lb7", "getLb7", "Lb2", "getLb2", "Ye2", "getYe2", "Pi2", "getPi2", "Gr2", "getGr2", "Or2", "getOr2", "Bl2", "getBl2", "Br2", "getBr2", "Si2", "getSi2", "Bg1", "getBg1", "Text4", "getText4", "allColorMap", "", "", "getAllColorMap", "()Ljava/util/Map;", "dayAndNightColorMap", "Lkotlin/Pair;", "", "getDayAndNightColorMap", "dayAndNightColorMap$delegate", "Lkotlin/Lazy;", "dayColorMap", "getDayColorMap", "dayColorMap$delegate", "getByName", "name", "getByDayAndNight", "dayColor", "nightColor", "create", "serializer", "Lkotlinx/serialization/KSerializer;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroColor> serializer() {
            return OuroColor$$serializer.INSTANCE;
        }

        public final OuroColor getGa9() {
            return new OuroColor(4281283128L, 4291875799L, "Ga9");
        }

        public final OuroColor getGa7() {
            return new OuroColor(4284573293L, 4288849838L, "Ga7");
        }

        public final OuroColor getGa5() {
            return new OuroColor(4287928736L, 4285889153L, "Ga5");
        }

        public final OuroColor getGa3() {
            return new OuroColor(4291415248L, 4282796365L, "Ga3");
        }

        public final OuroColor getGa1() {
            return new OuroColor(4294046451L, 4278848268L, "Ga1");
        }

        public final OuroColor getPu6() {
            return new OuroColor(4287583972L, 4288704229L, "Pu6");
        }

        public final OuroColor getRe5() {
            return new OuroColor(4294466132L, 4291903550L, "Re5");
        }

        public final OuroColor getOr5() {
            return new OuroColor(4294927898L, 4292957197L, "Or5");
        }

        public final OuroColor getYe5() {
            return new OuroColor(4294946855L, 4292577024L, "Ye5");
        }

        public final OuroColor getGr5() {
            return new OuroColor(4280993892L, 4280263249L, "Gr5");
        }

        public final OuroColor getLb5() {
            return new OuroColor(4278234860L, 4278224829L, "Lb5");
        }

        public final OuroColor getLb7() {
            return new OuroColor(4278217117L, 4284002772L, "Lb7");
        }

        public final OuroColor getLb2() {
            return new OuroColor(4290768378L, 4278725952L, "Lb2");
        }

        public final OuroColor getYe2() {
            return new OuroColor(4294962889L, 4283248651L, "Ye2");
        }

        public final OuroColor getPi2() {
            return new OuroColor(4294957540L, 4282851376L, "Pi2");
        }

        public final OuroColor getGr2() {
            return new OuroColor(4291490262L, 4279384355L, "Gr2");
        }

        public final OuroColor getOr2() {
            return new OuroColor(4294958278L, 4283244301L, "Or2");
        }

        public final OuroColor getBl2() {
            return new OuroColor(4292337663L, 4280231752L, "Bl2");
        }

        public final OuroColor getBr2() {
            return new OuroColor(4293912544L, 4281872170L, "Br2");
        }

        public final OuroColor getSi2() {
            return new OuroColor(4293652468L, 4281743679L, "Si2");
        }

        public final OuroColor getBg1() {
            return new OuroColor(4294967295L, 4279703578L, "Bg1");
        }

        public final OuroColor getText4() {
            return new OuroColor(4291415248L, 4282796365L, "Text4");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, OuroColor> getAllColorMap() {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("Ga9", getGa9()), TuplesKt.to("Ga7", getGa7()), TuplesKt.to("Ga5", getGa5()), TuplesKt.to("Ga3", getGa3()), TuplesKt.to("Pu6", getPu6()), TuplesKt.to("Re5", getRe5()), TuplesKt.to("Or5", getOr5()), TuplesKt.to("Ye5", getYe5()), TuplesKt.to("Gr5", getGr5()), TuplesKt.to("Lb5", getLb5()), TuplesKt.to("Lb7", getLb7()), TuplesKt.to("Lb2", getLb2()), TuplesKt.to("Ye2", getYe2()), TuplesKt.to("Pi2", getPi2()), TuplesKt.to("Gr2", getGr2()), TuplesKt.to("Or2", getOr2()), TuplesKt.to("Bl2", getBl2()), TuplesKt.to("Br2", getBr2()), TuplesKt.to("Si2", getSi2())});
        }

        private final Map<Pair<Integer, Integer>, OuroColor> getDayAndNightColorMap() {
            return (Map) OuroColor.dayAndNightColorMap$delegate.getValue();
        }

        private final Map<Integer, OuroColor> getDayColorMap() {
            return (Map) OuroColor.dayColorMap$delegate.getValue();
        }

        private final OuroColor getByName(String name) {
            return getAllColorMap().get(name);
        }

        private final OuroColor getByDayAndNight(int dayColor, int nightColor) {
            return getDayAndNightColorMap().get(TuplesKt.to(Integer.valueOf(dayColor), Integer.valueOf(nightColor)));
        }

        public final OuroColor create(int dayColor, int nightColor, String name) {
            OuroColor colorByDay;
            Intrinsics.checkNotNullParameter(name, "name");
            OuroColor colorByName = getByName(name);
            if (colorByName != null) {
                return colorByName;
            }
            if (name.length() > 0) {
                return new OuroColor(dayColor, nightColor, name);
            }
            OuroColor colorByDayAndNight = getByDayAndNight(dayColor, nightColor);
            if (colorByDayAndNight != null) {
                return colorByDayAndNight;
            }
            if (dayColor == nightColor && (colorByDay = getDayColorMap().get(Integer.valueOf(dayColor))) != null) {
                return colorByDay;
            }
            return new OuroColor(dayColor, nightColor, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map dayAndNightColorMap_delegate$lambda$0() {
        Iterable $this$associate$iv = Companion.getAllColorMap().entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Map.Entry entry = (Map.Entry) element$iv$iv;
            String str = (String) entry.getKey();
            OuroColor color = (OuroColor) entry.getValue();
            Pair pair = TuplesKt.to(new Pair(Integer.valueOf(color.lightColor), Integer.valueOf(color.darkColor)), color);
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map dayColorMap_delegate$lambda$0() {
        Iterable $this$associate$iv = Companion.getAllColorMap().entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Map.Entry entry = (Map.Entry) element$iv$iv;
            String str = (String) entry.getKey();
            OuroColor color = (OuroColor) entry.getValue();
            Pair pair = TuplesKt.to(Integer.valueOf(color.lightColor), color);
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroColor(long lightColor, long darkColor, String name) {
        this((int) lightColor, (int) darkColor, name);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public final int colorForTheme(ThemeDayNight theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        switch (WhenMappings.$EnumSwitchMapping$0[theme.ordinal()]) {
            case 1:
                return this.lightColor;
            case 2:
                return this.darkColor;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public String toString() {
        String num = Integer.toString(this.lightColor, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        String upperCase = num.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String num2 = Integer.toString(this.darkColor, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
        String upperCase2 = num2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        return upperCase + " - " + upperCase2 + " - " + this.name;
    }
}