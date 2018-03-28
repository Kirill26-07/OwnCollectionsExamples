package com.kirill.collectionTypes;

public interface INode<T> {

    INode add(final T value);
    int count();
    void forEach(final IConsumer<T> consumer);

    interface IConsumer<R> {
        void consume(final R value);
    }
}