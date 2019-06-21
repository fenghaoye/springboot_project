package com.fh.project.collection;


public class MyHashMap<K, V> {

    // 定义一个链表数组，每一个index中的值都是链表
    private Entry<K, V>[] tables;
    private static final Integer CAPACITY = 8;

    public MyHashMap() {
        this.tables = new Entry[CAPACITY];
    }

    // put方法，返回值是获取重复key中的value
    public V put(K k, V v) {
        // 获取K 的hascode
        int hashCode = k.hashCode();
        // 获取index
        int index = hashCode % CAPACITY;
        // 获取index这个位置的链表， 看是否有相同的key,有的话就覆盖value
        for (Entry<K, V> entry = tables[index]; entry != null; entry = entry.next) {
            if (entry.k.equals(k)) {
                V oldValue = entry.v;
                entry.v = v;
                return oldValue;
            }
        }

        // 没有相同的key，就添加进这个tables
        addEntry(k, v, index);
        return null;
    }

    public V get(K key){
        // 获取k的hashcode
        int hashcode = key.hashCode();
        // 获取index
        int index = hashcode % CAPACITY;
        // 获取entry中的值
        for(Entry entry = tables[index];entry!=null;entry = entry.next){
            if(entry.k.equals(key)){
                return (V) entry.v;
            }
        }
        return null;
    }

    public void addEntry(K k, V v, int index) {
        // 获取index位置的Entry
        Entry<K, V> next = tables[index];
        // 初始化新的entry,把新的entry的next指向原来的entry
        Entry<K, V> entry = new Entry<>(k, v, next);
        tables[index] = entry;
    }

    // 内部类，链表
    class Entry<K, V> {
        private K k;
        private V v;
        private Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("子路", "1");
        myHashMap.put("周瑜", "2");
        myHashMap.put("华安", "3");
        myHashMap.put("木兰", "4");
        myHashMap.put("木兰", "5");
        myHashMap.put("3", "6");
        myHashMap.put("曹操", "8");

        System.out.println(myHashMap.get("测试"));
        System.out.println(myHashMap.get("华安"));
        System.out.println(myHashMap.get("3"));
    }
}
