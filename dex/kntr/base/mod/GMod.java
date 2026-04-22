package kntr.base.mod;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GMod.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J.\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/base/mod/GMod;", "", "get", "Lkntr/base/mod/ModBundle;", "pool", "", "mod", "policy", "Lkntr/base/mod/ModRequirementPolicy;", "(Ljava/lang/String;Ljava/lang/String;Lkntr/base/mod/ModRequirementPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getList", "", "produceBundleStates", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/mod/ModBundleState;", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface GMod {
    Object get(String str, String str2, ModRequirementPolicy modRequirementPolicy, Continuation<? super ModBundle> continuation);

    List<ModBundle> getList(String str);

    Flow<ModBundleState> produceBundleStates(String str, String str2, ModRequirementPolicy modRequirementPolicy);

    /* compiled from: GMod.kt */
    /* renamed from: kntr.base.mod.GMod$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object get$default(GMod gMod, String str, String str2, ModRequirementPolicy modRequirementPolicy, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    modRequirementPolicy = ModRequirementPolicy.ByPriority;
                }
                return gMod.get(str, str2, modRequirementPolicy, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }

        public static /* synthetic */ Flow produceBundleStates$default(GMod gMod, String str, String str2, ModRequirementPolicy modRequirementPolicy, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    modRequirementPolicy = null;
                }
                return gMod.produceBundleStates(str, str2, modRequirementPolicy);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: produceBundleStates");
        }
    }

    /* compiled from: GMod.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}