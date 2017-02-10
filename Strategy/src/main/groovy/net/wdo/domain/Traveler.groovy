package net.wdo.domain

abstract class Traveler {
    int age = 0

    Traveler withAge(int age) {
        setAge age
        this
    }

}
