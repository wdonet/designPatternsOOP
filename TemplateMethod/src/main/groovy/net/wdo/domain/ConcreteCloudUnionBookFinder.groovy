package net.wdo.domain

import org.apache.commons.collections4.CollectionUtils

class ConcreteCloudUnionBookFinder extends AbstractBookFinder {

    @Override
    List<String> getWordsToRemove() {
        List<String> toRemove = new ArrayList<>()
        toRemove.add("the")
        toRemove.add("and")
        toRemove.add("of")
        toRemove.add("-")
        return toRemove
    }

    @Override
    List<String> doSimpleSearchOn(String s) {
        List<String> all = Arrays.asList(
                "The Amazonas and the culture of the inka-taki people:Mark Smith"
                , "Joy Makers:Pamela Cosio"
                , "Men working:Marce Junipera"
                , "The curious case of Benjamin:Camilo Rossi"
        )
        return all.findAll {it -> it.toLowerCase().split(":")[0].contains(s.toLowerCase())}
    }

    @Override
    List<String> merge(List<String> target, List<String> source) {
        return CollectionUtils.union(target, source)
    }
}
