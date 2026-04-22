package tv.danmaku.bili.fullscreen.service;

import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: ServiceProvider.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/ServiceProvider;", "", "<init>", "()V", "getSmsLoginService", "Ltv/danmaku/bili/fullscreen/service/ISmsLoginService;", "service", "Ltv/danmaku/bili/fullscreen/service/SmsLoginService;", "getPasswordService", "Ltv/danmaku/bili/fullscreen/service/IPasswordLoginService;", "Ltv/danmaku/bili/fullscreen/service/PasswordLoginService;", "getOnePassService", "Ltv/danmaku/bili/fullscreen/service/IPhoneOnePassLoginService;", "Ltv/danmaku/bili/fullscreen/service/PhoneOnePassLoginService;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Module
public abstract class ServiceProvider {
    public static final int $stable = 0;

    @Binds
    public abstract IPhoneOnePassLoginService getOnePassService(PhoneOnePassLoginService phoneOnePassLoginService);

    @Binds
    public abstract IPasswordLoginService getPasswordService(PasswordLoginService passwordLoginService);

    @Binds
    public abstract ISmsLoginService getSmsLoginService(SmsLoginService smsLoginService);
}