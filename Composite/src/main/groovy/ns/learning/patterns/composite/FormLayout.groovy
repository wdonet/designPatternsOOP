package ns.learning.patterns.composite

class FormLayout implements Container {
    List<Widget> childrenElements

    FormLayout() {
        childrenElements = new LinkedList<>()
    }

    @Override
    void setPosition(int x, int y) {

    }

    @Override
    void setWidth(int width) {

    }

    @Override
    void setHeight(int height) {

    }

    @Override
    String draw(String tabs) {
        StringBuilder content = new StringBuilder()

        content.append "${tabs}A FormLayout${System.lineSeparator()}"
        childrenElements.forEach { child -> content.append child.draw(tabs + TAB) }

        return content.toString()
    }

    @Override
    void addChild(Widget widget) {
        childrenElements.add(widget)
    }
}
