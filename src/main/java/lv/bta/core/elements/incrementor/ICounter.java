package lv.bta.core.elements.incrementor;

public interface ICounter<T> {

    T getIncrementingValue();

    int getCount();

    void increment();

    void decrement();

}
