package bili.resource.live;

import com.bilibili.crow.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.PluralStringResource;

/* compiled from: Plurals0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bY\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0007R\u001b\u0010\"\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b#\u0010\u0007R\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b&\u0010\u0007R\u001b\u0010(\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b)\u0010\u0007R\u001b\u0010+\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b,\u0010\u0007R\u001b\u0010.\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b/\u0010\u0007R\u001b\u00101\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b2\u0010\u0007R\u001b\u00104\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\u0007R\u001b\u00107\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b8\u0010\u0007R\u001b\u0010:\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b;\u0010\u0007R\u001b\u0010=\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b>\u0010\u0007R\u001b\u0010@\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\bA\u0010\u0007R\u001b\u0010C\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bD\u0010\u0007R\u001b\u0010F\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bG\u0010\u0007R\u001b\u0010I\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\t\u001a\u0004\bJ\u0010\u0007R\u001b\u0010L\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\t\u001a\u0004\bM\u0010\u0007R\u001b\u0010O\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\t\u001a\u0004\bP\u0010\u0007R\u001b\u0010R\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\t\u001a\u0004\bS\u0010\u0007R\u001b\u0010U\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\t\u001a\u0004\bV\u0010\u0007R\u001b\u0010X\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\t\u001a\u0004\bY\u0010\u0007R\u001b\u0010[\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\t\u001a\u0004\b\\\u0010\u0007¨\u0006^"}, d2 = {"Lbili/resource/live/CommonMainPlurals0;", BuildConfig.FLAVOR, "<init>", "()V", "live_global_string_2413", "Lorg/jetbrains/compose/resources/PluralStringResource;", "getLive_global_string_2413", "()Lorg/jetbrains/compose/resources/PluralStringResource;", "live_global_string_2413$delegate", "Lkotlin/Lazy;", "live_global_string_2414", "getLive_global_string_2414", "live_global_string_2414$delegate", "live_global_string_2415", "getLive_global_string_2415", "live_global_string_2415$delegate", "live_global_string_2416", "getLive_global_string_2416", "live_global_string_2416$delegate", "live_global_string_2417", "getLive_global_string_2417", "live_global_string_2417$delegate", "live_global_string_2419", "getLive_global_string_2419", "live_global_string_2419$delegate", "live_global_string_2420", "getLive_global_string_2420", "live_global_string_2420$delegate", "live_global_string_2421", "getLive_global_string_2421", "live_global_string_2421$delegate", "live_global_string_2422", "getLive_global_string_2422", "live_global_string_2422$delegate", "live_global_string_2423", "getLive_global_string_2423", "live_global_string_2423$delegate", "live_global_string_2425", "getLive_global_string_2425", "live_global_string_2425$delegate", "live_global_string_2426", "getLive_global_string_2426", "live_global_string_2426$delegate", "live_global_string_2427", "getLive_global_string_2427", "live_global_string_2427$delegate", "live_global_string_2428", "getLive_global_string_2428", "live_global_string_2428$delegate", "live_global_string_2430", "getLive_global_string_2430", "live_global_string_2430$delegate", "live_global_string_2432", "getLive_global_string_2432", "live_global_string_2432$delegate", "live_global_string_2433", "getLive_global_string_2433", "live_global_string_2433$delegate", "live_global_string_2434", "getLive_global_string_2434", "live_global_string_2434$delegate", "live_global_string_2436", "getLive_global_string_2436", "live_global_string_2436$delegate", "live_global_string_2437", "getLive_global_string_2437", "live_global_string_2437$delegate", "live_global_string_2439", "getLive_global_string_2439", "live_global_string_2439$delegate", "live_global_string_2440", "getLive_global_string_2440", "live_global_string_2440$delegate", "live_global_string_2441", "getLive_global_string_2441", "live_global_string_2441$delegate", "live_global_string_2442", "getLive_global_string_2442", "live_global_string_2442$delegate", "live_global_string_2444", "getLive_global_string_2444", "live_global_string_2444$delegate", "live_global_string_2445", "getLive_global_string_2445", "live_global_string_2445$delegate", "live_global_string_2446", "getLive_global_string_2446", "live_global_string_2446$delegate", "live_global_string_2447", "getLive_global_string_2447", "live_global_string_2447$delegate", "live_global_string_2449", "getLive_global_string_2449", "live_global_string_2449$delegate", "live_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class CommonMainPlurals0 {
    public static final CommonMainPlurals0 INSTANCE = new CommonMainPlurals0();
    private static final Lazy live_global_string_2413$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda0
        public final Object invoke() {
            PluralStringResource live_global_string_2413_delegate$lambda$0;
            live_global_string_2413_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2413_delegate$lambda$0();
            return live_global_string_2413_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2414$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda2
        public final Object invoke() {
            PluralStringResource live_global_string_2414_delegate$lambda$0;
            live_global_string_2414_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2414_delegate$lambda$0();
            return live_global_string_2414_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2415$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda13
        public final Object invoke() {
            PluralStringResource live_global_string_2415_delegate$lambda$0;
            live_global_string_2415_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2415_delegate$lambda$0();
            return live_global_string_2415_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2416$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda14
        public final Object invoke() {
            PluralStringResource live_global_string_2416_delegate$lambda$0;
            live_global_string_2416_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2416_delegate$lambda$0();
            return live_global_string_2416_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2417$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda15
        public final Object invoke() {
            PluralStringResource live_global_string_2417_delegate$lambda$0;
            live_global_string_2417_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2417_delegate$lambda$0();
            return live_global_string_2417_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2419$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda16
        public final Object invoke() {
            PluralStringResource live_global_string_2419_delegate$lambda$0;
            live_global_string_2419_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2419_delegate$lambda$0();
            return live_global_string_2419_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2420$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda17
        public final Object invoke() {
            PluralStringResource live_global_string_2420_delegate$lambda$0;
            live_global_string_2420_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2420_delegate$lambda$0();
            return live_global_string_2420_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2421$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda18
        public final Object invoke() {
            PluralStringResource live_global_string_2421_delegate$lambda$0;
            live_global_string_2421_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2421_delegate$lambda$0();
            return live_global_string_2421_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2422$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda19
        public final Object invoke() {
            PluralStringResource live_global_string_2422_delegate$lambda$0;
            live_global_string_2422_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2422_delegate$lambda$0();
            return live_global_string_2422_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2423$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda20
        public final Object invoke() {
            PluralStringResource live_global_string_2423_delegate$lambda$0;
            live_global_string_2423_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2423_delegate$lambda$0();
            return live_global_string_2423_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2425$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda11
        public final Object invoke() {
            PluralStringResource live_global_string_2425_delegate$lambda$0;
            live_global_string_2425_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2425_delegate$lambda$0();
            return live_global_string_2425_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2426$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda21
        public final Object invoke() {
            PluralStringResource live_global_string_2426_delegate$lambda$0;
            live_global_string_2426_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2426_delegate$lambda$0();
            return live_global_string_2426_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2427$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda22
        public final Object invoke() {
            PluralStringResource live_global_string_2427_delegate$lambda$0;
            live_global_string_2427_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2427_delegate$lambda$0();
            return live_global_string_2427_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2428$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda23
        public final Object invoke() {
            PluralStringResource live_global_string_2428_delegate$lambda$0;
            live_global_string_2428_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2428_delegate$lambda$0();
            return live_global_string_2428_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2430$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda24
        public final Object invoke() {
            PluralStringResource live_global_string_2430_delegate$lambda$0;
            live_global_string_2430_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2430_delegate$lambda$0();
            return live_global_string_2430_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2432$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda25
        public final Object invoke() {
            PluralStringResource live_global_string_2432_delegate$lambda$0;
            live_global_string_2432_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2432_delegate$lambda$0();
            return live_global_string_2432_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2433$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda26
        public final Object invoke() {
            PluralStringResource live_global_string_2433_delegate$lambda$0;
            live_global_string_2433_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2433_delegate$lambda$0();
            return live_global_string_2433_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2434$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda27
        public final Object invoke() {
            PluralStringResource live_global_string_2434_delegate$lambda$0;
            live_global_string_2434_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2434_delegate$lambda$0();
            return live_global_string_2434_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2436$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda28
        public final Object invoke() {
            PluralStringResource live_global_string_2436_delegate$lambda$0;
            live_global_string_2436_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2436_delegate$lambda$0();
            return live_global_string_2436_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2437$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda1
        public final Object invoke() {
            PluralStringResource live_global_string_2437_delegate$lambda$0;
            live_global_string_2437_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2437_delegate$lambda$0();
            return live_global_string_2437_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2439$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda3
        public final Object invoke() {
            PluralStringResource live_global_string_2439_delegate$lambda$0;
            live_global_string_2439_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2439_delegate$lambda$0();
            return live_global_string_2439_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2440$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda4
        public final Object invoke() {
            PluralStringResource live_global_string_2440_delegate$lambda$0;
            live_global_string_2440_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2440_delegate$lambda$0();
            return live_global_string_2440_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2441$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda5
        public final Object invoke() {
            PluralStringResource live_global_string_2441_delegate$lambda$0;
            live_global_string_2441_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2441_delegate$lambda$0();
            return live_global_string_2441_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2442$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda6
        public final Object invoke() {
            PluralStringResource live_global_string_2442_delegate$lambda$0;
            live_global_string_2442_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2442_delegate$lambda$0();
            return live_global_string_2442_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2444$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda7
        public final Object invoke() {
            PluralStringResource live_global_string_2444_delegate$lambda$0;
            live_global_string_2444_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2444_delegate$lambda$0();
            return live_global_string_2444_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2445$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda8
        public final Object invoke() {
            PluralStringResource live_global_string_2445_delegate$lambda$0;
            live_global_string_2445_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2445_delegate$lambda$0();
            return live_global_string_2445_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2446$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda9
        public final Object invoke() {
            PluralStringResource live_global_string_2446_delegate$lambda$0;
            live_global_string_2446_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2446_delegate$lambda$0();
            return live_global_string_2446_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2447$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda10
        public final Object invoke() {
            PluralStringResource live_global_string_2447_delegate$lambda$0;
            live_global_string_2447_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2447_delegate$lambda$0();
            return live_global_string_2447_delegate$lambda$0;
        }
    });
    private static final Lazy live_global_string_2449$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.live.CommonMainPlurals0$$ExternalSyntheticLambda12
        public final Object invoke() {
            PluralStringResource live_global_string_2449_delegate$lambda$0;
            live_global_string_2449_delegate$lambda$0 = CommonMainPlurals0.live_global_string_2449_delegate$lambda$0();
            return live_global_string_2449_delegate$lambda$0;
        }
    });

    private CommonMainPlurals0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2413_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2413;
        init_live_global_string_2413 = Plurals0_commonMainKt.init_live_global_string_2413();
        return init_live_global_string_2413;
    }

    public final PluralStringResource getLive_global_string_2413() {
        return (PluralStringResource) live_global_string_2413$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2414_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2414;
        init_live_global_string_2414 = Plurals0_commonMainKt.init_live_global_string_2414();
        return init_live_global_string_2414;
    }

    public final PluralStringResource getLive_global_string_2414() {
        return (PluralStringResource) live_global_string_2414$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2415_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2415;
        init_live_global_string_2415 = Plurals0_commonMainKt.init_live_global_string_2415();
        return init_live_global_string_2415;
    }

    public final PluralStringResource getLive_global_string_2415() {
        return (PluralStringResource) live_global_string_2415$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2416_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2416;
        init_live_global_string_2416 = Plurals0_commonMainKt.init_live_global_string_2416();
        return init_live_global_string_2416;
    }

    public final PluralStringResource getLive_global_string_2416() {
        return (PluralStringResource) live_global_string_2416$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2417_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2417;
        init_live_global_string_2417 = Plurals0_commonMainKt.init_live_global_string_2417();
        return init_live_global_string_2417;
    }

    public final PluralStringResource getLive_global_string_2417() {
        return (PluralStringResource) live_global_string_2417$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2419_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2419;
        init_live_global_string_2419 = Plurals0_commonMainKt.init_live_global_string_2419();
        return init_live_global_string_2419;
    }

    public final PluralStringResource getLive_global_string_2419() {
        return (PluralStringResource) live_global_string_2419$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2420_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2420;
        init_live_global_string_2420 = Plurals0_commonMainKt.init_live_global_string_2420();
        return init_live_global_string_2420;
    }

    public final PluralStringResource getLive_global_string_2420() {
        return (PluralStringResource) live_global_string_2420$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2421_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2421;
        init_live_global_string_2421 = Plurals0_commonMainKt.init_live_global_string_2421();
        return init_live_global_string_2421;
    }

    public final PluralStringResource getLive_global_string_2421() {
        return (PluralStringResource) live_global_string_2421$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2422_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2422;
        init_live_global_string_2422 = Plurals0_commonMainKt.init_live_global_string_2422();
        return init_live_global_string_2422;
    }

    public final PluralStringResource getLive_global_string_2422() {
        return (PluralStringResource) live_global_string_2422$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2423_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2423;
        init_live_global_string_2423 = Plurals0_commonMainKt.init_live_global_string_2423();
        return init_live_global_string_2423;
    }

    public final PluralStringResource getLive_global_string_2423() {
        return (PluralStringResource) live_global_string_2423$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2425_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2425;
        init_live_global_string_2425 = Plurals0_commonMainKt.init_live_global_string_2425();
        return init_live_global_string_2425;
    }

    public final PluralStringResource getLive_global_string_2425() {
        return (PluralStringResource) live_global_string_2425$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2426_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2426;
        init_live_global_string_2426 = Plurals0_commonMainKt.init_live_global_string_2426();
        return init_live_global_string_2426;
    }

    public final PluralStringResource getLive_global_string_2426() {
        return (PluralStringResource) live_global_string_2426$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2427_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2427;
        init_live_global_string_2427 = Plurals0_commonMainKt.init_live_global_string_2427();
        return init_live_global_string_2427;
    }

    public final PluralStringResource getLive_global_string_2427() {
        return (PluralStringResource) live_global_string_2427$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2428_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2428;
        init_live_global_string_2428 = Plurals0_commonMainKt.init_live_global_string_2428();
        return init_live_global_string_2428;
    }

    public final PluralStringResource getLive_global_string_2428() {
        return (PluralStringResource) live_global_string_2428$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2430_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2430;
        init_live_global_string_2430 = Plurals0_commonMainKt.init_live_global_string_2430();
        return init_live_global_string_2430;
    }

    public final PluralStringResource getLive_global_string_2430() {
        return (PluralStringResource) live_global_string_2430$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2432_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2432;
        init_live_global_string_2432 = Plurals0_commonMainKt.init_live_global_string_2432();
        return init_live_global_string_2432;
    }

    public final PluralStringResource getLive_global_string_2432() {
        return (PluralStringResource) live_global_string_2432$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2433_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2433;
        init_live_global_string_2433 = Plurals0_commonMainKt.init_live_global_string_2433();
        return init_live_global_string_2433;
    }

    public final PluralStringResource getLive_global_string_2433() {
        return (PluralStringResource) live_global_string_2433$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2434_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2434;
        init_live_global_string_2434 = Plurals0_commonMainKt.init_live_global_string_2434();
        return init_live_global_string_2434;
    }

    public final PluralStringResource getLive_global_string_2434() {
        return (PluralStringResource) live_global_string_2434$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2436_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2436;
        init_live_global_string_2436 = Plurals0_commonMainKt.init_live_global_string_2436();
        return init_live_global_string_2436;
    }

    public final PluralStringResource getLive_global_string_2436() {
        return (PluralStringResource) live_global_string_2436$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2437_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2437;
        init_live_global_string_2437 = Plurals0_commonMainKt.init_live_global_string_2437();
        return init_live_global_string_2437;
    }

    public final PluralStringResource getLive_global_string_2437() {
        return (PluralStringResource) live_global_string_2437$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2439_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2439;
        init_live_global_string_2439 = Plurals0_commonMainKt.init_live_global_string_2439();
        return init_live_global_string_2439;
    }

    public final PluralStringResource getLive_global_string_2439() {
        return (PluralStringResource) live_global_string_2439$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2440_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2440;
        init_live_global_string_2440 = Plurals0_commonMainKt.init_live_global_string_2440();
        return init_live_global_string_2440;
    }

    public final PluralStringResource getLive_global_string_2440() {
        return (PluralStringResource) live_global_string_2440$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2441_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2441;
        init_live_global_string_2441 = Plurals0_commonMainKt.init_live_global_string_2441();
        return init_live_global_string_2441;
    }

    public final PluralStringResource getLive_global_string_2441() {
        return (PluralStringResource) live_global_string_2441$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2442_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2442;
        init_live_global_string_2442 = Plurals0_commonMainKt.init_live_global_string_2442();
        return init_live_global_string_2442;
    }

    public final PluralStringResource getLive_global_string_2442() {
        return (PluralStringResource) live_global_string_2442$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2444_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2444;
        init_live_global_string_2444 = Plurals0_commonMainKt.init_live_global_string_2444();
        return init_live_global_string_2444;
    }

    public final PluralStringResource getLive_global_string_2444() {
        return (PluralStringResource) live_global_string_2444$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2445_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2445;
        init_live_global_string_2445 = Plurals0_commonMainKt.init_live_global_string_2445();
        return init_live_global_string_2445;
    }

    public final PluralStringResource getLive_global_string_2445() {
        return (PluralStringResource) live_global_string_2445$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2446_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2446;
        init_live_global_string_2446 = Plurals0_commonMainKt.init_live_global_string_2446();
        return init_live_global_string_2446;
    }

    public final PluralStringResource getLive_global_string_2446() {
        return (PluralStringResource) live_global_string_2446$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2447_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2447;
        init_live_global_string_2447 = Plurals0_commonMainKt.init_live_global_string_2447();
        return init_live_global_string_2447;
    }

    public final PluralStringResource getLive_global_string_2447() {
        return (PluralStringResource) live_global_string_2447$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource live_global_string_2449_delegate$lambda$0() {
        PluralStringResource init_live_global_string_2449;
        init_live_global_string_2449 = Plurals0_commonMainKt.init_live_global_string_2449();
        return init_live_global_string_2449;
    }

    public final PluralStringResource getLive_global_string_2449() {
        return (PluralStringResource) live_global_string_2449$delegate.getValue();
    }
}