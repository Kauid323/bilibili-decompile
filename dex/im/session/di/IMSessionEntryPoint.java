package im.session.di;

import im.session.di.HomeComponent;
import im.session.di.SecondaryComponent;
import kotlin.Metadata;

/* compiled from: IMSessionModule.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lim/session/di/IMSessionEntryPoint;", "", "getHomeComponentFactory", "Lim/session/di/HomeComponent$Builder;", "getSecondaryComponentFactory", "Lim/session/di/SecondaryComponent$Builder;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSessionEntryPoint {
    HomeComponent.Builder getHomeComponentFactory();

    SecondaryComponent.Builder getSecondaryComponentFactory();
}