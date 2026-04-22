package kntr.common.compose.launcher;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* compiled from: ComposeContainerStyle.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"composeContainerStyle", "Lkntr/common/compose/launcher/ComposeContainerStyle;", "getComposeContainerStyle", "()Lkntr/common/compose/launcher/ComposeContainerStyle;", "composeContainerStyle$delegate", "Lkotlin/Lazy;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposeContainerStyleKt {
    private static final Lazy composeContainerStyle$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.compose.launcher.ComposeContainerStyleKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            ComposeContainerStyleKt$composeContainerStyle$2$1 composeContainerStyle_delegate$lambda$0;
            composeContainerStyle_delegate$lambda$0 = ComposeContainerStyleKt.composeContainerStyle_delegate$lambda$0();
            return composeContainerStyle_delegate$lambda$0;
        }
    });

    public static final ComposeContainerStyle getComposeContainerStyle() {
        return (ComposeContainerStyle) composeContainerStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ComposeContainerStyleKt$composeContainerStyle$2$1 composeContainerStyle_delegate$lambda$0() {
        ComposeContainerStyle containerStyle = (ComposeContainerStyle) ((ComposeContainerStyleEntryPoint) Component_jvmKt.entryPoint(Gripper_component_holder_androidKt.getRootGripperComponent(), Reflection.getOrCreateKotlinClass(ComposeContainerStyleEntryPoint.class))).getComposeContainerStyle().orNull();
        return new ComposeContainerStyleKt$composeContainerStyle$2$1(containerStyle);
    }
}