package net.wdo.domain.iterator

interface MyIterator<E> {

    boolean hasNext()
    E next()
    int size()
}