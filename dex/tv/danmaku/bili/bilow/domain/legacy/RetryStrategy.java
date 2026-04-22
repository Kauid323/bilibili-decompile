package tv.danmaku.bili.bilow.domain.legacy;

import java.util.ArrayList;
import java.util.List;

public class RetryStrategy implements DomainStrategy {
    private List<String> domainList = new ArrayList(3);

    public RetryStrategy() {
        this.domainList.add("app.bilibili.com");
        this.domainList.add("app.bilibili.com");
        this.domainList.add("app.bilibili.com");
    }

    @Override // tv.danmaku.bili.bilow.domain.legacy.DomainStrategy
    public List<String> domainList() {
        return this.domainList;
    }
}