package bili.resource.following;

import com.bilibili.upper.BR;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.PluralStringResource;

/* compiled from: Plurals0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bS\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0007R\u001b\u0010\"\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b#\u0010\u0007R\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b&\u0010\u0007R\u001b\u0010(\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b)\u0010\u0007R\u001b\u0010+\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b,\u0010\u0007R\u001b\u0010.\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b/\u0010\u0007R\u001b\u00101\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b2\u0010\u0007R\u001b\u00104\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\u0007R\u001b\u00107\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b8\u0010\u0007R\u001b\u0010:\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b;\u0010\u0007R\u001b\u0010=\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b>\u0010\u0007R\u001b\u0010@\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\bA\u0010\u0007R\u001b\u0010C\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bD\u0010\u0007R\u001b\u0010F\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bG\u0010\u0007R\u001b\u0010I\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\t\u001a\u0004\bJ\u0010\u0007R\u001b\u0010L\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\t\u001a\u0004\bM\u0010\u0007R\u001b\u0010O\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\t\u001a\u0004\bP\u0010\u0007R\u001b\u0010R\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\t\u001a\u0004\bS\u0010\u0007R\u001b\u0010U\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\t\u001a\u0004\bV\u0010\u0007¨\u0006X"}, d2 = {"Lbili/resource/following/CommonMainPlurals0;", "", "<init>", "()V", "following_global_string_1114", "Lorg/jetbrains/compose/resources/PluralStringResource;", "getFollowing_global_string_1114", "()Lorg/jetbrains/compose/resources/PluralStringResource;", "following_global_string_1114$delegate", "Lkotlin/Lazy;", "following_global_string_1116", "getFollowing_global_string_1116", "following_global_string_1116$delegate", "following_global_string_1117", "getFollowing_global_string_1117", "following_global_string_1117$delegate", "following_global_string_1118", "getFollowing_global_string_1118", "following_global_string_1118$delegate", "following_global_string_1119", "getFollowing_global_string_1119", "following_global_string_1119$delegate", "following_global_string_1120", "getFollowing_global_string_1120", "following_global_string_1120$delegate", "following_global_string_1123", "getFollowing_global_string_1123", "following_global_string_1123$delegate", "following_global_string_1124", "getFollowing_global_string_1124", "following_global_string_1124$delegate", "following_global_string_1125", "getFollowing_global_string_1125", "following_global_string_1125$delegate", "following_global_string_1126", "getFollowing_global_string_1126", "following_global_string_1126$delegate", "following_global_string_1129", "getFollowing_global_string_1129", "following_global_string_1129$delegate", "following_global_string_1132", "getFollowing_global_string_1132", "following_global_string_1132$delegate", "following_global_string_1133", "getFollowing_global_string_1133", "following_global_string_1133$delegate", "following_global_string_1134", "getFollowing_global_string_1134", "following_global_string_1134$delegate", "following_global_string_1135", "getFollowing_global_string_1135", "following_global_string_1135$delegate", "following_global_string_1136", "getFollowing_global_string_1136", "following_global_string_1136$delegate", "following_global_string_1138", "getFollowing_global_string_1138", "following_global_string_1138$delegate", "following_global_string_1139", "getFollowing_global_string_1139", "following_global_string_1139$delegate", "following_global_string_1142", "getFollowing_global_string_1142", "following_global_string_1142$delegate", "following_global_string_1144", "getFollowing_global_string_1144", "following_global_string_1144$delegate", "following_global_string_1145", "getFollowing_global_string_1145", "following_global_string_1145$delegate", "following_global_string_1146", "getFollowing_global_string_1146", "following_global_string_1146$delegate", "following_global_string_1147", "getFollowing_global_string_1147", "following_global_string_1147$delegate", "following_global_string_1148", "getFollowing_global_string_1148", "following_global_string_1148$delegate", "following_global_string_1150", "getFollowing_global_string_1150", "following_global_string_1150$delegate", "following_global_string_1151", "getFollowing_global_string_1151", "following_global_string_1151$delegate", "following_global_string_1153", "getFollowing_global_string_1153", "following_global_string_1153$delegate", "following_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainPlurals0 {
    public static final CommonMainPlurals0 INSTANCE = new CommonMainPlurals0();
    private static final Lazy following_global_string_1114$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda0
        public final Object invoke() {
            PluralStringResource following_global_string_1114_delegate$lambda$0;
            following_global_string_1114_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1114_delegate$lambda$0();
            return following_global_string_1114_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1116$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda2
        public final Object invoke() {
            PluralStringResource following_global_string_1116_delegate$lambda$0;
            following_global_string_1116_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1116_delegate$lambda$0();
            return following_global_string_1116_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1117$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda10
        public final Object invoke() {
            PluralStringResource following_global_string_1117_delegate$lambda$0;
            following_global_string_1117_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1117_delegate$lambda$0();
            return following_global_string_1117_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1118$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda12
        public final Object invoke() {
            PluralStringResource following_global_string_1118_delegate$lambda$0;
            following_global_string_1118_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1118_delegate$lambda$0();
            return following_global_string_1118_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1119$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda13
        public final Object invoke() {
            PluralStringResource following_global_string_1119_delegate$lambda$0;
            following_global_string_1119_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1119_delegate$lambda$0();
            return following_global_string_1119_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1120$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda14
        public final Object invoke() {
            PluralStringResource following_global_string_1120_delegate$lambda$0;
            following_global_string_1120_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1120_delegate$lambda$0();
            return following_global_string_1120_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1123$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda15
        public final Object invoke() {
            PluralStringResource following_global_string_1123_delegate$lambda$0;
            following_global_string_1123_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1123_delegate$lambda$0();
            return following_global_string_1123_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1124$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda16
        public final Object invoke() {
            PluralStringResource following_global_string_1124_delegate$lambda$0;
            following_global_string_1124_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1124_delegate$lambda$0();
            return following_global_string_1124_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1125$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda17
        public final Object invoke() {
            PluralStringResource following_global_string_1125_delegate$lambda$0;
            following_global_string_1125_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1125_delegate$lambda$0();
            return following_global_string_1125_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1126$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda18
        public final Object invoke() {
            PluralStringResource following_global_string_1126_delegate$lambda$0;
            following_global_string_1126_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1126_delegate$lambda$0();
            return following_global_string_1126_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1129$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda11
        public final Object invoke() {
            PluralStringResource following_global_string_1129_delegate$lambda$0;
            following_global_string_1129_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1129_delegate$lambda$0();
            return following_global_string_1129_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1132$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda19
        public final Object invoke() {
            PluralStringResource following_global_string_1132_delegate$lambda$0;
            following_global_string_1132_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1132_delegate$lambda$0();
            return following_global_string_1132_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1133$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda20
        public final Object invoke() {
            PluralStringResource following_global_string_1133_delegate$lambda$0;
            following_global_string_1133_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1133_delegate$lambda$0();
            return following_global_string_1133_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1134$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda21
        public final Object invoke() {
            PluralStringResource following_global_string_1134_delegate$lambda$0;
            following_global_string_1134_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1134_delegate$lambda$0();
            return following_global_string_1134_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1135$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda22
        public final Object invoke() {
            PluralStringResource following_global_string_1135_delegate$lambda$0;
            following_global_string_1135_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1135_delegate$lambda$0();
            return following_global_string_1135_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1136$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda23
        public final Object invoke() {
            PluralStringResource following_global_string_1136_delegate$lambda$0;
            following_global_string_1136_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1136_delegate$lambda$0();
            return following_global_string_1136_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1138$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda24
        public final Object invoke() {
            PluralStringResource following_global_string_1138_delegate$lambda$0;
            following_global_string_1138_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1138_delegate$lambda$0();
            return following_global_string_1138_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1139$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda25
        public final Object invoke() {
            PluralStringResource following_global_string_1139_delegate$lambda$0;
            following_global_string_1139_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1139_delegate$lambda$0();
            return following_global_string_1139_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1142$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda26
        public final Object invoke() {
            PluralStringResource following_global_string_1142_delegate$lambda$0;
            following_global_string_1142_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1142_delegate$lambda$0();
            return following_global_string_1142_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1144$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda1
        public final Object invoke() {
            PluralStringResource following_global_string_1144_delegate$lambda$0;
            following_global_string_1144_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1144_delegate$lambda$0();
            return following_global_string_1144_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1145$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda3
        public final Object invoke() {
            PluralStringResource following_global_string_1145_delegate$lambda$0;
            following_global_string_1145_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1145_delegate$lambda$0();
            return following_global_string_1145_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1146$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda4
        public final Object invoke() {
            PluralStringResource following_global_string_1146_delegate$lambda$0;
            following_global_string_1146_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1146_delegate$lambda$0();
            return following_global_string_1146_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1147$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda5
        public final Object invoke() {
            PluralStringResource following_global_string_1147_delegate$lambda$0;
            following_global_string_1147_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1147_delegate$lambda$0();
            return following_global_string_1147_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1148$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda6
        public final Object invoke() {
            PluralStringResource following_global_string_1148_delegate$lambda$0;
            following_global_string_1148_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1148_delegate$lambda$0();
            return following_global_string_1148_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1150$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda7
        public final Object invoke() {
            PluralStringResource following_global_string_1150_delegate$lambda$0;
            following_global_string_1150_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1150_delegate$lambda$0();
            return following_global_string_1150_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1151$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda8
        public final Object invoke() {
            PluralStringResource following_global_string_1151_delegate$lambda$0;
            following_global_string_1151_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1151_delegate$lambda$0();
            return following_global_string_1151_delegate$lambda$0;
        }
    });
    private static final Lazy following_global_string_1153$delegate = LazyKt.lazy(new Function0() { // from class: bili.resource.following.CommonMainPlurals0$$ExternalSyntheticLambda9
        public final Object invoke() {
            PluralStringResource following_global_string_1153_delegate$lambda$0;
            following_global_string_1153_delegate$lambda$0 = CommonMainPlurals0.following_global_string_1153_delegate$lambda$0();
            return following_global_string_1153_delegate$lambda$0;
        }
    });

    private CommonMainPlurals0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1114_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1114;
        init_following_global_string_1114 = Plurals0_commonMainKt.init_following_global_string_1114();
        return init_following_global_string_1114;
    }

    public final PluralStringResource getFollowing_global_string_1114() {
        return (PluralStringResource) following_global_string_1114$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1116_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1116;
        init_following_global_string_1116 = Plurals0_commonMainKt.init_following_global_string_1116();
        return init_following_global_string_1116;
    }

    public final PluralStringResource getFollowing_global_string_1116() {
        return (PluralStringResource) following_global_string_1116$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1117_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1117;
        init_following_global_string_1117 = Plurals0_commonMainKt.init_following_global_string_1117();
        return init_following_global_string_1117;
    }

    public final PluralStringResource getFollowing_global_string_1117() {
        return (PluralStringResource) following_global_string_1117$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1118_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1118;
        init_following_global_string_1118 = Plurals0_commonMainKt.init_following_global_string_1118();
        return init_following_global_string_1118;
    }

    public final PluralStringResource getFollowing_global_string_1118() {
        return (PluralStringResource) following_global_string_1118$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1119_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1119;
        init_following_global_string_1119 = Plurals0_commonMainKt.init_following_global_string_1119();
        return init_following_global_string_1119;
    }

    public final PluralStringResource getFollowing_global_string_1119() {
        return (PluralStringResource) following_global_string_1119$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1120_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1120;
        init_following_global_string_1120 = Plurals0_commonMainKt.init_following_global_string_1120();
        return init_following_global_string_1120;
    }

    public final PluralStringResource getFollowing_global_string_1120() {
        return (PluralStringResource) following_global_string_1120$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1123_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1123;
        init_following_global_string_1123 = Plurals0_commonMainKt.init_following_global_string_1123();
        return init_following_global_string_1123;
    }

    public final PluralStringResource getFollowing_global_string_1123() {
        return (PluralStringResource) following_global_string_1123$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1124_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1124;
        init_following_global_string_1124 = Plurals0_commonMainKt.init_following_global_string_1124();
        return init_following_global_string_1124;
    }

    public final PluralStringResource getFollowing_global_string_1124() {
        return (PluralStringResource) following_global_string_1124$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1125_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1125;
        init_following_global_string_1125 = Plurals0_commonMainKt.init_following_global_string_1125();
        return init_following_global_string_1125;
    }

    public final PluralStringResource getFollowing_global_string_1125() {
        return (PluralStringResource) following_global_string_1125$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1126_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1126;
        init_following_global_string_1126 = Plurals0_commonMainKt.init_following_global_string_1126();
        return init_following_global_string_1126;
    }

    public final PluralStringResource getFollowing_global_string_1126() {
        return (PluralStringResource) following_global_string_1126$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1129_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1129;
        init_following_global_string_1129 = Plurals0_commonMainKt.init_following_global_string_1129();
        return init_following_global_string_1129;
    }

    public final PluralStringResource getFollowing_global_string_1129() {
        return (PluralStringResource) following_global_string_1129$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1132_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1132;
        init_following_global_string_1132 = Plurals0_commonMainKt.init_following_global_string_1132();
        return init_following_global_string_1132;
    }

    public final PluralStringResource getFollowing_global_string_1132() {
        return (PluralStringResource) following_global_string_1132$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1133_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1133;
        init_following_global_string_1133 = Plurals0_commonMainKt.init_following_global_string_1133();
        return init_following_global_string_1133;
    }

    public final PluralStringResource getFollowing_global_string_1133() {
        return (PluralStringResource) following_global_string_1133$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1134_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1134;
        init_following_global_string_1134 = Plurals0_commonMainKt.init_following_global_string_1134();
        return init_following_global_string_1134;
    }

    public final PluralStringResource getFollowing_global_string_1134() {
        return (PluralStringResource) following_global_string_1134$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1135_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1135;
        init_following_global_string_1135 = Plurals0_commonMainKt.init_following_global_string_1135();
        return init_following_global_string_1135;
    }

    public final PluralStringResource getFollowing_global_string_1135() {
        return (PluralStringResource) following_global_string_1135$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1136_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1136;
        init_following_global_string_1136 = Plurals0_commonMainKt.init_following_global_string_1136();
        return init_following_global_string_1136;
    }

    public final PluralStringResource getFollowing_global_string_1136() {
        return (PluralStringResource) following_global_string_1136$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1138_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1138;
        init_following_global_string_1138 = Plurals0_commonMainKt.init_following_global_string_1138();
        return init_following_global_string_1138;
    }

    public final PluralStringResource getFollowing_global_string_1138() {
        return (PluralStringResource) following_global_string_1138$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1139_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1139;
        init_following_global_string_1139 = Plurals0_commonMainKt.init_following_global_string_1139();
        return init_following_global_string_1139;
    }

    public final PluralStringResource getFollowing_global_string_1139() {
        return (PluralStringResource) following_global_string_1139$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1142_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1142;
        init_following_global_string_1142 = Plurals0_commonMainKt.init_following_global_string_1142();
        return init_following_global_string_1142;
    }

    public final PluralStringResource getFollowing_global_string_1142() {
        return (PluralStringResource) following_global_string_1142$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1144_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1144;
        init_following_global_string_1144 = Plurals0_commonMainKt.init_following_global_string_1144();
        return init_following_global_string_1144;
    }

    public final PluralStringResource getFollowing_global_string_1144() {
        return (PluralStringResource) following_global_string_1144$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1145_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1145;
        init_following_global_string_1145 = Plurals0_commonMainKt.init_following_global_string_1145();
        return init_following_global_string_1145;
    }

    public final PluralStringResource getFollowing_global_string_1145() {
        return (PluralStringResource) following_global_string_1145$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1146_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1146;
        init_following_global_string_1146 = Plurals0_commonMainKt.init_following_global_string_1146();
        return init_following_global_string_1146;
    }

    public final PluralStringResource getFollowing_global_string_1146() {
        return (PluralStringResource) following_global_string_1146$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1147_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1147;
        init_following_global_string_1147 = Plurals0_commonMainKt.init_following_global_string_1147();
        return init_following_global_string_1147;
    }

    public final PluralStringResource getFollowing_global_string_1147() {
        return (PluralStringResource) following_global_string_1147$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1148_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1148;
        init_following_global_string_1148 = Plurals0_commonMainKt.init_following_global_string_1148();
        return init_following_global_string_1148;
    }

    public final PluralStringResource getFollowing_global_string_1148() {
        return (PluralStringResource) following_global_string_1148$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1150_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1150;
        init_following_global_string_1150 = Plurals0_commonMainKt.init_following_global_string_1150();
        return init_following_global_string_1150;
    }

    public final PluralStringResource getFollowing_global_string_1150() {
        return (PluralStringResource) following_global_string_1150$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1151_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1151;
        init_following_global_string_1151 = Plurals0_commonMainKt.init_following_global_string_1151();
        return init_following_global_string_1151;
    }

    public final PluralStringResource getFollowing_global_string_1151() {
        return (PluralStringResource) following_global_string_1151$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource following_global_string_1153_delegate$lambda$0() {
        PluralStringResource init_following_global_string_1153;
        init_following_global_string_1153 = Plurals0_commonMainKt.init_following_global_string_1153();
        return init_following_global_string_1153;
    }

    public final PluralStringResource getFollowing_global_string_1153() {
        return (PluralStringResource) following_global_string_1153$delegate.getValue();
    }
}