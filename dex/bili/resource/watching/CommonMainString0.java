package bili.resource.watching;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bb\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0007R\u001b\u0010\"\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b#\u0010\u0007R\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b&\u0010\u0007R\u001b\u0010(\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b)\u0010\u0007R\u001b\u0010+\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b,\u0010\u0007R\u001b\u0010.\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b/\u0010\u0007R\u001b\u00101\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b2\u0010\u0007R\u001b\u00104\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\u0007R\u001b\u00107\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b8\u0010\u0007R\u001b\u0010:\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b;\u0010\u0007R\u001b\u0010=\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b>\u0010\u0007R\u001b\u0010@\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\bA\u0010\u0007R\u001b\u0010C\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bD\u0010\u0007R\u001b\u0010F\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bG\u0010\u0007R\u001b\u0010I\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\t\u001a\u0004\bJ\u0010\u0007R\u001b\u0010L\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\t\u001a\u0004\bM\u0010\u0007R\u001b\u0010O\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\t\u001a\u0004\bP\u0010\u0007R\u001b\u0010R\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\t\u001a\u0004\bS\u0010\u0007R\u001b\u0010U\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\t\u001a\u0004\bV\u0010\u0007R\u001b\u0010X\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\t\u001a\u0004\bY\u0010\u0007R\u001b\u0010[\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\t\u001a\u0004\b\\\u0010\u0007R\u001b\u0010^\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\t\u001a\u0004\b_\u0010\u0007R\u001b\u0010a\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\t\u001a\u0004\bb\u0010\u0007R\u001b\u0010d\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\t\u001a\u0004\be\u0010\u0007¨\u0006g"}, d2 = {"Lbili/resource/watching/CommonMainString0;", "", "<init>", "()V", "watching_global_string_1", "Lorg/jetbrains/compose/resources/StringResource;", "getWatching_global_string_1", "()Lorg/jetbrains/compose/resources/StringResource;", "watching_global_string_1$delegate", "Lkotlin/Lazy;", "watching_global_string_10", "getWatching_global_string_10", "watching_global_string_10$delegate", "watching_global_string_11", "getWatching_global_string_11", "watching_global_string_11$delegate", "watching_global_string_12", "getWatching_global_string_12", "watching_global_string_12$delegate", "watching_global_string_13", "getWatching_global_string_13", "watching_global_string_13$delegate", "watching_global_string_14", "getWatching_global_string_14", "watching_global_string_14$delegate", "watching_global_string_15", "getWatching_global_string_15", "watching_global_string_15$delegate", "watching_global_string_16", "getWatching_global_string_16", "watching_global_string_16$delegate", "watching_global_string_17", "getWatching_global_string_17", "watching_global_string_17$delegate", "watching_global_string_18", "getWatching_global_string_18", "watching_global_string_18$delegate", "watching_global_string_19", "getWatching_global_string_19", "watching_global_string_19$delegate", "watching_global_string_2", "getWatching_global_string_2", "watching_global_string_2$delegate", "watching_global_string_20", "getWatching_global_string_20", "watching_global_string_20$delegate", "watching_global_string_21", "getWatching_global_string_21", "watching_global_string_21$delegate", "watching_global_string_22", "getWatching_global_string_22", "watching_global_string_22$delegate", "watching_global_string_23", "getWatching_global_string_23", "watching_global_string_23$delegate", "watching_global_string_24", "getWatching_global_string_24", "watching_global_string_24$delegate", "watching_global_string_25", "getWatching_global_string_25", "watching_global_string_25$delegate", "watching_global_string_26", "getWatching_global_string_26", "watching_global_string_26$delegate", "watching_global_string_27", "getWatching_global_string_27", "watching_global_string_27$delegate", "watching_global_string_28", "getWatching_global_string_28", "watching_global_string_28$delegate", "watching_global_string_29", "getWatching_global_string_29", "watching_global_string_29$delegate", "watching_global_string_3", "getWatching_global_string_3", "watching_global_string_3$delegate", "watching_global_string_30", "getWatching_global_string_30", "watching_global_string_30$delegate", "watching_global_string_31", "getWatching_global_string_31", "watching_global_string_31$delegate", "watching_global_string_32", "getWatching_global_string_32", "watching_global_string_32$delegate", "watching_global_string_33", "getWatching_global_string_33", "watching_global_string_33$delegate", "watching_global_string_34", "getWatching_global_string_34", "watching_global_string_34$delegate", "watching_global_string_5", "getWatching_global_string_5", "watching_global_string_5$delegate", "watching_global_string_6", "getWatching_global_string_6", "watching_global_string_6$delegate", "watching_global_string_7", "getWatching_global_string_7", "watching_global_string_7$delegate", "watching_global_string_9", "getWatching_global_string_9", "watching_global_string_9$delegate", "watching_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class CommonMainString0 {
    public static final CommonMainString0 INSTANCE = new CommonMainString0();
    private static final Lazy watching_global_string_1$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda0
        public final Object invoke() {
            StringResource watching_global_string_1_delegate$lambda$0;
            watching_global_string_1_delegate$lambda$0 = CommonMainString0.watching_global_string_1_delegate$lambda$0();
            return watching_global_string_1_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_10$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda2
        public final Object invoke() {
            StringResource watching_global_string_10_delegate$lambda$0;
            watching_global_string_10_delegate$lambda$0 = CommonMainString0.watching_global_string_10_delegate$lambda$0();
            return watching_global_string_10_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_11$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda14
        public final Object invoke() {
            StringResource watching_global_string_11_delegate$lambda$0;
            watching_global_string_11_delegate$lambda$0 = CommonMainString0.watching_global_string_11_delegate$lambda$0();
            return watching_global_string_11_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_12$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda17
        public final Object invoke() {
            StringResource watching_global_string_12_delegate$lambda$0;
            watching_global_string_12_delegate$lambda$0 = CommonMainString0.watching_global_string_12_delegate$lambda$0();
            return watching_global_string_12_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_13$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda18
        public final Object invoke() {
            StringResource watching_global_string_13_delegate$lambda$0;
            watching_global_string_13_delegate$lambda$0 = CommonMainString0.watching_global_string_13_delegate$lambda$0();
            return watching_global_string_13_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_14$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda19
        public final Object invoke() {
            StringResource watching_global_string_14_delegate$lambda$0;
            watching_global_string_14_delegate$lambda$0 = CommonMainString0.watching_global_string_14_delegate$lambda$0();
            return watching_global_string_14_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_15$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda20
        public final Object invoke() {
            StringResource watching_global_string_15_delegate$lambda$0;
            watching_global_string_15_delegate$lambda$0 = CommonMainString0.watching_global_string_15_delegate$lambda$0();
            return watching_global_string_15_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_16$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda21
        public final Object invoke() {
            StringResource watching_global_string_16_delegate$lambda$0;
            watching_global_string_16_delegate$lambda$0 = CommonMainString0.watching_global_string_16_delegate$lambda$0();
            return watching_global_string_16_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_17$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda23
        public final Object invoke() {
            StringResource watching_global_string_17_delegate$lambda$0;
            watching_global_string_17_delegate$lambda$0 = CommonMainString0.watching_global_string_17_delegate$lambda$0();
            return watching_global_string_17_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_18$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda24
        public final Object invoke() {
            StringResource watching_global_string_18_delegate$lambda$0;
            watching_global_string_18_delegate$lambda$0 = CommonMainString0.watching_global_string_18_delegate$lambda$0();
            return watching_global_string_18_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_19$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda11
        public final Object invoke() {
            StringResource watching_global_string_19_delegate$lambda$0;
            watching_global_string_19_delegate$lambda$0 = CommonMainString0.watching_global_string_19_delegate$lambda$0();
            return watching_global_string_19_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_2$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda22
        public final Object invoke() {
            StringResource watching_global_string_2_delegate$lambda$0;
            watching_global_string_2_delegate$lambda$0 = CommonMainString0.watching_global_string_2_delegate$lambda$0();
            return watching_global_string_2_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_20$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda25
        public final Object invoke() {
            StringResource watching_global_string_20_delegate$lambda$0;
            watching_global_string_20_delegate$lambda$0 = CommonMainString0.watching_global_string_20_delegate$lambda$0();
            return watching_global_string_20_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_21$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda26
        public final Object invoke() {
            StringResource watching_global_string_21_delegate$lambda$0;
            watching_global_string_21_delegate$lambda$0 = CommonMainString0.watching_global_string_21_delegate$lambda$0();
            return watching_global_string_21_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_22$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda27
        public final Object invoke() {
            StringResource watching_global_string_22_delegate$lambda$0;
            watching_global_string_22_delegate$lambda$0 = CommonMainString0.watching_global_string_22_delegate$lambda$0();
            return watching_global_string_22_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_23$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda28
        public final Object invoke() {
            StringResource watching_global_string_23_delegate$lambda$0;
            watching_global_string_23_delegate$lambda$0 = CommonMainString0.watching_global_string_23_delegate$lambda$0();
            return watching_global_string_23_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_24$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda29
        public final Object invoke() {
            StringResource watching_global_string_24_delegate$lambda$0;
            watching_global_string_24_delegate$lambda$0 = CommonMainString0.watching_global_string_24_delegate$lambda$0();
            return watching_global_string_24_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_25$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda30
        public final Object invoke() {
            StringResource watching_global_string_25_delegate$lambda$0;
            watching_global_string_25_delegate$lambda$0 = CommonMainString0.watching_global_string_25_delegate$lambda$0();
            return watching_global_string_25_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_26$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda31
        public final Object invoke() {
            StringResource watching_global_string_26_delegate$lambda$0;
            watching_global_string_26_delegate$lambda$0 = CommonMainString0.watching_global_string_26_delegate$lambda$0();
            return watching_global_string_26_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_27$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda1
        public final Object invoke() {
            StringResource watching_global_string_27_delegate$lambda$0;
            watching_global_string_27_delegate$lambda$0 = CommonMainString0.watching_global_string_27_delegate$lambda$0();
            return watching_global_string_27_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_28$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda3
        public final Object invoke() {
            StringResource watching_global_string_28_delegate$lambda$0;
            watching_global_string_28_delegate$lambda$0 = CommonMainString0.watching_global_string_28_delegate$lambda$0();
            return watching_global_string_28_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_29$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda4
        public final Object invoke() {
            StringResource watching_global_string_29_delegate$lambda$0;
            watching_global_string_29_delegate$lambda$0 = CommonMainString0.watching_global_string_29_delegate$lambda$0();
            return watching_global_string_29_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_3$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda5
        public final Object invoke() {
            StringResource watching_global_string_3_delegate$lambda$0;
            watching_global_string_3_delegate$lambda$0 = CommonMainString0.watching_global_string_3_delegate$lambda$0();
            return watching_global_string_3_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_30$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda6
        public final Object invoke() {
            StringResource watching_global_string_30_delegate$lambda$0;
            watching_global_string_30_delegate$lambda$0 = CommonMainString0.watching_global_string_30_delegate$lambda$0();
            return watching_global_string_30_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_31$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda7
        public final Object invoke() {
            StringResource watching_global_string_31_delegate$lambda$0;
            watching_global_string_31_delegate$lambda$0 = CommonMainString0.watching_global_string_31_delegate$lambda$0();
            return watching_global_string_31_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_32$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda8
        public final Object invoke() {
            StringResource watching_global_string_32_delegate$lambda$0;
            watching_global_string_32_delegate$lambda$0 = CommonMainString0.watching_global_string_32_delegate$lambda$0();
            return watching_global_string_32_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_33$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda9
        public final Object invoke() {
            StringResource watching_global_string_33_delegate$lambda$0;
            watching_global_string_33_delegate$lambda$0 = CommonMainString0.watching_global_string_33_delegate$lambda$0();
            return watching_global_string_33_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_34$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda10
        public final Object invoke() {
            StringResource watching_global_string_34_delegate$lambda$0;
            watching_global_string_34_delegate$lambda$0 = CommonMainString0.watching_global_string_34_delegate$lambda$0();
            return watching_global_string_34_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_5$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda12
        public final Object invoke() {
            StringResource watching_global_string_5_delegate$lambda$0;
            watching_global_string_5_delegate$lambda$0 = CommonMainString0.watching_global_string_5_delegate$lambda$0();
            return watching_global_string_5_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_6$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda13
        public final Object invoke() {
            StringResource watching_global_string_6_delegate$lambda$0;
            watching_global_string_6_delegate$lambda$0 = CommonMainString0.watching_global_string_6_delegate$lambda$0();
            return watching_global_string_6_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_7$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda15
        public final Object invoke() {
            StringResource watching_global_string_7_delegate$lambda$0;
            watching_global_string_7_delegate$lambda$0 = CommonMainString0.watching_global_string_7_delegate$lambda$0();
            return watching_global_string_7_delegate$lambda$0;
        }
    });
    private static final Lazy watching_global_string_9$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.watching.CommonMainString0$$ExternalSyntheticLambda16
        public final Object invoke() {
            StringResource watching_global_string_9_delegate$lambda$0;
            watching_global_string_9_delegate$lambda$0 = CommonMainString0.watching_global_string_9_delegate$lambda$0();
            return watching_global_string_9_delegate$lambda$0;
        }
    });

    private CommonMainString0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_1_delegate$lambda$0() {
        StringResource init_watching_global_string_1;
        init_watching_global_string_1 = String0_commonMainKt.init_watching_global_string_1();
        return init_watching_global_string_1;
    }

    public final StringResource getWatching_global_string_1() {
        return (StringResource) watching_global_string_1$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_10_delegate$lambda$0() {
        StringResource init_watching_global_string_10;
        init_watching_global_string_10 = String0_commonMainKt.init_watching_global_string_10();
        return init_watching_global_string_10;
    }

    public final StringResource getWatching_global_string_10() {
        return (StringResource) watching_global_string_10$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_11_delegate$lambda$0() {
        StringResource init_watching_global_string_11;
        init_watching_global_string_11 = String0_commonMainKt.init_watching_global_string_11();
        return init_watching_global_string_11;
    }

    public final StringResource getWatching_global_string_11() {
        return (StringResource) watching_global_string_11$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_12_delegate$lambda$0() {
        StringResource init_watching_global_string_12;
        init_watching_global_string_12 = String0_commonMainKt.init_watching_global_string_12();
        return init_watching_global_string_12;
    }

    public final StringResource getWatching_global_string_12() {
        return (StringResource) watching_global_string_12$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_13_delegate$lambda$0() {
        StringResource init_watching_global_string_13;
        init_watching_global_string_13 = String0_commonMainKt.init_watching_global_string_13();
        return init_watching_global_string_13;
    }

    public final StringResource getWatching_global_string_13() {
        return (StringResource) watching_global_string_13$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_14_delegate$lambda$0() {
        StringResource init_watching_global_string_14;
        init_watching_global_string_14 = String0_commonMainKt.init_watching_global_string_14();
        return init_watching_global_string_14;
    }

    public final StringResource getWatching_global_string_14() {
        return (StringResource) watching_global_string_14$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_15_delegate$lambda$0() {
        StringResource init_watching_global_string_15;
        init_watching_global_string_15 = String0_commonMainKt.init_watching_global_string_15();
        return init_watching_global_string_15;
    }

    public final StringResource getWatching_global_string_15() {
        return (StringResource) watching_global_string_15$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_16_delegate$lambda$0() {
        StringResource init_watching_global_string_16;
        init_watching_global_string_16 = String0_commonMainKt.init_watching_global_string_16();
        return init_watching_global_string_16;
    }

    public final StringResource getWatching_global_string_16() {
        return (StringResource) watching_global_string_16$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_17_delegate$lambda$0() {
        StringResource init_watching_global_string_17;
        init_watching_global_string_17 = String0_commonMainKt.init_watching_global_string_17();
        return init_watching_global_string_17;
    }

    public final StringResource getWatching_global_string_17() {
        return (StringResource) watching_global_string_17$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_18_delegate$lambda$0() {
        StringResource init_watching_global_string_18;
        init_watching_global_string_18 = String0_commonMainKt.init_watching_global_string_18();
        return init_watching_global_string_18;
    }

    public final StringResource getWatching_global_string_18() {
        return (StringResource) watching_global_string_18$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_19_delegate$lambda$0() {
        StringResource init_watching_global_string_19;
        init_watching_global_string_19 = String0_commonMainKt.init_watching_global_string_19();
        return init_watching_global_string_19;
    }

    public final StringResource getWatching_global_string_19() {
        return (StringResource) watching_global_string_19$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_2_delegate$lambda$0() {
        StringResource init_watching_global_string_2;
        init_watching_global_string_2 = String0_commonMainKt.init_watching_global_string_2();
        return init_watching_global_string_2;
    }

    public final StringResource getWatching_global_string_2() {
        return (StringResource) watching_global_string_2$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_20_delegate$lambda$0() {
        StringResource init_watching_global_string_20;
        init_watching_global_string_20 = String0_commonMainKt.init_watching_global_string_20();
        return init_watching_global_string_20;
    }

    public final StringResource getWatching_global_string_20() {
        return (StringResource) watching_global_string_20$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_21_delegate$lambda$0() {
        StringResource init_watching_global_string_21;
        init_watching_global_string_21 = String0_commonMainKt.init_watching_global_string_21();
        return init_watching_global_string_21;
    }

    public final StringResource getWatching_global_string_21() {
        return (StringResource) watching_global_string_21$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_22_delegate$lambda$0() {
        StringResource init_watching_global_string_22;
        init_watching_global_string_22 = String0_commonMainKt.init_watching_global_string_22();
        return init_watching_global_string_22;
    }

    public final StringResource getWatching_global_string_22() {
        return (StringResource) watching_global_string_22$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_23_delegate$lambda$0() {
        StringResource init_watching_global_string_23;
        init_watching_global_string_23 = String0_commonMainKt.init_watching_global_string_23();
        return init_watching_global_string_23;
    }

    public final StringResource getWatching_global_string_23() {
        return (StringResource) watching_global_string_23$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_24_delegate$lambda$0() {
        StringResource init_watching_global_string_24;
        init_watching_global_string_24 = String0_commonMainKt.init_watching_global_string_24();
        return init_watching_global_string_24;
    }

    public final StringResource getWatching_global_string_24() {
        return (StringResource) watching_global_string_24$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_25_delegate$lambda$0() {
        StringResource init_watching_global_string_25;
        init_watching_global_string_25 = String0_commonMainKt.init_watching_global_string_25();
        return init_watching_global_string_25;
    }

    public final StringResource getWatching_global_string_25() {
        return (StringResource) watching_global_string_25$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_26_delegate$lambda$0() {
        StringResource init_watching_global_string_26;
        init_watching_global_string_26 = String0_commonMainKt.init_watching_global_string_26();
        return init_watching_global_string_26;
    }

    public final StringResource getWatching_global_string_26() {
        return (StringResource) watching_global_string_26$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_27_delegate$lambda$0() {
        StringResource init_watching_global_string_27;
        init_watching_global_string_27 = String0_commonMainKt.init_watching_global_string_27();
        return init_watching_global_string_27;
    }

    public final StringResource getWatching_global_string_27() {
        return (StringResource) watching_global_string_27$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_28_delegate$lambda$0() {
        StringResource init_watching_global_string_28;
        init_watching_global_string_28 = String0_commonMainKt.init_watching_global_string_28();
        return init_watching_global_string_28;
    }

    public final StringResource getWatching_global_string_28() {
        return (StringResource) watching_global_string_28$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_29_delegate$lambda$0() {
        StringResource init_watching_global_string_29;
        init_watching_global_string_29 = String0_commonMainKt.init_watching_global_string_29();
        return init_watching_global_string_29;
    }

    public final StringResource getWatching_global_string_29() {
        return (StringResource) watching_global_string_29$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_3_delegate$lambda$0() {
        StringResource init_watching_global_string_3;
        init_watching_global_string_3 = String0_commonMainKt.init_watching_global_string_3();
        return init_watching_global_string_3;
    }

    public final StringResource getWatching_global_string_3() {
        return (StringResource) watching_global_string_3$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_30_delegate$lambda$0() {
        StringResource init_watching_global_string_30;
        init_watching_global_string_30 = String0_commonMainKt.init_watching_global_string_30();
        return init_watching_global_string_30;
    }

    public final StringResource getWatching_global_string_30() {
        return (StringResource) watching_global_string_30$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_31_delegate$lambda$0() {
        StringResource init_watching_global_string_31;
        init_watching_global_string_31 = String0_commonMainKt.init_watching_global_string_31();
        return init_watching_global_string_31;
    }

    public final StringResource getWatching_global_string_31() {
        return (StringResource) watching_global_string_31$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_32_delegate$lambda$0() {
        StringResource init_watching_global_string_32;
        init_watching_global_string_32 = String0_commonMainKt.init_watching_global_string_32();
        return init_watching_global_string_32;
    }

    public final StringResource getWatching_global_string_32() {
        return (StringResource) watching_global_string_32$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_33_delegate$lambda$0() {
        StringResource init_watching_global_string_33;
        init_watching_global_string_33 = String0_commonMainKt.init_watching_global_string_33();
        return init_watching_global_string_33;
    }

    public final StringResource getWatching_global_string_33() {
        return (StringResource) watching_global_string_33$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_34_delegate$lambda$0() {
        StringResource init_watching_global_string_34;
        init_watching_global_string_34 = String0_commonMainKt.init_watching_global_string_34();
        return init_watching_global_string_34;
    }

    public final StringResource getWatching_global_string_34() {
        return (StringResource) watching_global_string_34$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_5_delegate$lambda$0() {
        StringResource init_watching_global_string_5;
        init_watching_global_string_5 = String0_commonMainKt.init_watching_global_string_5();
        return init_watching_global_string_5;
    }

    public final StringResource getWatching_global_string_5() {
        return (StringResource) watching_global_string_5$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_6_delegate$lambda$0() {
        StringResource init_watching_global_string_6;
        init_watching_global_string_6 = String0_commonMainKt.init_watching_global_string_6();
        return init_watching_global_string_6;
    }

    public final StringResource getWatching_global_string_6() {
        return (StringResource) watching_global_string_6$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_7_delegate$lambda$0() {
        StringResource init_watching_global_string_7;
        init_watching_global_string_7 = String0_commonMainKt.init_watching_global_string_7();
        return init_watching_global_string_7;
    }

    public final StringResource getWatching_global_string_7() {
        return (StringResource) watching_global_string_7$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource watching_global_string_9_delegate$lambda$0() {
        StringResource init_watching_global_string_9;
        init_watching_global_string_9 = String0_commonMainKt.init_watching_global_string_9();
        return init_watching_global_string_9;
    }

    public final StringResource getWatching_global_string_9() {
        return (StringResource) watching_global_string_9$delegate.getValue();
    }
}