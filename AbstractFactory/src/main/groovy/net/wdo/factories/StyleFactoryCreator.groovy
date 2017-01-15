package net.wdo.factories

class StyleFactoryCreator {
    private MexaStyleFactory mexaStyleFactory = new MexaStyleFactory()
    private ItalianStyleFactory italianStyleFactory = new ItalianStyleFactory()

    enum Style {MEXA, ITALIAN}

    AbstractFoodFactory create(Style style) {
        switch (style) {
            case Style.MEXA : mexaStyleFactory
                break
            case Style.ITALIAN : italianStyleFactory
                break
        }
    }
}
