package bili.resource.history;

import com.bilibili.upper.BR;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bw\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0007R\u001b\u0010\"\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b#\u0010\u0007R\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b&\u0010\u0007R\u001b\u0010(\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b)\u0010\u0007R\u001b\u0010+\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b,\u0010\u0007R\u001b\u0010.\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b/\u0010\u0007R\u001b\u00101\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b2\u0010\u0007R\u001b\u00104\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\u0007R\u001b\u00107\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b8\u0010\u0007R\u001b\u0010:\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b;\u0010\u0007R\u001b\u0010=\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b>\u0010\u0007R\u001b\u0010@\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\bA\u0010\u0007R\u001b\u0010C\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bD\u0010\u0007R\u001b\u0010F\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bG\u0010\u0007R\u001b\u0010I\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\t\u001a\u0004\bJ\u0010\u0007R\u001b\u0010L\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\t\u001a\u0004\bM\u0010\u0007R\u001b\u0010O\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\t\u001a\u0004\bP\u0010\u0007R\u001b\u0010R\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\t\u001a\u0004\bS\u0010\u0007R\u001b\u0010U\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\t\u001a\u0004\bV\u0010\u0007R\u001b\u0010X\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\t\u001a\u0004\bY\u0010\u0007R\u001b\u0010[\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\t\u001a\u0004\b\\\u0010\u0007R\u001b\u0010^\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\t\u001a\u0004\b_\u0010\u0007R\u001b\u0010a\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\t\u001a\u0004\bb\u0010\u0007R\u001b\u0010d\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\t\u001a\u0004\be\u0010\u0007R\u001b\u0010g\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\t\u001a\u0004\bh\u0010\u0007R\u001b\u0010j\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u0010\t\u001a\u0004\bk\u0010\u0007R\u001b\u0010m\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\t\u001a\u0004\bn\u0010\u0007R\u001b\u0010p\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\br\u0010\t\u001a\u0004\bq\u0010\u0007R\u001b\u0010s\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\t\u001a\u0004\bt\u0010\u0007R\u001b\u0010v\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\t\u001a\u0004\bw\u0010\u0007R\u001b\u0010y\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\t\u001a\u0004\bz\u0010\u0007¨\u0006|"}, d2 = {"Lbili/resource/history/CommonMainString0;", "", "<init>", "()V", "history_global_string_1", "Lorg/jetbrains/compose/resources/StringResource;", "getHistory_global_string_1", "()Lorg/jetbrains/compose/resources/StringResource;", "history_global_string_1$delegate", "Lkotlin/Lazy;", "history_global_string_10", "getHistory_global_string_10", "history_global_string_10$delegate", "history_global_string_11", "getHistory_global_string_11", "history_global_string_11$delegate", "history_global_string_13", "getHistory_global_string_13", "history_global_string_13$delegate", "history_global_string_14", "getHistory_global_string_14", "history_global_string_14$delegate", "history_global_string_17", "getHistory_global_string_17", "history_global_string_17$delegate", "history_global_string_18", "getHistory_global_string_18", "history_global_string_18$delegate", "history_global_string_19", "getHistory_global_string_19", "history_global_string_19$delegate", "history_global_string_2", "getHistory_global_string_2", "history_global_string_2$delegate", "history_global_string_20", "getHistory_global_string_20", "history_global_string_20$delegate", "history_global_string_21", "getHistory_global_string_21", "history_global_string_21$delegate", "history_global_string_22", "getHistory_global_string_22", "history_global_string_22$delegate", "history_global_string_23", "getHistory_global_string_23", "history_global_string_23$delegate", "history_global_string_24", "getHistory_global_string_24", "history_global_string_24$delegate", "history_global_string_25", "getHistory_global_string_25", "history_global_string_25$delegate", "history_global_string_26", "getHistory_global_string_26", "history_global_string_26$delegate", "history_global_string_27", "getHistory_global_string_27", "history_global_string_27$delegate", "history_global_string_28", "getHistory_global_string_28", "history_global_string_28$delegate", "history_global_string_3", "getHistory_global_string_3", "history_global_string_3$delegate", "history_global_string_32", "getHistory_global_string_32", "history_global_string_32$delegate", "history_global_string_34", "getHistory_global_string_34", "history_global_string_34$delegate", "history_global_string_35", "getHistory_global_string_35", "history_global_string_35$delegate", "history_global_string_37", "getHistory_global_string_37", "history_global_string_37$delegate", "history_global_string_39", "getHistory_global_string_39", "history_global_string_39$delegate", "history_global_string_4", "getHistory_global_string_4", "history_global_string_4$delegate", "history_global_string_40", "getHistory_global_string_40", "history_global_string_40$delegate", "history_global_string_41", "getHistory_global_string_41", "history_global_string_41$delegate", "history_global_string_42", "getHistory_global_string_42", "history_global_string_42$delegate", "history_global_string_43", "getHistory_global_string_43", "history_global_string_43$delegate", "history_global_string_44", "getHistory_global_string_44", "history_global_string_44$delegate", "history_global_string_45", "getHistory_global_string_45", "history_global_string_45$delegate", "history_global_string_46", "getHistory_global_string_46", "history_global_string_46$delegate", "history_global_string_47", "getHistory_global_string_47", "history_global_string_47$delegate", "history_global_string_48", "getHistory_global_string_48", "history_global_string_48$delegate", "history_global_string_5", "getHistory_global_string_5", "history_global_string_5$delegate", "history_global_string_6", "getHistory_global_string_6", "history_global_string_6$delegate", "history_global_string_7", "getHistory_global_string_7", "history_global_string_7$delegate", "history_global_string_8", "getHistory_global_string_8", "history_global_string_8$delegate", "history_global_string_9", "getHistory_global_string_9", "history_global_string_9$delegate", "history_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainString0 {
    public static final CommonMainString0 INSTANCE = new CommonMainString0();
    private static final Lazy history_global_string_1$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda0
        public final Object invoke() {
            StringResource history_global_string_1_delegate$lambda$0;
            history_global_string_1_delegate$lambda$0 = CommonMainString0.history_global_string_1_delegate$lambda$0();
            return history_global_string_1_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_10$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda2
        public final Object invoke() {
            StringResource history_global_string_10_delegate$lambda$0;
            history_global_string_10_delegate$lambda$0 = CommonMainString0.history_global_string_10_delegate$lambda$0();
            return history_global_string_10_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_11$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda14
        public final Object invoke() {
            StringResource history_global_string_11_delegate$lambda$0;
            history_global_string_11_delegate$lambda$0 = CommonMainString0.history_global_string_11_delegate$lambda$0();
            return history_global_string_11_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_13$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda25
        public final Object invoke() {
            StringResource history_global_string_13_delegate$lambda$0;
            history_global_string_13_delegate$lambda$0 = CommonMainString0.history_global_string_13_delegate$lambda$0();
            return history_global_string_13_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_14$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda26
        public final Object invoke() {
            StringResource history_global_string_14_delegate$lambda$0;
            history_global_string_14_delegate$lambda$0 = CommonMainString0.history_global_string_14_delegate$lambda$0();
            return history_global_string_14_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_17$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda27
        public final Object invoke() {
            StringResource history_global_string_17_delegate$lambda$0;
            history_global_string_17_delegate$lambda$0 = CommonMainString0.history_global_string_17_delegate$lambda$0();
            return history_global_string_17_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_18$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda28
        public final Object invoke() {
            StringResource history_global_string_18_delegate$lambda$0;
            history_global_string_18_delegate$lambda$0 = CommonMainString0.history_global_string_18_delegate$lambda$0();
            return history_global_string_18_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_19$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda29
        public final Object invoke() {
            StringResource history_global_string_19_delegate$lambda$0;
            history_global_string_19_delegate$lambda$0 = CommonMainString0.history_global_string_19_delegate$lambda$0();
            return history_global_string_19_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_2$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda30
        public final Object invoke() {
            StringResource history_global_string_2_delegate$lambda$0;
            history_global_string_2_delegate$lambda$0 = CommonMainString0.history_global_string_2_delegate$lambda$0();
            return history_global_string_2_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_20$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda31
        public final Object invoke() {
            StringResource history_global_string_20_delegate$lambda$0;
            history_global_string_20_delegate$lambda$0 = CommonMainString0.history_global_string_20_delegate$lambda$0();
            return history_global_string_20_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_21$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda11
        public final Object invoke() {
            StringResource history_global_string_21_delegate$lambda$0;
            history_global_string_21_delegate$lambda$0 = CommonMainString0.history_global_string_21_delegate$lambda$0();
            return history_global_string_21_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_22$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda22
        public final Object invoke() {
            StringResource history_global_string_22_delegate$lambda$0;
            history_global_string_22_delegate$lambda$0 = CommonMainString0.history_global_string_22_delegate$lambda$0();
            return history_global_string_22_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_23$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda32
        public final Object invoke() {
            StringResource history_global_string_23_delegate$lambda$0;
            history_global_string_23_delegate$lambda$0 = CommonMainString0.history_global_string_23_delegate$lambda$0();
            return history_global_string_23_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_24$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda33
        public final Object invoke() {
            StringResource history_global_string_24_delegate$lambda$0;
            history_global_string_24_delegate$lambda$0 = CommonMainString0.history_global_string_24_delegate$lambda$0();
            return history_global_string_24_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_25$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda34
        public final Object invoke() {
            StringResource history_global_string_25_delegate$lambda$0;
            history_global_string_25_delegate$lambda$0 = CommonMainString0.history_global_string_25_delegate$lambda$0();
            return history_global_string_25_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_26$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda35
        public final Object invoke() {
            StringResource history_global_string_26_delegate$lambda$0;
            history_global_string_26_delegate$lambda$0 = CommonMainString0.history_global_string_26_delegate$lambda$0();
            return history_global_string_26_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_27$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda36
        public final Object invoke() {
            StringResource history_global_string_27_delegate$lambda$0;
            history_global_string_27_delegate$lambda$0 = CommonMainString0.history_global_string_27_delegate$lambda$0();
            return history_global_string_27_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_28$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda37
        public final Object invoke() {
            StringResource history_global_string_28_delegate$lambda$0;
            history_global_string_28_delegate$lambda$0 = CommonMainString0.history_global_string_28_delegate$lambda$0();
            return history_global_string_28_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_3$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda38
        public final Object invoke() {
            StringResource history_global_string_3_delegate$lambda$0;
            history_global_string_3_delegate$lambda$0 = CommonMainString0.history_global_string_3_delegate$lambda$0();
            return history_global_string_3_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_32$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda1
        public final Object invoke() {
            StringResource history_global_string_32_delegate$lambda$0;
            history_global_string_32_delegate$lambda$0 = CommonMainString0.history_global_string_32_delegate$lambda$0();
            return history_global_string_32_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_34$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda3
        public final Object invoke() {
            StringResource history_global_string_34_delegate$lambda$0;
            history_global_string_34_delegate$lambda$0 = CommonMainString0.history_global_string_34_delegate$lambda$0();
            return history_global_string_34_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_35$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda4
        public final Object invoke() {
            StringResource history_global_string_35_delegate$lambda$0;
            history_global_string_35_delegate$lambda$0 = CommonMainString0.history_global_string_35_delegate$lambda$0();
            return history_global_string_35_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_37$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda5
        public final Object invoke() {
            StringResource history_global_string_37_delegate$lambda$0;
            history_global_string_37_delegate$lambda$0 = CommonMainString0.history_global_string_37_delegate$lambda$0();
            return history_global_string_37_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_39$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda6
        public final Object invoke() {
            StringResource history_global_string_39_delegate$lambda$0;
            history_global_string_39_delegate$lambda$0 = CommonMainString0.history_global_string_39_delegate$lambda$0();
            return history_global_string_39_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_4$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda7
        public final Object invoke() {
            StringResource history_global_string_4_delegate$lambda$0;
            history_global_string_4_delegate$lambda$0 = CommonMainString0.history_global_string_4_delegate$lambda$0();
            return history_global_string_4_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_40$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda8
        public final Object invoke() {
            StringResource history_global_string_40_delegate$lambda$0;
            history_global_string_40_delegate$lambda$0 = CommonMainString0.history_global_string_40_delegate$lambda$0();
            return history_global_string_40_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_41$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda9
        public final Object invoke() {
            StringResource history_global_string_41_delegate$lambda$0;
            history_global_string_41_delegate$lambda$0 = CommonMainString0.history_global_string_41_delegate$lambda$0();
            return history_global_string_41_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_42$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda10
        public final Object invoke() {
            StringResource history_global_string_42_delegate$lambda$0;
            history_global_string_42_delegate$lambda$0 = CommonMainString0.history_global_string_42_delegate$lambda$0();
            return history_global_string_42_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_43$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda12
        public final Object invoke() {
            StringResource history_global_string_43_delegate$lambda$0;
            history_global_string_43_delegate$lambda$0 = CommonMainString0.history_global_string_43_delegate$lambda$0();
            return history_global_string_43_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_44$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda13
        public final Object invoke() {
            StringResource history_global_string_44_delegate$lambda$0;
            history_global_string_44_delegate$lambda$0 = CommonMainString0.history_global_string_44_delegate$lambda$0();
            return history_global_string_44_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_45$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda15
        public final Object invoke() {
            StringResource history_global_string_45_delegate$lambda$0;
            history_global_string_45_delegate$lambda$0 = CommonMainString0.history_global_string_45_delegate$lambda$0();
            return history_global_string_45_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_46$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda16
        public final Object invoke() {
            StringResource history_global_string_46_delegate$lambda$0;
            history_global_string_46_delegate$lambda$0 = CommonMainString0.history_global_string_46_delegate$lambda$0();
            return history_global_string_46_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_47$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda17
        public final Object invoke() {
            StringResource history_global_string_47_delegate$lambda$0;
            history_global_string_47_delegate$lambda$0 = CommonMainString0.history_global_string_47_delegate$lambda$0();
            return history_global_string_47_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_48$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda18
        public final Object invoke() {
            StringResource history_global_string_48_delegate$lambda$0;
            history_global_string_48_delegate$lambda$0 = CommonMainString0.history_global_string_48_delegate$lambda$0();
            return history_global_string_48_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_5$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda19
        public final Object invoke() {
            StringResource history_global_string_5_delegate$lambda$0;
            history_global_string_5_delegate$lambda$0 = CommonMainString0.history_global_string_5_delegate$lambda$0();
            return history_global_string_5_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_6$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda20
        public final Object invoke() {
            StringResource history_global_string_6_delegate$lambda$0;
            history_global_string_6_delegate$lambda$0 = CommonMainString0.history_global_string_6_delegate$lambda$0();
            return history_global_string_6_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_7$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda21
        public final Object invoke() {
            StringResource history_global_string_7_delegate$lambda$0;
            history_global_string_7_delegate$lambda$0 = CommonMainString0.history_global_string_7_delegate$lambda$0();
            return history_global_string_7_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_8$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda23
        public final Object invoke() {
            StringResource history_global_string_8_delegate$lambda$0;
            history_global_string_8_delegate$lambda$0 = CommonMainString0.history_global_string_8_delegate$lambda$0();
            return history_global_string_8_delegate$lambda$0;
        }
    });
    private static final Lazy history_global_string_9$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.history.CommonMainString0$$ExternalSyntheticLambda24
        public final Object invoke() {
            StringResource history_global_string_9_delegate$lambda$0;
            history_global_string_9_delegate$lambda$0 = CommonMainString0.history_global_string_9_delegate$lambda$0();
            return history_global_string_9_delegate$lambda$0;
        }
    });

    private CommonMainString0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_1_delegate$lambda$0() {
        StringResource init_history_global_string_1;
        init_history_global_string_1 = String0_commonMainKt.init_history_global_string_1();
        return init_history_global_string_1;
    }

    public final StringResource getHistory_global_string_1() {
        return (StringResource) history_global_string_1$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_10_delegate$lambda$0() {
        StringResource init_history_global_string_10;
        init_history_global_string_10 = String0_commonMainKt.init_history_global_string_10();
        return init_history_global_string_10;
    }

    public final StringResource getHistory_global_string_10() {
        return (StringResource) history_global_string_10$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_11_delegate$lambda$0() {
        StringResource init_history_global_string_11;
        init_history_global_string_11 = String0_commonMainKt.init_history_global_string_11();
        return init_history_global_string_11;
    }

    public final StringResource getHistory_global_string_11() {
        return (StringResource) history_global_string_11$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_13_delegate$lambda$0() {
        StringResource init_history_global_string_13;
        init_history_global_string_13 = String0_commonMainKt.init_history_global_string_13();
        return init_history_global_string_13;
    }

    public final StringResource getHistory_global_string_13() {
        return (StringResource) history_global_string_13$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_14_delegate$lambda$0() {
        StringResource init_history_global_string_14;
        init_history_global_string_14 = String0_commonMainKt.init_history_global_string_14();
        return init_history_global_string_14;
    }

    public final StringResource getHistory_global_string_14() {
        return (StringResource) history_global_string_14$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_17_delegate$lambda$0() {
        StringResource init_history_global_string_17;
        init_history_global_string_17 = String0_commonMainKt.init_history_global_string_17();
        return init_history_global_string_17;
    }

    public final StringResource getHistory_global_string_17() {
        return (StringResource) history_global_string_17$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_18_delegate$lambda$0() {
        StringResource init_history_global_string_18;
        init_history_global_string_18 = String0_commonMainKt.init_history_global_string_18();
        return init_history_global_string_18;
    }

    public final StringResource getHistory_global_string_18() {
        return (StringResource) history_global_string_18$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_19_delegate$lambda$0() {
        StringResource init_history_global_string_19;
        init_history_global_string_19 = String0_commonMainKt.init_history_global_string_19();
        return init_history_global_string_19;
    }

    public final StringResource getHistory_global_string_19() {
        return (StringResource) history_global_string_19$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_2_delegate$lambda$0() {
        StringResource init_history_global_string_2;
        init_history_global_string_2 = String0_commonMainKt.init_history_global_string_2();
        return init_history_global_string_2;
    }

    public final StringResource getHistory_global_string_2() {
        return (StringResource) history_global_string_2$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_20_delegate$lambda$0() {
        StringResource init_history_global_string_20;
        init_history_global_string_20 = String0_commonMainKt.init_history_global_string_20();
        return init_history_global_string_20;
    }

    public final StringResource getHistory_global_string_20() {
        return (StringResource) history_global_string_20$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_21_delegate$lambda$0() {
        StringResource init_history_global_string_21;
        init_history_global_string_21 = String0_commonMainKt.init_history_global_string_21();
        return init_history_global_string_21;
    }

    public final StringResource getHistory_global_string_21() {
        return (StringResource) history_global_string_21$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_22_delegate$lambda$0() {
        StringResource init_history_global_string_22;
        init_history_global_string_22 = String0_commonMainKt.init_history_global_string_22();
        return init_history_global_string_22;
    }

    public final StringResource getHistory_global_string_22() {
        return (StringResource) history_global_string_22$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_23_delegate$lambda$0() {
        StringResource init_history_global_string_23;
        init_history_global_string_23 = String0_commonMainKt.init_history_global_string_23();
        return init_history_global_string_23;
    }

    public final StringResource getHistory_global_string_23() {
        return (StringResource) history_global_string_23$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_24_delegate$lambda$0() {
        StringResource init_history_global_string_24;
        init_history_global_string_24 = String0_commonMainKt.init_history_global_string_24();
        return init_history_global_string_24;
    }

    public final StringResource getHistory_global_string_24() {
        return (StringResource) history_global_string_24$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_25_delegate$lambda$0() {
        StringResource init_history_global_string_25;
        init_history_global_string_25 = String0_commonMainKt.init_history_global_string_25();
        return init_history_global_string_25;
    }

    public final StringResource getHistory_global_string_25() {
        return (StringResource) history_global_string_25$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_26_delegate$lambda$0() {
        StringResource init_history_global_string_26;
        init_history_global_string_26 = String0_commonMainKt.init_history_global_string_26();
        return init_history_global_string_26;
    }

    public final StringResource getHistory_global_string_26() {
        return (StringResource) history_global_string_26$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_27_delegate$lambda$0() {
        StringResource init_history_global_string_27;
        init_history_global_string_27 = String0_commonMainKt.init_history_global_string_27();
        return init_history_global_string_27;
    }

    public final StringResource getHistory_global_string_27() {
        return (StringResource) history_global_string_27$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_28_delegate$lambda$0() {
        StringResource init_history_global_string_28;
        init_history_global_string_28 = String0_commonMainKt.init_history_global_string_28();
        return init_history_global_string_28;
    }

    public final StringResource getHistory_global_string_28() {
        return (StringResource) history_global_string_28$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_3_delegate$lambda$0() {
        StringResource init_history_global_string_3;
        init_history_global_string_3 = String0_commonMainKt.init_history_global_string_3();
        return init_history_global_string_3;
    }

    public final StringResource getHistory_global_string_3() {
        return (StringResource) history_global_string_3$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_32_delegate$lambda$0() {
        StringResource init_history_global_string_32;
        init_history_global_string_32 = String0_commonMainKt.init_history_global_string_32();
        return init_history_global_string_32;
    }

    public final StringResource getHistory_global_string_32() {
        return (StringResource) history_global_string_32$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_34_delegate$lambda$0() {
        StringResource init_history_global_string_34;
        init_history_global_string_34 = String0_commonMainKt.init_history_global_string_34();
        return init_history_global_string_34;
    }

    public final StringResource getHistory_global_string_34() {
        return (StringResource) history_global_string_34$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_35_delegate$lambda$0() {
        StringResource init_history_global_string_35;
        init_history_global_string_35 = String0_commonMainKt.init_history_global_string_35();
        return init_history_global_string_35;
    }

    public final StringResource getHistory_global_string_35() {
        return (StringResource) history_global_string_35$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_37_delegate$lambda$0() {
        StringResource init_history_global_string_37;
        init_history_global_string_37 = String0_commonMainKt.init_history_global_string_37();
        return init_history_global_string_37;
    }

    public final StringResource getHistory_global_string_37() {
        return (StringResource) history_global_string_37$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_39_delegate$lambda$0() {
        StringResource init_history_global_string_39;
        init_history_global_string_39 = String0_commonMainKt.init_history_global_string_39();
        return init_history_global_string_39;
    }

    public final StringResource getHistory_global_string_39() {
        return (StringResource) history_global_string_39$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_4_delegate$lambda$0() {
        StringResource init_history_global_string_4;
        init_history_global_string_4 = String0_commonMainKt.init_history_global_string_4();
        return init_history_global_string_4;
    }

    public final StringResource getHistory_global_string_4() {
        return (StringResource) history_global_string_4$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_40_delegate$lambda$0() {
        StringResource init_history_global_string_40;
        init_history_global_string_40 = String0_commonMainKt.init_history_global_string_40();
        return init_history_global_string_40;
    }

    public final StringResource getHistory_global_string_40() {
        return (StringResource) history_global_string_40$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_41_delegate$lambda$0() {
        StringResource init_history_global_string_41;
        init_history_global_string_41 = String0_commonMainKt.init_history_global_string_41();
        return init_history_global_string_41;
    }

    public final StringResource getHistory_global_string_41() {
        return (StringResource) history_global_string_41$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_42_delegate$lambda$0() {
        StringResource init_history_global_string_42;
        init_history_global_string_42 = String0_commonMainKt.init_history_global_string_42();
        return init_history_global_string_42;
    }

    public final StringResource getHistory_global_string_42() {
        return (StringResource) history_global_string_42$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_43_delegate$lambda$0() {
        StringResource init_history_global_string_43;
        init_history_global_string_43 = String0_commonMainKt.init_history_global_string_43();
        return init_history_global_string_43;
    }

    public final StringResource getHistory_global_string_43() {
        return (StringResource) history_global_string_43$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_44_delegate$lambda$0() {
        StringResource init_history_global_string_44;
        init_history_global_string_44 = String0_commonMainKt.init_history_global_string_44();
        return init_history_global_string_44;
    }

    public final StringResource getHistory_global_string_44() {
        return (StringResource) history_global_string_44$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_45_delegate$lambda$0() {
        StringResource init_history_global_string_45;
        init_history_global_string_45 = String0_commonMainKt.init_history_global_string_45();
        return init_history_global_string_45;
    }

    public final StringResource getHistory_global_string_45() {
        return (StringResource) history_global_string_45$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_46_delegate$lambda$0() {
        StringResource init_history_global_string_46;
        init_history_global_string_46 = String0_commonMainKt.init_history_global_string_46();
        return init_history_global_string_46;
    }

    public final StringResource getHistory_global_string_46() {
        return (StringResource) history_global_string_46$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_47_delegate$lambda$0() {
        StringResource init_history_global_string_47;
        init_history_global_string_47 = String0_commonMainKt.init_history_global_string_47();
        return init_history_global_string_47;
    }

    public final StringResource getHistory_global_string_47() {
        return (StringResource) history_global_string_47$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_48_delegate$lambda$0() {
        StringResource init_history_global_string_48;
        init_history_global_string_48 = String0_commonMainKt.init_history_global_string_48();
        return init_history_global_string_48;
    }

    public final StringResource getHistory_global_string_48() {
        return (StringResource) history_global_string_48$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_5_delegate$lambda$0() {
        StringResource init_history_global_string_5;
        init_history_global_string_5 = String0_commonMainKt.init_history_global_string_5();
        return init_history_global_string_5;
    }

    public final StringResource getHistory_global_string_5() {
        return (StringResource) history_global_string_5$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_6_delegate$lambda$0() {
        StringResource init_history_global_string_6;
        init_history_global_string_6 = String0_commonMainKt.init_history_global_string_6();
        return init_history_global_string_6;
    }

    public final StringResource getHistory_global_string_6() {
        return (StringResource) history_global_string_6$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_7_delegate$lambda$0() {
        StringResource init_history_global_string_7;
        init_history_global_string_7 = String0_commonMainKt.init_history_global_string_7();
        return init_history_global_string_7;
    }

    public final StringResource getHistory_global_string_7() {
        return (StringResource) history_global_string_7$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_8_delegate$lambda$0() {
        StringResource init_history_global_string_8;
        init_history_global_string_8 = String0_commonMainKt.init_history_global_string_8();
        return init_history_global_string_8;
    }

    public final StringResource getHistory_global_string_8() {
        return (StringResource) history_global_string_8$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource history_global_string_9_delegate$lambda$0() {
        StringResource init_history_global_string_9;
        init_history_global_string_9 = String0_commonMainKt.init_history_global_string_9();
        return init_history_global_string_9;
    }

    public final StringResource getHistory_global_string_9() {
        return (StringResource) history_global_string_9$delegate.getValue();
    }
}