package kntr.base.mod;

import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.foundation.env.Env;
import com.bilibili.lib.foundation.env.EnvManager;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProvideModOptions.android.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"provideModOptions", "Lkntr/base/mod/KModOptions;", "mod_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProvideModOptions_androidKt {
    public static final KModOptions provideModOptions() {
        return new KModOptions() { // from class: kntr.base.mod.ProvideModOptions_androidKt$provideModOptions$1
            @Override // kntr.base.mod.KModOptions
            public String getRootDir() {
                String file = FoundationAlias.getFapp().getDir("kmod", 0).toString();
                Intrinsics.checkNotNullExpressionValue(file, "toString(...)");
                return file;
            }

            @Override // kntr.base.mod.KModOptions
            public boolean getDebug() {
                return EnvManager.getCurrent() == Env.TEST;
            }
        };
    }
}