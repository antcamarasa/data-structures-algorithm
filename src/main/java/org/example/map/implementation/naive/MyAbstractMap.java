package org.example.map.implementation.naive;

public abstract class MyAbstractMap<K, V> implements MyMap<K, V>{
    protected int capacity;
    protected int size;
    protected int modCount;
    protected final double MAXIMUM_RATIO;

    public MyAbstractMap(double MAXIMUM_RATIO){
        this.capacity = 10;
        this.size     = 0;
        this.modCount = 0;
        this.MAXIMUM_RATIO = MAXIMUM_RATIO;
    }

    // ______________________________________ Method public ______________________________________
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }

    // ______________________________________ Protected Method ___________________________________
    protected void incrementSize(){
        this.size = this.size + 1;
    }
    protected void decrementSize(){
        this.size = this.size - 1;
    }

    protected void incrementModCount(){
        this.modCount = modCount + 1;
    }
    protected void doubleCapacity(){
        this.capacity = this.capacity * 2;
    }
    protected Long convertKeyToHashValue(K key){
        int h = key.hashCode();
        return (long) (h ^ (h >>> 16));
    };
    protected int reduceHashValueToIndex(Long hashValue){
        return (int) Math.floorMod(hashValue, (long) this.capacity);
    };
    protected double calculateRatio(){
        return (double)this.size / (double)this.capacity;
    }

}
