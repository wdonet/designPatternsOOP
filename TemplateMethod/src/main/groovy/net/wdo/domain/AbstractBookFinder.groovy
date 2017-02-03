package net.wdo.domain

abstract class AbstractBookFinder {
    private final List<String> wordsToRemove = Arrays.asList("the", "an", "of")

    List<String> search(String query) {
        println "Original: $query"
        String simpleQuery = simplifyQuery(query)
        println "Simplified: $simpleQuery"
        List<String> specificQueries = specificQueriesAnalyzer(simpleQuery)
        println "specifics: $specificQueries"
        List<String> results = new ArrayList<>()
        int times = 1
        for (String specific : specificQueries) {
            def partial = doSimpleSearchOn(specific)
            results = merge(results, partial)
            println "${times++} time(s) merged with $partial => Total ${results.size()}"
        }
        println "final: $results"
        return highlight(results, specificQueries)
    }

    protected List<String> getWordsToRemove() {
        return wordsToRemove
    }

    protected String simplifyQuery(String s) {
        for (String word : getWordsToRemove()) {
            s = s.toLowerCase().replaceAll(word.toLowerCase(), "")
        }
        return s
    }

    protected List<String> specificQueriesAnalyzer(String s) {
        return s.split().collect {it -> it.trim()}
    }

    abstract List<String> doSimpleSearchOn(String s)

    abstract List<String> merge(List<String> target, List<String> source)

    protected List<String> highlight(List<String> books, List<String> wordsToHighlight) {
        //not highlighting by default
        return books
    }
}
