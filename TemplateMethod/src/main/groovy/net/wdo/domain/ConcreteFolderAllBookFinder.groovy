package net.wdo.domain

import org.apache.commons.collections4.CollectionUtils

class ConcreteFolderAllBookFinder extends AbstractBookFinder {

    @Override
    List<String> getWordsToRemove() {
        List<String> toRemove = new ArrayList<>()
        toRemove.add("in")
        toRemove.add("at")
        toRemove.add("from")
        toRemove.addAll(super.getWordsToRemove())
        return toRemove
    }

    @Override
    List<String> doSimpleSearchOn(String s) {
        List<String> all = Arrays.asList(
                "How Amazon Leads the Joy in the World.doc"
                , "The Joy of Work.pdf"
                , "Do Androids Dream of Electric Sheep?.md"
                , "The curious incident of the Dog in the Night Time.txt"
        )
        return all.findAll {it -> it.toLowerCase().contains(s.toLowerCase())}
    }

    @Override
    List<String> merge(List<String> target, List<String> source) {
        List<String> total = new ArrayList<>()
        total.addAll(target)
        total.addAll(source)
        return total
    }
}
