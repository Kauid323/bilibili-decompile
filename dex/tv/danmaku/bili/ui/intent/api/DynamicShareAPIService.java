package tv.danmaku.bili.ui.intent.api;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import retrofit2.http.BaseUrl;
import tv.danmaku.bili.BR;

/* compiled from: DynamicShareAPIService.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/intent/api/DynamicShareAPIService;", "", "CheckResult", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@BaseUrl("https://api.bilibili.com")
public interface DynamicShareAPIService {

    /* compiled from: DynamicShareAPIService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/intent/api/DynamicShareAPIService$CheckResult;", "", "<init>", "()V", "checkPackage", "", "getCheckPackage", "()Ljava/lang/Boolean;", "setCheckPackage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CheckResult {
        public static final int $stable = 8;
        @JSONField(name = "check_package")
        private Boolean checkPackage;

        public final Boolean getCheckPackage() {
            return this.checkPackage;
        }

        public final void setCheckPackage(Boolean bool) {
            this.checkPackage = bool;
        }
    }
}