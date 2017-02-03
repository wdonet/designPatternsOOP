package ns.learning.patterns.composite

interface Widget {

    String TAB = '  '

    void setPosition(int x, int y)
    void setWidth(int width)
    void setHeight(int height)

    String draw(String tabs)

}
