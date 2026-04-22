package kntr.base.dd.impl.internal.update;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: IDDUpdateEngine.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\b\u001a\u00060\tj\u0002`\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\b\u001a\u00060\tj\u0002`\nH¦@¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lkntr/base/dd/impl/internal/update/IDDUpdateEngine;", "", "update", "Lkotlin/Result;", "", "from", "", AppKey.VERSION, "env", "Lkntr/base/dd/IDeviceDecision$Version$Env;", "Lkntr/base/dd/impl/internal/common/DDEnv;", "force", "", "update-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Lkntr/base/dd/IDeviceDecision$Version$Env;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fallback", "fallback-0E7RQCE", "(Ljava/lang/String;Lkntr/base/dd/IDeviceDecision$Version$Env;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDDUpdateEngine {
    /* renamed from: fallback-0E7RQCE  reason: not valid java name */
    Object mo1364fallback0E7RQCE(String str, IDeviceDecision.Version.Env env, Continuation<? super Result<Unit>> continuation);

    /* renamed from: update-yxL6bBk  reason: not valid java name */
    Object mo1365updateyxL6bBk(String str, String str2, IDeviceDecision.Version.Env env, boolean z, Continuation<? super Result<Unit>> continuation);

    /* compiled from: IDDUpdateEngine.kt */
    /* renamed from: kntr.base.dd.impl.internal.update.IDDUpdateEngine$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        /* renamed from: update-yxL6bBk$default  reason: not valid java name */
        public static /* synthetic */ Object m1366updateyxL6bBk$default(IDDUpdateEngine iDDUpdateEngine, String str, String str2, IDeviceDecision.Version.Env env, boolean z, Continuation continuation, int i, Object obj) {
            boolean z2;
            if (obj == null) {
                if ((i & 8) == 0) {
                    z2 = z;
                } else {
                    z2 = false;
                }
                return iDDUpdateEngine.mo1365updateyxL6bBk(str, str2, env, z2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update-yxL6bBk");
        }
    }

    /* compiled from: IDDUpdateEngine.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}