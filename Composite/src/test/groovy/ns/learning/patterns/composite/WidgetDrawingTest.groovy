package ns.learning.patterns.composite

import spock.lang.Specification

class WidgetDrawingTest extends Specification {

    def 'Creating a complex structure and then ask to draw as a single object'() {
        given:
        Container parentLayout = new VerticalLayout()
        Container childVerticalLayout = new HorizontalLayout()
        Container formLayout = new FormLayout()

        parentLayout.addChild new Button()
        parentLayout.addChild new ComboBox()
        parentLayout.addChild childVerticalLayout

        childVerticalLayout.addChild new Label()
        childVerticalLayout.addChild new ListBox()
        childVerticalLayout.addChild formLayout
        childVerticalLayout.addChild new Button()

        formLayout.addChild new Label()
        formLayout.addChild new EditBox()
        formLayout.addChild new Label()
        formLayout.addChild new EditBox()
        formLayout.addChild new Label()
        formLayout.addChild new EditBox()

        when:
        String result = parentLayout.draw('')

        then:
        print result
        result == ("A VerticalLayout\n" +
                "  A Button\n" +
                "  A ComboBox\n" +
                "  A HorizontalLayout\n" +
                "    A Label\n" +
                "    A ListBox\n" +
                "    A FormLayout\n" +
                "      A Label\n" +
                "      A EditBox\n" +
                "      A Label\n" +
                "      A EditBox\n" +
                "      A Label\n" +
                "      A EditBox\n" +
                "    A Button\n")


    }


}
