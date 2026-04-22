package im.base;

import dagger.Module;
import dagger.multibindings.Multibinds;
import im.base.model.SessionId;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: SessionIdConverter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003H'¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lim/base/EmptyIdModule;", "", "bindSessionIdConverters", "", "", "Lim/base/SessionIdConverter;", "Lim/base/model/SessionId;", "Lkotlin/jvm/JvmSuppressWildcards;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public interface EmptyIdModule {
    @Multibinds
    Map<Integer, SessionIdConverter<SessionId>> bindSessionIdConverters();
}