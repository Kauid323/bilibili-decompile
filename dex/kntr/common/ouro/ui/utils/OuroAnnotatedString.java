package kntr.common.ouro.ui.utils;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRangeKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroAnnotatedString.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001:\u0001'Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005HÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u0005HÆ\u0003Jk\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u00052\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0018HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lkntr/common/ouro/ui/utils/OuroAnnotatedString;", "", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "drawables", "", "Lkntr/common/ouro/ui/utils/CustomAnnotation;", "Lkntr/common/ouro/ui/utils/DrawableStyle;", "quotes", "Lkntr/common/ouro/ui/utils/QuoteStyle;", "listOrders", "Lkntr/common/ouro/ui/utils/ListOrderStyle;", "backgrounds", "Lkntr/common/ouro/ui/utils/BackgroundStyle;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getDrawables", "()Ljava/util/List;", "getQuotes", "getListOrders", "getBackgrounds", "length", "", "getLength", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "Builder", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroAnnotatedString {
    public static final int $stable = 8;
    private final AnnotatedString annotatedString;
    private final List<CustomAnnotation<BackgroundStyle>> backgrounds;
    private final List<CustomAnnotation<DrawableStyle>> drawables;
    private final List<CustomAnnotation<ListOrderStyle>> listOrders;
    private final List<CustomAnnotation<QuoteStyle>> quotes;

    public OuroAnnotatedString() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OuroAnnotatedString copy$default(OuroAnnotatedString ouroAnnotatedString, AnnotatedString annotatedString, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            annotatedString = ouroAnnotatedString.annotatedString;
        }
        List<CustomAnnotation<DrawableStyle>> list5 = list;
        if ((i & 2) != 0) {
            list5 = ouroAnnotatedString.drawables;
        }
        List list6 = list5;
        List<CustomAnnotation<QuoteStyle>> list7 = list2;
        if ((i & 4) != 0) {
            list7 = ouroAnnotatedString.quotes;
        }
        List list8 = list7;
        List<CustomAnnotation<ListOrderStyle>> list9 = list3;
        if ((i & 8) != 0) {
            list9 = ouroAnnotatedString.listOrders;
        }
        List list10 = list9;
        List<CustomAnnotation<BackgroundStyle>> list11 = list4;
        if ((i & 16) != 0) {
            list11 = ouroAnnotatedString.backgrounds;
        }
        return ouroAnnotatedString.copy(annotatedString, list6, list8, list10, list11);
    }

    public final AnnotatedString component1() {
        return this.annotatedString;
    }

    public final List<CustomAnnotation<DrawableStyle>> component2() {
        return this.drawables;
    }

    public final List<CustomAnnotation<QuoteStyle>> component3() {
        return this.quotes;
    }

    public final List<CustomAnnotation<ListOrderStyle>> component4() {
        return this.listOrders;
    }

    public final List<CustomAnnotation<BackgroundStyle>> component5() {
        return this.backgrounds;
    }

    public final OuroAnnotatedString copy(AnnotatedString annotatedString, List<CustomAnnotation<DrawableStyle>> list, List<CustomAnnotation<QuoteStyle>> list2, List<CustomAnnotation<ListOrderStyle>> list3, List<CustomAnnotation<BackgroundStyle>> list4) {
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(list, "drawables");
        Intrinsics.checkNotNullParameter(list2, "quotes");
        Intrinsics.checkNotNullParameter(list3, "listOrders");
        Intrinsics.checkNotNullParameter(list4, "backgrounds");
        return new OuroAnnotatedString(annotatedString, list, list2, list3, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroAnnotatedString) {
            OuroAnnotatedString ouroAnnotatedString = (OuroAnnotatedString) obj;
            return Intrinsics.areEqual(this.annotatedString, ouroAnnotatedString.annotatedString) && Intrinsics.areEqual(this.drawables, ouroAnnotatedString.drawables) && Intrinsics.areEqual(this.quotes, ouroAnnotatedString.quotes) && Intrinsics.areEqual(this.listOrders, ouroAnnotatedString.listOrders) && Intrinsics.areEqual(this.backgrounds, ouroAnnotatedString.backgrounds);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.annotatedString.hashCode() * 31) + this.drawables.hashCode()) * 31) + this.quotes.hashCode()) * 31) + this.listOrders.hashCode()) * 31) + this.backgrounds.hashCode();
    }

    public String toString() {
        AnnotatedString annotatedString = this.annotatedString;
        List<CustomAnnotation<DrawableStyle>> list = this.drawables;
        List<CustomAnnotation<QuoteStyle>> list2 = this.quotes;
        List<CustomAnnotation<ListOrderStyle>> list3 = this.listOrders;
        return "OuroAnnotatedString(annotatedString=" + annotatedString + ", drawables=" + list + ", quotes=" + list2 + ", listOrders=" + list3 + ", backgrounds=" + this.backgrounds + ")";
    }

    public OuroAnnotatedString(AnnotatedString annotatedString, List<CustomAnnotation<DrawableStyle>> list, List<CustomAnnotation<QuoteStyle>> list2, List<CustomAnnotation<ListOrderStyle>> list3, List<CustomAnnotation<BackgroundStyle>> list4) {
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(list, "drawables");
        Intrinsics.checkNotNullParameter(list2, "quotes");
        Intrinsics.checkNotNullParameter(list3, "listOrders");
        Intrinsics.checkNotNullParameter(list4, "backgrounds");
        this.annotatedString = annotatedString;
        this.drawables = list;
        this.quotes = list2;
        this.listOrders = list3;
        this.backgrounds = list4;
    }

    public /* synthetic */ OuroAnnotatedString(AnnotatedString annotatedString, List list, List list2, List list3, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AnnotatedString("", (List) null, 2, (DefaultConstructorMarker) null) : annotatedString, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? CollectionsKt.emptyList() : list3, (i & 16) != 0 ? CollectionsKt.emptyList() : list4);
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final List<CustomAnnotation<DrawableStyle>> getDrawables() {
        return this.drawables;
    }

    public final List<CustomAnnotation<QuoteStyle>> getQuotes() {
        return this.quotes;
    }

    public final List<CustomAnnotation<ListOrderStyle>> getListOrders() {
        return this.listOrders;
    }

    public final List<CustomAnnotation<BackgroundStyle>> getBackgrounds() {
        return this.backgrounds;
    }

    public final int getLength() {
        return this.annotatedString.length();
    }

    /* compiled from: OuroAnnotatedString.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u0005\u0012\u001e\b\u0002\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u0005¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0010J/\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00112\u0019\b\u0004\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\"¢\u0006\u0002\b#H\u0086\bø\u0001\u0000J;\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r2\u0019\b\u0004\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\"¢\u0006\u0002\b#H\u0086\bø\u0001\u0000J/\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020&2\u0019\b\u0004\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\"¢\u0006\u0002\b#H\u0086\bø\u0001\u0000J\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u0012H\u0002JD\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u0012*\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00122\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006,"}, d2 = {"Lkntr/common/ouro/ui/utils/OuroAnnotatedString$Builder;", "", "annotatedStringBuilder", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "drawables", "", "Lkntr/common/ouro/ui/utils/CustomAnnotation;", "Lkntr/common/ouro/ui/utils/DrawableStyle;", "quotes", "Lkntr/common/ouro/ui/utils/QuoteStyle;", "listOrders", "Lkntr/common/ouro/ui/utils/ListOrderStyle;", "backgrounds", "Lkntr/common/ouro/ui/utils/BackgroundStyle;", "annotationStack", "", "", "Lkntr/common/ouro/ui/utils/OuroCustomStyle;", "Lkntr/common/ouro/ui/utils/AnnotationMap;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "length", "", "getLength", "()I", "push", "", "annotations", "pop", "append", "string", "withStyle", "style", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/text/SpanStyle;", "backgroundStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "toAnnotatedString", "Lkntr/common/ouro/ui/utils/OuroAnnotatedString;", "currentAnnotations", "merge", "other", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Builder {
        public static final int $stable = 8;
        private final AnnotatedString.Builder annotatedStringBuilder;
        private final List<Map<String, OuroCustomStyle>> annotationStack;
        private final List<CustomAnnotation<BackgroundStyle>> backgrounds;
        private final List<CustomAnnotation<DrawableStyle>> drawables;
        private final List<CustomAnnotation<ListOrderStyle>> listOrders;
        private final List<CustomAnnotation<QuoteStyle>> quotes;

        public Builder(AnnotatedString.Builder annotatedStringBuilder, List<CustomAnnotation<DrawableStyle>> list, List<CustomAnnotation<QuoteStyle>> list2, List<CustomAnnotation<ListOrderStyle>> list3, List<CustomAnnotation<BackgroundStyle>> list4, List<Map<String, OuroCustomStyle>> list5) {
            Intrinsics.checkNotNullParameter(annotatedStringBuilder, "annotatedStringBuilder");
            Intrinsics.checkNotNullParameter(list, "drawables");
            Intrinsics.checkNotNullParameter(list2, "quotes");
            Intrinsics.checkNotNullParameter(list3, "listOrders");
            Intrinsics.checkNotNullParameter(list4, "backgrounds");
            Intrinsics.checkNotNullParameter(list5, "annotationStack");
            this.annotatedStringBuilder = annotatedStringBuilder;
            this.drawables = list;
            this.quotes = list2;
            this.listOrders = list3;
            this.backgrounds = list4;
            this.annotationStack = list5;
        }

        public /* synthetic */ Builder(AnnotatedString.Builder builder, List list, List list2, List list3, List list4, List list5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? new ArrayList() : list2, (i & 8) != 0 ? new ArrayList() : list3, (i & 16) != 0 ? new ArrayList() : list4, (i & 32) != 0 ? new ArrayList() : list5);
        }

        public final int getLength() {
            return this.annotatedStringBuilder.getLength();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void push(Map<String, ? extends OuroCustomStyle> map) {
            this.annotationStack.add(merge(currentAnnotations(), map));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void pop() {
            CollectionsKt.removeLastOrNull(this.annotationStack);
        }

        public final void append(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            this.annotatedStringBuilder.append(string);
        }

        public final void withStyle(OuroCustomStyle style, Function1<? super Builder, Unit> function1) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(function1, "action");
            push(MapsKt.mapOf(TuplesKt.to(style.getKey(), style)));
            int start = getLength();
            try {
                function1.invoke(this);
                InlineMarker.finallyStart(1);
                if (((OuroCustomStyle) currentAnnotations().get(style.getKey())) != null) {
                    int end = getLength();
                    if (style instanceof DrawableStyle) {
                        this.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start, end), style, null));
                    } else if (style instanceof QuoteStyle) {
                        this.quotes.add(new CustomAnnotation(TextRangeKt.TextRange(start, end), style, null));
                    } else if (style instanceof ListOrderStyle) {
                        this.listOrders.add(new CustomAnnotation(TextRangeKt.TextRange(start, end), style, null));
                    } else if (style instanceof BackgroundStyle) {
                        this.backgrounds.add(new CustomAnnotation(TextRangeKt.TextRange(start, end), style, null));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                pop();
                InlineMarker.finallyEnd(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                if (((OuroCustomStyle) currentAnnotations().get(style.getKey())) != null) {
                    int end2 = getLength();
                    if (style instanceof DrawableStyle) {
                        this.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start, end2), style, null));
                    } else if (style instanceof QuoteStyle) {
                        this.quotes.add(new CustomAnnotation(TextRangeKt.TextRange(start, end2), style, null));
                    } else if (style instanceof ListOrderStyle) {
                        this.listOrders.add(new CustomAnnotation(TextRangeKt.TextRange(start, end2), style, null));
                    } else if (style instanceof BackgroundStyle) {
                        this.backgrounds.add(new CustomAnnotation(TextRangeKt.TextRange(start, end2), style, null));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                pop();
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }

        public static /* synthetic */ void withStyle$default(Builder $this, SpanStyle style, BackgroundStyle backgroundStyle, Function1 action, int i, Object obj) {
            BackgroundStyle backgroundStyle2;
            int i2;
            if ((i & 2) == 0) {
                backgroundStyle2 = backgroundStyle;
            } else {
                backgroundStyle2 = null;
            }
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(action, "action");
            $this.annotatedStringBuilder.pushStyle(style);
            if (backgroundStyle2 != null) {
                try {
                    BackgroundStyle style$iv = backgroundStyle2;
                    $this.push(MapsKt.mapOf(TuplesKt.to(style$iv.getKey(), style$iv)));
                    int start$iv = $this.getLength();
                    action.invoke($this);
                    InlineMarker.finallyStart(1);
                    if (((OuroCustomStyle) $this.currentAnnotations().get(style$iv.getKey())) != null) {
                        int end$iv = $this.getLength();
                        if (style$iv instanceof DrawableStyle) {
                            $this.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv), style$iv, null));
                        } else if (style$iv instanceof QuoteStyle) {
                            $this.quotes.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv), style$iv, null));
                        } else if (style$iv instanceof ListOrderStyle) {
                            $this.listOrders.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv), style$iv, null));
                        } else if (!(style$iv instanceof BackgroundStyle)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            $this.backgrounds.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv), style$iv, null));
                        }
                    }
                    $this.pop();
                    InlineMarker.finallyEnd(1);
                } catch (Throwable th) {
                    th = th;
                    i2 = 1;
                    InlineMarker.finallyStart(i2);
                    $this.annotatedStringBuilder.pop();
                    InlineMarker.finallyEnd(i2);
                    throw th;
                }
            } else {
                try {
                    action.invoke($this);
                } catch (Throwable th2) {
                    th = th2;
                    i2 = 1;
                    InlineMarker.finallyStart(i2);
                    $this.annotatedStringBuilder.pop();
                    InlineMarker.finallyEnd(i2);
                    throw th;
                }
            }
            InlineMarker.finallyStart(1);
            $this.annotatedStringBuilder.pop();
            InlineMarker.finallyEnd(1);
        }

        public final void withStyle(SpanStyle style, BackgroundStyle backgroundStyle, Function1<? super Builder, Unit> function1) {
            BackgroundStyle style$iv;
            int start$iv;
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(function1, "action");
            this.annotatedStringBuilder.pushStyle(style);
            int i = 1;
            if (backgroundStyle != null) {
                try {
                    style$iv = backgroundStyle;
                    push(MapsKt.mapOf(TuplesKt.to(style$iv.getKey(), style$iv)));
                    start$iv = getLength();
                    function1.invoke(this);
                } catch (Throwable th) {
                    th = th;
                    i = 1;
                }
                try {
                    InlineMarker.finallyStart(1);
                    if (((OuroCustomStyle) currentAnnotations().get(style$iv.getKey())) != null) {
                        int end$iv = getLength();
                        if (style$iv instanceof DrawableStyle) {
                            this.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv), style$iv, null));
                        } else if (style$iv instanceof QuoteStyle) {
                            this.quotes.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv), style$iv, null));
                        } else if (style$iv instanceof ListOrderStyle) {
                            this.listOrders.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv), style$iv, null));
                        } else {
                            this.backgrounds.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv), style$iv, null));
                        }
                    }
                    pop();
                    InlineMarker.finallyEnd(1);
                } catch (Throwable th2) {
                    th = th2;
                    InlineMarker.finallyStart(i);
                    this.annotatedStringBuilder.pop();
                    InlineMarker.finallyEnd(i);
                    throw th;
                }
            } else {
                try {
                    function1.invoke(this);
                } catch (Throwable th3) {
                    th = th3;
                    i = 1;
                    InlineMarker.finallyStart(i);
                    this.annotatedStringBuilder.pop();
                    InlineMarker.finallyEnd(i);
                    throw th;
                }
            }
            InlineMarker.finallyStart(1);
            this.annotatedStringBuilder.pop();
            InlineMarker.finallyEnd(1);
        }

        public final void withStyle(ParagraphStyle style, Function1<? super Builder, Unit> function1) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(function1, "action");
            this.annotatedStringBuilder.pushStyle(style);
            try {
                function1.invoke(this);
            } finally {
                InlineMarker.finallyStart(1);
                this.annotatedStringBuilder.pop();
                InlineMarker.finallyEnd(1);
            }
        }

        public final OuroAnnotatedString toAnnotatedString() {
            return new OuroAnnotatedString(this.annotatedStringBuilder.toAnnotatedString(), CollectionsKt.toList(this.drawables), CollectionsKt.toList(this.quotes), CollectionsKt.toList(this.listOrders), CollectionsKt.toList(this.backgrounds));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, OuroCustomStyle> currentAnnotations() {
            Map<String, OuroCustomStyle> map = (Map) CollectionsKt.lastOrNull(this.annotationStack);
            return map == null ? MapsKt.emptyMap() : map;
        }

        private final Map<String, OuroCustomStyle> merge(Map<String, ? extends OuroCustomStyle> map, Map<String, ? extends OuroCustomStyle> map2) {
            Map $this$merge_u24lambda_u240 = MapsKt.toMutableMap(map);
            $this$merge_u24lambda_u240.putAll(map2);
            return $this$merge_u24lambda_u240;
        }
    }
}