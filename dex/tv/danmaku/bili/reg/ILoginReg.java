package tv.danmaku.bili.reg;

import android.content.Context;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: ILoginReg.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/reg/ILoginReg;", "", "showReg", "", "context", "Landroid/content/Context;", "changeRegCheckValue", "", "status", "selectedReg", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ILoginReg {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String TAG = "ILoginReg";

    void changeRegCheckValue(boolean z);

    boolean selectedReg();

    boolean showReg(Context context);

    /* compiled from: ILoginReg.kt */
    /* renamed from: tv.danmaku.bili.reg.ILoginReg$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$showReg(ILoginReg _this, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String switchValue = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), LoginRegHelper.SWITCH_LOGIN_REG_STATUTE, (Object) null, 2, (Object) null);
            if (switchValue == null) {
                switchValue = "0";
            }
            return (Intrinsics.areEqual(switchValue, "0") && BiliAccounts.get(context).hasFirstLogin()) ? false : true;
        }
    }

    /* compiled from: ILoginReg.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/reg/ILoginReg$Companion;", "", "<init>", "()V", "TAG", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String TAG = "ILoginReg";

        private Companion() {
        }
    }
}