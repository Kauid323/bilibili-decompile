package kntr.app.ad.ui.inspector.ui;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kntr.app.ad.ui.inspector.model.UserRole;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: LocalUserRole.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalUserRole", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkntr/app/ad/ui/inspector/model/UserRole;", "getLocalUserRole", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LocalUserRoleKt {
    private static final ProvidableCompositionLocal<UserRole> LocalUserRole = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, new Function0() { // from class: kntr.app.ad.ui.inspector.ui.LocalUserRoleKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            UserRole userRole;
            userRole = UserRole.OPERATOR;
            return userRole;
        }
    }, 1, (Object) null);

    public static final ProvidableCompositionLocal<UserRole> getLocalUserRole() {
        return LocalUserRole;
    }
}