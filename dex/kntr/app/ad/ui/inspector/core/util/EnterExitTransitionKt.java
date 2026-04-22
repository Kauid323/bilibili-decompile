package kntr.app.ad.ui.inspector.core.util;

import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"iosEnterTransition", "Landroidx/compose/animation/EnterTransition;", "iosPopExitTransition", "Landroidx/compose/animation/ExitTransition;", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EnterExitTransitionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int iosEnterTransition$lambda$0(int fullWidth) {
        return fullWidth;
    }

    public static final EnterTransition iosEnterTransition() {
        return androidx.compose.animation.EnterExitTransitionKt.slideInHorizontally(AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), new Function1() { // from class: kntr.app.ad.ui.inspector.core.util.EnterExitTransitionKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                int iosEnterTransition$lambda$0;
                iosEnterTransition$lambda$0 = EnterExitTransitionKt.iosEnterTransition$lambda$0(((Integer) obj).intValue());
                return Integer.valueOf(iosEnterTransition$lambda$0);
            }
        }).plus(androidx.compose.animation.EnterExitTransitionKt.fadeIn(AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), 0.3f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int iosPopExitTransition$lambda$0(int fullWidth) {
        return fullWidth;
    }

    public static final ExitTransition iosPopExitTransition() {
        return androidx.compose.animation.EnterExitTransitionKt.slideOutHorizontally(AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), new Function1() { // from class: kntr.app.ad.ui.inspector.core.util.EnterExitTransitionKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                int iosPopExitTransition$lambda$0;
                iosPopExitTransition$lambda$0 = EnterExitTransitionKt.iosPopExitTransition$lambda$0(((Integer) obj).intValue());
                return Integer.valueOf(iosPopExitTransition$lambda$0);
            }
        }).plus(androidx.compose.animation.EnterExitTransitionKt.fadeOut(AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), 0.3f));
    }
}