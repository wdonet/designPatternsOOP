package design.pattern.bridge

//Concrete implementor
class RCA implements TV {
    private int channel = 1
    private String brand = "RCA"

    @Override
    on() {
        println "Turn on RCA tv in channel $channel"
    }

    @Override
    off() {
        println "Turn off RCA tv"
    }

    @Override
    tuneChannel() {
        channel++
        if(channel > 3) {
            channel = 1
        }
        println "\tRCA tv is inside channel $channel"
    }

    @Override
    getBrand() {
        return brand
    }
}
