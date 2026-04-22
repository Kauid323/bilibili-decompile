package j$.util.concurrent;

import j$.sun.misc.DesugarUnsafe;
import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.stream.Stream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements java.util.concurrent.ConcurrentMap<K, V>, Serializable, ConcurrentMap<K, V> {
    private static final int ASHIFT;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MAX_RESIZERS = 65535;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1;
    static final int RESERVED = -3;
    private static final int RESIZE_STAMP_BITS = 16;
    private static final int RESIZE_STAMP_SHIFT = 16;
    static final int TREEBIN = -2;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient CounterCell[] counterCells;
    private transient EntrySetView<K, V> entrySet;
    private transient KeySetView<K, V> keySet;
    private volatile transient Node<K, V>[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient Node<K, V>[] table;
    private volatile transient int transferIndex;
    private transient ValuesView<K, V> values;
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("segments", Segment[].class), new ObjectStreamField("segmentMask", Integer.TYPE), new ObjectStreamField("segmentShift", Integer.TYPE)};
    private static final DesugarUnsafe U = DesugarUnsafe.getUnsafe();
    private static final long SIZECTL = U.objectFieldOffset(ConcurrentHashMap.class, "sizeCtl");
    private static final long TRANSFERINDEX = U.objectFieldOffset(ConcurrentHashMap.class, "transferIndex");
    private static final long BASECOUNT = U.objectFieldOffset(ConcurrentHashMap.class, "baseCount");
    private static final long CELLSBUSY = U.objectFieldOffset(ConcurrentHashMap.class, "cellsBusy");
    private static final long CELLVALUE = U.objectFieldOffset(CounterCell.class, "value");
    private static final int ABASE = U.arrayBaseOffset(Node[].class);

    static {
        int scale = U.arrayIndexScale(Node[].class);
        if (((scale + MOVED) & scale) != 0) {
            throw new ExceptionInInitializerError("array index scale not a power of two");
        }
        ASHIFT = 31 - Integer.numberOfLeadingZeros(scale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        volatile Node<K, V> next;
        volatile V val;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        Node(int hash, K key, V val) {
            this.hash = hash;
            this.key = key;
            this.val = val;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        Node(int hash, K key, V val, Node<K, V> node) {
            this(hash, key, val);
            this.next = node;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.val;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        public final String toString() {
            return Helpers.mapEntryToString(this.key, this.val);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.Map.Entry
        public final V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.Map.Entry
        public final boolean equals(Object o) {
            Map.Entry<?, ?> e;
            Object k;
            Object v;
            Object u;
            return (o instanceof Map.Entry) && (k = (e = (Map.Entry) o).getKey()) != null && (v = e.getValue()) != null && (k == this.key || k.equals(this.key)) && (v == (u = this.val) || v.equals(u));
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        Node<K, V> find(int h, Object k) {
            Node<K, V> node;
            K ek;
            Node<K, V> node2 = this;
            if (k != null) {
                do {
                    if (node2.hash == h && ((ek = node2.key) == k || (ek != null && k.equals(ek)))) {
                        return node2;
                    }
                    node = node2.next;
                    node2 = node;
                } while (node != null);
                return null;
            }
            return null;
        }
    }

    static final int spread(int h) {
        return ((h >>> 16) ^ h) & HASH_BITS;
    }

    private static final int tableSizeFor(int c) {
        int n = MOVED >>> Integer.numberOfLeadingZeros(c + MOVED);
        if (n < 0) {
            return 1;
        }
        return n >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : n + 1;
    }

    static Class<?> comparableClassFor(Object x) {
        Type[] as;
        if (x instanceof Comparable) {
            Class<?> c = x.getClass();
            if (c == String.class) {
                return c;
            }
            Type[] ts = c.getGenericInterfaces();
            if (ts != null) {
                for (Type t : ts) {
                    if (t instanceof ParameterizedType) {
                        ParameterizedType p = (ParameterizedType) t;
                        if (p.getRawType() == Comparable.class && (as = p.getActualTypeArguments()) != null && as.length == 1 && as[0] == c) {
                            return c;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    static int compareComparables(Class<?> kc, Object k, Object x) {
        if (x == null || x.getClass() != kc) {
            return 0;
        }
        return ((Comparable) k).compareTo(x);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    static final <K, V> Node<K, V> tabAt(Node<K, V>[] nodeArr, int i) {
        return (Node) U.getObjectAcquire(nodeArr, (i << ASHIFT) + ABASE);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    static final <K, V> boolean casTabAt(Node<K, V>[] nodeArr, int i, Node<K, V> node, Node<K, V> node2) {
        return U.compareAndSetObject(nodeArr, (i << ASHIFT) + ABASE, node, node2);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    static final <K, V> void setTabAt(Node<K, V>[] nodeArr, int i, Node<K, V> node) {
        U.putObjectRelease(nodeArr, (i << ASHIFT) + ABASE, node);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public ConcurrentHashMap() {
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public ConcurrentHashMap(int initialCapacity) {
        this(initialCapacity, LOAD_FACTOR, 1);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public ConcurrentHashMap(Map<? extends K, ? extends V> m) {
        this.sizeCtl = 16;
        putAll(m);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public ConcurrentHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, 1);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel) {
        if (loadFactor <= 0.0f || initialCapacity < 0 || concurrencyLevel <= 0) {
            throw new IllegalArgumentException();
        }
        long size = (long) (((initialCapacity < concurrencyLevel ? concurrencyLevel : initialCapacity) / loadFactor) + 1.0d);
        int cap = size >= 1073741824 ? MAXIMUM_CAPACITY : tableSizeFor((int) size);
        this.sizeCtl = cap;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long n = sumCount();
        if (n < 0) {
            return 0;
        }
        return n > 2147483647L ? HASH_BITS : (int) n;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        int n;
        K ek;
        int h = spread(key.hashCode());
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null && (n = nodeArr.length) > 0) {
            Node<K, V> tabAt = tabAt(nodeArr, (n + MOVED) & h);
            Node<K, V> node = tabAt;
            if (tabAt != null) {
                int eh = node.hash;
                if (eh == h) {
                    K ek2 = node.key;
                    if (ek2 == key || (ek2 != null && key.equals(ek2))) {
                        return node.val;
                    }
                } else if (eh < 0) {
                    Node<K, V> find = node.find(h, key);
                    if (find != null) {
                        return find.val;
                    }
                    return null;
                }
                while (true) {
                    Node<K, V> node2 = node.next;
                    node = node2;
                    if (node2 == null) {
                        break;
                    } else if (node.hash != h || ((ek = node.key) != key && (ek == null || !key.equals(ek)))) {
                    }
                }
                return node.val;
            }
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                V v = advance.val;
                if (v == value) {
                    return true;
                }
                if (v != null && value.equals(v)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        return putVal(key, value, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ad, code lost:
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bb, code lost:
        addCount(1, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c0, code lost:
        return null;
     */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final V putVal(K key, V value, boolean onlyIfAbsent) {
        K ek;
        K fk;
        V fv;
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        int hash = spread(key.hashCode());
        int binCount = 0;
        Node<K, V>[] nodeArr = this.table;
        while (true) {
            if (nodeArr != null) {
                int n = nodeArr.length;
                if (n != 0) {
                    int i = (n + MOVED) & hash;
                    Node<K, V> tabAt = tabAt(nodeArr, i);
                    if (tabAt == null) {
                        if (casTabAt(nodeArr, i, null, new Node(hash, key, value))) {
                            break;
                        }
                    } else {
                        int fh = tabAt.hash;
                        if (fh == MOVED) {
                            nodeArr = helpTransfer(nodeArr, tabAt);
                        } else if (onlyIfAbsent && fh == hash && (((fk = tabAt.key) == key || (fk != null && key.equals(fk))) && (fv = tabAt.val) != null)) {
                            return fv;
                        } else {
                            V oldVal = null;
                            synchronized (tabAt) {
                                if (tabAt(nodeArr, i) == tabAt) {
                                    if (fh >= 0) {
                                        binCount = 1;
                                        Node<K, V> node = tabAt;
                                        while (true) {
                                            if (node.hash != hash || ((ek = node.key) != key && (ek == null || !key.equals(ek)))) {
                                                Node<K, V> node2 = node;
                                                Node<K, V> node3 = node.next;
                                                node = node3;
                                                if (node3 == null) {
                                                    node2.next = new Node<>(hash, key, value);
                                                    break;
                                                }
                                                binCount++;
                                            }
                                        }
                                        oldVal = node.val;
                                        if (!onlyIfAbsent) {
                                            node.val = value;
                                        }
                                    } else if (tabAt instanceof TreeBin) {
                                        binCount = 2;
                                        TreeNode<K, V> putTreeVal = ((TreeBin) tabAt).putTreeVal(hash, key, value);
                                        if (putTreeVal != null) {
                                            oldVal = putTreeVal.val;
                                            if (!onlyIfAbsent) {
                                                putTreeVal.val = value;
                                            }
                                        }
                                    } else if (tabAt instanceof ReservationNode) {
                                        break;
                                    }
                                }
                            }
                            if (binCount != 0) {
                                if (binCount >= 8) {
                                    treeifyBin(nodeArr, i);
                                }
                                if (oldVal != null) {
                                    return oldVal;
                                }
                            }
                        }
                    }
                }
            }
            nodeArr = initTable();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m) {
        tryPresize(m.size());
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            putVal(e.getKey(), e.getValue(), false);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        return replaceNode(key, null, null);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
    final V replaceNode(Object key, V value, Object cv) {
        int i;
        Node<K, V> tabAt;
        TreeNode<K, V> findTreeNode;
        K ek;
        Object obj = key;
        int hash = spread(key.hashCode());
        Node<K, V>[] nodeArr = this.table;
        while (nodeArr != null) {
            int n = nodeArr.length;
            if (n != 0 && (tabAt = tabAt(nodeArr, (i = (n + MOVED) & hash))) != null) {
                int fh = tabAt.hash;
                if (fh == MOVED) {
                    nodeArr = helpTransfer(nodeArr, tabAt);
                } else {
                    V oldVal = null;
                    boolean validated = false;
                    synchronized (tabAt) {
                        if (tabAt(nodeArr, i) == tabAt) {
                            if (fh >= 0) {
                                validated = true;
                                Node<K, V> node = tabAt;
                                Node<K, V> node2 = null;
                                while (true) {
                                    if (node.hash != hash || ((ek = node.key) != obj && (ek == null || !obj.equals(ek)))) {
                                        node2 = node;
                                        Node<K, V> node3 = node.next;
                                        node = node3;
                                        if (node3 == null) {
                                            break;
                                        }
                                    }
                                }
                                V ev = node.val;
                                if (cv == null || cv == ev || (ev != null && cv.equals(ev))) {
                                    oldVal = ev;
                                    if (value != null) {
                                        node.val = value;
                                    } else if (node2 != null) {
                                        node2.next = node.next;
                                    } else {
                                        setTabAt(nodeArr, i, node.next);
                                    }
                                }
                            } else if (tabAt instanceof TreeBin) {
                                validated = true;
                                TreeBin treeBin = (TreeBin) tabAt;
                                TreeNode<K, V> treeNode = treeBin.root;
                                if (treeNode != null && (findTreeNode = treeNode.findTreeNode(hash, obj, null)) != null) {
                                    V pv = findTreeNode.val;
                                    if (cv == null || cv == pv || (pv != null && cv.equals(pv))) {
                                        oldVal = pv;
                                        if (value != null) {
                                            findTreeNode.val = value;
                                        } else if (treeBin.removeTreeNode(findTreeNode)) {
                                            setTabAt(nodeArr, i, untreeify(treeBin.first));
                                        }
                                    }
                                }
                            } else if (tabAt instanceof ReservationNode) {
                                throw new IllegalStateException("Recursive update");
                            }
                        }
                    }
                    if (validated) {
                        if (oldVal != null) {
                            if (value == null) {
                                addCount(-1L, MOVED);
                            }
                            return oldVal;
                        }
                        return null;
                    }
                }
                obj = key;
            } else {
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x004c -> B:35:0x004d). Please submit an issue!!! */
    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Node<K, V> node;
        long delta = 0;
        int i = 0;
        Node<K, V>[] nodeArr = this.table;
        while (nodeArr != null && i < nodeArr.length) {
            Node<K, V> tabAt = tabAt(nodeArr, i);
            if (tabAt == null) {
                i++;
            } else {
                int fh = tabAt.hash;
                if (fh == MOVED) {
                    nodeArr = helpTransfer(nodeArr, tabAt);
                    i = 0;
                } else {
                    synchronized (tabAt) {
                        try {
                            if (tabAt(nodeArr, i) == tabAt) {
                                if (fh >= 0) {
                                    node = tabAt;
                                } else if (!(tabAt instanceof TreeBin)) {
                                    node = null;
                                } else {
                                    node = ((TreeBin) tabAt).first;
                                }
                                while (node != null) {
                                    delta--;
                                    node = node.next;
                                }
                                int i2 = i + 1;
                                try {
                                    setTabAt(nodeArr, i, null);
                                    i = i2;
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
        }
        if (delta != 0) {
            addCount(delta, MOVED);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        KeySetView<K, V> keySetView = this.keySet;
        if (keySetView != null) {
            return keySetView;
        }
        KeySetView<K, V> keySetView2 = new KeySetView<>(this, null);
        this.keySet = keySetView2;
        return keySetView2;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        ValuesView<K, V> valuesView = this.values;
        if (valuesView != null) {
            return valuesView;
        }
        ValuesView<K, V> valuesView2 = new ValuesView<>(this);
        this.values = valuesView2;
        return valuesView2;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySetView<K, V> entrySetView = this.entrySet;
        if (entrySetView != null) {
            return entrySetView;
        }
        EntrySetView<K, V> entrySetView2 = new EntrySetView<>(this);
        this.entrySet = entrySetView2;
        return entrySetView2;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int h = 0;
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                h += advance.key.hashCode() ^ advance.val.hashCode();
            }
        }
        return h;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
    @Override // java.util.AbstractMap
    public String toString() {
        Node<K, V>[] nodeArr = this.table;
        int f = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, f, 0, f);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Node<K, V> advance = traverser.advance();
        Node<K, V> node = advance;
        if (advance != null) {
            while (true) {
                K k = node.key;
                V v = node.val;
                sb.append(k == this ? "(this Map)" : k);
                sb.append('=');
                sb.append(v != this ? v : "(this Map)");
                Node<K, V> advance2 = traverser.advance();
                node = advance2;
                if (advance2 == null) {
                    break;
                }
                sb.append(',').append(' ');
            }
        }
        return sb.append('}').toString();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object o) {
        Object mv;
        Object v;
        if (o != this) {
            if (o instanceof Map) {
                Map<?, ?> m = (Map) o;
                Node<K, V>[] nodeArr = this.table;
                int f = nodeArr == null ? 0 : nodeArr.length;
                Traverser traverser = new Traverser(nodeArr, f, 0, f);
                while (true) {
                    Node<K, V> advance = traverser.advance();
                    if (advance != null) {
                        V val = advance.val;
                        Object v2 = m.get(advance.key);
                        if (v2 == null || (v2 != val && !v2.equals(val))) {
                            break;
                        }
                    } else {
                        for (Map.Entry<?, ?> e : m.entrySet()) {
                            Object mk = e.getKey();
                            if (mk == null || (mv = e.getValue()) == null || (v = get(mk)) == null || (mv != v && !mv.equals(v))) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static class Segment<K, V> extends ReentrantLock implements Serializable {
        private static final long serialVersionUID = 2249069246763182397L;
        final float loadFactor;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Segment != java.util.concurrent.ConcurrentHashMap$Segment<K, V> */
        Segment(float lf) {
            this.loadFactor = lf;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Segment[] != java.util.concurrent.ConcurrentHashMap$Segment<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
    private void writeObject(ObjectOutputStream s) {
        int sshift = 0;
        int ssize = 1;
        while (ssize < 16) {
            sshift++;
            ssize <<= 1;
        }
        int segmentShift = 32 - sshift;
        int segmentMask = ssize + MOVED;
        Segment[] segmentArr = new Segment[16];
        for (int i = 0; i < segmentArr.length; i++) {
            segmentArr[i] = new Segment(LOAD_FACTOR);
        }
        ObjectOutputStream.PutField streamFields = s.putFields();
        streamFields.put("segments", segmentArr);
        streamFields.put("segmentShift", segmentShift);
        streamFields.put("segmentMask", segmentMask);
        s.writeFields();
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                s.writeObject(advance.key);
                s.writeObject(advance.val);
            }
        }
        s.writeObject(null);
        s.writeObject(null);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
    private void readObject(ObjectInputStream s) {
        Node<K, V> node;
        long size;
        long ts;
        int mask;
        boolean insertAtFront;
        K qk;
        long j;
        this.sizeCtl = MOVED;
        s.defaultReadObject();
        long size2 = 0;
        Node<K, V> node2 = null;
        while (true) {
            Object readObject = s.readObject();
            Object readObject2 = s.readObject();
            if (readObject == null || readObject2 == null) {
                break;
            }
            node2 = new Node<>(spread(readObject.hashCode()), readObject, readObject2, node2);
            size2++;
        }
        if (size2 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long ts2 = (long) ((((float) size2) / LOAD_FACTOR) + 1.0d);
        int n = ts2 >= 1073741824 ? MAXIMUM_CAPACITY : tableSizeFor((int) ts2);
        Node<K, V>[] nodeArr = new Node[n];
        int mask2 = n + MOVED;
        long added = 0;
        while (node2 != null) {
            Node<K, V> node3 = node2.next;
            int h = node2.hash;
            int j2 = h & mask2;
            Node<K, V> tabAt = tabAt(nodeArr, j2);
            if (tabAt == null) {
                ts = ts2;
                mask = mask2;
                insertAtFront = true;
                node = tabAt;
                size = size2;
            } else {
                K k = node2.key;
                node = tabAt;
                size = size2;
                if (node.hash < 0) {
                    if (((TreeBin) node).putTreeVal(h, k, node2.val) == null) {
                        added++;
                    }
                    insertAtFront = false;
                    ts = ts2;
                    mask = mask2;
                } else {
                    int binCount = 0;
                    boolean insertAtFront2 = true;
                    Node<K, V> node4 = node;
                    while (node4 != null) {
                        ts = ts2;
                        if (node4.hash == h && ((qk = node4.key) == k || (qk != null && k.equals(qk)))) {
                            insertAtFront2 = false;
                            break;
                        }
                        binCount++;
                        node4 = node4.next;
                        ts2 = ts;
                    }
                    ts = ts2;
                    if (insertAtFront2 && binCount >= 8) {
                        boolean insertAtFront3 = false;
                        added++;
                        node2.next = node;
                        TreeNode<K, V> treeNode = null;
                        Node<K, V> node5 = node2;
                        TreeNode<K, V> treeNode2 = null;
                        while (node5 != null) {
                            boolean insertAtFront4 = insertAtFront3;
                            K k2 = k;
                            int mask3 = mask2;
                            TreeNode<K, V> treeNode3 = new TreeNode<>(node5.hash, node5.key, node5.val, null, null);
                            treeNode3.prev = treeNode2;
                            if (treeNode2 == null) {
                                treeNode = treeNode3;
                            } else {
                                treeNode2.next = treeNode3;
                            }
                            treeNode2 = treeNode3;
                            node5 = node5.next;
                            insertAtFront3 = insertAtFront4;
                            k = k2;
                            mask2 = mask3;
                        }
                        insertAtFront = insertAtFront3;
                        mask = mask2;
                        setTabAt(nodeArr, j2, new TreeBin(treeNode));
                    } else {
                        mask = mask2;
                        insertAtFront = insertAtFront2;
                    }
                }
            }
            if (!insertAtFront) {
                j = 1;
            } else {
                j = 1;
                added++;
                node2.next = node;
                setTabAt(nodeArr, j2, node2);
            }
            node2 = node3;
            size2 = size;
            ts2 = ts;
            mask2 = mask;
        }
        this.table = nodeArr;
        this.sizeCtl = n - (n >>> 2);
        this.baseCount = added;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V putIfAbsent(K key, V value) {
        return putVal(key, value, true);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object key, Object value) {
        if (key != null) {
            return (value == null || replaceNode(key, null, value) == null) ? false : true;
        }
        throw new NullPointerException();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean replace(K key, V oldValue, V newValue) {
        if (key == null || oldValue == null || newValue == null) {
            throw new NullPointerException();
        }
        return replaceNode(key, newValue, oldValue) != null;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V replace(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        return replaceNode(key, value, null);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public V getOrDefault(Object key, V defaultValue) {
        V v = get(key);
        return v == null ? defaultValue : v;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public void forEach(BiConsumer<? super K, ? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance != null) {
                    action.accept((K) advance.key, (V) advance.val);
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        V v;
        if (function == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance != null) {
                    V v2 = advance.val;
                    Object obj = (K) advance.key;
                    do {
                        V newValue = function.apply(obj, v2);
                        if (newValue == null) {
                            throw new NullPointerException();
                        }
                        if (replaceNode(obj, newValue, v2) == null) {
                            v = get(obj);
                            V oldValue = v;
                            v2 = (Object) oldValue;
                        }
                    } while (v != null);
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
    boolean removeEntryIf(Predicate<? super Map.Entry<K, V>> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        boolean removed = false;
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                K k = advance.key;
                V v = advance.val;
                Map.Entry<K, V> e = new AbstractMap.SimpleImmutableEntry<>(k, v);
                if (function.test(e) && replaceNode(k, null, v) != null) {
                    removed = true;
                }
            }
        }
        return removed;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
    boolean removeValueIf(Predicate<? super V> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        boolean removed = false;
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                K k = advance.key;
                Object obj = (V) advance.val;
                if (function.test(obj) && replaceNode(k, null, obj) != null) {
                    removed = true;
                }
            }
        }
        return removed;
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x00f9, code lost:
        if (r1 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00fb, code lost:
        addCount(1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0100, code lost:
        return r1;
     */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        TreeNode<K, V> findTreeNode;
        K ek;
        K fk;
        V fv;
        if (key == null || mappingFunction == null) {
            throw new NullPointerException();
        }
        int h = spread(key.hashCode());
        V val = null;
        int binCount = 0;
        Node<K, V>[] nodeArr = this.table;
        while (true) {
            if (nodeArr != null) {
                int n = nodeArr.length;
                if (n != 0) {
                    int i = (n + MOVED) & h;
                    Node<K, V> tabAt = tabAt(nodeArr, i);
                    if (tabAt == null) {
                        ReservationNode reservationNode = new ReservationNode();
                        synchronized (reservationNode) {
                            if (casTabAt(nodeArr, i, null, reservationNode)) {
                                binCount = 1;
                                Node node = null;
                                V apply = mappingFunction.apply(key);
                                val = apply;
                                if (apply != null) {
                                    node = new Node(h, key, val);
                                }
                                setTabAt(nodeArr, i, node);
                            }
                        }
                        if (binCount != 0) {
                            break;
                        }
                    } else {
                        int fh = tabAt.hash;
                        if (fh == MOVED) {
                            nodeArr = helpTransfer(nodeArr, tabAt);
                        } else if (fh == h && (((fk = tabAt.key) == key || (fk != null && key.equals(fk))) && (fv = tabAt.val) != null)) {
                            return fv;
                        } else {
                            boolean added = false;
                            synchronized (tabAt) {
                                if (tabAt(nodeArr, i) == tabAt) {
                                    if (fh >= 0) {
                                        binCount = 1;
                                        Node<K, V> node2 = tabAt;
                                        while (true) {
                                            if (node2.hash != h || ((ek = node2.key) != key && (ek == null || !key.equals(ek)))) {
                                                Node<K, V> node3 = node2;
                                                Node<K, V> node4 = node2.next;
                                                node2 = node4;
                                                if (node4 == null) {
                                                    V apply2 = mappingFunction.apply(key);
                                                    val = apply2;
                                                    if (apply2 != null) {
                                                        if (node3.next != null) {
                                                            throw new IllegalStateException("Recursive update");
                                                        }
                                                        added = true;
                                                        node3.next = new Node<>(h, key, val);
                                                    }
                                                } else {
                                                    binCount++;
                                                }
                                            }
                                        }
                                        val = node2.val;
                                    } else if (tabAt instanceof TreeBin) {
                                        binCount = 2;
                                        TreeBin treeBin = (TreeBin) tabAt;
                                        TreeNode<K, V> treeNode = treeBin.root;
                                        if (treeNode != null && (findTreeNode = treeNode.findTreeNode(h, key, null)) != null) {
                                            val = findTreeNode.val;
                                        } else {
                                            V apply3 = mappingFunction.apply(key);
                                            val = apply3;
                                            if (apply3 != null) {
                                                added = true;
                                                treeBin.putTreeVal(h, key, val);
                                            }
                                        }
                                    } else if (tabAt instanceof ReservationNode) {
                                        throw new IllegalStateException("Recursive update");
                                    }
                                }
                            }
                            if (binCount != 0) {
                                if (binCount >= 8) {
                                    treeifyBin(nodeArr, i);
                                }
                                if (!added) {
                                    return val;
                                }
                            }
                        }
                    }
                }
            }
            nodeArr = initTable();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b0, code lost:
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        TreeNode<K, V> findTreeNode;
        K ek;
        if (key == null || remappingFunction == null) {
            throw new NullPointerException();
        }
        int h = spread(key.hashCode());
        V val = null;
        int delta = 0;
        int binCount = 0;
        Node<K, V>[] nodeArr = this.table;
        while (true) {
            if (nodeArr != null) {
                int n = nodeArr.length;
                if (n != 0) {
                    int i = (n + MOVED) & h;
                    Node<K, V> tabAt = tabAt(nodeArr, i);
                    if (tabAt == null) {
                        break;
                    }
                    int fh = tabAt.hash;
                    if (fh == MOVED) {
                        nodeArr = helpTransfer(nodeArr, tabAt);
                    } else {
                        synchronized (tabAt) {
                            if (tabAt(nodeArr, i) == tabAt) {
                                if (fh >= 0) {
                                    binCount = 1;
                                    Node<K, V> node = tabAt;
                                    Node<K, V> node2 = null;
                                    while (true) {
                                        if (node.hash != h || ((ek = node.key) != key && (ek == null || !key.equals(ek)))) {
                                            node2 = node;
                                            Node<K, V> node3 = node.next;
                                            node = node3;
                                            if (node3 == null) {
                                                break;
                                            }
                                            binCount++;
                                        }
                                    }
                                    val = remappingFunction.apply(key, (V) node.val);
                                    if (val != null) {
                                        node.val = val;
                                    } else {
                                        delta = MOVED;
                                        Node<K, V> node4 = node.next;
                                        if (node2 != null) {
                                            node2.next = node4;
                                        } else {
                                            setTabAt(nodeArr, i, node4);
                                        }
                                    }
                                } else if (tabAt instanceof TreeBin) {
                                    binCount = 2;
                                    TreeBin treeBin = (TreeBin) tabAt;
                                    TreeNode<K, V> treeNode = treeBin.root;
                                    if (treeNode != null && (findTreeNode = treeNode.findTreeNode(h, key, null)) != null) {
                                        val = remappingFunction.apply(key, (V) findTreeNode.val);
                                        if (val != null) {
                                            findTreeNode.val = val;
                                        } else {
                                            delta = MOVED;
                                            if (treeBin.removeTreeNode(findTreeNode)) {
                                                setTabAt(nodeArr, i, untreeify(treeBin.first));
                                            }
                                        }
                                    }
                                } else if (tabAt instanceof ReservationNode) {
                                    break;
                                }
                            }
                        }
                        if (binCount != 0) {
                            break;
                        }
                    }
                }
            }
            nodeArr = initTable();
        }
        if (delta != 0) {
            addCount(delta, binCount);
        }
        return val;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b3, code lost:
        r5 = r20.apply(r2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b8, code lost:
        if (r5 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bc, code lost:
        if (r0.next != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00be, code lost:
        r6 = 1;
        r0.next = new j$.util.concurrent.ConcurrentHashMap.Node<>(r4, r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ce, code lost:
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        TreeNode<K, V> treeNode;
        K ek;
        Object obj = key;
        if (obj == null || remappingFunction == null) {
            throw new NullPointerException();
        }
        int h = spread(key.hashCode());
        Node<K, V>[] nodeArr = this.table;
        int binCount = 0;
        int delta = 0;
        V val = null;
        Object obj2 = obj;
        while (true) {
            if (nodeArr != null) {
                int n = nodeArr.length;
                if (n != 0) {
                    int i = (n + MOVED) & h;
                    Node<K, V> tabAt = tabAt(nodeArr, i);
                    V v = (Object) null;
                    if (tabAt == null) {
                        ReservationNode reservationNode = new ReservationNode();
                        synchronized (reservationNode) {
                            if (casTabAt(nodeArr, i, null, reservationNode)) {
                                binCount = 1;
                                Node node = null;
                                V apply = remappingFunction.apply(obj2, null);
                                val = apply;
                                if (apply != null) {
                                    delta = 1;
                                    node = new Node(h, obj2, val);
                                }
                                setTabAt(nodeArr, i, node);
                            }
                        }
                        if (binCount != 0) {
                            break;
                        }
                        obj2 = key;
                    } else {
                        int fh = tabAt.hash;
                        if (fh == MOVED) {
                            nodeArr = helpTransfer(nodeArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                try {
                                    if (tabAt(nodeArr, i) == tabAt) {
                                        if (fh >= 0) {
                                            Node<K, V> node2 = tabAt;
                                            int binCount2 = 1;
                                            Node<K, V> node3 = null;
                                            while (true) {
                                                try {
                                                    if (node2.hash != h || ((ek = node2.key) != obj2 && (ek == null || !obj2.equals(ek)))) {
                                                        node3 = node2;
                                                        Node<K, V> node4 = node2.next;
                                                        node2 = node4;
                                                        if (node4 == null) {
                                                            break;
                                                        }
                                                        binCount2++;
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    throw th;
                                                }
                                            }
                                            val = remappingFunction.apply(obj2, (V) node2.val);
                                            if (val != null) {
                                                node2.val = val;
                                            } else {
                                                delta = MOVED;
                                                Node<K, V> node5 = node2.next;
                                                if (node3 != null) {
                                                    node3.next = node5;
                                                } else {
                                                    setTabAt(nodeArr, i, node5);
                                                }
                                            }
                                            binCount = binCount2;
                                        } else if (tabAt instanceof TreeBin) {
                                            binCount = 1;
                                            TreeBin treeBin = (TreeBin) tabAt;
                                            TreeNode<K, V> treeNode2 = treeBin.root;
                                            if (treeNode2 != null) {
                                                treeNode = treeNode2.findTreeNode(h, obj2, null);
                                            } else {
                                                treeNode = null;
                                            }
                                            if (treeNode != null) {
                                                v = treeNode.val;
                                            }
                                            val = remappingFunction.apply(obj2, v);
                                            if (val != null) {
                                                if (treeNode != null) {
                                                    treeNode.val = val;
                                                } else {
                                                    delta = 1;
                                                    treeBin.putTreeVal(h, obj2, val);
                                                }
                                            } else if (treeNode != null) {
                                                delta = MOVED;
                                                if (treeBin.removeTreeNode(treeNode)) {
                                                    setTabAt(nodeArr, i, untreeify(treeBin.first));
                                                }
                                            }
                                        } else if (tabAt instanceof ReservationNode) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                    if (binCount != 0) {
                                        if (binCount >= 8) {
                                            treeifyBin(nodeArr, i);
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                        obj2 = key;
                    }
                }
            }
            nodeArr = initTable();
            obj2 = key;
        }
        if (delta != 0) {
            addCount(delta, binCount);
        }
        return val;
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0117, code lost:
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:124:? -> B:108:0x0137). Please submit an issue!!! */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        V val;
        V val2;
        int delta;
        V val3;
        K k = key;
        if (k == null || value == null || remappingFunction == null) {
            throw new NullPointerException();
        }
        int h = spread(key.hashCode());
        Node<K, V>[] nodeArr = this.table;
        int binCount = 0;
        int delta2 = 0;
        V val4 = null;
        while (true) {
            if (nodeArr == null) {
                val = val4;
            } else {
                int n = nodeArr.length;
                if (n == 0) {
                    val = val4;
                } else {
                    int i = (n + MOVED) & h;
                    Node<K, V> tabAt = tabAt(nodeArr, i);
                    TreeNode<K, V> treeNode = null;
                    if (tabAt != null) {
                        int delta3 = tabAt.hash;
                        if (delta3 == MOVED) {
                            nodeArr = helpTransfer(nodeArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                try {
                                } catch (Throwable th) {
                                    th = th;
                                }
                                try {
                                    if (tabAt(nodeArr, i) == tabAt) {
                                        if (delta3 >= 0) {
                                            Node<K, V> node = tabAt;
                                            int binCount2 = 1;
                                            Node<K, V> node2 = null;
                                            while (true) {
                                                try {
                                                    if (node.hash == h) {
                                                        K ek = node.key;
                                                        if (ek == k) {
                                                            break;
                                                        } else if (ek != null) {
                                                            try {
                                                                if (k.equals(ek)) {
                                                                    break;
                                                                }
                                                                val3 = val4;
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                throw th;
                                                            }
                                                        } else {
                                                            val3 = val4;
                                                        }
                                                    } else {
                                                        val3 = val4;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                }
                                                try {
                                                    node2 = node;
                                                    Node<K, V> node3 = node.next;
                                                    node = node3;
                                                    if (node3 == null) {
                                                        delta2 = 1;
                                                        val4 = value;
                                                        node2.next = new Node<>(h, k, val4);
                                                        break;
                                                    }
                                                    binCount2++;
                                                    val4 = val3;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    throw th;
                                                }
                                            }
                                            V val5 = node.val;
                                            val4 = remappingFunction.apply(val5, value);
                                            if (val4 != null) {
                                                node.val = val4;
                                            } else {
                                                delta2 = MOVED;
                                                Node<K, V> node4 = node.next;
                                                if (node2 != null) {
                                                    node2.next = node4;
                                                } else {
                                                    setTabAt(nodeArr, i, node4);
                                                }
                                                val4 = val4;
                                            }
                                            binCount = binCount2;
                                        } else {
                                            val2 = val4;
                                            try {
                                                if (!(tabAt instanceof TreeBin)) {
                                                    if (tabAt instanceof ReservationNode) {
                                                        break;
                                                    }
                                                } else {
                                                    binCount = 2;
                                                    TreeBin treeBin = (TreeBin) tabAt;
                                                    TreeNode<K, V> treeNode2 = treeBin.root;
                                                    if (treeNode2 != null) {
                                                        treeNode = treeNode2.findTreeNode(h, k, null);
                                                    }
                                                    V val6 = treeNode == null ? value : remappingFunction.apply((V) treeNode.val, value);
                                                    if (val6 != null) {
                                                        if (treeNode != null) {
                                                            try {
                                                                treeNode.val = val6;
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                throw th;
                                                            }
                                                        } else {
                                                            delta2 = 1;
                                                            treeBin.putTreeVal(h, k, val6);
                                                        }
                                                    } else if (treeNode != null) {
                                                        delta2 = MOVED;
                                                        if (treeBin.removeTreeNode(treeNode)) {
                                                            setTabAt(nodeArr, i, untreeify(treeBin.first));
                                                        }
                                                    }
                                                    val4 = val6;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                            }
                                        }
                                        if (binCount == 0) {
                                            if (binCount >= 8) {
                                                treeifyBin(nodeArr, i);
                                            }
                                            delta = delta2;
                                        }
                                    } else {
                                        val2 = val4;
                                    }
                                    if (binCount == 0) {
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    throw th;
                                }
                                val4 = val2;
                            }
                        }
                        k = key;
                    } else if (casTabAt(nodeArr, i, null, new Node(h, k, value))) {
                        delta = 1;
                        val4 = value;
                        break;
                    } else {
                        k = key;
                    }
                }
            }
            nodeArr = initTable();
            val4 = val;
            k = key;
        }
        if (delta != 0) {
            addCount(delta, binCount);
        }
        return val4;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public boolean contains(Object value) {
        return containsValue(value);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    public Enumeration<K> keys() {
        Node<K, V>[] nodeArr = this.table;
        int f = nodeArr == null ? 0 : nodeArr.length;
        return new KeyIterator(nodeArr, f, 0, f, this);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    public Enumeration<V> elements() {
        Node<K, V>[] nodeArr = this.table;
        int f = nodeArr == null ? 0 : nodeArr.length;
        return new ValueIterator(nodeArr, f, 0, f, this);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public long mappingCount() {
        long n = sumCount();
        if (n < 0) {
            return 0L;
        }
        return n;
    }

    public static <K> KeySetView<K, Boolean> newKeySet() {
        return new KeySetView<>(new ConcurrentHashMap(), Boolean.TRUE);
    }

    public static <K> KeySetView<K, Boolean> newKeySet(int initialCapacity) {
        return new KeySetView<>(new ConcurrentHashMap(initialCapacity), Boolean.TRUE);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public KeySetView<K, V> keySet(V mappedValue) {
        if (mappedValue == null) {
            throw new NullPointerException();
        }
        return new KeySetView<>(this, mappedValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class ForwardingNode<K, V> extends Node<K, V> {
        final Node<K, V>[] nextTable;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForwardingNode != java.util.concurrent.ConcurrentHashMap$ForwardingNode<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        ForwardingNode(Node<K, V>[] nodeArr) {
            super(ConcurrentHashMap.MOVED, null, null);
            this.nextTable = nodeArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
            if ((r4 instanceof j$.util.concurrent.ConcurrentHashMap.ForwardingNode) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:
            r0 = ((j$.util.concurrent.ConcurrentHashMap.ForwardingNode) r4).nextTable;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
            return r4.find(r8, r9);
         */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForwardingNode != java.util.concurrent.ConcurrentHashMap$ForwardingNode<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Node<K, V> find(int h, Object k) {
            int n;
            K ek;
            Node<K, V>[] nodeArr = this.nextTable;
            loop0: while (k != null && nodeArr != null && (n = nodeArr.length) != 0) {
                Node<K, V> tabAt = ConcurrentHashMap.tabAt(nodeArr, (n + ConcurrentHashMap.MOVED) & h);
                Node<K, V> node = tabAt;
                if (tabAt == null) {
                    break;
                }
                while (true) {
                    int eh = node.hash;
                    if (eh != h || ((ek = node.key) != k && (ek == null || !k.equals(ek)))) {
                        if (eh < 0) {
                            break;
                        }
                        Node<K, V> node2 = node.next;
                        node = node2;
                        if (node2 == null) {
                            return null;
                        }
                    }
                }
                return node;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class ReservationNode<K, V> extends Node<K, V> {
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReservationNode != java.util.concurrent.ConcurrentHashMap$ReservationNode<K, V> */
        ReservationNode() {
            super(ConcurrentHashMap.RESERVED, null, null);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReservationNode != java.util.concurrent.ConcurrentHashMap$ReservationNode<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        Node<K, V> find(int h, Object k) {
            return null;
        }
    }

    static final int resizeStamp(int n) {
        return Integer.numberOfLeadingZeros(n) | 32768;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
        return r1;
     */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Node<K, V>[] initTable() {
        while (true) {
            Node<K, V>[] nodeArr = this.table;
            Node<K, V>[] nodeArr2 = nodeArr;
            if (nodeArr != null && nodeArr2.length != 0) {
                break;
            }
            int i = this.sizeCtl;
            int sc = i;
            if (i < 0) {
                Thread.yield();
            } else if (U.compareAndSetInt(this, SIZECTL, sc, MOVED)) {
                try {
                    Node<K, V>[] nodeArr3 = this.table;
                    nodeArr2 = nodeArr3;
                    if (nodeArr3 == null || nodeArr2.length == 0) {
                        int n = sc > 0 ? sc : 16;
                        Node<K, V>[] nodeArr4 = new Node[n];
                        nodeArr2 = nodeArr4;
                        this.table = nodeArr4;
                        sc = n - (n >>> 2);
                    }
                } finally {
                    this.sizeCtl = sc;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0.compareAndSetLong(r23, r2, r4, r6) == false) goto L54;
     */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addCount(long x, int check) {
        int m;
        CounterCell c;
        long s;
        Node<K, V>[] nodeArr;
        int n;
        Node<K, V>[] nodeArr2;
        CounterCell[] cs = this.counterCells;
        if (cs == null) {
            DesugarUnsafe desugarUnsafe = U;
            long j = BASECOUNT;
            long b = this.baseCount;
            long j2 = b + x;
            s = j2;
        }
        boolean uncontended = true;
        if (cs != null && (m = cs.length - 1) >= 0 && (c = cs[ThreadLocalRandom.getProbe() & m]) != null) {
            DesugarUnsafe desugarUnsafe2 = U;
            long j3 = CELLVALUE;
            long v = c.value;
            boolean compareAndSetLong = desugarUnsafe2.compareAndSetLong(c, j3, v, v + x);
            uncontended = compareAndSetLong;
            if (compareAndSetLong) {
                if (check <= 1) {
                    return;
                }
                s = sumCount();
                if (check < 0) {
                    return;
                }
                while (true) {
                    int sc = this.sizeCtl;
                    if (s >= sc && (nodeArr = this.table) != null && (n = nodeArr.length) < MAXIMUM_CAPACITY) {
                        int rs = resizeStamp(n);
                        if (sc < 0) {
                            if ((sc >>> 16) == rs && sc != rs + 1 && sc != MAX_RESIZERS + rs && (nodeArr2 = this.nextTable) != null && this.transferIndex > 0) {
                                if (U.compareAndSetInt(this, SIZECTL, sc, sc + 1)) {
                                    transfer(nodeArr, nodeArr2);
                                }
                            } else {
                                return;
                            }
                        } else if (U.compareAndSetInt(this, SIZECTL, sc, (rs << 16) + 2)) {
                            transfer(nodeArr, null);
                        }
                        s = sumCount();
                    } else {
                        return;
                    }
                }
            }
        }
        fullAddCount(x, uncontended);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    final Node<K, V>[] helpTransfer(Node<K, V>[] nodeArr, Node<K, V> node) {
        Node<K, V>[] nodeArr2;
        int sc;
        if (nodeArr != null && (node instanceof ForwardingNode) && (nodeArr2 = ((ForwardingNode) node).nextTable) != null) {
            int rs = resizeStamp(nodeArr.length);
            while (true) {
                if (nodeArr2 != this.nextTable || this.table != nodeArr || (sc = this.sizeCtl) >= 0 || (sc >>> 16) != rs || sc == rs + 1 || sc == MAX_RESIZERS + rs || this.transferIndex <= 0) {
                    break;
                } else if (U.compareAndSetInt(this, SIZECTL, sc, sc + 1)) {
                    transfer(nodeArr, nodeArr2);
                    break;
                }
            }
            return nodeArr2;
        }
        return this.table;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    private final void tryPresize(int size) {
        int n;
        int c = size >= 536870912 ? MAXIMUM_CAPACITY : tableSizeFor((size >>> 1) + size + 1);
        while (true) {
            int i = this.sizeCtl;
            int sc = i;
            if (i >= 0) {
                Node<K, V>[] nodeArr = this.table;
                if (nodeArr == null || (n = nodeArr.length) == 0) {
                    int n2 = sc > c ? sc : c;
                    if (U.compareAndSetInt(this, SIZECTL, sc, MOVED)) {
                        try {
                            if (this.table == nodeArr) {
                                this.table = new Node[n2];
                                sc = n2 - (n2 >>> 2);
                            }
                        } finally {
                            this.sizeCtl = sc;
                        }
                    } else {
                        continue;
                    }
                } else if (c > sc && n < MAXIMUM_CAPACITY) {
                    if (nodeArr == this.table) {
                        int rs = resizeStamp(n);
                        if (U.compareAndSetInt(this, SIZECTL, sc, (rs << 16) + 2)) {
                            transfer(nodeArr, null);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForwardingNode != java.util.concurrent.ConcurrentHashMap$ForwardingNode<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:129:0x0208 -> B:127:0x0206). Please submit an issue!!! */
    private final void transfer(Node<K, V>[] nodeArr, Node<K, V>[] nodeArr2) {
        Node<K, V>[] nodeArr3;
        int stride;
        int nextn;
        char c;
        int fh;
        Node<K, V> node;
        Node<K, V> node2;
        Node<K, V> node3;
        ConcurrentHashMap<K, V> concurrentHashMap = this;
        int n = nodeArr.length;
        int i = 1;
        int i2 = NCPU > 1 ? (n >>> 3) / NCPU : n;
        int stride2 = i2;
        char c2 = 16;
        int stride3 = i2 < 16 ? 16 : stride2;
        if (nodeArr2 == null) {
            try {
                Node<K, V>[] nodeArr4 = new Node[n << 1];
                concurrentHashMap.nextTable = nodeArr4;
                concurrentHashMap.transferIndex = n;
                nodeArr3 = nodeArr4;
            } catch (Throwable th) {
                concurrentHashMap.sizeCtl = HASH_BITS;
                return;
            }
        } else {
            nodeArr3 = nodeArr2;
        }
        int nextn2 = nodeArr3.length;
        ForwardingNode forwardingNode = new ForwardingNode(nodeArr3);
        boolean advance = true;
        boolean finishing = false;
        int i3 = 0;
        int bound = 0;
        while (true) {
            if (advance) {
                int i4 = i3 + MOVED;
                if (i4 >= bound || finishing) {
                    i3 = i4;
                    advance = false;
                    bound = bound;
                } else {
                    int nextIndex = concurrentHashMap.transferIndex;
                    if (nextIndex <= 0) {
                        i3 = MOVED;
                        advance = false;
                    } else {
                        DesugarUnsafe desugarUnsafe = U;
                        long j = TRANSFERINDEX;
                        int nextBound = nextIndex > stride3 ? nextIndex - stride3 : 0;
                        int bound2 = bound;
                        if (desugarUnsafe.compareAndSetInt(this, j, nextIndex, nextBound)) {
                            i3 = nextIndex + MOVED;
                            advance = false;
                            bound = nextBound;
                        } else {
                            i3 = i4;
                            bound = bound2;
                        }
                    }
                }
            } else {
                int bound3 = bound;
                if (i3 < 0 || i3 >= n) {
                    stride = stride3;
                    nextn = nextn2;
                } else if (i3 + n >= nextn2) {
                    stride = stride3;
                    nextn = nextn2;
                } else {
                    Node<K, V> tabAt = tabAt(nodeArr, i3);
                    if (tabAt == null) {
                        advance = casTabAt(nodeArr, i3, null, forwardingNode);
                        fh = i;
                        c = c2;
                        stride = stride3;
                        nextn = nextn2;
                    } else {
                        int i5 = tabAt.hash;
                        int fh2 = i5;
                        if (i5 == MOVED) {
                            advance = true;
                            fh = i;
                            c = c2;
                            stride = stride3;
                            nextn = nextn2;
                        } else {
                            synchronized (tabAt) {
                                try {
                                    if (tabAt(nodeArr, i3) != tabAt) {
                                        stride = stride3;
                                        nextn = nextn2;
                                    } else if (fh2 >= 0) {
                                        int runBit = fh2 & n;
                                        Node<K, V> node4 = tabAt;
                                        try {
                                            for (Node<K, V> node5 = tabAt.next; node5 != null; node5 = node5.next) {
                                                try {
                                                    int b = node5.hash & n;
                                                    if (b != runBit) {
                                                        runBit = b;
                                                        node4 = node5;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    throw th;
                                                }
                                            }
                                            if (runBit == 0) {
                                                node2 = node4;
                                                node = null;
                                            } else {
                                                node = node4;
                                                node2 = null;
                                            }
                                            Node<K, V> node6 = tabAt;
                                            while (node6 != node4) {
                                                int ph = node6.hash;
                                                int runBit2 = runBit;
                                                K pk = node6.key;
                                                int fh3 = fh2;
                                                try {
                                                    V pv = node6.val;
                                                    if ((ph & n) == 0) {
                                                        node3 = node4;
                                                        node2 = new Node<>(ph, pk, pv, node2);
                                                    } else {
                                                        node3 = node4;
                                                        node = new Node<>(ph, pk, pv, node);
                                                    }
                                                    node6 = node6.next;
                                                    fh2 = fh3;
                                                    runBit = runBit2;
                                                    node4 = node3;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    throw th;
                                                }
                                            }
                                            setTabAt(nodeArr3, i3, node2);
                                            setTabAt(nodeArr3, i3 + n, node);
                                            setTabAt(nodeArr, i3, forwardingNode);
                                            advance = true;
                                            stride = stride3;
                                            nextn = nextn2;
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    } else {
                                        try {
                                            if (tabAt instanceof TreeBin) {
                                                TreeBin treeBin = (TreeBin) tabAt;
                                                Node node7 = treeBin.first;
                                                int hc = 0;
                                                int lc = 0;
                                                TreeNode<K, V> treeNode = null;
                                                TreeNode<K, V> treeNode2 = null;
                                                TreeNode<K, V> treeNode3 = null;
                                                TreeNode<K, V> treeNode4 = null;
                                                while (node7 != null) {
                                                    int stride4 = stride3;
                                                    try {
                                                        int stride5 = node7.hash;
                                                        int nextn3 = nextn2;
                                                        try {
                                                            TreeNode<K, V> treeNode5 = new TreeNode<>(stride5, node7.key, node7.val, null, null);
                                                            if ((stride5 & n) == 0) {
                                                                treeNode5.prev = treeNode3;
                                                                if (treeNode3 == null) {
                                                                    treeNode4 = treeNode5;
                                                                } else {
                                                                    treeNode3.next = treeNode5;
                                                                }
                                                                treeNode3 = treeNode5;
                                                                lc++;
                                                            } else {
                                                                treeNode5.prev = treeNode;
                                                                if (treeNode == null) {
                                                                    treeNode2 = treeNode5;
                                                                } else {
                                                                    treeNode.next = treeNode5;
                                                                }
                                                                treeNode = treeNode5;
                                                                hc++;
                                                            }
                                                            node7 = (Node<K, V>) node7.next;
                                                            stride3 = stride4;
                                                            nextn2 = nextn3;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            throw th;
                                                        }
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        throw th;
                                                    }
                                                }
                                                stride = stride3;
                                                nextn = nextn2;
                                                Node untreeify = lc <= UNTREEIFY_THRESHOLD ? untreeify(treeNode4) : hc != 0 ? new TreeBin(treeNode4) : treeBin;
                                                Node untreeify2 = hc <= UNTREEIFY_THRESHOLD ? untreeify(treeNode2) : lc != 0 ? new TreeBin(treeNode2) : treeBin;
                                                setTabAt(nodeArr3, i3, untreeify);
                                                setTabAt(nodeArr3, i3 + n, untreeify2);
                                                setTabAt(nodeArr, i3, forwardingNode);
                                                advance = true;
                                            } else {
                                                stride = stride3;
                                                nextn = nextn2;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                }
                            }
                            concurrentHashMap = this;
                            fh = 1;
                            c = 16;
                        }
                    }
                    i = fh;
                    c2 = c;
                    bound = bound3;
                    stride3 = stride;
                    nextn2 = nextn;
                }
                if (finishing) {
                    this.nextTable = null;
                    this.table = nodeArr3;
                    this.sizeCtl = (n << 1) - (n >>> 1);
                    return;
                }
                concurrentHashMap = this;
                DesugarUnsafe desugarUnsafe2 = U;
                long j2 = SIZECTL;
                int sc = concurrentHashMap.sizeCtl;
                int i6 = i3;
                if (desugarUnsafe2.compareAndSetInt(this, j2, sc, sc + MOVED)) {
                    c = 16;
                    if (sc + TREEBIN != (resizeStamp(n) << 16)) {
                        return;
                    }
                    fh = 1;
                    advance = true;
                    finishing = true;
                    i3 = n;
                } else {
                    fh = 1;
                    c = 16;
                    i3 = i6;
                }
                i = fh;
                c2 = c;
                bound = bound3;
                stride3 = stride;
                nextn2 = nextn;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class CounterCell {
        volatile long value;

        CounterCell(long x) {
            this.value = x;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    final long sumCount() {
        CounterCell[] cs = this.counterCells;
        long sum = this.baseCount;
        if (cs != null) {
            for (CounterCell c : cs) {
                if (c != null) {
                    sum += c.value;
                }
            }
        }
        return sum;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    private final void fullAddCount(long x, boolean wasUncontended) {
        boolean wasUncontended2;
        int n;
        CounterCell c;
        int m;
        int probe = ThreadLocalRandom.getProbe();
        int h = probe;
        if (probe != 0) {
            wasUncontended2 = wasUncontended;
        } else {
            ThreadLocalRandom.localInit();
            h = ThreadLocalRandom.getProbe();
            wasUncontended2 = true;
        }
        boolean wasUncontended3 = wasUncontended2;
        int h2 = h;
        boolean collide = false;
        while (true) {
            CounterCell[] cs = this.counterCells;
            if (cs != null && (n = cs.length) > 0) {
                CounterCell c2 = cs[(n + MOVED) & h2];
                if (c2 == null) {
                    if (this.cellsBusy != 0) {
                        c = c2;
                    } else {
                        CounterCell r = new CounterCell(x);
                        if (this.cellsBusy != 0) {
                            c = c2;
                        } else {
                            c = c2;
                            if (U.compareAndSetInt(this, CELLSBUSY, 0, 1)) {
                                boolean created = false;
                                try {
                                    CounterCell[] rs = this.counterCells;
                                    if (rs != null && (m = rs.length) > 0) {
                                        int j = (m + MOVED) & h2;
                                        if (rs[j] == null) {
                                            rs[j] = r;
                                            created = true;
                                        }
                                    }
                                    if (created) {
                                        return;
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                    collide = false;
                    h2 = ThreadLocalRandom.advanceProbe(h2);
                } else {
                    if (!wasUncontended3) {
                        wasUncontended3 = true;
                    } else {
                        DesugarUnsafe desugarUnsafe = U;
                        long j2 = CELLVALUE;
                        long v = c2.value;
                        if (!desugarUnsafe.compareAndSetLong(c2, j2, v, v + x)) {
                            if (this.counterCells == cs && n < NCPU) {
                                if (!collide) {
                                    collide = true;
                                } else if (this.cellsBusy == 0 && U.compareAndSetInt(this, CELLSBUSY, 0, 1)) {
                                    try {
                                        if (this.counterCells == cs) {
                                            this.counterCells = (CounterCell[]) Arrays.copyOf(cs, n << 1);
                                        }
                                        this.cellsBusy = 0;
                                        collide = false;
                                    } finally {
                                    }
                                }
                            }
                            collide = false;
                        } else {
                            return;
                        }
                    }
                    h2 = ThreadLocalRandom.advanceProbe(h2);
                }
            } else {
                int h3 = this.cellsBusy;
                if (h3 == 0 && this.counterCells == cs && U.compareAndSetInt(this, CELLSBUSY, 0, 1)) {
                    boolean init = false;
                    try {
                        if (this.counterCells == cs) {
                            CounterCell[] rs2 = new CounterCell[2];
                            rs2[h2 & 1] = new CounterCell(x);
                            this.counterCells = rs2;
                            init = true;
                        }
                        if (init) {
                            return;
                        }
                    } finally {
                    }
                } else {
                    DesugarUnsafe desugarUnsafe2 = U;
                    long j3 = BASECOUNT;
                    long v2 = this.baseCount;
                    if (desugarUnsafe2.compareAndSetLong(this, j3, v2, v2 + x)) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
    private final void treeifyBin(Node<K, V>[] nodeArr, int index) {
        if (nodeArr != null) {
            int n = nodeArr.length;
            if (n < 64) {
                tryPresize(n << 1);
                return;
            }
            Node<K, V> tabAt = tabAt(nodeArr, index);
            if (tabAt != null && tabAt.hash >= 0) {
                synchronized (tabAt) {
                    if (tabAt(nodeArr, index) == tabAt) {
                        TreeNode<K, V> treeNode = null;
                        TreeNode<K, V> treeNode2 = null;
                        for (Node<K, V> node = tabAt; node != null; node = node.next) {
                            TreeNode<K, V> treeNode3 = new TreeNode<>(node.hash, node.key, node.val, null, null);
                            treeNode3.prev = treeNode2;
                            if (treeNode2 == null) {
                                treeNode = treeNode3;
                            } else {
                                treeNode2.next = treeNode3;
                            }
                            treeNode2 = treeNode3;
                        }
                        setTabAt(nodeArr, index, new TreeBin(treeNode));
                    }
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
    static <K, V> Node<K, V> untreeify(Node<K, V> node) {
        Node<K, V> node2 = null;
        Node<K, V> node3 = null;
        for (Node<K, V> node4 = node; node4 != null; node4 = node4.next) {
            Node<K, V> node5 = new Node<>(node4.hash, node4.key, node4.val);
            if (node3 == null) {
                node2 = node5;
            } else {
                node3.next = node5;
            }
            node3 = node5;
        }
        return node2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class TreeNode<K, V> extends Node<K, V> {
        TreeNode<K, V> left;
        TreeNode<K, V> parent;
        TreeNode<K, V> prev;
        boolean red;
        TreeNode<K, V> right;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        TreeNode(int hash, K key, V val, Node<K, V> node, TreeNode<K, V> treeNode) {
            super(hash, key, val, node);
            this.parent = treeNode;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        Node<K, V> find(int h, Object k) {
            return findTreeNode(h, k, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
            if (r3 != null) goto L36;
         */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final TreeNode<K, V> findTreeNode(int h, Object k, Class<?> kc) {
            if (k != null) {
                TreeNode<K, V> treeNode = this;
                do {
                    TreeNode<K, V> treeNode2 = treeNode.left;
                    TreeNode<K, V> treeNode3 = treeNode.right;
                    int ph = treeNode.hash;
                    if (ph > h) {
                        treeNode = treeNode2;
                        continue;
                    } else if (ph < h) {
                        treeNode = treeNode3;
                        continue;
                    } else {
                        K pk = treeNode.key;
                        if (pk == k || (pk != null && k.equals(pk))) {
                            return treeNode;
                        }
                        if (treeNode2 == null) {
                            treeNode = treeNode3;
                            continue;
                        } else if (treeNode3 == null) {
                            treeNode = treeNode2;
                            continue;
                        } else {
                            if (kc == null) {
                                Class<?> comparableClassFor = ConcurrentHashMap.comparableClassFor(k);
                                kc = comparableClassFor;
                            }
                            int dir = ConcurrentHashMap.compareComparables(kc, k, pk);
                            if (dir != 0) {
                                treeNode = dir < 0 ? treeNode2 : treeNode3;
                                continue;
                            }
                            TreeNode<K, V> findTreeNode = treeNode3.findTreeNode(h, k, kc);
                            if (findTreeNode != null) {
                                return findTreeNode;
                            }
                            treeNode = treeNode2;
                            continue;
                        }
                    }
                } while (treeNode != null);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class TreeBin<K, V> extends Node<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int READER = 4;
        static final int WAITER = 2;
        static final int WRITER = 1;
        volatile TreeNode<K, V> first;
        volatile int lockState;
        TreeNode<K, V> root;
        volatile Thread waiter;
        private static final DesugarUnsafe U = DesugarUnsafe.getUnsafe();
        private static final long LOCKSTATE = U.objectFieldOffset(TreeBin.class, "lockState");

        static int tieBreakOrder(Object a, Object b) {
            int d;
            if (a == null || b == null || (d = a.getClass().getName().compareTo(b.getClass().getName())) == 0) {
                int d2 = System.identityHashCode(a) <= System.identityHashCode(b) ? ConcurrentHashMap.MOVED : 1;
                return d2;
            }
            return d;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
            if (r9 != null) goto L31;
         */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        TreeBin(TreeNode<K, V> treeNode) {
            super(ConcurrentHashMap.TREEBIN, null, null);
            int dir;
            TreeNode<K, V> treeNode2;
            TreeNode<K, V> treeNode3;
            this.first = treeNode;
            TreeNode<K, V> treeNode4 = null;
            TreeNode<K, V> treeNode5 = treeNode;
            while (treeNode5 != null) {
                TreeNode<K, V> treeNode6 = (TreeNode) treeNode5.next;
                treeNode5.right = null;
                treeNode5.left = null;
                if (treeNode4 == null) {
                    treeNode5.parent = null;
                    treeNode5.red = $assertionsDisabled;
                    treeNode4 = treeNode5;
                } else {
                    K k = treeNode5.key;
                    int h = treeNode5.hash;
                    Class<?> kc = null;
                    TreeNode<K, V> treeNode7 = treeNode4;
                    do {
                        K pk = treeNode7.key;
                        int ph = treeNode7.hash;
                        if (ph > h) {
                            dir = ConcurrentHashMap.MOVED;
                        } else if (ph < h) {
                            dir = 1;
                        } else {
                            if (kc == null) {
                                Class<?> comparableClassFor = ConcurrentHashMap.comparableClassFor(k);
                                kc = comparableClassFor;
                            }
                            int dir2 = ConcurrentHashMap.compareComparables(kc, k, pk);
                            if (dir2 != 0) {
                                dir = dir2;
                            }
                            dir = tieBreakOrder(k, pk);
                        }
                        treeNode2 = treeNode7;
                        treeNode3 = dir <= 0 ? treeNode7.left : treeNode7.right;
                        treeNode7 = treeNode3;
                    } while (treeNode3 != null);
                    treeNode5.parent = treeNode2;
                    if (dir <= 0) {
                        treeNode2.left = treeNode5;
                    } else {
                        treeNode2.right = treeNode5;
                    }
                    treeNode4 = balanceInsertion(treeNode4, treeNode5);
                }
                treeNode5 = treeNode6;
            }
            this.root = treeNode4;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
        private final void lockRoot() {
            if (!U.compareAndSetInt(this, LOCKSTATE, 0, 1)) {
                contendedLock();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
        private final void unlockRoot() {
            this.lockState = 0;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
        private final void contendedLock() {
            boolean waiting = $assertionsDisabled;
            while (true) {
                int s = this.lockState;
                if ((s & ConcurrentHashMap.RESERVED) == 0) {
                    if (U.compareAndSetInt(this, LOCKSTATE, s, 1)) {
                        break;
                    }
                } else if ((s & 2) == 0) {
                    if (U.compareAndSetInt(this, LOCKSTATE, s, s | 2)) {
                        waiting = true;
                        this.waiter = Thread.currentThread();
                    }
                } else if (waiting) {
                    LockSupport.park(this);
                }
            }
            if (waiting) {
                this.waiter = null;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        final Node<K, V> find(int h, Object k) {
            K ek;
            Thread w;
            TreeNode<K, V> treeNode = null;
            if (k != null) {
                Node<K, V> node = this.first;
                while (node != null) {
                    int s = this.lockState;
                    if ((s & 3) != 0) {
                        if (node.hash == h && ((ek = node.key) == k || (ek != null && k.equals(ek)))) {
                            return node;
                        }
                        node = node.next;
                    } else if (U.compareAndSetInt(this, LOCKSTATE, s, s + 4)) {
                        try {
                            TreeNode<K, V> treeNode2 = this.root;
                            if (treeNode2 != null) {
                                treeNode = treeNode2.findTreeNode(h, k, null);
                            }
                            return treeNode;
                        } finally {
                            if (U.getAndAddInt(this, LOCKSTATE, -4) == ConcurrentHashMap.UNTREEIFY_THRESHOLD && (w = this.waiter) != null) {
                                LockSupport.unpark(w);
                            }
                        }
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
            if (r2 != null) goto L59;
         */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final TreeNode<K, V> putTreeVal(int h, K k, V v) {
            int dir;
            boolean searched;
            Class<?> kc;
            TreeNode<K, V> treeNode;
            int i = h;
            Class<?> kc2 = null;
            boolean searched2 = false;
            TreeNode<K, V> treeNode2 = this.root;
            while (treeNode2 != null) {
                int ph = treeNode2.hash;
                if (ph > i) {
                    dir = ConcurrentHashMap.MOVED;
                    searched = searched2;
                    kc = kc2;
                } else if (ph < i) {
                    dir = 1;
                    searched = searched2;
                    kc = kc2;
                } else {
                    K pk = treeNode2.key;
                    if (pk == k || (pk != null && k.equals(pk))) {
                        return treeNode2;
                    }
                    if (kc2 == null) {
                        Class<?> comparableClassFor = ConcurrentHashMap.comparableClassFor(k);
                        kc2 = comparableClassFor;
                    }
                    int dir2 = ConcurrentHashMap.compareComparables(kc2, k, pk);
                    if (dir2 != 0) {
                        dir = dir2;
                        searched = searched2;
                        kc = kc2;
                    }
                    if (!searched2) {
                        searched2 = true;
                        TreeNode<K, V> treeNode3 = treeNode2.left;
                        if (treeNode3 != null) {
                            TreeNode<K, V> findTreeNode = treeNode3.findTreeNode(i, k, kc2);
                            treeNode = findTreeNode;
                            if (findTreeNode != null) {
                                return treeNode;
                            }
                        }
                        TreeNode<K, V> treeNode4 = treeNode2.right;
                        if (treeNode4 != null) {
                            TreeNode<K, V> findTreeNode2 = treeNode4.findTreeNode(i, k, kc2);
                            treeNode = findTreeNode2;
                            if (findTreeNode2 != null) {
                                return treeNode;
                            }
                        }
                    }
                    dir = tieBreakOrder(k, pk);
                    searched = searched2;
                    kc = kc2;
                }
                TreeNode<K, V> treeNode5 = treeNode2;
                TreeNode<K, V> treeNode6 = dir <= 0 ? treeNode2.left : treeNode2.right;
                treeNode2 = treeNode6;
                if (treeNode6 == null) {
                    TreeNode<K, V> treeNode7 = this.first;
                    TreeNode<K, V> treeNode8 = new TreeNode<>(h, k, v, treeNode7, treeNode5);
                    this.first = treeNode8;
                    if (treeNode7 != null) {
                        treeNode7.prev = treeNode8;
                    }
                    if (dir <= 0) {
                        treeNode5.left = treeNode8;
                    } else {
                        treeNode5.right = treeNode8;
                    }
                    if (!treeNode5.red) {
                        treeNode8.red = true;
                    } else {
                        lockRoot();
                        try {
                            this.root = balanceInsertion(this.root, treeNode8);
                        } finally {
                            unlockRoot();
                        }
                    }
                    return null;
                }
                i = h;
                kc2 = kc;
                searched2 = searched;
            }
            TreeNode<K, V> treeNode9 = new TreeNode<>(h, k, v, null, null);
            this.root = treeNode9;
            this.first = treeNode9;
            return null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeBin != java.util.concurrent.ConcurrentHashMap$TreeBin<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        final boolean removeTreeNode(TreeNode<K, V> treeNode) {
            TreeNode<K, V> treeNode2;
            TreeNode<K, V> treeNode3;
            TreeNode<K, V> treeNode4;
            TreeNode<K, V> treeNode5 = (TreeNode) treeNode.next;
            TreeNode<K, V> treeNode6 = treeNode.prev;
            if (treeNode6 == null) {
                this.first = treeNode5;
            } else {
                treeNode6.next = treeNode5;
            }
            if (treeNode5 != null) {
                treeNode5.prev = treeNode6;
            }
            if (this.first == null) {
                this.root = null;
                return true;
            }
            TreeNode<K, V> treeNode7 = this.root;
            TreeNode<K, V> treeNode8 = treeNode7;
            if (treeNode7 == null || treeNode8.right == null || (treeNode2 = treeNode8.left) == null || treeNode2.left == null) {
                return true;
            }
            lockRoot();
            try {
                TreeNode<K, V> treeNode9 = treeNode.left;
                TreeNode<K, V> treeNode10 = treeNode.right;
                if (treeNode9 != null && treeNode10 != null) {
                    TreeNode<K, V> treeNode11 = treeNode10;
                    while (true) {
                        TreeNode<K, V> treeNode12 = treeNode11.left;
                        if (treeNode12 == null) {
                            break;
                        }
                        treeNode11 = treeNode12;
                    }
                    boolean c = treeNode11.red;
                    treeNode11.red = treeNode.red;
                    treeNode.red = c;
                    TreeNode<K, V> treeNode13 = treeNode11.right;
                    TreeNode<K, V> treeNode14 = treeNode.parent;
                    if (treeNode11 == treeNode10) {
                        treeNode.parent = treeNode11;
                        treeNode11.right = treeNode;
                    } else {
                        TreeNode<K, V> treeNode15 = treeNode11.parent;
                        treeNode.parent = treeNode15;
                        if (treeNode15 != null) {
                            if (treeNode11 == treeNode15.left) {
                                treeNode15.left = treeNode;
                            } else {
                                treeNode15.right = treeNode;
                            }
                        }
                        treeNode11.right = treeNode10;
                        if (treeNode10 != null) {
                            treeNode10.parent = treeNode11;
                        }
                    }
                    treeNode.left = null;
                    treeNode.right = treeNode13;
                    if (treeNode13 != null) {
                        treeNode13.parent = treeNode;
                    }
                    treeNode11.left = treeNode9;
                    if (treeNode9 != null) {
                        treeNode9.parent = treeNode11;
                    }
                    treeNode11.parent = treeNode14;
                    if (treeNode14 == null) {
                        treeNode8 = treeNode11;
                    } else if (treeNode == treeNode14.left) {
                        treeNode14.left = treeNode11;
                    } else {
                        treeNode14.right = treeNode11;
                    }
                    if (treeNode13 != null) {
                        treeNode3 = treeNode13;
                    } else {
                        treeNode3 = treeNode;
                    }
                } else if (treeNode9 != null) {
                    treeNode3 = treeNode9;
                } else if (treeNode10 != null) {
                    treeNode3 = treeNode10;
                } else {
                    treeNode3 = treeNode;
                }
                if (treeNode3 != treeNode) {
                    TreeNode<K, V> treeNode16 = treeNode.parent;
                    treeNode3.parent = treeNode16;
                    if (treeNode16 == null) {
                        treeNode8 = treeNode3;
                    } else if (treeNode == treeNode16.left) {
                        treeNode16.left = treeNode3;
                    } else {
                        treeNode16.right = treeNode3;
                    }
                    treeNode.parent = null;
                    treeNode.right = null;
                    treeNode.left = null;
                }
                this.root = treeNode.red ? treeNode8 : balanceDeletion(treeNode8, treeNode3);
                if (treeNode == treeNode3 && (treeNode4 = treeNode.parent) != null) {
                    if (treeNode == treeNode4.left) {
                        treeNode4.left = null;
                    } else if (treeNode == treeNode4.right) {
                        treeNode4.right = null;
                    }
                    treeNode.parent = null;
                }
                unlockRoot();
                return $assertionsDisabled;
            } catch (Throwable th) {
                unlockRoot();
                throw th;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            TreeNode<K, V> treeNode3;
            if (treeNode2 != null && (treeNode3 = treeNode2.right) != null) {
                TreeNode<K, V> treeNode4 = treeNode3.left;
                treeNode2.right = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.parent = treeNode2;
                }
                TreeNode<K, V> treeNode5 = treeNode2.parent;
                treeNode3.parent = treeNode5;
                if (treeNode5 == null) {
                    treeNode = treeNode3;
                    treeNode3.red = $assertionsDisabled;
                } else if (treeNode5.left == treeNode2) {
                    treeNode5.left = treeNode3;
                } else {
                    treeNode5.right = treeNode3;
                }
                treeNode3.left = treeNode2;
                treeNode2.parent = treeNode3;
            }
            return treeNode;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            TreeNode<K, V> treeNode3;
            if (treeNode2 != null && (treeNode3 = treeNode2.left) != null) {
                TreeNode<K, V> treeNode4 = treeNode3.right;
                treeNode2.left = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.parent = treeNode2;
                }
                TreeNode<K, V> treeNode5 = treeNode2.parent;
                treeNode3.parent = treeNode5;
                if (treeNode5 == null) {
                    treeNode = treeNode3;
                    treeNode3.red = $assertionsDisabled;
                } else if (treeNode5.right == treeNode2) {
                    treeNode5.right = treeNode3;
                } else {
                    treeNode5.left = treeNode3;
                }
                treeNode3.right = treeNode2;
                treeNode2.parent = treeNode3;
            }
            return treeNode;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            treeNode2.red = true;
            while (true) {
                TreeNode<K, V> treeNode3 = treeNode2.parent;
                TreeNode<K, V> treeNode4 = treeNode3;
                if (treeNode3 == null) {
                    treeNode2.red = $assertionsDisabled;
                    return treeNode2;
                } else if (!treeNode4.red) {
                    break;
                } else {
                    TreeNode<K, V> treeNode5 = treeNode4.parent;
                    TreeNode<K, V> treeNode6 = treeNode5;
                    if (treeNode5 == null) {
                        break;
                    }
                    TreeNode<K, V> treeNode7 = treeNode6.left;
                    if (treeNode4 == treeNode7) {
                        TreeNode<K, V> treeNode8 = treeNode6.right;
                        if (treeNode8 != null && treeNode8.red) {
                            treeNode8.red = $assertionsDisabled;
                            treeNode4.red = $assertionsDisabled;
                            treeNode6.red = true;
                            treeNode2 = treeNode6;
                        } else {
                            if (treeNode2 == treeNode4.right) {
                                treeNode2 = treeNode4;
                                treeNode = rotateLeft(treeNode, treeNode4);
                                TreeNode<K, V> treeNode9 = treeNode2.parent;
                                treeNode4 = treeNode9;
                                treeNode6 = treeNode9 != null ? treeNode4.parent : null;
                            }
                            if (treeNode4 != null) {
                                treeNode4.red = $assertionsDisabled;
                                if (treeNode6 != null) {
                                    treeNode6.red = true;
                                    treeNode = rotateRight(treeNode, treeNode6);
                                }
                            }
                        }
                    } else if (treeNode7 != null && treeNode7.red) {
                        treeNode7.red = $assertionsDisabled;
                        treeNode4.red = $assertionsDisabled;
                        treeNode6.red = true;
                        treeNode2 = treeNode6;
                    } else {
                        if (treeNode2 == treeNode4.left) {
                            treeNode2 = treeNode4;
                            treeNode = rotateRight(treeNode, treeNode4);
                            TreeNode<K, V> treeNode10 = treeNode2.parent;
                            treeNode4 = treeNode10;
                            treeNode6 = treeNode10 != null ? treeNode4.parent : null;
                        }
                        if (treeNode4 != null) {
                            treeNode4.red = $assertionsDisabled;
                            if (treeNode6 != null) {
                                treeNode6.red = true;
                                treeNode = rotateLeft(treeNode, treeNode6);
                            }
                        }
                    }
                }
            }
            return treeNode;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            while (treeNode2 != null && treeNode2 != treeNode) {
                TreeNode<K, V> treeNode3 = treeNode2.parent;
                TreeNode<K, V> treeNode4 = treeNode3;
                if (treeNode3 == null) {
                    treeNode2.red = $assertionsDisabled;
                    return treeNode2;
                } else if (treeNode2.red) {
                    treeNode2.red = $assertionsDisabled;
                    return treeNode;
                } else {
                    TreeNode<K, V> treeNode5 = treeNode4.left;
                    TreeNode<K, V> treeNode6 = treeNode5;
                    if (treeNode5 == treeNode2) {
                        TreeNode<K, V> treeNode7 = treeNode4.right;
                        TreeNode<K, V> treeNode8 = treeNode7;
                        if (treeNode7 != null && treeNode8.red) {
                            treeNode8.red = $assertionsDisabled;
                            treeNode4.red = true;
                            treeNode = rotateLeft(treeNode, treeNode4);
                            TreeNode<K, V> treeNode9 = treeNode2.parent;
                            treeNode4 = treeNode9;
                            treeNode8 = treeNode9 == null ? null : treeNode4.right;
                        }
                        if (treeNode8 == null) {
                            treeNode2 = treeNode4;
                        } else {
                            TreeNode<K, V> treeNode10 = treeNode8.left;
                            TreeNode<K, V> treeNode11 = treeNode8.right;
                            if ((treeNode11 == null || !treeNode11.red) && (treeNode10 == null || !treeNode10.red)) {
                                treeNode8.red = true;
                                treeNode2 = treeNode4;
                            } else {
                                if (treeNode11 == null || !treeNode11.red) {
                                    if (treeNode10 != null) {
                                        treeNode10.red = $assertionsDisabled;
                                    }
                                    treeNode8.red = true;
                                    treeNode = rotateRight(treeNode, treeNode8);
                                    TreeNode<K, V> treeNode12 = treeNode2.parent;
                                    treeNode4 = treeNode12;
                                    treeNode8 = treeNode12 != null ? treeNode4.right : null;
                                }
                                if (treeNode8 != null) {
                                    treeNode8.red = treeNode4 == null ? false : treeNode4.red;
                                    TreeNode<K, V> treeNode13 = treeNode8.right;
                                    if (treeNode13 != null) {
                                        treeNode13.red = $assertionsDisabled;
                                    }
                                }
                                if (treeNode4 != null) {
                                    treeNode4.red = $assertionsDisabled;
                                    treeNode = rotateLeft(treeNode, treeNode4);
                                }
                                treeNode2 = treeNode;
                            }
                        }
                    } else {
                        if (treeNode6 != null && treeNode6.red) {
                            treeNode6.red = $assertionsDisabled;
                            treeNode4.red = true;
                            treeNode = rotateRight(treeNode, treeNode4);
                            TreeNode<K, V> treeNode14 = treeNode2.parent;
                            treeNode4 = treeNode14;
                            treeNode6 = treeNode14 == null ? null : treeNode4.left;
                        }
                        if (treeNode6 == null) {
                            treeNode2 = treeNode4;
                        } else {
                            TreeNode<K, V> treeNode15 = treeNode6.left;
                            TreeNode<K, V> treeNode16 = treeNode6.right;
                            if ((treeNode15 == null || !treeNode15.red) && (treeNode16 == null || !treeNode16.red)) {
                                treeNode6.red = true;
                                treeNode2 = treeNode4;
                            } else {
                                if (treeNode15 == null || !treeNode15.red) {
                                    if (treeNode16 != null) {
                                        treeNode16.red = $assertionsDisabled;
                                    }
                                    treeNode6.red = true;
                                    treeNode = rotateLeft(treeNode, treeNode6);
                                    TreeNode<K, V> treeNode17 = treeNode2.parent;
                                    treeNode4 = treeNode17;
                                    treeNode6 = treeNode17 != null ? treeNode4.left : null;
                                }
                                if (treeNode6 != null) {
                                    treeNode6.red = treeNode4 == null ? false : treeNode4.red;
                                    TreeNode<K, V> treeNode18 = treeNode6.left;
                                    if (treeNode18 != null) {
                                        treeNode18.red = $assertionsDisabled;
                                    }
                                }
                                if (treeNode4 != null) {
                                    treeNode4.red = $assertionsDisabled;
                                    treeNode = rotateRight(treeNode, treeNode4);
                                }
                                treeNode2 = treeNode;
                            }
                        }
                    }
                }
            }
            return treeNode;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TreeNode != java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> */
        static <K, V> boolean checkInvariants(TreeNode<K, V> treeNode) {
            TreeNode<K, V> treeNode2 = treeNode.parent;
            TreeNode<K, V> treeNode3 = treeNode.left;
            TreeNode<K, V> treeNode4 = treeNode.right;
            TreeNode<K, V> treeNode5 = treeNode.prev;
            TreeNode treeNode6 = (TreeNode) treeNode.next;
            if (treeNode5 != null && treeNode5.next != treeNode) {
                return $assertionsDisabled;
            }
            if (treeNode6 != null && treeNode6.prev != treeNode) {
                return $assertionsDisabled;
            }
            if (treeNode2 != null && treeNode != treeNode2.left && treeNode != treeNode2.right) {
                return $assertionsDisabled;
            }
            if (treeNode3 != null && (treeNode3.parent != treeNode || treeNode3.hash > treeNode.hash)) {
                return $assertionsDisabled;
            }
            if (treeNode4 != null && (treeNode4.parent != treeNode || treeNode4.hash < treeNode.hash)) {
                return $assertionsDisabled;
            }
            if (treeNode.red && treeNode3 != null && treeNode3.red && treeNode4 != null && treeNode4.red) {
                return $assertionsDisabled;
            }
            if (treeNode3 != null && !checkInvariants(treeNode3)) {
                return $assertionsDisabled;
            }
            if (treeNode4 != null && !checkInvariants(treeNode4)) {
                return $assertionsDisabled;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class TableStack<K, V> {
        int index;
        int length;
        TableStack<K, V> next;
        Node<K, V>[] tab;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TableStack != java.util.concurrent.ConcurrentHashMap$TableStack<K, V> */
        TableStack() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class Traverser<K, V> {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int index;
        Node<K, V> next = null;
        TableStack<K, V> spare;
        TableStack<K, V> stack;
        Node<K, V>[] tab;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
        Traverser(Node<K, V>[] nodeArr, int size, int index, int limit) {
            this.tab = nodeArr;
            this.baseSize = size;
            this.index = index;
            this.baseIndex = index;
            this.baseLimit = limit;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
        final Node<K, V> advance() {
            Node<K, V>[] nodeArr;
            int n;
            int i;
            Node<K, V> node = this.next;
            TreeNode<K, V> treeNode = node;
            if (node != null) {
                treeNode = treeNode.next;
            }
            while (treeNode == null) {
                if (this.baseIndex >= this.baseLimit || (nodeArr = this.tab) == null || (n = nodeArr.length) <= (i = this.index) || i < 0) {
                    this.next = null;
                    return null;
                }
                Node<K, V> tabAt = ConcurrentHashMap.tabAt(nodeArr, i);
                treeNode = tabAt;
                if (tabAt != null && treeNode.hash < 0) {
                    if (treeNode instanceof ForwardingNode) {
                        this.tab = ((ForwardingNode) treeNode).nextTable;
                        treeNode = null;
                        pushState(nodeArr, i, n);
                    } else if (treeNode instanceof TreeBin) {
                        treeNode = ((TreeBin) treeNode).first;
                    } else {
                        treeNode = null;
                    }
                }
                if (this.stack != null) {
                    recoverState(n);
                } else {
                    int i2 = this.baseSize + i;
                    this.index = i2;
                    if (i2 >= n) {
                        int i3 = this.baseIndex + 1;
                        this.baseIndex = i3;
                        this.index = i3;
                    }
                }
            }
            this.next = treeNode;
            return treeNode;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TableStack != java.util.concurrent.ConcurrentHashMap$TableStack<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
        private void pushState(Node<K, V>[] nodeArr, int i, int n) {
            TableStack<K, V> tableStack = this.spare;
            if (tableStack != null) {
                this.spare = tableStack.next;
            } else {
                tableStack = new TableStack<>();
            }
            tableStack.tab = nodeArr;
            tableStack.length = n;
            tableStack.index = i;
            tableStack.next = this.stack;
            this.stack = tableStack;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TableStack != java.util.concurrent.ConcurrentHashMap$TableStack<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
        private void recoverState(int n) {
            TableStack<K, V> tableStack;
            while (true) {
                tableStack = this.stack;
                if (tableStack == null) {
                    break;
                }
                int i = this.index;
                int len = tableStack.length;
                int i2 = i + len;
                this.index = i2;
                if (i2 < n) {
                    break;
                }
                n = len;
                this.index = tableStack.index;
                this.tab = tableStack.tab;
                tableStack.tab = null;
                TableStack<K, V> tableStack2 = tableStack.next;
                tableStack.next = this.spare;
                this.stack = tableStack2;
                this.spare = tableStack;
            }
            if (tableStack == null) {
                int i3 = this.index + this.baseSize;
                this.index = i3;
                if (i3 >= n) {
                    int i4 = this.baseIndex + 1;
                    this.baseIndex = i4;
                    this.index = i4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class BaseIterator<K, V> extends Traverser<K, V> {
        Node<K, V> lastReturned;
        final ConcurrentHashMap<K, V> map;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BaseIterator != java.util.concurrent.ConcurrentHashMap$BaseIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        BaseIterator(Node<K, V>[] nodeArr, int size, int index, int limit, ConcurrentHashMap<K, V> concurrentHashMap) {
            super(nodeArr, size, index, limit);
            this.map = concurrentHashMap;
            advance();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BaseIterator != java.util.concurrent.ConcurrentHashMap$BaseIterator<K, V> */
        public final boolean hasNext() {
            return this.next != null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BaseIterator != java.util.concurrent.ConcurrentHashMap$BaseIterator<K, V> */
        public final boolean hasMoreElements() {
            return this.next != null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BaseIterator != java.util.concurrent.ConcurrentHashMap$BaseIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        public final void remove() {
            Node<K, V> node = this.lastReturned;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.lastReturned = null;
            this.map.replaceNode(node.key, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class KeyIterator<K, V> extends BaseIterator<K, V> implements Iterator<K>, Enumeration<K> {
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeyIterator != java.util.concurrent.ConcurrentHashMap$KeyIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        KeyIterator(Node<K, V>[] nodeArr, int size, int index, int limit, ConcurrentHashMap<K, V> concurrentHashMap) {
            super(nodeArr, size, index, limit, concurrentHashMap);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeyIterator != java.util.concurrent.ConcurrentHashMap$KeyIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.Iterator
        public final K next() {
            Node<K, V> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            K k = node.key;
            this.lastReturned = node;
            advance();
            return k;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeyIterator != java.util.concurrent.ConcurrentHashMap$KeyIterator<K, V> */
        @Override // java.util.Enumeration
        public final K nextElement() {
            return next();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class ValueIterator<K, V> extends BaseIterator<K, V> implements Iterator<V>, Enumeration<V> {
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValueIterator != java.util.concurrent.ConcurrentHashMap$ValueIterator<K, V> */
        ValueIterator(Node<K, V>[] nodeArr, int size, int index, int limit, ConcurrentHashMap<K, V> concurrentHashMap) {
            super(nodeArr, size, index, limit, concurrentHashMap);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValueIterator != java.util.concurrent.ConcurrentHashMap$ValueIterator<K, V> */
        @Override // java.util.Iterator
        public final V next() {
            Node<K, V> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            V v = node.val;
            this.lastReturned = node;
            advance();
            return v;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValueIterator != java.util.concurrent.ConcurrentHashMap$ValueIterator<K, V> */
        @Override // java.util.Enumeration
        public final V nextElement() {
            return next();
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class EntryIterator<K, V> extends BaseIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntryIterator != java.util.concurrent.ConcurrentHashMap$EntryIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        EntryIterator(Node<K, V>[] nodeArr, int size, int index, int limit, ConcurrentHashMap<K, V> concurrentHashMap) {
            super(nodeArr, size, index, limit, concurrentHashMap);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntryIterator != java.util.concurrent.ConcurrentHashMap$EntryIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.Iterator
        public final Map.Entry<K, V> next() {
            Node<K, V> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            K k = node.key;
            V v = node.val;
            this.lastReturned = node;
            advance();
            return new MapEntry(k, v, this.map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class MapEntry<K, V> implements Map.Entry<K, V> {
        final K key;
        final ConcurrentHashMap<K, V> map;
        V val;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapEntry != java.util.concurrent.ConcurrentHashMap$MapEntry<K, V> */
        MapEntry(K key, V val, ConcurrentHashMap<K, V> concurrentHashMap) {
            this.key = key;
            this.val = val;
            this.map = concurrentHashMap;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapEntry != java.util.concurrent.ConcurrentHashMap$MapEntry<K, V> */
        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapEntry != java.util.concurrent.ConcurrentHashMap$MapEntry<K, V> */
        @Override // java.util.Map.Entry
        public V getValue() {
            return this.val;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapEntry != java.util.concurrent.ConcurrentHashMap$MapEntry<K, V> */
        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapEntry != java.util.concurrent.ConcurrentHashMap$MapEntry<K, V> */
        public String toString() {
            return Helpers.mapEntryToString(this.key, this.val);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapEntry != java.util.concurrent.ConcurrentHashMap$MapEntry<K, V> */
        @Override // java.util.Map.Entry
        public boolean equals(Object o) {
            Map.Entry<?, ?> e;
            Object k;
            Object v;
            return (o instanceof Map.Entry) && (k = (e = (Map.Entry) o).getKey()) != null && (v = e.getValue()) != null && (k == this.key || k.equals(this.key)) && (v == this.val || v.equals(this.val));
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapEntry != java.util.concurrent.ConcurrentHashMap$MapEntry<K, V> */
        @Override // java.util.Map.Entry
        public V setValue(V value) {
            if (value == null) {
                throw new NullPointerException();
            }
            V v = this.val;
            this.val = value;
            this.map.put(this.key, value);
            return v;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class KeySpliterator<K, V> extends Traverser<K, V> implements Spliterator<K> {
        long est;

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySpliterator != java.util.concurrent.ConcurrentHashMap$KeySpliterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        KeySpliterator(Node<K, V>[] nodeArr, int size, int index, int limit, long est) {
            super(nodeArr, size, index, limit);
            this.est = est;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySpliterator != java.util.concurrent.ConcurrentHashMap$KeySpliterator<K, V> */
        @Override // j$.util.Spliterator
        public KeySpliterator<K, V> trySplit() {
            int i = this.baseIndex;
            int f = this.baseLimit;
            int h = (i + f) >>> 1;
            if (h <= i) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i2 = this.baseSize;
            this.baseLimit = h;
            long j = this.est >>> 1;
            this.est = j;
            return new KeySpliterator<>(nodeArr, i2, h, f, j);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySpliterator != java.util.concurrent.ConcurrentHashMap$KeySpliterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    action.accept((K) advance.key);
                } else {
                    return;
                }
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySpliterator != java.util.concurrent.ConcurrentHashMap$KeySpliterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V> advance = advance();
            if (advance == null) {
                return false;
            }
            action.accept((K) advance.key);
            return true;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySpliterator != java.util.concurrent.ConcurrentHashMap$KeySpliterator<K, V> */
        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySpliterator != java.util.concurrent.ConcurrentHashMap$KeySpliterator<K, V> */
        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4353;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class ValueSpliterator<K, V> extends Traverser<K, V> implements Spliterator<V> {
        long est;

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValueSpliterator != java.util.concurrent.ConcurrentHashMap$ValueSpliterator<K, V> */
        ValueSpliterator(Node<K, V>[] nodeArr, int size, int index, int limit, long est) {
            super(nodeArr, size, index, limit);
            this.est = est;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValueSpliterator != java.util.concurrent.ConcurrentHashMap$ValueSpliterator<K, V> */
        @Override // j$.util.Spliterator
        public ValueSpliterator<K, V> trySplit() {
            int i = this.baseIndex;
            int f = this.baseLimit;
            int h = (i + f) >>> 1;
            if (h <= i) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i2 = this.baseSize;
            this.baseLimit = h;
            long j = this.est >>> 1;
            this.est = j;
            return new ValueSpliterator<>(nodeArr, i2, h, f, j);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValueSpliterator != java.util.concurrent.ConcurrentHashMap$ValueSpliterator<K, V> */
        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer<? super V> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    action.accept((V) advance.val);
                } else {
                    return;
                }
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValueSpliterator != java.util.concurrent.ConcurrentHashMap$ValueSpliterator<K, V> */
        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer<? super V> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V> advance = advance();
            if (advance == null) {
                return false;
            }
            action.accept((V) advance.val);
            return true;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValueSpliterator != java.util.concurrent.ConcurrentHashMap$ValueSpliterator<K, V> */
        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValueSpliterator != java.util.concurrent.ConcurrentHashMap$ValueSpliterator<K, V> */
        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4352;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class EntrySpliterator<K, V> extends Traverser<K, V> implements Spliterator<Map.Entry<K, V>> {
        long est;
        final ConcurrentHashMap<K, V> map;

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySpliterator != java.util.concurrent.ConcurrentHashMap$EntrySpliterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        EntrySpliterator(Node<K, V>[] nodeArr, int size, int index, int limit, long est, ConcurrentHashMap<K, V> concurrentHashMap) {
            super(nodeArr, size, index, limit);
            this.map = concurrentHashMap;
            this.est = est;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySpliterator != java.util.concurrent.ConcurrentHashMap$EntrySpliterator<K, V> */
        @Override // j$.util.Spliterator
        public EntrySpliterator<K, V> trySplit() {
            int i = this.baseIndex;
            int f = this.baseLimit;
            int h = (i + f) >>> 1;
            if (h <= i) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i2 = this.baseSize;
            this.baseLimit = h;
            long j = this.est >>> 1;
            this.est = j;
            return new EntrySpliterator<>(nodeArr, i2, h, f, j, this.map);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySpliterator != java.util.concurrent.ConcurrentHashMap$EntrySpliterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    action.accept(new MapEntry(advance.key, advance.val, this.map));
                } else {
                    return;
                }
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySpliterator != java.util.concurrent.ConcurrentHashMap$EntrySpliterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V> advance = advance();
            if (advance == null) {
                return false;
            }
            action.accept(new MapEntry(advance.key, advance.val, this.map));
            return true;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySpliterator != java.util.concurrent.ConcurrentHashMap$EntrySpliterator<K, V> */
        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySpliterator != java.util.concurrent.ConcurrentHashMap$EntrySpliterator<K, V> */
        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4353;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    final int batchFor(long b) {
        if (b != Long.MAX_VALUE) {
            long n = sumCount();
            if (n <= 1 || n < b) {
                return 0;
            }
            int sp = ForkJoinPool.getCommonPoolParallelism() << 2;
            if (b > 0) {
                long n2 = n / b;
                if (n2 < sp) {
                    return (int) n2;
                }
            }
            return sp;
        }
        return 0;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public void forEach(long parallelismThreshold, BiConsumer<? super K, ? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachMappingTask(null, batchFor(parallelismThreshold), 0, 0, this.table, action).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> void forEach(long parallelismThreshold, BiFunction<? super K, ? super V, ? extends U> transformer, Consumer<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedMappingTask(null, batchFor(parallelismThreshold), 0, 0, this.table, transformer, action).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> U search(long parallelismThreshold, BiFunction<? super K, ? super V, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return (U) new SearchMappingsTask(null, batchFor(parallelismThreshold), 0, 0, this.table, searchFunction, new AtomicReference()).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> U reduce(long parallelismThreshold, BiFunction<? super K, ? super V, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return (U) new MapReduceMappingsTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, reducer).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public double reduceToDouble(long parallelismThreshold, ToDoubleBiFunction<? super K, ? super V> transformer, double basis, DoubleBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Double) new MapReduceMappingsToDoubleTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).doubleValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public long reduceToLong(long parallelismThreshold, ToLongBiFunction<? super K, ? super V> transformer, long basis, LongBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Long) new MapReduceMappingsToLongTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).longValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public int reduceToInt(long parallelismThreshold, ToIntBiFunction<? super K, ? super V> transformer, int basis, IntBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Integer) new MapReduceMappingsToIntTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).intValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public void forEachKey(long parallelismThreshold, Consumer<? super K> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachKeyTask(null, batchFor(parallelismThreshold), 0, 0, this.table, action).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> void forEachKey(long parallelismThreshold, Function<? super K, ? extends U> transformer, Consumer<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedKeyTask(null, batchFor(parallelismThreshold), 0, 0, this.table, transformer, action).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> U searchKeys(long parallelismThreshold, Function<? super K, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return (U) new SearchKeysTask(null, batchFor(parallelismThreshold), 0, 0, this.table, searchFunction, new AtomicReference()).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public K reduceKeys(long parallelismThreshold, BiFunction<? super K, ? super K, ? extends K> reducer) {
        if (reducer == null) {
            throw new NullPointerException();
        }
        return (K) new ReduceKeysTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, reducer).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> U reduceKeys(long parallelismThreshold, Function<? super K, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return (U) new MapReduceKeysTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, reducer).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public double reduceKeysToDouble(long parallelismThreshold, ToDoubleFunction<? super K> transformer, double basis, DoubleBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Double) new MapReduceKeysToDoubleTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).doubleValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public long reduceKeysToLong(long parallelismThreshold, ToLongFunction<? super K> transformer, long basis, LongBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Long) new MapReduceKeysToLongTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).longValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public int reduceKeysToInt(long parallelismThreshold, ToIntFunction<? super K> transformer, int basis, IntBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Integer) new MapReduceKeysToIntTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).intValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public void forEachValue(long parallelismThreshold, Consumer<? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachValueTask(null, batchFor(parallelismThreshold), 0, 0, this.table, action).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> void forEachValue(long parallelismThreshold, Function<? super V, ? extends U> transformer, Consumer<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedValueTask(null, batchFor(parallelismThreshold), 0, 0, this.table, transformer, action).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> U searchValues(long parallelismThreshold, Function<? super V, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return (U) new SearchValuesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, searchFunction, new AtomicReference()).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public V reduceValues(long parallelismThreshold, BiFunction<? super V, ? super V, ? extends V> reducer) {
        if (reducer == null) {
            throw new NullPointerException();
        }
        return (V) new ReduceValuesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, reducer).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> U reduceValues(long parallelismThreshold, Function<? super V, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return (U) new MapReduceValuesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, reducer).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public double reduceValuesToDouble(long parallelismThreshold, ToDoubleFunction<? super V> transformer, double basis, DoubleBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Double) new MapReduceValuesToDoubleTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).doubleValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public long reduceValuesToLong(long parallelismThreshold, ToLongFunction<? super V> transformer, long basis, LongBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Long) new MapReduceValuesToLongTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).longValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public int reduceValuesToInt(long parallelismThreshold, ToIntFunction<? super V> transformer, int basis, IntBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Integer) new MapReduceValuesToIntTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).intValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public void forEachEntry(long parallelismThreshold, Consumer<? super Map.Entry<K, V>> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachEntryTask(null, batchFor(parallelismThreshold), 0, 0, this.table, action).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> void forEachEntry(long parallelismThreshold, Function<Map.Entry<K, V>, ? extends U> transformer, Consumer<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedEntryTask(null, batchFor(parallelismThreshold), 0, 0, this.table, transformer, action).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> U searchEntries(long parallelismThreshold, Function<Map.Entry<K, V>, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return (U) new SearchEntriesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, searchFunction, new AtomicReference()).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public Map.Entry<K, V> reduceEntries(long parallelismThreshold, BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer) {
        if (reducer == null) {
            throw new NullPointerException();
        }
        return (Map.Entry) new ReduceEntriesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, reducer).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public <U> U reduceEntries(long parallelismThreshold, Function<Map.Entry<K, V>, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return (U) new MapReduceEntriesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, reducer).invoke();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public double reduceEntriesToDouble(long parallelismThreshold, ToDoubleFunction<Map.Entry<K, V>> transformer, double basis, DoubleBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Double) new MapReduceEntriesToDoubleTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).doubleValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public long reduceEntriesToLong(long parallelismThreshold, ToLongFunction<Map.Entry<K, V>> transformer, long basis, LongBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Long) new MapReduceEntriesToLongTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).longValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
    public int reduceEntriesToInt(long parallelismThreshold, ToIntFunction<Map.Entry<K, V>> transformer, int basis, IntBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Integer) new MapReduceEntriesToIntTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class CollectionView<K, V, E> implements Collection<E>, Serializable {
        private static final String OOME_MSG = "Required array size too large";
        private static final long serialVersionUID = 7249069246763182397L;
        final ConcurrentHashMap<K, V> map;

        @Override // java.util.Collection
        public abstract boolean contains(Object obj);

        @Override // java.util.Collection, java.lang.Iterable
        public abstract Iterator<E> iterator();

        @Override // java.util.Collection
        public abstract boolean remove(Object obj);

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        CollectionView(ConcurrentHashMap<K, V> concurrentHashMap) {
            this.map = concurrentHashMap;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        public ConcurrentHashMap<K, V> getMap() {
            return this.map;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        @Override // java.util.Collection
        public final void clear() {
            this.map.clear();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        @Override // java.util.Collection
        public final int size() {
            return this.map.size();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        @Override // java.util.Collection
        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        @Override // java.util.Collection
        public final Object[] toArray() {
            long sz = this.map.mappingCount();
            if (sz > 2147483639) {
                throw new OutOfMemoryError(OOME_MSG);
            }
            int n = (int) sz;
            Object[] r = new Object[n];
            int i = 0;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                E e = it.next();
                if (i == n) {
                    if (n >= ConcurrentHashMap.MAX_ARRAY_SIZE) {
                        throw new OutOfMemoryError(OOME_MSG);
                    }
                    if (n >= 1073741819) {
                        n = ConcurrentHashMap.MAX_ARRAY_SIZE;
                    } else {
                        n += (n >>> 1) + 1;
                    }
                    r = Arrays.copyOf(r, n);
                }
                r[i] = e;
                i++;
            }
            return i == n ? r : Arrays.copyOf(r, i);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        @Override // java.util.Collection
        public final <T> T[] toArray(T[] a) {
            long sz = this.map.mappingCount();
            if (sz > 2147483639) {
                throw new OutOfMemoryError(OOME_MSG);
            }
            int m = (int) sz;
            T[] tArr = a.length >= m ? a : (Object[]) Array.newInstance(a.getClass().getComponentType(), m);
            int n = tArr.length;
            int i = 0;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                E e = it.next();
                if (i == n) {
                    if (n >= ConcurrentHashMap.MAX_ARRAY_SIZE) {
                        throw new OutOfMemoryError(OOME_MSG);
                    }
                    if (n >= 1073741819) {
                        n = ConcurrentHashMap.MAX_ARRAY_SIZE;
                    } else {
                        n += (n >>> 1) + 1;
                    }
                    tArr = (T[]) Arrays.copyOf(tArr, n);
                }
                tArr[i] = e;
                i++;
            }
            if (a == r && i < n) {
                tArr[i] = null;
                T[] r = (T[]) tArr;
                return r;
            } else if (i == n) {
                Object[] r2 = tArr;
                return r2;
            } else {
                return (T[]) Arrays.copyOf(tArr, i);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Iterator<E> it = iterator();
            if (it.hasNext()) {
                while (true) {
                    Object e = it.next();
                    sb.append(e == this ? "(this Collection)" : e);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(',').append(' ');
                }
            }
            return sb.append(']').toString();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
        @Override // java.util.Collection
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean containsAll(Collection<?> c) {
            if (c != this) {
                for (Object e : c) {
                    if (e == null || !contains(e)) {
                        return false;
                    }
                    while (r0.hasNext()) {
                    }
                }
                return true;
            }
            return true;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        @Override // java.util.Collection
        public boolean removeAll(Collection<?> c) {
            if (c == null) {
                throw new NullPointerException();
            }
            boolean modified = false;
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return false;
            }
            if ((c instanceof Set) && c.size() > nodeArr.length) {
                Iterator<E> it = iterator();
                while (it.hasNext()) {
                    if (c.contains(it.next())) {
                        it.remove();
                        modified = true;
                    }
                }
            } else {
                for (Object e : c) {
                    modified |= remove(e);
                }
            }
            return modified;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$CollectionView != java.util.concurrent.ConcurrentHashMap$CollectionView<K, V, E> */
        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> c) {
            if (c == null) {
                throw new NullPointerException();
            }
            boolean modified = false;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                if (!c.contains(it.next())) {
                    it.remove();
                    modified = true;
                }
            }
            return modified;
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class KeySetView<K, V> extends CollectionView<K, V, K> implements Set<K>, Serializable, j$.util.Set<K> {
        private static final long serialVersionUID = 7249069246763182397L;
        private final V value;

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Collection.CC.$default$parallelStream(this);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream parallelStream() {
            return Stream.Wrapper.convert(parallelStream());
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.convert(spliterator());
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream stream() {
            return Stream.Wrapper.convert(stream());
        }

        @Override // j$.util.Collection
        public /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Collection.CC.$default$toArray(this, intFunction);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView
        public /* bridge */ /* synthetic */ ConcurrentHashMap getMap() {
            return super.getMap();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public /* bridge */ /* synthetic */ boolean removeAll(java.util.Collection collection) {
            return super.removeAll(collection);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        KeySetView(ConcurrentHashMap<K, V> concurrentHashMap, V value) {
            super(concurrentHashMap);
            this.value = value;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        public V getMappedValue() {
            return this.value;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean contains(Object o) {
            return this.map.containsKey(o);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean remove(Object o) {
            return this.map.remove(o) != null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            ConcurrentHashMap<K, V> concurrentHashMap = this.map;
            Node<K, V>[] nodeArr = concurrentHashMap.table;
            int f = nodeArr == null ? 0 : nodeArr.length;
            return new KeyIterator(nodeArr, f, 0, f, concurrentHashMap);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        @Override // java.util.Collection, java.util.Set
        public boolean add(K e) {
            V v = this.value;
            if (v != null) {
                return this.map.putVal(e, v, true) == null;
            }
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        @Override // java.util.Collection, java.util.Set
        public boolean addAll(java.util.Collection<? extends K> c) {
            boolean added = false;
            V v = this.value;
            if (v == null) {
                throw new UnsupportedOperationException();
            }
            for (K e : c) {
                if (this.map.putVal(e, v, true) == null) {
                    added = true;
                }
            }
            return added;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int h = 0;
            Iterator<K> it = iterator();
            while (it.hasNext()) {
                K e = it.next();
                h += e.hashCode();
            }
            return h;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o) {
            Set<?> c;
            return (o instanceof Set) && ((c = (Set) o) == this || (containsAll(c) && c.containsAll(this)));
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        @Override // java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Set, j$.util.Collection, j$.lang.Iterable
        public Spliterator<K> spliterator() {
            ConcurrentHashMap<K, V> concurrentHashMap = this.map;
            long n = concurrentHashMap.sumCount();
            Node<K, V>[] nodeArr = concurrentHashMap.table;
            int f = nodeArr == null ? 0 : nodeArr.length;
            return new KeySpliterator(nodeArr, f, 0, f, n < 0 ? 0L : n);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$KeySetView != java.util.concurrent.ConcurrentHashMap$KeySetView<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
        @Override // java.lang.Iterable, j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node<K, V> advance = traverser.advance();
                    if (advance != null) {
                        action.accept((K) advance.key);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class ValuesView<K, V> extends CollectionView<K, V, V> implements java.util.Collection<V>, Serializable, j$.util.Collection<V> {
        private static final long serialVersionUID = 2249069246763182397L;

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Collection.CC.$default$parallelStream(this);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream parallelStream() {
            return Stream.Wrapper.convert(parallelStream());
        }

        @Override // java.util.Collection, java.lang.Iterable
        public /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.convert(spliterator());
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream stream() {
            return Stream.Wrapper.convert(stream());
        }

        @Override // j$.util.Collection
        public /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Collection.CC.$default$toArray(this, intFunction);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
        ValuesView(ConcurrentHashMap<K, V> concurrentHashMap) {
            super(concurrentHashMap);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public final boolean contains(Object o) {
            return this.map.containsValue(o);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public final boolean remove(Object o) {
            if (o != null) {
                Iterator<V> it = iterator();
                while (it.hasNext()) {
                    if (o.equals(it.next())) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            ConcurrentHashMap<K, V> concurrentHashMap = this.map;
            Node<K, V>[] nodeArr = concurrentHashMap.table;
            int f = nodeArr == null ? 0 : nodeArr.length;
            return new ValueIterator(nodeArr, f, 0, f, concurrentHashMap);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
        @Override // java.util.Collection
        public final boolean add(V e) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
        @Override // java.util.Collection
        public final boolean addAll(java.util.Collection<? extends V> c) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean removeAll(java.util.Collection<?> c) {
            if (c == null) {
                throw new NullPointerException();
            }
            boolean modified = false;
            Iterator<V> it = iterator();
            while (it.hasNext()) {
                if (c.contains(it.next())) {
                    it.remove();
                    modified = true;
                }
            }
            return modified;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
        @Override // java.util.Collection, j$.util.Collection
        public boolean removeIf(Predicate<? super V> filter) {
            return this.map.removeValueIf(filter);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, j$.lang.Iterable
        public Spliterator<V> spliterator() {
            ConcurrentHashMap<K, V> concurrentHashMap = this.map;
            long n = concurrentHashMap.sumCount();
            Node<K, V>[] nodeArr = concurrentHashMap.table;
            int f = nodeArr == null ? 0 : nodeArr.length;
            return new ValueSpliterator(nodeArr, f, 0, f, n < 0 ? 0L : n);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ValuesView != java.util.concurrent.ConcurrentHashMap$ValuesView<K, V> */
        @Override // java.lang.Iterable, j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer<? super V> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node<K, V> advance = traverser.advance();
                    if (advance != null) {
                        action.accept((V) advance.val);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class EntrySetView<K, V> extends CollectionView<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>>, Serializable, j$.util.Set<Map.Entry<K, V>> {
        private static final long serialVersionUID = 2249069246763182397L;

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Collection.CC.$default$parallelStream(this);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream parallelStream() {
            return Stream.Wrapper.convert(parallelStream());
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.convert(spliterator());
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream stream() {
            return Stream.Wrapper.convert(stream());
        }

        @Override // j$.util.Collection
        public /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Collection.CC.$default$toArray(this, intFunction);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        @Override // java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add((Map.Entry) ((Map.Entry) obj));
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        EntrySetView(ConcurrentHashMap<K, V> concurrentHashMap) {
            super(concurrentHashMap);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean contains(Object o) {
            Map.Entry<?, ?> e;
            Object k;
            Object r;
            Object v;
            return (!(o instanceof Map.Entry) || (k = (e = (Map.Entry) o).getKey()) == null || (r = this.map.get(k)) == null || (v = e.getValue()) == null || (v != r && !v.equals(r))) ? false : true;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean remove(Object o) {
            Map.Entry<?, ?> e;
            Object k;
            Object v;
            return (o instanceof Map.Entry) && (k = (e = (Map.Entry) o).getKey()) != null && (v = e.getValue()) != null && this.map.remove(k, v);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            ConcurrentHashMap<K, V> concurrentHashMap = this.map;
            Node<K, V>[] nodeArr = concurrentHashMap.table;
            int f = nodeArr == null ? 0 : nodeArr.length;
            return new EntryIterator(nodeArr, f, 0, f, concurrentHashMap);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        public boolean add(Map.Entry<K, V> e) {
            return this.map.putVal(e.getKey(), e.getValue(), false) == null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        @Override // java.util.Collection, java.util.Set
        public boolean addAll(java.util.Collection<? extends Map.Entry<K, V>> c) {
            boolean added = false;
            for (Map.Entry<K, V> e : c) {
                if (add((Map.Entry) e)) {
                    added = true;
                }
            }
            return added;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        @Override // java.util.Collection, j$.util.Collection
        public boolean removeIf(Predicate<? super Map.Entry<K, V>> filter) {
            return this.map.removeEntryIf(filter);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            int h = 0;
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node<K, V> advance = traverser.advance();
                    if (advance == null) {
                        break;
                    }
                    h += advance.hashCode();
                }
            }
            return h;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object o) {
            Set<?> c;
            return (o instanceof Set) && ((c = (Set) o) == this || (containsAll(c) && c.containsAll(this)));
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap != java.util.concurrent.ConcurrentHashMap<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        @Override // java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Set, j$.util.Collection, j$.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            ConcurrentHashMap<K, V> concurrentHashMap = this.map;
            long n = concurrentHashMap.sumCount();
            Node<K, V>[] nodeArr = concurrentHashMap.table;
            int f = nodeArr == null ? 0 : nodeArr.length;
            return new EntrySpliterator(nodeArr, f, 0, f, n < 0 ? 0L : n, concurrentHashMap);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$EntrySetView != java.util.concurrent.ConcurrentHashMap$EntrySetView<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Traverser != java.util.concurrent.ConcurrentHashMap$Traverser<K, V> */
        @Override // java.lang.Iterable, j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node<K, V> advance = traverser.advance();
                    if (advance != null) {
                        action.accept(new MapEntry(advance.key, advance.val, this.map));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static abstract class BulkTask<K, V, R> extends CountedCompleter<R> {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int batch;
        int index;
        Node<K, V> next;
        TableStack<K, V> spare;
        TableStack<K, V> stack;
        Node<K, V>[] tab;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, R> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        BulkTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr) {
            super(bulkTask);
            this.batch = b;
            this.baseIndex = i;
            this.index = i;
            this.tab = nodeArr;
            if (nodeArr == null) {
                this.baseLimit = 0;
                this.baseSize = 0;
            } else if (bulkTask == null) {
                int length = nodeArr.length;
                this.baseLimit = length;
                this.baseSize = length;
            } else {
                this.baseLimit = f;
                this.baseSize = bulkTask.baseSize;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, R> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        final Node<K, V> advance() {
            Node<K, V>[] nodeArr;
            int n;
            int i;
            Node<K, V> node = this.next;
            TreeNode<K, V> treeNode = node;
            if (node != null) {
                treeNode = treeNode.next;
            }
            while (treeNode == null) {
                if (this.baseIndex >= this.baseLimit || (nodeArr = this.tab) == null || (n = nodeArr.length) <= (i = this.index) || i < 0) {
                    this.next = null;
                    return null;
                }
                Node<K, V> tabAt = ConcurrentHashMap.tabAt(nodeArr, i);
                treeNode = tabAt;
                if (tabAt != null && treeNode.hash < 0) {
                    if (treeNode instanceof ForwardingNode) {
                        this.tab = ((ForwardingNode) treeNode).nextTable;
                        treeNode = null;
                        pushState(nodeArr, i, n);
                    } else if (treeNode instanceof TreeBin) {
                        treeNode = ((TreeBin) treeNode).first;
                    } else {
                        treeNode = null;
                    }
                }
                if (this.stack != null) {
                    recoverState(n);
                } else {
                    int i2 = this.baseSize + i;
                    this.index = i2;
                    if (i2 >= n) {
                        int i3 = this.baseIndex + 1;
                        this.baseIndex = i3;
                        this.index = i3;
                    }
                }
            }
            this.next = treeNode;
            return treeNode;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, R> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TableStack != java.util.concurrent.ConcurrentHashMap$TableStack<K, V> */
        private void pushState(Node<K, V>[] nodeArr, int i, int n) {
            TableStack<K, V> tableStack = this.spare;
            if (tableStack != null) {
                this.spare = tableStack.next;
            } else {
                tableStack = new TableStack<>();
            }
            tableStack.tab = nodeArr;
            tableStack.length = n;
            tableStack.index = i;
            tableStack.next = this.stack;
            this.stack = tableStack;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, R> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$TableStack != java.util.concurrent.ConcurrentHashMap$TableStack<K, V> */
        private void recoverState(int n) {
            TableStack<K, V> tableStack;
            while (true) {
                tableStack = this.stack;
                if (tableStack == null) {
                    break;
                }
                int i = this.index;
                int len = tableStack.length;
                int i2 = i + len;
                this.index = i2;
                if (i2 < n) {
                    break;
                }
                n = len;
                this.index = tableStack.index;
                this.tab = tableStack.tab;
                tableStack.tab = null;
                TableStack<K, V> tableStack2 = tableStack.next;
                tableStack.next = this.spare;
                this.stack = tableStack2;
                this.spare = tableStack;
            }
            if (tableStack == null) {
                int i3 = this.index + this.baseSize;
                this.index = i3;
                if (i3 >= n) {
                    int i4 = this.baseIndex + 1;
                    this.baseIndex = i4;
                    this.index = i4;
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ForEachKeyTask<K, V> extends BulkTask<K, V, Void> {
        final Consumer<? super K> action;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachKeyTask != java.util.concurrent.ConcurrentHashMap$ForEachKeyTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        ForEachKeyTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, Consumer<? super K> action) {
            super(bulkTask, b, i, f, nodeArr);
            this.action = action;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachKeyTask != java.util.concurrent.ConcurrentHashMap$ForEachKeyTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super K> action = this.action;
            if (action != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    new ForEachKeyTask(this, i2, h, f, this.tab, action).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        action.accept((K) advance.key);
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ForEachValueTask<K, V> extends BulkTask<K, V, Void> {
        final Consumer<? super V> action;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachValueTask != java.util.concurrent.ConcurrentHashMap$ForEachValueTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        ForEachValueTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, Consumer<? super V> action) {
            super(bulkTask, b, i, f, nodeArr);
            this.action = action;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachValueTask != java.util.concurrent.ConcurrentHashMap$ForEachValueTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super V> action = this.action;
            if (action != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    new ForEachValueTask(this, i2, h, f, this.tab, action).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        action.accept((V) advance.val);
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ForEachEntryTask<K, V> extends BulkTask<K, V, Void> {
        final Consumer<? super Map.Entry<K, V>> action;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachEntryTask != java.util.concurrent.ConcurrentHashMap$ForEachEntryTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        ForEachEntryTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, Consumer<? super Map.Entry<K, V>> action) {
            super(bulkTask, b, i, f, nodeArr);
            this.action = action;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachEntryTask != java.util.concurrent.ConcurrentHashMap$ForEachEntryTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super Map.Entry<K, V>> action = this.action;
            if (action != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    new ForEachEntryTask(this, i2, h, f, this.tab, action).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        action.accept(advance);
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ForEachMappingTask<K, V> extends BulkTask<K, V, Void> {
        final BiConsumer<? super K, ? super V> action;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachMappingTask != java.util.concurrent.ConcurrentHashMap$ForEachMappingTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        ForEachMappingTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, BiConsumer<? super K, ? super V> action) {
            super(bulkTask, b, i, f, nodeArr);
            this.action = action;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachMappingTask != java.util.concurrent.ConcurrentHashMap$ForEachMappingTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiConsumer<? super K, ? super V> action = this.action;
            if (action != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    new ForEachMappingTask(this, i2, h, f, this.tab, action).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        action.accept((K) advance.key, (V) advance.val);
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ForEachTransformedKeyTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final Function<? super K, ? extends U> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachTransformedKeyTask != java.util.concurrent.ConcurrentHashMap$ForEachTransformedKeyTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        ForEachTransformedKeyTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, Function<? super K, ? extends U> transformer, Consumer<? super U> action) {
            super(bulkTask, b, i, f, nodeArr);
            this.transformer = transformer;
            this.action = action;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachTransformedKeyTask != java.util.concurrent.ConcurrentHashMap$ForEachTransformedKeyTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super U> action;
            Function<? super K, ? extends U> transformer = this.transformer;
            if (transformer != null && (action = this.action) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    new ForEachTransformedKeyTask(this, i2, h, f, this.tab, transformer, action).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        Object obj = (U) transformer.apply((K) advance.key);
                        if (obj != null) {
                            action.accept(obj);
                        }
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ForEachTransformedValueTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final Function<? super V, ? extends U> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachTransformedValueTask != java.util.concurrent.ConcurrentHashMap$ForEachTransformedValueTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        ForEachTransformedValueTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, Function<? super V, ? extends U> transformer, Consumer<? super U> action) {
            super(bulkTask, b, i, f, nodeArr);
            this.transformer = transformer;
            this.action = action;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachTransformedValueTask != java.util.concurrent.ConcurrentHashMap$ForEachTransformedValueTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super U> action;
            Function<? super V, ? extends U> transformer = this.transformer;
            if (transformer != null && (action = this.action) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    new ForEachTransformedValueTask(this, i2, h, f, this.tab, transformer, action).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        Object obj = (U) transformer.apply((V) advance.val);
                        if (obj != null) {
                            action.accept(obj);
                        }
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ForEachTransformedEntryTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final Function<Map.Entry<K, V>, ? extends U> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachTransformedEntryTask != java.util.concurrent.ConcurrentHashMap$ForEachTransformedEntryTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        ForEachTransformedEntryTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, Function<Map.Entry<K, V>, ? extends U> transformer, Consumer<? super U> action) {
            super(bulkTask, b, i, f, nodeArr);
            this.transformer = transformer;
            this.action = action;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachTransformedEntryTask != java.util.concurrent.ConcurrentHashMap$ForEachTransformedEntryTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super U> action;
            Function<Map.Entry<K, V>, ? extends U> transformer = this.transformer;
            if (transformer != null && (action = this.action) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    new ForEachTransformedEntryTask(this, i2, h, f, this.tab, transformer, action).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        Object obj = (U) transformer.apply(advance);
                        if (obj != null) {
                            action.accept(obj);
                        }
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ForEachTransformedMappingTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final BiFunction<? super K, ? super V, ? extends U> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachTransformedMappingTask != java.util.concurrent.ConcurrentHashMap$ForEachTransformedMappingTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        ForEachTransformedMappingTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, BiFunction<? super K, ? super V, ? extends U> transformer, Consumer<? super U> action) {
            super(bulkTask, b, i, f, nodeArr);
            this.transformer = transformer;
            this.action = action;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ForEachTransformedMappingTask != java.util.concurrent.ConcurrentHashMap$ForEachTransformedMappingTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super U> action;
            BiFunction<? super K, ? super V, ? extends U> transformer = this.transformer;
            if (transformer != null && (action = this.action) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    new ForEachTransformedMappingTask(this, i2, h, f, this.tab, transformer, action).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        Object obj = (U) transformer.apply((K) advance.key, (V) advance.val);
                        if (obj != null) {
                            action.accept(obj);
                        }
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class SearchKeysTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Function<? super K, ? extends U> searchFunction;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchKeysTask != java.util.concurrent.ConcurrentHashMap$SearchKeysTask<K, V, U> */
        SearchKeysTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, Function<? super K, ? extends U> searchFunction, AtomicReference<U> result) {
            super(bulkTask, b, i, f, nodeArr);
            this.searchFunction = searchFunction;
            this.result = result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchKeysTask != java.util.concurrent.ConcurrentHashMap$SearchKeysTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchKeysTask != java.util.concurrent.ConcurrentHashMap$SearchKeysTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            AtomicReference<U> result;
            Function<? super K, ? extends U> searchFunction = this.searchFunction;
            if (searchFunction != null && (result = this.result) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    } else if (result.get() != null) {
                        return;
                    } else {
                        addToPendingCount(1);
                        int i2 = this.batch >>> 1;
                        this.batch = i2;
                        this.baseLimit = h;
                        new SearchKeysTask(this, i2, h, f, this.tab, searchFunction, result).fork();
                    }
                }
                while (result.get() == null) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        propagateCompletion();
                        return;
                    }
                    U u = searchFunction.apply((K) advance.key);
                    if (u != null) {
                        if (ConcurrentHashMap$SearchEntriesTask$$ExternalSyntheticBackportWithForwarding0.m(result, null, u)) {
                            quietlyCompleteRoot();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class SearchValuesTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Function<? super V, ? extends U> searchFunction;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchValuesTask != java.util.concurrent.ConcurrentHashMap$SearchValuesTask<K, V, U> */
        SearchValuesTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, Function<? super V, ? extends U> searchFunction, AtomicReference<U> result) {
            super(bulkTask, b, i, f, nodeArr);
            this.searchFunction = searchFunction;
            this.result = result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchValuesTask != java.util.concurrent.ConcurrentHashMap$SearchValuesTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchValuesTask != java.util.concurrent.ConcurrentHashMap$SearchValuesTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            AtomicReference<U> result;
            Function<? super V, ? extends U> searchFunction = this.searchFunction;
            if (searchFunction != null && (result = this.result) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    } else if (result.get() != null) {
                        return;
                    } else {
                        addToPendingCount(1);
                        int i2 = this.batch >>> 1;
                        this.batch = i2;
                        this.baseLimit = h;
                        new SearchValuesTask(this, i2, h, f, this.tab, searchFunction, result).fork();
                    }
                }
                while (result.get() == null) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        propagateCompletion();
                        return;
                    }
                    U u = searchFunction.apply((V) advance.val);
                    if (u != null) {
                        if (ConcurrentHashMap$SearchEntriesTask$$ExternalSyntheticBackportWithForwarding0.m(result, null, u)) {
                            quietlyCompleteRoot();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class SearchEntriesTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Function<Map.Entry<K, V>, ? extends U> searchFunction;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchEntriesTask != java.util.concurrent.ConcurrentHashMap$SearchEntriesTask<K, V, U> */
        SearchEntriesTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, Function<Map.Entry<K, V>, ? extends U> searchFunction, AtomicReference<U> result) {
            super(bulkTask, b, i, f, nodeArr);
            this.searchFunction = searchFunction;
            this.result = result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchEntriesTask != java.util.concurrent.ConcurrentHashMap$SearchEntriesTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchEntriesTask != java.util.concurrent.ConcurrentHashMap$SearchEntriesTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            AtomicReference<U> result;
            Function<Map.Entry<K, V>, ? extends U> searchFunction = this.searchFunction;
            if (searchFunction != null && (result = this.result) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    } else if (result.get() != null) {
                        return;
                    } else {
                        addToPendingCount(1);
                        int i2 = this.batch >>> 1;
                        this.batch = i2;
                        this.baseLimit = h;
                        new SearchEntriesTask(this, i2, h, f, this.tab, searchFunction, result).fork();
                    }
                }
                while (result.get() == null) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        propagateCompletion();
                        return;
                    }
                    U u = searchFunction.apply(advance);
                    if (u != null) {
                        if (ConcurrentHashMap$SearchEntriesTask$$ExternalSyntheticBackportWithForwarding0.m(result, null, u)) {
                            quietlyCompleteRoot();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class SearchMappingsTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final BiFunction<? super K, ? super V, ? extends U> searchFunction;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchMappingsTask != java.util.concurrent.ConcurrentHashMap$SearchMappingsTask<K, V, U> */
        SearchMappingsTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, BiFunction<? super K, ? super V, ? extends U> searchFunction, AtomicReference<U> result) {
            super(bulkTask, b, i, f, nodeArr);
            this.searchFunction = searchFunction;
            this.result = result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchMappingsTask != java.util.concurrent.ConcurrentHashMap$SearchMappingsTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$SearchMappingsTask != java.util.concurrent.ConcurrentHashMap$SearchMappingsTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            AtomicReference<U> result;
            BiFunction<? super K, ? super V, ? extends U> searchFunction = this.searchFunction;
            if (searchFunction != null && (result = this.result) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    } else if (result.get() != null) {
                        return;
                    } else {
                        addToPendingCount(1);
                        int i2 = this.batch >>> 1;
                        this.batch = i2;
                        this.baseLimit = h;
                        new SearchMappingsTask(this, i2, h, f, this.tab, searchFunction, result).fork();
                    }
                }
                while (result.get() == null) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        propagateCompletion();
                        return;
                    }
                    U u = searchFunction.apply((K) advance.key, (V) advance.val);
                    if (u != null) {
                        if (ConcurrentHashMap$SearchEntriesTask$$ExternalSyntheticBackportWithForwarding0.m(result, null, u)) {
                            quietlyCompleteRoot();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ReduceKeysTask<K, V> extends BulkTask<K, V, K> {
        ReduceKeysTask<K, V> nextRight;
        final BiFunction<? super K, ? super K, ? extends K> reducer;
        K result;
        ReduceKeysTask<K, V> rights;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReduceKeysTask != java.util.concurrent.ConcurrentHashMap$ReduceKeysTask<K, V> */
        ReduceKeysTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, ReduceKeysTask<K, V> reduceKeysTask, BiFunction<? super K, ? super K, ? extends K> reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = reduceKeysTask;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReduceKeysTask != java.util.concurrent.ConcurrentHashMap$ReduceKeysTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final K getRawResult() {
            return this.result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReduceKeysTask != java.util.concurrent.ConcurrentHashMap$ReduceKeysTask<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super K, ? super K, ? extends K> reducer = this.reducer;
            if (reducer != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    ReduceKeysTask<K, V> reduceKeysTask = new ReduceKeysTask<>(this, i2, h, f, this.tab, this.rights, reducer);
                    this.rights = reduceKeysTask;
                    reduceKeysTask.fork();
                }
                K r = (K) 0;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj = (K) advance.key;
                    r = r == null ? obj : obj == null ? r : reducer.apply(r, obj);
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    ReduceKeysTask reduceKeysTask2 = (ReduceKeysTask) c;
                    ReduceKeysTask<K, V> reduceKeysTask3 = reduceKeysTask2.rights;
                    while (reduceKeysTask3 != null) {
                        K k = reduceKeysTask3.result;
                        if (k != 0) {
                            Object obj2 = (K) reduceKeysTask2.result;
                            reduceKeysTask2.result = obj2 == null ? k : reducer.apply(obj2, k);
                        }
                        ReduceKeysTask<K, V> reduceKeysTask4 = reduceKeysTask3.nextRight;
                        reduceKeysTask2.rights = reduceKeysTask4;
                        reduceKeysTask3 = reduceKeysTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ReduceValuesTask<K, V> extends BulkTask<K, V, V> {
        ReduceValuesTask<K, V> nextRight;
        final BiFunction<? super V, ? super V, ? extends V> reducer;
        V result;
        ReduceValuesTask<K, V> rights;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReduceValuesTask != java.util.concurrent.ConcurrentHashMap$ReduceValuesTask<K, V> */
        ReduceValuesTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, ReduceValuesTask<K, V> reduceValuesTask, BiFunction<? super V, ? super V, ? extends V> reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = reduceValuesTask;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReduceValuesTask != java.util.concurrent.ConcurrentHashMap$ReduceValuesTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final V getRawResult() {
            return this.result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReduceValuesTask != java.util.concurrent.ConcurrentHashMap$ReduceValuesTask<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super V, ? super V, ? extends V> reducer = this.reducer;
            if (reducer != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    ReduceValuesTask<K, V> reduceValuesTask = new ReduceValuesTask<>(this, i2, h, f, this.tab, this.rights, reducer);
                    this.rights = reduceValuesTask;
                    reduceValuesTask.fork();
                }
                V r = (V) 0;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    V v = advance.val;
                    r = r == null ? v : reducer.apply(r, v);
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    ReduceValuesTask reduceValuesTask2 = (ReduceValuesTask) c;
                    ReduceValuesTask<K, V> reduceValuesTask3 = reduceValuesTask2.rights;
                    while (reduceValuesTask3 != null) {
                        V v2 = reduceValuesTask3.result;
                        if (v2 != 0) {
                            Object obj = (V) reduceValuesTask2.result;
                            reduceValuesTask2.result = obj == null ? v2 : reducer.apply(obj, v2);
                        }
                        ReduceValuesTask<K, V> reduceValuesTask4 = reduceValuesTask3.nextRight;
                        reduceValuesTask2.rights = reduceValuesTask4;
                        reduceValuesTask3 = reduceValuesTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class ReduceEntriesTask<K, V> extends BulkTask<K, V, Map.Entry<K, V>> {
        ReduceEntriesTask<K, V> nextRight;
        final BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer;
        Map.Entry<K, V> result;
        ReduceEntriesTask<K, V> rights;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReduceEntriesTask != java.util.concurrent.ConcurrentHashMap$ReduceEntriesTask<K, V> */
        ReduceEntriesTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, ReduceEntriesTask<K, V> reduceEntriesTask, BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = reduceEntriesTask;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReduceEntriesTask != java.util.concurrent.ConcurrentHashMap$ReduceEntriesTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Map.Entry<K, V> getRawResult() {
            return this.result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$ReduceEntriesTask != java.util.concurrent.ConcurrentHashMap$ReduceEntriesTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer = this.reducer;
            if (reducer != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    ReduceEntriesTask<K, V> reduceEntriesTask = new ReduceEntriesTask<>(this, i2, h, f, this.tab, this.rights, reducer);
                    this.rights = reduceEntriesTask;
                    reduceEntriesTask.fork();
                }
                Map.Entry<K, V> r = null;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r = r == null ? advance : reducer.apply(r, advance);
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    ReduceEntriesTask reduceEntriesTask2 = (ReduceEntriesTask) c;
                    ReduceEntriesTask<K, V> reduceEntriesTask3 = reduceEntriesTask2.rights;
                    while (reduceEntriesTask3 != null) {
                        Map.Entry<K, V> sr = reduceEntriesTask3.result;
                        if (sr != null) {
                            Map.Entry<K, V> tr = reduceEntriesTask2.result;
                            reduceEntriesTask2.result = tr == null ? sr : reducer.apply(tr, sr);
                        }
                        ReduceEntriesTask<K, V> reduceEntriesTask4 = reduceEntriesTask3.nextRight;
                        reduceEntriesTask2.rights = reduceEntriesTask4;
                        reduceEntriesTask3 = reduceEntriesTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceKeysTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceKeysTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceKeysTask<K, V, U> rights;
        final Function<? super K, ? extends U> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceKeysTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceKeysTask<K, V, U> mapReduceKeysTask, Function<? super K, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceKeysTask;
            this.transformer = transformer;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super U, ? super U, ? extends U> reducer;
            Function<? super K, ? extends U> transformer = this.transformer;
            if (transformer != null && (reducer = this.reducer) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceKeysTask<K, V, U> mapReduceKeysTask = new MapReduceKeysTask<>(this, i2, h, f, this.tab, this.rights, transformer, reducer);
                    this.rights = mapReduceKeysTask;
                    mapReduceKeysTask.fork();
                }
                U r = (U) 0;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj = (U) transformer.apply((K) advance.key);
                    if (obj != null) {
                        r = r == null ? obj : reducer.apply(r, obj);
                    }
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceKeysTask mapReduceKeysTask2 = (MapReduceKeysTask) c;
                    MapReduceKeysTask<K, V, U> mapReduceKeysTask3 = mapReduceKeysTask2.rights;
                    while (mapReduceKeysTask3 != null) {
                        U u = mapReduceKeysTask3.result;
                        if (u != 0) {
                            Object obj2 = (U) mapReduceKeysTask2.result;
                            mapReduceKeysTask2.result = obj2 == null ? u : reducer.apply(obj2, u);
                        }
                        MapReduceKeysTask<K, V, U> mapReduceKeysTask4 = mapReduceKeysTask3.nextRight;
                        mapReduceKeysTask2.rights = mapReduceKeysTask4;
                        mapReduceKeysTask3 = mapReduceKeysTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceValuesTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceValuesTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceValuesTask<K, V, U> rights;
        final Function<? super V, ? extends U> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceValuesTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceValuesTask<K, V, U> mapReduceValuesTask, Function<? super V, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceValuesTask;
            this.transformer = transformer;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super U, ? super U, ? extends U> reducer;
            Function<? super V, ? extends U> transformer = this.transformer;
            if (transformer != null && (reducer = this.reducer) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceValuesTask<K, V, U> mapReduceValuesTask = new MapReduceValuesTask<>(this, i2, h, f, this.tab, this.rights, transformer, reducer);
                    this.rights = mapReduceValuesTask;
                    mapReduceValuesTask.fork();
                }
                U r = (U) 0;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj = (U) transformer.apply((V) advance.val);
                    if (obj != null) {
                        r = r == null ? obj : reducer.apply(r, obj);
                    }
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceValuesTask mapReduceValuesTask2 = (MapReduceValuesTask) c;
                    MapReduceValuesTask<K, V, U> mapReduceValuesTask3 = mapReduceValuesTask2.rights;
                    while (mapReduceValuesTask3 != null) {
                        U u = mapReduceValuesTask3.result;
                        if (u != 0) {
                            Object obj2 = (U) mapReduceValuesTask2.result;
                            mapReduceValuesTask2.result = obj2 == null ? u : reducer.apply(obj2, u);
                        }
                        MapReduceValuesTask<K, V, U> mapReduceValuesTask4 = mapReduceValuesTask3.nextRight;
                        mapReduceValuesTask2.rights = mapReduceValuesTask4;
                        mapReduceValuesTask3 = mapReduceValuesTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceEntriesTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceEntriesTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceEntriesTask<K, V, U> rights;
        final Function<Map.Entry<K, V>, ? extends U> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceEntriesTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceEntriesTask<K, V, U> mapReduceEntriesTask, Function<Map.Entry<K, V>, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceEntriesTask;
            this.transformer = transformer;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super U, ? super U, ? extends U> reducer;
            Function<Map.Entry<K, V>, ? extends U> transformer = this.transformer;
            if (transformer != null && (reducer = this.reducer) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceEntriesTask<K, V, U> mapReduceEntriesTask = new MapReduceEntriesTask<>(this, i2, h, f, this.tab, this.rights, transformer, reducer);
                    this.rights = mapReduceEntriesTask;
                    mapReduceEntriesTask.fork();
                }
                U r = (U) 0;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj = (U) transformer.apply(advance);
                    if (obj != null) {
                        r = r == null ? obj : reducer.apply(r, obj);
                    }
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceEntriesTask mapReduceEntriesTask2 = (MapReduceEntriesTask) c;
                    MapReduceEntriesTask<K, V, U> mapReduceEntriesTask3 = mapReduceEntriesTask2.rights;
                    while (mapReduceEntriesTask3 != null) {
                        U u = mapReduceEntriesTask3.result;
                        if (u != 0) {
                            Object obj2 = (U) mapReduceEntriesTask2.result;
                            mapReduceEntriesTask2.result = obj2 == null ? u : reducer.apply(obj2, u);
                        }
                        MapReduceEntriesTask<K, V, U> mapReduceEntriesTask4 = mapReduceEntriesTask3.nextRight;
                        mapReduceEntriesTask2.rights = mapReduceEntriesTask4;
                        mapReduceEntriesTask3 = mapReduceEntriesTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceMappingsTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceMappingsTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceMappingsTask<K, V, U> rights;
        final BiFunction<? super K, ? super V, ? extends U> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceMappingsTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceMappingsTask<K, V, U> mapReduceMappingsTask, BiFunction<? super K, ? super V, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceMappingsTask;
            this.transformer = transformer;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsTask<K, V, U> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsTask<K, V, U> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super U, ? super U, ? extends U> reducer;
            BiFunction<? super K, ? super V, ? extends U> transformer = this.transformer;
            if (transformer != null && (reducer = this.reducer) != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceMappingsTask<K, V, U> mapReduceMappingsTask = new MapReduceMappingsTask<>(this, i2, h, f, this.tab, this.rights, transformer, reducer);
                    this.rights = mapReduceMappingsTask;
                    mapReduceMappingsTask.fork();
                }
                U r = (U) 0;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj = (U) transformer.apply((K) advance.key, (V) advance.val);
                    if (obj != null) {
                        r = r == null ? obj : reducer.apply(r, obj);
                    }
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceMappingsTask mapReduceMappingsTask2 = (MapReduceMappingsTask) c;
                    MapReduceMappingsTask<K, V, U> mapReduceMappingsTask3 = mapReduceMappingsTask2.rights;
                    while (mapReduceMappingsTask3 != null) {
                        U u = mapReduceMappingsTask3.result;
                        if (u != 0) {
                            Object obj2 = (U) mapReduceMappingsTask2.result;
                            mapReduceMappingsTask2.result = obj2 == null ? u : reducer.apply(obj2, u);
                        }
                        MapReduceMappingsTask<K, V, U> mapReduceMappingsTask4 = mapReduceMappingsTask3.nextRight;
                        mapReduceMappingsTask2.rights = mapReduceMappingsTask4;
                        mapReduceMappingsTask3 = mapReduceMappingsTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceKeysToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceKeysToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceKeysToDoubleTask<K, V> rights;
        final ToDoubleFunction<? super K> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysToDoubleTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceKeysToDoubleTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask, ToDoubleFunction<? super K> transformer, double basis, DoubleBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceKeysToDoubleTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysToDoubleTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysToDoubleTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            DoubleBinaryOperator reducer;
            ToDoubleFunction<? super K> transformer;
            ToDoubleFunction<? super K> toDoubleFunction = this.transformer;
            ToDoubleFunction<? super K> transformer2 = toDoubleFunction;
            if (toDoubleFunction != null && (reducer = this.reducer) != null) {
                double r = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        transformer = transformer2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        transformer = transformer2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask = new MapReduceKeysToDoubleTask<>(this, i2, h, f, this.tab, this.rights, transformer2, r, reducer);
                    this.rights = mapReduceKeysToDoubleTask;
                    mapReduceKeysToDoubleTask.fork();
                    transformer2 = transformer2;
                    i = i;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r = reducer.applyAsDouble(r, transformer.applyAsDouble((K) advance.key));
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceKeysToDoubleTask mapReduceKeysToDoubleTask2 = (MapReduceKeysToDoubleTask) c;
                    MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask3 = mapReduceKeysToDoubleTask2.rights;
                    while (mapReduceKeysToDoubleTask3 != null) {
                        mapReduceKeysToDoubleTask2.result = reducer.applyAsDouble(mapReduceKeysToDoubleTask2.result, mapReduceKeysToDoubleTask3.result);
                        MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask4 = mapReduceKeysToDoubleTask3.nextRight;
                        mapReduceKeysToDoubleTask2.rights = mapReduceKeysToDoubleTask4;
                        mapReduceKeysToDoubleTask3 = mapReduceKeysToDoubleTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceValuesToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceValuesToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceValuesToDoubleTask<K, V> rights;
        final ToDoubleFunction<? super V> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesToDoubleTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceValuesToDoubleTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask, ToDoubleFunction<? super V> transformer, double basis, DoubleBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceValuesToDoubleTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesToDoubleTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesToDoubleTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            DoubleBinaryOperator reducer;
            ToDoubleFunction<? super V> transformer;
            ToDoubleFunction<? super V> toDoubleFunction = this.transformer;
            ToDoubleFunction<? super V> transformer2 = toDoubleFunction;
            if (toDoubleFunction != null && (reducer = this.reducer) != null) {
                double r = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        transformer = transformer2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        transformer = transformer2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask = new MapReduceValuesToDoubleTask<>(this, i2, h, f, this.tab, this.rights, transformer2, r, reducer);
                    this.rights = mapReduceValuesToDoubleTask;
                    mapReduceValuesToDoubleTask.fork();
                    transformer2 = transformer2;
                    i = i;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r = reducer.applyAsDouble(r, transformer.applyAsDouble((V) advance.val));
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceValuesToDoubleTask mapReduceValuesToDoubleTask2 = (MapReduceValuesToDoubleTask) c;
                    MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask3 = mapReduceValuesToDoubleTask2.rights;
                    while (mapReduceValuesToDoubleTask3 != null) {
                        mapReduceValuesToDoubleTask2.result = reducer.applyAsDouble(mapReduceValuesToDoubleTask2.result, mapReduceValuesToDoubleTask3.result);
                        MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask4 = mapReduceValuesToDoubleTask3.nextRight;
                        mapReduceValuesToDoubleTask2.rights = mapReduceValuesToDoubleTask4;
                        mapReduceValuesToDoubleTask3 = mapReduceValuesToDoubleTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceEntriesToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceEntriesToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceEntriesToDoubleTask<K, V> rights;
        final ToDoubleFunction<Map.Entry<K, V>> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesToDoubleTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceEntriesToDoubleTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask, ToDoubleFunction<Map.Entry<K, V>> transformer, double basis, DoubleBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceEntriesToDoubleTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesToDoubleTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesToDoubleTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            DoubleBinaryOperator reducer;
            ToDoubleFunction<Map.Entry<K, V>> transformer;
            ToDoubleFunction<Map.Entry<K, V>> toDoubleFunction = this.transformer;
            ToDoubleFunction<Map.Entry<K, V>> transformer2 = toDoubleFunction;
            if (toDoubleFunction != null && (reducer = this.reducer) != null) {
                double r = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        transformer = transformer2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        transformer = transformer2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask = new MapReduceEntriesToDoubleTask<>(this, i2, h, f, this.tab, this.rights, transformer2, r, reducer);
                    this.rights = mapReduceEntriesToDoubleTask;
                    mapReduceEntriesToDoubleTask.fork();
                    transformer2 = transformer2;
                    i = i;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r = reducer.applyAsDouble(r, transformer.applyAsDouble(advance));
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceEntriesToDoubleTask mapReduceEntriesToDoubleTask2 = (MapReduceEntriesToDoubleTask) c;
                    MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask3 = mapReduceEntriesToDoubleTask2.rights;
                    while (mapReduceEntriesToDoubleTask3 != null) {
                        mapReduceEntriesToDoubleTask2.result = reducer.applyAsDouble(mapReduceEntriesToDoubleTask2.result, mapReduceEntriesToDoubleTask3.result);
                        MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask4 = mapReduceEntriesToDoubleTask3.nextRight;
                        mapReduceEntriesToDoubleTask2.rights = mapReduceEntriesToDoubleTask4;
                        mapReduceEntriesToDoubleTask3 = mapReduceEntriesToDoubleTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceMappingsToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceMappingsToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceMappingsToDoubleTask<K, V> rights;
        final ToDoubleBiFunction<? super K, ? super V> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsToDoubleTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceMappingsToDoubleTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask, ToDoubleBiFunction<? super K, ? super V> transformer, double basis, DoubleBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceMappingsToDoubleTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsToDoubleTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsToDoubleTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsToDoubleTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            DoubleBinaryOperator reducer;
            ToDoubleBiFunction<? super K, ? super V> transformer;
            ToDoubleBiFunction<? super K, ? super V> toDoubleBiFunction = this.transformer;
            ToDoubleBiFunction<? super K, ? super V> transformer2 = toDoubleBiFunction;
            if (toDoubleBiFunction != null && (reducer = this.reducer) != null) {
                double r = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        transformer = transformer2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        transformer = transformer2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask = new MapReduceMappingsToDoubleTask<>(this, i2, h, f, this.tab, this.rights, transformer2, r, reducer);
                    this.rights = mapReduceMappingsToDoubleTask;
                    mapReduceMappingsToDoubleTask.fork();
                    transformer2 = transformer2;
                    i = i;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r = reducer.applyAsDouble(r, transformer.applyAsDouble((K) advance.key, (V) advance.val));
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceMappingsToDoubleTask mapReduceMappingsToDoubleTask2 = (MapReduceMappingsToDoubleTask) c;
                    MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask3 = mapReduceMappingsToDoubleTask2.rights;
                    while (mapReduceMappingsToDoubleTask3 != null) {
                        mapReduceMappingsToDoubleTask2.result = reducer.applyAsDouble(mapReduceMappingsToDoubleTask2.result, mapReduceMappingsToDoubleTask3.result);
                        MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask4 = mapReduceMappingsToDoubleTask3.nextRight;
                        mapReduceMappingsToDoubleTask2.rights = mapReduceMappingsToDoubleTask4;
                        mapReduceMappingsToDoubleTask3 = mapReduceMappingsToDoubleTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceKeysToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceKeysToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceKeysToLongTask<K, V> rights;
        final ToLongFunction<? super K> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysToLongTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceKeysToLongTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask, ToLongFunction<? super K> transformer, long basis, LongBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceKeysToLongTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysToLongTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysToLongTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            LongBinaryOperator reducer;
            ToLongFunction<? super K> transformer;
            ToLongFunction<? super K> toLongFunction = this.transformer;
            ToLongFunction<? super K> transformer2 = toLongFunction;
            if (toLongFunction != null && (reducer = this.reducer) != null) {
                long r = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        transformer = transformer2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        transformer = transformer2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask = new MapReduceKeysToLongTask<>(this, i2, h, f, this.tab, this.rights, transformer2, r, reducer);
                    this.rights = mapReduceKeysToLongTask;
                    mapReduceKeysToLongTask.fork();
                    transformer2 = transformer2;
                    i = i;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r = reducer.applyAsLong(r, transformer.applyAsLong((K) advance.key));
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceKeysToLongTask mapReduceKeysToLongTask2 = (MapReduceKeysToLongTask) c;
                    MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask3 = mapReduceKeysToLongTask2.rights;
                    while (mapReduceKeysToLongTask3 != null) {
                        mapReduceKeysToLongTask2.result = reducer.applyAsLong(mapReduceKeysToLongTask2.result, mapReduceKeysToLongTask3.result);
                        MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask4 = mapReduceKeysToLongTask3.nextRight;
                        mapReduceKeysToLongTask2.rights = mapReduceKeysToLongTask4;
                        mapReduceKeysToLongTask3 = mapReduceKeysToLongTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceValuesToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceValuesToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceValuesToLongTask<K, V> rights;
        final ToLongFunction<? super V> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesToLongTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceValuesToLongTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask, ToLongFunction<? super V> transformer, long basis, LongBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceValuesToLongTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesToLongTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesToLongTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            LongBinaryOperator reducer;
            ToLongFunction<? super V> transformer;
            ToLongFunction<? super V> toLongFunction = this.transformer;
            ToLongFunction<? super V> transformer2 = toLongFunction;
            if (toLongFunction != null && (reducer = this.reducer) != null) {
                long r = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        transformer = transformer2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        transformer = transformer2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask = new MapReduceValuesToLongTask<>(this, i2, h, f, this.tab, this.rights, transformer2, r, reducer);
                    this.rights = mapReduceValuesToLongTask;
                    mapReduceValuesToLongTask.fork();
                    transformer2 = transformer2;
                    i = i;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r = reducer.applyAsLong(r, transformer.applyAsLong((V) advance.val));
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceValuesToLongTask mapReduceValuesToLongTask2 = (MapReduceValuesToLongTask) c;
                    MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask3 = mapReduceValuesToLongTask2.rights;
                    while (mapReduceValuesToLongTask3 != null) {
                        mapReduceValuesToLongTask2.result = reducer.applyAsLong(mapReduceValuesToLongTask2.result, mapReduceValuesToLongTask3.result);
                        MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask4 = mapReduceValuesToLongTask3.nextRight;
                        mapReduceValuesToLongTask2.rights = mapReduceValuesToLongTask4;
                        mapReduceValuesToLongTask3 = mapReduceValuesToLongTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceEntriesToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceEntriesToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceEntriesToLongTask<K, V> rights;
        final ToLongFunction<Map.Entry<K, V>> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesToLongTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceEntriesToLongTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask, ToLongFunction<Map.Entry<K, V>> transformer, long basis, LongBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceEntriesToLongTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesToLongTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesToLongTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            LongBinaryOperator reducer;
            ToLongFunction<Map.Entry<K, V>> transformer;
            ToLongFunction<Map.Entry<K, V>> toLongFunction = this.transformer;
            ToLongFunction<Map.Entry<K, V>> transformer2 = toLongFunction;
            if (toLongFunction != null && (reducer = this.reducer) != null) {
                long r = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        transformer = transformer2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        transformer = transformer2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask = new MapReduceEntriesToLongTask<>(this, i2, h, f, this.tab, this.rights, transformer2, r, reducer);
                    this.rights = mapReduceEntriesToLongTask;
                    mapReduceEntriesToLongTask.fork();
                    transformer2 = transformer2;
                    i = i;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r = reducer.applyAsLong(r, transformer.applyAsLong(advance));
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceEntriesToLongTask mapReduceEntriesToLongTask2 = (MapReduceEntriesToLongTask) c;
                    MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask3 = mapReduceEntriesToLongTask2.rights;
                    while (mapReduceEntriesToLongTask3 != null) {
                        mapReduceEntriesToLongTask2.result = reducer.applyAsLong(mapReduceEntriesToLongTask2.result, mapReduceEntriesToLongTask3.result);
                        MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask4 = mapReduceEntriesToLongTask3.nextRight;
                        mapReduceEntriesToLongTask2.rights = mapReduceEntriesToLongTask4;
                        mapReduceEntriesToLongTask3 = mapReduceEntriesToLongTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceMappingsToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceMappingsToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceMappingsToLongTask<K, V> rights;
        final ToLongBiFunction<? super K, ? super V> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsToLongTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceMappingsToLongTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask, ToLongBiFunction<? super K, ? super V> transformer, long basis, LongBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceMappingsToLongTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsToLongTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsToLongTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsToLongTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            LongBinaryOperator reducer;
            ToLongBiFunction<? super K, ? super V> transformer;
            ToLongBiFunction<? super K, ? super V> toLongBiFunction = this.transformer;
            ToLongBiFunction<? super K, ? super V> transformer2 = toLongBiFunction;
            if (toLongBiFunction != null && (reducer = this.reducer) != null) {
                long r = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        transformer = transformer2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        transformer = transformer2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask = new MapReduceMappingsToLongTask<>(this, i2, h, f, this.tab, this.rights, transformer2, r, reducer);
                    this.rights = mapReduceMappingsToLongTask;
                    mapReduceMappingsToLongTask.fork();
                    transformer2 = transformer2;
                    i = i;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r = reducer.applyAsLong(r, transformer.applyAsLong((K) advance.key, (V) advance.val));
                }
                this.result = r;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceMappingsToLongTask mapReduceMappingsToLongTask2 = (MapReduceMappingsToLongTask) c;
                    MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask3 = mapReduceMappingsToLongTask2.rights;
                    while (mapReduceMappingsToLongTask3 != null) {
                        mapReduceMappingsToLongTask2.result = reducer.applyAsLong(mapReduceMappingsToLongTask2.result, mapReduceMappingsToLongTask3.result);
                        MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask4 = mapReduceMappingsToLongTask3.nextRight;
                        mapReduceMappingsToLongTask2.rights = mapReduceMappingsToLongTask4;
                        mapReduceMappingsToLongTask3 = mapReduceMappingsToLongTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceKeysToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceKeysToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceKeysToIntTask<K, V> rights;
        final ToIntFunction<? super K> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysToIntTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceKeysToIntTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask, ToIntFunction<? super K> transformer, int basis, IntBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceKeysToIntTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysToIntTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceKeysToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceKeysToIntTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            IntBinaryOperator reducer;
            int r;
            ToIntFunction<? super K> transformer = this.transformer;
            if (transformer != null && (reducer = this.reducer) != null) {
                int r2 = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        r = r2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        r = r2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask = new MapReduceKeysToIntTask<>(this, i2, h, f, this.tab, this.rights, transformer, r2, reducer);
                    this.rights = mapReduceKeysToIntTask;
                    mapReduceKeysToIntTask.fork();
                    r2 = r2;
                }
                int r3 = r;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r3 = reducer.applyAsInt(r3, transformer.applyAsInt((K) advance.key));
                }
                this.result = r3;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceKeysToIntTask mapReduceKeysToIntTask2 = (MapReduceKeysToIntTask) c;
                    MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask3 = mapReduceKeysToIntTask2.rights;
                    while (mapReduceKeysToIntTask3 != null) {
                        mapReduceKeysToIntTask2.result = reducer.applyAsInt(mapReduceKeysToIntTask2.result, mapReduceKeysToIntTask3.result);
                        MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask4 = mapReduceKeysToIntTask3.nextRight;
                        mapReduceKeysToIntTask2.rights = mapReduceKeysToIntTask4;
                        mapReduceKeysToIntTask3 = mapReduceKeysToIntTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceValuesToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceValuesToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceValuesToIntTask<K, V> rights;
        final ToIntFunction<? super V> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesToIntTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceValuesToIntTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask, ToIntFunction<? super V> transformer, int basis, IntBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceValuesToIntTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesToIntTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceValuesToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceValuesToIntTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            IntBinaryOperator reducer;
            int r;
            ToIntFunction<? super V> transformer = this.transformer;
            if (transformer != null && (reducer = this.reducer) != null) {
                int r2 = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        r = r2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        r = r2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask = new MapReduceValuesToIntTask<>(this, i2, h, f, this.tab, this.rights, transformer, r2, reducer);
                    this.rights = mapReduceValuesToIntTask;
                    mapReduceValuesToIntTask.fork();
                    r2 = r2;
                }
                int r3 = r;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r3 = reducer.applyAsInt(r3, transformer.applyAsInt((V) advance.val));
                }
                this.result = r3;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceValuesToIntTask mapReduceValuesToIntTask2 = (MapReduceValuesToIntTask) c;
                    MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask3 = mapReduceValuesToIntTask2.rights;
                    while (mapReduceValuesToIntTask3 != null) {
                        mapReduceValuesToIntTask2.result = reducer.applyAsInt(mapReduceValuesToIntTask2.result, mapReduceValuesToIntTask3.result);
                        MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask4 = mapReduceValuesToIntTask3.nextRight;
                        mapReduceValuesToIntTask2.rights = mapReduceValuesToIntTask4;
                        mapReduceValuesToIntTask3 = mapReduceValuesToIntTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceEntriesToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceEntriesToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceEntriesToIntTask<K, V> rights;
        final ToIntFunction<Map.Entry<K, V>> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesToIntTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceEntriesToIntTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask, ToIntFunction<Map.Entry<K, V>> transformer, int basis, IntBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceEntriesToIntTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesToIntTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceEntriesToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceEntriesToIntTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            IntBinaryOperator reducer;
            int r;
            ToIntFunction<Map.Entry<K, V>> transformer = this.transformer;
            if (transformer != null && (reducer = this.reducer) != null) {
                int r2 = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        r = r2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        r = r2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask = new MapReduceEntriesToIntTask<>(this, i2, h, f, this.tab, this.rights, transformer, r2, reducer);
                    this.rights = mapReduceEntriesToIntTask;
                    mapReduceEntriesToIntTask.fork();
                    r2 = r2;
                }
                int r3 = r;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r3 = reducer.applyAsInt(r3, transformer.applyAsInt(advance));
                }
                this.result = r3;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceEntriesToIntTask mapReduceEntriesToIntTask2 = (MapReduceEntriesToIntTask) c;
                    MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask3 = mapReduceEntriesToIntTask2.rights;
                    while (mapReduceEntriesToIntTask3 != null) {
                        mapReduceEntriesToIntTask2.result = reducer.applyAsInt(mapReduceEntriesToIntTask2.result, mapReduceEntriesToIntTask3.result);
                        MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask4 = mapReduceEntriesToIntTask3.nextRight;
                        mapReduceEntriesToIntTask2.rights = mapReduceEntriesToIntTask4;
                        mapReduceEntriesToIntTask3 = mapReduceEntriesToIntTask4;
                    }
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class MapReduceMappingsToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceMappingsToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceMappingsToIntTask<K, V> rights;
        final ToIntBiFunction<? super K, ? super V> transformer;

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$BulkTask != java.util.concurrent.ConcurrentHashMap$BulkTask<K, V, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsToIntTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node[] != java.util.concurrent.ConcurrentHashMap$Node<K, V>[] */
        MapReduceMappingsToIntTask(BulkTask<K, V, ?> bulkTask, int b, int i, int f, Node<K, V>[] nodeArr, MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask, ToIntBiFunction<? super K, ? super V> transformer, int basis, IntBinaryOperator reducer) {
            super(bulkTask, b, i, f, nodeArr);
            this.nextRight = mapReduceMappingsToIntTask;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsToIntTask<K, V> */
        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$MapReduceMappingsToIntTask != java.util.concurrent.ConcurrentHashMap$MapReduceMappingsToIntTask<K, V> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.concurrent.ConcurrentHashMap$Node != java.util.concurrent.ConcurrentHashMap$Node<K, V> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            IntBinaryOperator reducer;
            int r;
            ToIntBiFunction<? super K, ? super V> transformer = this.transformer;
            if (transformer != null && (reducer = this.reducer) != null) {
                int r2 = this.basis;
                int i = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        r = r2;
                        break;
                    }
                    int f = this.baseLimit;
                    int h = (f + i) >>> 1;
                    if (h <= i) {
                        r = r2;
                        break;
                    }
                    addToPendingCount(1);
                    int i2 = this.batch >>> 1;
                    this.batch = i2;
                    this.baseLimit = h;
                    MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask = new MapReduceMappingsToIntTask<>(this, i2, h, f, this.tab, this.rights, transformer, r2, reducer);
                    this.rights = mapReduceMappingsToIntTask;
                    mapReduceMappingsToIntTask.fork();
                    r2 = r2;
                }
                int r3 = r;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    r3 = reducer.applyAsInt(r3, transformer.applyAsInt((K) advance.key, (V) advance.val));
                }
                this.result = r3;
                for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
                    MapReduceMappingsToIntTask mapReduceMappingsToIntTask2 = (MapReduceMappingsToIntTask) c;
                    MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask3 = mapReduceMappingsToIntTask2.rights;
                    while (mapReduceMappingsToIntTask3 != null) {
                        mapReduceMappingsToIntTask2.result = reducer.applyAsInt(mapReduceMappingsToIntTask2.result, mapReduceMappingsToIntTask3.result);
                        MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask4 = mapReduceMappingsToIntTask3.nextRight;
                        mapReduceMappingsToIntTask2.rights = mapReduceMappingsToIntTask4;
                        mapReduceMappingsToIntTask3 = mapReduceMappingsToIntTask4;
                    }
                }
            }
        }
    }
}