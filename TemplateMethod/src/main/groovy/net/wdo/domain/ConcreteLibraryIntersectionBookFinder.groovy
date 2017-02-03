package net.wdo.domain

import org.apache.commons.collections4.CollectionUtils

class ConcreteLibraryIntersectionBookFinder extends AbstractBookFinder {
    @Override
    protected List<String> getWordsToRemove() {
        List<String> toRemove = new ArrayList<>()
        toRemove.add "for"
        return toRemove
    }

    @Override
    List<String> doSimpleSearchOn(String s) {
        List<String> all = Arrays.asList(
                "code:567, Martin Luther, The colors at sky, Bilbao"
                , "code:278, Maria Carey, Amazonas, Larousse"
                , "code:973, Kathy Kulman, Angular 2 for Dummies, In Action"
                , "code:223, Mark y Cia, Joyfully praise the Lord, Grijalbo"
                , "code:973, Kathy Kulman, Android 4.5 for Dummies, In Action"
        )
        return all.findAll {it -> it.toLowerCase()
                .split(",")[2]
                .trim()
                .contains(s.toLowerCase())}
    }

    @Override
    List<String> merge(List<String> target, List<String> source) {
        if (CollectionUtils.isEmpty(target) || CollectionUtils.isEmpty(source)) {
            return CollectionUtils.union(target, source)
        }
        return CollectionUtils.intersection(target, source)
    }

    @Override
    protected List<String> highlight(List<String> books, List<String> wordsToHighlight) {
        List<String> highlighted = null
        for (String word : wordsToHighlight) {
            highlighted = new ArrayList<>()
            for (String title : books) {
                int init = title.toLowerCase().indexOf(word)
                if (init > 0) {
                    highlighted.add(title.substring(0, init) + '*' + word.toUpperCase() + '*' + title.substring(init + word.size()))
                }
                else {
                    highlighted.add(title)
                }
            }
            books = highlighted
        }
        return highlighted
    }
}
