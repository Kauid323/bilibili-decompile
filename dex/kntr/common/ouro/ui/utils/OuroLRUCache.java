package kntr.common.ouro.ui.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroLRUCache.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001$B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\r\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0001¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u001c\u0010\u001d\u001a\u00020\u00112\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0002J\u001c\u0010\u001f\u001a\u00020\u00112\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0002J\u001c\u0010 \u001a\u00020\u00112\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0002J\u0016\u0010!\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\nH\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkntr/common/ouro/ui/utils/OuroLRUCache;", "K", "V", "", "capacity", "", "<init>", "(I)V", "cache", "", "Lkntr/common/ouro/ui/utils/OuroLRUCache$Node;", "head", "tail", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "remove", "clear", "size", "isEmpty", "", "containsKey", "(Ljava/lang/Object;)Z", "keys", "", "addToHead", "node", "removeNode", "moveToHead", "removeTail", "toString", "", "Node", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroLRUCache<K, V> {
    public static final int $stable = 8;
    private final Map<K, Node<K, V>> cache;
    private final int capacity;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public OuroLRUCache(int capacity) {
        this.capacity = capacity;
        if (!(this.capacity > 0)) {
            throw new IllegalArgumentException("Cache size must be positive".toString());
        }
        this.cache = new LinkedHashMap();
        this.head = new Node<>(null, null, null, null, 12, null);
        this.tail = new Node<>(null, null, null, null, 12, null);
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OuroLRUCache.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003BG\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0016\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0017\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000HÆ\u0003J^\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00022\b\b\u0002\u0010\u0005\u001a\u00028\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00002\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u00028\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006#"}, d2 = {"Lkntr/common/ouro/ui/utils/OuroLRUCache$Node;", "K", "V", "", "key", "value", "prev", "next", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Lkntr/common/ouro/ui/utils/OuroLRUCache$Node;Lkntr/common/ouro/ui/utils/OuroLRUCache$Node;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "setValue", "(Ljava/lang/Object;)V", "getPrev", "()Lkntr/common/ouro/ui/utils/OuroLRUCache$Node;", "setPrev", "(Lkntr/common/ouro/ui/utils/OuroLRUCache$Node;)V", "getNext", "setNext", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Lkntr/common/ouro/ui/utils/OuroLRUCache$Node;Lkntr/common/ouro/ui/utils/OuroLRUCache$Node;)Lkntr/common/ouro/ui/utils/OuroLRUCache$Node;", "equals", "", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Node<K, V> {
        private final K key;
        private Node<K, V> next;
        private Node<K, V> prev;
        private V value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Node copy$default(Node node, Object obj, Object obj2, Node node2, Node node3, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = node.key;
            }
            if ((i & 2) != 0) {
                obj2 = node.value;
            }
            if ((i & 4) != 0) {
                node2 = node.prev;
            }
            if ((i & 8) != 0) {
                node3 = node.next;
            }
            return node.copy(obj, obj2, node2, node3);
        }

        public final K component1() {
            return this.key;
        }

        public final V component2() {
            return this.value;
        }

        public final Node<K, V> component3() {
            return this.prev;
        }

        public final Node<K, V> component4() {
            return this.next;
        }

        public final Node<K, V> copy(K k, V v, Node<K, V> node, Node<K, V> node2) {
            return new Node<>(k, v, node, node2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Node) {
                Node node = (Node) obj;
                return Intrinsics.areEqual(this.key, node.key) && Intrinsics.areEqual(this.value, node.value) && Intrinsics.areEqual(this.prev, node.prev) && Intrinsics.areEqual(this.next, node.next);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.key == null ? 0 : this.key.hashCode()) * 31) + (this.value == null ? 0 : this.value.hashCode())) * 31) + (this.prev == null ? 0 : this.prev.hashCode())) * 31) + (this.next != null ? this.next.hashCode() : 0);
        }

        public String toString() {
            K k = this.key;
            V v = this.value;
            Node<K, V> node = this.prev;
            return "Node(key=" + k + ", value=" + v + ", prev=" + node + ", next=" + this.next + ")";
        }

        public Node(K k, V v, Node<K, V> node, Node<K, V> node2) {
            this.key = k;
            this.value = v;
            this.prev = node;
            this.next = node2;
        }

        public /* synthetic */ Node(Object obj, Object obj2, Node node, Node node2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, obj2, (i & 4) != 0 ? null : node, (i & 8) != 0 ? null : node2);
        }

        public final K getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.value;
        }

        public final void setValue(V v) {
            this.value = v;
        }

        public final Node<K, V> getPrev() {
            return this.prev;
        }

        public final void setPrev(Node<K, V> node) {
            this.prev = node;
        }

        public final Node<K, V> getNext() {
            return this.next;
        }

        public final void setNext(Node<K, V> node) {
            this.next = node;
        }
    }

    public final V get(K k) {
        Node node = this.cache.get(k);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.getValue();
    }

    public final void put(K k, V v) {
        Node lastNode;
        Node existingNode = this.cache.get(k);
        if (existingNode != null) {
            existingNode.setValue(v);
            moveToHead(existingNode);
            return;
        }
        Node newNode = new Node(k, v, null, null, 12, null);
        if (this.cache.size() >= this.capacity && (lastNode = removeTail()) != null) {
            this.cache.remove(lastNode.getKey());
        }
        this.cache.put(k, newNode);
        addToHead(newNode);
    }

    public final V remove(K k) {
        Node node = this.cache.remove(k);
        if (node == null) {
            return null;
        }
        removeNode(node);
        return node.getValue();
    }

    public final void clear() {
        this.cache.clear();
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    public final int size() {
        return this.cache.size();
    }

    public final boolean isEmpty() {
        return this.cache.isEmpty();
    }

    public final boolean containsKey(K k) {
        return this.cache.containsKey(k);
    }

    public final List<K> keys() {
        K key;
        List result = new ArrayList();
        Node current = this.head.getNext();
        while (!Intrinsics.areEqual(current, this.tail)) {
            if (current != null && (key = current.getKey()) != null) {
                result.add(key);
            }
            current = current != null ? current.getNext() : null;
        }
        return result;
    }

    private final void addToHead(Node<K, V> node) {
        node.setPrev(this.head);
        node.setNext(this.head.getNext());
        Node<K, V> next = this.head.getNext();
        if (next != null) {
            next.setPrev(node);
        }
        this.head.setNext(node);
    }

    private final void removeNode(Node<K, V> node) {
        Node<K, V> prev = node.getPrev();
        if (prev != null) {
            prev.setNext(node.getNext());
        }
        Node<K, V> next = node.getNext();
        if (next != null) {
            next.setPrev(node.getPrev());
        }
    }

    private final void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private final Node<K, V> removeTail() {
        Node lastNode = this.tail.getPrev();
        if (!Intrinsics.areEqual(lastNode, this.head)) {
            Intrinsics.checkNotNull(lastNode);
            removeNode(lastNode);
            return lastNode;
        }
        return null;
    }

    public String toString() {
        List entries = new ArrayList();
        Node current = this.head.getNext();
        while (!Intrinsics.areEqual(current, this.tail)) {
            if (current != null) {
                Node it = current;
                entries.add(it.getKey() + "=" + it.getValue());
            }
            current = current != null ? current.getNext() : null;
        }
        return "LRUCache(" + CollectionsKt.joinToString$default(entries, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ")";
    }
}