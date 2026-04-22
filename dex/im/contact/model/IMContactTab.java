package im.contact.model;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IMContactTabData.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\tR\u0012\u0010\u0019\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016\u0082\u0001\u0002\u001b\u001c¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lim/contact/model/IMContactTab;", "", "status", "Lim/contact/model/IMContactPageStatus;", "getStatus", "()Lim/contact/model/IMContactPageStatus;", ContentDisposition.Parameters.Name, "", "getName", "()Ljava/lang/String;", "showList", "", "Lim/contact/model/IMContactItem;", "getShowList", "()Ljava/util/List;", "currentTab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "getCurrentTab", "()Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "canSearch", "", "getCanSearch", "()Z", "searchWord", "getSearchWord", "inSearch", "getInSearch", "Lim/contact/model/IMContactSearchingTabData;", "Lim/contact/model/IMContactTabData;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMContactTab {
    boolean getCanSearch();

    KContactTabType getCurrentTab();

    boolean getInSearch();

    String getName();

    String getSearchWord();

    List<IMContactItem> getShowList();

    IMContactPageStatus getStatus();
}